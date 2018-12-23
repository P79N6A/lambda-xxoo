package com.yatop.lambda.workflow.engine.editor.value;

import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.context.CharValueContext;
import com.yatop.lambda.workflow.core.context.WorkflowContext;
import com.yatop.lambda.workflow.core.framework.chartype.ICharTypeClazz;
import com.yatop.lambda.workflow.core.richmodel.component.Component;
import com.yatop.lambda.workflow.core.richmodel.component.characteristic.CmptChar;
import com.yatop.lambda.workflow.core.richmodel.component.specification.CmptSpec;
import com.yatop.lambda.workflow.core.richmodel.workflow.CharValue;
import org.springframework.stereotype.Service;

@Service
public class CharValueValidate {

    public boolean validateCharValue(WorkflowContext workflowContext, Component component, CmptSpec cmptSpec, CmptChar cmptChar, CharValue charValue) {

        if(DataUtil.isNotNull(charValue.getInText())) {
            ICharTypeClazz charTypeClazz = CharValueHelper.getCharTypeClazzBean(cmptChar.getType());
            if (charTypeClazz.catchValidateValue()) {
                CharValueContext charValueContext = new CharValueContext(workflowContext, component, cmptSpec, cmptChar);
                charValueContext.setCharValue(charValue);
                boolean isPassValidate = charTypeClazz.onValidateValue(charValueContext);
                charValueContext.clear();
                return isPassValidate;
            }
            return true;
        }
        return true;
    }
}
