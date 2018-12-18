package com.yatop.lambda.workflow.core.richmodel.component;

import com.alibaba.fastjson.JSONObject;
import com.yatop.lambda.base.model.CfCmptCharValue;
import com.yatop.lambda.workflow.core.richmodel.IRichModel;
import com.yatop.lambda.workflow.core.richmodel.component.characteristic.CmptChar;

public class CmptCharValue extends CfCmptCharValue implements IRichModel {

    public CmptCharValue() {}

    public CmptCharValue(CfCmptCharValue data) {super.copyProperties(data);}

    @Override
    public void clear() {
        super.clear();
    }
}
