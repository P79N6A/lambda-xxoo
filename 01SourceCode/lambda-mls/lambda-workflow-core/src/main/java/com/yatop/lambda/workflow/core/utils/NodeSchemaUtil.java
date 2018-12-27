package com.yatop.lambda.workflow.core.utils;

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
public class NodeSchemaUtil {

    static private JsonObjectMgr JSON_OBJECT_MGR;

    @Autowired
    public void setNodeSchemaMgr(JsonObjectMgr josnObjectMgr) {
        NodeSchemaUtil.JSON_OBJECT_MGR = josnObjectMgr;
    }

    static public JsonObject queryJsonObject(Long objectId) {
        WfJsonObject jsonObject = NodeSchemaUtil.JSON_OBJECT_MGR.queryJsonObject(objectId);
        if(DataUtil.isNull(jsonObject)) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query data output port schema info failed -- json object data missing.", "节点数据输出端口schema信息丢失，请联系管理员");
        }
        return new JsonObject(jsonObject);
    }

    static public void updateJsonObject(JsonObject richJsonObject, String operId) {
        WfJsonObject jsonObject = new WfJsonObject();
        jsonObject.setObjectId(richJsonObject.getObjectId());
        jsonObject.setObjectData(richJsonObject.getObjectData());
        jsonObject.setObjectState(DataUtil.isNotEmpty(richJsonObject.getObjectData()) ? JsonObjectStateEnum.NORMAL.getState() : JsonObjectStateEnum.EMPTY.getState());
        NodeSchemaUtil.JSON_OBJECT_MGR.updateJsonObject(richJsonObject, operId);
        richJsonObject.copyProperties(JSON_OBJECT_MGR.queryJsonObject(richJsonObject.getObjectId()));
    }

    static public void deleteJsonObject(JsonObject richJsonObject, String operId) {
        NodeSchemaUtil.JSON_OBJECT_MGR.deleteJsonObject(richJsonObject, operId);
    }

    static public JsonObject recoverJsonObject(Long jsonObjectId, String operId) {
        NodeSchemaUtil.JSON_OBJECT_MGR.recoverJsonObject(jsonObjectId, operId);
        return queryJsonObject(jsonObjectId);
    }
}
