package com.yatop.lambda.workflow.core.richmodel.workflow.module;

import com.yatop.lambda.base.model.WfModule;
import com.yatop.lambda.workflow.core.richmodel.IRichModel;
import com.yatop.lambda.workflow.core.richmodel.component.Component;

public class Module extends WfModule implements Comparable<Module>, IRichModel {
    private Component component;

    public Module() {}

    public Module(WfModule data) {super.copyProperties(data);}

    @Override
    public int compareTo(Module o) {
        return this.getModuleId() < o.getModuleId() ?  -1 : (this.getModuleId() == o.getModuleId() ? 0 : 1);
    }

    @Override
    public void clear() {
        component = null;
        super.clear();
    }

    public Component getComponent() {
        return component;
    }

    public void setComponent(Component component) {
        this.component = component;
    }
}
