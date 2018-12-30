package com.yatop.lambda.workflow.core.richmodel.workflow;

import com.yatop.lambda.base.model.WfFlowGlobalParameter;
import com.yatop.lambda.workflow.core.richmodel.IRichModel;
import com.yatop.lambda.workflow.core.richmodel.component.characteristic.CmptChar;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.Node;

public class GlobalParameter extends WfFlowGlobalParameter implements IRichModel {

    private CmptChar cmptChar;  //关联计算组件特征

    public GlobalParameter(WfFlowGlobalParameter data, CmptChar cmptChar) {
        super.copyProperties(data);
        this.cmptChar = cmptChar;
        this.clearColoured();
    }

    @Override
    public void clear() {
        cmptChar = null;
        super.clear();
    }

    public CmptChar getCmptChar() {
        return cmptChar;
    }
}
