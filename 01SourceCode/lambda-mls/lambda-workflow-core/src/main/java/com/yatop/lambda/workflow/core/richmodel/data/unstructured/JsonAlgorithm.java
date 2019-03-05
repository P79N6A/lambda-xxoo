package com.yatop.lambda.workflow.core.richmodel.data.unstructured;

import com.alibaba.fastjson.JSONObject;
import com.yatop.lambda.base.model.WfJsonObject;
import com.yatop.lambda.core.enums.JsonObjectStateEnum;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.richmodel.RichModel;
import com.yatop.lambda.workflow.core.serialize.TaskContentSerializer;

public class JsonAlgorithm extends RichModel<WfJsonObject> {

    public JsonAlgorithm(WfJsonObject data) {
        super(data);
    }

    @Override
    public JSONObject toJSON() {
        JSONObject jsonObject = super.toJSON();
        jsonObject.put(TaskContentSerializer.JSON_CLASS_NAME_KEY, JsonAlgorithm.class.getName());
        return jsonObject;
    }

    public void setObjectContent(JSONObject jsonObject) {

        if(DataUtil.isNotEmpty(jsonObject)) {
            String jsonString = jsonObject.toJSONString();
            if(this.isStateEmpty() || !DataUtil.equals(jsonString, this.data().getObjectContent())) {
                this.data().setObjectContent(jsonString);
                this.data().setObjectState(JsonObjectStateEnum.NORMAL.getState());
            }
        } else {
            if(this.isStateNormal()) {
                this.data().setObjectContent(null);
                this.data().setObjectState(JsonObjectStateEnum.EMPTY.getState());
            }
        }
    }

    public boolean isStateEmpty() {
        return this.data().getObjectState() == JsonObjectStateEnum.EMPTY.getState();
    }

    public boolean isStateNormal() {
        return this.data().getObjectState() == JsonObjectStateEnum.NORMAL.getState();
    }
}