package com.yatop.lambda.base.model;

import com.alibaba.fastjson.JSONObject;
import com.yatop.lambda.base.utils.LambdaRootModel;
import java.io.Serializable;
import java.util.Date;

public class WfCfgSpecification extends LambdaRootModel implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_cfg_specification.SPEC_ID
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    private String specId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_cfg_specification.SPEC_ID:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    private boolean specIdColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_cfg_specification.SPEC_NAME
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    private String specName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_cfg_specification.SPEC_NAME:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    private boolean specNameColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_cfg_specification.SPEC_TYPE
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    private Integer specType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_cfg_specification.SPEC_TYPE:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    private boolean specTypeColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_cfg_specification.DESCRIPTION
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    private String description;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_cfg_specification.DESCRIPTION:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    private boolean descriptionColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_cfg_specification.STATUS
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    private Integer status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_cfg_specification.STATUS:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    private boolean statusColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_cfg_specification.LAST_UPDATE_TIME
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    private Date lastUpdateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_cfg_specification.LAST_UPDATE_TIME:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    private boolean lastUpdateTimeColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_cfg_specification.LAST_UPDATE_OPER
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    private String lastUpdateOper;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_cfg_specification.LAST_UPDATE_OPER:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    private boolean lastUpdateOperColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_cfg_specification.CREATE_TIME
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_cfg_specification.CREATE_TIME:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    private boolean createTimeColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_cfg_specification.CREATE_OPER
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    private String createOper;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_cfg_specification.CREATE_OPER:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    private boolean createOperColoured;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table wf_cfg_specification
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_cfg_specification.SPEC_ID
     *
     * @return the value of wf_cfg_specification.SPEC_ID
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public String getSpecId() {
        return specId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_cfg_specification.SPEC_ID:Coloured
     *
     * @return the value of wf_cfg_specification.SPEC_ID:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public boolean isSpecIdColoured() {
        return specIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_cfg_specification.SPEC_ID:Coloured
     *
     * @return the value of wf_cfg_specification.SPEC_ID:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public boolean isSpecIdNotColoured() {
        return !specIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_cfg_specification.SPEC_ID
     *
     * @param specId the value for wf_cfg_specification.SPEC_ID
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public void setSpecId(String specId) {
        this.specId = specId == null ? null : specId.trim();
        this.specIdColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_cfg_specification.SPEC_ID:Coloured
     *
     * @param specIdColoured the value for wf_cfg_specification.SPEC_ID:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public void setSpecIdColoured(boolean specIdColoured) {
        this.specIdColoured = specIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_cfg_specification.SPEC_NAME
     *
     * @return the value of wf_cfg_specification.SPEC_NAME
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public String getSpecName() {
        return specName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_cfg_specification.SPEC_NAME:Coloured
     *
     * @return the value of wf_cfg_specification.SPEC_NAME:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public boolean isSpecNameColoured() {
        return specNameColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_cfg_specification.SPEC_NAME:Coloured
     *
     * @return the value of wf_cfg_specification.SPEC_NAME:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public boolean isSpecNameNotColoured() {
        return !specNameColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_cfg_specification.SPEC_NAME
     *
     * @param specName the value for wf_cfg_specification.SPEC_NAME
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public void setSpecName(String specName) {
        this.specName = specName == null ? null : specName.trim();
        this.specNameColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_cfg_specification.SPEC_NAME:Coloured
     *
     * @param specNameColoured the value for wf_cfg_specification.SPEC_NAME:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public void setSpecNameColoured(boolean specNameColoured) {
        this.specNameColoured = specNameColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_cfg_specification.SPEC_TYPE
     *
     * @return the value of wf_cfg_specification.SPEC_TYPE
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public Integer getSpecType() {
        return specType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_cfg_specification.SPEC_TYPE:Coloured
     *
     * @return the value of wf_cfg_specification.SPEC_TYPE:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public boolean isSpecTypeColoured() {
        return specTypeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_cfg_specification.SPEC_TYPE:Coloured
     *
     * @return the value of wf_cfg_specification.SPEC_TYPE:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public boolean isSpecTypeNotColoured() {
        return !specTypeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_cfg_specification.SPEC_TYPE
     *
     * @param specType the value for wf_cfg_specification.SPEC_TYPE
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public void setSpecType(Integer specType) {
        this.specType = specType;
        this.specTypeColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_cfg_specification.SPEC_TYPE:Coloured
     *
     * @param specTypeColoured the value for wf_cfg_specification.SPEC_TYPE:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public void setSpecTypeColoured(boolean specTypeColoured) {
        this.specTypeColoured = specTypeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_cfg_specification.DESCRIPTION
     *
     * @return the value of wf_cfg_specification.DESCRIPTION
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_cfg_specification.DESCRIPTION:Coloured
     *
     * @return the value of wf_cfg_specification.DESCRIPTION:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public boolean isDescriptionColoured() {
        return descriptionColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_cfg_specification.DESCRIPTION:Coloured
     *
     * @return the value of wf_cfg_specification.DESCRIPTION:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public boolean isDescriptionNotColoured() {
        return !descriptionColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_cfg_specification.DESCRIPTION
     *
     * @param description the value for wf_cfg_specification.DESCRIPTION
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
        this.descriptionColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_cfg_specification.DESCRIPTION:Coloured
     *
     * @param descriptionColoured the value for wf_cfg_specification.DESCRIPTION:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public void setDescriptionColoured(boolean descriptionColoured) {
        this.descriptionColoured = descriptionColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_cfg_specification.STATUS
     *
     * @return the value of wf_cfg_specification.STATUS
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_cfg_specification.STATUS:Coloured
     *
     * @return the value of wf_cfg_specification.STATUS:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public boolean isStatusColoured() {
        return statusColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_cfg_specification.STATUS:Coloured
     *
     * @return the value of wf_cfg_specification.STATUS:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public boolean isStatusNotColoured() {
        return !statusColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_cfg_specification.STATUS
     *
     * @param status the value for wf_cfg_specification.STATUS
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public void setStatus(Integer status) {
        this.status = status;
        this.statusColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_cfg_specification.STATUS:Coloured
     *
     * @param statusColoured the value for wf_cfg_specification.STATUS:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public void setStatusColoured(boolean statusColoured) {
        this.statusColoured = statusColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_cfg_specification.LAST_UPDATE_TIME
     *
     * @return the value of wf_cfg_specification.LAST_UPDATE_TIME
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_cfg_specification.LAST_UPDATE_TIME:Coloured
     *
     * @return the value of wf_cfg_specification.LAST_UPDATE_TIME:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public boolean isLastUpdateTimeColoured() {
        return lastUpdateTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_cfg_specification.LAST_UPDATE_TIME:Coloured
     *
     * @return the value of wf_cfg_specification.LAST_UPDATE_TIME:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public boolean isLastUpdateTimeNotColoured() {
        return !lastUpdateTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_cfg_specification.LAST_UPDATE_TIME
     *
     * @param lastUpdateTime the value for wf_cfg_specification.LAST_UPDATE_TIME
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
        this.lastUpdateTimeColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_cfg_specification.LAST_UPDATE_TIME:Coloured
     *
     * @param lastUpdateTimeColoured the value for wf_cfg_specification.LAST_UPDATE_TIME:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public void setLastUpdateTimeColoured(boolean lastUpdateTimeColoured) {
        this.lastUpdateTimeColoured = lastUpdateTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_cfg_specification.LAST_UPDATE_OPER
     *
     * @return the value of wf_cfg_specification.LAST_UPDATE_OPER
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public String getLastUpdateOper() {
        return lastUpdateOper;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_cfg_specification.LAST_UPDATE_OPER:Coloured
     *
     * @return the value of wf_cfg_specification.LAST_UPDATE_OPER:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public boolean isLastUpdateOperColoured() {
        return lastUpdateOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_cfg_specification.LAST_UPDATE_OPER:Coloured
     *
     * @return the value of wf_cfg_specification.LAST_UPDATE_OPER:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public boolean isLastUpdateOperNotColoured() {
        return !lastUpdateOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_cfg_specification.LAST_UPDATE_OPER
     *
     * @param lastUpdateOper the value for wf_cfg_specification.LAST_UPDATE_OPER
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public void setLastUpdateOper(String lastUpdateOper) {
        this.lastUpdateOper = lastUpdateOper == null ? null : lastUpdateOper.trim();
        this.lastUpdateOperColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_cfg_specification.LAST_UPDATE_OPER:Coloured
     *
     * @param lastUpdateOperColoured the value for wf_cfg_specification.LAST_UPDATE_OPER:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public void setLastUpdateOperColoured(boolean lastUpdateOperColoured) {
        this.lastUpdateOperColoured = lastUpdateOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_cfg_specification.CREATE_TIME
     *
     * @return the value of wf_cfg_specification.CREATE_TIME
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_cfg_specification.CREATE_TIME:Coloured
     *
     * @return the value of wf_cfg_specification.CREATE_TIME:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public boolean isCreateTimeColoured() {
        return createTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_cfg_specification.CREATE_TIME:Coloured
     *
     * @return the value of wf_cfg_specification.CREATE_TIME:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public boolean isCreateTimeNotColoured() {
        return !createTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_cfg_specification.CREATE_TIME
     *
     * @param createTime the value for wf_cfg_specification.CREATE_TIME
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
        this.createTimeColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_cfg_specification.CREATE_TIME:Coloured
     *
     * @param createTimeColoured the value for wf_cfg_specification.CREATE_TIME:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public void setCreateTimeColoured(boolean createTimeColoured) {
        this.createTimeColoured = createTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_cfg_specification.CREATE_OPER
     *
     * @return the value of wf_cfg_specification.CREATE_OPER
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public String getCreateOper() {
        return createOper;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_cfg_specification.CREATE_OPER:Coloured
     *
     * @return the value of wf_cfg_specification.CREATE_OPER:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public boolean isCreateOperColoured() {
        return createOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_cfg_specification.CREATE_OPER:Coloured
     *
     * @return the value of wf_cfg_specification.CREATE_OPER:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public boolean isCreateOperNotColoured() {
        return !createOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_cfg_specification.CREATE_OPER
     *
     * @param createOper the value for wf_cfg_specification.CREATE_OPER
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public void setCreateOper(String createOper) {
        this.createOper = createOper == null ? null : createOper.trim();
        this.createOperColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_cfg_specification.CREATE_OPER:Coloured
     *
     * @param createOperColoured the value for wf_cfg_specification.CREATE_OPER:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public void setCreateOperColoured(boolean createOperColoured) {
        this.createOperColoured = createOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_cfg_specification
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
        if(!(that instanceof WfCfgSpecification)) {
            return false;
        }
        WfCfgSpecification other = (WfCfgSpecification) that;
        return (this.getSpecId() == null ? other.getSpecId() == null : this.getSpecId().equals(other.getSpecId()))
            && (this.getSpecName() == null ? other.getSpecName() == null : this.getSpecName().equals(other.getSpecName()))
            && (this.getSpecType() == null ? other.getSpecType() == null : this.getSpecType().equals(other.getSpecType()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getLastUpdateTime() == null ? other.getLastUpdateTime() == null : this.getLastUpdateTime().equals(other.getLastUpdateTime()))
            && (this.getLastUpdateOper() == null ? other.getLastUpdateOper() == null : this.getLastUpdateOper().equals(other.getLastUpdateOper()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getCreateOper() == null ? other.getCreateOper() == null : this.getCreateOper().equals(other.getCreateOper()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_cfg_specification
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getSpecId() == null) ? 0 : getSpecId().hashCode());
        result = prime * result + ((getSpecName() == null) ? 0 : getSpecName().hashCode());
        result = prime * result + ((getSpecType() == null) ? 0 : getSpecType().hashCode());
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
     * This method corresponds to the database table wf_cfg_specification
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public void copyProperties(WfCfgSpecification that) {
        if (this == that || that == null) {
            return;
        }
        if(that.isSpecIdColoured() ) {this.setSpecId(that.getSpecId() );}
        if(that.isSpecNameColoured() ) {this.setSpecName(that.getSpecName() );}
        if(that.isSpecTypeColoured() ) {this.setSpecType(that.getSpecType() );}
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
     * This method corresponds to the database table wf_cfg_specification
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public WfCfgSpecification makeCopy() {
        WfCfgSpecification copy = new WfCfgSpecification();
        if(this.specId != null ) {copy.specId = this.specId;}
        if(this.specName != null ) {copy.specName = this.specName;}
        if(this.specType != null ) {copy.specType = this.specType;}
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
     * This method corresponds to the database table wf_cfg_specification
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    @Override
    public JSONObject toJSON() {
        JSONObject jsonObj = new JSONObject(32, true);
        if(this.specId != null) {jsonObj.put("specId", this.specId);}
        if(this.specName != null) {jsonObj.put("specName", this.specName);}
        if(this.specType != null) {jsonObj.put("specType", this.specType);}
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
     * This method corresponds to the database table wf_cfg_specification
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    @Override
    public void clear() {
         this.specId = null; this.specIdColoured = false;
         this.specName = null; this.specNameColoured = false;
         this.specType = null; this.specTypeColoured = false;
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
     * This method corresponds to the database table wf_cfg_specification
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    @Override
    public void clearColoured() {
        this.specIdColoured = false;
        this.specNameColoured = false;
        this.specTypeColoured = false;
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
     * This method corresponds to the database table wf_cfg_specification
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    @Override
    public boolean isColoured() {
        if(this.specIdColoured) return true;
        if(this.specNameColoured) return true;
        if(this.specTypeColoured) return true;
        if(this.descriptionColoured) return true;
        if(this.statusColoured) return true;
        if(this.lastUpdateTimeColoured) return true;
        if(this.lastUpdateOperColoured) return true;
        if(this.createTimeColoured) return true;
        if(this.createOperColoured) return true;
        return false;
    }
}