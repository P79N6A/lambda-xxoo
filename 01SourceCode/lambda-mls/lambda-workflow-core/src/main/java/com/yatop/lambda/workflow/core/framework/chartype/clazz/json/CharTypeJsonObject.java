package com.yatop.lambda.workflow.core.framework.chartype.clazz.json;

import com.alibaba.fastjson.JSONObject;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.richmodel.component.characteristic.CmptChar;
import com.yatop.lambda.workflow.core.richmodel.workflow.charvalue.CharValue;
import org.springframework.stereotype.Service;

@Service
public class CharTypeJsonObject extends CharTypeJsonGeneric {

    @Override
    public boolean validateCharValue(CharValue charValue) {
        CmptChar cmptChar = charValue.getCmptChar();
        String textValue = charValue.getTextValue();

        /*if(cmptChar.isRequired() && DataUtil.isEmpty(textValue)) {
            return false;
        }*/

        try {
            JSONObject.parseObject(charValue.getTextValue());
        } catch (Throwable e){
            return false;
        }

        return true;
    }

    @Override
    public Object toJsonValue(CharValue charValue) {
        if(DataUtil.isEmpty(charValue.getTextValue()))
            return null;

        return JSONObject.parseObject(charValue.getTextValue());
    }

    @Override
    public void parseJsonValue(CharValue charValue, Object obj) {
        return;
    }
}
