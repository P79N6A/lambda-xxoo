package com.yatop.lambda.workflow.core.context;

import com.alibaba.fastjson.JSONObject;
import com.yatop.lambda.workflow.core.framework.chartype.CharValue;
import com.yatop.lambda.workflow.core.richmodel.component.Component;
import com.yatop.lambda.workflow.core.richmodel.component.characteristic.CmptChar;
import com.yatop.lambda.workflow.core.richmodel.component.specification.CmptSpec;

public class CharValueContext {
    private WorkflowContext workflowContext;
    private Component component;
    private CmptSpec cmptSpec;
    private CmptChar cmptChar;
    private CharValue charValue;

    public void clear() {
        workflowContext = null;
        component = null;
        cmptSpec = null;
        cmptChar = null;
        charValue.clear();
    }

    public WorkflowContext getWorkflowContext() {
        return workflowContext;
    }

    public void setWorkflowContext(WorkflowContext workflowContext) {
        this.workflowContext = workflowContext;
    }

    public Component getComponent() {
        return component;
    }

    public void setComponent(Component component) {
        this.component = component;
    }

    public CmptSpec getCmptSpec() {
        return cmptSpec;
    }

    public void setCmptSpec(CmptSpec cmptSpec) {
        this.cmptSpec = cmptSpec;
    }

    public CmptChar getCmptChar() {
        return cmptChar;
    }

    public void setCmptChar(CmptChar cmptChar) {
        this.cmptChar = cmptChar;
    }

    public CharValue getCharValue() {
        return charValue;
    }

    public void setCharValue(CharValue charValue) {
        this.charValue = charValue;
    }
}
