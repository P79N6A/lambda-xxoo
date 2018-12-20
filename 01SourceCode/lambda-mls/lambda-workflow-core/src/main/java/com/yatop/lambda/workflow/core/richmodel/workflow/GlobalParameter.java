package com.yatop.lambda.workflow.core.richmodel.workflow;

import com.yatop.lambda.base.model.WfFlowGlobalParameter;
import com.yatop.lambda.workflow.core.richmodel.IRichModel;
import com.yatop.lambda.workflow.core.richmodel.component.characteristic.CmptChar;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.Node;

public class GlobalParameter extends WfFlowGlobalParameter implements IRichModel {

    private Node node;          //关联节点
    private CmptChar cmptChar;  //关联计算组件特征

    public GlobalParameter() {}

    public GlobalParameter(WfFlowGlobalParameter data) {super.copyProperties(data);}

    @Override
    public void clear() {
        node = null;
        cmptChar = null;
        super.clear();
    }

    public Node getNode() {
        return node;
    }

    public void setNode(Node node) {
        this.node = node;
    }

    public CmptChar getCmptChar() {
        return cmptChar;
    }

    public void setCmptChar(CmptChar cmptChar) {
        this.cmptChar = cmptChar;
    }
}
