package com.yatop.lambda.workflow.core.richmodel.workflow.module;

import com.yatop.lambda.base.model.WfCfgModulePort;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.framework.chartype.ICharTypeClazz;
import com.yatop.lambda.workflow.core.framework.chartype.clazz.algorithm.AlgorithmGeneric;
import com.yatop.lambda.workflow.core.framework.chartype.clazz.model.ModelGeneric;
import com.yatop.lambda.workflow.core.framework.chartype.clazz.table.TableGeneric;
import com.yatop.lambda.workflow.core.richmodel.RichModel;
import com.yatop.lambda.workflow.core.richmodel.workflow.component.characteristic.CmptChar;

public class ModulePort extends RichModel<WfCfgModulePort> {

    private static String MODULE_PORT_CATEGORY_UNDEFINED = "undefined";
    private static String MODULE_PORT_CATEGORY_ALGORITHM = "algorithm";
    private static String MODULE_PORT_CATEGORY_DATATABLE = "table";
    private static String MODULE_PORT_CATEGORY_MODEL = "model";

    private CmptChar cmptChar;  //关联计算组件特征
    private String portCategory;

    public ModulePort(WfCfgModulePort data, CmptChar cmptChar) {
        super(data);
        this.cmptChar = cmptChar;
        this.portCategory = this.valueOfPortCategory();
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

    private String valueOfPortCategory() {
        ICharTypeClazz clazzBean = getCharTypeClazzBean();

        if(DataUtil.isNull(clazzBean))
            return MODULE_PORT_CATEGORY_UNDEFINED;
        else {
            if(clazzBean instanceof AlgorithmGeneric)
                return MODULE_PORT_CATEGORY_ALGORITHM;
            else if(clazzBean instanceof TableGeneric)
                return MODULE_PORT_CATEGORY_DATATABLE;
            else if(clazzBean instanceof ModelGeneric)
                return MODULE_PORT_CATEGORY_MODEL;
            else
            return MODULE_PORT_CATEGORY_UNDEFINED;
        }
    }

    public String getPortCategory() {
        return portCategory;
    }
}
