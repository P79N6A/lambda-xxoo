package com.yatop.lambda.workflow.core.richmodel.workflow.snapshot;

import com.yatop.lambda.base.model.WfFlow;
import com.yatop.lambda.workflow.core.richmodel.IRichModel;

public class SnapshotParameter extends WfFlow implements IRichModel {

    public SnapshotParameter(WfFlow data) {
        super.copyProperties(data);
        this.clearColoured();
    }

    @Override
    public void clear() {
        super.clear();
    }
}
