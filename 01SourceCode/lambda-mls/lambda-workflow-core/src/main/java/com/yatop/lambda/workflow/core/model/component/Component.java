package com.yatop.lambda.workflow.core.model.component;

import com.alibaba.fastjson.JSONObject;
import com.yatop.lambda.base.model.CfComponent;
import com.yatop.lambda.workflow.core.model.IRichModel;

public class Component implements IRichModel {
    CfComponent component;

    @Override
    public JSONObject toJSON() {
        return null;
    }

    @Override
    public void clear() {

    }
}
