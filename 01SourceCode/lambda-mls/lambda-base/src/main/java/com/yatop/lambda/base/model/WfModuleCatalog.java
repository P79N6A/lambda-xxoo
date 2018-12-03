package com.yatop.lambda.base.model;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;

public class WfModuleCatalog implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_module_catalog.CATALOG_ID
     *
     * @mbg.generated Mon Dec 03 08:28:47 CST 2018
     */
    private Long catalogId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_module_catalog.CATALOG_ID:Coloured
     *
     * @mbg.generated Mon Dec 03 08:28:47 CST 2018
     */
    private boolean catalogIdColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_module_catalog.CATALOG_CODE
     *
     * @mbg.generated Mon Dec 03 08:28:47 CST 2018
     */
    private String catalogCode;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_module_catalog.CATALOG_CODE:Coloured
     *
     * @mbg.generated Mon Dec 03 08:28:47 CST 2018
     */
    private boolean catalogCodeColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_module_catalog.CATALOG_NAME
     *
     * @mbg.generated Mon Dec 03 08:28:47 CST 2018
     */
    private String catalogName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_module_catalog.CATALOG_NAME:Coloured
     *
     * @mbg.generated Mon Dec 03 08:28:47 CST 2018
     */
    private boolean catalogNameColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_module_catalog.PARENT_CATALOG_ID
     *
     * @mbg.generated Mon Dec 03 08:28:47 CST 2018
     */
    private Long parentCatalogId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_module_catalog.PARENT_CATALOG_ID:Coloured
     *
     * @mbg.generated Mon Dec 03 08:28:47 CST 2018
     */
    private boolean parentCatalogIdColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_module_catalog.SEQUENCE
     *
     * @mbg.generated Mon Dec 03 08:28:47 CST 2018
     */
    private Integer sequence;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_module_catalog.SEQUENCE:Coloured
     *
     * @mbg.generated Mon Dec 03 08:28:47 CST 2018
     */
    private boolean sequenceColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_module_catalog.ICON_TYPE
     *
     * @mbg.generated Mon Dec 03 08:28:47 CST 2018
     */
    private Integer iconType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_module_catalog.ICON_TYPE:Coloured
     *
     * @mbg.generated Mon Dec 03 08:28:47 CST 2018
     */
    private boolean iconTypeColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_module_catalog.CATEGORY
     *
     * @mbg.generated Mon Dec 03 08:28:47 CST 2018
     */
    private String category;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_module_catalog.CATEGORY:Coloured
     *
     * @mbg.generated Mon Dec 03 08:28:47 CST 2018
     */
    private boolean categoryColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_module_catalog.DESCRIPTION
     *
     * @mbg.generated Mon Dec 03 08:28:47 CST 2018
     */
    private String description;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_module_catalog.DESCRIPTION:Coloured
     *
     * @mbg.generated Mon Dec 03 08:28:47 CST 2018
     */
    private boolean descriptionColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_module_catalog.STATUS
     *
     * @mbg.generated Mon Dec 03 08:28:47 CST 2018
     */
    private Integer status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_module_catalog.STATUS:Coloured
     *
     * @mbg.generated Mon Dec 03 08:28:47 CST 2018
     */
    private boolean statusColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_module_catalog.LAST_UPDATE_TIME
     *
     * @mbg.generated Mon Dec 03 08:28:47 CST 2018
     */
    private Date lastUpdateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_module_catalog.LAST_UPDATE_TIME:Coloured
     *
     * @mbg.generated Mon Dec 03 08:28:47 CST 2018
     */
    private boolean lastUpdateTimeColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_module_catalog.LAST_UPDATE_OPER
     *
     * @mbg.generated Mon Dec 03 08:28:47 CST 2018
     */
    private String lastUpdateOper;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_module_catalog.LAST_UPDATE_OPER:Coloured
     *
     * @mbg.generated Mon Dec 03 08:28:47 CST 2018
     */
    private boolean lastUpdateOperColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_module_catalog.CREATE_TIME
     *
     * @mbg.generated Mon Dec 03 08:28:47 CST 2018
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_module_catalog.CREATE_TIME:Coloured
     *
     * @mbg.generated Mon Dec 03 08:28:47 CST 2018
     */
    private boolean createTimeColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_module_catalog.CREATE_OPER
     *
     * @mbg.generated Mon Dec 03 08:28:47 CST 2018
     */
    private String createOper;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wf_module_catalog.CREATE_OPER:Coloured
     *
     * @mbg.generated Mon Dec 03 08:28:47 CST 2018
     */
    private boolean createOperColoured;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table wf_module_catalog
     *
     * @mbg.generated Mon Dec 03 08:28:47 CST 2018
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_module_catalog.CATALOG_ID
     *
     * @return the value of wf_module_catalog.CATALOG_ID
     *
     * @mbg.generated Mon Dec 03 08:28:47 CST 2018
     */
    public Long getCatalogId() {
        return catalogId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_module_catalog.CATALOG_ID:Coloured
     *
     * @return the value of wf_module_catalog.CATALOG_ID:Coloured
     *
     * @mbg.generated Mon Dec 03 08:28:47 CST 2018
     */
    public boolean isCatalogIdColoured() {
        return catalogIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_module_catalog.CATALOG_ID
     *
     * @param catalogId the value for wf_module_catalog.CATALOG_ID
     *
     * @mbg.generated Mon Dec 03 08:28:47 CST 2018
     */
    public void setCatalogId(Long catalogId) {
        this.catalogId = catalogId;
        this.catalogIdColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_module_catalog.CATALOG_ID:Coloured
     *
     * @param catalogIdColoured the value for wf_module_catalog.CATALOG_ID:Coloured
     *
     * @mbg.generated Mon Dec 03 08:28:47 CST 2018
     */
    public void setCatalogIdColoured(boolean catalogIdColoured) {
        this.catalogIdColoured = catalogIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_module_catalog.CATALOG_CODE
     *
     * @return the value of wf_module_catalog.CATALOG_CODE
     *
     * @mbg.generated Mon Dec 03 08:28:47 CST 2018
     */
    public String getCatalogCode() {
        return catalogCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_module_catalog.CATALOG_CODE:Coloured
     *
     * @return the value of wf_module_catalog.CATALOG_CODE:Coloured
     *
     * @mbg.generated Mon Dec 03 08:28:47 CST 2018
     */
    public boolean isCatalogCodeColoured() {
        return catalogCodeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_module_catalog.CATALOG_CODE
     *
     * @param catalogCode the value for wf_module_catalog.CATALOG_CODE
     *
     * @mbg.generated Mon Dec 03 08:28:47 CST 2018
     */
    public void setCatalogCode(String catalogCode) {
        this.catalogCode = catalogCode == null ? null : catalogCode.trim();
        this.catalogCodeColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_module_catalog.CATALOG_CODE:Coloured
     *
     * @param catalogCodeColoured the value for wf_module_catalog.CATALOG_CODE:Coloured
     *
     * @mbg.generated Mon Dec 03 08:28:47 CST 2018
     */
    public void setCatalogCodeColoured(boolean catalogCodeColoured) {
        this.catalogCodeColoured = catalogCodeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_module_catalog.CATALOG_NAME
     *
     * @return the value of wf_module_catalog.CATALOG_NAME
     *
     * @mbg.generated Mon Dec 03 08:28:47 CST 2018
     */
    public String getCatalogName() {
        return catalogName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_module_catalog.CATALOG_NAME:Coloured
     *
     * @return the value of wf_module_catalog.CATALOG_NAME:Coloured
     *
     * @mbg.generated Mon Dec 03 08:28:47 CST 2018
     */
    public boolean isCatalogNameColoured() {
        return catalogNameColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_module_catalog.CATALOG_NAME
     *
     * @param catalogName the value for wf_module_catalog.CATALOG_NAME
     *
     * @mbg.generated Mon Dec 03 08:28:47 CST 2018
     */
    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName == null ? null : catalogName.trim();
        this.catalogNameColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_module_catalog.CATALOG_NAME:Coloured
     *
     * @param catalogNameColoured the value for wf_module_catalog.CATALOG_NAME:Coloured
     *
     * @mbg.generated Mon Dec 03 08:28:47 CST 2018
     */
    public void setCatalogNameColoured(boolean catalogNameColoured) {
        this.catalogNameColoured = catalogNameColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_module_catalog.PARENT_CATALOG_ID
     *
     * @return the value of wf_module_catalog.PARENT_CATALOG_ID
     *
     * @mbg.generated Mon Dec 03 08:28:47 CST 2018
     */
    public Long getParentCatalogId() {
        return parentCatalogId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_module_catalog.PARENT_CATALOG_ID:Coloured
     *
     * @return the value of wf_module_catalog.PARENT_CATALOG_ID:Coloured
     *
     * @mbg.generated Mon Dec 03 08:28:47 CST 2018
     */
    public boolean isParentCatalogIdColoured() {
        return parentCatalogIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_module_catalog.PARENT_CATALOG_ID
     *
     * @param parentCatalogId the value for wf_module_catalog.PARENT_CATALOG_ID
     *
     * @mbg.generated Mon Dec 03 08:28:47 CST 2018
     */
    public void setParentCatalogId(Long parentCatalogId) {
        this.parentCatalogId = parentCatalogId;
        this.parentCatalogIdColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_module_catalog.PARENT_CATALOG_ID:Coloured
     *
     * @param parentCatalogIdColoured the value for wf_module_catalog.PARENT_CATALOG_ID:Coloured
     *
     * @mbg.generated Mon Dec 03 08:28:47 CST 2018
     */
    public void setParentCatalogIdColoured(boolean parentCatalogIdColoured) {
        this.parentCatalogIdColoured = parentCatalogIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_module_catalog.SEQUENCE
     *
     * @return the value of wf_module_catalog.SEQUENCE
     *
     * @mbg.generated Mon Dec 03 08:28:47 CST 2018
     */
    public Integer getSequence() {
        return sequence;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_module_catalog.SEQUENCE:Coloured
     *
     * @return the value of wf_module_catalog.SEQUENCE:Coloured
     *
     * @mbg.generated Mon Dec 03 08:28:47 CST 2018
     */
    public boolean isSequenceColoured() {
        return sequenceColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_module_catalog.SEQUENCE
     *
     * @param sequence the value for wf_module_catalog.SEQUENCE
     *
     * @mbg.generated Mon Dec 03 08:28:47 CST 2018
     */
    public void setSequence(Integer sequence) {
        this.sequence = sequence;
        this.sequenceColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_module_catalog.SEQUENCE:Coloured
     *
     * @param sequenceColoured the value for wf_module_catalog.SEQUENCE:Coloured
     *
     * @mbg.generated Mon Dec 03 08:28:47 CST 2018
     */
    public void setSequenceColoured(boolean sequenceColoured) {
        this.sequenceColoured = sequenceColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_module_catalog.ICON_TYPE
     *
     * @return the value of wf_module_catalog.ICON_TYPE
     *
     * @mbg.generated Mon Dec 03 08:28:47 CST 2018
     */
    public Integer getIconType() {
        return iconType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_module_catalog.ICON_TYPE:Coloured
     *
     * @return the value of wf_module_catalog.ICON_TYPE:Coloured
     *
     * @mbg.generated Mon Dec 03 08:28:47 CST 2018
     */
    public boolean isIconTypeColoured() {
        return iconTypeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_module_catalog.ICON_TYPE
     *
     * @param iconType the value for wf_module_catalog.ICON_TYPE
     *
     * @mbg.generated Mon Dec 03 08:28:47 CST 2018
     */
    public void setIconType(Integer iconType) {
        this.iconType = iconType;
        this.iconTypeColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_module_catalog.ICON_TYPE:Coloured
     *
     * @param iconTypeColoured the value for wf_module_catalog.ICON_TYPE:Coloured
     *
     * @mbg.generated Mon Dec 03 08:28:47 CST 2018
     */
    public void setIconTypeColoured(boolean iconTypeColoured) {
        this.iconTypeColoured = iconTypeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_module_catalog.CATEGORY
     *
     * @return the value of wf_module_catalog.CATEGORY
     *
     * @mbg.generated Mon Dec 03 08:28:47 CST 2018
     */
    public String getCategory() {
        return category;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_module_catalog.CATEGORY:Coloured
     *
     * @return the value of wf_module_catalog.CATEGORY:Coloured
     *
     * @mbg.generated Mon Dec 03 08:28:47 CST 2018
     */
    public boolean isCategoryColoured() {
        return categoryColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_module_catalog.CATEGORY
     *
     * @param category the value for wf_module_catalog.CATEGORY
     *
     * @mbg.generated Mon Dec 03 08:28:47 CST 2018
     */
    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
        this.categoryColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_module_catalog.CATEGORY:Coloured
     *
     * @param categoryColoured the value for wf_module_catalog.CATEGORY:Coloured
     *
     * @mbg.generated Mon Dec 03 08:28:47 CST 2018
     */
    public void setCategoryColoured(boolean categoryColoured) {
        this.categoryColoured = categoryColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_module_catalog.DESCRIPTION
     *
     * @return the value of wf_module_catalog.DESCRIPTION
     *
     * @mbg.generated Mon Dec 03 08:28:47 CST 2018
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_module_catalog.DESCRIPTION:Coloured
     *
     * @return the value of wf_module_catalog.DESCRIPTION:Coloured
     *
     * @mbg.generated Mon Dec 03 08:28:47 CST 2018
     */
    public boolean isDescriptionColoured() {
        return descriptionColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_module_catalog.DESCRIPTION
     *
     * @param description the value for wf_module_catalog.DESCRIPTION
     *
     * @mbg.generated Mon Dec 03 08:28:47 CST 2018
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
        this.descriptionColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_module_catalog.DESCRIPTION:Coloured
     *
     * @param descriptionColoured the value for wf_module_catalog.DESCRIPTION:Coloured
     *
     * @mbg.generated Mon Dec 03 08:28:47 CST 2018
     */
    public void setDescriptionColoured(boolean descriptionColoured) {
        this.descriptionColoured = descriptionColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_module_catalog.STATUS
     *
     * @return the value of wf_module_catalog.STATUS
     *
     * @mbg.generated Mon Dec 03 08:28:47 CST 2018
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_module_catalog.STATUS:Coloured
     *
     * @return the value of wf_module_catalog.STATUS:Coloured
     *
     * @mbg.generated Mon Dec 03 08:28:47 CST 2018
     */
    public boolean isStatusColoured() {
        return statusColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_module_catalog.STATUS
     *
     * @param status the value for wf_module_catalog.STATUS
     *
     * @mbg.generated Mon Dec 03 08:28:47 CST 2018
     */
    public void setStatus(Integer status) {
        this.status = status;
        this.statusColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_module_catalog.STATUS:Coloured
     *
     * @param statusColoured the value for wf_module_catalog.STATUS:Coloured
     *
     * @mbg.generated Mon Dec 03 08:28:47 CST 2018
     */
    public void setStatusColoured(boolean statusColoured) {
        this.statusColoured = statusColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_module_catalog.LAST_UPDATE_TIME
     *
     * @return the value of wf_module_catalog.LAST_UPDATE_TIME
     *
     * @mbg.generated Mon Dec 03 08:28:47 CST 2018
     */
    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_module_catalog.LAST_UPDATE_TIME:Coloured
     *
     * @return the value of wf_module_catalog.LAST_UPDATE_TIME:Coloured
     *
     * @mbg.generated Mon Dec 03 08:28:47 CST 2018
     */
    public boolean isLastUpdateTimeColoured() {
        return lastUpdateTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_module_catalog.LAST_UPDATE_TIME
     *
     * @param lastUpdateTime the value for wf_module_catalog.LAST_UPDATE_TIME
     *
     * @mbg.generated Mon Dec 03 08:28:47 CST 2018
     */
    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
        this.lastUpdateTimeColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_module_catalog.LAST_UPDATE_TIME:Coloured
     *
     * @param lastUpdateTimeColoured the value for wf_module_catalog.LAST_UPDATE_TIME:Coloured
     *
     * @mbg.generated Mon Dec 03 08:28:47 CST 2018
     */
    public void setLastUpdateTimeColoured(boolean lastUpdateTimeColoured) {
        this.lastUpdateTimeColoured = lastUpdateTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_module_catalog.LAST_UPDATE_OPER
     *
     * @return the value of wf_module_catalog.LAST_UPDATE_OPER
     *
     * @mbg.generated Mon Dec 03 08:28:47 CST 2018
     */
    public String getLastUpdateOper() {
        return lastUpdateOper;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_module_catalog.LAST_UPDATE_OPER:Coloured
     *
     * @return the value of wf_module_catalog.LAST_UPDATE_OPER:Coloured
     *
     * @mbg.generated Mon Dec 03 08:28:47 CST 2018
     */
    public boolean isLastUpdateOperColoured() {
        return lastUpdateOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_module_catalog.LAST_UPDATE_OPER
     *
     * @param lastUpdateOper the value for wf_module_catalog.LAST_UPDATE_OPER
     *
     * @mbg.generated Mon Dec 03 08:28:47 CST 2018
     */
    public void setLastUpdateOper(String lastUpdateOper) {
        this.lastUpdateOper = lastUpdateOper == null ? null : lastUpdateOper.trim();
        this.lastUpdateOperColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_module_catalog.LAST_UPDATE_OPER:Coloured
     *
     * @param lastUpdateOperColoured the value for wf_module_catalog.LAST_UPDATE_OPER:Coloured
     *
     * @mbg.generated Mon Dec 03 08:28:47 CST 2018
     */
    public void setLastUpdateOperColoured(boolean lastUpdateOperColoured) {
        this.lastUpdateOperColoured = lastUpdateOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_module_catalog.CREATE_TIME
     *
     * @return the value of wf_module_catalog.CREATE_TIME
     *
     * @mbg.generated Mon Dec 03 08:28:47 CST 2018
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_module_catalog.CREATE_TIME:Coloured
     *
     * @return the value of wf_module_catalog.CREATE_TIME:Coloured
     *
     * @mbg.generated Mon Dec 03 08:28:47 CST 2018
     */
    public boolean isCreateTimeColoured() {
        return createTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_module_catalog.CREATE_TIME
     *
     * @param createTime the value for wf_module_catalog.CREATE_TIME
     *
     * @mbg.generated Mon Dec 03 08:28:47 CST 2018
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
        this.createTimeColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_module_catalog.CREATE_TIME:Coloured
     *
     * @param createTimeColoured the value for wf_module_catalog.CREATE_TIME:Coloured
     *
     * @mbg.generated Mon Dec 03 08:28:47 CST 2018
     */
    public void setCreateTimeColoured(boolean createTimeColoured) {
        this.createTimeColoured = createTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_module_catalog.CREATE_OPER
     *
     * @return the value of wf_module_catalog.CREATE_OPER
     *
     * @mbg.generated Mon Dec 03 08:28:47 CST 2018
     */
    public String getCreateOper() {
        return createOper;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wf_module_catalog.CREATE_OPER:Coloured
     *
     * @return the value of wf_module_catalog.CREATE_OPER:Coloured
     *
     * @mbg.generated Mon Dec 03 08:28:47 CST 2018
     */
    public boolean isCreateOperColoured() {
        return createOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_module_catalog.CREATE_OPER
     *
     * @param createOper the value for wf_module_catalog.CREATE_OPER
     *
     * @mbg.generated Mon Dec 03 08:28:47 CST 2018
     */
    public void setCreateOper(String createOper) {
        this.createOper = createOper == null ? null : createOper.trim();
        this.createOperColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wf_module_catalog.CREATE_OPER:Coloured
     *
     * @param createOperColoured the value for wf_module_catalog.CREATE_OPER:Coloured
     *
     * @mbg.generated Mon Dec 03 08:28:47 CST 2018
     */
    public void setCreateOperColoured(boolean createOperColoured) {
        this.createOperColoured = createOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_module_catalog
     *
     * @mbg.generated Mon Dec 03 08:28:47 CST 2018
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
        WfModuleCatalog other = (WfModuleCatalog) that;
        return (this.getCatalogId() == null ? other.getCatalogId() == null : this.getCatalogId().equals(other.getCatalogId()))
            && (this.getCatalogCode() == null ? other.getCatalogCode() == null : this.getCatalogCode().equals(other.getCatalogCode()))
            && (this.getCatalogName() == null ? other.getCatalogName() == null : this.getCatalogName().equals(other.getCatalogName()))
            && (this.getParentCatalogId() == null ? other.getParentCatalogId() == null : this.getParentCatalogId().equals(other.getParentCatalogId()))
            && (this.getSequence() == null ? other.getSequence() == null : this.getSequence().equals(other.getSequence()))
            && (this.getIconType() == null ? other.getIconType() == null : this.getIconType().equals(other.getIconType()))
            && (this.getCategory() == null ? other.getCategory() == null : this.getCategory().equals(other.getCategory()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getLastUpdateTime() == null ? other.getLastUpdateTime() == null : this.getLastUpdateTime().equals(other.getLastUpdateTime()))
            && (this.getLastUpdateOper() == null ? other.getLastUpdateOper() == null : this.getLastUpdateOper().equals(other.getLastUpdateOper()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getCreateOper() == null ? other.getCreateOper() == null : this.getCreateOper().equals(other.getCreateOper()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_module_catalog
     *
     * @mbg.generated Mon Dec 03 08:28:47 CST 2018
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCatalogId() == null) ? 0 : getCatalogId().hashCode());
        result = prime * result + ((getCatalogCode() == null) ? 0 : getCatalogCode().hashCode());
        result = prime * result + ((getCatalogName() == null) ? 0 : getCatalogName().hashCode());
        result = prime * result + ((getParentCatalogId() == null) ? 0 : getParentCatalogId().hashCode());
        result = prime * result + ((getSequence() == null) ? 0 : getSequence().hashCode());
        result = prime * result + ((getIconType() == null) ? 0 : getIconType().hashCode());
        result = prime * result + ((getCategory() == null) ? 0 : getCategory().hashCode());
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
     * This method corresponds to the database table wf_module_catalog
     *
     * @mbg.generated Mon Dec 03 08:28:47 CST 2018
     */
    public void copyProperties(Object that) {
        if (this == that || that == null || this.getClass() != that.getClass() ) {
            return;
        }
        WfModuleCatalog other = (WfModuleCatalog) that;
        if(other.isCatalogIdColoured() ) {this.setCatalogId(other.getCatalogId() );}
        if(other.isCatalogCodeColoured() ) {this.setCatalogCode(other.getCatalogCode() );}
        if(other.isCatalogNameColoured() ) {this.setCatalogName(other.getCatalogName() );}
        if(other.isParentCatalogIdColoured() ) {this.setParentCatalogId(other.getParentCatalogId() );}
        if(other.isSequenceColoured() ) {this.setSequence(other.getSequence() );}
        if(other.isIconTypeColoured() ) {this.setIconType(other.getIconType() );}
        if(other.isCategoryColoured() ) {this.setCategory(other.getCategory() );}
        if(other.isDescriptionColoured() ) {this.setDescription(other.getDescription() );}
        if(other.isStatusColoured() ) {this.setStatus(other.getStatus() );}
        if(other.isLastUpdateTimeColoured() ) {this.setLastUpdateTime(other.getLastUpdateTime() );}
        if(other.isLastUpdateOperColoured() ) {this.setLastUpdateOper(other.getLastUpdateOper() );}
        if(other.isCreateTimeColoured() ) {this.setCreateTime(other.getCreateTime() );}
        if(other.isCreateOperColoured() ) {this.setCreateOper(other.getCreateOper() );}
        return;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_module_catalog
     *
     * @mbg.generated Mon Dec 03 08:28:47 CST 2018
     */
    public JSONObject toJSON() {
        HashMap<String, Object> hashMap = new HashMap();
        if(this.catalogIdColoured) {hashMap.put("catalogId", this.catalogId);}
        if(this.catalogCodeColoured) {hashMap.put("catalogCode", this.catalogCode);}
        if(this.catalogNameColoured) {hashMap.put("catalogName", this.catalogName);}
        if(this.parentCatalogIdColoured) {hashMap.put("parentCatalogId", this.parentCatalogId);}
        if(this.sequenceColoured) {hashMap.put("sequence", this.sequence);}
        if(this.iconTypeColoured) {hashMap.put("iconType", this.iconType);}
        if(this.categoryColoured) {hashMap.put("category", this.category);}
        if(this.descriptionColoured) {hashMap.put("description", this.description);}
        if(this.statusColoured) {hashMap.put("status", this.status);}
        if(this.lastUpdateTimeColoured) {hashMap.put("lastUpdateTime", this.lastUpdateTime);}
        if(this.lastUpdateOperColoured) {hashMap.put("lastUpdateOper", this.lastUpdateOper);}
        if(this.createTimeColoured) {hashMap.put("createTime", this.createTime);}
        if(this.createOperColoured) {hashMap.put("createOper", this.createOper);}
        return (JSONObject) JSON.toJSON(hashMap);
    }
}