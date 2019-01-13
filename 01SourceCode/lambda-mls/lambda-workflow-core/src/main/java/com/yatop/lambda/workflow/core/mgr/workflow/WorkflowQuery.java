package com.yatop.lambda.workflow.core.mgr.workflow;


import com.yatop.lambda.base.model.WfFlow;
import com.yatop.lambda.core.mgr.workflow.WorkflowMgr;
import com.yatop.lambda.workflow.core.richmodel.experiment.Experiment;
import com.yatop.lambda.workflow.core.richmodel.workflow.Workflow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkflowQuery {

    @Autowired
    WorkflowMgr workflowMgr;

    public Workflow queryWorkflow(Experiment experiment) {
        WfFlow workflow = workflowMgr.queryWorkflow(experiment.getWorkflowId());
        return new Workflow(workflow, experiment);
    }
}
