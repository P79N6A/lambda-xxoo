package com.yatop.lambda.workflow.core.mgr.workflow.execution.job;

import com.yatop.lambda.core.mgr.workflow.execution.ExecutionJobMgr;
import com.yatop.lambda.workflow.core.richmodel.workflow.execution.ExecutionJob;
import com.yatop.lambda.workflow.core.richmodel.workflow.execution.ExecutionJobQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JobHelper {

    private static ExecutionJobMgr EXECUTION_JOB_MGR;

    @Autowired
    public static void setExecutionJobMgr(ExecutionJobMgr executionJobMgr) {
        EXECUTION_JOB_MGR = executionJobMgr;
    }

    public static ExecutionJob queryExecutionJob(Long jobId) {
        return ExecutionJob.BuildExecutionJob(EXECUTION_JOB_MGR.queryJob(jobId));
    }

    public static ExecutionJob queryExecutionJob(ExecutionJobQueue jobQueue) {
        return queryExecutionJob(jobQueue.data().getJobId());
    }

    public static void updateExecutionJob(ExecutionJob executionJob, String operId) {
        EXECUTION_JOB_MGR.updateJob(executionJob.data(), operId);
        executionJob.clearColoured();
    }

}
