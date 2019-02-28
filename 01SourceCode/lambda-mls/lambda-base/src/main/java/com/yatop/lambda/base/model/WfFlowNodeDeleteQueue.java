package com.yatop.lambda.base.model;

import com.alibaba.fastjson.JSONObject;
import com.yatop.lambda.base.utils.LambdaRootModel;
import java.io.Serializable;
import java.util.Date;

public class WfFlowNodeDeleteQueue extends LambdaRootModel implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_node_delete_queue.FLOW_ID
     *
     * @mbg.generated Thu Feb 28 16:41:10 CST 2019
     */
    private Long flowId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_node_delete_queue.FLOW_ID:Coloured
     *
     * @mbg.generated Thu Feb 28 16:41:10 CST 2019
     */
    private boolean flowIdColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_node_delete_queue.NODE_ID
     *
     * @mbg.generated Thu Feb 28 16:41:10 CST 2019
     */
    private Long nodeId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_node_delete_queue.NODE_ID:Coloured
     *
     * @mbg.generated Thu Feb 28 16:41:10 CST 2019
     */
    private boolean nodeIdColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_node_delete_queue.SEQUENCE
     *
     * @mbg.generated Thu Feb 28 16:41:10 CST 2019
     */
    private Long sequence;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_node_delete_queue.SEQUENCE:Coloured
     *
     * @mbg.generated Thu Feb 28 16:41:10 CST 2019
     */
    private boolean sequenceColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_node_delete_queue.DESCRIPTION
     *
     * @mbg.generated Thu Feb 28 16:41:10 CST 2019
     */
    private String description;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_node_delete_queue.DESCRIPTION:Coloured
     *
     * @mbg.generated Thu Feb 28 16:41:10 CST 2019
     */
    private boolean descriptionColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_node_delete_queue.CREATE_TIME
     *
     * @mbg.generated Thu Feb 28 16:41:10 CST 2019
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_node_delete_queue.CREATE_TIME:Coloured
     *
     * @mbg.generated Thu Feb 28 16:41:10 CST 2019
     */
    private boolean createTimeColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_node_delete_queue.CREATE_OPER
     *
     * @mbg.generated Thu Feb 28 16:41:10 CST 2019
     */
    private String createOper;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_node_delete_queue.CREATE_OPER:Coloured
     *
     * @mbg.generated Thu Feb 28 16:41:10 CST 2019
     */
    private boolean createOperColoured;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table wf_flow_node_delete_queue
     *
     * @mbg.generated Thu Feb 28 16:41:10 CST 2019
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_delete_queue.FLOW_ID
     *
     * @return the value of wf_flow_node_delete_queue.FLOW_ID
     *
     * @mbg.generated Thu Feb 28 16:41:10 CST 2019
     */
    public Long getFlowId() {
        return flowId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_delete_queue.FLOW_ID:Coloured
     *
     * @return the value of wf_flow_node_delete_queue.FLOW_ID:Coloured
     *
     * @mbg.generated Thu Feb 28 16:41:10 CST 2019
     */
    public boolean isFlowIdColoured() {
        return flowIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_delete_queue.FLOW_ID:Coloured
     *
     * @return the value of wf_flow_node_delete_queue.FLOW_ID:Coloured
     *
     * @mbg.generated Thu Feb 28 16:41:10 CST 2019
     */
    public boolean isFlowIdNotColoured() {
        return !flowIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_node_delete_queue.FLOW_ID
     *
     * @param flowId the value for wf_flow_node_delete_queue.FLOW_ID
     *
     * @mbg.generated Thu Feb 28 16:41:10 CST 2019
     */
    public void setFlowId(Long flowId) {
        this.flowId = flowId;
        this.flowIdColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_node_delete_queue.FLOW_ID:Coloured
     *
     * @param flowIdColoured the value for wf_flow_node_delete_queue.FLOW_ID:Coloured
     *
     * @mbg.generated Thu Feb 28 16:41:10 CST 2019
     */
    public void setFlowIdColoured(boolean flowIdColoured) {
        this.flowIdColoured = flowIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_delete_queue.NODE_ID
     *
     * @return the value of wf_flow_node_delete_queue.NODE_ID
     *
     * @mbg.generated Thu Feb 28 16:41:10 CST 2019
     */
    public Long getNodeId() {
        return nodeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_delete_queue.NODE_ID:Coloured
     *
     * @return the value of wf_flow_node_delete_queue.NODE_ID:Coloured
     *
     * @mbg.generated Thu Feb 28 16:41:10 CST 2019
     */
    public boolean isNodeIdColoured() {
        return nodeIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_delete_queue.NODE_ID:Coloured
     *
     * @return the value of wf_flow_node_delete_queue.NODE_ID:Coloured
     *
     * @mbg.generated Thu Feb 28 16:41:10 CST 2019
     */
    public boolean isNodeIdNotColoured() {
        return !nodeIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_node_delete_queue.NODE_ID
     *
     * @param nodeId the value for wf_flow_node_delete_queue.NODE_ID
     *
     * @mbg.generated Thu Feb 28 16:41:10 CST 2019
     */
    public void setNodeId(Long nodeId) {
        this.nodeId = nodeId;
        this.nodeIdColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_node_delete_queue.NODE_ID:Coloured
     *
     * @param nodeIdColoured the value for wf_flow_node_delete_queue.NODE_ID:Coloured
     *
     * @mbg.generated Thu Feb 28 16:41:10 CST 2019
     */
    public void setNodeIdColoured(boolean nodeIdColoured) {
        this.nodeIdColoured = nodeIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_delete_queue.SEQUENCE
     *
     * @return the value of wf_flow_node_delete_queue.SEQUENCE
     *
     * @mbg.generated Thu Feb 28 16:41:10 CST 2019
     */
    public Long getSequence() {
        return sequence;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_delete_queue.SEQUENCE:Coloured
     *
     * @return the value of wf_flow_node_delete_queue.SEQUENCE:Coloured
     *
     * @mbg.generated Thu Feb 28 16:41:10 CST 2019
     */
    public boolean isSequenceColoured() {
        return sequenceColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_delete_queue.SEQUENCE:Coloured
     *
     * @return the value of wf_flow_node_delete_queue.SEQUENCE:Coloured
     *
     * @mbg.generated Thu Feb 28 16:41:10 CST 2019
     */
    public boolean isSequenceNotColoured() {
        return !sequenceColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_node_delete_queue.SEQUENCE
     *
     * @param sequence the value for wf_flow_node_delete_queue.SEQUENCE
     *
     * @mbg.generated Thu Feb 28 16:41:10 CST 2019
     */
    public void setSequence(Long sequence) {
        this.sequence = sequence;
        this.sequenceColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_node_delete_queue.SEQUENCE:Coloured
     *
     * @param sequenceColoured the value for wf_flow_node_delete_queue.SEQUENCE:Coloured
     *
     * @mbg.generated Thu Feb 28 16:41:10 CST 2019
     */
    public void setSequenceColoured(boolean sequenceColoured) {
        this.sequenceColoured = sequenceColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_delete_queue.DESCRIPTION
     *
     * @return the value of wf_flow_node_delete_queue.DESCRIPTION
     *
     * @mbg.generated Thu Feb 28 16:41:10 CST 2019
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_delete_queue.DESCRIPTION:Coloured
     *
     * @return the value of wf_flow_node_delete_queue.DESCRIPTION:Coloured
     *
     * @mbg.generated Thu Feb 28 16:41:10 CST 2019
     */
    public boolean isDescriptionColoured() {
        return descriptionColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_delete_queue.DESCRIPTION:Coloured
     *
     * @return the value of wf_flow_node_delete_queue.DESCRIPTION:Coloured
     *
     * @mbg.generated Thu Feb 28 16:41:10 CST 2019
     */
    public boolean isDescriptionNotColoured() {
        return !descriptionColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_node_delete_queue.DESCRIPTION
     *
     * @param description the value for wf_flow_node_delete_queue.DESCRIPTION
     *
     * @mbg.generated Thu Feb 28 16:41:10 CST 2019
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
        this.descriptionColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_node_delete_queue.DESCRIPTION:Coloured
     *
     * @param descriptionColoured the value for wf_flow_node_delete_queue.DESCRIPTION:Coloured
     *
     * @mbg.generated Thu Feb 28 16:41:10 CST 2019
     */
    public void setDescriptionColoured(boolean descriptionColoured) {
        this.descriptionColoured = descriptionColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_delete_queue.CREATE_TIME
     *
     * @return the value of wf_flow_node_delete_queue.CREATE_TIME
     *
     * @mbg.generated Thu Feb 28 16:41:10 CST 2019
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_delete_queue.CREATE_TIME:Coloured
     *
     * @return the value of wf_flow_node_delete_queue.CREATE_TIME:Coloured
     *
     * @mbg.generated Thu Feb 28 16:41:10 CST 2019
     */
    public boolean isCreateTimeColoured() {
        return createTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_delete_queue.CREATE_TIME:Coloured
     *
     * @return the value of wf_flow_node_delete_queue.CREATE_TIME:Coloured
     *
     * @mbg.generated Thu Feb 28 16:41:10 CST 2019
     */
    public boolean isCreateTimeNotColoured() {
        return !createTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_node_delete_queue.CREATE_TIME
     *
     * @param createTime the value for wf_flow_node_delete_queue.CREATE_TIME
     *
     * @mbg.generated Thu Feb 28 16:41:10 CST 2019
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
        this.createTimeColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_node_delete_queue.CREATE_TIME:Coloured
     *
     * @param createTimeColoured the value for wf_flow_node_delete_queue.CREATE_TIME:Coloured
     *
     * @mbg.generated Thu Feb 28 16:41:10 CST 2019
     */
    public void setCreateTimeColoured(boolean createTimeColoured) {
        this.createTimeColoured = createTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_delete_queue.CREATE_OPER
     *
     * @return the value of wf_flow_node_delete_queue.CREATE_OPER
     *
     * @mbg.generated Thu Feb 28 16:41:10 CST 2019
     */
    public String getCreateOper() {
        return createOper;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_delete_queue.CREATE_OPER:Coloured
     *
     * @return the value of wf_flow_node_delete_queue.CREATE_OPER:Coloured
     *
     * @mbg.generated Thu Feb 28 16:41:10 CST 2019
     */
    public boolean isCreateOperColoured() {
        return createOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_delete_queue.CREATE_OPER:Coloured
     *
     * @return the value of wf_flow_node_delete_queue.CREATE_OPER:Coloured
     *
     * @mbg.generated Thu Feb 28 16:41:10 CST 2019
     */
    public boolean isCreateOperNotColoured() {
        return !createOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_node_delete_queue.CREATE_OPER
     *
     * @param createOper the value for wf_flow_node_delete_queue.CREATE_OPER
     *
     * @mbg.generated Thu Feb 28 16:41:10 CST 2019
     */
    public void setCreateOper(String createOper) {
        this.createOper = createOper == null ? null : createOper.trim();
        this.createOperColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_node_delete_queue.CREATE_OPER:Coloured
     *
     * @param createOperColoured the value for wf_flow_node_delete_queue.CREATE_OPER:Coloured
     *
     * @mbg.generated Thu Feb 28 16:41:10 CST 2019
     */
    public void setCreateOperColoured(boolean createOperColoured) {
        this.createOperColoured = createOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_node_delete_queue
     *
     * @mbg.generated Thu Feb 28 16:41:10 CST 2019
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if(!(that instanceof WfFlowNodeDeleteQueue)) {
            return false;
        }
        WfFlowNodeDeleteQueue other = (WfFlowNodeDeleteQueue) that;
        return (this.getFlowId() == null ? other.getFlowId() == null : this.getFlowId().equals(other.getFlowId()))
            && (this.getNodeId() == null ? other.getNodeId() == null : this.getNodeId().equals(other.getNodeId()))
            && (this.getSequence() == null ? other.getSequence() == null : this.getSequence().equals(other.getSequence()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getCreateOper() == null ? other.getCreateOper() == null : this.getCreateOper().equals(other.getCreateOper()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_node_delete_queue
     *
     * @mbg.generated Thu Feb 28 16:41:10 CST 2019
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getFlowId() == null) ? 0 : getFlowId().hashCode());
        result = prime * result + ((getNodeId() == null) ? 0 : getNodeId().hashCode());
        result = prime * result + ((getSequence() == null) ? 0 : getSequence().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCreateOper() == null) ? 0 : getCreateOper().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_node_delete_queue
     *
     * @mbg.generated Thu Feb 28 16:41:10 CST 2019
     */
    public void copyProperties(WfFlowNodeDeleteQueue that) {
        if (this == that || that == null) {
            return;
        }
        if(that.isFlowIdColoured() ) {this.setFlowId(that.getFlowId() );}
        if(that.isNodeIdColoured() ) {this.setNodeId(that.getNodeId() );}
        if(that.isSequenceColoured() ) {this.setSequence(that.getSequence() );}
        if(that.isDescriptionColoured() ) {this.setDescription(that.getDescription() );}
        if(that.isCreateTimeColoured() ) {this.setCreateTime(that.getCreateTime() );}
        if(that.isCreateOperColoured() ) {this.setCreateOper(that.getCreateOper() );}
        return;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_node_delete_queue
     *
     * @mbg.generated Thu Feb 28 16:41:10 CST 2019
     */
    public WfFlowNodeDeleteQueue makeCopy() {
        WfFlowNodeDeleteQueue copy = new WfFlowNodeDeleteQueue();
        if(this.flowId != null ) {copy.flowId = this.flowId;}
        if(this.nodeId != null ) {copy.nodeId = this.nodeId;}
        if(this.sequence != null ) {copy.sequence = this.sequence;}
        if(this.description != null ) {copy.description = this.description;}
        if(this.createTime != null ) {copy.createTime = this.createTime;}
        if(this.createOper != null ) {copy.createOper = this.createOper;}
        return copy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_node_delete_queue
     *
     * @mbg.generated Thu Feb 28 16:41:10 CST 2019
     */
    @Override
    public JSONObject toJSON() {
        JSONObject jsonObj = new JSONObject(32, true);
        if(this.flowId != null) {jsonObj.put("flowId", this.flowId);}
        if(this.nodeId != null) {jsonObj.put("nodeId", this.nodeId);}
        if(this.sequence != null) {jsonObj.put("sequence", this.sequence);}
        if(this.description != null) {jsonObj.put("description", this.description);}
        if(this.createTime != null) {jsonObj.put("createTime", this.createTime);}
        if(this.createOper != null) {jsonObj.put("createOper", this.createOper);}
        return jsonObj;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_node_delete_queue
     *
     * @mbg.generated Thu Feb 28 16:41:10 CST 2019
     */
    @Override
    public void clear() {
         this.flowId = null; this.flowIdColoured = false;
         this.nodeId = null; this.nodeIdColoured = false;
         this.sequence = null; this.sequenceColoured = false;
         this.description = null; this.descriptionColoured = false;
         this.createTime = null; this.createTimeColoured = false;
         this.createOper = null; this.createOperColoured = false;
        return;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_node_delete_queue
     *
     * @mbg.generated Thu Feb 28 16:41:10 CST 2019
     */
    @Override
    public void clearColoured() {
        this.flowIdColoured = false;
        this.nodeIdColoured = false;
        this.sequenceColoured = false;
        this.descriptionColoured = false;
        this.createTimeColoured = false;
        this.createOperColoured = false;
        return;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_node_delete_queue
     *
     * @mbg.generated Thu Feb 28 16:41:10 CST 2019
     */
    @Override
    public boolean isColoured() {
        if(this.flowIdColoured) return true;
        if(this.nodeIdColoured) return true;
        if(this.sequenceColoured) return true;
        if(this.descriptionColoured) return true;
        if(this.createTimeColoured) return true;
        if(this.createOperColoured) return true;
        return false;
    }
}