package com.yatop.lambda.workflow.core.model.workflow.execution;

import com.alibaba.fastjson.JSONObject;
import com.yatop.lambda.base.model.WfExecutionJob;
import com.yatop.lambda.base.model.WfFlowNode;
import com.yatop.lambda.workflow.core.model.IRichModel;

public class ExecutionJob implements IRichModel {
    WfExecutionJob job;

    @Override
    public JSONObject toJson() {
        return null;
    }

    @Override
    public void parseJson(String jsonStr) {

    }
}
