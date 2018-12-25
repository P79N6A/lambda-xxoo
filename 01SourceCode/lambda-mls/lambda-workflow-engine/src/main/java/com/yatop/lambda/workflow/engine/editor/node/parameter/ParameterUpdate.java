package com.yatop.lambda.workflow.engine.editor.node.parameter;

import com.yatop.lambda.base.model.WfFlowNodeParameter;
import com.yatop.lambda.core.enums.SourceLevelEnum;
import com.yatop.lambda.core.enums.SpecTypeEnum;
import com.yatop.lambda.core.mgr.workflow.node.NodeParameterMgr;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.context.WorkflowContext;
import com.yatop.lambda.workflow.core.richmodel.workflow.CharValue;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.Node;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.NodeParameter;
import com.yatop.lambda.workflow.engine.editor.node.value.CharValueUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParameterUpdate {

    @Autowired
    private NodeParameterMgr nodeParameterMgr;

    @Autowired
    private CharValueUpdate charValueUpdate;

    @Autowired
    private ParameterCreate parameterCreate;

    private NodeParameter updateParameter(WorkflowContext workflowContext, Node node, NodeParameter targetParmeter, String charValueText, Class<ParameterUpdate> none) {

        if(targetParmeter.getCmptChar().getSrcLevel() == SourceLevelEnum.WORKFLOW.getSource()) {
            if(!targetParmeter.isSimulateParameter()) {
                CharValue charValue = targetParmeter.getValue();
                charValue.setInText(charValueText);
                charValueUpdate.updateCharValue(workflowContext, node, charValue);

                WfFlowNodeParameter parameter = new WfFlowNodeParameter();
                parameter.setNodeId(node.getNodeId());
                parameter.setCharId(targetParmeter.getCmptChar().getCharId());
                if (DataUtil.isNotNull(charValue.getCharValue()))
                    parameter.setCharValue(charValue.getCharValue());
                else
                    parameter.setCharValue(null);

                nodeParameterMgr.updateNodeParameter(parameter, workflowContext.getOperId());
                targetParmeter.copyProperties(nodeParameterMgr.queryNodeParameter(parameter.getNodeId(), parameter.getCharId()));
                return targetParmeter;
            } else {
                return parameterCreate.createParameter(workflowContext, node, targetParmeter.getCmptChar(), charValueText);
            }
        } else {
            //TODO throw exception ???
            return null;
        }
    }

    public void updateParameter(WorkflowContext workflowContext, Node node, NodeParameter targetParmeter, String charValueText) {

        switch (SpecTypeEnum.valueOf(targetParmeter.getSpecType())) {
            case PARAMETER: {
                NodeParameter parameter = updateParameter(workflowContext, node, targetParmeter, charValueText, ParameterUpdate.class);
                node.putParameter(parameter);
                break;
            }
            case OPTIMIZE_EXECUTION: {
                NodeParameter parameter = updateParameter(workflowContext, node, targetParmeter, charValueText, ParameterUpdate.class);
                node.putOptimizeParameter(parameter);
                break;
            }
            default:
                //TODO throw exception ???
        }
    }
}
