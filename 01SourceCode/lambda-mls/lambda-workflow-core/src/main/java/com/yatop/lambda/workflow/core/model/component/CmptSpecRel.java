package com.yatop.lambda.workflow.core.model.component;

import com.alibaba.fastjson.JSONObject;
import com.yatop.lambda.base.model.CfCmptSpecRel;
import com.yatop.lambda.workflow.core.model.IRichModel;

public class CmptSpecRel implements IRichModel {
    CfCmptSpecRel relation;

    @Override
    public JSONObject toJson() {
        return null;
    }

    @Override
    public void parseJson(String jsonStr) {

    }
}
