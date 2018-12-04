package com.yatop.lambda.core.enums;

public enum ProjectRoleEnum {
    /**
     * 一般成员
     */
    GENERAL_MEMBER(0),

    /**
     * 项目所有者
     */
    PROJECT_OWNER(1),

    /**
     * 项目维护者
     */
    PROJECT_MAINTAINER(2);

    private int role;

    ProjectRoleEnum(int tag) {
        this.role = tag;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int tag) {
        this.role = tag;
    }
}
