package com.yatop.lambda.workflow.core.mgr.workflow.execution.job.analyzer;

import com.yatop.lambda.core.enums.LambdaExceptionEnum;
import com.yatop.lambda.core.exception.LambdaException;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.context.WorkflowContext;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.Node;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.NodeInputPort;
import com.yatop.lambda.workflow.core.utils.CollectionUtil;

import java.util.*;

public class JobContentAnalyzer4RunEndHere {

    protected static List<TreeSet<Node>> analyzeJobContent(WorkflowContext workflowContext, Node relatedNode) {

        if(DataUtil.isNull(relatedNode))
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Analyze job content failed -- no executable nodes.", "无可运行节点");

        if(relatedNode.isStateNotReady()) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Analyze job content failed -- node not ready.", relatedNode.data().getWarningMsg(), relatedNode.data());
        }

        TreeSet<Node> jobStartNodes = new TreeSet<Node>();
        TreeSet<Node> jobSubNodes = new TreeSet<Node>();
        Deque<Node> analyzeStack = new LinkedList<Node>(){{ add(relatedNode); }};

        analyzeUpstreamNodes(workflowContext, analyzeStack, jobStartNodes, jobSubNodes);
        List<TreeSet<Node>> jobContent = new ArrayList<TreeSet<Node>>(2);
        jobContent.add(jobStartNodes);
        jobContent.add(jobSubNodes);
        return jobContent;
    }

    private static void analyzeUpstreamNodes(WorkflowContext workflowContext, Deque<Node> analyzeStack, TreeSet<Node> jobStartNodes, TreeSet<Node> jobSubNodes) {

        Node currentNode = null;
        while(DataUtil.isNotNull(currentNode = CollectionUtil.pollLast(analyzeStack))) {
            searchUpstreamNodes(workflowContext, currentNode, analyzeStack, jobStartNodes, jobSubNodes);
        }
    }

    private static void searchUpstreamNodes(WorkflowContext workflowContext, Node currentNode, Deque<Node> analyzeStack, TreeSet<Node> jobStartNodes, TreeSet<Node> jobSubNodes) {

        if(DataUtil.isNull(currentNode)
                || CollectionUtil.contains(jobStartNodes, currentNode)
                || CollectionUtil.contains(jobSubNodes, currentNode))
            return;


        boolean upstreamNodesAllSuccess = true;
        if(currentNode.inputNodePortCount() > 0) {
            for (NodeInputPort inputPort : currentNode.getInputNodePorts()) {
                Node upstreamNode = workflowContext.fetchUpstreamNode(inputPort);

                if (DataUtil.isNull(upstreamNode) && !inputPort.getCmptChar().isRequired()) {
                    continue;
                }

                if (DataUtil.isNull(upstreamNode) || upstreamNode.isStateNotReady()) {
                    throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Analyze job content failed -- node not ready.", upstreamNode.data().getWarningMsg(), upstreamNode.data());
                }

                if (!upstreamNode.isStateSuccess()) {
                    upstreamNodesAllSuccess = false;
                    if (!CollectionUtil.contains(jobStartNodes, upstreamNode) && !CollectionUtil.contains(jobSubNodes, upstreamNode)) {
                        CollectionUtil.offerLast(analyzeStack, upstreamNode);
                    }
                }
            }
        }

        if(upstreamNodesAllSuccess) {
            CollectionUtil.add(jobStartNodes, currentNode);
        } else {
            CollectionUtil.add(jobSubNodes, currentNode);
        }
    }
}
