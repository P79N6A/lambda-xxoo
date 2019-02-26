package com.yatop.lambda.workflow.core.richmodel.workflow.execution;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yatop.lambda.base.model.WfExecutionJob;
import com.yatop.lambda.core.enums.JobStateEnum;
import com.yatop.lambda.core.enums.JobTypeEnum;
import com.yatop.lambda.core.enums.LambdaExceptionEnum;
import com.yatop.lambda.core.exception.LambdaException;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.context.WorkflowContext;
import com.yatop.lambda.workflow.core.mgr.workflow.execution.job.JobHelper;
import com.yatop.lambda.workflow.core.mgr.workflow.snapshot.SnapshotHelper;
import com.yatop.lambda.workflow.core.richmodel.RichModel;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.Node;
import com.yatop.lambda.workflow.core.richmodel.workflow.snapshot.Snapshot;

import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Map;

public class ExecutionJob extends RichModel<WfExecutionJob> {

    private static String JOB_CONTENT_KEY_WAIT_HEAD_NODES = "@@@WaitHeadNodes";
    private static String JOB_CONTENT_KEY_WAIT_NODES = "@@@WaitNodes";
    private static String JOB_CONTENT_KEY_PENDING_NODES = "@@@PendingNodes";
  //private static String JOB_CONTENT_KEY_PREPARING_NODES = "@@@PreparingNodes";
  //private static String JOB_CONTENT_KEY_READY_NODES = "@@@ReadyNodes";
    private static String JOB_CONTENT_KEY_RUNNING_NODES = "@@@RunningNodes";
    private static String JOB_CONTENT_KEY_SUCCESS_NODES = "@@@SuccessNodes";
    private static String JOB_CONTENT_KEY_ERROR_NODES = "@@@ErrorNodes";
    private static String JOB_CONTENT_KEY_TERMINATED_NODES = "@@@TerminatedNodes";

    private Snapshot snapshot;

    private TreeSet<Node> waitHeadNodes = new TreeSet<Node>();
    private TreeSet<Node> waitNodes = new TreeSet<Node>();
    private TreeSet<Node> pendingNodes = new TreeSet<Node>();
  //private TreeMap<Node, Long> preparingNodes = new TreeMap<Node, Long>();
  //private TreeMap<Node, Long> readyNodes = new TreeMap<Node, Long>();
    private TreeMap<Node, Long> runningNodes = new TreeMap<Node, Long>();
    private TreeMap<Node, Long> successNodes = new TreeMap<Node, Long>();
    private TreeMap<Node, Long> errorNodes = new TreeMap<Node, Long>();
    private TreeMap<Node, Long> terminatedNodes = new TreeMap<Node, Long>();

    public static ExecutionJob BuildExecutionJob4Create(WfExecutionJob data, WorkflowContext workflowContext, Snapshot snapShot, List<TreeSet<Node>> jobContent) {
        ExecutionJob job = new ExecutionJob(data);
        job.snapshot = snapShot;
        job.initJobContent(workflowContext, jobContent);
        return job;
    }

    public static ExecutionJob BuildExecutionJob(WfExecutionJob data) {
        ExecutionJob job = new ExecutionJob(data);
        return job;
    }

    private ExecutionJob(WfExecutionJob data) {
        super(data);
    }

    public void flush(WorkflowContext workflowContext) {

        if(this.enableFlushSnapshot() && DataUtil.isNotNull(snapshot)) {
            this.getSnapshot().flush(workflowContext);
        }

        this.flushJobContent();
        JobHelper.updateExecutionJob(this, workflowContext.getOperId());
    }

    @Override
    public void clear() {
        snapshot.clear();
        super.clear();
    }

    private void initJobContent(WorkflowContext workflowContext, List<TreeSet<Node>> jobContent) {

        if(DataUtil.isNull(jobContent) || jobContent.size() != 2 || DataUtil.isEmpty(jobContent.get(0))) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Initialize job content failed -- empty content error.", "作业内容为空", workflowContext.getWorkflow().data());
        }

        waitHeadNodes = jobContent.get(0);
        waitNodes = jobContent.get(1);

