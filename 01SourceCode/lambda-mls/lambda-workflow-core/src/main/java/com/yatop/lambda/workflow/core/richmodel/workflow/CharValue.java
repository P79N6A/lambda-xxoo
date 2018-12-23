package com.yatop.lambda.workflow.core.richmodel.workflow;

import com.alibaba.fastjson.JSONObject;
import com.yatop.lambda.core.enums.IsDuplicatedEnum;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.richmodel.IRichModel;
import com.yatop.lambda.workflow.core.richmodel.component.characteristic.CmptChar;

public class CharValue implements IRichModel {
    private CmptChar cmptChar;
    private String charValue;	    //特征值内容
    private Integer isDuplicated;   //是否被复制
    private String inText;		    //传入文本内容，基本类型，调参类型，代码脚本、普通JSON对象 & JSON数组、算法参数等以文本内容方式进行传入传出
    private String outText;		    //传出文本内容
    private IRichModel inObject;    //传入对象内容，inText/OutText之外的非基本类型（数据表、模型、报告）以对象内容方式进行传入传出
    private IRichModel outObject;	//传出对象内容

    public CharValue(CmptChar cmptChar) {
        this.cmptChar = cmptChar;
    }

    @Override
    public void clear() {
        charValue = null;
        isDuplicated = null;
        inText = null;
        outText = null;
        outObject = null;
    }

    public CmptChar getCmptChar() {
        return cmptChar;
    }

    public String getCharValue() {
        return charValue;
    }

    public void setCharValue(String charValue) {
        this.charValue = charValue;
    }

    public boolean isDuplicated() {
        return DataUtil.isNull(isDuplicated) ? false : (isDuplicated == IsDuplicatedEnum.YES.getMark());
    }

    public void setIsDuplicated(Integer isDuplicated) {
        this.isDuplicated = isDuplicated;
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
}
