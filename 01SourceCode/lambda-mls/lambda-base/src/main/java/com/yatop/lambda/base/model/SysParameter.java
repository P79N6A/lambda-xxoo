package com.yatop.lambda.base.model;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yatop.lambda.base.utils.LambdaRootModel;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;

public class SysParameter extends LambdaRootModel implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_parameter.PARAM_ID
     *
     * @mbg.generated Sat Dec 08 20:55:04 CST 2018
     */
    private Long paramId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_parameter.PARAM_ID:Coloured
     *
     * @mbg.generated Sat Dec 08 20:55:04 CST 2018
     */
    private boolean paramIdColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_parameter.PARAM_CODE
     *
     * @mbg.generated Sat Dec 08 20:55:04 CST 2018
     */
    private String paramCode;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_parameter.PARAM_CODE:Coloured
     *
     * @mbg.generated Sat Dec 08 20:55:04 CST 2018
     */
    private boolean paramCodeColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_parameter.PARAM_NAME
     *
     * @mbg.generated Sat Dec 08 20:55:04 CST 2018
     */
    private String paramName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_parameter.PARAM_NAME:Coloured
     *
     * @mbg.generated Sat Dec 08 20:55:04 CST 2018
     */
    private boolean paramNameColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_parameter.PARAM_CLASS
     *
     * @mbg.generated Sat Dec 08 20:55:04 CST 2018
     */
    private Integer paramClass;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_parameter.PARAM_CLASS:Coloured
     *
     * @mbg.generated Sat Dec 08 20:55:04 CST 2018
     */
    private boolean paramClassColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_parameter.PARAM_SUB_CLASS
     *
     * @mbg.generated Sat Dec 08 20:55:04 CST 2018
     */
    private Integer paramSubClass;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_parameter.PARAM_SUB_CLASS:Coloured
     *
     * @mbg.generated Sat Dec 08 20:55:04 CST 2018
     */
    private boolean paramSubClassColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_parameter.PARAM_VALUE
     *
     * @mbg.generated Sat Dec 08 20:55:04 CST 2018
     */
    private String paramValue;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_parameter.PARAM_VALUE:Coloured
     *
     * @mbg.generated Sat Dec 08 20:55:04 CST 2018
     */
    private boolean paramValueColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_parameter.DESCRIPTION
     *
     * @mbg.generated Sat Dec 08 20:55:04 CST 2018
     */
    private String description;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_parameter.DESCRIPTION:Coloured
     *
     * @mbg.generated Sat Dec 08 20:55:04 CST 2018
     */
    private boolean descriptionColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_parameter.STATUS
     *
     * @mbg.generated Sat Dec 08 20:55:04 CST 2018
     */
    private Integer status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_parameter.STATUS:Coloured
     *
     * @mbg.generated Sat Dec 08 20:55:04 CST 2018
     */
    private boolean statusColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_parameter.LAST_UPDATE_TIME
     *
     * @mbg.generated Sat Dec 08 20:55:04 CST 2018
     */
    private Date lastUpdateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_parameter.LAST_UPDATE_TIME:Coloured
     *
     * @mbg.generated Sat Dec 08 20:55:04 CST 2018
     */
    private boolean lastUpdateTimeColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_parameter.LAST_UPDATE_OPER
     *
     * @mbg.generated Sat Dec 08 20:55:04 CST 2018
     */
    private String lastUpdateOper;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_parameter.LAST_UPDATE_OPER:Coloured
     *
     * @mbg.generated Sat Dec 08 20:55:04 CST 2018
     */
    private boolean lastUpdateOperColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_parameter.CREATE_TIME
     *
     * @mbg.generated Sat Dec 08 20:55:04 CST 2018
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_parameter.CREATE_TIME:Coloured
     *
     * @mbg.generated Sat Dec 08 20:55:04 CST 2018
     */
    private boolean createTimeColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_parameter.CREATE_OPER
     *
     * @mbg.generated Sat Dec 08 20:55:04 CST 2018
     */
    private String createOper;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_parameter.CREATE_OPER:Coloured
     *
     * @mbg.generated Sat Dec 08 20:55:04 CST 2018
     */
    private boolean createOperColoured;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table sys_parameter
     *
     * @mbg.generated Sat Dec 08 20:55:04 CST 2018
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_parameter.PARAM_ID
     *
     * @return the value of sys_parameter.PARAM_ID
     *
     * @mbg.generated Sat Dec 08 20:55:04 CST 2018
     */
    public Long getParamId() {
        return paramId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_parameter.PARAM_ID:Coloured
     *
     * @return the value of sys_parameter.PARAM_ID:Coloured
     *
     * @mbg.generated Sat Dec 08 20:55:04 CST 2018
     */
    public boolean isParamIdColoured() {
        return paramIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_parameter.PARAM_ID:Coloured
     *
     * @return the value of sys_parameter.PARAM_ID:Coloured
     *
     * @mbg.generated Sat Dec 08 20:55:04 CST 2018
     */
    public boolean isParamIdNotColoured() {
        return !paramIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_parameter.PARAM_ID
     *
     * @param paramId the value for sys_parameter.PARAM_ID
     *
     * @mbg.generated Sat Dec 08 20:55:04 CST 2018
     */
    public void setParamId(Long paramId) {
        this.paramId = paramId;
        this.paramIdColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_parameter.PARAM_ID:Coloured
     *
     * @param paramIdColoured the value for sys_parameter.PARAM_ID:Coloured
     *
     * @mbg.generated Sat Dec 08 20:55:04 CST 2018
     */
    public void setParamIdColoured(boolean paramIdColoured) {
        this.paramIdColoured = paramIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_parameter.PARAM_CODE
     *
     * @return the value of sys_parameter.PARAM_CODE
     *
     * @mbg.generated Sat Dec 08 20:55:04 CST 2018
     */
    public String getParamCode() {
        return paramCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_parameter.PARAM_CODE:Coloured
     *
     * @return the value of sys_parameter.PARAM_CODE:Coloured
     *
     * @mbg.generated Sat Dec 08 20:55:04 CST 2018
     */
    public boolean isParamCodeColoured() {
        return paramCodeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_parameter.PARAM_CODE:Coloured
     *
     * @return the value of sys_parameter.PARAM_CODE:Coloured
     *
     * @mbg.generated Sat Dec 08 20:55:04 CST 2018
     */
    public boolean isParamCodeNotColoured() {
        return !paramCodeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_parameter.PARAM_CODE
     *
     * @param paramCode the value for sys_parameter.PARAM_CODE
     *
     * @mbg.generated Sat Dec 08 20:55:04 CST 2018
     */
    public void setParamCode(String paramCode) {
        this.paramCode = paramCode == null ? null : paramCode.trim();
        this.paramCodeColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_parameter.PARAM_CODE:Coloured
     *
     * @param paramCodeColoured the value for sys_parameter.PARAM_CODE:Coloured
     *
     * @mbg.generated Sat Dec 08 20:55:04 CST 2018
     */
    public void setParamCodeColoured(boolean paramCodeColoured) {
        this.paramCodeColoured = paramCodeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_parameter.PARAM_NAME
     *
     * @return the value of sys_parameter.PARAM_NAME
     *
     * @mbg.generated Sat Dec 08 20:55:04 CST 2018
     */
    public String getParamName() {
        return paramName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_parameter.PARAM_NAME:Coloured
     *
     * @return the value of sys_parameter.PARAM_NAME:Coloured
     *
     * @mbg.generated Sat Dec 08 20:55:04 CST 2018
     */
    public boolean isParamNameColoured() {
        return paramNameColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_parameter.PARAM_NAME:Coloured
     *
     * @return the value of sys_parameter.PARAM_NAME:Coloured
     *
     * @mbg.generated Sat Dec 08 20:55:04 CST 2018
     */
    public boolean isParamNameNotColoured() {
        return !paramNameColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_parameter.PARAM_NAME
     *
     * @param paramName the value for sys_parameter.PARAM_NAME
     *
     * @mbg.generated Sat Dec 08 20:55:04 CST 2018
     */
    public void setParamName(String paramName) {
        this.paramName = paramName == null ? null : paramName.trim();
        this.paramNameColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_parameter.PARAM_NAME:Coloured
     *
     * @param paramNameColoured the value for sys_parameter.PARAM_NAME:Coloured
     *
     * @mbg.generated Sat Dec 08 20:55:04 CST 2018
     */
    public void setParamNameColoured(boolean paramNameColoured) {
        this.paramNameColoured = paramNameColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_parameter.PARAM_CLASS
     *
     * @return the value of sys_parameter.PARAM_CLASS
     *
     * @mbg.generated Sat Dec 08 20:55:04 CST 2018
     */
    public Integer getParamClass() {
        return paramClass;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_parameter.PARAM_CLASS:Coloured
     *
     * @return the value of sys_parameter.PARAM_CLASS:Coloured
     *
     * @mbg.generated Sat Dec 08 20:55:04 CST 2018
     */
    public boolean isParamClassColoured() {
        return paramClassColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_parameter.PARAM_CLASS:Coloured
     *
     * @return the value of sys_parameter.PARAM_CLASS:Coloured
     *
     * @mbg.generated Sat Dec 08 20:55:04 CST 2018
     */
    public boolean isParamClassNotColoured() {
        return !paramClassColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_parameter.PARAM_CLASS
     *
     * @param paramClass the value for sys_parameter.PARAM_CLASS
     *
     * @mbg.generated Sat Dec 08 20:55:04 CST 2018
     */
    public void setParamClass(Integer paramClass) {
        this.paramClass = paramClass;
        this.paramClassColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_parameter.PARAM_CLASS:Coloured
     *
     * @param paramClassColoured the value for sys_parameter.PARAM_CLASS:Coloured
     *
     * @mbg.generated Sat Dec 08 20:55:04 CST 2018
     */
    public void setParamClassColoured(boolean paramClassColoured) {
        this.paramClassColoured = paramClassColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_parameter.PARAM_SUB_CLASS
     *
     * @return the value of sys_parameter.PARAM_SUB_CLASS
     *
     * @mbg.generated Sat Dec 08 20:55:04 CST 2018
     */
    public Integer getParamSubClass() {
        return paramSubClass;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_parameter.PARAM_SUB_CLASS:Coloured
     *
     * @return the value of sys_parameter.PARAM_SUB_CLASS:Coloured
     *
     * @mbg.generated Sat Dec 08 20:55:04 CST 2018
     */
    public boolean isParamSubClassColoured() {
        return paramSubClassColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_parameter.PARAM_SUB_CLASS:Coloured
     *
     * @return the value of sys_parameter.PARAM_SUB_CLASS:Coloured
     *
     * @mbg.generated Sat Dec 08 20:55:04 CST 2018
     */
    public boolean isParamSubClassNotColoured() {
        return !paramSubClassColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_parameter.PARAM_SUB_CLASS
     *
     * @param paramSubClass the value for sys_parameter.PARAM_SUB_CLASS
     *
     * @mbg.generated Sat Dec 08 20:55:04 CST 2018
     */
    public void setParamSubClass(Integer paramSubClass) {
        this.paramSubClass = paramSubClass;
        this.paramSubClassColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_parameter.PARAM_SUB_CLASS:Coloured
     *
     * @param paramSubClassColoured the value for sys_parameter.PARAM_SUB_CLASS:Coloured
     *
     * @mbg.generated Sat Dec 08 20:55:04 CST 2018
     */
    public void setParamSubClassColoured(boolean paramSubClassColoured) {
        this.paramSubClassColoured = paramSubClassColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_parameter.PARAM_VALUE
     *
     * @return the value of sys_parameter.PARAM_VALUE
     *
     * @mbg.generated Sat Dec 08 20:55:04 CST 2018
     */
    public String getParamValue() {
        return paramValue;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_parameter.PARAM_VALUE:Coloured
     *
     * @return the value of sys_parameter.PARAM_VALUE:Coloured
     *
     * @mbg.generated Sat Dec 08 20:55:04 CST 2018
     */
    public boolean isParamValueColoured() {
        return paramValueColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_parameter.PARAM_VALUE:Coloured
     *
     * @return the value of sys_parameter.PARAM_VALUE:Coloured
     *
     * @mbg.generated Sat Dec 08 20:55:04 CST 2018
     */
    public boolean isParamValueNotColoured() {
        return !paramValueColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_parameter.PARAM_VALUE
     *
     * @param paramValue the value for sys_parameter.PARAM_VALUE
     *
     * @mbg.generated Sat Dec 08 20:55:04 CST 2018
     */
    public void setParamValue(String paramValue) {
        this.paramValue = paramValue == null ? null : paramValue.trim();
        this.paramValueColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_parameter.PARAM_VALUE:Coloured
     *
     * @param paramValueColoured the value for sys_parameter.PARAM_VALUE:Coloured
     *
     * @mbg.generated Sat Dec 08 20:55:04 CST 2018
     */
    public void setParamValueColoured(boolean paramValueColoured) {
        this.paramValueColoured = paramValueColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_parameter.DESCRIPTION
     *
     * @return the value of sys_parameter.DESCRIPTION
     *
     * @mbg.generated Sat Dec 08 20:55:04 CST 2018
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_parameter.DESCRIPTION:Coloured
     *
     * @return the value of sys_parameter.DESCRIPTION:Coloured
     *
     * @mbg.generated Sat Dec 08 20:55:04 CST 2018
     */
    public boolean isDescriptionColoured() {
        return descriptionColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_parameter.DESCRIPTION:Coloured
     *
     * @return the value of sys_parameter.DESCRIPTION:Coloured
     *
     * @mbg.generated Sat Dec 08 20:55:04 CST 2018
     */
    public boolean isDescriptionNotColoured() {
        return !descriptionColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_parameter.DESCRIPTION
     *
     * @param description the value for sys_parameter.DESCRIPTION
     *
     * @mbg.generated Sat Dec 08 20:55:04 CST 2018
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
        this.descriptionColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_parameter.DESCRIPTION:Coloured
     *
     * @param descriptionColoured the value for sys_parameter.DESCRIPTION:Coloured
     *
     * @mbg.generated Sat Dec 08 20:55:04 CST 2018
     */
    public void setDescriptionColoured(boolean descriptionColoured) {
        this.descriptionColoured = descriptionColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_parameter.STATUS
     *
     * @return the value of sys_parameter.STATUS
     *
     * @mbg.generated Sat Dec 08 20:55:04 CST 2018
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_parameter.STATUS:Coloured
     *
     * @return the value of sys_parameter.STATUS:Coloured
     *
     * @mbg.generated Sat Dec 08 20:55:04 CST 2018
     */
    public boolean isStatusColoured() {
        return statusColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_parameter.STATUS:Coloured
     *
     * @return the value of sys_parameter.STATUS:Coloured
     *
     * @mbg.generated Sat Dec 08 20:55:04 CST 2018
     */
    public boolean isStatusNotColoured() {
        return !statusColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_parameter.STATUS
     *
     * @param status the value for sys_parameter.STATUS
     *
     * @mbg.generated Sat Dec 08 20:55:04 CST 2018
     */
    public void setStatus(Integer status) {
        this.status = status;
        this.statusColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_parameter.STATUS:Coloured
     *
     * @param statusColoured the value for sys_parameter.STATUS:Coloured
     *
     * @mbg.generated Sat Dec 08 20:55:04 CST 2018
     */
    public void setStatusColoured(boolean statusColoured) {
        this.statusColoured = statusColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_parameter.LAST_UPDATE_TIME
     *
     * @return the value of sys_parameter.LAST_UPDATE_TIME
     *
     * @mbg.generated Sat Dec 08 20:55:04 CST 2018
     */
    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_parameter.LAST_UPDATE_TIME:Coloured
     *
     * @return the value of sys_parameter.LAST_UPDATE_TIME:Coloured
     *
     * @mbg.generated Sat Dec 08 20:55:04 CST 2018
     */
    public boolean isLastUpdateTimeColoured() {
        return lastUpdateTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_parameter.LAST_UPDATE_TIME:Coloured
     *
     * @return the value of sys_parameter.LAST_UPDATE_TIME:Coloured
     *
     * @mbg.generated Sat Dec 08 20:55:04 CST 2018
     */
    public boolean isLastUpdateTimeNotColoured() {
        return !lastUpdateTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_parameter.LAST_UPDATE_TIME
     *
     * @param lastUpdateTime the value for sys_parameter.LAST_UPDATE_TIME
     *
     * @mbg.generated Sat Dec 08 20:55:04 CST 2018
     */
    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
        this.lastUpdateTimeColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_parameter.LAST_UPDATE_TIME:Coloured
     *
     * @param lastUpdateTimeColoured the value for sys_parameter.LAST_UPDATE_TIME:Coloured
     *
     * @mbg.generated Sat Dec 08 20:55:04 CST 2018
     */
    public void setLastUpdateTimeColoured(boolean lastUpdateTimeColoured) {
        this.lastUpdateTimeColoured = lastUpdateTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_parameter.LAST_UPDATE_OPER
     *
     * @return the value of sys_parameter.LAST_UPDATE_OPER
     *
     * @mbg.generated Sat Dec 08 20:55:04 CST 2018
     */
    public String getLastUpdateOper() {
        return lastUpdateOper;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_parameter.LAST_UPDATE_OPER:Coloured
     *
     * @return the value of sys_parameter.LAST_UPDATE_OPER:Coloured
     *
     * @mbg.generated Sat Dec 08 20:55:04 CST 2018
     */
    public boolean isLastUpdateOperColoured() {
        return lastUpdateOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_parameter.LAST_UPDATE_OPER:Coloured
     *
     * @return the value of sys_parameter.LAST_UPDATE_OPER:Coloured
     *
     * @mbg.generated Sat Dec 08 20:55:04 CST 2018
     */
    public boolean isLastUpdateOperNotColoured() {
        return !lastUpdateOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_parameter.LAST_UPDATE_OPER
     *
     * @param lastUpdateOper the value for sys_parameter.LAST_UPDATE_OPER
     *
     * @mbg.generated Sat Dec 08 20:55:04 CST 2018
     */
    public void setLastUpdateOper(String lastUpdateOper) {
        this.lastUpdateOper = lastUpdateOper == null ? null : lastUpdateOper.trim();
        this.lastUpdateOperColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_parameter.LAST_UPDATE_OPER:Coloured
     *
     * @param lastUpdateOperColoured the value for sys_parameter.LAST_UPDATE_OPER:Coloured
     *
     * @mbg.generated Sat Dec 08 20:55:04 CST 2018
     */
    public void setLastUpdateOperColoured(boolean lastUpdateOperColoured) {
        this.lastUpdateOperColoured = lastUpdateOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_parameter.CREATE_TIME
     *
     * @return the value of sys_parameter.CREATE_TIME
     *
     * @mbg.generated Sat Dec 08 20:55:04 CST 2018
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_parameter.CREATE_TIME:Coloured
     *
     * @return the value of sys_parameter.CREATE_TIME:Coloured
     *
     * @mbg.generated Sat Dec 08 20:55:04 CST 2018
     */
    public boolean isCreateTimeColoured() {
        return createTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_parameter.CREATE_TIME:Coloured
     *
     * @return the value of sys_parameter.CREATE_TIME:Coloured
     *
     * @mbg.generated Sat Dec 08 20:55:04 CST 2018
     */
    public boolean isCreateTimeNotColoured() {
        return !createTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_parameter.CREATE_TIME
     *
     * @param createTime the value for sys_parameter.CREATE_TIME
     *
     * @mbg.generated Sat Dec 08 20:55:04 CST 2018
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
        this.createTimeColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_parameter.CREATE_TIME:Coloured
     *
     * @param createTimeColoured the value for sys_parameter.CREATE_TIME:Coloured
     *
     * @mbg.generated Sat Dec 08 20:55:04 CST 2018
     */
    public void setCreateTimeColoured(boolean createTimeColoured) {
        this.createTimeColoured = createTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_parameter.CREATE_OPER
     *
     * @return the value of sys_parameter.CREATE_OPER
     *
     * @mbg.generated Sat Dec 08 20:55:04 CST 2018
     */
    public String getCreateOper() {
        return createOper;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_parameter.CREATE_OPER:Coloured
     *
     * @return the value of sys_parameter.CREATE_OPER:Coloured
     *
     * @mbg.generated Sat Dec 08 20:55:04 CST 2018
     */
    public boolean isCreateOperColoured() {
        return createOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_parameter.CREATE_OPER:Coloured
     *
     * @return the value of sys_parameter.CREATE_OPER:Coloured
     *
     * @mbg.generated Sat Dec 08 20:55:04 CST 2018
     */
    public boolean isCreateOperNotColoured() {
        return !createOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_parameter.CREATE_OPER
     *
     * @param createOper the value for sys_parameter.CREATE_OPER
     *
     * @mbg.generated Sat Dec 08 20:55:04 CST 2018
     */
    public void setCreateOper(String createOper) {
        this.createOper = createOper == null ? null : createOper.trim();
        this.createOperColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_parameter.CREATE_OPER:Coloured
     *
     * @param createOperColoured the value for sys_parameter.CREATE_OPER:Coloured
     *
     * @mbg.generated Sat Dec 08 20:55:04 CST 2018
     */
    public void setCreateOperColoured(boolean createOperColoured) {
        this.createOperColoured = createOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_parameter
     *
     * @mbg.generated Sat Dec 08 20:55:04 CST 2018
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
        SysParameter other = (SysParameter) that;
        return (this.getParamId() == null ? other.getParamId() == null : this.getParamId().equals(other.getParamId()))
            && (this.getParamCode() == null ? other.getParamCode() == null : this.getParamCode().equals(other.getParamCode()))
            && (this.getParamName() == null ? other.getParamName() == null : this.getParamName().equals(other.getParamName()))
            && (this.getParamClass() == null ? other.getParamClass() == null : this.getParamClass().equals(other.getParamClass()))
            && (this.getParamSubClass() == null ? other.getParamSubClass() == null : this.getParamSubClass().equals(other.getParamSubClass()))
            && (this.getParamValue() == null ? other.getParamValue() == null : this.getParamValue().equals(other.getParamValue()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getLastUpdateTime() == null ? other.getLastUpdateTime() == null : this.getLastUpdateTime().equals(other.getLastUpdateTime()))
            && (this.getLastUpdateOper() == null ? other.getLastUpdateOper() == null : this.getLastUpdateOper().equals(other.getLastUpdateOper()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getCreateOper() == null ? other.getCreateOper() == null : this.getCreateOper().equals(other.getCreateOper()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_parameter
     *
     * @mbg.generated Sat Dec 08 20:55:04 CST 2018
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getParamId() == null) ? 0 : getParamId().hashCode());
        result = prime * result + ((getParamCode() == null) ? 0 : getParamCode().hashCode());
        result = prime * result + ((getParamName() == null) ? 0 : getParamName().hashCode());
        result = prime * result + ((getParamClass() == null) ? 0 : getParamClass().hashCode());
        result = prime * result + ((getParamSubClass() == null) ? 0 : getParamSubClass().hashCode());
        result = prime * result + ((getParamValue() == null) ? 0 : getParamValue().hashCode());
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
     * This method corresponds to the database table sys_parameter
     *
     * @mbg.generated Sat Dec 08 20:55:04 CST 2018
     */
    @Override
    public void copyProperties(Object that) {
        if (this == that || that == null || this.getClass() != that.getClass() ) {
            return;
        }
        SysParameter other = (SysParameter) that;
        if(other.isParamIdColoured() ) {this.setParamId(other.getParamId() );}
        if(other.isParamCodeColoured() ) {this.setParamCode(other.getParamCode() );}
        if(other.isParamNameColoured() ) {this.setParamName(other.getParamName() );}
        if(other.isParamClassColoured() ) {this.setParamClass(other.getParamClass() );}
        if(other.isParamSubClassColoured() ) {this.setParamSubClass(other.getParamSubClass() );}
        if(other.isParamValueColoured() ) {this.setParamValue(other.getParamValue() );}
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
     * This method corresponds to the database table sys_parameter
     *
     * @mbg.generated Sat Dec 08 20:55:04 CST 2018
     */
    @Override
    public JSONObject toJSON() {
        HashMap<String, Object> hashMap = new HashMap();
        if(this.paramIdColoured) {hashMap.put("paramId", this.paramId);}
        if(this.paramCodeColoured) {hashMap.put("paramCode", this.paramCode);}
        if(this.paramNameColoured) {hashMap.put("paramName", this.paramName);}
        if(this.paramClassColoured) {hashMap.put("paramClass", this.paramClass);}
        if(this.paramSubClassColoured) {hashMap.put("paramSubClass", this.paramSubClass);}
        if(this.paramValueColoured) {hashMap.put("paramValue", this.paramValue);}
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
     * This method corresponds to the database table sys_parameter
     *
     * @mbg.generated Sat Dec 08 20:55:04 CST 2018
     */
    @Override
    public void clear() {
        if(this.paramIdColoured) {this.paramId = null; this.paramIdColoured = false;}
        if(this.paramCodeColoured) {this.paramCode = null; this.paramCodeColoured = false;}
        if(this.paramNameColoured) {this.paramName = null; this.paramNameColoured = false;}
        if(this.paramClassColoured) {this.paramClass = null; this.paramClassColoured = false;}
        if(this.paramSubClassColoured) {this.paramSubClass = null; this.paramSubClassColoured = false;}
        if(this.paramValueColoured) {this.paramValue = null; this.paramValueColoured = false;}
        if(this.descriptionColoured) {this.description = null; this.descriptionColoured = false;}
        if(this.statusColoured) {this.status = null; this.statusColoured = false;}
        if(this.lastUpdateTimeColoured) {this.lastUpdateTime = null; this.lastUpdateTimeColoured = false;}
        if(this.lastUpdateOperColoured) {this.lastUpdateOper = null; this.lastUpdateOperColoured = false;}
        if(this.createTimeColoured) {this.createTime = null; this.createTimeColoured = false;}
        if(this.createOperColoured) {this.createOper = null; this.createOperColoured = false;}
        return;
    }
}