package com.yatop.lambda.core.exception;

public class BaseException extends RuntimeException {

	private String errorCode;
	private String errorHint;


	public BaseException(String errorCode, String errorMessage) {
		this(errorCode, errorMessage, "系统处理异常，请联系管理员");
	}

	public BaseException(String errorCode, String errorMessage, String errorHint) {
		super(errorMessage);
		this.errorCode = errorCode;
		this.errorHint = errorHint;
	}

	public BaseException(String errorCode, String errorMessage, Throwable e) {
		this(errorCode, errorMessage, "系统处理异常，请联系管理员", e);
	}

	public BaseException(String errorCode, String errorMessage, String errorHint, Throwable e) {
		super(errorMessage, e);
		this.errorCode = errorCode;
		this.errorHint = errorHint;
	}

}
