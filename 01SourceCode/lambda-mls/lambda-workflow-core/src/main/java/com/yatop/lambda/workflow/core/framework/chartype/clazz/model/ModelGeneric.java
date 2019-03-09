package com.yatop.lambda.workflow.core.framework.chartype.clazz.model;

import com.alibaba.fastjson.JSONObject;
import com.yatop.lambda.base.model.MwModel;
import com.yatop.lambda.workflow.core.context.CharValueContext;
import com.yatop.lambda.workflow.core.framework.chartype.CharTypeClazzBaseClazz;
import com.yatop.lambda.workflow.core.mgr.data.model.CachedModelHelper;
import com.yatop.lambda.workflow.core.richmodel.data.model.Model;
import com.yatop.lambda.workflow.core.richmodel.workflow.charvalue.CharValue;

public abstract class ModelGeneric extends CharTypeClazzBaseClazz {


    //
    //模型（已训练模型）类型接口方法默认实现
    //

    @Override
    public void createCharValue(CharValueContext context) {
        CachedModelHelper.createCachedModel(context);
    }

    @Override
    public void deleteCharValue(CharValueContext context) {
        CachedModelHelper.deleteCachedModel(context);
    }

    @Override
    public void recoverCharValue(CharValueContext context) {
        CachedModelHelper.recoverCachedModel(context);
    }

    @Override
    public void clearCharValue(CharValueContext context) {
        CachedModelHelper.clearCachedModel(context);
    }

    @Override
    public void completeCharValue(CharValueContext context) {
        CachedModelHelper.completeCachedModel(context);
    }

    @Override
    public void updateCharValue(CharValueContext context) {
        return;
    }

    @Override
    public void queryCharValue(CharValue charValue) {
        CachedModelHelper.queryCachedModel(charValue);
    }

    @Override
    public boolean validateCharValue(CharValue charValue) {
        return true;
    }

    @Override
    public Object toJsonValue(CharValue charValue) {
        return charValue.getModel().toJSON();
    }

    @Override
    public void parseJsonValue(CharValue charValue, Object obj) {

        if(obj instanceof JSONObject) {
            JSONObject jsonValue = (JSONObject)obj;
            Model model = new Model(jsonValue.toJavaObject(MwModel.class));
            charValue.setObjectValue(model);
        }
    }

    @Override
    public boolean isEmptyCharValue(CharValue charValue) {
        return charValue.getModel().isStateEmpty();
    }
}
