package com.yatop.lambda.workflow.core.mgr.workflow.execution.queue;

import com.yatop.lambda.base.model.WfExecutionJobQueue;
import com.yatop.lambda.core.enums.JobSignalEnum;
import com.yatop.lambda.core.enums.JobStateEnum;
import com.yatop.lambda.core.mgr.workflow.execution.ExecutionJobQueueMgr;
import com.yatop.lambda.core.utils.PagerUtil;
import com.yatop.lambda.workflow.core.richmodel.workflow.execution.ExecutionJob;
import com.yatop.lambda.workflow.core.richmodel.workflow.execution.ExecutionJobQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JobQueueHelper {

    private static ExecutionJobQueueMgr EXECUTION_JOB_QUEUE_MGR;

    @Autowired
    public void setExecutionJobQueueMgr(ExecutionJobQueueMgr executionJobQueueMgr) {
        EXECUTION_JOB_QUEUE_MGR = executionJobQueueMgr;
    }

    public static ExecutionJobQueue pushJobToQueue(ExecutionJob job, String operId) {
        WfExecutionJobQueue jobQueue = new WfExecutionJobQueue();
        jobQueue.setJobId(job.data().getJobId());
        jobQueue.setOwnerProjectId(job.data().getOwnerProjectId());
        jobQueue.setJobTime(job.data().getJobTime());
        EXECUTION_JOB_QUEUE_MGR.insertQueue(jobQueue, operId);

        return new ExecutionJobQueue(jobQueue);
    }

    public static void removeJobFromQueue(ExecutionJob job) {
        EXECUTION_JOB_QUEUE_MGR.removeQueue(job.data().getJobId());
    }

    /*public static ExecutionJobQueue queryJobInQueue(ExecutionJob job) {
        return new ExecutionJobQueue(EXECUTION_JOB_QUEUE_MGR.queryQueue(job.data().getJobId()));
    }*/

    public static void updateJobInQueue(ExecutionJobQueue jobQueue, String operId) {
        EXECUTION_JOB_QUEUE_MGR.updateQueue(jobQueue.data(), operId);
        jobQueue.clearColoured();
    }

    public static List<WfExecutionJobQueue> queryRunningJobs(int topN) {
        return EXECUTION_JOB_QUEUE_MGR.queryQueue(JobSignalEnum.SIG_NORMAL, JobStateEnum.RUNNING, PagerUtil.Pager4TopN(topN));
    }

    public static List<WfExecutionJobQueue> queryQueueingJobs(int topN) {
        return EXECUTION_JOB_QUEUE_MGR.queryQueue(JobSignalEnum.SIG_NORMAL, JobStateEnum.QUEUEING, PagerUtil.Pager4TopN(topN));
    }

    public static List<WfExecutionJobQueue> querKillJobs() {
        return EXECUTION_JOB_QUEUE_MGR.queryQueue(JobSignalEnum.SIG_KILL, null, null);
    }
}
