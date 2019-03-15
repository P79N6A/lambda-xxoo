package com.yatop.lambda.workflow.core.richmodel.workflow.module;

import com.google.common.collect.TreeMultimap;
import com.yatop.lambda.workflow.core.richmodel.IRichModel;
import com.yatop.lambda.workflow.core.utils.CollectionUtil;

import java.util.ArrayList;
import java.util.List;

public class ModulePropertyPage implements IRichModel {

    private TreeMultimap<Integer, ModulePropertyTab> tabs = TreeMultimap.create(); //key=priority
    private ArrayList<ModulePropertyRelation> relations = new ArrayList<ModulePropertyRelation>();

    @Override
    public void clear() {
        CollectionUtil.enhancedClear(tabs);
        CollectionUtil.enhancedClear(relations);
    }

    public int tabCount() {
        return tabs.size();
    }

    public List<ModulePropertyTab> getTabs() {
        return CollectionUtil.toList(tabs);
    }

    public void putTab(ModulePropertyTab tab) {
        CollectionUtil.put(tabs, tab.data().getPriority(), tab);
    }

    public int relationCount() {
        return relations.size();
    }

    public List<ModulePropertyRelation> getRelations() {
        return relations;
    }

    public void addRelation(ModulePropertyRelation relation) {
        CollectionUtil.add(relations, relation);
    }
}
