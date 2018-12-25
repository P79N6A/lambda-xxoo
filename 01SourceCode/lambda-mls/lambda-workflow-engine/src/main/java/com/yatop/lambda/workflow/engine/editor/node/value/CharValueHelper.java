package com.yatop.lambda.workflow.engine.editor.node.value;

import com.yatop.lambda.core.enums.LambdaExceptionEnum;
import com.yatop.lambda.core.exception.LambdaException;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.framework.chartype.CharTyeClazzBaseClazz;
import com.yatop.lambda.workflow.core.framework.chartype.ICharTypeClazz;
import com.yatop.lambda.workflow.core.richmodel.component.characteristic.CmptCharType;

public class CharValueHelper {

    public static ICharTypeClazz getCharTypeClazzBean(CmptCharType cmptCharType) {
        ICharTypeClazz charTypeClazz = CharTyeClazzBaseClazz.getClazzBean(cmptCharType.getClassPath());
        if (DataUtil.isNull(charTypeClazz))
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Search component characteristic type clazz bean failed.", "计算组件配置错误，请联系管理员");

        return charTypeClazz;
    }
}
