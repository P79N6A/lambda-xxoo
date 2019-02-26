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
import com.yatop.lambda.workflow.core.richmodel.data.unstructured.CodeScript;
import com.yatop.lambda.workflow.core.richmodel.data.unstructured.JsonObject;

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
        jsonObject.put("textValue", getTextValue());
        jsonObject.put("objectValue", getObjectValue());
        return jsonObject;
    }

    @Override
    public String toString() {
        return DataUtil.prettyFormat(toJSON());
    }

    @Override
    public void clear(boolean clearData) {
        cmptChar = null;
        charValue = null;
        textValue = null;
        objectValue = null;
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

    public boolean isBasicDataType() {
        return getCharTypeClazzBean() instanceof CharTypeBasicGeneric;
    }

    public boolean isTuneDataType() {
        return getCharTypeClazzBean() instanceof CharTypeTuneGeneric;
    }

    public boolean isJsonDataType() {
        return getCharTypeClazzBean() instanceof CharTypeJsonGeneric;
    }

    public boolean isScriptDataType() {
        return getCharTypeClazzBean() instanceof CharTypeScriptGeneric;
    }

    public boolean isAlgorithmDataType() {
        return getCharTypeClazzBean() instanceof CharTypeAlgorithmGeneric;
    }

    public boolean isReportDataType() {
        return getCharTypeClazzBean() instanceof CharTypeReportGeneric;
    }

    public boolean isTableDataType() {
        return getCharTypeClazzBean() instanceof CharTypeTableGeneric;
    }

    public boolean isModelDataType() {
        return getCharTypeClazzBean() instanceof CharTypeModelGeneric;
    }
/*
    public String getBasicDataValue() {
        return isBasicDataType() ? getTextValue() : null;
    }

    public String getTuneParamValue() {
        return isTuneDataType() ? getTextValue() : null;
    }

    public String getScriptParamValue() {
        return isScriptDataType() ? getTextValue() : null;
    }

    public String getJsonParamValue() {
        return isJsonDataType() ? getTextValue() : null;
    }

    public JsonObject getJsonAlgorithm() {
        return isAlgorithmDataType() ? (JsonObject) getObjectValue() : null;
    }
    */

    public CodeScript getCodeScript() {
        return isScriptDataType() ? (CodeScript) getObjectValue() : null;
    }

    public JsonObject getJsonObject() {
        return isJsonDataType() || isAlgorithmDataType() || isReportDataType() ? (JsonObject) getObjectValue() : null;
    }

    public DataTable getDataTable() {
        return isTableDataType() ? (DataTable) getObjectValue() : null;
    }

    public Model getModel() {
        return isModelDataType() ? (Model) getObjectValue() : null;
    }
}
