package com.yatop.lambda.workflow.core.model.workflow.node;

import com.alibaba.fastjson.JSONObject;
import com.yatop.lambda.base.model.WfFlowNodePort;
import com.yatop.lambda.workflow.core.model.IRichModel;

public class NodePort implements IRichModel {
    WfFlowNodePort port;

    @Override
    public JSONObject toJSON() {
        return null;
    }

    @Override
    public void clear() {

    }
}
