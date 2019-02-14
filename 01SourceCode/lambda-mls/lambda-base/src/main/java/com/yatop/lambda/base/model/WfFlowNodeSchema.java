package com.yatop.lambda.base.model;

import com.alibaba.fastjson.JSONObject;
import com.yatop.lambda.base.utils.LambdaRootModel;
import java.io.Serializable;
import java.util.Date;

public class WfFlowNodeSchema extends LambdaRootModel implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_node_schema.NODE_PORT_ID
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    private Long nodePortId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_node_schema.NODE_PORT_ID:Coloured
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    private boolean nodePortIdColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_node_schema.SCHEMA_NAME
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    private String schemaName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_node_schema.SCHEMA_NAME:Coloured
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    private boolean schemaNameColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_node_schema.OWNER_NODE_ID
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    private Long ownerNodeId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_node_schema.OWNER_NODE_ID:Coloured
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    private boolean ownerNodeIdColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_node_schema.OBJECT_ID
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    private Long objectId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_node_schema.OBJECT_ID:Coloured
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    private boolean objectIdColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_node_schema.SCHEMA_STATE
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    private Integer schemaState;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_node_schema.SCHEMA_STATE:Coloured
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    private boolean schemaStateColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_node_schema.DESCRIPTION
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    private String description;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_node_schema.DESCRIPTION:Coloured
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    private boolean descriptionColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_node_schema.STATUS
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    private Integer status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_node_schema.STATUS:Coloured
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    private boolean statusColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_node_schema.LAST_UPDATE_TIME
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    private Date lastUpdateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_node_schema.LAST_UPDATE_TIME:Coloured
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    private boolean lastUpdateTimeColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_node_schema.LAST_UPDATE_OPER
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    private String lastUpdateOper;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_node_schema.LAST_UPDATE_OPER:Coloured
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    private boolean lastUpdateOperColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_node_schema.CREATE_TIME
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_node_schema.CREATE_TIME:Coloured
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    private boolean createTimeColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_node_schema.CREATE_OPER
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    private String createOper;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_node_schema.CREATE_OPER:Coloured
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    private boolean createOperColoured;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table wf_flow_node_schema
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_schema.NODE_PORT_ID
     *
     * @return the value of wf_flow_node_schema.NODE_PORT_ID
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    public Long getNodePortId() {
        return nodePortId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_schema.NODE_PORT_ID:Coloured
     *
     * @return the value of wf_flow_node_schema.NODE_PORT_ID:Coloured
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    public boolean isNodePortIdColoured() {
        return nodePortIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_schema.NODE_PORT_ID:Coloured
     *
     * @return the value of wf_flow_node_schema.NODE_PORT_ID:Coloured
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    public boolean isNodePortIdNotColoured() {
        return !nodePortIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_node_schema.NODE_PORT_ID
     *
     * @param nodePortId the value for wf_flow_node_schema.NODE_PORT_ID
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    public void setNodePortId(Long nodePortId) {
        this.nodePortId = nodePortId;
        this.nodePortIdColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_node_schema.NODE_PORT_ID:Coloured
     *
     * @param nodePortIdColoured the value for wf_flow_node_schema.NODE_PORT_ID:Coloured
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    public void setNodePortIdColoured(boolean nodePortIdColoured) {
        this.nodePortIdColoured = nodePortIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_schema.SCHEMA_NAME
     *
     * @return the value of wf_flow_node_schema.SCHEMA_NAME
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    public String getSchemaName() {
        return schemaName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_schema.SCHEMA_NAME:Coloured
     *
     * @return the value of wf_flow_node_schema.SCHEMA_NAME:Coloured
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    public boolean isSchemaNameColoured() {
        return schemaNameColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_schema.SCHEMA_NAME:Coloured
     *
     * @return the value of wf_flow_node_schema.SCHEMA_NAME:Coloured
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    public boolean isSchemaNameNotColoured() {
        return !schemaNameColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_node_schema.SCHEMA_NAME
     *
     * @param schemaName the value for wf_flow_node_schema.SCHEMA_NAME
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    public void setSchemaName(String schemaName) {
        this.schemaName = schemaName == null ? null : schemaName.trim();
        this.schemaNameColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_node_schema.SCHEMA_NAME:Coloured
     *
     * @param schemaNameColoured the value for wf_flow_node_schema.SCHEMA_NAME:Coloured
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    public void setSchemaNameColoured(boolean schemaNameColoured) {
        this.schemaNameColoured = schemaNameColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_schema.OWNER_NODE_ID
     *
     * @return the value of wf_flow_node_schema.OWNER_NODE_ID
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    public Long getOwnerNodeId() {
        return ownerNodeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_schema.OWNER_NODE_ID:Coloured
     *
     * @return the value of wf_flow_node_schema.OWNER_NODE_ID:Coloured
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    public boolean isOwnerNodeIdColoured() {
        return ownerNodeIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_schema.OWNER_NODE_ID:Coloured
     *
     * @return the value of wf_flow_node_schema.OWNER_NODE_ID:Coloured
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    public boolean isOwnerNodeIdNotColoured() {
        return !ownerNodeIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_node_schema.OWNER_NODE_ID
     *
     * @param ownerNodeId the value for wf_flow_node_schema.OWNER_NODE_ID
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    public void setOwnerNodeId(Long ownerNodeId) {
        this.ownerNodeId = ownerNodeId;
        this.ownerNodeIdColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_node_schema.OWNER_NODE_ID:Coloured
     *
     * @param ownerNodeIdColoured the value for wf_flow_node_schema.OWNER_NODE_ID:Coloured
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    public void setOwnerNodeIdColoured(boolean ownerNodeIdColoured) {
        this.ownerNodeIdColoured = ownerNodeIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_schema.OBJECT_ID
     *
     * @return the value of wf_flow_node_schema.OBJECT_ID
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    public Long getObjectId() {
        return objectId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_schema.OBJECT_ID:Coloured
     *
     * @return the value of wf_flow_node_schema.OBJECT_ID:Coloured
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    public boolean isObjectIdColoured() {
        return objectIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_schema.OBJECT_ID:Coloured
     *
     * @return the value of wf_flow_node_schema.OBJECT_ID:Coloured
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    public boolean isObjectIdNotColoured() {
        return !objectIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_node_schema.OBJECT_ID
     *
     * @param objectId the value for wf_flow_node_schema.OBJECT_ID
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    public void setObjectId(Long objectId) {
        this.objectId = objectId;
        this.objectIdColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_node_schema.OBJECT_ID:Coloured
     *
     * @param objectIdColoured the value for wf_flow_node_schema.OBJECT_ID:Coloured
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    public void setObjectIdColoured(boolean objectIdColoured) {
        this.objectIdColoured = objectIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_schema.SCHEMA_STATE
     *
     * @return the value of wf_flow_node_schema.SCHEMA_STATE
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    public Integer getSchemaState() {
        return schemaState;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_schema.SCHEMA_STATE:Coloured
     *
     * @return the value of wf_flow_node_schema.SCHEMA_STATE:Coloured
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    public boolean isSchemaStateColoured() {
        return schemaStateColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_schema.SCHEMA_STATE:Coloured
     *
     * @return the value of wf_flow_node_schema.SCHEMA_STATE:Coloured
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    public boolean isSchemaStateNotColoured() {
        return !schemaStateColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_node_schema.SCHEMA_STATE
     *
     * @param schemaState the value for wf_flow_node_schema.SCHEMA_STATE
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    public void setSchemaState(Integer schemaState) {
        this.schemaState = schemaState;
        this.schemaStateColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_node_schema.SCHEMA_STATE:Coloured
     *
     * @param schemaStateColoured the value for wf_flow_node_schema.SCHEMA_STATE:Coloured
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    public void setSchemaStateColoured(boolean schemaStateColoured) {
        this.schemaStateColoured = schemaStateColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_schema.DESCRIPTION
     *
     * @return the value of wf_flow_node_schema.DESCRIPTION
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_schema.DESCRIPTION:Coloured
     *
     * @return the value of wf_flow_node_schema.DESCRIPTION:Coloured
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    public boolean isDescriptionColoured() {
        return descriptionColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_schema.DESCRIPTION:Coloured
     *
     * @return the value of wf_flow_node_schema.DESCRIPTION:Coloured
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    public boolean isDescriptionNotColoured() {
        return !descriptionColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_node_schema.DESCRIPTION
     *
     * @param description the value for wf_flow_node_schema.DESCRIPTION
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
        this.descriptionColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_node_schema.DESCRIPTION:Coloured
     *
     * @param descriptionColoured the value for wf_flow_node_schema.DESCRIPTION:Coloured
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    public void setDescriptionColoured(boolean descriptionColoured) {
        this.descriptionColoured = descriptionColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_schema.STATUS
     *
     * @return the value of wf_flow_node_schema.STATUS
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_schema.STATUS:Coloured
     *
     * @return the value of wf_flow_node_schema.STATUS:Coloured
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    public boolean isStatusColoured() {
        return statusColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_schema.STATUS:Coloured
     *
     * @return the value of wf_flow_node_schema.STATUS:Coloured
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    public boolean isStatusNotColoured() {
        return !statusColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_node_schema.STATUS
     *
     * @param status the value for wf_flow_node_schema.STATUS
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    public void setStatus(Integer status) {
        this.status = status;
        this.statusColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_node_schema.STATUS:Coloured
     *
     * @param statusColoured the value for wf_flow_node_schema.STATUS:Coloured
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    public void setStatusColoured(boolean statusColoured) {
        this.statusColoured = statusColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_schema.LAST_UPDATE_TIME
     *
     * @return the value of wf_flow_node_schema.LAST_UPDATE_TIME
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_schema.LAST_UPDATE_TIME:Coloured
     *
     * @return the value of wf_flow_node_schema.LAST_UPDATE_TIME:Coloured
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    public boolean isLastUpdateTimeColoured() {
        return lastUpdateTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_schema.LAST_UPDATE_TIME:Coloured
     *
     * @return the value of wf_flow_node_schema.LAST_UPDATE_TIME:Coloured
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    public boolean isLastUpdateTimeNotColoured() {
        return !lastUpdateTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_node_schema.LAST_UPDATE_TIME
     *
     * @param lastUpdateTime the value for wf_flow_node_schema.LAST_UPDATE_TIME
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
        this.lastUpdateTimeColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_node_schema.LAST_UPDATE_TIME:Coloured
     *
     * @param lastUpdateTimeColoured the value for wf_flow_node_schema.LAST_UPDATE_TIME:Coloured
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    public void setLastUpdateTimeColoured(boolean lastUpdateTimeColoured) {
        this.lastUpdateTimeColoured = lastUpdateTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_schema.LAST_UPDATE_OPER
     *
     * @return the value of wf_flow_node_schema.LAST_UPDATE_OPER
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    public String getLastUpdateOper() {
        return lastUpdateOper;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_schema.LAST_UPDATE_OPER:Coloured
     *
     * @return the value of wf_flow_node_schema.LAST_UPDATE_OPER:Coloured
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    public boolean isLastUpdateOperColoured() {
        return lastUpdateOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_schema.LAST_UPDATE_OPER:Coloured
     *
     * @return the value of wf_flow_node_schema.LAST_UPDATE_OPER:Coloured
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    public boolean isLastUpdateOperNotColoured() {
        return !lastUpdateOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_node_schema.LAST_UPDATE_OPER
     *
     * @param lastUpdateOper the value for wf_flow_node_schema.LAST_UPDATE_OPER
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    public void setLastUpdateOper(String lastUpdateOper) {
        this.lastUpdateOper = lastUpdateOper == null ? null : lastUpdateOper.trim();
        this.lastUpdateOperColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_node_schema.LAST_UPDATE_OPER:Coloured
     *
     * @param lastUpdateOperColoured the value for wf_flow_node_schema.LAST_UPDATE_OPER:Coloured
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    public void setLastUpdateOperColoured(boolean lastUpdateOperColoured) {
        this.lastUpdateOperColoured = lastUpdateOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_schema.CREATE_TIME
     *
     * @return the value of wf_flow_node_schema.CREATE_TIME
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_schema.CREATE_TIME:Coloured
     *
     * @return the value of wf_flow_node_schema.CREATE_TIME:Coloured
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    public boolean isCreateTimeColoured() {
        return createTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_schema.CREATE_TIME:Coloured
     *
     * @return the value of wf_flow_node_schema.CREATE_TIME:Coloured
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    public boolean isCreateTimeNotColoured() {
        return !createTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_node_schema.CREATE_TIME
     *
     * @param createTime the value for wf_flow_node_schema.CREATE_TIME
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
        this.createTimeColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_node_schema.CREATE_TIME:Coloured
     *
     * @param createTimeColoured the value for wf_flow_node_schema.CREATE_TIME:Coloured
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    public void setCreateTimeColoured(boolean createTimeColoured) {
        this.createTimeColoured = createTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_schema.CREATE_OPER
     *
     * @return the value of wf_flow_node_schema.CREATE_OPER
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    public String getCreateOper() {
        return createOper;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_schema.CREATE_OPER:Coloured
     *
     * @return the value of wf_flow_node_schema.CREATE_OPER:Coloured
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    public boolean isCreateOperColoured() {
        return createOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_schema.CREATE_OPER:Coloured
     *
     * @return the value of wf_flow_node_schema.CREATE_OPER:Coloured
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    public boolean isCreateOperNotColoured() {
        return !createOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_node_schema.CREATE_OPER
     *
     * @param createOper the value for wf_flow_node_schema.CREATE_OPER
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    public void setCreateOper(String createOper) {
        this.createOper = createOper == null ? null : createOper.trim();
        this.createOperColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_node_schema.CREATE_OPER:Coloured
     *
     * @param createOperColoured the value for wf_flow_node_schema.CREATE_OPER:Coloured
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    public void setCreateOperColoured(boolean createOperColoured) {
        this.createOperColoured = createOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_node_schema
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
        if(!(that instanceof WfFlowNodeSchema)) {
            return false;
        }
        WfFlowNodeSchema other = (WfFlowNodeSchema) that;
        return (this.getNodePortId() == null ? other.getNodePortId() == null : this.getNodePortId().equals(other.getNodePortId()))
            && (this.getSchemaName() == null ? other.getSchemaName() == null : this.getSchemaName().equals(other.getSchemaName()))
            && (this.getOwnerNodeId() == null ? other.getOwnerNodeId() == null : this.getOwnerNodeId().equals(other.getOwnerNodeId()))
            && (this.getObjectId() == null ? other.getObjectId() == null : this.getObjectId().equals(other.getObjectId()))
            && (this.getSchemaState() == null ? other.getSchemaState() == null : this.getSchemaState().equals(other.getSchemaState()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getLastUpdateTime() == null ? other.getLastUpdateTime() == null : this.getLastUpdateTime().equals(other.getLastUpdateTime()))
            && (this.getLastUpdateOper() == null ? other.getLastUpdateOper() == null : this.getLastUpdateOper().equals(other.getLastUpdateOper()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getCreateOper() == null ? other.getCreateOper() == null : this.getCreateOper().equals(other.getCreateOper()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_node_schema
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getNodePortId() == null) ? 0 : getNodePortId().hashCode());
        result = prime * result + ((getSchemaName() == null) ? 0 : getSchemaName().hashCode());
        result = prime * result + ((getOwnerNodeId() == null) ? 0 : getOwnerNodeId().hashCode());
        result = prime * result + ((getObjectId() == null) ? 0 : getObjectId().hashCode());
        result = prime * result + ((getSchemaState() == null) ? 0 : getSchemaState().hashCode());
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
     * This method corresponds to the database table wf_flow_node_schema
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    public void copyProperties(WfFlowNodeSchema that) {
        if (this == that || that == null) {
            return;
        }
        if(that.isNodePortIdColoured() ) {this.setNodePortId(that.getNodePortId() );}
        if(that.isSchemaNameColoured() ) {this.setSchemaName(that.getSchemaName() );}
        if(that.isOwnerNodeIdColoured() ) {this.setOwnerNodeId(that.getOwnerNodeId() );}
        if(that.isObjectIdColoured() ) {this.setObjectId(that.getObjectId() );}
        if(that.isSchemaStateColoured() ) {this.setSchemaState(that.getSchemaState() );}
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
     * This method corresponds to the database table wf_flow_node_schema
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    @Override
    public JSONObject toJSON() {
        JSONObject jsonObj = new JSONObject(32, true);
        if(this.nodePortId != null) {jsonObj.put("nodePortId", this.nodePortId);}
        if(this.schemaName != null) {jsonObj.put("schemaName", this.schemaName);}
        if(this.ownerNodeId != null) {jsonObj.put("ownerNodeId", this.ownerNodeId);}
        if(this.objectId != null) {jsonObj.put("objectId", this.objectId);}
        if(this.schemaState != null) {jsonObj.put("schemaState", this.schemaState);}
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
     * This method corresponds to the database table wf_flow_node_schema
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    @Override
    public void clear() {
         this.nodePortId = null; this.nodePortIdColoured = false;
         this.schemaName = null; this.schemaNameColoured = false;
         this.ownerNodeId = null; this.ownerNodeIdColoured = false;
         this.objectId = null; this.objectIdColoured = false;
         this.schemaState = null; this.schemaStateColoured = false;
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
     * This method corresponds to the database table wf_flow_node_schema
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    @Override
    public void clearColoured() {
        this.nodePortIdColoured = false;
        this.schemaNameColoured = false;
        this.ownerNodeIdColoured = false;
        this.objectIdColoured = false;
        this.schemaStateColoured = false;
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
     * This method corresponds to the database table wf_flow_node_schema
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    @Override
    public boolean isColoured() {
        if(this.nodePortIdColoured) return true;
        if(this.schemaNameColoured) return true;
        if(this.ownerNodeIdColoured) return true;
        if(this.objectIdColoured) return true;
        if(this.schemaStateColoured) return true;
        if(this.descriptionColoured) return true;
        if(this.statusColoured) return true;
        if(this.lastUpdateTimeColoured) return true;
        if(this.lastUpdateOperColoured) return true;
        if(this.createTimeColoured) return true;
        if(this.createOperColoured) return true;
        return false;
    }
}