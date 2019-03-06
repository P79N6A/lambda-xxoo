package com.yatop.lambda.workflow.core.framework.chartype.clazz.tune;

import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.context.CharValueContext;
import com.yatop.lambda.workflow.core.framework.chartype.CharTypeClazzBaseClazz;
import com.yatop.lambda.workflow.core.richmodel.workflow.charvalue.CharValue;

public abstract class CharTypeTuneGeneric extends CharTypeClazzBaseClazz {


    //
    //调参数据类型接口方法默认实现
    //

    @Override
    public void deleteCharValue(CharValueContext context) {
        return;
    }

    @Override
    public void recoverCharValue(CharValueContext context) {
        CharValue charValue = context.getCharValue();
        if(DataUtil.isNotEmpty(charValue.getCharValue())) {
            charValue.setTextValue(charValue.getCharValue());
        }
    }

    @Override
    public void updateCharValue(CharValueContext context) {
        CharValue charValue = context.getCharValue();
        charValue.setCharValue(charValue.getTextValue());
    }

    @Override
    public void clearCharValue(CharValueContext context) {
        return;
    }

    @Override
    public void completeCharValue(CharValueContext context) {
        return;
    }

    @Override
    public void queryCharValue(CharValue charValue) {
        if(DataUtil.isNotEmpty(charValue.getCharValue())) {
            charValue.setTextValue(charValue.getCharValue());
        }
    }

    @Override
    public boolean isEmptyCharValue(CharValue charValue) {
        return DataUtil.isEmpty(charValue.getCharValue());
    }
}
