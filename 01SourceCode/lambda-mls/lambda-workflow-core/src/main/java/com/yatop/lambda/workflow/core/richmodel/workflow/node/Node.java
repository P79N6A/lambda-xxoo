package com.yatop.lambda.workflow.core.richmodel.workflow.node;

import com.yatop.lambda.base.model.WfFlowNode;
import com.yatop.lambda.core.enums.NodeStateEnum;
import com.yatop.lambda.core.enums.SpecTypeEnum;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.framework.module.IModuleClazz;
import com.yatop.lambda.workflow.core.mgr.workflow.analyzer.SchemaAnalyzerHelper;
import com.yatop.lambda.workflow.core.mgr.workflow.node.NodeHelper;
import com.yatop.lambda.workflow.core.richmodel.RichModel;
import com.yatop.lambda.workflow.core.richmodel.workflow.component.Component;
import com.yatop.lambda.workflow.core.richmodel.workflow.component.characteristic.CmptChar;
import com.yatop.lambda.workflow.core.richmodel.workflow.module.Module;
import com.yatop.lambda.workflow.core.richmodel.workflow.charvalue.CharValue;
import com.yatop.lambda.workflow.core.richmodel.workflow.module.ModulePropertyPage;
import com.yatop.lambda.workflow.core.utils.CollectionUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Node extends RichModel<WfFlowNode> implements Comparable<Node> {

    private Module module;
    private TreeMap<String, NodeParameter> parameters = new TreeMap<String, NodeParameter>();   //组件参数，key=charId
    private TreeMap<String, NodeParameter> parametersOrderByCharCode = new TreeMap<String, NodeParameter>();   //组件参数，key=charCode
    private TreeMap<String, NodeParameter> optimizeParameters = new TreeMap<String, NodeParameter>();         //执行调优参数，key=charId
    private TreeMap<String, NodeParameter> optimizeParametersOrderByCharCode = new TreeMap<String, NodeParameter>();         //执行调优参数，key=charCode
    private TreeMap<Long, NodeInputPort> inputNodePorts = new TreeMap<Long, NodeInputPort>();                 //输入节点端口，key=nodePortId
    private TreeMap<String, NodeInputPort> inputNodePortsOrderByCharId = new TreeMap<String, NodeInputPort>();                 //输入节点端口，key=charId
    private TreeMap<String, NodeInputPort> inputNodePortsOrderByCharCode = new TreeMap<String, NodeInputPort>();                 //输入节点端口，key=charCode
    private TreeMap<Integer, NodeInputPort> inputNodePortsOrderBySequence = new TreeMap<Integer, NodeInputPort>(); //输入节点端口按序号排序
    private TreeMap<Long, NodeOutputPort> outputNodePorts = new TreeMap<Long, NodeOutputPort>();                //输出节点端口，key=nodePortId
    private TreeMap<String, NodeOutputPort> outputNodePortsOrderByCharId = new TreeMap<String, NodeOutputPort>();                //输出节点端口，key=charId
    private TreeMap<String, NodeOutputPort> outputNodePortsOrderByCharCode = new TreeMap<String, NodeOutputPort>();                //输出节点端口，key=charCode
    private TreeMap<Integer, NodeOutputPort> outputNodePortsOrderBySequence = new TreeMap<Integer, NodeOutputPort>();//输出节点端口按序号排序

    private TreeMap<String, NodeOutput> outputs = new TreeMap<String, NodeOutput>(); //节点输出，key=charId
    private TreeMap<String, NodeOutput> outputsOrderByCharCode = new TreeMap<String, NodeOutput>(); //节点输出，key=charCode

    private int indegree;
    private boolean deleted;
    private boolean analyzed;

    public Node(WfFlowNode data, Module module) {
        super(data);
        this.module = module;
        this.deleted = false;
        this.analyzed = false;
    }

    @Override
    public int compareTo(Node o) {
        return this.data().getNodeId().compareTo(o.data().getNodeId());
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
        super.clear();
    }

    public void flush(boolean flushNodeParameter, String operId) {

        if(!this.isDeleted()) {
            if(flushNodeParameter) {
                if (this.parameterCount() > 0) {
                    for (NodeParameter parameter : this.getParameters()) {
                        parameter.flush(operId);
                    }
                }
                if (this.optimizeParameterCount() > 0) {
                    for (NodeParameter parameter : this.getOptimizeParameters()) {
                        parameter.flush(operId);
                    }
                }
                if (!this.isTailNode()) {
                    for (NodeOutputPort outputPort : this.getOutputNodePorts()) {
                        outputPort.flush(operId);
                    }
                }
            }

            if(this.outputs.size() > 0) {
                for (NodeOutput output : this.getOutputs()) {
                    output.flush(operId);
                }
            }

            if (this.isColoured() && this.data().getNodeId() > 0)
                NodeHelper.updateNode(this, operId);
        }
    }

    public boolean isStateNotReady() {
        return this.data().getNodeState() == NodeStateEnum.NOT_READY.getState();
    }

    public boolean isStateReady() {
        return this.data().getNodeState() == NodeStateEnum.READY.getState();
    }

    public boolean isStatePreparing() {
        return this.data().getNodeState() == NodeStateEnum.PREPARING.getState();
    }

    public boolean isStateRunning() {
        return this.data().getNodeState() == NodeStateEnum.RUNNING.getState();
    }

    public boolean isStateSuccess() {
        return this.data().getNodeState() == NodeStateEnum.SUCCESS.getState();
    }

    public boolean isStateError() {
        return this.data().getNodeState() == NodeStateEnum.ERROR.getState();
    }

    public void changeState2NotReady() {
        this.changeNodeState(NodeStateEnum.NOT_READY);
    }

    public void downgradeState2Ready() {
        if(this.data().getNodeState() <= NodeStateEnum.READY.getState())
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
        if(this.data().getNodeState() == stateEnum.getState())
            return;

        this.data().setNodeState(stateEnum.getState());
    }

    public Module getModule() {
        return module;
    }

    public Component getComponent() {
        return module.getComponent();
    }

    public int parameterCount() {
        return parameters.size();
    }

    public NodeParameter getParameter(String charId) {
        return CollectionUtil.get(parameters, charId);
    }

    public NodeParameter getParameter(CmptChar cmptChar) {
        return getParameter(cmptChar.data().getCharId());
    }

    public NodeParameter getParameterByCharCode(String charCode) {
        return CollectionUtil.get(parametersOrderByCharCode, charCode);
    }

    public List<NodeParameter> getParameters() {
        return CollectionUtil.toList(parameters);
    }

    public CharValue getParameterCharValue(CmptChar cmptChar) {
        return getParameter(cmptChar.data().getCharId()).getCharValue();
    }

    public List<CharValue> getParameterCharValues() {
        if(parameterCount() == 0)
            return null;

        List<CharValue> charValues = new ArrayList<CharValue>();
        for(NodeParameter parameter : getParameters()) {
            charValues.add(parameter.getCharValue());
        }
        return charValues;
    }

    public void putParameter(NodeParameter parameter) {
        CollectionUtil.put(parameters, parameter.data().getCharId(), parameter);
        CollectionUtil.put(parametersOrderByCharCode, parameter.getCmptChar().data().getCharCode(), parameter);
    }

    public int optimizeParameterCount() {
        return optimizeParameters.size();
    }

    public NodeParameter getOptimizeParameter(String charId) {
        return CollectionUtil.get(optimizeParameters, charId);
    }

    public NodeParameter getOptimizeParameter(CmptChar cmptChar) {
        return getOptimizeParameter(cmptChar.data().getCharId());
    }

    public NodeParameter getOptimizeParameterByCharCode(String charCode) {
        return CollectionUtil.get(optimizeParametersOrderByCharCode, charCode);
    }

    public List<NodeParameter> getOptimizeParameters() {
        return CollectionUtil.toList(optimizeParameters);
    }

    public CharValue getOptimizeParameterCharValue(CmptChar cmptChar) {
        return getOptimizeParameter(cmptChar.data().getCharId()).getCharValue();
    }

    public List<CharValue> getOptimizeParameterCharValues() {
        if(parameterCount() == 0)
            return null;

        List<CharValue> charValues = new ArrayList<CharValue>();
        for(NodeParameter parameter : getOptimizeParameters()) {
            charValues.add(parameter.getCharValue());
        }
        return charValues;
    }

    public void putOptimizeParameter(NodeParameter parameter) {
        CollectionUtil.put(optimizeParameters, parameter.data().getCharId(), parameter);
        CollectionUtil.put(optimizeParametersOrderByCharCode, parameter.getCmptChar().data().getCharCode(), parameter);
    }

    public NodeParameter searchParameterByCode(String paramCode) {
        CmptChar cmptChar = this.module.searchParameterByCode(paramCode);

        if(DataUtil.isNull(cmptChar))
            return null;

        switch (SpecTypeEnum.valueOf(cmptChar.data().getSpecType())) {
            case PARAMETER:
                return getParameter(cmptChar);
            case OPTIMIZE_EXECUTION:
                return getOptimizeParameter(cmptChar);
            default:
                return null;
        }
    }

    public int inputPortCount() {
        return module.inputPortCount();
    }

    public boolean isHeadNode() {
        return module.isHeadNode();
    }

    public boolean isTailNode() {
        return module.isTailNode();
    }

    public boolean haveOutputDataTablePort() {
        return module.outputDataTablePortCount() > 0;
    }

    public int inputNodePortCount() {
        return inputNodePorts.size();
    }

    public NodeInputPort getInputNodePort(Long nodePortId) {
        return CollectionUtil.get(inputNodePorts, nodePortId);
    }

    public NodeInputPort getInputNodePort(String charId) {
        return CollectionUtil.get(inputNodePortsOrderByCharId, charId);
    }

    public NodeInputPort getInputNodePortByCharCode(String charCode) {
        return CollectionUtil.get(inputNodePortsOrderByCharCode, charCode);
    }

    public NodeInputPort getInputNodePortBySequence(Integer sequence) {
        return CollectionUtil.get(inputNodePortsOrderBySequence, sequence);
    }

    public List<NodeInputPort> getInputNodePorts() {
        return CollectionUtil.toList(inputNodePortsOrderBySequence);
    }

    public void putInputNodePort(NodeInputPort inputNodePort) {
        CollectionUtil.put(inputNodePorts, inputNodePort.data().getNodePortId(), inputNodePort);
        CollectionUtil.put(inputNodePortsOrderByCharId, inputNodePort.data().getRefCharId(), inputNodePort);
        CollectionUtil.put(inputNodePortsOrderByCharCode, inputNodePort.getCmptChar().data().getCharCode(), inputNodePort);
        CollectionUtil.put(inputNodePortsOrderBySequence, inputNodePort.getModulePort().data().getSequence(), inputNodePort);
    }

    public int inputDataTablePortCount() {
        return module.inputDataTablePortCount();
    }

    public List<NodeInputPort> getInputDataTablePorts() {
        List<NodeInputPort> dataPorts = null;
        if(inputDataTablePortCount() > 0) {
            dataPorts = new ArrayList<NodeInputPort>();
            for (NodeInputPort inputNodePort : getInputNodePorts()) {
                if (inputNodePort.isDataTablePort()) {
                    dataPorts.add(inputNodePort);
                }
            }
        }
        return dataPorts;
    }

    public int outputPortCount() {
        return module.outputPortCount();
    }

    public int outputNodePortCount() {
        return outputNodePorts.size();
    }

    public NodeOutputPort getOutputNodePort(Long nodePortId) {
        return CollectionUtil.get(outputNodePorts, nodePortId);
    }

    public NodeOutputPort getOutputNodePort(String charId) {
        return CollectionUtil.get(outputNodePortsOrderByCharId, charId);
    }

    public NodeOutputPort getOutputNodePortByCharCode(String charCode) {
        return CollectionUtil.get(outputNodePortsOrderByCharCode, charCode);
    }

    public NodeOutputPort getOutputNodePortBySequence(Integer sequence) {
        return CollectionUtil.get(outputNodePortsOrderBySequence, sequence);
    }

    public List<NodeOutputPort> getOutputNodePorts() {
        return CollectionUtil.toList(outputNodePortsOrderBySequence);
    }

    public void putOutputNodePort(NodeOutputPort outputNodePort) {
        CollectionUtil.put(outputNodePorts, outputNodePort.data().getNodePortId(), outputNodePort);
        CollectionUtil.put(outputNodePortsOrderByCharId, outputNodePort.data().getRefCharId(), outputNodePort);
        CollectionUtil.put(outputNodePortsOrderByCharCode, outputNodePort.getCmptChar().data().getCharCode(), outputNodePort);
        CollectionUtil.put(outputNodePortsOrderBySequence, outputNodePort.getModulePort().data().getSequence(), outputNodePort);
    }

    public int outputDataTablePortCount() {
        return module.outputDataTablePortCount();
    }

    public List<NodeOutputPort> getOutputDataTablePorts() {
        List<NodeOutputPort> dataPorts = null;
        if(outputDataTablePortCount() > 0) {
            dataPorts = new ArrayList<NodeOutputPort>();
            for (NodeOutputPort outputNodePort : getOutputNodePorts()) {
                if (outputNodePort.isDataTablePort()) {
                    dataPorts.add(outputNodePort);
                }
            }
        }
        return dataPorts;
    }

    public NodeSchema getOutputDataTablePortSchema(String charId) {

        if(isDeleted())
            return null;

        NodeOutputPort outputNodePort = getOutputNodePort(charId);
        return outputNodePort.isDataTablePort() ? outputNodePort.getSchema() : null;
    }

    public NodeSchema getOutputDataTablePortSchemaByCharCode(String charCode) {
        if(isDeleted())
            return null;

        NodeOutputPort outputNodePort = getOutputNodePortByCharCode(charCode);
        return outputNodePort.isDataTablePort() ? outputNodePort.getSchema() : null;
    }

    public List<NodeSchema> getOutputDataTablePortSchemas() {
        if(isDeleted())
            return null;

        List<NodeSchema> nodeSchemas = null;
        if(outputDataTablePortCount() > 0) {
            nodeSchemas = new ArrayList<NodeSchema>(outputDataTablePortCount());
            for (NodeOutputPort outputNodePort : getOutputNodePorts()) {
                if (outputNodePort.isDataTablePort()) {
                    CollectionUtil.add(nodeSchemas, outputNodePort.getSchema());
                }
            }
        }
        return nodeSchemas;
    }

    private void loadOutputAndResources() {

        if(outputs.isEmpty() && getComponent().haveOutputContent()) {
            this.getModuleClazzBean().exploreOutputAndResource(this);
        }
    }

    public int outputCount() {
        loadOutputAndResources();
        return outputs.size();
    }

    public List<NodeOutput> getOutputs() {
        loadOutputAndResources();
        return CollectionUtil.toList(outputs);
    }

    public NodeOutput getutput(String charId) {
        loadOutputAndResources();
        return CollectionUtil.get(outputs, charId);
    }

    public NodeOutput getOutputByCode(String charCode) {
        loadOutputAndResources();
        return CollectionUtil.get(outputs, charCode);
    }

    public void putOutput(NodeOutput nodeOutput) {
        CollectionUtil.put(outputs, nodeOutput.data().getCharId(), nodeOutput);
        CollectionUtil.put(outputsOrderByCharCode, nodeOutput.getCmptChar().data().getCharCode(), nodeOutput);
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void markDeleted() {
        this.deleted = true;

        if (!this.isHeadNode()) {
            for (NodeInputPort inputPort : this.getInputNodePorts()) {
                inputPort.markDeleted();
            }
        }

        if (!this.isTailNode()) {
            for (NodeOutputPort outputPort : this.getOutputNodePorts()) {
                outputPort.markDeleted();
            }
        }
    }

    public boolean isAnalyzed() {
        return analyzed;
    }

    public void markAnalyzed() {
        /*if(!this.isHeadNode()) {
            for (NodeInputPort inputNodePort : this.getInputNodePorts()) {
                inputNodePort.markAnalyzed();
            }
        }*/
        if(!this.isTailNode()) {
            for (NodeOutputPort outputNodePort : this.getOutputNodePorts()) {
                outputNodePort.markAnalyzed();
            }
        }
        this.analyzed = true;
    }

    public boolean isSupportAnalyze() {
        return SchemaAnalyzerHelper.supportAnalyzeSchema(this);
    }

    //用于analyzer在分析过程中判断节点是否需要分析输出数据端口的schema
    public boolean needAnalyzeSchema() {
        return !this.isDeleted() && !this.isAnalyzed() && this.haveOutputDataTablePort();
    }

    public void changeSchemas2Empty() {
        List<NodeSchema> dataPortSchemas = this.getOutputDataTablePortSchemas();
        if (DataUtil.isNotEmpty(dataPortSchemas)) {
            for (NodeSchema nodeSchema : dataPortSchemas)
                nodeSchema.changeState2Empty();
        }
    }

    public void changeSchemas2NotSupport() {
        List<NodeSchema> dataPortSchemas = this.getOutputDataTablePortSchemas();
        if (DataUtil.isNotEmpty(dataPortSchemas)) {
            for (NodeSchema nodeSchema : dataPortSchemas)
                nodeSchema.changeState2NotSupport();
        }
    }

    public boolean isOccuredWarning() {
        return isStateNotReady();
    }

    public void changeOccuredWarning(String warningMsg) {
        this.data().setWarningMsg(warningMsg);
        this.changeState2NotReady();
    }

    public void clearOccuredWarning() {
        if(DataUtil.isNotEmpty(this.data().getWarningMsg()))
            this.data().setWarningMsg(null);
    }

    public int getIndegree() {
        return indegree;
    }

    public void setIndegree(int indegree) {
        this.indegree = indegree;
    }

    public int decreaseIndegree() {
        return --this.indegree;
    }

    public IModuleClazz getModuleClazzBean() {
        return this.getModule().getModuleClazzBean();
    }

    public ModulePropertyPage getPropertyPage() {
        return getModule().getPropertyPage();
    }

    public List<NodeParameter> getPropertyParameters() {
        List<NodeParameter> propertyParameters = new ArrayList<>(parameterCount() + optimizeParameterCount());
        if(parameterCount() > 0)
            propertyParameters.addAll(getParameters());
        if(optimizeParameterCount() > 0)
            propertyParameters.addAll(getOptimizeParameters());
        return propertyParameters;
    }
}
