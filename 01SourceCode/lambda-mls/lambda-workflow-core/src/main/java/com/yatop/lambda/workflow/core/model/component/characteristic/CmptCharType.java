package com.yatop.lambda.workflow.core.model.component.characteristic;

import com.alibaba.fastjson.JSONObject;
import com.yatop.lambda.base.model.CfCmptCharType;
import com.yatop.lambda.workflow.core.model.IRichModel;

public class CmptCharType implements IRichModel {
    CfCmptCharType type;

    @Override
    public JSONObject toJson() {
        return null;
    }

    @Override
    public void parseJson(String jsonStr) {

    }
}
