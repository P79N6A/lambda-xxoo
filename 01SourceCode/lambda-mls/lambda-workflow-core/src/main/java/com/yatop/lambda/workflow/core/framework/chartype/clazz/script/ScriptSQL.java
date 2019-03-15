package com.yatop.lambda.workflow.core.framework.chartype.clazz.script;

import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.context.CharValueContext;
import com.yatop.lambda.workflow.core.mgr.data.unstructured.CodeScriptHelper;
import com.yatop.lambda.workflow.core.richmodel.workflow.component.characteristic.CmptChar;
import com.yatop.lambda.workflow.core.richmodel.workflow.charvalue.CharValue;

public class ScriptSQL extends ScriptGeneric {

    @Override
    public void createCharValue(CharValueContext context) {
        String textValue = context.getCharValue().getTextValue();
        if(DataUtil.isEmpty(textValue)) {
            context.getCharValue().setTextValue("--输入数据已自动映射成t1~t4，使用方式如：select * from t1\n"
                    + "--本组件支持SPARK SQL的所有语法，必须为select语句，查询结果作为本组件的输出数据\n");
        }
        CodeScriptHelper.createCodeScript4Sql(context);
    }

    @Override
    public boolean validateCharValue(CharValue charValue) {
        CmptChar cmptChar = charValue.getCmptChar();
        String textValue = charValue.getTextValue();

        if(DataUtil.isEmpty(textValue)) {
            return true;
        }

        return true;
    }

    @Override
    public Object toJsonValue(CharValue charValue) {
        return charValue.getTextValue();
    }

    @Override
    public void parseJsonValue(CharValue charValue, Object obj) {
        return;
    }
}
