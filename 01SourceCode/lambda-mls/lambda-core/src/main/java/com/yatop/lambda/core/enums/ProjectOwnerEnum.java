package com.yatop.lambda.core.enums;

public enum ProjectOwnerEnum {
    /**
     * 是所有者
     */
    NOT_OWNER(0),

    /**
     * 不是所有者
     */
    OWNER(1);

    private int tag;

    ProjectOwnerEnum(int tag) {
        this.tag = tag;
    }

    public int getTag() {
        return tag;
    }

    public void setTag(int tag) {
        this.tag = tag;
    }
}
