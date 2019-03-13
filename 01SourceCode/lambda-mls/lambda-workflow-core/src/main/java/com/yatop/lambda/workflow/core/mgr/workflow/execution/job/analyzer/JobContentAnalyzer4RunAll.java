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

public class JobContentAnalyzer4RunAll {

    protected static List<TreeSet<Node>> analyzeJobContent(WorkflowContext workflowContext) {

        //TODO 改为简单点，直接在search node过程中构建wait-head-nodes和wait-nodes ?

        List<Node> allHeadNodes = searchHeadNodes(workflowContext);
        if(DataUtil.isEmpty(allHeadNodes))
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Analyze job content failed -- no executable nodes.", "无可运行节点");

        TreeSet<Node> jobStartNodes = new TreeSet<Node>();
        TreeSet<Node> jobSubNodes = new TreeSet<Node>();
        Deque<Node> analyzeStack = new LinkedList<Node>();
        for(Node headNode : allHeadNodes) {
            CollectionUtil.add(jobStartNodes, headNode);
            CollectionUtil.offerLast(analyzeStack, headNode);
        }
        analyzeDownstreamNodes(workflowContext, analyzeStack, jobSubNodes);
        List<TreeSet<Node>> initialJobContent = new ArrayList<TreeSet<Node>>(2);
        initialJobContent.add(jobStartNodes);
        initialJobContent.add(jobSubNodes);
        return initialJobContent;
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
            for (NodeOutputPort outputPort : currentNode.getOutputNodePorts()) {
                List<Node> downstreamNodes = workflowContext.fetchDownstreamNodes(outputPort);
                if (DataUtil.isNotEmpty(downstreamNodes)) {
                    for (Node downstreamNode : downstreamNodes) {
                        if (downstreamNode.isStateNotReady()) {
                            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Analyze job content failed -- node not ready.", downstreamNode.data().getWarningMsg(), downstreamNode.data());
                        }

                        if (!isUpstreamNodeExecutionConditionReady(workflowContext, downstreamNode))
                            continue;

                        if (!CollectionUtil.contains(jobSubNodes, downstreamNode)) {
                            CollectionUtil.offerLast(analyzeStack, downstreamNode);
                        }
                    }
                }
            }
        }

        CollectionUtil.add(jobSubNodes, currentNode);
    }

    private static boolean isUpstreamNodeExecutionConditionReady(WorkflowContext workflowContext, Node currentNode) {
        if(!currentNode.isHeadNode()) {
            for (NodeInputPort inputPort : currentNode.getInputNodePorts()) {

                Node upstreamNode = workflowContext.fetchUpstreamNode(inputPort);
                if (DataUtil.isNull(upstreamNode) && inputPort.getCmptChar().isRequired()) {
                    return false;
                }
                if (DataUtil.isNotNull(upstreamNode) && upstreamNode.isStateNotReady()) {
                    return false;
                }
            }
        }
        return true;
    }

    public static List<Node> searchHeadNodes(WorkflowContext workflowContext) {
        if(workflowContext.nodeCount() == 0)
            return null;

        List<Node> headNodes = new ArrayList<Node>();
        for(Node node : workflowContext.getNodes()) {
            if(node.isStateNotReady()) {
                throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Analyze job content failed -- node not ready.", node.data().getWarningMsg(), node.data());
            }

            if(node.isHeadNode()) {
                headNodes.add(node);
            }
        }
        return headNodes;
    }
}
