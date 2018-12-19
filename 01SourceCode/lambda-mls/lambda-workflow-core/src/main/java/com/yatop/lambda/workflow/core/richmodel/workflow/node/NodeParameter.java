package com.yatop.lambda.workflow.core.richmodel.workflow.node;

import com.yatop.lambda.base.model.WfFlowNodeParameter;
import com.yatop.lambda.workflow.core.richmodel.IRichModel;
import com.yatop.lambda.workflow.core.richmodel.component.characteristic.CmptChar;
import com.yatop.lambda.workflow.core.richmodel.workflow.GlobalParameter;

public class NodeParameter extends WfFlowNodeParameter implements IRichModel {

    private CmptChar cmptChar;
    private GlobalParameter lastGlobalParameter;

    public NodeParameter() {}

    public NodeParameter(WfFlowNodeParameter data) {super.copyProperties(data);}

    @Override
    public void clear() {
        cmptChar = null;
        super.clear();
    }

    public CmptChar getCmptChar() {
        return cmptChar;
    }

    public void setCmptChar(CmptChar cmptChar) {
        this.cmptChar = cmptChar;
    }

    public GlobalParameter getLastGlobalParameter() {
        return lastGlobalParameter;
    }

    public void setLastGlobalParameter(GlobalParameter lastGlobalParameter) {
        this.lastGlobalParameter = lastGlobalParameter;
    }
}
