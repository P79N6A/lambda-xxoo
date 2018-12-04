package com.yatop.lambda.core.enums;

public enum DataStatusCondEnum {
    /**
     * 正常
     */
    NORMAL_STATUS(0),

    /**
     * 失效
     */
    INVALID_STATUS(1),

    /**
     * 失效
     */
    ALL_STATUS(1);

    private int condition;

    DataStatusCondEnum(int cond) {
        this.condition = cond;
    }

    public int getCondition() {
        return condition;
    }

    public void setCondition(int status) {
        this.condition = status;
    }

    public boolean isAllStatus() {
        return condition == ALL_STATUS.getCondition();
    }
}
