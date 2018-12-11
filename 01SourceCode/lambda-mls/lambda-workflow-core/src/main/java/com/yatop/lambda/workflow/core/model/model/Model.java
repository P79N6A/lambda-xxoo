package com.yatop.lambda.workflow.core.model.model;

import com.alibaba.fastjson.JSONObject;
import com.yatop.lambda.base.model.MwModel;
import com.yatop.lambda.workflow.core.model.IRichModel;

public class Model implements IRichModel {
    MwModel model;

    @Override
    public JSONObject toJSON() {
        return null;
    }

    @Override
    public void clear() {

    }
}
