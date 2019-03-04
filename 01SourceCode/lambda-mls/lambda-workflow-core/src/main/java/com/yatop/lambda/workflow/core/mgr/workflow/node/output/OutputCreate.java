package com.yatop.lambda.workflow.core.mgr.workflow.node.output;

import com.yatop.lambda.base.model.WfFlowNodeOutput;
import com.yatop.lambda.core.enums.OutputStateEnum;
import com.yatop.lambda.core.mgr.workflow.node.NodeOutputMgr;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.context.WorkflowContext;
import com.yatop.lambda.workflow.core.richmodel.component.Component;
import com.yatop.lambda.workflow.core.richmodel.component.characteristic.CmptChar;
import com.yatop.lambda.workflow.core.richmodel.component.specification.CmptSpec;
import com.yatop.lambda.workflow.core.richmodel.workflow.charvalue.CharValue;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.Node;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.NodeOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OutputCreate {

    @Autowired
    private NodeOutputMgr nodeOutputMgr;

    private NodeOutput createOutput(WorkflowContext workflowContext, Node node, CmptChar cmptChar) {

        WfFlowNodeOutput output = new WfFlowNodeOutput();
        output.setNodeId(node.data().getNodeId());
        output.setCharId(cmptChar.data().getCharId());
        nodeOutputMgr.insertNodeOutput(output, workflowContext.getOperId());

        return new NodeOutput(output, new CharValue(cmptChar));
    }

    public void createOutputs(WorkflowContext workflowContext, Node node) {

        Component component = node.getComponent();
        //组件输出
        CmptSpec outputSpec = component.getOutput();
        if(DataUtil.isNotNull(outputSpec) && outputSpec.cmptCharCount() > 0) {
            for (CmptChar cmptChar : outputSpec.getCmptChars()) {
                NodeOutput output = createOutput(workflowContext, node, cmptChar);
                node.putOutput(output);
            }

            node.getModuleClazzBean().prepareOutputResource(workflowContext, node);
        }
    }
}
