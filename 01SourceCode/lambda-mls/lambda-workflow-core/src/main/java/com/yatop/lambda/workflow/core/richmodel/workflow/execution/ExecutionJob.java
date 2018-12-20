package com.yatop.lambda.workflow.core.richmodel.workflow.execution;

import com.yatop.lambda.base.model.WfExecutionJob;
import com.yatop.lambda.workflow.core.richmodel.IRichModel;

public class ExecutionJob extends WfExecutionJob implements IRichModel {

    public ExecutionJob() {}

    public ExecutionJob(WfExecutionJob data) {super.copyProperties(data);}

    @Override
    public void clear() {
        super.clear();
    }
}
