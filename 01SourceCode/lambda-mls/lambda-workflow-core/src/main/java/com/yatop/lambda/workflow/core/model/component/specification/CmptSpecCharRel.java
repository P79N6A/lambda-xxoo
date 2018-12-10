package com.yatop.lambda.workflow.core.model.component.specification;

import com.alibaba.fastjson.JSONObject;
import com.yatop.lambda.base.model.CfCmptSpecCharRel;
import com.yatop.lambda.workflow.core.model.IRichModel;

public class CmptSpecCharRel implements IRichModel {
    CfCmptSpecCharRel relation;

    @Override
    public JSONObject toJson() {
        return null;
    }

    @Override
    public void parseJson(String jsonStr) {

    }
}
