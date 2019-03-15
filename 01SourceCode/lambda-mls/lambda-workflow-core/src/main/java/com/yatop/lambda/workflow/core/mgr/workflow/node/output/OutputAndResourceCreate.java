package com.yatop.lambda.workflow.core.mgr.workflow.node.output;

import com.yatop.lambda.base.model.WfFlowNodeOutput;
import com.yatop.lambda.core.mgr.workflow.node.NodeOutputMgr;
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

@Service
public class OutputAndResourceCreate {

    @Autowired
    private NodeOutputMgr nodeOutputMgr;

    private NodeOutput createOutputAndResource(WorkflowContext workflowContext, Node node, CmptChar cmptChar) {

        CharValue charValue = new CharValue(cmptChar);
        OutputCharValueHelper.prepareOutputCharValue(workflowContext, node, charValue);

        WfFlowNodeOutput output = new WfFlowNodeOutput();
        output.setNodeId(node.data().getNodeId());
        output.setCharId(cmptChar.data().getCharId());
        output.setCharValue(charValue.getCharValue());
        output = nodeOutputMgr.insertNodeOutput(output, workflowContext.getOperId());

        return new NodeOutput(output, charValue);
    }

    public void createOutputAndResources(WorkflowContext workflowContext, Node node) {

        Component component = node.getComponent();
        if(component.haveOutputContent()) {
            //组件输出
            CmptSpec outputSpec = component.getOutput();
            for (CmptChar cmptChar : outputSpec.getCmptChars()) {
                NodeOutput output = createOutputAndResource(workflowContext, node, cmptChar);
                node.putOutput(output);
            }
        }
    }
}
