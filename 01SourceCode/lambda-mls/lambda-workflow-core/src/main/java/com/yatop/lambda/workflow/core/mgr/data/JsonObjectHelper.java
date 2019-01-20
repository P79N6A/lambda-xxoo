package com.yatop.lambda.workflow.core.mgr.data;

import com.yatop.lambda.base.model.WfJsonObject;
import com.yatop.lambda.core.enums.*;
import com.yatop.lambda.core.exception.LambdaException;
import com.yatop.lambda.core.mgr.workflow.unstructured.JsonObjectMgr;
import com.yatop.lambda.core.utils.JsonObjectFileUtil;
import com.yatop.lambda.core.utils.WorkDirectoryUtil;
import com.yatop.lambda.workflow.core.context.CharValueContext;
import com.yatop.lambda.workflow.core.context.WorkflowContext;
import com.yatop.lambda.workflow.core.richmodel.data.unstructured.JsonObject;
import com.yatop.lambda.workflow.core.richmodel.workflow.execution.ExecutionJob;
import com.yatop.lambda.workflow.core.richmodel.workflow.execution.ExecutionTask;
import com.yatop.lambda.workflow.core.richmodel.workflow.module.ModulePort;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.Node;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JsonObjectHelper {

    private static JsonObjectMgr JSON_OBJECT_MGR;

    @Autowired
    public void setJsonObjectMgr(JsonObjectMgr jsonObjectMgr) {
        JSON_OBJECT_MGR = jsonObjectMgr;
    }
    public static JsonObject createJsonObject4Report(CharValueContext context, JsonObjectTypeEnum jsonObjectType) {
        WorkflowContext workflowContext = context.getWorkflowContext();
        Node node = context.getNode();
        ModulePort modulePort = node.getOutputNodePort(context.getCmptChar().data().getCharId()).getModulePort();
        ExecutionJob job = workflowContext.getCurrentJob();
        ExecutionTask task = workflowContext.getExecutionTask(node);

        String reportNamePrefix = null;
        switch (jsonObjectType) {
            case MODEL_EVALUATION_REPORT:
                reportNamePrefix = "model_evaluation_report";
                break;
            case STATISTICAL_ANALYSIS_REPORT:
                reportNamePrefix = "statistical_analysis_report";
                break;
            case TUNE_PARAMETERS_REPORT:
                reportNamePrefix = "tune_parameters_report";
                break;
            case GENERATE_RULES_REPORT:
                reportNamePrefix = "generate_rules_report";
                break;
            default:
                throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Create json object failed -- unexpected report type.", "未知报告类型");
        }

        WfJsonObject jsonObject = new WfJsonObject();
        jsonObject.setObjectName(String.format("%s_%d_%s_%d", reportNamePrefix, node.data().getNodeId(), modulePort.getCmptChar().data().getCharId(), job.data().getJobId()));
        jsonObject.setObjectType(jsonObjectType.getType());
        jsonObject.setObjectSrc(JsonObjectSourceEnum.EXECUTION.getSource());
        jsonObject.setOwnerProjectId(workflowContext.getProject().data().getProjectId());
        jsonObject.setRelFlowId(workflowContext.getWorkflow().data().getFlowId());
        jsonObject.setRelNodeId(node.data().getNodeId());
        jsonObject.setRelCharId(modulePort.getCmptChar().data().getCharId());
        jsonObject.setRelTaskId(task.data().getTaskId());
        jsonObject.setStorageLocation(StorageLocationEnum.FILE_SYSTEM.getLocation());
        jsonObject.setObjectState(JsonObjectStateEnum.EMPTY.getState());
        jsonObject = JSON_OBJECT_MGR.insertJsonObject(jsonObject, workflowContext.getOperId());

        String jobDfsDir = job.data().getJobDfsDir();
        String jobLocalDir = job.data().getJobLocalDir();
        jsonObject.setObjectDfsFile(JsonObjectFileUtil.getFilePath4Report(jobDfsDir, task.data().getTaskId(), jsonObject.getJsonObjectId()));
        jsonObject.setObjectLocalFile(JsonObjectFileUtil.getFilePath4Report(jobLocalDir, task.data().getTaskId(), jsonObject.getJsonObjectId()));
        JSON_OBJECT_MGR.updateJsonObject(jsonObject, workflowContext.getOperId());
        return new JsonObject(jsonObject);
    }

    public static void deleteJsonObject(CharValueContext context, JsonObject jsonObject) {
        WorkflowContext workflowContext = context.getWorkflowContext();
        JSON_OBJECT_MGR.deleteJsonObject(jsonObject.data().getJsonObjectId(), workflowContext.getOperId());

        //TODO ignore jsonObject state
        //TODO clear jsonObjectFile & summaryDataFile
    }

    public static void updateJsonObject(CharValueContext context, JsonObject jsonObject) {
        WorkflowContext workflowContext = context.getWorkflowContext();
        jsonObject.data().setJsonObjectNameColoured(true);
        jsonObject.data().setJsonObjectFileSizeColoured(true);
        jsonObject.data().setTrainTableIdColoured(true);
        jsonObject.data().setTrainCostTimeColoured(true);
        jsonObject.data().setJsonObjectState(JsonObjectStateEnum.NORMAL.getState());
        JSON_OBJECT_MGR.updateJsonObject(jsonObject.data(), workflowContext.getOperId());
    }

    public static JsonObject queryJsonObject(Long jsonObjectId) {
        WfJsonObject jsonObject = JSON_OBJECT_MGR.queryJsonObject(jsonObjectId);
        return new JsonObject(jsonObject);
    }
}
