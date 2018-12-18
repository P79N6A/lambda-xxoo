package com.yatop.lambda.workflow.core.richmodel.workflow;

import com.yatop.lambda.base.model.WfFlow;
import com.yatop.lambda.workflow.core.richmodel.IRichModel;
import com.yatop.lambda.workflow.core.richmodel.experiment.Experiment;
import com.yatop.lambda.workflow.core.richmodel.project.Project;
import com.yatop.lambda.workflow.core.richmodel.workflow.execution.ExecutionJob;

public class Workflow extends WfFlow implements IRichModel {

    ExecutionJob lastJob;

    public Workflow() {}

    public Workflow(WfFlow data) {super.copyProperties(data);}

    @Override
    public void clear() {
        lastJob = null;
        super.clear();
    }

    public ExecutionJob getLastJob() {
        return lastJob;
    }

    public void setLastJob(ExecutionJob lastJob) {
        this.lastJob = lastJob;
    }
}
