package com.yatop.lambda.workflow.core.context;

import com.yatop.lambda.core.enums.*;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.mgr.warehouse.DataWarehouseHelper;
import com.yatop.lambda.workflow.core.mgr.warehouse.ModelWarehouseHelper;
import com.yatop.lambda.workflow.core.mgr.workflow.analyzer.SchemaAnalyzer;
import com.yatop.lambda.workflow.core.mgr.workflow.analyzer.SchemaAnalyzerHelper;
import com.yatop.lambda.workflow.core.mgr.workflow.module.AnalyzeNodeStateHelper;
import com.yatop.lambda.workflow.core.mgr.workflow.snapshot.SnapshotHelper;
import com.yatop.lambda.workflow.core.richmodel.component.characteristic.CmptChar;
import com.yatop.lambda.workflow.core.richmodel.data.table.DataWarehouse;
import com.yatop.lambda.workflow.core.richmodel.data.model.ModelWarehouse;
import com.yatop.lambda.workflow.core.richmodel.experiment.Experiment;
import com.yatop.lambda.workflow.core.richmodel.experiment.ExperimentTemplate;
import com.yatop.lambda.workflow.core.richmodel.workflow.execution.ExecutionJob;
import com.yatop.lambda.workflow.core.richmodel.workflow.execution.ExecutionTask;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.*;
import com.yatop.lambda.workflow.core.richmodel.workflow.snapshot.Snapshot;
import com.yatop.lambda.workflow.core.utils.CollectionUtil;
import com.yatop.lambda.workflow.core.richmodel.project.Project;
import com.yatop.lambda.workflow.core.richmodel.workflow.Workflow;

import java.util.*;

public class WorkflowContext implements IWorkContext {

    private boolean lazyLoadMode;           //标识是否为懒加载模式，否则视为节点和链接的相关信息都已经一次性读取到上下文中
    private boolean executionWorkMode;      //标识是否为运行工作模式
    private boolean enableFlushWorkflow;    //控制是否可执行flush更新工作流相关信息
    private boolean loadNodeParameter;      //控制是否查询带出节点参数信息
    private AnalyzeTypeEnum schemaAnalyze;  //触发的schema分析类型
    private Workflow workflow;              //操作关联工作流
    private TreeMap<Long, Node> nodes = new TreeMap<Long, Node>();      //操作关联节点，key=nodeId
    private TreeMap<Long, NodeLink> links = new TreeMap<Long, NodeLink>();  //操作关联节点链接，key=linkId
    private TreeMap<Long, NodeLink> inputLinks = new TreeMap<Long, NodeLink>();  //操作关联节点链接，key=dstPortId
    private TreeMap<Long, TreeSet<NodeLink>> outputLinks = new TreeMap<Long, TreeSet<NodeLink>>();  //操作关联节点链接，key=srcPortId
    private TreeMap<Long, NodeInputPort> inputPorts = new TreeMap<Long, NodeInputPort>();  //操作关联节点输入端口，key=nodePortId
    private TreeMap<Long, NodeOutputPort> outputPorts = new TreeMap<Long, NodeOutputPort>();  //操作关联节点输出端口，key=nodePortId

    private TreeMap<Long, DataWarehouse>  dataWarehouses = new TreeMap<Long, DataWarehouse>();   //操作关联数据仓库，key=dwId
    private TreeMap<String, DataWarehouse> dataWarehousesOrderByCode = new TreeMap<String, DataWarehouse>();   //操作关联数据仓库，key=dwName
    private TreeMap<Long, ModelWarehouse> modelWarehouses = new TreeMap<Long, ModelWarehouse>();  //操作关联模型仓库，key=mwId

    private ExecutionJob currentJob;        //操作关联的当前运行作业
    private TreeMap<Long, ExecutionTask> tasks = new TreeMap<Long, ExecutionTask>();    //操作关联运行任务

    private TreeMap<Long, Node> deleteNodes = new TreeMap<Long, Node>();      //删除节点，key=nodeId
    private TreeMap<Long, NodeLink> deleteLinks = new TreeMap<Long, NodeLink>();  //删除节点链接，key=linkId

    private TreeMap<Long, Node> addNodes = new TreeMap<Long, Node>();      //删除节点，key=nodeId
    private TreeMap<Long, NodeLink> addLinks = new TreeMap<Long, NodeLink>();  //删除节点链接，key=linkId

    private Deque<Node> analyzeNodes = new LinkedList<Node>();      //待分析节点，key=nodeId
    private Deque<NodeLink> analyzeLinks = new LinkedList<NodeLink>();  //待分析节点链接，key=linkId
    private String operId;

    //工作流创建使用（无需加载）
    public static WorkflowContext BuildWorkflowContext4Create(Workflow workflow, String operId) {
        WorkflowContext context = new WorkflowContext(workflow, operId);
        return context;
    }

