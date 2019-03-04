package com.yatop.lambda.workflow.core.mgr.workflow.node.output;

import com.yatop.lambda.core.mgr.workflow.node.NodeOutputMgr;
import com.yatop.lambda.workflow.core.context.WorkflowContext;
import com.yatop.lambda.workflow.core.mgr.workflow.charvalue.OutputCharValueHelper;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.Node;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.NodeOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OutputResourceClear {

    @Autowired
    private NodeOutputMgr nodeOutputMgr;

    private void clearOutputResource(WorkflowContext workflowContext, Node node, NodeOutput output) {

        OutputCharValueHelper.clearOutputCharValue(workflowContext, node, output.getCharValue());
        output.changeState2Empty();
    }

    public void clearOutputResource(WorkflowContext workflowContext, Node node) {

        if(node.outputCount() > 0) {
            for (NodeOutput output : node.getOutputs()) {
                if(!output.isSimulateOutput()) {
                    clearOutputResource(workflowContext, node, output);
                }
            }
        }
    }
}
