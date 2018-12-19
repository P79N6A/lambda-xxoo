package com.yatop.lambda.workflow.core.context;

import com.alibaba.fastjson.JSONObject;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.Node;

import java.util.TreeMap;

public class WorkflowNodeContext {
    private WorkflowContext workflowContext;
    private Node node;
    private String outputSummary;
    private TreeMap<String, String> outputWarningMsgs = new TreeMap<String, String>();    //charId, warningMsg

    public JSONObject toJSON() {
        return null;
    }

    public void clear() {

    }
}
