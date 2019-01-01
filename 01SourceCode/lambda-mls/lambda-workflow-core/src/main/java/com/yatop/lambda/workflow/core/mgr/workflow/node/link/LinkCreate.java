package com.yatop.lambda.workflow.core.mgr.workflow.node.link;

import com.yatop.lambda.core.mgr.workflow.node.NodeLinkMgr;
import com.yatop.lambda.workflow.core.context.WorkflowContext;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.Node;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.NodeLink;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.NodePortInput;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.NodePortOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LinkCreate {

    @Autowired
    NodeLinkMgr nodeLinkMgr;

    public NodeLink createLink(WorkflowContext workflowContext, Node srcNode, Node dstNode, NodePortOutput srcNodePort, NodePortInput dstNodePort) {
        return null;
    }
}
