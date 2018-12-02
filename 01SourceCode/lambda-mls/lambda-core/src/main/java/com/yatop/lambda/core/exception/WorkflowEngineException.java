package com.yatop.lambda.core.exception;

public class WorkflowEngineException extends LambdaException {

    static private final String DEFAULT_ERROR_CODE = "F9999";

    public WorkflowEngineException(String errorMessage) {
        super(DEFAULT_ERROR_CODE, errorMessage, errorMessage);
    }

	public WorkflowEngineException(String errorMessage, String errorHint) {
		super(DEFAULT_ERROR_CODE, errorMessage, errorHint);
    }

	public WorkflowEngineException(String errorCode, String errorMessage, String errorHint) {
		super(errorCode, errorMessage, errorHint);
	}

	public WorkflowEngineException(String errorMessage, Throwable e) {
		super(DEFAULT_ERROR_CODE, errorMessage, errorMessage, e);
	}

    public WorkflowEngineException(String errorMessage, String errorHint, Throwable e) {
		super(DEFAULT_ERROR_CODE, errorMessage, errorHint, e);
    }

	public WorkflowEngineException(String errorCode, String errorMessage, String errorHint, Throwable e) {
		super(errorCode, errorMessage, errorHint, e);
	}
}
