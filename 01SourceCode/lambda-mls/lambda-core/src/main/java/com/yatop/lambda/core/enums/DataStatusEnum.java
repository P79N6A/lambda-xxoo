package com.yatop.lambda.core.enums;

public enum DataStatusEnum {
    /**
     * 正常
     */
    NORMAL(0),

    /**
     * 失效
     */
    INVALID(1);

    private int status;

    DataStatusEnum(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
