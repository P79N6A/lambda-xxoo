package com.yatop.lambda.workflow.core.richmodel.workflow.component.specification;

import com.yatop.lambda.base.model.WfCfgSpecification;
import com.yatop.lambda.workflow.core.richmodel.RichModel;
import com.yatop.lambda.workflow.core.richmodel.workflow.component.characteristic.CmptChar;
import com.yatop.lambda.workflow.core.utils.CollectionUtil;

import java.util.List;
import java.util.TreeMap;

public class CmptSpec extends RichModel<WfCfgSpecification> {

    private TreeMap<String, CmptChar> cmptChars = new TreeMap<String, CmptChar>();              //规格关联特征
    private TreeMap<String, CmptChar> cmptCharsOrderByCode = new TreeMap<String, CmptChar>();   //规格关联特征，key=charCode
    private TreeMap<String, SpecCharValue> charValues = new TreeMap<String, SpecCharValue>();   //规格配置特征值

    public CmptSpec(WfCfgSpecification data) {
        super(data);
    }

    @Override
    public void clear() {
        CollectionUtil.clear(cmptChars);
        cmptChars = null;
        CollectionUtil.enhancedClear(charValues);
        charValues = null;
        super.clear();
    }

    public int cmptCharCount() {
        return cmptChars.size();
    }

    public CmptChar getCmptChar(String charId) {
        return CollectionUtil.get(cmptChars, charId);
    }

    public CmptChar getCmptCharByCode(String charCode) {
        return CollectionUtil.get(cmptCharsOrderByCode, charCode);
    }

    public List<CmptChar> getCmptChars() {
        return CollectionUtil.toList(cmptChars);
    }

    public void putCmptChar(CmptChar cmptChar) {
        CollectionUtil.put(cmptChars, cmptChar.data().getCharId(), cmptChar);
        CollectionUtil.put(cmptCharsOrderByCode, cmptChar.data().getCharCode(), cmptChar);
    }

    public int charValueCount() {
        return charValues.size();
    }

    public SpecCharValue getCharValue(String charId) {
        return CollectionUtil.get(charValues, charId);
    }

    public void putCharValue(SpecCharValue charValue) {
        CollectionUtil.put(charValues, charValue.data().getCharId(), charValue);
    }
}
