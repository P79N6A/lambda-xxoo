package com.yatop.lambda.workflow.core.framework.chartype;

import com.yatop.lambda.core.enums.LambdaExceptionEnum;
import com.yatop.lambda.core.exception.LambdaException;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.context.CharValueContext;
import com.yatop.lambda.workflow.core.richmodel.workflow.charvalue.CharValue;
import com.yatop.lambda.workflow.core.utils.CollectionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;

public abstract class CharTyeClazzBaseClazz implements ICharTypeClazz {

    public static Logger logger = LoggerFactory.getLogger(CharTyeClazzBaseClazz.class);

    //<class-path, bean-object>
    private static final HashMap<String, ICharTypeClazz> CLAZZ_BEANS = new HashMap<String, ICharTypeClazz>();

    public static ICharTypeClazz getClazzBean(String clazzPath) {
        return CollectionUtil.get(CLAZZ_BEANS, clazzPath);
    }

    private static void putClazzBean(String clazzPath, ICharTypeClazz charTypeBean) {
        CollectionUtil.put(CLAZZ_BEANS, clazzPath, charTypeBean);
    }

    public CharTyeClazzBaseClazz() {
        CharTyeClazzBaseClazz.putClazzBean(this.getClass().getName(), this);
    }

    //
    //接口方法默认实现
    //

    @Override
    public void createCharValue(CharValueContext context) {
        CharValue charValue = context.getCharValue();
        charValue.setCharValue(charValue.getTextValue());
    }

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
    public void queryCharValue(CharValue charValue) {
        if(DataUtil.isNotEmpty(charValue.getCharValue())) {
            charValue.setTextValue(charValue.getCharValue());
        }
    }

    @Override
    public boolean validateCharValue(CharValue charValue) {
        return false;
    }
}
