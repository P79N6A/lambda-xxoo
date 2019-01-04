package com.yatop.lambda.workflow.core.context;

import com.yatop.lambda.workflow.core.richmodel.workflow.execution.ExecutionJob;
import com.yatop.lambda.workflow.core.richmodel.workflow.execution.ExecutionTask;
import com.yatop.lambda.workflow.core.utils.CollectionUtil;

import java.util.List;
import java.util.TreeMap;

public class ExecutionJobContext implements IWorkContext {

    private ExecutionJob job;       //操作关联运行作业
    private WorkflowContext workflowContext;    //作业内容的工作流上下文
    private TreeMap<Long, ExecutionTask> tasks = new TreeMap<Long, ExecutionTask>();      //操作关联运行任务
    private String operId;

    public ExecutionJobContext(ExecutionJob job, WorkflowContext workflowContext, String operId) {
        //TODO check workflow context execution work mode ???

        this.job = job;
        this.workflowContext = workflowContext;
        this.operId = operId;
    }

    @Override
    public void clear() {
        job = null;
        workflowContext = null;
    }

    public void flush() {
        this.job.flush(this.operId);
        this.workflowContext.getWorkflow().flush(this.operId);
    }

    public ExecutionJob getJob() {
        return job;
    }
    
    public WorkflowContext getWorkflowContext() {
        return workflowContext;
    }

    public int taskCount() {
        return tasks.size();
    }

    public ExecutionTask getNode(Long taskId) {
        return tasks.get(taskId);
    }

    public List<ExecutionTask> getNodes() {
        return CollectionUtil.toList(tasks);
    }

    public void putTask(ExecutionTask task) {
        CollectionUtil.put(tasks, task.getTaskId(), task);
    }
}
