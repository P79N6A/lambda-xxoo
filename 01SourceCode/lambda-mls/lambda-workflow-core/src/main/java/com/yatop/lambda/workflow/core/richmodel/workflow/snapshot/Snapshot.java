package com.yatop.lambda.workflow.core.richmodel.workflow.snapshot;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.yatop.lambda.base.model.*;
import com.yatop.lambda.core.enums.LambdaExceptionEnum;
import com.yatop.lambda.core.enums.SnapshotStateEnum;
import com.yatop.lambda.core.exception.LambdaException;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.config.ComponentConfigHelper;
import com.yatop.lambda.workflow.core.config.ModuleConfigHelper;
import com.yatop.lambda.workflow.core.context.WorkflowContext;
import com.yatop.lambda.workflow.core.mgr.workflow.snapshot.SnapshotHelper;
import com.yatop.lambda.workflow.core.richmodel.RichModel;
import com.yatop.lambda.workflow.core.richmodel.experiment.Experiment;
import com.yatop.lambda.workflow.core.richmodel.project.Project;
import com.yatop.lambda.workflow.core.richmodel.workflow.Workflow;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.*;
import com.yatop.lambda.workflow.core.richmodel.workflow.charvalue.CharValue;
import com.yatop.lambda.workflow.core.utils.CollectionUtil;

import java.util.List;
import java.util.TreeMap;

public class Snapshot extends RichModel<WfSnapshot> {

    private static String SNAPSHOT_CONTENT_KEY_PROJECT = "@@@Project";
    private static String SNAPSHOT_CONTENT_KEY_EXPERIMENT = "@@@Experiment";
    private static String SNAPSHOT_CONTENT_KEY_WORKFLOW = "@@@Workflow";
    private static String SNAPSHOT_CONTENT_KEY_NODES = "@@@Nodes";
    private static String SNAPSHOT_CONTENT_KEY_NODE_PARAMETERS = "@@@Parameters";
    private static String SNAPSHOT_CONTENT_KEY_NODE_OPTIMIZE_PARAMETERS = "@@@OptimizeParameters";
    private static String SNAPSHOT_CONTENT_KEY_NODE_PARAMETER_CHAR_VALUE_ATTRIBUTE = "charValue";
    private static String SNAPSHOT_CONTENT_KEY_NODE_INPUT_PORTS = "@@@InputPorts";
    private static String SNAPSHOT_CONTENT_KEY_NODE_OUTPUT_PORTS = "@@@OutputPorts";
    private static String SNAPSHOT_CONTENT_KEY_LINKS = "@@@Links";

    private boolean enableFlushSnapshot;
    private JSONObject project = new JSONObject(true);
    private JSONObject experiment = new JSONObject(true);
    private JSONObject workflow = new JSONObject(true);
    private TreeMap<Long, Node> nodes = new TreeMap<Long, Node>();
    private TreeMap<Long, NodeLink> links = new TreeMap<Long, NodeLink>();

    private Workflow javaObjectWorkflow;

    //用于快照创建
    public static Snapshot BuildSnapshot4Create(WfSnapshot data) {
        Snapshot snapshot = new Snapshot(data, true);
        return snapshot;
    }

    public static Snapshot BuildSnapshot(WfSnapshot data) {
        return BuildSnapshot(data, false);
    }

    public static Snapshot BuildSnapshot(WfSnapshot data, boolean enableFlushSnapshot) {
        Snapshot snapshot = new Snapshot(data, enableFlushSnapshot);
        snapshot.parseSnapshotContent();
        return snapshot;
    }

    private Snapshot(WfSnapshot data) {
        this(data, false);
    }

    private Snapshot(WfSnapshot data, boolean enableFlushSnapshot) {
        super(data);
        this.enableFlushSnapshot = enableFlushSnapshot;
    }

    public void flush(WorkflowContext workflowContext) {

        if(!this.isEnableFlushSnapshot())
            return;

        this.syncSnapshot2WorkflowContext(workflowContext);
        this.flushSnapshotContent();
        SnapshotHelper.updateSnapshot(this, workflowContext.getOperId());
    }

    @Override
    public void clear() {
        project.clear();
        experiment.clear();
        workflow.clear();
        CollectionUtil.clear(nodes);
        CollectionUtil.clear(links);
        javaObjectWorkflow = null;
        super.clear();
    }

