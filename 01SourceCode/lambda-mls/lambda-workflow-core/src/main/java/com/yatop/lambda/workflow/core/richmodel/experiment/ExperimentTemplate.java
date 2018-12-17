package com.yatop.lambda.workflow.core.richmodel.experiment;

import com.yatop.lambda.base.model.EmExperimentTemplate;
import com.yatop.lambda.workflow.core.richmodel.IRichModel;

public class ExperimentTemplate extends EmExperimentTemplate implements IRichModel {

    public ExperimentTemplate() {}

    public ExperimentTemplate(EmExperimentTemplate data) {super.copyProperties(data);}

    @Override
    public void clear() {
        super.clear();
    }
}
