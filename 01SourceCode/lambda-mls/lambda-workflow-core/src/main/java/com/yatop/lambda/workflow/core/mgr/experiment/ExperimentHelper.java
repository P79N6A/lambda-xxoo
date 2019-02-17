package com.yatop.lambda.workflow.core.mgr.experiment;

import com.yatop.lambda.base.model.EmExperiment;
import com.yatop.lambda.core.mgr.experiment.ExperimentMgr;
import com.yatop.lambda.workflow.core.mgr.project.ProjectHelper;
import com.yatop.lambda.workflow.core.richmodel.experiment.Experiment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ExperimentHelper {

    private static ExperimentMgr EXPERIMENT_MGR;

    @Autowired
    public void setExperimentMgr(ExperimentMgr experimentMgr) {
        EXPERIMENT_MGR = experimentMgr;
    }

    public static Experiment queryExperiment(Long experimentId) {
        EmExperiment experiment = EXPERIMENT_MGR.queryExperiment(experimentId);
        return new Experiment(experiment, ProjectHelper.queryProject(experiment.getOwnerProjectId()));
    }
}
