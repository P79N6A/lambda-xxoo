package com.yatop.lambda.core.exception;

import com.yatop.lambda.core.enums.LambdaExceptionEnum;

import java.util.ArrayList;
import java.util.List;

public class WorkFlowExpireException extends LambdaException {

    public WorkFlowExpireException(String errorMessage, String errorHint) {
        super(LambdaExceptionEnum.WF_MGNT_WORKFLOW_EXPIRE_ERROR, errorMessage, errorHint);
    }
}
