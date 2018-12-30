package com.yatop.lambda.workflow.core.mgr.editor.node.port.schema;

import com.yatop.lambda.base.model.WfJsonObject;
import com.yatop.lambda.core.enums.JsonObjectStateEnum;
import com.yatop.lambda.core.enums.LambdaExceptionEnum;
import com.yatop.lambda.core.exception.LambdaException;
import com.yatop.lambda.core.mgr.workflow.JsonObjectMgr;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.richmodel.workflow.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class SchemaHelper {

    private static JsonObjectMgr JSON_OBJECT_MGR;

    @Autowired
    public void setNodeSchemaMgr(JsonObjectMgr josnObjectMgr) {
        JSON_OBJECT_MGR = josnObjectMgr;
    }

    static public JsonObject queryFieldAttributes(Long objectId) {
        WfJsonObject jsonObject = JSON_OBJECT_MGR.queryJsonObject(objectId);
        if(DataUtil.isNull(jsonObject)) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query data output port schema info failed -- json object data missing.", "节点数据输出端口schema信息丢失，请联系管理员");
        }
        return new JsonObject(jsonObject);
    }

    static public void updateFieldAttributes(JsonObject richJsonObject, String operId) {
        WfJsonObject jsonObject = new WfJsonObject();
        jsonObject.setObjectId(richJsonObject.getObjectId());
        jsonObject.setObjectData(richJsonObject.getObjectData());
        jsonObject.setObjectState(DataUtil.isNotEmpty(richJsonObject.getObjectData()) ? JsonObjectStateEnum.NORMAL.getState() : JsonObjectStateEnum.EMPTY.getState());
        JSON_OBJECT_MGR.updateJsonObject(richJsonObject, operId);
        richJsonObject.copyProperties(JSON_OBJECT_MGR.queryJsonObject(richJsonObject.getObjectId()));
    }

    static public void deleteFieldAttributes(JsonObject richJsonObject, String operId) {
        JSON_OBJECT_MGR.deleteJsonObject(richJsonObject.getObjectId(), true, operId);
    }

    static public JsonObject recoverFieldAttributes(Long jsonObjectId, String operId) {
        JSON_OBJECT_MGR.recoverJsonObject(jsonObjectId, operId);
        return queryFieldAttributes(jsonObjectId);
    }
}
