package com.yatop.lambda.workflow.core.context;

import com.yatop.lambda.core.enums.SpecTypeEnum;
import com.yatop.lambda.workflow.core.richmodel.component.characteristic.CmptChar;
import com.yatop.lambda.workflow.core.richmodel.workflow.value.CharValue;
import com.yatop.lambda.workflow.core.richmodel.workflow.execution.ExecutionJob;
import com.yatop.lambda.workflow.core.richmodel.workflow.execution.ExecutionTask;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.Node;
import com.yatop.lambda.workflow.core.utils.CollectionUtil;

import java.util.List;
import java.util.TreeMap;

public class ExecutionTaskContext implements IWorkContext {

    private WorkflowContext workflowContext;
    private ExecutionTask task;     //操作关联运行任务
    //private ExecutionJobContext executionJobContext;    //作业内容的工作流上下文
    private Node node;                          //操作关联节点
    private TreeMap<String, CharValue> inputCharValues = new TreeMap<String, CharValue>();         //节点输入内容特征值
    private TreeMap<String, CharValue> outputCharValues = new TreeMap<String, CharValue>();        //节点输出内容特征值
    private TreeMap<String, CharValue> execCharValues = new TreeMap<String, CharValue>();          //节点调用执行特征值
    private TreeMap<String, CharValue> optimizeCharValues = new TreeMap<String, CharValue>();      //节点执行调优参数特征值
    private TreeMap<String, CharValue> parameterCharValues = new TreeMap<String, CharValue>();     //节点组件参数特征值
    private String warningMsg;

    public ExecutionTaskContext(ExecutionTask task, WorkflowContext workflowContext, Node node) {
        this.task = task;
        this.workflowContext = workflowContext;
        //this.executionJobContext = executionJobContext;
        this.node = node;
        this.warningMsg = null;
    }

    @Override
    public void clear() {
        task = null;
        executionJobContext = null;
        node = null;
        CollectionUtil.enhancedClear(inputCharValues);
        CollectionUtil.enhancedClear(outputCharValues);
        CollectionUtil.enhancedClear(execCharValues);
        CollectionUtil.enhancedClear(optimizeCharValues);
        CollectionUtil.enhancedClear(parameterCharValues);
        warningMsg = null;
    }

    public ExecutionJob getJob() {
        return executionJobContext.getJob();
    }

    public ExecutionTask getTask() {
        return task;
    }

    public WorkflowContext getWorkflowContext() {
        return executionJobContext.getWorkflowContext();
    }

    public Node getNode() {
        return node;
    }

    public String getWarningMsg() {
        return warningMsg;
    }

    public void setWarningMsg(String warningMsg) {
        this.warningMsg = warningMsg;
    }

    public int inputCharValueCount() {
        return inputCharValues.size();
    }

    public int outputCharValueCount() {
        return outputCharValues.size();
    }

    public int optimizeCharValueCount() {
        return optimizeCharValues.size();
    }

    public int parameterCharValueCount() {
        return parameterCharValues.size();
    }

    public CharValue getCharValue(CmptChar cmptChar) {
        switch (SpecTypeEnum.valueOf(cmptChar.data().getSpecType())) {
            case INPUT:
                return inputCharValues.get(cmptChar.data().getCharId());
            case OUTPUT:
                return outputCharValues.get(cmptChar.data().getCharId());
            case EXECUTION:
                return execCharValues.get(cmptChar.data().getCharId());
            case OPTIMIZE_EXECUTION:
                return optimizeCharValues.get(cmptChar.data().getCharId());
            case PARAMETER:
                return parameterCharValues.get(cmptChar.data().getCharId());
        }
        return null;
    }

    public List<CharValue> getCharValues(SpecTypeEnum specTypeEnum) {
        switch (specTypeEnum) {
            case INPUT:
                return CollectionUtil.toList(inputCharValues);
            case OUTPUT:
                return CollectionUtil.toList(outputCharValues);
            case EXECUTION:
                return CollectionUtil.toList(execCharValues);
            case OPTIMIZE_EXECUTION:
                return CollectionUtil.toList(optimizeCharValues);
            case PARAMETER:
                return CollectionUtil.toList(parameterCharValues);
        }
        return null;
    }

    public void putCharValue(CmptChar cmptChar, CharValue charValue) {
        switch (SpecTypeEnum.valueOf(cmptChar.data().getSpecType())) {
            case INPUT:
                CollectionUtil.put(inputCharValues, cmptChar.data().getCharId(), charValue);
            case OUTPUT:
                CollectionUtil.put(outputCharValues, cmptChar.data().getCharId(), charValue);
            case EXECUTION:
                CollectionUtil.put(execCharValues, cmptChar.data().getCharId(), charValue);
            case OPTIMIZE_EXECUTION:
                CollectionUtil.put(optimizeCharValues, cmptChar.data().getCharId(), charValue);
            case PARAMETER:
                CollectionUtil.put(parameterCharValues, cmptChar.data().getCharId(), charValue);
        }
    }
}
