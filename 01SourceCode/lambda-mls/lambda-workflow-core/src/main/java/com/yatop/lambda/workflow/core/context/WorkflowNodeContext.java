package com.yatop.lambda.workflow.core.context;

import com.yatop.lambda.workflow.core.richmodel.workflow.node.Node;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.NodeParameter;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.NodeSchema;
import com.yatop.lambda.workflow.core.utils.CollectionUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class WorkflowNodeContext implements IWorkContext {
    private WorkflowContext workflowContext;    //操作关联工作流上下文
    private Node node;                          //操作节点
    private String outSummary;                  //传出生成摘要
    private TreeMap<String, String> outWarningMsgs = new TreeMap<String, String>();     //charId, warningMsg，传出组件参数告警消息
    private TreeMap<String, NodeSchema> outSchemas = new TreeMap<String, NodeSchema>(); //charId, schema，传出更新的schema

    public WorkflowNodeContext(WorkflowContext workflowContext, Node node) {
        this.workflowContext = workflowContext;
        this.node = node;
    }

    @Override
    public void clear() {
        workflowContext = null;
        node = null;
        outSummary = null;
        CollectionUtil.clear(outWarningMsgs);
        outWarningMsgs = null;
        CollectionUtil.clear(outSchemas);
        outSchemas = null;
    }

    public WorkflowContext getWorkflowContext() {
        return workflowContext;
    }

    public Node getNode() {
        return node;
    }

    public int outWarningMsgCount() {
        return outSchemas.size();
    }

    public String getOutSummary() {
        return outSummary;
    }

    public void setOutSummary(String outSummary) {
        this.outSummary = outSummary;
    }

    public TreeMap<String, String> getOutWarningMsgs() {
        return outWarningMsgs;
    }

    public void putOutWarningMsg(NodeParameter parameter, String warningMsg) {
        CollectionUtil.put(outWarningMsgs, parameter.getCmptChar().data().getCharId(), warningMsg);
    }

    public int outSchemaCount() {
        return outSchemas.size();
    }

    public TreeMap<String, NodeSchema> getOutSchemas() {
        return outSchemas;
    }

    public void putOutSchema(NodeSchema schema) {
        CollectionUtil.put(outSchemas, schema.getCmptChar().data().getCharId(), schema);
    }
}
