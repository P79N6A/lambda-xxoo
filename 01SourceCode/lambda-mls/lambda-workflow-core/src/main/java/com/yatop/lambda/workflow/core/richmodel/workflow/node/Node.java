package com.yatop.lambda.workflow.core.richmodel.workflow.node;

import com.alibaba.fastjson.JSONObject;
import com.yatop.lambda.base.model.WfFlowNode;
import com.yatop.lambda.workflow.core.richmodel.IRichModel;
import com.yatop.lambda.workflow.core.richmodel.project.Project;
import com.yatop.lambda.workflow.core.richmodel.workflow.Workflow;
import com.yatop.lambda.workflow.core.richmodel.workflow.execution.ExecutionTask;
import com.yatop.lambda.workflow.core.richmodel.workflow.module.Module;

public class Node extends WfFlowNode implements IRichModel {

    private Module module;
    private ExecutionTask lastTask;

    public Node() {}

    public Node(WfFlowNode data) {super.copyProperties(data);}

    @Override
    public void clear() {
        super.clear();
    }
}
