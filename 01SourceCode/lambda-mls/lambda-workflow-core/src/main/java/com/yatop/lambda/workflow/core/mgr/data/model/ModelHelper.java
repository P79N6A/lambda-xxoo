package com.yatop.lambda.workflow.core.mgr.data.model;

import com.yatop.lambda.base.model.MwModel;
import com.yatop.lambda.core.enums.ModelSourceEnum;
import com.yatop.lambda.core.enums.ModelStateEnum;
import com.yatop.lambda.core.enums.ModelTypeEnum;
import com.yatop.lambda.core.mgr.model.ModelMgr;
import com.yatop.lambda.core.utils.ModelFileUtil;
import com.yatop.lambda.core.utils.WorkDirectoryUtil;
import com.yatop.lambda.workflow.core.context.CharValueContext;
import com.yatop.lambda.workflow.core.context.WorkflowContext;
import com.yatop.lambda.workflow.core.richmodel.data.model.Model;
import com.yatop.lambda.workflow.core.richmodel.workflow.execution.ExecutionJob;
import com.yatop.lambda.workflow.core.richmodel.workflow.execution.ExecutionTask;
import com.yatop.lambda.workflow.core.richmodel.workflow.module.ModulePort;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.Node;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ModelHelper {

    private static ModelMgr MODEL_MGR;

    @Autowired
    public void setModelMgr(ModelMgr modelMgr) {
        MODEL_MGR = modelMgr;
    }

    public static Model createCachedModel(CharValueContext context) {
        WorkflowContext workflowContext = context.getWorkflowContext();
        Node node = context.getNode();
        ModulePort modulePort = node.getOutputNodePort(context.getCmptChar().data().getCharId()).getModulePort();
        ExecutionJob job = workflowContext.getCurrentJob();
        ExecutionTask task = workflowContext.getExecutionTask(node);

        MwModel model = new MwModel();
        model.setModelName(String.format("%s - %d - Model", node.getModule().data().getModuleName(), node.data().getSequence()));
        model.setModelType(ModelTypeEnum.CACHED.getType());
        model.setModelSrc(ModelSourceEnum.EXECUTION.getSource());
        model.setOwnerMwId(workflowContext.getModelWarehouse().data().getMwId());
        model.setRelFlowId(workflowContext.getWorkflow().data().getFlowId());
        model.setRelNodeId(node.data().getNodeId());
        model.setRelCharId(modulePort.getCmptChar().data().getCharId());
        model.setRelTaskId(task.data().getTaskId());
        model.setRefAlgorithmId(node.getComponent().getAlgorithm().data().getAlgorithmId());
        model.setModelState(ModelStateEnum.EMPTY.getState());
        model = MODEL_MGR.insertModel(model, workflowContext.getOperId());

        String jobDfsDir = WorkDirectoryUtil.getJobDfsDirectory(workflowContext.getProject().data().getProjectId(), workflowContext.getWorkflow().data().getFlowId(), job.data().getJobId());
        String jobLocalDir = WorkDirectoryUtil.getJobDfsDirectory(workflowContext.getProject().data().getProjectId(), workflowContext.getWorkflow().data().getFlowId(), job.data().getJobId());
        model.setModelFile(ModelFileUtil.getFilePath4Cached(jobDfsDir, task.data().getTaskId(), model.getModelId()));
        model.setDfsSummaryFile(ModelFileUtil.getSummaryFilePath4Cached(jobDfsDir, task.data().getTaskId(), model.getModelId()));
        model.setLocalSummaryFile(ModelFileUtil.getSummaryFilePath4Cached(jobLocalDir, task.data().getTaskId(), model.getModelId()));
        MODEL_MGR.updateModel(model, workflowContext.getOperId());
        return new Model(model);
    }

    public static void deleteModel(CharValueContext context, Model model) {
        WorkflowContext workflowContext = context.getWorkflowContext();
        MODEL_MGR.deleteModel(model.data().getModelId(), workflowContext.getOperId());

        //TODO ignore model state
        //TODO clear modelFile & summaryDataFile
    }

    public static void updateModel(CharValueContext context, Model model) {
        WorkflowContext workflowContext = context.getWorkflowContext();
        model.data().setModelNameColoured(true);
        model.data().setModelFileSizeColoured(true);
        model.data().setTrainTableIdColoured(true);
        model.data().setTrainCostTimeColoured(true);
        model.data().setModelState(ModelStateEnum.NORMAL.getState());
        MODEL_MGR.updateModel(model.data(), workflowContext.getOperId());
    }

    public static Model queryModel(Long modelId) {
        MwModel model = MODEL_MGR.queryModel(modelId);
        return new Model(model);
    }
}
