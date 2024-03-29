package com.yatop.lambda.workflow.core.context;

import com.yatop.lambda.core.enums.SpecTypeEnum;
import com.yatop.lambda.workflow.core.richmodel.workflow.module.Module;
import com.yatop.lambda.workflow.core.richmodel.workflow.charvalue.CharValue;
import com.yatop.lambda.workflow.core.richmodel.workflow.component.Component;
import com.yatop.lambda.workflow.core.richmodel.workflow.component.characteristic.CmptChar;
import com.yatop.lambda.workflow.core.richmodel.workflow.component.specification.CmptSpec;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.Node;

public class CharValueContext implements IWorkContext {

    private WorkflowContext workflowContext;    //操作关联工作流上下文
    private Node node;              //操作关联节点
    private CharValue charValue;    //特征值的传入传出

    public CharValueContext(WorkflowContext workflowContext, Node node, CharValue charValue) {
        this.workflowContext = workflowContext;
        this.node = node;
        this.charValue = charValue;
    }

    @Override
    public void clear() {
        workflowContext = null;
        node = null;
        charValue = null;
    }

    public WorkflowContext getWorkflowContext() {
        return workflowContext;
    }

    public Node getNode() {
        return node;
    }

    public Module getModule() {
        return node.getModule();
    }

    public Component getComponent() {
        return getModule().getComponent();
    }

    public CmptSpec getCmptSpec() {
        return getComponent().getCmptSpec(SpecTypeEnum.valueOf(this.charValue.getSpecType()));
    }

    public CmptChar getCmptChar() {
        return charValue.getCmptChar();
    }

    public CharValue getCharValue() {
        return charValue;
    }
}
