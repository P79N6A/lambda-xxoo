package com.yatop.lambda.workflow.engine.editor.node.parameter;

import com.yatop.lambda.base.model.WfFlowNodeParameter;
import com.yatop.lambda.core.enums.LambdaExceptionEnum;
import com.yatop.lambda.core.enums.SourceLevelEnum;
import com.yatop.lambda.core.enums.SpecTypeEnum;
import com.yatop.lambda.core.exception.LambdaException;
import com.yatop.lambda.core.mgr.workflow.node.NodeParameterMgr;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.context.WorkflowContext;
import com.yatop.lambda.workflow.core.richmodel.component.Component;
import com.yatop.lambda.workflow.core.richmodel.component.characteristic.CmptChar;
import com.yatop.lambda.workflow.core.richmodel.component.specification.CmptSpec;
import com.yatop.lambda.workflow.core.richmodel.workflow.CharValue;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.Node;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.NodeParameter;
import com.yatop.lambda.workflow.engine.editor.node.value.CharValueQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

@Service
public class ParameterQuery {

    @Autowired
    private NodeParameterMgr nodeParameterMgr;

    @Autowired
    private CharValueQuery charValueQuery;

/*    private NodeParameter queryParameter(WorkflowContext workflowContext, Node node, CmptChar cmptChar) {
        return queryParameter(workflowContext, node, cmptChar, null);
    }*/

    private NodeParameter queryParameter(WorkflowContext workflowContext, Node node, CmptChar cmptChar) {

        CharValue charValue = new CharValue(cmptChar, charValueText);
        if(cmptChar.getSrcLevel() == SourceLevelEnum.WORKFLOW.getSource()) {
            charValueCreate.queryCharValue(workflowContext, node, charValue);
        } else {
            return null;
        }

/*        WfFlowNodeParameter parameter = new WfFlowNodeParameter();
        parameter.setNodeId(node.getNodeId());
        parameter.setSpecType(charValue.getSpecType());
        parameter.setCharId(cmptChar.getCharId());
        if(DataUtil.isNotNull(charValue.getConfigCharValue()))
            parameter.setCharValue(charValue.getConfigCharValue());

        nodeParameterMgr.queryNodeParameterExt(parameter, workflowContext.getOperId());*/

        NodeParameter richParameter = new NodeParameter(parameter, cmptChar, charValue);
        richParameter.copyProperties(nodeParameterMgr.queryNodeParameter(richParameter.getNodeId(), richParameter.getCharId()));
        return richParameter;
    }

    public void queryParameters(WorkflowContext workflowContext, Node node) {
        List<WfFlowNodeParameter> nodeParameters = nodeParameterMgr.queryNodeParameter(node.getNodeId());

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

        Component component = node.getComponent();
        //组件参数
        CmptSpec paramSpec = component.getParameter();
        for (CmptChar cmptChar : paramSpec.getCmptChars()) {
            NodeParameter parameter = queryParameter(workflowContext, node, cmptChar);
            node.putParameter(parameter);
        }

        //执行调优参数
        CmptSpec optimizeSpec = component.getOptimizeExecution();
        for (CmptChar cmptChar : optimizeSpec.getCmptChars()) {
            NodeParameter parameter = queryParameter(workflowContext, node, cmptChar);
            node.putOptimizeParameter(parameter);
        }
    }
}
