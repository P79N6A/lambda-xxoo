package com.yatop.lambda.workflow.core.model.experiment;

import com.alibaba.fastjson.JSONObject;
import com.yatop.lambda.base.model.EmExperiment;
import com.yatop.lambda.workflow.core.model.IRichModel;

public class Experiment implements IRichModel {
    EmExperiment experiment;

    @Override
    public JSONObject toJSON() {
        return null;
    }

    @Override
    public void clear() {

    }
}
