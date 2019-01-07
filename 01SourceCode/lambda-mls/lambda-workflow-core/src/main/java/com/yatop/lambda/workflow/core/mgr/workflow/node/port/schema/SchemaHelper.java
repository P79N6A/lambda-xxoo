package com.yatop.lambda.workflow.core.mgr.workflow.node.port.schema;

import com.yatop.lambda.base.model.WfJsonObject;
import com.yatop.lambda.core.enums.LambdaExceptionEnum;
import com.yatop.lambda.core.exception.LambdaException;
import com.yatop.lambda.core.mgr.workflow.unstructured.JsonObjectMgr;
import com.yatop.lambda.core.mgr.workflow.node.NodeSchemaMgr;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.richmodel.data.unstructured.JsonObject;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.Node;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.NodeParameter;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.NodeSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class SchemaHelper {

    private static JsonObjectMgr JSON_OBJECT_MGR;

    private static NodeSchemaMgr NODE_SCHEMA_MGR;

    private static  SchemaAnalyze SCHEMA_ANALYZE;

    @Autowired
    public void setJsonObjectMgr(JsonObjectMgr josnObjectMgr) {
        SchemaHelper.JSON_OBJECT_MGR = josnObjectMgr;
    }

    @Autowired
    public void setNodeSchemaMgr(NodeSchemaMgr nodeSchemaMgr) {
        SchemaHelper.NODE_SCHEMA_MGR = nodeSchemaMgr;
    }

    @Autowired
    public void setSchemaAnalyze(SchemaAnalyze schemaAnalyze) {
        SchemaHelper.SCHEMA_ANALYZE = schemaAnalyze;
    }

    static public JsonObject queryFieldAttributes(Long objectId) {
        WfJsonObject jsonObject = JSON_OBJECT_MGR.queryJsonObject(objectId);
        if(DataUtil.isNull(jsonObject)) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query data output port schema info failed -- json object data missing.", "节点数据输出端口schema信息丢失，请联系管理员");
        }
        return new JsonObject(jsonObject);
    }

    static public void updateFieldAttributes(JsonObject jsonObject, String operId) {
        JSON_OBJECT_MGR.updateJsonObject(jsonObject.data(), operId);
        jsonObject.clearColoured();
    }

    static public void deleteFieldAttributes(Long jsonObjectId, String operId) {
        JSON_OBJECT_MGR.deleteJsonObject(jsonObjectId, true, operId);
    }

    static public void recoverFieldAttributes(Long jsonObjectId, String operId) {
        JSON_OBJECT_MGR.recoverJsonObject(jsonObjectId, operId);
    }

    static public void updateNodeSchema(NodeSchema schema, String operId) {
        NODE_SCHEMA_MGR.updateSchema(schema.data(), operId);
        schema.clearColoured();
    }

    static public boolean needAnalyzeSchema(Node node, NodeParameter parameter) {
        return SCHEMA_ANALYZE.needAnalyzeSchema(node, parameter);
    }

    static public boolean needAnalyzeSchema(Node node) {
        return SCHEMA_ANALYZE.needAnalyzeSchema(node);
    }
}
