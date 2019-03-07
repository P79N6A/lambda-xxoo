package com.yatop.lambda.workflow.core.framework.chartype.clazz.table;

import com.alibaba.fastjson.JSONObject;
import com.yatop.lambda.base.model.DwDataTable;
import com.yatop.lambda.workflow.core.context.CharValueContext;
import com.yatop.lambda.workflow.core.framework.chartype.CharTypeClazzBaseClazz;
import com.yatop.lambda.workflow.core.mgr.data.table.CachedTableHelper;
import com.yatop.lambda.workflow.core.richmodel.data.table.DataTable;
import com.yatop.lambda.workflow.core.richmodel.workflow.charvalue.CharValue;

public class TableGeneric extends CharTypeClazzBaseClazz {

    @Override
    public void createCharValue(CharValueContext context) {
        CachedTableHelper.createCachedTable(context);
    }

    @Override
    public void deleteCharValue(CharValueContext context) {
        CachedTableHelper.deleteCachedTable(context);
    }

    @Override
    public void recoverCharValue(CharValueContext context) {
        CachedTableHelper.recoverCachedTable(context);
    }

    @Override
    public void clearCharValue(CharValueContext context) {
        CachedTableHelper.clearCachedTable(context);
    }

    @Override
    public void completeCharValue(CharValueContext context) {
        CachedTableHelper.completeCachedTable(context);
    }

    @Override
    public void updateCharValue(CharValueContext context) {
        return;
    }

    @Override
    public void queryCharValue(CharValue charValue) {
        CachedTableHelper.queryCachedTable(charValue);
    }

    @Override
    public boolean validateCharValue(CharValue charValue) {
        return true;
    }

    @Override
    public Object toJsonValue(CharValue charValue) {
        return charValue.getDataTable().toJSON();
    }

    @Override
    public void parseJsonValue(CharValue charValue, Object obj) {

        if(obj instanceof JSONObject) {
            JSONObject jsonValue = (JSONObject)obj;
            DataTable dataTable = new DataTable(jsonValue.toJavaObject(DwDataTable.class));
            charValue.setObjectValue(dataTable);
        }
    }

    @Override
    public boolean isEmptyCharValue(CharValue charValue) {
        return charValue.getDataTable().isStateEmpty();
    }
}
