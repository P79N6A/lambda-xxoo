package com.yatop.lambda.base.model;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yatop.lambda.base.utils.LambdaRootModel;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;

public class PrProject extends LambdaRootModel implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pr_project.PROJECT_ID
     *
     * @mbg.generated Sat Dec 08 02:38:58 CST 2018
     */
    private Long projectId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pr_project.PROJECT_ID:Coloured
     *
     * @mbg.generated Sat Dec 08 02:38:58 CST 2018
     */
    private boolean projectIdColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pr_project.PROJECT_CODE
     *
     * @mbg.generated Sat Dec 08 02:38:58 CST 2018
     */
    private String projectCode;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pr_project.PROJECT_CODE:Coloured
     *
     * @mbg.generated Sat Dec 08 02:38:58 CST 2018
     */
    private boolean projectCodeColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pr_project.PROJECT_NAME
     *
     * @mbg.generated Sat Dec 08 02:38:58 CST 2018
     */
    private String projectName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pr_project.PROJECT_NAME:Coloured
     *
     * @mbg.generated Sat Dec 08 02:38:58 CST 2018
     */
    private boolean projectNameColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pr_project.DW_ID
     *
     * @mbg.generated Sat Dec 08 02:38:58 CST 2018
     */
    private Long dwId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pr_project.DW_ID:Coloured
     *
     * @mbg.generated Sat Dec 08 02:38:58 CST 2018
     */
    private boolean dwIdColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pr_project.MW_ID
     *
     * @mbg.generated Sat Dec 08 02:38:58 CST 2018
     */
    private Long mwId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pr_project.MW_ID:Coloured
     *
     * @mbg.generated Sat Dec 08 02:38:58 CST 2018
     */
    private boolean mwIdColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pr_project.CACHE_EXPIRE_DAYS
     *
     * @mbg.generated Sat Dec 08 02:38:58 CST 2018
     */
    private Integer cacheExpireDays;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pr_project.CACHE_EXPIRE_DAYS:Coloured
     *
     * @mbg.generated Sat Dec 08 02:38:58 CST 2018
     */
    private boolean cacheExpireDaysColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pr_project.DESCRIPTION
     *
     * @mbg.generated Sat Dec 08 02:38:58 CST 2018
     */
    private String description;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pr_project.DESCRIPTION:Coloured
     *
     * @mbg.generated Sat Dec 08 02:38:58 CST 2018
     */
    private boolean descriptionColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pr_project.STATUS
     *
     * @mbg.generated Sat Dec 08 02:38:58 CST 2018
     */
    private Integer status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pr_project.STATUS:Coloured
     *
     * @mbg.generated Sat Dec 08 02:38:58 CST 2018
     */
    private boolean statusColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pr_project.LAST_UPDATE_TIME
     *
     * @mbg.generated Sat Dec 08 02:38:58 CST 2018
     */
    private Date lastUpdateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pr_project.LAST_UPDATE_TIME:Coloured
     *
     * @mbg.generated Sat Dec 08 02:38:58 CST 2018
     */
    private boolean lastUpdateTimeColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pr_project.LAST_UPDATE_OPER
     *
     * @mbg.generated Sat Dec 08 02:38:58 CST 2018
     */
    private String lastUpdateOper;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pr_project.LAST_UPDATE_OPER:Coloured
     *
     * @mbg.generated Sat Dec 08 02:38:58 CST 2018
     */
    private boolean lastUpdateOperColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pr_project.CREATE_TIME
     *
     * @mbg.generated Sat Dec 08 02:38:58 CST 2018
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pr_project.CREATE_TIME:Coloured
     *
     * @mbg.generated Sat Dec 08 02:38:58 CST 2018
     */
    private boolean createTimeColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pr_project.CREATE_OPER
     *
     * @mbg.generated Sat Dec 08 02:38:58 CST 2018
     */
    private String createOper;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pr_project.CREATE_OPER:Coloured
     *
     * @mbg.generated Sat Dec 08 02:38:58 CST 2018
     */
    private boolean createOperColoured;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table pr_project
     *
     * @mbg.generated Sat Dec 08 02:38:58 CST 2018
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pr_project.PROJECT_ID
     *
     * @return the value of pr_project.PROJECT_ID
     *
     * @mbg.generated Sat Dec 08 02:38:58 CST 2018
     */
    public Long getProjectId() {
        return projectId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pr_project.PROJECT_ID:Coloured
     *
     * @return the value of pr_project.PROJECT_ID:Coloured
     *
     * @mbg.generated Sat Dec 08 02:38:58 CST 2018
     */
    public boolean isProjectIdColoured() {
        return projectIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pr_project.PROJECT_ID:Coloured
     *
     * @return the value of pr_project.PROJECT_ID:Coloured
     *
     * @mbg.generated Sat Dec 08 02:38:58 CST 2018
     */
    public boolean isProjectIdNotColoured() {
        return !projectIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pr_project.PROJECT_ID
     *
     * @param projectId the value for pr_project.PROJECT_ID
     *
     * @mbg.generated Sat Dec 08 02:38:58 CST 2018
     */
    public void setProjectId(Long projectId) {
        this.projectId = projectId;
        this.projectIdColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pr_project.PROJECT_ID:Coloured
     *
     * @param projectIdColoured the value for pr_project.PROJECT_ID:Coloured
     *
     * @mbg.generated Sat Dec 08 02:38:58 CST 2018
     */
    public void setProjectIdColoured(boolean projectIdColoured) {
        this.projectIdColoured = projectIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pr_project.PROJECT_CODE
     *
     * @return the value of pr_project.PROJECT_CODE
     *
     * @mbg.generated Sat Dec 08 02:38:58 CST 2018
     */
    public String getProjectCode() {
        return projectCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pr_project.PROJECT_CODE:Coloured
     *
     * @return the value of pr_project.PROJECT_CODE:Coloured
     *
     * @mbg.generated Sat Dec 08 02:38:58 CST 2018
     */
    public boolean isProjectCodeColoured() {
        return projectCodeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pr_project.PROJECT_CODE:Coloured
     *
     * @return the value of pr_project.PROJECT_CODE:Coloured
     *
     * @mbg.generated Sat Dec 08 02:38:58 CST 2018
     */
    public boolean isProjectCodeNotColoured() {
        return !projectCodeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pr_project.PROJECT_CODE
     *
     * @param projectCode the value for pr_project.PROJECT_CODE
     *
     * @mbg.generated Sat Dec 08 02:38:58 CST 2018
     */
    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode == null ? null : projectCode.trim();
        this.projectCodeColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pr_project.PROJECT_CODE:Coloured
     *
     * @param projectCodeColoured the value for pr_project.PROJECT_CODE:Coloured
     *
     * @mbg.generated Sat Dec 08 02:38:58 CST 2018
     */
    public void setProjectCodeColoured(boolean projectCodeColoured) {
        this.projectCodeColoured = projectCodeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pr_project.PROJECT_NAME
     *
     * @return the value of pr_project.PROJECT_NAME
     *
     * @mbg.generated Sat Dec 08 02:38:58 CST 2018
     */
    public String getProjectName() {
        return projectName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pr_project.PROJECT_NAME:Coloured
     *
     * @return the value of pr_project.PROJECT_NAME:Coloured
     *
     * @mbg.generated Sat Dec 08 02:38:58 CST 2018
     */
    public boolean isProjectNameColoured() {
        return projectNameColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pr_project.PROJECT_NAME:Coloured
     *
     * @return the value of pr_project.PROJECT_NAME:Coloured
     *
     * @mbg.generated Sat Dec 08 02:38:58 CST 2018
     */
    public boolean isProjectNameNotColoured() {
        return !projectNameColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pr_project.PROJECT_NAME
     *
     * @param projectName the value for pr_project.PROJECT_NAME
     *
     * @mbg.generated Sat Dec 08 02:38:58 CST 2018
     */
    public void setProjectName(String projectName) {
        this.projectName = projectName == null ? null : projectName.trim();
        this.projectNameColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pr_project.PROJECT_NAME:Coloured
     *
     * @param projectNameColoured the value for pr_project.PROJECT_NAME:Coloured
     *
     * @mbg.generated Sat Dec 08 02:38:58 CST 2018
     */
    public void setProjectNameColoured(boolean projectNameColoured) {
        this.projectNameColoured = projectNameColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pr_project.DW_ID
     *
     * @return the value of pr_project.DW_ID
     *
     * @mbg.generated Sat Dec 08 02:38:58 CST 2018
     */
    public Long getDwId() {
        return dwId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pr_project.DW_ID:Coloured
     *
     * @return the value of pr_project.DW_ID:Coloured
     *
     * @mbg.generated Sat Dec 08 02:38:58 CST 2018
     */
    public boolean isDwIdColoured() {
        return dwIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pr_project.DW_ID:Coloured
     *
     * @return the value of pr_project.DW_ID:Coloured
     *
     * @mbg.generated Sat Dec 08 02:38:58 CST 2018
     */
    public boolean isDwIdNotColoured() {
        return !dwIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pr_project.DW_ID
     *
     * @param dwId the value for pr_project.DW_ID
     *
     * @mbg.generated Sat Dec 08 02:38:58 CST 2018
     */
    public void setDwId(Long dwId) {
        this.dwId = dwId;
        this.dwIdColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pr_project.DW_ID:Coloured
     *
     * @param dwIdColoured the value for pr_project.DW_ID:Coloured
     *
     * @mbg.generated Sat Dec 08 02:38:58 CST 2018
     */
    public void setDwIdColoured(boolean dwIdColoured) {
        this.dwIdColoured = dwIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pr_project.MW_ID
     *
     * @return the value of pr_project.MW_ID
     *
     * @mbg.generated Sat Dec 08 02:38:58 CST 2018
     */
    public Long getMwId() {
        return mwId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pr_project.MW_ID:Coloured
     *
     * @return the value of pr_project.MW_ID:Coloured
     *
     * @mbg.generated Sat Dec 08 02:38:58 CST 2018
     */
    public boolean isMwIdColoured() {
        return mwIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pr_project.MW_ID:Coloured
     *
     * @return the value of pr_project.MW_ID:Coloured
     *
     * @mbg.generated Sat Dec 08 02:38:58 CST 2018
     */
    public boolean isMwIdNotColoured() {
        return !mwIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pr_project.MW_ID
     *
     * @param mwId the value for pr_project.MW_ID
     *
     * @mbg.generated Sat Dec 08 02:38:58 CST 2018
     */
    public void setMwId(Long mwId) {
        this.mwId = mwId;
        this.mwIdColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pr_project.MW_ID:Coloured
     *
     * @param mwIdColoured the value for pr_project.MW_ID:Coloured
     *
     * @mbg.generated Sat Dec 08 02:38:58 CST 2018
     */
    public void setMwIdColoured(boolean mwIdColoured) {
        this.mwIdColoured = mwIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pr_project.CACHE_EXPIRE_DAYS
     *
     * @return the value of pr_project.CACHE_EXPIRE_DAYS
     *
     * @mbg.generated Sat Dec 08 02:38:58 CST 2018
     */
    public Integer getCacheExpireDays() {
        return cacheExpireDays;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pr_project.CACHE_EXPIRE_DAYS:Coloured
     *
     * @return the value of pr_project.CACHE_EXPIRE_DAYS:Coloured
     *
     * @mbg.generated Sat Dec 08 02:38:58 CST 2018
     */
    public boolean isCacheExpireDaysColoured() {
        return cacheExpireDaysColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pr_project.CACHE_EXPIRE_DAYS:Coloured
     *
     * @return the value of pr_project.CACHE_EXPIRE_DAYS:Coloured
     *
     * @mbg.generated Sat Dec 08 02:38:58 CST 2018
     */
    public boolean isCacheExpireDaysNotColoured() {
        return !cacheExpireDaysColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pr_project.CACHE_EXPIRE_DAYS
     *
     * @param cacheExpireDays the value for pr_project.CACHE_EXPIRE_DAYS
     *
     * @mbg.generated Sat Dec 08 02:38:58 CST 2018
     */
    public void setCacheExpireDays(Integer cacheExpireDays) {
        this.cacheExpireDays = cacheExpireDays;
        this.cacheExpireDaysColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pr_project.CACHE_EXPIRE_DAYS:Coloured
     *
     * @param cacheExpireDaysColoured the value for pr_project.CACHE_EXPIRE_DAYS:Coloured
     *
     * @mbg.generated Sat Dec 08 02:38:58 CST 2018
     */
    public void setCacheExpireDaysColoured(boolean cacheExpireDaysColoured) {
        this.cacheExpireDaysColoured = cacheExpireDaysColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pr_project.DESCRIPTION
     *
     * @return the value of pr_project.DESCRIPTION
     *
     * @mbg.generated Sat Dec 08 02:38:58 CST 2018
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pr_project.DESCRIPTION:Coloured
     *
     * @return the value of pr_project.DESCRIPTION:Coloured
     *
     * @mbg.generated Sat Dec 08 02:38:58 CST 2018
     */
    public boolean isDescriptionColoured() {
        return descriptionColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pr_project.DESCRIPTION:Coloured
     *
     * @return the value of pr_project.DESCRIPTION:Coloured
     *
     * @mbg.generated Sat Dec 08 02:38:58 CST 2018
     */
    public boolean isDescriptionNotColoured() {
        return !descriptionColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pr_project.DESCRIPTION
     *
     * @param description the value for pr_project.DESCRIPTION
     *
     * @mbg.generated Sat Dec 08 02:38:58 CST 2018
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
        this.descriptionColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pr_project.DESCRIPTION:Coloured
     *
     * @param descriptionColoured the value for pr_project.DESCRIPTION:Coloured
     *
     * @mbg.generated Sat Dec 08 02:38:58 CST 2018
     */
    public void setDescriptionColoured(boolean descriptionColoured) {
        this.descriptionColoured = descriptionColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pr_project.STATUS
     *
     * @return the value of pr_project.STATUS
     *
     * @mbg.generated Sat Dec 08 02:38:58 CST 2018
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pr_project.STATUS:Coloured
     *
     * @return the value of pr_project.STATUS:Coloured
     *
     * @mbg.generated Sat Dec 08 02:38:58 CST 2018
     */
    public boolean isStatusColoured() {
        return statusColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pr_project.STATUS:Coloured
     *
     * @return the value of pr_project.STATUS:Coloured
     *
     * @mbg.generated Sat Dec 08 02:38:58 CST 2018
     */
    public boolean isStatusNotColoured() {
        return !statusColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pr_project.STATUS
     *
     * @param status the value for pr_project.STATUS
     *
     * @mbg.generated Sat Dec 08 02:38:58 CST 2018
     */
    public void setStatus(Integer status) {
        this.status = status;
        this.statusColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pr_project.STATUS:Coloured
     *
     * @param statusColoured the value for pr_project.STATUS:Coloured
     *
     * @mbg.generated Sat Dec 08 02:38:58 CST 2018
     */
    public void setStatusColoured(boolean statusColoured) {
        this.statusColoured = statusColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pr_project.LAST_UPDATE_TIME
     *
     * @return the value of pr_project.LAST_UPDATE_TIME
     *
     * @mbg.generated Sat Dec 08 02:38:58 CST 2018
     */
    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pr_project.LAST_UPDATE_TIME:Coloured
     *
     * @return the value of pr_project.LAST_UPDATE_TIME:Coloured
     *
     * @mbg.generated Sat Dec 08 02:38:58 CST 2018
     */
    public boolean isLastUpdateTimeColoured() {
        return lastUpdateTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pr_project.LAST_UPDATE_TIME:Coloured
     *
     * @return the value of pr_project.LAST_UPDATE_TIME:Coloured
     *
     * @mbg.generated Sat Dec 08 02:38:58 CST 2018
     */
    public boolean isLastUpdateTimeNotColoured() {
        return !lastUpdateTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pr_project.LAST_UPDATE_TIME
     *
     * @param lastUpdateTime the value for pr_project.LAST_UPDATE_TIME
     *
     * @mbg.generated Sat Dec 08 02:38:58 CST 2018
     */
    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
        this.lastUpdateTimeColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pr_project.LAST_UPDATE_TIME:Coloured
     *
     * @param lastUpdateTimeColoured the value for pr_project.LAST_UPDATE_TIME:Coloured
     *
     * @mbg.generated Sat Dec 08 02:38:58 CST 2018
     */
    public void setLastUpdateTimeColoured(boolean lastUpdateTimeColoured) {
        this.lastUpdateTimeColoured = lastUpdateTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pr_project.LAST_UPDATE_OPER
     *
     * @return the value of pr_project.LAST_UPDATE_OPER
     *
     * @mbg.generated Sat Dec 08 02:38:58 CST 2018
     */
    public String getLastUpdateOper() {
        return lastUpdateOper;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pr_project.LAST_UPDATE_OPER:Coloured
     *
     * @return the value of pr_project.LAST_UPDATE_OPER:Coloured
     *
     * @mbg.generated Sat Dec 08 02:38:58 CST 2018
     */
    public boolean isLastUpdateOperColoured() {
        return lastUpdateOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pr_project.LAST_UPDATE_OPER:Coloured
     *
     * @return the value of pr_project.LAST_UPDATE_OPER:Coloured
     *
     * @mbg.generated Sat Dec 08 02:38:58 CST 2018
     */
    public boolean isLastUpdateOperNotColoured() {
        return !lastUpdateOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pr_project.LAST_UPDATE_OPER
     *
     * @param lastUpdateOper the value for pr_project.LAST_UPDATE_OPER
     *
     * @mbg.generated Sat Dec 08 02:38:58 CST 2018
     */
    public void setLastUpdateOper(String lastUpdateOper) {
        this.lastUpdateOper = lastUpdateOper == null ? null : lastUpdateOper.trim();
        this.lastUpdateOperColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pr_project.LAST_UPDATE_OPER:Coloured
     *
     * @param lastUpdateOperColoured the value for pr_project.LAST_UPDATE_OPER:Coloured
     *
     * @mbg.generated Sat Dec 08 02:38:58 CST 2018
     */
    public void setLastUpdateOperColoured(boolean lastUpdateOperColoured) {
        this.lastUpdateOperColoured = lastUpdateOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pr_project.CREATE_TIME
     *
     * @return the value of pr_project.CREATE_TIME
     *
     * @mbg.generated Sat Dec 08 02:38:58 CST 2018
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pr_project.CREATE_TIME:Coloured
     *
     * @return the value of pr_project.CREATE_TIME:Coloured
     *
     * @mbg.generated Sat Dec 08 02:38:58 CST 2018
     */
    public boolean isCreateTimeColoured() {
        return createTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pr_project.CREATE_TIME:Coloured
     *
     * @return the value of pr_project.CREATE_TIME:Coloured
     *
     * @mbg.generated Sat Dec 08 02:38:58 CST 2018
     */
    public boolean isCreateTimeNotColoured() {
        return !createTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pr_project.CREATE_TIME
     *
     * @param createTime the value for pr_project.CREATE_TIME
     *
     * @mbg.generated Sat Dec 08 02:38:58 CST 2018
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
        this.createTimeColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pr_project.CREATE_TIME:Coloured
     *
     * @param createTimeColoured the value for pr_project.CREATE_TIME:Coloured
     *
     * @mbg.generated Sat Dec 08 02:38:58 CST 2018
     */
    public void setCreateTimeColoured(boolean createTimeColoured) {
        this.createTimeColoured = createTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pr_project.CREATE_OPER
     *
     * @return the value of pr_project.CREATE_OPER
     *
     * @mbg.generated Sat Dec 08 02:38:58 CST 2018
     */
    public String getCreateOper() {
        return createOper;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pr_project.CREATE_OPER:Coloured
     *
     * @return the value of pr_project.CREATE_OPER:Coloured
     *
     * @mbg.generated Sat Dec 08 02:38:58 CST 2018
     */
    public boolean isCreateOperColoured() {
        return createOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pr_project.CREATE_OPER:Coloured
     *
     * @return the value of pr_project.CREATE_OPER:Coloured
     *
     * @mbg.generated Sat Dec 08 02:38:58 CST 2018
     */
    public boolean isCreateOperNotColoured() {
        return !createOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pr_project.CREATE_OPER
     *
     * @param createOper the value for pr_project.CREATE_OPER
     *
     * @mbg.generated Sat Dec 08 02:38:58 CST 2018
     */
    public void setCreateOper(String createOper) {
        this.createOper = createOper == null ? null : createOper.trim();
        this.createOperColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pr_project.CREATE_OPER:Coloured
     *
     * @param createOperColoured the value for pr_project.CREATE_OPER:Coloured
     *
     * @mbg.generated Sat Dec 08 02:38:58 CST 2018
     */
    public void setCreateOperColoured(boolean createOperColoured) {
        this.createOperColoured = createOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pr_project
     *
     * @mbg.generated Sat Dec 08 02:38:58 CST 2018
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
        PrProject other = (PrProject) that;
        return (this.getProjectId() == null ? other.getProjectId() == null : this.getProjectId().equals(other.getProjectId()))
            && (this.getProjectCode() == null ? other.getProjectCode() == null : this.getProjectCode().equals(other.getProjectCode()))
            && (this.getProjectName() == null ? other.getProjectName() == null : this.getProjectName().equals(other.getProjectName()))
            && (this.getDwId() == null ? other.getDwId() == null : this.getDwId().equals(other.getDwId()))
            && (this.getMwId() == null ? other.getMwId() == null : this.getMwId().equals(other.getMwId()))
            && (this.getCacheExpireDays() == null ? other.getCacheExpireDays() == null : this.getCacheExpireDays().equals(other.getCacheExpireDays()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getLastUpdateTime() == null ? other.getLastUpdateTime() == null : this.getLastUpdateTime().equals(other.getLastUpdateTime()))
            && (this.getLastUpdateOper() == null ? other.getLastUpdateOper() == null : this.getLastUpdateOper().equals(other.getLastUpdateOper()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getCreateOper() == null ? other.getCreateOper() == null : this.getCreateOper().equals(other.getCreateOper()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pr_project
     *
     * @mbg.generated Sat Dec 08 02:38:58 CST 2018
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getProjectId() == null) ? 0 : getProjectId().hashCode());
        result = prime * result + ((getProjectCode() == null) ? 0 : getProjectCode().hashCode());
        result = prime * result + ((getProjectName() == null) ? 0 : getProjectName().hashCode());
        result = prime * result + ((getDwId() == null) ? 0 : getDwId().hashCode());
        result = prime * result + ((getMwId() == null) ? 0 : getMwId().hashCode());
        result = prime * result + ((getCacheExpireDays() == null) ? 0 : getCacheExpireDays().hashCode());
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
     * This method corresponds to the database table pr_project
     *
     * @mbg.generated Sat Dec 08 02:38:58 CST 2018
     */
    @Override
    public void copyProperties(Object that) {
        if (this == that || that == null || this.getClass() != that.getClass() ) {
            return;
        }
        PrProject other = (PrProject) that;
        if(other.isProjectIdColoured() ) {this.setProjectId(other.getProjectId() );}
        if(other.isProjectCodeColoured() ) {this.setProjectCode(other.getProjectCode() );}
        if(other.isProjectNameColoured() ) {this.setProjectName(other.getProjectName() );}
        if(other.isDwIdColoured() ) {this.setDwId(other.getDwId() );}
        if(other.isMwIdColoured() ) {this.setMwId(other.getMwId() );}
        if(other.isCacheExpireDaysColoured() ) {this.setCacheExpireDays(other.getCacheExpireDays() );}
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
     * This method corresponds to the database table pr_project
     *
     * @mbg.generated Sat Dec 08 02:38:58 CST 2018
     */
    @Override
    public JSONObject toJSON() {
        HashMap<String, Object> hashMap = new HashMap();
        if(this.projectIdColoured) {hashMap.put("projectId", this.projectId);}
        if(this.projectCodeColoured) {hashMap.put("projectCode", this.projectCode);}
        if(this.projectNameColoured) {hashMap.put("projectName", this.projectName);}
        if(this.dwIdColoured) {hashMap.put("dwId", this.dwId);}
        if(this.mwIdColoured) {hashMap.put("mwId", this.mwId);}
        if(this.cacheExpireDaysColoured) {hashMap.put("cacheExpireDays", this.cacheExpireDays);}
        if(this.descriptionColoured) {hashMap.put("description", this.description);}
        if(this.statusColoured) {hashMap.put("status", this.status);}
        if(this.lastUpdateTimeColoured) {hashMap.put("lastUpdateTime", this.lastUpdateTime);}
        if(this.lastUpdateOperColoured) {hashMap.put("lastUpdateOper", this.lastUpdateOper);}
        if(this.createTimeColoured) {hashMap.put("createTime", this.createTime);}
        if(this.createOperColoured) {hashMap.put("createOper", this.createOper);}
        return (JSONObject) JSON.toJSON(hashMap);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pr_project
     *
     * @mbg.generated Sat Dec 08 02:38:58 CST 2018
     */
    @Override
    public void clear() {
        if(this.projectIdColoured) {this.projectId = null; this.projectIdColoured = false;}
        if(this.projectCodeColoured) {this.projectCode = null; this.projectCodeColoured = false;}
        if(this.projectNameColoured) {this.projectName = null; this.projectNameColoured = false;}
        if(this.dwIdColoured) {this.dwId = null; this.dwIdColoured = false;}
        if(this.mwIdColoured) {this.mwId = null; this.mwIdColoured = false;}
        if(this.cacheExpireDaysColoured) {this.cacheExpireDays = null; this.cacheExpireDaysColoured = false;}
        if(this.descriptionColoured) {this.description = null; this.descriptionColoured = false;}
        if(this.statusColoured) {this.status = null; this.statusColoured = false;}
        if(this.lastUpdateTimeColoured) {this.lastUpdateTime = null; this.lastUpdateTimeColoured = false;}
        if(this.lastUpdateOperColoured) {this.lastUpdateOper = null; this.lastUpdateOperColoured = false;}
        if(this.createTimeColoured) {this.createTime = null; this.createTimeColoured = false;}
        if(this.createOperColoured) {this.createOper = null; this.createOperColoured = false;}
        return;
    }
}