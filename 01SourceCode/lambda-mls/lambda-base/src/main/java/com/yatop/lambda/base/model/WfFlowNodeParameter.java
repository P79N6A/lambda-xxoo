package com.yatop.lambda.base.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "wf_flow_node_parameter")
public class WfFlowNodeParameter implements Serializable {
    /**
     * 节点ID
     */
    @Id
    @Column(name = "NODE_ID")
    private Long nodeId;

    /**
     * 规格类型，说明参考CF_CMPT_SPEC.SPEC_TYPE
            节点上只设置组件参数和调优执行
     */
    @Id
    @Column(name = "SPEC_TYPE")
    private Integer specType;

    /**
     * 组件特征ID
     */
    @Id
    @Column(name = "CHAR_ID")
    private Long charId;

    /**
     * 特征值
     */
    @Column(name = "CHAR_VALUE")
    private String charValue;

    /**
     * 是否为全局参数
            0：否
            1：是
     */
    @Column(name = "IS_GLOBAL_PARAMETER")
    private Integer isGlobalParameter;

    /**
     * 是否被复制
            0：否
            1：是
            
            创建快照和运行任务时对象数据类型会以浅拷贝方式复制，同时该标记会被置位，辅助于对象类型特征值发生更新时，判断是否创建新对象来保存新值
     */
    @Column(name = "IS_DUPLICATED")
    private Integer isDuplicated;

    /**
     * 警告消息
     */
    @Column(name = "WARNING_MSG")
    private String warningMsg;

    /**
     * 描述
     */
    @Column(name = "DESCRIPTION")
    private String description;

    /**
     * 状态
            0：正常
            1：失效
     */
    @Column(name = "STATUS")
    private Integer status;

    /**
     * 最后更新时间
     */
    @Column(name = "LAST_UPDATE_TIME")
    private Date lastUpdateTime;

    /**
     * 最后更新用户
     */
    @Column(name = "LAST_UPDATE_OPER")
    private String lastUpdateOper;

    /**
     * 创建时间
     */
    @Column(name = "CREATE_TIME")
    private Date createTime;

    /**
     * 创建用户
     */
    @Column(name = "CREATE_OPER")
    private String createOper;

    private static final long serialVersionUID = 1L;

    /**
     * 获取节点ID
     *
     * @return NODE_ID - 节点ID
     */
    public Long getNodeId() {
        return nodeId;
    }

    /**
     * 设置节点ID
     *
     * @param nodeId 节点ID
     */
    public void setNodeId(Long nodeId) {
        this.nodeId = nodeId;
    }

    /**
     * 获取规格类型，说明参考CF_CMPT_SPEC.SPEC_TYPE
            节点上只设置组件参数和调优执行
     *
     * @return SPEC_TYPE - 规格类型，说明参考CF_CMPT_SPEC.SPEC_TYPE
            节点上只设置组件参数和调优执行
     */
    public Integer getSpecType() {
        return specType;
    }

    /**
     * 设置规格类型，说明参考CF_CMPT_SPEC.SPEC_TYPE
            节点上只设置组件参数和调优执行
     *
     * @param specType 规格类型，说明参考CF_CMPT_SPEC.SPEC_TYPE
            节点上只设置组件参数和调优执行
     */
    public void setSpecType(Integer specType) {
        this.specType = specType;
    }

    /**
     * 获取组件特征ID
     *
     * @return CHAR_ID - 组件特征ID
     */
    public Long getCharId() {
        return charId;
    }

    /**
     * 设置组件特征ID
     *
     * @param charId 组件特征ID
     */
    public void setCharId(Long charId) {
        this.charId = charId;
    }

    /**
     * 获取特征值
     *
     * @return CHAR_VALUE - 特征值
     */
    public String getCharValue() {
        return charValue;
    }

    /**
     * 设置特征值
     *
     * @param charValue 特征值
     */
    public void setCharValue(String charValue) {
        this.charValue = charValue == null ? null : charValue.trim();
    }

    /**
     * 获取是否为全局参数
            0：否
            1：是
     *
     * @return IS_GLOBAL_PARAMETER - 是否为全局参数
            0：否
            1：是
     */
    public Integer getIsGlobalParameter() {
        return isGlobalParameter;
    }

    /**
     * 设置是否为全局参数
            0：否
            1：是
     *
     * @param isGlobalParameter 是否为全局参数
            0：否
            1：是
     */
    public void setIsGlobalParameter(Integer isGlobalParameter) {
        this.isGlobalParameter = isGlobalParameter;
    }

    /**
     * 获取是否被复制
            0：否
            1：是
            
            创建快照和运行任务时对象数据类型会以浅拷贝方式复制，同时该标记会被置位，辅助于对象类型特征值发生更新时，判断是否创建新对象来保存新值
     *
     * @return IS_DUPLICATED - 是否被复制
            0：否
            1：是
            
            创建快照和运行任务时对象数据类型会以浅拷贝方式复制，同时该标记会被置位，辅助于对象类型特征值发生更新时，判断是否创建新对象来保存新值
     */
    public Integer getIsDuplicated() {
        return isDuplicated;
    }

    /**
     * 设置是否被复制
            0：否
            1：是
            
            创建快照和运行任务时对象数据类型会以浅拷贝方式复制，同时该标记会被置位，辅助于对象类型特征值发生更新时，判断是否创建新对象来保存新值
     *
     * @param isDuplicated 是否被复制
            0：否
            1：是
            
            创建快照和运行任务时对象数据类型会以浅拷贝方式复制，同时该标记会被置位，辅助于对象类型特征值发生更新时，判断是否创建新对象来保存新值
     */
    public void setIsDuplicated(Integer isDuplicated) {
        this.isDuplicated = isDuplicated;
    }

    /**
     * 获取警告消息
     *
     * @return WARNING_MSG - 警告消息
     */
    public String getWarningMsg() {
        return warningMsg;
    }

    /**
     * 设置警告消息
     *
     * @param warningMsg 警告消息
     */
    public void setWarningMsg(String warningMsg) {
        this.warningMsg = warningMsg == null ? null : warningMsg.trim();
    }

    /**
     * 获取描述
     *
     * @return DESCRIPTION - 描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置描述
     *
     * @param description 描述
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * 获取状态
            0：正常
            1：失效
     *
     * @return STATUS - 状态
            0：正常
            1：失效
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置状态
            0：正常
            1：失效
     *
     * @param status 状态
            0：正常
            1：失效
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取最后更新时间
     *
     * @return LAST_UPDATE_TIME - 最后更新时间
     */
    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    /**
     * 设置最后更新时间
     *
     * @param lastUpdateTime 最后更新时间
     */
    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    /**
     * 获取最后更新用户
     *
     * @return LAST_UPDATE_OPER - 最后更新用户
     */
    public String getLastUpdateOper() {
        return lastUpdateOper;
    }

    /**
     * 设置最后更新用户
     *
     * @param lastUpdateOper 最后更新用户
     */
    public void setLastUpdateOper(String lastUpdateOper) {
        this.lastUpdateOper = lastUpdateOper == null ? null : lastUpdateOper.trim();
    }

    /**
     * 获取创建时间
     *
     * @return CREATE_TIME - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取创建用户
     *
     * @return CREATE_OPER - 创建用户
     */
    public String getCreateOper() {
        return createOper;
    }

    /**
     * 设置创建用户
     *
     * @param createOper 创建用户
     */
    public void setCreateOper(String createOper) {
        this.createOper = createOper == null ? null : createOper.trim();
    }

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
}