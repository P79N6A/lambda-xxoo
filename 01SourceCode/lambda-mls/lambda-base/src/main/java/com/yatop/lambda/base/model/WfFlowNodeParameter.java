package com.yatop.lambda.base.model;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yatop.lambda.base.utils.LambdaRootModel;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;

public class WfFlowNodeParameter extends LambdaRootModel implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_node_parameter.NODE_ID
     *
     * @mbg.generated Wed Dec 05 11:19:47 CST 2018
     */
    private Long nodeId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_node_parameter.NODE_ID:Coloured
     *
     * @mbg.generated Wed Dec 05 11:19:47 CST 2018
     */
    private boolean nodeIdColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_node_parameter.SPEC_TYPE
     *
     * @mbg.generated Wed Dec 05 11:19:47 CST 2018
     */
    private Integer specType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_node_parameter.SPEC_TYPE:Coloured
     *
     * @mbg.generated Wed Dec 05 11:19:47 CST 2018
     */
    private boolean specTypeColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_node_parameter.CHAR_ID
     *
     * @mbg.generated Wed Dec 05 11:19:47 CST 2018
     */
    private Long charId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_node_parameter.CHAR_ID:Coloured
     *
     * @mbg.generated Wed Dec 05 11:19:47 CST 2018
     */
    private boolean charIdColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_node_parameter.CHAR_VALUE
     *
     * @mbg.generated Wed Dec 05 11:19:47 CST 2018
     */
    private String charValue;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_node_parameter.CHAR_VALUE:Coloured
     *
     * @mbg.generated Wed Dec 05 11:19:47 CST 2018
     */
    private boolean charValueColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_node_parameter.IS_GLOBAL_PARAMETER
     *
     * @mbg.generated Wed Dec 05 11:19:47 CST 2018
     */
    private Integer isGlobalParameter;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_node_parameter.IS_GLOBAL_PARAMETER:Coloured
     *
     * @mbg.generated Wed Dec 05 11:19:47 CST 2018
     */
    private boolean isGlobalParameterColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_node_parameter.IS_DUPLICATED
     *
     * @mbg.generated Wed Dec 05 11:19:47 CST 2018
     */
    private Integer isDuplicated;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_node_parameter.IS_DUPLICATED:Coloured
     *
     * @mbg.generated Wed Dec 05 11:19:47 CST 2018
     */
    private boolean isDuplicatedColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_node_parameter.WARNING_MSG
     *
     * @mbg.generated Wed Dec 05 11:19:47 CST 2018
     */
    private String warningMsg;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_node_parameter.WARNING_MSG:Coloured
     *
     * @mbg.generated Wed Dec 05 11:19:47 CST 2018
     */
    private boolean warningMsgColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_node_parameter.DESCRIPTION
     *
     * @mbg.generated Wed Dec 05 11:19:47 CST 2018
     */
    private String description;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_node_parameter.DESCRIPTION:Coloured
     *
     * @mbg.generated Wed Dec 05 11:19:47 CST 2018
     */
    private boolean descriptionColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_node_parameter.STATUS
     *
     * @mbg.generated Wed Dec 05 11:19:47 CST 2018
     */
    private Integer status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_node_parameter.STATUS:Coloured
     *
     * @mbg.generated Wed Dec 05 11:19:47 CST 2018
     */
    private boolean statusColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_node_parameter.LAST_UPDATE_TIME
     *
     * @mbg.generated Wed Dec 05 11:19:47 CST 2018
     */
    private Date lastUpdateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_node_parameter.LAST_UPDATE_TIME:Coloured
     *
     * @mbg.generated Wed Dec 05 11:19:47 CST 2018
     */
    private boolean lastUpdateTimeColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_node_parameter.LAST_UPDATE_OPER
     *
     * @mbg.generated Wed Dec 05 11:19:47 CST 2018
     */
    private String lastUpdateOper;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_node_parameter.LAST_UPDATE_OPER:Coloured
     *
     * @mbg.generated Wed Dec 05 11:19:47 CST 2018
     */
    private boolean lastUpdateOperColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_node_parameter.CREATE_TIME
     *
     * @mbg.generated Wed Dec 05 11:19:47 CST 2018
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_node_parameter.CREATE_TIME:Coloured
     *
     * @mbg.generated Wed Dec 05 11:19:47 CST 2018
     */
    private boolean createTimeColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_node_parameter.CREATE_OPER
     *
     * @mbg.generated Wed Dec 05 11:19:47 CST 2018
     */
    private String createOper;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_node_parameter.CREATE_OPER:Coloured
     *
     * @mbg.generated Wed Dec 05 11:19:47 CST 2018
     */
    private boolean createOperColoured;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table wf_flow_node_parameter
     *
     * @mbg.generated Wed Dec 05 11:19:47 CST 2018
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_parameter.NODE_ID
     *
     * @return the value of wf_flow_node_parameter.NODE_ID
     *
     * @mbg.generated Wed Dec 05 11:19:47 CST 2018
     */
    public Long getNodeId() {
        return nodeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_parameter.NODE_ID:Coloured
     *
     * @return the value of wf_flow_node_parameter.NODE_ID:Coloured
     *
     * @mbg.generated Wed Dec 05 11:19:47 CST 2018
     */
    public boolean isNodeIdColoured() {
        return nodeIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_node_parameter.NODE_ID
     *
     * @param nodeId the value for wf_flow_node_parameter.NODE_ID
     *
     * @mbg.generated Wed Dec 05 11:19:47 CST 2018
     */
    public void setNodeId(Long nodeId) {
        this.nodeId = nodeId;
        this.nodeIdColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_node_parameter.NODE_ID:Coloured
     *
     * @param nodeIdColoured the value for wf_flow_node_parameter.NODE_ID:Coloured
     *
     * @mbg.generated Wed Dec 05 11:19:47 CST 2018
     */
    public void setNodeIdColoured(boolean nodeIdColoured) {
        this.nodeIdColoured = nodeIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_parameter.SPEC_TYPE
     *
     * @return the value of wf_flow_node_parameter.SPEC_TYPE
     *
     * @mbg.generated Wed Dec 05 11:19:47 CST 2018
     */
    public Integer getSpecType() {
        return specType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_parameter.SPEC_TYPE:Coloured
     *
     * @return the value of wf_flow_node_parameter.SPEC_TYPE:Coloured
     *
     * @mbg.generated Wed Dec 05 11:19:47 CST 2018
     */
    public boolean isSpecTypeColoured() {
        return specTypeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_node_parameter.SPEC_TYPE
     *
     * @param specType the value for wf_flow_node_parameter.SPEC_TYPE
     *
     * @mbg.generated Wed Dec 05 11:19:47 CST 2018
     */
    public void setSpecType(Integer specType) {
        this.specType = specType;
        this.specTypeColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_node_parameter.SPEC_TYPE:Coloured
     *
     * @param specTypeColoured the value for wf_flow_node_parameter.SPEC_TYPE:Coloured
     *
     * @mbg.generated Wed Dec 05 11:19:47 CST 2018
     */
    public void setSpecTypeColoured(boolean specTypeColoured) {
        this.specTypeColoured = specTypeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_parameter.CHAR_ID
     *
     * @return the value of wf_flow_node_parameter.CHAR_ID
     *
     * @mbg.generated Wed Dec 05 11:19:47 CST 2018
     */
    public Long getCharId() {
        return charId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_parameter.CHAR_ID:Coloured
     *
     * @return the value of wf_flow_node_parameter.CHAR_ID:Coloured
     *
     * @mbg.generated Wed Dec 05 11:19:47 CST 2018
     */
    public boolean isCharIdColoured() {
        return charIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_node_parameter.CHAR_ID
     *
     * @param charId the value for wf_flow_node_parameter.CHAR_ID
     *
     * @mbg.generated Wed Dec 05 11:19:47 CST 2018
     */
    public void setCharId(Long charId) {
        this.charId = charId;
        this.charIdColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_node_parameter.CHAR_ID:Coloured
     *
     * @param charIdColoured the value for wf_flow_node_parameter.CHAR_ID:Coloured
     *
     * @mbg.generated Wed Dec 05 11:19:47 CST 2018
     */
    public void setCharIdColoured(boolean charIdColoured) {
        this.charIdColoured = charIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_parameter.CHAR_VALUE
     *
     * @return the value of wf_flow_node_parameter.CHAR_VALUE
     *
     * @mbg.generated Wed Dec 05 11:19:47 CST 2018
     */
    public String getCharValue() {
        return charValue;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_parameter.CHAR_VALUE:Coloured
     *
     * @return the value of wf_flow_node_parameter.CHAR_VALUE:Coloured
     *
     * @mbg.generated Wed Dec 05 11:19:47 CST 2018
     */
    public boolean isCharValueColoured() {
        return charValueColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_node_parameter.CHAR_VALUE
     *
     * @param charValue the value for wf_flow_node_parameter.CHAR_VALUE
     *
     * @mbg.generated Wed Dec 05 11:19:47 CST 2018
     */
    public void setCharValue(String charValue) {
        this.charValue = charValue == null ? null : charValue.trim();
        this.charValueColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_node_parameter.CHAR_VALUE:Coloured
     *
     * @param charValueColoured the value for wf_flow_node_parameter.CHAR_VALUE:Coloured
     *
     * @mbg.generated Wed Dec 05 11:19:47 CST 2018
     */
    public void setCharValueColoured(boolean charValueColoured) {
        this.charValueColoured = charValueColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_parameter.IS_GLOBAL_PARAMETER
     *
     * @return the value of wf_flow_node_parameter.IS_GLOBAL_PARAMETER
     *
     * @mbg.generated Wed Dec 05 11:19:47 CST 2018
     */
    public Integer getIsGlobalParameter() {
        return isGlobalParameter;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_parameter.IS_GLOBAL_PARAMETER:Coloured
     *
     * @return the value of wf_flow_node_parameter.IS_GLOBAL_PARAMETER:Coloured
     *
     * @mbg.generated Wed Dec 05 11:19:47 CST 2018
     */
    public boolean isIsGlobalParameterColoured() {
        return isGlobalParameterColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_node_parameter.IS_GLOBAL_PARAMETER
     *
     * @param isGlobalParameter the value for wf_flow_node_parameter.IS_GLOBAL_PARAMETER
     *
     * @mbg.generated Wed Dec 05 11:19:47 CST 2018
     */
    public void setIsGlobalParameter(Integer isGlobalParameter) {
        this.isGlobalParameter = isGlobalParameter;
        this.isGlobalParameterColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_node_parameter.IS_GLOBAL_PARAMETER:Coloured
     *
     * @param isGlobalParameterColoured the value for wf_flow_node_parameter.IS_GLOBAL_PARAMETER:Coloured
     *
     * @mbg.generated Wed Dec 05 11:19:47 CST 2018
     */
    public void setIsGlobalParameterColoured(boolean isGlobalParameterColoured) {
        this.isGlobalParameterColoured = isGlobalParameterColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_parameter.IS_DUPLICATED
     *
     * @return the value of wf_flow_node_parameter.IS_DUPLICATED
     *
     * @mbg.generated Wed Dec 05 11:19:47 CST 2018
     */
    public Integer getIsDuplicated() {
        return isDuplicated;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_parameter.IS_DUPLICATED:Coloured
     *
     * @return the value of wf_flow_node_parameter.IS_DUPLICATED:Coloured
     *
     * @mbg.generated Wed Dec 05 11:19:47 CST 2018
     */
    public boolean isIsDuplicatedColoured() {
        return isDuplicatedColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_node_parameter.IS_DUPLICATED
     *
     * @param isDuplicated the value for wf_flow_node_parameter.IS_DUPLICATED
     *
     * @mbg.generated Wed Dec 05 11:19:47 CST 2018
     */
    public void setIsDuplicated(Integer isDuplicated) {
        this.isDuplicated = isDuplicated;
        this.isDuplicatedColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_node_parameter.IS_DUPLICATED:Coloured
     *
     * @param isDuplicatedColoured the value for wf_flow_node_parameter.IS_DUPLICATED:Coloured
     *
     * @mbg.generated Wed Dec 05 11:19:47 CST 2018
     */
    public void setIsDuplicatedColoured(boolean isDuplicatedColoured) {
        this.isDuplicatedColoured = isDuplicatedColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_parameter.WARNING_MSG
     *
     * @return the value of wf_flow_node_parameter.WARNING_MSG
     *
     * @mbg.generated Wed Dec 05 11:19:47 CST 2018
     */
    public String getWarningMsg() {
        return warningMsg;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_parameter.WARNING_MSG:Coloured
     *
     * @return the value of wf_flow_node_parameter.WARNING_MSG:Coloured
     *
     * @mbg.generated Wed Dec 05 11:19:47 CST 2018
     */
    public boolean isWarningMsgColoured() {
        return warningMsgColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_node_parameter.WARNING_MSG
     *
     * @param warningMsg the value for wf_flow_node_parameter.WARNING_MSG
     *
     * @mbg.generated Wed Dec 05 11:19:47 CST 2018
     */
    public void setWarningMsg(String warningMsg) {
        this.warningMsg = warningMsg == null ? null : warningMsg.trim();
        this.warningMsgColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_node_parameter.WARNING_MSG:Coloured
     *
     * @param warningMsgColoured the value for wf_flow_node_parameter.WARNING_MSG:Coloured
     *
     * @mbg.generated Wed Dec 05 11:19:47 CST 2018
     */
    public void setWarningMsgColoured(boolean warningMsgColoured) {
        this.warningMsgColoured = warningMsgColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_parameter.DESCRIPTION
     *
     * @return the value of wf_flow_node_parameter.DESCRIPTION
     *
     * @mbg.generated Wed Dec 05 11:19:47 CST 2018
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_parameter.DESCRIPTION:Coloured
     *
     * @return the value of wf_flow_node_parameter.DESCRIPTION:Coloured
     *
     * @mbg.generated Wed Dec 05 11:19:47 CST 2018
     */
    public boolean isDescriptionColoured() {
        return descriptionColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_node_parameter.DESCRIPTION
     *
     * @param description the value for wf_flow_node_parameter.DESCRIPTION
     *
     * @mbg.generated Wed Dec 05 11:19:47 CST 2018
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
        this.descriptionColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_node_parameter.DESCRIPTION:Coloured
     *
     * @param descriptionColoured the value for wf_flow_node_parameter.DESCRIPTION:Coloured
     *
     * @mbg.generated Wed Dec 05 11:19:47 CST 2018
     */
    public void setDescriptionColoured(boolean descriptionColoured) {
        this.descriptionColoured = descriptionColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_parameter.STATUS
     *
     * @return the value of wf_flow_node_parameter.STATUS
     *
     * @mbg.generated Wed Dec 05 11:19:47 CST 2018
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_parameter.STATUS:Coloured
     *
     * @return the value of wf_flow_node_parameter.STATUS:Coloured
     *
     * @mbg.generated Wed Dec 05 11:19:47 CST 2018
     */
    public boolean isStatusColoured() {
        return statusColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_node_parameter.STATUS
     *
     * @param status the value for wf_flow_node_parameter.STATUS
     *
     * @mbg.generated Wed Dec 05 11:19:47 CST 2018
     */
    public void setStatus(Integer status) {
        this.status = status;
        this.statusColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_node_parameter.STATUS:Coloured
     *
     * @param statusColoured the value for wf_flow_node_parameter.STATUS:Coloured
     *
     * @mbg.generated Wed Dec 05 11:19:47 CST 2018
     */
    public void setStatusColoured(boolean statusColoured) {
        this.statusColoured = statusColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_parameter.LAST_UPDATE_TIME
     *
     * @return the value of wf_flow_node_parameter.LAST_UPDATE_TIME
     *
     * @mbg.generated Wed Dec 05 11:19:47 CST 2018
     */
    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_parameter.LAST_UPDATE_TIME:Coloured
     *
     * @return the value of wf_flow_node_parameter.LAST_UPDATE_TIME:Coloured
     *
     * @mbg.generated Wed Dec 05 11:19:47 CST 2018
     */
    public boolean isLastUpdateTimeColoured() {
        return lastUpdateTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_node_parameter.LAST_UPDATE_TIME
     *
     * @param lastUpdateTime the value for wf_flow_node_parameter.LAST_UPDATE_TIME
     *
     * @mbg.generated Wed Dec 05 11:19:47 CST 2018
     */
    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
        this.lastUpdateTimeColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_node_parameter.LAST_UPDATE_TIME:Coloured
     *
     * @param lastUpdateTimeColoured the value for wf_flow_node_parameter.LAST_UPDATE_TIME:Coloured
     *
     * @mbg.generated Wed Dec 05 11:19:47 CST 2018
     */
    public void setLastUpdateTimeColoured(boolean lastUpdateTimeColoured) {
        this.lastUpdateTimeColoured = lastUpdateTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_parameter.LAST_UPDATE_OPER
     *
     * @return the value of wf_flow_node_parameter.LAST_UPDATE_OPER
     *
     * @mbg.generated Wed Dec 05 11:19:47 CST 2018
     */
    public String getLastUpdateOper() {
        return lastUpdateOper;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_parameter.LAST_UPDATE_OPER:Coloured
     *
     * @return the value of wf_flow_node_parameter.LAST_UPDATE_OPER:Coloured
     *
     * @mbg.generated Wed Dec 05 11:19:47 CST 2018
     */
    public boolean isLastUpdateOperColoured() {
        return lastUpdateOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_node_parameter.LAST_UPDATE_OPER
     *
     * @param lastUpdateOper the value for wf_flow_node_parameter.LAST_UPDATE_OPER
     *
     * @mbg.generated Wed Dec 05 11:19:47 CST 2018
     */
    public void setLastUpdateOper(String lastUpdateOper) {
        this.lastUpdateOper = lastUpdateOper == null ? null : lastUpdateOper.trim();
        this.lastUpdateOperColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_node_parameter.LAST_UPDATE_OPER:Coloured
     *
     * @param lastUpdateOperColoured the value for wf_flow_node_parameter.LAST_UPDATE_OPER:Coloured
     *
     * @mbg.generated Wed Dec 05 11:19:47 CST 2018
     */
    public void setLastUpdateOperColoured(boolean lastUpdateOperColoured) {
        this.lastUpdateOperColoured = lastUpdateOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_parameter.CREATE_TIME
     *
     * @return the value of wf_flow_node_parameter.CREATE_TIME
     *
     * @mbg.generated Wed Dec 05 11:19:47 CST 2018
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_parameter.CREATE_TIME:Coloured
     *
     * @return the value of wf_flow_node_parameter.CREATE_TIME:Coloured
     *
     * @mbg.generated Wed Dec 05 11:19:47 CST 2018
     */
    public boolean isCreateTimeColoured() {
        return createTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_node_parameter.CREATE_TIME
     *
     * @param createTime the value for wf_flow_node_parameter.CREATE_TIME
     *
     * @mbg.generated Wed Dec 05 11:19:47 CST 2018
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
        this.createTimeColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_node_parameter.CREATE_TIME:Coloured
     *
     * @param createTimeColoured the value for wf_flow_node_parameter.CREATE_TIME:Coloured
     *
     * @mbg.generated Wed Dec 05 11:19:47 CST 2018
     */
    public void setCreateTimeColoured(boolean createTimeColoured) {
        this.createTimeColoured = createTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_parameter.CREATE_OPER
     *
     * @return the value of wf_flow_node_parameter.CREATE_OPER
     *
     * @mbg.generated Wed Dec 05 11:19:47 CST 2018
     */
    public String getCreateOper() {
        return createOper;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_parameter.CREATE_OPER:Coloured
     *
     * @return the value of wf_flow_node_parameter.CREATE_OPER:Coloured
     *
     * @mbg.generated Wed Dec 05 11:19:47 CST 2018
     */
    public boolean isCreateOperColoured() {
        return createOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_node_parameter.CREATE_OPER
     *
     * @param createOper the value for wf_flow_node_parameter.CREATE_OPER
     *
     * @mbg.generated Wed Dec 05 11:19:47 CST 2018
     */
    public void setCreateOper(String createOper) {
        this.createOper = createOper == null ? null : createOper.trim();
        this.createOperColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_node_parameter.CREATE_OPER:Coloured
     *
     * @param createOperColoured the value for wf_flow_node_parameter.CREATE_OPER:Coloured
     *
     * @mbg.generated Wed Dec 05 11:19:47 CST 2018
     */
    public void setCreateOperColoured(boolean createOperColoured) {
        this.createOperColoured = createOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_node_parameter
     *
     * @mbg.generated Wed Dec 05 11:19:47 CST 2018
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
        WfFlowNodeParameter other = (WfFlowNodeParameter) that;
        return (this.getNodeId() == null ? other.getNodeId() == null : this.getNodeId().equals(other.getNodeId()))
            && (this.getSpecType() == null ? other.getSpecType() == null : this.getSpecType().equals(other.getSpecType()))
            && (this.getCharId() == null ? other.getCharId() == null : this.getCharId().equals(other.getCharId()))
            && (this.getCharValue() == null ? other.getCharValue() == null : this.getCharValue().equals(other.getCharValue()))
            && (this.getIsGlobalParameter() == null ? other.getIsGlobalParameter() == null : this.getIsGlobalParameter().equals(other.getIsGlobalParameter()))
            && (this.getIsDuplicated() == null ? other.getIsDuplicated() == null : this.getIsDuplicated().equals(other.getIsDuplicated()))
            && (this.getWarningMsg() == null ? other.getWarningMsg() == null : this.getWarningMsg().equals(other.getWarningMsg()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getLastUpdateTime() == null ? other.getLastUpdateTime() == null : this.getLastUpdateTime().equals(other.getLastUpdateTime()))
            && (this.getLastUpdateOper() == null ? other.getLastUpdateOper() == null : this.getLastUpdateOper().equals(other.getLastUpdateOper()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getCreateOper() == null ? other.getCreateOper() == null : this.getCreateOper().equals(other.getCreateOper()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_node_parameter
     *
     * @mbg.generated Wed Dec 05 11:19:47 CST 2018
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getNodeId() == null) ? 0 : getNodeId().hashCode());
        result = prime * result + ((getSpecType() == null) ? 0 : getSpecType().hashCode());
        result = prime * result + ((getCharId() == null) ? 0 : getCharId().hashCode());
        result = prime * result + ((getCharValue() == null) ? 0 : getCharValue().hashCode());
        result = prime * result + ((getIsGlobalParameter() == null) ? 0 : getIsGlobalParameter().hashCode());
        result = prime * result + ((getIsDuplicated() == null) ? 0 : getIsDuplicated().hashCode());
        result = prime * result + ((getWarningMsg() == null) ? 0 : getWarningMsg().hashCode());
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
     * This method corresponds to the database table wf_flow_node_parameter
     *
     * @mbg.generated Wed Dec 05 11:19:47 CST 2018
     */
    @Override
    public void copyProperties(Object that) {
        if (this == that || that == null || this.getClass() != that.getClass() ) {
            return;
        }
        WfFlowNodeParameter other = (WfFlowNodeParameter) that;
        if(other.isNodeIdColoured() ) {this.setNodeId(other.getNodeId() );}
        if(other.isSpecTypeColoured() ) {this.setSpecType(other.getSpecType() );}
        if(other.isCharIdColoured() ) {this.setCharId(other.getCharId() );}
        if(other.isCharValueColoured() ) {this.setCharValue(other.getCharValue() );}
        if(other.isIsGlobalParameterColoured() ) {this.setIsGlobalParameter(other.getIsGlobalParameter() );}
        if(other.isIsDuplicatedColoured() ) {this.setIsDuplicated(other.getIsDuplicated() );}
        if(other.isWarningMsgColoured() ) {this.setWarningMsg(other.getWarningMsg() );}
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
     * This method corresponds to the database table wf_flow_node_parameter
     *
     * @mbg.generated Wed Dec 05 11:19:47 CST 2018
     */
    @Override
    public JSONObject toJSON() {
        HashMap<String, Object> hashMap = new HashMap();
        if(this.nodeIdColoured) {hashMap.put("nodeId", this.nodeId);}
        if(this.specTypeColoured) {hashMap.put("specType", this.specType);}
        if(this.charIdColoured) {hashMap.put("charId", this.charId);}
        if(this.charValueColoured) {hashMap.put("charValue", this.charValue);}
        if(this.isGlobalParameterColoured) {hashMap.put("isGlobalParameter", this.isGlobalParameter);}
        if(this.isDuplicatedColoured) {hashMap.put("isDuplicated", this.isDuplicated);}
        if(this.warningMsgColoured) {hashMap.put("warningMsg", this.warningMsg);}
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
     * This method corresponds to the database table wf_flow_node_parameter
     *
     * @mbg.generated Wed Dec 05 11:19:47 CST 2018
     */
    @Override
    public void clear() {
        if(this.nodeIdColoured) {this.nodeId = null; this.nodeIdColoured = false;}
        if(this.specTypeColoured) {this.specType = null; this.specTypeColoured = false;}
        if(this.charIdColoured) {this.charId = null; this.charIdColoured = false;}
        if(this.charValueColoured) {this.charValue = null; this.charValueColoured = false;}
        if(this.isGlobalParameterColoured) {this.isGlobalParameter = null; this.isGlobalParameterColoured = false;}
        if(this.isDuplicatedColoured) {this.isDuplicated = null; this.isDuplicatedColoured = false;}
        if(this.warningMsgColoured) {this.warningMsg = null; this.warningMsgColoured = false;}
        if(this.descriptionColoured) {this.description = null; this.descriptionColoured = false;}
        if(this.statusColoured) {this.status = null; this.statusColoured = false;}
        if(this.lastUpdateTimeColoured) {this.lastUpdateTime = null; this.lastUpdateTimeColoured = false;}
        if(this.lastUpdateOperColoured) {this.lastUpdateOper = null; this.lastUpdateOperColoured = false;}
        if(this.createTimeColoured) {this.createTime = null; this.createTimeColoured = false;}
        if(this.createOperColoured) {this.createOper = null; this.createOperColoured = false;}
        return;
    }
}