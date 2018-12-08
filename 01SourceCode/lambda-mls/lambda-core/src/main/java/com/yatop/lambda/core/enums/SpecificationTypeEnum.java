package com.yatop.lambda.core.enums;

public enum SpecificationTypeEnum {

    /**
     * 输入
     */
    INPUT(1, "Input"),

    /**
     * 输出
     */
    OUTPUT(2, "Output"),

    /**
     * 调用执行
     */
    EXECUTION(3, "Execution"),

    /**
     * 执行调优
     */
    OPTIMIZE_EXECUTION(4, "Optimize Execution"),

    /**
     * 组件参数
     */
    PARAMETER(5, "Parameter");

    private int type;
    private String name;

    SpecificationTypeEnum(int type, String name) {
        this.type = type;
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
