package com.yatop.lambda.workflow.core.richmodel.data.script;

import com.yatop.lambda.base.model.WfCodeScript;
import com.yatop.lambda.core.enums.CodeScriptStateEnum;
import com.yatop.lambda.workflow.core.richmodel.IRichModel;
import com.yatop.lambda.workflow.core.richmodel.RichModel;

public class CodeScript extends RichModel<WfCodeScript> {

    public CodeScript(WfCodeScript data) {
        super(data);
    }

    @Override
    public boolean isResourceStateEmpty() {
        return data().getScriptState() == CodeScriptStateEnum.EMPTY.getState();
    }

    @Override
    public Long getResourceId() {
        return data().getScriptId();
    }
}
