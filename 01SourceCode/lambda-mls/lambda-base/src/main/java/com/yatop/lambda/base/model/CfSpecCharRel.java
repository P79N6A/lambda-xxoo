package com.yatop.lambda.base.model;

import com.alibaba.fastjson.JSONObject;
import com.yatop.lambda.base.utils.LambdaRootModel;
import java.io.Serializable;
import java.util.Date;

public class CfSpecCharRel extends LambdaRootModel implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_spec_char_rel.SPEC_ID
     *
     * @mbg.generated Sat Mar 02 13:34:42 CST 2019
     */
    private String specId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_spec_char_rel.SPEC_ID:Coloured
     *
     * @mbg.generated Sat Mar 02 13:34:42 CST 2019
     */
    private boolean specIdColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_spec_char_rel.CHAR_ID
     *
     * @mbg.generated Sat Mar 02 13:34:42 CST 2019
     */
    private String charId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_spec_char_rel.CHAR_ID:Coloured
     *
     * @mbg.generated Sat Mar 02 13:34:42 CST 2019
     */
    private boolean charIdColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_spec_char_rel.DESCRIPTION
     *
     * @mbg.generated Sat Mar 02 13:34:42 CST 2019
     */
    private String description;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_spec_char_rel.DESCRIPTION:Coloured
     *
     * @mbg.generated Sat Mar 02 13:34:42 CST 2019
     */
    private boolean descriptionColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_spec_char_rel.STATUS
     *
     * @mbg.generated Sat Mar 02 13:34:42 CST 2019
     */
    private Integer status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_spec_char_rel.STATUS:Coloured
     *
     * @mbg.generated Sat Mar 02 13:34:42 CST 2019
     */
    private boolean statusColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_spec_char_rel.LAST_UPDATE_TIME
     *
     * @mbg.generated Sat Mar 02 13:34:42 CST 2019
     */
    private Date lastUpdateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_spec_char_rel.LAST_UPDATE_TIME:Coloured
     *
     * @mbg.generated Sat Mar 02 13:34:42 CST 2019
     */
    private boolean lastUpdateTimeColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_spec_char_rel.LAST_UPDATE_OPER
     *
     * @mbg.generated Sat Mar 02 13:34:42 CST 2019
     */
    private String lastUpdateOper;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_spec_char_rel.LAST_UPDATE_OPER:Coloured
     *
     * @mbg.generated Sat Mar 02 13:34:42 CST 2019
     */
    private boolean lastUpdateOperColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_spec_char_rel.CREATE_TIME
     *
     * @mbg.generated Sat Mar 02 13:34:42 CST 2019
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_spec_char_rel.CREATE_TIME:Coloured
     *
     * @mbg.generated Sat Mar 02 13:34:42 CST 2019
     */
    private boolean createTimeColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_spec_char_rel.CREATE_OPER
     *
     * @mbg.generated Sat Mar 02 13:34:42 CST 2019
     */
    private String createOper;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_spec_char_rel.CREATE_OPER:Coloured
     *
     * @mbg.generated Sat Mar 02 13:34:42 CST 2019
     */
    private boolean createOperColoured;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table cf_spec_char_rel
     *
     * @mbg.generated Sat Mar 02 13:34:42 CST 2019
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_spec_char_rel.SPEC_ID
     *
     * @return the value of cf_spec_char_rel.SPEC_ID
     *
     * @mbg.generated Sat Mar 02 13:34:42 CST 2019
     */
    public String getSpecId() {
        return specId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_spec_char_rel.SPEC_ID:Coloured
     *
     * @return the value of cf_spec_char_rel.SPEC_ID:Coloured
     *
     * @mbg.generated Sat Mar 02 13:34:42 CST 2019
     */
    public boolean isSpecIdColoured() {
        return specIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_spec_char_rel.SPEC_ID:Coloured
     *
     * @return the value of cf_spec_char_rel.SPEC_ID:Coloured
     *
     * @mbg.generated Sat Mar 02 13:34:42 CST 2019
     */
    public boolean isSpecIdNotColoured() {
        return !specIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cf_spec_char_rel.SPEC_ID
     *
     * @param specId the value for cf_spec_char_rel.SPEC_ID
     *
     * @mbg.generated Sat Mar 02 13:34:42 CST 2019
     */
    public void setSpecId(String specId) {
        this.specId = specId == null ? null : specId.trim();
        this.specIdColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cf_spec_char_rel.SPEC_ID:Coloured
     *
     * @param specIdColoured the value for cf_spec_char_rel.SPEC_ID:Coloured
     *
     * @mbg.generated Sat Mar 02 13:34:42 CST 2019
     */
    public void setSpecIdColoured(boolean specIdColoured) {
        this.specIdColoured = specIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_spec_char_rel.CHAR_ID
     *
     * @return the value of cf_spec_char_rel.CHAR_ID
     *
     * @mbg.generated Sat Mar 02 13:34:42 CST 2019
     */
    public String getCharId() {
        return charId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_spec_char_rel.CHAR_ID:Coloured
     *
     * @return the value of cf_spec_char_rel.CHAR_ID:Coloured
     *
     * @mbg.generated Sat Mar 02 13:34:42 CST 2019
     */
    public boolean isCharIdColoured() {
        return charIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_spec_char_rel.CHAR_ID:Coloured
     *
     * @return the value of cf_spec_char_rel.CHAR_ID:Coloured
     *
     * @mbg.generated Sat Mar 02 13:34:42 CST 2019
     */
    public boolean isCharIdNotColoured() {
        return !charIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cf_spec_char_rel.CHAR_ID
     *
     * @param charId the value for cf_spec_char_rel.CHAR_ID
     *
     * @mbg.generated Sat Mar 02 13:34:42 CST 2019
     */
    public void setCharId(String charId) {
        this.charId = charId == null ? null : charId.trim();
        this.charIdColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cf_spec_char_rel.CHAR_ID:Coloured
     *
     * @param charIdColoured the value for cf_spec_char_rel.CHAR_ID:Coloured
     *
     * @mbg.generated Sat Mar 02 13:34:42 CST 2019
     */
    public void setCharIdColoured(boolean charIdColoured) {
        this.charIdColoured = charIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_spec_char_rel.DESCRIPTION
     *
     * @return the value of cf_spec_char_rel.DESCRIPTION
     *
     * @mbg.generated Sat Mar 02 13:34:42 CST 2019
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_spec_char_rel.DESCRIPTION:Coloured
     *
     * @return the value of cf_spec_char_rel.DESCRIPTION:Coloured
     *
     * @mbg.generated Sat Mar 02 13:34:42 CST 2019
     */
    public boolean isDescriptionColoured() {
        return descriptionColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_spec_char_rel.DESCRIPTION:Coloured
     *
     * @return the value of cf_spec_char_rel.DESCRIPTION:Coloured
     *
     * @mbg.generated Sat Mar 02 13:34:42 CST 2019
     */
    public boolean isDescriptionNotColoured() {
        return !descriptionColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cf_spec_char_rel.DESCRIPTION
     *
     * @param description the value for cf_spec_char_rel.DESCRIPTION
     *
     * @mbg.generated Sat Mar 02 13:34:42 CST 2019
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
        this.descriptionColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cf_spec_char_rel.DESCRIPTION:Coloured
     *
     * @param descriptionColoured the value for cf_spec_char_rel.DESCRIPTION:Coloured
     *
     * @mbg.generated Sat Mar 02 13:34:42 CST 2019
     */
    public void setDescriptionColoured(boolean descriptionColoured) {
        this.descriptionColoured = descriptionColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_spec_char_rel.STATUS
     *
     * @return the value of cf_spec_char_rel.STATUS
     *
     * @mbg.generated Sat Mar 02 13:34:42 CST 2019
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_spec_char_rel.STATUS:Coloured
     *
     * @return the value of cf_spec_char_rel.STATUS:Coloured
     *
     * @mbg.generated Sat Mar 02 13:34:42 CST 2019
     */
    public boolean isStatusColoured() {
        return statusColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_spec_char_rel.STATUS:Coloured
     *
     * @return the value of cf_spec_char_rel.STATUS:Coloured
     *
     * @mbg.generated Sat Mar 02 13:34:42 CST 2019
     */
    public boolean isStatusNotColoured() {
        return !statusColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cf_spec_char_rel.STATUS
     *
     * @param status the value for cf_spec_char_rel.STATUS
     *
     * @mbg.generated Sat Mar 02 13:34:42 CST 2019
     */
    public void setStatus(Integer status) {
        this.status = status;
        this.statusColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cf_spec_char_rel.STATUS:Coloured
     *
     * @param statusColoured the value for cf_spec_char_rel.STATUS:Coloured
     *
     * @mbg.generated Sat Mar 02 13:34:42 CST 2019
     */
    public void setStatusColoured(boolean statusColoured) {
        this.statusColoured = statusColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_spec_char_rel.LAST_UPDATE_TIME
     *
     * @return the value of cf_spec_char_rel.LAST_UPDATE_TIME
     *
     * @mbg.generated Sat Mar 02 13:34:42 CST 2019
     */
    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_spec_char_rel.LAST_UPDATE_TIME:Coloured
     *
     * @return the value of cf_spec_char_rel.LAST_UPDATE_TIME:Coloured
     *
     * @mbg.generated Sat Mar 02 13:34:42 CST 2019
     */
    public boolean isLastUpdateTimeColoured() {
        return lastUpdateTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_spec_char_rel.LAST_UPDATE_TIME:Coloured
     *
     * @return the value of cf_spec_char_rel.LAST_UPDATE_TIME:Coloured
     *
     * @mbg.generated Sat Mar 02 13:34:42 CST 2019
     */
    public boolean isLastUpdateTimeNotColoured() {
        return !lastUpdateTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cf_spec_char_rel.LAST_UPDATE_TIME
     *
     * @param lastUpdateTime the value for cf_spec_char_rel.LAST_UPDATE_TIME
     *
     * @mbg.generated Sat Mar 02 13:34:42 CST 2019
     */
    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
        this.lastUpdateTimeColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cf_spec_char_rel.LAST_UPDATE_TIME:Coloured
     *
     * @param lastUpdateTimeColoured the value for cf_spec_char_rel.LAST_UPDATE_TIME:Coloured
     *
     * @mbg.generated Sat Mar 02 13:34:42 CST 2019
     */
    public void setLastUpdateTimeColoured(boolean lastUpdateTimeColoured) {
        this.lastUpdateTimeColoured = lastUpdateTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_spec_char_rel.LAST_UPDATE_OPER
     *
     * @return the value of cf_spec_char_rel.LAST_UPDATE_OPER
     *
     * @mbg.generated Sat Mar 02 13:34:42 CST 2019
     */
    public String getLastUpdateOper() {
        return lastUpdateOper;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_spec_char_rel.LAST_UPDATE_OPER:Coloured
     *
     * @return the value of cf_spec_char_rel.LAST_UPDATE_OPER:Coloured
     *
     * @mbg.generated Sat Mar 02 13:34:42 CST 2019
     */
    public boolean isLastUpdateOperColoured() {
        return lastUpdateOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_spec_char_rel.LAST_UPDATE_OPER:Coloured
     *
     * @return the value of cf_spec_char_rel.LAST_UPDATE_OPER:Coloured
     *
     * @mbg.generated Sat Mar 02 13:34:42 CST 2019
     */
    public boolean isLastUpdateOperNotColoured() {
        return !lastUpdateOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cf_spec_char_rel.LAST_UPDATE_OPER
     *
     * @param lastUpdateOper the value for cf_spec_char_rel.LAST_UPDATE_OPER
     *
     * @mbg.generated Sat Mar 02 13:34:42 CST 2019
     */
    public void setLastUpdateOper(String lastUpdateOper) {
        this.lastUpdateOper = lastUpdateOper == null ? null : lastUpdateOper.trim();
        this.lastUpdateOperColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cf_spec_char_rel.LAST_UPDATE_OPER:Coloured
     *
     * @param lastUpdateOperColoured the value for cf_spec_char_rel.LAST_UPDATE_OPER:Coloured
     *
     * @mbg.generated Sat Mar 02 13:34:42 CST 2019
     */
    public void setLastUpdateOperColoured(boolean lastUpdateOperColoured) {
        this.lastUpdateOperColoured = lastUpdateOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_spec_char_rel.CREATE_TIME
     *
     * @return the value of cf_spec_char_rel.CREATE_TIME
     *
     * @mbg.generated Sat Mar 02 13:34:42 CST 2019
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_spec_char_rel.CREATE_TIME:Coloured
     *
     * @return the value of cf_spec_char_rel.CREATE_TIME:Coloured
     *
     * @mbg.generated Sat Mar 02 13:34:42 CST 2019
     */
    public boolean isCreateTimeColoured() {
        return createTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_spec_char_rel.CREATE_TIME:Coloured
     *
     * @return the value of cf_spec_char_rel.CREATE_TIME:Coloured
     *
     * @mbg.generated Sat Mar 02 13:34:42 CST 2019
     */
    public boolean isCreateTimeNotColoured() {
        return !createTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cf_spec_char_rel.CREATE_TIME
     *
     * @param createTime the value for cf_spec_char_rel.CREATE_TIME
     *
     * @mbg.generated Sat Mar 02 13:34:42 CST 2019
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
        this.createTimeColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cf_spec_char_rel.CREATE_TIME:Coloured
     *
     * @param createTimeColoured the value for cf_spec_char_rel.CREATE_TIME:Coloured
     *
     * @mbg.generated Sat Mar 02 13:34:42 CST 2019
     */
    public void setCreateTimeColoured(boolean createTimeColoured) {
        this.createTimeColoured = createTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_spec_char_rel.CREATE_OPER
     *
     * @return the value of cf_spec_char_rel.CREATE_OPER
     *
     * @mbg.generated Sat Mar 02 13:34:42 CST 2019
     */
    public String getCreateOper() {
        return createOper;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_spec_char_rel.CREATE_OPER:Coloured
     *
     * @return the value of cf_spec_char_rel.CREATE_OPER:Coloured
     *
     * @mbg.generated Sat Mar 02 13:34:42 CST 2019
     */
    public boolean isCreateOperColoured() {
        return createOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_spec_char_rel.CREATE_OPER:Coloured
     *
     * @return the value of cf_spec_char_rel.CREATE_OPER:Coloured
     *
     * @mbg.generated Sat Mar 02 13:34:42 CST 2019
     */
    public boolean isCreateOperNotColoured() {
        return !createOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cf_spec_char_rel.CREATE_OPER
     *
     * @param createOper the value for cf_spec_char_rel.CREATE_OPER
     *
     * @mbg.generated Sat Mar 02 13:34:42 CST 2019
     */
    public void setCreateOper(String createOper) {
        this.createOper = createOper == null ? null : createOper.trim();
        this.createOperColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cf_spec_char_rel.CREATE_OPER:Coloured
     *
     * @param createOperColoured the value for cf_spec_char_rel.CREATE_OPER:Coloured
     *
     * @mbg.generated Sat Mar 02 13:34:42 CST 2019
     */
    public void setCreateOperColoured(boolean createOperColoured) {
        this.createOperColoured = createOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_spec_char_rel
     *
     * @mbg.generated Sat Mar 02 13:34:42 CST 2019
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if(!(that instanceof CfSpecCharRel)) {
            return false;
        }
        CfSpecCharRel other = (CfSpecCharRel) that;
        return (this.getSpecId() == null ? other.getSpecId() == null : this.getSpecId().equals(other.getSpecId()))
            && (this.getCharId() == null ? other.getCharId() == null : this.getCharId().equals(other.getCharId()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getLastUpdateTime() == null ? other.getLastUpdateTime() == null : this.getLastUpdateTime().equals(other.getLastUpdateTime()))
            && (this.getLastUpdateOper() == null ? other.getLastUpdateOper() == null : this.getLastUpdateOper().equals(other.getLastUpdateOper()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getCreateOper() == null ? other.getCreateOper() == null : this.getCreateOper().equals(other.getCreateOper()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_spec_char_rel
     *
     * @mbg.generated Sat Mar 02 13:34:42 CST 2019
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getSpecId() == null) ? 0 : getSpecId().hashCode());
        result = prime * result + ((getCharId() == null) ? 0 : getCharId().hashCode());
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
     * This method corresponds to the database table cf_spec_char_rel
     *
     * @mbg.generated Sat Mar 02 13:34:42 CST 2019
     */
    public void copyProperties(CfSpecCharRel that) {
        if (this == that || that == null) {
            return;
        }
        if(that.isSpecIdColoured() ) {this.setSpecId(that.getSpecId() );}
        if(that.isCharIdColoured() ) {this.setCharId(that.getCharId() );}
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
     * This method corresponds to the database table cf_spec_char_rel
     *
     * @mbg.generated Sat Mar 02 13:34:42 CST 2019
     */
    public CfSpecCharRel makeCopy() {
        CfSpecCharRel copy = new CfSpecCharRel();
        if(this.specId != null ) {copy.specId = this.specId;}
        if(this.charId != null ) {copy.charId = this.charId;}
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
     * This method corresponds to the database table cf_spec_char_rel
     *
     * @mbg.generated Sat Mar 02 13:34:42 CST 2019
     */
    @Override
    public JSONObject toJSON() {
        JSONObject jsonObj = new JSONObject(32, true);
        if(this.specId != null) {jsonObj.put("specId", this.specId);}
        if(this.charId != null) {jsonObj.put("charId", this.charId);}
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
     * This method corresponds to the database table cf_spec_char_rel
     *
     * @mbg.generated Sat Mar 02 13:34:42 CST 2019
     */
    @Override
    public void clear() {
         this.specId = null; this.specIdColoured = false;
         this.charId = null; this.charIdColoured = false;
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
     * This method corresponds to the database table cf_spec_char_rel
     *
     * @mbg.generated Sat Mar 02 13:34:42 CST 2019
     */
    @Override
    public void clearColoured() {
        this.specIdColoured = false;
        this.charIdColoured = false;
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
     * This method corresponds to the database table cf_spec_char_rel
     *
     * @mbg.generated Sat Mar 02 13:34:42 CST 2019
     */
    @Override
    public boolean isColoured() {
        if(this.specIdColoured) return true;
        if(this.charIdColoured) return true;
        if(this.descriptionColoured) return true;
        if(this.statusColoured) return true;
        if(this.lastUpdateTimeColoured) return true;
        if(this.lastUpdateOperColoured) return true;
        if(this.createTimeColoured) return true;
        if(this.createOperColoured) return true;
        return false;
    }
}