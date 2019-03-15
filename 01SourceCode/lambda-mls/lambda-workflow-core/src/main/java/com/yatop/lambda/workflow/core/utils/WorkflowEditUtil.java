package com.yatop.lambda.workflow.core.utils;

import com.yatop.lambda.core.concurrent.workflow.WorkflowNamedLockService;
import com.yatop.lambda.core.enums.LambdaExceptionEnum;
import com.yatop.lambda.core.exception.LambdaException;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.config.ModuleConfig;
import com.yatop.lambda.workflow.core.richmodel.experiment.Experiment;
import com.yatop.lambda.workflow.core.richmodel.workflow.Workflow;
import com.yatop.lambda.workflow.core.richmodel.workflow.module.Module;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.Node;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.NodeParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WorkflowEditUtil {

    @Autowired
    WorkflowNamedLockService workflowNamedLockService;

    @Autowired
    ModuleConfig moduleConfig;

    //请求工作流资源锁
    public void requestWorkflowResource(Workflow workflow) {
        boolean lockedResource = workflowNamedLockService.requestResource(workflow.data().getFlowId());
        if(!lockedResource) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Request workflow resource failed.", "当前工作流资源锁定中，请稍后再试！", workflow.data());
        }
    }

    //释放工作流资源锁
    public void releaseWorkflowResource() {
        workflowNamedLockService.releaseResource();
    }

    //检测工作流共享锁
    public void detectWorkflowShareLock(Workflow workflow) {
        if(workflow.isWorkflowLocked()) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Request edit workflow failed -- workflow locked.", "当前工作流状态不可编辑", workflow.data());
        }
    }

    public Module findWorkflowModule(Long moduleId) {
        Module module = moduleConfig.getModule(moduleId);

        if(DataUtil.isNull(module)) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Find workflow module failed -- module not exists.", "工作流组件不存在");
        }
        return module;
    }
}
