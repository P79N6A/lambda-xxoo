package com.yatop.lambda.workflow.core.mgr.workflow.node;

import com.yatop.lambda.core.enums.LambdaExceptionEnum;
import com.yatop.lambda.core.exception.LambdaException;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.context.ExecutionTaskContext;
import com.yatop.lambda.workflow.core.framework.module.IModuleClazz;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.Node;
import org.springframework.stereotype.Service;

@Service
public class NodeTaskExecution {

    public void prepareTaskExecutionOutputResource(ExecutionTaskContext executionTaskContext) {

        IModuleClazz moduleClazz = executionTaskContext.getNode().getModuleClazzBean();

        try {
            moduleClazz.prepareTaskExecutionOutputResource(executionTaskContext);
        } catch (Exception e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Node task execution pre-process failed -- module-clazz occur error.", "工作流组件节点任务运行预处理时发生错误", e, executionTaskContext.getNode());
        }

        if(DataUtil.isNotEmpty(executionTaskContext.getWarningMsg())) {
            executionTaskContext.getTask().changeOccuredWarning(String.format("任务节点[%s]:%s", executionTaskContext.getNode().data().getNodeName(), executionTaskContext.getWarningMsg()));
        }
    }

    public void clearTaskExecutionOutputResource(ExecutionTaskContext executionTaskContext) {

        IModuleClazz moduleClazz = executionTaskContext.getNode().getModuleClazzBean();

        try {
            moduleClazz.prepareTaskExecutionOutputResource(executionTaskContext);
        } catch (Exception e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Node task execution pre-process failed -- module-clazz occur error.", "工作流组件节点任务运行预处理时发生错误", e, executionTaskContext.getNode());
        }

        if(DataUtil.isNotEmpty(executionTaskContext.getWarningMsg())) {
            executionTaskContext.getTask().changeOccuredWarning(String.format("任务节点[%s]:%s", executionTaskContext.getNode().data().getNodeName(), executionTaskContext.getWarningMsg()));
        }
    }
}
