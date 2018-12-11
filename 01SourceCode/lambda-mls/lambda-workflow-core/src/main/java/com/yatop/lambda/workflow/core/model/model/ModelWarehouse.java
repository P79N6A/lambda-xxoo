package com.yatop.lambda.workflow.core.model.model;

import com.alibaba.fastjson.JSONObject;
import com.yatop.lambda.base.model.MwModelWarehouse;
import com.yatop.lambda.workflow.core.model.IRichModel;

public class ModelWarehouse implements IRichModel {
    MwModelWarehouse warehouse;

    @Override
    public JSONObject toJSON() {
        return null;
    }

    @Override
    public void clear() {

    }
}
