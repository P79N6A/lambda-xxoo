package com.yatop.lambda.workflow.core.context;

import com.alibaba.fastjson.JSONObject;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.Node;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.NodeSchema;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class WorkflowSchemaContext {
    private WorkflowContext workflowContext;
    private Node node;
    private List<NodeSchema> changeSchemas = new ArrayList<NodeSchema>();

    public void clear() {
        workflowContext = null;
        node = null;
        changeSchemas.clear();
    }

    public WorkflowContext getWorkflowContext() {
        return workflowContext;
    }

    public void setWorkflowContext(WorkflowContext workflowContext) {
        this.workflowContext = workflowContext;
    }

    public Node getNode() {
        return node;
    }

    public void setNode(Node node) {
        this.node = node;
    }

    public List<NodeSchema> getChangeSchemas() {
        return changeSchemas;
    }

    public void setChangeSchemas(List<NodeSchema> changeSchemas) {
        this.changeSchemas = changeSchemas;
    }
}
