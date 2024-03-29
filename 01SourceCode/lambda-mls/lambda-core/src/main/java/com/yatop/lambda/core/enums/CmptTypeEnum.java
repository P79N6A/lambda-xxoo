package com.yatop.lambda.core.enums;

public enum CmptTypeEnum {

    /**
     * 输入输出组件
     */
    IO_CMPT(0, "Input & Output Component"),

    /**
     * 脚本工具组件
     */
    SCRIPT_CMPT(1, "Script Tool Component"),

    /**
     * 数据预处理组件
     */
    PRERPOCESS_CMPT(2, "Data Preprocessing Component"),

    /**
     * 特征工程组件
     */
    FEATURE_CMPT(3, "Feature Engineering Component"),

    /**
     * 统计分析组件
     */
    STATISTICAL_CMPT(4, "Statistical Analytics Component"),

    /**
     * 机器学习组件
     */
    ML_CMPT(5, "Machine Learning Component"),

    /**
     * 深度学习组件
     */
    DP_CMPT(6, "Deep Learning Component"),

    /**
     * 文本分析组件
     */
    TEXT_CMPT(7, "Text Analytics Component"),

    /**
     * 网络分析组件
     */
    NETWORK_CMPT(8, "Network Analytics Component"),

    /**
     * 时间序列组件
     */
    TIME_CMPT(9, "Time Series Component"),

    /**
     * 业务场景组件
     */
    BUSINESS_CMPT(10, "Business Scenario Component");

    private int type;
    private String name;

    CmptTypeEnum(int type, String name) {
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

    public static CmptTypeEnum valueOf(int type) {
        switch (type) {
            case 0: return IO_CMPT;
            case 1: return SCRIPT_CMPT;
            case 2: return PRERPOCESS_CMPT;
            case 3: return FEATURE_CMPT;
            case 4: return STATISTICAL_CMPT;
            case 5: return ML_CMPT;
            case 6: return DP_CMPT;
            case 7: return TEXT_CMPT;
            case 8: return NETWORK_CMPT;
            case 9: return TIME_CMPT;
            case 10: return BUSINESS_CMPT;
            default: return null;
        }
    }
}
