package com.yatop.lambda.workflow.core.richmodel.workflow.execution;

import com.yatop.lambda.base.model.WfExecutionTask;
import com.yatop.lambda.core.enums.TaskStateEnum;
import com.yatop.lambda.workflow.core.richmodel.IRichModel;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.Node;
import com.yatop.lambda.workflow.core.utils.CollectionUtil;

import java.util.List;
import java.util.TreeMap;

public class ExecutionTask extends WfExecutionTask implements IRichModel {

    private Node node;  //操作关联节点
    private TreeMap<String, ExecutionTaskOutput> taskOutputs = new TreeMap<String, ExecutionTaskOutput>();   //任务输出内容

    public ExecutionTask(WfExecutionTask data, Node node) {
        super.copyProperties(data);
        this.node = node;
        this.clearColoured();
    }

    @Override
    public void clear() {
        taskOutputs.clear();
        super.clear();
    }

    public void flush(String operId) {

        if (this.taskOutputCount() > 0) {
            for (ExecutionTaskOutput taskOutput : this.getTaskOutputs()) {
                taskOutput.flush(operId);
            }
        }
        if (this.isColoured())
            ;//NodeHelper.updateNode(this, operId);
    }

    public boolean isStatePreparing() {
        return this.getTaskState() == TaskStateEnum.PREPARING.getState();
    }

    public boolean isStateReady() {
        return this.getTaskState() == TaskStateEnum.READY.getState();
    }

    public boolean isStateRunning() {
        return this.getTaskState() == TaskStateEnum.RUNNING.getState();
    }

    public boolean isStateSuccess() {
        return this.getTaskState() == TaskStateEnum.SUCCESS.getState();
    }

    public boolean isStateErrorTerminated() {
        return this.getTaskState() == TaskStateEnum.ERROR_TERMINATED.getState();
    }

    public boolean isStateUserTerminated() {
        return this.getTaskState() == TaskStateEnum.USER_TERMINATED.getState();
    }

    public void changeState2Ready() {
        this.changeTaskState(TaskStateEnum.READY);
    }

    public void changeState2Running() {
        this.changeTaskState(TaskStateEnum.RUNNING);
    }

    public void changeState2Success() {
        this.changeTaskState(TaskStateEnum.SUCCESS);
    }

    public void changeState2ErrorTerminated() {
        this.changeTaskState(TaskStateEnum.ERROR_TERMINATED);
    }

    public void changeState2UserTerminated() {
        this.changeTaskState(TaskStateEnum.USER_TERMINATED);
    }

    private void changeTaskState(TaskStateEnum stateEnum) {
        if(this.getTaskState() == stateEnum.getState())
            return;

        this.setTaskState(stateEnum.getState());
    }

    public Node getNode() {
        return this.node;
    }

    public int taskOutputCount() {
        return taskOutputs.size();
    }

    public List<ExecutionTaskOutput> getTaskOutputs() {
        return CollectionUtil.toList(taskOutputs);
    }

    public ExecutionTaskOutput getTaskOutput(String charId) {
        return CollectionUtil.get(taskOutputs, charId);
    }

    public void putTaskOutput(ExecutionTaskOutput taskOutput) {
        CollectionUtil.put(taskOutputs, taskOutput.getCharId(), taskOutput);
    }
}
