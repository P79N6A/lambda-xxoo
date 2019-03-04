package com.yatop.lambda.workflow.core.mgr.data.unstructured;

import com.yatop.lambda.base.model.WfJsonObject;
import com.yatop.lambda.core.enums.*;
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
public class JsonObjectHelper {

    private static JsonObjectMgr JSON_OBJECT_MGR;

    @Autowired
    public void setJsonObjectMgr(JsonObjectMgr jsonObjectMgr) {
        JSON_OBJECT_MGR = jsonObjectMgr;
    }

    public static void createJsonObject(CharValueContext context) {
        WorkflowContext workflowContext = context.getWorkflowContext();
        Node node = context.getNode();
        CmptChar cmptChar = context.getCmptChar();
        String defaultObjectContent = context.getCharValue().getTextValue();

        WfJsonObject jsonObject = new WfJsonObject();
        jsonObject.setObjectName(String.format("general_%d_%s", node.data().getNodeId(), cmptChar.data().getCharId()));
        jsonObject.setObjectType(JsonObjectTypeEnum.GENERAL.getType());
        jsonObject.setOwnerProjectId(workflowContext.getProject().data().getProjectId());
        jsonObject.setRelFlowId(workflowContext.getWorkflow().data().getFlowId());
        jsonObject.setRelNodeId(node.data().getNodeId());
        jsonObject.setRelCharId(cmptChar.data().getCharId());
        jsonObject.setStorageLocation(StorageLocationEnum.TABLE_FIELD.getLocation());
        if(DataUtil.isNotEmpty(defaultObjectContent)) {
            jsonObject.setObjectContent(defaultObjectContent);
            jsonObject.setObjectState(JsonObjectStateEnum.NORMAL.getState());
        } else {
            jsonObject.setObjectState(JsonObjectStateEnum.EMPTY.getState());
        }
        jsonObject = JSON_OBJECT_MGR.insertJsonObject(jsonObject, workflowContext.getOperId());
        JsonObject richJsonObject = new JsonObject(jsonObject);

        context.getCharValue().setCharValue(String.valueOf(richJsonObject.data().getObjectId()));
        context.getCharValue().setObjectValue(richJsonObject);
        context.getCharValue().setTextValue(defaultObjectContent);
    }

    public static void deleteJsonObject(CharValueContext context) {
        WorkflowContext workflowContext = context.getWorkflowContext();
        JSON_OBJECT_MGR.deleteJsonObject(Long.parseLong(context.getCharValue().getCharValue()), workflowContext.getOperId());
    }

    public static void recoverJsonObject(CharValueContext context) {
        WorkflowContext workflowContext = context.getWorkflowContext();
        JSON_OBJECT_MGR.recoverJsonObject(Long.parseLong(context.getCharValue().getCharValue()), workflowContext.getOperId());
        queryJsonObject(context.getCharValue());
    }

    public static void updateJsonObject(CharValueContext context) {
        WorkflowContext workflowContext = context.getWorkflowContext();
        String updateObjectContent = context.getCharValue().getTextValue();
        JsonObject jsonObject = context.getCharValue().getJsonObject();

        if(DataUtil.equals(jsonObject.data().getObjectContent(), updateObjectContent))
            return;

        if(DataUtil.isNotEmpty(updateObjectContent)) {
            jsonObject.data().setObjectContent(updateObjectContent);
            jsonObject.data().setObjectState(JsonObjectStateEnum.NORMAL.getState());
        } else {
            jsonObject.data().setObjectContent(null);
            jsonObject.data().setObjectState(JsonObjectStateEnum.EMPTY.getState());
        }
        JSON_OBJECT_MGR.updateJsonObject(jsonObject.data(), workflowContext.getOperId());

        context.getCharValue().setTextValue(jsonObject.data().getObjectContent());
    }

    /*public static void clearJsonObject(CharValueContext context) {
        context.getCharValue().setTextValue(null);
        updateJsonObject(context);
    }*/

    public static JsonObject queryJsonObject(CharValue charValue) {
        WfJsonObject jsonObject = JSON_OBJECT_MGR.queryJsonObject(Long.parseLong(charValue.getCharValue()));

        JsonObject richJsonObject = new JsonObject(jsonObject);
        charValue.setObjectValue(richJsonObject);
        charValue.setTextValue(jsonObject.getObjectContent());
        return richJsonObject;
    }
}
