package com.yatop.lambda.workflow.core.framework.chartype.clazz.basic;

import com.yatop.lambda.workflow.core.richmodel.workflow.charvalue.CharValue;

public class CharTypeDatetime extends CharTypeBasicGeneric {

    @Override
    public boolean validateCharValue(CharValue charValue) {
        return false;
    }

    @Override
    public Object toJSONValue(CharValue charValue) {
        return null;
    }

    @Override
    public void parseJSONValue(CharValue charValue, Object obj) {

    }
}