    //工作流编辑使用（懒加载）
    public static WorkflowContext BuildWorkflowContext4Lazyload(Workflow workflow, String operId) {
        return BuildWorkflowContext4Lazyload(workflow, operId, true);
    }

    public static WorkflowContext BuildWorkflowContext4Lazyload(Workflow workflow, String operId, boolean loadNodeParameter) {
        WorkflowContext context = new WorkflowContext(workflow, operId);
        context.lazyLoadMode = true;
        context.loadNodeParameter = loadNodeParameter;
        return context;
    }

    //工作流编辑使用（预加载）
    public static WorkflowContext BuildWorkflowContext4Preload(Workflow workflow, String operId) {
        return BuildWorkflowContext4Preload(workflow, operId, true);
    }

    public static WorkflowContext BuildWorkflowContext4Preload(Workflow workflow, String operId, boolean loadNodeParameter) {
        WorkflowContext context = new WorkflowContext(workflow, operId);
        context.lazyLoadMode = false;
        context.loadNodeParameter = loadNodeParameter;
        context.preloadWorkflowContent();
        return context;
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////

    //工作流快照查看使用
    public static WorkflowContext BuildWorkflowContext4ViewSnapshot(Snapshot snapshot, String operId) {
        WorkflowContext context = new WorkflowContext(snapshot.getWorkflow(), operId);
        context.initializeWithSnapshot(snapshot);
        return context;
    }

    //实验模版查看使用
    public static WorkflowContext BuildWorkflowContext4ViewTemplate(ExperimentTemplate template, String operId) {
        return BuildWorkflowContext4ViewSnapshot(SnapshotHelper.simulateSnapshot4Template(template), operId);
    }

    //作业运行调度使用
    public static WorkflowContext BuildWorkflowContext4ExecutionSchedule(ExecutionJob job, String operId) {
        WorkflowContext context = BuildWorkflowContext4ViewSnapshot(job.getSnapshot(), operId);
        context.initializeWithExecution(job);
        return context;
    }

    private WorkflowContext(Workflow workflow, String operId) {
        this.workflow = workflow;
        this.operId = operId;
        this.schemaAnalyze = AnalyzeTypeEnum.NONE;

        this.lazyLoadMode = false;
        this.executionWorkMode = false;
        this.enableFlushWorkflow = true;
        this.loadNodeParameter = true;
    }

    private void preloadWorkflowContent() {
        WorkflowContextHelper.loadAllNodes(this);
        WorkflowContextHelper.loadAllLinks(this);

        //if(WorkflowContextHelper.existDirectedCyclicGraph(this)) {
        //    throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Workflow context error -- Workflow exists directed cyclic graph.", "工作流数据异常，请联系管理员");
        //}
    }

    private void initializeWithSnapshot(Snapshot snapshot) {
        this.enableFlushWorkflow = false;
        this.loadNodeParameter = false;
        snapshot.syncSnapshot2WorkflowContext(this);
    }

    private void initializeWithExecution(ExecutionJob currentJob) {
        this.executionWorkMode = true;
        this.enableFlushWorkflow = currentJob.enableFlushWorkflow();
        this.currentJob = currentJob;
        currentJob.parseJobContent(this);

        /*if(!currentJob.enableFlushSnapshot()) {
            //TODO Clear [workflow & Node]'s execution information by job type
            //TODO loadAllTasks and set [workflow state & last job id] & [node state & last task id]
            //离线调度和在线调度，重置为ready，lastTaskId置为null，同时加载所有作业下的task做syncTaskState2Node
        } else{
            //工作台运行和数据文件导入，正常情况不需要重置，仅create job时根据对分析结果的作业节点做重置syncTaskState2Node
            //TODO Nothing
        }*/
    }

    @Override
    public void clear() {
        clear(false, false);
    }

    public void clearSkipNodes() {
        clear(true, false);
    }

    public void clearSkipNodeLinks() {
        clear(false, true);
    }

    public void clearSkipNodesAndNodeLinks() {
        clear(true, true);
    }

    private void clear(boolean excludeNode, boolean excludeNodeLink) {
        workflow.clear();
        workflow = null;
        operId = null;

        if(excludeNode) {
            CollectionUtil.clear(nodes);
        } else {
            CollectionUtil.enhancedClear(nodes);
        }

        if(excludeNodeLink) {
            CollectionUtil.clear(links);
        } else {
            CollectionUtil.enhancedClear(links);
        }

        CollectionUtil.clear(inputLinks);
        CollectionUtil.clear(outputLinks);
        CollectionUtil.clear(inputPorts);
        CollectionUtil.clear(outputPorts);

        CollectionUtil.enhancedClear(dataWarehouses);
        CollectionUtil.clear(dataWarehousesOrderByCode);
        CollectionUtil.enhancedClear(modelWarehouses);

        if(DataUtil.isNotNull(currentJob)) {
            currentJob.clear();
            currentJob = null;
        }

        CollectionUtil.enhancedClear(tasks);

        CollectionUtil.clear(deleteNodes);
        CollectionUtil.clear(deleteLinks);

        CollectionUtil.clear(addNodes);
        CollectionUtil.clear(addLinks);

        CollectionUtil.clear(analyzeNodes);
        CollectionUtil.clear(analyzeLinks);
    }

    public void flush() {
        if(this.workflow.isDeleted())
            return;

        if(this.isEnableFlushWorkflow() && this.workflow.data().getFlowId() > 0) {

            if (loadNodeParameter && !isAnalyzeWithNone()) {
                SchemaAnalyzer.dealAnalyzeSchema(this);
                this.markAnalyzeWithNone();
            }

            if (this.nodeCount() > 0) {
                for (Node node : this.getNodes()) {
                    node.flush(this.isLoadNodeParameter(), this.getOperId());
                }
            }
            this.workflow.flush(this.getOperId());
        }

        if(this.isExecutionWorkMode()) {
            /*if(tasks.size() > 0) {
                for(ExecutionTask task : CollectionUtil.toList(tasks)) {
                    if(task.data().getOwnerJobId().equals(currentJob.data().getJobId()))
                        task.flush(this.getOperId());
                }
            }*/
            this.getCurrentJob().flush(this);
        }
    }

    /*
     *
     * Editor Transaction Done Section
     *
     */

    public void doneCreateNode(Node node) {
        node.downgradeState2Ready();
        this.putNode(node);
        this.putAddNode(node);
        this.workflow.changeState2Draft();
        this.markAnalyzeWithCreateNode(node);
        AnalyzeNodeStateHelper.analyzeInputPortAndParameter(this, node, true);
    }

    public void doneCreateLink(NodeLink link) {
        this.putLink(link);
        this.putAddLink(link);
        this.workflow.changeState2Draft();
        this.markAnalyzeWithCreateLink(link);
        AnalyzeNodeStateHelper.analyzeInputPortAndParameter(this, this.fetchDownstreamNode(link));
    }

    public void doneUpdateNodeParameter(Node node, NodeParameter parameter) {
        node.downgradeState2Ready();
        this.workflow.changeState2Draft();
        if(parameter.getCmptChar().data().getSpecType() == SpecTypeEnum.PARAMETER.getType()) {
            this.markAnalyzeWithUpdateNodeParameter(node, parameter);
        }
        AnalyzeNodeStateHelper.analyzeInputPortAndParameter(this, node);
    }

    public void doneDeleteNode(Node node) {
        node.markDeleted();
        this.putDeleteNode(node);
        this.workflow.changeState2Draft();
        this.markAnalyzeWithDeleteNode(node);

        //TreeMap<Long, List<Node>> downstreamNodes = this.fetchDownstreamNodes(node);
        TreeMap<Long, List<Node>> downstreamNodes = this.getDownstreamNodes(node);
        if(DataUtil.isNotEmpty(downstreamNodes)) {
            for (List<Node> chainList : CollectionUtil.toList(downstreamNodes)) {
                for(Node downstreamNode : chainList) {
                    AnalyzeNodeStateHelper.analyzeInputPortAndParameter(this, downstreamNode);
                }
            }
        }
    }

    public void doneRecoverNode(Node node) {
        this.doneCreateNode(node);
    }

    public void doneDeleteLink(NodeLink link) {
        link.markDeleted();
        this.putDeleteLink(link);
        this.workflow.changeState2Draft();
        this.markAnalyzeWithDeleteLink(link);
        AnalyzeNodeStateHelper.analyzeInputPortAndParameter(this, this.fetchDownstreamNode(link));
    }

    /*
     *
     * Schema Analyze Section
     *
     */

    public AnalyzeTypeEnum getAnalyzeType() {
        return schemaAnalyze;
    }

    public boolean isAnalyzeWithNone() {
        return this.schemaAnalyze.getType() == AnalyzeTypeEnum.NONE.getType();
    }

    public boolean isAnalyzeWithCreateNode() {
        return this.schemaAnalyze.getType() == AnalyzeTypeEnum.CREATE_NODE.getType();
    }

    public boolean isAnalyzeWithCreateLink() {
        return this.schemaAnalyze.getType() == AnalyzeTypeEnum.CREATE_LINK.getType();
    }

    public boolean isAnalyzeWithUpdateNodeParameter() {
        return this.schemaAnalyze.getType() == AnalyzeTypeEnum.UPDATE_NODE_PARAMETER.getType();
    }

    public boolean isAnalyzeWithDeleteNode() {
        return this.schemaAnalyze.getType() == AnalyzeTypeEnum.DELETE_NODE.getType();
    }

    public boolean isAnalyzeWithDeleteLink() {
        return this.schemaAnalyze.getType() == AnalyzeTypeEnum.DELETE_LINK.getType();
    }

    public boolean isAnalyzeWithRefreshSchema() {
        return this.schemaAnalyze.getType() == AnalyzeTypeEnum.REFRESH_WORKFLOW.getType();
    }

    private void markAnalyzeWithNone() {
        this.schemaAnalyze = AnalyzeTypeEnum.NONE;
    }

    private void markAnalyzeWithCreateNode(Node node) {
        //TODO 对于异常情况是否抛出错误
        if(this.isAnalyzeWithNone() || this.isAnalyzeWithCreateNode()) {
            if(SchemaAnalyzerHelper.needAnalyzeNode(node)) {
                this.schemaAnalyze = AnalyzeTypeEnum.CREATE_NODE;
                this.pushAnalyzeNode(node);
            }
        }
    }

    private void markAnalyzeWithCreateLink(NodeLink link) {
        //TODO 对于异常情况是否抛出错误
        if(this.isAnalyzeWithNone()) {
            this.schemaAnalyze = AnalyzeTypeEnum.CREATE_LINK;
            this.pushAnalyzeLink(link);
        }
    }

    private void markAnalyzeWithUpdateNodeParameter(Node node, NodeParameter parameter) {
        //TODO 对于异常情况是否抛出错误
        if(this.isAnalyzeWithNone()) {
            if(SchemaAnalyzerHelper.needAnalyzeNode(node, parameter)) {
                this.schemaAnalyze = AnalyzeTypeEnum.UPDATE_NODE_PARAMETER;
                this.pushAnalyzeNode(node);
            }
        }
    }

    private void markAnalyzeWithDeleteNode(Node node) {
        //TODO 对于异常情况是否抛出错误
        if(this.isAnalyzeWithNone() || this.isAnalyzeWithDeleteNode() || this.isAnalyzeWithDeleteLink()) {
            if(SchemaAnalyzerHelper.needAnalyzeNode(node)) {
                this.schemaAnalyze = AnalyzeTypeEnum.DELETE_NODE;
                this.pushAnalyzeNode(node);
            }
        }
    }

    private void markAnalyzeWithDeleteLink(NodeLink link) {
        //TODO 对于异常情况是否抛出错误
        if(this.isAnalyzeWithNone() || this.isAnalyzeWithDeleteLink()) {
            this.schemaAnalyze = AnalyzeTypeEnum.DELETE_LINK;
            this.pushAnalyzeLink(link);
        }
    }

    public void markAnalyzeWithRefreshWorkflow() {
        //TODO 对于异常情况是否抛出错误
        if(this.isAnalyzeWithNone())
            this.schemaAnalyze = AnalyzeTypeEnum.REFRESH_WORKFLOW;
    }

    /*
     *
     * Common Section
     *
     */

    public boolean isLazyLoadMode() {
        return lazyLoadMode;
    }

    public boolean isExecutionWorkMode() {
        return executionWorkMode;
    }

    public boolean isEnableFlushWorkflow() {
        return enableFlushWorkflow;
    }

    public boolean isLoadNodeParameter() {
        return loadNodeParameter;
    }

    public Project getProject() {
        return getWorkflow().getProject();
    }

    public Experiment getExperiment() {
        return getWorkflow().getExperiment();
    }

    public Workflow getWorkflow() {
        return workflow;
    }

    public DataWarehouse getDataWarehouse() {
        return getDataWarehouse(getProject().data().getDwId());
    }

    public ModelWarehouse getModelWarehouse() {
        return getModelWarehouse(getProject().data().getMwId());
    }

    public DataWarehouse getDataWarehouse(Long dataWarehouseId) {
        DataWarehouse dataWarehouse = CollectionUtil.get(dataWarehouses, dataWarehouseId);
        if(DataUtil.isNull(dataWarehouse)) {
            dataWarehouse = DataWarehouseHelper.queryDataWarehouse(dataWarehouseId);
            this.putDataWarehouse(dataWarehouse);
        }
        return dataWarehouse;
    }

    public DataWarehouse getDataWarehouse(String dataWarehouseCode) {
        DataWarehouse dataWarehouse = CollectionUtil.get(dataWarehousesOrderByCode, dataWarehouseCode);
        if(DataUtil.isNull(dataWarehouse)) {
            dataWarehouse = DataWarehouseHelper.queryDataWarehouse(dataWarehouseCode);
            this.putDataWarehouse(dataWarehouse);
        }
        return dataWarehouse;
    }

    public List<DataWarehouse> getDataWarehouses() {
        return CollectionUtil.toList(dataWarehouses);
    }

    public ModelWarehouse getModelWarehouse(Long modelWarehouseId) {
        ModelWarehouse modelWarehouse = CollectionUtil.get(modelWarehouses, modelWarehouseId);
        if(DataUtil.isNull(modelWarehouse)) {
            modelWarehouse = ModelWarehouseHelper.queryModelWarehouse(modelWarehouseId);
            this.putModelWarehouse(modelWarehouse);
        }
        return modelWarehouse;
    }

    public List<ModelWarehouse> getModelWarehouses() {
        return CollectionUtil.toList(modelWarehouses);
    }

    public ExecutionJob getCurrentJob() {
        /*if(DataUtil.isNull(currentJob)){
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Workflow context error -- Missing current execution job.", "系统内部发生错误");
        }*/

        return currentJob;
    }

    public ExecutionTask getExecutionTask(Node node) {
        if(DataUtil.isNull(node.data().getLastTaskId()))
            return null;

        ExecutionTask task = CollectionUtil.get(tasks, node.data().getLastTaskId());
        if(DataUtil.isNull(task)) {
            //TODO query task
            //task = xxx
            this.putExecutionTask(task);
        }
        return task;
    }

    public String getOperId() {
        return operId;
    }

    /*
    *
    * Node Section
    *
    */

    public int nodeCount() {
        return nodes.size();
    }

    public List<Node> getNodes() {
        return CollectionUtil.toList(nodes);
    }

    public Node getNode(Long nodeId) {
        return CollectionUtil.get(nodes, nodeId);
    }

    public Node getUpstreamNode(NodeLink nodeLink) {
        return getNode(nodeLink.data().getSrcNodeId());
    }

    public Node getDownstreamNode(NodeLink nodeLink) {
        return getNode(nodeLink.data().getDstNodeId());
    }

    //key:inputNodePortId
    public TreeMap<Long, List<Node>> getUpstreamNodes(Node node) {
        if(node.isHeadNode())
            return null;

        List<NodeLink> inLinks = this.getInLinks(node);
        if(DataUtil.isNotEmpty(inLinks)) {
            TreeMap<Long, List<Node>> upstreamNodes = new TreeMap<Long, List<Node>>();
            for(NodeLink nodeLink : inLinks) {
                Node upstreamNode = this.getUpstreamNode(nodeLink);
                CollectionUtil.put4ChainMap(upstreamNodes, nodeLink.data().getDstPortId(), upstreamNode);
            }
            return upstreamNodes;
        }
        return null;
    }

    //key:outputNodePortId
    public TreeMap<Long, List<Node>> getDownstreamNodes(Node node) {
        if(node.isTailNode())
            return null;

        List<NodeLink> outLinks = this.getOutLinks(node);
        if(DataUtil.isNotEmpty(outLinks)) {
            TreeMap<Long, List<Node>> downstreamNodes = new TreeMap<Long, List<Node>>();
            for(NodeLink nodeLink : outLinks) {
                Node downstreamNode = this.getDownstreamNode(nodeLink);
                CollectionUtil.put4ChainMap(downstreamNodes, nodeLink.data().getSrcPortId(), downstreamNode);
            }
            return downstreamNodes;
        }
        return null;
    }

    public Node fetchNode(Long nodeId) {
        WorkflowContextHelper.loadOneNode(this, nodeId);
        return getNode(nodeId);
    }

    public Node fetchUpstreamNode(NodeLink nodeLink) {
        return fetchNode(nodeLink.data().getSrcNodeId());
    }

    public Node fetchDownstreamNode(NodeLink nodeLink) {
        return fetchNode(nodeLink.data().getDstNodeId());
    }

    //key:inputNodePortId
    public TreeMap<Long, List<Node>> fetchUpstreamNodes(Node node) {
        WorkflowContextHelper.loadUpstreamNodes(this, node);
        return getUpstreamNodes(node);
    }

    //key:outputNodePortId
    public TreeMap<Long, List<Node>> fetchDownstreamNodes(Node node) {
        WorkflowContextHelper.loadDownstreamNodes(this, node);
        return getDownstreamNodes(node);
    }

    public Node fetchUpstreamNode(NodeInputPort intputNodePort) {
        NodeLink inLink = this.fetchInLink(intputNodePort);
        if(DataUtil.isNotNull(inLink)) {
            return this.fetchUpstreamNode(inLink);
        }
        return null;
    }

    public List<Node> fetchDownstreamNodes(NodeOutputPort outputNodePort) {
        List<NodeLink> outLinks = this.fetchOutLinks(outputNodePort);
        if(DataUtil.isNotEmpty(outLinks)) {
            List<Node> downstreamNodes = new LinkedList<Node>();
            for(NodeLink nodeLink : outLinks) {
                CollectionUtil.add(downstreamNodes, this.fetchDownstreamNode(nodeLink));
            }
            return downstreamNodes;
        }
        return null;
    }

    /*
     *
     * Link Section
     *
     */

    public int linkCount() {
        return links.size();
    }

    public List<NodeLink> getLinks() {
        return CollectionUtil.toList(links);
    }

    public NodeLink getLink(Long linkId) {
        return CollectionUtil.get(links, linkId);
    }

    public NodeLink getInLink(Long dstPortId) {
        return CollectionUtil.get(inputLinks, dstPortId);
    }

    public NodeLink getInLink(NodeInputPort inputNodePort) {
        return this.getInLink(inputNodePort.data().getNodePortId());
    }

    public List<NodeLink> getInLinks(Node node) {
        if(!node.isHeadNode()) {
            List<NodeLink> inLinks = new ArrayList<NodeLink>();
            for (NodeInputPort inputNodePort : node.getInputNodePorts()) {
                NodeLink nodeLink = this.getInLink(inputNodePort);
                if(DataUtil.isNotNull(nodeLink)) {
                    inLinks.add(nodeLink);
                }
            }
            return DataUtil.isNotEmpty(inLinks) ? inLinks : null;
        }
        return null;
    }

    public List<NodeLink> getOutLinks(Long srcPortId) {
        return CollectionUtil.toList(outputLinks.get(srcPortId));
    }

    public List<NodeLink> getOutLinks(NodeOutputPort outputNodePort) {
        return this.getOutLinks(outputNodePort.data().getNodePortId());
    }

    public List<NodeLink> getOutLinks(Node node) {
        if(!node.isTailNode()) {
            List<NodeLink> outLinks = new ArrayList<NodeLink>();
            for (NodeOutputPort outputNodePort : node.getOutputNodePorts()) {
                List<NodeLink> nodeLinks = this.getOutLinks(outputNodePort);
                if(DataUtil.isNotEmpty(nodeLinks)) {
                    for(NodeLink nodeLink : nodeLinks)
                        outLinks.add(nodeLink);
                }
            }
            return DataUtil.isNotEmpty(outLinks) ? outLinks : null;
        }
        return null;
    }

    public NodeLink fetchLink(Long linkId) {
        WorkflowContextHelper.loadOneLink(this, linkId);
        return getLink(linkId);
    }

    public NodeLink fetchInLink(Long dstPortId) {
        WorkflowContextHelper.loadInLink(this, dstPortId);
        return getInLink(dstPortId);
    }

    public NodeLink fetchInLink(NodeInputPort inputNodePort) {
        return this.fetchInLink(inputNodePort.data().getNodePortId());
    }

    public List<NodeLink> fetchInLinks(Node node) {
        WorkflowContextHelper.loadInLinks(this, node);
        return this.getInLinks(node);
    }

    public List<NodeLink> fetchOutLinks(Long srcPortId) {
        WorkflowContextHelper.loadOutLinks(this, srcPortId);
        return getOutLinks(srcPortId);
    }

    public List<NodeLink> fetchOutLinks(NodeOutputPort outputNodePort) {
        return this.fetchOutLinks(outputNodePort.data().getNodePortId());
    }

    public List<NodeLink> fetchOutLinks(Node node) {
        WorkflowContextHelper.loadOutLinks(this, node);
        return this.getOutLinks(node);
    }

    /*
     *
     * Node Port Section
     *
     */

    public NodeInputPort getInputPort(Long portId) {
        return CollectionUtil.get(inputPorts, portId);
    }

    public NodeOutputPort getOutputPort(Long portId) {
        return CollectionUtil.get(outputPorts, portId);
    }

    public NodeOutputPort getUpstreamPort(NodeLink nodeLink) {
        return this.getOutputPort(nodeLink.data().getSrcPortId());
    }

    public NodeInputPort getDownstreamPort(NodeLink nodeLink) {
        return this.getInputPort(nodeLink.data().getDstPortId());
    }

    public NodeOutputPort getUpstreamPort(NodeInputPort inputNodePort) {
        NodeLink nodeLink = this.getInLink(inputNodePort.data().getNodePortId());
        if(DataUtil.isNotNull(nodeLink)) {
            return this.getOutputPort(nodeLink.data().getSrcPortId());
        }
        return null;
    }

    public List<NodeInputPort> getDownstreamPorts(NodeOutputPort outputNodePort) {
        List<NodeLink> nodeLinks = this.getOutLinks(outputNodePort.data().getNodePortId());
        if(DataUtil.isNotEmpty(nodeLinks)) {
            List<NodeInputPort> inputPorts = new ArrayList<NodeInputPort>(nodeLinks.size());
            for(NodeLink nodeLink : nodeLinks) {
                NodeInputPort inputNodePort = this.getInputPort(nodeLink.data().getDstPortId());
                inputPorts.add(inputNodePort);
            }
            return inputPorts;
        }
        return null;
    }

    //key:inputNodePortId
    public TreeMap<Long, NodeOutputPort> getUpstreamPorts(Node node) {
        if(node.isHeadNode())
            return null;

        List<NodeLink> inLinks = this.getInLinks(node);
        if(DataUtil.isNotEmpty(inLinks)) {
            TreeMap<Long, NodeOutputPort> upstreamPorts = new TreeMap<Long, NodeOutputPort>();
            for(NodeLink nodeLink : inLinks) {
                NodeOutputPort upstreamPort = this.getUpstreamPort(nodeLink);
                CollectionUtil.put(upstreamPorts, nodeLink.data().getDstPortId(), upstreamPort);
            }
            return upstreamPorts;
        }
        return null;
    }

    //key:outputNodePortId
    public TreeMap<Long, List<NodeInputPort>> getDownstreamPorts(Node node) {
        if(node.isTailNode())
            return null;

        List<NodeLink> outLinks = this.getOutLinks(node);
        if(DataUtil.isNotEmpty(outLinks)) {
            TreeMap<Long, List<NodeInputPort>> downstreamPorts = new TreeMap<Long, List<NodeInputPort>>();
            for(NodeLink nodeLink : outLinks) {
                NodeInputPort downstreamPort = this.getDownstreamPort(nodeLink);
                CollectionUtil.put4ChainMap(downstreamPorts, nodeLink.data().getSrcPortId(), downstreamPort);
            }
            return downstreamPorts;
        }
        return null;
    }

    public NodeInputPort fetchInputPort(Long portId) {
        WorkflowContextHelper.loadInputPort(this, portId);
        return this.getInputPort(portId);
    }

    public NodeOutputPort fetchOutputPort(Long portId) {
        WorkflowContextHelper.loadOutputPort(this, portId);
        return this.getOutputPort(portId);
    }

    public NodeOutputPort fetchUpstreamPort(NodeLink nodeLink) {
        return this.fetchOutputPort(nodeLink.data().getSrcPortId());
    }

    public NodeInputPort fetchDownstreamPort(NodeLink nodeLink) {
        return this.fetchInputPort(nodeLink.data().getDstPortId());
    }

    public NodeOutputPort fetchUpstreamPort(NodeInputPort inputNodePort) {
        WorkflowContextHelper.loadUpstreamPort(this, inputNodePort);
        return this.getUpstreamPort(inputNodePort);
    }

    public List<NodeInputPort> fetchDownstreamPorts(NodeOutputPort outputNodePort) {
        WorkflowContextHelper.loadDownstreamPorts(this, outputNodePort);
        return this.getDownstreamPorts(outputNodePort);
    }

    public TreeMap<Long, NodeOutputPort> fetchUpstreamPorts(Node node) {
        WorkflowContextHelper.loadUpstreamPorts(this, node);
        return this.getUpstreamPorts(node);
    }

    public TreeMap<Long, List<NodeInputPort>> fetchDownstreamPorts(Node node) {
        WorkflowContextHelper.loadDownstreamPorts(this, node);
        return this.getDownstreamPorts(node);
    }

    //key: input port cmpt-char, value: upstream output port schema
    public TreeMap<CmptChar, NodeSchema> fetchUpstreamSchema(Node node) {
        if(node.inputDataTablePortCount() == 0)
            return null;

        WorkflowContextHelper.loadUpstreamPorts(this, node);
        TreeMap<Long, NodeOutputPort> upstreamPorts = this.getUpstreamPorts(node);
        if(DataUtil.isNotEmpty(upstreamPorts)) {
            TreeMap<CmptChar, NodeSchema> resultMap = new TreeMap<CmptChar, NodeSchema>();
            for(Map.Entry<Long, NodeOutputPort> entry : upstreamPorts.entrySet()) {
                if(entry.getValue().isDataTablePort()) {
                    CollectionUtil.put(resultMap, node.getInputNodePort(entry.getKey()).getCmptChar(), entry.getValue().getSchema());
                }
            }
            return DataUtil.isEmpty(resultMap) ? null : resultMap;
        }
        return null;
    }

    /*
     *
     * Put Data Warehouse, Model Warehouse, Job, Task, Node, Link, Node Port, etc. Section
     *
     */

    public void putDataWarehouse(DataWarehouse warehouse) {
        CollectionUtil.put(dataWarehouses, warehouse.data().getDwId(), warehouse);
        CollectionUtil.put(dataWarehousesOrderByCode, warehouse.data().getDwName(), warehouse);
    }

    public void putModelWarehouse(ModelWarehouse warehouse) {
        CollectionUtil.put(modelWarehouses, warehouse.data().getMwId(), warehouse);
    }

    public void putExecutionTask(ExecutionTask task) {
        CollectionUtil.put(tasks, task.data().getTaskId(), task);
    }

    public void putNode(Node node) {
        if(CollectionUtil.containsKey(nodes, node.data().getNodeId()))
            return;

        CollectionUtil.put(nodes, node.data().getNodeId(), node);
    }

    public void putLink(NodeLink link) {
        if(CollectionUtil.containsKey(links, link.data().getLinkId()))
            return;

        CollectionUtil.put(links, link.data().getLinkId(), link);
        CollectionUtil.put(inputLinks, link.data().getSrcNodeId(), link);

        {
            TreeSet<NodeLink> outLinkSet = CollectionUtil.get(outputLinks, link.data().getDstPortId());
            if (DataUtil.isNotNull(outLinkSet))
                CollectionUtil.add(outLinkSet, link);
            else {
                outLinkSet = new TreeSet<NodeLink>();
                CollectionUtil.add(outLinkSet, link);
                CollectionUtil.put(outputLinks, link.data().getSrcPortId(), outLinkSet);
            }
        }
    }

    public List<Node> getDeleteNodes() {
        return CollectionUtil.toList(deleteNodes);
    }

    private void putDeleteNode(Node node) {
        if(CollectionUtil.containsKey(deleteNodes, node.data().getNodeId()))
            return;

        CollectionUtil.put(deleteNodes, node.data().getNodeId(), node);
    }

    public List<NodeLink> getDeleteLinks() {
        return CollectionUtil.toList(deleteLinks);
    }

    private void putDeleteLink(NodeLink link) {
        if(CollectionUtil.containsKey(deleteLinks, link.data().getLinkId()))
            return;

        CollectionUtil.put(deleteLinks, link.data().getLinkId(), link);
    }

    public List<Node> getAddNodes() {
        return CollectionUtil.toList(deleteNodes);
    }

    private void putAddNode(Node node) {
        if(CollectionUtil.containsKey(deleteNodes, node.data().getNodeId()))
            return;

        CollectionUtil.put(deleteNodes, node.data().getNodeId(), node);
    }

    public List<NodeLink> getAddLinks() {
        return CollectionUtil.toList(deleteLinks);
    }

    private void putAddLink(NodeLink link) {
        if(CollectionUtil.containsKey(deleteLinks, link.data().getLinkId()))
            return;

        CollectionUtil.put(deleteLinks, link.data().getLinkId(), link);
    }

    public void putInputPort(NodeInputPort inputPort) {
        if(CollectionUtil.containsKey(inputPorts, inputPort.data().getNodePortId()))
            return;

        CollectionUtil.put(inputPorts, inputPort.data().getNodePortId(), inputPort);
    }

    public void putOutputPort(NodeOutputPort outputPort) {
        if(CollectionUtil.containsKey(outputPorts, outputPort.data().getNodePortId()))
            return;

        CollectionUtil.put(outputPorts, outputPort.data().getNodePortId(), outputPort);
    }

    /*
     *
     * Other Section
     *
     */

/*    public int analyzeNodeCount() {
        return analyzeNodes.size();
    }

    public int analyzeLinkCount() {
        return analyzeLinks.size();
    }*/

    public void pushAnalyzeNode(Node node) {
        CollectionUtil.offerLast(analyzeNodes, node);
    }

    public void pushAnalyzeLink(NodeLink link) {
        CollectionUtil.offerLast(analyzeLinks, link);
    }

    public Node popAnalyzeNode() {
        return CollectionUtil.pollLast(analyzeNodes);
    }

    public NodeLink popAnalyzeLink() {
        return CollectionUtil.pollLast(analyzeLinks);
    }

/*    public void clearAnalyzeNodes() {
        CollectionUtil.clear(analyzeNodes);
    }

    public void clearAnalyzeLinks() {
        CollectionUtil.clear(analyzeLinks);
    }*/

/*    public void eraseNode(Node node) {

        for(NodeInputPort inputNodePort : node.getInputNodePorts()) {
            List<NodeLink> nodeLinks = this.getInLinks(inputNodePort.data().getNodePortId());
            if(DataUtil.isNotEmpty(nodeLinks)) {
                for(NodeLink link : nodeLinks)
                    CollectionUtil.remove(links, link.data().getLinkId());
                CollectionUtil.remove(inputLinks, inputNodePort.data().getNodePortId());
            }
            CollectionUtil.remove(inputPorts, inputNodePort.data().getNodePortId());
        }

        for(NodeOutputPort outputNodePort : node.getOutputNodePorts()) {
            List<NodeLink> nodeLinks = this.getOutLinks(outputNodePort.data().getNodePortId());
            if(DataUtil.isNotEmpty(nodeLinks)) {
                for(NodeLink link : nodeLinks)
                    CollectionUtil.remove(links, link.data().getLinkId());
                CollectionUtil.remove(outputLinks, outputNodePort.data().getNodePortId());
            }
            CollectionUtil.remove(outputPorts, outputNodePort.data().getNodePortId());
        }
        CollectionUtil.remove(nodes, node.data().getNodeId());
    }*/
}
