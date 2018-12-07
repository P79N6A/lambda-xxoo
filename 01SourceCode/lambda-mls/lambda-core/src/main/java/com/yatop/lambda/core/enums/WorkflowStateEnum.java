package com.yatop.lambda.core.enums;

public enum WorkflowStateEnum {

    /**
     * 草稿
     */
    DRAFT(0, "Draft"),

    /**
     * 准备中
     */
    PREPARING(1, "Preparing"),

    /**
     * 运行中
     */
    RUNNING(1, "Running"),

    /**
     * 运行结束
     */
    FINISHED_RUNNING(1, "Finished Running");

    private int state;
    private String name;

    WorkflowStateEnum(int state, String name) {
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
