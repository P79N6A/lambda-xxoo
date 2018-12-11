package com.yatop.lambda.workflow.core.model.workflow.node;

import com.alibaba.fastjson.JSONObject;
import com.yatop.lambda.base.model.WfFlowNodeSchema;
import com.yatop.lambda.workflow.core.model.IRichModel;

public class NodeSchema implements IRichModel {
    WfFlowNodeSchema schema;

    @Override
    public JSONObject toJSON() {
        return null;
    }

    @Override
    public void clear() {

    }
}