    public void syncSnapshot2WorkflowContext(WorkflowContext workflowContext) {

        /*if(javaObjectWorkflow != workflowContext.getWorkflow())\
            return;*/

        if(this.nodeCount() > 0) {
            for(Node node : this.getNodes()) {
                workflowContext.putNode(node);

                if(node.inputNodePortCount() > 0) {
                    for(NodeInputPort inputPort : node.getInputNodePorts()) {
                        workflowContext.putInputPort(inputPort);
                    }
                }

                if(node.outputNodePortCount() > 0) {
                    for(NodeOutputPort outputPort : node.getOutputNodePorts()) {
                        workflowContext.putOutputPort(outputPort);
                    }
                }
            }

            if(this.linkCount() > 0) {
                for(NodeLink link : this.getLinks()) {
                    workflowContext.putLink(link);
                }
            }
        }
    }

    public void syncWorkflowContext2Snapshot(WorkflowContext workflowContext) {
        this.project = workflowContext.getProject().toJSON();
        this.experiment = workflowContext.getExperiment().toJSON();
        this.workflow = workflowContext.getWorkflow().toJSON();
        this.javaObjectWorkflow = workflowContext.getWorkflow();

        if(workflowContext.nodeCount() > 0) {
            for(Node node : workflowContext.getNodes()) {
                if(!CollectionUtil.containsKey(nodes, node.data().getNodeId())) {
                    this.putNode(node);
                }
            }

            if(workflowContext.linkCount() > 0) {
                for(NodeLink link : workflowContext.getLinks()) {
                    if(!CollectionUtil.containsKey(links, link.data().getLinkId())) {
                        this.putLink(link);
                    }
                }
            }
        }
    }

    public void flushSnapshotContent() {
        JSONObject jsonContent = new JSONObject(8, true);
        JSONArray jsonNodes = new JSONArray();
        JSONArray jsonLinks = new JSONArray();

        if(nodeCount() > 0) {
            for(Node node : getNodes()) {
                JSONObject jsonNode = node.toJSON();
                JSONArray jsonParameters = new JSONArray();
                JSONArray jsonOptimizeParameters = new JSONArray();
                JSONArray jsonInputPorts = new JSONArray();
                JSONArray jsonOutputPorts = new JSONArray();

                if(node.parameterCount() > 0) {
                    for(NodeParameter parameter : node.getParameters()) {
                        JSONObject jsonParameter = parameter.toJSON();
                        if(parameter.getCharValue().isJsonType() || parameter.getCharValue().isScriptType())
                            jsonParameter.put(SNAPSHOT_CONTENT_KEY_NODE_PARAMETER_CHAR_VALUE_ATTRIBUTE, parameter.getCharValue().getTextValue());

                        jsonParameters.add(jsonParameter);
                    }
                }

                if(node.optimizeParameterCount() > 0) {
                    for(NodeParameter parameter : node.getOptimizeParameters()) {
                        JSONObject jsonParameter = parameter.toJSON();
                        if(parameter.getCharValue().isJsonType() || parameter.getCharValue().isScriptType())
                            jsonParameter.put(SNAPSHOT_CONTENT_KEY_NODE_PARAMETER_CHAR_VALUE_ATTRIBUTE, parameter.getCharValue().getTextValue());

                        jsonOptimizeParameters.add(jsonParameter);
                    }
                }

                if(node.inputNodePortCount() > 0) {
                    for(NodeInputPort inputPort : node.getInputNodePorts()) {
                        JSONObject jsonInputPort = inputPort.toJSON();
                        jsonInputPorts.add(jsonInputPort);
                    }
                }

                if(node.outputNodePortCount() > 0) {
                    for(NodeOutputPort outputPort : node.getOutputNodePorts()) {
                        JSONObject jsonOutputPort = outputPort.toJSON();
                        jsonOutputPorts.add(jsonOutputPort);
                    }
                }

                jsonNode.put(SNAPSHOT_CONTENT_KEY_NODE_PARAMETERS, jsonParameters);
                jsonNode.put(SNAPSHOT_CONTENT_KEY_NODE_OPTIMIZE_PARAMETERS, jsonOptimizeParameters);
                jsonNode.put(SNAPSHOT_CONTENT_KEY_NODE_INPUT_PORTS, jsonInputPorts);
                jsonNode.put(SNAPSHOT_CONTENT_KEY_NODE_OUTPUT_PORTS, jsonOutputPorts);
                jsonNodes.add(jsonNode);
            }

            if(linkCount() > 0) {
                for(NodeLink link : getLinks()) {
                    JSONObject jsonLink = link.toJSON();
                    jsonLinks.add(jsonLink);
                }
            }
        }

        jsonContent.put(SNAPSHOT_CONTENT_KEY_PROJECT, project);
        jsonContent.put(SNAPSHOT_CONTENT_KEY_EXPERIMENT, experiment);
        jsonContent.put(SNAPSHOT_CONTENT_KEY_WORKFLOW, workflow);
        jsonContent.put(SNAPSHOT_CONTENT_KEY_NODES, jsonNodes);
        jsonContent.put(SNAPSHOT_CONTENT_KEY_LINKS, jsonLinks);
        this.data().setSnapshotContent(DataUtil.toPrettyJSONString(jsonContent));

        jsonContent.clear();
    }

