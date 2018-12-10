package com.yatop.lambda.workflow.core.model.data;

import com.alibaba.fastjson.JSONObject;
import com.yatop.lambda.base.model.DwDataTable;
import com.yatop.lambda.workflow.core.model.IRichModel;

public class DataTable implements IRichModel {
    DwDataTable table;

    @Override
    public JSONObject toJson() {
        return null;
    }

    @Override
    public void parseJson(String jsonStr) {

    }
}
