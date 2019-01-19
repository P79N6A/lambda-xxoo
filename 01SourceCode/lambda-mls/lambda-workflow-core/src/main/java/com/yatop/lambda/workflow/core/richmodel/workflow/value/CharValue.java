package com.yatop.lambda.workflow.core.richmodel.workflow.value;

import com.alibaba.fastjson.JSONObject;
import com.yatop.lambda.base.utils.LambdaRootModel;
import com.yatop.lambda.workflow.core.framework.chartype.ICharTypeClazz;
import com.yatop.lambda.workflow.core.richmodel.IRichModel;
import com.yatop.lambda.workflow.core.richmodel.component.characteristic.CmptChar;

public class CharValue extends LambdaRootModel implements IRichModel {
    private CmptChar cmptChar;
    private String charValue;	    //特征值内容
    private String inText;		    //传入文本内容，仅限组件参数、调用执行、运行调优参数，以文本内容方式进行传入传出
    private String outText;		    //传出文本内容
    private IRichModel inObject;    //传入对象内容，仅限输入内容、输出内容，以对象内容方式进行传入传出（算法参数、数据表、模型、报告）
    private IRichModel outObject;	//传出对象内容

    public CharValue(CmptChar cmptChar) {
        this(cmptChar, null);
    }

    public CharValue(CmptChar cmptChar, String charValue) {
        this.cmptChar = cmptChar;
        this.charValue = charValue;
        this.clearColoured();
    }

    @Override
    public JSONObject toJSON() {
        JSONObject jsonObject = cmptChar.toJSON();
        jsonObject.put("charValue", charValue);
        jsonObject.put("inText", inText);
        jsonObject.put("inObject", inObject);
        jsonObject.put("outText", outText);
        jsonObject.put("outObject", outObject);
        return jsonObject;
    }

    @Override
    public void clear() {
        cmptChar = null;
        charValue = null;
        inText = null;
        outText = null;
        inObject = null;
        outObject = null;
    }

    @Override
    public void clearColoured() {

    }

    @Override
    public boolean isColoured() {
        return false;
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

    public String getInText() {
        return inText;
    }

    public void setInText(String inText) {
        this.inText = inText;
    }

    public String getOutText() {
        return outText;
    }

    public void setOutText(String outText) {
        this.outText = outText;
    }

    public IRichModel getInObject() {
        return inObject;
    }

    public void setInObject(IRichModel inObject) {
        this.inObject = inObject;
    }

    public IRichModel getOutObject() {
        return outObject;
    }

    public void setOutObject(IRichModel outObject) {
        this.outObject = outObject;
    }

    public String getTextValue() {
        return this.getOutText();
    }

    public IRichModel getObjectValue() {
        return this.getOutObject();
    }

    public ICharTypeClazz getCharTypeClazzBean() {
        return this.cmptChar.getCharTypeClazzBean();
    }
}
