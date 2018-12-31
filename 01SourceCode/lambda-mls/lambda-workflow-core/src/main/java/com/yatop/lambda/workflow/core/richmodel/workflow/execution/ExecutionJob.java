package com.yatop.lambda.workflow.core.richmodel.workflow.execution;

import com.yatop.lambda.base.model.WfExecutionJob;
import com.yatop.lambda.core.enums.JobTypeEnum;
import com.yatop.lambda.workflow.core.richmodel.IRichModel;

public class ExecutionJob extends WfExecutionJob implements IRichModel {

    public ExecutionJob(WfExecutionJob data) {
        super.copyProperties(data);
        this.clearColoured();
    }

    @Override
    public void clear() {
        super.clear();
    }
}
