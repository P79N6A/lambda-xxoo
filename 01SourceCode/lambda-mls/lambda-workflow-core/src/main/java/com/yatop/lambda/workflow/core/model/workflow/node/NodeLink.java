package com.yatop.lambda.workflow.core.model.workflow.node;

import com.alibaba.fastjson.JSONObject;
import com.yatop.lambda.base.model.WfFlowNodeLink;
import com.yatop.lambda.workflow.core.model.IRichModel;

public class NodeLink implements IRichModel {
    WfFlowNodeLink link;

    @Override
    public JSONObject toJson() {
        return null;
    }

    @Override
    public void parseJson(String jsonStr) {

    }
}
