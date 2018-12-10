package com.yatop.lambda.workflow.core.model.data;

import com.alibaba.fastjson.JSONObject;
import com.yatop.lambda.base.model.DwDataWarehouse;
import com.yatop.lambda.workflow.core.model.IRichModel;

public class DataWarehouse implements IRichModel {
    DwDataWarehouse warehouse;

    @Override
    public JSONObject toJson() {
        return null;
    }

    @Override
    public void parseJson(String jsonStr) {

    }
}
