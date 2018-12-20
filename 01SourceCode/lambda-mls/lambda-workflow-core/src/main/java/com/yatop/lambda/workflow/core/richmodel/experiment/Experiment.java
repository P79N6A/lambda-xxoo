package com.yatop.lambda.workflow.core.richmodel.experiment;

import com.yatop.lambda.base.model.EmExperiment;
import com.yatop.lambda.workflow.core.richmodel.IRichModel;
import com.yatop.lambda.workflow.core.richmodel.workflow.Workflow;

public class Experiment extends EmExperiment implements IRichModel {

    private Workflow workflow;  //实验工作流

    public Experiment() {}

    public Experiment(EmExperiment data) {super.copyProperties(data);}

    @Override
    public void clear() {
        workflow = null;
        super.clear();
    }

    public Workflow getWorkflow() {
        return workflow;
    }

    public void setWorkflow(Workflow workflow) {
        this.workflow = workflow;
    }
}
