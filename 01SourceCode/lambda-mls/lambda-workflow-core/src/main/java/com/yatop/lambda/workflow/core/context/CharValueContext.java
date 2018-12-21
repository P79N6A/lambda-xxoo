package com.yatop.lambda.workflow.core.context;

import com.yatop.lambda.workflow.core.richmodel.workflow.CharValue;
import com.yatop.lambda.workflow.core.richmodel.component.Component;
import com.yatop.lambda.workflow.core.richmodel.component.characteristic.CmptChar;
import com.yatop.lambda.workflow.core.richmodel.component.specification.CmptSpec;

public class CharValueContext implements IWorkContext {

    private boolean isTaskReturn;   //是否为运行任务返回后的特征值操作
    private WorkflowContext workflowContext;    //操作关联工作流
    private Component component;    //操作关联组件
    private CmptSpec cmptSpec;      //操作关联组件规格
    private CmptChar cmptChar;      //操作关联组件特征
    private CharValue charValue;  //特征值的传入传出

    public CharValueContext(WorkflowContext workflowContext, Component component, CmptSpec cmptSpec, CmptChar cmptChar) {
        this(workflowContext, component, cmptSpec, cmptChar, false);
    }

    public CharValueContext(WorkflowContext workflowContext, Component component, CmptSpec cmptSpec, CmptChar cmptChar, boolean isTaskReturn) {
        this.isTaskReturn = isTaskReturn;
        this.workflowContext = workflowContext;
        this.component = component;
        this.cmptSpec = cmptSpec;
        this.cmptChar = cmptChar;
        this.charValue = new CharValue(this.cmptChar);
    }

    @Override
    public void clear() {
        isTaskReturn = false;
        workflowContext = null;
        component = null;
        cmptSpec = null;
        cmptChar = null;
        charValue.clear();
    }

    public boolean isTaskReturn() {
        return isTaskReturn;
    }

    public WorkflowContext getWorkflowContext() {
        return workflowContext;
    }

    public Component getComponent() {
        return component;
    }

    public CmptSpec getCmptSpec() {
        return cmptSpec;
    }

    public CmptChar getCmptChar() {
        return cmptChar;
    }

    public CharValue getCharValue() {
        return charValue;
    }
}
