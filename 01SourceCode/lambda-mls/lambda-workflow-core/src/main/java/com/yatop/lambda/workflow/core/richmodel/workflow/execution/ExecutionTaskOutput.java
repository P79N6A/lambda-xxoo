package com.yatop.lambda.workflow.core.richmodel.workflow.execution;

import com.yatop.lambda.base.model.WfExecutionTaskOutput;
import com.yatop.lambda.core.enums.OutputStateEnum;
import com.yatop.lambda.workflow.core.richmodel.RichModel;
import com.yatop.lambda.workflow.core.richmodel.component.characteristic.CmptChar;

public class ExecutionTaskOutput extends RichModel<WfExecutionTaskOutput> {

    private CmptChar cmptChar;

    public ExecutionTaskOutput(WfExecutionTaskOutput data, CmptChar cmptChar) {
        super(data);
        this.cmptChar = cmptChar;
    }

    protected void flush(String operId) {

        if (this.isColoured())
            ;//NodeHelper.updateNode(this, operId);
    }

    @Override
    public void clear() {
        cmptChar = null;
        super.clear();
    }

    public void changeState2Normal() {
        this.changeOutputState(OutputStateEnum.NORMAL);
    }

    private void changeOutputState(OutputStateEnum stateEnum) {
        if(this.data().getOutputState() == stateEnum.getState())
            return;

        this.data().setOutputState(stateEnum.getState());
    }

    public CmptChar getCmptChar() {
        return cmptChar;
    }
}
