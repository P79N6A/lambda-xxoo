package com.yatop.lambda.workflow.core.context;

import com.yatop.lambda.core.enums.*;
import com.yatop.lambda.core.exception.LambdaException;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.mgr.workflow.node.port.schema.SchemaAnalyzer;
import com.yatop.lambda.workflow.core.mgr.workflow.node.port.schema.SchemaHelper;
import com.yatop.lambda.workflow.core.richmodel.data.table.DataWarehouse;
import com.yatop.lambda.workflow.core.richmodel.data.model.ModelWarehouse;
import com.yatop.lambda.workflow.core.richmodel.workflow.execution.ExecutionJob;
import com.yatop.lambda.workflow.core.richmodel.workflow.execution.ExecutionTask;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.*;
import com.yatop.lambda.workflow.core.utils.CollectionUtil;
import com.yatop.lambda.workflow.core.richmodel.project.Project;
import com.yatop.lambda.workflow.core.richmodel.workflow.Workflow;

import java.util.*;

public class WorkflowContext implements IWorkContext {

    /**
     *  工作流、节点、节点参数、节点数据端口schema等信息采用延迟更新，由flush方法发起提交
     * */

    private boolean lazyLoadMode;           //标识是否为懒加载模式，否则视为节点和链接的相关信息都已经一次性读取到上下文中
    private boolean executionWorkMode;      //标识是否为运行工作模式，否则视为编辑器模式（用于特征CharValue增删改查等事件内部判断用）
    private boolean enableFlushWorkflow;    //控制是否可执行flush更新工作流相关信息
    private boolean loadNodeParameter;      //控制是否查询带出节点参数信息
    private boolean loadDataPortSchema;     //控制是否查询带出数据输出端口schema信息
    private AnalyzeTypeEnum schemaAnalyze;  //触发的schema分析类型
    private Project project;                //操作关联项目
    private Workflow workflow;              //操作关联工作流
    private ExecutionJob job;               //操作关联作业
    private ExecutionTask task;             //操作关联任务
    private TreeMap<Long, DataWarehouse>  dataWarehouses = new TreeMap<Long, DataWarehouse>();   //操作关联数据仓库，key=dwId
    private TreeMap<Long, ModelWarehouse> modelWarehouses = new TreeMap<Long, ModelWarehouse>();  //操作关联模型仓库，key=mwId
    private TreeMap<Long, Node> nodes = new TreeMap<Long, Node>();      //操作关联节点，key=nodeId
    private TreeMap<Long, NodeLink> links = new TreeMap<Long, NodeLink>();  //操作关联节点链接，key=linkId
    private TreeMap<Long, TreeSet<NodeLink>> inputLinks = new TreeMap<Long, TreeSet<NodeLink>>();  //操作关联节点链接，key=dstPortId
    private TreeMap<Long, TreeSet<NodeLink>> outputLinks = new TreeMap<Long, TreeSet<NodeLink>>();  //操作关联节点链接，key=srcPortId
    private TreeMap<Long, NodePortInput> inputPorts = new TreeMap<Long, NodePortInput>();  //操作关联节点输入端口，key=nodePortId
    private TreeMap<Long, NodePortOutput> outputPorts = new TreeMap<Long, NodePortOutput>();  //操作关联节点输出端口，key=nodePortId
  //private TreeMap<Long, GlobalParameter> globalParameters = new TreeMap<Long, GlobalParameter>();  //操作关联节点全局参数，key=globalParameterId
    private String operId;

    private Deque<Node> analyzeNodes = new LinkedList<Node>();      //待分析节点，key=nodeId
    private Deque<NodeLink> analyzeLinks = new LinkedList<NodeLink>();  //待分析节点链接，key=linkId

    //工作流新建使用（无需加载）
    public static WorkflowContext BuildWorkflowContext4Create(Project project, Workflow workflow, String operId) {
        WorkflowContext context = new WorkflowContext(project, workflow, operId);
        context.lazyLoadMode = false;
        context.executionWorkMode = false;
        context.enableFlushWorkflow = true;
        context.loadNodeParameter = true;
        context.loadDataPortSchema = true;
        return context;
    }

