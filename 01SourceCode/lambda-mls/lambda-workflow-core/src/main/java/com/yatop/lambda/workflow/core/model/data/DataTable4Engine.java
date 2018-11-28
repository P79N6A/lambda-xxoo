package com.yatop.lambda.workflow.core.model.data;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yatop.lambda.base.model.DwDataTable;
import com.yatop.lambda.base.model.DwDataWarehouse;
import com.yatop.lambda.workflow.core.model.IRichModel;

public class DataTable4Engine implements IRichModel {
    private DwDataTable dataTable;
    private DwDataWarehouse dataWarehouse;

    public DataTable4Engine(Long tableID) {

    }

    public JSONObject toJson4Engine() {
        return (JSONObject)JSON.toJSON(dataTable);
    }
}
