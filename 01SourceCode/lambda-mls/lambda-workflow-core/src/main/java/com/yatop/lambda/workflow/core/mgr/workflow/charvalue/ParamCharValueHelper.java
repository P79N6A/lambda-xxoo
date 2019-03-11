package com.yatop.lambda.workflow.core.mgr.workflow.charvalue;

import com.yatop.lambda.core.enums.LambdaExceptionEnum;
import com.yatop.lambda.core.enums.SourceLevelEnum;
import com.yatop.lambda.core.exception.LambdaException;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.context.CharValueContext;
import com.yatop.lambda.workflow.core.context.WorkflowContext;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.Node;
import com.yatop.lambda.workflow.core.richmodel.workflow.charvalue.CharValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParamCharValueHelper {

    public static Logger logger = LoggerFactory.getLogger(ParamCharValueHelper.class);

    //适用组件参数、执行调优参数
    public static void createParamCharValue(WorkflowContext workflowContext, Node node, CharValue charValue) {

        if(charValue.getCmptChar().data().getSrcLevel() != SourceLevelEnum.WORKFLOW.getSource()) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Create param value failed -- create non-workflow source level char-value.\n" + charValue, "节点参数级别异常", node.data());
        }

        if (DataUtil.isEmpty(charValue.getTextValue()))
            charValue.setTextValue(node.getComponent().getConfigCharValue(charValue.getCmptChar()));

        if (!validateParamCharValue(node, charValue)){
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Create param value failed -- char-value validation failed.\n" + charValue, "节点参数内容错误", node.data());
        }

        try {
            CharValueContext charValueContext = new CharValueContext(workflowContext, node, charValue);
            charValue.getCharTypeClazzBean().createCharValue(charValueContext);
            charValueContext.clear();
            return;
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Create param value failed -- Char-Type-Clazz occur error.\n" + charValue, "节点参数创建出错", node.data());
        }
    }

    //适用组件参数、执行调优参数
    public static void deleteParamCharValue(WorkflowContext workflowContext, Node node, CharValue charValue) {

        if(charValue.getCmptChar().data().getSrcLevel() != SourceLevelEnum.WORKFLOW.getSource()) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Delete param value failed -- delete non-workflow source level char-value.\n" + charValue, "节点参数级别异常", node.data());
        }

        if(DataUtil.isEmpty(charValue.getCharValue())) {
            return;
        }

        try {
            CharValueContext charValueContext = new CharValueContext(workflowContext, node, charValue);
            charValue.getCharTypeClazzBean().deleteCharValue(charValueContext);
            charValueContext.clear();
            return;
        } catch (Throwable e) {
            e = new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Delete param value failed -- Char-Type-Clazz occur error.\n" + charValue, "节点参数删除出错", e, node.data());
            logger.error("系统内部发生错误", e);
        }
    }

    //适用组件参数、执行调优参数
    public static void recoverParamCharValue(WorkflowContext workflowContext, Node node, CharValue charValue) {

        if(charValue.getCmptChar().data().getSrcLevel() != SourceLevelEnum.WORKFLOW.getSource()) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Recover param value failed -- recover non-workflow source level char-value.\n" + charValue, "节点参数级别异常", node.data());
        }

        if(DataUtil.isEmpty(charValue.getCharValue())) {
            return;
        }

        try {
            CharValueContext charValueContext = new CharValueContext(workflowContext, node, charValue);
            charValue.getCharTypeClazzBean().recoverCharValue(charValueContext);
            charValueContext.clear();
            return;
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Recover param value failed -- Char-Type-Clazz occur error.\n" + charValue, "节点参数恢复出错", e, node.data());
        }
    }

    //适用组件参数、执行调优参数
    public static void updateParamCharValue(WorkflowContext workflowContext, Node node, CharValue charValue) {

        if(charValue.getCmptChar().data().getSrcLevel() != SourceLevelEnum.WORKFLOW.getSource()) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Update param value failed -- update non-workflow source level char-value.\n" + charValue, "节点参数级别异常", node.data());
        }

        if (!validateParamCharValue(node, charValue)){
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Update param value failed -- char-value validation failed.\n" + charValue, "节点参数内容错误", node.data());

            //特征值和更新参数值内容都为空时
        } else if(DataUtil.isEmpty(charValue.getCharValue()) && DataUtil.isEmpty(charValue.getTextValue())) {
            return;
        }

        try {
            CharValueContext charValueContext = new CharValueContext(workflowContext, node, charValue);
            charValue.getCharTypeClazzBean().updateCharValue(charValueContext);
            charValueContext.clear();
            return;
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Update param value failed -- Char-Type-Clazz occur error.\n" + charValue, "节点参数更新出错", e, node.data());
        }
    }

    //适用组件参数、执行调优参数、调用执行参数
    public static void queryParamCharValue(Node node, CharValue charValue) {

        if (DataUtil.isEmpty(charValue.getCharValue()))
            charValue.setCharValue(node.getComponent().getConfigCharValue(charValue.getCmptChar()));

        if(DataUtil.isEmpty(charValue.getCharValue())) {
            return;
        }

        try {
            charValue.getCharTypeClazzBean().queryCharValue(charValue);
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query param value failed -- Char-Type-Clazz occur error.\n" + charValue, "节点参数查询出错", e, node.data());
        }
    }

    //适用组件参数、执行调优参数、调用执行参数
    public static boolean validateParamCharValue(Node node, CharValue charValue) {

        try {
            boolean isPassValidate = charValue.getCharTypeClazzBean().validateCharValue(charValue);
            return isPassValidate;
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Validate param value failed -- Char-Type-Clazz occur error.\n" + charValue, "节点参数校验出错", e, node.data());
        }
    }
}
