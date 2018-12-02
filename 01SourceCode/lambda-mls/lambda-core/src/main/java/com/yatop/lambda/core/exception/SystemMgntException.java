package com.yatop.lambda.core.exception;

public class SystemMgntException extends LambdaException {

    static private final String DEFAULT_ERROR_CODE = "J9999";

    public SystemMgntException(String errorMessage) {
        super(DEFAULT_ERROR_CODE, errorMessage, errorMessage);
    }

	public SystemMgntException(String errorMessage, String errorHint) {
		super(DEFAULT_ERROR_CODE, errorMessage, errorHint);
    }

	public SystemMgntException(String errorCode, String errorMessage, String errorHint) {
		super(errorCode, errorMessage, errorHint);
	}

	public SystemMgntException(String errorMessage, Throwable e) {
		super(DEFAULT_ERROR_CODE, errorMessage, errorMessage, e);
	}

    public SystemMgntException(String errorMessage, String errorHint, Throwable e) {
		super(DEFAULT_ERROR_CODE, errorMessage, errorHint, e);
    }

	public SystemMgntException(String errorCode, String errorMessage, String errorHint, Throwable e) {
		super(errorCode, errorMessage, errorHint, e);
	}
}
