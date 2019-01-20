package com.yatop.lambda.workflow.core.mgr.workflow.module;

import com.yatop.lambda.core.enums.LambdaExceptionEnum;
import com.yatop.lambda.core.exception.LambdaException;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.context.ExecutionTaskContext;
import com.yatop.lambda.workflow.core.context.WorkflowContext;
import com.yatop.lambda.workflow.core.framework.module.IModuleClazz;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.Node;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class OutputResourceHelper {

    public static Logger logger = LoggerFactory.getLogger(OutputResourceHelper.class);

    public static void prepareOutputResource(ExecutionTaskContext executionTaskContext) {

        IModuleClazz moduleClazz = executionTaskContext.getNode().getModuleClazzBean();
        try {
            moduleClazz.prepareOutputResource(executionTaskContext);
        } catch (Exception e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Prepare task execution output resource failed -- module-clazz occur error.", "准备输出资源时发生错误", e, executionTaskContext.getNode());
        }

        if(DataUtil.isNotEmpty(executionTaskContext.getWarningMsg())) {
            executionTaskContext.getTask().changeOccuredWarning(String.format("任务节点[%s]:%s", executionTaskContext.getNode().data().getNodeName(), executionTaskContext.getWarningMsg()));
        }
    }

    public static void completeOutputResource(ExecutionTaskContext executionTaskContext) {

        IModuleClazz moduleClazz = executionTaskContext.getNode().getModuleClazzBean();
        try {
            moduleClazz.completeOutputResource(executionTaskContext);
        } catch (Exception e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Complete task execution output resource failed -- module-clazz occur error.", "完成输出资源时发生错误", e, executionTaskContext.getNode());
        }

        if(DataUtil.isNotEmpty(executionTaskContext.getWarningMsg())) {
            logger.error(String.format("运行作业[%d], 任务节点[%s]:%s", executionTaskContext.getJob().data().getJobId(), executionTaskContext.getNode().data().getNodeName(), executionTaskContext.getWarningMsg()));
        }
    }

    public static void clearOutputResource(ExecutionTaskContext executionTaskContext) {

        IModuleClazz moduleClazz = executionTaskContext.getNode().getModuleClazzBean();
        try {
            moduleClazz.clearOutputResource(executionTaskContext);
        } catch (Exception e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Clear task execution output resource failed -- module-clazz occur error.", "清理输出资源时发生错误", e, executionTaskContext.getNode());
        }

        if(DataUtil.isNotEmpty(executionTaskContext.getWarningMsg())) {
            logger.error(String.format("运行作业[%d], 任务节点[%s]:%s", executionTaskContext.getJob().data().getJobId(), executionTaskContext.getNode().data().getNodeName(), executionTaskContext.getWarningMsg()));
        }
    }

    public static void exploreOutputResource(WorkflowContext workflowContext, Node node) {

        IModuleClazz moduleClazz = node.getModuleClazzBean();
        try {
            moduleClazz.exploreOutputResource(workflowContext, node);
        } catch (Exception e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Explore task execution output resource failed -- module-clazz occur error.", "探测输出资源时发生错误", e, node);
        }
    }
}
