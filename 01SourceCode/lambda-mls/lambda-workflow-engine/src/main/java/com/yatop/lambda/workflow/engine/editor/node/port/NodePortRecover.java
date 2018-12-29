package com.yatop.lambda.workflow.engine.editor.node.port;

import com.yatop.lambda.core.mgr.workflow.node.NodePortMgr;
import com.yatop.lambda.workflow.core.context.WorkflowContext;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.Node;
import com.yatop.lambda.workflow.engine.editor.node.port.schema.SchemaDelete;
import com.yatop.lambda.workflow.engine.editor.node.port.schema.SchemaRecover;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NodePortRecover {

    @Autowired
    private NodePortMgr nodePortMgr;

    @Autowired
    private SchemaRecover schemaRecover;

    public void recoverNodePort(WorkflowContext workflowContext, Node node) {

        schemaRecover.recoverSchemas(workflowContext, node);
        nodePortMgr.deleteNodePort(node, workflowContext.getOperId());
    }
}
