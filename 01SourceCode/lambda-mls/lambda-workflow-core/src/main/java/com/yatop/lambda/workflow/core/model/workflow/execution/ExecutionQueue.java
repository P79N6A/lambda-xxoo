package com.yatop.lambda.workflow.core.model.workflow.execution;

import com.alibaba.fastjson.JSONObject;
import com.yatop.lambda.base.model.WfExecutionJob;
import com.yatop.lambda.base.model.WfExecutionQueue;
import com.yatop.lambda.workflow.core.model.IRichModel;

public class ExecutionQueue implements IRichModel {
    WfExecutionQueue queue;

    @Override
    public JSONObject toJson() {
        return null;
    }

    @Override
    public void parseJson(String jsonStr) {

    }
}
