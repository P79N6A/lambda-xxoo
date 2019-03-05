package com.yatop.lambda.workflow.core.mgr.workflow.node.output;

import com.yatop.lambda.core.mgr.workflow.node.NodeOutputMgr;
import com.yatop.lambda.workflow.core.context.WorkflowContext;
import com.yatop.lambda.workflow.core.mgr.workflow.charvalue.OutputCharValueHelper;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.Node;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.NodeOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OutputAndResourceDelete {

    @Autowired
    private NodeOutputMgr nodeOutputMgr;

    private void deleteOutputResource(WorkflowContext workflowContext, Node node, NodeOutput output) {

        OutputCharValueHelper.deleteOutputCharValue(workflowContext, node, output.getCharValue());
    }

    public void deleteOutputAndResources(WorkflowContext workflowContext, Node node) {

        if(node.outputCount() > 0) {
            int deleteCount = 0;
            for (NodeOutput output : node.getOutputs()) {
                if(!output.isSimulateOutput()) {
                    deleteOutputResource(workflowContext, node, output);
                    deleteCount++;
                }
            }

            if(deleteCount > 0) {
                nodeOutputMgr.deleteNodeOutput(node.data().getNodeId(), workflowContext.getOperId());
            }
        }
    }
}
