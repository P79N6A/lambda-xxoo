package com.yatop.lambda.workflow.core.context;

import com.alibaba.fastjson.JSONObject;
import com.yatop.lambda.workflow.core.component.chartype.CharValue;
import com.yatop.lambda.workflow.core.richmodel.component.characteristic.CmptChar;

public class CharValueContext {

    private CmptChar cmptChar;
//    private CharDefaultValue defaultValue;
    private CharValue charValue;
    private String warningMsg;

    public JSONObject toJSON() {
        return null;
    }

    public void clear() {

    }
}
