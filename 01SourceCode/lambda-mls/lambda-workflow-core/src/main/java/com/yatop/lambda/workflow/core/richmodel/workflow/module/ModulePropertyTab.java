package com.yatop.lambda.workflow.core.richmodel.workflow.module;

import com.yatop.lambda.base.model.WfCfgModulePropTab;
import com.yatop.lambda.workflow.core.richmodel.RichModel;
import com.yatop.lambda.workflow.core.utils.CollectionUtil;

import java.util.List;
import java.util.TreeMap;

public class ModulePropertyTab extends RichModel<WfCfgModulePropTab> {

    private TreeMap<Integer, ModulePropertyControl> controls = new TreeMap<Integer, ModulePropertyControl>(); //key=Sequence

    public ModulePropertyTab(WfCfgModulePropTab data) {
        super(data);
    }

    @Override
    public void clear() {
        CollectionUtil.enhancedClear(controls);
        super.clear();
    }

    public int controlCount() {
        return controls.size();
    }

    public List<ModulePropertyControl> getControls() {
        return CollectionUtil.toList(controls);
    }

    public void putControl(ModulePropertyControl control) {
        CollectionUtil.put(controls, control.data().getSequence(), control);
    }
}
