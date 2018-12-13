package com.yatop.lambda.workflow.core.context;

import com.alibaba.fastjson.JSONObject;
import com.yatop.lambda.workflow.core.model.experiment.Experiment;
import com.yatop.lambda.workflow.core.model.project.Project;
import com.yatop.lambda.workflow.core.model.workflow.GlobalParameter;
import com.yatop.lambda.workflow.core.model.workflow.Workflow;
import com.yatop.lambda.workflow.core.model.workflow.node.Node;
import com.yatop.lambda.workflow.core.model.workflow.node.NodeLink;
import com.yatop.lambda.workflow.core.model.workflow.node.NodeParameter;
import com.yatop.lambda.workflow.core.model.workflow.node.NodePort;
import com.yatop.lambda.workflow.core.utils.MapUtils;

import java.util.TreeMap;

public class WorkflowContext {

    private Project project;                //操作关联的项目
    private Experiment experiment;          //操作关联的实验
    private Workflow workflow;              //操作关联的工作流
    private TreeMap<Long, Node> nodes;      //操作关联的节点
    private TreeMap<Long, NodeLink> links;  //操作关联的节点链接
    private TreeMap<Long, NodeParameter> parameters;  //操作关联的节点参数
    private TreeMap<Long, NodePort> ports;  //操作关联的节点参数
    private TreeMap<Long, GlobalParameter> globalParameters;  //操作关联的节点参数
    private MapUtils mapUtils = new MapUtils();

    public WorkflowContext(Project project, Experiment experiment, Workflow workflow) {
        this.project = project;
        this.experiment = experiment;
        this.workflow = workflow;
        this.nodes = new TreeMap<Long, Node>();
        this.links = new TreeMap<Long, NodeLink>();
        this.parameters = new TreeMap<Long, NodeParameter>();
        this.ports = new TreeMap<Long, NodePort>();
        this.globalParameters = new TreeMap<Long, GlobalParameter>();
    }

    public Project getProject() {
        return project;
    }

    public Experiment getExperiment() {
        return experiment;
    }

    public Workflow getWorkflow() {
        return workflow;
    }

    public Node getNode(Long id) {
        return nodes.get(id);
    }

    public NodeLink getLink(Long id) {
        return links.get(id);
    }

    public NodeParameter getParameter(Long id) {
        return parameters.get(id);
    }

    public NodePort getPort(Long id) {
        return ports.get(id);
    }

    public GlobalParameter getGlobalParameter(Long id) {
        return globalParameters.get(id);
    }

    public void setNode(Long id, Node node) {
        mapUtils.put(nodes, id, node);
    }

    public void setLink(Long id, NodeLink link) {
        links.put(id, link);
    }

    public void setParameter(Long id, NodeParameter parameter) {
        mapUtils.put(parameters, id, parameter);
    }

    public void setPort(Long id, NodePort port) {
        mapUtils.put(ports, id, port);
    }

    public void getGlobalParameter(Long id, GlobalParameter globalParameter) {
        mapUtils.put(globalParameters, id, globalParameter);
    }

    public JSONObject toJSON() {
        return null;
    }

    public void clear() {
        project.clear();
        experiment.clear();
        workflow.clear();
        mapUtils.clear(nodes);
        mapUtils.clear(links);
        mapUtils.clear(parameters);
        mapUtils.clear(ports);
        mapUtils.clear(globalParameters);
    }
}
