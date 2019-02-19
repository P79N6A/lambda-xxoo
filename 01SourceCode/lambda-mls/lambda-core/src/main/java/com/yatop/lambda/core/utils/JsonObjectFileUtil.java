package com.yatop.lambda.core.utils;

public class JsonObjectFileUtil {

    public static String getFilePath4Report(String flowDir, String reportNamePrefix, Long nodeId, Long jsonObjectId) {
        return String.format("%s/%s_%d_%d.json", flowDir, reportNamePrefix, nodeId, jsonObjectId);
    }
}
