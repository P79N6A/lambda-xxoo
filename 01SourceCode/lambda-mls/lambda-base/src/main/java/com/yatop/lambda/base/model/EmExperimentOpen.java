package com.yatop.lambda.base.model;

import com.alibaba.fastjson.JSONObject;
import com.yatop.lambda.base.utils.LambdaRootModel;
import java.io.Serializable;
import java.util.Date;

public class EmExperimentOpen extends LambdaRootModel implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column em_experiment_open.EXPERIMENT_ID
     *
     * @mbg.generated Thu Mar 07 20:56:58 CST 2019
     */
    private Long experimentId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column em_experiment_open.EXPERIMENT_ID:Coloured
     *
     * @mbg.generated Thu Mar 07 20:56:58 CST 2019
     */
    private boolean experimentIdColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column em_experiment_open.PROJECT_ID
     *
     * @mbg.generated Thu Mar 07 20:56:58 CST 2019
     */
    private Long projectId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column em_experiment_open.PROJECT_ID:Coloured
     *
     * @mbg.generated Thu Mar 07 20:56:58 CST 2019
     */
    private boolean projectIdColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column em_experiment_open.USER_NAME
     *
     * @mbg.generated Thu Mar 07 20:56:58 CST 2019
     */
    private String userName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column em_experiment_open.USER_NAME:Coloured
     *
     * @mbg.generated Thu Mar 07 20:56:58 CST 2019
     */
    private boolean userNameColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column em_experiment_open.OPEN_STATE
     *
     * @mbg.generated Thu Mar 07 20:56:58 CST 2019
     */
    private Integer openState;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column em_experiment_open.OPEN_STATE:Coloured
     *
     * @mbg.generated Thu Mar 07 20:56:58 CST 2019
     */
    private boolean openStateColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column em_experiment_open.LAST_UPDATE_TIME
     *
     * @mbg.generated Thu Mar 07 20:56:58 CST 2019
     */
    private Date lastUpdateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column em_experiment_open.LAST_UPDATE_TIME:Coloured
     *
     * @mbg.generated Thu Mar 07 20:56:58 CST 2019
     */
    private boolean lastUpdateTimeColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column em_experiment_open.LAST_UPDATE_OPER
     *
     * @mbg.generated Thu Mar 07 20:56:58 CST 2019
     */
    private String lastUpdateOper;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column em_experiment_open.LAST_UPDATE_OPER:Coloured
     *
     * @mbg.generated Thu Mar 07 20:56:58 CST 2019
     */
    private boolean lastUpdateOperColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column em_experiment_open.CREATE_TIME
     *
     * @mbg.generated Thu Mar 07 20:56:58 CST 2019
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column em_experiment_open.CREATE_TIME:Coloured
     *
     * @mbg.generated Thu Mar 07 20:56:58 CST 2019
     */
    private boolean createTimeColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column em_experiment_open.CREATE_OPER
     *
     * @mbg.generated Thu Mar 07 20:56:58 CST 2019
     */
    private String createOper;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column em_experiment_open.CREATE_OPER:Coloured
     *
     * @mbg.generated Thu Mar 07 20:56:58 CST 2019
     */
    private boolean createOperColoured;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table em_experiment_open
     *
     * @mbg.generated Thu Mar 07 20:56:58 CST 2019
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column em_experiment_open.EXPERIMENT_ID
     *
     * @return the value of em_experiment_open.EXPERIMENT_ID
     *
     * @mbg.generated Thu Mar 07 20:56:58 CST 2019
     */
    public Long getExperimentId() {
        return experimentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column em_experiment_open.EXPERIMENT_ID:Coloured
     *
     * @return the value of em_experiment_open.EXPERIMENT_ID:Coloured
     *
     * @mbg.generated Thu Mar 07 20:56:58 CST 2019
     */
    public boolean isExperimentIdColoured() {
        return experimentIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column em_experiment_open.EXPERIMENT_ID:Coloured
     *
     * @return the value of em_experiment_open.EXPERIMENT_ID:Coloured
     *
     * @mbg.generated Thu Mar 07 20:56:58 CST 2019
     */
    public boolean isExperimentIdNotColoured() {
        return !experimentIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column em_experiment_open.EXPERIMENT_ID
     *
     * @param experimentId the value for em_experiment_open.EXPERIMENT_ID
     *
     * @mbg.generated Thu Mar 07 20:56:58 CST 2019
     */
    public void setExperimentId(Long experimentId) {
        this.experimentId = experimentId;
        this.experimentIdColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column em_experiment_open.EXPERIMENT_ID:Coloured
     *
     * @param experimentIdColoured the value for em_experiment_open.EXPERIMENT_ID:Coloured
     *
     * @mbg.generated Thu Mar 07 20:56:58 CST 2019
     */
    public void setExperimentIdColoured(boolean experimentIdColoured) {
        this.experimentIdColoured = experimentIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column em_experiment_open.PROJECT_ID
     *
     * @return the value of em_experiment_open.PROJECT_ID
     *
     * @mbg.generated Thu Mar 07 20:56:58 CST 2019
     */
    public Long getProjectId() {
        return projectId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column em_experiment_open.PROJECT_ID:Coloured
     *
     * @return the value of em_experiment_open.PROJECT_ID:Coloured
     *
     * @mbg.generated Thu Mar 07 20:56:58 CST 2019
     */
    public boolean isProjectIdColoured() {
        return projectIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column em_experiment_open.PROJECT_ID:Coloured
     *
     * @return the value of em_experiment_open.PROJECT_ID:Coloured
     *
     * @mbg.generated Thu Mar 07 20:56:58 CST 2019
     */
    public boolean isProjectIdNotColoured() {
        return !projectIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column em_experiment_open.PROJECT_ID
     *
     * @param projectId the value for em_experiment_open.PROJECT_ID
     *
     * @mbg.generated Thu Mar 07 20:56:58 CST 2019
     */
    public void setProjectId(Long projectId) {
        this.projectId = projectId;
        this.projectIdColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column em_experiment_open.PROJECT_ID:Coloured
     *
     * @param projectIdColoured the value for em_experiment_open.PROJECT_ID:Coloured
     *
     * @mbg.generated Thu Mar 07 20:56:58 CST 2019
     */
    public void setProjectIdColoured(boolean projectIdColoured) {
        this.projectIdColoured = projectIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column em_experiment_open.USER_NAME
     *
     * @return the value of em_experiment_open.USER_NAME
     *
     * @mbg.generated Thu Mar 07 20:56:58 CST 2019
     */
    public String getUserName() {
        return userName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column em_experiment_open.USER_NAME:Coloured
     *
     * @return the value of em_experiment_open.USER_NAME:Coloured
     *
     * @mbg.generated Thu Mar 07 20:56:58 CST 2019
     */
    public boolean isUserNameColoured() {
        return userNameColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column em_experiment_open.USER_NAME:Coloured
     *
     * @return the value of em_experiment_open.USER_NAME:Coloured
     *
     * @mbg.generated Thu Mar 07 20:56:58 CST 2019
     */
    public boolean isUserNameNotColoured() {
        return !userNameColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column em_experiment_open.USER_NAME
     *
     * @param userName the value for em_experiment_open.USER_NAME
     *
     * @mbg.generated Thu Mar 07 20:56:58 CST 2019
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
        this.userNameColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column em_experiment_open.USER_NAME:Coloured
     *
     * @param userNameColoured the value for em_experiment_open.USER_NAME:Coloured
     *
     * @mbg.generated Thu Mar 07 20:56:58 CST 2019
     */
    public void setUserNameColoured(boolean userNameColoured) {
        this.userNameColoured = userNameColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column em_experiment_open.OPEN_STATE
     *
     * @return the value of em_experiment_open.OPEN_STATE
     *
     * @mbg.generated Thu Mar 07 20:56:58 CST 2019
     */
    public Integer getOpenState() {
        return openState;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column em_experiment_open.OPEN_STATE:Coloured
     *
     * @return the value of em_experiment_open.OPEN_STATE:Coloured
     *
     * @mbg.generated Thu Mar 07 20:56:58 CST 2019
     */
    public boolean isOpenStateColoured() {
        return openStateColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column em_experiment_open.OPEN_STATE:Coloured
     *
     * @return the value of em_experiment_open.OPEN_STATE:Coloured
     *
     * @mbg.generated Thu Mar 07 20:56:58 CST 2019
     */
    public boolean isOpenStateNotColoured() {
        return !openStateColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column em_experiment_open.OPEN_STATE
     *
     * @param openState the value for em_experiment_open.OPEN_STATE
     *
     * @mbg.generated Thu Mar 07 20:56:58 CST 2019
     */
    public void setOpenState(Integer openState) {
        this.openState = openState;
        this.openStateColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column em_experiment_open.OPEN_STATE:Coloured
     *
     * @param openStateColoured the value for em_experiment_open.OPEN_STATE:Coloured
     *
     * @mbg.generated Thu Mar 07 20:56:58 CST 2019
     */
    public void setOpenStateColoured(boolean openStateColoured) {
        this.openStateColoured = openStateColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column em_experiment_open.LAST_UPDATE_TIME
     *
     * @return the value of em_experiment_open.LAST_UPDATE_TIME
     *
     * @mbg.generated Thu Mar 07 20:56:58 CST 2019
     */
    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column em_experiment_open.LAST_UPDATE_TIME:Coloured
     *
     * @return the value of em_experiment_open.LAST_UPDATE_TIME:Coloured
     *
     * @mbg.generated Thu Mar 07 20:56:58 CST 2019
     */
    public boolean isLastUpdateTimeColoured() {
        return lastUpdateTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column em_experiment_open.LAST_UPDATE_TIME:Coloured
     *
     * @return the value of em_experiment_open.LAST_UPDATE_TIME:Coloured
     *
     * @mbg.generated Thu Mar 07 20:56:58 CST 2019
     */
    public boolean isLastUpdateTimeNotColoured() {
        return !lastUpdateTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column em_experiment_open.LAST_UPDATE_TIME
     *
     * @param lastUpdateTime the value for em_experiment_open.LAST_UPDATE_TIME
     *
     * @mbg.generated Thu Mar 07 20:56:58 CST 2019
     */
    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
        this.lastUpdateTimeColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column em_experiment_open.LAST_UPDATE_TIME:Coloured
     *
     * @param lastUpdateTimeColoured the value for em_experiment_open.LAST_UPDATE_TIME:Coloured
     *
     * @mbg.generated Thu Mar 07 20:56:58 CST 2019
     */
    public void setLastUpdateTimeColoured(boolean lastUpdateTimeColoured) {
        this.lastUpdateTimeColoured = lastUpdateTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column em_experiment_open.LAST_UPDATE_OPER
     *
     * @return the value of em_experiment_open.LAST_UPDATE_OPER
     *
     * @mbg.generated Thu Mar 07 20:56:58 CST 2019
     */
    public String getLastUpdateOper() {
        return lastUpdateOper;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column em_experiment_open.LAST_UPDATE_OPER:Coloured
     *
     * @return the value of em_experiment_open.LAST_UPDATE_OPER:Coloured
     *
     * @mbg.generated Thu Mar 07 20:56:58 CST 2019
     */
    public boolean isLastUpdateOperColoured() {
        return lastUpdateOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column em_experiment_open.LAST_UPDATE_OPER:Coloured
     *
     * @return the value of em_experiment_open.LAST_UPDATE_OPER:Coloured
     *
     * @mbg.generated Thu Mar 07 20:56:58 CST 2019
     */
    public boolean isLastUpdateOperNotColoured() {
        return !lastUpdateOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column em_experiment_open.LAST_UPDATE_OPER
     *
     * @param lastUpdateOper the value for em_experiment_open.LAST_UPDATE_OPER
     *
     * @mbg.generated Thu Mar 07 20:56:58 CST 2019
     */
    public void setLastUpdateOper(String lastUpdateOper) {
        this.lastUpdateOper = lastUpdateOper == null ? null : lastUpdateOper.trim();
        this.lastUpdateOperColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column em_experiment_open.LAST_UPDATE_OPER:Coloured
     *
     * @param lastUpdateOperColoured the value for em_experiment_open.LAST_UPDATE_OPER:Coloured
     *
     * @mbg.generated Thu Mar 07 20:56:58 CST 2019
     */
    public void setLastUpdateOperColoured(boolean lastUpdateOperColoured) {
        this.lastUpdateOperColoured = lastUpdateOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column em_experiment_open.CREATE_TIME
     *
     * @return the value of em_experiment_open.CREATE_TIME
     *
     * @mbg.generated Thu Mar 07 20:56:58 CST 2019
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column em_experiment_open.CREATE_TIME:Coloured
     *
     * @return the value of em_experiment_open.CREATE_TIME:Coloured
     *
     * @mbg.generated Thu Mar 07 20:56:58 CST 2019
     */
    public boolean isCreateTimeColoured() {
        return createTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column em_experiment_open.CREATE_TIME:Coloured
     *
     * @return the value of em_experiment_open.CREATE_TIME:Coloured
     *
     * @mbg.generated Thu Mar 07 20:56:58 CST 2019
     */
    public boolean isCreateTimeNotColoured() {
        return !createTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column em_experiment_open.CREATE_TIME
     *
     * @param createTime the value for em_experiment_open.CREATE_TIME
     *
     * @mbg.generated Thu Mar 07 20:56:58 CST 2019
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
        this.createTimeColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column em_experiment_open.CREATE_TIME:Coloured
     *
     * @param createTimeColoured the value for em_experiment_open.CREATE_TIME:Coloured
     *
     * @mbg.generated Thu Mar 07 20:56:58 CST 2019
     */
    public void setCreateTimeColoured(boolean createTimeColoured) {
        this.createTimeColoured = createTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column em_experiment_open.CREATE_OPER
     *
     * @return the value of em_experiment_open.CREATE_OPER
     *
     * @mbg.generated Thu Mar 07 20:56:58 CST 2019
     */
    public String getCreateOper() {
        return createOper;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column em_experiment_open.CREATE_OPER:Coloured
     *
     * @return the value of em_experiment_open.CREATE_OPER:Coloured
     *
     * @mbg.generated Thu Mar 07 20:56:58 CST 2019
     */
    public boolean isCreateOperColoured() {
        return createOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column em_experiment_open.CREATE_OPER:Coloured
     *
     * @return the value of em_experiment_open.CREATE_OPER:Coloured
     *
     * @mbg.generated Thu Mar 07 20:56:58 CST 2019
     */
    public boolean isCreateOperNotColoured() {
        return !createOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column em_experiment_open.CREATE_OPER
     *
     * @param createOper the value for em_experiment_open.CREATE_OPER
     *
     * @mbg.generated Thu Mar 07 20:56:58 CST 2019
     */
    public void setCreateOper(String createOper) {
        this.createOper = createOper == null ? null : createOper.trim();
        this.createOperColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column em_experiment_open.CREATE_OPER:Coloured
     *
     * @param createOperColoured the value for em_experiment_open.CREATE_OPER:Coloured
     *
     * @mbg.generated Thu Mar 07 20:56:58 CST 2019
     */
    public void setCreateOperColoured(boolean createOperColoured) {
        this.createOperColoured = createOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table em_experiment_open
     *
     * @mbg.generated Thu Mar 07 20:56:58 CST 2019
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if(!(that instanceof EmExperimentOpen)) {
            return false;
        }
        EmExperimentOpen other = (EmExperimentOpen) that;
        return (this.getExperimentId() == null ? other.getExperimentId() == null : this.getExperimentId().equals(other.getExperimentId()))
            && (this.getProjectId() == null ? other.getProjectId() == null : this.getProjectId().equals(other.getProjectId()))
            && (this.getUserName() == null ? other.getUserName() == null : this.getUserName().equals(other.getUserName()))
            && (this.getOpenState() == null ? other.getOpenState() == null : this.getOpenState().equals(other.getOpenState()))
            && (this.getLastUpdateTime() == null ? other.getLastUpdateTime() == null : this.getLastUpdateTime().equals(other.getLastUpdateTime()))
            && (this.getLastUpdateOper() == null ? other.getLastUpdateOper() == null : this.getLastUpdateOper().equals(other.getLastUpdateOper()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getCreateOper() == null ? other.getCreateOper() == null : this.getCreateOper().equals(other.getCreateOper()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table em_experiment_open
     *
     * @mbg.generated Thu Mar 07 20:56:58 CST 2019
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getExperimentId() == null) ? 0 : getExperimentId().hashCode());
        result = prime * result + ((getProjectId() == null) ? 0 : getProjectId().hashCode());
        result = prime * result + ((getUserName() == null) ? 0 : getUserName().hashCode());
        result = prime * result + ((getOpenState() == null) ? 0 : getOpenState().hashCode());
        result = prime * result + ((getLastUpdateTime() == null) ? 0 : getLastUpdateTime().hashCode());
        result = prime * result + ((getLastUpdateOper() == null) ? 0 : getLastUpdateOper().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCreateOper() == null) ? 0 : getCreateOper().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table em_experiment_open
     *
     * @mbg.generated Thu Mar 07 20:56:58 CST 2019
     */
    public void copyProperties(EmExperimentOpen that) {
        if (this == that || that == null) {
            return;
        }
        if(that.isExperimentIdColoured() ) {this.setExperimentId(that.getExperimentId() );}
        if(that.isProjectIdColoured() ) {this.setProjectId(that.getProjectId() );}
        if(that.isUserNameColoured() ) {this.setUserName(that.getUserName() );}
        if(that.isOpenStateColoured() ) {this.setOpenState(that.getOpenState() );}
        if(that.isLastUpdateTimeColoured() ) {this.setLastUpdateTime(that.getLastUpdateTime() );}
        if(that.isLastUpdateOperColoured() ) {this.setLastUpdateOper(that.getLastUpdateOper() );}
        if(that.isCreateTimeColoured() ) {this.setCreateTime(that.getCreateTime() );}
        if(that.isCreateOperColoured() ) {this.setCreateOper(that.getCreateOper() );}
        return;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table em_experiment_open
     *
     * @mbg.generated Thu Mar 07 20:56:58 CST 2019
     */
    public EmExperimentOpen makeCopy() {
        EmExperimentOpen copy = new EmExperimentOpen();
        if(this.experimentId != null ) {copy.experimentId = this.experimentId;}
        if(this.projectId != null ) {copy.projectId = this.projectId;}
        if(this.userName != null ) {copy.userName = this.userName;}
        if(this.openState != null ) {copy.openState = this.openState;}
        if(this.lastUpdateTime != null ) {copy.lastUpdateTime = this.lastUpdateTime;}
        if(this.lastUpdateOper != null ) {copy.lastUpdateOper = this.lastUpdateOper;}
        if(this.createTime != null ) {copy.createTime = this.createTime;}
        if(this.createOper != null ) {copy.createOper = this.createOper;}
        return copy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table em_experiment_open
     *
     * @mbg.generated Thu Mar 07 20:56:58 CST 2019
     */
    @Override
    public JSONObject toJSON() {
        JSONObject jsonObj = new JSONObject(32, true);
        if(this.experimentId != null) {jsonObj.put("experimentId", this.experimentId);}
        if(this.projectId != null) {jsonObj.put("projectId", this.projectId);}
        if(this.userName != null) {jsonObj.put("userName", this.userName);}
        if(this.openState != null) {jsonObj.put("openState", this.openState);}
        if(this.lastUpdateTime != null) {jsonObj.put("lastUpdateTime", this.lastUpdateTime);}
        if(this.lastUpdateOper != null) {jsonObj.put("lastUpdateOper", this.lastUpdateOper);}
        if(this.createTime != null) {jsonObj.put("createTime", this.createTime);}
        if(this.createOper != null) {jsonObj.put("createOper", this.createOper);}
        return jsonObj;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table em_experiment_open
     *
     * @mbg.generated Thu Mar 07 20:56:58 CST 2019
     */
    @Override
    public void clear() {
         this.experimentId = null; this.experimentIdColoured = false;
         this.projectId = null; this.projectIdColoured = false;
         this.userName = null; this.userNameColoured = false;
         this.openState = null; this.openStateColoured = false;
         this.lastUpdateTime = null; this.lastUpdateTimeColoured = false;
         this.lastUpdateOper = null; this.lastUpdateOperColoured = false;
         this.createTime = null; this.createTimeColoured = false;
         this.createOper = null; this.createOperColoured = false;
        return;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table em_experiment_open
     *
     * @mbg.generated Thu Mar 07 20:56:58 CST 2019
     */
    @Override
    public void clearColoured() {
        this.experimentIdColoured = false;
        this.projectIdColoured = false;
        this.userNameColoured = false;
        this.openStateColoured = false;
        this.lastUpdateTimeColoured = false;
        this.lastUpdateOperColoured = false;
        this.createTimeColoured = false;
        this.createOperColoured = false;
        return;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table em_experiment_open
     *
     * @mbg.generated Thu Mar 07 20:56:58 CST 2019
     */
    @Override
    public boolean isColoured() {
        if(this.experimentIdColoured) return true;
        if(this.projectIdColoured) return true;
        if(this.userNameColoured) return true;
        if(this.openStateColoured) return true;
        if(this.lastUpdateTimeColoured) return true;
        if(this.lastUpdateOperColoured) return true;
        if(this.createTimeColoured) return true;
        if(this.createOperColoured) return true;
        return false;
    }
}