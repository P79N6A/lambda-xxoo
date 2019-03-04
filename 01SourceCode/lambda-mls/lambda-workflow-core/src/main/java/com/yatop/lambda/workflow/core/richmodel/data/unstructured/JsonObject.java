package com.yatop.lambda.workflow.core.richmodel.data.unstructured;

import com.alibaba.fastjson.JSONObject;
import com.yatop.lambda.base.model.WfJsonObject;
import com.yatop.lambda.core.enums.JsonObjectStateEnum;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.serialize.TaskContentSerializer;
import com.yatop.lambda.workflow.core.richmodel.RichModel;

public class JsonObject extends RichModel<WfJsonObject> {

    public JsonObject(WfJsonObject data) {
        super(data);
    }

    @Override
    public JSONObject toJSON() {
        JSONObject jsonObject = super.toJSON();
        jsonObject.put(TaskContentSerializer.JSON_CLASS_NAME_KEY, JsonObject.class.getName());
        return jsonObject;
    }

    public void setObjectContent(JSONObject jsonObject) {

        if(DataUtil.isNotEmpty(jsonObject)) {
            String jsonObjectContent = jsonObject.toJSONString();
            this.data().setObjectContent(jsonObjectContent);
            this.data().setObjectState(JsonObjectStateEnum.NORMAL.getState());
        } else {
            this.data().setObjectContent(null);
            this.data().setObjectState(JsonObjectStateEnum.EMPTY.getState());
        }
    }

    @Override
    public boolean isDataStateEmpty() {
        return data().getObjectState() == JsonObjectStateEnum.EMPTY.getState();
    }
}