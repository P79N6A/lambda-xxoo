package com.yatop.lambda.workflow.core.framework.chartype.clazz.report;

import com.alibaba.fastjson.JSONObject;
import com.yatop.lambda.base.model.WfJsonObject;
import com.yatop.lambda.workflow.core.context.CharValueContext;
import com.yatop.lambda.workflow.core.framework.chartype.CharTypeClazzBaseClazz;
import com.yatop.lambda.workflow.core.mgr.data.unstructured.JsonReportHelper;
import com.yatop.lambda.workflow.core.richmodel.data.unstructured.JsonReport;
import com.yatop.lambda.workflow.core.richmodel.workflow.charvalue.CharValue;

public abstract class ReportGeneric extends CharTypeClazzBaseClazz {


    //
    //报告类型接口方法默认实现
    //

    @Override
    public void deleteCharValue(CharValueContext context) {
        JsonReportHelper.deleteJsonReport(context);
    }

    @Override
    public void recoverCharValue(CharValueContext context) {
        JsonReportHelper.recoverJsonReport(context);
    }

    @Override
    public void clearCharValue(CharValueContext context) {
        JsonReportHelper.clearJsonReport(context);
    }

    @Override
    public void completeCharValue(CharValueContext context) {
        JsonReportHelper.completeJsonReport(context);
    }

    @Override
    public void updateCharValue(CharValueContext context) {
        return;
    }

    @Override
    public void queryCharValue(CharValue charValue) {
        JsonReportHelper.queryJsonReport(charValue);
    }

    @Override
    public boolean validateCharValue(CharValue charValue) {
        return true;
    }

    @Override
    public Object toJsonValue(CharValue charValue) {
        return charValue.getJsonReport().toJSON();
    }

    @Override
    public void parseJsonValue(CharValue charValue, Object obj) {

        if(obj instanceof JSONObject) {
            JSONObject jsonValue = (JSONObject)obj;
            JsonReport report = new JsonReport(jsonValue.toJavaObject(WfJsonObject.class));
            charValue.setObjectValue(report);
        }
    }

    @Override
    public boolean isEmptyCharValue(CharValue charValue) {
        return charValue.getJsonReport().isStateEmpty();
    }
}
