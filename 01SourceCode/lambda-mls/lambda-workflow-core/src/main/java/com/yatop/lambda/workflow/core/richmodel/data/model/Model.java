package com.yatop.lambda.workflow.core.richmodel.data.model;

import com.alibaba.fastjson.JSONObject;
import com.yatop.lambda.base.model.MwModel;
import com.yatop.lambda.core.enums.ModelStateEnum;
import com.yatop.lambda.workflow.core.serialize.TaskContentSerializer;
import com.yatop.lambda.workflow.core.richmodel.RichModel;

public class Model extends RichModel<MwModel> {

    public Model(MwModel data) {
        super(data);
    }

    @Override
    public JSONObject toJSON() {
        JSONObject jsonObject = super.toJSON();
        jsonObject.put(TaskContentSerializer.JSON_CLASS_NAME_KEY, Model.class.getName());
        return jsonObject;
    }

    @Override
    public boolean isDataStateEmpty() {
        return data().getModelState() == ModelStateEnum.EMPTY.getState();
    }
}
