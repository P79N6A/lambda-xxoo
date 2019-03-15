package com.yatop.lambda.workflow.core.framework.chartype.clazz.basic;

import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.richmodel.workflow.component.characteristic.CmptChar;
import com.yatop.lambda.workflow.core.richmodel.workflow.charvalue.CharValue;

public final class BasicLong extends BasicGeneric {

    @Override
    public boolean validateCharValue(CharValue charValue) {
        CmptChar cmptChar = charValue.getCmptChar();
        String textValue = charValue.getTextValue();

        if(DataUtil.isEmpty(textValue)) {
            return true;
        }

        try {
            Long value = DataUtil.toLong(textValue);
        } catch (Throwable e) {
            return false;
        }

        return true;
    }

    @Override
    public Object toJsonValue(CharValue charValue) {
        String textValue = charValue.getTextValue();

        if(DataUtil.isEmpty(textValue)) {
            return null;
        }

        return DataUtil.toLong(textValue);
    }

    @Override
    public void parseJsonValue(CharValue charValue, Object obj) {

        /*if(obj == null) {
            charValue.setCharValue(null);
            charValue.setTextValue(null);
        }
        if(obj instanceof Long) {
            String value = String.valueOf(obj);
            charValue.setCharValue(value);
            charValue.setTextValue(value);
        }*/
    }
}
