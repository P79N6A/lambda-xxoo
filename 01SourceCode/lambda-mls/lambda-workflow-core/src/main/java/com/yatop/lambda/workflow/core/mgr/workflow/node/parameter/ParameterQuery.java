package com.yatop.lambda.workflow.core.mgr.workflow.node.parameter;

import com.yatop.lambda.base.model.WfFlowNodeParameter;
import com.yatop.lambda.core.enums.SourceLevelEnum;
import com.yatop.lambda.core.enums.SpecTypeEnum;
import com.yatop.lambda.core.mgr.workflow.node.NodeParameterMgr;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.context.WorkflowContext;
import com.yatop.lambda.workflow.core.mgr.workflow.charvalue.ParamCharValueHelper;
import com.yatop.lambda.workflow.core.richmodel.workflow.component.Component;
import com.yatop.lambda.workflow.core.richmodel.workflow.component.characteristic.CmptChar;
import com.yatop.lambda.workflow.core.richmodel.workflow.component.specification.CmptSpec;
import com.yatop.lambda.workflow.core.richmodel.workflow.charvalue.CharValue;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.Node;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.NodeParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.TreeMap;

@Service
public class ParameterQuery {

    @Autowired
    private NodeParameterMgr nodeParameterMgr;

    private NodeParameter queryParameter(WorkflowContext workflowContext, Node node, CmptChar cmptChar, WfFlowNodeParameter parameter) {

        if(cmptChar.data().getSrcLevel() == SourceLevelEnum.WORKFLOW.getSource() && DataUtil.isNotNull(parameter)) {
            CharValue charValue = new CharValue(cmptChar, parameter.getCharValue());
            ParamCharValueHelper.queryParamCharValue(node, charValue);
            return new NodeParameter(parameter, charValue);
        } else {
            CharValue charValue = new CharValue(cmptChar);
            ParamCharValueHelper.queryParamCharValue(node, charValue);
            return ParameterHelper.simulateParameter(workflowContext, node, charValue);
        }
    }

    public void queryParameters(WorkflowContext workflowContext, Node node) {

        Component component = node.getComponent();
        if(!component.haveParameterContnent() && !component.haveOptimizeExecutionContent())
            return;

        List<WfFlowNodeParameter> nodeParameters = nodeParameterMgr.queryNodeParameter(node.data().getNodeId());
        TreeMap<String, WfFlowNodeParameter> parameterMap = new TreeMap<String, WfFlowNodeParameter>();
        TreeMap<String, WfFlowNodeParameter> optimizeMap = new TreeMap<String, WfFlowNodeParameter>();

        if(DataUtil.isNotEmpty(nodeParameters)) {
            for (WfFlowNodeParameter parameter : nodeParameters) {
                switch (SpecTypeEnum.valueOf(parameter.getSpecType())) {
                    case PARAMETER:
                        parameterMap.put(parameter.getCharId(), parameter);
                        break;
                    case OPTIMIZE_EXECUTION:
                        optimizeMap.put(parameter.getCharId(), parameter);
                        break;
                    default:
                        //TODO throw exception ???
                }
            }
        }

        if(component.haveParameterContnent()) {
            //组件参数
            CmptSpec paramSpec = component.getParameter();
            for (CmptChar cmptChar : paramSpec.getCmptChars()) {
                NodeParameter parameter = queryParameter(workflowContext, node, cmptChar, parameterMap.get(cmptChar.data().getCharId()));
                node.putParameter(parameter);
            }
        }

        if(component.haveOptimizeExecutionContent()) {
            //执行调优参数
            CmptSpec optimizeSpec = component.getOptimizeExecution();
            for (CmptChar cmptChar : optimizeSpec.getCmptChars()) {
                NodeParameter parameter = queryParameter(workflowContext, node, cmptChar, optimizeMap.get(cmptChar.data().getCharId()));
                node.putOptimizeParameter(parameter);
            }
        }
        parameterMap.clear();
        optimizeMap.clear();
    }
}
