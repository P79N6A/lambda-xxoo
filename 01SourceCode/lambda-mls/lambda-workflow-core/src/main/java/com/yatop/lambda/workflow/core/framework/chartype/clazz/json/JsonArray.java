package com.yatop.lambda.workflow.core.framework.chartype.clazz.json;

import com.alibaba.fastjson.JSONArray;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.richmodel.component.characteristic.CmptChar;
import com.yatop.lambda.workflow.core.richmodel.workflow.charvalue.CharValue;

public class JsonArray extends JsonGeneric {

    @Override
    public boolean validateCharValue(CharValue charValue) {
        CmptChar cmptChar = charValue.getCmptChar();
        String textValue = charValue.getTextValue();

        if(DataUtil.isEmpty(textValue)) {
            return true;
        }

        try {
            JSONArray.parseArray(charValue.getTextValue());
        } catch (Throwable e){
            return false;
        }

        return true;
    }

    @Override
    public Object toJsonValue(CharValue charValue) {
        if(DataUtil.isEmpty(charValue.getTextValue()))
            return null;

        return JSONArray.parseArray(charValue.getTextValue());
    }

    @Override
    public void parseJsonValue(CharValue charValue, Object obj) {
        return;
    }
}
