package com.yatop.lambda.workflow.core.richmodel.data.table;

import com.alibaba.fastjson.JSONObject;
import com.yatop.lambda.base.model.DwDataTable;
import com.yatop.lambda.workflow.core.codec.TaskContentCodec;
import com.yatop.lambda.workflow.core.richmodel.RichModel;

public class DataTable extends RichModel<DwDataTable> {

    public DataTable(DwDataTable data) {
        super(data);
        this.clearColoured();
    }

    @Override
    public JSONObject toJSON() {
        JSONObject jsonObject = super.toJSON();
        jsonObject.put(TaskContentCodec.JSON_CLASS_NAME_KEY, DataTable.class.getName());
        return jsonObject;
    }
}
