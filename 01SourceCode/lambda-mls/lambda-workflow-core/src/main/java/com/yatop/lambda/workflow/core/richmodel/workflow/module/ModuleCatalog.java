package com.yatop.lambda.workflow.core.richmodel.workflow.module;

import com.google.common.collect.TreeMultimap;
import com.yatop.lambda.base.model.WfModuleCatalog;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.richmodel.IRichModel;
import com.yatop.lambda.workflow.core.utils.MapUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ModuleCatalog extends WfModuleCatalog implements Comparable<ModuleCatalog>, IRichModel {
    private TreeMultimap<Integer, ModuleCatalog> childCatalogs = TreeMultimap.create();
    private TreeMultimap<Integer, Module> childModules = TreeMultimap.create();

    public ModuleCatalog() {}

    public ModuleCatalog(WfModuleCatalog data) {super.copyProperties(data);}

    public List<ModuleCatalog> getChildCatalogs() {
        return MapUtil.toList(childCatalogs);
    }

    public void putChildCatalog(ModuleCatalog catalog) {
        if(DataUtil.isNull(catalog))
            return;
        this.childCatalogs.put(catalog.getSequence(), catalog);
    }

    public List<Module> getChildModules() {
        return MapUtil.toList(childModules);
    }

    public void putChildModule(Module module) {
        if(DataUtil.isNull(module))
            return;
        this.childModules.put(module.getSequence(), module);
    }

    @Override
    public int compareTo(ModuleCatalog o) {
        return this.getCatalogId() < o.getCatalogId() ?  -1 : (this.getCatalogId() == o.getCatalogId() ? 0 : 1);
    }

    @Override
    public void clear() {
        childCatalogs.clear();
        childCatalogs = null;
        childModules.clear();
        childModules = null;
        super.clear();
    }
}
