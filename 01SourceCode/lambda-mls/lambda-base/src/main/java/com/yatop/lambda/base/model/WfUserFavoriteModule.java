package com.yatop.lambda.base.model;

import com.alibaba.fastjson.JSONObject;
import com.yatop.lambda.base.utils.LambdaRootModel;
import java.io.Serializable;
import java.util.Date;

public class WfUserFavoriteModule extends LambdaRootModel implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_user_favorite_module.PROJECT_ID
     *
     * @mbg.generated Mon Dec 31 14:57:25 CST 2018
     */
    private Long projectId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_user_favorite_module.PROJECT_ID:Coloured
     *
     * @mbg.generated Mon Dec 31 14:57:25 CST 2018
     */
    private boolean projectIdColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_user_favorite_module.OPER_ID
     *
     * @mbg.generated Mon Dec 31 14:57:25 CST 2018
     */
    private String operId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_user_favorite_module.OPER_ID:Coloured
     *
     * @mbg.generated Mon Dec 31 14:57:25 CST 2018
     */
    private boolean operIdColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_user_favorite_module.MODULE_ID
     *
     * @mbg.generated Mon Dec 31 14:57:25 CST 2018
     */
    private Long moduleId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_user_favorite_module.MODULE_ID:Coloured
     *
     * @mbg.generated Mon Dec 31 14:57:25 CST 2018
     */
    private boolean moduleIdColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_user_favorite_module.DESCRIPTION
     *
     * @mbg.generated Mon Dec 31 14:57:25 CST 2018
     */
    private String description;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_user_favorite_module.DESCRIPTION:Coloured
     *
     * @mbg.generated Mon Dec 31 14:57:25 CST 2018
     */
    private boolean descriptionColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_user_favorite_module.STATUS
     *
     * @mbg.generated Mon Dec 31 14:57:25 CST 2018
     */
    private Integer status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_user_favorite_module.STATUS:Coloured
     *
     * @mbg.generated Mon Dec 31 14:57:25 CST 2018
     */
    private boolean statusColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_user_favorite_module.LAST_UPDATE_TIME
     *
     * @mbg.generated Mon Dec 31 14:57:25 CST 2018
     */
    private Date lastUpdateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_user_favorite_module.LAST_UPDATE_TIME:Coloured
     *
     * @mbg.generated Mon Dec 31 14:57:25 CST 2018
     */
    private boolean lastUpdateTimeColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_user_favorite_module.LAST_UPDATE_OPER
     *
     * @mbg.generated Mon Dec 31 14:57:25 CST 2018
     */
    private String lastUpdateOper;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_user_favorite_module.LAST_UPDATE_OPER:Coloured
     *
     * @mbg.generated Mon Dec 31 14:57:25 CST 2018
     */
    private boolean lastUpdateOperColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_user_favorite_module.CREATE_TIME
     *
     * @mbg.generated Mon Dec 31 14:57:25 CST 2018
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_user_favorite_module.CREATE_TIME:Coloured
     *
     * @mbg.generated Mon Dec 31 14:57:25 CST 2018
     */
    private boolean createTimeColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_user_favorite_module.CREATE_OPER
     *
     * @mbg.generated Mon Dec 31 14:57:25 CST 2018
     */
    private String createOper;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_user_favorite_module.CREATE_OPER:Coloured
     *
     * @mbg.generated Mon Dec 31 14:57:25 CST 2018
     */
    private boolean createOperColoured;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table wf_user_favorite_module
     *
     * @mbg.generated Mon Dec 31 14:57:25 CST 2018
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_user_favorite_module.PROJECT_ID
     *
     * @return the value of wf_user_favorite_module.PROJECT_ID
     *
     * @mbg.generated Mon Dec 31 14:57:25 CST 2018
     */
    public Long getProjectId() {
        return projectId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_user_favorite_module.PROJECT_ID:Coloured
     *
     * @return the value of wf_user_favorite_module.PROJECT_ID:Coloured
     *
     * @mbg.generated Mon Dec 31 14:57:25 CST 2018
     */
    public boolean isProjectIdColoured() {
        return projectIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_user_favorite_module.PROJECT_ID:Coloured
     *
     * @return the value of wf_user_favorite_module.PROJECT_ID:Coloured
     *
     * @mbg.generated Mon Dec 31 14:57:25 CST 2018
     */
    public boolean isProjectIdNotColoured() {
        return !projectIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_user_favorite_module.PROJECT_ID
     *
     * @param projectId the value for wf_user_favorite_module.PROJECT_ID
     *
     * @mbg.generated Mon Dec 31 14:57:25 CST 2018
     */
    public void setProjectId(Long projectId) {
        this.projectId = projectId;
        this.projectIdColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_user_favorite_module.PROJECT_ID:Coloured
     *
     * @param projectIdColoured the value for wf_user_favorite_module.PROJECT_ID:Coloured
     *
     * @mbg.generated Mon Dec 31 14:57:25 CST 2018
     */
    public void setProjectIdColoured(boolean projectIdColoured) {
        this.projectIdColoured = projectIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_user_favorite_module.OPER_ID
     *
     * @return the value of wf_user_favorite_module.OPER_ID
     *
     * @mbg.generated Mon Dec 31 14:57:25 CST 2018
     */
    public String getOperId() {
        return operId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_user_favorite_module.OPER_ID:Coloured
     *
     * @return the value of wf_user_favorite_module.OPER_ID:Coloured
     *
     * @mbg.generated Mon Dec 31 14:57:25 CST 2018
     */
    public boolean isOperIdColoured() {
        return operIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_user_favorite_module.OPER_ID:Coloured
     *
     * @return the value of wf_user_favorite_module.OPER_ID:Coloured
     *
     * @mbg.generated Mon Dec 31 14:57:25 CST 2018
     */
    public boolean isOperIdNotColoured() {
        return !operIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_user_favorite_module.OPER_ID
     *
     * @param operId the value for wf_user_favorite_module.OPER_ID
     *
     * @mbg.generated Mon Dec 31 14:57:25 CST 2018
     */
    public void setOperId(String operId) {
        this.operId = operId == null ? null : operId.trim();
        this.operIdColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_user_favorite_module.OPER_ID:Coloured
     *
     * @param operIdColoured the value for wf_user_favorite_module.OPER_ID:Coloured
     *
     * @mbg.generated Mon Dec 31 14:57:25 CST 2018
     */
    public void setOperIdColoured(boolean operIdColoured) {
        this.operIdColoured = operIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_user_favorite_module.MODULE_ID
     *
     * @return the value of wf_user_favorite_module.MODULE_ID
     *
     * @mbg.generated Mon Dec 31 14:57:25 CST 2018
     */
    public Long getModuleId() {
        return moduleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_user_favorite_module.MODULE_ID:Coloured
     *
     * @return the value of wf_user_favorite_module.MODULE_ID:Coloured
     *
     * @mbg.generated Mon Dec 31 14:57:25 CST 2018
     */
    public boolean isModuleIdColoured() {
        return moduleIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_user_favorite_module.MODULE_ID:Coloured
     *
     * @return the value of wf_user_favorite_module.MODULE_ID:Coloured
     *
     * @mbg.generated Mon Dec 31 14:57:25 CST 2018
     */
    public boolean isModuleIdNotColoured() {
        return !moduleIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_user_favorite_module.MODULE_ID
     *
     * @param moduleId the value for wf_user_favorite_module.MODULE_ID
     *
     * @mbg.generated Mon Dec 31 14:57:25 CST 2018
     */
    public void setModuleId(Long moduleId) {
        this.moduleId = moduleId;
        this.moduleIdColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_user_favorite_module.MODULE_ID:Coloured
     *
     * @param moduleIdColoured the value for wf_user_favorite_module.MODULE_ID:Coloured
     *
     * @mbg.generated Mon Dec 31 14:57:25 CST 2018
     */
    public void setModuleIdColoured(boolean moduleIdColoured) {
        this.moduleIdColoured = moduleIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_user_favorite_module.DESCRIPTION
     *
     * @return the value of wf_user_favorite_module.DESCRIPTION
     *
     * @mbg.generated Mon Dec 31 14:57:25 CST 2018
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_user_favorite_module.DESCRIPTION:Coloured
     *
     * @return the value of wf_user_favorite_module.DESCRIPTION:Coloured
     *
     * @mbg.generated Mon Dec 31 14:57:25 CST 2018
     */
    public boolean isDescriptionColoured() {
        return descriptionColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_user_favorite_module.DESCRIPTION:Coloured
     *
     * @return the value of wf_user_favorite_module.DESCRIPTION:Coloured
     *
     * @mbg.generated Mon Dec 31 14:57:25 CST 2018
     */
    public boolean isDescriptionNotColoured() {
        return !descriptionColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_user_favorite_module.DESCRIPTION
     *
     * @param description the value for wf_user_favorite_module.DESCRIPTION
     *
     * @mbg.generated Mon Dec 31 14:57:25 CST 2018
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
        this.descriptionColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_user_favorite_module.DESCRIPTION:Coloured
     *
     * @param descriptionColoured the value for wf_user_favorite_module.DESCRIPTION:Coloured
     *
     * @mbg.generated Mon Dec 31 14:57:25 CST 2018
     */
    public void setDescriptionColoured(boolean descriptionColoured) {
        this.descriptionColoured = descriptionColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_user_favorite_module.STATUS
     *
     * @return the value of wf_user_favorite_module.STATUS
     *
     * @mbg.generated Mon Dec 31 14:57:25 CST 2018
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_user_favorite_module.STATUS:Coloured
     *
     * @return the value of wf_user_favorite_module.STATUS:Coloured
     *
     * @mbg.generated Mon Dec 31 14:57:25 CST 2018
     */
    public boolean isStatusColoured() {
        return statusColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_user_favorite_module.STATUS:Coloured
     *
     * @return the value of wf_user_favorite_module.STATUS:Coloured
     *
     * @mbg.generated Mon Dec 31 14:57:25 CST 2018
     */
    public boolean isStatusNotColoured() {
        return !statusColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_user_favorite_module.STATUS
     *
     * @param status the value for wf_user_favorite_module.STATUS
     *
     * @mbg.generated Mon Dec 31 14:57:25 CST 2018
     */
    public void setStatus(Integer status) {
        this.status = status;
        this.statusColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_user_favorite_module.STATUS:Coloured
     *
     * @param statusColoured the value for wf_user_favorite_module.STATUS:Coloured
     *
     * @mbg.generated Mon Dec 31 14:57:25 CST 2018
     */
    public void setStatusColoured(boolean statusColoured) {
        this.statusColoured = statusColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_user_favorite_module.LAST_UPDATE_TIME
     *
     * @return the value of wf_user_favorite_module.LAST_UPDATE_TIME
     *
     * @mbg.generated Mon Dec 31 14:57:25 CST 2018
     */
    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_user_favorite_module.LAST_UPDATE_TIME:Coloured
     *
     * @return the value of wf_user_favorite_module.LAST_UPDATE_TIME:Coloured
     *
     * @mbg.generated Mon Dec 31 14:57:25 CST 2018
     */
    public boolean isLastUpdateTimeColoured() {
        return lastUpdateTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_user_favorite_module.LAST_UPDATE_TIME:Coloured
     *
     * @return the value of wf_user_favorite_module.LAST_UPDATE_TIME:Coloured
     *
     * @mbg.generated Mon Dec 31 14:57:25 CST 2018
     */
    public boolean isLastUpdateTimeNotColoured() {
        return !lastUpdateTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_user_favorite_module.LAST_UPDATE_TIME
     *
     * @param lastUpdateTime the value for wf_user_favorite_module.LAST_UPDATE_TIME
     *
     * @mbg.generated Mon Dec 31 14:57:25 CST 2018
     */
    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
        this.lastUpdateTimeColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_user_favorite_module.LAST_UPDATE_TIME:Coloured
     *
     * @param lastUpdateTimeColoured the value for wf_user_favorite_module.LAST_UPDATE_TIME:Coloured
     *
     * @mbg.generated Mon Dec 31 14:57:25 CST 2018
     */
    public void setLastUpdateTimeColoured(boolean lastUpdateTimeColoured) {
        this.lastUpdateTimeColoured = lastUpdateTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_user_favorite_module.LAST_UPDATE_OPER
     *
     * @return the value of wf_user_favorite_module.LAST_UPDATE_OPER
     *
     * @mbg.generated Mon Dec 31 14:57:25 CST 2018
     */
    public String getLastUpdateOper() {
        return lastUpdateOper;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_user_favorite_module.LAST_UPDATE_OPER:Coloured
     *
     * @return the value of wf_user_favorite_module.LAST_UPDATE_OPER:Coloured
     *
     * @mbg.generated Mon Dec 31 14:57:25 CST 2018
     */
    public boolean isLastUpdateOperColoured() {
        return lastUpdateOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_user_favorite_module.LAST_UPDATE_OPER:Coloured
     *
     * @return the value of wf_user_favorite_module.LAST_UPDATE_OPER:Coloured
     *
     * @mbg.generated Mon Dec 31 14:57:25 CST 2018
     */
    public boolean isLastUpdateOperNotColoured() {
        return !lastUpdateOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_user_favorite_module.LAST_UPDATE_OPER
     *
     * @param lastUpdateOper the value for wf_user_favorite_module.LAST_UPDATE_OPER
     *
     * @mbg.generated Mon Dec 31 14:57:25 CST 2018
     */
    public void setLastUpdateOper(String lastUpdateOper) {
        this.lastUpdateOper = lastUpdateOper == null ? null : lastUpdateOper.trim();
        this.lastUpdateOperColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_user_favorite_module.LAST_UPDATE_OPER:Coloured
     *
     * @param lastUpdateOperColoured the value for wf_user_favorite_module.LAST_UPDATE_OPER:Coloured
     *
     * @mbg.generated Mon Dec 31 14:57:25 CST 2018
     */
    public void setLastUpdateOperColoured(boolean lastUpdateOperColoured) {
        this.lastUpdateOperColoured = lastUpdateOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_user_favorite_module.CREATE_TIME
     *
     * @return the value of wf_user_favorite_module.CREATE_TIME
     *
     * @mbg.generated Mon Dec 31 14:57:25 CST 2018
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_user_favorite_module.CREATE_TIME:Coloured
     *
     * @return the value of wf_user_favorite_module.CREATE_TIME:Coloured
     *
     * @mbg.generated Mon Dec 31 14:57:25 CST 2018
     */
    public boolean isCreateTimeColoured() {
        return createTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_user_favorite_module.CREATE_TIME:Coloured
     *
     * @return the value of wf_user_favorite_module.CREATE_TIME:Coloured
     *
     * @mbg.generated Mon Dec 31 14:57:25 CST 2018
     */
    public boolean isCreateTimeNotColoured() {
        return !createTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_user_favorite_module.CREATE_TIME
     *
     * @param createTime the value for wf_user_favorite_module.CREATE_TIME
     *
     * @mbg.generated Mon Dec 31 14:57:25 CST 2018
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
        this.createTimeColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_user_favorite_module.CREATE_TIME:Coloured
     *
     * @param createTimeColoured the value for wf_user_favorite_module.CREATE_TIME:Coloured
     *
     * @mbg.generated Mon Dec 31 14:57:25 CST 2018
     */
    public void setCreateTimeColoured(boolean createTimeColoured) {
        this.createTimeColoured = createTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_user_favorite_module.CREATE_OPER
     *
     * @return the value of wf_user_favorite_module.CREATE_OPER
     *
     * @mbg.generated Mon Dec 31 14:57:25 CST 2018
     */
    public String getCreateOper() {
        return createOper;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_user_favorite_module.CREATE_OPER:Coloured
     *
     * @return the value of wf_user_favorite_module.CREATE_OPER:Coloured
     *
     * @mbg.generated Mon Dec 31 14:57:25 CST 2018
     */
    public boolean isCreateOperColoured() {
        return createOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_user_favorite_module.CREATE_OPER:Coloured
     *
     * @return the value of wf_user_favorite_module.CREATE_OPER:Coloured
     *
     * @mbg.generated Mon Dec 31 14:57:25 CST 2018
     */
    public boolean isCreateOperNotColoured() {
        return !createOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_user_favorite_module.CREATE_OPER
     *
     * @param createOper the value for wf_user_favorite_module.CREATE_OPER
     *
     * @mbg.generated Mon Dec 31 14:57:25 CST 2018
     */
    public void setCreateOper(String createOper) {
        this.createOper = createOper == null ? null : createOper.trim();
        this.createOperColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_user_favorite_module.CREATE_OPER:Coloured
     *
     * @param createOperColoured the value for wf_user_favorite_module.CREATE_OPER:Coloured
     *
     * @mbg.generated Mon Dec 31 14:57:25 CST 2018
     */
    public void setCreateOperColoured(boolean createOperColoured) {
        this.createOperColoured = createOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_user_favorite_module
     *
     * @mbg.generated Mon Dec 31 14:57:25 CST 2018
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if(!(that instanceof WfUserFavoriteModule)) {
            return false;
        }
        WfUserFavoriteModule other = (WfUserFavoriteModule) that;
        return (this.getProjectId() == null ? other.getProjectId() == null : this.getProjectId().equals(other.getProjectId()))
            && (this.getOperId() == null ? other.getOperId() == null : this.getOperId().equals(other.getOperId()))
            && (this.getModuleId() == null ? other.getModuleId() == null : this.getModuleId().equals(other.getModuleId()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getLastUpdateTime() == null ? other.getLastUpdateTime() == null : this.getLastUpdateTime().equals(other.getLastUpdateTime()))
            && (this.getLastUpdateOper() == null ? other.getLastUpdateOper() == null : this.getLastUpdateOper().equals(other.getLastUpdateOper()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getCreateOper() == null ? other.getCreateOper() == null : this.getCreateOper().equals(other.getCreateOper()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_user_favorite_module
     *
     * @mbg.generated Mon Dec 31 14:57:25 CST 2018
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getProjectId() == null) ? 0 : getProjectId().hashCode());
        result = prime * result + ((getOperId() == null) ? 0 : getOperId().hashCode());
        result = prime * result + ((getModuleId() == null) ? 0 : getModuleId().hashCode());
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
     * This method corresponds to the database table wf_user_favorite_module
     *
     * @mbg.generated Mon Dec 31 14:57:25 CST 2018
     */
    public void copyProperties(WfUserFavoriteModule that) {
        if (this == that || that == null) {
            return;
        }
        if(that.isProjectIdColoured() ) {this.setProjectId(that.getProjectId() );}
        if(that.isOperIdColoured() ) {this.setOperId(that.getOperId() );}
        if(that.isModuleIdColoured() ) {this.setModuleId(that.getModuleId() );}
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
     * This method corresponds to the database table wf_user_favorite_module
     *
     * @mbg.generated Mon Dec 31 14:57:25 CST 2018
     */
    @Override
    public JSONObject toJSON() {
        JSONObject jsonObj = new JSONObject(32, true);
        if(this.projectId != null) {jsonObj.put("projectId", this.projectId);}
        if(this.operId != null) {jsonObj.put("operId", this.operId);}
        if(this.moduleId != null) {jsonObj.put("moduleId", this.moduleId);}
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
     * This method corresponds to the database table wf_user_favorite_module
     *
     * @mbg.generated Mon Dec 31 14:57:25 CST 2018
     */
    @Override
    public void clear() {
         this.projectId = null; this.projectIdColoured = false;
         this.operId = null; this.operIdColoured = false;
         this.moduleId = null; this.moduleIdColoured = false;
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
     * This method corresponds to the database table wf_user_favorite_module
     *
     * @mbg.generated Mon Dec 31 14:57:25 CST 2018
     */
    @Override
    public void clearColoured() {
        this.projectIdColoured = false;
        this.operIdColoured = false;
        this.moduleIdColoured = false;
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
     * This method corresponds to the database table wf_user_favorite_module
     *
     * @mbg.generated Mon Dec 31 14:57:25 CST 2018
     */
    @Override
    public boolean isColoured() {
        if(this.projectIdColoured) return true;
        if(this.operIdColoured) return true;
        if(this.moduleIdColoured) return true;
        if(this.descriptionColoured) return true;
        if(this.statusColoured) return true;
        if(this.lastUpdateTimeColoured) return true;
        if(this.lastUpdateOperColoured) return true;
        if(this.createTimeColoured) return true;
        if(this.createOperColoured) return true;
        return false;
    }
}