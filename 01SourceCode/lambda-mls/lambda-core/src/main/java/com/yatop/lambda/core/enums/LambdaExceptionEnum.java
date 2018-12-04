package com.yatop.lambda.core.enums;

public enum LambdaExceptionEnum {

    /*
     *   错误代码
     *   A0000 ~ A9999：系统管理错误
     *   B0000 ~ B9999：项目管理错误
     *   C0000 ~ C9999：实验管理错误
     *   D0000 ~ D9999：数据管理错误
     *   E0000 ~ E9999：模型管理错误
     *   F0000 ~ F9999：工作流管理错误
     *   G0000 ~ G9999：工作流引擎错误
     *   H0000 ~ H9999：计算框架错误
     *   I0000 ~ I9999：开放服务错误
     *   J0000 ~ J9999：预测服务错误
     *   K0000 ~ K9999：系统内部错误
     *   Y0000 ~ Y9999：服务请求错误（参数错误、认证失败）
     *   Z9999：默认错误
     * */

    WF_MGNT_WORKFLOW_EXPIRE_ERROR(      "G0000",    "工作流引擎",       "工作流过期"),
    ZZ_DEFAULT_ERROR(                   "Z9999",    "系统默认",         "默认错误");

    private String errorCode;
    private String errorModule;
    private String errorHint;

    LambdaExceptionEnum(String errorCode, String errorModule, String errorHint) {
        this.errorCode = errorCode;
        this.errorModule = errorModule;
        this.errorHint = errorHint;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public void setErrorModule(String errorModule) {
        this.errorModule = errorModule;
    }

    public String getErrorHint() {
        return errorHint;
    }

    public String getErrorModule() {
        return errorModule;
    }

    public void setErrorHint(String errorHint) {
        this.errorHint = errorHint;
    }
}