    //工作流编辑使用（创建节点、更新节点参数、删除节点和删除链接，增量加载）
    public static WorkflowContext BuildWorkflowContext4Edit(Project project, Workflow workflow, String operId) {
        WorkflowContext context = new WorkflowContext(project, workflow, operId);
        context.lazyLoadMode = true;
        context.executionWorkMode = false;
        context.enableFlushWorkflow = true;
        context.loadNodeParameter = true;
        context.loadDataPortSchema = true;
        return context;
    }

    //工作流编辑创建链接使用（全量预加载）
    public static WorkflowContext BuildWorkflowContext4EditCreateLink(Project project, Workflow workflow, String operId) {
        WorkflowContext context = new WorkflowContext(project, workflow, operId);
        context.lazyLoadMode = false;
        context.executionWorkMode = false;
        context.enableFlushWorkflow = true;
        context.loadNodeParameter = true;
        context.loadDataPortSchema = true;
        context.initialize(true);
        return context;
    }

    //工作流编辑验证链接使用（增量加载）
    public static WorkflowContext BuildWorkflowContext4EditValidateLink(Project project, Workflow workflow, String operId) {
        WorkflowContext context = new WorkflowContext(project, workflow, operId);
        context.lazyLoadMode = true;
        context.executionWorkMode = false;
        context.enableFlushWorkflow = false;
        context.loadNodeParameter = false;
        context.loadDataPortSchema = false;
        return context;
    }

    //工作流查询画布图形信息使用（全量预加载）
    public static WorkflowContext BuildWorkflowContext4OnlyGraph(Project project, Workflow workflow, String operId) {
        WorkflowContext context = new WorkflowContext(project, workflow, operId);
        context.lazyLoadMode = false;
        context.executionWorkMode = false;
        context.enableFlushWorkflow = false;
        context.loadNodeParameter = false;
        context.loadDataPortSchema = false;
        context.initialize(true);
        return context;
    }

    //工作流内容查询用于工作流编译、复制、构建快照、构建作业等场景使用（全量预加载）
    public static WorkflowContext BuildWorkflowContext4FullContent(Project project, Workflow workflow, String operId) {
        WorkflowContext context = new WorkflowContext(project, workflow, operId);
        context.lazyLoadMode = false;
        context.executionWorkMode = false;
        context.enableFlushWorkflow = true;
        context.loadNodeParameter = true;
        context.loadDataPortSchema = true;
        context.initialize(true);
        return context;
    }

    //快照内容读取使用（反序列化时注入）
    public static WorkflowContext BuildWorkflowContext4Snapshot(Project project, Workflow workflow, String operId) {
        WorkflowContext context = new WorkflowContext(project, workflow, operId);
        context.lazyLoadMode = false;
        context.executionWorkMode = false;
        context.enableFlushWorkflow = false;
        context.loadNodeParameter = false;  //WorkflowContextCodec中填入
        context.loadDataPortSchema = false;
        return context;
    }

    //作业内容读取使用（反序列化时注入）
    public static WorkflowContext BuildWorkflowContext4Execution(Project project, Workflow workflow, ExecutionJob job, String operId) {
        WorkflowContext context = new WorkflowContext(project, workflow, operId);
        context.job = job;
        context.lazyLoadMode = false;
        context.executionWorkMode = true;
        context.enableFlushWorkflow = JobTypeEnum.enableFlushWorkflow(JobTypeEnum.valueOf(job.data().getJobType()));
        context.loadNodeParameter = false;  //WorkflowContextCodec中填入
        context.loadDataPortSchema = false;
        return context;
    }

    private WorkflowContext(Project project, Workflow workflow, String operId) {
        this.project = project;
        this.workflow = workflow;
        this.operId = operId;
        this.schemaAnalyze = AnalyzeTypeEnum.NONE;
    }

    private void initialize(boolean doPreload) {
        if(doPreload) {
            WorkflowContextHelper.loadAllNodes(this);
            WorkflowContextHelper.loadAllLinks(this);
            if(WorkflowContextHelper.existDirectedCyclicGraph(this)) {
                throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Workflow context error -- Workflow exists directed cyclic graph.", "工作流数据异常，请联系管理员");
            }
        }
    }

