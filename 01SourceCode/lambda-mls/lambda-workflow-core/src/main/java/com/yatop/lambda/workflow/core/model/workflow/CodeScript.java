package com.yatop.lambda.workflow.core.model.workflow;

import com.alibaba.fastjson.JSONObject;
import com.yatop.lambda.base.model.WfCodeScript;
import com.yatop.lambda.workflow.core.model.IRichModel;

public class CodeScript implements IRichModel {
    WfCodeScript script;

    @Override
    public JSONObject toJSON() {
        return null;
    }

    @Override
    public void clear() {

    }
}
