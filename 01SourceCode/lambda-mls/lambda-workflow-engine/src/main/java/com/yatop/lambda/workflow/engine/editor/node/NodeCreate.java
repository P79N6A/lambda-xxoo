package com.yatop.lambda.workflow.engine.editor.node;

import com.yatop.lambda.base.model.WfFlowNode;
import com.yatop.lambda.core.mgr.workflow.node.NodeMgr;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.context.WorkflowContext;
import com.yatop.lambda.workflow.core.richmodel.workflow.module.Module;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.Node;
import com.yatop.lambda.workflow.engine.editor.node.parameter.ParameterCreate;
import com.yatop.lambda.workflow.engine.editor.node.port.NodePortCreate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NodeCreate {

    @Autowired
    private NodeMgr nodeMgr;

    @Autowired
    private ParameterCreate parameterCreate;

    @Autowired
    private NodePortCreate nodePortCreate;

    private Node createNode(WorkflowContext workflowContext, Module module, Node otherNode, Long x, Long y) {
        WfFlowNode node = new WfFlowNode();
        node.setNodeName(module.getModuleName());
        node.setOwnerProjectId(workflowContext.getProject().getProjectId());
        node.setOwnerFlowId(workflowContext.getWorkflow().getFlowId());
        node.setRefModuleId(module.getModuleId());
        node.setPositionX(x);
        node.setPositionY(y);
        node = nodeMgr.insertNode(node, workflowContext.getOperId());

        Node richNode = new Node(node, module);
        //richNode.copyProperties(nodeMgr.queryNode(richNode.getNodeId()));
        workflowContext.putNode(richNode);

        if(DataUtil.isNull(otherNode)) {
            parameterCreate.createParameters(workflowContext, richNode);
        } else {
            parameterCreate.createParameters(workflowContext, richNode, otherNode);
        }
        nodePortCreate.createNodePorts(workflowContext, richNode);
        return richNode;
    }

    public Node createNode(WorkflowContext workflowContext, Module module, Long x, Long y) {
        return createNode(workflowContext, module, null, x, y);
    }

    public Node createNode(WorkflowContext workflowContext, Node otherNode, Long x, Long y) {
        return createNode(workflowContext, otherNode.getModule(), otherNode, x, y);
    }
}
