package com.yatop.lambda.base.model;

import com.alibaba.fastjson.JSONObject;
import com.yatop.lambda.base.utils.LambdaRootModel;
import java.io.Serializable;
import java.util.Date;

public class WfUserFavoriteTable extends LambdaRootModel implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_user_favorite_table.PROJECT_ID
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    private Long projectId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_user_favorite_table.PROJECT_ID:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    private boolean projectIdColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_user_favorite_table.OPER_ID
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    private String operId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_user_favorite_table.OPER_ID:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    private boolean operIdColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_user_favorite_table.TABLE_ID
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    private Long tableId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_user_favorite_table.TABLE_ID:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    private boolean tableIdColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_user_favorite_table.DESCRIPTION
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    private String description;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_user_favorite_table.DESCRIPTION:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    private boolean descriptionColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_user_favorite_table.STATUS
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    private Integer status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_user_favorite_table.STATUS:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    private boolean statusColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_user_favorite_table.LAST_UPDATE_TIME
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    private Date lastUpdateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_user_favorite_table.LAST_UPDATE_TIME:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    private boolean lastUpdateTimeColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_user_favorite_table.LAST_UPDATE_OPER
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    private String lastUpdateOper;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_user_favorite_table.LAST_UPDATE_OPER:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    private boolean lastUpdateOperColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_user_favorite_table.CREATE_TIME
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_user_favorite_table.CREATE_TIME:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    private boolean createTimeColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_user_favorite_table.CREATE_OPER
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    private String createOper;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_user_favorite_table.CREATE_OPER:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    private boolean createOperColoured;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table wf_user_favorite_table
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_user_favorite_table.PROJECT_ID
     *
     * @return the value of wf_user_favorite_table.PROJECT_ID
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public Long getProjectId() {
        return projectId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_user_favorite_table.PROJECT_ID:Coloured
     *
     * @return the value of wf_user_favorite_table.PROJECT_ID:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public boolean isProjectIdColoured() {
        return projectIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_user_favorite_table.PROJECT_ID:Coloured
     *
     * @return the value of wf_user_favorite_table.PROJECT_ID:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public boolean isProjectIdNotColoured() {
        return !projectIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_user_favorite_table.PROJECT_ID
     *
     * @param projectId the value for wf_user_favorite_table.PROJECT_ID
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public void setProjectId(Long projectId) {
        this.projectId = projectId;
        this.projectIdColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_user_favorite_table.PROJECT_ID:Coloured
     *
     * @param projectIdColoured the value for wf_user_favorite_table.PROJECT_ID:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public void setProjectIdColoured(boolean projectIdColoured) {
        this.projectIdColoured = projectIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_user_favorite_table.OPER_ID
     *
     * @return the value of wf_user_favorite_table.OPER_ID
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public String getOperId() {
        return operId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_user_favorite_table.OPER_ID:Coloured
     *
     * @return the value of wf_user_favorite_table.OPER_ID:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public boolean isOperIdColoured() {
        return operIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_user_favorite_table.OPER_ID:Coloured
     *
     * @return the value of wf_user_favorite_table.OPER_ID:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public boolean isOperIdNotColoured() {
        return !operIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_user_favorite_table.OPER_ID
     *
     * @param operId the value for wf_user_favorite_table.OPER_ID
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public void setOperId(String operId) {
        this.operId = operId == null ? null : operId.trim();
        this.operIdColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_user_favorite_table.OPER_ID:Coloured
     *
     * @param operIdColoured the value for wf_user_favorite_table.OPER_ID:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public void setOperIdColoured(boolean operIdColoured) {
        this.operIdColoured = operIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_user_favorite_table.TABLE_ID
     *
     * @return the value of wf_user_favorite_table.TABLE_ID
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public Long getTableId() {
        return tableId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_user_favorite_table.TABLE_ID:Coloured
     *
     * @return the value of wf_user_favorite_table.TABLE_ID:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public boolean isTableIdColoured() {
        return tableIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_user_favorite_table.TABLE_ID:Coloured
     *
     * @return the value of wf_user_favorite_table.TABLE_ID:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public boolean isTableIdNotColoured() {
        return !tableIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_user_favorite_table.TABLE_ID
     *
     * @param tableId the value for wf_user_favorite_table.TABLE_ID
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public void setTableId(Long tableId) {
        this.tableId = tableId;
        this.tableIdColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_user_favorite_table.TABLE_ID:Coloured
     *
     * @param tableIdColoured the value for wf_user_favorite_table.TABLE_ID:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public void setTableIdColoured(boolean tableIdColoured) {
        this.tableIdColoured = tableIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_user_favorite_table.DESCRIPTION
     *
     * @return the value of wf_user_favorite_table.DESCRIPTION
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_user_favorite_table.DESCRIPTION:Coloured
     *
     * @return the value of wf_user_favorite_table.DESCRIPTION:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public boolean isDescriptionColoured() {
        return descriptionColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_user_favorite_table.DESCRIPTION:Coloured
     *
     * @return the value of wf_user_favorite_table.DESCRIPTION:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public boolean isDescriptionNotColoured() {
        return !descriptionColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_user_favorite_table.DESCRIPTION
     *
     * @param description the value for wf_user_favorite_table.DESCRIPTION
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
        this.descriptionColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_user_favorite_table.DESCRIPTION:Coloured
     *
     * @param descriptionColoured the value for wf_user_favorite_table.DESCRIPTION:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public void setDescriptionColoured(boolean descriptionColoured) {
        this.descriptionColoured = descriptionColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_user_favorite_table.STATUS
     *
     * @return the value of wf_user_favorite_table.STATUS
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_user_favorite_table.STATUS:Coloured
     *
     * @return the value of wf_user_favorite_table.STATUS:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public boolean isStatusColoured() {
        return statusColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_user_favorite_table.STATUS:Coloured
     *
     * @return the value of wf_user_favorite_table.STATUS:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public boolean isStatusNotColoured() {
        return !statusColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_user_favorite_table.STATUS
     *
     * @param status the value for wf_user_favorite_table.STATUS
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public void setStatus(Integer status) {
        this.status = status;
        this.statusColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_user_favorite_table.STATUS:Coloured
     *
     * @param statusColoured the value for wf_user_favorite_table.STATUS:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public void setStatusColoured(boolean statusColoured) {
        this.statusColoured = statusColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_user_favorite_table.LAST_UPDATE_TIME
     *
     * @return the value of wf_user_favorite_table.LAST_UPDATE_TIME
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_user_favorite_table.LAST_UPDATE_TIME:Coloured
     *
     * @return the value of wf_user_favorite_table.LAST_UPDATE_TIME:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public boolean isLastUpdateTimeColoured() {
        return lastUpdateTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_user_favorite_table.LAST_UPDATE_TIME:Coloured
     *
     * @return the value of wf_user_favorite_table.LAST_UPDATE_TIME:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public boolean isLastUpdateTimeNotColoured() {
        return !lastUpdateTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_user_favorite_table.LAST_UPDATE_TIME
     *
     * @param lastUpdateTime the value for wf_user_favorite_table.LAST_UPDATE_TIME
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
        this.lastUpdateTimeColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_user_favorite_table.LAST_UPDATE_TIME:Coloured
     *
     * @param lastUpdateTimeColoured the value for wf_user_favorite_table.LAST_UPDATE_TIME:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public void setLastUpdateTimeColoured(boolean lastUpdateTimeColoured) {
        this.lastUpdateTimeColoured = lastUpdateTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_user_favorite_table.LAST_UPDATE_OPER
     *
     * @return the value of wf_user_favorite_table.LAST_UPDATE_OPER
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public String getLastUpdateOper() {
        return lastUpdateOper;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_user_favorite_table.LAST_UPDATE_OPER:Coloured
     *
     * @return the value of wf_user_favorite_table.LAST_UPDATE_OPER:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public boolean isLastUpdateOperColoured() {
        return lastUpdateOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_user_favorite_table.LAST_UPDATE_OPER:Coloured
     *
     * @return the value of wf_user_favorite_table.LAST_UPDATE_OPER:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public boolean isLastUpdateOperNotColoured() {
        return !lastUpdateOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_user_favorite_table.LAST_UPDATE_OPER
     *
     * @param lastUpdateOper the value for wf_user_favorite_table.LAST_UPDATE_OPER
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public void setLastUpdateOper(String lastUpdateOper) {
        this.lastUpdateOper = lastUpdateOper == null ? null : lastUpdateOper.trim();
        this.lastUpdateOperColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_user_favorite_table.LAST_UPDATE_OPER:Coloured
     *
     * @param lastUpdateOperColoured the value for wf_user_favorite_table.LAST_UPDATE_OPER:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public void setLastUpdateOperColoured(boolean lastUpdateOperColoured) {
        this.lastUpdateOperColoured = lastUpdateOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_user_favorite_table.CREATE_TIME
     *
     * @return the value of wf_user_favorite_table.CREATE_TIME
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_user_favorite_table.CREATE_TIME:Coloured
     *
     * @return the value of wf_user_favorite_table.CREATE_TIME:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public boolean isCreateTimeColoured() {
        return createTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_user_favorite_table.CREATE_TIME:Coloured
     *
     * @return the value of wf_user_favorite_table.CREATE_TIME:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public boolean isCreateTimeNotColoured() {
        return !createTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_user_favorite_table.CREATE_TIME
     *
     * @param createTime the value for wf_user_favorite_table.CREATE_TIME
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
        this.createTimeColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_user_favorite_table.CREATE_TIME:Coloured
     *
     * @param createTimeColoured the value for wf_user_favorite_table.CREATE_TIME:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public void setCreateTimeColoured(boolean createTimeColoured) {
        this.createTimeColoured = createTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_user_favorite_table.CREATE_OPER
     *
     * @return the value of wf_user_favorite_table.CREATE_OPER
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public String getCreateOper() {
        return createOper;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_user_favorite_table.CREATE_OPER:Coloured
     *
     * @return the value of wf_user_favorite_table.CREATE_OPER:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public boolean isCreateOperColoured() {
        return createOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_user_favorite_table.CREATE_OPER:Coloured
     *
     * @return the value of wf_user_favorite_table.CREATE_OPER:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public boolean isCreateOperNotColoured() {
        return !createOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_user_favorite_table.CREATE_OPER
     *
     * @param createOper the value for wf_user_favorite_table.CREATE_OPER
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public void setCreateOper(String createOper) {
        this.createOper = createOper == null ? null : createOper.trim();
        this.createOperColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_user_favorite_table.CREATE_OPER:Coloured
     *
     * @param createOperColoured the value for wf_user_favorite_table.CREATE_OPER:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public void setCreateOperColoured(boolean createOperColoured) {
        this.createOperColoured = createOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_user_favorite_table
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if(!(that instanceof WfUserFavoriteTable)) {
            return false;
        }
        WfUserFavoriteTable other = (WfUserFavoriteTable) that;
        return (this.getProjectId() == null ? other.getProjectId() == null : this.getProjectId().equals(other.getProjectId()))
            && (this.getOperId() == null ? other.getOperId() == null : this.getOperId().equals(other.getOperId()))
            && (this.getTableId() == null ? other.getTableId() == null : this.getTableId().equals(other.getTableId()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getLastUpdateTime() == null ? other.getLastUpdateTime() == null : this.getLastUpdateTime().equals(other.getLastUpdateTime()))
            && (this.getLastUpdateOper() == null ? other.getLastUpdateOper() == null : this.getLastUpdateOper().equals(other.getLastUpdateOper()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getCreateOper() == null ? other.getCreateOper() == null : this.getCreateOper().equals(other.getCreateOper()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_user_favorite_table
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getProjectId() == null) ? 0 : getProjectId().hashCode());
        result = prime * result + ((getOperId() == null) ? 0 : getOperId().hashCode());
        result = prime * result + ((getTableId() == null) ? 0 : getTableId().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getLastUpdateTime() == null) ? 0 : getLastUpdateTime().hashCode());
        result = prime * result + ((getLastUpdateOper() == null) ? 0 : getLastUpdateOper().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCreateOper() == null) ? 0 : getCreateOper().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_user_favorite_table
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public void copyProperties(WfUserFavoriteTable that) {
        if (this == that || that == null) {
            return;
        }
        if(that.isProjectIdColoured() ) {this.setProjectId(that.getProjectId() );}
        if(that.isOperIdColoured() ) {this.setOperId(that.getOperId() );}
        if(that.isTableIdColoured() ) {this.setTableId(that.getTableId() );}
        if(that.isDescriptionColoured() ) {this.setDescription(that.getDescription() );}
        if(that.isStatusColoured() ) {this.setStatus(that.getStatus() );}
        if(that.isLastUpdateTimeColoured() ) {this.setLastUpdateTime(that.getLastUpdateTime() );}
        if(that.isLastUpdateOperColoured() ) {this.setLastUpdateOper(that.getLastUpdateOper() );}
        if(that.isCreateTimeColoured() ) {this.setCreateTime(that.getCreateTime() );}
        if(that.isCreateOperColoured() ) {this.setCreateOper(that.getCreateOper() );}
        return;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_user_favorite_table
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public WfUserFavoriteTable makeCopy() {
        WfUserFavoriteTable copy = new WfUserFavoriteTable();
        if(this.projectId != null ) {copy.projectId = this.projectId;}
        if(this.operId != null ) {copy.operId = this.operId;}
        if(this.tableId != null ) {copy.tableId = this.tableId;}
        if(this.description != null ) {copy.description = this.description;}
        if(this.status != null ) {copy.status = this.status;}
        if(this.lastUpdateTime != null ) {copy.lastUpdateTime = this.lastUpdateTime;}
        if(this.lastUpdateOper != null ) {copy.lastUpdateOper = this.lastUpdateOper;}
        if(this.createTime != null ) {copy.createTime = this.createTime;}
        if(this.createOper != null ) {copy.createOper = this.createOper;}
        return copy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_user_favorite_table
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    @Override
    public JSONObject toJSON() {
        JSONObject jsonObj = new JSONObject(32, true);
        if(this.projectId != null) {jsonObj.put("projectId", this.projectId);}
        if(this.operId != null) {jsonObj.put("operId", this.operId);}
        if(this.tableId != null) {jsonObj.put("tableId", this.tableId);}
        if(this.description != null) {jsonObj.put("description", this.description);}
        if(this.status != null) {jsonObj.put("status", this.status);}
        if(this.lastUpdateTime != null) {jsonObj.put("lastUpdateTime", this.lastUpdateTime);}
        if(this.lastUpdateOper != null) {jsonObj.put("lastUpdateOper", this.lastUpdateOper);}
        if(this.createTime != null) {jsonObj.put("createTime", this.createTime);}
        if(this.createOper != null) {jsonObj.put("createOper", this.createOper);}
        return jsonObj;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_user_favorite_table
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    @Override
    public void clear() {
         this.projectId = null; this.projectIdColoured = false;
         this.operId = null; this.operIdColoured = false;
         this.tableId = null; this.tableIdColoured = false;
         this.description = null; this.descriptionColoured = false;
         this.status = null; this.statusColoured = false;
         this.lastUpdateTime = null; this.lastUpdateTimeColoured = false;
         this.lastUpdateOper = null; this.lastUpdateOperColoured = false;
         this.createTime = null; this.createTimeColoured = false;
         this.createOper = null; this.createOperColoured = false;
        return;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_user_favorite_table
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    @Override
    public void clearColoured() {
        this.projectIdColoured = false;
        this.operIdColoured = false;
        this.tableIdColoured = false;
        this.descriptionColoured = false;
        this.statusColoured = false;
        this.lastUpdateTimeColoured = false;
        this.lastUpdateOperColoured = false;
        this.createTimeColoured = false;
        this.createOperColoured = false;
        return;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_user_favorite_table
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    @Override
    public boolean isColoured() {
        if(this.projectIdColoured) return true;
        if(this.operIdColoured) return true;
        if(this.tableIdColoured) return true;
        if(this.descriptionColoured) return true;
        if(this.statusColoured) return true;
        if(this.lastUpdateTimeColoured) return true;
        if(this.lastUpdateOperColoured) return true;
        if(this.createTimeColoured) return true;
        if(this.createOperColoured) return true;
        return false;
    }
}