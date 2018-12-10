package com.yatop.lambda.workflow.core.model.workflow.node;

import com.alibaba.fastjson.JSONObject;
import com.yatop.lambda.base.model.WfFlowNodeParameter;
import com.yatop.lambda.workflow.core.model.IRichModel;

public class NodeParameter implements IRichModel {
    WfFlowNodeParameter parameter;

    @Override
    public JSONObject toJson() {
        return null;
    }

    @Override
    public void parseJson(String jsonStr) {

    }
}
