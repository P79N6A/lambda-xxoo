package com.yatop.lambda.workflow.core.richmodel.workflow.module;

import com.yatop.lambda.base.model.WfModule;
import com.yatop.lambda.workflow.core.richmodel.IRichModel;
import com.yatop.lambda.workflow.core.richmodel.component.Component;
import com.yatop.lambda.workflow.core.utils.CollectionUtil;

import java.util.List;
import java.util.TreeMap;

public class Module extends WfModule implements Comparable<Module>, IRichModel {

    private Component component;
    private TreeMap<Long, ModulePort> inputPorts = new TreeMap<Long, ModulePort>();
    private TreeMap<Integer, ModulePort> inputPortsOrderBySequence = new TreeMap<Integer, ModulePort>();
    private TreeMap<Long, ModulePort> outputPorts = new TreeMap<Long, ModulePort>();
    private TreeMap<Integer, ModulePort> outputPortsOrderBySequence = new TreeMap<Integer, ModulePort>();

    public Module() {}

    public Module(WfModule data) {super.copyProperties(data);}

    @Override
    public int compareTo(Module o) {
        return this.getModuleId() < o.getModuleId() ?  -1 : (this.getModuleId() == o.getModuleId() ? 0 : 1);
    }

    @Override
    public void clear() {
        component = null;
        inputPorts.clear();
        inputPorts = null;
        inputPortsOrderBySequence.clear();
        inputPortsOrderBySequence = null;
        outputPorts.clear();
        outputPorts = null;
        outputPortsOrderBySequence.clear();
        outputPortsOrderBySequence = null;
        super.clear();
    }

    public Component getComponent() {
        return component;
    }

    public void setComponent(Component component) {
        this.component = component;
    }

    public ModulePort getInputPort(Long inputPortId) {
        return CollectionUtil.get(inputPorts, inputPortId);
    }

    public List<ModulePort> getInputPorts() {
        return CollectionUtil.toList(inputPortsOrderBySequence);
    }

    public void setInputPort(ModulePort inputPort) {
        CollectionUtil.put(inputPorts, inputPort.getPortId(), inputPort);
        CollectionUtil.put(inputPortsOrderBySequence, inputPort.getSequence(), inputPort);
    }

    public ModulePort getOutputPort(Long outputPortId) {
        return CollectionUtil.get(outputPorts, outputPortId);
    }

    public List<ModulePort> getOutputPorts() {
        return CollectionUtil.toList(outputPortsOrderBySequence);
    }

    public void setOutputPort(ModulePort outputPort) {
        CollectionUtil.put(outputPorts, outputPort.getPortId(), outputPort);
        CollectionUtil.put(outputPortsOrderBySequence, outputPort.getSequence(), outputPort);
    }
}
