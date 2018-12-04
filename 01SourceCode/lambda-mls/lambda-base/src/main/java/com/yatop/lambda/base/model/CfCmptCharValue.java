package com.yatop.lambda.base.model;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yatop.lambda.base.utils.LambdaRootModel;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;

public class CfCmptCharValue extends LambdaRootModel implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_cmpt_char_value.CMPT_ID
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    private String cmptId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_cmpt_char_value.CMPT_ID:Coloured
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    private boolean cmptIdColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_cmpt_char_value.CHAR_ID
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    private String charId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_cmpt_char_value.CHAR_ID:Coloured
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    private boolean charIdColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_cmpt_char_value.IS_SYSTEM_PARAM
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    private Integer isSystemParam;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_cmpt_char_value.IS_SYSTEM_PARAM:Coloured
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    private boolean isSystemParamColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_cmpt_char_value.CHAR_VALUE
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    private String charValue;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_cmpt_char_value.CHAR_VALUE:Coloured
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    private boolean charValueColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_cmpt_char_value.DESCRIPTION
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    private String description;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_cmpt_char_value.DESCRIPTION:Coloured
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    private boolean descriptionColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_cmpt_char_value.STATUS
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    private Integer status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_cmpt_char_value.STATUS:Coloured
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    private boolean statusColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_cmpt_char_value.LAST_UPDATE_TIME
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    private Date lastUpdateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_cmpt_char_value.LAST_UPDATE_TIME:Coloured
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    private boolean lastUpdateTimeColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_cmpt_char_value.LAST_UPDATE_OPER
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    private String lastUpdateOper;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_cmpt_char_value.LAST_UPDATE_OPER:Coloured
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    private boolean lastUpdateOperColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_cmpt_char_value.CREATE_TIME
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_cmpt_char_value.CREATE_TIME:Coloured
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    private boolean createTimeColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_cmpt_char_value.CREATE_OPER
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    private String createOper;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_cmpt_char_value.CREATE_OPER:Coloured
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    private boolean createOperColoured;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table cf_cmpt_char_value
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_cmpt_char_value.CMPT_ID
     *
     * @return the value of cf_cmpt_char_value.CMPT_ID
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    public String getCmptId() {
        return cmptId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_cmpt_char_value.CMPT_ID:Coloured
     *
     * @return the value of cf_cmpt_char_value.CMPT_ID:Coloured
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    public boolean isCmptIdColoured() {
        return cmptIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cf_cmpt_char_value.CMPT_ID
     *
     * @param cmptId the value for cf_cmpt_char_value.CMPT_ID
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    public void setCmptId(String cmptId) {
        this.cmptId = cmptId == null ? null : cmptId.trim();
        this.cmptIdColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cf_cmpt_char_value.CMPT_ID:Coloured
     *
     * @param cmptIdColoured the value for cf_cmpt_char_value.CMPT_ID:Coloured
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    public void setCmptIdColoured(boolean cmptIdColoured) {
        this.cmptIdColoured = cmptIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_cmpt_char_value.CHAR_ID
     *
     * @return the value of cf_cmpt_char_value.CHAR_ID
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    public String getCharId() {
        return charId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_cmpt_char_value.CHAR_ID:Coloured
     *
     * @return the value of cf_cmpt_char_value.CHAR_ID:Coloured
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    public boolean isCharIdColoured() {
        return charIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cf_cmpt_char_value.CHAR_ID
     *
     * @param charId the value for cf_cmpt_char_value.CHAR_ID
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    public void setCharId(String charId) {
        this.charId = charId == null ? null : charId.trim();
        this.charIdColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cf_cmpt_char_value.CHAR_ID:Coloured
     *
     * @param charIdColoured the value for cf_cmpt_char_value.CHAR_ID:Coloured
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    public void setCharIdColoured(boolean charIdColoured) {
        this.charIdColoured = charIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_cmpt_char_value.IS_SYSTEM_PARAM
     *
     * @return the value of cf_cmpt_char_value.IS_SYSTEM_PARAM
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    public Integer getIsSystemParam() {
        return isSystemParam;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_cmpt_char_value.IS_SYSTEM_PARAM:Coloured
     *
     * @return the value of cf_cmpt_char_value.IS_SYSTEM_PARAM:Coloured
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    public boolean isIsSystemParamColoured() {
        return isSystemParamColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cf_cmpt_char_value.IS_SYSTEM_PARAM
     *
     * @param isSystemParam the value for cf_cmpt_char_value.IS_SYSTEM_PARAM
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    public void setIsSystemParam(Integer isSystemParam) {
        this.isSystemParam = isSystemParam;
        this.isSystemParamColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cf_cmpt_char_value.IS_SYSTEM_PARAM:Coloured
     *
     * @param isSystemParamColoured the value for cf_cmpt_char_value.IS_SYSTEM_PARAM:Coloured
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    public void setIsSystemParamColoured(boolean isSystemParamColoured) {
        this.isSystemParamColoured = isSystemParamColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_cmpt_char_value.CHAR_VALUE
     *
     * @return the value of cf_cmpt_char_value.CHAR_VALUE
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    public String getCharValue() {
        return charValue;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_cmpt_char_value.CHAR_VALUE:Coloured
     *
     * @return the value of cf_cmpt_char_value.CHAR_VALUE:Coloured
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    public boolean isCharValueColoured() {
        return charValueColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cf_cmpt_char_value.CHAR_VALUE
     *
     * @param charValue the value for cf_cmpt_char_value.CHAR_VALUE
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    public void setCharValue(String charValue) {
        this.charValue = charValue == null ? null : charValue.trim();
        this.charValueColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cf_cmpt_char_value.CHAR_VALUE:Coloured
     *
     * @param charValueColoured the value for cf_cmpt_char_value.CHAR_VALUE:Coloured
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    public void setCharValueColoured(boolean charValueColoured) {
        this.charValueColoured = charValueColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_cmpt_char_value.DESCRIPTION
     *
     * @return the value of cf_cmpt_char_value.DESCRIPTION
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_cmpt_char_value.DESCRIPTION:Coloured
     *
     * @return the value of cf_cmpt_char_value.DESCRIPTION:Coloured
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    public boolean isDescriptionColoured() {
        return descriptionColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cf_cmpt_char_value.DESCRIPTION
     *
     * @param description the value for cf_cmpt_char_value.DESCRIPTION
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
        this.descriptionColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cf_cmpt_char_value.DESCRIPTION:Coloured
     *
     * @param descriptionColoured the value for cf_cmpt_char_value.DESCRIPTION:Coloured
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    public void setDescriptionColoured(boolean descriptionColoured) {
        this.descriptionColoured = descriptionColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_cmpt_char_value.STATUS
     *
     * @return the value of cf_cmpt_char_value.STATUS
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_cmpt_char_value.STATUS:Coloured
     *
     * @return the value of cf_cmpt_char_value.STATUS:Coloured
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    public boolean isStatusColoured() {
        return statusColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cf_cmpt_char_value.STATUS
     *
     * @param status the value for cf_cmpt_char_value.STATUS
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    public void setStatus(Integer status) {
        this.status = status;
        this.statusColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cf_cmpt_char_value.STATUS:Coloured
     *
     * @param statusColoured the value for cf_cmpt_char_value.STATUS:Coloured
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    public void setStatusColoured(boolean statusColoured) {
        this.statusColoured = statusColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_cmpt_char_value.LAST_UPDATE_TIME
     *
     * @return the value of cf_cmpt_char_value.LAST_UPDATE_TIME
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_cmpt_char_value.LAST_UPDATE_TIME:Coloured
     *
     * @return the value of cf_cmpt_char_value.LAST_UPDATE_TIME:Coloured
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    public boolean isLastUpdateTimeColoured() {
        return lastUpdateTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cf_cmpt_char_value.LAST_UPDATE_TIME
     *
     * @param lastUpdateTime the value for cf_cmpt_char_value.LAST_UPDATE_TIME
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
        this.lastUpdateTimeColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cf_cmpt_char_value.LAST_UPDATE_TIME:Coloured
     *
     * @param lastUpdateTimeColoured the value for cf_cmpt_char_value.LAST_UPDATE_TIME:Coloured
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    public void setLastUpdateTimeColoured(boolean lastUpdateTimeColoured) {
        this.lastUpdateTimeColoured = lastUpdateTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_cmpt_char_value.LAST_UPDATE_OPER
     *
     * @return the value of cf_cmpt_char_value.LAST_UPDATE_OPER
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    public String getLastUpdateOper() {
        return lastUpdateOper;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_cmpt_char_value.LAST_UPDATE_OPER:Coloured
     *
     * @return the value of cf_cmpt_char_value.LAST_UPDATE_OPER:Coloured
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    public boolean isLastUpdateOperColoured() {
        return lastUpdateOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cf_cmpt_char_value.LAST_UPDATE_OPER
     *
     * @param lastUpdateOper the value for cf_cmpt_char_value.LAST_UPDATE_OPER
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    public void setLastUpdateOper(String lastUpdateOper) {
        this.lastUpdateOper = lastUpdateOper == null ? null : lastUpdateOper.trim();
        this.lastUpdateOperColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cf_cmpt_char_value.LAST_UPDATE_OPER:Coloured
     *
     * @param lastUpdateOperColoured the value for cf_cmpt_char_value.LAST_UPDATE_OPER:Coloured
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    public void setLastUpdateOperColoured(boolean lastUpdateOperColoured) {
        this.lastUpdateOperColoured = lastUpdateOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_cmpt_char_value.CREATE_TIME
     *
     * @return the value of cf_cmpt_char_value.CREATE_TIME
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_cmpt_char_value.CREATE_TIME:Coloured
     *
     * @return the value of cf_cmpt_char_value.CREATE_TIME:Coloured
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    public boolean isCreateTimeColoured() {
        return createTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cf_cmpt_char_value.CREATE_TIME
     *
     * @param createTime the value for cf_cmpt_char_value.CREATE_TIME
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
        this.createTimeColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cf_cmpt_char_value.CREATE_TIME:Coloured
     *
     * @param createTimeColoured the value for cf_cmpt_char_value.CREATE_TIME:Coloured
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    public void setCreateTimeColoured(boolean createTimeColoured) {
        this.createTimeColoured = createTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_cmpt_char_value.CREATE_OPER
     *
     * @return the value of cf_cmpt_char_value.CREATE_OPER
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    public String getCreateOper() {
        return createOper;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_cmpt_char_value.CREATE_OPER:Coloured
     *
     * @return the value of cf_cmpt_char_value.CREATE_OPER:Coloured
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    public boolean isCreateOperColoured() {
        return createOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cf_cmpt_char_value.CREATE_OPER
     *
     * @param createOper the value for cf_cmpt_char_value.CREATE_OPER
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    public void setCreateOper(String createOper) {
        this.createOper = createOper == null ? null : createOper.trim();
        this.createOperColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cf_cmpt_char_value.CREATE_OPER:Coloured
     *
     * @param createOperColoured the value for cf_cmpt_char_value.CREATE_OPER:Coloured
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    public void setCreateOperColoured(boolean createOperColoured) {
        this.createOperColoured = createOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_char_value
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
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
        CfCmptCharValue other = (CfCmptCharValue) that;
        return (this.getCmptId() == null ? other.getCmptId() == null : this.getCmptId().equals(other.getCmptId()))
            && (this.getCharId() == null ? other.getCharId() == null : this.getCharId().equals(other.getCharId()))
            && (this.getIsSystemParam() == null ? other.getIsSystemParam() == null : this.getIsSystemParam().equals(other.getIsSystemParam()))
            && (this.getCharValue() == null ? other.getCharValue() == null : this.getCharValue().equals(other.getCharValue()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getLastUpdateTime() == null ? other.getLastUpdateTime() == null : this.getLastUpdateTime().equals(other.getLastUpdateTime()))
            && (this.getLastUpdateOper() == null ? other.getLastUpdateOper() == null : this.getLastUpdateOper().equals(other.getLastUpdateOper()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getCreateOper() == null ? other.getCreateOper() == null : this.getCreateOper().equals(other.getCreateOper()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_char_value
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCmptId() == null) ? 0 : getCmptId().hashCode());
        result = prime * result + ((getCharId() == null) ? 0 : getCharId().hashCode());
        result = prime * result + ((getIsSystemParam() == null) ? 0 : getIsSystemParam().hashCode());
        result = prime * result + ((getCharValue() == null) ? 0 : getCharValue().hashCode());
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
     * This method corresponds to the database table cf_cmpt_char_value
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    @Override
    public void copyProperties(Object that) {
        if (this == that || that == null || this.getClass() != that.getClass() ) {
            return;
        }
        CfCmptCharValue other = (CfCmptCharValue) that;
        if(other.isCmptIdColoured() ) {this.setCmptId(other.getCmptId() );}
        if(other.isCharIdColoured() ) {this.setCharId(other.getCharId() );}
        if(other.isIsSystemParamColoured() ) {this.setIsSystemParam(other.getIsSystemParam() );}
        if(other.isCharValueColoured() ) {this.setCharValue(other.getCharValue() );}
        if(other.isDescriptionColoured() ) {this.setDescription(other.getDescription() );}
        if(other.isStatusColoured() ) {this.setStatus(other.getStatus() );}
        if(other.isLastUpdateTimeColoured() ) {this.setLastUpdateTime(other.getLastUpdateTime() );}
        if(other.isLastUpdateOperColoured() ) {this.setLastUpdateOper(other.getLastUpdateOper() );}
        if(other.isCreateTimeColoured() ) {this.setCreateTime(other.getCreateTime() );}
        if(other.isCreateOperColoured() ) {this.setCreateOper(other.getCreateOper() );}
        return;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_char_value
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    @Override
    public JSONObject toJSON() {
        HashMap<String, Object> hashMap = new HashMap();
        if(this.cmptIdColoured) {hashMap.put("cmptId", this.cmptId);}
        if(this.charIdColoured) {hashMap.put("charId", this.charId);}
        if(this.isSystemParamColoured) {hashMap.put("isSystemParam", this.isSystemParam);}
        if(this.charValueColoured) {hashMap.put("charValue", this.charValue);}
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
     * This method corresponds to the database table cf_cmpt_char_value
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    @Override
    public void clear() {
        if(this.cmptIdColoured) {this.cmptId = null; this.cmptIdColoured = false;}
        if(this.charIdColoured) {this.charId = null; this.charIdColoured = false;}
        if(this.isSystemParamColoured) {this.isSystemParam = null; this.isSystemParamColoured = false;}
        if(this.charValueColoured) {this.charValue = null; this.charValueColoured = false;}
        if(this.descriptionColoured) {this.description = null; this.descriptionColoured = false;}
        if(this.statusColoured) {this.status = null; this.statusColoured = false;}
        if(this.lastUpdateTimeColoured) {this.lastUpdateTime = null; this.lastUpdateTimeColoured = false;}
        if(this.lastUpdateOperColoured) {this.lastUpdateOper = null; this.lastUpdateOperColoured = false;}
        if(this.createTimeColoured) {this.createTime = null; this.createTimeColoured = false;}
        if(this.createOperColoured) {this.createOper = null; this.createOperColoured = false;}
        return;
    }
}