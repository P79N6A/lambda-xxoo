package com.yatop.lambda.workflow.core.model.workflow;

import com.alibaba.fastjson.JSONObject;
import com.yatop.lambda.base.model.WfFlowGlobalParameter;
import com.yatop.lambda.workflow.core.model.IRichModel;

public class GlobalParameter implements IRichModel {
    WfFlowGlobalParameter parameter;

    @Override
    public JSONObject toJson() {
        return null;
    }

    @Override
    public void parseJson(String jsonStr) {

    }
}
