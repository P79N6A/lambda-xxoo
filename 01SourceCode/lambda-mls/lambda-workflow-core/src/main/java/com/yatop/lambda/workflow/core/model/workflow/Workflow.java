package com.yatop.lambda.workflow.core.model.workflow;

import com.alibaba.fastjson.JSONObject;
import com.yatop.lambda.base.model.WfFlow;
import com.yatop.lambda.workflow.core.model.IRichModel;

public class Workflow implements IRichModel {
    WfFlow workflow;

    @Override
    public JSONObject toJson() {
        return null;
    }

    @Override
    public void parseJson(String jsonStr) {

    }
}
