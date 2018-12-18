package com.yatop.lambda.workflow.core.richmodel.workflow.node;

import com.alibaba.fastjson.JSONObject;
import com.yatop.lambda.base.model.WfFlowNodeSchema;
import com.yatop.lambda.workflow.core.richmodel.IRichModel;
import com.yatop.lambda.workflow.core.richmodel.workflow.JsonObject;

public class NodeSchema extends WfFlowNodeSchema implements IRichModel {

    private JsonObject jsonObject;

    public NodeSchema() {}

    public NodeSchema(WfFlowNodeSchema data) {super.copyProperties(data);}

    @Override
    public void clear() {
        jsonObject = null;
        super.clear();
    }

    public JsonObject getJsonObject() {
        return jsonObject;
    }

    public void setJsonObject(JsonObject jsonObject) {
        this.jsonObject = jsonObject;
    }
}
