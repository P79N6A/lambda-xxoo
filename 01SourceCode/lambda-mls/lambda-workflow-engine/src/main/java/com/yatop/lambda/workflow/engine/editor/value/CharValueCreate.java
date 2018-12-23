package com.yatop.lambda.workflow.engine.editor.value;

import com.yatop.lambda.core.enums.LambdaExceptionEnum;
import com.yatop.lambda.core.enums.SpecTypeEnum;
import com.yatop.lambda.core.exception.LambdaException;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.context.CharValueContext;
import com.yatop.lambda.workflow.core.context.WorkflowContext;
import com.yatop.lambda.workflow.core.framework.chartype.ICharTypeClazz;
import com.yatop.lambda.workflow.core.richmodel.component.Component;
import com.yatop.lambda.workflow.core.richmodel.component.characteristic.CmptChar;
import com.yatop.lambda.workflow.core.richmodel.component.specification.CmptSpec;
import com.yatop.lambda.workflow.core.richmodel.workflow.CharValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CharValueCreate {

    @Autowired
    CharValueValidate charValueValidate;

    public CharValue createCharValue(WorkflowContext workflowContext, Component component, CmptSpec cmptSpec, CmptChar cmptChar, String inCharValueText) {

        if(cmptSpec.getSpecType() == SpecTypeEnum.INPUT.getType() || cmptSpec.getSpecType() == SpecTypeEnum.EXECUTION.getType()) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Create characteristic value failed -- forbid create input & execution char-value.", "不允许输入内容和调用执行的特征值创建");
        }

        CharValue charValue = new CharValue(cmptChar);
        if(cmptSpec.getSpecType() != SpecTypeEnum.OUTPUT.getType()) {
            if (DataUtil.isNotNull(inCharValueText))
                charValue.setInText(inCharValueText);
            else
                charValue.setInText(component.getCharValue(SpecTypeEnum.valueOf(cmptSpec.getSpecType()), cmptChar.getCharId()));

            if (DataUtil.isNotNull(charValue.getInText()) && charValueValidate.validateCharValue(workflowContext, component, cmptSpec, cmptChar, charValue)){
                throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Create characteristic value failed -- char-value validation failed.", "计算组件特征值验证失败");
            }
        }

        ICharTypeClazz charTypeClazz = CharValueHelper.getCharTypeClazzBean(cmptChar.getType());
        if (charTypeClazz.catchCreateValue()) {

            try {
                CharValueContext charValueContext = new CharValueContext(workflowContext, component, cmptSpec, cmptChar);
                charValueContext.setCharValue(charValue);
                charTypeClazz.onCreateValue(charValueContext);
                charValueContext.clear();
                return charValue;
            } catch (Exception e) {
                throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Create characteristic value failed -- char-type-clazz occur error.", "计算组件特征值创建时发生错误", e);
            }
        } else if(cmptSpec.getSpecType() == SpecTypeEnum.OUTPUT.getType()) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Create characteristic value failed -- char-type-clazz uncaught output char-value create event.", "系统内部严重错误，请联系管理员");
        } else if(DataUtil.isNotNull(charValue.getInText())) {
            charValue.setCharValue(charValue.getInText());
            charValue.setOutText(charValue.getInText());
        }
        return charValue;
    }
}
