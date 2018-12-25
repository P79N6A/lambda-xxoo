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

    public NodeParameter(WfFlowNodeParameter data, CmptChar cmptChar, CharValue value) {
        super.copyProperties(data);
        this.cmptChar = cmptChar;
        this.value = value;
    }

    @Override
    public void clear() {
        cmptChar = null;
        value.clear();
        value = null;
        super.clear();
    }

    public CmptChar getCmptChar() {
        return cmptChar;
    }

    public CharValue getValue() {
        return value;
    }
}
