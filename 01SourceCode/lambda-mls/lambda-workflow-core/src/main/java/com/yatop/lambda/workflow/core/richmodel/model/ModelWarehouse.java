package com.yatop.lambda.workflow.core.richmodel.model;

import com.yatop.lambda.base.model.MwModelWarehouse;
import com.yatop.lambda.workflow.core.richmodel.IRichModel;
import com.yatop.lambda.workflow.core.richmodel.project.Project;

public class ModelWarehouse extends MwModelWarehouse implements IRichModel {

    public ModelWarehouse() {}

    public ModelWarehouse(MwModelWarehouse data) {super.copyProperties(data);}

    @Override
    public void clear() {
        super.clear();
    }
}
