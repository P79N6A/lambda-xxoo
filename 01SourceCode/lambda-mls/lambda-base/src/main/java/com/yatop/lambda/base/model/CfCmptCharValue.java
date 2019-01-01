package com.yatop.lambda.base.model;

import com.alibaba.fastjson.JSONObject;
import com.yatop.lambda.base.utils.LambdaRootModel;
import java.io.Serializable;
import java.util.Date;

public class CfCmptCharValue extends LambdaRootModel implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_cmpt_char_value.CMPT_ID
     *
     * @mbg.generated Wed Jan 02 00:41:23 CST 2019
     */
    private String cmptId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_cmpt_char_value.CMPT_ID:Coloured
     *
     * @mbg.generated Wed Jan 02 00:41:23 CST 2019
     */
    private boolean cmptIdColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_cmpt_char_value.CHAR_ID
     *
     * @mbg.generated Wed Jan 02 00:41:23 CST 2019
     */
    private String charId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_cmpt_char_value.CHAR_ID:Coloured
     *
     * @mbg.generated Wed Jan 02 00:41:23 CST 2019
     */
    private boolean charIdColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_cmpt_char_value.IS_SYSTEM_PARAM
     *
     * @mbg.generated Wed Jan 02 00:41:23 CST 2019
     */
    private Integer isSystemParam;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_cmpt_char_value.IS_SYSTEM_PARAM:Coloured
     *
     * @mbg.generated Wed Jan 02 00:41:23 CST 2019
     */
    private boolean isSystemParamColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_cmpt_char_value.CHAR_VALUE
     *
     * @mbg.generated Wed Jan 02 00:41:23 CST 2019
     */
    private String charValue;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_cmpt_char_value.CHAR_VALUE:Coloured
     *
     * @mbg.generated Wed Jan 02 00:41:23 CST 2019
     */
    private boolean charValueColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_cmpt_char_value.DESCRIPTION
     *
     * @mbg.generated Wed Jan 02 00:41:23 CST 2019
     */
    private String description;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_cmpt_char_value.DESCRIPTION:Coloured
     *
     * @mbg.generated Wed Jan 02 00:41:23 CST 2019
     */
    private boolean descriptionColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_cmpt_char_value.STATUS
     *
     * @mbg.generated Wed Jan 02 00:41:23 CST 2019
     */
    private Integer status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_cmpt_char_value.STATUS:Coloured
     *
     * @mbg.generated Wed Jan 02 00:41:23 CST 2019
     */
    private boolean statusColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_cmpt_char_value.LAST_UPDATE_TIME
     *
     * @mbg.generated Wed Jan 02 00:41:23 CST 2019
     */
    private Date lastUpdateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_cmpt_char_value.LAST_UPDATE_TIME:Coloured
     *
     * @mbg.generated Wed Jan 02 00:41:23 CST 2019
     */
    private boolean lastUpdateTimeColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_cmpt_char_value.LAST_UPDATE_OPER
     *
     * @mbg.generated Wed Jan 02 00:41:23 CST 2019
     */
    private String lastUpdateOper;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_cmpt_char_value.LAST_UPDATE_OPER:Coloured
     *
     * @mbg.generated Wed Jan 02 00:41:23 CST 2019
     */
    private boolean lastUpdateOperColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_cmpt_char_value.CREATE_TIME
     *
     * @mbg.generated Wed Jan 02 00:41:23 CST 2019
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_cmpt_char_value.CREATE_TIME:Coloured
     *
     * @mbg.generated Wed Jan 02 00:41:23 CST 2019
     */
    private boolean createTimeColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_cmpt_char_value.CREATE_OPER
     *
     * @mbg.generated Wed Jan 02 00:41:23 CST 2019
     */
    private String createOper;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_cmpt_char_value.CREATE_OPER:Coloured
     *
     * @mbg.generated Wed Jan 02 00:41:23 CST 2019
     */
    private boolean createOperColoured;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table cf_cmpt_char_value
     *
     * @mbg.generated Wed Jan 02 00:41:23 CST 2019
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_cmpt_char_value.CMPT_ID
     *
     * @return the value of cf_cmpt_char_value.CMPT_ID
     *
     * @mbg.generated Wed Jan 02 00:41:23 CST 2019
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
     * @mbg.generated Wed Jan 02 00:41:23 CST 2019
     */
    public boolean isCmptIdColoured() {
        return cmptIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_cmpt_char_value.CMPT_ID:Coloured
     *
     * @return the value of cf_cmpt_char_value.CMPT_ID:Coloured
     *
     * @mbg.generated Wed Jan 02 00:41:23 CST 2019
     */
    public boolean isCmptIdNotColoured() {
        return !cmptIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cf_cmpt_char_value.CMPT_ID
     *
     * @param cmptId the value for cf_cmpt_char_value.CMPT_ID
     *
     * @mbg.generated Wed Jan 02 00:41:23 CST 2019
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
     * @mbg.generated Wed Jan 02 00:41:23 CST 2019
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
     * @mbg.generated Wed Jan 02 00:41:23 CST 2019
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
     * @mbg.generated Wed Jan 02 00:41:23 CST 2019
     */
    public boolean isCharIdColoured() {
        return charIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_cmpt_char_value.CHAR_ID:Coloured
     *
     * @return the value of cf_cmpt_char_value.CHAR_ID:Coloured
     *
     * @mbg.generated Wed Jan 02 00:41:23 CST 2019
     */
    public boolean isCharIdNotColoured() {
        return !charIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cf_cmpt_char_value.CHAR_ID
     *
     * @param charId the value for cf_cmpt_char_value.CHAR_ID
     *
     * @mbg.generated Wed Jan 02 00:41:23 CST 2019
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
     * @mbg.generated Wed Jan 02 00:41:23 CST 2019
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
     * @mbg.generated Wed Jan 02 00:41:23 CST 2019
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
     * @mbg.generated Wed Jan 02 00:41:23 CST 2019
     */
    public boolean isIsSystemParamColoured() {
        return isSystemParamColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_cmpt_char_value.IS_SYSTEM_PARAM:Coloured
     *
     * @return the value of cf_cmpt_char_value.IS_SYSTEM_PARAM:Coloured
     *
     * @mbg.generated Wed Jan 02 00:41:23 CST 2019
     */
    public boolean isIsSystemParamNotColoured() {
        return !isSystemParamColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cf_cmpt_char_value.IS_SYSTEM_PARAM
     *
     * @param isSystemParam the value for cf_cmpt_char_value.IS_SYSTEM_PARAM
     *
     * @mbg.generated Wed Jan 02 00:41:23 CST 2019
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
     * @mbg.generated Wed Jan 02 00:41:23 CST 2019
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
     * @mbg.generated Wed Jan 02 00:41:23 CST 2019
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
     * @mbg.generated Wed Jan 02 00:41:23 CST 2019
     */
    public boolean isCharValueColoured() {
        return charValueColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_cmpt_char_value.CHAR_VALUE:Coloured
     *
     * @return the value of cf_cmpt_char_value.CHAR_VALUE:Coloured
     *
     * @mbg.generated Wed Jan 02 00:41:23 CST 2019
     */
    public boolean isCharValueNotColoured() {
        return !charValueColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cf_cmpt_char_value.CHAR_VALUE
     *
     * @param charValue the value for cf_cmpt_char_value.CHAR_VALUE
     *
     * @mbg.generated Wed Jan 02 00:41:23 CST 2019
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
     * @mbg.generated Wed Jan 02 00:41:23 CST 2019
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
     * @mbg.generated Wed Jan 02 00:41:23 CST 2019
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
     * @mbg.generated Wed Jan 02 00:41:23 CST 2019
     */
    public boolean isDescriptionColoured() {
        return descriptionColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_cmpt_char_value.DESCRIPTION:Coloured
     *
     * @return the value of cf_cmpt_char_value.DESCRIPTION:Coloured
     *
     * @mbg.generated Wed Jan 02 00:41:23 CST 2019
     */
    public boolean isDescriptionNotColoured() {
        return !descriptionColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cf_cmpt_char_value.DESCRIPTION
     *
     * @param description the value for cf_cmpt_char_value.DESCRIPTION
     *
     * @mbg.generated Wed Jan 02 00:41:23 CST 2019
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
     * @mbg.generated Wed Jan 02 00:41:23 CST 2019
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
     * @mbg.generated Wed Jan 02 00:41:23 CST 2019
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
     * @mbg.generated Wed Jan 02 00:41:23 CST 2019
     */
    public boolean isStatusColoured() {
        return statusColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_cmpt_char_value.STATUS:Coloured
     *
     * @return the value of cf_cmpt_char_value.STATUS:Coloured
     *
     * @mbg.generated Wed Jan 02 00:41:23 CST 2019
     */
    public boolean isStatusNotColoured() {
        return !statusColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cf_cmpt_char_value.STATUS
     *
     * @param status the value for cf_cmpt_char_value.STATUS
     *
     * @mbg.generated Wed Jan 02 00:41:23 CST 2019
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
     * @mbg.generated Wed Jan 02 00:41:23 CST 2019
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
     * @mbg.generated Wed Jan 02 00:41:23 CST 2019
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
     * @mbg.generated Wed Jan 02 00:41:23 CST 2019
     */
    public boolean isLastUpdateTimeColoured() {
        return lastUpdateTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_cmpt_char_value.LAST_UPDATE_TIME:Coloured
     *
     * @return the value of cf_cmpt_char_value.LAST_UPDATE_TIME:Coloured
     *
     * @mbg.generated Wed Jan 02 00:41:23 CST 2019
     */
    public boolean isLastUpdateTimeNotColoured() {
        return !lastUpdateTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cf_cmpt_char_value.LAST_UPDATE_TIME
     *
     * @param lastUpdateTime the value for cf_cmpt_char_value.LAST_UPDATE_TIME
     *
     * @mbg.generated Wed Jan 02 00:41:23 CST 2019
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
     * @mbg.generated Wed Jan 02 00:41:23 CST 2019
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
     * @mbg.generated Wed Jan 02 00:41:23 CST 2019
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
     * @mbg.generated Wed Jan 02 00:41:23 CST 2019
     */
    public boolean isLastUpdateOperColoured() {
        return lastUpdateOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_cmpt_char_value.LAST_UPDATE_OPER:Coloured
     *
     * @return the value of cf_cmpt_char_value.LAST_UPDATE_OPER:Coloured
     *
     * @mbg.generated Wed Jan 02 00:41:23 CST 2019
     */
    public boolean isLastUpdateOperNotColoured() {
        return !lastUpdateOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cf_cmpt_char_value.LAST_UPDATE_OPER
     *
     * @param lastUpdateOper the value for cf_cmpt_char_value.LAST_UPDATE_OPER
     *
     * @mbg.generated Wed Jan 02 00:41:23 CST 2019
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
     * @mbg.generated Wed Jan 02 00:41:23 CST 2019
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
     * @mbg.generated Wed Jan 02 00:41:23 CST 2019
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
     * @mbg.generated Wed Jan 02 00:41:23 CST 2019
     */
    public boolean isCreateTimeColoured() {
        return createTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_cmpt_char_value.CREATE_TIME:Coloured
     *
     * @return the value of cf_cmpt_char_value.CREATE_TIME:Coloured
     *
     * @mbg.generated Wed Jan 02 00:41:23 CST 2019
     */
    public boolean isCreateTimeNotColoured() {
        return !createTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cf_cmpt_char_value.CREATE_TIME
     *
     * @param createTime the value for cf_cmpt_char_value.CREATE_TIME
     *
     * @mbg.generated Wed Jan 02 00:41:23 CST 2019
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
     * @mbg.generated Wed Jan 02 00:41:23 CST 2019
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
     * @mbg.generated Wed Jan 02 00:41:23 CST 2019
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
     * @mbg.generated Wed Jan 02 00:41:23 CST 2019
     */
    public boolean isCreateOperColoured() {
        return createOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_cmpt_char_value.CREATE_OPER:Coloured
     *
     * @return the value of cf_cmpt_char_value.CREATE_OPER:Coloured
     *
     * @mbg.generated Wed Jan 02 00:41:23 CST 2019
     */
    public boolean isCreateOperNotColoured() {
        return !createOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cf_cmpt_char_value.CREATE_OPER
     *
     * @param createOper the value for cf_cmpt_char_value.CREATE_OPER
     *
     * @mbg.generated Wed Jan 02 00:41:23 CST 2019
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
     * @mbg.generated Wed Jan 02 00:41:23 CST 2019
     */
    public void setCreateOperColoured(boolean createOperColoured) {
        this.createOperColoured = createOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_char_value
     *
     * @mbg.generated Wed Jan 02 00:41:23 CST 2019
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if(!(that instanceof CfCmptCharValue)) {
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
     * @mbg.generated Wed Jan 02 00:41:23 CST 2019
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
     * @mbg.generated Wed Jan 02 00:41:23 CST 2019
     */
    public void copyProperties(CfCmptCharValue that) {
        if (this == that || that == null) {
            return;
        }
        if(that.isCmptIdColoured() ) {this.setCmptId(that.getCmptId() );}
        if(that.isCharIdColoured() ) {this.setCharId(that.getCharId() );}
        if(that.isIsSystemParamColoured() ) {this.setIsSystemParam(that.getIsSystemParam() );}
        if(that.isCharValueColoured() ) {this.setCharValue(that.getCharValue() );}
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
     * This method corresponds to the database table cf_cmpt_char_value
     *
     * @mbg.generated Wed Jan 02 00:41:23 CST 2019
     */
    @Override
    public JSONObject toJSON() {
        JSONObject jsonObj = new JSONObject(32, true);
        if(this.cmptId != null) {jsonObj.put("cmptId", this.cmptId);}
        if(this.charId != null) {jsonObj.put("charId", this.charId);}
        if(this.isSystemParam != null) {jsonObj.put("isSystemParam", this.isSystemParam);}
        if(this.charValue != null) {jsonObj.put("charValue", this.charValue);}
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
     * This method corresponds to the database table cf_cmpt_char_value
     *
     * @mbg.generated Wed Jan 02 00:41:23 CST 2019
     */
    @Override
    public void clear() {
         this.cmptId = null; this.cmptIdColoured = false;
         this.charId = null; this.charIdColoured = false;
         this.isSystemParam = null; this.isSystemParamColoured = false;
         this.charValue = null; this.charValueColoured = false;
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
     * This method corresponds to the database table cf_cmpt_char_value
     *
     * @mbg.generated Wed Jan 02 00:41:23 CST 2019
     */
    @Override
    public void clearColoured() {
        this.cmptIdColoured = false;
        this.charIdColoured = false;
        this.isSystemParamColoured = false;
        this.charValueColoured = false;
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
     * This method corresponds to the database table cf_cmpt_char_value
     *
     * @mbg.generated Wed Jan 02 00:41:23 CST 2019
     */
    @Override
    public boolean isColoured() {
        if(this.cmptIdColoured) return true;
        if(this.charIdColoured) return true;
        if(this.isSystemParamColoured) return true;
        if(this.charValueColoured) return true;
        if(this.descriptionColoured) return true;
        if(this.statusColoured) return true;
        if(this.lastUpdateTimeColoured) return true;
        if(this.lastUpdateOperColoured) return true;
        if(this.createTimeColoured) return true;
        if(this.createOperColoured) return true;
        return false;
    }
}