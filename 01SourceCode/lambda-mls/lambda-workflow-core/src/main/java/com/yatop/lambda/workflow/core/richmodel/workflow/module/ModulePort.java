package com.yatop.lambda.workflow.core.richmodel.workflow.module;

import com.yatop.lambda.base.model.WfModulePort;
import com.yatop.lambda.workflow.core.framework.chartype.ICharTypeClazz;
import com.yatop.lambda.workflow.core.framework.chartype.clazz.table.TableGeneric;
import com.yatop.lambda.workflow.core.richmodel.RichModel;
import com.yatop.lambda.workflow.core.richmodel.component.characteristic.CmptChar;

public class ModulePort extends RichModel<WfModulePort> {

    private CmptChar cmptChar;  //关联计算组件特征

    public ModulePort(WfModulePort data, CmptChar cmptChar) {
        super(data);
        this.cmptChar = cmptChar;
    }

    @Override
    public void clear() {
        cmptChar = null;
        super.clear();
    }

    public CmptChar getCmptChar() {
        return cmptChar;
    }

    public ICharTypeClazz getCharTypeClazzBean() {
        return this.getCmptChar().getCharTypeClazzBean();
    }

    public boolean isDataTablePort() {
        return this.getCharTypeClazzBean() instanceof TableGeneric;
    }
}
