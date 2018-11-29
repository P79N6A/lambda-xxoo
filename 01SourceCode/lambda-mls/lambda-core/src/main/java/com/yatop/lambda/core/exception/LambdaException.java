package com.yatop.lambda.core.exception;

public class LambdaException extends RuntimeException {

    /*
    *   错误代码
	*   10000 ~ 19999：系统管理错误
 	*   20000 ~ 29999：项目管理错误
	*   30000 ~ 39999：实验管理错误
    *   40000 ~ 49999：数据管理错误
    *   50000 ~ 59999：模型管理错误
    *   60000 ~ 69999：工作流引擎错误
	*   70000 ~ 79999：计算框架错误
	*	80000 ~ 89999：开放服务错误
	*	90000 ~ 99999：预测服务错误
	*   A0000 ~ A9999：系统内部错误
    *   Z9999：未知错误
    * */
	private String errorCode;

	/*
	* 	错误提示
	* */
	private String errorHint;

    public LambdaException(String errorMessage) {
        this("Z9999", errorMessage, errorMessage);
    }

	public LambdaException(String errorMessage, String errorHint) {
		this("Z9999", errorMessage, errorHint);
    }

	protected LambdaException(String errorCode, String errorMessage, String errorHint) {
		super(errorCode + "@{" + errorHint + "}:" + errorMessage);
		this.errorCode = errorCode;
		this.errorHint = errorHint;
	}

	public LambdaException(String errorMessage, Throwable e) {
		this("Z9999", errorMessage, errorMessage, e);
	}

    public LambdaException(String errorMessage, String errorHint, Throwable e) {
        this("Z9999", errorMessage, errorHint, e);
    }

    protected LambdaException(String errorCode, String errorMessage, String errorHint, Throwable e) {
        super(errorCode + "@{" + errorHint + "}:" + errorMessage, e);
		this.errorCode = errorCode;
		this.errorHint = errorHint;
	}

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMsg() {
        return super.getMessage();
    }

    public String getErrorHint() {
        return errorHint;
    }
}
