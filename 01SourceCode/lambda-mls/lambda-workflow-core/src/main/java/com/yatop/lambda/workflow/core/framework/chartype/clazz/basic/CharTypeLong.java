package com.yatop.lambda.workflow.core.framework.chartype.clazz.basic;

import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.richmodel.component.characteristic.CmptChar;
import com.yatop.lambda.workflow.core.richmodel.workflow.charvalue.CharValue;
import org.springframework.stereotype.Service;

@Service
public final class CharTypeLong extends CharTypeBasicGeneric {

    @Override
    public boolean validateCharValue(CharValue charValue) {
        CmptChar cmptChar = charValue.getCmptChar();
        String textValue = charValue.getTextValue();

        if(cmptChar.isRequired() && DataUtil.isEmpty(textValue)) {
            return false;
        }

        try {
            Long value = Long.valueOf(textValue);
        } catch (Throwable e) {
            return false;
        }

        return true;
    }

    @Override
    public Object toJSONValue(CharValue charValue) {
        String textValue = charValue.getTextValue();

        if(DataUtil.isEmpty(textValue)) {
            return null;
        }

        return Long.valueOf(textValue);
    }

    @Override
    public void parseJSONValue(CharValue charValue, Object obj) {

        if(obj == null) {
            charValue.setCharValue(null);
            charValue.setTextValue(null);
        }
        if(obj instanceof Long) {
            String value = String.valueOf(obj);
            charValue.setCharValue(value);
            charValue.setTextValue(value);
        }
    }
}
