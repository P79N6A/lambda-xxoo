package com.yatop.lambda.base.model;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yatop.lambda.base.utils.LambdaRootModel;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;

public class CfCmptCharEnum extends LambdaRootModel implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_cmpt_char_enum.CHAR_ID
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    private String charId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_cmpt_char_enum.CHAR_ID:Coloured
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    private boolean charIdColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_cmpt_char_enum.ENUM_NAME
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    private String enumName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_cmpt_char_enum.ENUM_NAME:Coloured
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    private boolean enumNameColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_cmpt_char_enum.ENUM_VALUE
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    private String enumValue;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_cmpt_char_enum.ENUM_VALUE:Coloured
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    private boolean enumValueColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_cmpt_char_enum.ENUM_LABEL
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    private String enumLabel;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_cmpt_char_enum.ENUM_LABEL:Coloured
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    private boolean enumLabelColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_cmpt_char_enum.SEQUENCE
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    private Integer sequence;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_cmpt_char_enum.SEQUENCE:Coloured
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    private boolean sequenceColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_cmpt_char_enum.DESCRIPTION
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    private String description;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_cmpt_char_enum.DESCRIPTION:Coloured
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    private boolean descriptionColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_cmpt_char_enum.STATUS
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    private Integer status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_cmpt_char_enum.STATUS:Coloured
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    private boolean statusColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_cmpt_char_enum.LAST_UPDATE_TIME
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    private Date lastUpdateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_cmpt_char_enum.LAST_UPDATE_TIME:Coloured
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    private boolean lastUpdateTimeColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_cmpt_char_enum.LAST_UPDATE_OPER
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    private String lastUpdateOper;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_cmpt_char_enum.LAST_UPDATE_OPER:Coloured
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    private boolean lastUpdateOperColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_cmpt_char_enum.CREATE_TIME
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_cmpt_char_enum.CREATE_TIME:Coloured
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    private boolean createTimeColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_cmpt_char_enum.CREATE_OPER
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    private String createOper;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_cmpt_char_enum.CREATE_OPER:Coloured
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    private boolean createOperColoured;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table cf_cmpt_char_enum
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_cmpt_char_enum.CHAR_ID
     *
     * @return the value of cf_cmpt_char_enum.CHAR_ID
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    public String getCharId() {
        return charId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_cmpt_char_enum.CHAR_ID:Coloured
     *
     * @return the value of cf_cmpt_char_enum.CHAR_ID:Coloured
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    public boolean isCharIdColoured() {
        return charIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_cmpt_char_enum.CHAR_ID:Coloured
     *
     * @return the value of cf_cmpt_char_enum.CHAR_ID:Coloured
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    public boolean isCharIdNotColoured() {
        return !charIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cf_cmpt_char_enum.CHAR_ID
     *
     * @param charId the value for cf_cmpt_char_enum.CHAR_ID
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    public void setCharId(String charId) {
        this.charId = charId == null ? null : charId.trim();
        this.charIdColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cf_cmpt_char_enum.CHAR_ID:Coloured
     *
     * @param charIdColoured the value for cf_cmpt_char_enum.CHAR_ID:Coloured
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    public void setCharIdColoured(boolean charIdColoured) {
        this.charIdColoured = charIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_cmpt_char_enum.ENUM_NAME
     *
     * @return the value of cf_cmpt_char_enum.ENUM_NAME
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    public String getEnumName() {
        return enumName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_cmpt_char_enum.ENUM_NAME:Coloured
     *
     * @return the value of cf_cmpt_char_enum.ENUM_NAME:Coloured
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    public boolean isEnumNameColoured() {
        return enumNameColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_cmpt_char_enum.ENUM_NAME:Coloured
     *
     * @return the value of cf_cmpt_char_enum.ENUM_NAME:Coloured
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    public boolean isEnumNameNotColoured() {
        return !enumNameColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cf_cmpt_char_enum.ENUM_NAME
     *
     * @param enumName the value for cf_cmpt_char_enum.ENUM_NAME
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    public void setEnumName(String enumName) {
        this.enumName = enumName == null ? null : enumName.trim();
        this.enumNameColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cf_cmpt_char_enum.ENUM_NAME:Coloured
     *
     * @param enumNameColoured the value for cf_cmpt_char_enum.ENUM_NAME:Coloured
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    public void setEnumNameColoured(boolean enumNameColoured) {
        this.enumNameColoured = enumNameColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_cmpt_char_enum.ENUM_VALUE
     *
     * @return the value of cf_cmpt_char_enum.ENUM_VALUE
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    public String getEnumValue() {
        return enumValue;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_cmpt_char_enum.ENUM_VALUE:Coloured
     *
     * @return the value of cf_cmpt_char_enum.ENUM_VALUE:Coloured
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    public boolean isEnumValueColoured() {
        return enumValueColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_cmpt_char_enum.ENUM_VALUE:Coloured
     *
     * @return the value of cf_cmpt_char_enum.ENUM_VALUE:Coloured
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    public boolean isEnumValueNotColoured() {
        return !enumValueColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cf_cmpt_char_enum.ENUM_VALUE
     *
     * @param enumValue the value for cf_cmpt_char_enum.ENUM_VALUE
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    public void setEnumValue(String enumValue) {
        this.enumValue = enumValue == null ? null : enumValue.trim();
        this.enumValueColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cf_cmpt_char_enum.ENUM_VALUE:Coloured
     *
     * @param enumValueColoured the value for cf_cmpt_char_enum.ENUM_VALUE:Coloured
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    public void setEnumValueColoured(boolean enumValueColoured) {
        this.enumValueColoured = enumValueColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_cmpt_char_enum.ENUM_LABEL
     *
     * @return the value of cf_cmpt_char_enum.ENUM_LABEL
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    public String getEnumLabel() {
        return enumLabel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_cmpt_char_enum.ENUM_LABEL:Coloured
     *
     * @return the value of cf_cmpt_char_enum.ENUM_LABEL:Coloured
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    public boolean isEnumLabelColoured() {
        return enumLabelColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_cmpt_char_enum.ENUM_LABEL:Coloured
     *
     * @return the value of cf_cmpt_char_enum.ENUM_LABEL:Coloured
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    public boolean isEnumLabelNotColoured() {
        return !enumLabelColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cf_cmpt_char_enum.ENUM_LABEL
     *
     * @param enumLabel the value for cf_cmpt_char_enum.ENUM_LABEL
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    public void setEnumLabel(String enumLabel) {
        this.enumLabel = enumLabel == null ? null : enumLabel.trim();
        this.enumLabelColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cf_cmpt_char_enum.ENUM_LABEL:Coloured
     *
     * @param enumLabelColoured the value for cf_cmpt_char_enum.ENUM_LABEL:Coloured
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    public void setEnumLabelColoured(boolean enumLabelColoured) {
        this.enumLabelColoured = enumLabelColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_cmpt_char_enum.SEQUENCE
     *
     * @return the value of cf_cmpt_char_enum.SEQUENCE
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    public Integer getSequence() {
        return sequence;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_cmpt_char_enum.SEQUENCE:Coloured
     *
     * @return the value of cf_cmpt_char_enum.SEQUENCE:Coloured
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    public boolean isSequenceColoured() {
        return sequenceColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_cmpt_char_enum.SEQUENCE:Coloured
     *
     * @return the value of cf_cmpt_char_enum.SEQUENCE:Coloured
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    public boolean isSequenceNotColoured() {
        return !sequenceColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cf_cmpt_char_enum.SEQUENCE
     *
     * @param sequence the value for cf_cmpt_char_enum.SEQUENCE
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    public void setSequence(Integer sequence) {
        this.sequence = sequence;
        this.sequenceColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cf_cmpt_char_enum.SEQUENCE:Coloured
     *
     * @param sequenceColoured the value for cf_cmpt_char_enum.SEQUENCE:Coloured
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    public void setSequenceColoured(boolean sequenceColoured) {
        this.sequenceColoured = sequenceColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_cmpt_char_enum.DESCRIPTION
     *
     * @return the value of cf_cmpt_char_enum.DESCRIPTION
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_cmpt_char_enum.DESCRIPTION:Coloured
     *
     * @return the value of cf_cmpt_char_enum.DESCRIPTION:Coloured
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    public boolean isDescriptionColoured() {
        return descriptionColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_cmpt_char_enum.DESCRIPTION:Coloured
     *
     * @return the value of cf_cmpt_char_enum.DESCRIPTION:Coloured
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    public boolean isDescriptionNotColoured() {
        return !descriptionColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cf_cmpt_char_enum.DESCRIPTION
     *
     * @param description the value for cf_cmpt_char_enum.DESCRIPTION
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
        this.descriptionColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cf_cmpt_char_enum.DESCRIPTION:Coloured
     *
     * @param descriptionColoured the value for cf_cmpt_char_enum.DESCRIPTION:Coloured
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    public void setDescriptionColoured(boolean descriptionColoured) {
        this.descriptionColoured = descriptionColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_cmpt_char_enum.STATUS
     *
     * @return the value of cf_cmpt_char_enum.STATUS
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_cmpt_char_enum.STATUS:Coloured
     *
     * @return the value of cf_cmpt_char_enum.STATUS:Coloured
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    public boolean isStatusColoured() {
        return statusColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_cmpt_char_enum.STATUS:Coloured
     *
     * @return the value of cf_cmpt_char_enum.STATUS:Coloured
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    public boolean isStatusNotColoured() {
        return !statusColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cf_cmpt_char_enum.STATUS
     *
     * @param status the value for cf_cmpt_char_enum.STATUS
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    public void setStatus(Integer status) {
        this.status = status;
        this.statusColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cf_cmpt_char_enum.STATUS:Coloured
     *
     * @param statusColoured the value for cf_cmpt_char_enum.STATUS:Coloured
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    public void setStatusColoured(boolean statusColoured) {
        this.statusColoured = statusColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_cmpt_char_enum.LAST_UPDATE_TIME
     *
     * @return the value of cf_cmpt_char_enum.LAST_UPDATE_TIME
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_cmpt_char_enum.LAST_UPDATE_TIME:Coloured
     *
     * @return the value of cf_cmpt_char_enum.LAST_UPDATE_TIME:Coloured
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    public boolean isLastUpdateTimeColoured() {
        return lastUpdateTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_cmpt_char_enum.LAST_UPDATE_TIME:Coloured
     *
     * @return the value of cf_cmpt_char_enum.LAST_UPDATE_TIME:Coloured
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    public boolean isLastUpdateTimeNotColoured() {
        return !lastUpdateTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cf_cmpt_char_enum.LAST_UPDATE_TIME
     *
     * @param lastUpdateTime the value for cf_cmpt_char_enum.LAST_UPDATE_TIME
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
        this.lastUpdateTimeColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cf_cmpt_char_enum.LAST_UPDATE_TIME:Coloured
     *
     * @param lastUpdateTimeColoured the value for cf_cmpt_char_enum.LAST_UPDATE_TIME:Coloured
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    public void setLastUpdateTimeColoured(boolean lastUpdateTimeColoured) {
        this.lastUpdateTimeColoured = lastUpdateTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_cmpt_char_enum.LAST_UPDATE_OPER
     *
     * @return the value of cf_cmpt_char_enum.LAST_UPDATE_OPER
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    public String getLastUpdateOper() {
        return lastUpdateOper;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_cmpt_char_enum.LAST_UPDATE_OPER:Coloured
     *
     * @return the value of cf_cmpt_char_enum.LAST_UPDATE_OPER:Coloured
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    public boolean isLastUpdateOperColoured() {
        return lastUpdateOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_cmpt_char_enum.LAST_UPDATE_OPER:Coloured
     *
     * @return the value of cf_cmpt_char_enum.LAST_UPDATE_OPER:Coloured
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    public boolean isLastUpdateOperNotColoured() {
        return !lastUpdateOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cf_cmpt_char_enum.LAST_UPDATE_OPER
     *
     * @param lastUpdateOper the value for cf_cmpt_char_enum.LAST_UPDATE_OPER
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    public void setLastUpdateOper(String lastUpdateOper) {
        this.lastUpdateOper = lastUpdateOper == null ? null : lastUpdateOper.trim();
        this.lastUpdateOperColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cf_cmpt_char_enum.LAST_UPDATE_OPER:Coloured
     *
     * @param lastUpdateOperColoured the value for cf_cmpt_char_enum.LAST_UPDATE_OPER:Coloured
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    public void setLastUpdateOperColoured(boolean lastUpdateOperColoured) {
        this.lastUpdateOperColoured = lastUpdateOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_cmpt_char_enum.CREATE_TIME
     *
     * @return the value of cf_cmpt_char_enum.CREATE_TIME
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_cmpt_char_enum.CREATE_TIME:Coloured
     *
     * @return the value of cf_cmpt_char_enum.CREATE_TIME:Coloured
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    public boolean isCreateTimeColoured() {
        return createTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_cmpt_char_enum.CREATE_TIME:Coloured
     *
     * @return the value of cf_cmpt_char_enum.CREATE_TIME:Coloured
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    public boolean isCreateTimeNotColoured() {
        return !createTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cf_cmpt_char_enum.CREATE_TIME
     *
     * @param createTime the value for cf_cmpt_char_enum.CREATE_TIME
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
        this.createTimeColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cf_cmpt_char_enum.CREATE_TIME:Coloured
     *
     * @param createTimeColoured the value for cf_cmpt_char_enum.CREATE_TIME:Coloured
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    public void setCreateTimeColoured(boolean createTimeColoured) {
        this.createTimeColoured = createTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_cmpt_char_enum.CREATE_OPER
     *
     * @return the value of cf_cmpt_char_enum.CREATE_OPER
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    public String getCreateOper() {
        return createOper;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_cmpt_char_enum.CREATE_OPER:Coloured
     *
     * @return the value of cf_cmpt_char_enum.CREATE_OPER:Coloured
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    public boolean isCreateOperColoured() {
        return createOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_cmpt_char_enum.CREATE_OPER:Coloured
     *
     * @return the value of cf_cmpt_char_enum.CREATE_OPER:Coloured
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    public boolean isCreateOperNotColoured() {
        return !createOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cf_cmpt_char_enum.CREATE_OPER
     *
     * @param createOper the value for cf_cmpt_char_enum.CREATE_OPER
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    public void setCreateOper(String createOper) {
        this.createOper = createOper == null ? null : createOper.trim();
        this.createOperColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cf_cmpt_char_enum.CREATE_OPER:Coloured
     *
     * @param createOperColoured the value for cf_cmpt_char_enum.CREATE_OPER:Coloured
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    public void setCreateOperColoured(boolean createOperColoured) {
        this.createOperColoured = createOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_char_enum
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
        CfCmptCharEnum other = (CfCmptCharEnum) that;
        return (this.getCharId() == null ? other.getCharId() == null : this.getCharId().equals(other.getCharId()))
            && (this.getEnumName() == null ? other.getEnumName() == null : this.getEnumName().equals(other.getEnumName()))
            && (this.getEnumValue() == null ? other.getEnumValue() == null : this.getEnumValue().equals(other.getEnumValue()))
            && (this.getEnumLabel() == null ? other.getEnumLabel() == null : this.getEnumLabel().equals(other.getEnumLabel()))
            && (this.getSequence() == null ? other.getSequence() == null : this.getSequence().equals(other.getSequence()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getLastUpdateTime() == null ? other.getLastUpdateTime() == null : this.getLastUpdateTime().equals(other.getLastUpdateTime()))
            && (this.getLastUpdateOper() == null ? other.getLastUpdateOper() == null : this.getLastUpdateOper().equals(other.getLastUpdateOper()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getCreateOper() == null ? other.getCreateOper() == null : this.getCreateOper().equals(other.getCreateOper()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_char_enum
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCharId() == null) ? 0 : getCharId().hashCode());
        result = prime * result + ((getEnumName() == null) ? 0 : getEnumName().hashCode());
        result = prime * result + ((getEnumValue() == null) ? 0 : getEnumValue().hashCode());
        result = prime * result + ((getEnumLabel() == null) ? 0 : getEnumLabel().hashCode());
        result = prime * result + ((getSequence() == null) ? 0 : getSequence().hashCode());
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
     * This method corresponds to the database table cf_cmpt_char_enum
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    @Override
    public void copyProperties(Object that) {
        if (this == that || that == null || this.getClass() != that.getClass() ) {
            return;
        }
        CfCmptCharEnum other = (CfCmptCharEnum) that;
        if(other.isCharIdColoured() ) {this.setCharId(other.getCharId() );}
        if(other.isEnumNameColoured() ) {this.setEnumName(other.getEnumName() );}
        if(other.isEnumValueColoured() ) {this.setEnumValue(other.getEnumValue() );}
        if(other.isEnumLabelColoured() ) {this.setEnumLabel(other.getEnumLabel() );}
        if(other.isSequenceColoured() ) {this.setSequence(other.getSequence() );}
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
     * This method corresponds to the database table cf_cmpt_char_enum
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    @Override
    public JSONObject toJSON() {
        HashMap<String, Object> hashMap = new HashMap();
        if(this.charIdColoured) {hashMap.put("charId", this.charId);}
        if(this.enumNameColoured) {hashMap.put("enumName", this.enumName);}
        if(this.enumValueColoured) {hashMap.put("enumValue", this.enumValue);}
        if(this.enumLabelColoured) {hashMap.put("enumLabel", this.enumLabel);}
        if(this.sequenceColoured) {hashMap.put("sequence", this.sequence);}
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
     * This method corresponds to the database table cf_cmpt_char_enum
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    @Override
    public void clear() {
        if(this.charIdColoured) {this.charId = null; this.charIdColoured = false;}
        if(this.enumNameColoured) {this.enumName = null; this.enumNameColoured = false;}
        if(this.enumValueColoured) {this.enumValue = null; this.enumValueColoured = false;}
        if(this.enumLabelColoured) {this.enumLabel = null; this.enumLabelColoured = false;}
        if(this.sequenceColoured) {this.sequence = null; this.sequenceColoured = false;}
        if(this.descriptionColoured) {this.description = null; this.descriptionColoured = false;}
        if(this.statusColoured) {this.status = null; this.statusColoured = false;}
        if(this.lastUpdateTimeColoured) {this.lastUpdateTime = null; this.lastUpdateTimeColoured = false;}
        if(this.lastUpdateOperColoured) {this.lastUpdateOper = null; this.lastUpdateOperColoured = false;}
        if(this.createTimeColoured) {this.createTime = null; this.createTimeColoured = false;}
        if(this.createOperColoured) {this.createOper = null; this.createOperColoured = false;}
        return;
    }
}