package com.yatop.lambda.workflow.core.utils;

import com.yatop.lambda.core.enums.LambdaExceptionEnum;
import com.yatop.lambda.core.exception.LambdaException;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.framework.chartype.CharTypeClazzBaseClazz;
import com.yatop.lambda.workflow.core.framework.chartype.ICharTypeClazz;
import com.yatop.lambda.workflow.core.framework.module.IModuleClazz;
import com.yatop.lambda.workflow.core.framework.module.ModuleClazzClazzBase;
import com.yatop.lambda.workflow.core.richmodel.component.characteristic.CharType;
import com.yatop.lambda.workflow.core.richmodel.workflow.module.Module;

public class ClazzHelperUtil {

    public static ICharTypeClazz getCharTypeClazzBean(CharType charType) {
        ICharTypeClazz charTypeClazz = CharTypeClazzBaseClazz.getClazzBean(charType.data().getClazzPath());
        if (DataUtil.isNull(charTypeClazz))
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Search component Char-Type-Clazz bean failed.", "计算组件配置错误，请联系管理员");

        return charTypeClazz;
    }

    public static IModuleClazz getModuleClazzBean(Module module) {
        IModuleClazz moduleClazz = ModuleClazzClazzBase.getClazzBean(module.data().getClazzPath());
        if (DataUtil.isNull(moduleClazz))
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Search Module-Clazz bean failed.", "工作流组件配置错误，请联系管理员");

        return moduleClazz;
    }
}