    @Override
    public void clear() {
        project = null;
        workflow = null;
        operId = null;
        job = null;
        task = null;
        CollectionUtil.enhancedClear(dataWarehouses);
        CollectionUtil.enhancedClear(modelWarehouses);
        CollectionUtil.enhancedClear(nodes);
        CollectionUtil.enhancedClear(links);
        CollectionUtil.clear(inputLinks);
        CollectionUtil.clear(outputLinks);
        CollectionUtil.clear(inputPorts);
        CollectionUtil.clear(outputPorts);
        //CollectionUtil.clear(globalParameters);
        CollectionUtil.clear(analyzeNodes);
        CollectionUtil.clear(analyzeLinks);
    }

    public void flush() {
        if(!this.isEnableFlushWorkflow())
            return;

        if(loadNodeParameter && loadDataPortSchema) {
            SchemaAnalyzer.dealAnalyzeSchema(this);
        }

        if(this.nodeCount() > 0) {
            for (Node node : this.getNodes()) {
                node.flush(this.isLoadNodeParameter(), this.isLoadDataPortSchema(), this.operId);
            }
        }
        this.workflow.flush(this.operId);
    }

    /*
     *
     * Editor Transaction Done Section
     *
     */

    public void doneCreateNode(Node node) {
        node.downgradeState2Ready();
        this.putNode(node);
        this.workflow.changeState2Draft();
        this.markAnalyzeWithCreateNode(node);
    }

    public void doneCreateLink(NodeLink link) {
        this.putLink(link);
        this.workflow.changeState2Draft();
        this.markAnalyzeWithCreateLink(link);
    }

    public void doneUpdateNodeParameter(Node node, NodeParameter parameter) {
        node.downgradeState2Ready();
        this.workflow.changeState2Draft();
        if(parameter.getCmptChar().data().getSpecType() == SpecTypeEnum.PARAMETER.getType())
            this.markAnalyzeWithUpdateNodeParameter(node, parameter);
    }

    public void doneDeleteNode(Node node) {
        node.markDeleted();
        this.workflow.changeState2Draft();
        this.markAnalyzeWithDeleteNode(node);
    }

    public void doneRecoverNode(Node node) {
        this.doneCreateNode(node);
    }

    public void doneDeleteLink(NodeLink link) {
        link.markDeleted();
        this.workflow.changeState2Draft();
        this.markAnalyzeWithDeleteLink(link);
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

    public boolean isAnalyzeWithCompileWorkflow() {
        return this.schemaAnalyze.getType() == AnalyzeTypeEnum.COMPILE_WORKFLOW.getType();
    }

    private void markAnalyzeWithCreateNode(Node node) {
        //TODO 对于异常情况是否抛出错误
        if(this.isAnalyzeWithNone() || this.isAnalyzeWithCreateNode()) {
            if(SchemaHelper.needAnalyzeSchema(node)) {
                this.schemaAnalyze = AnalyzeTypeEnum.CREATE_NODE;
                this.pushAnalyzeNode(node);
            }
        }
    }

    private void markAnalyzeWithCreateLink(NodeLink link) {
        //TODO 对于异常情况是否抛出错误
        if(this.isAnalyzeWithNone()) {
            if(!link.isWebLink()) {
                this.schemaAnalyze = AnalyzeTypeEnum.CREATE_LINK;
                this.pushAnalyzeLink(link);
            }
        }
    }

    private void markAnalyzeWithUpdateNodeParameter(Node node, NodeParameter parameter) {
        //TODO 对于异常情况是否抛出错误
        if(this.isAnalyzeWithNone()) {
            if(SchemaHelper.needAnalyzeSchema(node, parameter)) {
                this.schemaAnalyze = AnalyzeTypeEnum.UPDATE_NODE_PARAMETER;
                this.pushAnalyzeNode(node);
            }
        }
    }

    private void markAnalyzeWithDeleteNode(Node node) {
        //TODO 对于异常情况是否抛出错误
        if(this.isAnalyzeWithNone() || this.isAnalyzeWithDeleteNode() || this.isAnalyzeWithDeleteLink()) {
            if(SchemaHelper.needAnalyzeSchema(node)) {
                this.schemaAnalyze = AnalyzeTypeEnum.DELETE_NODE;
                this.pushAnalyzeNode(node);
            }
        }
    }

    private void markAnalyzeWithDeleteLink(NodeLink link) {
        //TODO 对于异常情况是否抛出错误
        if(this.isAnalyzeWithNone() || this.isAnalyzeWithDeleteLink()) {
            if(!link.isWebLink()) {
                this.schemaAnalyze = AnalyzeTypeEnum.DELETE_LINK;
                this.pushAnalyzeLink(link);
            }
        }
    }

    public void markAnalyzeWithCompileWorkflow() {
        //TODO 对于异常情况是否抛出错误
        if(this.isAnalyzeWithNone())
            this.schemaAnalyze = AnalyzeTypeEnum.COMPILE_WORKFLOW;
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

    public boolean isLoadDataPortSchema() {
        return loadDataPortSchema;
    }

    public Project getProject() {
        return project;
    }

    public Workflow getWorkflow() {
        return workflow;
    }

    public ExecutionJob getJob() {
        if(!executionWorkMode){
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Workflow context error -- Non execution work mode.", "系统内部发生错误，请联系管理员");
        }
        if(executionWorkMode && DataUtil.isNull(job)){
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Workflow context error -- Execution work mode missing job info.", "系统内部发生错误，请联系管理员");
        }
        return job;
    }

    public ExecutionTask getTask() {
        ExecutionJob execJob = getJob();
        if(executionWorkMode && DataUtil.isNull(task)) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Workflow context error -- Execution work mode missing task info.", "系统内部发生错误，请联系管理员");
        }
        if(!execJob.data().getJobId().equals(task.data().getOwnerJobId())) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Workflow context error -- Execution job.job_id & task.owner_job_id inconsistent.", "系统内部发生错误，请联系管理员", execJob, task);
        }
        return task;
    }

