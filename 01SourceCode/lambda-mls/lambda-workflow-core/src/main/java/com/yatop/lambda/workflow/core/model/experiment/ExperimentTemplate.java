package com.yatop.lambda.workflow.core.model.experiment;

import com.alibaba.fastjson.JSONObject;
import com.yatop.lambda.base.model.EmExperiment;
import com.yatop.lambda.base.model.EmExperimentTemplate;
import com.yatop.lambda.workflow.core.model.IRichModel;

public class ExperimentTemplate implements IRichModel {
    EmExperimentTemplate template;

    @Override
    public JSONObject toJson() {
        return null;
    }

    @Override
    public void parseJson(String jsonStr) {

    }
}