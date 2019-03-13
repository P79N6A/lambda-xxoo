package com.yatop.lambda.workflow.core.mgr.workflow.execution.job.analyzer;

import com.yatop.lambda.core.enums.LambdaExceptionEnum;
import com.yatop.lambda.core.exception.LambdaException;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.context.WorkflowContext;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.Node;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.NodeInputPort;

import java.util.*;

public class JobContentAnalyzer4RunThisNode {

    protected static List<TreeSet<Node>> analyzeJobContent(WorkflowContext workflowContext, Node relatedNode) {

        if(DataUtil.isNull(relatedNode))
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Analyze job content failed -- no executable nodes.", "无可运行节点");

        if(relatedNode.isStateNotReady()) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Analyze job content failed -- node not ready.", relatedNode.data().getWarningMsg(), relatedNode.data());
        }

        checkUpstreamNodeExecutionConditionReady(workflowContext, relatedNode);

        TreeSet<Node> jobStartNodes = new TreeSet<Node>() {{ add(relatedNode); }};
        TreeSet<Node> jobSubNodes = new TreeSet<Node>();
        List<TreeSet<Node>> jobContent = new ArrayList<TreeSet<Node>>(2);
        jobContent.add(jobStartNodes);
        jobContent.add(jobSubNodes);
        return jobContent;
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
}
