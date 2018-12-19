package com.yatop.lambda.workflow.core.richmodel.component.characteristic;

import com.yatop.lambda.base.model.CfCmptChar;
import com.yatop.lambda.workflow.core.richmodel.IRichModel;
import com.yatop.lambda.workflow.core.utils.CollectionUtil;

import java.util.List;
import java.util.TreeMap;

public class CmptChar extends CfCmptChar implements IRichModel {

    private CmptCharType type;
    private TreeMap<String, CmptCharEnum> enums = new TreeMap<String, CmptCharEnum>();
    private TreeMap<Integer, CmptCharEnum> enumsOrderbySequence = new TreeMap<Integer, CmptCharEnum>();

    public CmptChar() {}

    public CmptChar(CfCmptChar data) {super.copyProperties(data);}

    @Override
    public void clear() {
        type = null;
        enums.clear();
        enums = null;
        CollectionUtil.clear(enumsOrderbySequence);
        enumsOrderbySequence = null;
        super.clear();
    }

    public CmptCharType getType() {
        return type;
    }

    public void setType(CmptCharType type) {
        this.type = type;
    }

    public boolean containsEnum(String value) {
        return CollectionUtil.containsKey(enums, value);
    }

    public List<CmptCharEnum> getEnums() {
        return CollectionUtil.toList(enumsOrderbySequence);
    }

    public void putEnum(CmptCharEnum charEnum) {
        CollectionUtil.put(enums, charEnum.getEnumValue(), charEnum);
        CollectionUtil.put(enumsOrderbySequence, charEnum.getSequence(), charEnum);
    }
}
