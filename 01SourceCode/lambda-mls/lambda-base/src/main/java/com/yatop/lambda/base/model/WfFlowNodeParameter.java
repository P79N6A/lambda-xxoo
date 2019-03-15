package com.yatop.lambda.base.model;

import com.alibaba.fastjson.JSONObject;
import com.yatop.lambda.base.utils.LambdaRootModel;
import java.io.Serializable;
import java.util.Date;

public class WfFlowNodeParameter extends LambdaRootModel implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_node_parameter.NODE_ID
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    private Long nodeId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_node_parameter.NODE_ID:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    private boolean nodeIdColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_node_parameter.SPEC_TYPE
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    private Integer specType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_node_parameter.SPEC_TYPE:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    private boolean specTypeColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_node_parameter.CHAR_ID
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    private String charId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_node_parameter.CHAR_ID:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    private boolean charIdColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_node_parameter.CHAR_VALUE
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    private String charValue;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_node_parameter.CHAR_VALUE:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    private boolean charValueColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_node_parameter.WARNING_MSG
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    private String warningMsg;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_node_parameter.WARNING_MSG:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    private boolean warningMsgColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_node_parameter.DESCRIPTION
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    private String description;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_node_parameter.DESCRIPTION:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    private boolean descriptionColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_node_parameter.STATUS
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    private Integer status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_node_parameter.STATUS:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    private boolean statusColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_node_parameter.LAST_UPDATE_TIME
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    private Date lastUpdateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_node_parameter.LAST_UPDATE_TIME:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    private boolean lastUpdateTimeColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_node_parameter.LAST_UPDATE_OPER
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    private String lastUpdateOper;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_node_parameter.LAST_UPDATE_OPER:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    private boolean lastUpdateOperColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_node_parameter.CREATE_TIME
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_node_parameter.CREATE_TIME:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    private boolean createTimeColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_node_parameter.CREATE_OPER
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    private String createOper;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_node_parameter.CREATE_OPER:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    private boolean createOperColoured;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table wf_flow_node_parameter
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_parameter.NODE_ID
     *
     * @return the value of wf_flow_node_parameter.NODE_ID
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
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
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public boolean isNodeIdColoured() {
        return nodeIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_parameter.NODE_ID:Coloured
     *
     * @return the value of wf_flow_node_parameter.NODE_ID:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public boolean isNodeIdNotColoured() {
        return !nodeIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_node_parameter.NODE_ID
     *
     * @param nodeId the value for wf_flow_node_parameter.NODE_ID
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
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
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
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
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
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
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public boolean isSpecTypeColoured() {
        return specTypeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_parameter.SPEC_TYPE:Coloured
     *
     * @return the value of wf_flow_node_parameter.SPEC_TYPE:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public boolean isSpecTypeNotColoured() {
        return !specTypeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_node_parameter.SPEC_TYPE
     *
     * @param specType the value for wf_flow_node_parameter.SPEC_TYPE
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
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
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
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
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public String getCharId() {
        return charId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_parameter.CHAR_ID:Coloured
     *
     * @return the value of wf_flow_node_parameter.CHAR_ID:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public boolean isCharIdColoured() {
        return charIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_parameter.CHAR_ID:Coloured
     *
     * @return the value of wf_flow_node_parameter.CHAR_ID:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public boolean isCharIdNotColoured() {
        return !charIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_node_parameter.CHAR_ID
     *
     * @param charId the value for wf_flow_node_parameter.CHAR_ID
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public void setCharId(String charId) {
        this.charId = charId == null ? null : charId.trim();
        this.charIdColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_node_parameter.CHAR_ID:Coloured
     *
     * @param charIdColoured the value for wf_flow_node_parameter.CHAR_ID:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
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
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
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
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public boolean isCharValueColoured() {
        return charValueColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_parameter.CHAR_VALUE:Coloured
     *
     * @return the value of wf_flow_node_parameter.CHAR_VALUE:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public boolean isCharValueNotColoured() {
        return !charValueColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_node_parameter.CHAR_VALUE
     *
     * @param charValue the value for wf_flow_node_parameter.CHAR_VALUE
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
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
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public void setCharValueColoured(boolean charValueColoured) {
        this.charValueColoured = charValueColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_parameter.WARNING_MSG
     *
     * @return the value of wf_flow_node_parameter.WARNING_MSG
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
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
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public boolean isWarningMsgColoured() {
        return warningMsgColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_parameter.WARNING_MSG:Coloured
     *
     * @return the value of wf_flow_node_parameter.WARNING_MSG:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public boolean isWarningMsgNotColoured() {
        return !warningMsgColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_node_parameter.WARNING_MSG
     *
     * @param warningMsg the value for wf_flow_node_parameter.WARNING_MSG
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
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
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
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
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
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
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public boolean isDescriptionColoured() {
        return descriptionColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_parameter.DESCRIPTION:Coloured
     *
     * @return the value of wf_flow_node_parameter.DESCRIPTION:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public boolean isDescriptionNotColoured() {
        return !descriptionColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_node_parameter.DESCRIPTION
     *
     * @param description the value for wf_flow_node_parameter.DESCRIPTION
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
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
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
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
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
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
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public boolean isStatusColoured() {
        return statusColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_parameter.STATUS:Coloured
     *
     * @return the value of wf_flow_node_parameter.STATUS:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public boolean isStatusNotColoured() {
        return !statusColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_node_parameter.STATUS
     *
     * @param status the value for wf_flow_node_parameter.STATUS
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
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
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
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
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
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
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public boolean isLastUpdateTimeColoured() {
        return lastUpdateTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_parameter.LAST_UPDATE_TIME:Coloured
     *
     * @return the value of wf_flow_node_parameter.LAST_UPDATE_TIME:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public boolean isLastUpdateTimeNotColoured() {
        return !lastUpdateTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_node_parameter.LAST_UPDATE_TIME
     *
     * @param lastUpdateTime the value for wf_flow_node_parameter.LAST_UPDATE_TIME
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
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
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
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
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
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
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public boolean isLastUpdateOperColoured() {
        return lastUpdateOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_parameter.LAST_UPDATE_OPER:Coloured
     *
     * @return the value of wf_flow_node_parameter.LAST_UPDATE_OPER:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public boolean isLastUpdateOperNotColoured() {
        return !lastUpdateOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_node_parameter.LAST_UPDATE_OPER
     *
     * @param lastUpdateOper the value for wf_flow_node_parameter.LAST_UPDATE_OPER
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
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
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
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
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
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
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public boolean isCreateTimeColoured() {
        return createTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_parameter.CREATE_TIME:Coloured
     *
     * @return the value of wf_flow_node_parameter.CREATE_TIME:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public boolean isCreateTimeNotColoured() {
        return !createTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_node_parameter.CREATE_TIME
     *
     * @param createTime the value for wf_flow_node_parameter.CREATE_TIME
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
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
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
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
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
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
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public boolean isCreateOperColoured() {
        return createOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_parameter.CREATE_OPER:Coloured
     *
     * @return the value of wf_flow_node_parameter.CREATE_OPER:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public boolean isCreateOperNotColoured() {
        return !createOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_node_parameter.CREATE_OPER
     *
     * @param createOper the value for wf_flow_node_parameter.CREATE_OPER
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
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
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public void setCreateOperColoured(boolean createOperColoured) {
        this.createOperColoured = createOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_node_parameter
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
        if(!(that instanceof WfFlowNodeParameter)) {
            return false;
        }
        WfFlowNodeParameter other = (WfFlowNodeParameter) that;
        return (this.getNodeId() == null ? other.getNodeId() == null : this.getNodeId().equals(other.getNodeId()))
            && (this.getSpecType() == null ? other.getSpecType() == null : this.getSpecType().equals(other.getSpecType()))
            && (this.getCharId() == null ? other.getCharId() == null : this.getCharId().equals(other.getCharId()))
            && (this.getCharValue() == null ? other.getCharValue() == null : this.getCharValue().equals(other.getCharValue()))
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
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getNodeId() == null) ? 0 : getNodeId().hashCode());
        result = prime * result + ((getSpecType() == null) ? 0 : getSpecType().hashCode());
        result = prime * result + ((getCharId() == null) ? 0 : getCharId().hashCode());
        result = prime * result + ((getCharValue() == null) ? 0 : getCharValue().hashCode());
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
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public void copyProperties(WfFlowNodeParameter that) {
        if (this == that || that == null) {
            return;
        }
        if(that.isNodeIdColoured() ) {this.setNodeId(that.getNodeId() );}
        if(that.isSpecTypeColoured() ) {this.setSpecType(that.getSpecType() );}
        if(that.isCharIdColoured() ) {this.setCharId(that.getCharId() );}
        if(that.isCharValueColoured() ) {this.setCharValue(that.getCharValue() );}
        if(that.isWarningMsgColoured() ) {this.setWarningMsg(that.getWarningMsg() );}
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
     * This method corresponds to the database table wf_flow_node_parameter
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public WfFlowNodeParameter makeCopy() {
        WfFlowNodeParameter copy = new WfFlowNodeParameter();
        if(this.nodeId != null ) {copy.nodeId = this.nodeId;}
        if(this.specType != null ) {copy.specType = this.specType;}
        if(this.charId != null ) {copy.charId = this.charId;}
        if(this.charValue != null ) {copy.charValue = this.charValue;}
        if(this.warningMsg != null ) {copy.warningMsg = this.warningMsg;}
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
     * This method corresponds to the database table wf_flow_node_parameter
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    @Override
    public JSONObject toJSON() {
        JSONObject jsonObj = new JSONObject(32, true);
        if(this.nodeId != null) {jsonObj.put("nodeId", this.nodeId);}
        if(this.specType != null) {jsonObj.put("specType", this.specType);}
        if(this.charId != null) {jsonObj.put("charId", this.charId);}
        if(this.charValue != null) {jsonObj.put("charValue", this.charValue);}
        if(this.warningMsg != null) {jsonObj.put("warningMsg", this.warningMsg);}
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
     * This method corresponds to the database table wf_flow_node_parameter
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    @Override
    public void clear() {
         this.nodeId = null; this.nodeIdColoured = false;
         this.specType = null; this.specTypeColoured = false;
         this.charId = null; this.charIdColoured = false;
         this.charValue = null; this.charValueColoured = false;
         this.warningMsg = null; this.warningMsgColoured = false;
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
     * This method corresponds to the database table wf_flow_node_parameter
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    @Override
    public void clearColoured() {
        this.nodeIdColoured = false;
        this.specTypeColoured = false;
        this.charIdColoured = false;
        this.charValueColoured = false;
        this.warningMsgColoured = false;
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
     * This method corresponds to the database table wf_flow_node_parameter
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    @Override
    public boolean isColoured() {
        if(this.nodeIdColoured) return true;
        if(this.specTypeColoured) return true;
        if(this.charIdColoured) return true;
        if(this.charValueColoured) return true;
        if(this.warningMsgColoured) return true;
        if(this.descriptionColoured) return true;
        if(this.statusColoured) return true;
        if(this.lastUpdateTimeColoured) return true;
        if(this.lastUpdateOperColoured) return true;
        if(this.createTimeColoured) return true;
        if(this.createOperColoured) return true;
        return false;
    }
}