package com.yatop.lambda.workflow.core.richmodel.workflow.execution;

import com.yatop.lambda.base.model.WfExecutionTask;
import com.yatop.lambda.core.enums.TaskStateEnum;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.richmodel.RichModel;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.Node;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.NodeOutput;
import com.yatop.lambda.workflow.core.richmodel.workflow.charvalue.CharValue;
import com.yatop.lambda.workflow.core.utils.CollectionUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class ExecutionTask extends RichModel<WfExecutionTask> {

    private Node node;  //操作关联节点
    private TreeMap<String, NodeOutput> outputs = new TreeMap<String, NodeOutput>();   //任务输出内容

    public ExecutionTask(WfExecutionTask data, Node node) {
        super(data);
        this.node = node;
    }

    @Override
    public void clear() {
        node = null;
        CollectionUtil.enhancedClear(outputs);
        super.clear();
    }

    public void flush(String operId) {

        if (this.taskOutputCount() > 0) {
            for (NodeOutput nodeOutput : this.getOutputs()) {
                nodeOutput.flush(operId);
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

    private void changeState2ErrorTerminated() {
        this.changeTaskState(TaskStateEnum.ERROR_TERMINATED);
    }

    public void changeState2UserTerminated() {
        this.changeTaskState(TaskStateEnum.USER_TERMINATED);
    }

    private void changeTaskState(TaskStateEnum taskState) {
        if(this.data().getTaskState() == taskState.getState())
            return;

        this.data().setTaskState(taskState.getState());
        this.syncTaskState2Node(taskState);
    }

    public void syncTaskState2Node() {
        this.syncTaskState2Node(TaskStateEnum.valueOf(this.data().getTaskState()));
    }

    private void syncTaskState2Node(TaskStateEnum taskState) {
        switch (taskState) {
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
                this.syncTaskId2Node();
                break;
            case USER_TERMINATED:
                this.node.downgradeState2Ready();
                this.syncTaskId2Node();
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

    /*private void clearTaskId2Node() {
        Long lastTaskId = this.node.data().getLastTaskId();
        if(DataUtil.isNotNull(lastTaskId) || lastTaskId.equals(this.data().getTaskId()))
            this.node.data().setLastTaskId(null);
    }*/

    public Node getNode() {
        return this.node;
    }

    public int taskOutputCount() {
        return outputs.size();
    }

    public List<NodeOutput> getOutputs() {
        return CollectionUtil.toList(outputs);
    }

    public NodeOutput getOutput(String charId) {
        return CollectionUtil.get(outputs, charId);
    }

    public CharValue getOutputCharValue(String charId) {
        return CollectionUtil.get(outputs, charId).getCharValue();
    }

    public List<CharValue> getOutputCharValues() {
        if(taskOutputCount() == 0)
            return null;

        List<CharValue> charValues = new ArrayList<CharValue>();
        for(NodeOutput output : getOutputs()) {
            charValues.add(output.getCharValue());
        }
        return charValues;
    }

    public void putTaskOutput(NodeOutput nodeOutput) {
        CollectionUtil.put(outputs, nodeOutput.data().getCharId(), nodeOutput);
    }

    public boolean isOccuredWarning() {
        return DataUtil.isNotEmpty(this.data().getWarningMsg());
    }

    public void setOccuredWarning(String warningMsg) {
        this.data().setWarningMsg(warningMsg);
        changeState2ErrorTerminated();
    }
}
