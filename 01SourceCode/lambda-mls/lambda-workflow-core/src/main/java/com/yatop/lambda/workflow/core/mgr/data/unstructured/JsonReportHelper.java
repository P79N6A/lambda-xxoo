package com.yatop.lambda.workflow.core.mgr.data.unstructured;

import com.yatop.lambda.base.model.WfJsonObject;
import com.yatop.lambda.core.enums.JsonObjectStateEnum;
import com.yatop.lambda.core.enums.JsonObjectTypeEnum;
import com.yatop.lambda.core.enums.LambdaExceptionEnum;
import com.yatop.lambda.core.enums.StorageLocationEnum;
import com.yatop.lambda.core.exception.LambdaException;
import com.yatop.lambda.core.mgr.workflow.unstructured.JsonObjectMgr;
import com.yatop.lambda.core.utils.JsonObjectFileUtil;
import com.yatop.lambda.workflow.core.context.CharValueContext;
import com.yatop.lambda.workflow.core.context.WorkflowContext;
import com.yatop.lambda.workflow.core.richmodel.component.characteristic.CmptChar;
import com.yatop.lambda.workflow.core.richmodel.data.unstructured.JsonReport;
import com.yatop.lambda.workflow.core.richmodel.workflow.charvalue.CharValue;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.Node;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JsonReportHelper {

    private static JsonObjectMgr JSON_OBJECT_MGR;

    @Autowired
    public void setJsonObjectMgr(JsonObjectMgr jsonObjectMgr) {
        JSON_OBJECT_MGR = jsonObjectMgr;
    }

    public static void createJsonReport(CharValueContext context, JsonObjectTypeEnum jsonObjectType) {
        WorkflowContext workflowContext = context.getWorkflowContext();
        Node node = context.getNode();
        CmptChar cmptChar = context.getCmptChar();

        String reportNamePrefix = null;
        switch (jsonObjectType) {
            case MODEL_EVALUATION_REPORT:
                reportNamePrefix = "model_evaluation_report";
                break;
            case STATISTICAL_ANALYTICS_REPORT:
                reportNamePrefix = "statistical_analytics_report";
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
        jsonObject.setObjectName(String.format("%s_%d_%s", reportNamePrefix, node.data().getNodeId(), cmptChar.data().getCharId()));
        jsonObject.setObjectType(jsonObjectType.getType());
        jsonObject.setOwnerProjectId(workflowContext.getProject().data().getProjectId());
        jsonObject.setRelFlowId(workflowContext.getWorkflow().data().getFlowId());
        jsonObject.setRelNodeId(node.data().getNodeId());
        jsonObject.setRelCharId(cmptChar.data().getCharId());
        jsonObject.setStorageLocation(StorageLocationEnum.FILE_SYSTEM.getLocation());
        jsonObject.setObjectState(JsonObjectStateEnum.EMPTY.getState());
        jsonObject = JSON_OBJECT_MGR.insertJsonObject(jsonObject, workflowContext.getOperId());

        String flowDfsDir = workflowContext.getWorkflow().data().getFlowDfsDir();
        String flowLocalDir = workflowContext.getWorkflow().data().getFlowLocalDir();
        jsonObject.setObjectDfsFile(JsonObjectFileUtil.getFilePath4Report(flowDfsDir, reportNamePrefix, node.data().getNodeId(), jsonObject.getObjectId()));
        jsonObject.setObjectLocalFile(JsonObjectFileUtil.getFilePath4Report(flowLocalDir, reportNamePrefix, node.data().getNodeId(), jsonObject.getObjectId()));
        JSON_OBJECT_MGR.updateJsonObject(jsonObject, workflowContext.getOperId());
        JsonReport richJsonReport = new JsonReport(jsonObject);

        context.getCharValue().setCharValue(String.valueOf(richJsonReport.data().getObjectId()));
        context.getCharValue().setObjectValue(richJsonReport);
    }

    public static void deleteJsonReport(CharValueContext context) {
        WorkflowContext workflowContext = context.getWorkflowContext();
        clearJsonReport(context);
        JSON_OBJECT_MGR.deleteJsonObject(Long.parseLong(context.getCharValue().getCharValue()), workflowContext.getOperId());
    }

    public static void recoverJsonReport(CharValueContext context) {
        WorkflowContext workflowContext = context.getWorkflowContext();
        JSON_OBJECT_MGR.recoverJsonObject(Long.parseLong(context.getCharValue().getCharValue()), workflowContext.getOperId());
        queryJsonReport(context.getCharValue());
    }

    public static void completeJsonReport(CharValueContext context) {
        WorkflowContext workflowContext = context.getWorkflowContext();
        JsonReport jsonObject = context.getCharValue().getJsonReport();

        jsonObject.data().setObjectState(JsonObjectStateEnum.NORMAL.getState());
        JSON_OBJECT_MGR.updateJsonObject(jsonObject.data(), workflowContext.getOperId());

        //TODO synchronize dfs report file to local filesystem
    }

    public static void clearJsonReport(CharValueContext context) {
        WorkflowContext workflowContext = context.getWorkflowContext();
        JsonReport jsonObject = context.getCharValue().getJsonReport();

        jsonObject.data().setObjectState(JsonObjectStateEnum.EMPTY.getState());
        JSON_OBJECT_MGR.updateJsonObject(jsonObject.data(), workflowContext.getOperId());

        //TODO remove dfs & local report file
    }

    public static JsonReport queryJsonReport(CharValue charValue) {
        WfJsonObject jsonObject = JSON_OBJECT_MGR.queryJsonObject(Long.parseLong(charValue.getCharValue()));

        JsonReport richJsonReport = new JsonReport(jsonObject);
        charValue.setObjectValue(richJsonReport);
        return richJsonReport;
    }
}
