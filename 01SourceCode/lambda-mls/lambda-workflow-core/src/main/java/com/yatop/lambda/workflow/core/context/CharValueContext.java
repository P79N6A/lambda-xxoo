package com.yatop.lambda.workflow.core.context;

import com.alibaba.fastjson.JSONObject;
import com.yatop.lambda.workflow.core.framework.chartype.CharValue;
import com.yatop.lambda.workflow.core.richmodel.component.Component;
import com.yatop.lambda.workflow.core.richmodel.component.characteristic.CmptChar;
import com.yatop.lambda.workflow.core.richmodel.component.specification.CmptSpec;

public class CharValueContext {
    private WorkflowContext workflowContext;
    private Component component;
    private CmptSpec cmptSpec;
    private CmptChar cmptChar;
    private CharValue charValue;

    public void clear() {

    }
}
