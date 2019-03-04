package com.yatop.lambda.workflow.core.mgr.data.unstructured;

import com.yatop.lambda.base.model.WfCodeScript;
import com.yatop.lambda.core.enums.CodeScriptStateEnum;
import com.yatop.lambda.core.enums.CodeScriptTypeEnum;
import com.yatop.lambda.core.mgr.workflow.unstructured.CodeScriptMgr;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.context.CharValueContext;
import com.yatop.lambda.workflow.core.context.WorkflowContext;
import com.yatop.lambda.workflow.core.richmodel.component.characteristic.CmptChar;
import com.yatop.lambda.workflow.core.richmodel.data.unstructured.CodeScript;
import com.yatop.lambda.workflow.core.richmodel.workflow.charvalue.CharValue;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.Node;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CodeScriptHelper {
    private static CodeScriptMgr CODE_SCRIPT_MGR;

    @Autowired
    public void setCodeScriptMgr(CodeScriptMgr codeScriptMgr) {
        CODE_SCRIPT_MGR = codeScriptMgr;
    }

    public static void createCodeScript4Sql(CharValueContext context) {
        WorkflowContext workflowContext = context.getWorkflowContext();
        Node node = context.getNode();
        CmptChar cmptChar = context.getCmptChar();
        String defaultScriptContent = context.getCharValue().getTextValue();

        WfCodeScript codeScript = new WfCodeScript();
        codeScript.setScriptName(String.format("sql_%d_%s", node.data().getNodeId(), cmptChar.data().getCharId()));
        codeScript.setScriptType(CodeScriptTypeEnum.SQL.getType());
        codeScript.setOwnerProjectId(workflowContext.getProject().data().getProjectId());
        codeScript.setRelFlowId(workflowContext.getWorkflow().data().getFlowId());
        codeScript.setRelNodeId(node.data().getNodeId());
        codeScript.setRelCharId(cmptChar.data().getCharId());
        if(DataUtil.isNotEmpty(defaultScriptContent)) {
            codeScript.setScriptContent(defaultScriptContent);
            codeScript.setScriptState(CodeScriptStateEnum.NORMAL.getState());
        } else {
            codeScript.setScriptState(CodeScriptStateEnum.EMPTY.getState());
        }
        codeScript = CODE_SCRIPT_MGR.insertCodeScript(codeScript, workflowContext.getOperId());
        CodeScript richCodeScript = new CodeScript(codeScript);

        context.getCharValue().setCharValue(String.valueOf(richCodeScript.data().getScriptId()));
        context.getCharValue().setObjectValue(richCodeScript);
        context.getCharValue().setTextValue(defaultScriptContent);
    }

    public static void deleteCodeScript(CharValueContext context) {
        WorkflowContext workflowContext = context.getWorkflowContext();
        CODE_SCRIPT_MGR.deleteCodeScript(Long.parseLong(context.getCharValue().getCharValue()), workflowContext.getOperId());
    }

    public static void recoverCodeScript(CharValueContext context) {
        WorkflowContext workflowContext = context.getWorkflowContext();
        CODE_SCRIPT_MGR.recoverCodeScript(Long.parseLong(context.getCharValue().getCharValue()), workflowContext.getOperId());
        queryCodeScript(context.getCharValue());
    }

    public static void updateCodeScript(CharValueContext context) {
        WorkflowContext workflowContext = context.getWorkflowContext();
        String updateScriptContent = context.getCharValue().getTextValue();
        CodeScript codeScript = context.getCharValue().getCodeScript();

        if(DataUtil.equals(codeScript.data().getScriptContent(), updateScriptContent))
            return;

        if(DataUtil.isNotEmpty(updateScriptContent)) {
            codeScript.data().setScriptContent(updateScriptContent);
            codeScript.data().setScriptState(CodeScriptStateEnum.NORMAL.getState());
        } else {
            codeScript.data().setScriptContent(null);
            codeScript.data().setScriptState(CodeScriptStateEnum.EMPTY.getState());
        }
        CODE_SCRIPT_MGR.updateCodeScript(codeScript.data(), workflowContext.getOperId());

        context.getCharValue().setTextValue(codeScript.data().getScriptContent());
    }

    /*public static void clearCodeScript(CharValueContext context) {
        context.getCharValue().setTextValue(null);
        updateCodeScript(context);
    }*/

    public static CodeScript queryCodeScript(CharValue charValue) {

        WfCodeScript codeScript = CODE_SCRIPT_MGR.queryCodeScript(Long.parseLong(charValue.getCharValue()));

        CodeScript richCodeScript = new CodeScript(codeScript);
        charValue.setObjectValue(richCodeScript);
        charValue.setTextValue(codeScript.getScriptContent());
        return richCodeScript;
    }
}
