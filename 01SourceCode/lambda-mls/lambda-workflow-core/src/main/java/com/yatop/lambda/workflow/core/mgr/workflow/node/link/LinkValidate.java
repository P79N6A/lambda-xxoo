package com.yatop.lambda.workflow.core.mgr.workflow.node.link;

import com.yatop.lambda.core.enums.LambdaExceptionEnum;
import com.yatop.lambda.core.exception.LambdaException;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.context.WorkflowContext;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.Node;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.NodeLink;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.NodeInputPort;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.NodeOutputPort;
import org.springframework.stereotype.Service;

@Service
public class LinkValidate {

    public boolean validateLink(WorkflowContext workflowContext, Node srcNode, Node dstNode, NodeOutputPort srcNodePort, NodeInputPort dstNodePort) {

        if(srcNode.data().getNodeId().equals(dstNode.data().getNodeId()))
            return false;

        if(DataUtil.isNull(srcNode.getOutputNodePort(srcNodePort.data().getNodePortId())))
            return false;

        if(DataUtil.isNull(dstNode.getInputNodePort(dstNodePort.data().getNodePortId())))
            return false;

        NodeLink link = workflowContext.fetchInLink(dstNodePort.data().getNodePortId());
        if (DataUtil.isNotNull(link))
            return false;

        return srcNodePort.matchTargetInputPort(dstNodePort);
    }

    public boolean validateLink(WorkflowContext workflowContext, Long srcNodeId, Long dstNodeId, Long srcNodePortId, Long dstNodePortId) {
        Node srcNode = workflowContext.fetchNode(srcNodeId);
        Node dstNode = workflowContext.fetchNode(dstNodeId);

        NodeOutputPort srcNodePort = srcNode.getOutputNodePort(srcNodePortId);
        if(DataUtil.isNull(srcNodePort)) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Validate node link failed -- source node port info missing.", "输出端口信息缺失", srcNode.data());
        }

        NodeInputPort dstNodePort = srcNode.getInputNodePort(dstNodePortId);
        if(DataUtil.isNull(dstNodePort)) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Validate node link failed -- destination node port info missing.", "输入端口信息缺失", dstNode.data());
        }

        return validateLink(workflowContext, srcNode, dstNode, srcNodePort, dstNodePort);
    }
}
