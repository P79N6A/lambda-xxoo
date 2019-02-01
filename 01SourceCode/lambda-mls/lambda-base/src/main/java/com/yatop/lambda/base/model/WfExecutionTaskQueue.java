package com.yatop.lambda.base.model;

import com.alibaba.fastjson.JSONObject;
import com.yatop.lambda.base.utils.LambdaRootModel;
import java.io.Serializable;
import java.util.Date;

public class WfExecutionTaskQueue extends LambdaRootModel implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_execution_task_queue.TASK_ID
     *
     * @mbg.generated Fri Feb 01 23:43:10 CST 2019
     */
    private Long taskId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_execution_task_queue.TASK_ID:Coloured
     *
     * @mbg.generated Fri Feb 01 23:43:10 CST 2019
     */
    private boolean taskIdColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_execution_task_queue.OWNER_PROJECT_ID
     *
     * @mbg.generated Fri Feb 01 23:43:10 CST 2019
     */
    private Long ownerProjectId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_execution_task_queue.OWNER_PROJECT_ID:Coloured
     *
     * @mbg.generated Fri Feb 01 23:43:10 CST 2019
     */
    private boolean ownerProjectIdColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_execution_task_queue.OWNER_JOB_ID
     *
     * @mbg.generated Fri Feb 01 23:43:10 CST 2019
     */
    private Long ownerJobId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_execution_task_queue.OWNER_JOB_ID:Coloured
     *
     * @mbg.generated Fri Feb 01 23:43:10 CST 2019
     */
    private boolean ownerJobIdColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_execution_task_queue.TASK_TIME
     *
     * @mbg.generated Fri Feb 01 23:43:10 CST 2019
     */
    private Date taskTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_execution_task_queue.TASK_TIME:Coloured
     *
     * @mbg.generated Fri Feb 01 23:43:10 CST 2019
     */
    private boolean taskTimeColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_execution_task_queue.TASK_SIGNAL
     *
     * @mbg.generated Fri Feb 01 23:43:10 CST 2019
     */
    private Integer taskSignal;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_execution_task_queue.TASK_SIGNAL:Coloured
     *
     * @mbg.generated Fri Feb 01 23:43:10 CST 2019
     */
    private boolean taskSignalColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_execution_task_queue.TASK_STATE
     *
     * @mbg.generated Fri Feb 01 23:43:10 CST 2019
     */
    private Integer taskState;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_execution_task_queue.TASK_STATE:Coloured
     *
     * @mbg.generated Fri Feb 01 23:43:10 CST 2019
     */
    private boolean taskStateColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_execution_task_queue.DESCRIPTION
     *
     * @mbg.generated Fri Feb 01 23:43:10 CST 2019
     */
    private String description;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_execution_task_queue.DESCRIPTION:Coloured
     *
     * @mbg.generated Fri Feb 01 23:43:10 CST 2019
     */
    private boolean descriptionColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_execution_task_queue.LAST_UPDATE_TIME
     *
     * @mbg.generated Fri Feb 01 23:43:10 CST 2019
     */
    private Date lastUpdateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_execution_task_queue.LAST_UPDATE_TIME:Coloured
     *
     * @mbg.generated Fri Feb 01 23:43:10 CST 2019
     */
    private boolean lastUpdateTimeColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_execution_task_queue.LAST_UPDATE_OPER
     *
     * @mbg.generated Fri Feb 01 23:43:10 CST 2019
     */
    private String lastUpdateOper;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_execution_task_queue.LAST_UPDATE_OPER:Coloured
     *
     * @mbg.generated Fri Feb 01 23:43:10 CST 2019
     */
    private boolean lastUpdateOperColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_execution_task_queue.CREATE_TIME
     *
     * @mbg.generated Fri Feb 01 23:43:10 CST 2019
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_execution_task_queue.CREATE_TIME:Coloured
     *
     * @mbg.generated Fri Feb 01 23:43:10 CST 2019
     */
    private boolean createTimeColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_execution_task_queue.CREATE_OPER
     *
     * @mbg.generated Fri Feb 01 23:43:10 CST 2019
     */
    private String createOper;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_execution_task_queue.CREATE_OPER:Coloured
     *
     * @mbg.generated Fri Feb 01 23:43:10 CST 2019
     */
    private boolean createOperColoured;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table wf_execution_task_queue
     *
     * @mbg.generated Fri Feb 01 23:43:10 CST 2019
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_execution_task_queue.TASK_ID
     *
     * @return the value of wf_execution_task_queue.TASK_ID
     *
     * @mbg.generated Fri Feb 01 23:43:10 CST 2019
     */
    public Long getTaskId() {
        return taskId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_execution_task_queue.TASK_ID:Coloured
     *
     * @return the value of wf_execution_task_queue.TASK_ID:Coloured
     *
     * @mbg.generated Fri Feb 01 23:43:10 CST 2019
     */
    public boolean isTaskIdColoured() {
        return taskIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_execution_task_queue.TASK_ID:Coloured
     *
     * @return the value of wf_execution_task_queue.TASK_ID:Coloured
     *
     * @mbg.generated Fri Feb 01 23:43:10 CST 2019
     */
    public boolean isTaskIdNotColoured() {
        return !taskIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_execution_task_queue.TASK_ID
     *
     * @param taskId the value for wf_execution_task_queue.TASK_ID
     *
     * @mbg.generated Fri Feb 01 23:43:10 CST 2019
     */
    public void setTaskId(Long taskId) {
        this.taskId = taskId;
        this.taskIdColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_execution_task_queue.TASK_ID:Coloured
     *
     * @param taskIdColoured the value for wf_execution_task_queue.TASK_ID:Coloured
     *
     * @mbg.generated Fri Feb 01 23:43:10 CST 2019
     */
    public void setTaskIdColoured(boolean taskIdColoured) {
        this.taskIdColoured = taskIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_execution_task_queue.OWNER_PROJECT_ID
     *
     * @return the value of wf_execution_task_queue.OWNER_PROJECT_ID
     *
     * @mbg.generated Fri Feb 01 23:43:10 CST 2019
     */
    public Long getOwnerProjectId() {
        return ownerProjectId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_execution_task_queue.OWNER_PROJECT_ID:Coloured
     *
     * @return the value of wf_execution_task_queue.OWNER_PROJECT_ID:Coloured
     *
     * @mbg.generated Fri Feb 01 23:43:10 CST 2019
     */
    public boolean isOwnerProjectIdColoured() {
        return ownerProjectIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_execution_task_queue.OWNER_PROJECT_ID:Coloured
     *
     * @return the value of wf_execution_task_queue.OWNER_PROJECT_ID:Coloured
     *
     * @mbg.generated Fri Feb 01 23:43:10 CST 2019
     */
    public boolean isOwnerProjectIdNotColoured() {
        return !ownerProjectIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_execution_task_queue.OWNER_PROJECT_ID
     *
     * @param ownerProjectId the value for wf_execution_task_queue.OWNER_PROJECT_ID
     *
     * @mbg.generated Fri Feb 01 23:43:10 CST 2019
     */
    public void setOwnerProjectId(Long ownerProjectId) {
        this.ownerProjectId = ownerProjectId;
        this.ownerProjectIdColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_execution_task_queue.OWNER_PROJECT_ID:Coloured
     *
     * @param ownerProjectIdColoured the value for wf_execution_task_queue.OWNER_PROJECT_ID:Coloured
     *
     * @mbg.generated Fri Feb 01 23:43:10 CST 2019
     */
    public void setOwnerProjectIdColoured(boolean ownerProjectIdColoured) {
        this.ownerProjectIdColoured = ownerProjectIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_execution_task_queue.OWNER_JOB_ID
     *
     * @return the value of wf_execution_task_queue.OWNER_JOB_ID
     *
     * @mbg.generated Fri Feb 01 23:43:10 CST 2019
     */
    public Long getOwnerJobId() {
        return ownerJobId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_execution_task_queue.OWNER_JOB_ID:Coloured
     *
     * @return the value of wf_execution_task_queue.OWNER_JOB_ID:Coloured
     *
     * @mbg.generated Fri Feb 01 23:43:10 CST 2019
     */
    public boolean isOwnerJobIdColoured() {
        return ownerJobIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_execution_task_queue.OWNER_JOB_ID:Coloured
     *
     * @return the value of wf_execution_task_queue.OWNER_JOB_ID:Coloured
     *
     * @mbg.generated Fri Feb 01 23:43:10 CST 2019
     */
    public boolean isOwnerJobIdNotColoured() {
        return !ownerJobIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_execution_task_queue.OWNER_JOB_ID
     *
     * @param ownerJobId the value for wf_execution_task_queue.OWNER_JOB_ID
     *
     * @mbg.generated Fri Feb 01 23:43:10 CST 2019
     */
    public void setOwnerJobId(Long ownerJobId) {
        this.ownerJobId = ownerJobId;
        this.ownerJobIdColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_execution_task_queue.OWNER_JOB_ID:Coloured
     *
     * @param ownerJobIdColoured the value for wf_execution_task_queue.OWNER_JOB_ID:Coloured
     *
     * @mbg.generated Fri Feb 01 23:43:10 CST 2019
     */
    public void setOwnerJobIdColoured(boolean ownerJobIdColoured) {
        this.ownerJobIdColoured = ownerJobIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_execution_task_queue.TASK_TIME
     *
     * @return the value of wf_execution_task_queue.TASK_TIME
     *
     * @mbg.generated Fri Feb 01 23:43:10 CST 2019
     */
    public Date getTaskTime() {
        return taskTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_execution_task_queue.TASK_TIME:Coloured
     *
     * @return the value of wf_execution_task_queue.TASK_TIME:Coloured
     *
     * @mbg.generated Fri Feb 01 23:43:10 CST 2019
     */
    public boolean isTaskTimeColoured() {
        return taskTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_execution_task_queue.TASK_TIME:Coloured
     *
     * @return the value of wf_execution_task_queue.TASK_TIME:Coloured
     *
     * @mbg.generated Fri Feb 01 23:43:10 CST 2019
     */
    public boolean isTaskTimeNotColoured() {
        return !taskTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_execution_task_queue.TASK_TIME
     *
     * @param taskTime the value for wf_execution_task_queue.TASK_TIME
     *
     * @mbg.generated Fri Feb 01 23:43:10 CST 2019
     */
    public void setTaskTime(Date taskTime) {
        this.taskTime = taskTime;
        this.taskTimeColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_execution_task_queue.TASK_TIME:Coloured
     *
     * @param taskTimeColoured the value for wf_execution_task_queue.TASK_TIME:Coloured
     *
     * @mbg.generated Fri Feb 01 23:43:10 CST 2019
     */
    public void setTaskTimeColoured(boolean taskTimeColoured) {
        this.taskTimeColoured = taskTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_execution_task_queue.TASK_SIGNAL
     *
     * @return the value of wf_execution_task_queue.TASK_SIGNAL
     *
     * @mbg.generated Fri Feb 01 23:43:10 CST 2019
     */
    public Integer getTaskSignal() {
        return taskSignal;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_execution_task_queue.TASK_SIGNAL:Coloured
     *
     * @return the value of wf_execution_task_queue.TASK_SIGNAL:Coloured
     *
     * @mbg.generated Fri Feb 01 23:43:10 CST 2019
     */
    public boolean isTaskSignalColoured() {
        return taskSignalColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_execution_task_queue.TASK_SIGNAL:Coloured
     *
     * @return the value of wf_execution_task_queue.TASK_SIGNAL:Coloured
     *
     * @mbg.generated Fri Feb 01 23:43:10 CST 2019
     */
    public boolean isTaskSignalNotColoured() {
        return !taskSignalColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_execution_task_queue.TASK_SIGNAL
     *
     * @param taskSignal the value for wf_execution_task_queue.TASK_SIGNAL
     *
     * @mbg.generated Fri Feb 01 23:43:10 CST 2019
     */
    public void setTaskSignal(Integer taskSignal) {
        this.taskSignal = taskSignal;
        this.taskSignalColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_execution_task_queue.TASK_SIGNAL:Coloured
     *
     * @param taskSignalColoured the value for wf_execution_task_queue.TASK_SIGNAL:Coloured
     *
     * @mbg.generated Fri Feb 01 23:43:10 CST 2019
     */
    public void setTaskSignalColoured(boolean taskSignalColoured) {
        this.taskSignalColoured = taskSignalColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_execution_task_queue.TASK_STATE
     *
     * @return the value of wf_execution_task_queue.TASK_STATE
     *
     * @mbg.generated Fri Feb 01 23:43:10 CST 2019
     */
    public Integer getTaskState() {
        return taskState;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_execution_task_queue.TASK_STATE:Coloured
     *
     * @return the value of wf_execution_task_queue.TASK_STATE:Coloured
     *
     * @mbg.generated Fri Feb 01 23:43:10 CST 2019
     */
    public boolean isTaskStateColoured() {
        return taskStateColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_execution_task_queue.TASK_STATE:Coloured
     *
     * @return the value of wf_execution_task_queue.TASK_STATE:Coloured
     *
     * @mbg.generated Fri Feb 01 23:43:10 CST 2019
     */
    public boolean isTaskStateNotColoured() {
        return !taskStateColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_execution_task_queue.TASK_STATE
     *
     * @param taskState the value for wf_execution_task_queue.TASK_STATE
     *
     * @mbg.generated Fri Feb 01 23:43:10 CST 2019
     */
    public void setTaskState(Integer taskState) {
        this.taskState = taskState;
        this.taskStateColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_execution_task_queue.TASK_STATE:Coloured
     *
     * @param taskStateColoured the value for wf_execution_task_queue.TASK_STATE:Coloured
     *
     * @mbg.generated Fri Feb 01 23:43:10 CST 2019
     */
    public void setTaskStateColoured(boolean taskStateColoured) {
        this.taskStateColoured = taskStateColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_execution_task_queue.DESCRIPTION
     *
     * @return the value of wf_execution_task_queue.DESCRIPTION
     *
     * @mbg.generated Fri Feb 01 23:43:10 CST 2019
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_execution_task_queue.DESCRIPTION:Coloured
     *
     * @return the value of wf_execution_task_queue.DESCRIPTION:Coloured
     *
     * @mbg.generated Fri Feb 01 23:43:10 CST 2019
     */
    public boolean isDescriptionColoured() {
        return descriptionColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_execution_task_queue.DESCRIPTION:Coloured
     *
     * @return the value of wf_execution_task_queue.DESCRIPTION:Coloured
     *
     * @mbg.generated Fri Feb 01 23:43:10 CST 2019
     */
    public boolean isDescriptionNotColoured() {
        return !descriptionColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_execution_task_queue.DESCRIPTION
     *
     * @param description the value for wf_execution_task_queue.DESCRIPTION
     *
     * @mbg.generated Fri Feb 01 23:43:10 CST 2019
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
        this.descriptionColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_execution_task_queue.DESCRIPTION:Coloured
     *
     * @param descriptionColoured the value for wf_execution_task_queue.DESCRIPTION:Coloured
     *
     * @mbg.generated Fri Feb 01 23:43:10 CST 2019
     */
    public void setDescriptionColoured(boolean descriptionColoured) {
        this.descriptionColoured = descriptionColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_execution_task_queue.LAST_UPDATE_TIME
     *
     * @return the value of wf_execution_task_queue.LAST_UPDATE_TIME
     *
     * @mbg.generated Fri Feb 01 23:43:10 CST 2019
     */
    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_execution_task_queue.LAST_UPDATE_TIME:Coloured
     *
     * @return the value of wf_execution_task_queue.LAST_UPDATE_TIME:Coloured
     *
     * @mbg.generated Fri Feb 01 23:43:10 CST 2019
     */
    public boolean isLastUpdateTimeColoured() {
        return lastUpdateTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_execution_task_queue.LAST_UPDATE_TIME:Coloured
     *
     * @return the value of wf_execution_task_queue.LAST_UPDATE_TIME:Coloured
     *
     * @mbg.generated Fri Feb 01 23:43:10 CST 2019
     */
    public boolean isLastUpdateTimeNotColoured() {
        return !lastUpdateTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_execution_task_queue.LAST_UPDATE_TIME
     *
     * @param lastUpdateTime the value for wf_execution_task_queue.LAST_UPDATE_TIME
     *
     * @mbg.generated Fri Feb 01 23:43:10 CST 2019
     */
    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
        this.lastUpdateTimeColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_execution_task_queue.LAST_UPDATE_TIME:Coloured
     *
     * @param lastUpdateTimeColoured the value for wf_execution_task_queue.LAST_UPDATE_TIME:Coloured
     *
     * @mbg.generated Fri Feb 01 23:43:10 CST 2019
     */
    public void setLastUpdateTimeColoured(boolean lastUpdateTimeColoured) {
        this.lastUpdateTimeColoured = lastUpdateTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_execution_task_queue.LAST_UPDATE_OPER
     *
     * @return the value of wf_execution_task_queue.LAST_UPDATE_OPER
     *
     * @mbg.generated Fri Feb 01 23:43:10 CST 2019
     */
    public String getLastUpdateOper() {
        return lastUpdateOper;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_execution_task_queue.LAST_UPDATE_OPER:Coloured
     *
     * @return the value of wf_execution_task_queue.LAST_UPDATE_OPER:Coloured
     *
     * @mbg.generated Fri Feb 01 23:43:10 CST 2019
     */
    public boolean isLastUpdateOperColoured() {
        return lastUpdateOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_execution_task_queue.LAST_UPDATE_OPER:Coloured
     *
     * @return the value of wf_execution_task_queue.LAST_UPDATE_OPER:Coloured
     *
     * @mbg.generated Fri Feb 01 23:43:10 CST 2019
     */
    public boolean isLastUpdateOperNotColoured() {
        return !lastUpdateOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_execution_task_queue.LAST_UPDATE_OPER
     *
     * @param lastUpdateOper the value for wf_execution_task_queue.LAST_UPDATE_OPER
     *
     * @mbg.generated Fri Feb 01 23:43:10 CST 2019
     */
    public void setLastUpdateOper(String lastUpdateOper) {
        this.lastUpdateOper = lastUpdateOper == null ? null : lastUpdateOper.trim();
        this.lastUpdateOperColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_execution_task_queue.LAST_UPDATE_OPER:Coloured
     *
     * @param lastUpdateOperColoured the value for wf_execution_task_queue.LAST_UPDATE_OPER:Coloured
     *
     * @mbg.generated Fri Feb 01 23:43:10 CST 2019
     */
    public void setLastUpdateOperColoured(boolean lastUpdateOperColoured) {
        this.lastUpdateOperColoured = lastUpdateOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_execution_task_queue.CREATE_TIME
     *
     * @return the value of wf_execution_task_queue.CREATE_TIME
     *
     * @mbg.generated Fri Feb 01 23:43:10 CST 2019
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_execution_task_queue.CREATE_TIME:Coloured
     *
     * @return the value of wf_execution_task_queue.CREATE_TIME:Coloured
     *
     * @mbg.generated Fri Feb 01 23:43:10 CST 2019
     */
    public boolean isCreateTimeColoured() {
        return createTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_execution_task_queue.CREATE_TIME:Coloured
     *
     * @return the value of wf_execution_task_queue.CREATE_TIME:Coloured
     *
     * @mbg.generated Fri Feb 01 23:43:10 CST 2019
     */
    public boolean isCreateTimeNotColoured() {
        return !createTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_execution_task_queue.CREATE_TIME
     *
     * @param createTime the value for wf_execution_task_queue.CREATE_TIME
     *
     * @mbg.generated Fri Feb 01 23:43:10 CST 2019
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
        this.createTimeColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_execution_task_queue.CREATE_TIME:Coloured
     *
     * @param createTimeColoured the value for wf_execution_task_queue.CREATE_TIME:Coloured
     *
     * @mbg.generated Fri Feb 01 23:43:10 CST 2019
     */
    public void setCreateTimeColoured(boolean createTimeColoured) {
        this.createTimeColoured = createTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_execution_task_queue.CREATE_OPER
     *
     * @return the value of wf_execution_task_queue.CREATE_OPER
     *
     * @mbg.generated Fri Feb 01 23:43:10 CST 2019
     */
    public String getCreateOper() {
        return createOper;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_execution_task_queue.CREATE_OPER:Coloured
     *
     * @return the value of wf_execution_task_queue.CREATE_OPER:Coloured
     *
     * @mbg.generated Fri Feb 01 23:43:10 CST 2019
     */
    public boolean isCreateOperColoured() {
        return createOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_execution_task_queue.CREATE_OPER:Coloured
     *
     * @return the value of wf_execution_task_queue.CREATE_OPER:Coloured
     *
     * @mbg.generated Fri Feb 01 23:43:10 CST 2019
     */
    public boolean isCreateOperNotColoured() {
        return !createOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_execution_task_queue.CREATE_OPER
     *
     * @param createOper the value for wf_execution_task_queue.CREATE_OPER
     *
     * @mbg.generated Fri Feb 01 23:43:10 CST 2019
     */
    public void setCreateOper(String createOper) {
        this.createOper = createOper == null ? null : createOper.trim();
        this.createOperColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_execution_task_queue.CREATE_OPER:Coloured
     *
     * @param createOperColoured the value for wf_execution_task_queue.CREATE_OPER:Coloured
     *
     * @mbg.generated Fri Feb 01 23:43:10 CST 2019
     */
    public void setCreateOperColoured(boolean createOperColoured) {
        this.createOperColoured = createOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_execution_task_queue
     *
     * @mbg.generated Fri Feb 01 23:43:10 CST 2019
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if(!(that instanceof WfExecutionTaskQueue)) {
            return false;
        }
        WfExecutionTaskQueue other = (WfExecutionTaskQueue) that;
        return (this.getTaskId() == null ? other.getTaskId() == null : this.getTaskId().equals(other.getTaskId()))
            && (this.getOwnerProjectId() == null ? other.getOwnerProjectId() == null : this.getOwnerProjectId().equals(other.getOwnerProjectId()))
            && (this.getOwnerJobId() == null ? other.getOwnerJobId() == null : this.getOwnerJobId().equals(other.getOwnerJobId()))
            && (this.getTaskTime() == null ? other.getTaskTime() == null : this.getTaskTime().equals(other.getTaskTime()))
            && (this.getTaskSignal() == null ? other.getTaskSignal() == null : this.getTaskSignal().equals(other.getTaskSignal()))
            && (this.getTaskState() == null ? other.getTaskState() == null : this.getTaskState().equals(other.getTaskState()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getLastUpdateTime() == null ? other.getLastUpdateTime() == null : this.getLastUpdateTime().equals(other.getLastUpdateTime()))
            && (this.getLastUpdateOper() == null ? other.getLastUpdateOper() == null : this.getLastUpdateOper().equals(other.getLastUpdateOper()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getCreateOper() == null ? other.getCreateOper() == null : this.getCreateOper().equals(other.getCreateOper()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_execution_task_queue
     *
     * @mbg.generated Fri Feb 01 23:43:10 CST 2019
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getTaskId() == null) ? 0 : getTaskId().hashCode());
        result = prime * result + ((getOwnerProjectId() == null) ? 0 : getOwnerProjectId().hashCode());
        result = prime * result + ((getOwnerJobId() == null) ? 0 : getOwnerJobId().hashCode());
        result = prime * result + ((getTaskTime() == null) ? 0 : getTaskTime().hashCode());
        result = prime * result + ((getTaskSignal() == null) ? 0 : getTaskSignal().hashCode());
        result = prime * result + ((getTaskState() == null) ? 0 : getTaskState().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getLastUpdateTime() == null) ? 0 : getLastUpdateTime().hashCode());
        result = prime * result + ((getLastUpdateOper() == null) ? 0 : getLastUpdateOper().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCreateOper() == null) ? 0 : getCreateOper().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_execution_task_queue
     *
     * @mbg.generated Fri Feb 01 23:43:10 CST 2019
     */
    public void copyProperties(WfExecutionTaskQueue that) {
        if (this == that || that == null) {
            return;
        }
        if(that.isTaskIdColoured() ) {this.setTaskId(that.getTaskId() );}
        if(that.isOwnerProjectIdColoured() ) {this.setOwnerProjectId(that.getOwnerProjectId() );}
        if(that.isOwnerJobIdColoured() ) {this.setOwnerJobId(that.getOwnerJobId() );}
        if(that.isTaskTimeColoured() ) {this.setTaskTime(that.getTaskTime() );}
        if(that.isTaskSignalColoured() ) {this.setTaskSignal(that.getTaskSignal() );}
        if(that.isTaskStateColoured() ) {this.setTaskState(that.getTaskState() );}
        if(that.isDescriptionColoured() ) {this.setDescription(that.getDescription() );}
        if(that.isLastUpdateTimeColoured() ) {this.setLastUpdateTime(that.getLastUpdateTime() );}
        if(that.isLastUpdateOperColoured() ) {this.setLastUpdateOper(that.getLastUpdateOper() );}
        if(that.isCreateTimeColoured() ) {this.setCreateTime(that.getCreateTime() );}
        if(that.isCreateOperColoured() ) {this.setCreateOper(that.getCreateOper() );}
        return;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_execution_task_queue
     *
     * @mbg.generated Fri Feb 01 23:43:10 CST 2019
     */
    @Override
    public JSONObject toJSON() {
        JSONObject jsonObj = new JSONObject(32, true);
        if(this.taskId != null) {jsonObj.put("taskId", this.taskId);}
        if(this.ownerProjectId != null) {jsonObj.put("ownerProjectId", this.ownerProjectId);}
        if(this.ownerJobId != null) {jsonObj.put("ownerJobId", this.ownerJobId);}
        if(this.taskTime != null) {jsonObj.put("taskTime", this.taskTime);}
        if(this.taskSignal != null) {jsonObj.put("taskSignal", this.taskSignal);}
        if(this.taskState != null) {jsonObj.put("taskState", this.taskState);}
        if(this.description != null) {jsonObj.put("description", this.description);}
        if(this.lastUpdateTime != null) {jsonObj.put("lastUpdateTime", this.lastUpdateTime);}
        if(this.lastUpdateOper != null) {jsonObj.put("lastUpdateOper", this.lastUpdateOper);}
        if(this.createTime != null) {jsonObj.put("createTime", this.createTime);}
        if(this.createOper != null) {jsonObj.put("createOper", this.createOper);}
        return jsonObj;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_execution_task_queue
     *
     * @mbg.generated Fri Feb 01 23:43:10 CST 2019
     */
    @Override
    public void clear() {
         this.taskId = null; this.taskIdColoured = false;
         this.ownerProjectId = null; this.ownerProjectIdColoured = false;
         this.ownerJobId = null; this.ownerJobIdColoured = false;
         this.taskTime = null; this.taskTimeColoured = false;
         this.taskSignal = null; this.taskSignalColoured = false;
         this.taskState = null; this.taskStateColoured = false;
         this.description = null; this.descriptionColoured = false;
         this.lastUpdateTime = null; this.lastUpdateTimeColoured = false;
         this.lastUpdateOper = null; this.lastUpdateOperColoured = false;
         this.createTime = null; this.createTimeColoured = false;
         this.createOper = null; this.createOperColoured = false;
        return;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_execution_task_queue
     *
     * @mbg.generated Fri Feb 01 23:43:10 CST 2019
     */
    @Override
    public void clearColoured() {
        this.taskIdColoured = false;
        this.ownerProjectIdColoured = false;
        this.ownerJobIdColoured = false;
        this.taskTimeColoured = false;
        this.taskSignalColoured = false;
        this.taskStateColoured = false;
        this.descriptionColoured = false;
        this.lastUpdateTimeColoured = false;
        this.lastUpdateOperColoured = false;
        this.createTimeColoured = false;
        this.createOperColoured = false;
        return;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_execution_task_queue
     *
     * @mbg.generated Fri Feb 01 23:43:10 CST 2019
     */
    @Override
    public boolean isColoured() {
        if(this.taskIdColoured) return true;
        if(this.ownerProjectIdColoured) return true;
        if(this.ownerJobIdColoured) return true;
        if(this.taskTimeColoured) return true;
        if(this.taskSignalColoured) return true;
        if(this.taskStateColoured) return true;
        if(this.descriptionColoured) return true;
        if(this.lastUpdateTimeColoured) return true;
        if(this.lastUpdateOperColoured) return true;
        if(this.createTimeColoured) return true;
        if(this.createOperColoured) return true;
        return false;
    }
}