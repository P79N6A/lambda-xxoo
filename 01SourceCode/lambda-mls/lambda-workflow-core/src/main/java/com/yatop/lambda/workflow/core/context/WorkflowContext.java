package com.yatop.lambda.workflow.core.context;

import com.yatop.lambda.core.enums.IsWebLinkEnum;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.richmodel.data.DataWarehouse;
import com.yatop.lambda.workflow.core.richmodel.model.ModelWarehouse;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.NodeSchema;
import com.yatop.lambda.workflow.core.utils.CollectionUtil;
import com.yatop.lambda.workflow.core.richmodel.project.Project;
import com.yatop.lambda.workflow.core.richmodel.workflow.GlobalParameter;
import com.yatop.lambda.workflow.core.richmodel.workflow.Workflow;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.Node;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.NodeLink;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.NodePort;

import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

public class WorkflowContext implements IWorkContext {

    private boolean isNoWorkflow;           //是否为无工作流（无关联实验和工作流，但有一个节点的特殊情况，比如用于对数据文件导入的包装）
    private Project project;                //操作关联项目
    private Workflow workflow;              //操作关联工作流
    private TreeMap<Long, DataWarehouse>  dataWarehouses = new TreeMap<Long, DataWarehouse>();   //操作关联数据仓库，key=dwId
    private TreeMap<Long, ModelWarehouse> modelWarehouses = new TreeMap<Long, ModelWarehouse>();  //操作关联模型仓库，key=mwId
    private TreeMap<Long, Node> nodes = new TreeMap<Long, Node>();      //操作关联节点，key=nodeId
    private TreeMap<Long, NodeLink> links = new TreeMap<Long, NodeLink>();  //操作关联节点链接，key=linkId
    private TreeMap<Long, TreeSet<NodeLink>> inLinks = new TreeMap<Long, TreeSet<NodeLink>>();  //操作关联节点链接，key=dstPortId
    private TreeMap<Long, TreeSet<NodeLink>> outLinks = new TreeMap<Long, TreeSet<NodeLink>>();  //操作关联节点链接，key=srcPortId
    private TreeMap<Long, NodePort> ports = new TreeMap<Long, NodePort>();  //操作关联节点端口，key=portId
    private TreeMap<Long, NodeSchema> schemas = new TreeMap<Long, NodeSchema>();  //操作关联节点端口，key=portId
    private TreeMap<Long, GlobalParameter> globalParameters = new TreeMap<Long, GlobalParameter>();  //操作关联节点参数，key=globalParameterId
    private String operId;

    public WorkflowContext(Project project, Workflow workflow, String operId) {
        this.project = project;
        this.workflow = workflow;
        this.operId = operId;
        this.isNoWorkflow = false;
    }

    public WorkflowContext(Project project, String operId) {
        this.project = project;
        this.operId = operId;
        this.isNoWorkflow = true;
    }

    public boolean isNoWorkflow() {
        return isNoWorkflow;
    }

    public Project getProject() {
        return project;
    }

    public Workflow getWorkflow() {
        return workflow;
    }

    public DataWarehouse getDataWarehouse(Long dataWarehouseId) {
        return dataWarehouses.get(dataWarehouseId);
    }

    public List<DataWarehouse> getDataWarehouses() {
        return CollectionUtil.toList(dataWarehouses);
    }

    public ModelWarehouse getModelWarehouse(Long modelWarehouseId) {
        return modelWarehouses.get(modelWarehouseId);
    }

    public List<ModelWarehouse> getModelWarehouses() {
        return CollectionUtil.toList(modelWarehouses);
    }

    public Node getNode(Long nodeId) {
        return nodes.get(nodeId);
    }

    public List<Node> getNodes() {
        return CollectionUtil.toList(nodes);
    }

    public NodeLink getLink(Long linkId) {
        return links.get(linkId);
    }

    public List<NodeLink> getInLinks(Long dstPortId) {
        return CollectionUtil.toList(inLinks.get(dstPortId));
    }

    public NodeLink getNonWebInLink(Long dstPortId) {
        List<NodeLink> linkList = this.getInLinks(dstPortId);
        if(DataUtil.isNotNull(linkList)) {
            for (NodeLink link : linkList) {
                if (link.getIsWebLink() == IsWebLinkEnum.NO.getMark()) {
                    return link;
                }
            }
        }
        return null;
    }

    public List<NodeLink> getOutLinks(Long srcPortId) {
        return CollectionUtil.toList(outLinks.get(srcPortId));
    }

    public List<NodeLink> getLinks() {
        return CollectionUtil.toList(links);
    }

    public NodePort getPort(Long portId) {
        return ports.get(portId);
    }

    public List<NodePort> getPorts() {
        return CollectionUtil.toList(ports);
    }

    public NodeSchema getSchema(Long schemaId) {
        return schemas.get(schemaId);
    }

    public List<NodeSchema> getSchemas() {
        return CollectionUtil.toList(schemas);
    }

    public GlobalParameter getGlobalParameter(Long globalParameterId) {
        return globalParameters.get(globalParameterId);
    }

    public List<GlobalParameter> getGlobalParameters() {
        return CollectionUtil.toList(globalParameters);
    }

    public void putDataWarehouse(DataWarehouse warehouse) {
        CollectionUtil.put(dataWarehouses, warehouse.getDwId(), warehouse);
    }

    public void putModelWarehouse(ModelWarehouse warehouse) {
        CollectionUtil.put(modelWarehouses, warehouse.getMwId(), warehouse);
    }

    public void putNode(Node node) {
        CollectionUtil.put(nodes, node.getNodeId(), node);
    }

    public void putLink(NodeLink link) {
        CollectionUtil.put(links, link.getLinkId(), link);

        {
            TreeSet<NodeLink> inLinkSet = CollectionUtil.get(inLinks, link.getLinkId());
            if (DataUtil.isNotNull(inLinkSet))
                CollectionUtil.add(inLinkSet, link);
            else {
                inLinkSet = new TreeSet<NodeLink>();
                CollectionUtil.add(inLinkSet, link);
                CollectionUtil.put(inLinks, link.getDstPortId(), inLinkSet);
            }
        }

        {
            TreeSet<NodeLink> outLinkSet = CollectionUtil.get(outLinks, link.getLinkId());
            if (DataUtil.isNotNull(outLinkSet))
                CollectionUtil.add(outLinkSet, link);
            else {
                outLinkSet = new TreeSet<NodeLink>();
                CollectionUtil.add(outLinkSet, link);
                CollectionUtil.put(outLinks, link.getSrcPortId(), outLinkSet);
            }
        }
    }

    public void putPort(NodePort port) {
        CollectionUtil.put(ports, port.getNodePortId(), port);
    }

    public void putSchema(NodeSchema schema) {
        CollectionUtil.put(schemas, schema.getNodePortId(), schema);
    }

    public void putGlobalParameter(GlobalParameter globalParameter) {
        CollectionUtil.put(globalParameters, globalParameter.getGlobalParamId(), globalParameter);
    }

    public String getOperId() {
        return operId;
    }

    @Override
    public void clear() {
        project.clear();
        workflow.clear();

        CollectionUtil.clear(dataWarehouses);
        CollectionUtil.clear(modelWarehouses);
        CollectionUtil.clear(nodes);
        CollectionUtil.clear(links);
        CollectionUtil.clear(ports);
        CollectionUtil.clear(schemas);
        CollectionUtil.clear(globalParameters);
    }
}
