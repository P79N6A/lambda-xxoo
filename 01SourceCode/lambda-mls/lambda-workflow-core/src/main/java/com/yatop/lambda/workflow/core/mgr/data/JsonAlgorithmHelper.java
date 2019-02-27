package com.yatop.lambda.workflow.core.mgr.data;

import com.yatop.lambda.base.model.WfJsonObject;
import com.yatop.lambda.core.enums.JsonObjectStateEnum;
import com.yatop.lambda.core.enums.JsonObjectTypeEnum;
import com.yatop.lambda.core.enums.LambdaExceptionEnum;
import com.yatop.lambda.core.enums.StorageLocationEnum;
import com.yatop.lambda.core.exception.LambdaException;
import com.yatop.lambda.core.mgr.workflow.unstructured.JsonObjectMgr;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.core.utils.JsonObjectFileUtil;
import com.yatop.lambda.workflow.core.context.CharValueContext;
import com.yatop.lambda.workflow.core.context.WorkflowContext;
import com.yatop.lambda.workflow.core.richmodel.component.characteristic.CmptChar;
import com.yatop.lambda.workflow.core.richmodel.data.unstructured.JsonObject;
import com.yatop.lambda.workflow.core.richmodel.workflow.charvalue.CharValue;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.Node;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JsonAlgorithmHelper {

    private static JsonObjectMgr JSON_OBJECT_MGR;

    @Autowired
    public void setJsonObjectMgr(JsonObjectMgr jsonObjectMgr) {
        JSON_OBJECT_MGR = jsonObjectMgr;
    }

    public static void createJsonAlgorithm(CharValueContext context) {
        WorkflowContext workflowContext = context.getWorkflowContext();
        Node node = context.getNode();
        CmptChar cmptChar = context.getCmptChar();

        WfJsonObject jsonObject = new WfJsonObject();
        jsonObject.setObjectName(String.format("algorithm_parameters_%d_%s", node.data().getNodeId(), cmptChar.data().getCharId()));
        jsonObject.setObjectType(JsonObjectTypeEnum.ALGORITHM_PARAMETERS.getType());
        jsonObject.setOwnerProjectId(workflowContext.getProject().data().getProjectId());
        jsonObject.setRelFlowId(workflowContext.getWorkflow().data().getFlowId());
        jsonObject.setRelNodeId(node.data().getNodeId());
        jsonObject.setRelCharId(cmptChar.data().getCharId());
        jsonObject.setStorageLocation(StorageLocationEnum.TABLE_FIELD.getLocation());
        jsonObject.setObjectState(JsonObjectStateEnum.EMPTY.getState());
        jsonObject = JSON_OBJECT_MGR.insertJsonObject(jsonObject, workflowContext.getOperId());
        JsonObject richJsonObject = new JsonObject(jsonObject);

        context.getCharValue().setCharValue(String.valueOf(richJsonObject.data().getObjectId()));
        context.getCharValue().setObjectValue(richJsonObject);
    }

    public static void deleteJsonAlgorithm(CharValueContext context) {
        WorkflowContext workflowContext = context.getWorkflowContext();
        clearJsonAlgorithm(context);
        JSON_OBJECT_MGR.deleteJsonObject(Long.parseLong(context.getCharValue().getCharValue()), workflowContext.getOperId());
    }

    public static void recoverJsonAlgorithm(CharValueContext context) {
        WorkflowContext workflowContext = context.getWorkflowContext();
        JSON_OBJECT_MGR.recoverJsonObject(Long.parseLong(context.getCharValue().getCharValue()), workflowContext.getOperId());
        queryJsonAlgorithm(context.getCharValue());
    }

    public static void updateJsonAlgorithm(CharValueContext context) {
        WorkflowContext workflowContext = context.getWorkflowContext();
        JsonObject jsonObject = context.getCharValue().getJsonObject();

        jsonObject.data().setObjectContentColoured(true);
        jsonObject.data().setObjectStateColoured(true);
        JSON_OBJECT_MGR.updateJsonObject(jsonObject.data(), workflowContext.getOperId());
    }

    public static void clearJsonAlgorithm(CharValueContext context) {
        WorkflowContext workflowContext = context.getWorkflowContext();
        JsonObject jsonObject = context.getCharValue().getJsonObject();

        jsonObject.data().setObjectContent(null);
        jsonObject.data().setObjectState(JsonObjectStateEnum.EMPTY.getState());
        JSON_OBJECT_MGR.updateJsonObject(jsonObject.data(), workflowContext.getOperId());
    }

    public static JsonObject queryJsonAlgorithm(CharValue charValue) {
        WfJsonObject jsonObject = JSON_OBJECT_MGR.queryJsonObject(Long.parseLong(charValue.getCharValue()));

        JsonObject richJsonObject = new JsonObject(jsonObject);
        charValue.setObjectValue(richJsonObject);
        return richJsonObject;
    }
}
