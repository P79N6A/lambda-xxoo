package com.yatop.lambda.workflow.engine.editor.node.parameter;

import com.yatop.lambda.base.model.WfFlowNodeParameter;
import com.yatop.lambda.core.enums.DataStatusEnum;
import com.yatop.lambda.core.enums.IsDuplicatedEnum;
import com.yatop.lambda.core.enums.IsGlobalParameterEnum;
import com.yatop.lambda.core.enums.SourceLevelEnum;
import com.yatop.lambda.core.mgr.workflow.node.NodeParameterMgr;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.context.WorkflowContext;
import com.yatop.lambda.workflow.core.richmodel.component.Component;
import com.yatop.lambda.workflow.core.richmodel.component.characteristic.CmptChar;
import com.yatop.lambda.workflow.core.richmodel.component.specification.CmptSpec;
import com.yatop.lambda.workflow.core.richmodel.workflow.CharValue;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.Node;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.NodeParameter;
import com.yatop.lambda.workflow.engine.editor.node.value.CharValueCreate;
import com.yatop.lambda.workflow.engine.editor.node.value.CharValueQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ParameterCreate {

    @Autowired
    private NodeParameterMgr nodeParameterMgr;

    @Autowired
    private CharValueCreate charValueCreate;

    @Autowired
    private CharValueQuery charValueQuery;

    private NodeParameter createParameter(WorkflowContext workflowContext, Node node, CmptChar cmptChar) {
        return createParameter(workflowContext, node, cmptChar, null);
    }

    private NodeParameter createParameter(WorkflowContext workflowContext, Node node, CmptChar cmptChar, String charValueText) {

        if(cmptChar.getSrcLevel() == SourceLevelEnum.WORKFLOW.getSource()) {
            CharValue charValue = new CharValue(cmptChar, charValueText);
            charValueCreate.createCharValue(workflowContext, node, charValue);

            WfFlowNodeParameter parameter = new WfFlowNodeParameter();
            parameter.setNodeId(node.getNodeId());
            parameter.setSpecType(charValue.getSpecType());
            parameter.setCharId(cmptChar.getCharId());
            if(DataUtil.isNotNull(charValue.getCharValue()))
                parameter.setCharValue(charValue.getCharValue());
            nodeParameterMgr.insertNodeParameter(parameter, workflowContext.getOperId());

            NodeParameter richParameter = new NodeParameter(parameter, cmptChar, charValue);
            richParameter.copyProperties(nodeParameterMgr.queryNodeParameter(richParameter.getNodeId(), richParameter.getCharId()));
            return richParameter;
        } else {
            CharValue charValue = new CharValue(cmptChar);
            charValueQuery.queryCharValue(workflowContext, node, charValue);

            //模拟生成非workflow来源级别的节点参数
            Date curTime = new Date();
            WfFlowNodeParameter parameter = new WfFlowNodeParameter();
            parameter.setNodeId(node.getNodeId());
            parameter.setSpecType(charValue.getSpecType());
            parameter.setCharId(cmptChar.getCharId());
            if(DataUtil.isNotNull(charValue.getCharValue()))
                parameter.setCharValue(charValue.getCharValue());
            parameter.setIsGlobalParameter(IsGlobalParameterEnum.NO.getMark());
            parameter.setIsDuplicated(IsDuplicatedEnum.NO.getMark());
            parameter.setStatus(DataStatusEnum.NORMAL.getStatus());
            parameter.setDescription(SourceLevelEnum.valueOf(cmptChar.getSrcLevel()) + " Source Level");
            parameter.setLastUpdateTime(curTime);
            parameter.setLastUpdateOper(workflowContext.getOperId());
            parameter.setCreateTime(curTime);
            parameter.setCreateOper(workflowContext.getOperId());
            return new NodeParameter(parameter, cmptChar, charValue);
        }
    }

    public void createParameters(WorkflowContext workflowContext, Node node) {

        Component component = node.getComponent();
        //组件参数
        CmptSpec paramSpec = component.getParameter();
        for (CmptChar cmptChar : paramSpec.getCmptChars()) {
            NodeParameter parameter = createParameter(workflowContext, node, cmptChar);
            node.putParameter(parameter);
        }

        //执行调优参数
        CmptSpec optimizeSpec = component.getOptimizeExecution();
        for (CmptChar cmptChar : optimizeSpec.getCmptChars()) {
            NodeParameter parameter = createParameter(workflowContext, node, cmptChar);
            node.putOptimizeParameter(parameter);
        }
    }

    private void copyParameters(WorkflowContext workflowContext, Node node, Node otherNode) {

        Component component = node.getComponent();
        //组件参数
        CmptSpec paramSpec = component.getParameter();
        for (CmptChar cmptChar : paramSpec.getCmptChars()) {
            NodeParameter parameter = createParameter(workflowContext, node, cmptChar, otherNode.getParameter(cmptChar.getCharId()).getValue().getOutText());
            node.putParameter(parameter);
        }

        //执行调优参数
        CmptSpec optimizeSpec = component.getOptimizeExecution();
        for (CmptChar cmptChar : optimizeSpec.getCmptChars()) {
            NodeParameter parameter = createParameter(workflowContext, node, cmptChar, otherNode.getParameter(cmptChar.getCharId()).getValue().getOutText());
            node.putOptimizeParameter(parameter);
        }
    }
}
