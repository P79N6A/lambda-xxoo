package com.yatop.lambda.core.exception;

public class InternalSystemException extends LambdaException {

    static private final String DEFAULT_ERROR_CODE = "J9999";

    public InternalSystemException(String errorMessage) {
        super(DEFAULT_ERROR_CODE, errorMessage, errorMessage);
    }

	public InternalSystemException(String errorMessage, String errorHint) {
		super(DEFAULT_ERROR_CODE, errorMessage, errorHint);
    }

	public InternalSystemException(String errorCode, String errorMessage, String errorHint) {
		super(errorCode, errorMessage, errorHint);
	}

	public InternalSystemException(String errorMessage, Throwable e) {
		super(DEFAULT_ERROR_CODE, errorMessage, errorMessage, e);
	}

    public InternalSystemException(String errorMessage, String errorHint, Throwable e) {
		super(DEFAULT_ERROR_CODE, errorMessage, errorHint, e);
    }

	public InternalSystemException(String errorCode, String errorMessage, String errorHint, Throwable e) {
		super(errorCode, errorMessage, errorHint, e);
	}
}
