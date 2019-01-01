package com.yatop.lambda.workflow.core.richmodel.workflow.global;

import com.yatop.lambda.base.model.WfFlowGlobalParameter;
import com.yatop.lambda.workflow.core.richmodel.IRichModel;
import com.yatop.lambda.workflow.core.richmodel.component.characteristic.CmptChar;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.Node;

//TODO 待进一步确定实现方案
public class GlobalParameter extends WfFlowGlobalParameter implements IRichModel {

    private CmptChar cmptChar;  //关联计算组件特征
/*    private CharValue globalDefaultValue;
    private CharValue globalValue;*/

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