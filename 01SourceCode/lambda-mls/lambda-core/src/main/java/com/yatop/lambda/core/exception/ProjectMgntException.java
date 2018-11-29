package com.yatop.lambda.core.exception;

public class ProjectMgntException extends LambdaException {

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

    static final String DEFAULT_ERROR_CODE = "29999";

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
