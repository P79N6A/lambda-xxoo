package com.yatop.lambda.core.utils;

public class JsonFileUtil {

    public static String getFilePath4ModelEvaluationReport(String jobDir, Long jsonObjectId) {
        return String.format("%s/model_evaluation_report_%d.json", jobDir, jsonObjectId);
    }

    public static String getFilePath4StatisticsAnalysisReport(String jobDir, Long jsonObjectId) {
        return String.format("%s/statistics_analysis_report_%d.json", jobDir, jsonObjectId);
    }

    public static String getFilePath4TuneParametersReport(String jobDir, Long jsonObjectId) {
        return String.format("%s/tune_parameters_report_%d.json", jobDir, jsonObjectId);
    }

    public static String getFilePath4GenerateRulesReport(String jobDir, Long jsonObjectId) {
        return String.format("%s/generate_rules_report_%d.json", jobDir, jsonObjectId);
    }
}
