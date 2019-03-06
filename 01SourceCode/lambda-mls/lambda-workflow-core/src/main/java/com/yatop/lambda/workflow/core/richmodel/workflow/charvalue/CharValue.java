package com.yatop.lambda.workflow.core.richmodel.workflow.charvalue;

import com.alibaba.fastjson.JSONObject;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.framework.chartype.ICharTypeClazz;
import com.yatop.lambda.workflow.core.framework.chartype.clazz.algorithm.CharTypeAlgorithmGeneric;
import com.yatop.lambda.workflow.core.framework.chartype.clazz.basic.CharTypeBasicGeneric;
import com.yatop.lambda.workflow.core.framework.chartype.clazz.json.CharTypeJsonGeneric;
import com.yatop.lambda.workflow.core.framework.chartype.clazz.model.CharTypeModelGeneric;
import com.yatop.lambda.workflow.core.framework.chartype.clazz.report.CharTypeReportGeneric;
import com.yatop.lambda.workflow.core.framework.chartype.clazz.script.CharTypeScriptGeneric;
import com.yatop.lambda.workflow.core.framework.chartype.clazz.table.CharTypeTableGeneric;
import com.yatop.lambda.workflow.core.framework.chartype.clazz.tune.CharTypeTuneGeneric;
import com.yatop.lambda.workflow.core.richmodel.IRichModel;
import com.yatop.lambda.workflow.core.richmodel.RichModel;
import com.yatop.lambda.workflow.core.richmodel.component.characteristic.CmptChar;
import com.yatop.lambda.workflow.core.richmodel.data.model.Model;
import com.yatop.lambda.workflow.core.richmodel.data.table.DataTable;
import com.yatop.lambda.workflow.core.richmodel.data.unstructured.JsonAlgorithm;
import com.yatop.lambda.workflow.core.richmodel.data.unstructured.JsonReport;
import com.yatop.lambda.workflow.core.richmodel.data.unstructured.CodeScript;
import com.yatop.lambda.workflow.core.richmodel.data.unstructured.JsonGeneral;

public class CharValue implements IRichModel {
    private CmptChar cmptChar;
    private String charValue;	    //特征值
    private String textValue;	    //特征值-文本内容
    private RichModel objectValue;  //特征值-关联对象

    public CharValue(CmptChar cmptChar) {
        this(cmptChar, null);
    }

    public CharValue(CmptChar cmptChar, String charValue) {
        this.cmptChar = cmptChar;
        this.charValue = charValue;
    }

    public JSONObject toJSON() {
        JSONObject jsonObject = this.cmptChar.toJSON();
        jsonObject.put("charValue", this.charValue);
        jsonObject.put("JSONValue", this.toJSONValue());
        return jsonObject;
    }

    @Override
    public String toString() {
        return DataUtil.toPrettyJSONString(toJSON());
    }

    @Override
    public void clear() {
        cmptChar = null;
        charValue = null;
        textValue = null;
        if(DataUtil.isNotNull(objectValue)) {
            objectValue.clear();
            objectValue = null;
        }
    }

    public CmptChar getCmptChar() {
        return cmptChar;
    }

    public Integer getSpecType() {
        return this.getCmptChar().data().getSpecType();
    }

    public String getCharValue() {
        return charValue;
    }

    public void setCharValue(String charValue) {
        this.charValue = charValue;
    }

    public String getTextValue() {
        return textValue;
    }

    public void setTextValue(String textValue) {
        this.textValue = textValue;
    }

    public RichModel getObjectValue() {
        return objectValue;
    }

    public void setObjectValue(RichModel objectValue) {
        this.objectValue = objectValue;
    }

    public ICharTypeClazz getCharTypeClazzBean() {
        return this.cmptChar.getCharTypeClazzBean();
    }

    public Object toJSONValue() {
        return getCharTypeClazzBean().toJsonValue(this);
    }

    public void parseJSONValue(Object obj) {
        getCharTypeClazzBean().parseJsonValue(this, obj);
    }

    public boolean isEmptyCharValue() {
        return getCharTypeClazzBean().isEmptyCharValue(this);
    }

    public boolean isBasicType() {
        return getCharTypeClazzBean() instanceof CharTypeBasicGeneric;
    }

    public boolean isTuneType() {
        return getCharTypeClazzBean() instanceof CharTypeTuneGeneric;
    }

    public boolean isJsonType() {
        return getCharTypeClazzBean() instanceof CharTypeJsonGeneric;
    }

    public boolean isScriptType() {
        return getCharTypeClazzBean() instanceof CharTypeScriptGeneric;
    }

    public boolean isAlgorithmType() {
        return getCharTypeClazzBean() instanceof CharTypeAlgorithmGeneric;
    }

    public boolean isReportType() {
        return getCharTypeClazzBean() instanceof CharTypeReportGeneric;
    }

    public boolean isTableType() {
        return getCharTypeClazzBean() instanceof CharTypeTableGeneric;
    }

    public boolean isModelType() {
        return getCharTypeClazzBean() instanceof CharTypeModelGeneric;
    }

    public CodeScript getCodeScript() {
        return isScriptType() ? (CodeScript) getObjectValue() : null;
    }

    public JsonGeneral getJsonGeneral() {
        return isJsonType() ? (JsonGeneral) getObjectValue() : null;
    }

    public JsonAlgorithm getJsonAlgorithm() {
        return isAlgorithmType() ? (JsonAlgorithm) getObjectValue() : null;
    }

    public JsonReport getJsonReport() {
        return isReportType() ? (JsonReport) getObjectValue() : null;
    }

    public DataTable getDataTable() {
        return isTableType() ? (DataTable) getObjectValue() : null;
    }

    public Model getModel() {
        return isModelType() ? (Model) getObjectValue() : null;
    }
}
