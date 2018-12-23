package com.yatop.lambda.workflow.engine.editor.node;

import com.yatop.lambda.base.model.WfFlowNode;
import com.yatop.lambda.base.model.WfFlowNodeParameter;
import com.yatop.lambda.core.enums.SourceLevelEnum;
import com.yatop.lambda.core.mgr.workflow.node.NodeMgr;
import com.yatop.lambda.core.mgr.workflow.node.NodeParameterMgr;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.context.WorkflowContext;
import com.yatop.lambda.workflow.core.richmodel.component.Component;
import com.yatop.lambda.workflow.core.richmodel.component.characteristic.CmptChar;
import com.yatop.lambda.workflow.core.richmodel.component.specification.CmptSpec;
import com.yatop.lambda.workflow.core.richmodel.workflow.CharValue;
import com.yatop.lambda.workflow.core.richmodel.workflow.module.Module;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.Node;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.NodeParameter;
import com.yatop.lambda.workflow.engine.editor.value.CharValueCreate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NodeCreate {

    @Autowired
    private NodeMgr nodeMgr;

    @Autowired
    NodeParameterMgr nodeParameterMgr;

    @Autowired
    private CharValueCreate charValueCreate;

    private NodeParameter createNodeParameter(WorkflowContext workflowContext, Component component, CmptSpec cmptSpec, CmptChar cmptChar, Node node, String charValueText) {

        CharValue charValue = null;
        if(cmptChar.getSrcLevel() == SourceLevelEnum.WORKFLOW.getSource()) {
            charValue = charValueCreate.createCharValue(workflowContext, component, cmptSpec, cmptChar, charValueText);
        } else {
            return null;
        }

        WfFlowNodeParameter parameter = new WfFlowNodeParameter();
        parameter.setNodeId(node.getNodeId());
        parameter.setSpecType(cmptSpec.getSpecType());
        parameter.setCharId(cmptChar.getCharId());
        if(DataUtil.isNotNull(charValue.getCharValue()))
            parameter.setCharValue(charValue.getCharValue());
        nodeParameterMgr.insertNodeParameter(parameter, workflowContext.getOperId());

        NodeParameter richParameter = new NodeParameter(parameter, cmptChar);
        richParameter.copyProperties(nodeParameterMgr.queryNodeParameter(richParameter.getNodeId(), richParameter.getCharId()));
        richParameter.setValue(charValue);
        return richParameter;
    }

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

        Component component = module.getComponent();
        //组件参数
        CmptSpec paramSpec = component.getParameter();
        for (CmptChar cmptChar : paramSpec.getCmptChars()) {
            NodeParameter richParameter = createNodeParameter(workflowContext, component, paramSpec, cmptChar, richNode, null);
            richNode.putParameter(richParameter);
        }

        //执行调优参数
        CmptSpec optimizeSpec = component.getOptimizeExecution();
        for (CmptChar cmptChar : optimizeSpec.getCmptChars()) {
            NodeParameter richParameter = createNodeParameter(workflowContext, component, optimizeSpec, cmptChar, richNode, null);
            richNode.putOptimizeParameter(richParameter);
        }

        return null;
    }
}
