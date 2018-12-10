package com.yatop.lambda.workflow.core.model.component;

import com.alibaba.fastjson.JSONObject;
import com.yatop.lambda.base.model.CfCmptCharValue;
import com.yatop.lambda.workflow.core.model.IRichModel;

public class CmptCharValue implements IRichModel {
    CfCmptCharValue value;

    @Override
    public JSONObject toJson() {
        return null;
    }

    @Override
    public void parseJson(String jsonStr) {

    }
}
