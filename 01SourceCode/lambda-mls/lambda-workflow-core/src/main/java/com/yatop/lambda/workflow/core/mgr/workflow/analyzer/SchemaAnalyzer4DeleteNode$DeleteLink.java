package com.yatop.lambda.workflow.core.mgr.workflow.analyzer;

import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.context.WorkflowContext;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.Node;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.NodeOutputPort;
import com.yatop.lambda.workflow.core.utils.CollectionUtil;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

public class SchemaAnalyzer4DeleteNode$DeleteLink {

    public static List<Node> searchDownstreamNodes(WorkflowContext workflowContext, Node deleteNode) {
        if(DataUtil.isNull(deleteNode))
            return null;

        TreeMap<Long, Node> downstreamNodes = new TreeMap<Long, Node>();
        for(NodeOutputPort outputDataPort : deleteNode.getOutputDataTablePorts()) {
            List<Node> nodes = workflowContext.fetchDownstreamNodes(outputDataPort);
            if(DataUtil.isNotEmpty(nodes)) {
                for (Node downstreamNode : nodes) {
                    if(downstreamNode.needAnalyzeSchema())  //non-deleted, non-analyzed, have data-table output
                        CollectionUtil.put(downstreamNodes, downstreamNode.data().getNodeId(), downstreamNode);
                }
            }
        }

        return CollectionUtil.toList(downstreamNodes);
    }

    private static void analyzeOneNode(WorkflowContext workflowContext, Node currentNode, Deque<Node> analyzeStack) {
        if(DataUtil.isNull(currentNode) || !currentNode.needAnalyzeSchema())
            return;


        SchemaAnalyzerHelper.analyzeSchema(workflowContext, currentNode);
        currentNode.markAnalyzed();
        SchemaAnalyzerHelper.searchDownstreamNodes(workflowContext, currentNode, analyzeStack, false);
    }

    private static void analyzeStackNodes(WorkflowContext workflowContext, Deque<Node> analyzeStack) {
        Node currentNode = null;
        while(DataUtil.isNotNull(currentNode = CollectionUtil.pollLast(analyzeStack))) {
            analyzeOneNode(workflowContext, currentNode, analyzeStack);
        }
    }

    public static void analyzeStartNode(WorkflowContext workflowContext, Node startNode) {

        Deque<Node> analyzeStack = new LinkedList<Node>();
        analyzeOneNode(workflowContext, startNode, analyzeStack);
        analyzeStackNodes(workflowContext, analyzeStack);
    }
}
