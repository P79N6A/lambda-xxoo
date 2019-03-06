package com.yatop.lambda.manager.api.request.experiment;

import com.yatop.lambda.core.utils.PagerUtil;

/**
 * @author huangyu
 * @create 2019-02-27-16:48
 */

/**
 * 实验管理 Vo 类
 *
 * @author huangyu
 * @create 2019-02-26-11:28
 */
public class ExperimentRequest extends PagerUtil {
    private Long projectId;
    private String experimentName;
    private String summary;
    private String description;
    private Long experimentId;
    private Long templateId;
    private Long snapshotId;
    private String keyword;

    private Long nodeId;
    private Long posX;
    private Long posY;
    private Long[] nodeIds;
    private Long[] posXs;
    private Long[] posYs;
    private Long tableId;
    private String tableName;
    private Long moduleId;
    private Long srcNodeId;
    private Long dstNodeId;
    private Long srcNodePortId;
    private Long dstNodePortId;
    private Long modelId;


    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getExperimentName() {
        return experimentName;
    }

    public void setExperimentName(String experimentName) {
        this.experimentName = experimentName;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Long getExperimentId() {
        return experimentId;
    }

    public void setExperimentId(Long experimentId) {
        this.experimentId = experimentId;
    }

    public Long getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Long templateId) {
        this.templateId = templateId;
    }

    public Long getSnapshotId() {
        return snapshotId;
    }

    public void setSnapshotId(Long snapshotId) {
        this.snapshotId = snapshotId;
    }

    public Long getNodeId() {
        return nodeId;
    }

    public void setNodeId(Long nodeId) {
        this.nodeId = nodeId;
    }

    public Long getPosX() {
        return posX;
    }

    public void setPosX(Long posX) {
        this.posX = posX;
    }

    public Long getPosY() {
        return posY;
    }

    public void setPosY(Long posY) {
        this.posY = posY;
    }

    public Long getTableId() {
        return tableId;
    }

    public void setTableId(Long tableId) {
        this.tableId = tableId;
    }

    public Long getModuleId() {
        return moduleId;
    }

    public void setModuleId(Long moduleId) {
        this.moduleId = moduleId;
    }

    public Long[] getNodeIds() {
        return nodeIds;
    }

    public void setNodeIds(Long[] nodeIds) {
        this.nodeIds = nodeIds;
    }

    public Long[] getPosXs() {
        return posXs;
    }

    public void setPosXs(Long[] posXs) {
        this.posXs = posXs;
    }

    public Long[] getPosYs() {
        return posYs;
    }

    public void setPosYs(Long[] posYs) {
        this.posYs = posYs;
    }

    public Long getSrcNodeId() {
        return srcNodeId;
    }

    public void setSrcNodeId(Long srcNodeId) {
        this.srcNodeId = srcNodeId;
    }

    public Long getDstNodeId() {
        return dstNodeId;
    }

    public void setDstNodeId(Long dstNodeId) {
        this.dstNodeId = dstNodeId;
    }

    public Long getSrcNodePortId() {
        return srcNodePortId;
    }

    public void setSrcNodePortId(Long srcNodePortId) {
        this.srcNodePortId = srcNodePortId;
    }

    public Long getDstNodePortId() {
        return dstNodePortId;
    }

    public void setDstNodePortId(Long dstNodePortId) {
        this.dstNodePortId = dstNodePortId;
    }

    public Long getModelId() {
        return modelId;
    }

    public void setModelId(Long modelId) {
        this.modelId = modelId;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }
}


