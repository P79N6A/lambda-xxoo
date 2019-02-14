package com.yatop.lambda.base.model;

import com.alibaba.fastjson.JSONObject;
import com.yatop.lambda.base.utils.LambdaRootModel;
import java.io.Serializable;
import java.util.Date;

public class CfComponent extends LambdaRootModel implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_component.CMPT_ID
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    private String cmptId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_component.CMPT_ID:Coloured
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    private boolean cmptIdColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_component.CMPT_CODE
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    private String cmptCode;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_component.CMPT_CODE:Coloured
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    private boolean cmptCodeColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_component.CMPT_NAME
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    private String cmptName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_component.CMPT_NAME:Coloured
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    private boolean cmptNameColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_component.CMPT_TYPE
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    private Integer cmptType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_component.CMPT_TYPE:Coloured
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    private boolean cmptTypeColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_component.REL_ALGORITHM_ID
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    private Long relAlgorithmId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_component.REL_ALGORITHM_ID:Coloured
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    private boolean relAlgorithmIdColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_component.DESCRIPTION
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    private String description;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_component.DESCRIPTION:Coloured
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    private boolean descriptionColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_component.STATUS
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    private Integer status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_component.STATUS:Coloured
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    private boolean statusColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_component.LAST_UPDATE_TIME
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    private Date lastUpdateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_component.LAST_UPDATE_TIME:Coloured
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    private boolean lastUpdateTimeColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_component.LAST_UPDATE_OPER
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    private String lastUpdateOper;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_component.LAST_UPDATE_OPER:Coloured
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    private boolean lastUpdateOperColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_component.CREATE_TIME
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_component.CREATE_TIME:Coloured
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    private boolean createTimeColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_component.CREATE_OPER
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    private String createOper;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_component.CREATE_OPER:Coloured
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    private boolean createOperColoured;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table cf_component
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_component.CMPT_ID
     *
     * @return the value of cf_component.CMPT_ID
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    public String getCmptId() {
        return cmptId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_component.CMPT_ID:Coloured
     *
     * @return the value of cf_component.CMPT_ID:Coloured
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    public boolean isCmptIdColoured() {
        return cmptIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_component.CMPT_ID:Coloured
     *
     * @return the value of cf_component.CMPT_ID:Coloured
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    public boolean isCmptIdNotColoured() {
        return !cmptIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cf_component.CMPT_ID
     *
     * @param cmptId the value for cf_component.CMPT_ID
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    public void setCmptId(String cmptId) {
        this.cmptId = cmptId == null ? null : cmptId.trim();
        this.cmptIdColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cf_component.CMPT_ID:Coloured
     *
     * @param cmptIdColoured the value for cf_component.CMPT_ID:Coloured
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    public void setCmptIdColoured(boolean cmptIdColoured) {
        this.cmptIdColoured = cmptIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_component.CMPT_CODE
     *
     * @return the value of cf_component.CMPT_CODE
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    public String getCmptCode() {
        return cmptCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_component.CMPT_CODE:Coloured
     *
     * @return the value of cf_component.CMPT_CODE:Coloured
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    public boolean isCmptCodeColoured() {
        return cmptCodeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_component.CMPT_CODE:Coloured
     *
     * @return the value of cf_component.CMPT_CODE:Coloured
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    public boolean isCmptCodeNotColoured() {
        return !cmptCodeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cf_component.CMPT_CODE
     *
     * @param cmptCode the value for cf_component.CMPT_CODE
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    public void setCmptCode(String cmptCode) {
        this.cmptCode = cmptCode == null ? null : cmptCode.trim();
        this.cmptCodeColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cf_component.CMPT_CODE:Coloured
     *
     * @param cmptCodeColoured the value for cf_component.CMPT_CODE:Coloured
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    public void setCmptCodeColoured(boolean cmptCodeColoured) {
        this.cmptCodeColoured = cmptCodeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_component.CMPT_NAME
     *
     * @return the value of cf_component.CMPT_NAME
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    public String getCmptName() {
        return cmptName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_component.CMPT_NAME:Coloured
     *
     * @return the value of cf_component.CMPT_NAME:Coloured
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    public boolean isCmptNameColoured() {
        return cmptNameColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_component.CMPT_NAME:Coloured
     *
     * @return the value of cf_component.CMPT_NAME:Coloured
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    public boolean isCmptNameNotColoured() {
        return !cmptNameColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cf_component.CMPT_NAME
     *
     * @param cmptName the value for cf_component.CMPT_NAME
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    public void setCmptName(String cmptName) {
        this.cmptName = cmptName == null ? null : cmptName.trim();
        this.cmptNameColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cf_component.CMPT_NAME:Coloured
     *
     * @param cmptNameColoured the value for cf_component.CMPT_NAME:Coloured
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    public void setCmptNameColoured(boolean cmptNameColoured) {
        this.cmptNameColoured = cmptNameColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_component.CMPT_TYPE
     *
     * @return the value of cf_component.CMPT_TYPE
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    public Integer getCmptType() {
        return cmptType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_component.CMPT_TYPE:Coloured
     *
     * @return the value of cf_component.CMPT_TYPE:Coloured
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    public boolean isCmptTypeColoured() {
        return cmptTypeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_component.CMPT_TYPE:Coloured
     *
     * @return the value of cf_component.CMPT_TYPE:Coloured
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    public boolean isCmptTypeNotColoured() {
        return !cmptTypeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cf_component.CMPT_TYPE
     *
     * @param cmptType the value for cf_component.CMPT_TYPE
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    public void setCmptType(Integer cmptType) {
        this.cmptType = cmptType;
        this.cmptTypeColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cf_component.CMPT_TYPE:Coloured
     *
     * @param cmptTypeColoured the value for cf_component.CMPT_TYPE:Coloured
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    public void setCmptTypeColoured(boolean cmptTypeColoured) {
        this.cmptTypeColoured = cmptTypeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_component.REL_ALGORITHM_ID
     *
     * @return the value of cf_component.REL_ALGORITHM_ID
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    public Long getRelAlgorithmId() {
        return relAlgorithmId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_component.REL_ALGORITHM_ID:Coloured
     *
     * @return the value of cf_component.REL_ALGORITHM_ID:Coloured
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    public boolean isRelAlgorithmIdColoured() {
        return relAlgorithmIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_component.REL_ALGORITHM_ID:Coloured
     *
     * @return the value of cf_component.REL_ALGORITHM_ID:Coloured
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    public boolean isRelAlgorithmIdNotColoured() {
        return !relAlgorithmIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cf_component.REL_ALGORITHM_ID
     *
     * @param relAlgorithmId the value for cf_component.REL_ALGORITHM_ID
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    public void setRelAlgorithmId(Long relAlgorithmId) {
        this.relAlgorithmId = relAlgorithmId;
        this.relAlgorithmIdColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cf_component.REL_ALGORITHM_ID:Coloured
     *
     * @param relAlgorithmIdColoured the value for cf_component.REL_ALGORITHM_ID:Coloured
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    public void setRelAlgorithmIdColoured(boolean relAlgorithmIdColoured) {
        this.relAlgorithmIdColoured = relAlgorithmIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_component.DESCRIPTION
     *
     * @return the value of cf_component.DESCRIPTION
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_component.DESCRIPTION:Coloured
     *
     * @return the value of cf_component.DESCRIPTION:Coloured
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    public boolean isDescriptionColoured() {
        return descriptionColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_component.DESCRIPTION:Coloured
     *
     * @return the value of cf_component.DESCRIPTION:Coloured
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    public boolean isDescriptionNotColoured() {
        return !descriptionColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cf_component.DESCRIPTION
     *
     * @param description the value for cf_component.DESCRIPTION
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
        this.descriptionColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cf_component.DESCRIPTION:Coloured
     *
     * @param descriptionColoured the value for cf_component.DESCRIPTION:Coloured
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    public void setDescriptionColoured(boolean descriptionColoured) {
        this.descriptionColoured = descriptionColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_component.STATUS
     *
     * @return the value of cf_component.STATUS
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_component.STATUS:Coloured
     *
     * @return the value of cf_component.STATUS:Coloured
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    public boolean isStatusColoured() {
        return statusColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_component.STATUS:Coloured
     *
     * @return the value of cf_component.STATUS:Coloured
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    public boolean isStatusNotColoured() {
        return !statusColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cf_component.STATUS
     *
     * @param status the value for cf_component.STATUS
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    public void setStatus(Integer status) {
        this.status = status;
        this.statusColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cf_component.STATUS:Coloured
     *
     * @param statusColoured the value for cf_component.STATUS:Coloured
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    public void setStatusColoured(boolean statusColoured) {
        this.statusColoured = statusColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_component.LAST_UPDATE_TIME
     *
     * @return the value of cf_component.LAST_UPDATE_TIME
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_component.LAST_UPDATE_TIME:Coloured
     *
     * @return the value of cf_component.LAST_UPDATE_TIME:Coloured
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    public boolean isLastUpdateTimeColoured() {
        return lastUpdateTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_component.LAST_UPDATE_TIME:Coloured
     *
     * @return the value of cf_component.LAST_UPDATE_TIME:Coloured
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    public boolean isLastUpdateTimeNotColoured() {
        return !lastUpdateTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cf_component.LAST_UPDATE_TIME
     *
     * @param lastUpdateTime the value for cf_component.LAST_UPDATE_TIME
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
        this.lastUpdateTimeColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cf_component.LAST_UPDATE_TIME:Coloured
     *
     * @param lastUpdateTimeColoured the value for cf_component.LAST_UPDATE_TIME:Coloured
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    public void setLastUpdateTimeColoured(boolean lastUpdateTimeColoured) {
        this.lastUpdateTimeColoured = lastUpdateTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_component.LAST_UPDATE_OPER
     *
     * @return the value of cf_component.LAST_UPDATE_OPER
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    public String getLastUpdateOper() {
        return lastUpdateOper;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_component.LAST_UPDATE_OPER:Coloured
     *
     * @return the value of cf_component.LAST_UPDATE_OPER:Coloured
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    public boolean isLastUpdateOperColoured() {
        return lastUpdateOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_component.LAST_UPDATE_OPER:Coloured
     *
     * @return the value of cf_component.LAST_UPDATE_OPER:Coloured
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    public boolean isLastUpdateOperNotColoured() {
        return !lastUpdateOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cf_component.LAST_UPDATE_OPER
     *
     * @param lastUpdateOper the value for cf_component.LAST_UPDATE_OPER
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    public void setLastUpdateOper(String lastUpdateOper) {
        this.lastUpdateOper = lastUpdateOper == null ? null : lastUpdateOper.trim();
        this.lastUpdateOperColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cf_component.LAST_UPDATE_OPER:Coloured
     *
     * @param lastUpdateOperColoured the value for cf_component.LAST_UPDATE_OPER:Coloured
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    public void setLastUpdateOperColoured(boolean lastUpdateOperColoured) {
        this.lastUpdateOperColoured = lastUpdateOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_component.CREATE_TIME
     *
     * @return the value of cf_component.CREATE_TIME
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_component.CREATE_TIME:Coloured
     *
     * @return the value of cf_component.CREATE_TIME:Coloured
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    public boolean isCreateTimeColoured() {
        return createTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_component.CREATE_TIME:Coloured
     *
     * @return the value of cf_component.CREATE_TIME:Coloured
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    public boolean isCreateTimeNotColoured() {
        return !createTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cf_component.CREATE_TIME
     *
     * @param createTime the value for cf_component.CREATE_TIME
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
        this.createTimeColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cf_component.CREATE_TIME:Coloured
     *
     * @param createTimeColoured the value for cf_component.CREATE_TIME:Coloured
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    public void setCreateTimeColoured(boolean createTimeColoured) {
        this.createTimeColoured = createTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_component.CREATE_OPER
     *
     * @return the value of cf_component.CREATE_OPER
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    public String getCreateOper() {
        return createOper;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_component.CREATE_OPER:Coloured
     *
     * @return the value of cf_component.CREATE_OPER:Coloured
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    public boolean isCreateOperColoured() {
        return createOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_component.CREATE_OPER:Coloured
     *
     * @return the value of cf_component.CREATE_OPER:Coloured
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    public boolean isCreateOperNotColoured() {
        return !createOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cf_component.CREATE_OPER
     *
     * @param createOper the value for cf_component.CREATE_OPER
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    public void setCreateOper(String createOper) {
        this.createOper = createOper == null ? null : createOper.trim();
        this.createOperColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cf_component.CREATE_OPER:Coloured
     *
     * @param createOperColoured the value for cf_component.CREATE_OPER:Coloured
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    public void setCreateOperColoured(boolean createOperColoured) {
        this.createOperColoured = createOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_component
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if(!(that instanceof CfComponent)) {
            return false;
        }
        CfComponent other = (CfComponent) that;
        return (this.getCmptId() == null ? other.getCmptId() == null : this.getCmptId().equals(other.getCmptId()))
            && (this.getCmptCode() == null ? other.getCmptCode() == null : this.getCmptCode().equals(other.getCmptCode()))
            && (this.getCmptName() == null ? other.getCmptName() == null : this.getCmptName().equals(other.getCmptName()))
            && (this.getCmptType() == null ? other.getCmptType() == null : this.getCmptType().equals(other.getCmptType()))
            && (this.getRelAlgorithmId() == null ? other.getRelAlgorithmId() == null : this.getRelAlgorithmId().equals(other.getRelAlgorithmId()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getLastUpdateTime() == null ? other.getLastUpdateTime() == null : this.getLastUpdateTime().equals(other.getLastUpdateTime()))
            && (this.getLastUpdateOper() == null ? other.getLastUpdateOper() == null : this.getLastUpdateOper().equals(other.getLastUpdateOper()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getCreateOper() == null ? other.getCreateOper() == null : this.getCreateOper().equals(other.getCreateOper()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_component
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCmptId() == null) ? 0 : getCmptId().hashCode());
        result = prime * result + ((getCmptCode() == null) ? 0 : getCmptCode().hashCode());
        result = prime * result + ((getCmptName() == null) ? 0 : getCmptName().hashCode());
        result = prime * result + ((getCmptType() == null) ? 0 : getCmptType().hashCode());
        result = prime * result + ((getRelAlgorithmId() == null) ? 0 : getRelAlgorithmId().hashCode());
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
     * This method corresponds to the database table cf_component
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    public void copyProperties(CfComponent that) {
        if (this == that || that == null) {
            return;
        }
        if(that.isCmptIdColoured() ) {this.setCmptId(that.getCmptId() );}
        if(that.isCmptCodeColoured() ) {this.setCmptCode(that.getCmptCode() );}
        if(that.isCmptNameColoured() ) {this.setCmptName(that.getCmptName() );}
        if(that.isCmptTypeColoured() ) {this.setCmptType(that.getCmptType() );}
        if(that.isRelAlgorithmIdColoured() ) {this.setRelAlgorithmId(that.getRelAlgorithmId() );}
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
     * This method corresponds to the database table cf_component
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    @Override
    public JSONObject toJSON() {
        JSONObject jsonObj = new JSONObject(32, true);
        if(this.cmptId != null) {jsonObj.put("cmptId", this.cmptId);}
        if(this.cmptCode != null) {jsonObj.put("cmptCode", this.cmptCode);}
        if(this.cmptName != null) {jsonObj.put("cmptName", this.cmptName);}
        if(this.cmptType != null) {jsonObj.put("cmptType", this.cmptType);}
        if(this.relAlgorithmId != null) {jsonObj.put("relAlgorithmId", this.relAlgorithmId);}
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
     * This method corresponds to the database table cf_component
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    @Override
    public void clear() {
         this.cmptId = null; this.cmptIdColoured = false;
         this.cmptCode = null; this.cmptCodeColoured = false;
         this.cmptName = null; this.cmptNameColoured = false;
         this.cmptType = null; this.cmptTypeColoured = false;
         this.relAlgorithmId = null; this.relAlgorithmIdColoured = false;
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
     * This method corresponds to the database table cf_component
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    @Override
    public void clearColoured() {
        this.cmptIdColoured = false;
        this.cmptCodeColoured = false;
        this.cmptNameColoured = false;
        this.cmptTypeColoured = false;
        this.relAlgorithmIdColoured = false;
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
     * This method corresponds to the database table cf_component
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    @Override
    public boolean isColoured() {
        if(this.cmptIdColoured) return true;
        if(this.cmptCodeColoured) return true;
        if(this.cmptNameColoured) return true;
        if(this.cmptTypeColoured) return true;
        if(this.relAlgorithmIdColoured) return true;
        if(this.descriptionColoured) return true;
        if(this.statusColoured) return true;
        if(this.lastUpdateTimeColoured) return true;
        if(this.lastUpdateOperColoured) return true;
        if(this.createTimeColoured) return true;
        if(this.createOperColoured) return true;
        return false;
    }
}