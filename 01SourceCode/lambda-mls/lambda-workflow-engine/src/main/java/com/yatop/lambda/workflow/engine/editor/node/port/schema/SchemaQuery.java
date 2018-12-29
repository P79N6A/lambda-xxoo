package com.yatop.lambda.workflow.engine.editor.node.port.schema;

import com.yatop.lambda.base.model.WfFlowNodeSchema;
import com.yatop.lambda.core.mgr.workflow.node.NodeSchemaMgr;
import com.yatop.lambda.workflow.core.context.WorkflowContext;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.Node;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.NodePortOutput;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.NodeSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchemaQuery {

    @Autowired
    private NodeSchemaMgr nodeSchemaMgr;

    public void querySchema(WorkflowContext workflowContext, Node node) {

        int counter = 0;
        for(NodePortOutput port : node.getOutputNodePorts()) {
            if(port.isDataPort()) {
                NodeSchema schema = port.getSchema();
                schema.deleteFieldAttributes(workflowContext.getOperId());
                counter++;
            }
        }

        if(counter > 0) {
            List<WfFlowNodeSchema> schemaList = nodeSchemaMgr.querySchemaByNodeId(node.getNodeId());
            for(WfFlowNodeSchema schema : schemaList) {
                node.getOutputNodePort(schema.getNodePortId()).setSchema(new NodeSchema(schema));
            }
        }
    }
}
