package com.yatop.lambda.workflow.core.richmodel.workflow.execution;

import com.alibaba.fastjson.JSONObject;
import com.yatop.lambda.base.model.WfExecutionTaskOutput;
import com.yatop.lambda.workflow.core.richmodel.IRichModel;
import com.yatop.lambda.workflow.core.richmodel.component.characteristic.CmptChar;

public class ExecutionTaskOutput extends WfExecutionTaskOutput implements IRichModel {

    private CmptChar cmptChar;

    public ExecutionTaskOutput(WfExecutionTaskOutput data, CmptChar cmptChar) {
        super.copyProperties(data);
        this.cmptChar = cmptChar;
        this.clearColoured();
    }

    @Override
    public void clear() {
        cmptChar = null;
        super.clear();
    }

    public void flush(String operId) {
        if(this.isColoured())
            ;//ParameterHelper.updateNodeParameter(this, operId);
    }

    public CmptChar getCmptChar() {
        return cmptChar;
    }
}
