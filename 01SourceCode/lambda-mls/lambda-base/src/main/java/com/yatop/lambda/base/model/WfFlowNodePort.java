package com.yatop.lambda.base.model;

import com.alibaba.fastjson.JSONObject;
import com.yatop.lambda.base.utils.LambdaRootModel;
import java.io.Serializable;
import java.util.Date;

public class WfFlowNodePort extends LambdaRootModel implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_node_port.NODE_PORT_ID
     *
     * @mbg.generated Sun Dec 23 19:14:01 CST 2018
     */
    private Long nodePortId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_node_port.NODE_PORT_ID:Coloured
     *
     * @mbg.generated Sun Dec 23 19:14:01 CST 2018
     */
    private boolean nodePortIdColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_node_port.NODE_PORT_NAME
     *
     * @mbg.generated Sun Dec 23 19:14:01 CST 2018
     */
    private String nodePortName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_node_port.NODE_PORT_NAME:Coloured
     *
     * @mbg.generated Sun Dec 23 19:14:01 CST 2018
     */
    private boolean nodePortNameColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_node_port.OWNER_NODE_ID
     *
     * @mbg.generated Sun Dec 23 19:14:01 CST 2018
     */
    private Long ownerNodeId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_node_port.OWNER_NODE_ID:Coloured
     *
     * @mbg.generated Sun Dec 23 19:14:01 CST 2018
     */
    private boolean ownerNodeIdColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_node_port.REF_PORT_ID
     *
     * @mbg.generated Sun Dec 23 19:14:01 CST 2018
     */
    private Long refPortId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_node_port.REF_PORT_ID:Coloured
     *
     * @mbg.generated Sun Dec 23 19:14:01 CST 2018
     */
    private boolean refPortIdColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_node_port.REF_CHAR_ID
     *
     * @mbg.generated Sun Dec 23 19:14:01 CST 2018
     */
    private String refCharId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_node_port.REF_CHAR_ID:Coloured
     *
     * @mbg.generated Sun Dec 23 19:14:01 CST 2018
     */
    private boolean refCharIdColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_node_port.DESCRIPTION
     *
     * @mbg.generated Sun Dec 23 19:14:01 CST 2018
     */
    private String description;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_node_port.DESCRIPTION:Coloured
     *
     * @mbg.generated Sun Dec 23 19:14:01 CST 2018
     */
    private boolean descriptionColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_node_port.STATUS
     *
     * @mbg.generated Sun Dec 23 19:14:01 CST 2018
     */
    private Integer status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_node_port.STATUS:Coloured
     *
     * @mbg.generated Sun Dec 23 19:14:01 CST 2018
     */
    private boolean statusColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_node_port.LAST_UPDATE_TIME
     *
     * @mbg.generated Sun Dec 23 19:14:01 CST 2018
     */
    private Date lastUpdateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_node_port.LAST_UPDATE_TIME:Coloured
     *
     * @mbg.generated Sun Dec 23 19:14:01 CST 2018
     */
    private boolean lastUpdateTimeColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_node_port.LAST_UPDATE_OPER
     *
     * @mbg.generated Sun Dec 23 19:14:01 CST 2018
     */
    private String lastUpdateOper;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_node_port.LAST_UPDATE_OPER:Coloured
     *
     * @mbg.generated Sun Dec 23 19:14:01 CST 2018
     */
    private boolean lastUpdateOperColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_node_port.CREATE_TIME
     *
     * @mbg.generated Sun Dec 23 19:14:01 CST 2018
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_node_port.CREATE_TIME:Coloured
     *
     * @mbg.generated Sun Dec 23 19:14:01 CST 2018
     */
    private boolean createTimeColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_node_port.CREATE_OPER
     *
     * @mbg.generated Sun Dec 23 19:14:01 CST 2018
     */
    private String createOper;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_node_port.CREATE_OPER:Coloured
     *
     * @mbg.generated Sun Dec 23 19:14:01 CST 2018
     */
    private boolean createOperColoured;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table wf_flow_node_port
     *
     * @mbg.generated Sun Dec 23 19:14:01 CST 2018
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_port.NODE_PORT_ID
     *
     * @return the value of wf_flow_node_port.NODE_PORT_ID
     *
     * @mbg.generated Sun Dec 23 19:14:01 CST 2018
     */
    public Long getNodePortId() {
        return nodePortId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_port.NODE_PORT_ID:Coloured
     *
     * @return the value of wf_flow_node_port.NODE_PORT_ID:Coloured
     *
     * @mbg.generated Sun Dec 23 19:14:01 CST 2018
     */
    public boolean isNodePortIdColoured() {
        return nodePortIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_port.NODE_PORT_ID:Coloured
     *
     * @return the value of wf_flow_node_port.NODE_PORT_ID:Coloured
     *
     * @mbg.generated Sun Dec 23 19:14:01 CST 2018
     */
    public boolean isNodePortIdNotColoured() {
        return !nodePortIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_node_port.NODE_PORT_ID
     *
     * @param nodePortId the value for wf_flow_node_port.NODE_PORT_ID
     *
     * @mbg.generated Sun Dec 23 19:14:01 CST 2018
     */
    public void setNodePortId(Long nodePortId) {
        this.nodePortId = nodePortId;
        this.nodePortIdColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_node_port.NODE_PORT_ID:Coloured
     *
     * @param nodePortIdColoured the value for wf_flow_node_port.NODE_PORT_ID:Coloured
     *
     * @mbg.generated Sun Dec 23 19:14:01 CST 2018
     */
    public void setNodePortIdColoured(boolean nodePortIdColoured) {
        this.nodePortIdColoured = nodePortIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_port.NODE_PORT_NAME
     *
     * @return the value of wf_flow_node_port.NODE_PORT_NAME
     *
     * @mbg.generated Sun Dec 23 19:14:01 CST 2018
     */
    public String getNodePortName() {
        return nodePortName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_port.NODE_PORT_NAME:Coloured
     *
     * @return the value of wf_flow_node_port.NODE_PORT_NAME:Coloured
     *
     * @mbg.generated Sun Dec 23 19:14:01 CST 2018
     */
    public boolean isNodePortNameColoured() {
        return nodePortNameColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_port.NODE_PORT_NAME:Coloured
     *
     * @return the value of wf_flow_node_port.NODE_PORT_NAME:Coloured
     *
     * @mbg.generated Sun Dec 23 19:14:01 CST 2018
     */
    public boolean isNodePortNameNotColoured() {
        return !nodePortNameColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_node_port.NODE_PORT_NAME
     *
     * @param nodePortName the value for wf_flow_node_port.NODE_PORT_NAME
     *
     * @mbg.generated Sun Dec 23 19:14:01 CST 2018
     */
    public void setNodePortName(String nodePortName) {
        this.nodePortName = nodePortName == null ? null : nodePortName.trim();
        this.nodePortNameColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_node_port.NODE_PORT_NAME:Coloured
     *
     * @param nodePortNameColoured the value for wf_flow_node_port.NODE_PORT_NAME:Coloured
     *
     * @mbg.generated Sun Dec 23 19:14:01 CST 2018
     */
    public void setNodePortNameColoured(boolean nodePortNameColoured) {
        this.nodePortNameColoured = nodePortNameColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_port.OWNER_NODE_ID
     *
     * @return the value of wf_flow_node_port.OWNER_NODE_ID
     *
     * @mbg.generated Sun Dec 23 19:14:01 CST 2018
     */
    public Long getOwnerNodeId() {
        return ownerNodeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_port.OWNER_NODE_ID:Coloured
     *
     * @return the value of wf_flow_node_port.OWNER_NODE_ID:Coloured
     *
     * @mbg.generated Sun Dec 23 19:14:01 CST 2018
     */
    public boolean isOwnerNodeIdColoured() {
        return ownerNodeIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_port.OWNER_NODE_ID:Coloured
     *
     * @return the value of wf_flow_node_port.OWNER_NODE_ID:Coloured
     *
     * @mbg.generated Sun Dec 23 19:14:01 CST 2018
     */
    public boolean isOwnerNodeIdNotColoured() {
        return !ownerNodeIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_node_port.OWNER_NODE_ID
     *
     * @param ownerNodeId the value for wf_flow_node_port.OWNER_NODE_ID
     *
     * @mbg.generated Sun Dec 23 19:14:01 CST 2018
     */
    public void setOwnerNodeId(Long ownerNodeId) {
        this.ownerNodeId = ownerNodeId;
        this.ownerNodeIdColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_node_port.OWNER_NODE_ID:Coloured
     *
     * @param ownerNodeIdColoured the value for wf_flow_node_port.OWNER_NODE_ID:Coloured
     *
     * @mbg.generated Sun Dec 23 19:14:01 CST 2018
     */
    public void setOwnerNodeIdColoured(boolean ownerNodeIdColoured) {
        this.ownerNodeIdColoured = ownerNodeIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_port.REF_PORT_ID
     *
     * @return the value of wf_flow_node_port.REF_PORT_ID
     *
     * @mbg.generated Sun Dec 23 19:14:01 CST 2018
     */
    public Long getRefPortId() {
        return refPortId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_port.REF_PORT_ID:Coloured
     *
     * @return the value of wf_flow_node_port.REF_PORT_ID:Coloured
     *
     * @mbg.generated Sun Dec 23 19:14:01 CST 2018
     */
    public boolean isRefPortIdColoured() {
        return refPortIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_port.REF_PORT_ID:Coloured
     *
     * @return the value of wf_flow_node_port.REF_PORT_ID:Coloured
     *
     * @mbg.generated Sun Dec 23 19:14:01 CST 2018
     */
    public boolean isRefPortIdNotColoured() {
        return !refPortIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_node_port.REF_PORT_ID
     *
     * @param refPortId the value for wf_flow_node_port.REF_PORT_ID
     *
     * @mbg.generated Sun Dec 23 19:14:01 CST 2018
     */
    public void setRefPortId(Long refPortId) {
        this.refPortId = refPortId;
        this.refPortIdColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_node_port.REF_PORT_ID:Coloured
     *
     * @param refPortIdColoured the value for wf_flow_node_port.REF_PORT_ID:Coloured
     *
     * @mbg.generated Sun Dec 23 19:14:01 CST 2018
     */
    public void setRefPortIdColoured(boolean refPortIdColoured) {
        this.refPortIdColoured = refPortIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_port.REF_CHAR_ID
     *
     * @return the value of wf_flow_node_port.REF_CHAR_ID
     *
     * @mbg.generated Sun Dec 23 19:14:01 CST 2018
     */
    public String getRefCharId() {
        return refCharId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_port.REF_CHAR_ID:Coloured
     *
     * @return the value of wf_flow_node_port.REF_CHAR_ID:Coloured
     *
     * @mbg.generated Sun Dec 23 19:14:01 CST 2018
     */
    public boolean isRefCharIdColoured() {
        return refCharIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_port.REF_CHAR_ID:Coloured
     *
     * @return the value of wf_flow_node_port.REF_CHAR_ID:Coloured
     *
     * @mbg.generated Sun Dec 23 19:14:01 CST 2018
     */
    public boolean isRefCharIdNotColoured() {
        return !refCharIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_node_port.REF_CHAR_ID
     *
     * @param refCharId the value for wf_flow_node_port.REF_CHAR_ID
     *
     * @mbg.generated Sun Dec 23 19:14:01 CST 2018
     */
    public void setRefCharId(String refCharId) {
        this.refCharId = refCharId == null ? null : refCharId.trim();
        this.refCharIdColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_node_port.REF_CHAR_ID:Coloured
     *
     * @param refCharIdColoured the value for wf_flow_node_port.REF_CHAR_ID:Coloured
     *
     * @mbg.generated Sun Dec 23 19:14:01 CST 2018
     */
    public void setRefCharIdColoured(boolean refCharIdColoured) {
        this.refCharIdColoured = refCharIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_port.DESCRIPTION
     *
     * @return the value of wf_flow_node_port.DESCRIPTION
     *
     * @mbg.generated Sun Dec 23 19:14:01 CST 2018
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_port.DESCRIPTION:Coloured
     *
     * @return the value of wf_flow_node_port.DESCRIPTION:Coloured
     *
     * @mbg.generated Sun Dec 23 19:14:01 CST 2018
     */
    public boolean isDescriptionColoured() {
        return descriptionColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_port.DESCRIPTION:Coloured
     *
     * @return the value of wf_flow_node_port.DESCRIPTION:Coloured
     *
     * @mbg.generated Sun Dec 23 19:14:01 CST 2018
     */
    public boolean isDescriptionNotColoured() {
        return !descriptionColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_node_port.DESCRIPTION
     *
     * @param description the value for wf_flow_node_port.DESCRIPTION
     *
     * @mbg.generated Sun Dec 23 19:14:01 CST 2018
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
        this.descriptionColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_node_port.DESCRIPTION:Coloured
     *
     * @param descriptionColoured the value for wf_flow_node_port.DESCRIPTION:Coloured
     *
     * @mbg.generated Sun Dec 23 19:14:01 CST 2018
     */
    public void setDescriptionColoured(boolean descriptionColoured) {
        this.descriptionColoured = descriptionColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_port.STATUS
     *
     * @return the value of wf_flow_node_port.STATUS
     *
     * @mbg.generated Sun Dec 23 19:14:01 CST 2018
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_port.STATUS:Coloured
     *
     * @return the value of wf_flow_node_port.STATUS:Coloured
     *
     * @mbg.generated Sun Dec 23 19:14:01 CST 2018
     */
    public boolean isStatusColoured() {
        return statusColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_port.STATUS:Coloured
     *
     * @return the value of wf_flow_node_port.STATUS:Coloured
     *
     * @mbg.generated Sun Dec 23 19:14:01 CST 2018
     */
    public boolean isStatusNotColoured() {
        return !statusColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_node_port.STATUS
     *
     * @param status the value for wf_flow_node_port.STATUS
     *
     * @mbg.generated Sun Dec 23 19:14:01 CST 2018
     */
    public void setStatus(Integer status) {
        this.status = status;
        this.statusColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_node_port.STATUS:Coloured
     *
     * @param statusColoured the value for wf_flow_node_port.STATUS:Coloured
     *
     * @mbg.generated Sun Dec 23 19:14:01 CST 2018
     */
    public void setStatusColoured(boolean statusColoured) {
        this.statusColoured = statusColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_port.LAST_UPDATE_TIME
     *
     * @return the value of wf_flow_node_port.LAST_UPDATE_TIME
     *
     * @mbg.generated Sun Dec 23 19:14:01 CST 2018
     */
    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_port.LAST_UPDATE_TIME:Coloured
     *
     * @return the value of wf_flow_node_port.LAST_UPDATE_TIME:Coloured
     *
     * @mbg.generated Sun Dec 23 19:14:01 CST 2018
     */
    public boolean isLastUpdateTimeColoured() {
        return lastUpdateTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_port.LAST_UPDATE_TIME:Coloured
     *
     * @return the value of wf_flow_node_port.LAST_UPDATE_TIME:Coloured
     *
     * @mbg.generated Sun Dec 23 19:14:01 CST 2018
     */
    public boolean isLastUpdateTimeNotColoured() {
        return !lastUpdateTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_node_port.LAST_UPDATE_TIME
     *
     * @param lastUpdateTime the value for wf_flow_node_port.LAST_UPDATE_TIME
     *
     * @mbg.generated Sun Dec 23 19:14:01 CST 2018
     */
    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
        this.lastUpdateTimeColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_node_port.LAST_UPDATE_TIME:Coloured
     *
     * @param lastUpdateTimeColoured the value for wf_flow_node_port.LAST_UPDATE_TIME:Coloured
     *
     * @mbg.generated Sun Dec 23 19:14:01 CST 2018
     */
    public void setLastUpdateTimeColoured(boolean lastUpdateTimeColoured) {
        this.lastUpdateTimeColoured = lastUpdateTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_port.LAST_UPDATE_OPER
     *
     * @return the value of wf_flow_node_port.LAST_UPDATE_OPER
     *
     * @mbg.generated Sun Dec 23 19:14:01 CST 2018
     */
    public String getLastUpdateOper() {
        return lastUpdateOper;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_port.LAST_UPDATE_OPER:Coloured
     *
     * @return the value of wf_flow_node_port.LAST_UPDATE_OPER:Coloured
     *
     * @mbg.generated Sun Dec 23 19:14:01 CST 2018
     */
    public boolean isLastUpdateOperColoured() {
        return lastUpdateOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_port.LAST_UPDATE_OPER:Coloured
     *
     * @return the value of wf_flow_node_port.LAST_UPDATE_OPER:Coloured
     *
     * @mbg.generated Sun Dec 23 19:14:01 CST 2018
     */
    public boolean isLastUpdateOperNotColoured() {
        return !lastUpdateOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_node_port.LAST_UPDATE_OPER
     *
     * @param lastUpdateOper the value for wf_flow_node_port.LAST_UPDATE_OPER
     *
     * @mbg.generated Sun Dec 23 19:14:01 CST 2018
     */
    public void setLastUpdateOper(String lastUpdateOper) {
        this.lastUpdateOper = lastUpdateOper == null ? null : lastUpdateOper.trim();
        this.lastUpdateOperColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_node_port.LAST_UPDATE_OPER:Coloured
     *
     * @param lastUpdateOperColoured the value for wf_flow_node_port.LAST_UPDATE_OPER:Coloured
     *
     * @mbg.generated Sun Dec 23 19:14:01 CST 2018
     */
    public void setLastUpdateOperColoured(boolean lastUpdateOperColoured) {
        this.lastUpdateOperColoured = lastUpdateOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_port.CREATE_TIME
     *
     * @return the value of wf_flow_node_port.CREATE_TIME
     *
     * @mbg.generated Sun Dec 23 19:14:01 CST 2018
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_port.CREATE_TIME:Coloured
     *
     * @return the value of wf_flow_node_port.CREATE_TIME:Coloured
     *
     * @mbg.generated Sun Dec 23 19:14:01 CST 2018
     */
    public boolean isCreateTimeColoured() {
        return createTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_port.CREATE_TIME:Coloured
     *
     * @return the value of wf_flow_node_port.CREATE_TIME:Coloured
     *
     * @mbg.generated Sun Dec 23 19:14:01 CST 2018
     */
    public boolean isCreateTimeNotColoured() {
        return !createTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_node_port.CREATE_TIME
     *
     * @param createTime the value for wf_flow_node_port.CREATE_TIME
     *
     * @mbg.generated Sun Dec 23 19:14:01 CST 2018
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
        this.createTimeColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_node_port.CREATE_TIME:Coloured
     *
     * @param createTimeColoured the value for wf_flow_node_port.CREATE_TIME:Coloured
     *
     * @mbg.generated Sun Dec 23 19:14:01 CST 2018
     */
    public void setCreateTimeColoured(boolean createTimeColoured) {
        this.createTimeColoured = createTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_port.CREATE_OPER
     *
     * @return the value of wf_flow_node_port.CREATE_OPER
     *
     * @mbg.generated Sun Dec 23 19:14:01 CST 2018
     */
    public String getCreateOper() {
        return createOper;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_port.CREATE_OPER:Coloured
     *
     * @return the value of wf_flow_node_port.CREATE_OPER:Coloured
     *
     * @mbg.generated Sun Dec 23 19:14:01 CST 2018
     */
    public boolean isCreateOperColoured() {
        return createOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_port.CREATE_OPER:Coloured
     *
     * @return the value of wf_flow_node_port.CREATE_OPER:Coloured
     *
     * @mbg.generated Sun Dec 23 19:14:01 CST 2018
     */
    public boolean isCreateOperNotColoured() {
        return !createOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_node_port.CREATE_OPER
     *
     * @param createOper the value for wf_flow_node_port.CREATE_OPER
     *
     * @mbg.generated Sun Dec 23 19:14:01 CST 2018
     */
    public void setCreateOper(String createOper) {
        this.createOper = createOper == null ? null : createOper.trim();
        this.createOperColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_node_port.CREATE_OPER:Coloured
     *
     * @param createOperColoured the value for wf_flow_node_port.CREATE_OPER:Coloured
     *
     * @mbg.generated Sun Dec 23 19:14:01 CST 2018
     */
    public void setCreateOperColoured(boolean createOperColoured) {
        this.createOperColoured = createOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_node_port
     *
     * @mbg.generated Sun Dec 23 19:14:01 CST 2018
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
        WfFlowNodePort other = (WfFlowNodePort) that;
        return (this.getNodePortId() == null ? other.getNodePortId() == null : this.getNodePortId().equals(other.getNodePortId()))
            && (this.getNodePortName() == null ? other.getNodePortName() == null : this.getNodePortName().equals(other.getNodePortName()))
            && (this.getOwnerNodeId() == null ? other.getOwnerNodeId() == null : this.getOwnerNodeId().equals(other.getOwnerNodeId()))
            && (this.getRefPortId() == null ? other.getRefPortId() == null : this.getRefPortId().equals(other.getRefPortId()))
            && (this.getRefCharId() == null ? other.getRefCharId() == null : this.getRefCharId().equals(other.getRefCharId()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getLastUpdateTime() == null ? other.getLastUpdateTime() == null : this.getLastUpdateTime().equals(other.getLastUpdateTime()))
            && (this.getLastUpdateOper() == null ? other.getLastUpdateOper() == null : this.getLastUpdateOper().equals(other.getLastUpdateOper()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getCreateOper() == null ? other.getCreateOper() == null : this.getCreateOper().equals(other.getCreateOper()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_node_port
     *
     * @mbg.generated Sun Dec 23 19:14:01 CST 2018
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getNodePortId() == null) ? 0 : getNodePortId().hashCode());
        result = prime * result + ((getNodePortName() == null) ? 0 : getNodePortName().hashCode());
        result = prime * result + ((getOwnerNodeId() == null) ? 0 : getOwnerNodeId().hashCode());
        result = prime * result + ((getRefPortId() == null) ? 0 : getRefPortId().hashCode());
        result = prime * result + ((getRefCharId() == null) ? 0 : getRefCharId().hashCode());
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
     * This method corresponds to the database table wf_flow_node_port
     *
     * @mbg.generated Sun Dec 23 19:14:01 CST 2018
     */
    public void copyProperties(WfFlowNodePort that) {
        if (this == that || that == null) {
            return;
        }
        if(that.isNodePortIdColoured() ) {this.setNodePortId(that.getNodePortId() );}
        if(that.isNodePortNameColoured() ) {this.setNodePortName(that.getNodePortName() );}
        if(that.isOwnerNodeIdColoured() ) {this.setOwnerNodeId(that.getOwnerNodeId() );}
        if(that.isRefPortIdColoured() ) {this.setRefPortId(that.getRefPortId() );}
        if(that.isRefCharIdColoured() ) {this.setRefCharId(that.getRefCharId() );}
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
     * This method corresponds to the database table wf_flow_node_port
     *
     * @mbg.generated Sun Dec 23 19:14:01 CST 2018
     */
    @Override
    public JSONObject toJSON() {
        JSONObject jsonObj = new JSONObject(32, true);
        if(this.nodePortIdColoured) {jsonObj.put("nodePortId", this.nodePortId);}
        if(this.nodePortNameColoured) {jsonObj.put("nodePortName", this.nodePortName);}
        if(this.ownerNodeIdColoured) {jsonObj.put("ownerNodeId", this.ownerNodeId);}
        if(this.refPortIdColoured) {jsonObj.put("refPortId", this.refPortId);}
        if(this.refCharIdColoured) {jsonObj.put("refCharId", this.refCharId);}
        if(this.descriptionColoured) {jsonObj.put("description", this.description);}
        if(this.statusColoured) {jsonObj.put("status", this.status);}
        if(this.lastUpdateTimeColoured) {jsonObj.put("lastUpdateTime", this.lastUpdateTime);}
        if(this.lastUpdateOperColoured) {jsonObj.put("lastUpdateOper", this.lastUpdateOper);}
        if(this.createTimeColoured) {jsonObj.put("createTime", this.createTime);}
        if(this.createOperColoured) {jsonObj.put("createOper", this.createOper);}
        return jsonObj;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_node_port
     *
     * @mbg.generated Sun Dec 23 19:14:01 CST 2018
     */
    @Override
    public void clear() {
         this.nodePortId = null; this.nodePortIdColoured = false;
         this.nodePortName = null; this.nodePortNameColoured = false;
         this.ownerNodeId = null; this.ownerNodeIdColoured = false;
         this.refPortId = null; this.refPortIdColoured = false;
         this.refCharId = null; this.refCharIdColoured = false;
         this.description = null; this.descriptionColoured = false;
         this.status = null; this.statusColoured = false;
         this.lastUpdateTime = null; this.lastUpdateTimeColoured = false;
         this.lastUpdateOper = null; this.lastUpdateOperColoured = false;
         this.createTime = null; this.createTimeColoured = false;
         this.createOper = null; this.createOperColoured = false;
        return;
    }
}