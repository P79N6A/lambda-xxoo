package com.yatop.lambda.workflow.core.richmodel.workflow.module;

import com.google.common.collect.TreeMultimap;
import com.yatop.lambda.base.model.WfCfgModuleCatalog;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.richmodel.RichModel;
import com.yatop.lambda.workflow.core.utils.CollectionUtil;

import java.util.List;

public class ModuleCatalog extends RichModel<WfCfgModuleCatalog> implements Comparable<ModuleCatalog> {

    private TreeMultimap<Integer, ModuleCatalog> childCatalogs = TreeMultimap.create();     //下级目录按序号排序
    private TreeMultimap<Integer, Module> childModules = TreeMultimap.create();     //工作流组件按序号排序

    public ModuleCatalog(WfCfgModuleCatalog data) {
        super(data);
    }

    public int childCatalogCount() {
        return childCatalogs.size();
    }

    public List<ModuleCatalog> getChildCatalogs() {
        return CollectionUtil.toList(childCatalogs);
    }

    public void putChildCatalog(ModuleCatalog catalog) {
        CollectionUtil.put(childCatalogs, catalog.data().getSequence(), catalog);
    }

    public int childModuleCount() {
        return childModules.size();
    }

    public List<Module> getChildModules() {
        return CollectionUtil.toList(childModules);
    }

    public void putChildModule(Module module) {
        CollectionUtil.put(childModules, module.data().getSequence(), module);
    }

    @Override
    public int compareTo(ModuleCatalog o) {
        return this.data().getCatalogId().compareTo(o.data().getCatalogId());
    }

    @Override
    public void clear() {
        CollectionUtil.clear(childCatalogs);
        CollectionUtil.clear(childModules);
        super.clear();
    }
}
