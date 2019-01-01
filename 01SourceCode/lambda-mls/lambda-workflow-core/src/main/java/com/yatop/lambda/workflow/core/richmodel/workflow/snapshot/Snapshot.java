package com.yatop.lambda.workflow.core.richmodel.workflow.snapshot;

import com.yatop.lambda.base.model.WfFlow;
import com.yatop.lambda.workflow.core.richmodel.IRichModel;

public class Snapshot extends WfFlow implements IRichModel {

    public Snapshot(WfFlow data) {
        super.copyProperties(data);
        this.clearColoured();
    }

    @Override
    public void clear() {
        super.clear();
    }
}