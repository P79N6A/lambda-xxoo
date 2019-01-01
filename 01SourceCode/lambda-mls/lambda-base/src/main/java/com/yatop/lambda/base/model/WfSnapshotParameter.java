package com.yatop.lambda.base.model;

import com.alibaba.fastjson.JSONObject;
import com.yatop.lambda.base.utils.LambdaRootModel;
import java.io.Serializable;
import java.util.Date;

public class WfSnapshotParameter extends LambdaRootModel implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_snapshot_parameter.SNAPSHOT_ID
     *
     * @mbg.generated Wed Jan 02 00:41:22 CST 2019
     */
    private Long snapshotId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_snapshot_parameter.SNAPSHOT_ID:Coloured
     *
     * @mbg.generated Wed Jan 02 00:41:22 CST 2019
     */
    private boolean snapshotIdColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_snapshot_parameter.OWNER_NODE_ID
     *
     * @mbg.generated Wed Jan 02 00:41:22 CST 2019
     */
    private Long ownerNodeId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_snapshot_parameter.OWNER_NODE_ID:Coloured
     *
     * @mbg.generated Wed Jan 02 00:41:22 CST 2019
     */
    private boolean ownerNodeIdColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_snapshot_parameter.DESCRIPTION
     *
     * @mbg.generated Wed Jan 02 00:41:22 CST 2019
     */
    private String description;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_snapshot_parameter.DESCRIPTION:Coloured
     *
     * @mbg.generated Wed Jan 02 00:41:22 CST 2019
     */
    private boolean descriptionColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_snapshot_parameter.STATUS
     *
     * @mbg.generated Wed Jan 02 00:41:22 CST 2019
     */
    private Integer status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_snapshot_parameter.STATUS:Coloured
     *
     * @mbg.generated Wed Jan 02 00:41:22 CST 2019
     */
    private boolean statusColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_snapshot_parameter.LAST_UPDATE_TIME
     *
     * @mbg.generated Wed Jan 02 00:41:22 CST 2019
     */
    private Date lastUpdateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_snapshot_parameter.LAST_UPDATE_TIME:Coloured
     *
     * @mbg.generated Wed Jan 02 00:41:22 CST 2019
     */
    private boolean lastUpdateTimeColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_snapshot_parameter.LAST_UPDATE_OPER
     *
     * @mbg.generated Wed Jan 02 00:41:22 CST 2019
     */
    private String lastUpdateOper;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_snapshot_parameter.LAST_UPDATE_OPER:Coloured
     *
     * @mbg.generated Wed Jan 02 00:41:22 CST 2019
     */
    private boolean lastUpdateOperColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_snapshot_parameter.CREATE_TIME
     *
     * @mbg.generated Wed Jan 02 00:41:22 CST 2019
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_snapshot_parameter.CREATE_TIME:Coloured
     *
     * @mbg.generated Wed Jan 02 00:41:22 CST 2019
     */
    private boolean createTimeColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_snapshot_parameter.CREATE_OPER
     *
     * @mbg.generated Wed Jan 02 00:41:22 CST 2019
     */
    private String createOper;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_snapshot_parameter.CREATE_OPER:Coloured
     *
     * @mbg.generated Wed Jan 02 00:41:22 CST 2019
     */
    private boolean createOperColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_snapshot_parameter.PARAMETER_CONTENT
     *
     * @mbg.generated Wed Jan 02 00:41:22 CST 2019
     */
    private String parameterContent;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_snapshot_parameter.PARAMETER_CONTENT:Coloured
     *
     * @mbg.generated Wed Jan 02 00:41:22 CST 2019
     */
    private boolean parameterContentColoured;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table wf_snapshot_parameter
     *
     * @mbg.generated Wed Jan 02 00:41:22 CST 2019
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_snapshot_parameter.SNAPSHOT_ID
     *
     * @return the value of wf_snapshot_parameter.SNAPSHOT_ID
     *
     * @mbg.generated Wed Jan 02 00:41:22 CST 2019
     */
    public Long getSnapshotId() {
        return snapshotId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_snapshot_parameter.SNAPSHOT_ID:Coloured
     *
     * @return the value of wf_snapshot_parameter.SNAPSHOT_ID:Coloured
     *
     * @mbg.generated Wed Jan 02 00:41:22 CST 2019
     */
    public boolean isSnapshotIdColoured() {
        return snapshotIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_snapshot_parameter.SNAPSHOT_ID:Coloured
     *
     * @return the value of wf_snapshot_parameter.SNAPSHOT_ID:Coloured
     *
     * @mbg.generated Wed Jan 02 00:41:22 CST 2019
     */
    public boolean isSnapshotIdNotColoured() {
        return !snapshotIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_snapshot_parameter.SNAPSHOT_ID
     *
     * @param snapshotId the value for wf_snapshot_parameter.SNAPSHOT_ID
     *
     * @mbg.generated Wed Jan 02 00:41:22 CST 2019
     */
    public void setSnapshotId(Long snapshotId) {
        this.snapshotId = snapshotId;
        this.snapshotIdColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_snapshot_parameter.SNAPSHOT_ID:Coloured
     *
     * @param snapshotIdColoured the value for wf_snapshot_parameter.SNAPSHOT_ID:Coloured
     *
     * @mbg.generated Wed Jan 02 00:41:22 CST 2019
     */
    public void setSnapshotIdColoured(boolean snapshotIdColoured) {
        this.snapshotIdColoured = snapshotIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_snapshot_parameter.OWNER_NODE_ID
     *
     * @return the value of wf_snapshot_parameter.OWNER_NODE_ID
     *
     * @mbg.generated Wed Jan 02 00:41:22 CST 2019
     */
    public Long getOwnerNodeId() {
        return ownerNodeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_snapshot_parameter.OWNER_NODE_ID:Coloured
     *
     * @return the value of wf_snapshot_parameter.OWNER_NODE_ID:Coloured
     *
     * @mbg.generated Wed Jan 02 00:41:22 CST 2019
     */
    public boolean isOwnerNodeIdColoured() {
        return ownerNodeIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_snapshot_parameter.OWNER_NODE_ID:Coloured
     *
     * @return the value of wf_snapshot_parameter.OWNER_NODE_ID:Coloured
     *
     * @mbg.generated Wed Jan 02 00:41:22 CST 2019
     */
    public boolean isOwnerNodeIdNotColoured() {
        return !ownerNodeIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_snapshot_parameter.OWNER_NODE_ID
     *
     * @param ownerNodeId the value for wf_snapshot_parameter.OWNER_NODE_ID
     *
     * @mbg.generated Wed Jan 02 00:41:22 CST 2019
     */
    public void setOwnerNodeId(Long ownerNodeId) {
        this.ownerNodeId = ownerNodeId;
        this.ownerNodeIdColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_snapshot_parameter.OWNER_NODE_ID:Coloured
     *
     * @param ownerNodeIdColoured the value for wf_snapshot_parameter.OWNER_NODE_ID:Coloured
     *
     * @mbg.generated Wed Jan 02 00:41:22 CST 2019
     */
    public void setOwnerNodeIdColoured(boolean ownerNodeIdColoured) {
        this.ownerNodeIdColoured = ownerNodeIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_snapshot_parameter.DESCRIPTION
     *
     * @return the value of wf_snapshot_parameter.DESCRIPTION
     *
     * @mbg.generated Wed Jan 02 00:41:22 CST 2019
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_snapshot_parameter.DESCRIPTION:Coloured
     *
     * @return the value of wf_snapshot_parameter.DESCRIPTION:Coloured
     *
     * @mbg.generated Wed Jan 02 00:41:22 CST 2019
     */
    public boolean isDescriptionColoured() {
        return descriptionColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_snapshot_parameter.DESCRIPTION:Coloured
     *
     * @return the value of wf_snapshot_parameter.DESCRIPTION:Coloured
     *
     * @mbg.generated Wed Jan 02 00:41:22 CST 2019
     */
    public boolean isDescriptionNotColoured() {
        return !descriptionColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_snapshot_parameter.DESCRIPTION
     *
     * @param description the value for wf_snapshot_parameter.DESCRIPTION
     *
     * @mbg.generated Wed Jan 02 00:41:22 CST 2019
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
        this.descriptionColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_snapshot_parameter.DESCRIPTION:Coloured
     *
     * @param descriptionColoured the value for wf_snapshot_parameter.DESCRIPTION:Coloured
     *
     * @mbg.generated Wed Jan 02 00:41:22 CST 2019
     */
    public void setDescriptionColoured(boolean descriptionColoured) {
        this.descriptionColoured = descriptionColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_snapshot_parameter.STATUS
     *
     * @return the value of wf_snapshot_parameter.STATUS
     *
     * @mbg.generated Wed Jan 02 00:41:22 CST 2019
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_snapshot_parameter.STATUS:Coloured
     *
     * @return the value of wf_snapshot_parameter.STATUS:Coloured
     *
     * @mbg.generated Wed Jan 02 00:41:22 CST 2019
     */
    public boolean isStatusColoured() {
        return statusColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_snapshot_parameter.STATUS:Coloured
     *
     * @return the value of wf_snapshot_parameter.STATUS:Coloured
     *
     * @mbg.generated Wed Jan 02 00:41:22 CST 2019
     */
    public boolean isStatusNotColoured() {
        return !statusColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_snapshot_parameter.STATUS
     *
     * @param status the value for wf_snapshot_parameter.STATUS
     *
     * @mbg.generated Wed Jan 02 00:41:22 CST 2019
     */
    public void setStatus(Integer status) {
        this.status = status;
        this.statusColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_snapshot_parameter.STATUS:Coloured
     *
     * @param statusColoured the value for wf_snapshot_parameter.STATUS:Coloured
     *
     * @mbg.generated Wed Jan 02 00:41:22 CST 2019
     */
    public void setStatusColoured(boolean statusColoured) {
        this.statusColoured = statusColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_snapshot_parameter.LAST_UPDATE_TIME
     *
     * @return the value of wf_snapshot_parameter.LAST_UPDATE_TIME
     *
     * @mbg.generated Wed Jan 02 00:41:22 CST 2019
     */
    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_snapshot_parameter.LAST_UPDATE_TIME:Coloured
     *
     * @return the value of wf_snapshot_parameter.LAST_UPDATE_TIME:Coloured
     *
     * @mbg.generated Wed Jan 02 00:41:22 CST 2019
     */
    public boolean isLastUpdateTimeColoured() {
        return lastUpdateTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_snapshot_parameter.LAST_UPDATE_TIME:Coloured
     *
     * @return the value of wf_snapshot_parameter.LAST_UPDATE_TIME:Coloured
     *
     * @mbg.generated Wed Jan 02 00:41:22 CST 2019
     */
    public boolean isLastUpdateTimeNotColoured() {
        return !lastUpdateTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_snapshot_parameter.LAST_UPDATE_TIME
     *
     * @param lastUpdateTime the value for wf_snapshot_parameter.LAST_UPDATE_TIME
     *
     * @mbg.generated Wed Jan 02 00:41:22 CST 2019
     */
    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
        this.lastUpdateTimeColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_snapshot_parameter.LAST_UPDATE_TIME:Coloured
     *
     * @param lastUpdateTimeColoured the value for wf_snapshot_parameter.LAST_UPDATE_TIME:Coloured
     *
     * @mbg.generated Wed Jan 02 00:41:22 CST 2019
     */
    public void setLastUpdateTimeColoured(boolean lastUpdateTimeColoured) {
        this.lastUpdateTimeColoured = lastUpdateTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_snapshot_parameter.LAST_UPDATE_OPER
     *
     * @return the value of wf_snapshot_parameter.LAST_UPDATE_OPER
     *
     * @mbg.generated Wed Jan 02 00:41:22 CST 2019
     */
    public String getLastUpdateOper() {
        return lastUpdateOper;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_snapshot_parameter.LAST_UPDATE_OPER:Coloured
     *
     * @return the value of wf_snapshot_parameter.LAST_UPDATE_OPER:Coloured
     *
     * @mbg.generated Wed Jan 02 00:41:22 CST 2019
     */
    public boolean isLastUpdateOperColoured() {
        return lastUpdateOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_snapshot_parameter.LAST_UPDATE_OPER:Coloured
     *
     * @return the value of wf_snapshot_parameter.LAST_UPDATE_OPER:Coloured
     *
     * @mbg.generated Wed Jan 02 00:41:22 CST 2019
     */
    public boolean isLastUpdateOperNotColoured() {
        return !lastUpdateOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_snapshot_parameter.LAST_UPDATE_OPER
     *
     * @param lastUpdateOper the value for wf_snapshot_parameter.LAST_UPDATE_OPER
     *
     * @mbg.generated Wed Jan 02 00:41:22 CST 2019
     */
    public void setLastUpdateOper(String lastUpdateOper) {
        this.lastUpdateOper = lastUpdateOper == null ? null : lastUpdateOper.trim();
        this.lastUpdateOperColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_snapshot_parameter.LAST_UPDATE_OPER:Coloured
     *
     * @param lastUpdateOperColoured the value for wf_snapshot_parameter.LAST_UPDATE_OPER:Coloured
     *
     * @mbg.generated Wed Jan 02 00:41:22 CST 2019
     */
    public void setLastUpdateOperColoured(boolean lastUpdateOperColoured) {
        this.lastUpdateOperColoured = lastUpdateOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_snapshot_parameter.CREATE_TIME
     *
     * @return the value of wf_snapshot_parameter.CREATE_TIME
     *
     * @mbg.generated Wed Jan 02 00:41:22 CST 2019
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_snapshot_parameter.CREATE_TIME:Coloured
     *
     * @return the value of wf_snapshot_parameter.CREATE_TIME:Coloured
     *
     * @mbg.generated Wed Jan 02 00:41:22 CST 2019
     */
    public boolean isCreateTimeColoured() {
        return createTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_snapshot_parameter.CREATE_TIME:Coloured
     *
     * @return the value of wf_snapshot_parameter.CREATE_TIME:Coloured
     *
     * @mbg.generated Wed Jan 02 00:41:22 CST 2019
     */
    public boolean isCreateTimeNotColoured() {
        return !createTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_snapshot_parameter.CREATE_TIME
     *
     * @param createTime the value for wf_snapshot_parameter.CREATE_TIME
     *
     * @mbg.generated Wed Jan 02 00:41:22 CST 2019
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
        this.createTimeColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_snapshot_parameter.CREATE_TIME:Coloured
     *
     * @param createTimeColoured the value for wf_snapshot_parameter.CREATE_TIME:Coloured
     *
     * @mbg.generated Wed Jan 02 00:41:22 CST 2019
     */
    public void setCreateTimeColoured(boolean createTimeColoured) {
        this.createTimeColoured = createTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_snapshot_parameter.CREATE_OPER
     *
     * @return the value of wf_snapshot_parameter.CREATE_OPER
     *
     * @mbg.generated Wed Jan 02 00:41:22 CST 2019
     */
    public String getCreateOper() {
        return createOper;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_snapshot_parameter.CREATE_OPER:Coloured
     *
     * @return the value of wf_snapshot_parameter.CREATE_OPER:Coloured
     *
     * @mbg.generated Wed Jan 02 00:41:22 CST 2019
     */
    public boolean isCreateOperColoured() {
        return createOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_snapshot_parameter.CREATE_OPER:Coloured
     *
     * @return the value of wf_snapshot_parameter.CREATE_OPER:Coloured
     *
     * @mbg.generated Wed Jan 02 00:41:22 CST 2019
     */
    public boolean isCreateOperNotColoured() {
        return !createOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_snapshot_parameter.CREATE_OPER
     *
     * @param createOper the value for wf_snapshot_parameter.CREATE_OPER
     *
     * @mbg.generated Wed Jan 02 00:41:22 CST 2019
     */
    public void setCreateOper(String createOper) {
        this.createOper = createOper == null ? null : createOper.trim();
        this.createOperColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_snapshot_parameter.CREATE_OPER:Coloured
     *
     * @param createOperColoured the value for wf_snapshot_parameter.CREATE_OPER:Coloured
     *
     * @mbg.generated Wed Jan 02 00:41:22 CST 2019
     */
    public void setCreateOperColoured(boolean createOperColoured) {
        this.createOperColoured = createOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_snapshot_parameter.PARAMETER_CONTENT
     *
     * @return the value of wf_snapshot_parameter.PARAMETER_CONTENT
     *
     * @mbg.generated Wed Jan 02 00:41:22 CST 2019
     */
    public String getParameterContent() {
        return parameterContent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_snapshot_parameter.PARAMETER_CONTENT:Coloured
     *
     * @return the value of wf_snapshot_parameter.PARAMETER_CONTENT:Coloured
     *
     * @mbg.generated Wed Jan 02 00:41:22 CST 2019
     */
    public boolean isParameterContentColoured() {
        return parameterContentColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_snapshot_parameter.PARAMETER_CONTENT:Coloured
     *
     * @return the value of wf_snapshot_parameter.PARAMETER_CONTENT:Coloured
     *
     * @mbg.generated Wed Jan 02 00:41:22 CST 2019
     */
    public boolean isParameterContentNotColoured() {
        return !parameterContentColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_snapshot_parameter.PARAMETER_CONTENT
     *
     * @param parameterContent the value for wf_snapshot_parameter.PARAMETER_CONTENT
     *
     * @mbg.generated Wed Jan 02 00:41:22 CST 2019
     */
    public void setParameterContent(String parameterContent) {
        this.parameterContent = parameterContent == null ? null : parameterContent.trim();
        this.parameterContentColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_snapshot_parameter.PARAMETER_CONTENT:Coloured
     *
     * @param parameterContentColoured the value for wf_snapshot_parameter.PARAMETER_CONTENT:Coloured
     *
     * @mbg.generated Wed Jan 02 00:41:22 CST 2019
     */
    public void setParameterContentColoured(boolean parameterContentColoured) {
        this.parameterContentColoured = parameterContentColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_snapshot_parameter
     *
     * @mbg.generated Wed Jan 02 00:41:22 CST 2019
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if(!(that instanceof WfSnapshotParameter)) {
            return false;
        }
        WfSnapshotParameter other = (WfSnapshotParameter) that;
        return (this.getSnapshotId() == null ? other.getSnapshotId() == null : this.getSnapshotId().equals(other.getSnapshotId()))
            && (this.getOwnerNodeId() == null ? other.getOwnerNodeId() == null : this.getOwnerNodeId().equals(other.getOwnerNodeId()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getLastUpdateTime() == null ? other.getLastUpdateTime() == null : this.getLastUpdateTime().equals(other.getLastUpdateTime()))
            && (this.getLastUpdateOper() == null ? other.getLastUpdateOper() == null : this.getLastUpdateOper().equals(other.getLastUpdateOper()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getCreateOper() == null ? other.getCreateOper() == null : this.getCreateOper().equals(other.getCreateOper()))
            && (this.getParameterContent() == null ? other.getParameterContent() == null : this.getParameterContent().equals(other.getParameterContent()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_snapshot_parameter
     *
     * @mbg.generated Wed Jan 02 00:41:22 CST 2019
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getSnapshotId() == null) ? 0 : getSnapshotId().hashCode());
        result = prime * result + ((getOwnerNodeId() == null) ? 0 : getOwnerNodeId().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getLastUpdateTime() == null) ? 0 : getLastUpdateTime().hashCode());
        result = prime * result + ((getLastUpdateOper() == null) ? 0 : getLastUpdateOper().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCreateOper() == null) ? 0 : getCreateOper().hashCode());
        result = prime * result + ((getParameterContent() == null) ? 0 : getParameterContent().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_snapshot_parameter
     *
     * @mbg.generated Wed Jan 02 00:41:22 CST 2019
     */
    public void copyProperties(WfSnapshotParameter that) {
        if (this == that || that == null) {
            return;
        }
        if(that.isSnapshotIdColoured() ) {this.setSnapshotId(that.getSnapshotId() );}
        if(that.isOwnerNodeIdColoured() ) {this.setOwnerNodeId(that.getOwnerNodeId() );}
        if(that.isDescriptionColoured() ) {this.setDescription(that.getDescription() );}
        if(that.isStatusColoured() ) {this.setStatus(that.getStatus() );}
        if(that.isLastUpdateTimeColoured() ) {this.setLastUpdateTime(that.getLastUpdateTime() );}
        if(that.isLastUpdateOperColoured() ) {this.setLastUpdateOper(that.getLastUpdateOper() );}
        if(that.isCreateTimeColoured() ) {this.setCreateTime(that.getCreateTime() );}
        if(that.isCreateOperColoured() ) {this.setCreateOper(that.getCreateOper() );}
        if(that.isParameterContentColoured() ) {this.setParameterContent(that.getParameterContent() );}
        return;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_snapshot_parameter
     *
     * @mbg.generated Wed Jan 02 00:41:22 CST 2019
     */
    @Override
    public JSONObject toJSON() {
        JSONObject jsonObj = new JSONObject(32, true);
        if(this.snapshotId != null) {jsonObj.put("snapshotId", this.snapshotId);}
        if(this.ownerNodeId != null) {jsonObj.put("ownerNodeId", this.ownerNodeId);}
        if(this.description != null) {jsonObj.put("description", this.description);}
        if(this.status != null) {jsonObj.put("status", this.status);}
        if(this.lastUpdateTime != null) {jsonObj.put("lastUpdateTime", this.lastUpdateTime);}
        if(this.lastUpdateOper != null) {jsonObj.put("lastUpdateOper", this.lastUpdateOper);}
        if(this.createTime != null) {jsonObj.put("createTime", this.createTime);}
        if(this.createOper != null) {jsonObj.put("createOper", this.createOper);}
        if(this.parameterContent != null) {jsonObj.put("parameterContent", this.parameterContent);}
        return jsonObj;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_snapshot_parameter
     *
     * @mbg.generated Wed Jan 02 00:41:22 CST 2019
     */
    @Override
    public void clear() {
         this.snapshotId = null; this.snapshotIdColoured = false;
         this.ownerNodeId = null; this.ownerNodeIdColoured = false;
         this.description = null; this.descriptionColoured = false;
         this.status = null; this.statusColoured = false;
         this.lastUpdateTime = null; this.lastUpdateTimeColoured = false;
         this.lastUpdateOper = null; this.lastUpdateOperColoured = false;
         this.createTime = null; this.createTimeColoured = false;
         this.createOper = null; this.createOperColoured = false;
         this.parameterContent = null; this.parameterContentColoured = false;
        return;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_snapshot_parameter
     *
     * @mbg.generated Wed Jan 02 00:41:22 CST 2019
     */
    @Override
    public void clearColoured() {
        this.snapshotIdColoured = false;
        this.ownerNodeIdColoured = false;
        this.descriptionColoured = false;
        this.statusColoured = false;
        this.lastUpdateTimeColoured = false;
        this.lastUpdateOperColoured = false;
        this.createTimeColoured = false;
        this.createOperColoured = false;
        this.parameterContentColoured = false;
        return;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_snapshot_parameter
     *
     * @mbg.generated Wed Jan 02 00:41:22 CST 2019
     */
    @Override
    public boolean isColoured() {
        if(this.snapshotIdColoured) return true;
        if(this.ownerNodeIdColoured) return true;
        if(this.descriptionColoured) return true;
        if(this.statusColoured) return true;
        if(this.lastUpdateTimeColoured) return true;
        if(this.lastUpdateOperColoured) return true;
        if(this.createTimeColoured) return true;
        if(this.createOperColoured) return true;
        if(this.parameterContentColoured) return true;
        return false;
    }
}