package com.yatop.lambda.workflow.core.mgr.workflow.charvalue;

import com.yatop.lambda.core.enums.LambdaExceptionEnum;
import com.yatop.lambda.core.exception.LambdaException;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.context.CharValueContext;
import com.yatop.lambda.workflow.core.context.WorkflowContext;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.Node;
import com.yatop.lambda.workflow.core.richmodel.workflow.charvalue.CharValue;

public class OutputCharValueHelper {

    //适用输出内容
    public void exploreOutputCharValue(WorkflowContext workflowContext, Node node, CharValue charValue) {

        if(DataUtil.isEmpty(charValue.getCharValue())) {
            return;
        }

        try {
            CharValueContext charValueContext = new CharValueContext(workflowContext, node, charValue);
            charValue.getCharTypeClazzBean().exploreOutputCharValue(charValueContext);
            charValueContext.clear();
            return;
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Explore output value failed -- Char-Type-Clazz occur error.\n" + charValue, "节点输出探测出错", e, node.data());
        }
    }

    //适用输出内容
    public void prepareOutputCharValue(WorkflowContext workflowContext, Node node, CharValue charValue) {

        try {
            CharValueContext charValueContext = new CharValueContext(workflowContext, node, charValue);
            charValue.getCharTypeClazzBean().prepareOutputCharValue(charValueContext);
            charValueContext.clear();
            return;
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Prepare output value failed -- Char-Type-Clazz occur error.\n" + charValue, "节点输出准备出错", e, node.data());
        }
    }

    //适用输出内容
    public static void completeOutputCharValue(WorkflowContext workflowContext, Node node, CharValue charValue) {

        if(DataUtil.isEmpty(charValue.getCharValue())) {
            return;
        }

        try {
            CharValueContext charValueContext = new CharValueContext(workflowContext, node, charValue);
            charValue.getCharTypeClazzBean().completeOutputCharValue(charValueContext);
            charValueContext.clear();
            return;
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Complete output value failed -- Char-Type-Clazz occur error.\n" + charValue, "节点输出完成出错", e, node.data());
        }
    }

    //适用输出内容
    public static void clearOutputCharValue(WorkflowContext workflowContext, Node node, CharValue charValue) {

        if(DataUtil.isEmpty(charValue.getCharValue())) {
            return;
        }

        try {
            CharValueContext charValueContext = new CharValueContext(workflowContext, node, charValue);
            charValue.getCharTypeClazzBean().clearOutputCharValue(charValueContext);
            charValueContext.clear();
            return;
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Clear output value failed -- Char-Type-Clazz occur error.\n" + charValue, "节点输出清理出错", e, node.data());
        }
    }

    //适用输出内容
    public void deleteOutputCharValue(WorkflowContext workflowContext, Node node, CharValue charValue) {

        if(DataUtil.isEmpty(charValue.getCharValue())) {
            return;
        }

        try {
            CharValueContext charValueContext = new CharValueContext(workflowContext, node, charValue);
            charValue.getCharTypeClazzBean().deleteOutputCharValue(charValueContext);
            charValueContext.clear();
            return;
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Delete output value failed -- Char-Type-Clazz occur error.\n" + charValue, "节点输出删除出错", e, node.data());
        }
    }

    //适用输出内容
    public void recoverOutputCharValue(WorkflowContext workflowContext, Node node, CharValue charValue) {

        if(DataUtil.isEmpty(charValue.getCharValue())) {
            return;
        }

        try {
            CharValueContext charValueContext = new CharValueContext(workflowContext, node, charValue);
            charValue.getCharTypeClazzBean().recoverOutputCharValue(charValueContext);
            charValueContext.clear();
            return;
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Recover output value failed -- Char-Type-Clazz occur error.\n" + charValue, "节点输出恢复出错", e, node.data());
        }
    }
}
