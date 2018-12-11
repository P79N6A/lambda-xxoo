package com.yatop.lambda.workflow.core.model.workflow.module;

import com.alibaba.fastjson.JSONObject;
import com.yatop.lambda.base.model.WfModule;
import com.yatop.lambda.workflow.core.model.IRichModel;

public class Module implements IRichModel {
    WfModule module;

    @Override
    public JSONObject toJSON() {
        return null;
    }

    @Override
    public void clear() {

    }
}
