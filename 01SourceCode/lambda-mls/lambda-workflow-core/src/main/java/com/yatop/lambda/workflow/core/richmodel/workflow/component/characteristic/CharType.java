package com.yatop.lambda.workflow.core.richmodel.workflow.component.characteristic;

import com.yatop.lambda.base.model.WfCfgCharType;
import com.yatop.lambda.workflow.core.framework.chartype.ICharTypeClazz;
import com.yatop.lambda.workflow.core.richmodel.RichModel;
import com.yatop.lambda.workflow.core.utils.ClazzHelperUtil;
import com.yatop.lambda.workflow.core.utils.CollectionUtil;

import java.util.*;

public class CharType extends RichModel<WfCfgCharType> {

    //作为输出端时，所适配的输入端特征类型
    private TreeMap<Integer, CharType> matchTargetTypes = new TreeMap<Integer, CharType>();   //适配特征类型，用于节点连线时的校验

    public CharType(WfCfgCharType data) {
        super(data);
    }

    @Override
    public void clear() {
        CollectionUtil.clear(matchTargetTypes);
        matchTargetTypes = null;
        super.clear();
    }

    public boolean matchTargetType(CharType target) {
        return this.data().getCharTypeId().equals(target.data().getCharTypeId()) || CollectionUtil.containsKey(matchTargetTypes, target.data().getCharTypeId());
    }

    public int matchTargetTypeCount() {
        return matchTargetTypes.size();
    }

    public List<CharType> getMatchTargetTypes() {
        return CollectionUtil.toList(matchTargetTypes);
    }

    public void putMatchTargetType(CharType targetType) {
        CollectionUtil.put(matchTargetTypes, targetType.data().getCharTypeId(), targetType);
    }

    public void replaceMatchTargetTypes(TreeMap<Integer, CharType> expandedTargetCharTypes) {
        matchTargetTypes.clear();
        this.matchTargetTypes = expandedTargetCharTypes;
    }

    public ICharTypeClazz getCharTypeClazzBean() {
        return ClazzHelperUtil.getCharTypeClazzBean(this);
    }
}
