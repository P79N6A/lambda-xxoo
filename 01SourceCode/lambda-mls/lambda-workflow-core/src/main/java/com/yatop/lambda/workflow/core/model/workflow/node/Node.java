package com.yatop.lambda.workflow.core.model.workflow.node;

import com.alibaba.fastjson.JSONObject;
import com.yatop.lambda.base.model.WfFlowNode;
import com.yatop.lambda.workflow.core.model.IRichModel;

public class Node implements IRichModel {
    WfFlowNode node;

    @Override
    public JSONObject toJSON() {
        return null;
    }

    @Override
    public void clear() {

    }
}
