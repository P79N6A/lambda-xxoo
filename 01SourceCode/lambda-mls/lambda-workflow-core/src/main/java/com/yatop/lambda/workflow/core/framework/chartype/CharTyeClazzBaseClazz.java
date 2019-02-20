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
    public void createParamCharValue(CharValueContext context) {
        CharValue charValue = context.getCharValue();
        charValue.setCharValue(charValue.getParamValue());
    }

    @Override
    public void deleteParamCharValue(CharValueContext context) {
        return;
    }

    @Override
    public void recoverParamCharValue(CharValueContext context) {
        CharValue charValue = context.getCharValue();
        if(DataUtil.isNotEmpty(charValue.getCharValue())) {
            charValue.setParamValue(charValue.getCharValue());
        }
    }

    @Override
    public void queryParamCharValue(CharValueContext context) {
        CharValue charValue = context.getCharValue();
        if(DataUtil.isNotEmpty(charValue.getCharValue())) {
            charValue.setParamValue(charValue.getCharValue());
        }
    }

    @Override
    public void updateParamCharValue(CharValueContext context) {
        CharValue charValue = context.getCharValue();
        charValue.setCharValue(charValue.getParamValue());
    }

    @Override
    public boolean validateParamCharValue(CharValueContext context) {
        return false;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////

    private void missingOutputCharValueImplement(CharValueContext context) {
        CharValue charValue = context.getCharValue();
        LambdaException e = new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Char-Type-Clazz occur error.\n" + charValue, "计算组件错误", context.getNode().data(), charValue.getCmptChar().getType().data());
        logger.error("系统内部发生错误", e);
        throw e;
    }

    @Override
    public void exploreOutputCharValue(CharValueContext context) {
        missingOutputCharValueImplement(context);
    }

    @Override
    public void prepareOutputCharValue(CharValueContext context) {
        missingOutputCharValueImplement(context);
    }

    @Override
    public void completeOutputCharValue(CharValueContext context) {
        missingOutputCharValueImplement(context);
    }

    @Override
    public void clearOutputCharValue(CharValueContext context) {
        missingOutputCharValueImplement(context);
    }

    @Override
    public void deleteOutputCharValue(CharValueContext context) {
        missingOutputCharValueImplement(context);
    }

    @Override
    public void recoverOutputCharValue(CharValueContext context) {
        missingOutputCharValueImplement(context);
    }
}
