package com.yatop.lambda.workflow.core.mgr.workflow.node.link;

import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.context.WorkflowContext;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.Node;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.NodeLink;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.NodePortInput;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.NodePortOutput;
import org.springframework.stereotype.Service;

@Service
public class LinkValidate {


    public boolean matchTargetCharType(NodePortOutput srcNodePort, NodePortInput dstNodePort) {
        return srcNodePort.getModulePort().getCmptChar().getType().matchTargetType(dstNodePort.getModulePort().getCmptChar().getType());
    }

    public boolean validateLink(WorkflowContext workflowContext, Node srcNode, Node dstNode, NodePortOutput srcNodePort, NodePortInput dstNodePort) {

        if(srcNode.getModule().getComponent().isWebComponent()) {
            NodeLink link = workflowContext.getWebInLink(dstNodePort.getNodePortId());
            if (DataUtil.isNotNull(link))
                return false;
        } else {
            NodeLink link = workflowContext.getNonWebInLink(dstNodePort.getNodePortId());
            if (DataUtil.isNotNull(link))
                return false;
        }

        return matchTargetCharType(srcNodePort, dstNodePort);
    }
}
