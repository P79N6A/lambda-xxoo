package com.yatop.lambda.workflow.core.model;

import com.alibaba.fastjson.JSONObject;

public interface IRichModel {
    JSONObject toJSON();
    void clear();
}
