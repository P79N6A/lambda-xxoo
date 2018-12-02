package com.yatop.lambda.base.model;

import java.io.Serializable;
import java.util.Date;

public class WfFlowNodeLink implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_node_link.LINK_ID
     *
     * @mbg.generated Mon Dec 03 03:14:10 CST 2018
     */
    private Long linkId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_node_link.LINK_ID:Coloured
     *
     * @mbg.generated Mon Dec 03 03:14:10 CST 2018
     */
    private boolean linkIdColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_node_link.OWNER_FLOW_ID
     *
     * @mbg.generated Mon Dec 03 03:14:10 CST 2018
     */
    private Long ownerFlowId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_node_link.OWNER_FLOW_ID:Coloured
     *
     * @mbg.generated Mon Dec 03 03:14:10 CST 2018
     */
    private boolean ownerFlowIdColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_node_link.IS_WEB_LINK
     *
     * @mbg.generated Mon Dec 03 03:14:10 CST 2018
     */
    private Integer isWebLink;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_node_link.IS_WEB_LINK:Coloured
     *
     * @mbg.generated Mon Dec 03 03:14:10 CST 2018
     */
    private boolean isWebLinkColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_node_link.SRC_PORT_ID
     *
     * @mbg.generated Mon Dec 03 03:14:10 CST 2018
     */
    private Long srcPortId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_node_link.SRC_PORT_ID:Coloured
     *
     * @mbg.generated Mon Dec 03 03:14:10 CST 2018
     */
    private boolean srcPortIdColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_node_link.DST_PORT_ID
     *
     * @mbg.generated Mon Dec 03 03:14:10 CST 2018
     */
    private Long dstPortId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_node_link.DST_PORT_ID:Coloured
     *
     * @mbg.generated Mon Dec 03 03:14:10 CST 2018
     */
    private boolean dstPortIdColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_node_link.DESCRIPTION
     *
     * @mbg.generated Mon Dec 03 03:14:10 CST 2018
     */
    private String description;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_node_link.DESCRIPTION:Coloured
     *
     * @mbg.generated Mon Dec 03 03:14:10 CST 2018
     */
    private boolean descriptionColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_node_link.STATUS
     *
     * @mbg.generated Mon Dec 03 03:14:10 CST 2018
     */
    private Integer status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_node_link.STATUS:Coloured
     *
     * @mbg.generated Mon Dec 03 03:14:10 CST 2018
     */
    private boolean statusColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_node_link.LAST_UPDATE_TIME
     *
     * @mbg.generated Mon Dec 03 03:14:10 CST 2018
     */
    private Date lastUpdateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_node_link.LAST_UPDATE_TIME:Coloured
     *
     * @mbg.generated Mon Dec 03 03:14:10 CST 2018
     */
    private boolean lastUpdateTimeColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_node_link.LAST_UPDATE_OPER
     *
     * @mbg.generated Mon Dec 03 03:14:10 CST 2018
     */
    private String lastUpdateOper;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_node_link.LAST_UPDATE_OPER:Coloured
     *
     * @mbg.generated Mon Dec 03 03:14:10 CST 2018
     */
    private boolean lastUpdateOperColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_node_link.CREATE_TIME
     *
     * @mbg.generated Mon Dec 03 03:14:10 CST 2018
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_node_link.CREATE_TIME:Coloured
     *
     * @mbg.generated Mon Dec 03 03:14:10 CST 2018
     */
    private boolean createTimeColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_node_link.CREATE_OPER
     *
     * @mbg.generated Mon Dec 03 03:14:10 CST 2018
     */
    private String createOper;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_node_link.CREATE_OPER:Coloured
     *
     * @mbg.generated Mon Dec 03 03:14:10 CST 2018
     */
    private boolean createOperColoured;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table wf_flow_node_link
     *
     * @mbg.generated Mon Dec 03 03:14:10 CST 2018
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_link.LINK_ID
     *
     * @return the value of wf_flow_node_link.LINK_ID
     *
     * @mbg.generated Mon Dec 03 03:14:10 CST 2018
     */
    public Long getLinkId() {
        return linkId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_link.LINK_ID:Coloured
     *
     * @return the value of wf_flow_node_link.LINK_ID:Coloured
     *
     * @mbg.generated Mon Dec 03 03:14:10 CST 2018
     */
    public boolean isLinkIdColoured() {
        return linkIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_node_link.LINK_ID
     *
     * @param linkId the value for wf_flow_node_link.LINK_ID
     *
     * @mbg.generated Mon Dec 03 03:14:10 CST 2018
     */
    public void setLinkId(Long linkId) {
        this.linkId = linkId;
        this.linkIdColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_node_link.LINK_ID:Coloured
     *
     * @param linkIdColoured the value for wf_flow_node_link.LINK_ID:Coloured
     *
     * @mbg.generated Mon Dec 03 03:14:10 CST 2018
     */
    public void setLinkIdColoured(boolean linkIdColoured) {
        this.linkIdColoured = linkIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_link.OWNER_FLOW_ID
     *
     * @return the value of wf_flow_node_link.OWNER_FLOW_ID
     *
     * @mbg.generated Mon Dec 03 03:14:10 CST 2018
     */
    public Long getOwnerFlowId() {
        return ownerFlowId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_link.OWNER_FLOW_ID:Coloured
     *
     * @return the value of wf_flow_node_link.OWNER_FLOW_ID:Coloured
     *
     * @mbg.generated Mon Dec 03 03:14:10 CST 2018
     */
    public boolean isOwnerFlowIdColoured() {
        return ownerFlowIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_node_link.OWNER_FLOW_ID
     *
     * @param ownerFlowId the value for wf_flow_node_link.OWNER_FLOW_ID
     *
     * @mbg.generated Mon Dec 03 03:14:10 CST 2018
     */
    public void setOwnerFlowId(Long ownerFlowId) {
        this.ownerFlowId = ownerFlowId;
        this.ownerFlowIdColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_node_link.OWNER_FLOW_ID:Coloured
     *
     * @param ownerFlowIdColoured the value for wf_flow_node_link.OWNER_FLOW_ID:Coloured
     *
     * @mbg.generated Mon Dec 03 03:14:10 CST 2018
     */
    public void setOwnerFlowIdColoured(boolean ownerFlowIdColoured) {
        this.ownerFlowIdColoured = ownerFlowIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_link.IS_WEB_LINK
     *
     * @return the value of wf_flow_node_link.IS_WEB_LINK
     *
     * @mbg.generated Mon Dec 03 03:14:10 CST 2018
     */
    public Integer getIsWebLink() {
        return isWebLink;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_link.IS_WEB_LINK:Coloured
     *
     * @return the value of wf_flow_node_link.IS_WEB_LINK:Coloured
     *
     * @mbg.generated Mon Dec 03 03:14:10 CST 2018
     */
    public boolean isIsWebLinkColoured() {
        return isWebLinkColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_node_link.IS_WEB_LINK
     *
     * @param isWebLink the value for wf_flow_node_link.IS_WEB_LINK
     *
     * @mbg.generated Mon Dec 03 03:14:10 CST 2018
     */
    public void setIsWebLink(Integer isWebLink) {
        this.isWebLink = isWebLink;
        this.isWebLinkColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_node_link.IS_WEB_LINK:Coloured
     *
     * @param isWebLinkColoured the value for wf_flow_node_link.IS_WEB_LINK:Coloured
     *
     * @mbg.generated Mon Dec 03 03:14:10 CST 2018
     */
    public void setIsWebLinkColoured(boolean isWebLinkColoured) {
        this.isWebLinkColoured = isWebLinkColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_link.SRC_PORT_ID
     *
     * @return the value of wf_flow_node_link.SRC_PORT_ID
     *
     * @mbg.generated Mon Dec 03 03:14:10 CST 2018
     */
    public Long getSrcPortId() {
        return srcPortId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_link.SRC_PORT_ID:Coloured
     *
     * @return the value of wf_flow_node_link.SRC_PORT_ID:Coloured
     *
     * @mbg.generated Mon Dec 03 03:14:10 CST 2018
     */
    public boolean isSrcPortIdColoured() {
        return srcPortIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_node_link.SRC_PORT_ID
     *
     * @param srcPortId the value for wf_flow_node_link.SRC_PORT_ID
     *
     * @mbg.generated Mon Dec 03 03:14:10 CST 2018
     */
    public void setSrcPortId(Long srcPortId) {
        this.srcPortId = srcPortId;
        this.srcPortIdColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_node_link.SRC_PORT_ID:Coloured
     *
     * @param srcPortIdColoured the value for wf_flow_node_link.SRC_PORT_ID:Coloured
     *
     * @mbg.generated Mon Dec 03 03:14:10 CST 2018
     */
    public void setSrcPortIdColoured(boolean srcPortIdColoured) {
        this.srcPortIdColoured = srcPortIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_link.DST_PORT_ID
     *
     * @return the value of wf_flow_node_link.DST_PORT_ID
     *
     * @mbg.generated Mon Dec 03 03:14:10 CST 2018
     */
    public Long getDstPortId() {
        return dstPortId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_link.DST_PORT_ID:Coloured
     *
     * @return the value of wf_flow_node_link.DST_PORT_ID:Coloured
     *
     * @mbg.generated Mon Dec 03 03:14:10 CST 2018
     */
    public boolean isDstPortIdColoured() {
        return dstPortIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_node_link.DST_PORT_ID
     *
     * @param dstPortId the value for wf_flow_node_link.DST_PORT_ID
     *
     * @mbg.generated Mon Dec 03 03:14:10 CST 2018
     */
    public void setDstPortId(Long dstPortId) {
        this.dstPortId = dstPortId;
        this.dstPortIdColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_node_link.DST_PORT_ID:Coloured
     *
     * @param dstPortIdColoured the value for wf_flow_node_link.DST_PORT_ID:Coloured
     *
     * @mbg.generated Mon Dec 03 03:14:10 CST 2018
     */
    public void setDstPortIdColoured(boolean dstPortIdColoured) {
        this.dstPortIdColoured = dstPortIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_link.DESCRIPTION
     *
     * @return the value of wf_flow_node_link.DESCRIPTION
     *
     * @mbg.generated Mon Dec 03 03:14:10 CST 2018
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_link.DESCRIPTION:Coloured
     *
     * @return the value of wf_flow_node_link.DESCRIPTION:Coloured
     *
     * @mbg.generated Mon Dec 03 03:14:10 CST 2018
     */
    public boolean isDescriptionColoured() {
        return descriptionColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_node_link.DESCRIPTION
     *
     * @param description the value for wf_flow_node_link.DESCRIPTION
     *
     * @mbg.generated Mon Dec 03 03:14:10 CST 2018
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
        this.descriptionColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_node_link.DESCRIPTION:Coloured
     *
     * @param descriptionColoured the value for wf_flow_node_link.DESCRIPTION:Coloured
     *
     * @mbg.generated Mon Dec 03 03:14:10 CST 2018
     */
    public void setDescriptionColoured(boolean descriptionColoured) {
        this.descriptionColoured = descriptionColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_link.STATUS
     *
     * @return the value of wf_flow_node_link.STATUS
     *
     * @mbg.generated Mon Dec 03 03:14:10 CST 2018
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_link.STATUS:Coloured
     *
     * @return the value of wf_flow_node_link.STATUS:Coloured
     *
     * @mbg.generated Mon Dec 03 03:14:10 CST 2018
     */
    public boolean isStatusColoured() {
        return statusColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_node_link.STATUS
     *
     * @param status the value for wf_flow_node_link.STATUS
     *
     * @mbg.generated Mon Dec 03 03:14:10 CST 2018
     */
    public void setStatus(Integer status) {
        this.status = status;
        this.statusColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_node_link.STATUS:Coloured
     *
     * @param statusColoured the value for wf_flow_node_link.STATUS:Coloured
     *
     * @mbg.generated Mon Dec 03 03:14:10 CST 2018
     */
    public void setStatusColoured(boolean statusColoured) {
        this.statusColoured = statusColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_link.LAST_UPDATE_TIME
     *
     * @return the value of wf_flow_node_link.LAST_UPDATE_TIME
     *
     * @mbg.generated Mon Dec 03 03:14:10 CST 2018
     */
    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_link.LAST_UPDATE_TIME:Coloured
     *
     * @return the value of wf_flow_node_link.LAST_UPDATE_TIME:Coloured
     *
     * @mbg.generated Mon Dec 03 03:14:10 CST 2018
     */
    public boolean isLastUpdateTimeColoured() {
        return lastUpdateTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_node_link.LAST_UPDATE_TIME
     *
     * @param lastUpdateTime the value for wf_flow_node_link.LAST_UPDATE_TIME
     *
     * @mbg.generated Mon Dec 03 03:14:10 CST 2018
     */
    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
        this.lastUpdateTimeColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_node_link.LAST_UPDATE_TIME:Coloured
     *
     * @param lastUpdateTimeColoured the value for wf_flow_node_link.LAST_UPDATE_TIME:Coloured
     *
     * @mbg.generated Mon Dec 03 03:14:10 CST 2018
     */
    public void setLastUpdateTimeColoured(boolean lastUpdateTimeColoured) {
        this.lastUpdateTimeColoured = lastUpdateTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_link.LAST_UPDATE_OPER
     *
     * @return the value of wf_flow_node_link.LAST_UPDATE_OPER
     *
     * @mbg.generated Mon Dec 03 03:14:10 CST 2018
     */
    public String getLastUpdateOper() {
        return lastUpdateOper;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_link.LAST_UPDATE_OPER:Coloured
     *
     * @return the value of wf_flow_node_link.LAST_UPDATE_OPER:Coloured
     *
     * @mbg.generated Mon Dec 03 03:14:10 CST 2018
     */
    public boolean isLastUpdateOperColoured() {
        return lastUpdateOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_node_link.LAST_UPDATE_OPER
     *
     * @param lastUpdateOper the value for wf_flow_node_link.LAST_UPDATE_OPER
     *
     * @mbg.generated Mon Dec 03 03:14:10 CST 2018
     */
    public void setLastUpdateOper(String lastUpdateOper) {
        this.lastUpdateOper = lastUpdateOper == null ? null : lastUpdateOper.trim();
        this.lastUpdateOperColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_node_link.LAST_UPDATE_OPER:Coloured
     *
     * @param lastUpdateOperColoured the value for wf_flow_node_link.LAST_UPDATE_OPER:Coloured
     *
     * @mbg.generated Mon Dec 03 03:14:10 CST 2018
     */
    public void setLastUpdateOperColoured(boolean lastUpdateOperColoured) {
        this.lastUpdateOperColoured = lastUpdateOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_link.CREATE_TIME
     *
     * @return the value of wf_flow_node_link.CREATE_TIME
     *
     * @mbg.generated Mon Dec 03 03:14:10 CST 2018
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_link.CREATE_TIME:Coloured
     *
     * @return the value of wf_flow_node_link.CREATE_TIME:Coloured
     *
     * @mbg.generated Mon Dec 03 03:14:10 CST 2018
     */
    public boolean isCreateTimeColoured() {
        return createTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_node_link.CREATE_TIME
     *
     * @param createTime the value for wf_flow_node_link.CREATE_TIME
     *
     * @mbg.generated Mon Dec 03 03:14:10 CST 2018
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
        this.createTimeColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_node_link.CREATE_TIME:Coloured
     *
     * @param createTimeColoured the value for wf_flow_node_link.CREATE_TIME:Coloured
     *
     * @mbg.generated Mon Dec 03 03:14:10 CST 2018
     */
    public void setCreateTimeColoured(boolean createTimeColoured) {
        this.createTimeColoured = createTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_link.CREATE_OPER
     *
     * @return the value of wf_flow_node_link.CREATE_OPER
     *
     * @mbg.generated Mon Dec 03 03:14:10 CST 2018
     */
    public String getCreateOper() {
        return createOper;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_link.CREATE_OPER:Coloured
     *
     * @return the value of wf_flow_node_link.CREATE_OPER:Coloured
     *
     * @mbg.generated Mon Dec 03 03:14:10 CST 2018
     */
    public boolean isCreateOperColoured() {
        return createOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_node_link.CREATE_OPER
     *
     * @param createOper the value for wf_flow_node_link.CREATE_OPER
     *
     * @mbg.generated Mon Dec 03 03:14:10 CST 2018
     */
    public void setCreateOper(String createOper) {
        this.createOper = createOper == null ? null : createOper.trim();
        this.createOperColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_node_link.CREATE_OPER:Coloured
     *
     * @param createOperColoured the value for wf_flow_node_link.CREATE_OPER:Coloured
     *
     * @mbg.generated Mon Dec 03 03:14:10 CST 2018
     */
    public void setCreateOperColoured(boolean createOperColoured) {
        this.createOperColoured = createOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_node_link
     *
     * @mbg.generated Mon Dec 03 03:14:10 CST 2018
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
        WfFlowNodeLink other = (WfFlowNodeLink) that;
        return (this.getLinkId() == null ? other.getLinkId() == null : this.getLinkId().equals(other.getLinkId()))
            && (this.getOwnerFlowId() == null ? other.getOwnerFlowId() == null : this.getOwnerFlowId().equals(other.getOwnerFlowId()))
            && (this.getIsWebLink() == null ? other.getIsWebLink() == null : this.getIsWebLink().equals(other.getIsWebLink()))
            && (this.getSrcPortId() == null ? other.getSrcPortId() == null : this.getSrcPortId().equals(other.getSrcPortId()))
            && (this.getDstPortId() == null ? other.getDstPortId() == null : this.getDstPortId().equals(other.getDstPortId()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getLastUpdateTime() == null ? other.getLastUpdateTime() == null : this.getLastUpdateTime().equals(other.getLastUpdateTime()))
            && (this.getLastUpdateOper() == null ? other.getLastUpdateOper() == null : this.getLastUpdateOper().equals(other.getLastUpdateOper()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getCreateOper() == null ? other.getCreateOper() == null : this.getCreateOper().equals(other.getCreateOper()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_node_link
     *
     * @mbg.generated Mon Dec 03 03:14:10 CST 2018
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getLinkId() == null) ? 0 : getLinkId().hashCode());
        result = prime * result + ((getOwnerFlowId() == null) ? 0 : getOwnerFlowId().hashCode());
        result = prime * result + ((getIsWebLink() == null) ? 0 : getIsWebLink().hashCode());
        result = prime * result + ((getSrcPortId() == null) ? 0 : getSrcPortId().hashCode());
        result = prime * result + ((getDstPortId() == null) ? 0 : getDstPortId().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getLastUpdateTime() == null) ? 0 : getLastUpdateTime().hashCode());
        result = prime * result + ((getLastUpdateOper() == null) ? 0 : getLastUpdateOper().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCreateOper() == null) ? 0 : getCreateOper().hashCode());
        return result;
    }
}