        for(Node node : waitHeadNodes) {
            node.changeState2Preparing();
        }

        for(Node node : waitNodes) {
            node.changeState2Preparing();
        }
    }

    public void flushJobContent() {

        JSONObject jsonContent = new JSONObject(8, true);
        JSONArray jsonWaitHeadNodes = this.toJSONArray(waitHeadNodes);
        JSONArray jsonWaitNodes = this.toJSONArray(waitNodes);
        JSONArray jsonPendingNodes = this.toJSONArray(pendingNodes);
      //JSONObject jsonPreparingNodes = this.toJSONObject(this.preparingNodes);
      //JSONObject jsonReadyNodes = this.toJSONObject(this.readyNodes);
        JSONObject jsonRunningNodes = this.toJSONObject(this.runningNodes);
        JSONObject jsonSuccessNodes = this.toJSONObject(this.successNodes);
        JSONObject jsonErrorNodes = this.toJSONObject(this.errorNodes);
        JSONObject jsonTerminatedNodes = this.toJSONObject(this.terminatedNodes);

        jsonContent.put(JOB_CONTENT_KEY_WAIT_HEAD_NODES, jsonWaitHeadNodes);
        jsonContent.put(JOB_CONTENT_KEY_WAIT_NODES, jsonWaitNodes);
        jsonContent.put(JOB_CONTENT_KEY_PENDING_NODES, jsonPendingNodes);
      //jsonContent.put(JOB_CONTENT_KEY_PREPARING_NODES, jsonPreparingNodes);
      //jsonContent.put(JOB_CONTENT_KEY_READY_NODES, jsonReadyNodes);
        jsonContent.put(JOB_CONTENT_KEY_RUNNING_NODES, jsonRunningNodes);
        jsonContent.put(JOB_CONTENT_KEY_SUCCESS_NODES, jsonSuccessNodes);
        jsonContent.put(JOB_CONTENT_KEY_ERROR_NODES, jsonErrorNodes);
        jsonContent.put(JOB_CONTENT_KEY_TERMINATED_NODES, jsonTerminatedNodes);
        this.data().setJobContent(DataUtil.prettyFormat(jsonContent));

        jsonContent.clear();
    }

    private JSONArray toJSONArray(TreeSet<Node> nodes) {
        if(DataUtil.isEmpty(nodes))
            return new JSONArray();

        JSONArray jsonArray = new JSONArray(nodes.size());
        for(Node node : nodes) {
            jsonArray.add(node.data().getNodeId());
        }
        return jsonArray;
    }

    private JSONObject toJSONObject(TreeMap<Node, Long> nodes) {
        if(DataUtil.isEmpty(nodes))
            return new JSONObject();

        JSONObject jsonObject = new JSONObject(nodes.size(), true);
        for(Map.Entry<Node, Long> entry : nodes.entrySet()) {
            jsonObject.put(entry.getKey().data().getNodeId().toString(), entry.getValue());
        }
        return jsonObject;
    }

    public void parseJobContent(WorkflowContext workflowContext) {

        if(DataUtil.isEmpty(this.data().getJobContent())) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Parse job content failed -- empty content error.", "作业内容为空", this.data());
        }
        try {

            JSONObject jsonContent = JSONObject.parseObject(this.data().getJobContent());
            JSONArray jsonWaitHeadNodes = jsonContent.getJSONArray(JOB_CONTENT_KEY_WAIT_HEAD_NODES);
            JSONArray jsonWaitNodes = jsonContent.getJSONArray(JOB_CONTENT_KEY_WAIT_NODES);
            JSONArray jsonPendingNodes = jsonContent.getJSONArray(JOB_CONTENT_KEY_PENDING_NODES);
          //JSONObject jsonPreparingNodes = jsonContent.getJSONObject(JOB_CONTENT_KEY_PREPARING_NODES);
          //JSONObject jsonReadyNodes = jsonContent.getJSONObject(JOB_CONTENT_KEY_READY_NODES);
            JSONObject jsonRunningNodes = jsonContent.getJSONObject(JOB_CONTENT_KEY_RUNNING_NODES);
            JSONObject jsonSuccessNodes = jsonContent.getJSONObject(JOB_CONTENT_KEY_SUCCESS_NODES);
            JSONObject jsonErrorNodes = jsonContent.getJSONObject(JOB_CONTENT_KEY_ERROR_NODES);
            JSONObject jsonTerminatedNodes = jsonContent.getJSONObject(JOB_CONTENT_KEY_TERMINATED_NODES);

            this.parseJSONArray(workflowContext, jsonWaitHeadNodes, this.waitHeadNodes);
            this.parseJSONArray(workflowContext, jsonWaitNodes, this.waitNodes);
            this.parseJSONArray(workflowContext, jsonPendingNodes, this.pendingNodes);
          //this.parseJSONObject(workflowContext, jsonPreparingNodes, this.preparingNodes);
          //this.parseJSONObject(workflowContext, jsonReadyNodes, this.readyNodes);
            this.parseJSONObject(workflowContext, jsonRunningNodes, this.runningNodes);
            this.parseJSONObject(workflowContext, jsonSuccessNodes, this.successNodes);
            this.parseJSONObject(workflowContext, jsonErrorNodes, this.errorNodes);
            this.parseJSONObject(workflowContext, jsonTerminatedNodes, this.terminatedNodes);

            jsonContent.clear();
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Parse job content failed -- job content error.", "作业内容错误", e, this.data());
        }
    }

    private void parseJSONArray(WorkflowContext workflowContext, JSONArray jsonArray, TreeSet<Node> nodes) {
        if(DataUtil.isNotEmpty(jsonArray)) {
            for (int i = 0; i < jsonArray.size(); i++) {
                Long nodeId = jsonArray.getLong(i);
                nodes.add(workflowContext.fetchNode(nodeId));
            }
        }
    }

    private void parseJSONObject(WorkflowContext workflowContext, JSONObject jsonObject, TreeMap<Node, Long> nodes) {
        if(DataUtil.isNotEmpty(jsonObject)) {
            for(Map.Entry<String, Object> entry : jsonObject.entrySet()) {
                Long nodeId = Long.parseLong(entry.getKey());
                Long taskId = jsonObject.getLong(entry.getKey());
                nodes.put(workflowContext.getNode(nodeId), taskId);
            }
        }
    }

    public boolean enableFlushSnapshot() {
        return JobTypeEnum.enableFlushSnapshot(JobTypeEnum.valueOf(this.data().getJobType()));
    }

    public Snapshot getSnapshot() {
        if(DataUtil.isNull(snapshot)) {
            snapshot = SnapshotHelper.querySnapshot4Execution(this);
            this.syncJobState2SnapshotAndWorkflow();
        }
        return snapshot;
    }

    public void increaseNextTaskSequence() {
        this.data().setNextTaskSequence(this.data().getNextTaskSequence() + 1);
    }

    public boolean isStatePreparing() {
        return this.data().getJobState() == JobStateEnum.PREPARING.getState();
    }

    public boolean isStateQueueing() {
        return this.data().getJobState() == JobStateEnum.QUEUEING.getState();
    }

    public boolean isStateRunning() {
        return this.data().getJobState() == JobStateEnum.RUNNING.getState();
    }

    public boolean isStateSuccess() {
        return this.data().getJobState() == JobStateEnum.SUCCESS.getState();
    }

    public boolean isStateErrorTerminated() {
        return this.data().getJobState() == JobStateEnum.ERROR_TERMINATED.getState();
    }

    public boolean isStateUserTerminated() {
        return this.data().getJobState() == JobStateEnum.USER_TERMINATED.getState();
    }

    public void changeState2Queueing() {
        this.changeJobState(JobStateEnum.QUEUEING);
    }

    public void changeState2Running() {
        this.changeJobState(JobStateEnum.RUNNING);
    }

    public void changeState2Success() {
        this.changeJobState(JobStateEnum.SUCCESS);
    }

    public void changeState2ErrorTerminated() {
        this.changeJobState(JobStateEnum.ERROR_TERMINATED);
    }

    public void changeState2UserTerminated() {
        this.changeJobState(JobStateEnum.USER_TERMINATED);
    }

    private void changeJobState(JobStateEnum jobState) {
        if(this.data().getJobState() == jobState.getState())
            return;

        this.data().setJobState(jobState.getState());
        this.syncJobState2SnapshotAndWorkflow(jobState);
    }

    public void syncJobState2SnapshotAndWorkflow() {
        this.syncJobState2SnapshotAndWorkflow(JobStateEnum.valueOf(this.data().getJobState()));
    }

    private void syncJobState2SnapshotAndWorkflow(JobStateEnum jobState) {
        switch (jobState) {
            case PREPARING:
                this.snapshot.getWorkflow().changeState2Preparing();
                this.syncJobId2Workflow();
                break;
            case QUEUEING:
                this.snapshot.getWorkflow().changeState2Preparing();
                this.syncJobId2Workflow();
                break;
            case RUNNING:
                this.snapshot.getWorkflow().changeState2Running();
                this.syncJobId2Workflow();
                break;
            case SUCCESS:
                this.snapshot.changeState2Finished();
                this.snapshot.getWorkflow().changeState2Finished();
                this.syncJobId2Workflow();
                break;
            case ERROR_TERMINATED:
                this.snapshot.changeState2Finished();
                this.snapshot.getWorkflow().changeState2Finished();
                this.syncJobId2Workflow();
                break;
            case USER_TERMINATED:
                this.snapshot.changeState2Finished();
                this.snapshot.getWorkflow().changeState2Finished();
                this.syncJobId2Workflow();
                break;
            default:
                break;
        }
    }

    private void syncJobId2Workflow() {
        Long lastJobId = this.snapshot.getWorkflow().data().getLastJobId();
        if(DataUtil.isNull(lastJobId) || !lastJobId.equals(this.data().getJobId()))
            this.snapshot.getWorkflow().data().setLastJobId(this.data().getJobId());
    }

    public boolean enableFlushWorkflow() {
        return JobTypeEnum.enableFlushWorkflow(JobTypeEnum.valueOf(this.data().getJobType()));
    }

    public TreeSet<Node> getWaitHeadNodes() {
        return waitHeadNodes;
    }

    public TreeSet<Node> getWaitNodes() {
        return waitNodes;
    }

    public TreeSet<Node> getPendingNodes() {
        return pendingNodes;
    }

    public TreeMap<Node, Long> getRunningNodes() {
        return runningNodes;
    }

    public TreeMap<Node, Long> getSuccessNodes() {
        return successNodes;
    }

    public TreeMap<Node, Long> getErrorNodes() {
        return errorNodes;
    }

    public TreeMap<Node, Long> getTerminatedNodes() {
        return terminatedNodes;
    }

    //TODO Job Execution Daemon Process Steps (集群并发粒度控制???)
    // 1. Deal kill signal jobs, monitor running tasks, kill running task ...
    // 2. Deal running jobs, monitor running tasks ...
    //  PS: use external-id or return-file, deal both missing case(比如集群挂掉), 暂不考虑redo submit task
    // 3. Deal queueing jobs, prepare head tasks ...

    //Deal kill signal jobs
    // 检测是否有任务已经完成，然后进入kill tasks
    // Return running tasks, loop<kill task & clear output resources>
    // Not support SIG_PAUSE & SIG_CONT

    //Deal running jobs
    // 1.scan job queue, scan task queue???
    // 2.monitor task, return-result analyze, complete task, synchronize task result to workflow
    // 3.has next tobe running nodes, loop<create & submit task>
    // 4.no tobe running nodes {
    //  cond-A: occur error
    //
    //
    // }

    //Deal queueing jobs
    // Return head nodes, loop<create & submit task>, change job state to running
    //  PS: queueing VS no tobe running head nodes, end job immediately


    //TODO Running => Finished, synchronize job result to workflow
    //TODO 每个任务运行处理结束，分析当前作业状态，是否终止，否则是否还有就绪的可执行节点（综合KILL信号、运行出错、作业内容信息进行推断和生成结果）

}
