package com.yatop.lambda.core.enums;

public enum ExperimentOpenEnum {

    /**
     * 未激活
     */
    NOT_ACTIVATE(0,"not Activate"),
    /**
     * 激活中
     */
    ACTIVATE(1, "activate");

    private int status;
    private String name;

    ExperimentOpenEnum(int status, String name) {
        this.status = status;
        this.name = name;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static ExperimentOpenEnum valueOf(int status) {
        switch (status) {
            case 0: return ACTIVATE;
            case 1: return NOT_ACTIVATE;
            default: return null;
        }
    }
}
