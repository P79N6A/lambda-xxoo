package com.yatop.lambda.workflow.core.richmodel.experiment;

import com.yatop.lambda.base.model.EmExperiment;
import com.yatop.lambda.workflow.core.richmodel.RichModel;
import com.yatop.lambda.workflow.core.richmodel.project.Project;

public class Experiment extends RichModel<EmExperiment> {

    private Project project;  //实验工作流

    public Experiment(EmExperiment data, Project project) {
        super(data);
        this.project = project;
    }

    @Override
    public void clear() {
        project = null;
        super.clear();
    }

    public Project getProject() {
        return project;
    }
}
