package com.yatop.lambda.core.enums;

public enum SpecMaskEnum {

    /**
     * 输入规格
     */
    INPUT(0x01, "Input Specification"),

    /**
     * 输出规格
     */
    OUTPUT(0x02, "Output Specification"),

    /**
     * 调用执行规格
     */
    EXECUTION(0x04, "Execution Specification"),

    /**
     * 执行优化规格
     */
    OPTIMIZE_EXECUTION(0x08, "Optimze Execution Specification"),

    /**
     * 组件参数规格
     */
    PARAMETER(0x10, "Parameter Specification");

    private int bit;
    private String name;

    SpecMaskEnum(int bit, String name) {
        this.bit = bit;
        this.name = name;
    }

    public int getBit() {
        return bit;
    }

    public void setBit(int bit) {
        this.bit = bit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static boolean isCorrectMask(int mask) {
        return !((mask & 0x1F) > 0);
        //return !((mask & (INPUT.getBit() | OUTPUT.getBit() | EXECUTION.getBit() | OPTIMIZE_EXECUTION.getBit() | PARAMETER.getBit())) > 0);
    }

    public static boolean isCorrectFitSpecType(int mask, SpecTypeEnum typeEnum) {
        return (((0x01 << (typeEnum.getType() - 1)) & mask) > 0);
    }

    public static boolean matchInput(int mask) {
        return (mask & INPUT.getBit()) > 0;
    }

    public static boolean matchOutput(int mask) {
        return (mask & OUTPUT.getBit()) > 0;
    }

    public static boolean matchExecution(int mask) {
        return (mask & EXECUTION.getBit()) > 0;
    }

    public static boolean matchOptimizeExecution(int mask) {
        return (mask & OPTIMIZE_EXECUTION.getBit()) > 0;
    }

    public static boolean matchParameter(int mask) {
        return (mask & PARAMETER.getBit()) > 0;
    }
}
