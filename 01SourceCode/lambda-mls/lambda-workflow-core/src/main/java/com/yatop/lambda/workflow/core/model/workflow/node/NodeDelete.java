package com.yatop.lambda.workflow.core.model.workflow.node;

import com.alibaba.fastjson.JSONObject;
import com.yatop.lambda.base.model.WfFlowNodeDeleteQueue;
import com.yatop.lambda.workflow.core.model.IRichModel;

public class NodeDelete implements IRichModel {
    WfFlowNodeDeleteQueue delete;

    @Override
    public JSONObject toJSON() {
        return null;
    }

    @Override
    public void clear() {

    }
}
