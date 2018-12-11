package com.yatop.lambda.workflow.core.model.project;

import com.alibaba.fastjson.JSONObject;
import com.yatop.lambda.base.model.PrProject;
import com.yatop.lambda.workflow.core.model.IRichModel;

public class Project implements IRichModel {
    PrProject project;

    @Override
    public JSONObject toJSON() {
        return null;
    }

    @Override
    public void clear() {

    }
}
