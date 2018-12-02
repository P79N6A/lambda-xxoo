package com.yatop.lambda.base.model;

import java.io.Serializable;
import java.util.Date;

public class CfCmptSpec implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_cmpt_spec.SPEC_ID
     *
     * @mbg.generated Sun Dec 02 15:46:24 CST 2018
     */
    private String specId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_cmpt_spec.SPEC_CODE
     *
     * @mbg.generated Sun Dec 02 15:46:24 CST 2018
     */
    private String specCode;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_cmpt_spec.SPEC_NAME
     *
     * @mbg.generated Sun Dec 02 15:46:24 CST 2018
     */
    private String specName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_cmpt_spec.SPEC_TYPE
     *
     * @mbg.generated Sun Dec 02 15:46:24 CST 2018
     */
    private Integer specType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_cmpt_spec.DESCRIPTION
     *
     * @mbg.generated Sun Dec 02 15:46:24 CST 2018
     */
    private String description;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_cmpt_spec.STATUS
     *
     * @mbg.generated Sun Dec 02 15:46:24 CST 2018
     */
    private Integer status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_cmpt_spec.LAST_UPDATE_TIME
     *
     * @mbg.generated Sun Dec 02 15:46:24 CST 2018
     */
    private Date lastUpdateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_cmpt_spec.LAST_UPDATE_OPER
     *
     * @mbg.generated Sun Dec 02 15:46:24 CST 2018
     */
    private String lastUpdateOper;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_cmpt_spec.CREATE_TIME
     *
     * @mbg.generated Sun Dec 02 15:46:24 CST 2018
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_cmpt_spec.CREATE_OPER
     *
     * @mbg.generated Sun Dec 02 15:46:24 CST 2018
     */
    private String createOper;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table cf_cmpt_spec
     *
     * @mbg.generated Sun Dec 02 15:46:24 CST 2018
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_cmpt_spec.SPEC_ID
     *
     * @return the value of cf_cmpt_spec.SPEC_ID
     *
     * @mbg.generated Sun Dec 02 15:46:24 CST 2018
     */
    public String getSpecId() {
        return specId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cf_cmpt_spec.SPEC_ID
     *
     * @param specId the value for cf_cmpt_spec.SPEC_ID
     *
     * @mbg.generated Sun Dec 02 15:46:24 CST 2018
     */
    public void setSpecId(String specId) {
        this.specId = specId == null ? null : specId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_cmpt_spec.SPEC_CODE
     *
     * @return the value of cf_cmpt_spec.SPEC_CODE
     *
     * @mbg.generated Sun Dec 02 15:46:24 CST 2018
     */
    public String getSpecCode() {
        return specCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cf_cmpt_spec.SPEC_CODE
     *
     * @param specCode the value for cf_cmpt_spec.SPEC_CODE
     *
     * @mbg.generated Sun Dec 02 15:46:24 CST 2018
     */
    public void setSpecCode(String specCode) {
        this.specCode = specCode == null ? null : specCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_cmpt_spec.SPEC_NAME
     *
     * @return the value of cf_cmpt_spec.SPEC_NAME
     *
     * @mbg.generated Sun Dec 02 15:46:24 CST 2018
     */
    public String getSpecName() {
        return specName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cf_cmpt_spec.SPEC_NAME
     *
     * @param specName the value for cf_cmpt_spec.SPEC_NAME
     *
     * @mbg.generated Sun Dec 02 15:46:24 CST 2018
     */
    public void setSpecName(String specName) {
        this.specName = specName == null ? null : specName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_cmpt_spec.SPEC_TYPE
     *
     * @return the value of cf_cmpt_spec.SPEC_TYPE
     *
     * @mbg.generated Sun Dec 02 15:46:24 CST 2018
     */
    public Integer getSpecType() {
        return specType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cf_cmpt_spec.SPEC_TYPE
     *
     * @param specType the value for cf_cmpt_spec.SPEC_TYPE
     *
     * @mbg.generated Sun Dec 02 15:46:24 CST 2018
     */
    public void setSpecType(Integer specType) {
        this.specType = specType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_cmpt_spec.DESCRIPTION
     *
     * @return the value of cf_cmpt_spec.DESCRIPTION
     *
     * @mbg.generated Sun Dec 02 15:46:24 CST 2018
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cf_cmpt_spec.DESCRIPTION
     *
     * @param description the value for cf_cmpt_spec.DESCRIPTION
     *
     * @mbg.generated Sun Dec 02 15:46:24 CST 2018
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_cmpt_spec.STATUS
     *
     * @return the value of cf_cmpt_spec.STATUS
     *
     * @mbg.generated Sun Dec 02 15:46:24 CST 2018
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cf_cmpt_spec.STATUS
     *
     * @param status the value for cf_cmpt_spec.STATUS
     *
     * @mbg.generated Sun Dec 02 15:46:24 CST 2018
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_cmpt_spec.LAST_UPDATE_TIME
     *
     * @return the value of cf_cmpt_spec.LAST_UPDATE_TIME
     *
     * @mbg.generated Sun Dec 02 15:46:24 CST 2018
     */
    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cf_cmpt_spec.LAST_UPDATE_TIME
     *
     * @param lastUpdateTime the value for cf_cmpt_spec.LAST_UPDATE_TIME
     *
     * @mbg.generated Sun Dec 02 15:46:24 CST 2018
     */
    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_cmpt_spec.LAST_UPDATE_OPER
     *
     * @return the value of cf_cmpt_spec.LAST_UPDATE_OPER
     *
     * @mbg.generated Sun Dec 02 15:46:24 CST 2018
     */
    public String getLastUpdateOper() {
        return lastUpdateOper;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cf_cmpt_spec.LAST_UPDATE_OPER
     *
     * @param lastUpdateOper the value for cf_cmpt_spec.LAST_UPDATE_OPER
     *
     * @mbg.generated Sun Dec 02 15:46:24 CST 2018
     */
    public void setLastUpdateOper(String lastUpdateOper) {
        this.lastUpdateOper = lastUpdateOper == null ? null : lastUpdateOper.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_cmpt_spec.CREATE_TIME
     *
     * @return the value of cf_cmpt_spec.CREATE_TIME
     *
     * @mbg.generated Sun Dec 02 15:46:24 CST 2018
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cf_cmpt_spec.CREATE_TIME
     *
     * @param createTime the value for cf_cmpt_spec.CREATE_TIME
     *
     * @mbg.generated Sun Dec 02 15:46:24 CST 2018
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_cmpt_spec.CREATE_OPER
     *
     * @return the value of cf_cmpt_spec.CREATE_OPER
     *
     * @mbg.generated Sun Dec 02 15:46:24 CST 2018
     */
    public String getCreateOper() {
        return createOper;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cf_cmpt_spec.CREATE_OPER
     *
     * @param createOper the value for cf_cmpt_spec.CREATE_OPER
     *
     * @mbg.generated Sun Dec 02 15:46:24 CST 2018
     */
    public void setCreateOper(String createOper) {
        this.createOper = createOper == null ? null : createOper.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_spec
     *
     * @mbg.generated Sun Dec 02 15:46:24 CST 2018
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
        CfCmptSpec other = (CfCmptSpec) that;
        return (this.getSpecId() == null ? other.getSpecId() == null : this.getSpecId().equals(other.getSpecId()))
            && (this.getSpecCode() == null ? other.getSpecCode() == null : this.getSpecCode().equals(other.getSpecCode()))
            && (this.getSpecName() == null ? other.getSpecName() == null : this.getSpecName().equals(other.getSpecName()))
            && (this.getSpecType() == null ? other.getSpecType() == null : this.getSpecType().equals(other.getSpecType()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getLastUpdateTime() == null ? other.getLastUpdateTime() == null : this.getLastUpdateTime().equals(other.getLastUpdateTime()))
            && (this.getLastUpdateOper() == null ? other.getLastUpdateOper() == null : this.getLastUpdateOper().equals(other.getLastUpdateOper()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getCreateOper() == null ? other.getCreateOper() == null : this.getCreateOper().equals(other.getCreateOper()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_spec
     *
     * @mbg.generated Sun Dec 02 15:46:24 CST 2018
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getSpecId() == null) ? 0 : getSpecId().hashCode());
        result = prime * result + ((getSpecCode() == null) ? 0 : getSpecCode().hashCode());
        result = prime * result + ((getSpecName() == null) ? 0 : getSpecName().hashCode());
        result = prime * result + ((getSpecType() == null) ? 0 : getSpecType().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getLastUpdateTime() == null) ? 0 : getLastUpdateTime().hashCode());
        result = prime * result + ((getLastUpdateOper() == null) ? 0 : getLastUpdateOper().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCreateOper() == null) ? 0 : getCreateOper().hashCode());
        return result;
    }
}