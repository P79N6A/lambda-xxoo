package com.yatop.lambda.workflow.core.richmodel.workflow;

import com.yatop.lambda.base.model.WfJsonObject;
import com.yatop.lambda.workflow.core.richmodel.IRichModel;
import com.yatop.lambda.workflow.core.richmodel.project.Project;

public class JsonObject extends WfJsonObject implements IRichModel {

    public JsonObject() {}

    public JsonObject(WfJsonObject data) {super.copyProperties(data);}

    @Override
    public void clear() {
        super.clear();
    }
}
