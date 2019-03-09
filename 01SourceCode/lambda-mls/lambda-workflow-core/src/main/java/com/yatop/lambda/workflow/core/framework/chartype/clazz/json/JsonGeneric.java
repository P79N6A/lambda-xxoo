package com.yatop.lambda.workflow.core.framework.chartype.clazz.json;

import com.yatop.lambda.workflow.core.context.CharValueContext;
import com.yatop.lambda.workflow.core.framework.chartype.CharTypeClazzBaseClazz;
import com.yatop.lambda.workflow.core.mgr.data.unstructured.JsonGeneralHelper;
import com.yatop.lambda.workflow.core.richmodel.workflow.charvalue.CharValue;

public abstract class JsonGeneric extends CharTypeClazzBaseClazz {


    //
    //普通json类型接口方法默认实现
    //

    @Override
    public void createCharValue(CharValueContext context) {
        JsonGeneralHelper.createJsonObject(context);
    }

    @Override
    public void deleteCharValue(CharValueContext context) {
        JsonGeneralHelper.deleteJsonObject(context);
    }

    @Override
    public void recoverCharValue(CharValueContext context) {
        JsonGeneralHelper.recoverJsonObject(context);
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
    public void updateCharValue(CharValueContext context) {
        JsonGeneralHelper.updateJsonObject(context);
    }

    @Override
    public void queryCharValue(CharValue charValue) {
        JsonGeneralHelper.queryJsonObject(charValue);
    }

    @Override
    public boolean isEmptyCharValue(CharValue charValue) {
        return charValue.getJsonGeneral().isStateEmpty();
    }
}
