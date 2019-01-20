package com.yatop.lambda.base.model;

import com.alibaba.fastjson.JSONObject;
import com.yatop.lambda.base.utils.LambdaRootModel;
import java.io.Serializable;
import java.util.Date;

public class WfFlowAccumulate extends LambdaRootModel implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_accumulate.FLOW_ID
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    private Long flowId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_accumulate.FLOW_ID:Coloured
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    private boolean flowIdColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_accumulate.MODULE_ID
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    private Long moduleId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_accumulate.MODULE_ID:Coloured
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    private boolean moduleIdColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_accumulate.USAGE_COUNT
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    private Long usageCount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_accumulate.USAGE_COUNT:Coloured
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    private boolean usageCountColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_accumulate.DESCRIPTION
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    private String description;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_accumulate.DESCRIPTION:Coloured
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    private boolean descriptionColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_accumulate.STATUS
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    private Integer status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_accumulate.STATUS:Coloured
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    private boolean statusColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_accumulate.LAST_UPDATE_TIME
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    private Date lastUpdateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_accumulate.LAST_UPDATE_TIME:Coloured
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    private boolean lastUpdateTimeColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_accumulate.LAST_UPDATE_OPER
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    private String lastUpdateOper;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_accumulate.LAST_UPDATE_OPER:Coloured
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    private boolean lastUpdateOperColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_accumulate.CREATE_TIME
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_accumulate.CREATE_TIME:Coloured
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    private boolean createTimeColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_accumulate.CREATE_OPER
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    private String createOper;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_accumulate.CREATE_OPER:Coloured
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    private boolean createOperColoured;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table wf_flow_accumulate
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_accumulate.FLOW_ID
     *
     * @return the value of wf_flow_accumulate.FLOW_ID
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    public Long getFlowId() {
        return flowId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_accumulate.FLOW_ID:Coloured
     *
     * @return the value of wf_flow_accumulate.FLOW_ID:Coloured
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    public boolean isFlowIdColoured() {
        return flowIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_accumulate.FLOW_ID:Coloured
     *
     * @return the value of wf_flow_accumulate.FLOW_ID:Coloured
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    public boolean isFlowIdNotColoured() {
        return !flowIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_accumulate.FLOW_ID
     *
     * @param flowId the value for wf_flow_accumulate.FLOW_ID
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    public void setFlowId(Long flowId) {
        this.flowId = flowId;
        this.flowIdColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_accumulate.FLOW_ID:Coloured
     *
     * @param flowIdColoured the value for wf_flow_accumulate.FLOW_ID:Coloured
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    public void setFlowIdColoured(boolean flowIdColoured) {
        this.flowIdColoured = flowIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_accumulate.MODULE_ID
     *
     * @return the value of wf_flow_accumulate.MODULE_ID
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    public Long getModuleId() {
        return moduleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_accumulate.MODULE_ID:Coloured
     *
     * @return the value of wf_flow_accumulate.MODULE_ID:Coloured
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    public boolean isModuleIdColoured() {
        return moduleIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_accumulate.MODULE_ID:Coloured
     *
     * @return the value of wf_flow_accumulate.MODULE_ID:Coloured
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    public boolean isModuleIdNotColoured() {
        return !moduleIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_accumulate.MODULE_ID
     *
     * @param moduleId the value for wf_flow_accumulate.MODULE_ID
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    public void setModuleId(Long moduleId) {
        this.moduleId = moduleId;
        this.moduleIdColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_accumulate.MODULE_ID:Coloured
     *
     * @param moduleIdColoured the value for wf_flow_accumulate.MODULE_ID:Coloured
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    public void setModuleIdColoured(boolean moduleIdColoured) {
        this.moduleIdColoured = moduleIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_accumulate.USAGE_COUNT
     *
     * @return the value of wf_flow_accumulate.USAGE_COUNT
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    public Long getUsageCount() {
        return usageCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_accumulate.USAGE_COUNT:Coloured
     *
     * @return the value of wf_flow_accumulate.USAGE_COUNT:Coloured
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    public boolean isUsageCountColoured() {
        return usageCountColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_accumulate.USAGE_COUNT:Coloured
     *
     * @return the value of wf_flow_accumulate.USAGE_COUNT:Coloured
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    public boolean isUsageCountNotColoured() {
        return !usageCountColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_accumulate.USAGE_COUNT
     *
     * @param usageCount the value for wf_flow_accumulate.USAGE_COUNT
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    public void setUsageCount(Long usageCount) {
        this.usageCount = usageCount;
        this.usageCountColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_accumulate.USAGE_COUNT:Coloured
     *
     * @param usageCountColoured the value for wf_flow_accumulate.USAGE_COUNT:Coloured
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    public void setUsageCountColoured(boolean usageCountColoured) {
        this.usageCountColoured = usageCountColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_accumulate.DESCRIPTION
     *
     * @return the value of wf_flow_accumulate.DESCRIPTION
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_accumulate.DESCRIPTION:Coloured
     *
     * @return the value of wf_flow_accumulate.DESCRIPTION:Coloured
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    public boolean isDescriptionColoured() {
        return descriptionColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_accumulate.DESCRIPTION:Coloured
     *
     * @return the value of wf_flow_accumulate.DESCRIPTION:Coloured
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    public boolean isDescriptionNotColoured() {
        return !descriptionColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_accumulate.DESCRIPTION
     *
     * @param description the value for wf_flow_accumulate.DESCRIPTION
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
        this.descriptionColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_accumulate.DESCRIPTION:Coloured
     *
     * @param descriptionColoured the value for wf_flow_accumulate.DESCRIPTION:Coloured
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    public void setDescriptionColoured(boolean descriptionColoured) {
        this.descriptionColoured = descriptionColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_accumulate.STATUS
     *
     * @return the value of wf_flow_accumulate.STATUS
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_accumulate.STATUS:Coloured
     *
     * @return the value of wf_flow_accumulate.STATUS:Coloured
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    public boolean isStatusColoured() {
        return statusColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_accumulate.STATUS:Coloured
     *
     * @return the value of wf_flow_accumulate.STATUS:Coloured
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    public boolean isStatusNotColoured() {
        return !statusColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_accumulate.STATUS
     *
     * @param status the value for wf_flow_accumulate.STATUS
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    public void setStatus(Integer status) {
        this.status = status;
        this.statusColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_accumulate.STATUS:Coloured
     *
     * @param statusColoured the value for wf_flow_accumulate.STATUS:Coloured
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    public void setStatusColoured(boolean statusColoured) {
        this.statusColoured = statusColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_accumulate.LAST_UPDATE_TIME
     *
     * @return the value of wf_flow_accumulate.LAST_UPDATE_TIME
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_accumulate.LAST_UPDATE_TIME:Coloured
     *
     * @return the value of wf_flow_accumulate.LAST_UPDATE_TIME:Coloured
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    public boolean isLastUpdateTimeColoured() {
        return lastUpdateTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_accumulate.LAST_UPDATE_TIME:Coloured
     *
     * @return the value of wf_flow_accumulate.LAST_UPDATE_TIME:Coloured
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    public boolean isLastUpdateTimeNotColoured() {
        return !lastUpdateTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_accumulate.LAST_UPDATE_TIME
     *
     * @param lastUpdateTime the value for wf_flow_accumulate.LAST_UPDATE_TIME
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
        this.lastUpdateTimeColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_accumulate.LAST_UPDATE_TIME:Coloured
     *
     * @param lastUpdateTimeColoured the value for wf_flow_accumulate.LAST_UPDATE_TIME:Coloured
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    public void setLastUpdateTimeColoured(boolean lastUpdateTimeColoured) {
        this.lastUpdateTimeColoured = lastUpdateTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_accumulate.LAST_UPDATE_OPER
     *
     * @return the value of wf_flow_accumulate.LAST_UPDATE_OPER
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    public String getLastUpdateOper() {
        return lastUpdateOper;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_accumulate.LAST_UPDATE_OPER:Coloured
     *
     * @return the value of wf_flow_accumulate.LAST_UPDATE_OPER:Coloured
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    public boolean isLastUpdateOperColoured() {
        return lastUpdateOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_accumulate.LAST_UPDATE_OPER:Coloured
     *
     * @return the value of wf_flow_accumulate.LAST_UPDATE_OPER:Coloured
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    public boolean isLastUpdateOperNotColoured() {
        return !lastUpdateOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_accumulate.LAST_UPDATE_OPER
     *
     * @param lastUpdateOper the value for wf_flow_accumulate.LAST_UPDATE_OPER
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    public void setLastUpdateOper(String lastUpdateOper) {
        this.lastUpdateOper = lastUpdateOper == null ? null : lastUpdateOper.trim();
        this.lastUpdateOperColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_accumulate.LAST_UPDATE_OPER:Coloured
     *
     * @param lastUpdateOperColoured the value for wf_flow_accumulate.LAST_UPDATE_OPER:Coloured
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    public void setLastUpdateOperColoured(boolean lastUpdateOperColoured) {
        this.lastUpdateOperColoured = lastUpdateOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_accumulate.CREATE_TIME
     *
     * @return the value of wf_flow_accumulate.CREATE_TIME
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_accumulate.CREATE_TIME:Coloured
     *
     * @return the value of wf_flow_accumulate.CREATE_TIME:Coloured
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    public boolean isCreateTimeColoured() {
        return createTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_accumulate.CREATE_TIME:Coloured
     *
     * @return the value of wf_flow_accumulate.CREATE_TIME:Coloured
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    public boolean isCreateTimeNotColoured() {
        return !createTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_accumulate.CREATE_TIME
     *
     * @param createTime the value for wf_flow_accumulate.CREATE_TIME
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
        this.createTimeColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_accumulate.CREATE_TIME:Coloured
     *
     * @param createTimeColoured the value for wf_flow_accumulate.CREATE_TIME:Coloured
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    public void setCreateTimeColoured(boolean createTimeColoured) {
        this.createTimeColoured = createTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_accumulate.CREATE_OPER
     *
     * @return the value of wf_flow_accumulate.CREATE_OPER
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    public String getCreateOper() {
        return createOper;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_accumulate.CREATE_OPER:Coloured
     *
     * @return the value of wf_flow_accumulate.CREATE_OPER:Coloured
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    public boolean isCreateOperColoured() {
        return createOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_accumulate.CREATE_OPER:Coloured
     *
     * @return the value of wf_flow_accumulate.CREATE_OPER:Coloured
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    public boolean isCreateOperNotColoured() {
        return !createOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_accumulate.CREATE_OPER
     *
     * @param createOper the value for wf_flow_accumulate.CREATE_OPER
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    public void setCreateOper(String createOper) {
        this.createOper = createOper == null ? null : createOper.trim();
        this.createOperColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_accumulate.CREATE_OPER:Coloured
     *
     * @param createOperColoured the value for wf_flow_accumulate.CREATE_OPER:Coloured
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    public void setCreateOperColoured(boolean createOperColoured) {
        this.createOperColoured = createOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_accumulate
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if(!(that instanceof WfFlowAccumulate)) {
            return false;
        }
        WfFlowAccumulate other = (WfFlowAccumulate) that;
        return (this.getFlowId() == null ? other.getFlowId() == null : this.getFlowId().equals(other.getFlowId()))
            && (this.getModuleId() == null ? other.getModuleId() == null : this.getModuleId().equals(other.getModuleId()))
            && (this.getUsageCount() == null ? other.getUsageCount() == null : this.getUsageCount().equals(other.getUsageCount()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getLastUpdateTime() == null ? other.getLastUpdateTime() == null : this.getLastUpdateTime().equals(other.getLastUpdateTime()))
            && (this.getLastUpdateOper() == null ? other.getLastUpdateOper() == null : this.getLastUpdateOper().equals(other.getLastUpdateOper()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getCreateOper() == null ? other.getCreateOper() == null : this.getCreateOper().equals(other.getCreateOper()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_accumulate
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getFlowId() == null) ? 0 : getFlowId().hashCode());
        result = prime * result + ((getModuleId() == null) ? 0 : getModuleId().hashCode());
        result = prime * result + ((getUsageCount() == null) ? 0 : getUsageCount().hashCode());
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
     * This method corresponds to the database table wf_flow_accumulate
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    public void copyProperties(WfFlowAccumulate that) {
        if (this == that || that == null) {
            return;
        }
        if(that.isFlowIdColoured() ) {this.setFlowId(that.getFlowId() );}
        if(that.isModuleIdColoured() ) {this.setModuleId(that.getModuleId() );}
        if(that.isUsageCountColoured() ) {this.setUsageCount(that.getUsageCount() );}
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
     * This method corresponds to the database table wf_flow_accumulate
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    @Override
    public JSONObject toJSON() {
        JSONObject jsonObj = new JSONObject(32, true);
        if(this.flowId != null) {jsonObj.put("flowId", this.flowId);}
        if(this.moduleId != null) {jsonObj.put("moduleId", this.moduleId);}
        if(this.usageCount != null) {jsonObj.put("usageCount", this.usageCount);}
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
     * This method corresponds to the database table wf_flow_accumulate
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    @Override
    public void clear() {
         this.flowId = null; this.flowIdColoured = false;
         this.moduleId = null; this.moduleIdColoured = false;
         this.usageCount = null; this.usageCountColoured = false;
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
     * This method corresponds to the database table wf_flow_accumulate
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    @Override
    public void clearColoured() {
        this.flowIdColoured = false;
        this.moduleIdColoured = false;
        this.usageCountColoured = false;
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
     * This method corresponds to the database table wf_flow_accumulate
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    @Override
    public boolean isColoured() {
        if(this.flowIdColoured) return true;
        if(this.moduleIdColoured) return true;
        if(this.usageCountColoured) return true;
        if(this.descriptionColoured) return true;
        if(this.statusColoured) return true;
        if(this.lastUpdateTimeColoured) return true;
        if(this.lastUpdateOperColoured) return true;
        if(this.createTimeColoured) return true;
        if(this.createOperColoured) return true;
        return false;
    }
}