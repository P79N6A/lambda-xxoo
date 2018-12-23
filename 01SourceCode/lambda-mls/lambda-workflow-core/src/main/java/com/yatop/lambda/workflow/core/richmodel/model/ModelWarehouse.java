package com.yatop.lambda.workflow.core.richmodel.model;

import com.yatop.lambda.base.model.MwModelWarehouse;
import com.yatop.lambda.workflow.core.richmodel.IRichModel;

public class ModelWarehouse extends MwModelWarehouse implements IRichModel {

    public ModelWarehouse(MwModelWarehouse data) {super.copyProperties(data);}

    @Override
    public void clear() {
        super.clear();
    }
}
