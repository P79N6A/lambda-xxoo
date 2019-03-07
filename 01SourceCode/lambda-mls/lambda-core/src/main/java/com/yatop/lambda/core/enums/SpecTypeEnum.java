package com.yatop.lambda.core.enums;

public enum SpecTypeEnum {

    /**
     * 输入规格
     */
    INPUT(0, "Input Specification"),

    /**
     * 输出规格
     */
    OUTPUT(1, "Output Specification"),

    /**
     * 调用执行规格
     */
    EXECUTION(2, "Execution Specification"),

    /**
     * 执行优化规格
     */
    OPTIMIZE_EXECUTION(3, "Optimze Execution Specification"),

    /**
     * 组件参数规格
     */
    PARAMETER(4, "Parameter Specification");

    private int type;
    private String name;

    SpecTypeEnum(int type, String name) {
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

    public static SpecTypeEnum valueOf(int type) {
        switch (type) {
            case 0: return INPUT;
            case 1: return OUTPUT;
            case 2: return EXECUTION;
            case 3: return OPTIMIZE_EXECUTION;
            case 4: return PARAMETER;
            default: return null;
        }
    }
}
