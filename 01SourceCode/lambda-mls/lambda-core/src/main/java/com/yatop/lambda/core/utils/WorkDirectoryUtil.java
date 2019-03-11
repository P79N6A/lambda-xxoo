package com.yatop.lambda.core.utils;

import com.yatop.lambda.core.enums.SystemParameterEnum;

public class WorkDirectoryUtil {

    private static String HDFS_SCHEMA_PREFIX = "hdfs://";

    private static String getDfsDefautlFS() {
        return SystemParameterUtil.find4String(SystemParameterEnum.CF_HDFS_SITE_defaultFS);
    }

    private static String getDfsWorkRoot() {
        return SystemParameterUtil.find4String(SystemParameterEnum.CF_HDFS_WORK_ROOT);
    }

    private static String getLocalWorkRoot() {
        return SystemParameterUtil.find4String(SystemParameterEnum.CF_LOCAL_WORK_ROOT);
    }

    private static String getFlowFileDirName() {
        return SystemParameterUtil.find4String(SystemParameterEnum.CF_FLOW_FILE_DIR_NAME);
    }

    private static String getJobFileDirName() {
        return SystemParameterUtil.find4String(SystemParameterEnum.CF_JOB_FILE_DIR_NAME);
    }

    private static String getDataFileDirName() {
        return SystemParameterUtil.find4String(SystemParameterEnum.CF_DATA_FILE_DIR_NAME);
    }

    private static String getModelFileDirName() {
        return SystemParameterUtil.find4String(SystemParameterEnum.CF_MODEL_FILE_DIR_NAME);
    }

    public static String getWorkFLowDfsDirectory(Long projectId, Long flowId) {
        return String.format("%s%s/%s/%d/%d", getDfsDefautlFS(), getDfsWorkRoot(), getFlowFileDirName(), projectId, flowId);
    }

    public static String getWorkFLowLocalDirectory(Long projectId, Long flowId) {
        return String.format("%s/%s/%d/%d", getLocalWorkRoot(), getFlowFileDirName(), projectId, flowId);
    }

    public static String getJobDfsDirectory(Long projectId, Long flowId, Long jobId) {
        if(flowId > 0L)
            return String.format("%s%s/%s/%d/%d/%d", getDfsDefautlFS(), getDfsWorkRoot(), getJobFileDirName(), projectId, flowId, jobId);
        else
            return String.format("%s%s/%s/%d/other/%d", getDfsDefautlFS(), getDfsWorkRoot(), getJobFileDirName(), projectId, jobId);
    }

    public static String getJobLocalDirectory(Long projectId, Long flowId, Long jobId) {
        if(flowId > 0L)
            return String.format("%s/%s/%d/%d/%d", getLocalWorkRoot(), getJobFileDirName(), projectId, flowId, jobId);
        else
            return String.format("%s/%s/%d/other/%d", getLocalWorkRoot(), getJobFileDirName(), projectId, jobId);
    }

    public static String getDataWarehouseDfsDirectory(Long dwId) {
        return String.format("%s%s/%s/%d", getDfsDefautlFS(), getDfsWorkRoot(), getDataFileDirName(), dwId);
    }

    public static String getDataWarehouseLocalDirectory(Long dwId) {
        return String.format("%s/%s/%d", getLocalWorkRoot(), getDataFileDirName(), dwId);
    }

    public static String getModelWarehouseDfsDirectory(Long mwId) {
        return String.format("%s%s/%s/%d", getDfsDefautlFS(), getDfsWorkRoot(), getModelFileDirName(), mwId);
    }

    public static String getModelWarehouseLocalDirectory(Long mwId) {
        return String.format("%s/%s/%d", getLocalWorkRoot(), getModelFileDirName(), mwId);
    }

    public static boolean existDfsSchemaPrefix(String dfsPath) {
        if(DataUtil.isEmpty(dfsPath))
            return false;

        if(dfsPath.substring(0, HDFS_SCHEMA_PREFIX.length()).equalsIgnoreCase(HDFS_SCHEMA_PREFIX)) {
            return true;
        }
        return false;
    }

    public static String removeDfsSchemaPrefix(String dfsPath) {

        if(existDfsSchemaPrefix(dfsPath)) {
            dfsPath = dfsPath.substring(HDFS_SCHEMA_PREFIX.length());
            int rootDirIndex = dfsPath.indexOf('/');
            if (rootDirIndex - 1 > 0) {
                return dfsPath.substring(rootDirIndex);
            }
            return null;
        }

        return dfsPath;
    }

    public static String addDfsSchemaPrefix(String dfsPath) {

        dfsPath = removeDfsSchemaPrefix(dfsPath);
        return DataUtil.isNotEmpty(dfsPath) ? String.format("%s%s", getDfsDefautlFS(), dfsPath) : null;
    }
}
