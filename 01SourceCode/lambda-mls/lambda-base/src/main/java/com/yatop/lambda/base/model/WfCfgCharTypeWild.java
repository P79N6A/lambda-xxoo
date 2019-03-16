package com.yatop.lambda.base.model;

import com.alibaba.fastjson.JSONObject;
import com.yatop.lambda.base.utils.LambdaRootModel;
import java.io.Serializable;
import java.util.Date;

public class WfCfgCharTypeWild extends LambdaRootModel implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_cfg_char_type_wild.DST_CHAR_TYPE_ID
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    private Integer dstCharTypeId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_cfg_char_type_wild.DST_CHAR_TYPE_ID:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    private boolean dstCharTypeIdColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_cfg_char_type_wild.SRC_CHAR_TYPE_ID
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    private Integer srcCharTypeId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_cfg_char_type_wild.SRC_CHAR_TYPE_ID:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    private boolean srcCharTypeIdColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_cfg_char_type_wild.DESCRIPTION
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    private String description;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_cfg_char_type_wild.DESCRIPTION:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    private boolean descriptionColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_cfg_char_type_wild.STATUS
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    private Integer status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_cfg_char_type_wild.STATUS:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    private boolean statusColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_cfg_char_type_wild.LAST_UPDATE_TIME
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    private Date lastUpdateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_cfg_char_type_wild.LAST_UPDATE_TIME:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    private boolean lastUpdateTimeColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_cfg_char_type_wild.LAST_UPDATE_OPER
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    private String lastUpdateOper;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_cfg_char_type_wild.LAST_UPDATE_OPER:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    private boolean lastUpdateOperColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_cfg_char_type_wild.CREATE_TIME
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_cfg_char_type_wild.CREATE_TIME:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    private boolean createTimeColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_cfg_char_type_wild.CREATE_OPER
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    private String createOper;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_cfg_char_type_wild.CREATE_OPER:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    private boolean createOperColoured;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table wf_cfg_char_type_wild
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_cfg_char_type_wild.DST_CHAR_TYPE_ID
     *
     * @return the value of wf_cfg_char_type_wild.DST_CHAR_TYPE_ID
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public Integer getDstCharTypeId() {
        return dstCharTypeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_cfg_char_type_wild.DST_CHAR_TYPE_ID:Coloured
     *
     * @return the value of wf_cfg_char_type_wild.DST_CHAR_TYPE_ID:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public boolean isDstCharTypeIdColoured() {
        return dstCharTypeIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_cfg_char_type_wild.DST_CHAR_TYPE_ID:Coloured
     *
     * @return the value of wf_cfg_char_type_wild.DST_CHAR_TYPE_ID:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public boolean isDstCharTypeIdNotColoured() {
        return !dstCharTypeIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_cfg_char_type_wild.DST_CHAR_TYPE_ID
     *
     * @param dstCharTypeId the value for wf_cfg_char_type_wild.DST_CHAR_TYPE_ID
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public void setDstCharTypeId(Integer dstCharTypeId) {
        this.dstCharTypeId = dstCharTypeId;
        this.dstCharTypeIdColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_cfg_char_type_wild.DST_CHAR_TYPE_ID:Coloured
     *
     * @param dstCharTypeIdColoured the value for wf_cfg_char_type_wild.DST_CHAR_TYPE_ID:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public void setDstCharTypeIdColoured(boolean dstCharTypeIdColoured) {
        this.dstCharTypeIdColoured = dstCharTypeIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_cfg_char_type_wild.SRC_CHAR_TYPE_ID
     *
     * @return the value of wf_cfg_char_type_wild.SRC_CHAR_TYPE_ID
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public Integer getSrcCharTypeId() {
        return srcCharTypeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_cfg_char_type_wild.SRC_CHAR_TYPE_ID:Coloured
     *
     * @return the value of wf_cfg_char_type_wild.SRC_CHAR_TYPE_ID:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public boolean isSrcCharTypeIdColoured() {
        return srcCharTypeIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_cfg_char_type_wild.SRC_CHAR_TYPE_ID:Coloured
     *
     * @return the value of wf_cfg_char_type_wild.SRC_CHAR_TYPE_ID:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public boolean isSrcCharTypeIdNotColoured() {
        return !srcCharTypeIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_cfg_char_type_wild.SRC_CHAR_TYPE_ID
     *
     * @param srcCharTypeId the value for wf_cfg_char_type_wild.SRC_CHAR_TYPE_ID
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public void setSrcCharTypeId(Integer srcCharTypeId) {
        this.srcCharTypeId = srcCharTypeId;
        this.srcCharTypeIdColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_cfg_char_type_wild.SRC_CHAR_TYPE_ID:Coloured
     *
     * @param srcCharTypeIdColoured the value for wf_cfg_char_type_wild.SRC_CHAR_TYPE_ID:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public void setSrcCharTypeIdColoured(boolean srcCharTypeIdColoured) {
        this.srcCharTypeIdColoured = srcCharTypeIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_cfg_char_type_wild.DESCRIPTION
     *
     * @return the value of wf_cfg_char_type_wild.DESCRIPTION
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_cfg_char_type_wild.DESCRIPTION:Coloured
     *
     * @return the value of wf_cfg_char_type_wild.DESCRIPTION:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public boolean isDescriptionColoured() {
        return descriptionColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_cfg_char_type_wild.DESCRIPTION:Coloured
     *
     * @return the value of wf_cfg_char_type_wild.DESCRIPTION:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public boolean isDescriptionNotColoured() {
        return !descriptionColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_cfg_char_type_wild.DESCRIPTION
     *
     * @param description the value for wf_cfg_char_type_wild.DESCRIPTION
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
        this.descriptionColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_cfg_char_type_wild.DESCRIPTION:Coloured
     *
     * @param descriptionColoured the value for wf_cfg_char_type_wild.DESCRIPTION:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public void setDescriptionColoured(boolean descriptionColoured) {
        this.descriptionColoured = descriptionColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_cfg_char_type_wild.STATUS
     *
     * @return the value of wf_cfg_char_type_wild.STATUS
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_cfg_char_type_wild.STATUS:Coloured
     *
     * @return the value of wf_cfg_char_type_wild.STATUS:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public boolean isStatusColoured() {
        return statusColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_cfg_char_type_wild.STATUS:Coloured
     *
     * @return the value of wf_cfg_char_type_wild.STATUS:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public boolean isStatusNotColoured() {
        return !statusColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_cfg_char_type_wild.STATUS
     *
     * @param status the value for wf_cfg_char_type_wild.STATUS
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public void setStatus(Integer status) {
        this.status = status;
        this.statusColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_cfg_char_type_wild.STATUS:Coloured
     *
     * @param statusColoured the value for wf_cfg_char_type_wild.STATUS:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public void setStatusColoured(boolean statusColoured) {
        this.statusColoured = statusColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_cfg_char_type_wild.LAST_UPDATE_TIME
     *
     * @return the value of wf_cfg_char_type_wild.LAST_UPDATE_TIME
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_cfg_char_type_wild.LAST_UPDATE_TIME:Coloured
     *
     * @return the value of wf_cfg_char_type_wild.LAST_UPDATE_TIME:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public boolean isLastUpdateTimeColoured() {
        return lastUpdateTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_cfg_char_type_wild.LAST_UPDATE_TIME:Coloured
     *
     * @return the value of wf_cfg_char_type_wild.LAST_UPDATE_TIME:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public boolean isLastUpdateTimeNotColoured() {
        return !lastUpdateTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_cfg_char_type_wild.LAST_UPDATE_TIME
     *
     * @param lastUpdateTime the value for wf_cfg_char_type_wild.LAST_UPDATE_TIME
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
        this.lastUpdateTimeColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_cfg_char_type_wild.LAST_UPDATE_TIME:Coloured
     *
     * @param lastUpdateTimeColoured the value for wf_cfg_char_type_wild.LAST_UPDATE_TIME:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public void setLastUpdateTimeColoured(boolean lastUpdateTimeColoured) {
        this.lastUpdateTimeColoured = lastUpdateTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_cfg_char_type_wild.LAST_UPDATE_OPER
     *
     * @return the value of wf_cfg_char_type_wild.LAST_UPDATE_OPER
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public String getLastUpdateOper() {
        return lastUpdateOper;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_cfg_char_type_wild.LAST_UPDATE_OPER:Coloured
     *
     * @return the value of wf_cfg_char_type_wild.LAST_UPDATE_OPER:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public boolean isLastUpdateOperColoured() {
        return lastUpdateOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_cfg_char_type_wild.LAST_UPDATE_OPER:Coloured
     *
     * @return the value of wf_cfg_char_type_wild.LAST_UPDATE_OPER:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public boolean isLastUpdateOperNotColoured() {
        return !lastUpdateOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_cfg_char_type_wild.LAST_UPDATE_OPER
     *
     * @param lastUpdateOper the value for wf_cfg_char_type_wild.LAST_UPDATE_OPER
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public void setLastUpdateOper(String lastUpdateOper) {
        this.lastUpdateOper = lastUpdateOper == null ? null : lastUpdateOper.trim();
        this.lastUpdateOperColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_cfg_char_type_wild.LAST_UPDATE_OPER:Coloured
     *
     * @param lastUpdateOperColoured the value for wf_cfg_char_type_wild.LAST_UPDATE_OPER:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public void setLastUpdateOperColoured(boolean lastUpdateOperColoured) {
        this.lastUpdateOperColoured = lastUpdateOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_cfg_char_type_wild.CREATE_TIME
     *
     * @return the value of wf_cfg_char_type_wild.CREATE_TIME
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_cfg_char_type_wild.CREATE_TIME:Coloured
     *
     * @return the value of wf_cfg_char_type_wild.CREATE_TIME:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public boolean isCreateTimeColoured() {
        return createTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_cfg_char_type_wild.CREATE_TIME:Coloured
     *
     * @return the value of wf_cfg_char_type_wild.CREATE_TIME:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public boolean isCreateTimeNotColoured() {
        return !createTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_cfg_char_type_wild.CREATE_TIME
     *
     * @param createTime the value for wf_cfg_char_type_wild.CREATE_TIME
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
        this.createTimeColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_cfg_char_type_wild.CREATE_TIME:Coloured
     *
     * @param createTimeColoured the value for wf_cfg_char_type_wild.CREATE_TIME:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public void setCreateTimeColoured(boolean createTimeColoured) {
        this.createTimeColoured = createTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_cfg_char_type_wild.CREATE_OPER
     *
     * @return the value of wf_cfg_char_type_wild.CREATE_OPER
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public String getCreateOper() {
        return createOper;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_cfg_char_type_wild.CREATE_OPER:Coloured
     *
     * @return the value of wf_cfg_char_type_wild.CREATE_OPER:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public boolean isCreateOperColoured() {
        return createOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_cfg_char_type_wild.CREATE_OPER:Coloured
     *
     * @return the value of wf_cfg_char_type_wild.CREATE_OPER:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public boolean isCreateOperNotColoured() {
        return !createOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_cfg_char_type_wild.CREATE_OPER
     *
     * @param createOper the value for wf_cfg_char_type_wild.CREATE_OPER
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public void setCreateOper(String createOper) {
        this.createOper = createOper == null ? null : createOper.trim();
        this.createOperColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_cfg_char_type_wild.CREATE_OPER:Coloured
     *
     * @param createOperColoured the value for wf_cfg_char_type_wild.CREATE_OPER:Coloured
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public void setCreateOperColoured(boolean createOperColoured) {
        this.createOperColoured = createOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_cfg_char_type_wild
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
        if(!(that instanceof WfCfgCharTypeWild)) {
            return false;
        }
        WfCfgCharTypeWild other = (WfCfgCharTypeWild) that;
        return (this.getDstCharTypeId() == null ? other.getDstCharTypeId() == null : this.getDstCharTypeId().equals(other.getDstCharTypeId()))
            && (this.getSrcCharTypeId() == null ? other.getSrcCharTypeId() == null : this.getSrcCharTypeId().equals(other.getSrcCharTypeId()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getLastUpdateTime() == null ? other.getLastUpdateTime() == null : this.getLastUpdateTime().equals(other.getLastUpdateTime()))
            && (this.getLastUpdateOper() == null ? other.getLastUpdateOper() == null : this.getLastUpdateOper().equals(other.getLastUpdateOper()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getCreateOper() == null ? other.getCreateOper() == null : this.getCreateOper().equals(other.getCreateOper()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_cfg_char_type_wild
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDstCharTypeId() == null) ? 0 : getDstCharTypeId().hashCode());
        result = prime * result + ((getSrcCharTypeId() == null) ? 0 : getSrcCharTypeId().hashCode());
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
     * This method corresponds to the database table wf_cfg_char_type_wild
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public void copyProperties(WfCfgCharTypeWild that) {
        if (this == that || that == null) {
            return;
        }
        if(that.isDstCharTypeIdColoured() ) {this.setDstCharTypeId(that.getDstCharTypeId() );}
        if(that.isSrcCharTypeIdColoured() ) {this.setSrcCharTypeId(that.getSrcCharTypeId() );}
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
     * This method corresponds to the database table wf_cfg_char_type_wild
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    public WfCfgCharTypeWild makeCopy() {
        WfCfgCharTypeWild copy = new WfCfgCharTypeWild();
        if(this.dstCharTypeId != null ) {copy.dstCharTypeId = this.dstCharTypeId;}
        if(this.srcCharTypeId != null ) {copy.srcCharTypeId = this.srcCharTypeId;}
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
     * This method corresponds to the database table wf_cfg_char_type_wild
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    @Override
    public JSONObject toJSON() {
        JSONObject jsonObj = new JSONObject(32, true);
        if(this.dstCharTypeId != null) {jsonObj.put("dstCharTypeId", this.dstCharTypeId);}
        if(this.srcCharTypeId != null) {jsonObj.put("srcCharTypeId", this.srcCharTypeId);}
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
     * This method corresponds to the database table wf_cfg_char_type_wild
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    @Override
    public void clear() {
         this.dstCharTypeId = null; this.dstCharTypeIdColoured = false;
         this.srcCharTypeId = null; this.srcCharTypeIdColoured = false;
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
     * This method corresponds to the database table wf_cfg_char_type_wild
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    @Override
    public void clearColoured() {
        this.dstCharTypeIdColoured = false;
        this.srcCharTypeIdColoured = false;
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
     * This method corresponds to the database table wf_cfg_char_type_wild
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    @Override
    public boolean isColoured() {
        if(this.dstCharTypeIdColoured) return true;
        if(this.srcCharTypeIdColoured) return true;
        if(this.descriptionColoured) return true;
        if(this.statusColoured) return true;
        if(this.lastUpdateTimeColoured) return true;
        if(this.lastUpdateOperColoured) return true;
        if(this.createTimeColoured) return true;
        if(this.createOperColoured) return true;
        return false;
    }
}