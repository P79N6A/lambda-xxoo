package com.yatop.lambda.workflow.core.mgr.workflow.node.port;

import com.yatop.lambda.core.mgr.workflow.node.NodePortMgr;
import com.yatop.lambda.workflow.core.context.WorkflowContext;
import com.yatop.lambda.workflow.core.mgr.workflow.node.schema.NodeSchemaHelper;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.Node;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NodePortDelete {

    @Autowired
    private NodePortMgr nodePortMgr;

    public void deleteNodePorts(WorkflowContext workflowContext, Node node) {

        if(node.getModule().inputPortCount() > 0 || node.getModule().outputPortCount() > 0) {
            NodeSchemaHelper.deleteSchemas(workflowContext, node);
            nodePortMgr.deleteNodePort(node.data().getNodeId(), workflowContext.getOperId());
        }
    }
}
