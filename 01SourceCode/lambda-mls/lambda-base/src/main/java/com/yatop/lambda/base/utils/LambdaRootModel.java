package com.yatop.lambda.base.utils;

import com.alibaba.fastjson.JSONObject;

public abstract class LambdaRootModel {
    public abstract void copyProperties(Object that);
    public abstract JSONObject toJSON();
}
