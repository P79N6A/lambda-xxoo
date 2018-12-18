package com.yatop.lambda.workflow.core.richmodel.data;

import com.yatop.lambda.base.model.DwDataTable;
import com.yatop.lambda.workflow.core.richmodel.IRichModel;

public class DataTable extends DwDataTable implements IRichModel {

    public DataTable() {}

    public DataTable(DwDataTable data) {super.copyProperties(data);}

    @Override
    public void clear() {
        super.clear();
    }
}
