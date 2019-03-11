package com.yatop.lambda.manager.api.response.experiment;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yatop.lambda.manager.api.response.NodeResponse;
import com.yatop.lambda.workflow.core.context.WorkflowContext;

/**
 * @author huangyu
 * @create 2019-03-05-17:22
 */

public class AddExperimentNodeResponse extends JSONObject {

    public AddExperimentNodeResponse(WorkflowContext context) {
        super(true);
        JSONArray nodes = new JSONArray(context.nodeCount());
        NodeResponse.dumpNodes(context,nodes,true);

        this.put("nodes",nodes);
    }
}
