package com.yatop.lambda.base.model;

import com.alibaba.fastjson.JSONObject;
import com.yatop.lambda.base.utils.LambdaRootModel;
import java.io.Serializable;
import java.util.Date;

public class WfCfgModulePropTab extends LambdaRootModel implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_cfg_module_prop_tab.TAB_ID
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    private Long tabId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_cfg_module_prop_tab.TAB_ID:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    private boolean tabIdColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_cfg_module_prop_tab.TAB_NAME
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    private String tabName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_cfg_module_prop_tab.TAB_NAME:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    private boolean tabNameColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_cfg_module_prop_tab.PRIORITY
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    private Integer priority;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_cfg_module_prop_tab.PRIORITY:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    private boolean priorityColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_cfg_module_prop_tab.DESCRIPTION
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    private String description;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_cfg_module_prop_tab.DESCRIPTION:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    private boolean descriptionColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_cfg_module_prop_tab.STATUS
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    private Integer status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_cfg_module_prop_tab.STATUS:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    private boolean statusColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_cfg_module_prop_tab.LAST_UPDATE_TIME
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    private Date lastUpdateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_cfg_module_prop_tab.LAST_UPDATE_TIME:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    private boolean lastUpdateTimeColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_cfg_module_prop_tab.LAST_UPDATE_OPER
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    private String lastUpdateOper;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_cfg_module_prop_tab.LAST_UPDATE_OPER:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    private boolean lastUpdateOperColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_cfg_module_prop_tab.CREATE_TIME
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_cfg_module_prop_tab.CREATE_TIME:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    private boolean createTimeColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_cfg_module_prop_tab.CREATE_OPER
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    private String createOper;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_cfg_module_prop_tab.CREATE_OPER:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    private boolean createOperColoured;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table wf_cfg_module_prop_tab
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_cfg_module_prop_tab.TAB_ID
     *
     * @return the value of wf_cfg_module_prop_tab.TAB_ID
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public Long getTabId() {
        return tabId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_cfg_module_prop_tab.TAB_ID:Coloured
     *
     * @return the value of wf_cfg_module_prop_tab.TAB_ID:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public boolean isTabIdColoured() {
        return tabIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_cfg_module_prop_tab.TAB_ID:Coloured
     *
     * @return the value of wf_cfg_module_prop_tab.TAB_ID:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public boolean isTabIdNotColoured() {
        return !tabIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_cfg_module_prop_tab.TAB_ID
     *
     * @param tabId the value for wf_cfg_module_prop_tab.TAB_ID
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public void setTabId(Long tabId) {
        this.tabId = tabId;
        this.tabIdColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_cfg_module_prop_tab.TAB_ID:Coloured
     *
     * @param tabIdColoured the value for wf_cfg_module_prop_tab.TAB_ID:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public void setTabIdColoured(boolean tabIdColoured) {
        this.tabIdColoured = tabIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_cfg_module_prop_tab.TAB_NAME
     *
     * @return the value of wf_cfg_module_prop_tab.TAB_NAME
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public String getTabName() {
        return tabName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_cfg_module_prop_tab.TAB_NAME:Coloured
     *
     * @return the value of wf_cfg_module_prop_tab.TAB_NAME:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public boolean isTabNameColoured() {
        return tabNameColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_cfg_module_prop_tab.TAB_NAME:Coloured
     *
     * @return the value of wf_cfg_module_prop_tab.TAB_NAME:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public boolean isTabNameNotColoured() {
        return !tabNameColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_cfg_module_prop_tab.TAB_NAME
     *
     * @param tabName the value for wf_cfg_module_prop_tab.TAB_NAME
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public void setTabName(String tabName) {
        this.tabName = tabName == null ? null : tabName.trim();
        this.tabNameColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_cfg_module_prop_tab.TAB_NAME:Coloured
     *
     * @param tabNameColoured the value for wf_cfg_module_prop_tab.TAB_NAME:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public void setTabNameColoured(boolean tabNameColoured) {
        this.tabNameColoured = tabNameColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_cfg_module_prop_tab.PRIORITY
     *
     * @return the value of wf_cfg_module_prop_tab.PRIORITY
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public Integer getPriority() {
        return priority;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_cfg_module_prop_tab.PRIORITY:Coloured
     *
     * @return the value of wf_cfg_module_prop_tab.PRIORITY:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public boolean isPriorityColoured() {
        return priorityColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_cfg_module_prop_tab.PRIORITY:Coloured
     *
     * @return the value of wf_cfg_module_prop_tab.PRIORITY:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public boolean isPriorityNotColoured() {
        return !priorityColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_cfg_module_prop_tab.PRIORITY
     *
     * @param priority the value for wf_cfg_module_prop_tab.PRIORITY
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public void setPriority(Integer priority) {
        this.priority = priority;
        this.priorityColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_cfg_module_prop_tab.PRIORITY:Coloured
     *
     * @param priorityColoured the value for wf_cfg_module_prop_tab.PRIORITY:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public void setPriorityColoured(boolean priorityColoured) {
        this.priorityColoured = priorityColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_cfg_module_prop_tab.DESCRIPTION
     *
     * @return the value of wf_cfg_module_prop_tab.DESCRIPTION
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_cfg_module_prop_tab.DESCRIPTION:Coloured
     *
     * @return the value of wf_cfg_module_prop_tab.DESCRIPTION:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public boolean isDescriptionColoured() {
        return descriptionColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_cfg_module_prop_tab.DESCRIPTION:Coloured
     *
     * @return the value of wf_cfg_module_prop_tab.DESCRIPTION:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public boolean isDescriptionNotColoured() {
        return !descriptionColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_cfg_module_prop_tab.DESCRIPTION
     *
     * @param description the value for wf_cfg_module_prop_tab.DESCRIPTION
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
        this.descriptionColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_cfg_module_prop_tab.DESCRIPTION:Coloured
     *
     * @param descriptionColoured the value for wf_cfg_module_prop_tab.DESCRIPTION:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public void setDescriptionColoured(boolean descriptionColoured) {
        this.descriptionColoured = descriptionColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_cfg_module_prop_tab.STATUS
     *
     * @return the value of wf_cfg_module_prop_tab.STATUS
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_cfg_module_prop_tab.STATUS:Coloured
     *
     * @return the value of wf_cfg_module_prop_tab.STATUS:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public boolean isStatusColoured() {
        return statusColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_cfg_module_prop_tab.STATUS:Coloured
     *
     * @return the value of wf_cfg_module_prop_tab.STATUS:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public boolean isStatusNotColoured() {
        return !statusColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_cfg_module_prop_tab.STATUS
     *
     * @param status the value for wf_cfg_module_prop_tab.STATUS
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public void setStatus(Integer status) {
        this.status = status;
        this.statusColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_cfg_module_prop_tab.STATUS:Coloured
     *
     * @param statusColoured the value for wf_cfg_module_prop_tab.STATUS:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public void setStatusColoured(boolean statusColoured) {
        this.statusColoured = statusColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_cfg_module_prop_tab.LAST_UPDATE_TIME
     *
     * @return the value of wf_cfg_module_prop_tab.LAST_UPDATE_TIME
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_cfg_module_prop_tab.LAST_UPDATE_TIME:Coloured
     *
     * @return the value of wf_cfg_module_prop_tab.LAST_UPDATE_TIME:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public boolean isLastUpdateTimeColoured() {
        return lastUpdateTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_cfg_module_prop_tab.LAST_UPDATE_TIME:Coloured
     *
     * @return the value of wf_cfg_module_prop_tab.LAST_UPDATE_TIME:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public boolean isLastUpdateTimeNotColoured() {
        return !lastUpdateTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_cfg_module_prop_tab.LAST_UPDATE_TIME
     *
     * @param lastUpdateTime the value for wf_cfg_module_prop_tab.LAST_UPDATE_TIME
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
        this.lastUpdateTimeColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_cfg_module_prop_tab.LAST_UPDATE_TIME:Coloured
     *
     * @param lastUpdateTimeColoured the value for wf_cfg_module_prop_tab.LAST_UPDATE_TIME:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public void setLastUpdateTimeColoured(boolean lastUpdateTimeColoured) {
        this.lastUpdateTimeColoured = lastUpdateTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_cfg_module_prop_tab.LAST_UPDATE_OPER
     *
     * @return the value of wf_cfg_module_prop_tab.LAST_UPDATE_OPER
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public String getLastUpdateOper() {
        return lastUpdateOper;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_cfg_module_prop_tab.LAST_UPDATE_OPER:Coloured
     *
     * @return the value of wf_cfg_module_prop_tab.LAST_UPDATE_OPER:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public boolean isLastUpdateOperColoured() {
        return lastUpdateOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_cfg_module_prop_tab.LAST_UPDATE_OPER:Coloured
     *
     * @return the value of wf_cfg_module_prop_tab.LAST_UPDATE_OPER:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public boolean isLastUpdateOperNotColoured() {
        return !lastUpdateOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_cfg_module_prop_tab.LAST_UPDATE_OPER
     *
     * @param lastUpdateOper the value for wf_cfg_module_prop_tab.LAST_UPDATE_OPER
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public void setLastUpdateOper(String lastUpdateOper) {
        this.lastUpdateOper = lastUpdateOper == null ? null : lastUpdateOper.trim();
        this.lastUpdateOperColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_cfg_module_prop_tab.LAST_UPDATE_OPER:Coloured
     *
     * @param lastUpdateOperColoured the value for wf_cfg_module_prop_tab.LAST_UPDATE_OPER:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public void setLastUpdateOperColoured(boolean lastUpdateOperColoured) {
        this.lastUpdateOperColoured = lastUpdateOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_cfg_module_prop_tab.CREATE_TIME
     *
     * @return the value of wf_cfg_module_prop_tab.CREATE_TIME
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_cfg_module_prop_tab.CREATE_TIME:Coloured
     *
     * @return the value of wf_cfg_module_prop_tab.CREATE_TIME:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public boolean isCreateTimeColoured() {
        return createTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_cfg_module_prop_tab.CREATE_TIME:Coloured
     *
     * @return the value of wf_cfg_module_prop_tab.CREATE_TIME:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public boolean isCreateTimeNotColoured() {
        return !createTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_cfg_module_prop_tab.CREATE_TIME
     *
     * @param createTime the value for wf_cfg_module_prop_tab.CREATE_TIME
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
        this.createTimeColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_cfg_module_prop_tab.CREATE_TIME:Coloured
     *
     * @param createTimeColoured the value for wf_cfg_module_prop_tab.CREATE_TIME:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public void setCreateTimeColoured(boolean createTimeColoured) {
        this.createTimeColoured = createTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_cfg_module_prop_tab.CREATE_OPER
     *
     * @return the value of wf_cfg_module_prop_tab.CREATE_OPER
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public String getCreateOper() {
        return createOper;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_cfg_module_prop_tab.CREATE_OPER:Coloured
     *
     * @return the value of wf_cfg_module_prop_tab.CREATE_OPER:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public boolean isCreateOperColoured() {
        return createOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_cfg_module_prop_tab.CREATE_OPER:Coloured
     *
     * @return the value of wf_cfg_module_prop_tab.CREATE_OPER:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public boolean isCreateOperNotColoured() {
        return !createOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_cfg_module_prop_tab.CREATE_OPER
     *
     * @param createOper the value for wf_cfg_module_prop_tab.CREATE_OPER
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public void setCreateOper(String createOper) {
        this.createOper = createOper == null ? null : createOper.trim();
        this.createOperColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_cfg_module_prop_tab.CREATE_OPER:Coloured
     *
     * @param createOperColoured the value for wf_cfg_module_prop_tab.CREATE_OPER:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public void setCreateOperColoured(boolean createOperColoured) {
        this.createOperColoured = createOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_cfg_module_prop_tab
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
        if(!(that instanceof WfCfgModulePropTab)) {
            return false;
        }
        WfCfgModulePropTab other = (WfCfgModulePropTab) that;
        return (this.getTabId() == null ? other.getTabId() == null : this.getTabId().equals(other.getTabId()))
            && (this.getTabName() == null ? other.getTabName() == null : this.getTabName().equals(other.getTabName()))
            && (this.getPriority() == null ? other.getPriority() == null : this.getPriority().equals(other.getPriority()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getLastUpdateTime() == null ? other.getLastUpdateTime() == null : this.getLastUpdateTime().equals(other.getLastUpdateTime()))
            && (this.getLastUpdateOper() == null ? other.getLastUpdateOper() == null : this.getLastUpdateOper().equals(other.getLastUpdateOper()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getCreateOper() == null ? other.getCreateOper() == null : this.getCreateOper().equals(other.getCreateOper()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_cfg_module_prop_tab
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getTabId() == null) ? 0 : getTabId().hashCode());
        result = prime * result + ((getTabName() == null) ? 0 : getTabName().hashCode());
        result = prime * result + ((getPriority() == null) ? 0 : getPriority().hashCode());
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
     * This method corresponds to the database table wf_cfg_module_prop_tab
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public void copyProperties(WfCfgModulePropTab that) {
        if (this == that || that == null) {
            return;
        }
        if(that.isTabIdColoured() ) {this.setTabId(that.getTabId() );}
        if(that.isTabNameColoured() ) {this.setTabName(that.getTabName() );}
        if(that.isPriorityColoured() ) {this.setPriority(that.getPriority() );}
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
     * This method corresponds to the database table wf_cfg_module_prop_tab
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public WfCfgModulePropTab makeCopy() {
        WfCfgModulePropTab copy = new WfCfgModulePropTab();
        if(this.tabId != null ) {copy.tabId = this.tabId;}
        if(this.tabName != null ) {copy.tabName = this.tabName;}
        if(this.priority != null ) {copy.priority = this.priority;}
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
     * This method corresponds to the database table wf_cfg_module_prop_tab
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    @Override
    public JSONObject toJSON() {
        JSONObject jsonObj = new JSONObject(32, true);
        if(this.tabId != null) {jsonObj.put("tabId", this.tabId);}
        if(this.tabName != null) {jsonObj.put("tabName", this.tabName);}
        if(this.priority != null) {jsonObj.put("priority", this.priority);}
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
     * This method corresponds to the database table wf_cfg_module_prop_tab
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    @Override
    public void clear() {
         this.tabId = null; this.tabIdColoured = false;
         this.tabName = null; this.tabNameColoured = false;
         this.priority = null; this.priorityColoured = false;
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
     * This method corresponds to the database table wf_cfg_module_prop_tab
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    @Override
    public void clearColoured() {
        this.tabIdColoured = false;
        this.tabNameColoured = false;
        this.priorityColoured = false;
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
     * This method corresponds to the database table wf_cfg_module_prop_tab
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    @Override
    public boolean isColoured() {
        if(this.tabIdColoured) return true;
        if(this.tabNameColoured) return true;
        if(this.priorityColoured) return true;
        if(this.descriptionColoured) return true;
        if(this.statusColoured) return true;
        if(this.lastUpdateTimeColoured) return true;
        if(this.lastUpdateOperColoured) return true;
        if(this.createTimeColoured) return true;
        if(this.createOperColoured) return true;
        return false;
    }
}