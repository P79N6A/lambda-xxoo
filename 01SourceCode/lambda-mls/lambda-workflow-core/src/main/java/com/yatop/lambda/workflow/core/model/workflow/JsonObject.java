package com.yatop.lambda.workflow.core.model.workflow;

import com.alibaba.fastjson.JSONObject;
import com.yatop.lambda.base.model.WfJsonObject;
import com.yatop.lambda.workflow.core.model.IRichModel;

public class JsonObject implements IRichModel {
    WfJsonObject object;

    @Override
    public JSONObject toJSON() {
        return null;
    }

    @Override
    public void clear() {

    }
}
