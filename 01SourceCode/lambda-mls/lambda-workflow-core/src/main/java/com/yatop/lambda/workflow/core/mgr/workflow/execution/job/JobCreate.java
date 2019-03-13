package com.yatop.lambda.workflow.core.mgr.workflow.execution.job;

import com.yatop.lambda.base.model.WfExecutionJob;
import com.yatop.lambda.core.enums.JobTypeEnum;
import com.yatop.lambda.core.enums.LambdaExceptionEnum;
import com.yatop.lambda.core.exception.LambdaException;
import com.yatop.lambda.core.mgr.workflow.execution.ExecutionJobMgr;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.core.utils.SystemTimeUtil;
import com.yatop.lambda.core.utils.WorkDirectoryUtil;
import com.yatop.lambda.workflow.core.context.WorkflowContext;
import com.yatop.lambda.workflow.core.mgr.workflow.execution.job.analyzer.JobContentAnalyzer;
import com.yatop.lambda.workflow.core.mgr.workflow.execution.queue.JobQueueHelper;
import com.yatop.lambda.workflow.core.mgr.workflow.snapshot.SnapshotCreate;
import com.yatop.lambda.workflow.core.richmodel.experiment.Experiment;
import com.yatop.lambda.workflow.core.richmodel.workflow.Workflow;
import com.yatop.lambda.workflow.core.richmodel.workflow.execution.ExecutionJob;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.Node;
import com.yatop.lambda.workflow.core.richmodel.workflow.snapshot.Snapshot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.TreeSet;
import java.util.List;

@Service
public class JobCreate {

    @Autowired
    private ExecutionJobMgr executionJobMgr;

    @Autowired
    private SnapshotCreate snapshotCreate;

    private ExecutionJob createJob(WorkflowContext workflowContext, JobTypeEnum jobType, Node relatedNode, Date jobTime) {

        List<TreeSet<Node>> initialJobContent = JobContentAnalyzer.analyzeJobContent(workflowContext, jobType, relatedNode);
        if(DataUtil.isNull(initialJobContent) || initialJobContent.size() != 2 || DataUtil.isEmpty(initialJobContent.get(0)))  {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Create job content failed -- no executable nodes.", "无可运行节点");
        }

        Snapshot snapShot = snapshotCreate.createSnapshot4Execution(workflowContext);
        Workflow workflow = workflowContext.getWorkflow();
        WfExecutionJob job = new WfExecutionJob();
        job.setJobName(workflow.getExperiment().data().getExperimentName() + " - " + jobType.getName());
        job.setJobType(jobType.getType());
        job.setOwnerProjectId(workflow.data().getOwnerProjectId());
        job.setRelFlowId(workflow.data().getFlowId());
        job.setRelSnapshotId(snapShot.data().getSnapshotId());
        job.setRelNodeId(DataUtil.isNotNull(relatedNode) ? relatedNode.data().getNodeId() : -1L);
        if(DataUtil.isNull(jobTime)) {
            job.setJobTime(SystemTimeUtil.getCurrentTime());
        } else {
            job.setJobTime(jobTime);
        }

        job = executionJobMgr.insertJob(job, workflowContext.getOperId());

        Experiment experiment= workflowContext.getExperiment();
        job.setJobDfsDir(WorkDirectoryUtil.getJobDfsDirectory(experiment.data().getOwnerProjectId(), workflow.data().getFlowId(), job.getJobId()));
        job.setJobLocalDir(WorkDirectoryUtil.getJobLocalDirectory(experiment.data().getOwnerProjectId(), workflow.data().getFlowId(), job.getJobId()));
        //executionJobMgr.updateJob(job, workflowContext.getOperId());

        ExecutionJob richJob = ExecutionJob.BuildExecutionJob4Create(job, workflowContext, snapShot, initialJobContent);
        workflow.lockWorkflow(String.format("工作流作业运行加锁 - %d", richJob.data().getJobId()));
        workflow.changeState2Preparing();

        JobQueueHelper.pushJobToQueue(richJob, workflowContext.getOperId());
        richJob.changeState2Queueing();

        //flush workflowContext, execution job, execution snapshot
        workflowContext.flush();
        richJob.flush(workflowContext);
        workflowContext.clear();
        return richJob;
    }

    public ExecutionJob createJob4RunAll(WorkflowContext workflowContext) {
        return createJob(workflowContext, JobTypeEnum.RUN_ALL, null, null);
    }

    public ExecutionJob createJob4RunStartHere(WorkflowContext workflowContext, Node relatedNode) {

        if(DataUtil.isNull(relatedNode))  {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Create job failed -- related node missing.", "运行关联节点缺失");
        }

        return createJob(workflowContext, JobTypeEnum.RUN_START_HERE, relatedNode, null);
    }

    public ExecutionJob createJob4RunEndHere(WorkflowContext workflowContext, Node relatedNode) {

        if(DataUtil.isNull(relatedNode))  {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Create job failed -- related node missing.", "运行关联节点缺失");
        }

        return createJob(workflowContext, JobTypeEnum.RUN_END_HERE, relatedNode, null);
    }

    public ExecutionJob createJob4RunThisNode(WorkflowContext workflowContext, Node relatedNode) {

        if(DataUtil.isNull(relatedNode))  {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Create job failed -- related node missing.", "运行关联节点缺失");
        }

        return createJob(workflowContext, JobTypeEnum.RUN_THIS_NODE, relatedNode, null);
    }

/*    public ExecutionJob createJob4RunOfflineSchedule(WorkflowContext workflowContext, Date jobTime) {
        return createJob(workflowContext, JobTypeEnum.RUN_OFFLINE_SCHEDULE, null, jobTime);
    }

    public ExecutionJob createJob4RunOnlineSchedule(WorkflowContext workflowContext) {
        return createJob(workflowContext, JobTypeEnum.RUN_ONLINE_SCHEDULE, null, null);
    }*/

    public ExecutionJob createJob4RunDatafileImport(WorkflowContext workflowContext) {
        return createJob(workflowContext, JobTypeEnum.RUN_DATAFILE_IMPORT, null, null);
    }
}