    public void switchTask(ExecutionTask task) {
        this.task = task;
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
        return nodes.get(nodeId);
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

    //key:inputNodePortId
    public TreeMap<Long, Node> fetchNonWebUpstreamNodes(Node node) {
        List<NodeLink> inLinks = this.fetchNonWebInLinks(node);
        if(DataUtil.isNotEmpty(inLinks)) {
            TreeMap<Long, Node> upstreamNodes = new TreeMap<Long, Node>();
            for(NodeLink nodeLink : inLinks) {
                Node upstreamNode = this.fetchUpstreamNode(nodeLink);
                upstreamNodes.put(nodeLink.data().getDstPortId(), upstreamNode);
            }
            return upstreamNodes;
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
        return links.get(linkId);
    }

    public List<NodeLink> getInLinks(Long dstPortId) {
        return CollectionUtil.toList(inputLinks.get(dstPortId));
    }

    public List<NodeLink> getInLinks(NodePortInput inputNodePort) {
        return this.getInLinks(inputNodePort.data().getNodePortId());
    }

    public List<NodeLink> getInLinks(Node node) {
        if(!node.isHeadNode()) {
            List<NodeLink> inLinks = new ArrayList<NodeLink>();
            for (NodePortInput inputNodePort : node.getInputNodePorts()) {
                List<NodeLink> nodeLinks = this.getInLinks(inputNodePort);
                if(DataUtil.isNotEmpty(nodeLinks)) {
                    for(NodeLink nodeLink : nodeLinks)
                        inLinks.add(nodeLink);
                }
            }
            return DataUtil.isNotEmpty(inLinks) ? inLinks : null;
        }
        return null;
    }

    private NodeLink filterPortInLinks4Port(List<NodeLink> nodeLinks, IsWebLinkEnum linkFilter) {
        if(DataUtil.isNotEmpty(nodeLinks)) {
            for (NodeLink nodeLink : nodeLinks) {
                if (nodeLink.data().getIsWebLink() == linkFilter.getMark())
                    return nodeLink;
            }
        }
        return null;
    }

    private List<NodeLink> filterPortInLinks4Node(List<NodeLink> nodeLinks, IsWebLinkEnum linkFilter) {
        if(DataUtil.isNotEmpty(nodeLinks)) {
            List<NodeLink> inLinks = new ArrayList<NodeLink>();
            for (NodeLink nodeLink : nodeLinks) {
                if (nodeLink.data().getIsWebLink() == linkFilter.getMark())
                    CollectionUtil.add(inLinks, nodeLink);
            }
            return inLinks;
        }
        return null;
    }

    public NodeLink getNonWebInLink(Long dstPortId) {
        List<NodeLink> nodeLinks = this.getInLinks(dstPortId);
        return filterPortInLinks4Port(nodeLinks, IsWebLinkEnum.NO);
    }

    public NodeLink getWebInLink(Long dstPortId) {
        List<NodeLink> nodeLinks = this.getInLinks(dstPortId);
        return filterPortInLinks4Port(nodeLinks, IsWebLinkEnum.YES);
    }

    public List<NodeLink> getNonWebInLinks(Node node) {
        List<NodeLink> nodeLinks = this.getInLinks(node);
        return filterPortInLinks4Node(nodeLinks, IsWebLinkEnum.NO);
    }

    public List<NodeLink> getOutLinks(Long srcPortId) {
        return CollectionUtil.toList(outputLinks.get(srcPortId));
    }

    public List<NodeLink> getOutLinks(NodePortOutput outputNodePort) {
        return this.getOutLinks(outputNodePort.data().getNodePortId());
    }

    public List<NodeLink> getOutLinks(Node node) {
        if(!node.isTailNode()) {
            List<NodeLink> outLinks = new ArrayList<NodeLink>();
            for (NodePortOutput outputNodePort : node.getOutputNodePorts()) {
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

    public List<NodeLink> fetchInLinks(Long dstPortId) {
        WorkflowContextHelper.loadInLinks(this, dstPortId);
        return getInLinks(dstPortId);
    }

    public List<NodeLink> fetchInLinks(NodePortInput inputNodePort) {
        return this.fetchInLinks(inputNodePort.data().getNodePortId());
    }

    public List<NodeLink> fetchInLinks(Node node) {
        WorkflowContextHelper.loadInLinks(this, node);
        return this.getInLinks(node);
    }

    public NodeLink fetchNonWebInLink(Long dstPortId) {
        WorkflowContextHelper.loadInLinks(this, dstPortId);
        return getNonWebInLink(dstPortId);
    }

    public NodeLink fetchWebInLink(Long dstPortId) {
        WorkflowContextHelper.loadInLinks(this, dstPortId);
        return getWebInLink(dstPortId);
    }

    public List<NodeLink> fetchNonWebInLinks(Node node) {
        WorkflowContextHelper.loadInLinks(this, node);
        return getNonWebInLinks(node);
    }

    public List<NodeLink> fetchOutLinks(Long srcPortId) {
        WorkflowContextHelper.loadOutLinks(this, srcPortId);
        return getOutLinks(srcPortId);
    }

    public List<NodeLink> fetchOutLinks(NodePortOutput outputNodePort) {
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

    public NodePortInput getInputPort(Long portId) {
        return inputPorts.get(portId);
    }

    public NodePortOutput getOutputPort(Long portId) {
        return outputPorts.get(portId);
    }

    public NodePortOutput getUpstreamPort(NodeLink nodeLink) {
        return this.getOutputPort(nodeLink.data().getSrcPortId());
    }

    public NodePortInput getDownstreamPort(NodeLink nodeLink) {
        return this.getInputPort(nodeLink.data().getDstPortId());
    }

    public List<NodePortOutput> getUpstreamPorts(NodePortInput inputNodePort) {
        List<NodeLink> nodeLinks = this.getInLinks(inputNodePort.data().getNodePortId());
        if(DataUtil.isNotEmpty(nodeLinks)) {
            List<NodePortOutput> outputPorts = new ArrayList<NodePortOutput>(nodeLinks.size());
            for(NodeLink nodeLink : nodeLinks) {
                NodePortOutput outputNodePort = this.getOutputPort(nodeLink.data().getSrcPortId());
                outputPorts.add(outputNodePort);
            }
            return outputPorts;
        }
        return null;
    }

    public List<NodePortInput> getDownstreamPorts(NodePortOutput outputNodePort) {
        List<NodeLink> nodeLinks = this.getOutLinks(outputNodePort.data().getNodePortId());
        if(DataUtil.isNotEmpty(nodeLinks)) {
            List<NodePortInput> inputPorts = new ArrayList<NodePortInput>(nodeLinks.size());
            for(NodeLink nodeLink : nodeLinks) {
                NodePortInput inputNodePort = this.getInputPort(nodeLink.data().getDstPortId());
                inputPorts.add(inputNodePort);
            }
            return inputPorts;
        }
        return null;
    }

    //key:inputNodePortId
    public TreeMap<Long, List<NodePortOutput>> getUpstreamPorts(Node node) {
        if(node.isHeadNode())
            return null;

        List<NodeLink> inLinks = this.getInLinks(node);
        if(DataUtil.isNotEmpty(inLinks)) {
            TreeMap<Long, List<NodePortOutput>> upstreamPorts = new TreeMap<Long, List<NodePortOutput>>();
            for(NodeLink nodeLink : inLinks) {
                NodePortOutput upstreamPort = this.getUpstreamPort(nodeLink);
                CollectionUtil.put4ChainMap(upstreamPorts, nodeLink.data().getDstPortId(), upstreamPort);
            }
            return upstreamPorts;
        }
        return null;
    }

    //key:outputNodePortId
    public TreeMap<Long, List<NodePortInput>> getDownstreamPorts(Node node) {
        if(node.isTailNode())
            return null;

        List<NodeLink> outLinks = this.getOutLinks(node);
        if(DataUtil.isNotEmpty(outLinks)) {
            TreeMap<Long, List<NodePortInput>> downstreamPorts = new TreeMap<Long, List<NodePortInput>>();
            for(NodeLink nodeLink : outLinks) {
                NodePortInput downstreamPort = this.getDownstreamPort(nodeLink);
                CollectionUtil.put4ChainMap(downstreamPorts, nodeLink.data().getSrcPortId(), downstreamPort);
            }
            return downstreamPorts;
        }
        return null;
    }

    public NodePortInput fetchInputPort(Long portId) {
        WorkflowContextHelper.loadInputPort(this, portId);
        return this.getInputPort(portId);
    }

    public NodePortOutput fetchOutputPort(Long portId) {
        WorkflowContextHelper.loadOutputPort(this, portId);
        return this.getOutputPort(portId);
    }

    public NodePortOutput fetchUpstreamPort(NodeLink nodeLink) {
        return this.fetchOutputPort(nodeLink.data().getSrcPortId());
    }

    public NodePortInput fetchDownstreamPort(NodeLink nodeLink) {
        return this.fetchInputPort(nodeLink.data().getDstPortId());
    }

    public List<NodePortOutput> fetchUpstreamPorts(NodePortInput inputNodePort) {
        WorkflowContextHelper.loadUpstreamPorts(this, inputNodePort);
        return this.getUpstreamPorts(inputNodePort);
    }

    public List<NodePortInput> fetchDownstreamPorts(NodePortOutput outputNodePort) {
        WorkflowContextHelper.loadDownstreamPorts(this, outputNodePort);
        return this.getDownstreamPorts(outputNodePort);
    }

    public TreeMap<Long, List<NodePortOutput>> fetchUpstreamPorts(Node node) {
        WorkflowContextHelper.loadUpstreamPorts(this, node);
        return this.getUpstreamPorts(node);
    }

    public TreeMap<Long, List<NodePortInput>> fetchDownstreamPorts(Node node) {
        WorkflowContextHelper.loadDownstreamPorts(this, node);
        return this.getDownstreamPorts(node);
    }

    //key:inputNodePortId
    public TreeMap<Long, NodePortOutput> fetchNonWebUpstreamPorts(Node node) {
        List<NodeLink> inLinks = this.fetchNonWebInLinks(node);
        if(DataUtil.isNotEmpty(inLinks)) {
            TreeMap<Long, NodePortOutput> upstreamPorts = new TreeMap<Long, NodePortOutput>();
            for(NodeLink nodeLink : inLinks) {
                NodePortOutput upstreamPort = this.fetchUpstreamPort(nodeLink);
                upstreamPorts.put(nodeLink.data().getDstPortId(), upstreamPort);
            }
            return upstreamPorts;
        }
        return null;
    }

    /*
     *
     * Put Warehouse, Node, Link, Node Port, etc. Section
     *
     */

    public void putDataWarehouse(DataWarehouse warehouse) {
        CollectionUtil.put(dataWarehouses, warehouse.data().getDwId(), warehouse);
    }

    public void putModelWarehouse(ModelWarehouse warehouse) {
        CollectionUtil.put(modelWarehouses, warehouse.data().getMwId(), warehouse);
    }

    public void putNode(Node node) {
        CollectionUtil.put(nodes, node.data().getNodeId(), node);
    }

    public void putLink(NodeLink link) {
        CollectionUtil.put(links, link.data().getLinkId(), link);

        {
            TreeSet<NodeLink> inLinkSet = CollectionUtil.get(inputLinks, link.data().getLinkId());
            if (DataUtil.isNotNull(inLinkSet))
                CollectionUtil.add(inLinkSet, link);
            else {
                inLinkSet = new TreeSet<NodeLink>();
                CollectionUtil.add(inLinkSet, link);
                CollectionUtil.put(inputLinks, link.data().getDstPortId(), inLinkSet);
            }
        }

        {
            TreeSet<NodeLink> outLinkSet = CollectionUtil.get(outputLinks, link.data().getLinkId());
            if (DataUtil.isNotNull(outLinkSet))
                CollectionUtil.add(outLinkSet, link);
            else {
                outLinkSet = new TreeSet<NodeLink>();
                CollectionUtil.add(outLinkSet, link);
                CollectionUtil.put(outputLinks, link.data().getSrcPortId(), outLinkSet);
            }
        }
    }

    public void putInputPort(NodePortInput inputPort) {
        CollectionUtil.put(inputPorts, inputPort.data().getNodePortId(), inputPort);
    }

    public void putOutputPort(NodePortOutput outputPort) {
        CollectionUtil.put(outputPorts, outputPort.data().getNodePortId(), outputPort);
    }

/*    public GlobalParameter getGlobalParameter(Long globalParameterId) {
        return globalParameters.get(globalParameterId);
    }

    public List<GlobalParameter> getGlobalParameters() {
        return CollectionUtil.toList(globalParameters);
    }

    public void putGlobalParameter(GlobalParameter globalParameter) {
        CollectionUtil.put(globalParameters, globalParameter.data().getGlobalParamId(), globalParameter);

    }
*/

    /*
     *
     * Other Section
     *
     */

    public int analyzeNodeCount() {
        return analyzeNodes.size();
    }

    public int analyzeLinkCount() {
        return analyzeLinks.size();
    }

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

    public void clearAnalyzeNodes() {
        CollectionUtil.clear(analyzeNodes);
    }

    public void clearAnalyzeLinks() {
        CollectionUtil.clear(analyzeLinks);
    }

    public void eraseNode(Node node) {

        for(NodePortInput inputNodePort : node.getInputNodePorts()) {
            List<NodeLink> nodeLinks = this.getInLinks(inputNodePort.data().getNodePortId());
            if(DataUtil.isNotEmpty(nodeLinks)) {
                for(NodeLink link : nodeLinks)
                    CollectionUtil.remove(links, link.data().getLinkId());
                CollectionUtil.remove(inputLinks, inputNodePort.data().getNodePortId());
            }
            CollectionUtil.remove(inputPorts, inputNodePort.data().getNodePortId());
        }

        for(NodePortOutput outputNodePort : node.getOutputNodePorts()) {
            List<NodeLink> nodeLinks = this.getOutLinks(outputNodePort.data().getNodePortId());
            if(DataUtil.isNotEmpty(nodeLinks)) {
                for(NodeLink link : nodeLinks)
                    CollectionUtil.remove(links, link.data().getLinkId());
                CollectionUtil.remove(outputLinks, outputNodePort.data().getNodePortId());
            }
            CollectionUtil.remove(outputPorts, outputNodePort.data().getNodePortId());
        }
        CollectionUtil.remove(nodes, node.data().getNodeId());
    }
}
