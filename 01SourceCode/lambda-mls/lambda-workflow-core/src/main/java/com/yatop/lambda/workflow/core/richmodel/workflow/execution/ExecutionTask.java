package com.yatop.lambda.workflow.core.richmodel.workflow.execution;

import com.yatop.lambda.base.model.WfExecutionTask;
import com.yatop.lambda.workflow.core.richmodel.IRichModel;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.Node;
import com.yatop.lambda.workflow.core.utils.CollectionUtil;

import java.util.List;
import java.util.TreeMap;

public class ExecutionTask extends WfExecutionTask implements IRichModel {

    private Node node;  //操作关联节点
    private TreeMap<String, ExecutionTaskOutput> taskOutputs = new TreeMap<String, ExecutionTaskOutput>();   //任务输出内容

    public ExecutionTask(WfExecutionTask data, Node node) {
        super.copyProperties(data);
        this.node = node;
        this.clearColoured();
    }

    @Override
    public void clear() {
        taskOutputs.clear();
        super.clear();
    }

    public void flush(String operId) {

        if (this.taskOutputCount() > 0) {
            for (ExecutionTaskOutput taskOutput : this.getTaskOutputs()) {
                taskOutput.flush(operId);
            }
        }
        if (this.isColoured())
            ;//NodeHelper.updateNode(this, operId);
    }

    public Node getNode() {
        return this.node;
    }

    public int taskOutputCount() {
        return taskOutputs.size();
    }

    public List<ExecutionTaskOutput> getTaskOutputs() {
        return CollectionUtil.toList(taskOutputs);
    }

    public ExecutionTaskOutput getTaskOutput(String charId) {
        return CollectionUtil.get(taskOutputs, charId);
    }

    public void putTaskOutput(ExecutionTaskOutput taskOutput) {
        CollectionUtil.put(taskOutputs, taskOutput.getCharId(), taskOutput);
    }
}
