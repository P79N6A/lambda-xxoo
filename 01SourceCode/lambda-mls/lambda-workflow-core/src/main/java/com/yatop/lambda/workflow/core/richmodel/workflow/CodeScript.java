package com.yatop.lambda.workflow.core.richmodel.workflow;

import com.yatop.lambda.base.model.WfCodeScript;
import com.yatop.lambda.workflow.core.richmodel.IRichModel;
import com.yatop.lambda.workflow.core.richmodel.project.Project;

public class CodeScript extends WfCodeScript implements IRichModel {

    public CodeScript(WfCodeScript data) {
        super.copyProperties(data);
        this.clearColoured();
    }

    @Override
    public void clear() {
        super.clear();
    }
}
