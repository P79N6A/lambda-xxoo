package com.yatop.lambda.workflow.core.context;

import com.yatop.lambda.workflow.core.richmodel.component.Component;
import com.yatop.lambda.workflow.core.richmodel.workflow.CharValue;
import com.yatop.lambda.workflow.core.richmodel.workflow.execution.ExecutionJob;
import com.yatop.lambda.workflow.core.richmodel.workflow.execution.ExecutionTask;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.Node;
import com.yatop.lambda.workflow.core.utils.CollectionUtil;

import java.util.TreeMap;

public class TaskContext implements IWorkContext {

    private ExecutionJob job;       //操作关联运行作业
    private ExecutionTask task;     //操作关联运行任务
    private WorkflowContext workflowContext;    //作业内容的工作流上下文
    private Node node;                          //操作关联节点
    private Component component;                //操作关联组件
    private TreeMap<String, CharValue> inputCharValues = new TreeMap<String, CharValue>();         //节点输入内容特征值
    private TreeMap<String, CharValue> outputCharValues = new TreeMap<String, CharValue>();        //节点输出内容特征值
    private TreeMap<String, CharValue> execCharValues = new TreeMap<String, CharValue>();          //节点调用执行特征值
    private TreeMap<String, CharValue> optimizeCharValues = new TreeMap<String, CharValue>();      //节点执行调优参数特征值
    private TreeMap<String, CharValue> parameterCharValues = new TreeMap<String, CharValue>();     //节点组件参数特征值
    private String warningMsg;

    @Override
    public void clear() {
        job = null;
        task = null;
        workflowContext = null;
        node = null;
        component = null;
        CollectionUtil.clear(inputCharValues);
        inputCharValues = null;
        CollectionUtil.clear(outputCharValues);
        outputCharValues = null;
        CollectionUtil.clear(execCharValues);
        execCharValues = null;
        CollectionUtil.clear(optimizeCharValues);
        optimizeCharValues = null;
        CollectionUtil.clear(parameterCharValues);
        parameterCharValues = null;
        warningMsg = null;
    }
}
