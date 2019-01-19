package com.yatop.lambda.workflow.core.mgr.workflow.node;

import com.yatop.lambda.core.enums.LambdaExceptionEnum;
import com.yatop.lambda.core.exception.LambdaException;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.context.ExecutionTaskContext;
import com.yatop.lambda.workflow.core.framework.module.IModuleClazz;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class NodeTaskExecution {

    public static Logger logger = LoggerFactory.getLogger(NodeTaskExecution.class);

    public void prepareTaskExecutionOutputResource(ExecutionTaskContext executionTaskContext) {

        IModuleClazz moduleClazz = executionTaskContext.getNode().getModuleClazzBean();
        try {
            moduleClazz.prepareTaskExecutionOutput(executionTaskContext);
        } catch (Exception e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Prepare task execution output resource failed -- module-clazz occur error.", "准备节点任务运行输出资源时发生错误", e, executionTaskContext.getNode());
        }

        if(DataUtil.isNotEmpty(executionTaskContext.getWarningMsg())) {
            executionTaskContext.getTask().changeOccuredWarning(String.format("任务节点[%s]:%s", executionTaskContext.getNode().data().getNodeName(), executionTaskContext.getWarningMsg()));
        }
    }

    public void clearTaskExecutionOutputResource(ExecutionTaskContext executionTaskContext) {

        IModuleClazz moduleClazz = executionTaskContext.getNode().getModuleClazzBean();
        try {
            moduleClazz.clearTaskExecutionOutput(executionTaskContext);
        } catch (Exception e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Clear task execution output resource failed -- module-clazz occur error.", "清理节点任务运行输出资源时发生错误", e, executionTaskContext.getNode());
        }

        if(DataUtil.isNotEmpty(executionTaskContext.getWarningMsg())) {
            logger.error(String.format("运行作业[%d], 任务节点[%s]:%s", executionTaskContext.getJob().data().getJobId(), executionTaskContext.getNode().data().getNodeName(), executionTaskContext.getWarningMsg()));
        }
    }
}
