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

public class CharValue implements IRichModel {
    private CmptChar cmptChar;
    private String charValue;	    //特征值
    private String paramValue;	    //参数特征值内容
    private RichModel outputValue;  //输出特征值内容

    public CharValue(CmptChar cmptChar) {
        this(cmptChar, null);
    }

    public CharValue(CmptChar cmptChar, String charValue) {
        this.cmptChar = cmptChar;
        this.charValue = charValue;
    }

    public JSONObject toJSON() {
        JSONObject jsonObject = cmptChar.toJSON();
        jsonObject.put("charValue", charValue);
        jsonObject.put("paramValue", getParamValue());
        jsonObject.put("outputValue", getOutputValue());
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
        paramValue = null;
        outputValue = null;
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

    public String getParamValue() {
        return paramValue;
    }

    public void setParamValue(String paramValue) {
        this.paramValue = paramValue;
    }

    public RichModel getOutputValue() {
        return outputValue;
    }

    public void setOutputValue(RichModel outputValue) {
        this.outputValue = outputValue;
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

    /*public String getBasicParamValue() {
        return isBasicDataType() ? getParamValue() : null;
    }

    public String getTuneParamValue() {
        return isTuneDataType() ? getParamValue() : null;
    }

    public String getScriptParamValue() {
        return isScriptDataType() ? getParamValue() : null;
    }

    public String getJsonParamValue() {
        return isJsonDataType() ? getParamValue() : null;
    }

    public JsonObject getAlgorithmOutputValue() {
        return isAlgorithmDataType() ? (JsonObject) getOutputValue() : null;
    }

    public JsonObject getReportOutputValue() {
        return isReportDataType() ? (JsonObject) getOutputValue() : null;
    }

    public DataTable getTableOutputValue() {
        return isTableDataType() ? (DataTable) getOutputValue() : null;
    }

    public Model getModelOutputValue() {
        return isModelDataType() ? (Model) getOutputValue() : null;
    }*/
}
