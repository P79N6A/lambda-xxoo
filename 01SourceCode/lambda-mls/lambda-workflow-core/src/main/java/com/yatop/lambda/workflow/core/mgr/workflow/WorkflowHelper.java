package com.yatop.lambda.workflow.core.mgr.workflow;


import com.yatop.lambda.core.mgr.workflow.WorkflowMgr;
import com.yatop.lambda.workflow.core.richmodel.workflow.Workflow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WorkflowHelper {

    private static WorkflowMgr WORKFLOW_MGR;

    @Autowired
    public void setWorkflowMgr(WorkflowMgr workflowMgr) {
        WORKFLOW_MGR = workflowMgr;
    }

    //名称、共享锁状态、共享锁消息、下一快照版本、节点数量、下一删除批次、最后作业ID、DFS工作流目录、本地工作流目录、工作流状态、描述、版本号
    public static void updateWorkflow(Workflow workflow, String operId) {
        WORKFLOW_MGR.updateWorkflow(workflow, operId);
    }
}
