package com.yatop.lambda.workflow.core.mgr.workflow.node.parameter;

import com.yatop.lambda.base.model.WfFlowNodeParameter;
import com.yatop.lambda.core.enums.DataStatusEnum;
import com.yatop.lambda.core.enums.SourceLevelEnum;
import com.yatop.lambda.core.mgr.workflow.node.NodeParameterMgr;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.context.WorkflowContext;
import com.yatop.lambda.workflow.core.mgr.workflow.charvalue.ParamCharValueHelper;
import com.yatop.lambda.workflow.core.richmodel.workflow.component.characteristic.CmptChar;
import com.yatop.lambda.workflow.core.richmodel.workflow.charvalue.CharValue;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.Node;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.NodeParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class ParameterHelper {

    private static NodeParameterMgr NODE_PARAMETER_MGR;

    @Autowired
    public void setNodeParameterMgr(NodeParameterMgr nodeParameterMgr) {
        NODE_PARAMETER_MGR = nodeParameterMgr;
    }

    public static NodeParameter simulateParameter(WorkflowContext workflowContext, Node node, CharValue charValue) {

        CmptChar cmptChar = charValue.getCmptChar();

        //模拟生成非workflow来源级别的节点参数，和workflow来源级别缺失的节点参数
        Date curTime = new Date();
        WfFlowNodeParameter parameter = new WfFlowNodeParameter();
        parameter.setNodeId(node.data().getNodeId());
        parameter.setSpecType(charValue.getSpecType());
        parameter.setCharId(cmptChar.data().getCharId());
        if(DataUtil.isNotNull(charValue.getCharValue()))
            parameter.setCharValue(charValue.getCharValue());
        parameter.setStatus(DataStatusEnum.NORMAL.getStatus());
        parameter.setDescription(SourceLevelEnum.valueOf(cmptChar.data().getSrcLevel()) + " Source Level -- Simulate Parameter");
        parameter.setLastUpdateTime(curTime);
        parameter.setLastUpdateOper(workflowContext.getOperId());
        parameter.setCreateTime(curTime);
        parameter.setCreateOper(workflowContext.getOperId());
        return new NodeParameter(parameter, charValue, true);
    }

    public static boolean validateUpdateNodeParameter(Node node, NodeParameter nodeParameter, String paramValue) {
        CharValue charValue = new CharValue(nodeParameter.getCmptChar(), nodeParameter.data().getCharValue());
        charValue.setTextValue(paramValue);
        return ParamCharValueHelper.validateParamCharValue(node, charValue);
    }

    public static void updateNodeParameter(NodeParameter parameter, String operId) {
        NODE_PARAMETER_MGR.updateNodeParameter(parameter.data(), operId);
        parameter.clearColoured();
    }
}
