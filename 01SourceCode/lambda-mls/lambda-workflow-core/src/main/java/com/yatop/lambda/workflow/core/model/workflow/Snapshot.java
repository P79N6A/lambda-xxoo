package com.yatop.lambda.workflow.core.model.workflow;

import com.alibaba.fastjson.JSONObject;
import com.yatop.lambda.base.model.WfSnapshot;
import com.yatop.lambda.workflow.core.model.IRichModel;

public class Snapshot implements IRichModel {
    WfSnapshot snapshot;

    @Override
    public JSONObject toJson() {
        return null;
    }

    @Override
    public void parseJson(String jsonStr) {

    }
}
