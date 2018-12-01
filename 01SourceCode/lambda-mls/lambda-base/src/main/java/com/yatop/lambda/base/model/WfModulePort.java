package com.yatop.lambda.base.model;

import java.io.Serializable;
import java.util.Date;

public class WfModulePort implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_module_port.PORT_ID
     *
     * @mbg.generated Sat Dec 01 22:15:38 CST 2018
     */
    private Long portId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_module_port.PORT_NAME
     *
     * @mbg.generated Sat Dec 01 22:15:38 CST 2018
     */
    private String portName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_module_port.PORT_TYPE
     *
     * @mbg.generated Sat Dec 01 22:15:38 CST 2018
     */
    private Integer portType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_module_port.OWNER_MODULE_ID
     *
     * @mbg.generated Sat Dec 01 22:15:38 CST 2018
     */
    private Long ownerModuleId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_module_port.BIND_CHAR_ID
     *
     * @mbg.generated Sat Dec 01 22:15:38 CST 2018
     */
    private String bindCharId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_module_port.SEQUENCE
     *
     * @mbg.generated Sat Dec 01 22:15:38 CST 2018
     */
    private Integer sequence;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_module_port.DESCRIPTION
     *
     * @mbg.generated Sat Dec 01 22:15:38 CST 2018
     */
    private String description;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_module_port.STATUS
     *
     * @mbg.generated Sat Dec 01 22:15:38 CST 2018
     */
    private Integer status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_module_port.LAST_UPDATE_TIME
     *
     * @mbg.generated Sat Dec 01 22:15:38 CST 2018
     */
    private Date lastUpdateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_module_port.LAST_UPDATE_OPER
     *
     * @mbg.generated Sat Dec 01 22:15:38 CST 2018
     */
    private String lastUpdateOper;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_module_port.CREATE_TIME
     *
     * @mbg.generated Sat Dec 01 22:15:38 CST 2018
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_module_port.CREATE_OPER
     *
     * @mbg.generated Sat Dec 01 22:15:38 CST 2018
     */
    private String createOper;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table wf_module_port
     *
     * @mbg.generated Sat Dec 01 22:15:38 CST 2018
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_module_port.PORT_ID
     *
     * @return the value of wf_module_port.PORT_ID
     *
     * @mbg.generated Sat Dec 01 22:15:38 CST 2018
     */
    public Long getPortId() {
        return portId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_module_port.PORT_ID
     *
     * @param portId the value for wf_module_port.PORT_ID
     *
     * @mbg.generated Sat Dec 01 22:15:38 CST 2018
     */
    public void setPortId(Long portId) {
        this.portId = portId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_module_port.PORT_NAME
     *
     * @return the value of wf_module_port.PORT_NAME
     *
     * @mbg.generated Sat Dec 01 22:15:38 CST 2018
     */
    public String getPortName() {
        return portName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_module_port.PORT_NAME
     *
     * @param portName the value for wf_module_port.PORT_NAME
     *
     * @mbg.generated Sat Dec 01 22:15:38 CST 2018
     */
    public void setPortName(String portName) {
        this.portName = portName == null ? null : portName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_module_port.PORT_TYPE
     *
     * @return the value of wf_module_port.PORT_TYPE
     *
     * @mbg.generated Sat Dec 01 22:15:38 CST 2018
     */
    public Integer getPortType() {
        return portType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_module_port.PORT_TYPE
     *
     * @param portType the value for wf_module_port.PORT_TYPE
     *
     * @mbg.generated Sat Dec 01 22:15:38 CST 2018
     */
    public void setPortType(Integer portType) {
        this.portType = portType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_module_port.OWNER_MODULE_ID
     *
     * @return the value of wf_module_port.OWNER_MODULE_ID
     *
     * @mbg.generated Sat Dec 01 22:15:38 CST 2018
     */
    public Long getOwnerModuleId() {
        return ownerModuleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_module_port.OWNER_MODULE_ID
     *
     * @param ownerModuleId the value for wf_module_port.OWNER_MODULE_ID
     *
     * @mbg.generated Sat Dec 01 22:15:38 CST 2018
     */
    public void setOwnerModuleId(Long ownerModuleId) {
        this.ownerModuleId = ownerModuleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_module_port.BIND_CHAR_ID
     *
     * @return the value of wf_module_port.BIND_CHAR_ID
     *
     * @mbg.generated Sat Dec 01 22:15:38 CST 2018
     */
    public String getBindCharId() {
        return bindCharId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_module_port.BIND_CHAR_ID
     *
     * @param bindCharId the value for wf_module_port.BIND_CHAR_ID
     *
     * @mbg.generated Sat Dec 01 22:15:38 CST 2018
     */
    public void setBindCharId(String bindCharId) {
        this.bindCharId = bindCharId == null ? null : bindCharId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_module_port.SEQUENCE
     *
     * @return the value of wf_module_port.SEQUENCE
     *
     * @mbg.generated Sat Dec 01 22:15:38 CST 2018
     */
    public Integer getSequence() {
        return sequence;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_module_port.SEQUENCE
     *
     * @param sequence the value for wf_module_port.SEQUENCE
     *
     * @mbg.generated Sat Dec 01 22:15:38 CST 2018
     */
    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_module_port.DESCRIPTION
     *
     * @return the value of wf_module_port.DESCRIPTION
     *
     * @mbg.generated Sat Dec 01 22:15:38 CST 2018
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_module_port.DESCRIPTION
     *
     * @param description the value for wf_module_port.DESCRIPTION
     *
     * @mbg.generated Sat Dec 01 22:15:38 CST 2018
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_module_port.STATUS
     *
     * @return the value of wf_module_port.STATUS
     *
     * @mbg.generated Sat Dec 01 22:15:38 CST 2018
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_module_port.STATUS
     *
     * @param status the value for wf_module_port.STATUS
     *
     * @mbg.generated Sat Dec 01 22:15:38 CST 2018
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_module_port.LAST_UPDATE_TIME
     *
     * @return the value of wf_module_port.LAST_UPDATE_TIME
     *
     * @mbg.generated Sat Dec 01 22:15:38 CST 2018
     */
    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_module_port.LAST_UPDATE_TIME
     *
     * @param lastUpdateTime the value for wf_module_port.LAST_UPDATE_TIME
     *
     * @mbg.generated Sat Dec 01 22:15:38 CST 2018
     */
    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_module_port.LAST_UPDATE_OPER
     *
     * @return the value of wf_module_port.LAST_UPDATE_OPER
     *
     * @mbg.generated Sat Dec 01 22:15:38 CST 2018
     */
    public String getLastUpdateOper() {
        return lastUpdateOper;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_module_port.LAST_UPDATE_OPER
     *
     * @param lastUpdateOper the value for wf_module_port.LAST_UPDATE_OPER
     *
     * @mbg.generated Sat Dec 01 22:15:38 CST 2018
     */
    public void setLastUpdateOper(String lastUpdateOper) {
        this.lastUpdateOper = lastUpdateOper == null ? null : lastUpdateOper.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_module_port.CREATE_TIME
     *
     * @return the value of wf_module_port.CREATE_TIME
     *
     * @mbg.generated Sat Dec 01 22:15:38 CST 2018
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_module_port.CREATE_TIME
     *
     * @param createTime the value for wf_module_port.CREATE_TIME
     *
     * @mbg.generated Sat Dec 01 22:15:38 CST 2018
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_module_port.CREATE_OPER
     *
     * @return the value of wf_module_port.CREATE_OPER
     *
     * @mbg.generated Sat Dec 01 22:15:38 CST 2018
     */
    public String getCreateOper() {
        return createOper;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_module_port.CREATE_OPER
     *
     * @param createOper the value for wf_module_port.CREATE_OPER
     *
     * @mbg.generated Sat Dec 01 22:15:38 CST 2018
     */
    public void setCreateOper(String createOper) {
        this.createOper = createOper == null ? null : createOper.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_module_port
     *
     * @mbg.generated Sat Dec 01 22:15:38 CST 2018
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
        WfModulePort other = (WfModulePort) that;
        return (this.getPortId() == null ? other.getPortId() == null : this.getPortId().equals(other.getPortId()))
            && (this.getPortName() == null ? other.getPortName() == null : this.getPortName().equals(other.getPortName()))
            && (this.getPortType() == null ? other.getPortType() == null : this.getPortType().equals(other.getPortType()))
            && (this.getOwnerModuleId() == null ? other.getOwnerModuleId() == null : this.getOwnerModuleId().equals(other.getOwnerModuleId()))
            && (this.getBindCharId() == null ? other.getBindCharId() == null : this.getBindCharId().equals(other.getBindCharId()))
            && (this.getSequence() == null ? other.getSequence() == null : this.getSequence().equals(other.getSequence()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getLastUpdateTime() == null ? other.getLastUpdateTime() == null : this.getLastUpdateTime().equals(other.getLastUpdateTime()))
            && (this.getLastUpdateOper() == null ? other.getLastUpdateOper() == null : this.getLastUpdateOper().equals(other.getLastUpdateOper()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getCreateOper() == null ? other.getCreateOper() == null : this.getCreateOper().equals(other.getCreateOper()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_module_port
     *
     * @mbg.generated Sat Dec 01 22:15:38 CST 2018
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getPortId() == null) ? 0 : getPortId().hashCode());
        result = prime * result + ((getPortName() == null) ? 0 : getPortName().hashCode());
        result = prime * result + ((getPortType() == null) ? 0 : getPortType().hashCode());
        result = prime * result + ((getOwnerModuleId() == null) ? 0 : getOwnerModuleId().hashCode());
        result = prime * result + ((getBindCharId() == null) ? 0 : getBindCharId().hashCode());
        result = prime * result + ((getSequence() == null) ? 0 : getSequence().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getLastUpdateTime() == null) ? 0 : getLastUpdateTime().hashCode());
        result = prime * result + ((getLastUpdateOper() == null) ? 0 : getLastUpdateOper().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCreateOper() == null) ? 0 : getCreateOper().hashCode());
        return result;
    }
}