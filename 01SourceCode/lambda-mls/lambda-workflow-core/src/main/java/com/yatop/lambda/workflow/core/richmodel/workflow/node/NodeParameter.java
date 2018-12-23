package com.yatop.lambda.workflow.core.richmodel.workflow.node;

import com.yatop.lambda.base.model.WfFlowNodeParameter;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.richmodel.IRichModel;
import com.yatop.lambda.workflow.core.richmodel.component.characteristic.CmptChar;
import com.yatop.lambda.workflow.core.richmodel.workflow.CharValue;
import com.yatop.lambda.workflow.core.richmodel.workflow.GlobalParameter;

public class NodeParameter extends WfFlowNodeParameter implements IRichModel {

    private CmptChar cmptChar;
    private CharValue value;
    private GlobalParameter lastGlobalParameter;

    public NodeParameter(WfFlowNodeParameter data, CmptChar cmptChar) {
        super.copyProperties(data);
        this.cmptChar = cmptChar;
    }

    @Override
    public void clear() {
        cmptChar = null;
        if(DataUtil.isNotNull(value))
            value.clear();
        value = null;
        lastGlobalParameter = null;
        super.clear();
    }

    public CmptChar getCmptChar() {
        return cmptChar;
    }

    public CharValue getValue() {
        return value;
    }

    public void setValue(CharValue value) {
        this.value = value;
    }

    public GlobalParameter getLastGlobalParameter() {
        return lastGlobalParameter;
    }

    public void setLastGlobalParameter(GlobalParameter lastGlobalParameter) {
        this.lastGlobalParameter = lastGlobalParameter;
    }

}
