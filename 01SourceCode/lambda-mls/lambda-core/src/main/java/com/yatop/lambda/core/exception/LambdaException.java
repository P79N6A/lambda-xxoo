package com.yatop.lambda.core.exception;

import java.util.ArrayList;
import java.util.List;

public class LambdaException extends RuntimeException {

	/*
	 *   错误代码
	 *   A0000 ~ A9999：系统管理错误
	 *   B0000 ~ B9999：项目管理错误
	 *   C0000 ~ C9999：实验管理错误
	 *   D0000 ~ D9999：数据管理错误
	 *   E0000 ~ E9999：模型管理错误
	 *   F0000 ~ F9999：工作流引擎错误
	 *   G0000 ~ G9999：计算框架错误
	 *   H0000 ~ H9999：开放服务错误
	 *   I0000 ~ I9999：预测服务错误
	 *   J0000 ~ J9999：系统内部错误
	 *   Y0000 ~ Y9999：服务请求错误（参数错误、认证失败）
	 *   Z9999：未知错误
	 * */
	private String errorCode;

	/*
	* 	错误提示
	* */
	private String errorHint;

	/*
	 * 	错误消息链
	 * */
	private List<String> errorMsgChain;

	public LambdaException(String errorMessage, String errorHint) {
		this("Z9999", errorMessage, errorHint);
    }

    public LambdaException(String errorCode, String errorMessage, String errorHint) {
		super(errorCode + "#" + errorHint + "#" + errorMessage);
		this.errorCode = errorCode;
		this.errorHint = errorHint;
		this.errorMsgChain = new ArrayList();
		errorMsgChain.add(errorMessage);
	}

    public LambdaException(String errorMessage, String errorHint, Throwable e) {
        this("Z9999", errorMessage, errorHint, e);
    }

    public LambdaException(String errorCode, String errorMessage, String errorHint, Throwable e) {
		this(errorCode, errorMessage, errorHint);
		this.initCause(e);
	}

    public LambdaException(String errorMessage, String errorHint, LambdaException e) {
        this("Z9999", errorMessage, errorHint, e);
    }

    public LambdaException(String errorCode, String errorMessage, String errorHint, LambdaException e) {
        super(errorCode + "#" + errorHint + "#" + errorMessage);
        this.errorCode = errorCode;
        this.errorHint = errorHint;
        this.errorMsgChain = e.getErrorMsgChain();
        errorMsgChain.add(errorMessage);
        this.initCause(e);
    }

    public String getErrorCode() {
        return errorCode;
    }

    public List<String> getErrorMsgChain() { return errorMsgChain; }

    public String getErrorHint() {
        return errorHint;
    }
}
