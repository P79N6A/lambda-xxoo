package com.yatop.lambda.workflow.core.model.component;

import com.alibaba.fastjson.JSONObject;
import com.yatop.lambda.base.model.CfCmptAlgorithm;
import com.yatop.lambda.workflow.core.model.IRichModel;

public class CmptAlgorithm implements IRichModel {
    CfCmptAlgorithm algorithm;

    @Override
    public JSONObject toJSON() {
        return null;
    }

    @Override
    public void clear() {

    }
}
