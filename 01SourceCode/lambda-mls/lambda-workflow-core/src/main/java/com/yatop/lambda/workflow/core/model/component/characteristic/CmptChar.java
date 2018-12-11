package com.yatop.lambda.workflow.core.model.component.characteristic;

import com.alibaba.fastjson.JSONObject;
import com.yatop.lambda.base.model.CfCmptChar;
import com.yatop.lambda.workflow.core.model.IRichModel;

public class CmptChar implements IRichModel {
    CfCmptChar cmptChar;

    @Override
    public JSONObject toJSON() {
        return null;
    }

    @Override
    public void clear() {

    }
}
