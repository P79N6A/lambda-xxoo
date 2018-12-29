package com.yatop.lambda.workflow.engine.editor.node.port.schema;

import com.yatop.lambda.base.model.WfFlowNodeSchema;
import com.yatop.lambda.core.enums.LambdaExceptionEnum;
import com.yatop.lambda.core.exception.LambdaException;
import com.yatop.lambda.core.mgr.workflow.node.NodeSchemaMgr;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.context.WorkflowContext;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.Node;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.NodePortOutput;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.NodeSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchemaRecover {

    @Autowired
    private NodeSchemaMgr nodeSchemaMgr;

    public void recoverSchemas(WorkflowContext workflowContext, Node node) {

        int counter = 0;
        for(NodePortOutput port : node.getOutputNodePorts()) {
            if(port.isDataPort()) {
                counter++;
            }
        }

        if(counter > 0) {
            nodeSchemaMgr.recoverSchema(node, workflowContext.getOperId());
            List<WfFlowNodeSchema> schemas = nodeSchemaMgr.querySchemaByNodeId(node.getNodeId());

            for(WfFlowNodeSchema schema : schemas) {
                NodeSchema richSchema = new NodeSchema(schema);
                NodePortOutput outputNodePort = node.getOutputNodePort(schema.getNodePortId());

                if(DataUtil.isNull(outputNodePort)) {
                    throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Recover data node output port schema error -- output node port not found.", "节点数据输出端口信息缺失，请联系管理员");
                }

                outputNodePort.setSchema(richSchema);
                richSchema.recoverFieldAttributes(workflowContext.getOperId());
            }
        }
    }
}
