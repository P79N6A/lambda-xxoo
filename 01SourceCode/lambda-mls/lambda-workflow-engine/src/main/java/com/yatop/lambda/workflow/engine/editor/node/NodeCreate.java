package com.yatop.lambda.workflow.engine.editor.node;

import com.yatop.lambda.base.model.WfFlowNode;
import com.yatop.lambda.core.mgr.workflow.node.NodeMgr;
import com.yatop.lambda.workflow.core.context.WorkflowContext;
import com.yatop.lambda.workflow.core.richmodel.workflow.module.Module;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.Node;
import com.yatop.lambda.workflow.engine.editor.node.parameter.ParameterCreate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NodeCreate {

    @Autowired
    private NodeMgr nodeMgr;

    @Autowired
    private ParameterCreate parameterCreate;

    public Node createNode(WorkflowContext workflowContext, Module module, Long x, Long y) {
        WfFlowNode node = new WfFlowNode();
        node.setNodeName(module.getModuleName());
        node.setOwnerProjectId(workflowContext.getProject().getProjectId());
        node.setOwnerFlowId(workflowContext.getWorkflow().getFlowId());
        node.setRefModuleId(module.getModuleId());
        node.setPositionX(x);
        node.setPositionY(y);
        nodeMgr.insertNode(node, workflowContext.getOperId());

        Node richNode = new Node(node, module);
        richNode.copyProperties(nodeMgr.queryNode(richNode.getNodeId()));
        workflowContext.putNode(richNode);

        parameterCreate.createParameters(workflowContext, richNode);

       /* */

        return null;
    }

    public Node createNode(WorkflowContext workflowContext, Node otherNode, Long x, Long y) {
/*        WfFlowNode node = new WfFlowNode();
        node.setNodeName(module.getModuleName());
        node.setOwnerProjectId(workflowContext.getProject().getProjectId());
        node.setOwnerFlowId(workflowContext.getWorkflow().getFlowId());
        node.setRefModuleId(module.getModuleId());
        node.setPositionX(x);
        node.setPositionY(y);
        nodeMgr.insertNode(node, workflowContext.getOperId());

        Node richNode = new Node(node, module);
        richNode.copyProperties(nodeMgr.queryNode(richNode.getNodeId()));
        workflowContext.putNode(richNode);

        Component component = module.getComponent();
        //组件参数
        CmptSpec paramSpec = component.getParameter();
        for (CmptChar cmptChar : paramSpec.getCmptChars()) {
            NodeParameter richParameter = parameterCreate.createParameter(workflowContext, richNode, cmptChar, null);
            richNode.putParameter(richParameter);
        }

        //执行调优参数
        CmptSpec optimizeSpec = component.getOptimizeExecution();
        for (CmptChar cmptChar : optimizeSpec.getCmptChars()) {
            NodeParameter richParameter = parameterCreate.createParameter(workflowContext, richNode, cmptChar, null);
            richNode.putOptimizeParameter(richParameter);
        }*/

        return null;
    }
}
