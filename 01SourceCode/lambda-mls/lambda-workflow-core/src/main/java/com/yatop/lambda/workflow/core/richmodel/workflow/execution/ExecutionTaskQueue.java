package com.yatop.lambda.workflow.core.richmodel.workflow.execution;

import com.yatop.lambda.base.model.WfExecutionTaskQueue;
import com.yatop.lambda.core.enums.TaskStateEnum;
import com.yatop.lambda.workflow.core.richmodel.IRichModel;

public class ExecutionTaskQueue extends WfExecutionTaskQueue implements IRichModel {

    public ExecutionTaskQueue(WfExecutionTaskQueue data) {
        super.copyProperties(data);
        this.clearColoured();
    }

    public void flush(String operId) {

        if (this.isColoured())
            ;//NodeHelper.updateNode(this, operId);
    }

    @Override
    public void clear() {
        super.clear();
    }

    public void changeState2Running() {
        this.changeTaskState(TaskStateEnum.RUNNING);
    }

    private void changeTaskState(TaskStateEnum stateEnum) {
        if(this.getTaskState() == stateEnum.getState())
            return;

        this.setTaskState(stateEnum.getState());
    }
}
