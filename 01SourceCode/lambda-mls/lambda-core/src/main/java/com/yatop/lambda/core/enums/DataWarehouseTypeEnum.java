package com.yatop.lambda.core.enums;

public enum DataWarehouseTypeEnum {
    /**
     * 公共数据库
     */
    PUBLIC(0),

    /**
     * 项目数据库
     */
    PROJECT(1);

    private int type;

    DataWarehouseTypeEnum(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
