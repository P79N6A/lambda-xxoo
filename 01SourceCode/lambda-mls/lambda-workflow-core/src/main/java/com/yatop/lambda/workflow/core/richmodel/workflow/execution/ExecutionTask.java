package com.yatop.lambda.workflow.core.richmodel.workflow.execution;

import com.alibaba.fastjson.JSONObject;
import com.yatop.lambda.base.model.WfExecutionTask;
import com.yatop.lambda.workflow.core.richmodel.IRichModel;
import com.yatop.lambda.workflow.core.utils.CollectionUtil;

import java.util.TreeMap;

public class ExecutionTask extends WfExecutionTask implements IRichModel {

    private TreeMap<String, ExecutionTaskOutput> taskOutputs;

    public ExecutionTask() {}

    public ExecutionTask(WfExecutionTask data) {super.copyProperties(data);}

    @Override
    public void clear() {
        super.clear();
    }

    public ExecutionTaskOutput getTaskOutput(String charId) {
        return CollectionUtil.get(taskOutputs, charId);
    }

    public void putTaskOutput(ExecutionTaskOutput taskOutput) {
        CollectionUtil.put(taskOutputs, taskOutput.getCharId(), taskOutput);
    }
}
