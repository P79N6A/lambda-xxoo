package com.yatop.lambda.workflow.core.model.component.characteristic;

import com.alibaba.fastjson.JSONObject;
import com.yatop.lambda.base.model.CfCmptCharEnum;
import com.yatop.lambda.workflow.core.model.IRichModel;

public class CmptCharEnum implements IRichModel {
    CfCmptCharEnum type;

    @Override
    public JSONObject toJson() {
        return null;
    }

    @Override
    public void parseJson(String jsonStr) {

    }
}
