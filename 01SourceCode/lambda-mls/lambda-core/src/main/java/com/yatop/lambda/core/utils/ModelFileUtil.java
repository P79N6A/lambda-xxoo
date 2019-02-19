package com.yatop.lambda.core.utils;

public class ModelFileUtil {

    public static String getFilePath4General(String warehouseDir, Long modelId) {
        return String.format("%s/model_%d.dat", warehouseDir, modelId);
    }

    public static String getSummaryFilePath4General(String warehouseDir, Long modelId) {
        return String.format("%s/model_summary_%d.json", warehouseDir, modelId);
    }

    public static String getFilePath4Cached(String jobDir, Long nodeId, Long modelId) {
        return String.format("%s/model_%d_%d.dat", jobDir, nodeId, modelId);
    }

    public static String getSummaryFilePath4Cached(String jobDir, Long nodeId, Long modelId) {
        return String.format("%s/model_summary_%d_%d.json", jobDir, nodeId, modelId);
    }
}
