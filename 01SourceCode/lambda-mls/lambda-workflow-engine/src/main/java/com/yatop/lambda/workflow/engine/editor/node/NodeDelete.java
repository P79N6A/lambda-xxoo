package com.yatop.lambda.workflow.engine.editor.node;


import com.yatop.lambda.core.mgr.workflow.node.NodeMgr;
import com.yatop.lambda.workflow.core.context.WorkflowContext;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.Node;
import com.yatop.lambda.workflow.engine.editor.node.parameter.ParameterDelete;
import com.yatop.lambda.workflow.engine.editor.node.port.NodePortDelete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NodeDelete {

    @Autowired
    NodeMgr nodeMgr;

    @Autowired
    NodePortDelete nodePortDelete;

    @Autowired
    ParameterDelete parameterDelete;

    public void deleteNode(WorkflowContext workflowContext, Node node) {

        nodePortDelete.deleteNodePorts(workflowContext, node);
        parameterDelete.deleteParameters(workflowContext, node);
        nodeMgr.deleteNode(node, workflowContext.getOperId());
        workflowContext.deleteNode(node);
    }
}
