package com.yatop.lambda.workflow.core.mgr.workflow.node.port.schema;

import com.yatop.lambda.base.model.WfFlowNodeSchema;
import com.yatop.lambda.base.model.WfJsonObject;
import com.yatop.lambda.core.enums.*;
import com.yatop.lambda.core.mgr.workflow.unstructured.JsonObjectMgr;
import com.yatop.lambda.core.mgr.workflow.node.NodeSchemaMgr;
import com.yatop.lambda.workflow.core.context.WorkflowContext;
import com.yatop.lambda.workflow.core.richmodel.data.unstructured.JsonObject;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.Node;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.NodeOutputPort;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.NodeSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SchemaCreate {

    @Autowired
    NodeSchemaMgr nodeSchemaMgr;

    public void createSchema(WorkflowContext workflowContext, Node node, NodeOutputPort outputPort) {

        WfFlowNodeSchema schema = new WfFlowNodeSchema();
        schema.setNodePortId(outputPort.data().getNodePortId());
        schema.setSchemaName(outputPort.data().getNodePortName());
        schema.setOwnerNodeId(node.data().getNodeId());
        schema.setSchemaState(node.isSupportAnalyze() ? SchemaStateEnum.EMPTY.getState() : SchemaStateEnum.NOT_SUPPORT.getState());
        schema = nodeSchemaMgr.insertSchema(schema, workflowContext.getOperId());
        //schema.copyProperties(nodeSchemaMgr.querySchema(schema.data().getNodePortId()));
        NodeSchema richSchema = new NodeSchema(schema, outputPort.getCmptChar());
        outputPort.setSchema(richSchema);
    }
}
