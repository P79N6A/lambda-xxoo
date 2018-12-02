package com.yatop.lambda.core.exception;

public class DataMgntException extends LambdaException {

    static private final String DEFAULT_ERROR_CODE = "D9999";

    public DataMgntException(String errorMessage) {
        super(DEFAULT_ERROR_CODE, errorMessage, errorMessage);
    }

	public DataMgntException(String errorMessage, String errorHint) {
		super(DEFAULT_ERROR_CODE, errorMessage, errorHint);
    }

	public DataMgntException(String errorCode, String errorMessage, String errorHint) {
		super(errorCode, errorMessage, errorHint);
	}

	public DataMgntException(String errorMessage, Throwable e) {
		super(DEFAULT_ERROR_CODE, errorMessage, errorMessage, e);
	}

    public DataMgntException(String errorMessage, String errorHint, Throwable e) {
		super(DEFAULT_ERROR_CODE, errorMessage, errorHint, e);
    }

	public DataMgntException(String errorCode, String errorMessage, String errorHint, Throwable e) {
		super(errorCode, errorMessage, errorHint, e);
	}
}
