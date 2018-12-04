package com.yatop.lambda.base.model;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yatop.lambda.base.utils.LambdaRootModel;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;

public class WfFlowGlobalParameter extends LambdaRootModel implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_global_parameter.GLOBAL_PARAM_ID
     *
     * @mbg.generated Tue Dec 04 13:25:54 CST 2018
     */
    private Long globalParamId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_global_parameter.GLOBAL_PARAM_ID:Coloured
     *
     * @mbg.generated Tue Dec 04 13:25:54 CST 2018
     */
    private boolean globalParamIdColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_global_parameter.GLOBAL_PARAM_NAME
     *
     * @mbg.generated Tue Dec 04 13:25:54 CST 2018
     */
    private String globalParamName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_global_parameter.GLOBAL_PARAM_NAME:Coloured
     *
     * @mbg.generated Tue Dec 04 13:25:54 CST 2018
     */
    private boolean globalParamNameColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_global_parameter.REL_FLOW_ID
     *
     * @mbg.generated Tue Dec 04 13:25:54 CST 2018
     */
    private Long relFlowId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_global_parameter.REL_FLOW_ID:Coloured
     *
     * @mbg.generated Tue Dec 04 13:25:54 CST 2018
     */
    private boolean relFlowIdColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_global_parameter.REL_NODE_ID
     *
     * @mbg.generated Tue Dec 04 13:25:54 CST 2018
     */
    private Long relNodeId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_global_parameter.REL_NODE_ID:Coloured
     *
     * @mbg.generated Tue Dec 04 13:25:54 CST 2018
     */
    private boolean relNodeIdColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_global_parameter.REL_CHAR_ID
     *
     * @mbg.generated Tue Dec 04 13:25:54 CST 2018
     */
    private Long relCharId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_global_parameter.REL_CHAR_ID:Coloured
     *
     * @mbg.generated Tue Dec 04 13:25:54 CST 2018
     */
    private boolean relCharIdColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_global_parameter.DEFAULT_VALUE
     *
     * @mbg.generated Tue Dec 04 13:25:54 CST 2018
     */
    private String defaultValue;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_global_parameter.DEFAULT_VALUE:Coloured
     *
     * @mbg.generated Tue Dec 04 13:25:54 CST 2018
     */
    private boolean defaultValueColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_global_parameter.DESCRIPTION
     *
     * @mbg.generated Tue Dec 04 13:25:54 CST 2018
     */
    private String description;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_global_parameter.DESCRIPTION:Coloured
     *
     * @mbg.generated Tue Dec 04 13:25:54 CST 2018
     */
    private boolean descriptionColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_global_parameter.STATUS
     *
     * @mbg.generated Tue Dec 04 13:25:54 CST 2018
     */
    private Integer status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_global_parameter.STATUS:Coloured
     *
     * @mbg.generated Tue Dec 04 13:25:54 CST 2018
     */
    private boolean statusColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_global_parameter.LAST_UPDATE_TIME
     *
     * @mbg.generated Tue Dec 04 13:25:54 CST 2018
     */
    private Date lastUpdateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_global_parameter.LAST_UPDATE_TIME:Coloured
     *
     * @mbg.generated Tue Dec 04 13:25:54 CST 2018
     */
    private boolean lastUpdateTimeColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_global_parameter.LAST_UPDATE_OPER
     *
     * @mbg.generated Tue Dec 04 13:25:54 CST 2018
     */
    private String lastUpdateOper;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_global_parameter.LAST_UPDATE_OPER:Coloured
     *
     * @mbg.generated Tue Dec 04 13:25:54 CST 2018
     */
    private boolean lastUpdateOperColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_global_parameter.CREATE_TIME
     *
     * @mbg.generated Tue Dec 04 13:25:54 CST 2018
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_global_parameter.CREATE_TIME:Coloured
     *
     * @mbg.generated Tue Dec 04 13:25:54 CST 2018
     */
    private boolean createTimeColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_global_parameter.CREATE_OPER
     *
     * @mbg.generated Tue Dec 04 13:25:54 CST 2018
     */
    private String createOper;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_global_parameter.CREATE_OPER:Coloured
     *
     * @mbg.generated Tue Dec 04 13:25:54 CST 2018
     */
    private boolean createOperColoured;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table wf_flow_global_parameter
     *
     * @mbg.generated Tue Dec 04 13:25:54 CST 2018
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_global_parameter.GLOBAL_PARAM_ID
     *
     * @return the value of wf_flow_global_parameter.GLOBAL_PARAM_ID
     *
     * @mbg.generated Tue Dec 04 13:25:54 CST 2018
     */
    public Long getGlobalParamId() {
        return globalParamId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_global_parameter.GLOBAL_PARAM_ID:Coloured
     *
     * @return the value of wf_flow_global_parameter.GLOBAL_PARAM_ID:Coloured
     *
     * @mbg.generated Tue Dec 04 13:25:54 CST 2018
     */
    public boolean isGlobalParamIdColoured() {
        return globalParamIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_global_parameter.GLOBAL_PARAM_ID
     *
     * @param globalParamId the value for wf_flow_global_parameter.GLOBAL_PARAM_ID
     *
     * @mbg.generated Tue Dec 04 13:25:54 CST 2018
     */
    public void setGlobalParamId(Long globalParamId) {
        this.globalParamId = globalParamId;
        this.globalParamIdColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_global_parameter.GLOBAL_PARAM_ID:Coloured
     *
     * @param globalParamIdColoured the value for wf_flow_global_parameter.GLOBAL_PARAM_ID:Coloured
     *
     * @mbg.generated Tue Dec 04 13:25:54 CST 2018
     */
    public void setGlobalParamIdColoured(boolean globalParamIdColoured) {
        this.globalParamIdColoured = globalParamIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_global_parameter.GLOBAL_PARAM_NAME
     *
     * @return the value of wf_flow_global_parameter.GLOBAL_PARAM_NAME
     *
     * @mbg.generated Tue Dec 04 13:25:54 CST 2018
     */
    public String getGlobalParamName() {
        return globalParamName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_global_parameter.GLOBAL_PARAM_NAME:Coloured
     *
     * @return the value of wf_flow_global_parameter.GLOBAL_PARAM_NAME:Coloured
     *
     * @mbg.generated Tue Dec 04 13:25:54 CST 2018
     */
    public boolean isGlobalParamNameColoured() {
        return globalParamNameColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_global_parameter.GLOBAL_PARAM_NAME
     *
     * @param globalParamName the value for wf_flow_global_parameter.GLOBAL_PARAM_NAME
     *
     * @mbg.generated Tue Dec 04 13:25:54 CST 2018
     */
    public void setGlobalParamName(String globalParamName) {
        this.globalParamName = globalParamName == null ? null : globalParamName.trim();
        this.globalParamNameColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_global_parameter.GLOBAL_PARAM_NAME:Coloured
     *
     * @param globalParamNameColoured the value for wf_flow_global_parameter.GLOBAL_PARAM_NAME:Coloured
     *
     * @mbg.generated Tue Dec 04 13:25:54 CST 2018
     */
    public void setGlobalParamNameColoured(boolean globalParamNameColoured) {
        this.globalParamNameColoured = globalParamNameColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_global_parameter.REL_FLOW_ID
     *
     * @return the value of wf_flow_global_parameter.REL_FLOW_ID
     *
     * @mbg.generated Tue Dec 04 13:25:54 CST 2018
     */
    public Long getRelFlowId() {
        return relFlowId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_global_parameter.REL_FLOW_ID:Coloured
     *
     * @return the value of wf_flow_global_parameter.REL_FLOW_ID:Coloured
     *
     * @mbg.generated Tue Dec 04 13:25:54 CST 2018
     */
    public boolean isRelFlowIdColoured() {
        return relFlowIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_global_parameter.REL_FLOW_ID
     *
     * @param relFlowId the value for wf_flow_global_parameter.REL_FLOW_ID
     *
     * @mbg.generated Tue Dec 04 13:25:54 CST 2018
     */
    public void setRelFlowId(Long relFlowId) {
        this.relFlowId = relFlowId;
        this.relFlowIdColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_global_parameter.REL_FLOW_ID:Coloured
     *
     * @param relFlowIdColoured the value for wf_flow_global_parameter.REL_FLOW_ID:Coloured
     *
     * @mbg.generated Tue Dec 04 13:25:54 CST 2018
     */
    public void setRelFlowIdColoured(boolean relFlowIdColoured) {
        this.relFlowIdColoured = relFlowIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_global_parameter.REL_NODE_ID
     *
     * @return the value of wf_flow_global_parameter.REL_NODE_ID
     *
     * @mbg.generated Tue Dec 04 13:25:54 CST 2018
     */
    public Long getRelNodeId() {
        return relNodeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_global_parameter.REL_NODE_ID:Coloured
     *
     * @return the value of wf_flow_global_parameter.REL_NODE_ID:Coloured
     *
     * @mbg.generated Tue Dec 04 13:25:54 CST 2018
     */
    public boolean isRelNodeIdColoured() {
        return relNodeIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_global_parameter.REL_NODE_ID
     *
     * @param relNodeId the value for wf_flow_global_parameter.REL_NODE_ID
     *
     * @mbg.generated Tue Dec 04 13:25:54 CST 2018
     */
    public void setRelNodeId(Long relNodeId) {
        this.relNodeId = relNodeId;
        this.relNodeIdColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_global_parameter.REL_NODE_ID:Coloured
     *
     * @param relNodeIdColoured the value for wf_flow_global_parameter.REL_NODE_ID:Coloured
     *
     * @mbg.generated Tue Dec 04 13:25:54 CST 2018
     */
    public void setRelNodeIdColoured(boolean relNodeIdColoured) {
        this.relNodeIdColoured = relNodeIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_global_parameter.REL_CHAR_ID
     *
     * @return the value of wf_flow_global_parameter.REL_CHAR_ID
     *
     * @mbg.generated Tue Dec 04 13:25:54 CST 2018
     */
    public Long getRelCharId() {
        return relCharId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_global_parameter.REL_CHAR_ID:Coloured
     *
     * @return the value of wf_flow_global_parameter.REL_CHAR_ID:Coloured
     *
     * @mbg.generated Tue Dec 04 13:25:54 CST 2018
     */
    public boolean isRelCharIdColoured() {
        return relCharIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_global_parameter.REL_CHAR_ID
     *
     * @param relCharId the value for wf_flow_global_parameter.REL_CHAR_ID
     *
     * @mbg.generated Tue Dec 04 13:25:54 CST 2018
     */
    public void setRelCharId(Long relCharId) {
        this.relCharId = relCharId;
        this.relCharIdColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_global_parameter.REL_CHAR_ID:Coloured
     *
     * @param relCharIdColoured the value for wf_flow_global_parameter.REL_CHAR_ID:Coloured
     *
     * @mbg.generated Tue Dec 04 13:25:54 CST 2018
     */
    public void setRelCharIdColoured(boolean relCharIdColoured) {
        this.relCharIdColoured = relCharIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_global_parameter.DEFAULT_VALUE
     *
     * @return the value of wf_flow_global_parameter.DEFAULT_VALUE
     *
     * @mbg.generated Tue Dec 04 13:25:54 CST 2018
     */
    public String getDefaultValue() {
        return defaultValue;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_global_parameter.DEFAULT_VALUE:Coloured
     *
     * @return the value of wf_flow_global_parameter.DEFAULT_VALUE:Coloured
     *
     * @mbg.generated Tue Dec 04 13:25:54 CST 2018
     */
    public boolean isDefaultValueColoured() {
        return defaultValueColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_global_parameter.DEFAULT_VALUE
     *
     * @param defaultValue the value for wf_flow_global_parameter.DEFAULT_VALUE
     *
     * @mbg.generated Tue Dec 04 13:25:54 CST 2018
     */
    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue == null ? null : defaultValue.trim();
        this.defaultValueColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_global_parameter.DEFAULT_VALUE:Coloured
     *
     * @param defaultValueColoured the value for wf_flow_global_parameter.DEFAULT_VALUE:Coloured
     *
     * @mbg.generated Tue Dec 04 13:25:54 CST 2018
     */
    public void setDefaultValueColoured(boolean defaultValueColoured) {
        this.defaultValueColoured = defaultValueColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_global_parameter.DESCRIPTION
     *
     * @return the value of wf_flow_global_parameter.DESCRIPTION
     *
     * @mbg.generated Tue Dec 04 13:25:54 CST 2018
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_global_parameter.DESCRIPTION:Coloured
     *
     * @return the value of wf_flow_global_parameter.DESCRIPTION:Coloured
     *
     * @mbg.generated Tue Dec 04 13:25:54 CST 2018
     */
    public boolean isDescriptionColoured() {
        return descriptionColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_global_parameter.DESCRIPTION
     *
     * @param description the value for wf_flow_global_parameter.DESCRIPTION
     *
     * @mbg.generated Tue Dec 04 13:25:54 CST 2018
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
        this.descriptionColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_global_parameter.DESCRIPTION:Coloured
     *
     * @param descriptionColoured the value for wf_flow_global_parameter.DESCRIPTION:Coloured
     *
     * @mbg.generated Tue Dec 04 13:25:54 CST 2018
     */
    public void setDescriptionColoured(boolean descriptionColoured) {
        this.descriptionColoured = descriptionColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_global_parameter.STATUS
     *
     * @return the value of wf_flow_global_parameter.STATUS
     *
     * @mbg.generated Tue Dec 04 13:25:54 CST 2018
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_global_parameter.STATUS:Coloured
     *
     * @return the value of wf_flow_global_parameter.STATUS:Coloured
     *
     * @mbg.generated Tue Dec 04 13:25:54 CST 2018
     */
    public boolean isStatusColoured() {
        return statusColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_global_parameter.STATUS
     *
     * @param status the value for wf_flow_global_parameter.STATUS
     *
     * @mbg.generated Tue Dec 04 13:25:54 CST 2018
     */
    public void setStatus(Integer status) {
        this.status = status;
        this.statusColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_global_parameter.STATUS:Coloured
     *
     * @param statusColoured the value for wf_flow_global_parameter.STATUS:Coloured
     *
     * @mbg.generated Tue Dec 04 13:25:54 CST 2018
     */
    public void setStatusColoured(boolean statusColoured) {
        this.statusColoured = statusColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_global_parameter.LAST_UPDATE_TIME
     *
     * @return the value of wf_flow_global_parameter.LAST_UPDATE_TIME
     *
     * @mbg.generated Tue Dec 04 13:25:54 CST 2018
     */
    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_global_parameter.LAST_UPDATE_TIME:Coloured
     *
     * @return the value of wf_flow_global_parameter.LAST_UPDATE_TIME:Coloured
     *
     * @mbg.generated Tue Dec 04 13:25:54 CST 2018
     */
    public boolean isLastUpdateTimeColoured() {
        return lastUpdateTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_global_parameter.LAST_UPDATE_TIME
     *
     * @param lastUpdateTime the value for wf_flow_global_parameter.LAST_UPDATE_TIME
     *
     * @mbg.generated Tue Dec 04 13:25:54 CST 2018
     */
    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
        this.lastUpdateTimeColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_global_parameter.LAST_UPDATE_TIME:Coloured
     *
     * @param lastUpdateTimeColoured the value for wf_flow_global_parameter.LAST_UPDATE_TIME:Coloured
     *
     * @mbg.generated Tue Dec 04 13:25:54 CST 2018
     */
    public void setLastUpdateTimeColoured(boolean lastUpdateTimeColoured) {
        this.lastUpdateTimeColoured = lastUpdateTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_global_parameter.LAST_UPDATE_OPER
     *
     * @return the value of wf_flow_global_parameter.LAST_UPDATE_OPER
     *
     * @mbg.generated Tue Dec 04 13:25:54 CST 2018
     */
    public String getLastUpdateOper() {
        return lastUpdateOper;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_global_parameter.LAST_UPDATE_OPER:Coloured
     *
     * @return the value of wf_flow_global_parameter.LAST_UPDATE_OPER:Coloured
     *
     * @mbg.generated Tue Dec 04 13:25:54 CST 2018
     */
    public boolean isLastUpdateOperColoured() {
        return lastUpdateOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_global_parameter.LAST_UPDATE_OPER
     *
     * @param lastUpdateOper the value for wf_flow_global_parameter.LAST_UPDATE_OPER
     *
     * @mbg.generated Tue Dec 04 13:25:54 CST 2018
     */
    public void setLastUpdateOper(String lastUpdateOper) {
        this.lastUpdateOper = lastUpdateOper == null ? null : lastUpdateOper.trim();
        this.lastUpdateOperColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_global_parameter.LAST_UPDATE_OPER:Coloured
     *
     * @param lastUpdateOperColoured the value for wf_flow_global_parameter.LAST_UPDATE_OPER:Coloured
     *
     * @mbg.generated Tue Dec 04 13:25:54 CST 2018
     */
    public void setLastUpdateOperColoured(boolean lastUpdateOperColoured) {
        this.lastUpdateOperColoured = lastUpdateOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_global_parameter.CREATE_TIME
     *
     * @return the value of wf_flow_global_parameter.CREATE_TIME
     *
     * @mbg.generated Tue Dec 04 13:25:54 CST 2018
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_global_parameter.CREATE_TIME:Coloured
     *
     * @return the value of wf_flow_global_parameter.CREATE_TIME:Coloured
     *
     * @mbg.generated Tue Dec 04 13:25:54 CST 2018
     */
    public boolean isCreateTimeColoured() {
        return createTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_global_parameter.CREATE_TIME
     *
     * @param createTime the value for wf_flow_global_parameter.CREATE_TIME
     *
     * @mbg.generated Tue Dec 04 13:25:54 CST 2018
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
        this.createTimeColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_global_parameter.CREATE_TIME:Coloured
     *
     * @param createTimeColoured the value for wf_flow_global_parameter.CREATE_TIME:Coloured
     *
     * @mbg.generated Tue Dec 04 13:25:54 CST 2018
     */
    public void setCreateTimeColoured(boolean createTimeColoured) {
        this.createTimeColoured = createTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_global_parameter.CREATE_OPER
     *
     * @return the value of wf_flow_global_parameter.CREATE_OPER
     *
     * @mbg.generated Tue Dec 04 13:25:54 CST 2018
     */
    public String getCreateOper() {
        return createOper;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_global_parameter.CREATE_OPER:Coloured
     *
     * @return the value of wf_flow_global_parameter.CREATE_OPER:Coloured
     *
     * @mbg.generated Tue Dec 04 13:25:54 CST 2018
     */
    public boolean isCreateOperColoured() {
        return createOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_global_parameter.CREATE_OPER
     *
     * @param createOper the value for wf_flow_global_parameter.CREATE_OPER
     *
     * @mbg.generated Tue Dec 04 13:25:54 CST 2018
     */
    public void setCreateOper(String createOper) {
        this.createOper = createOper == null ? null : createOper.trim();
        this.createOperColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_global_parameter.CREATE_OPER:Coloured
     *
     * @param createOperColoured the value for wf_flow_global_parameter.CREATE_OPER:Coloured
     *
     * @mbg.generated Tue Dec 04 13:25:54 CST 2018
     */
    public void setCreateOperColoured(boolean createOperColoured) {
        this.createOperColoured = createOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_global_parameter
     *
     * @mbg.generated Tue Dec 04 13:25:54 CST 2018
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
        WfFlowGlobalParameter other = (WfFlowGlobalParameter) that;
        return (this.getGlobalParamId() == null ? other.getGlobalParamId() == null : this.getGlobalParamId().equals(other.getGlobalParamId()))
            && (this.getGlobalParamName() == null ? other.getGlobalParamName() == null : this.getGlobalParamName().equals(other.getGlobalParamName()))
            && (this.getRelFlowId() == null ? other.getRelFlowId() == null : this.getRelFlowId().equals(other.getRelFlowId()))
            && (this.getRelNodeId() == null ? other.getRelNodeId() == null : this.getRelNodeId().equals(other.getRelNodeId()))
            && (this.getRelCharId() == null ? other.getRelCharId() == null : this.getRelCharId().equals(other.getRelCharId()))
            && (this.getDefaultValue() == null ? other.getDefaultValue() == null : this.getDefaultValue().equals(other.getDefaultValue()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getLastUpdateTime() == null ? other.getLastUpdateTime() == null : this.getLastUpdateTime().equals(other.getLastUpdateTime()))
            && (this.getLastUpdateOper() == null ? other.getLastUpdateOper() == null : this.getLastUpdateOper().equals(other.getLastUpdateOper()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getCreateOper() == null ? other.getCreateOper() == null : this.getCreateOper().equals(other.getCreateOper()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_global_parameter
     *
     * @mbg.generated Tue Dec 04 13:25:54 CST 2018
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getGlobalParamId() == null) ? 0 : getGlobalParamId().hashCode());
        result = prime * result + ((getGlobalParamName() == null) ? 0 : getGlobalParamName().hashCode());
        result = prime * result + ((getRelFlowId() == null) ? 0 : getRelFlowId().hashCode());
        result = prime * result + ((getRelNodeId() == null) ? 0 : getRelNodeId().hashCode());
        result = prime * result + ((getRelCharId() == null) ? 0 : getRelCharId().hashCode());
        result = prime * result + ((getDefaultValue() == null) ? 0 : getDefaultValue().hashCode());
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
     * This method corresponds to the database table wf_flow_global_parameter
     *
     * @mbg.generated Tue Dec 04 13:25:54 CST 2018
     */
    @Override
    public void copyProperties(Object that) {
        if (this == that || that == null || this.getClass() != that.getClass() ) {
            return;
        }
        WfFlowGlobalParameter other = (WfFlowGlobalParameter) that;
        if(other.isGlobalParamIdColoured() ) {this.setGlobalParamId(other.getGlobalParamId() );}
        if(other.isGlobalParamNameColoured() ) {this.setGlobalParamName(other.getGlobalParamName() );}
        if(other.isRelFlowIdColoured() ) {this.setRelFlowId(other.getRelFlowId() );}
        if(other.isRelNodeIdColoured() ) {this.setRelNodeId(other.getRelNodeId() );}
        if(other.isRelCharIdColoured() ) {this.setRelCharId(other.getRelCharId() );}
        if(other.isDefaultValueColoured() ) {this.setDefaultValue(other.getDefaultValue() );}
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
     * This method corresponds to the database table wf_flow_global_parameter
     *
     * @mbg.generated Tue Dec 04 13:25:54 CST 2018
     */
    @Override
    public JSONObject toJSON() {
        HashMap<String, Object> hashMap = new HashMap();
        if(this.globalParamIdColoured) {hashMap.put("globalParamId", this.globalParamId);}
        if(this.globalParamNameColoured) {hashMap.put("globalParamName", this.globalParamName);}
        if(this.relFlowIdColoured) {hashMap.put("relFlowId", this.relFlowId);}
        if(this.relNodeIdColoured) {hashMap.put("relNodeId", this.relNodeId);}
        if(this.relCharIdColoured) {hashMap.put("relCharId", this.relCharId);}
        if(this.defaultValueColoured) {hashMap.put("defaultValue", this.defaultValue);}
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
     * This method corresponds to the database table wf_flow_global_parameter
     *
     * @mbg.generated Tue Dec 04 13:25:54 CST 2018
     */
    @Override
    public void clear() {
        if(this.globalParamIdColoured) {this.globalParamId = null; this.globalParamIdColoured = false;}
        if(this.globalParamNameColoured) {this.globalParamName = null; this.globalParamNameColoured = false;}
        if(this.relFlowIdColoured) {this.relFlowId = null; this.relFlowIdColoured = false;}
        if(this.relNodeIdColoured) {this.relNodeId = null; this.relNodeIdColoured = false;}
        if(this.relCharIdColoured) {this.relCharId = null; this.relCharIdColoured = false;}
        if(this.defaultValueColoured) {this.defaultValue = null; this.defaultValueColoured = false;}
        if(this.descriptionColoured) {this.description = null; this.descriptionColoured = false;}
        if(this.statusColoured) {this.status = null; this.statusColoured = false;}
        if(this.lastUpdateTimeColoured) {this.lastUpdateTime = null; this.lastUpdateTimeColoured = false;}
        if(this.lastUpdateOperColoured) {this.lastUpdateOper = null; this.lastUpdateOperColoured = false;}
        if(this.createTimeColoured) {this.createTime = null; this.createTimeColoured = false;}
        if(this.createOperColoured) {this.createOper = null; this.createOperColoured = false;}
        return;
    }
}