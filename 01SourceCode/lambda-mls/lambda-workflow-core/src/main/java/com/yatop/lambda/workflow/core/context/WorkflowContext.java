package com.yatop.lambda.workflow.core.context;

import com.alibaba.fastjson.JSONObject;
import com.yatop.lambda.workflow.core.richmodel.data.DataWarehouse;
import com.yatop.lambda.workflow.core.richmodel.model.ModelWarehouse;
import com.yatop.lambda.workflow.core.utils.MapUtil;
import com.yatop.lambda.workflow.core.richmodel.experiment.Experiment;
import com.yatop.lambda.workflow.core.richmodel.project.Project;
import com.yatop.lambda.workflow.core.richmodel.workflow.GlobalParameter;
import com.yatop.lambda.workflow.core.richmodel.workflow.Workflow;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.Node;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.NodeLink;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.NodeParameter;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.NodePort;

import java.util.TreeMap;

public class WorkflowContext {

    private Project project;                //操作关联的项目
    private Experiment experiment;          //操作关联的实验
    private Workflow workflow;              //操作关联的工作流
    private TreeMap<Long, DataWarehouse>  dataWarehouses = new TreeMap<Long, DataWarehouse>();   //操作关联的数据仓库
    private TreeMap<Long, ModelWarehouse> modelWarehouses = new TreeMap<Long, ModelWarehouse>();  //操作关联的模型仓库
    private TreeMap<Long, Node> nodes = new TreeMap<Long, Node>();      //操作关联的节点
    private TreeMap<Long, NodeLink> links = new TreeMap<Long, NodeLink>();  //操作关联的节点链接
    private TreeMap<Long, NodeParameter> parameters = new TreeMap<Long, NodeParameter>();  //操作关联的节点参数
    private TreeMap<Long, NodePort> ports = new TreeMap<Long, NodePort>();  //操作关联的节点参数
    private TreeMap<Long, GlobalParameter> globalParameters = new TreeMap<Long, GlobalParameter>();  //操作关联的节点参数

    public WorkflowContext(Project project, Experiment experiment, Workflow workflow) {
        this.project = project;
        this.experiment = experiment;
        this.workflow = workflow;
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

    public DataWarehouse getDataWarehouse(Long id) {
        return dataWarehouses.get(id);
    }

    public ModelWarehouse getModelWarehouse(Long id) {
        return modelWarehouses.get(id);
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

    public void setDataWarehouse(Long id, DataWarehouse warehouse) {
        MapUtil.put(dataWarehouses, id, warehouse);
    }

    public void setModelWarehouse(Long id, ModelWarehouse warehouse) {
        MapUtil.put(modelWarehouses, id, warehouse);
    }

    public void setNode(Long id, Node node) {
        MapUtil.put(nodes, id, node);
    }

    public void setLink(Long id, NodeLink link) {
        MapUtil.put(links, id, link);
    }

    public void setParameter(Long id, NodeParameter parameter) {
        MapUtil.put(parameters, id, parameter);
    }

    public void setPort(Long id, NodePort port) {
        MapUtil.put(ports, id, port);
    }

    public void getGlobalParameter(Long id, GlobalParameter globalParameter) {
        MapUtil.put(globalParameters, id, globalParameter);
    }

    public JSONObject toJSON() {
        return null;
    }

    public void clear() {
        project.clear();
        experiment.clear();
        workflow.clear();

        MapUtil.clear(dataWarehouses);
        MapUtil.clear(modelWarehouses);
        MapUtil.clear(nodes);
        MapUtil.clear(links);
        MapUtil.clear(parameters);
        MapUtil.clear(ports);
        MapUtil.clear(globalParameters);
    }
}
