package com.yatop.lambda.workflow.core.mgr.workflow.node.output;

import com.yatop.lambda.base.model.WfFlowNodeOutput;
import com.yatop.lambda.core.enums.DataStatusEnum;
import com.yatop.lambda.core.enums.OutputStateEnum;
import com.yatop.lambda.core.mgr.workflow.node.NodeOutputMgr;
import com.yatop.lambda.workflow.core.context.WorkflowContext;
import com.yatop.lambda.workflow.core.richmodel.component.characteristic.CmptChar;
import com.yatop.lambda.workflow.core.richmodel.workflow.charvalue.CharValue;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.Node;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.NodeOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class OutputHelper {

    private static NodeOutputMgr NODE_OUTPUT_MGR;

    @Autowired
    public void setNodeParameterMgr(NodeOutputMgr nodeOutputMgr) {
        NODE_OUTPUT_MGR = nodeOutputMgr;
    }

    public static NodeOutput simulateOutput(WorkflowContext workflowContext, Node node, CharValue charValue) {

        CmptChar cmptChar = charValue.getCmptChar();

        //模拟生成非workflow来源级别的节点参数，和workflow来源级别缺失的节点参数
        Date curTime = new Date();
        WfFlowNodeOutput output = new WfFlowNodeOutput();
        output.setNodeId(node.data().getNodeId());
        output.setCharId(cmptChar.data().getCharId());
        output.setCharValue(charValue.getCharValue());
        if(charValue.getObjectValue().isDataStateEmpty())
            output.setOutputState(OutputStateEnum.EMPTY.getState());
        else
            output.setOutputState(OutputStateEnum.NORMAL.getState());
        output.setStatus(DataStatusEnum.NORMAL.getStatus());
        output.setDescription("Simulate Output");
        output.setLastUpdateTime(curTime);
        output.setLastUpdateOper(workflowContext.getOperId());
        output.setCreateTime(curTime);
        output.setCreateOper(workflowContext.getOperId());
        return new NodeOutput(output, charValue, true);
    }


}
