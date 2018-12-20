package com.yatop.lambda.core.enums;

public enum JsonObjectStateEnum {

    /**
     * 空对象
     */
    NORMAL(0, "Empty"),

    /**
     * 正常
     */
    EMPTY(1, "Normal");

    private int state;
    private String name;

    JsonObjectStateEnum(int state, String name) {
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

    public static JsonObjectStateEnum valueOf(int state) {
        switch (state) {
            case 0: return NORMAL;
            case 1: return EMPTY;
            default: return null;
        }
    }
}
