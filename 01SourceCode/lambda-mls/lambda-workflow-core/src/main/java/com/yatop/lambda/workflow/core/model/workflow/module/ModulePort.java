package com.yatop.lambda.workflow.core.model.workflow.module;

import com.alibaba.fastjson.JSONObject;
import com.yatop.lambda.base.model.WfModulePort;
import com.yatop.lambda.workflow.core.model.IRichModel;

public class ModulePort implements IRichModel {
    WfModulePort port;

    @Override
    public JSONObject toJson() {
        return null;
    }

    @Override
    public void parseJson(String jsonStr) {

    }
}
