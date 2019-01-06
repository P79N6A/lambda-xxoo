package com.yatop.lambda.workflow.core.mgr.workflow;

import com.yatop.lambda.base.model.WfFlow;
import com.yatop.lambda.core.mgr.workflow.WorkflowMgr;
import com.yatop.lambda.core.utils.WorkDirectoryUtil;
import com.yatop.lambda.workflow.core.context.WorkflowContext;
import com.yatop.lambda.workflow.core.richmodel.experiment.Experiment;
import com.yatop.lambda.workflow.core.richmodel.workflow.Workflow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkflowCreate {

    @Autowired
    private WorkflowMgr workflowMgr;

    public WorkflowContext createWorkflow(Experiment experiment, String operId) {

        WfFlow flow = new WfFlow();
        flow.setFlowId(experiment.data().getExperimentId());
        flow.setFlowName(experiment.data().getExperimentId() + " - WorkFLow");
        flow.setOwnerProjectId(experiment.data().getOwnerProjectId());
        flow = workflowMgr.insertWorkflow(flow, operId);

        Workflow richWorkflow = new Workflow(flow);
        richWorkflow.data().setFlowDfsDir(WorkDirectoryUtil.getWorkFLowDfsDirectory(experiment.data().getOwnerProjectId(), richWorkflow.data().getFlowId()));
        richWorkflow.data().setFlowLocalDir(WorkDirectoryUtil.getWorkFLowLocalDirectory(experiment.data().getOwnerProjectId(), richWorkflow.data().getFlowId()));
        workflowMgr.updateWorkflow(richWorkflow.data(), operId);

        //richWorkflow.copyProperties(workflowMgr.queryWorkflow(richWorkflow.data().getFlowId()));
        richWorkflow.changeState2Draft();
        return WorkflowContext.BuildWorkflowContext4Create(experiment.getProject(), richWorkflow, operId);
    }

    public WorkflowContext createWorkflow(Experiment experiment, WorkflowContext otherWorkflowContext, String operId) {
        WorkflowContext thisWorkFlowContext = createWorkflow(experiment, operId);

        //TODO ...

        thisWorkFlowContext.doneCopyWorkflow();
        return thisWorkFlowContext;
    }
}
