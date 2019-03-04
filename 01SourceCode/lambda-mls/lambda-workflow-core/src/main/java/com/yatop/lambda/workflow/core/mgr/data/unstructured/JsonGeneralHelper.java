package com.yatop.lambda.workflow.core.mgr.data.unstructured;

import com.yatop.lambda.base.model.WfJsonObject;
import com.yatop.lambda.core.enums.*;
import com.yatop.lambda.core.mgr.workflow.unstructured.JsonObjectMgr;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.context.CharValueContext;
import com.yatop.lambda.workflow.core.context.WorkflowContext;
import com.yatop.lambda.workflow.core.richmodel.component.characteristic.CmptChar;
import com.yatop.lambda.workflow.core.richmodel.data.unstructured.JsonGeneral;
import com.yatop.lambda.workflow.core.richmodel.workflow.charvalue.CharValue;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.Node;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JsonGeneralHelper {

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
        JsonGeneral richJsonGeneral = new JsonGeneral(jsonObject);

        context.getCharValue().setCharValue(String.valueOf(richJsonGeneral.data().getObjectId()));
        context.getCharValue().setObjectValue(richJsonGeneral);
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
        JsonGeneral jsonGeneral = context.getCharValue().getJsonGeneral();

        if(DataUtil.equals(jsonGeneral.data().getObjectContent(), updateObjectContent))
            return;

        if(DataUtil.isNotEmpty(updateObjectContent)) {
            jsonGeneral.data().setObjectContent(updateObjectContent);
            jsonGeneral.data().setObjectState(JsonObjectStateEnum.NORMAL.getState());
        } else {
            jsonGeneral.data().setObjectContent(null);
            jsonGeneral.data().setObjectState(JsonObjectStateEnum.EMPTY.getState());
        }
        JSON_OBJECT_MGR.updateJsonObject(jsonGeneral.data(), workflowContext.getOperId());

        context.getCharValue().setTextValue(jsonGeneral.data().getObjectContent());
    }

    /*public static void clearJsonObject(CharValueContext context) {
        context.getCharValue().setTextValue(null);
        updateJsonObject(context);
    }*/

    public static JsonGeneral queryJsonObject(CharValue charValue) {
        WfJsonObject jsonObject = JSON_OBJECT_MGR.queryJsonObject(Long.parseLong(charValue.getCharValue()));

        JsonGeneral richJsonGeneral = new JsonGeneral(jsonObject);
        charValue.setObjectValue(richJsonGeneral);
        charValue.setTextValue(jsonObject.getObjectContent());
        return richJsonGeneral;
    }
}
