package com.yatop.lambda.workflow.engine.service;

import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.context.WorkflowContext;
import com.yatop.lambda.workflow.core.richmodel.workflow.execution.ExecutionJobQueue;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ExecutionService {

    @Transactional
    public void processKillSignalJob(ExecutionJobQueue jobQueue) {

    }

    public void processRunningJob(ExecutionJobQueue jobQueue) {
        WorkflowContext workflowContext = WorkflowContext.BuildWorkflowContext4Execution(jobQueue.data().getJobId(), jobQueue.data().getCreateOper());

        monitorRunningJob(jobQueue);

        if(DataUtil.isNotNull(workflowContext) && workflowContext.getCurrentJob().getPendingNodes().size() > 0) {
            executePendingNodes(workflowContext);
        }
    }

    public void processQueueingJob(ExecutionJobQueue jobQueue) {

    }

    @Transactional
    public WorkflowContext monitorRunningJob(ExecutionJobQueue jobQueue) {

        return null;
    }

    @Transactional
    public void executePendingNodes(WorkflowContext workflowContext) {

    }
}
