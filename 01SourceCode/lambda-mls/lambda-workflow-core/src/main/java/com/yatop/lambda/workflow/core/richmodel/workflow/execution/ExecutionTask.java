package com.yatop.lambda.workflow.core.richmodel.workflow.execution;

import com.yatop.lambda.base.model.WfExecutionTask;
import com.yatop.lambda.workflow.core.richmodel.IRichModel;
import com.yatop.lambda.workflow.core.utils.CollectionUtil;

import java.util.TreeMap;

public class ExecutionTask extends WfExecutionTask implements IRichModel {

    private TreeMap<String, ExecutionTaskOutput> taskOutputs = new TreeMap<String, ExecutionTaskOutput>();   //任务输出内容

    public ExecutionTask(WfExecutionTask data) {
        super.copyProperties(data);
        this.clearColoured();
    }

    @Override
    public void clear() {
        taskOutputs.clear();
        super.clear();
    }

    public int taskOutputCount() {
        return taskOutputs.size();
    }

    public ExecutionTaskOutput getTaskOutput(String charId) {
        return CollectionUtil.get(taskOutputs, charId);
    }

    public void putTaskOutput(ExecutionTaskOutput taskOutput) {
        CollectionUtil.put(taskOutputs, taskOutput.getCharId(), taskOutput);
    }
}
