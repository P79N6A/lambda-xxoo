package com.yatop.lambda.workflow.core.framework.chartype.clazz.script;

import com.yatop.lambda.workflow.core.context.CharValueContext;
import com.yatop.lambda.workflow.core.framework.chartype.CharTypeClazzBaseClazz;
import com.yatop.lambda.workflow.core.mgr.data.unstructured.CodeScriptHelper;
import com.yatop.lambda.workflow.core.richmodel.workflow.charvalue.CharValue;

public abstract class CharTypeScriptGeneric extends CharTypeClazzBaseClazz {

    @Override
    public void deleteCharValue(CharValueContext context) {
        CodeScriptHelper.deleteCodeScript(context);
    }

    @Override
    public void recoverCharValue(CharValueContext context) {
        CodeScriptHelper.recoverCodeScript(context);
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
        CodeScriptHelper.updateCodeScript(context);
    }

    @Override
    public void queryCharValue(CharValue charValue) {
        CodeScriptHelper.queryCodeScript(charValue);
    }

    @Override
    public boolean isEmptyCharValue(CharValue charValue) {
        return charValue.getCodeScript().isStateEmpty();
    }
}
