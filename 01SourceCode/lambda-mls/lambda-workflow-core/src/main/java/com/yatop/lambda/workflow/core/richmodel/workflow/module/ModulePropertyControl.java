package com.yatop.lambda.workflow.core.richmodel.workflow.module;

import com.yatop.lambda.base.model.WfCfgModulePropCtrl;
import com.yatop.lambda.workflow.core.richmodel.RichModel;
import com.yatop.lambda.workflow.core.richmodel.workflow.component.characteristic.CmptChar;

public class ModulePropertyControl extends RichModel<WfCfgModulePropCtrl> {

    private CmptChar cmptChar;

    public ModulePropertyControl(WfCfgModulePropCtrl data, CmptChar cmptChar) {
        super(data);
        this.cmptChar = cmptChar;
    }

    @Override
    public void clear() {
        this.cmptChar = null;
        super.clear();
    }

    //注意：bind-char-code为null时，返回为null
    public CmptChar getCmptChar() {
        return cmptChar;
    }
}
