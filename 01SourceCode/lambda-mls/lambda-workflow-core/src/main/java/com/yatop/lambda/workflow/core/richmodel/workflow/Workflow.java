package com.yatop.lambda.workflow.core.richmodel.workflow;

import com.yatop.lambda.base.model.WfFlow;
import com.yatop.lambda.workflow.core.richmodel.IRichModel;
import com.yatop.lambda.workflow.core.richmodel.experiment.Experiment;
import com.yatop.lambda.workflow.core.richmodel.project.Project;
import com.yatop.lambda.workflow.core.richmodel.workflow.execution.ExecutionJob;

public class Workflow extends WfFlow implements IRichModel {

    public Workflow(WfFlow data) {super.copyProperties(data);}

    @Override
    public void clear() {
        super.clear();
    }
}
