package com.yatop.lambda.workflow.core.mgr.workflow.analyzer;

import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.context.WorkflowContext;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.Node;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.NodeOutputPort;
import com.yatop.lambda.workflow.core.utils.CollectionUtil;

import java.util.*;

public class SchemaAnalyzer4CreateLink$UpdateParameter {

    private static void analyzeOneNode(WorkflowContext workflowContext, Node currentNode, boolean ignoreUpstreamAnalyzed, Deque<Node> analyzeStack, Deque<Node> analyzePendingStack) {

        if(DataUtil.isNull(currentNode) || !currentNode.needAnalyzeSchema())
            return;

        if(!currentNode.isHeadNode() && !ignoreUpstreamAnalyzed) {
            TreeMap<Long, NodeOutputPort> upstreamPorts = workflowContext.fetchUpstreamPorts(currentNode);
            if (DataUtil.isNotEmpty(upstreamPorts)) {
                for (NodeOutputPort outputPort : CollectionUtil.toList(upstreamPorts)) {

                    if (outputPort.isDataTablePort() && !outputPort.isAnalyzed()) {
                        //ignoreUpstreamAnalyzed=false，且上游输入端口存在未分析，转入pending队列
                        CollectionUtil.offerLast(analyzePendingStack, currentNode);
                        return;
                    }
                }
            }
        }

        SchemaAnalyzerHelper.analyzeSchema(workflowContext, currentNode);
        currentNode.markAnalyzed();
        SchemaAnalyzerHelper.searchDownstreamNodes(workflowContext, currentNode, analyzeStack, false);
    }

    private static void analyzeStackNodes(WorkflowContext workflowContext, Deque<Node> analyzeStack, Deque<Node> analyzePendingStack) {

        Node currentNode = null;
        while(DataUtil.isNotNull(currentNode = CollectionUtil.pollLast(analyzeStack))) {
            analyzeOneNode(workflowContext, currentNode, false, analyzeStack, analyzePendingStack);
        }
    }

    private static void searchDownstreamNodes4PendingDependency(WorkflowContext workflowContext,
                                                                Node searchNode,
                                                                Node currentNode,
                                                                TreeMap<Long, TreeMap<Long, Node>> pendingDependencyNodes,
                                                                Deque<Node> searchPendingDependencyStack) {
        if(DataUtil.isNull(currentNode) || !currentNode.needAnalyzeSchema())
            return;

        for(NodeOutputPort outputDataPort : currentNode.getOutputDataTablePorts()) {
            //仅数据输出端口为schema changed时，找出端口下游节点
            if(outputDataPort.isSchemaChanged()) {
                List<Node> downstreamNodes = workflowContext.fetchDownstreamNodes(outputDataPort);
                if(DataUtil.isNotEmpty(downstreamNodes)) {
                    for (Node downstreamNode : downstreamNodes) {
                        if(downstreamNode.needAnalyzeSchema()) {
                            if(CollectionUtil.containsKey(pendingDependencyNodes, downstreamNode.data().getNodeId())) {
                                TreeMap<Long, Node> dependentNodes = CollectionUtil.get(pendingDependencyNodes, downstreamNode.data().getNodeId());
                                if(!CollectionUtil.containsKey(dependentNodes, searchNode.data().getNodeId()))
                                    CollectionUtil.put(dependentNodes, searchNode.data().getNodeId(), searchNode);

                                //TODO continue
                            } else {
                                CollectionUtil.offerLast(searchPendingDependencyStack, downstreamNode);
                            }
                        }
                    }
                }
            }
        }
    }

