package com.yatop.lambda.workflow.core.richmodel.workflow.node;

import com.yatop.lambda.base.model.WfFlowNode;
import com.yatop.lambda.core.enums.NodeStateEnum;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.mgr.workflow.node.NodeHelper;
import com.yatop.lambda.workflow.core.richmodel.IRichModel;
import com.yatop.lambda.workflow.core.richmodel.component.Component;
import com.yatop.lambda.workflow.core.richmodel.workflow.module.Module;
import com.yatop.lambda.workflow.core.utils.CollectionUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Node extends WfFlowNode implements IRichModel {

    private Module module;
    private TreeMap<String, NodeParameter> parameters = new TreeMap<String, NodeParameter>();   //组件参数，key=charId
    private TreeMap<String, NodeParameter> parametersOrderByCharCode = new TreeMap<String, NodeParameter>();   //组件参数，key=charCode
    private TreeMap<String, NodeParameter> optimizeParameters = new TreeMap<String, NodeParameter>();         //执行调优参数，key=charId
    private TreeMap<String, NodeParameter> optimizeParametersOrderByCharCode = new TreeMap<String, NodeParameter>();         //执行调优参数，key=charCode
    private TreeMap<Long, NodePortInput> inputNodePorts = new TreeMap<Long, NodePortInput>();                 //输入节点端口，key=nodePortId
    private TreeMap<String, NodePortInput> inputNodePortsOrderByCharId = new TreeMap<String, NodePortInput>();                 //输入节点端口，key=charId
    private TreeMap<String, NodePortInput> inputNodePortsOrderByCharCode = new TreeMap<String, NodePortInput>();                 //输入节点端口，key=charCode
    private TreeMap<Integer, NodePortInput> inputNodePortsOrderBySequence = new TreeMap<Integer, NodePortInput>(); //输入节点端口按序号排序
    private TreeMap<Long, NodePortOutput> outputNodePorts = new TreeMap<Long, NodePortOutput>();                //输出节点端口，key=nodePortId
    private TreeMap<String, NodePortOutput> outputNodePortsOrderByCharId = new TreeMap<String, NodePortOutput>();                //输出节点端口，key=charId
    private TreeMap<String, NodePortOutput> outputNodePortsOrderByCharCode = new TreeMap<String, NodePortOutput>();                //输出节点端口，key=charCode
    private TreeMap<Integer, NodePortOutput> outputNodePortsOrderBySequence = new TreeMap<Integer, NodePortOutput>();//输出节点端口按序号排序
  //private TreeMap<String, GlobalParameter> globalParameters = new TreeMap<String, GlobalParameter>();  //操作关联节点参数，key=charId
    private boolean deleted;
    private boolean analyzed;

    public Node(WfFlowNode data, Module module) {
        super.copyProperties(data);
        this.module = module;
        this.deleted = false;
        this.analyzed = false;
        this.clearColoured();
    }

    @Override
    public void clear() {
        module = null;
        CollectionUtil.enhancedClear(parameters);
        CollectionUtil.enhancedClear(optimizeParameters);
        CollectionUtil.enhancedClear(inputNodePorts);
        CollectionUtil.clear(inputNodePortsOrderBySequence);
        CollectionUtil.enhancedClear(outputNodePorts);
        CollectionUtil.clear(outputNodePortsOrderBySequence);
      //CollectionUtil.enhancedClear(globalParameters);
        super.clear();
    }

    public void flush(boolean flushNodeParameter, boolean flushDataPortSchema, String operId) {

        if(!this.isDeleted()) {
            if (flushNodeParameter && this.parameterCount() > 0) {
                for (NodeParameter parameter : this.getParameters()) {
                    parameter.flush(operId);
                }
            }
            if (flushNodeParameter && this.optimizeParameterCount() > 0) {
                for (NodeParameter parameter : this.getOptimizeParameters()) {
                    parameter.flush(operId);
                }
            }
            if (flushDataPortSchema && this.outputPortCount() > 0) {
                for (NodePortOutput outputPort : this.getOutputNodePorts()) {
                    outputPort.flush(operId);
                }
            }
            if (this.isColoured() && this.getNodeId() > 0)
                NodeHelper.updateNode(this, operId);
        }
    }

    public boolean isStateNotReady() {
        return this.getNodeState() == NodeStateEnum.NOT_READY.getState();
    }

    public boolean isStateReady() {
        return this.getNodeState() == NodeStateEnum.READY.getState();
    }

    public boolean isStatePreparing() {
        return this.getNodeState() == NodeStateEnum.PREPARING.getState();
    }

    public boolean isStateRunning() {
        return this.getNodeState() == NodeStateEnum.RUNNING.getState();
    }

    public boolean isStateSuccess() {
        return this.getNodeState() == NodeStateEnum.SUCCESS.getState();
    }

    public boolean isStateError() {
        return this.getNodeState() == NodeStateEnum.ERROR.getState();
    }

    public void changeState2NotReady() {
        this.changeNodeState(NodeStateEnum.NOT_READY);
    }

    public void downgradeState2Ready() {
        if(this.getNodeState() <= NodeStateEnum.READY.getState())
            return;

        this.changeNodeState(NodeStateEnum.READY);
    }

    public void changeState2Ready() {
        this.clearOccuredWarning();
        this.changeNodeState(NodeStateEnum.READY);
    }

    public void changeState2Preparing() {
        this.changeNodeState(NodeStateEnum.PREPARING);
    }

    public void changeState2Running() {
        this.changeNodeState(NodeStateEnum.RUNNING);
    }

    public void changeState2Success() {
        this.changeNodeState(NodeStateEnum.SUCCESS);
    }

    public void changeState2Error() {
        this.changeNodeState(NodeStateEnum.ERROR);
    }

    private void changeNodeState(NodeStateEnum stateEnum) {
        if(this.getNodeState() == stateEnum.getState())
            return;

        this.setNodeState(stateEnum.getState());
    }

    public Module getModule() {
        return module;
    }

    public Component getComponent() {
        return module.getComponent();
    }

    public int inputPortCount() {
        return module.inputPortCount();
    }

    public int outputPortCount() {
        return module.outputPortCount();
    }

    public int parameterCount() {
        return parameters.size();
    }

    public NodeParameter getParameter(String charId) {
        return CollectionUtil.get(parameters, charId);
    }

    public NodeParameter getParameterByCharCode(String charCode) {
        return CollectionUtil.get(parametersOrderByCharCode, charCode);
    }

    public List<NodeParameter> getParameters() {
        return CollectionUtil.toList(parameters);
    }

    public void putParameter(NodeParameter parameter) {
        CollectionUtil.put(parameters, parameter.getCharId(), parameter);
        CollectionUtil.put(parametersOrderByCharCode, parameter.getCmptChar().getCharCode(), parameter);
    }

    public int optimizeParameterCount() {
        return optimizeParameters.size();
    }

    public NodeParameter getOptimizeParameter(String charId) {
        return CollectionUtil.get(optimizeParameters, charId);
    }

    public NodeParameter getOptimizeParameterByCharCode(String charCode) {
        return CollectionUtil.get(optimizeParametersOrderByCharCode, charCode);
    }

    public List<NodeParameter> getOptimizeParameters() {
        return CollectionUtil.toList(optimizeParameters);
    }

    public void putOptimizeParameter(NodeParameter parameter) {
        CollectionUtil.put(optimizeParameters, parameter.getCharId(), parameter);
        CollectionUtil.put(optimizeParametersOrderByCharCode, parameter.getCmptChar().getCharCode(), parameter);
    }

    public NodePortInput getInputNodePort(Long nodePortId) {
        return CollectionUtil.get(inputNodePorts, nodePortId);
    }

    public NodePortInput getInputNodePort(String charId) {
        return CollectionUtil.get(inputNodePortsOrderByCharId, charId);
    }

    public NodePortInput getInputNodePortByCharCode(String charCode) {
        return CollectionUtil.get(inputNodePortsOrderByCharCode, charCode);
    }

    public List<NodePortInput> getInputNodePorts() {
        return CollectionUtil.toList(inputNodePortsOrderBySequence);
    }

    public void putInputNodePort(NodePortInput inputNodePort) {
        CollectionUtil.put(inputNodePorts, inputNodePort.getNodePortId(), inputNodePort);
        CollectionUtil.put(inputNodePortsOrderByCharId, inputNodePort.getRefCharId(), inputNodePort);
        CollectionUtil.put(inputNodePortsOrderByCharCode, inputNodePort.getCmptChar().getCharCode(), inputNodePort);
        CollectionUtil.put(inputNodePortsOrderBySequence, inputNodePort.getModulePort().getSequence(), inputNodePort);
    }

    public NodePortOutput getOutputNodePort(Long nodePortId) {
        return CollectionUtil.get(outputNodePorts, nodePortId);
    }

    public NodePortOutput getOutputNodePort(String charId) {
        return CollectionUtil.get(outputNodePortsOrderByCharId, charId);
    }

    public NodePortOutput getOutputNodePortByCharCode(String charCode) {
        return CollectionUtil.get(outputNodePortsOrderByCharCode, charCode);
    }

    public List<NodePortOutput> getOutputNodePorts() {
        return CollectionUtil.toList(outputNodePortsOrderBySequence);
    }

    public NodeSchema getOutputDataPortSchema(String charId) {
        NodePortOutput outputNodePort = getOutputNodePort(charId);
        return outputNodePort.isDataPort() ? outputNodePort.getSchema() : null;
    }

    public NodeSchema getOutputDataPortSchemaByCharCode(String charCode) {
        NodePortOutput outputNodePort = getOutputNodePortByCharCode(charCode);
        return outputNodePort.isDataPort() ? outputNodePort.getSchema() : null;
    }

    public List<NodeSchema> getOutputDataPortSchemas() {
        List<NodeSchema> nodeSchemas = null;
        if(outputDataPortCount() > 0) {
            nodeSchemas = new ArrayList<NodeSchema>(outputDataPortCount());
            for (NodePortOutput outputNodePort : getOutputNodePorts()) {
                if (outputNodePort.isDataPort()) {
                    nodeSchemas.add(outputNodePort.getSchema());
                }
            }
        }
        return nodeSchemas;
    }

    public void putOutputNodePort(NodePortOutput outputNodePort) {
        CollectionUtil.put(outputNodePorts, outputNodePort.getNodePortId(), outputNodePort);
        CollectionUtil.put(outputNodePortsOrderByCharId, outputNodePort.getRefCharId(), outputNodePort);
        CollectionUtil.put(outputNodePortsOrderByCharCode, outputNodePort.getCmptChar().getCharCode(), outputNodePort);
        CollectionUtil.put(outputNodePortsOrderBySequence, outputNodePort.getModulePort().getSequence(), outputNodePort);
    }
/*

    public int globalParameterCount() {
        return globalParameters.size();
    }

    public GlobalParameter getGlobalParameter(String charId) {
        return globalParameters.get(charId);
    }

    public List<GlobalParameter> getGlobalParameters() {
        return CollectionUtil.toList(globalParameters);
    }

    public void putGlobalParameter(GlobalParameter globalParameter) {
        CollectionUtil.put(globalParameters, globalParameter.getRelCharId(), globalParameter);
    }

    public void removeGlobalParameter(String charId) {
        CollectionUtil.remove(globalParameters, charId);
    }
*/

    public boolean isDeleted() {
        return deleted;
    }

    public void markDeleted() {
        this.deleted = true;
    }

    public boolean isAnalyzed() {
        return analyzed;
    }

    private void markAnalyzed() {
        if(inputPortCount() > 0) {
            for (NodePortInput inputNodePort : this.getInputNodePorts()) {
                inputNodePort.markAnalyzed();
            }
        }
        if(outputPortCount() > 0) {
            for (NodePortOutput outputNodePort : this.getOutputNodePorts()) {
                outputNodePort.markAnalyzed();
            }
        }
        this.analyzed = true;
    }

    public boolean isOccuredWarning() {
        return isStateNotReady();
    }

    public void changeOccuredWarning(String warningMsg) {
        this.setWarningMsg(warningMsg);
        this.changeState2NotReady();
    }

    public void clearOccuredWarning() {
        if(DataUtil.isNotEmpty(this.getWarningMsg()))
            this.setWarningMsg(null);
    }

    public int inputDataPortCount() {
        return module.inputDataPortCount();
    }

    public int outputDataPortCount() {
        return module.outputDataPortCount();
    }
}
