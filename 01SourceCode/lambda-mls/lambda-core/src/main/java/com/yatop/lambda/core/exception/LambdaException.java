package com.yatop.lambda.core.exception;

import com.yatop.lambda.core.enums.LambdaExceptionEnum;

import java.util.ArrayList;
import java.util.List;

public class LambdaException extends RuntimeException {

	/*
	 * 	错误枚举
	 * */
	private LambdaExceptionEnum errorEnum;

	/*
	* 	错误提示
	* */
	private String errorHint;

	/*
	 * 	错误消息链
	 * */
	private List<String> errorMsgChain;

	public LambdaException(String errorMessage, String errorHint) {
		this(LambdaExceptionEnum.ZZ_DEFAULT_ERROR, errorMessage, errorHint);
    }

    public LambdaException(LambdaExceptionEnum errorEnum, String errorMessage, String errorHint) {
		super(errorEnum.getErrorCode() + "#" + errorHint + "#" + errorMessage);
		this.errorEnum = errorEnum;
		this.errorHint = errorHint;
		this.errorMsgChain = new ArrayList<String>();
		errorMsgChain.add(errorMessage);
	}

    public LambdaException(String errorMessage, String errorHint, Throwable e) {
        this(LambdaExceptionEnum.ZZ_DEFAULT_ERROR, errorMessage, errorHint, e);
    }

    public LambdaException(LambdaExceptionEnum errorEnum, String errorMessage, String errorHint, Throwable e) {
		this(errorEnum, errorMessage, errorHint);
		this.initCause(e);
	}

	//返回捕获错误代码
    public LambdaException(String errorMessage, String errorHint, LambdaException e) {
		super(e.getErrorCode() + "#" + errorHint + "#" + errorMessage);
		this.errorEnum = e.getErrorEnum();
		this.errorHint = errorHint;
		this.errorMsgChain = e.getErrorMsgChain();
		this.initCause(e);
		errorMsgChain.add(errorMessage);
    }

    //返回当前错误代码
	public LambdaException(LambdaExceptionEnum errorEnum, String errorMessage, String errorHint, LambdaException e) {
		super(errorEnum.getErrorCode() + "#" + errorHint + "#" + errorMessage);
		this.errorEnum = errorEnum;
		this.errorHint = errorHint;
		this.errorMsgChain = e.getErrorMsgChain();
		this.initCause(e);
		errorMsgChain.add(errorMessage);
	}

	public LambdaExceptionEnum getErrorEnum() {
		return errorEnum;
	}

    public String getErrorCode() {
        return errorEnum.getErrorCode();
    }

    public List<String> getErrorMsgChain() { return errorMsgChain; }

    public String getErrorHint() {
        return errorHint;
    }
}
