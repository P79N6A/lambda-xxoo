package com.yatop.lambda.core.enums;

public enum ModelWarehouseTypeEnum {
    /**
     * 公共模型库
     */
    PUBLIC(0),

    /**
     * 项目模型库
     */
    PROJECT(1);

    private int type;

    ModelWarehouseTypeEnum(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
