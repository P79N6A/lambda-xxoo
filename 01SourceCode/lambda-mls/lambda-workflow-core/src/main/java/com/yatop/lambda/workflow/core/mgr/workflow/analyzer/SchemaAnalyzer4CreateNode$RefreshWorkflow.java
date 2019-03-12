package com.yatop.lambda.workflow.core.mgr.workflow.analyzer;

import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.context.WorkflowContext;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.Node;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.NodeOutputPort;
import com.yatop.lambda.workflow.core.utils.CollectionUtil;

import java.util.*;

public class SchemaAnalyzer4CreateNode$RefreshWorkflow {

    private static void analyzeOneNode(WorkflowContext workflowContext, Node currentNode, Deque<Node> analyzeStack) {

        if(DataUtil.isNull(currentNode) || !currentNode.needAnalyzeSchema())
            return;

        if(!currentNode.isHeadNode()) {
            TreeMap<Long, NodeOutputPort> upstreamPorts = workflowContext.fetchUpstreamPorts(currentNode);
            if(DataUtil.isNotEmpty(upstreamPorts)) {
                for (NodeOutputPort outputPort : CollectionUtil.toList(upstreamPorts)) {

                    //上游数据端口有未分析时，先跳过该节点
                    if(outputPort.isDataTablePort() && !outputPort.isAnalyzed())
                        return;
                }
            }
        }

        SchemaAnalyzerHelper.analyzeSchema(workflowContext, currentNode);
        currentNode.markAnalyzed();
        SchemaAnalyzerHelper.searchDownstreamNodes(workflowContext, currentNode, analyzeStack, true);
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
