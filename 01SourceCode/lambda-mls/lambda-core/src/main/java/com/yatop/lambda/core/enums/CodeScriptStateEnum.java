package com.yatop.lambda.core.enums;

public enum CodeScriptStateEnum {

    /**
     * 正常
     */
    NORMAL(0, "Normal"),

    /**
     * 空脚本
     */
    Empty(1, "Empty");

    private int state;
    private String name;

    CodeScriptStateEnum(int state, String name) {
        this.state = state;
        this.name = name;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
