package com.yatop.lambda.workflow.core.mgr.workflow.node.port.schema;

import com.yatop.lambda.core.enums.IsRequiredEnum;
import com.yatop.lambda.core.enums.LambdaExceptionEnum;
import com.yatop.lambda.core.exception.LambdaException;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.context.WorkflowContext;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.Node;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.NodeLink;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.NodePortInput;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.NodePortOutput;
import com.yatop.lambda.workflow.core.utils.CollectionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class SchemaAnalyzer {

    private static  SchemaAnalyze SCHEMA_ANALYZE;

    @Autowired
    public void setSchemaAnalyze(SchemaAnalyze schemaAnalyze) {
        SchemaAnalyzer.SCHEMA_ANALYZE = schemaAnalyze;
    }

    public static void dealAnalyzeSchema(WorkflowContext workflowContext) {
        switch (workflowContext.getAnalyzeType()) {
            case CREATE_NODE:
                dealAnalyzeSchema4CreateNode(workflowContext);
                break;
            case CREATE_LINK:
                dealAnalyzeSchema4CreateLink(workflowContext);
                break;
            case UPDATE_NODE_PARAMETER:
                dealAnalyzeSchema4UpdateNodeParameter(workflowContext);
                break;
            case DELETE_NODE:
                dealAnalyzeSchema4DeleteNode(workflowContext);
                break;
            case DELETE_LINK:
                dealAnalyzeSchema4DeleteLink(workflowContext);
                break;
            case COMPILE_WORKFLOW:
                dealAnalyzeSchema4CompileWorkflow(workflowContext);
                break;
            default:
                break;
        }
    }

    public static void dealAnalyzeSchema4CreateNode(WorkflowContext workflowContext) {

        Node analyzeNode = null;
        while(DataUtil.isNotNull(analyzeNode = workflowContext.popAnalyzeNode())) {

            //非头结点创建时schema已经初始化为empty，这里仅对头结点schema做分析
            if(analyzeNode.needAnalyzeSchema() && analyzeNode.isHeadNode() && !analyzeNode.isAnalyzed()) {
                SCHEMA_ANALYZE.analyzeSchema(workflowContext, analyzeNode);
                analyzeNode.markAnalyzed();
            }
        }
    }

    private static void searchDownstreamNodes4AnalyzeStack(WorkflowContext workflowContext, Node currentNode, Deque<Node> analyzeStack) {
        if(DataUtil.isNull(currentNode) || !currentNode.needAnalyzeSchema())
            return;

        for(NodePortOutput outputDataPort : currentNode.getOutputDataTablePorts()) {
            //仅数据输出端口为schema changed时，找出端口下游节点
            if(outputDataPort.isSchemaChanged()) {
                List<Node> downStreamNodes = workflowContext.fetchDownstreamNodes(outputDataPort);
                if(DataUtil.isNotEmpty(downStreamNodes)) {
                    for (Node downStreamNode : downStreamNodes) {
                        if(downStreamNode.needAnalyzeSchema())
                            CollectionUtil.offerLast(analyzeStack, downStreamNode);
                    }
                }
            }
        }
    }

    private static void analyzeOneNode4CreateAndUpdate(WorkflowContext workflowContext, Node currentNode, boolean isIgnoreUpstreamAnalyzed, Deque<Node> analyzeStack, Deque<Node> analyzePendingStack) {

        if(DataUtil.isNull(currentNode) || !currentNode.needAnalyzeSchema())
            return;

        if(!currentNode.isHeadNode()) {
            TreeMap<Long, NodePortOutput> upstreamNonWebPorts = workflowContext.fetchNonWebUpstreamPorts(currentNode);
            for (NodePortInput inputDataPort : currentNode.getInputDataTablePorts()) {
                //仅对必须输入端口的上游端口状态做分析判断
                if (inputDataPort.getCmptChar().data().getIsRequired() == IsRequiredEnum.YES.getMark()) {
                    NodePortOutput upstreamDataPort = CollectionUtil.get(upstreamNonWebPorts, inputDataPort.data().getNodePortId());
                    if (DataUtil.isNotNull(upstreamDataPort)) {
                        if (!upstreamDataPort.isDataTablePort()) throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Schema Analyzer error -- Illegal upstream node port.", "系统数据异常，请联系管理员", upstreamDataPort, inputDataPort);

                        //isIgnoreUpstreamAnalyzed=true，或上游端口已分析，必须输入端口的上游端口schema state不是normal时，直接更改为empty
                        if (isIgnoreUpstreamAnalyzed || upstreamDataPort.isAnalyzed()) {
                            if (!upstreamDataPort.getSchema().isStateNormal()) {
                                currentNode.changeSchemas2Empty();
                                currentNode.markAnalyzed();
                                searchDownstreamNodes4AnalyzeStack(workflowContext, currentNode, analyzeStack);
                                return;
                            }

                            //必须输入端口的上游端口schema state为normal时，继续确认下一必须输入端口的上游端口状况
                            continue;
                        } else {
                            //isIgnoreUpstreamAnalyzed=false，且上游端口未分析，上游必须输入端口未分析，转入pending队列
                            CollectionUtil.offerLast(analyzePendingStack, currentNode);
                            return;
                        }
                    } else {
                        //必须输入端口无对应数据流入时，无需分析该节点
                        return;
                    }
                }
            }
        }


        SCHEMA_ANALYZE.analyzeSchema(workflowContext, currentNode);
        currentNode.markAnalyzed();
        searchDownstreamNodes4AnalyzeStack(workflowContext, currentNode, analyzeStack);
    }

    private static void analyzeStackNodes4CreateAndUpdate(WorkflowContext workflowContext, Deque<Node> analyzeStack, Deque<Node> analyzePendingStack) {

        Node currentNode = null;
        while(DataUtil.isNotNull(currentNode = CollectionUtil.pollLast(analyzeStack))) {
            analyzeOneNode4CreateAndUpdate(workflowContext, currentNode, false, analyzeStack, analyzePendingStack);
        }
    }

    private static void searchDownstreamNodes4PendingDependency(WorkflowContext workflowContext,
                                                                Node searchNode,
                                                                Node currentNode,
                                                                TreeMap<Long, TreeMap<Long, Node>> pendingDependencyNodes,
                                                                Deque<Node> searchPendingDependencyStack) {
        if(DataUtil.isNull(currentNode) || !currentNode.needAnalyzeSchema())
            return;

        for(NodePortOutput outputDataPort : currentNode.getOutputDataTablePorts()) {
            //仅数据输出端口为schema changed时，找出端口下游节点
            if(outputDataPort.isSchemaChanged()) {
                List<Node> downStreamNodes = workflowContext.fetchDownstreamNodes(outputDataPort);
                if(DataUtil.isNotEmpty(downStreamNodes)) {
                    for (Node downStreamNode : downStreamNodes) {
                        if(downStreamNode.needAnalyzeSchema()) {
                            if(CollectionUtil.containsKey(pendingDependencyNodes, downStreamNode.data().getNodeId())) {
                                TreeMap<Long, Node> dependentNodes = CollectionUtil.get(pendingDependencyNodes, downStreamNode.data().getNodeId());
                                if(!CollectionUtil.containsKey(dependentNodes, searchNode.data().getNodeId()))
                                    CollectionUtil.put(dependentNodes, searchNode.data().getNodeId(), searchNode);

                                //TODO continue
                            } else {
                                CollectionUtil.offerLast(searchPendingDependencyStack, downStreamNode);
                            }
                        }
                    }
                }
            }
        }
    }

    private static void analyzePendingDependency4CreateAndUpdate(WorkflowContext workflowContext,
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

    private static void removePendingIndependency(Node removeNode, TreeMap<Long, TreeMap<Long, Node>> pendingDependencyNodes) {
        if(DataUtil.isNull(removeNode) || DataUtil.isEmpty(pendingDependencyNodes))
            return;

        for(TreeMap<Long, Node> dependentNodes : CollectionUtil.toList(pendingDependencyNodes)) {
            CollectionUtil.remove(dependentNodes, removeNode.data().getNodeId());
        }
    }

    private static void analyzeStartNode4CreateAndUpdate(WorkflowContext workflowContext, Node startNode) {

        Deque<Node> analyzeStack = new LinkedList<Node>();
        Deque<Node> analyzePendingStack = new LinkedList<Node>();
        analyzeOneNode4CreateAndUpdate(workflowContext, startNode, true, analyzeStack, analyzePendingStack);
        analyzeStackNodes4CreateAndUpdate(workflowContext, analyzeStack, analyzePendingStack);

        if(analyzePendingStack.size() > 0) {
            //key: pendingNodeId, pendingNode
            //key: pendingNodeId, <key: dependentPendingNodeId, dependentPendingNode>
            TreeMap<Long, Node> pendingNodes = new TreeMap<Long, Node>();
            TreeMap<Long, TreeMap<Long, Node>> pendingDependencyNodes = new TreeMap<Long, TreeMap<Long, Node>>();
            analyzePendingDependency4CreateAndUpdate(workflowContext, analyzePendingStack, pendingNodes, pendingDependencyNodes);
            CollectionUtil.clear(analyzePendingStack);

            List<Node> noDependencyNodes = null;
            while(DataUtil.isNotEmpty(noDependencyNodes = findPendingNoDependencyNodes(pendingNodes, pendingDependencyNodes))) {
                for(Node noDependencyNode : noDependencyNodes) {
                    analyzeOneNode4CreateAndUpdate(workflowContext, noDependencyNode, true, analyzeStack, analyzePendingStack);
                    removePendingIndependency(noDependencyNode, pendingDependencyNodes);
                }
                analyzeStackNodes4CreateAndUpdate(workflowContext, analyzeStack, analyzePendingStack);
                analyzePendingDependency4CreateAndUpdate(workflowContext, analyzePendingStack, pendingNodes, pendingDependencyNodes);
            }
        }
    }

    public static void dealAnalyzeSchema4CreateLink(WorkflowContext workflowContext) {
        NodeLink analyzeLink = workflowContext.popAnalyzeLink();
        if(DataUtil.isNotNull(analyzeLink) && !analyzeLink.isWebLink()) {
            workflowContext.clearAnalyzeNodes();
            Node analyzeNode = workflowContext.fetchDownstreamNode(analyzeLink);
            analyzeStartNode4CreateAndUpdate(workflowContext, analyzeNode);
        }
    }

    public static void dealAnalyzeSchema4UpdateNodeParameter(WorkflowContext workflowContext) {
        Node analyzeNode = workflowContext.popAnalyzeNode();
        analyzeStartNode4CreateAndUpdate(workflowContext, analyzeNode);
    }

    public static void dealAnalyzeSchema4DeleteNode(WorkflowContext workflowContext) {
        //TODO 一路clear下去
    }

    public static void dealAnalyzeSchema4DeleteLink(WorkflowContext workflowContext) {
        //TODO 一路clear下去
    }

    public static void dealAnalyzeSchema4CompileWorkflow(WorkflowContext workflowContext) {
        //TODO 从头节点开始分析
    }
}
