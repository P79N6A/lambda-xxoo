package com.yatop.lambda.workflow.core.mgr.workflow.node.parameter;

import com.yatop.lambda.core.enums.LambdaExceptionEnum;
import com.yatop.lambda.core.enums.SourceLevelEnum;
import com.yatop.lambda.core.enums.SpecTypeEnum;
import com.yatop.lambda.core.exception.LambdaException;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.context.WorkflowContext;
import com.yatop.lambda.workflow.core.mgr.workflow.charvalue.ParamCharValueHelper;
import com.yatop.lambda.workflow.core.richmodel.workflow.charvalue.CharValue;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.Node;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.NodeParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParameterCharValueUpdate {

    @Autowired
    private ParameterCreate parameterCreate;

    private NodeParameter updateParameter(WorkflowContext workflowContext, Node node, NodeParameter targetParameter, String paramValue, Class<ParameterCharValueUpdate> none) {

        if(targetParameter.getCmptChar().data().getSrcLevel() == SourceLevelEnum.WORKFLOW.getSource()) {
            if(!targetParameter.isSimulateParameter()) {
                if(DataUtil.isEmpty(targetParameter.data().getCharValue()) && DataUtil.isEmpty(paramValue))
                    return targetParameter;

                CharValue charValue = targetParameter.getCharValue();
                charValue.setTextValue(paramValue);
                ParamCharValueHelper.updateParamCharValue(workflowContext, node, charValue);

                targetParameter.data().setCharValue(DataUtil.isNotEmpty(charValue.getCharValue()) ? charValue.getCharValue() : null);
                return targetParameter;
            } else {
                return parameterCreate.createParameter(workflowContext, node, targetParameter.getCmptChar(), paramValue);
            }
        } else {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Update node parameter failed -- error source-level.", "节点参数来源级别不允许更新", node.data(), targetParameter.data());
        }
    }

    public void updateParameter(WorkflowContext workflowContext, Node node, NodeParameter targetParameter, String paramValue) {

        switch (SpecTypeEnum.valueOf(targetParameter.data().getSpecType())) {
            case PARAMETER: {
                NodeParameter parameter = updateParameter(workflowContext, node, targetParameter, paramValue, ParameterCharValueUpdate.class);
                node.putParameter(parameter);
                break;
            }
            case OPTIMIZE_EXECUTION: {
                NodeParameter parameter = updateParameter(workflowContext, node, targetParameter, paramValue, ParameterCharValueUpdate.class);
                node.putOptimizeParameter(parameter);
                break;
            }
            default:
                throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Update node parameter failed -- error spec-type.", "节点参数规格类型不允许更新", node.data(), targetParameter.data());
        }
        workflowContext.doneUpdateNodeParameter(node, targetParameter);
    }
}
