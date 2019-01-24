package com.yatop.lambda.workflow.core.mgr.workflow.execution.job.analyzer;

import com.yatop.lambda.core.enums.LambdaExceptionEnum;
import com.yatop.lambda.core.exception.LambdaException;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.context.WorkflowContext;
import com.yatop.lambda.workflow.core.context.WorkflowContextHelper;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.Node;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.NodeLink;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.NodePortInput;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.NodePortOutput;
import com.yatop.lambda.workflow.core.utils.CollectionUtil;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

public class JobContentAnalyzer4General {

    protected static TreeSet<Node>[] analyzeJobContent4RunAll(WorkflowContext workflowContext) {

        List<Node> allHeadNodes = WorkflowContextHelper.searchHeadNodes(workflowContext);
        if(DataUtil.isEmpty(allHeadNodes))
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Analyze job content failed -- no executable node.", "无可运行节点");

        TreeSet<Node> waitHeadNodes = new TreeSet<Node>();
        Deque<Node> analyzeStack = new LinkedList<Node>();
        for(Node headNode : allHeadNodes) {
            if(!headNode.isWebNode()) {
                if(headNode.isStateNotReady()) {
                    throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Analyze job content failed -- node not ready.", "[" + headNode.data().getNodeName() + "]节点未就绪", headNode);
                }
                CollectionUtil.add(waitHeadNodes, headNode);
                CollectionUtil.offerLast(analyzeStack, headNode);
            }
        }

        if(DataUtil.isEmpty(waitHeadNodes))
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Analyze job content failed -- no executable node.", "无可运行节点");

        TreeSet<Node> waitNodes = new TreeSet<Node>();
        analyzeDownstreamNodes(workflowContext, analyzeStack, waitNodes);
        return new TreeSet[] {waitHeadNodes, waitNodes};
    }

    protected static TreeSet<Node>[] analyzeJobContent4RunStartHere(WorkflowContext workflowContext, Node relatedNode) {

        if(DataUtil.isNull(relatedNode) || relatedNode.isWebNode())
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Analyze job content failed -- no executable node.", "无可运行节点");

        if(relatedNode.isStateNotReady()) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Analyze job content failed -- node not ready.", "[" + relatedNode.data().getNodeName() + "]节点未就绪", relatedNode);
        }

        if(isUpstreamNodeExecutionConditionReady(workflowContext, relatedNode, true)) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Analyze job content failed -- upstream node not executed successfully.", "[" + relatedNode.data().getNodeName() + "]上游未运行成功", relatedNode);
        }

        TreeSet<Node> waitHeadNodes = new TreeSet<Node>() {{ add(relatedNode); }};
        Deque<Node> analyzeStack = new LinkedList<Node>() {{ add(relatedNode); }};

        TreeSet<Node> waitNodes = new TreeSet<Node>();
        analyzeDownstreamNodes(workflowContext, analyzeStack, waitNodes);
        return new TreeSet[] {waitHeadNodes, waitNodes};
    }

    protected static TreeSet<Node>[] analyzeJobContent4RunEndHere(WorkflowContext workflowContext, Node relatedNode) {
        //TODO search upstream head nodes
        //TODO check node state ready in upstream paths
        return null;
    }

    protected static TreeSet<Node>[] analyzeJobContent4RunThisNode(WorkflowContext workflowContext, Node relatedNode) {

        if(DataUtil.isNull(relatedNode) || relatedNode.isWebNode())
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Analyze job content failed -- no executable node.", "无可运行节点");

        if(relatedNode.isStateNotReady()) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Analyze job content failed -- node not ready.", "[" + relatedNode.data().getNodeName() + "]节点未就绪", relatedNode);
        }

        if(isUpstreamNodeExecutionConditionReady(workflowContext, relatedNode, true)) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Analyze job content failed -- upstream node not executed successfully.", "[" + relatedNode.data().getNodeName() + "]上游未运行成功", relatedNode);
        }

        TreeSet<Node> waitHeadNodes = new TreeSet<Node>() {{ add(relatedNode); }};
        TreeSet<Node> waitNodes = new TreeSet<Node>();
        return new TreeSet[] {waitHeadNodes, waitNodes};
    }

    private static void analyzeDownstreamNodes(WorkflowContext workflowContext, Deque<Node> analyzeStack, TreeSet<Node> waitNodes) {

        Node currentNode = null;
        while(DataUtil.isNotNull(currentNode = CollectionUtil.pollLast(analyzeStack))) {
            searchDownstreamNodes(workflowContext, currentNode, analyzeStack, waitNodes);
        }
    }

    private static void searchDownstreamNodes(WorkflowContext workflowContext, Node currentNode, Deque<Node> analyzeStack, TreeSet<Node> waitNodes) {

        if(DataUtil.isNull(currentNode) || currentNode.outputPortCount() > 0)
            return;

        for(NodePortOutput outputDataPort : currentNode.getOutputNodePorts()) {
            List<Node> downstreamNodes = workflowContext.fetchDownstreamNodes(outputDataPort);
            if(DataUtil.isNotEmpty(downstreamNodes)) {
                for (Node downstreamNode : downstreamNodes) {
                    if(downstreamNode.isStateNotReady()) {
                        throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Analyze job content failed -- node not ready.", "[" + downstreamNode.data().getNodeName() + "]节点未就绪", downstreamNode);
                    }

                    if(!isUpstreamNodeExecutionConditionReady(workflowContext, downstreamNode, false))
                        continue;

                    if(CollectionUtil.contains(waitNodes, downstreamNode)) {
                        continue;
                    }

                    CollectionUtil.add(waitNodes, downstreamNode);
                    if(downstreamNode.outputPortCount() > 0) {
                        CollectionUtil.offerLast(analyzeStack, downstreamNode);
                    }
                }
            }
        }
    }

    private static boolean isUpstreamNodeExecutionConditionReady(WorkflowContext workflowContext, Node currentNode, boolean requireUpstreamSuccess) {
        if(!currentNode.isHeadNode()) {
            for (NodePortInput inputPort : currentNode.getInputNodePorts()) {

                NodeLink inLink = workflowContext.fetchNonWebInLink(inputPort.data().getNodePortId());
                Node upstreamNode = null;

                if (DataUtil.isNotNull(inLink)) {
                    upstreamNode = workflowContext.fetchUpstreamNode(inLink);
                }
                if (DataUtil.isNull(upstreamNode) && inputPort.getCmptChar().isRequired()) {
                    return false;
                }
                if (DataUtil.isNotNull(upstreamNode)) {
                    if (requireUpstreamSuccess && !upstreamNode.isStateSuccess())
                        return false;
                    if (upstreamNode.isStateNotReady())
                        return false;
                }
            }
        }
        return true;
    }
}
