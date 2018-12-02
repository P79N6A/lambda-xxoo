package com.yatop.lambda.base.model;

import java.io.Serializable;
import java.util.Date;

public class WfUserFavoriteTable implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_user_favorite_table.PROJECT_ID
     *
     * @mbg.generated Sun Dec 02 15:46:24 CST 2018
     */
    private Long projectId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_user_favorite_table.OPER_ID
     *
     * @mbg.generated Sun Dec 02 15:46:24 CST 2018
     */
    private String operId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_user_favorite_table.TABLE_ID
     *
     * @mbg.generated Sun Dec 02 15:46:24 CST 2018
     */
    private Long tableId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_user_favorite_table.DESCRIPTION
     *
     * @mbg.generated Sun Dec 02 15:46:24 CST 2018
     */
    private String description;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_user_favorite_table.STATUS
     *
     * @mbg.generated Sun Dec 02 15:46:24 CST 2018
     */
    private Integer status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_user_favorite_table.LAST_UPDATE_TIME
     *
     * @mbg.generated Sun Dec 02 15:46:24 CST 2018
     */
    private Date lastUpdateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_user_favorite_table.LAST_UPDATE_OPER
     *
     * @mbg.generated Sun Dec 02 15:46:24 CST 2018
     */
    private String lastUpdateOper;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_user_favorite_table.CREATE_TIME
     *
     * @mbg.generated Sun Dec 02 15:46:24 CST 2018
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_user_favorite_table.CREATE_OPER
     *
     * @mbg.generated Sun Dec 02 15:46:24 CST 2018
     */
    private String createOper;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table wf_user_favorite_table
     *
     * @mbg.generated Sun Dec 02 15:46:24 CST 2018
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_user_favorite_table.PROJECT_ID
     *
     * @return the value of wf_user_favorite_table.PROJECT_ID
     *
     * @mbg.generated Sun Dec 02 15:46:24 CST 2018
     */
    public Long getProjectId() {
        return projectId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_user_favorite_table.PROJECT_ID
     *
     * @param projectId the value for wf_user_favorite_table.PROJECT_ID
     *
     * @mbg.generated Sun Dec 02 15:46:24 CST 2018
     */
    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_user_favorite_table.OPER_ID
     *
     * @return the value of wf_user_favorite_table.OPER_ID
     *
     * @mbg.generated Sun Dec 02 15:46:24 CST 2018
     */
    public String getOperId() {
        return operId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_user_favorite_table.OPER_ID
     *
     * @param operId the value for wf_user_favorite_table.OPER_ID
     *
     * @mbg.generated Sun Dec 02 15:46:24 CST 2018
     */
    public void setOperId(String operId) {
        this.operId = operId == null ? null : operId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_user_favorite_table.TABLE_ID
     *
     * @return the value of wf_user_favorite_table.TABLE_ID
     *
     * @mbg.generated Sun Dec 02 15:46:24 CST 2018
     */
    public Long getTableId() {
        return tableId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_user_favorite_table.TABLE_ID
     *
     * @param tableId the value for wf_user_favorite_table.TABLE_ID
     *
     * @mbg.generated Sun Dec 02 15:46:24 CST 2018
     */
    public void setTableId(Long tableId) {
        this.tableId = tableId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_user_favorite_table.DESCRIPTION
     *
     * @return the value of wf_user_favorite_table.DESCRIPTION
     *
     * @mbg.generated Sun Dec 02 15:46:24 CST 2018
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_user_favorite_table.DESCRIPTION
     *
     * @param description the value for wf_user_favorite_table.DESCRIPTION
     *
     * @mbg.generated Sun Dec 02 15:46:24 CST 2018
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_user_favorite_table.STATUS
     *
     * @return the value of wf_user_favorite_table.STATUS
     *
     * @mbg.generated Sun Dec 02 15:46:24 CST 2018
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_user_favorite_table.STATUS
     *
     * @param status the value for wf_user_favorite_table.STATUS
     *
     * @mbg.generated Sun Dec 02 15:46:24 CST 2018
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_user_favorite_table.LAST_UPDATE_TIME
     *
     * @return the value of wf_user_favorite_table.LAST_UPDATE_TIME
     *
     * @mbg.generated Sun Dec 02 15:46:24 CST 2018
     */
    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_user_favorite_table.LAST_UPDATE_TIME
     *
     * @param lastUpdateTime the value for wf_user_favorite_table.LAST_UPDATE_TIME
     *
     * @mbg.generated Sun Dec 02 15:46:24 CST 2018
     */
    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_user_favorite_table.LAST_UPDATE_OPER
     *
     * @return the value of wf_user_favorite_table.LAST_UPDATE_OPER
     *
     * @mbg.generated Sun Dec 02 15:46:24 CST 2018
     */
    public String getLastUpdateOper() {
        return lastUpdateOper;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_user_favorite_table.LAST_UPDATE_OPER
     *
     * @param lastUpdateOper the value for wf_user_favorite_table.LAST_UPDATE_OPER
     *
     * @mbg.generated Sun Dec 02 15:46:24 CST 2018
     */
    public void setLastUpdateOper(String lastUpdateOper) {
        this.lastUpdateOper = lastUpdateOper == null ? null : lastUpdateOper.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_user_favorite_table.CREATE_TIME
     *
     * @return the value of wf_user_favorite_table.CREATE_TIME
     *
     * @mbg.generated Sun Dec 02 15:46:24 CST 2018
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_user_favorite_table.CREATE_TIME
     *
     * @param createTime the value for wf_user_favorite_table.CREATE_TIME
     *
     * @mbg.generated Sun Dec 02 15:46:24 CST 2018
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_user_favorite_table.CREATE_OPER
     *
     * @return the value of wf_user_favorite_table.CREATE_OPER
     *
     * @mbg.generated Sun Dec 02 15:46:24 CST 2018
     */
    public String getCreateOper() {
        return createOper;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_user_favorite_table.CREATE_OPER
     *
     * @param createOper the value for wf_user_favorite_table.CREATE_OPER
     *
     * @mbg.generated Sun Dec 02 15:46:24 CST 2018
     */
    public void setCreateOper(String createOper) {
        this.createOper = createOper == null ? null : createOper.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_user_favorite_table
     *
     * @mbg.generated Sun Dec 02 15:46:24 CST 2018
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
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
     * @mbg.generated Sun Dec 02 15:46:24 CST 2018
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
}