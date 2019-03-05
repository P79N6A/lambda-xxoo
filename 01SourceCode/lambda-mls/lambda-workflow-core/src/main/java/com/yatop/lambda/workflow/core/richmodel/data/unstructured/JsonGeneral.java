package com.yatop.lambda.workflow.core.richmodel.data.unstructured;

import com.alibaba.fastjson.JSONObject;
import com.yatop.lambda.base.model.WfJsonObject;
import com.yatop.lambda.core.enums.JsonObjectStateEnum;
import com.yatop.lambda.workflow.core.serialize.TaskContentSerializer;
import com.yatop.lambda.workflow.core.richmodel.RichModel;

public class JsonGeneral extends RichModel<WfJsonObject> {

    public JsonGeneral(WfJsonObject data) {
        super(data);
    }

    @Override
    public JSONObject toJSON() {
        JSONObject jsonObject = super.toJSON();
        jsonObject.put(TaskContentSerializer.JSON_CLASS_NAME_KEY, JsonGeneral.class.getName());
        return jsonObject;
    }

    public boolean isStateEmpty() {
        return this.data().getObjectState() == JsonObjectStateEnum.EMPTY.getState();
    }

    public boolean isStateNormal() {
        return this.data().getObjectState() == JsonObjectStateEnum.NORMAL.getState();
    }
}