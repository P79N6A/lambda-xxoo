package com.yatop.lambda.workflow.core.richmodel.workflow.component.characteristic;

import com.yatop.lambda.base.model.WfCfgCharacteristic;
import com.yatop.lambda.core.enums.IsRequiredEnum;
import com.yatop.lambda.workflow.core.framework.chartype.ICharTypeClazz;
import com.yatop.lambda.workflow.core.richmodel.RichModel;
import com.yatop.lambda.workflow.core.utils.CollectionUtil;

import java.util.List;
import java.util.Optional;
import java.util.TreeMap;

public class CmptChar extends RichModel<WfCfgCharacteristic> implements Comparable<CmptChar> {

    private CharType type;      //特征类型
    private TreeMap<String, CharOption> enums = new TreeMap<String, CharOption>();  //特征枚举值
    private TreeMap<Integer, CharOption> enumsOrderbySequence = new TreeMap<Integer, CharOption>();     //特征枚举值按序号排序

    public CmptChar(WfCfgCharacteristic data, CharType type) {
        super(data);
        this.type = type;
    }

    @Override
    public int compareTo(CmptChar o) {
        return this.data().getCharId().compareTo(o.data().getCharId());
    }

    @Override
    public void clear() {
        type = null;
        CollectionUtil.enhancedClear(enums);
        enums = null;
        CollectionUtil.enhancedClear(enumsOrderbySequence);
        enumsOrderbySequence = null;
        super.clear();
    }

    public CharType getType() {
        return type;
    }

    public boolean containsOption(String value) {
        return CollectionUtil.containsKey(enums, value);
    }

    public int optionCount() {
        return enums.size();
    }

    public List<CharOption> getOptions() {
        return CollectionUtil.toList(enumsOrderbySequence);
    }

    public void putOption(CharOption charOption) {
        CollectionUtil.put(enums, charOption.data().getOptionValue(), charOption);
        CollectionUtil.put(enumsOrderbySequence, charOption.data().getSequence(), charOption);
    }

    public ICharTypeClazz getCharTypeClazzBean() {
        return this.getType().getCharTypeClazzBean();
    }

    public String getCharAlias() {
        return Optional.ofNullable(this.data().getCharAlias())
                       .orElse(this.data().getCharCode());
    }

    public boolean isRequired() {
        return this.data().getIsRequired() == IsRequiredEnum.YES.getMark();
    }
}
