package com.yatop.lambda.workflow.core.richmodel.workflow.node;

import com.yatop.lambda.base.model.WfFlowNodeParameter;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.framework.chartype.ICharTypeClazz;
import com.yatop.lambda.workflow.core.mgr.workflow.node.parameter.ParameterHelper;
import com.yatop.lambda.workflow.core.richmodel.IRichModel;
import com.yatop.lambda.workflow.core.richmodel.RichModel;
import com.yatop.lambda.workflow.core.richmodel.component.characteristic.CmptChar;
import com.yatop.lambda.workflow.core.richmodel.workflow.value.CharValue;

public class NodeParameter extends RichModel<WfFlowNodeParameter> {

    private CmptChar cmptChar;
    private CharValue charValue;
    private boolean simulateParameter;  //标记来自ParameterHelper.simulateParameter构建的模拟节点参数
    private boolean isStateChanged;

    public NodeParameter(WfFlowNodeParameter data, CmptChar cmptChar, CharValue charValue) {
        this(data, cmptChar, charValue, false);
    }

    public NodeParameter(WfFlowNodeParameter data, CmptChar cmptChar, CharValue charValue, boolean simulateParameter) {
        super(data);
        this.cmptChar = cmptChar;
        this.charValue = charValue;
        this.simulateParameter = simulateParameter;
        this.isStateChanged = false;
    }

    @Override
    public void clear() {
        cmptChar = null;
        charValue = null;
        super.clear();
    }

    public boolean isStateChanged() {
        return isStateChanged;
    }

    protected void flush(String operId) {
        if(this.isColoured() && !simulateParameter) {
            ParameterHelper.updateNodeParameter(this, operId);
        }
    }

    public CmptChar getCmptChar() {
        return cmptChar;
    }

    public CharValue getCharValue() {
        return charValue;
    }

    public String getTextValue() {
        return this.getCharValue().getTextValue();
    }

    public IRichModel getObjectValue() {
        return this.getCharValue().getObjectValue();
    }

    public boolean isSimulateParameter() {
        return simulateParameter;
    }

    public boolean isOccuredWarning() {
        return DataUtil.isNotEmpty(this.data().getWarningMsg());
    }

    public void changeOccuredWarning(String warningMsg) {
        if(!DataUtil.equals(this.data().getWarningMsg(), warningMsg)) {
            this.data().setWarningMsg(warningMsg);
            isStateChanged = true;
        }
    }

    public void clearOccuredWarning() {
        if(this.isOccuredWarning()) {
            this.changeOccuredWarning(null);
            isStateChanged = true;
        }
    }

    public ICharTypeClazz getCharTypeClazzBean() {
        return this.getCmptChar().getCharTypeClazzBean();
    }
}
