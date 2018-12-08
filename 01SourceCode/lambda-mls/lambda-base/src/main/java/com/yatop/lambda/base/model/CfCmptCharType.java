package com.yatop.lambda.base.model;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yatop.lambda.base.utils.LambdaRootModel;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;

public class CfCmptCharType extends LambdaRootModel implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_cmpt_char_type.CHAR_TYPE_ID
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    private Integer charTypeId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_cmpt_char_type.CHAR_TYPE_ID:Coloured
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    private boolean charTypeIdColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_cmpt_char_type.CHAR_TYPE_CODE
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    private String charTypeCode;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_cmpt_char_type.CHAR_TYPE_CODE:Coloured
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    private boolean charTypeCodeColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_cmpt_char_type.CHAR_TYPE_NAME
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    private String charTypeName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_cmpt_char_type.CHAR_TYPE_NAME:Coloured
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    private boolean charTypeNameColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_cmpt_char_type.IS_WILDTYPE
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    private Integer isWildtype;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_cmpt_char_type.IS_WILDTYPE:Coloured
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    private boolean isWildtypeColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_cmpt_char_type.SPEC_TYPE_MASK
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    private Integer specTypeMask;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_cmpt_char_type.SPEC_TYPE_MASK:Coloured
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    private boolean specTypeMaskColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_cmpt_char_type.CLASS_PATH
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    private String classPath;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_cmpt_char_type.CLASS_PATH:Coloured
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    private boolean classPathColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_cmpt_char_type.DESCRIPTION
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    private String description;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_cmpt_char_type.DESCRIPTION:Coloured
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    private boolean descriptionColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_cmpt_char_type.STATUS
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    private Integer status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_cmpt_char_type.STATUS:Coloured
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    private boolean statusColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_cmpt_char_type.LAST_UPDATE_TIME
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    private Date lastUpdateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_cmpt_char_type.LAST_UPDATE_TIME:Coloured
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    private boolean lastUpdateTimeColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_cmpt_char_type.LAST_UPDATE_OPER
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    private String lastUpdateOper;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_cmpt_char_type.LAST_UPDATE_OPER:Coloured
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    private boolean lastUpdateOperColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_cmpt_char_type.CREATE_TIME
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_cmpt_char_type.CREATE_TIME:Coloured
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    private boolean createTimeColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_cmpt_char_type.CREATE_OPER
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    private String createOper;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_cmpt_char_type.CREATE_OPER:Coloured
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    private boolean createOperColoured;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table cf_cmpt_char_type
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_cmpt_char_type.CHAR_TYPE_ID
     *
     * @return the value of cf_cmpt_char_type.CHAR_TYPE_ID
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    public Integer getCharTypeId() {
        return charTypeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_cmpt_char_type.CHAR_TYPE_ID:Coloured
     *
     * @return the value of cf_cmpt_char_type.CHAR_TYPE_ID:Coloured
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    public boolean isCharTypeIdColoured() {
        return charTypeIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_cmpt_char_type.CHAR_TYPE_ID:Coloured
     *
     * @return the value of cf_cmpt_char_type.CHAR_TYPE_ID:Coloured
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    public boolean isCharTypeIdNotColoured() {
        return !charTypeIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cf_cmpt_char_type.CHAR_TYPE_ID
     *
     * @param charTypeId the value for cf_cmpt_char_type.CHAR_TYPE_ID
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    public void setCharTypeId(Integer charTypeId) {
        this.charTypeId = charTypeId;
        this.charTypeIdColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cf_cmpt_char_type.CHAR_TYPE_ID:Coloured
     *
     * @param charTypeIdColoured the value for cf_cmpt_char_type.CHAR_TYPE_ID:Coloured
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    public void setCharTypeIdColoured(boolean charTypeIdColoured) {
        this.charTypeIdColoured = charTypeIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_cmpt_char_type.CHAR_TYPE_CODE
     *
     * @return the value of cf_cmpt_char_type.CHAR_TYPE_CODE
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    public String getCharTypeCode() {
        return charTypeCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_cmpt_char_type.CHAR_TYPE_CODE:Coloured
     *
     * @return the value of cf_cmpt_char_type.CHAR_TYPE_CODE:Coloured
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    public boolean isCharTypeCodeColoured() {
        return charTypeCodeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_cmpt_char_type.CHAR_TYPE_CODE:Coloured
     *
     * @return the value of cf_cmpt_char_type.CHAR_TYPE_CODE:Coloured
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    public boolean isCharTypeCodeNotColoured() {
        return !charTypeCodeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cf_cmpt_char_type.CHAR_TYPE_CODE
     *
     * @param charTypeCode the value for cf_cmpt_char_type.CHAR_TYPE_CODE
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    public void setCharTypeCode(String charTypeCode) {
        this.charTypeCode = charTypeCode == null ? null : charTypeCode.trim();
        this.charTypeCodeColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cf_cmpt_char_type.CHAR_TYPE_CODE:Coloured
     *
     * @param charTypeCodeColoured the value for cf_cmpt_char_type.CHAR_TYPE_CODE:Coloured
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    public void setCharTypeCodeColoured(boolean charTypeCodeColoured) {
        this.charTypeCodeColoured = charTypeCodeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_cmpt_char_type.CHAR_TYPE_NAME
     *
     * @return the value of cf_cmpt_char_type.CHAR_TYPE_NAME
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    public String getCharTypeName() {
        return charTypeName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_cmpt_char_type.CHAR_TYPE_NAME:Coloured
     *
     * @return the value of cf_cmpt_char_type.CHAR_TYPE_NAME:Coloured
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    public boolean isCharTypeNameColoured() {
        return charTypeNameColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_cmpt_char_type.CHAR_TYPE_NAME:Coloured
     *
     * @return the value of cf_cmpt_char_type.CHAR_TYPE_NAME:Coloured
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    public boolean isCharTypeNameNotColoured() {
        return !charTypeNameColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cf_cmpt_char_type.CHAR_TYPE_NAME
     *
     * @param charTypeName the value for cf_cmpt_char_type.CHAR_TYPE_NAME
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    public void setCharTypeName(String charTypeName) {
        this.charTypeName = charTypeName == null ? null : charTypeName.trim();
        this.charTypeNameColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cf_cmpt_char_type.CHAR_TYPE_NAME:Coloured
     *
     * @param charTypeNameColoured the value for cf_cmpt_char_type.CHAR_TYPE_NAME:Coloured
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    public void setCharTypeNameColoured(boolean charTypeNameColoured) {
        this.charTypeNameColoured = charTypeNameColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_cmpt_char_type.IS_WILDTYPE
     *
     * @return the value of cf_cmpt_char_type.IS_WILDTYPE
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    public Integer getIsWildtype() {
        return isWildtype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_cmpt_char_type.IS_WILDTYPE:Coloured
     *
     * @return the value of cf_cmpt_char_type.IS_WILDTYPE:Coloured
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    public boolean isIsWildtypeColoured() {
        return isWildtypeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_cmpt_char_type.IS_WILDTYPE:Coloured
     *
     * @return the value of cf_cmpt_char_type.IS_WILDTYPE:Coloured
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    public boolean isIsWildtypeNotColoured() {
        return !isWildtypeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cf_cmpt_char_type.IS_WILDTYPE
     *
     * @param isWildtype the value for cf_cmpt_char_type.IS_WILDTYPE
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    public void setIsWildtype(Integer isWildtype) {
        this.isWildtype = isWildtype;
        this.isWildtypeColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cf_cmpt_char_type.IS_WILDTYPE:Coloured
     *
     * @param isWildtypeColoured the value for cf_cmpt_char_type.IS_WILDTYPE:Coloured
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    public void setIsWildtypeColoured(boolean isWildtypeColoured) {
        this.isWildtypeColoured = isWildtypeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_cmpt_char_type.SPEC_TYPE_MASK
     *
     * @return the value of cf_cmpt_char_type.SPEC_TYPE_MASK
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    public Integer getSpecTypeMask() {
        return specTypeMask;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_cmpt_char_type.SPEC_TYPE_MASK:Coloured
     *
     * @return the value of cf_cmpt_char_type.SPEC_TYPE_MASK:Coloured
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    public boolean isSpecTypeMaskColoured() {
        return specTypeMaskColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_cmpt_char_type.SPEC_TYPE_MASK:Coloured
     *
     * @return the value of cf_cmpt_char_type.SPEC_TYPE_MASK:Coloured
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    public boolean isSpecTypeMaskNotColoured() {
        return !specTypeMaskColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cf_cmpt_char_type.SPEC_TYPE_MASK
     *
     * @param specTypeMask the value for cf_cmpt_char_type.SPEC_TYPE_MASK
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    public void setSpecTypeMask(Integer specTypeMask) {
        this.specTypeMask = specTypeMask;
        this.specTypeMaskColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cf_cmpt_char_type.SPEC_TYPE_MASK:Coloured
     *
     * @param specTypeMaskColoured the value for cf_cmpt_char_type.SPEC_TYPE_MASK:Coloured
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    public void setSpecTypeMaskColoured(boolean specTypeMaskColoured) {
        this.specTypeMaskColoured = specTypeMaskColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_cmpt_char_type.CLASS_PATH
     *
     * @return the value of cf_cmpt_char_type.CLASS_PATH
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    public String getClassPath() {
        return classPath;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_cmpt_char_type.CLASS_PATH:Coloured
     *
     * @return the value of cf_cmpt_char_type.CLASS_PATH:Coloured
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    public boolean isClassPathColoured() {
        return classPathColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_cmpt_char_type.CLASS_PATH:Coloured
     *
     * @return the value of cf_cmpt_char_type.CLASS_PATH:Coloured
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    public boolean isClassPathNotColoured() {
        return !classPathColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cf_cmpt_char_type.CLASS_PATH
     *
     * @param classPath the value for cf_cmpt_char_type.CLASS_PATH
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    public void setClassPath(String classPath) {
        this.classPath = classPath == null ? null : classPath.trim();
        this.classPathColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cf_cmpt_char_type.CLASS_PATH:Coloured
     *
     * @param classPathColoured the value for cf_cmpt_char_type.CLASS_PATH:Coloured
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    public void setClassPathColoured(boolean classPathColoured) {
        this.classPathColoured = classPathColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_cmpt_char_type.DESCRIPTION
     *
     * @return the value of cf_cmpt_char_type.DESCRIPTION
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_cmpt_char_type.DESCRIPTION:Coloured
     *
     * @return the value of cf_cmpt_char_type.DESCRIPTION:Coloured
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    public boolean isDescriptionColoured() {
        return descriptionColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_cmpt_char_type.DESCRIPTION:Coloured
     *
     * @return the value of cf_cmpt_char_type.DESCRIPTION:Coloured
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    public boolean isDescriptionNotColoured() {
        return !descriptionColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cf_cmpt_char_type.DESCRIPTION
     *
     * @param description the value for cf_cmpt_char_type.DESCRIPTION
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
        this.descriptionColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cf_cmpt_char_type.DESCRIPTION:Coloured
     *
     * @param descriptionColoured the value for cf_cmpt_char_type.DESCRIPTION:Coloured
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    public void setDescriptionColoured(boolean descriptionColoured) {
        this.descriptionColoured = descriptionColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_cmpt_char_type.STATUS
     *
     * @return the value of cf_cmpt_char_type.STATUS
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_cmpt_char_type.STATUS:Coloured
     *
     * @return the value of cf_cmpt_char_type.STATUS:Coloured
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    public boolean isStatusColoured() {
        return statusColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_cmpt_char_type.STATUS:Coloured
     *
     * @return the value of cf_cmpt_char_type.STATUS:Coloured
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    public boolean isStatusNotColoured() {
        return !statusColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cf_cmpt_char_type.STATUS
     *
     * @param status the value for cf_cmpt_char_type.STATUS
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    public void setStatus(Integer status) {
        this.status = status;
        this.statusColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cf_cmpt_char_type.STATUS:Coloured
     *
     * @param statusColoured the value for cf_cmpt_char_type.STATUS:Coloured
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    public void setStatusColoured(boolean statusColoured) {
        this.statusColoured = statusColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_cmpt_char_type.LAST_UPDATE_TIME
     *
     * @return the value of cf_cmpt_char_type.LAST_UPDATE_TIME
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_cmpt_char_type.LAST_UPDATE_TIME:Coloured
     *
     * @return the value of cf_cmpt_char_type.LAST_UPDATE_TIME:Coloured
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    public boolean isLastUpdateTimeColoured() {
        return lastUpdateTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_cmpt_char_type.LAST_UPDATE_TIME:Coloured
     *
     * @return the value of cf_cmpt_char_type.LAST_UPDATE_TIME:Coloured
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    public boolean isLastUpdateTimeNotColoured() {
        return !lastUpdateTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cf_cmpt_char_type.LAST_UPDATE_TIME
     *
     * @param lastUpdateTime the value for cf_cmpt_char_type.LAST_UPDATE_TIME
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
        this.lastUpdateTimeColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cf_cmpt_char_type.LAST_UPDATE_TIME:Coloured
     *
     * @param lastUpdateTimeColoured the value for cf_cmpt_char_type.LAST_UPDATE_TIME:Coloured
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    public void setLastUpdateTimeColoured(boolean lastUpdateTimeColoured) {
        this.lastUpdateTimeColoured = lastUpdateTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_cmpt_char_type.LAST_UPDATE_OPER
     *
     * @return the value of cf_cmpt_char_type.LAST_UPDATE_OPER
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    public String getLastUpdateOper() {
        return lastUpdateOper;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_cmpt_char_type.LAST_UPDATE_OPER:Coloured
     *
     * @return the value of cf_cmpt_char_type.LAST_UPDATE_OPER:Coloured
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    public boolean isLastUpdateOperColoured() {
        return lastUpdateOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_cmpt_char_type.LAST_UPDATE_OPER:Coloured
     *
     * @return the value of cf_cmpt_char_type.LAST_UPDATE_OPER:Coloured
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    public boolean isLastUpdateOperNotColoured() {
        return !lastUpdateOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cf_cmpt_char_type.LAST_UPDATE_OPER
     *
     * @param lastUpdateOper the value for cf_cmpt_char_type.LAST_UPDATE_OPER
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    public void setLastUpdateOper(String lastUpdateOper) {
        this.lastUpdateOper = lastUpdateOper == null ? null : lastUpdateOper.trim();
        this.lastUpdateOperColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cf_cmpt_char_type.LAST_UPDATE_OPER:Coloured
     *
     * @param lastUpdateOperColoured the value for cf_cmpt_char_type.LAST_UPDATE_OPER:Coloured
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    public void setLastUpdateOperColoured(boolean lastUpdateOperColoured) {
        this.lastUpdateOperColoured = lastUpdateOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_cmpt_char_type.CREATE_TIME
     *
     * @return the value of cf_cmpt_char_type.CREATE_TIME
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_cmpt_char_type.CREATE_TIME:Coloured
     *
     * @return the value of cf_cmpt_char_type.CREATE_TIME:Coloured
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    public boolean isCreateTimeColoured() {
        return createTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_cmpt_char_type.CREATE_TIME:Coloured
     *
     * @return the value of cf_cmpt_char_type.CREATE_TIME:Coloured
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    public boolean isCreateTimeNotColoured() {
        return !createTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cf_cmpt_char_type.CREATE_TIME
     *
     * @param createTime the value for cf_cmpt_char_type.CREATE_TIME
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
        this.createTimeColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cf_cmpt_char_type.CREATE_TIME:Coloured
     *
     * @param createTimeColoured the value for cf_cmpt_char_type.CREATE_TIME:Coloured
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    public void setCreateTimeColoured(boolean createTimeColoured) {
        this.createTimeColoured = createTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_cmpt_char_type.CREATE_OPER
     *
     * @return the value of cf_cmpt_char_type.CREATE_OPER
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    public String getCreateOper() {
        return createOper;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_cmpt_char_type.CREATE_OPER:Coloured
     *
     * @return the value of cf_cmpt_char_type.CREATE_OPER:Coloured
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    public boolean isCreateOperColoured() {
        return createOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_cmpt_char_type.CREATE_OPER:Coloured
     *
     * @return the value of cf_cmpt_char_type.CREATE_OPER:Coloured
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    public boolean isCreateOperNotColoured() {
        return !createOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cf_cmpt_char_type.CREATE_OPER
     *
     * @param createOper the value for cf_cmpt_char_type.CREATE_OPER
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    public void setCreateOper(String createOper) {
        this.createOper = createOper == null ? null : createOper.trim();
        this.createOperColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cf_cmpt_char_type.CREATE_OPER:Coloured
     *
     * @param createOperColoured the value for cf_cmpt_char_type.CREATE_OPER:Coloured
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    public void setCreateOperColoured(boolean createOperColoured) {
        this.createOperColoured = createOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_char_type
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
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
        CfCmptCharType other = (CfCmptCharType) that;
        return (this.getCharTypeId() == null ? other.getCharTypeId() == null : this.getCharTypeId().equals(other.getCharTypeId()))
            && (this.getCharTypeCode() == null ? other.getCharTypeCode() == null : this.getCharTypeCode().equals(other.getCharTypeCode()))
            && (this.getCharTypeName() == null ? other.getCharTypeName() == null : this.getCharTypeName().equals(other.getCharTypeName()))
            && (this.getIsWildtype() == null ? other.getIsWildtype() == null : this.getIsWildtype().equals(other.getIsWildtype()))
            && (this.getSpecTypeMask() == null ? other.getSpecTypeMask() == null : this.getSpecTypeMask().equals(other.getSpecTypeMask()))
            && (this.getClassPath() == null ? other.getClassPath() == null : this.getClassPath().equals(other.getClassPath()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getLastUpdateTime() == null ? other.getLastUpdateTime() == null : this.getLastUpdateTime().equals(other.getLastUpdateTime()))
            && (this.getLastUpdateOper() == null ? other.getLastUpdateOper() == null : this.getLastUpdateOper().equals(other.getLastUpdateOper()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getCreateOper() == null ? other.getCreateOper() == null : this.getCreateOper().equals(other.getCreateOper()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_char_type
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCharTypeId() == null) ? 0 : getCharTypeId().hashCode());
        result = prime * result + ((getCharTypeCode() == null) ? 0 : getCharTypeCode().hashCode());
        result = prime * result + ((getCharTypeName() == null) ? 0 : getCharTypeName().hashCode());
        result = prime * result + ((getIsWildtype() == null) ? 0 : getIsWildtype().hashCode());
        result = prime * result + ((getSpecTypeMask() == null) ? 0 : getSpecTypeMask().hashCode());
        result = prime * result + ((getClassPath() == null) ? 0 : getClassPath().hashCode());
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
     * This method corresponds to the database table cf_cmpt_char_type
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    @Override
    public void copyProperties(Object that) {
        if (this == that || that == null || this.getClass() != that.getClass() ) {
            return;
        }
        CfCmptCharType other = (CfCmptCharType) that;
        if(other.isCharTypeIdColoured() ) {this.setCharTypeId(other.getCharTypeId() );}
        if(other.isCharTypeCodeColoured() ) {this.setCharTypeCode(other.getCharTypeCode() );}
        if(other.isCharTypeNameColoured() ) {this.setCharTypeName(other.getCharTypeName() );}
        if(other.isIsWildtypeColoured() ) {this.setIsWildtype(other.getIsWildtype() );}
        if(other.isSpecTypeMaskColoured() ) {this.setSpecTypeMask(other.getSpecTypeMask() );}
        if(other.isClassPathColoured() ) {this.setClassPath(other.getClassPath() );}
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
     * This method corresponds to the database table cf_cmpt_char_type
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    @Override
    public JSONObject toJSON() {
        HashMap<String, Object> hashMap = new HashMap();
        if(this.charTypeIdColoured) {hashMap.put("charTypeId", this.charTypeId);}
        if(this.charTypeCodeColoured) {hashMap.put("charTypeCode", this.charTypeCode);}
        if(this.charTypeNameColoured) {hashMap.put("charTypeName", this.charTypeName);}
        if(this.isWildtypeColoured) {hashMap.put("isWildtype", this.isWildtype);}
        if(this.specTypeMaskColoured) {hashMap.put("specTypeMask", this.specTypeMask);}
        if(this.classPathColoured) {hashMap.put("classPath", this.classPath);}
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
     * This method corresponds to the database table cf_cmpt_char_type
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    @Override
    public void clear() {
        if(this.charTypeIdColoured) {this.charTypeId = null; this.charTypeIdColoured = false;}
        if(this.charTypeCodeColoured) {this.charTypeCode = null; this.charTypeCodeColoured = false;}
        if(this.charTypeNameColoured) {this.charTypeName = null; this.charTypeNameColoured = false;}
        if(this.isWildtypeColoured) {this.isWildtype = null; this.isWildtypeColoured = false;}
        if(this.specTypeMaskColoured) {this.specTypeMask = null; this.specTypeMaskColoured = false;}
        if(this.classPathColoured) {this.classPath = null; this.classPathColoured = false;}
        if(this.descriptionColoured) {this.description = null; this.descriptionColoured = false;}
        if(this.statusColoured) {this.status = null; this.statusColoured = false;}
        if(this.lastUpdateTimeColoured) {this.lastUpdateTime = null; this.lastUpdateTimeColoured = false;}
        if(this.lastUpdateOperColoured) {this.lastUpdateOper = null; this.lastUpdateOperColoured = false;}
        if(this.createTimeColoured) {this.createTime = null; this.createTimeColoured = false;}
        if(this.createOperColoured) {this.createOper = null; this.createOperColoured = false;}
        return;
    }
}