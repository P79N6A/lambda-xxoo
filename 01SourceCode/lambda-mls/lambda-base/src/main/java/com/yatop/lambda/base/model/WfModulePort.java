package com.yatop.lambda.base.model;

import com.alibaba.fastjson.JSONObject;
import com.yatop.lambda.base.utils.LambdaRootModel;
import java.io.Serializable;
import java.util.Date;

public class WfModulePort extends LambdaRootModel implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_module_port.PORT_ID
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    private Long portId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_module_port.PORT_ID:Coloured
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    private boolean portIdColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_module_port.PORT_NAME
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    private String portName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_module_port.PORT_NAME:Coloured
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    private boolean portNameColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_module_port.PORT_TYPE
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    private Integer portType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_module_port.PORT_TYPE:Coloured
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    private boolean portTypeColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_module_port.OWNER_MODULE_ID
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    private Long ownerModuleId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_module_port.OWNER_MODULE_ID:Coloured
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    private boolean ownerModuleIdColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_module_port.BIND_CHAR_ID
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    private String bindCharId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_module_port.BIND_CHAR_ID:Coloured
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    private boolean bindCharIdColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_module_port.SEQUENCE
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    private Integer sequence;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_module_port.SEQUENCE:Coloured
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    private boolean sequenceColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_module_port.DESCRIPTION
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    private String description;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_module_port.DESCRIPTION:Coloured
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    private boolean descriptionColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_module_port.STATUS
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    private Integer status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_module_port.STATUS:Coloured
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    private boolean statusColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_module_port.LAST_UPDATE_TIME
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    private Date lastUpdateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_module_port.LAST_UPDATE_TIME:Coloured
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    private boolean lastUpdateTimeColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_module_port.LAST_UPDATE_OPER
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    private String lastUpdateOper;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_module_port.LAST_UPDATE_OPER:Coloured
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    private boolean lastUpdateOperColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_module_port.CREATE_TIME
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_module_port.CREATE_TIME:Coloured
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    private boolean createTimeColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_module_port.CREATE_OPER
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    private String createOper;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_module_port.CREATE_OPER:Coloured
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    private boolean createOperColoured;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table wf_module_port
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_module_port.PORT_ID
     *
     * @return the value of wf_module_port.PORT_ID
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    public Long getPortId() {
        return portId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_module_port.PORT_ID:Coloured
     *
     * @return the value of wf_module_port.PORT_ID:Coloured
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    public boolean isPortIdColoured() {
        return portIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_module_port.PORT_ID:Coloured
     *
     * @return the value of wf_module_port.PORT_ID:Coloured
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    public boolean isPortIdNotColoured() {
        return !portIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_module_port.PORT_ID
     *
     * @param portId the value for wf_module_port.PORT_ID
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    public void setPortId(Long portId) {
        this.portId = portId;
        this.portIdColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_module_port.PORT_ID:Coloured
     *
     * @param portIdColoured the value for wf_module_port.PORT_ID:Coloured
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    public void setPortIdColoured(boolean portIdColoured) {
        this.portIdColoured = portIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_module_port.PORT_NAME
     *
     * @return the value of wf_module_port.PORT_NAME
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    public String getPortName() {
        return portName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_module_port.PORT_NAME:Coloured
     *
     * @return the value of wf_module_port.PORT_NAME:Coloured
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    public boolean isPortNameColoured() {
        return portNameColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_module_port.PORT_NAME:Coloured
     *
     * @return the value of wf_module_port.PORT_NAME:Coloured
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    public boolean isPortNameNotColoured() {
        return !portNameColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_module_port.PORT_NAME
     *
     * @param portName the value for wf_module_port.PORT_NAME
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    public void setPortName(String portName) {
        this.portName = portName == null ? null : portName.trim();
        this.portNameColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_module_port.PORT_NAME:Coloured
     *
     * @param portNameColoured the value for wf_module_port.PORT_NAME:Coloured
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    public void setPortNameColoured(boolean portNameColoured) {
        this.portNameColoured = portNameColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_module_port.PORT_TYPE
     *
     * @return the value of wf_module_port.PORT_TYPE
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    public Integer getPortType() {
        return portType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_module_port.PORT_TYPE:Coloured
     *
     * @return the value of wf_module_port.PORT_TYPE:Coloured
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    public boolean isPortTypeColoured() {
        return portTypeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_module_port.PORT_TYPE:Coloured
     *
     * @return the value of wf_module_port.PORT_TYPE:Coloured
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    public boolean isPortTypeNotColoured() {
        return !portTypeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_module_port.PORT_TYPE
     *
     * @param portType the value for wf_module_port.PORT_TYPE
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    public void setPortType(Integer portType) {
        this.portType = portType;
        this.portTypeColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_module_port.PORT_TYPE:Coloured
     *
     * @param portTypeColoured the value for wf_module_port.PORT_TYPE:Coloured
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    public void setPortTypeColoured(boolean portTypeColoured) {
        this.portTypeColoured = portTypeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_module_port.OWNER_MODULE_ID
     *
     * @return the value of wf_module_port.OWNER_MODULE_ID
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    public Long getOwnerModuleId() {
        return ownerModuleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_module_port.OWNER_MODULE_ID:Coloured
     *
     * @return the value of wf_module_port.OWNER_MODULE_ID:Coloured
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    public boolean isOwnerModuleIdColoured() {
        return ownerModuleIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_module_port.OWNER_MODULE_ID:Coloured
     *
     * @return the value of wf_module_port.OWNER_MODULE_ID:Coloured
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    public boolean isOwnerModuleIdNotColoured() {
        return !ownerModuleIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_module_port.OWNER_MODULE_ID
     *
     * @param ownerModuleId the value for wf_module_port.OWNER_MODULE_ID
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    public void setOwnerModuleId(Long ownerModuleId) {
        this.ownerModuleId = ownerModuleId;
        this.ownerModuleIdColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_module_port.OWNER_MODULE_ID:Coloured
     *
     * @param ownerModuleIdColoured the value for wf_module_port.OWNER_MODULE_ID:Coloured
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    public void setOwnerModuleIdColoured(boolean ownerModuleIdColoured) {
        this.ownerModuleIdColoured = ownerModuleIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_module_port.BIND_CHAR_ID
     *
     * @return the value of wf_module_port.BIND_CHAR_ID
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    public String getBindCharId() {
        return bindCharId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_module_port.BIND_CHAR_ID:Coloured
     *
     * @return the value of wf_module_port.BIND_CHAR_ID:Coloured
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    public boolean isBindCharIdColoured() {
        return bindCharIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_module_port.BIND_CHAR_ID:Coloured
     *
     * @return the value of wf_module_port.BIND_CHAR_ID:Coloured
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    public boolean isBindCharIdNotColoured() {
        return !bindCharIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_module_port.BIND_CHAR_ID
     *
     * @param bindCharId the value for wf_module_port.BIND_CHAR_ID
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    public void setBindCharId(String bindCharId) {
        this.bindCharId = bindCharId == null ? null : bindCharId.trim();
        this.bindCharIdColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_module_port.BIND_CHAR_ID:Coloured
     *
     * @param bindCharIdColoured the value for wf_module_port.BIND_CHAR_ID:Coloured
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    public void setBindCharIdColoured(boolean bindCharIdColoured) {
        this.bindCharIdColoured = bindCharIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_module_port.SEQUENCE
     *
     * @return the value of wf_module_port.SEQUENCE
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    public Integer getSequence() {
        return sequence;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_module_port.SEQUENCE:Coloured
     *
     * @return the value of wf_module_port.SEQUENCE:Coloured
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    public boolean isSequenceColoured() {
        return sequenceColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_module_port.SEQUENCE:Coloured
     *
     * @return the value of wf_module_port.SEQUENCE:Coloured
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    public boolean isSequenceNotColoured() {
        return !sequenceColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_module_port.SEQUENCE
     *
     * @param sequence the value for wf_module_port.SEQUENCE
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    public void setSequence(Integer sequence) {
        this.sequence = sequence;
        this.sequenceColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_module_port.SEQUENCE:Coloured
     *
     * @param sequenceColoured the value for wf_module_port.SEQUENCE:Coloured
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    public void setSequenceColoured(boolean sequenceColoured) {
        this.sequenceColoured = sequenceColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_module_port.DESCRIPTION
     *
     * @return the value of wf_module_port.DESCRIPTION
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_module_port.DESCRIPTION:Coloured
     *
     * @return the value of wf_module_port.DESCRIPTION:Coloured
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    public boolean isDescriptionColoured() {
        return descriptionColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_module_port.DESCRIPTION:Coloured
     *
     * @return the value of wf_module_port.DESCRIPTION:Coloured
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    public boolean isDescriptionNotColoured() {
        return !descriptionColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_module_port.DESCRIPTION
     *
     * @param description the value for wf_module_port.DESCRIPTION
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
        this.descriptionColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_module_port.DESCRIPTION:Coloured
     *
     * @param descriptionColoured the value for wf_module_port.DESCRIPTION:Coloured
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    public void setDescriptionColoured(boolean descriptionColoured) {
        this.descriptionColoured = descriptionColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_module_port.STATUS
     *
     * @return the value of wf_module_port.STATUS
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_module_port.STATUS:Coloured
     *
     * @return the value of wf_module_port.STATUS:Coloured
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    public boolean isStatusColoured() {
        return statusColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_module_port.STATUS:Coloured
     *
     * @return the value of wf_module_port.STATUS:Coloured
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    public boolean isStatusNotColoured() {
        return !statusColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_module_port.STATUS
     *
     * @param status the value for wf_module_port.STATUS
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    public void setStatus(Integer status) {
        this.status = status;
        this.statusColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_module_port.STATUS:Coloured
     *
     * @param statusColoured the value for wf_module_port.STATUS:Coloured
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    public void setStatusColoured(boolean statusColoured) {
        this.statusColoured = statusColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_module_port.LAST_UPDATE_TIME
     *
     * @return the value of wf_module_port.LAST_UPDATE_TIME
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_module_port.LAST_UPDATE_TIME:Coloured
     *
     * @return the value of wf_module_port.LAST_UPDATE_TIME:Coloured
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    public boolean isLastUpdateTimeColoured() {
        return lastUpdateTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_module_port.LAST_UPDATE_TIME:Coloured
     *
     * @return the value of wf_module_port.LAST_UPDATE_TIME:Coloured
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    public boolean isLastUpdateTimeNotColoured() {
        return !lastUpdateTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_module_port.LAST_UPDATE_TIME
     *
     * @param lastUpdateTime the value for wf_module_port.LAST_UPDATE_TIME
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
        this.lastUpdateTimeColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_module_port.LAST_UPDATE_TIME:Coloured
     *
     * @param lastUpdateTimeColoured the value for wf_module_port.LAST_UPDATE_TIME:Coloured
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    public void setLastUpdateTimeColoured(boolean lastUpdateTimeColoured) {
        this.lastUpdateTimeColoured = lastUpdateTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_module_port.LAST_UPDATE_OPER
     *
     * @return the value of wf_module_port.LAST_UPDATE_OPER
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    public String getLastUpdateOper() {
        return lastUpdateOper;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_module_port.LAST_UPDATE_OPER:Coloured
     *
     * @return the value of wf_module_port.LAST_UPDATE_OPER:Coloured
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    public boolean isLastUpdateOperColoured() {
        return lastUpdateOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_module_port.LAST_UPDATE_OPER:Coloured
     *
     * @return the value of wf_module_port.LAST_UPDATE_OPER:Coloured
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    public boolean isLastUpdateOperNotColoured() {
        return !lastUpdateOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_module_port.LAST_UPDATE_OPER
     *
     * @param lastUpdateOper the value for wf_module_port.LAST_UPDATE_OPER
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    public void setLastUpdateOper(String lastUpdateOper) {
        this.lastUpdateOper = lastUpdateOper == null ? null : lastUpdateOper.trim();
        this.lastUpdateOperColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_module_port.LAST_UPDATE_OPER:Coloured
     *
     * @param lastUpdateOperColoured the value for wf_module_port.LAST_UPDATE_OPER:Coloured
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    public void setLastUpdateOperColoured(boolean lastUpdateOperColoured) {
        this.lastUpdateOperColoured = lastUpdateOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_module_port.CREATE_TIME
     *
     * @return the value of wf_module_port.CREATE_TIME
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_module_port.CREATE_TIME:Coloured
     *
     * @return the value of wf_module_port.CREATE_TIME:Coloured
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    public boolean isCreateTimeColoured() {
        return createTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_module_port.CREATE_TIME:Coloured
     *
     * @return the value of wf_module_port.CREATE_TIME:Coloured
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    public boolean isCreateTimeNotColoured() {
        return !createTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_module_port.CREATE_TIME
     *
     * @param createTime the value for wf_module_port.CREATE_TIME
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
        this.createTimeColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_module_port.CREATE_TIME:Coloured
     *
     * @param createTimeColoured the value for wf_module_port.CREATE_TIME:Coloured
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    public void setCreateTimeColoured(boolean createTimeColoured) {
        this.createTimeColoured = createTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_module_port.CREATE_OPER
     *
     * @return the value of wf_module_port.CREATE_OPER
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    public String getCreateOper() {
        return createOper;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_module_port.CREATE_OPER:Coloured
     *
     * @return the value of wf_module_port.CREATE_OPER:Coloured
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    public boolean isCreateOperColoured() {
        return createOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_module_port.CREATE_OPER:Coloured
     *
     * @return the value of wf_module_port.CREATE_OPER:Coloured
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    public boolean isCreateOperNotColoured() {
        return !createOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_module_port.CREATE_OPER
     *
     * @param createOper the value for wf_module_port.CREATE_OPER
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    public void setCreateOper(String createOper) {
        this.createOper = createOper == null ? null : createOper.trim();
        this.createOperColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_module_port.CREATE_OPER:Coloured
     *
     * @param createOperColoured the value for wf_module_port.CREATE_OPER:Coloured
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    public void setCreateOperColoured(boolean createOperColoured) {
        this.createOperColoured = createOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_module_port
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if(!(that instanceof WfModulePort)) {
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
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
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

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_module_port
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    public void copyProperties(WfModulePort that) {
        if (this == that || that == null) {
            return;
        }
        if(that.isPortIdColoured() ) {this.setPortId(that.getPortId() );}
        if(that.isPortNameColoured() ) {this.setPortName(that.getPortName() );}
        if(that.isPortTypeColoured() ) {this.setPortType(that.getPortType() );}
        if(that.isOwnerModuleIdColoured() ) {this.setOwnerModuleId(that.getOwnerModuleId() );}
        if(that.isBindCharIdColoured() ) {this.setBindCharId(that.getBindCharId() );}
        if(that.isSequenceColoured() ) {this.setSequence(that.getSequence() );}
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
     * This method corresponds to the database table wf_module_port
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    @Override
    public JSONObject toJSON() {
        JSONObject jsonObj = new JSONObject(32, true);
        if(this.portId != null) {jsonObj.put("portId", this.portId);}
        if(this.portName != null) {jsonObj.put("portName", this.portName);}
        if(this.portType != null) {jsonObj.put("portType", this.portType);}
        if(this.ownerModuleId != null) {jsonObj.put("ownerModuleId", this.ownerModuleId);}
        if(this.bindCharId != null) {jsonObj.put("bindCharId", this.bindCharId);}
        if(this.sequence != null) {jsonObj.put("sequence", this.sequence);}
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
     * This method corresponds to the database table wf_module_port
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    @Override
    public void clear() {
         this.portId = null; this.portIdColoured = false;
         this.portName = null; this.portNameColoured = false;
         this.portType = null; this.portTypeColoured = false;
         this.ownerModuleId = null; this.ownerModuleIdColoured = false;
         this.bindCharId = null; this.bindCharIdColoured = false;
         this.sequence = null; this.sequenceColoured = false;
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
     * This method corresponds to the database table wf_module_port
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    @Override
    public void clearColoured() {
        this.portIdColoured = false;
        this.portNameColoured = false;
        this.portTypeColoured = false;
        this.ownerModuleIdColoured = false;
        this.bindCharIdColoured = false;
        this.sequenceColoured = false;
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
     * This method corresponds to the database table wf_module_port
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    @Override
    public boolean isColoured() {
        if(this.portIdColoured) return true;
        if(this.portNameColoured) return true;
        if(this.portTypeColoured) return true;
        if(this.ownerModuleIdColoured) return true;
        if(this.bindCharIdColoured) return true;
        if(this.sequenceColoured) return true;
        if(this.descriptionColoured) return true;
        if(this.statusColoured) return true;
        if(this.lastUpdateTimeColoured) return true;
        if(this.lastUpdateOperColoured) return true;
        if(this.createTimeColoured) return true;
        if(this.createOperColoured) return true;
        return false;
    }
}