package com.yatop.lambda.workflow.core.richmodel.data.unstructured;

import com.yatop.lambda.base.model.WfCodeScript;
import com.yatop.lambda.core.enums.CodeScriptStateEnum;
import com.yatop.lambda.workflow.core.richmodel.IRichModel;
import com.yatop.lambda.workflow.core.richmodel.RichModel;

public class CodeScript extends RichModel<WfCodeScript> {

    public CodeScript(WfCodeScript data) {
        super(data);
    }

    public boolean isStateEmpty() {
        return this.data().getScriptState() == CodeScriptStateEnum.EMPTY.getState();
    }

    public boolean isStateNormal() {
        return this.data().getScriptState() == CodeScriptStateEnum.NORMAL.getState();
    }
}
