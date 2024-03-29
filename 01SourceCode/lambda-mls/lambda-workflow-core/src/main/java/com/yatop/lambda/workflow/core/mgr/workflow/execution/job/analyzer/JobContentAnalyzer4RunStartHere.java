package com.yatop.lambda.workflow.core.mgr.workflow.execution.job.analyzer;

import com.yatop.lambda.core.enums.LambdaExceptionEnum;
import com.yatop.lambda.core.exception.LambdaException;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.context.WorkflowContext;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.Node;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.NodeInputPort;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.NodeOutputPort;
import com.yatop.lambda.workflow.core.utils.CollectionUtil;

import java.util.*;

public class JobContentAnalyzer4RunStartHere {

    protected static List<TreeSet<Node>> analyzeJobContent(WorkflowContext workflowContext, Node relatedNode) {

        if(DataUtil.isNull(relatedNode))
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Analyze job content failed -- no executable nodes.", "无可运行节点");

        if(relatedNode.isStateNotReady()) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Analyze job content failed -- node not ready.", relatedNode.data().getWarningMsg(), relatedNode.data());
        }

        checkUpstreamNodeExecutionConditionReady(workflowContext, relatedNode);

        TreeSet<Node> jobStartNodes = new TreeSet<Node>() {{ add(relatedNode); }};
        TreeSet<Node> jobSubNodes = new TreeSet<Node>();
        Deque<Node> analyzeStack = new LinkedList<Node>() {{ add(relatedNode); }};
        analyzeDownstreamNodes(workflowContext, analyzeStack, jobSubNodes);

        for(Node waitNode : jobSubNodes) {
            checkUpstreamNodeExecutionConditionReady(workflowContext, waitNode, relatedNode, jobSubNodes);
        }

        List<TreeSet<Node>> jobContent = new ArrayList<TreeSet<Node>>(2);
        jobContent.add(jobStartNodes);
        jobContent.add(jobSubNodes);
        return jobContent;
    }

    private static void analyzeDownstreamNodes(WorkflowContext workflowContext, Deque<Node> analyzeStack, TreeSet<Node> jobSubNodes) {

        Node currentNode = null;
        while(DataUtil.isNotNull(currentNode = CollectionUtil.pollLast(analyzeStack))) {
            searchDownstreamNodes(workflowContext, currentNode, analyzeStack, jobSubNodes);
        }
    }

    private static void searchDownstreamNodes(WorkflowContext workflowContext, Node currentNode, Deque<Node> analyzeStack, TreeSet<Node> jobSubNodes) {

        if(DataUtil.isNull(currentNode) || CollectionUtil.contains(jobSubNodes, currentNode))
            return;

        if(currentNode.inputNodePortCount() > 0) {
            for(NodeOutputPort outputPort : currentNode.getOutputNodePorts()) {
                List<Node> downstreamNodes = workflowContext.fetchDownstreamNodes(outputPort);
                if(DataUtil.isNotEmpty(downstreamNodes)) {
                    for (Node downstreamNode : downstreamNodes) {
                        if(downstreamNode.isStateNotReady()) {
                            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Analyze job content failed -- node not ready.", downstreamNode.data().getWarningMsg(), downstreamNode.data());
                        }

                        if (!CollectionUtil.contains(jobSubNodes, downstreamNode)) {
                            CollectionUtil.offerLast(analyzeStack, downstreamNode);
                        }
                    }
                }
            }
        }

        CollectionUtil.add(jobSubNodes, currentNode);
    }

    private static void checkUpstreamNodeExecutionConditionReady(WorkflowContext workflowContext, Node currentNode) {
        if(!currentNode.isHeadNode()) {
            for (NodeInputPort inputPort : currentNode.getInputNodePorts()) {

                Node upstreamNode = workflowContext.fetchUpstreamNode(inputPort);
                if (DataUtil.isNull(upstreamNode) && inputPort.getCmptChar().isRequired()) {
                    throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Analyze job content failed -- required input port not connected.", currentNode.data().getWarningMsg(), currentNode.data());
                }
                if (DataUtil.isNotNull(upstreamNode) && !upstreamNode.isStateSuccess()) {
                    throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Analyze job content failed -- upstream node not executed successfully.", "[" + currentNode.data().getNodeName() + "]上游未运行成功", currentNode.data());
                }
            }
        }
    }

    private static void checkUpstreamNodeExecutionConditionReady(WorkflowContext workflowContext, Node currentNode, Node headNode, TreeSet<Node> jobSubNodes) {
        if(!currentNode.isHeadNode()) {
            for (NodeInputPort inputPort : currentNode.getInputNodePorts()) {

                Node upstreamNode = workflowContext.fetchUpstreamNode(inputPort);
                if (DataUtil.isNull(upstreamNode) && inputPort.getCmptChar().isRequired()) {
                    throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Analyze job content failed -- required input port not connected.", currentNode.data().getWarningMsg(), currentNode.data());
                }
                if (DataUtil.isNotNull(upstreamNode)) {
                    if(upstreamNode.compareTo(headNode) == 0)
                        continue;

                    if(CollectionUtil.contains(jobSubNodes, upstreamNode))
                        continue;

                    if(!upstreamNode.isStateSuccess())
                        throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Analyze job content failed -- upstream node not executed successfully.", "[" + currentNode.data().getNodeName() + "]上游未运行成功", currentNode.data());
                }
            }
        }
    }
}
