package com.yatop.lambda.workflow.core.framework.chartype.clazz.basic;

import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.richmodel.workflow.component.characteristic.CmptChar;
import com.yatop.lambda.workflow.core.richmodel.workflow.charvalue.CharValue;

import java.util.Date;

public class BasicDateTime extends BasicGeneric {

    private static String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    @Override
    public boolean validateCharValue(CharValue charValue) {
        CmptChar cmptChar = charValue.getCmptChar();
        String textValue = charValue.getTextValue();

        if(DataUtil.isEmpty(textValue)) {
            return true;
        }

        if(DataUtil.isNotEmpty(textValue) && textValue.length() != DATE_FORMAT.length()) {
            return false;
        }

        try {
            Date value = DataUtil.toDate(textValue, DATE_FORMAT);
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

        return textValue;
    }

    @Override
    public void parseJsonValue(CharValue charValue, Object obj) {

        /*if(obj == null) {
            charValue.setCharValue(null);
            charValue.setTextValue(null);
        }
        if(obj instanceof String) {
            String value = (String)obj;
            charValue.setCharValue(value);
            charValue.setTextValue(value);
        }*/
    }
}
