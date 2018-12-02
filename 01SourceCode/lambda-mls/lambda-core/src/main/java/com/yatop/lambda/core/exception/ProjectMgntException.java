package com.yatop.lambda.core.exception;

public class ProjectMgntException extends LambdaException {

    static private final String DEFAULT_ERROR_CODE = "B9999";

    public ProjectMgntException(String errorMessage) {
        super(DEFAULT_ERROR_CODE, errorMessage, errorMessage);
    }

	public ProjectMgntException(String errorMessage, String errorHint) {
		super(DEFAULT_ERROR_CODE, errorMessage, errorHint);
    }

	public ProjectMgntException(String errorCode, String errorMessage, String errorHint) {
		super(errorCode, errorMessage, errorHint);
	}

	public ProjectMgntException(String errorMessage, Throwable e) {
		super(DEFAULT_ERROR_CODE, errorMessage, errorMessage, e);
	}

    public ProjectMgntException(String errorMessage, String errorHint, Throwable e) {
		super(DEFAULT_ERROR_CODE, errorMessage, errorHint, e);
    }

	public ProjectMgntException(String errorCode, String errorMessage, String errorHint, Throwable e) {
		super(errorCode, errorMessage, errorHint, e);
	}
}