    private static void analyzePendingDependency(WorkflowContext workflowContext,
                                                Deque<Node> analyzePendingStack,
                                                TreeMap<Long, Node> pendingNodes,
                                                TreeMap<Long, TreeMap<Long, Node>> pendingDependencyNodes) {
        {
            Node pendingNode = null;
            while (DataUtil.isNotNull(pendingNode = CollectionUtil.pollLast(analyzePendingStack))) {
                if (!CollectionUtil.containsKey(pendingNodes, pendingNode.data().getNodeId())) {
                    CollectionUtil.put(pendingNodes, pendingNode.data().getNodeId(), pendingNode);
                    CollectionUtil.put(pendingDependencyNodes, pendingNode.data().getNodeId(), new TreeMap<Long, Node>());
                }
            }
        }

        if(DataUtil.isEmpty(pendingNodes))
            return;

        {
            for (Node pendingNode : CollectionUtil.toList(pendingNodes)) {
                CollectionUtil.offerLast(analyzePendingStack, pendingNode);
            }

            Node searchNode = null;
            while (DataUtil.isNotNull(searchNode = CollectionUtil.pollLast(analyzePendingStack))) {
                Deque<Node> searchPendingDependencyStack = new LinkedList<Node>();
                searchDownstreamNodes4PendingDependency(workflowContext, searchNode, searchNode, pendingDependencyNodes, searchPendingDependencyStack);

                Node currentNode = null;
                while(DataUtil.isNotNull(currentNode = CollectionUtil.pollLast(searchPendingDependencyStack))) {
                    searchDownstreamNodes4PendingDependency(workflowContext, searchNode, currentNode, pendingDependencyNodes, searchPendingDependencyStack);
                }
            }
        }
    }

    private static List<Node> findPendingNoDependencyNodes(TreeMap<Long, Node> pendingNodes, TreeMap<Long, TreeMap<Long, Node>> pendingDependencyNodes) {
        if(DataUtil.isEmpty(pendingNodes) || DataUtil.isEmpty(pendingDependencyNodes))
            return null;

        List<Node> noDependencyNodes = new ArrayList<Node>();
        for(Node pendingNode : CollectionUtil.toList(pendingNodes)) {
            TreeMap<Long, Node> dependentNodes = CollectionUtil.get(pendingDependencyNodes, pendingNode.data().getNodeId());
            if(DataUtil.isEmpty(dependentNodes)) {
                CollectionUtil.add(noDependencyNodes, pendingNode);
                CollectionUtil.remove(pendingNodes, pendingNode.data().getNodeId());
                CollectionUtil.remove(pendingDependencyNodes, pendingNode.data().getNodeId());
            }
        }
        return DataUtil.isNotEmpty(noDependencyNodes) ? noDependencyNodes : null;
    }

    private static void removePendingDependency(Node removeNode, TreeMap<Long, TreeMap<Long, Node>> pendingDependencyNodes) {
        if(DataUtil.isNull(removeNode) || DataUtil.isEmpty(pendingDependencyNodes))
            return;

        for(TreeMap<Long, Node> dependentNodes : CollectionUtil.toList(pendingDependencyNodes)) {
            CollectionUtil.remove(dependentNodes, removeNode.data().getNodeId());
        }
    }

    public static void analyzeStartNode(WorkflowContext workflowContext, Node startNode) {

        Deque<Node> analyzeStack = new LinkedList<Node>();
        Deque<Node> analyzePendingStack = new LinkedList<Node>();
        analyzeOneNode(workflowContext, startNode, true, analyzeStack, analyzePendingStack);
        analyzeStackNodes(workflowContext, analyzeStack, analyzePendingStack);

        if(analyzePendingStack.size() > 0) {
            //key: pendingNodeId, pendingNode
            //key: pendingNodeId, <key: dependentPendingNodeId, dependentPendingNode>
            TreeMap<Long, Node> pendingNodes = new TreeMap<Long, Node>();
            TreeMap<Long, TreeMap<Long, Node>> pendingDependencyNodes = new TreeMap<Long, TreeMap<Long, Node>>();
            analyzePendingDependency(workflowContext, analyzePendingStack, pendingNodes, pendingDependencyNodes);
            CollectionUtil.clear(analyzePendingStack);

            List<Node> noDependencyNodes = null;
            while(DataUtil.isNotEmpty(noDependencyNodes = findPendingNoDependencyNodes(pendingNodes, pendingDependencyNodes))) {
                for(Node noDependencyNode : noDependencyNodes) {
                    analyzeOneNode(workflowContext, noDependencyNode, true, analyzeStack, analyzePendingStack);
                    removePendingDependency(noDependencyNode, pendingDependencyNodes);
                }
                analyzeStackNodes(workflowContext, analyzeStack, analyzePendingStack);
                analyzePendingDependency(workflowContext, analyzePendingStack, pendingNodes, pendingDependencyNodes);
            }
        }
    }
}
