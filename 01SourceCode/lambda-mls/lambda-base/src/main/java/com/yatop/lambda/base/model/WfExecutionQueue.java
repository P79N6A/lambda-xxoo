package com.yatop.lambda.base.model;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yatop.lambda.base.utils.LambdaRootModel;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;

public class WfExecutionQueue extends LambdaRootModel implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_execution_queue.JOB_ID
     *
     * @mbg.generated Mon Dec 03 11:07:18 CST 2018
     */
    private Long jobId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_execution_queue.JOB_ID:Coloured
     *
     * @mbg.generated Mon Dec 03 11:07:18 CST 2018
     */
    private boolean jobIdColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_execution_queue.OWNER_PROJECT_ID
     *
     * @mbg.generated Mon Dec 03 11:07:18 CST 2018
     */
    private Long ownerProjectId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_execution_queue.OWNER_PROJECT_ID:Coloured
     *
     * @mbg.generated Mon Dec 03 11:07:18 CST 2018
     */
    private boolean ownerProjectIdColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_execution_queue.JOB_TIME
     *
     * @mbg.generated Mon Dec 03 11:07:18 CST 2018
     */
    private Date jobTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_execution_queue.JOB_TIME:Coloured
     *
     * @mbg.generated Mon Dec 03 11:07:18 CST 2018
     */
    private boolean jobTimeColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_execution_queue.JOB_SIGNAL
     *
     * @mbg.generated Mon Dec 03 11:07:18 CST 2018
     */
    private Integer jobSignal;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_execution_queue.JOB_SIGNAL:Coloured
     *
     * @mbg.generated Mon Dec 03 11:07:18 CST 2018
     */
    private boolean jobSignalColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_execution_queue.JOB_STATE
     *
     * @mbg.generated Mon Dec 03 11:07:18 CST 2018
     */
    private Integer jobState;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_execution_queue.JOB_STATE:Coloured
     *
     * @mbg.generated Mon Dec 03 11:07:18 CST 2018
     */
    private boolean jobStateColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_execution_queue.DESCRIPTION
     *
     * @mbg.generated Mon Dec 03 11:07:18 CST 2018
     */
    private String description;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_execution_queue.DESCRIPTION:Coloured
     *
     * @mbg.generated Mon Dec 03 11:07:18 CST 2018
     */
    private boolean descriptionColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_execution_queue.LAST_UPDATE_TIME
     *
     * @mbg.generated Mon Dec 03 11:07:18 CST 2018
     */
    private Date lastUpdateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_execution_queue.LAST_UPDATE_TIME:Coloured
     *
     * @mbg.generated Mon Dec 03 11:07:18 CST 2018
     */
    private boolean lastUpdateTimeColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_execution_queue.LAST_UPDATE_OPER
     *
     * @mbg.generated Mon Dec 03 11:07:18 CST 2018
     */
    private String lastUpdateOper;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_execution_queue.LAST_UPDATE_OPER:Coloured
     *
     * @mbg.generated Mon Dec 03 11:07:18 CST 2018
     */
    private boolean lastUpdateOperColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_execution_queue.CREATE_TIME
     *
     * @mbg.generated Mon Dec 03 11:07:18 CST 2018
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_execution_queue.CREATE_TIME:Coloured
     *
     * @mbg.generated Mon Dec 03 11:07:18 CST 2018
     */
    private boolean createTimeColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_execution_queue.CREATE_OPER
     *
     * @mbg.generated Mon Dec 03 11:07:18 CST 2018
     */
    private String createOper;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_execution_queue.CREATE_OPER:Coloured
     *
     * @mbg.generated Mon Dec 03 11:07:18 CST 2018
     */
    private boolean createOperColoured;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table wf_execution_queue
     *
     * @mbg.generated Mon Dec 03 11:07:18 CST 2018
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_execution_queue.JOB_ID
     *
     * @return the value of wf_execution_queue.JOB_ID
     *
     * @mbg.generated Mon Dec 03 11:07:18 CST 2018
     */
    public Long getJobId() {
        return jobId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_execution_queue.JOB_ID:Coloured
     *
     * @return the value of wf_execution_queue.JOB_ID:Coloured
     *
     * @mbg.generated Mon Dec 03 11:07:18 CST 2018
     */
    public boolean isJobIdColoured() {
        return jobIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_execution_queue.JOB_ID
     *
     * @param jobId the value for wf_execution_queue.JOB_ID
     *
     * @mbg.generated Mon Dec 03 11:07:18 CST 2018
     */
    public void setJobId(Long jobId) {
        this.jobId = jobId;
        this.jobIdColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_execution_queue.JOB_ID:Coloured
     *
     * @param jobIdColoured the value for wf_execution_queue.JOB_ID:Coloured
     *
     * @mbg.generated Mon Dec 03 11:07:18 CST 2018
     */
    public void setJobIdColoured(boolean jobIdColoured) {
        this.jobIdColoured = jobIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_execution_queue.OWNER_PROJECT_ID
     *
     * @return the value of wf_execution_queue.OWNER_PROJECT_ID
     *
     * @mbg.generated Mon Dec 03 11:07:18 CST 2018
     */
    public Long getOwnerProjectId() {
        return ownerProjectId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_execution_queue.OWNER_PROJECT_ID:Coloured
     *
     * @return the value of wf_execution_queue.OWNER_PROJECT_ID:Coloured
     *
     * @mbg.generated Mon Dec 03 11:07:18 CST 2018
     */
    public boolean isOwnerProjectIdColoured() {
        return ownerProjectIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_execution_queue.OWNER_PROJECT_ID
     *
     * @param ownerProjectId the value for wf_execution_queue.OWNER_PROJECT_ID
     *
     * @mbg.generated Mon Dec 03 11:07:18 CST 2018
     */
    public void setOwnerProjectId(Long ownerProjectId) {
        this.ownerProjectId = ownerProjectId;
        this.ownerProjectIdColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_execution_queue.OWNER_PROJECT_ID:Coloured
     *
     * @param ownerProjectIdColoured the value for wf_execution_queue.OWNER_PROJECT_ID:Coloured
     *
     * @mbg.generated Mon Dec 03 11:07:18 CST 2018
     */
    public void setOwnerProjectIdColoured(boolean ownerProjectIdColoured) {
        this.ownerProjectIdColoured = ownerProjectIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_execution_queue.JOB_TIME
     *
     * @return the value of wf_execution_queue.JOB_TIME
     *
     * @mbg.generated Mon Dec 03 11:07:18 CST 2018
     */
    public Date getJobTime() {
        return jobTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_execution_queue.JOB_TIME:Coloured
     *
     * @return the value of wf_execution_queue.JOB_TIME:Coloured
     *
     * @mbg.generated Mon Dec 03 11:07:18 CST 2018
     */
    public boolean isJobTimeColoured() {
        return jobTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_execution_queue.JOB_TIME
     *
     * @param jobTime the value for wf_execution_queue.JOB_TIME
     *
     * @mbg.generated Mon Dec 03 11:07:18 CST 2018
     */
    public void setJobTime(Date jobTime) {
        this.jobTime = jobTime;
        this.jobTimeColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_execution_queue.JOB_TIME:Coloured
     *
     * @param jobTimeColoured the value for wf_execution_queue.JOB_TIME:Coloured
     *
     * @mbg.generated Mon Dec 03 11:07:18 CST 2018
     */
    public void setJobTimeColoured(boolean jobTimeColoured) {
        this.jobTimeColoured = jobTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_execution_queue.JOB_SIGNAL
     *
     * @return the value of wf_execution_queue.JOB_SIGNAL
     *
     * @mbg.generated Mon Dec 03 11:07:18 CST 2018
     */
    public Integer getJobSignal() {
        return jobSignal;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_execution_queue.JOB_SIGNAL:Coloured
     *
     * @return the value of wf_execution_queue.JOB_SIGNAL:Coloured
     *
     * @mbg.generated Mon Dec 03 11:07:18 CST 2018
     */
    public boolean isJobSignalColoured() {
        return jobSignalColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_execution_queue.JOB_SIGNAL
     *
     * @param jobSignal the value for wf_execution_queue.JOB_SIGNAL
     *
     * @mbg.generated Mon Dec 03 11:07:18 CST 2018
     */
    public void setJobSignal(Integer jobSignal) {
        this.jobSignal = jobSignal;
        this.jobSignalColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_execution_queue.JOB_SIGNAL:Coloured
     *
     * @param jobSignalColoured the value for wf_execution_queue.JOB_SIGNAL:Coloured
     *
     * @mbg.generated Mon Dec 03 11:07:18 CST 2018
     */
    public void setJobSignalColoured(boolean jobSignalColoured) {
        this.jobSignalColoured = jobSignalColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_execution_queue.JOB_STATE
     *
     * @return the value of wf_execution_queue.JOB_STATE
     *
     * @mbg.generated Mon Dec 03 11:07:18 CST 2018
     */
    public Integer getJobState() {
        return jobState;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_execution_queue.JOB_STATE:Coloured
     *
     * @return the value of wf_execution_queue.JOB_STATE:Coloured
     *
     * @mbg.generated Mon Dec 03 11:07:18 CST 2018
     */
    public boolean isJobStateColoured() {
        return jobStateColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_execution_queue.JOB_STATE
     *
     * @param jobState the value for wf_execution_queue.JOB_STATE
     *
     * @mbg.generated Mon Dec 03 11:07:18 CST 2018
     */
    public void setJobState(Integer jobState) {
        this.jobState = jobState;
        this.jobStateColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_execution_queue.JOB_STATE:Coloured
     *
     * @param jobStateColoured the value for wf_execution_queue.JOB_STATE:Coloured
     *
     * @mbg.generated Mon Dec 03 11:07:18 CST 2018
     */
    public void setJobStateColoured(boolean jobStateColoured) {
        this.jobStateColoured = jobStateColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_execution_queue.DESCRIPTION
     *
     * @return the value of wf_execution_queue.DESCRIPTION
     *
     * @mbg.generated Mon Dec 03 11:07:18 CST 2018
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_execution_queue.DESCRIPTION:Coloured
     *
     * @return the value of wf_execution_queue.DESCRIPTION:Coloured
     *
     * @mbg.generated Mon Dec 03 11:07:18 CST 2018
     */
    public boolean isDescriptionColoured() {
        return descriptionColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_execution_queue.DESCRIPTION
     *
     * @param description the value for wf_execution_queue.DESCRIPTION
     *
     * @mbg.generated Mon Dec 03 11:07:18 CST 2018
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
        this.descriptionColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_execution_queue.DESCRIPTION:Coloured
     *
     * @param descriptionColoured the value for wf_execution_queue.DESCRIPTION:Coloured
     *
     * @mbg.generated Mon Dec 03 11:07:18 CST 2018
     */
    public void setDescriptionColoured(boolean descriptionColoured) {
        this.descriptionColoured = descriptionColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_execution_queue.LAST_UPDATE_TIME
     *
     * @return the value of wf_execution_queue.LAST_UPDATE_TIME
     *
     * @mbg.generated Mon Dec 03 11:07:18 CST 2018
     */
    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_execution_queue.LAST_UPDATE_TIME:Coloured
     *
     * @return the value of wf_execution_queue.LAST_UPDATE_TIME:Coloured
     *
     * @mbg.generated Mon Dec 03 11:07:18 CST 2018
     */
    public boolean isLastUpdateTimeColoured() {
        return lastUpdateTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_execution_queue.LAST_UPDATE_TIME
     *
     * @param lastUpdateTime the value for wf_execution_queue.LAST_UPDATE_TIME
     *
     * @mbg.generated Mon Dec 03 11:07:18 CST 2018
     */
    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
        this.lastUpdateTimeColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_execution_queue.LAST_UPDATE_TIME:Coloured
     *
     * @param lastUpdateTimeColoured the value for wf_execution_queue.LAST_UPDATE_TIME:Coloured
     *
     * @mbg.generated Mon Dec 03 11:07:18 CST 2018
     */
    public void setLastUpdateTimeColoured(boolean lastUpdateTimeColoured) {
        this.lastUpdateTimeColoured = lastUpdateTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_execution_queue.LAST_UPDATE_OPER
     *
     * @return the value of wf_execution_queue.LAST_UPDATE_OPER
     *
     * @mbg.generated Mon Dec 03 11:07:18 CST 2018
     */
    public String getLastUpdateOper() {
        return lastUpdateOper;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_execution_queue.LAST_UPDATE_OPER:Coloured
     *
     * @return the value of wf_execution_queue.LAST_UPDATE_OPER:Coloured
     *
     * @mbg.generated Mon Dec 03 11:07:18 CST 2018
     */
    public boolean isLastUpdateOperColoured() {
        return lastUpdateOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_execution_queue.LAST_UPDATE_OPER
     *
     * @param lastUpdateOper the value for wf_execution_queue.LAST_UPDATE_OPER
     *
     * @mbg.generated Mon Dec 03 11:07:18 CST 2018
     */
    public void setLastUpdateOper(String lastUpdateOper) {
        this.lastUpdateOper = lastUpdateOper == null ? null : lastUpdateOper.trim();
        this.lastUpdateOperColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_execution_queue.LAST_UPDATE_OPER:Coloured
     *
     * @param lastUpdateOperColoured the value for wf_execution_queue.LAST_UPDATE_OPER:Coloured
     *
     * @mbg.generated Mon Dec 03 11:07:18 CST 2018
     */
    public void setLastUpdateOperColoured(boolean lastUpdateOperColoured) {
        this.lastUpdateOperColoured = lastUpdateOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_execution_queue.CREATE_TIME
     *
     * @return the value of wf_execution_queue.CREATE_TIME
     *
     * @mbg.generated Mon Dec 03 11:07:18 CST 2018
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_execution_queue.CREATE_TIME:Coloured
     *
     * @return the value of wf_execution_queue.CREATE_TIME:Coloured
     *
     * @mbg.generated Mon Dec 03 11:07:18 CST 2018
     */
    public boolean isCreateTimeColoured() {
        return createTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_execution_queue.CREATE_TIME
     *
     * @param createTime the value for wf_execution_queue.CREATE_TIME
     *
     * @mbg.generated Mon Dec 03 11:07:18 CST 2018
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
        this.createTimeColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_execution_queue.CREATE_TIME:Coloured
     *
     * @param createTimeColoured the value for wf_execution_queue.CREATE_TIME:Coloured
     *
     * @mbg.generated Mon Dec 03 11:07:18 CST 2018
     */
    public void setCreateTimeColoured(boolean createTimeColoured) {
        this.createTimeColoured = createTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_execution_queue.CREATE_OPER
     *
     * @return the value of wf_execution_queue.CREATE_OPER
     *
     * @mbg.generated Mon Dec 03 11:07:18 CST 2018
     */
    public String getCreateOper() {
        return createOper;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_execution_queue.CREATE_OPER:Coloured
     *
     * @return the value of wf_execution_queue.CREATE_OPER:Coloured
     *
     * @mbg.generated Mon Dec 03 11:07:18 CST 2018
     */
    public boolean isCreateOperColoured() {
        return createOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_execution_queue.CREATE_OPER
     *
     * @param createOper the value for wf_execution_queue.CREATE_OPER
     *
     * @mbg.generated Mon Dec 03 11:07:18 CST 2018
     */
    public void setCreateOper(String createOper) {
        this.createOper = createOper == null ? null : createOper.trim();
        this.createOperColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_execution_queue.CREATE_OPER:Coloured
     *
     * @param createOperColoured the value for wf_execution_queue.CREATE_OPER:Coloured
     *
     * @mbg.generated Mon Dec 03 11:07:18 CST 2018
     */
    public void setCreateOperColoured(boolean createOperColoured) {
        this.createOperColoured = createOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_execution_queue
     *
     * @mbg.generated Mon Dec 03 11:07:18 CST 2018
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
        WfExecutionQueue other = (WfExecutionQueue) that;
        return (this.getJobId() == null ? other.getJobId() == null : this.getJobId().equals(other.getJobId()))
            && (this.getOwnerProjectId() == null ? other.getOwnerProjectId() == null : this.getOwnerProjectId().equals(other.getOwnerProjectId()))
            && (this.getJobTime() == null ? other.getJobTime() == null : this.getJobTime().equals(other.getJobTime()))
            && (this.getJobSignal() == null ? other.getJobSignal() == null : this.getJobSignal().equals(other.getJobSignal()))
            && (this.getJobState() == null ? other.getJobState() == null : this.getJobState().equals(other.getJobState()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getLastUpdateTime() == null ? other.getLastUpdateTime() == null : this.getLastUpdateTime().equals(other.getLastUpdateTime()))
            && (this.getLastUpdateOper() == null ? other.getLastUpdateOper() == null : this.getLastUpdateOper().equals(other.getLastUpdateOper()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getCreateOper() == null ? other.getCreateOper() == null : this.getCreateOper().equals(other.getCreateOper()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_execution_queue
     *
     * @mbg.generated Mon Dec 03 11:07:18 CST 2018
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getJobId() == null) ? 0 : getJobId().hashCode());
        result = prime * result + ((getOwnerProjectId() == null) ? 0 : getOwnerProjectId().hashCode());
        result = prime * result + ((getJobTime() == null) ? 0 : getJobTime().hashCode());
        result = prime * result + ((getJobSignal() == null) ? 0 : getJobSignal().hashCode());
        result = prime * result + ((getJobState() == null) ? 0 : getJobState().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getLastUpdateTime() == null) ? 0 : getLastUpdateTime().hashCode());
        result = prime * result + ((getLastUpdateOper() == null) ? 0 : getLastUpdateOper().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCreateOper() == null) ? 0 : getCreateOper().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_execution_queue
     *
     * @mbg.generated Mon Dec 03 11:07:18 CST 2018
     */
    @Override
    public void copyProperties(Object that) {
        if (this == that || that == null || this.getClass() != that.getClass() ) {
            return;
        }
        WfExecutionQueue other = (WfExecutionQueue) that;
        if(other.isJobIdColoured() ) {this.setJobId(other.getJobId() );}
        if(other.isOwnerProjectIdColoured() ) {this.setOwnerProjectId(other.getOwnerProjectId() );}
        if(other.isJobTimeColoured() ) {this.setJobTime(other.getJobTime() );}
        if(other.isJobSignalColoured() ) {this.setJobSignal(other.getJobSignal() );}
        if(other.isJobStateColoured() ) {this.setJobState(other.getJobState() );}
        if(other.isDescriptionColoured() ) {this.setDescription(other.getDescription() );}
        if(other.isLastUpdateTimeColoured() ) {this.setLastUpdateTime(other.getLastUpdateTime() );}
        if(other.isLastUpdateOperColoured() ) {this.setLastUpdateOper(other.getLastUpdateOper() );}
        if(other.isCreateTimeColoured() ) {this.setCreateTime(other.getCreateTime() );}
        if(other.isCreateOperColoured() ) {this.setCreateOper(other.getCreateOper() );}
        return;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_execution_queue
     *
     * @mbg.generated Mon Dec 03 11:07:18 CST 2018
     */
    @Override
    public JSONObject toJSON() {
        HashMap<String, Object> hashMap = new HashMap();
        if(this.jobIdColoured) {hashMap.put("jobId", this.jobId);}
        if(this.ownerProjectIdColoured) {hashMap.put("ownerProjectId", this.ownerProjectId);}
        if(this.jobTimeColoured) {hashMap.put("jobTime", this.jobTime);}
        if(this.jobSignalColoured) {hashMap.put("jobSignal", this.jobSignal);}
        if(this.jobStateColoured) {hashMap.put("jobState", this.jobState);}
        if(this.descriptionColoured) {hashMap.put("description", this.description);}
        if(this.lastUpdateTimeColoured) {hashMap.put("lastUpdateTime", this.lastUpdateTime);}
        if(this.lastUpdateOperColoured) {hashMap.put("lastUpdateOper", this.lastUpdateOper);}
        if(this.createTimeColoured) {hashMap.put("createTime", this.createTime);}
        if(this.createOperColoured) {hashMap.put("createOper", this.createOper);}
        return (JSONObject) JSON.toJSON(hashMap);
    }
}