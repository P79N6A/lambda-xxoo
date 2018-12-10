package com.yatop.lambda.workflow.core.model.component.characteristic;

import com.alibaba.fastjson.JSONObject;
import com.yatop.lambda.base.model.CfCmptCharTypeWild;
import com.yatop.lambda.workflow.core.model.IRichModel;

public class CmptCharTypeWild implements IRichModel {
    CfCmptCharTypeWild wild;

    @Override
    public JSONObject toJson() {
        return null;
    }

    @Override
    public void parseJson(String jsonStr) {

    }
}
