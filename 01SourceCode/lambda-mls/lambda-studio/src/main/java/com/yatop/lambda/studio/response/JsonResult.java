package com.yatop.lambda.studio.response;

import com.yatop.lambda.core.exception.LambdaException;

import java.io.Serializable;

@SuppressWarnings("unused")
public class JsonResult implements Serializable{

    private Boolean success;

    private Object data;

	private String errorCode;

    private String errorMsg;

    private String errorHint;

    public JsonResult(Object data) {
        this.success = true;
        this.data = data;
    }

    public JsonResult(LambdaException e) {
        this.success = false;
        this.errorCode = e.getErrorCode();
        this.errorMsg = e.getErrorMsg();
        this.errorHint = e.getErrorHint();
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getErrorHint() {
        return errorHint;
    }

    public void setErrorHint(String errorHint) {
        this.errorHint = errorHint;
    }
}
