package com.yatop.lambda.workflow.core.mgr.workflow.node.output;

import com.yatop.lambda.base.model.WfFlowNodeOutput;
import com.yatop.lambda.core.enums.LambdaExceptionEnum;
import com.yatop.lambda.core.exception.LambdaException;
import com.yatop.lambda.core.mgr.workflow.node.NodeOutputMgr;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.context.WorkflowContext;
import com.yatop.lambda.workflow.core.mgr.workflow.charvalue.OutputCharValueHelper;
import com.yatop.lambda.workflow.core.richmodel.workflow.component.Component;
import com.yatop.lambda.workflow.core.richmodel.workflow.component.characteristic.CmptChar;
import com.yatop.lambda.workflow.core.richmodel.workflow.component.specification.CmptSpec;
import com.yatop.lambda.workflow.core.richmodel.workflow.charvalue.CharValue;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.Node;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.NodeOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OutputAndResourceRecover {

    @Autowired
    private NodeOutputMgr nodeOutputMgr;

    private NodeOutput recoverOutputResource(WorkflowContext workflowContext, Node node, CmptChar cmptChar, WfFlowNodeOutput output) {

        CharValue charValue = new CharValue(cmptChar, output.getCharValue());
        OutputCharValueHelper.recoverOutputCharValue(workflowContext, node, charValue);
        return new NodeOutput(output, charValue);
    }

    public void recoverOutputAndResources(WorkflowContext workflowContext, Node node) {

        Component component = node.getComponent();
        if(component.haveOutputContent()) {

            nodeOutputMgr.recoverNodeOutput(node.data().getNodeId(), workflowContext.getOperId());
            List<WfFlowNodeOutput> nodeOutputs = nodeOutputMgr.queryNodeOutput(node.data().getNodeId());
            if (DataUtil.isEmpty(nodeOutputs)) {
                throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query node output failed -- output data missing.", "节点输出记录缺失", node.data());
            }

            if (nodeOutputs.size() != component.getOutput().cmptCharCount()) {
                throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query node output failed -- component-output vs node-output inconsistent.", "节点输出信息错误", node.data());
            }

            CmptSpec outputSpec = component.getOutput();
            for (WfFlowNodeOutput nodeOutput : nodeOutputs) {
                CmptChar outputChar = outputSpec.getCmptChar(nodeOutput.getCharId());
                if (DataUtil.isNull(outputChar)) {
                    throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query node output failed -- component output not found.", "节点输出信息错误", nodeOutput);
                }

                NodeOutput output = recoverOutputResource(workflowContext, node, outputChar, nodeOutput);
                node.putOutput(output);
            }
        }
    }
}
