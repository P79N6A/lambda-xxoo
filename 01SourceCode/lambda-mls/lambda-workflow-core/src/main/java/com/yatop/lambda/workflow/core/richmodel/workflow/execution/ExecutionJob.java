package com.yatop.lambda.workflow.core.richmodel.workflow.execution;

import com.yatop.lambda.base.model.WfExecutionJob;
import com.yatop.lambda.core.enums.JobStateEnum;
import com.yatop.lambda.workflow.core.richmodel.IRichModel;

public class ExecutionJob extends WfExecutionJob implements IRichModel {

    public ExecutionJob(WfExecutionJob data) {
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

    public boolean isStatePreparing() {
        return this.getJobState() == JobStateEnum.PREPARING.getState();
    }

    public boolean isStateQueueing() {
        return this.getJobState() == JobStateEnum.QUEUEING.getState();
    }

    public boolean isStateRunning() {
        return this.getJobState() == JobStateEnum.RUNNING.getState();
    }

    public boolean isStateSuccess() {
        return this.getJobState() == JobStateEnum.SUCCESS.getState();
    }

    public boolean isStateErrorTerminated() {
        return this.getJobState() == JobStateEnum.ERROR_TERMINATED.getState();
    }

    public boolean isStateUserTerminated() {
        return this.getJobState() == JobStateEnum.USER_TERMINATED.getState();
    }

    public void changeState2Queueing() {
        this.changeJobState(JobStateEnum.QUEUEING);
    }

    public void changeState2Running() {
        this.changeJobState(JobStateEnum.RUNNING);
    }

    public void changeState2Success() {
        this.changeJobState(JobStateEnum.SUCCESS);
    }

    public void changeState2ErrorTerminated() {
        this.changeJobState(JobStateEnum.ERROR_TERMINATED);
    }

    public void changeState2UserTerminated() {
        this.changeJobState(JobStateEnum.USER_TERMINATED);
    }

    private void changeJobState(JobStateEnum stateEnum) {
        if(this.getJobState() == stateEnum.getState())
            return;

        this.setJobState(stateEnum.getState());
    }
}
