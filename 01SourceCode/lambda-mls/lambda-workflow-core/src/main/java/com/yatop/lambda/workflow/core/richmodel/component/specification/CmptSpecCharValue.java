package com.yatop.lambda.workflow.core.richmodel.component.specification;

import com.alibaba.fastjson.JSONObject;
import com.yatop.lambda.base.model.CfCmptSpecCharValue;
import com.yatop.lambda.workflow.core.richmodel.IRichModel;
import com.yatop.lambda.workflow.core.richmodel.component.characteristic.CmptChar;

public class CmptSpecCharValue extends CfCmptSpecCharValue implements IRichModel {

    public CmptSpecCharValue() {}

    public CmptSpecCharValue(CfCmptSpecCharValue data) {super.copyProperties(data);}

    @Override
    public void clear() {
        super.clear();
    }
}
