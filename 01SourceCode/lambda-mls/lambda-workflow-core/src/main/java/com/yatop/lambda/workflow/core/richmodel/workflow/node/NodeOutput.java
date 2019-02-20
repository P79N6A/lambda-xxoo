package com.yatop.lambda.workflow.core.richmodel.workflow.node;

import com.yatop.lambda.base.model.WfFlowNodeOutput;
import com.yatop.lambda.core.enums.OutputStateEnum;
import com.yatop.lambda.workflow.core.richmodel.RichModel;
import com.yatop.lambda.workflow.core.richmodel.component.characteristic.CmptChar;
import com.yatop.lambda.workflow.core.richmodel.workflow.charvalue.CharValue;

public class NodeOutput extends RichModel<WfFlowNodeOutput> {

    private CharValue charValue;

    public NodeOutput(WfFlowNodeOutput data, CharValue charValue) {
        super(data);
        this.charValue = charValue;
    }

    public void flush(String operId) {

        if (this.isColoured())
            ;//NodeHelper.updateNode(this, operId);
    }

    @Override
    public void clear(boolean clearData) {
        charValue = null;
        super.clear(clearData);
    }

    public CmptChar getCmptChar() {
        return charValue.getCmptChar();
    }

    public CharValue getCharValue() {
        return charValue;
    }

    public void changeState2Empty() {
        this.changeOutputState(OutputStateEnum.EMPTY);
    }

    public void changeState2Normal() {
        this.changeOutputState(OutputStateEnum.NORMAL);
    }

    private void changeOutputState(OutputStateEnum stateEnum) {
        if(this.data().getOutputState() == stateEnum.getState())
            return;

        this.data().setOutputState(stateEnum.getState());
    }
}
