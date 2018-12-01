package com.yatop.lambda.base.model;

import java.io.Serializable;
import java.util.Date;

public class WfModule implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_module.MODULE_ID
     *
     * @mbg.generated Sat Dec 01 22:15:38 CST 2018
     */
    private Long moduleId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_module.MODULE_CODE
     *
     * @mbg.generated Sat Dec 01 22:15:38 CST 2018
     */
    private String moduleCode;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_module.MODULE_NAME
     *
     * @mbg.generated Sat Dec 01 22:15:38 CST 2018
     */
    private String moduleName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_module.CATALOG_ID
     *
     * @mbg.generated Sat Dec 01 22:15:38 CST 2018
     */
    private Long catalogId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_module.SEQUENCE
     *
     * @mbg.generated Sat Dec 01 22:15:38 CST 2018
     */
    private Integer sequence;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_module.CATEGORY
     *
     * @mbg.generated Sat Dec 01 22:15:38 CST 2018
     */
    private String category;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_module.ICON_TYPE
     *
     * @mbg.generated Sat Dec 01 22:15:38 CST 2018
     */
    private Integer iconType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_module.CLASS_PATH
     *
     * @mbg.generated Sat Dec 01 22:15:38 CST 2018
     */
    private String classPath;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_module.PKG_CMPT_ID
     *
     * @mbg.generated Sat Dec 01 22:15:38 CST 2018
     */
    private String pkgCmptId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_module.DESCRIPTION
     *
     * @mbg.generated Sat Dec 01 22:15:38 CST 2018
     */
    private String description;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_module.STATUS
     *
     * @mbg.generated Sat Dec 01 22:15:38 CST 2018
     */
    private Integer status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_module.LAST_UPDATE_TIME
     *
     * @mbg.generated Sat Dec 01 22:15:38 CST 2018
     */
    private Date lastUpdateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_module.LAST_UPDATE_OPER
     *
     * @mbg.generated Sat Dec 01 22:15:38 CST 2018
     */
    private String lastUpdateOper;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_module.CREATE_TIME
     *
     * @mbg.generated Sat Dec 01 22:15:38 CST 2018
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_module.CREATE_OPER
     *
     * @mbg.generated Sat Dec 01 22:15:38 CST 2018
     */
    private String createOper;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table wf_module
     *
     * @mbg.generated Sat Dec 01 22:15:38 CST 2018
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_module.MODULE_ID
     *
     * @return the value of wf_module.MODULE_ID
     *
     * @mbg.generated Sat Dec 01 22:15:38 CST 2018
     */
    public Long getModuleId() {
        return moduleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_module.MODULE_ID
     *
     * @param moduleId the value for wf_module.MODULE_ID
     *
     * @mbg.generated Sat Dec 01 22:15:38 CST 2018
     */
    public void setModuleId(Long moduleId) {
        this.moduleId = moduleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_module.MODULE_CODE
     *
     * @return the value of wf_module.MODULE_CODE
     *
     * @mbg.generated Sat Dec 01 22:15:38 CST 2018
     */
    public String getModuleCode() {
        return moduleCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_module.MODULE_CODE
     *
     * @param moduleCode the value for wf_module.MODULE_CODE
     *
     * @mbg.generated Sat Dec 01 22:15:38 CST 2018
     */
    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode == null ? null : moduleCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_module.MODULE_NAME
     *
     * @return the value of wf_module.MODULE_NAME
     *
     * @mbg.generated Sat Dec 01 22:15:38 CST 2018
     */
    public String getModuleName() {
        return moduleName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_module.MODULE_NAME
     *
     * @param moduleName the value for wf_module.MODULE_NAME
     *
     * @mbg.generated Sat Dec 01 22:15:38 CST 2018
     */
    public void setModuleName(String moduleName) {
        this.moduleName = moduleName == null ? null : moduleName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_module.CATALOG_ID
     *
     * @return the value of wf_module.CATALOG_ID
     *
     * @mbg.generated Sat Dec 01 22:15:38 CST 2018
     */
    public Long getCatalogId() {
        return catalogId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_module.CATALOG_ID
     *
     * @param catalogId the value for wf_module.CATALOG_ID
     *
     * @mbg.generated Sat Dec 01 22:15:38 CST 2018
     */
    public void setCatalogId(Long catalogId) {
        this.catalogId = catalogId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_module.SEQUENCE
     *
     * @return the value of wf_module.SEQUENCE
     *
     * @mbg.generated Sat Dec 01 22:15:38 CST 2018
     */
    public Integer getSequence() {
        return sequence;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_module.SEQUENCE
     *
     * @param sequence the value for wf_module.SEQUENCE
     *
     * @mbg.generated Sat Dec 01 22:15:38 CST 2018
     */
    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_module.CATEGORY
     *
     * @return the value of wf_module.CATEGORY
     *
     * @mbg.generated Sat Dec 01 22:15:38 CST 2018
     */
    public String getCategory() {
        return category;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_module.CATEGORY
     *
     * @param category the value for wf_module.CATEGORY
     *
     * @mbg.generated Sat Dec 01 22:15:38 CST 2018
     */
    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_module.ICON_TYPE
     *
     * @return the value of wf_module.ICON_TYPE
     *
     * @mbg.generated Sat Dec 01 22:15:38 CST 2018
     */
    public Integer getIconType() {
        return iconType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_module.ICON_TYPE
     *
     * @param iconType the value for wf_module.ICON_TYPE
     *
     * @mbg.generated Sat Dec 01 22:15:38 CST 2018
     */
    public void setIconType(Integer iconType) {
        this.iconType = iconType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_module.CLASS_PATH
     *
     * @return the value of wf_module.CLASS_PATH
     *
     * @mbg.generated Sat Dec 01 22:15:38 CST 2018
     */
    public String getClassPath() {
        return classPath;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_module.CLASS_PATH
     *
     * @param classPath the value for wf_module.CLASS_PATH
     *
     * @mbg.generated Sat Dec 01 22:15:38 CST 2018
     */
    public void setClassPath(String classPath) {
        this.classPath = classPath == null ? null : classPath.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_module.PKG_CMPT_ID
     *
     * @return the value of wf_module.PKG_CMPT_ID
     *
     * @mbg.generated Sat Dec 01 22:15:38 CST 2018
     */
    public String getPkgCmptId() {
        return pkgCmptId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_module.PKG_CMPT_ID
     *
     * @param pkgCmptId the value for wf_module.PKG_CMPT_ID
     *
     * @mbg.generated Sat Dec 01 22:15:38 CST 2018
     */
    public void setPkgCmptId(String pkgCmptId) {
        this.pkgCmptId = pkgCmptId == null ? null : pkgCmptId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_module.DESCRIPTION
     *
     * @return the value of wf_module.DESCRIPTION
     *
     * @mbg.generated Sat Dec 01 22:15:38 CST 2018
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_module.DESCRIPTION
     *
     * @param description the value for wf_module.DESCRIPTION
     *
     * @mbg.generated Sat Dec 01 22:15:38 CST 2018
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_module.STATUS
     *
     * @return the value of wf_module.STATUS
     *
     * @mbg.generated Sat Dec 01 22:15:38 CST 2018
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_module.STATUS
     *
     * @param status the value for wf_module.STATUS
     *
     * @mbg.generated Sat Dec 01 22:15:38 CST 2018
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_module.LAST_UPDATE_TIME
     *
     * @return the value of wf_module.LAST_UPDATE_TIME
     *
     * @mbg.generated Sat Dec 01 22:15:38 CST 2018
     */
    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_module.LAST_UPDATE_TIME
     *
     * @param lastUpdateTime the value for wf_module.LAST_UPDATE_TIME
     *
     * @mbg.generated Sat Dec 01 22:15:38 CST 2018
     */
    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_module.LAST_UPDATE_OPER
     *
     * @return the value of wf_module.LAST_UPDATE_OPER
     *
     * @mbg.generated Sat Dec 01 22:15:38 CST 2018
     */
    public String getLastUpdateOper() {
        return lastUpdateOper;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_module.LAST_UPDATE_OPER
     *
     * @param lastUpdateOper the value for wf_module.LAST_UPDATE_OPER
     *
     * @mbg.generated Sat Dec 01 22:15:38 CST 2018
     */
    public void setLastUpdateOper(String lastUpdateOper) {
        this.lastUpdateOper = lastUpdateOper == null ? null : lastUpdateOper.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_module.CREATE_TIME
     *
     * @return the value of wf_module.CREATE_TIME
     *
     * @mbg.generated Sat Dec 01 22:15:38 CST 2018
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_module.CREATE_TIME
     *
     * @param createTime the value for wf_module.CREATE_TIME
     *
     * @mbg.generated Sat Dec 01 22:15:38 CST 2018
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_module.CREATE_OPER
     *
     * @return the value of wf_module.CREATE_OPER
     *
     * @mbg.generated Sat Dec 01 22:15:38 CST 2018
     */
    public String getCreateOper() {
        return createOper;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_module.CREATE_OPER
     *
     * @param createOper the value for wf_module.CREATE_OPER
     *
     * @mbg.generated Sat Dec 01 22:15:38 CST 2018
     */
    public void setCreateOper(String createOper) {
        this.createOper = createOper == null ? null : createOper.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_module
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
        WfModule other = (WfModule) that;
        return (this.getModuleId() == null ? other.getModuleId() == null : this.getModuleId().equals(other.getModuleId()))
            && (this.getModuleCode() == null ? other.getModuleCode() == null : this.getModuleCode().equals(other.getModuleCode()))
            && (this.getModuleName() == null ? other.getModuleName() == null : this.getModuleName().equals(other.getModuleName()))
            && (this.getCatalogId() == null ? other.getCatalogId() == null : this.getCatalogId().equals(other.getCatalogId()))
            && (this.getSequence() == null ? other.getSequence() == null : this.getSequence().equals(other.getSequence()))
            && (this.getCategory() == null ? other.getCategory() == null : this.getCategory().equals(other.getCategory()))
            && (this.getIconType() == null ? other.getIconType() == null : this.getIconType().equals(other.getIconType()))
            && (this.getClassPath() == null ? other.getClassPath() == null : this.getClassPath().equals(other.getClassPath()))
            && (this.getPkgCmptId() == null ? other.getPkgCmptId() == null : this.getPkgCmptId().equals(other.getPkgCmptId()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getLastUpdateTime() == null ? other.getLastUpdateTime() == null : this.getLastUpdateTime().equals(other.getLastUpdateTime()))
            && (this.getLastUpdateOper() == null ? other.getLastUpdateOper() == null : this.getLastUpdateOper().equals(other.getLastUpdateOper()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getCreateOper() == null ? other.getCreateOper() == null : this.getCreateOper().equals(other.getCreateOper()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_module
     *
     * @mbg.generated Sat Dec 01 22:15:38 CST 2018
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getModuleId() == null) ? 0 : getModuleId().hashCode());
        result = prime * result + ((getModuleCode() == null) ? 0 : getModuleCode().hashCode());
        result = prime * result + ((getModuleName() == null) ? 0 : getModuleName().hashCode());
        result = prime * result + ((getCatalogId() == null) ? 0 : getCatalogId().hashCode());
        result = prime * result + ((getSequence() == null) ? 0 : getSequence().hashCode());
        result = prime * result + ((getCategory() == null) ? 0 : getCategory().hashCode());
        result = prime * result + ((getIconType() == null) ? 0 : getIconType().hashCode());
        result = prime * result + ((getClassPath() == null) ? 0 : getClassPath().hashCode());
        result = prime * result + ((getPkgCmptId() == null) ? 0 : getPkgCmptId().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getLastUpdateTime() == null) ? 0 : getLastUpdateTime().hashCode());
        result = prime * result + ((getLastUpdateOper() == null) ? 0 : getLastUpdateOper().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCreateOper() == null) ? 0 : getCreateOper().hashCode());
        return result;
    }
}