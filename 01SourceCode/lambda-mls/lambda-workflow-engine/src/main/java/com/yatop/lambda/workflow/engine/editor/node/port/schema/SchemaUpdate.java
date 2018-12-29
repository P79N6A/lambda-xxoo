package com.yatop.lambda.workflow.engine.editor.node.port.schema;

import com.yatop.lambda.core.mgr.workflow.node.NodeSchemaMgr;
import com.yatop.lambda.workflow.core.context.WorkflowContext;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.NodeSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SchemaUpdate {

    @Autowired
    NodeSchemaMgr nodeSchemaMgr;

    public void updateSchema(WorkflowContext workflowContext, NodeSchema schema) {

        schema.flushFieldAttributes(workflowContext.getOperId());
        nodeSchemaMgr.updateSchema(schema, workflowContext.getOperId());
        schema.copyProperties(nodeSchemaMgr.querySchema(schema.getNodePortId()));
    }
}
