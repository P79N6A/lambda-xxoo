package com.yatop.lambda.workflow.core.framework.chartype.clazz.algorithm;

import com.alibaba.fastjson.JSONObject;
import com.yatop.lambda.base.model.WfJsonObject;
import com.yatop.lambda.workflow.core.context.CharValueContext;
import com.yatop.lambda.workflow.core.framework.chartype.CharTypeClazzBaseClazz;
import com.yatop.lambda.workflow.core.mgr.data.unstructured.JsonAlgorithmHelper;
import com.yatop.lambda.workflow.core.richmodel.data.unstructured.JsonAlgorithm;
import com.yatop.lambda.workflow.core.richmodel.workflow.charvalue.CharValue;

public abstract class CharTypeAlgorithmGeneric extends CharTypeClazzBaseClazz {

    private static String FIELD_OBJECT_CONTENT = "objectContent";

    @Override
    public void createCharValue(CharValueContext context) {
        JsonAlgorithmHelper.createJsonAlgorithm(context);
    }

    @Override
    public void deleteCharValue(CharValueContext context) {
        JsonAlgorithmHelper.deleteJsonAlgorithm(context);
    }

    @Override
    public void recoverCharValue(CharValueContext context) {
        JsonAlgorithmHelper.recoverJsonAlgorithm(context);
    }

    @Override
    public void clearCharValue(CharValueContext context) {
        JsonAlgorithmHelper.clearJsonAlgorithm(context);
    }

    @Override
    public void completeCharValue(CharValueContext context) {
        JsonAlgorithmHelper.completeJsonAlgorithm(context);
    }

    @Override
    public void updateCharValue(CharValueContext context) {
        return;
    }

    @Override
    public void queryCharValue(CharValue charValue) {
        JsonAlgorithmHelper.queryJsonAlgorithm(charValue);
    }

    @Override
    public boolean validateCharValue(CharValue charValue) {
        return true;
    }

    @Override
    public Object toJsonValue(CharValue charValue) {

        JsonAlgorithm algorithm = charValue.getJsonAlgorithm();
        JSONObject jsonValue = algorithm.toJSON();
        jsonValue.put(FIELD_OBJECT_CONTENT, JSONObject.parseObject(algorithm.data().getObjectContent()));
        return jsonValue;
    }

    @Override
    public void parseJsonValue(CharValue charValue, Object obj) {

        if(obj instanceof JSONObject) {
            JSONObject jsonValue = (JSONObject)obj;
            JSONObject jsonContent = jsonValue.getJSONObject(FIELD_OBJECT_CONTENT);
            jsonValue.remove(FIELD_OBJECT_CONTENT);

            JsonAlgorithm algorithm = new JsonAlgorithm(jsonValue.toJavaObject(WfJsonObject.class));
            algorithm.setObjectContent(jsonContent);
            charValue.setObjectValue(algorithm);
        }
    }

    @Override
    public boolean isEmptyCharValue(CharValue charValue) {
        return charValue.getJsonAlgorithm().isStateEmpty();
    }
}
