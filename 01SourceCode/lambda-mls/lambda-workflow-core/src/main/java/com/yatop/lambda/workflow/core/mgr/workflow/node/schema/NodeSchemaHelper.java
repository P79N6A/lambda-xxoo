package com.yatop.lambda.workflow.core.mgr.workflow.node.schema;

import com.yatop.lambda.base.model.WfFlowNodeSchema;
import com.yatop.lambda.core.enums.LambdaExceptionEnum;
import com.yatop.lambda.core.enums.SchemaStateEnum;
import com.yatop.lambda.core.exception.LambdaException;
import com.yatop.lambda.core.mgr.workflow.node.NodeSchemaMgr;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.context.WorkflowContext;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.Node;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.NodeOutputPort;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.NodeSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NodeSchemaHelper {

    private static NodeSchemaMgr NODE_SCHEMA_MGR;

    @Autowired
    public void setNodeSchemaMgr(NodeSchemaMgr nodeSchemaMgr) {
        NodeSchemaHelper.NODE_SCHEMA_MGR = nodeSchemaMgr;
    }

    public static void createSchema(WorkflowContext workflowContext, Node node, NodeOutputPort outputPort) {

        WfFlowNodeSchema schema = new WfFlowNodeSchema();
        schema.setNodePortId(outputPort.data().getNodePortId());
        schema.setSchemaName(outputPort.data().getNodePortName());
        schema.setOwnerNodeId(node.data().getNodeId());
        schema.setSchemaState(node.isSupportAnalyze() ? SchemaStateEnum.EMPTY.getState() : SchemaStateEnum.NOT_SUPPORT.getState());
        schema = NODE_SCHEMA_MGR.insertSchema(schema, workflowContext.getOperId());
        //schema.copyProperties(nodeSchemaMgr.querySchema(schema.data().getNodePortId()));
        NodeSchema richSchema = new NodeSchema(schema, outputPort.getCmptChar());
        outputPort.setSchema(richSchema);
    }

    public static void deleteSchemas(WorkflowContext workflowContext, Node node) {

        if(!node.isTailNode() && node.haveOutputDataTablePort()) {
            NODE_SCHEMA_MGR.deleteSchema(node.data().getNodeId(), workflowContext.getOperId());
        }
    }

    public static void querySchemas(Node node) {

        if(!node.isTailNode() && node.haveOutputDataTablePort()) {
            List<WfFlowNodeSchema> schemaList = NODE_SCHEMA_MGR.querySchemaByNodeId(node.data().getNodeId());

            if (DataUtil.isEmpty(schemaList)) {
                throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query node schema failed -- schema list size inconsistent.", "节点数据输出端口schema缺失", node.data());
            }

            for (WfFlowNodeSchema schema : schemaList) {
                NodeOutputPort outputNodePort = node.getOutputNodePort(schema.getNodePortId());

                if (DataUtil.isNull(outputNodePort)) {
                    throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query node schema failed -- output node port not found.", "节点数据输出端口信息缺失", schema);
                }

                outputNodePort.setSchema(new NodeSchema(schema, outputNodePort.getCmptChar()));
            }
        }
    }

    public static NodeSchema querySchema(NodeOutputPort outputNodePort) {

        if(outputNodePort.isDataTablePort()) {
            WfFlowNodeSchema schema = NODE_SCHEMA_MGR.querySchema(outputNodePort.data().getNodePortId());
            return new NodeSchema(schema, outputNodePort.getCmptChar());
        } else {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query node schema failed -- non data port.", "非节点数据端口", outputNodePort.data());
        }
    }

    public static void recoverSchemas(WorkflowContext workflowContext, Node node) {

        if(!node.isTailNode() && node.haveOutputDataTablePort()) {

            NODE_SCHEMA_MGR.recoverSchema(node.data().getNodeId(), workflowContext.getOperId());
            List<WfFlowNodeSchema> schemaList = NODE_SCHEMA_MGR.querySchemaByNodeId(node.data().getNodeId());

            if (DataUtil.isEmpty(schemaList)) {
                throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Recover node schema failed -- schema list size inconsistent.", "节点数据输出端口schema缺失", node.data());
            }
            for (WfFlowNodeSchema schema : schemaList) {
                NodeOutputPort outputNodePort = node.getOutputNodePort(schema.getNodePortId());

                if (DataUtil.isNull(outputNodePort)) {
                    throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Recover node schema failed -- output node port not found.", "节点数据输出端口信息缺失", schema);
                }
                outputNodePort.setSchema(new NodeSchema(schema, outputNodePort.getCmptChar()));

                if(node.isSupportAnalyze()) {
                    outputNodePort.getSchema().changeState2Empty();
                } else {
                    outputNodePort.getSchema().changeState2NotSupport();
                }
            }
        }
    }

    public static void updateNodeSchema(NodeSchema schema, String operId) {
        NODE_SCHEMA_MGR.updateSchema(schema.data(), operId);
        schema.clearColoured();
    }
}
