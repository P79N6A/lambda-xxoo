package com.yatop.lambda.base.model;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yatop.lambda.base.utils.LambdaRootModel;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;

public class WfExecutionTaskOutput extends LambdaRootModel implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_execution_task_output.TASK_ID
     *
     * @mbg.generated Sat Dec 15 00:05:03 CST 2018
     */
    private Long taskId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_execution_task_output.TASK_ID:Coloured
     *
     * @mbg.generated Sat Dec 15 00:05:03 CST 2018
     */
    private boolean taskIdColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_execution_task_output.CHAR_ID
     *
     * @mbg.generated Sat Dec 15 00:05:03 CST 2018
     */
    private String charId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_execution_task_output.CHAR_ID:Coloured
     *
     * @mbg.generated Sat Dec 15 00:05:03 CST 2018
     */
    private boolean charIdColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_execution_task_output.CHAR_VALUE
     *
     * @mbg.generated Sat Dec 15 00:05:03 CST 2018
     */
    private String charValue;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_execution_task_output.CHAR_VALUE:Coloured
     *
     * @mbg.generated Sat Dec 15 00:05:03 CST 2018
     */
    private boolean charValueColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_execution_task_output.OUTPUT_STATE
     *
     * @mbg.generated Sat Dec 15 00:05:03 CST 2018
     */
    private Integer outputState;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_execution_task_output.OUTPUT_STATE:Coloured
     *
     * @mbg.generated Sat Dec 15 00:05:03 CST 2018
     */
    private boolean outputStateColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_execution_task_output.DESCRIPTION
     *
     * @mbg.generated Sat Dec 15 00:05:03 CST 2018
     */
    private String description;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_execution_task_output.DESCRIPTION:Coloured
     *
     * @mbg.generated Sat Dec 15 00:05:03 CST 2018
     */
    private boolean descriptionColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_execution_task_output.STATUS
     *
     * @mbg.generated Sat Dec 15 00:05:03 CST 2018
     */
    private Integer status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_execution_task_output.STATUS:Coloured
     *
     * @mbg.generated Sat Dec 15 00:05:03 CST 2018
     */
    private boolean statusColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_execution_task_output.LAST_UPDATE_TIME
     *
     * @mbg.generated Sat Dec 15 00:05:03 CST 2018
     */
    private Date lastUpdateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_execution_task_output.LAST_UPDATE_TIME:Coloured
     *
     * @mbg.generated Sat Dec 15 00:05:03 CST 2018
     */
    private boolean lastUpdateTimeColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_execution_task_output.LAST_UPDATE_OPER
     *
     * @mbg.generated Sat Dec 15 00:05:03 CST 2018
     */
    private String lastUpdateOper;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_execution_task_output.LAST_UPDATE_OPER:Coloured
     *
     * @mbg.generated Sat Dec 15 00:05:03 CST 2018
     */
    private boolean lastUpdateOperColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_execution_task_output.CREATE_TIME
     *
     * @mbg.generated Sat Dec 15 00:05:03 CST 2018
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_execution_task_output.CREATE_TIME:Coloured
     *
     * @mbg.generated Sat Dec 15 00:05:03 CST 2018
     */
    private boolean createTimeColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_execution_task_output.CREATE_OPER
     *
     * @mbg.generated Sat Dec 15 00:05:03 CST 2018
     */
    private String createOper;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_execution_task_output.CREATE_OPER:Coloured
     *
     * @mbg.generated Sat Dec 15 00:05:03 CST 2018
     */
    private boolean createOperColoured;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table wf_execution_task_output
     *
     * @mbg.generated Sat Dec 15 00:05:03 CST 2018
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_execution_task_output.TASK_ID
     *
     * @return the value of wf_execution_task_output.TASK_ID
     *
     * @mbg.generated Sat Dec 15 00:05:03 CST 2018
     */
    public Long getTaskId() {
        return taskId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_execution_task_output.TASK_ID:Coloured
     *
     * @return the value of wf_execution_task_output.TASK_ID:Coloured
     *
     * @mbg.generated Sat Dec 15 00:05:03 CST 2018
     */
    public boolean isTaskIdColoured() {
        return taskIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_execution_task_output.TASK_ID:Coloured
     *
     * @return the value of wf_execution_task_output.TASK_ID:Coloured
     *
     * @mbg.generated Sat Dec 15 00:05:03 CST 2018
     */
    public boolean isTaskIdNotColoured() {
        return !taskIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_execution_task_output.TASK_ID
     *
     * @param taskId the value for wf_execution_task_output.TASK_ID
     *
     * @mbg.generated Sat Dec 15 00:05:03 CST 2018
     */
    public void setTaskId(Long taskId) {
        this.taskId = taskId;
        this.taskIdColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_execution_task_output.TASK_ID:Coloured
     *
     * @param taskIdColoured the value for wf_execution_task_output.TASK_ID:Coloured
     *
     * @mbg.generated Sat Dec 15 00:05:03 CST 2018
     */
    public void setTaskIdColoured(boolean taskIdColoured) {
        this.taskIdColoured = taskIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_execution_task_output.CHAR_ID
     *
     * @return the value of wf_execution_task_output.CHAR_ID
     *
     * @mbg.generated Sat Dec 15 00:05:03 CST 2018
     */
    public String getCharId() {
        return charId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_execution_task_output.CHAR_ID:Coloured
     *
     * @return the value of wf_execution_task_output.CHAR_ID:Coloured
     *
     * @mbg.generated Sat Dec 15 00:05:03 CST 2018
     */
    public boolean isCharIdColoured() {
        return charIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_execution_task_output.CHAR_ID:Coloured
     *
     * @return the value of wf_execution_task_output.CHAR_ID:Coloured
     *
     * @mbg.generated Sat Dec 15 00:05:03 CST 2018
     */
    public boolean isCharIdNotColoured() {
        return !charIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_execution_task_output.CHAR_ID
     *
     * @param charId the value for wf_execution_task_output.CHAR_ID
     *
     * @mbg.generated Sat Dec 15 00:05:03 CST 2018
     */
    public void setCharId(String charId) {
        this.charId = charId == null ? null : charId.trim();
        this.charIdColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_execution_task_output.CHAR_ID:Coloured
     *
     * @param charIdColoured the value for wf_execution_task_output.CHAR_ID:Coloured
     *
     * @mbg.generated Sat Dec 15 00:05:03 CST 2018
     */
    public void setCharIdColoured(boolean charIdColoured) {
        this.charIdColoured = charIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_execution_task_output.CHAR_VALUE
     *
     * @return the value of wf_execution_task_output.CHAR_VALUE
     *
     * @mbg.generated Sat Dec 15 00:05:03 CST 2018
     */
    public String getCharValue() {
        return charValue;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_execution_task_output.CHAR_VALUE:Coloured
     *
     * @return the value of wf_execution_task_output.CHAR_VALUE:Coloured
     *
     * @mbg.generated Sat Dec 15 00:05:03 CST 2018
     */
    public boolean isCharValueColoured() {
        return charValueColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_execution_task_output.CHAR_VALUE:Coloured
     *
     * @return the value of wf_execution_task_output.CHAR_VALUE:Coloured
     *
     * @mbg.generated Sat Dec 15 00:05:03 CST 2018
     */
    public boolean isCharValueNotColoured() {
        return !charValueColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_execution_task_output.CHAR_VALUE
     *
     * @param charValue the value for wf_execution_task_output.CHAR_VALUE
     *
     * @mbg.generated Sat Dec 15 00:05:03 CST 2018
     */
    public void setCharValue(String charValue) {
        this.charValue = charValue == null ? null : charValue.trim();
        this.charValueColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_execution_task_output.CHAR_VALUE:Coloured
     *
     * @param charValueColoured the value for wf_execution_task_output.CHAR_VALUE:Coloured
     *
     * @mbg.generated Sat Dec 15 00:05:03 CST 2018
     */
    public void setCharValueColoured(boolean charValueColoured) {
        this.charValueColoured = charValueColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_execution_task_output.OUTPUT_STATE
     *
     * @return the value of wf_execution_task_output.OUTPUT_STATE
     *
     * @mbg.generated Sat Dec 15 00:05:03 CST 2018
     */
    public Integer getOutputState() {
        return outputState;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_execution_task_output.OUTPUT_STATE:Coloured
     *
     * @return the value of wf_execution_task_output.OUTPUT_STATE:Coloured
     *
     * @mbg.generated Sat Dec 15 00:05:03 CST 2018
     */
    public boolean isOutputStateColoured() {
        return outputStateColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_execution_task_output.OUTPUT_STATE:Coloured
     *
     * @return the value of wf_execution_task_output.OUTPUT_STATE:Coloured
     *
     * @mbg.generated Sat Dec 15 00:05:03 CST 2018
     */
    public boolean isOutputStateNotColoured() {
        return !outputStateColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_execution_task_output.OUTPUT_STATE
     *
     * @param outputState the value for wf_execution_task_output.OUTPUT_STATE
     *
     * @mbg.generated Sat Dec 15 00:05:03 CST 2018
     */
    public void setOutputState(Integer outputState) {
        this.outputState = outputState;
        this.outputStateColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_execution_task_output.OUTPUT_STATE:Coloured
     *
     * @param outputStateColoured the value for wf_execution_task_output.OUTPUT_STATE:Coloured
     *
     * @mbg.generated Sat Dec 15 00:05:03 CST 2018
     */
    public void setOutputStateColoured(boolean outputStateColoured) {
        this.outputStateColoured = outputStateColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_execution_task_output.DESCRIPTION
     *
     * @return the value of wf_execution_task_output.DESCRIPTION
     *
     * @mbg.generated Sat Dec 15 00:05:03 CST 2018
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_execution_task_output.DESCRIPTION:Coloured
     *
     * @return the value of wf_execution_task_output.DESCRIPTION:Coloured
     *
     * @mbg.generated Sat Dec 15 00:05:03 CST 2018
     */
    public boolean isDescriptionColoured() {
        return descriptionColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_execution_task_output.DESCRIPTION:Coloured
     *
     * @return the value of wf_execution_task_output.DESCRIPTION:Coloured
     *
     * @mbg.generated Sat Dec 15 00:05:03 CST 2018
     */
    public boolean isDescriptionNotColoured() {
        return !descriptionColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_execution_task_output.DESCRIPTION
     *
     * @param description the value for wf_execution_task_output.DESCRIPTION
     *
     * @mbg.generated Sat Dec 15 00:05:03 CST 2018
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
        this.descriptionColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_execution_task_output.DESCRIPTION:Coloured
     *
     * @param descriptionColoured the value for wf_execution_task_output.DESCRIPTION:Coloured
     *
     * @mbg.generated Sat Dec 15 00:05:03 CST 2018
     */
    public void setDescriptionColoured(boolean descriptionColoured) {
        this.descriptionColoured = descriptionColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_execution_task_output.STATUS
     *
     * @return the value of wf_execution_task_output.STATUS
     *
     * @mbg.generated Sat Dec 15 00:05:03 CST 2018
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_execution_task_output.STATUS:Coloured
     *
     * @return the value of wf_execution_task_output.STATUS:Coloured
     *
     * @mbg.generated Sat Dec 15 00:05:03 CST 2018
     */
    public boolean isStatusColoured() {
        return statusColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_execution_task_output.STATUS:Coloured
     *
     * @return the value of wf_execution_task_output.STATUS:Coloured
     *
     * @mbg.generated Sat Dec 15 00:05:03 CST 2018
     */
    public boolean isStatusNotColoured() {
        return !statusColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_execution_task_output.STATUS
     *
     * @param status the value for wf_execution_task_output.STATUS
     *
     * @mbg.generated Sat Dec 15 00:05:03 CST 2018
     */
    public void setStatus(Integer status) {
        this.status = status;
        this.statusColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_execution_task_output.STATUS:Coloured
     *
     * @param statusColoured the value for wf_execution_task_output.STATUS:Coloured
     *
     * @mbg.generated Sat Dec 15 00:05:03 CST 2018
     */
    public void setStatusColoured(boolean statusColoured) {
        this.statusColoured = statusColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_execution_task_output.LAST_UPDATE_TIME
     *
     * @return the value of wf_execution_task_output.LAST_UPDATE_TIME
     *
     * @mbg.generated Sat Dec 15 00:05:03 CST 2018
     */
    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_execution_task_output.LAST_UPDATE_TIME:Coloured
     *
     * @return the value of wf_execution_task_output.LAST_UPDATE_TIME:Coloured
     *
     * @mbg.generated Sat Dec 15 00:05:03 CST 2018
     */
    public boolean isLastUpdateTimeColoured() {
        return lastUpdateTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_execution_task_output.LAST_UPDATE_TIME:Coloured
     *
     * @return the value of wf_execution_task_output.LAST_UPDATE_TIME:Coloured
     *
     * @mbg.generated Sat Dec 15 00:05:03 CST 2018
     */
    public boolean isLastUpdateTimeNotColoured() {
        return !lastUpdateTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_execution_task_output.LAST_UPDATE_TIME
     *
     * @param lastUpdateTime the value for wf_execution_task_output.LAST_UPDATE_TIME
     *
     * @mbg.generated Sat Dec 15 00:05:03 CST 2018
     */
    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
        this.lastUpdateTimeColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_execution_task_output.LAST_UPDATE_TIME:Coloured
     *
     * @param lastUpdateTimeColoured the value for wf_execution_task_output.LAST_UPDATE_TIME:Coloured
     *
     * @mbg.generated Sat Dec 15 00:05:03 CST 2018
     */
    public void setLastUpdateTimeColoured(boolean lastUpdateTimeColoured) {
        this.lastUpdateTimeColoured = lastUpdateTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_execution_task_output.LAST_UPDATE_OPER
     *
     * @return the value of wf_execution_task_output.LAST_UPDATE_OPER
     *
     * @mbg.generated Sat Dec 15 00:05:03 CST 2018
     */
    public String getLastUpdateOper() {
        return lastUpdateOper;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_execution_task_output.LAST_UPDATE_OPER:Coloured
     *
     * @return the value of wf_execution_task_output.LAST_UPDATE_OPER:Coloured
     *
     * @mbg.generated Sat Dec 15 00:05:03 CST 2018
     */
    public boolean isLastUpdateOperColoured() {
        return lastUpdateOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_execution_task_output.LAST_UPDATE_OPER:Coloured
     *
     * @return the value of wf_execution_task_output.LAST_UPDATE_OPER:Coloured
     *
     * @mbg.generated Sat Dec 15 00:05:03 CST 2018
     */
    public boolean isLastUpdateOperNotColoured() {
        return !lastUpdateOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_execution_task_output.LAST_UPDATE_OPER
     *
     * @param lastUpdateOper the value for wf_execution_task_output.LAST_UPDATE_OPER
     *
     * @mbg.generated Sat Dec 15 00:05:03 CST 2018
     */
    public void setLastUpdateOper(String lastUpdateOper) {
        this.lastUpdateOper = lastUpdateOper == null ? null : lastUpdateOper.trim();
        this.lastUpdateOperColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_execution_task_output.LAST_UPDATE_OPER:Coloured
     *
     * @param lastUpdateOperColoured the value for wf_execution_task_output.LAST_UPDATE_OPER:Coloured
     *
     * @mbg.generated Sat Dec 15 00:05:03 CST 2018
     */
    public void setLastUpdateOperColoured(boolean lastUpdateOperColoured) {
        this.lastUpdateOperColoured = lastUpdateOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_execution_task_output.CREATE_TIME
     *
     * @return the value of wf_execution_task_output.CREATE_TIME
     *
     * @mbg.generated Sat Dec 15 00:05:03 CST 2018
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_execution_task_output.CREATE_TIME:Coloured
     *
     * @return the value of wf_execution_task_output.CREATE_TIME:Coloured
     *
     * @mbg.generated Sat Dec 15 00:05:03 CST 2018
     */
    public boolean isCreateTimeColoured() {
        return createTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_execution_task_output.CREATE_TIME:Coloured
     *
     * @return the value of wf_execution_task_output.CREATE_TIME:Coloured
     *
     * @mbg.generated Sat Dec 15 00:05:03 CST 2018
     */
    public boolean isCreateTimeNotColoured() {
        return !createTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_execution_task_output.CREATE_TIME
     *
     * @param createTime the value for wf_execution_task_output.CREATE_TIME
     *
     * @mbg.generated Sat Dec 15 00:05:03 CST 2018
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
        this.createTimeColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_execution_task_output.CREATE_TIME:Coloured
     *
     * @param createTimeColoured the value for wf_execution_task_output.CREATE_TIME:Coloured
     *
     * @mbg.generated Sat Dec 15 00:05:03 CST 2018
     */
    public void setCreateTimeColoured(boolean createTimeColoured) {
        this.createTimeColoured = createTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_execution_task_output.CREATE_OPER
     *
     * @return the value of wf_execution_task_output.CREATE_OPER
     *
     * @mbg.generated Sat Dec 15 00:05:03 CST 2018
     */
    public String getCreateOper() {
        return createOper;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_execution_task_output.CREATE_OPER:Coloured
     *
     * @return the value of wf_execution_task_output.CREATE_OPER:Coloured
     *
     * @mbg.generated Sat Dec 15 00:05:03 CST 2018
     */
    public boolean isCreateOperColoured() {
        return createOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_execution_task_output.CREATE_OPER:Coloured
     *
     * @return the value of wf_execution_task_output.CREATE_OPER:Coloured
     *
     * @mbg.generated Sat Dec 15 00:05:03 CST 2018
     */
    public boolean isCreateOperNotColoured() {
        return !createOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_execution_task_output.CREATE_OPER
     *
     * @param createOper the value for wf_execution_task_output.CREATE_OPER
     *
     * @mbg.generated Sat Dec 15 00:05:03 CST 2018
     */
    public void setCreateOper(String createOper) {
        this.createOper = createOper == null ? null : createOper.trim();
        this.createOperColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_execution_task_output.CREATE_OPER:Coloured
     *
     * @param createOperColoured the value for wf_execution_task_output.CREATE_OPER:Coloured
     *
     * @mbg.generated Sat Dec 15 00:05:03 CST 2018
     */
    public void setCreateOperColoured(boolean createOperColoured) {
        this.createOperColoured = createOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_execution_task_output
     *
     * @mbg.generated Sat Dec 15 00:05:03 CST 2018
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
        WfExecutionTaskOutput other = (WfExecutionTaskOutput) that;
        return (this.getTaskId() == null ? other.getTaskId() == null : this.getTaskId().equals(other.getTaskId()))
            && (this.getCharId() == null ? other.getCharId() == null : this.getCharId().equals(other.getCharId()))
            && (this.getCharValue() == null ? other.getCharValue() == null : this.getCharValue().equals(other.getCharValue()))
            && (this.getOutputState() == null ? other.getOutputState() == null : this.getOutputState().equals(other.getOutputState()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getLastUpdateTime() == null ? other.getLastUpdateTime() == null : this.getLastUpdateTime().equals(other.getLastUpdateTime()))
            && (this.getLastUpdateOper() == null ? other.getLastUpdateOper() == null : this.getLastUpdateOper().equals(other.getLastUpdateOper()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getCreateOper() == null ? other.getCreateOper() == null : this.getCreateOper().equals(other.getCreateOper()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_execution_task_output
     *
     * @mbg.generated Sat Dec 15 00:05:03 CST 2018
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getTaskId() == null) ? 0 : getTaskId().hashCode());
        result = prime * result + ((getCharId() == null) ? 0 : getCharId().hashCode());
        result = prime * result + ((getCharValue() == null) ? 0 : getCharValue().hashCode());
        result = prime * result + ((getOutputState() == null) ? 0 : getOutputState().hashCode());
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
     * This method corresponds to the database table wf_execution_task_output
     *
     * @mbg.generated Sat Dec 15 00:05:03 CST 2018
     */
    public void copyProperties(WfExecutionTaskOutput that) {
        if (this == that || that == null) {
            return;
        }
        if(that.isTaskIdColoured() ) {this.setTaskId(that.getTaskId() );}
        if(that.isCharIdColoured() ) {this.setCharId(that.getCharId() );}
        if(that.isCharValueColoured() ) {this.setCharValue(that.getCharValue() );}
        if(that.isOutputStateColoured() ) {this.setOutputState(that.getOutputState() );}
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
     * This method corresponds to the database table wf_execution_task_output
     *
     * @mbg.generated Sat Dec 15 00:05:03 CST 2018
     */
    @Override
    public JSONObject toJSON() {
        HashMap<String, Object> hashMap = new HashMap();
        if(this.taskIdColoured) {hashMap.put("taskId", this.taskId);}
        if(this.charIdColoured) {hashMap.put("charId", this.charId);}
        if(this.charValueColoured) {hashMap.put("charValue", this.charValue);}
        if(this.outputStateColoured) {hashMap.put("outputState", this.outputState);}
        if(this.descriptionColoured) {hashMap.put("description", this.description);}
        if(this.statusColoured) {hashMap.put("status", this.status);}
        if(this.lastUpdateTimeColoured) {hashMap.put("lastUpdateTime", this.lastUpdateTime);}
        if(this.lastUpdateOperColoured) {hashMap.put("lastUpdateOper", this.lastUpdateOper);}
        if(this.createTimeColoured) {hashMap.put("createTime", this.createTime);}
        if(this.createOperColoured) {hashMap.put("createOper", this.createOper);}
        return (JSONObject) JSON.toJSON(hashMap);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_execution_task_output
     *
     * @mbg.generated Sat Dec 15 00:05:03 CST 2018
     */
    @Override
    public void clear() {
        if(this.taskIdColoured) {this.taskId = null; this.taskIdColoured = false;}
        if(this.charIdColoured) {this.charId = null; this.charIdColoured = false;}
        if(this.charValueColoured) {this.charValue = null; this.charValueColoured = false;}
        if(this.outputStateColoured) {this.outputState = null; this.outputStateColoured = false;}
        if(this.descriptionColoured) {this.description = null; this.descriptionColoured = false;}
        if(this.statusColoured) {this.status = null; this.statusColoured = false;}
        if(this.lastUpdateTimeColoured) {this.lastUpdateTime = null; this.lastUpdateTimeColoured = false;}
        if(this.lastUpdateOperColoured) {this.lastUpdateOper = null; this.lastUpdateOperColoured = false;}
        if(this.createTimeColoured) {this.createTime = null; this.createTimeColoured = false;}
        if(this.createOperColoured) {this.createOper = null; this.createOperColoured = false;}
        return;
    }
}