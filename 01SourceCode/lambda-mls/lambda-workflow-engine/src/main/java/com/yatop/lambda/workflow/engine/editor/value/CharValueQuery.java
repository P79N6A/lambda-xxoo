package com.yatop.lambda.workflow.engine.editor.value;

import com.yatop.lambda.core.enums.LambdaExceptionEnum;
import com.yatop.lambda.core.enums.SpecTypeEnum;
import com.yatop.lambda.core.exception.LambdaException;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.context.CharValueContext;
import com.yatop.lambda.workflow.core.context.WorkflowContext;
import com.yatop.lambda.workflow.core.framework.chartype.ICharTypeClazz;
import com.yatop.lambda.workflow.core.richmodel.workflow.CharValue;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.Node;
import com.yatop.lambda.workflow.core.utils.ClazzHelper;
import org.springframework.stereotype.Service;

@Service
public class CharValueQuery {

    //适用组件参数、执行调优参数、输出内容、输入内容、调用执行
    // CharValue <[charValue] ==>> [outText, outObject]>
    public void queryCharValue(WorkflowContext workflowContext, Node node, CharValue charValue) {

        if(charValue.getSpecType() != SpecTypeEnum.INPUT.getType() && charValue.getSpecType() != SpecTypeEnum.OUTPUT.getType()) {
            if (DataUtil.isEmpty(charValue.getCharValue()))
                charValue.setCharValue(node.getComponent().getConfigCharValue(charValue.getCmptChar()));
        }

        if(DataUtil.isEmpty(charValue.getCharValue())) {
            return;
        }

        ICharTypeClazz charTypeClazz = ClazzHelper.getCharTypeClazzBean(charValue.getCmptChar().getType());
        if (charTypeClazz.catchQueryValue()) {

            try {
                CharValueContext charValueContext = new CharValueContext(workflowContext, node, charValue);
                charTypeClazz.onQueryValue(charValueContext);
                charValueContext.clear();
                return;
            } catch (Exception e) {
                throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query characteristic value failed -- char-type-clazz occur error.", "计算组件特征值查询时发生错误", e);
            }
        } else if(charValue.getSpecType() == SpecTypeEnum.INPUT.getType() || charValue.getSpecType() == SpecTypeEnum.OUTPUT.getType()) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query characteristic value failed -- char-type-clazz uncaught input/output char-value query event.", "系统内部严重错误，请联系管理员");
        } else {
            charValue.setOutText(charValue.getCharValue());
            return;
        }
    }
}
