package com.yatop.lambda.workflow.core.context;

import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.richmodel.workflow.execution.ExecutionJob;
import com.yatop.lambda.workflow.core.utils.CollectionUtil;

import java.util.List;
import java.util.TreeMap;

public class JobExecutionContext implements IWorkContext {

    private ExecutionJob job;       //操作关联运行作业
    private WorkflowContext workflowContext;    //作业内容的工作流上下文

    public JobExecutionContext(ExecutionJob job, WorkflowContext workflowContext) {
        this.job = job;
        this.workflowContext = workflowContext;
    }

    @Override
    public void clear() {
        job = null;
        workflowContext = null;
    }

    public void flush() {
        this.job.flush(workflowContext.getOperId());
        this.workflowContext.getWorkflow().flush(workflowContext.getOperId());
    }

    public ExecutionJob getJob() {
        return job;
    }

    public WorkflowContext getWorkflowContext() {
        return workflowContext;
    }
}
