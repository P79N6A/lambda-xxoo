package com.yatop.lambda.core.exception;

public class DecisionServiceException extends LambdaException {

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
	 *   Z9999：未知错误
	 * */

    static final String DEFAULT_ERROR_CODE = "I9999";

    public DecisionServiceException(String errorMessage) {
        super(DEFAULT_ERROR_CODE, errorMessage, errorMessage);
    }

	public DecisionServiceException(String errorMessage, String errorHint) {
		super(DEFAULT_ERROR_CODE, errorMessage, errorHint);
    }

	public DecisionServiceException(String errorCode, String errorMessage, String errorHint) {
		super(errorCode, errorMessage, errorHint);
	}

	public DecisionServiceException(String errorMessage, Throwable e) {
		super(DEFAULT_ERROR_CODE, errorMessage, errorMessage, e);
	}

    public DecisionServiceException(String errorMessage, String errorHint, Throwable e) {
		super(DEFAULT_ERROR_CODE, errorMessage, errorHint, e);
    }

	public DecisionServiceException(String errorCode, String errorMessage, String errorHint, Throwable e) {
		super(errorCode, errorMessage, errorHint, e);
	}
}
