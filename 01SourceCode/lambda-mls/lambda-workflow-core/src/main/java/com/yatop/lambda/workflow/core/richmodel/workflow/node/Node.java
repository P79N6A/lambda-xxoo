package com.yatop.lambda.workflow.core.richmodel.workflow.node;

import com.yatop.lambda.base.model.WfFlowNode;
import com.yatop.lambda.workflow.core.richmodel.IRichModel;
import com.yatop.lambda.workflow.core.richmodel.workflow.execution.ExecutionTask;
import com.yatop.lambda.workflow.core.richmodel.workflow.module.Module;
import com.yatop.lambda.workflow.core.utils.CollectionUtil;

import java.util.List;
import java.util.TreeMap;

public class Node extends WfFlowNode implements IRichModel {

    private Module module;
    private TreeMap<String, NodeParameter> parameters = new TreeMap<String, NodeParameter>();                //组件参数
    private TreeMap<String, NodeParameter> optimizePrameters = new TreeMap<String, NodeParameter>();         //执行调优参数
    private TreeMap<String, NodePort> inputNodePorts = new TreeMap<String, NodePort>();                 //输入节点端口
    private TreeMap<Integer, NodePort> inputNodePortsOrderBySequence = new TreeMap<Integer, NodePort>(); //输入节点端口按序号排序
    private TreeMap<String, NodePort> outputNodePorts = new TreeMap<String, NodePort>();                //输出节点端口
    private TreeMap<Integer, NodePort> outputNodePortsOrderBySequence = new TreeMap<Integer, NodePort>();//输出节点端口按序号排序

    public Node() {}

    public Node(WfFlowNode data) {super.copyProperties(data);}

    @Override
    public void clear() {
        module = null;
        CollectionUtil.clear(parameters);
        parameters = null;
        CollectionUtil.clear(optimizePrameters);
        optimizePrameters = null;
        inputNodePorts.clear();
        inputNodePorts = null;
        inputNodePortsOrderBySequence.clear();
        inputNodePortsOrderBySequence = null;
        outputNodePorts.clear();
        outputNodePorts = null;
        outputNodePortsOrderBySequence.clear();
        outputNodePortsOrderBySequence = null;
        super.clear();
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    public NodeParameter getParameter(String charId) {
        return CollectionUtil.get(parameters, charId);
    }

    public List<NodeParameter> getParameters() {
        return CollectionUtil.toList(parameters);
    }

    public void putParameter(NodeParameter parameter) {
        CollectionUtil.put(parameters, parameter.getCharId(), parameter);
    }

    public NodeParameter getOptimizeParameter(String charId) {
        return CollectionUtil.get(optimizePrameters, charId);
    }

    public List<NodeParameter> getOptimizeParameters() {
        return CollectionUtil.toList(optimizePrameters);
    }

    public void putOptimizeParameter(NodeParameter parameter) {
        CollectionUtil.put(optimizePrameters, parameter.getCharId(), parameter);
    }

    public NodePort getInputNodePort(String charId) {
        return CollectionUtil.get(inputNodePorts, charId);
    }

    public List<NodePort> getInputNodePorts() {
        return CollectionUtil.toList(inputNodePortsOrderBySequence);
    }

    public void putInputNodePort(NodePort inputNodePort) {
        CollectionUtil.put(inputNodePorts, inputNodePort.getRefCharId(), inputNodePort);
        CollectionUtil.put(inputNodePortsOrderBySequence, inputNodePort.getModulePort().getSequence(), inputNodePort);
    }

    public NodePort getOutputNodePort(String charId) {
        return CollectionUtil.get(outputNodePorts, charId);
    }

    public List<NodePort> getOutputNodePorts() {
        return CollectionUtil.toList(outputNodePortsOrderBySequence);
    }

    public void putOutputNodePort(NodePort outputNodePort) {
        CollectionUtil.put(outputNodePorts, outputNodePort.getRefCharId(), outputNodePort);
        CollectionUtil.put(outputNodePortsOrderBySequence, outputNodePort.getModulePort().getSequence(), outputNodePort);
    }
}
