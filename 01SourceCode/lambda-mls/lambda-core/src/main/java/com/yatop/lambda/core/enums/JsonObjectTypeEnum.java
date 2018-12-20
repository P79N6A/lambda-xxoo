package com.yatop.lambda.core.enums;

public enum JsonObjectTypeEnum {

    /**
     * 一般Json数据
     */
    GERNERAL(0, "Json Object | Json Array"),

    /**
     * 算法参数
     */
    ALGORITHM_PARAMTERS(1, "Algorithm Parameters"),

    /**
     * 模型评估报告
     */
    MODEL_EVALUATION_REPORT(2, "Model Evaluation Report"),

    /**
     * 交叉验证报告
     */
    CROSS_VALIDATION_REPORT(3, "Cross Validation Report"),

    /**
     * 统计分析报告
     */
    STATISTICS_ANALYSIS_REPORT(4, "Statistics Analysis Report"),

    /**
     * 自动调参报告
     */
    TUNE_PARAMETERS_REPORT(5, "Tune Parameters Report"),

    /**
     * 生成规则报告
     */
    GENERATE_RULES_REPORT(6, "Generate Rules Report"),

    /**
     * 输出端口Schema
     */
    OUTPUT_SCHEMA(99, "Output Port Schema");

    private int type;
    private String name;

    JsonObjectTypeEnum(int type, String name) {
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

    public static JsonObjectTypeEnum valueOf(int type) {
        switch (type) {
            case 0: return GERNERAL;
            case 1: return ALGORITHM_PARAMTERS;
            case 2: return MODEL_EVALUATION_REPORT;
            case 3: return CROSS_VALIDATION_REPORT;
            case 4: return STATISTICS_ANALYSIS_REPORT;
            case 5: return TUNE_PARAMETERS_REPORT;
            case 6: return GENERATE_RULES_REPORT;
            case 99: return OUTPUT_SCHEMA;
            default: return null;
        }
    }
}
