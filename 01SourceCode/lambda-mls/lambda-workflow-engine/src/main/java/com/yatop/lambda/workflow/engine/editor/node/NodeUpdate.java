package com.yatop.lambda.workflow.engine.editor.node;

import com.yatop.lambda.core.mgr.workflow.node.NodeMgr;
import com.yatop.lambda.workflow.core.context.WorkflowContext;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.Node;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NodeUpdate {

    @Autowired
    NodeMgr nodeMgr;

    //名称、X坐标、Y坐标、警告消息、节点状态、注释、概要、描述
    public void updateNode(WorkflowContext workflowContext, Node node) {
        nodeMgr.updateNode(node, workflowContext.getOperId());
        node.copyProperties(nodeMgr.queryNode(node.getNodeId()));
    }
}
