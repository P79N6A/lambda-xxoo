package com.yatop.lambda.workflow.core.richmodel.workflow.execution;

import com.yatop.lambda.base.model.WfExecutionTask;
import com.yatop.lambda.workflow.core.richmodel.IRichModel;
import com.yatop.lambda.workflow.core.utils.CollectionUtil;

import java.util.TreeMap;

public class ExecutionTask extends WfExecutionTask implements IRichModel {

    private TreeMap<String, ExecutionTaskOutput> taskOutputs;   //任务输出内容

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