    private void parseSnapshotContent() {

        if(DataUtil.isEmpty(this.data().getSnapshotContent())) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Parse snapshot content failed -- empty content error.", "快照内容为空", this.data());
        }

        try {
            JSONObject jsonContent = JSONObject.parseObject(this.data().getSnapshotContent(), Feature.OrderedField);
            this.project = jsonContent.getJSONObject(SNAPSHOT_CONTENT_KEY_PROJECT);
            this.experiment = jsonContent.getJSONObject(SNAPSHOT_CONTENT_KEY_EXPERIMENT);
            this.workflow = jsonContent.getJSONObject(SNAPSHOT_CONTENT_KEY_WORKFLOW);
            this.javaObjectWorkflow = new Workflow(workflow.toJavaObject(WfFlow.class), new Experiment(experiment.toJavaObject(EmExperiment.class), new Project(project.toJavaObject(PrProject.class))));
            JSONArray jsonNodes = jsonContent.getJSONArray(SNAPSHOT_CONTENT_KEY_NODES);
            JSONArray jsonLinks = jsonContent.getJSONArray(SNAPSHOT_CONTENT_KEY_LINKS);

            if(!jsonNodes.isEmpty()) {
                for (int idx = 0; idx < jsonNodes.size(); idx++) {
                    JSONObject jsonNode = jsonNodes.getJSONObject(idx);
                    JSONArray jsonParameters = jsonNode.getJSONArray(SNAPSHOT_CONTENT_KEY_NODE_PARAMETERS);
                    JSONArray jsonOptimizeParameters = jsonNode.getJSONArray(SNAPSHOT_CONTENT_KEY_NODE_OPTIMIZE_PARAMETERS);
                    JSONArray jsonInputPorts = jsonNode.getJSONArray(SNAPSHOT_CONTENT_KEY_NODE_INPUT_PORTS);
                    JSONArray jsonOutputPorts = jsonNode.getJSONArray(SNAPSHOT_CONTENT_KEY_NODE_OUTPUT_PORTS);
                    jsonNode.remove(SNAPSHOT_CONTENT_KEY_NODE_PARAMETERS);
                    jsonNode.remove(SNAPSHOT_CONTENT_KEY_NODE_OPTIMIZE_PARAMETERS);
                    jsonNode.remove(SNAPSHOT_CONTENT_KEY_NODE_INPUT_PORTS);
                    jsonNode.remove(SNAPSHOT_CONTENT_KEY_NODE_OUTPUT_PORTS);

                    WfFlowNode wfFlowNode = jsonNode.toJavaObject(WfFlowNode.class);
                    Node node = new Node(wfFlowNode, ModuleConfigHelper.getModule(wfFlowNode.getRefModuleId()));
                    if(!jsonParameters.isEmpty()) {
                        for (int i = 0; i < jsonParameters.size(); i++) {
                            WfFlowNodeParameter wfFlowNodeParameter = jsonParameters.getJSONObject(i).toJavaObject(WfFlowNodeParameter.class);
                            CharValue charValue = new CharValue(ComponentConfigHelper.getCharacteristic(wfFlowNodeParameter.getCharId()));
                            if(charValue.isJsonType() || charValue.isScriptType()) {
                                charValue.setTextValue(wfFlowNodeParameter.getCharValue());
                                wfFlowNodeParameter.setCharValue(null);
                            } else {
                                charValue.setCharValue(wfFlowNodeParameter.getCharValue());
                            }
                            NodeParameter parameter = new NodeParameter(wfFlowNodeParameter, charValue);
                            node.putParameter(parameter);
                        }
                    }
                    if(!jsonOptimizeParameters.isEmpty()) {
                        for (int i = 0; i < jsonOptimizeParameters.size(); i++) {
                            WfFlowNodeParameter wfFlowNodeParameter = jsonOptimizeParameters.getJSONObject(i).toJavaObject(WfFlowNodeParameter.class);
                            CharValue charValue = new CharValue(ComponentConfigHelper.getCharacteristic(wfFlowNodeParameter.getCharId()));
                            if(charValue.isJsonType() || charValue.isScriptType()) {
                                charValue.setTextValue(wfFlowNodeParameter.getCharValue());
                                wfFlowNodeParameter.setCharValue(null);
                            } else {
                                charValue.setCharValue(wfFlowNodeParameter.getCharValue());
                            }
                            NodeParameter parameter = new NodeParameter(wfFlowNodeParameter, charValue);
                            node.putOptimizeParameter(parameter);
                        }
                    }
                    if(!jsonInputPorts.isEmpty()) {
                        for (int i = 0; i < jsonInputPorts.size(); i++) {
                            WfFlowNodePort wfFlowNodePort = jsonInputPorts.getJSONObject(i).toJavaObject(WfFlowNodePort.class);
                            NodeInputPort inputPort = new NodeInputPort(wfFlowNodePort, ModuleConfigHelper.getModulePort(wfFlowNodePort.getRefPortId()));
                            node.putInputNodePort(inputPort);
                        }
                    }
                    if(!jsonOutputPorts.isEmpty()) {
                        for (int i = 0; i < jsonOutputPorts.size(); i++) {
                            WfFlowNodePort wfFlowNodePort = jsonOutputPorts.getJSONObject(i).toJavaObject(WfFlowNodePort.class);
                            NodeOutputPort outputPort = new NodeOutputPort(wfFlowNodePort, ModuleConfigHelper.getModulePort(wfFlowNodePort.getRefPortId()));
                            node.putOutputNodePort(outputPort);
                        }
                    }

                    this.putNode(node);
                }

                if(!jsonLinks.isEmpty()) {
                    for (int i = 0; i < jsonLinks.size(); i++) {
                        WfFlowNodeLink wfFlowNodeLink = jsonLinks.getJSONObject(i).toJavaObject(WfFlowNodeLink.class);
                        NodeLink link = new NodeLink(wfFlowNodeLink);
                        this.putLink(link);
                    }
                }
            }

            jsonContent.clear();
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Parse snapshot content failed -- snapshot content error.", "快照内容错误", e, this.data());
        }
    }

    public boolean isEnableFlushSnapshot() {
        return enableFlushSnapshot;
    }

    public Workflow getWorkflow() {
        return javaObjectWorkflow;
    }

    public int nodeCount() {
        return nodes.size();
    }

    public List<Node> getNodes() {
        return CollectionUtil.toList(nodes);
    }

    public Node getNode(Long nodeId) {
        return CollectionUtil.get(nodes, nodeId);
    }

    public void putNode(Node node) {
        CollectionUtil.put(nodes, node.data().getNodeId(), node);
    }

    public int linkCount() {
        return links.size();
    }

    public List<NodeLink> getLinks() {
        return CollectionUtil.toList(links);
    }

    public NodeLink getLink(Long linkId) {
        return CollectionUtil.get(links, linkId);
    }

    public void putLink(NodeLink link) {
        CollectionUtil.put(links, link.data().getLinkId(), link);
    }

    public void changeState2Finished() {
        this.changeSnapshotState(SnapshotStateEnum.FINISHED);
    }

    private void changeSnapshotState(SnapshotStateEnum snapshotState) {
        if(this.data().getSnapshotState() == snapshotState.getState())
            return;

        this.data().setSnapshotState(snapshotState.getState());
    }
}
