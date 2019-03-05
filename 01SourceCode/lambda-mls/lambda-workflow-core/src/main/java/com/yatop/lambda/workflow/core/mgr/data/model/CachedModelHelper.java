package com.yatop.lambda.workflow.core.mgr.data.model;

import com.yatop.lambda.base.model.MwModel;
import com.yatop.lambda.core.enums.ModelStateEnum;
import com.yatop.lambda.core.enums.ModelTypeEnum;
import com.yatop.lambda.core.mgr.model.ModelMgr;
import com.yatop.lambda.core.utils.ModelFileUtil;
import com.yatop.lambda.workflow.core.context.CharValueContext;
import com.yatop.lambda.workflow.core.context.WorkflowContext;
import com.yatop.lambda.workflow.core.richmodel.component.characteristic.CmptChar;
import com.yatop.lambda.workflow.core.richmodel.data.model.Model;
import com.yatop.lambda.workflow.core.richmodel.workflow.charvalue.CharValue;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.Node;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CachedModelHelper {

    private static ModelMgr MODEL_MGR;

    @Autowired
    public void setModelMgr(ModelMgr modelMgr) {
        MODEL_MGR = modelMgr;
    }

    public static Model createCachedModel(CharValueContext context) {
        WorkflowContext workflowContext = context.getWorkflowContext();
        Node node = context.getNode();
        CmptChar cmptChar = context.getCmptChar();

        MwModel model = new MwModel();
        model.setModelName(String.format("%s - %d - Model", node.getModule().data().getModuleName(), node.data().getSequence()));
        model.setModelType(ModelTypeEnum.CACHED.getType());
        model.setOwnerMwId(workflowContext.getModelWarehouse().data().getMwId());
        model.setRelFlowId(workflowContext.getWorkflow().data().getFlowId());
        model.setRelNodeId(node.data().getNodeId());
        model.setRelCharId(cmptChar.data().getCharId());
        model.setRefAlgorithmId(node.getComponent().getAlgorithm().data().getAlgorithmId());
        model.setModelState(ModelStateEnum.EMPTY.getState());
        model = MODEL_MGR.insertModel(model, workflowContext.getOperId());

        String flowDfsDir = workflowContext.getWorkflow().data().getFlowDfsDir();
        String flowLocalDir = workflowContext.getWorkflow().data().getFlowLocalDir();
        model.setModelFile(ModelFileUtil.getFilePath4Cached(flowDfsDir, node.data().getNodeId(), model.getModelId()));
        model.setSummaryDfsFile(ModelFileUtil.getSummaryFilePath4Cached(flowDfsDir, node.data().getNodeId(), model.getModelId()));
        model.setSummaryLocalFile(ModelFileUtil.getSummaryFilePath4Cached(flowLocalDir, node.data().getNodeId(), model.getModelId()));
        MODEL_MGR.updateModel(model, workflowContext.getOperId());
        return new Model(model);
    }

    public static void deleteCachedModel(CharValueContext context) {
        WorkflowContext workflowContext = context.getWorkflowContext();
        clearCachedModel(context);
        MODEL_MGR.deleteModel(Long.parseLong(context.getCharValue().getCharValue()), workflowContext.getOperId());
    }

    public static void recoverCachedModel(CharValueContext context) {
        WorkflowContext workflowContext = context.getWorkflowContext();
        MODEL_MGR.recoverModel(Long.parseLong(context.getCharValue().getCharValue()), workflowContext.getOperId());
        queryCachedModel(context.getCharValue());
    }

    public static void completeCachedModel(CharValueContext context) {
        WorkflowContext workflowContext = context.getWorkflowContext();
        Model model = context.getCharValue().getModel();

        model.data().setModelNameColoured(true);
        model.data().setModelFileSizeColoured(true);
        model.data().setTrainTableIdColoured(true);
        model.data().setTrainCostTimeColoured(true);
        model.data().setModelState(ModelStateEnum.NORMAL.getState());
        MODEL_MGR.updateModel(model.data(), workflowContext.getOperId());

        //TODO synchronize dfs model file to local filesystem
    }

    public static void clearCachedModel(CharValueContext context) {
        WorkflowContext workflowContext = context.getWorkflowContext();
        Model model = context.getCharValue().getModel();

        model.data().setModelFileSize(null);
        model.data().setTrainTableId(null);
        model.data().setTrainCostTime(null);
        model.data().setModelState(ModelStateEnum.EMPTY.getState());
        MODEL_MGR.updateModel(model.data(), workflowContext.getOperId());

        //TODO remove dfs & local model file
    }

    public static Model queryCachedModel(CharValue charValue) {
        MwModel model = MODEL_MGR.queryModel(Long.parseLong(charValue.getCharValue()));

        Model richModel = new Model(model);
        charValue.setObjectValue(richModel);
        return richModel;
    }
}
