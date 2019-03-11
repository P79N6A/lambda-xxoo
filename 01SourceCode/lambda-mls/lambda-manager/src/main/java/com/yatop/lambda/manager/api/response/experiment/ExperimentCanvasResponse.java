package com.yatop.lambda.manager.api.response.experiment;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yatop.lambda.manager.api.response.NodeResponse;
import com.yatop.lambda.workflow.core.context.WorkflowContext;
import com.yatop.lambda.workflow.core.richmodel.workflow.Workflow;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.NodeLink;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 实验响应类
 *
 * @author huangyu
 * @create 2019-03-05-15:24
 */
public class ExperimentCanvasResponse extends JSONObject {

    public ExperimentCanvasResponse(WorkflowContext context) {
        super(true);

        JSONArray nodes = new JSONArray(context.nodeCount());

        NodeResponse.dumpNodes(context,nodes,false);

        JSONArray links = new JSONArray(context.linkCount());
        if(context.linkCount() > 0) {
            for(NodeLink link : context.getLinks()) {
                links.add(link.toJSON());
            }
        }

        Workflow workflow = context.getWorkflow();

        this.put("flowState",workflow.data().getFlowState());
        this.put("shareLockMsg",workflow.data().getShareLockMsg());
        this.put("nodes", nodes);
        this.put("links", links);
    }
}
