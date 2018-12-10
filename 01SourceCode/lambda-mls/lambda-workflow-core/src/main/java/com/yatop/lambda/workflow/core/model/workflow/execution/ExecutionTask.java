package com.yatop.lambda.workflow.core.model.workflow.execution;

import com.alibaba.fastjson.JSONObject;
import com.yatop.lambda.base.model.WfExecutionTask;
import com.yatop.lambda.workflow.core.model.IRichModel;

public class ExecutionTask implements IRichModel {
    WfExecutionTask task;

    @Override
    public JSONObject toJson() {
        return null;
    }

    @Override
    public void parseJson(String jsonStr) {

    }
}
