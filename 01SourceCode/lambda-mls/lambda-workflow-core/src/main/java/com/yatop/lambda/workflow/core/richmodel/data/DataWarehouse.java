package com.yatop.lambda.workflow.core.richmodel.data;

import com.yatop.lambda.base.model.DwDataWarehouse;
import com.yatop.lambda.workflow.core.richmodel.IRichModel;

public class DataWarehouse extends DwDataWarehouse implements IRichModel {

    public DataWarehouse() {}

    public DataWarehouse(DwDataWarehouse data) {super.copyProperties(data);}

    @Override
    public void clear() {
        super.clear();
    }
}
