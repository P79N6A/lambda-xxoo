package com.yatop.lambda.workflow.core.richmodel.workflow;

import com.yatop.lambda.base.model.WfFlow;
import com.yatop.lambda.core.enums.ShareLockStateEnum;
import com.yatop.lambda.workflow.core.richmodel.IRichModel;
import com.yatop.lambda.workflow.core.richmodel.experiment.Experiment;
import com.yatop.lambda.workflow.core.richmodel.project.Project;
import com.yatop.lambda.workflow.core.richmodel.workflow.execution.ExecutionJob;

public class Workflow extends WfFlow implements IRichModel {

    private static long NODE_DELETE_MAX_SEQUENCE = 0x20;

    public Workflow(WfFlow data) {
        super.copyProperties(data);
        this.clearColoured();
    }

    public Long previousDeleteSequence() {
        return Math.abs( (this.getNextDeleteSequence() - 1) % NODE_DELETE_MAX_SEQUENCE );
    }

    public Long generateNextDeleteSequence() {
        return Math.abs( (this.getNextDeleteSequence() + 1) % NODE_DELETE_MAX_SEQUENCE );
    }

    public void increaseNodeCount() {
        this.setNodeCount(this.getNodeCount() + 1);
    }

    public void increaseNextSnapshotVersion() {
        this.setNextSnapshotVersion(this.getNextSnapshotVersion() + 1);
    }

    public void increaseVersion() {
        this.setVersion(this.getVersion() + 1);
    }

    public boolean isWorkflowLocked() {
        return this.getShareLockState() == ShareLockStateEnum.LOCKED.getState();
    }

    public boolean lockWorkflow() {
        if(this.getShareLockState() == ShareLockStateEnum.LOCKED.getState())
            return false;

        this.setShareLockState(ShareLockStateEnum.LOCKED.getState());
        return true;
    }

    public boolean unlockWorkflow() {
        if(this.getShareLockState() == ShareLockStateEnum.UNLOCKED.getState())
            return false;

        this.setShareLockState(ShareLockStateEnum.UNLOCKED.getState());
        return true;
    }

    public void doneDeleteNodes(Long nodeCount) {
        this.setNodeCount(this.getNodeCount() - nodeCount);
        this.setNextDeleteSequence(generateNextDeleteSequence());
    }

    public void doneRecoverNodes(Long nodeCount) {
        this.setNodeCount(this.getNodeCount() + nodeCount);
        this.setNextDeleteSequence(previousDeleteSequence());
    }

    @Override
    public void clear() {
        super.clear();
    }
}
