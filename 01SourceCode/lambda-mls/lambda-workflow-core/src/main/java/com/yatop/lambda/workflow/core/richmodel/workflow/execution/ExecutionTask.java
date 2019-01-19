package com.yatop.lambda.workflow.core.richmodel.workflow.execution;

import com.yatop.lambda.base.model.WfExecutionTask;
import com.yatop.lambda.core.enums.TaskStateEnum;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.richmodel.RichModel;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.Node;
import com.yatop.lambda.workflow.core.utils.CollectionUtil;

import java.util.List;
import java.util.TreeMap;

public class ExecutionTask extends RichModel<WfExecutionTask> {

    private Node node;  //操作关联节点
    private TreeMap<String, ExecutionTaskOutput> taskOutputs = new TreeMap<String, ExecutionTaskOutput>();   //任务输出内容

    public ExecutionTask(WfExecutionTask data, Node node) {
        super(data);
        this.node = node;
    }

    @Override
    public void clear() {
        node = null;
        CollectionUtil.enhancedClear(taskOutputs);
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
        return this.data().getTaskState() == TaskStateEnum.PREPARING.getState();
    }

    public boolean isStateReady() {
        return this.data().getTaskState() == TaskStateEnum.READY.getState();
    }

    public boolean isStateRunning() {
        return this.data().getTaskState() == TaskStateEnum.RUNNING.getState();
    }

    public boolean isStateSuccess() {
        return this.data().getTaskState() == TaskStateEnum.SUCCESS.getState();
    }

    public boolean isStateErrorTerminated() {
        return this.data().getTaskState() == TaskStateEnum.ERROR_TERMINATED.getState();
    }

    public boolean isStateUserTerminated() {
        return this.data().getTaskState() == TaskStateEnum.USER_TERMINATED.getState();
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
        if(this.data().getTaskState() == stateEnum.getState())
            return;

        this.data().setTaskState(stateEnum.getState());
        this.syncTaskState2Node(stateEnum);
    }

    public void syncTaskState2Node() {
        this.syncTaskState2Node(TaskStateEnum.valueOf(this.data().getTaskState()));
    }

    private void syncTaskState2Node(TaskStateEnum stateEnum) {
        switch (stateEnum) {
            case PREPARING:
            case READY:
                this.node.changeState2Preparing();
                this.syncTaskId2Node();
                break;
            case RUNNING:
                this.node.changeState2Running();
                this.syncTaskId2Node();
                break;
            case SUCCESS:
                this.node.changeState2Success();
                this.syncTaskId2Node();
                break;
            case ERROR_TERMINATED:
                this.node.changeState2Error();
                this.clearTaskId2Node();
                break;
            case USER_TERMINATED:
                this.node.downgradeState2Ready();
                this.clearTaskId2Node();
                break;
            default:
                break;
        }
    }

    private void syncTaskId2Node() {
        Long lastTaskId = this.node.data().getLastTaskId();
        if(DataUtil.isNull(lastTaskId) || !lastTaskId.equals(this.data().getTaskId()))
            this.node.data().setLastTaskId(this.data().getTaskId());
    }

    private void clearTaskId2Node() {
        Long lastTaskId = this.node.data().getLastTaskId();
        if(DataUtil.isNotNull(lastTaskId) || lastTaskId.equals(this.data().getTaskId()))
            this.node.data().setLastTaskId(null);
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
        CollectionUtil.put(taskOutputs, taskOutput.data().getCharId(), taskOutput);
    }

    public boolean isOccuredWarning() {
        return DataUtil.isNotEmpty(this.data().getWarningMsg());
    }

    public void changeOccuredWarning(String warningMsg) {
        this.data().setWarningMsg(warningMsg);
        changeState2ErrorTerminated();
    }

    /*
    public void clearOccuredWarning() {
        if(DataUtil.isNotEmpty(this.data().getWarningMsg()))
            this.data().setWarningMsg(null);
    }
    */
}
