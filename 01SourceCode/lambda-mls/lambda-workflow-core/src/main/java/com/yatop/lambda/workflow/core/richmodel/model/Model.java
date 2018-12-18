package com.yatop.lambda.workflow.core.richmodel.model;

import com.yatop.lambda.base.model.MwModel;
import com.yatop.lambda.workflow.core.richmodel.IRichModel;

public class Model extends MwModel implements IRichModel {

    public Model() {}

    public Model(MwModel data) {super.copyProperties(data);}

    @Override
    public void clear() {
        super.clear();
    }
}
