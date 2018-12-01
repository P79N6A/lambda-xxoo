package com.yatop.lambda.base.model;

import java.io.Serializable;
import java.util.Date;

public class WfExecutionQueue implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_execution_queue.JOB_ID
     *
     * @mbg.generated Sat Dec 01 22:15:38 CST 2018
     */
    private Long jobId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_execution_queue.OWNER_PROJECT_ID
     *
     * @mbg.generated Sat Dec 01 22:15:38 CST 2018
     */
    private Long ownerProjectId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_execution_queue.JOB_TIME
     *
     * @mbg.generated Sat Dec 01 22:15:38 CST 2018
     */
    private Date jobTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_execution_queue.JOB_SIGNAL
     *
     * @mbg.generated Sat Dec 01 22:15:38 CST 2018
     */
    private Integer jobSignal;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_execution_queue.JOB_STATE
     *
     * @mbg.generated Sat Dec 01 22:15:38 CST 2018
     */
    private Integer jobState;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_execution_queue.DESCRIPTION
     *
     * @mbg.generated Sat Dec 01 22:15:38 CST 2018
     */
    private String description;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_execution_queue.LAST_UPDATE_TIME
     *
     * @mbg.generated Sat Dec 01 22:15:38 CST 2018
     */
    private Date lastUpdateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_execution_queue.LAST_UPDATE_OPER
     *
     * @mbg.generated Sat Dec 01 22:15:38 CST 2018
     */
    private String lastUpdateOper;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_execution_queue.CREATE_TIME
     *
     * @mbg.generated Sat Dec 01 22:15:38 CST 2018
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_execution_queue.CREATE_OPER
     *
     * @mbg.generated Sat Dec 01 22:15:38 CST 2018
     */
    private String createOper;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table wf_execution_queue
     *
     * @mbg.generated Sat Dec 01 22:15:38 CST 2018
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_execution_queue.JOB_ID
     *
     * @return the value of wf_execution_queue.JOB_ID
     *
     * @mbg.generated Sat Dec 01 22:15:38 CST 2018
     */
    public Long getJobId() {
        return jobId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_execution_queue.JOB_ID
     *
     * @param jobId the value for wf_execution_queue.JOB_ID
     *
     * @mbg.generated Sat Dec 01 22:15:38 CST 2018
     */
    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_execution_queue.OWNER_PROJECT_ID
     *
     * @return the value of wf_execution_queue.OWNER_PROJECT_ID
     *
     * @mbg.generated Sat Dec 01 22:15:38 CST 2018
     */
    public Long getOwnerProjectId() {
        return ownerProjectId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_execution_queue.OWNER_PROJECT_ID
     *
     * @param ownerProjectId the value for wf_execution_queue.OWNER_PROJECT_ID
     *
     * @mbg.generated Sat Dec 01 22:15:38 CST 2018
     */
    public void setOwnerProjectId(Long ownerProjectId) {
        this.ownerProjectId = ownerProjectId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_execution_queue.JOB_TIME
     *
     * @return the value of wf_execution_queue.JOB_TIME
     *
     * @mbg.generated Sat Dec 01 22:15:38 CST 2018
     */
    public Date getJobTime() {
        return jobTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_execution_queue.JOB_TIME
     *
     * @param jobTime the value for wf_execution_queue.JOB_TIME
     *
     * @mbg.generated Sat Dec 01 22:15:38 CST 2018
     */
    public void setJobTime(Date jobTime) {
        this.jobTime = jobTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_execution_queue.JOB_SIGNAL
     *
     * @return the value of wf_execution_queue.JOB_SIGNAL
     *
     * @mbg.generated Sat Dec 01 22:15:38 CST 2018
     */
    public Integer getJobSignal() {
        return jobSignal;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_execution_queue.JOB_SIGNAL
     *
     * @param jobSignal the value for wf_execution_queue.JOB_SIGNAL
     *
     * @mbg.generated Sat Dec 01 22:15:38 CST 2018
     */
    public void setJobSignal(Integer jobSignal) {
        this.jobSignal = jobSignal;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_execution_queue.JOB_STATE
     *
     * @return the value of wf_execution_queue.JOB_STATE
     *
     * @mbg.generated Sat Dec 01 22:15:38 CST 2018
     */
    public Integer getJobState() {
        return jobState;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_execution_queue.JOB_STATE
     *
     * @param jobState the value for wf_execution_queue.JOB_STATE
     *
     * @mbg.generated Sat Dec 01 22:15:38 CST 2018
     */
    public void setJobState(Integer jobState) {
        this.jobState = jobState;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_execution_queue.DESCRIPTION
     *
     * @return the value of wf_execution_queue.DESCRIPTION
     *
     * @mbg.generated Sat Dec 01 22:15:38 CST 2018
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_execution_queue.DESCRIPTION
     *
     * @param description the value for wf_execution_queue.DESCRIPTION
     *
     * @mbg.generated Sat Dec 01 22:15:38 CST 2018
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_execution_queue.LAST_UPDATE_TIME
     *
     * @return the value of wf_execution_queue.LAST_UPDATE_TIME
     *
     * @mbg.generated Sat Dec 01 22:15:38 CST 2018
     */
    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_execution_queue.LAST_UPDATE_TIME
     *
     * @param lastUpdateTime the value for wf_execution_queue.LAST_UPDATE_TIME
     *
     * @mbg.generated Sat Dec 01 22:15:38 CST 2018
     */
    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_execution_queue.LAST_UPDATE_OPER
     *
     * @return the value of wf_execution_queue.LAST_UPDATE_OPER
     *
     * @mbg.generated Sat Dec 01 22:15:38 CST 2018
     */
    public String getLastUpdateOper() {
        return lastUpdateOper;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_execution_queue.LAST_UPDATE_OPER
     *
     * @param lastUpdateOper the value for wf_execution_queue.LAST_UPDATE_OPER
     *
     * @mbg.generated Sat Dec 01 22:15:38 CST 2018
     */
    public void setLastUpdateOper(String lastUpdateOper) {
        this.lastUpdateOper = lastUpdateOper == null ? null : lastUpdateOper.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_execution_queue.CREATE_TIME
     *
     * @return the value of wf_execution_queue.CREATE_TIME
     *
     * @mbg.generated Sat Dec 01 22:15:38 CST 2018
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_execution_queue.CREATE_TIME
     *
     * @param createTime the value for wf_execution_queue.CREATE_TIME
     *
     * @mbg.generated Sat Dec 01 22:15:38 CST 2018
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_execution_queue.CREATE_OPER
     *
     * @return the value of wf_execution_queue.CREATE_OPER
     *
     * @mbg.generated Sat Dec 01 22:15:38 CST 2018
     */
    public String getCreateOper() {
        return createOper;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_execution_queue.CREATE_OPER
     *
     * @param createOper the value for wf_execution_queue.CREATE_OPER
     *
     * @mbg.generated Sat Dec 01 22:15:38 CST 2018
     */
    public void setCreateOper(String createOper) {
        this.createOper = createOper == null ? null : createOper.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_execution_queue
     *
     * @mbg.generated Sat Dec 01 22:15:38 CST 2018
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
     * @mbg.generated Sat Dec 01 22:15:38 CST 2018
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
}