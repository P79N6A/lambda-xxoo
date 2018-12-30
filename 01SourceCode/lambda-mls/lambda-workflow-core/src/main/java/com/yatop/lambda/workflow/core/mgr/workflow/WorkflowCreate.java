package com.yatop.lambda.workflow.core.mgr.workflow;

import com.yatop.lambda.base.model.WfFlow;
import com.yatop.lambda.core.mgr.workflow.WorkflowMgr;
import com.yatop.lambda.core.utils.WorkDirectoryUtil;
import com.yatop.lambda.workflow.core.richmodel.experiment.Experiment;
import com.yatop.lambda.workflow.core.richmodel.workflow.Workflow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkflowCreate {

    @Autowired
    private WorkflowMgr workflowMgr;

    public Workflow createWorkflow(Experiment experiment, String operId) {

        WfFlow flow = new WfFlow();
        flow.setFlowName(experiment.getExperimentId() + " - WorkFLow");
        flow.setOwnerProjectId(experiment.getOwnerProjectId());
        flow.setOwnerExperimentId(experiment.getExperimentId());
        flow = workflowMgr.insertWorkflow(flow, operId);

        Workflow richWorkflow = new Workflow(flow);
        richWorkflow.setFlowDfsDir(WorkDirectoryUtil.getWorkFLowDfsDirectory(experiment.getOwnerProjectId(), richWorkflow.getFlowId()));
        richWorkflow.setFlowLocalDir(WorkDirectoryUtil.getWorkFLowLocalDirectory(experiment.getOwnerProjectId(), richWorkflow.getFlowId()));
        workflowMgr.updateWorkflow(richWorkflow, operId);

        richWorkflow.copyProperties(workflowMgr.queryWorkflow(richWorkflow.getFlowId()));
        return richWorkflow;
    }

/*    public Workflow createWorkflow(Experiment experiment, WorkflowContext otherContext, String operId) {
        Workflow richWorkflow = createWorkflowWithBlank(experiment, operId);

        WorkflowContext workFlowContext = new WorkflowContext(experiment.getProject(), richWorkflow, operId);

        return null;
    }*/
}
