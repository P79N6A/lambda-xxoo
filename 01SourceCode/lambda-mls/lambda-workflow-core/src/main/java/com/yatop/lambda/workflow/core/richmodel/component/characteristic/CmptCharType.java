package com.yatop.lambda.workflow.core.richmodel.component.characteristic;

import com.yatop.lambda.base.model.CfCmptCharType;
import com.yatop.lambda.workflow.core.richmodel.IRichModel;
import com.yatop.lambda.workflow.core.utils.CollectionUtil;

import java.util.*;

public class CmptCharType extends CfCmptCharType implements IRichModel {

    private TreeSet<Integer> matchTypes = new TreeSet<Integer>();   //适配特征类型，用于节点连线时的校验

    public CmptCharType(CfCmptCharType data) {
        super.copyProperties(data);
        this.clearColoured();
    }

    @Override
    public void clear() {
        matchTypes.clear();
        matchTypes = null;
        super.clear();
    }

    public boolean isMatchType(Integer charTypeId) {
        return CollectionUtil.contains(matchTypes, charTypeId);
    }

    public int matchTypeCount() {
        return matchTypes.size();
    }

    public List<Integer> getMatchTypes() {
        return CollectionUtil.toList(matchTypes);
    }

    public void addMatchType(Integer charTypeId) {
        CollectionUtil.add(matchTypes, charTypeId);
    }
}
