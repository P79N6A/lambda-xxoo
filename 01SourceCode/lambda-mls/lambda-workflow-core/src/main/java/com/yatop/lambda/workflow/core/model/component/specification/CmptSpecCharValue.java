package com.yatop.lambda.workflow.core.model.component.specification;

import com.alibaba.fastjson.JSONObject;
import com.yatop.lambda.base.model.CfCmptSpecCharValue;
import com.yatop.lambda.workflow.core.model.IRichModel;

public class CmptSpecCharValue implements IRichModel {
    CfCmptSpecCharValue value;

    @Override
    public JSONObject toJson() {
        return null;
    }

    @Override
    public void parseJson(String jsonStr) {

    }
}
