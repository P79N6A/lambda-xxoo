package com.yatop.lambda.workflow.core.richmodel.workflow;

import com.alibaba.fastjson.JSONObject;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.richmodel.IRichModel;

public class CharValue implements IRichModel {
    private String charValue;	    //特征值内容
    private Integer isDuplicated;   //是否被复制
    private String inText;		    //传入文本内容，所有新值以文本内容方式传入
    private String outText;		    //传出文本内容，代码脚本、普通JSON对象 & JSON数组、算法参数等以文本内容方式进行传出
    private IRichModel outObject;	//传出对象内容，outText之外的非基础特征类型以对象内容方式进行传出

    @Override
    public void clear() {
        charValue = null;
        isDuplicated = null;
        inText = null;
        outText = null;
        outObject = null;
    }

    public String getCharValue() {
        return charValue;
    }

    public void setCharValue(String charValue) {
        this.charValue = charValue;
    }

    public Integer getIsDuplicated() {
        return isDuplicated;
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

    public IRichModel getOutObject() {
        return outObject;
    }

    public void setOutObject(IRichModel outObject) {
        this.outObject = outObject;
    }
}
