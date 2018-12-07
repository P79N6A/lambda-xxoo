package com.yatop.lambda.base.model;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yatop.lambda.base.utils.LambdaRootModel;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;

public class WfFlowNodeDeleteQueue extends LambdaRootModel implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_node_delete_queue.FLOW_ID
     *
     * @mbg.generated Fri Dec 07 19:33:26 CST 2018
     */
    private Long flowId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_node_delete_queue.FLOW_ID:Coloured
     *
     * @mbg.generated Fri Dec 07 19:33:26 CST 2018
     */
    private boolean flowIdColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_node_delete_queue.NODE_ID
     *
     * @mbg.generated Fri Dec 07 19:33:26 CST 2018
     */
    private Long nodeId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_node_delete_queue.NODE_ID:Coloured
     *
     * @mbg.generated Fri Dec 07 19:33:26 CST 2018
     */
    private boolean nodeIdColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_node_delete_queue.SEQUENCE
     *
     * @mbg.generated Fri Dec 07 19:33:26 CST 2018
     */
    private Integer sequence;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_node_delete_queue.SEQUENCE:Coloured
     *
     * @mbg.generated Fri Dec 07 19:33:26 CST 2018
     */
    private boolean sequenceColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_node_delete_queue.DESCRIPTION
     *
     * @mbg.generated Fri Dec 07 19:33:26 CST 2018
     */
    private String description;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_node_delete_queue.DESCRIPTION:Coloured
     *
     * @mbg.generated Fri Dec 07 19:33:26 CST 2018
     */
    private boolean descriptionColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_node_delete_queue.CREATE_TIME
     *
     * @mbg.generated Fri Dec 07 19:33:26 CST 2018
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_node_delete_queue.CREATE_TIME:Coloured
     *
     * @mbg.generated Fri Dec 07 19:33:26 CST 2018
     */
    private boolean createTimeColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_node_delete_queue.CREATE_OPER
     *
     * @mbg.generated Fri Dec 07 19:33:26 CST 2018
     */
    private String createOper;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_flow_node_delete_queue.CREATE_OPER:Coloured
     *
     * @mbg.generated Fri Dec 07 19:33:26 CST 2018
     */
    private boolean createOperColoured;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table wf_flow_node_delete_queue
     *
     * @mbg.generated Fri Dec 07 19:33:26 CST 2018
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_delete_queue.FLOW_ID
     *
     * @return the value of wf_flow_node_delete_queue.FLOW_ID
     *
     * @mbg.generated Fri Dec 07 19:33:26 CST 2018
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
     * @mbg.generated Fri Dec 07 19:33:26 CST 2018
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
     * @mbg.generated Fri Dec 07 19:33:26 CST 2018
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
     * @mbg.generated Fri Dec 07 19:33:26 CST 2018
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
     * @mbg.generated Fri Dec 07 19:33:26 CST 2018
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
     * @mbg.generated Fri Dec 07 19:33:26 CST 2018
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
     * @mbg.generated Fri Dec 07 19:33:26 CST 2018
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
     * @mbg.generated Fri Dec 07 19:33:26 CST 2018
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
     * @mbg.generated Fri Dec 07 19:33:26 CST 2018
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
     * @mbg.generated Fri Dec 07 19:33:26 CST 2018
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
     * @mbg.generated Fri Dec 07 19:33:26 CST 2018
     */
    public Integer getSequence() {
        return sequence;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_flow_node_delete_queue.SEQUENCE:Coloured
     *
     * @return the value of wf_flow_node_delete_queue.SEQUENCE:Coloured
     *
     * @mbg.generated Fri Dec 07 19:33:26 CST 2018
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
     * @mbg.generated Fri Dec 07 19:33:26 CST 2018
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
     * @mbg.generated Fri Dec 07 19:33:26 CST 2018
     */
    public void setSequence(Integer sequence) {
        this.sequence = sequence;
        this.sequenceColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_flow_node_delete_queue.SEQUENCE:Coloured
     *
     * @param sequenceColoured the value for wf_flow_node_delete_queue.SEQUENCE:Coloured
     *
     * @mbg.generated Fri Dec 07 19:33:26 CST 2018
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
     * @mbg.generated Fri Dec 07 19:33:26 CST 2018
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
     * @mbg.generated Fri Dec 07 19:33:26 CST 2018
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
     * @mbg.generated Fri Dec 07 19:33:26 CST 2018
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
     * @mbg.generated Fri Dec 07 19:33:26 CST 2018
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
     * @mbg.generated Fri Dec 07 19:33:26 CST 2018
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
     * @mbg.generated Fri Dec 07 19:33:26 CST 2018
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
     * @mbg.generated Fri Dec 07 19:33:26 CST 2018
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
     * @mbg.generated Fri Dec 07 19:33:26 CST 2018
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
     * @mbg.generated Fri Dec 07 19:33:26 CST 2018
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
     * @mbg.generated Fri Dec 07 19:33:26 CST 2018
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
     * @mbg.generated Fri Dec 07 19:33:26 CST 2018
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
     * @mbg.generated Fri Dec 07 19:33:26 CST 2018
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
     * @mbg.generated Fri Dec 07 19:33:26 CST 2018
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
     * @mbg.generated Fri Dec 07 19:33:26 CST 2018
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
     * @mbg.generated Fri Dec 07 19:33:26 CST 2018
     */
    public void setCreateOperColoured(boolean createOperColoured) {
        this.createOperColoured = createOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_node_delete_queue
     *
     * @mbg.generated Fri Dec 07 19:33:26 CST 2018
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
     * @mbg.generated Fri Dec 07 19:33:26 CST 2018
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
     * @mbg.generated Fri Dec 07 19:33:26 CST 2018
     */
    @Override
    public void copyProperties(Object that) {
        if (this == that || that == null || this.getClass() != that.getClass() ) {
            return;
        }
        WfFlowNodeDeleteQueue other = (WfFlowNodeDeleteQueue) that;
        if(other.isFlowIdColoured() ) {this.setFlowId(other.getFlowId() );}
        if(other.isNodeIdColoured() ) {this.setNodeId(other.getNodeId() );}
        if(other.isSequenceColoured() ) {this.setSequence(other.getSequence() );}
        if(other.isDescriptionColoured() ) {this.setDescription(other.getDescription() );}
        if(other.isCreateTimeColoured() ) {this.setCreateTime(other.getCreateTime() );}
        if(other.isCreateOperColoured() ) {this.setCreateOper(other.getCreateOper() );}
        return;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_node_delete_queue
     *
     * @mbg.generated Fri Dec 07 19:33:26 CST 2018
     */
    @Override
    public JSONObject toJSON() {
        HashMap<String, Object> hashMap = new HashMap();
        if(this.flowIdColoured) {hashMap.put("flowId", this.flowId);}
        if(this.nodeIdColoured) {hashMap.put("nodeId", this.nodeId);}
        if(this.sequenceColoured) {hashMap.put("sequence", this.sequence);}
        if(this.descriptionColoured) {hashMap.put("description", this.description);}
        if(this.createTimeColoured) {hashMap.put("createTime", this.createTime);}
        if(this.createOperColoured) {hashMap.put("createOper", this.createOper);}
        return (JSONObject) JSON.toJSON(hashMap);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_node_delete_queue
     *
     * @mbg.generated Fri Dec 07 19:33:26 CST 2018
     */
    @Override
    public void clear() {
        if(this.flowIdColoured) {this.flowId = null; this.flowIdColoured = false;}
        if(this.nodeIdColoured) {this.nodeId = null; this.nodeIdColoured = false;}
        if(this.sequenceColoured) {this.sequence = null; this.sequenceColoured = false;}
        if(this.descriptionColoured) {this.description = null; this.descriptionColoured = false;}
        if(this.createTimeColoured) {this.createTime = null; this.createTimeColoured = false;}
        if(this.createOperColoured) {this.createOper = null; this.createOperColoured = false;}
        return;
    }
}