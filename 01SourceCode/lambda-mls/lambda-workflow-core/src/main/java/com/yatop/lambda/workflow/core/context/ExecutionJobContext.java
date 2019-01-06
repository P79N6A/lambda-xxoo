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
    private TreeMap<Long, ExecutionTask> tasksOrderByNodeId = new TreeMap<Long, ExecutionTask>();      //操作关联运行任务
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
        workflowContext.clear();
        workflowContext = null;
        operId = null;
        CollectionUtil.enhancedClear(tasks);
        CollectionUtil.clear(tasksOrderByNodeId);
    }

    public void flush() {
        if(this.taskCount() > 0) {
            for(ExecutionTask task : this.getTasks()) {
                task.flush(this.operId);
            }
        }

        this.job.flush(this.operId);
        this.workflowContext.flush();
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

    public ExecutionTask getTask(Long taskId) {
        return tasks.get(taskId);
    }

    public ExecutionTask getTaskByNodeId(Long nodeId) {
        return tasksOrderByNodeId.get(nodeId);
    }

    public List<ExecutionTask> getTasks() {
        return CollectionUtil.toList(tasks);
    }

    public void putTask(ExecutionTask task) {
        CollectionUtil.put(tasks, task.data().getTaskId(), task);
        CollectionUtil.put(tasksOrderByNodeId, task.data().getRelNodeId(), task);
    }
}
