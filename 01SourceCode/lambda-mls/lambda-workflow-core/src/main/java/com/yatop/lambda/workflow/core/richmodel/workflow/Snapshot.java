package com.yatop.lambda.workflow.core.richmodel.workflow;

import com.yatop.lambda.base.model.WfFlow;
import com.yatop.lambda.workflow.core.richmodel.IRichModel;

public class Snapshot extends WfFlow implements IRichModel {

    public Snapshot(WfFlow data) {super.copyProperties(data);}

    @Override
    public void clear() {
        super.clear();
    }
}
