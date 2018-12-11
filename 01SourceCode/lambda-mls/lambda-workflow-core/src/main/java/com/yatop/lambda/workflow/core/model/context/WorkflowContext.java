package com.yatop.lambda.workflow.core.model.context;

import com.alibaba.fastjson.JSONObject;
import com.yatop.lambda.workflow.core.model.IRichModel;
import com.yatop.lambda.workflow.core.model.data.DataWarehouse;
import com.yatop.lambda.workflow.core.model.experiment.Experiment;
import com.yatop.lambda.workflow.core.model.model.ModelWarehouse;
import com.yatop.lambda.workflow.core.model.project.Project;
import com.yatop.lambda.workflow.core.model.workflow.Workflow;

import java.util.TreeMap;

public class WorkflowContext implements IRichModel {

    Project project;
    TreeMap<Long, DataWarehouse>  dataWarehouses;
    TreeMap<Long, ModelWarehouse> modelWarehouses;
    Experiment experiment;
    Workflow workflow;

    @Override
    public JSONObject toJSON() {
        return null;
    }

    @Override
    public void clear() {

    }
}
