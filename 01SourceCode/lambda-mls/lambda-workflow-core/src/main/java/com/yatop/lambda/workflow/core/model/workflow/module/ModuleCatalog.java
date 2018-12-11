package com.yatop.lambda.workflow.core.model.workflow.module;

import com.alibaba.fastjson.JSONObject;
import com.yatop.lambda.base.model.WfModuleCatalog;
import com.yatop.lambda.workflow.core.model.IRichModel;

public class ModuleCatalog implements IRichModel {
    WfModuleCatalog catalog;

    @Override
    public JSONObject toJSON() {
        return null;
    }

    @Override
    public void clear() {

    }
}
