package com.yatop.lambda.base.model;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yatop.lambda.base.utils.LambdaRootModel;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;

public class DwDataWarehouse extends LambdaRootModel implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dw_data_warehouse.DW_ID
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    private Long dwId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dw_data_warehouse.DW_ID:Coloured
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    private boolean dwIdColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dw_data_warehouse.DW_CODE
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    private String dwCode;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dw_data_warehouse.DW_CODE:Coloured
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    private boolean dwCodeColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dw_data_warehouse.DW_NAME
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    private String dwName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dw_data_warehouse.DW_NAME:Coloured
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    private boolean dwNameColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dw_data_warehouse.DW_TYPE
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    private Integer dwType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dw_data_warehouse.DW_TYPE:Coloured
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    private boolean dwTypeColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dw_data_warehouse.OWNER_PROJECT_ID
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    private Long ownerProjectId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dw_data_warehouse.OWNER_PROJECT_ID:Coloured
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    private boolean ownerProjectIdColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dw_data_warehouse.DATA_DFS_DIR
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    private String dataDfsDir;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dw_data_warehouse.DATA_DFS_DIR:Coloured
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    private boolean dataDfsDirColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dw_data_warehouse.DATA_LOCAL_DIR
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    private String dataLocalDir;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dw_data_warehouse.DATA_LOCAL_DIR:Coloured
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    private boolean dataLocalDirColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dw_data_warehouse.DESCRIPTION
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    private String description;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dw_data_warehouse.DESCRIPTION:Coloured
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    private boolean descriptionColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dw_data_warehouse.STATUS
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    private Integer status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dw_data_warehouse.STATUS:Coloured
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    private boolean statusColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dw_data_warehouse.LAST_UPDATE_TIME
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    private Date lastUpdateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dw_data_warehouse.LAST_UPDATE_TIME:Coloured
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    private boolean lastUpdateTimeColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dw_data_warehouse.LAST_UPDATE_OPER
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    private String lastUpdateOper;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dw_data_warehouse.LAST_UPDATE_OPER:Coloured
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    private boolean lastUpdateOperColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dw_data_warehouse.CREATE_TIME
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dw_data_warehouse.CREATE_TIME:Coloured
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    private boolean createTimeColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dw_data_warehouse.CREATE_OPER
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    private String createOper;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dw_data_warehouse.CREATE_OPER:Coloured
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    private boolean createOperColoured;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table dw_data_warehouse
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dw_data_warehouse.DW_ID
     *
     * @return the value of dw_data_warehouse.DW_ID
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    public Long getDwId() {
        return dwId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dw_data_warehouse.DW_ID:Coloured
     *
     * @return the value of dw_data_warehouse.DW_ID:Coloured
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    public boolean isDwIdColoured() {
        return dwIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dw_data_warehouse.DW_ID
     *
     * @param dwId the value for dw_data_warehouse.DW_ID
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    public void setDwId(Long dwId) {
        this.dwId = dwId;
        this.dwIdColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dw_data_warehouse.DW_ID:Coloured
     *
     * @param dwIdColoured the value for dw_data_warehouse.DW_ID:Coloured
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    public void setDwIdColoured(boolean dwIdColoured) {
        this.dwIdColoured = dwIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dw_data_warehouse.DW_CODE
     *
     * @return the value of dw_data_warehouse.DW_CODE
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    public String getDwCode() {
        return dwCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dw_data_warehouse.DW_CODE:Coloured
     *
     * @return the value of dw_data_warehouse.DW_CODE:Coloured
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    public boolean isDwCodeColoured() {
        return dwCodeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dw_data_warehouse.DW_CODE
     *
     * @param dwCode the value for dw_data_warehouse.DW_CODE
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    public void setDwCode(String dwCode) {
        this.dwCode = dwCode == null ? null : dwCode.trim();
        this.dwCodeColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dw_data_warehouse.DW_CODE:Coloured
     *
     * @param dwCodeColoured the value for dw_data_warehouse.DW_CODE:Coloured
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    public void setDwCodeColoured(boolean dwCodeColoured) {
        this.dwCodeColoured = dwCodeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dw_data_warehouse.DW_NAME
     *
     * @return the value of dw_data_warehouse.DW_NAME
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    public String getDwName() {
        return dwName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dw_data_warehouse.DW_NAME:Coloured
     *
     * @return the value of dw_data_warehouse.DW_NAME:Coloured
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    public boolean isDwNameColoured() {
        return dwNameColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dw_data_warehouse.DW_NAME
     *
     * @param dwName the value for dw_data_warehouse.DW_NAME
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    public void setDwName(String dwName) {
        this.dwName = dwName == null ? null : dwName.trim();
        this.dwNameColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dw_data_warehouse.DW_NAME:Coloured
     *
     * @param dwNameColoured the value for dw_data_warehouse.DW_NAME:Coloured
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    public void setDwNameColoured(boolean dwNameColoured) {
        this.dwNameColoured = dwNameColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dw_data_warehouse.DW_TYPE
     *
     * @return the value of dw_data_warehouse.DW_TYPE
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    public Integer getDwType() {
        return dwType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dw_data_warehouse.DW_TYPE:Coloured
     *
     * @return the value of dw_data_warehouse.DW_TYPE:Coloured
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    public boolean isDwTypeColoured() {
        return dwTypeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dw_data_warehouse.DW_TYPE
     *
     * @param dwType the value for dw_data_warehouse.DW_TYPE
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    public void setDwType(Integer dwType) {
        this.dwType = dwType;
        this.dwTypeColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dw_data_warehouse.DW_TYPE:Coloured
     *
     * @param dwTypeColoured the value for dw_data_warehouse.DW_TYPE:Coloured
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    public void setDwTypeColoured(boolean dwTypeColoured) {
        this.dwTypeColoured = dwTypeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dw_data_warehouse.OWNER_PROJECT_ID
     *
     * @return the value of dw_data_warehouse.OWNER_PROJECT_ID
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    public Long getOwnerProjectId() {
        return ownerProjectId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dw_data_warehouse.OWNER_PROJECT_ID:Coloured
     *
     * @return the value of dw_data_warehouse.OWNER_PROJECT_ID:Coloured
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    public boolean isOwnerProjectIdColoured() {
        return ownerProjectIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dw_data_warehouse.OWNER_PROJECT_ID
     *
     * @param ownerProjectId the value for dw_data_warehouse.OWNER_PROJECT_ID
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    public void setOwnerProjectId(Long ownerProjectId) {
        this.ownerProjectId = ownerProjectId;
        this.ownerProjectIdColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dw_data_warehouse.OWNER_PROJECT_ID:Coloured
     *
     * @param ownerProjectIdColoured the value for dw_data_warehouse.OWNER_PROJECT_ID:Coloured
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    public void setOwnerProjectIdColoured(boolean ownerProjectIdColoured) {
        this.ownerProjectIdColoured = ownerProjectIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dw_data_warehouse.DATA_DFS_DIR
     *
     * @return the value of dw_data_warehouse.DATA_DFS_DIR
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    public String getDataDfsDir() {
        return dataDfsDir;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dw_data_warehouse.DATA_DFS_DIR:Coloured
     *
     * @return the value of dw_data_warehouse.DATA_DFS_DIR:Coloured
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    public boolean isDataDfsDirColoured() {
        return dataDfsDirColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dw_data_warehouse.DATA_DFS_DIR
     *
     * @param dataDfsDir the value for dw_data_warehouse.DATA_DFS_DIR
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    public void setDataDfsDir(String dataDfsDir) {
        this.dataDfsDir = dataDfsDir == null ? null : dataDfsDir.trim();
        this.dataDfsDirColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dw_data_warehouse.DATA_DFS_DIR:Coloured
     *
     * @param dataDfsDirColoured the value for dw_data_warehouse.DATA_DFS_DIR:Coloured
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    public void setDataDfsDirColoured(boolean dataDfsDirColoured) {
        this.dataDfsDirColoured = dataDfsDirColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dw_data_warehouse.DATA_LOCAL_DIR
     *
     * @return the value of dw_data_warehouse.DATA_LOCAL_DIR
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    public String getDataLocalDir() {
        return dataLocalDir;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dw_data_warehouse.DATA_LOCAL_DIR:Coloured
     *
     * @return the value of dw_data_warehouse.DATA_LOCAL_DIR:Coloured
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    public boolean isDataLocalDirColoured() {
        return dataLocalDirColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dw_data_warehouse.DATA_LOCAL_DIR
     *
     * @param dataLocalDir the value for dw_data_warehouse.DATA_LOCAL_DIR
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    public void setDataLocalDir(String dataLocalDir) {
        this.dataLocalDir = dataLocalDir == null ? null : dataLocalDir.trim();
        this.dataLocalDirColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dw_data_warehouse.DATA_LOCAL_DIR:Coloured
     *
     * @param dataLocalDirColoured the value for dw_data_warehouse.DATA_LOCAL_DIR:Coloured
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    public void setDataLocalDirColoured(boolean dataLocalDirColoured) {
        this.dataLocalDirColoured = dataLocalDirColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dw_data_warehouse.DESCRIPTION
     *
     * @return the value of dw_data_warehouse.DESCRIPTION
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dw_data_warehouse.DESCRIPTION:Coloured
     *
     * @return the value of dw_data_warehouse.DESCRIPTION:Coloured
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    public boolean isDescriptionColoured() {
        return descriptionColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dw_data_warehouse.DESCRIPTION
     *
     * @param description the value for dw_data_warehouse.DESCRIPTION
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
        this.descriptionColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dw_data_warehouse.DESCRIPTION:Coloured
     *
     * @param descriptionColoured the value for dw_data_warehouse.DESCRIPTION:Coloured
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    public void setDescriptionColoured(boolean descriptionColoured) {
        this.descriptionColoured = descriptionColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dw_data_warehouse.STATUS
     *
     * @return the value of dw_data_warehouse.STATUS
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dw_data_warehouse.STATUS:Coloured
     *
     * @return the value of dw_data_warehouse.STATUS:Coloured
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    public boolean isStatusColoured() {
        return statusColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dw_data_warehouse.STATUS
     *
     * @param status the value for dw_data_warehouse.STATUS
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    public void setStatus(Integer status) {
        this.status = status;
        this.statusColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dw_data_warehouse.STATUS:Coloured
     *
     * @param statusColoured the value for dw_data_warehouse.STATUS:Coloured
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    public void setStatusColoured(boolean statusColoured) {
        this.statusColoured = statusColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dw_data_warehouse.LAST_UPDATE_TIME
     *
     * @return the value of dw_data_warehouse.LAST_UPDATE_TIME
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dw_data_warehouse.LAST_UPDATE_TIME:Coloured
     *
     * @return the value of dw_data_warehouse.LAST_UPDATE_TIME:Coloured
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    public boolean isLastUpdateTimeColoured() {
        return lastUpdateTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dw_data_warehouse.LAST_UPDATE_TIME
     *
     * @param lastUpdateTime the value for dw_data_warehouse.LAST_UPDATE_TIME
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
        this.lastUpdateTimeColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dw_data_warehouse.LAST_UPDATE_TIME:Coloured
     *
     * @param lastUpdateTimeColoured the value for dw_data_warehouse.LAST_UPDATE_TIME:Coloured
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    public void setLastUpdateTimeColoured(boolean lastUpdateTimeColoured) {
        this.lastUpdateTimeColoured = lastUpdateTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dw_data_warehouse.LAST_UPDATE_OPER
     *
     * @return the value of dw_data_warehouse.LAST_UPDATE_OPER
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    public String getLastUpdateOper() {
        return lastUpdateOper;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dw_data_warehouse.LAST_UPDATE_OPER:Coloured
     *
     * @return the value of dw_data_warehouse.LAST_UPDATE_OPER:Coloured
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    public boolean isLastUpdateOperColoured() {
        return lastUpdateOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dw_data_warehouse.LAST_UPDATE_OPER
     *
     * @param lastUpdateOper the value for dw_data_warehouse.LAST_UPDATE_OPER
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    public void setLastUpdateOper(String lastUpdateOper) {
        this.lastUpdateOper = lastUpdateOper == null ? null : lastUpdateOper.trim();
        this.lastUpdateOperColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dw_data_warehouse.LAST_UPDATE_OPER:Coloured
     *
     * @param lastUpdateOperColoured the value for dw_data_warehouse.LAST_UPDATE_OPER:Coloured
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    public void setLastUpdateOperColoured(boolean lastUpdateOperColoured) {
        this.lastUpdateOperColoured = lastUpdateOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dw_data_warehouse.CREATE_TIME
     *
     * @return the value of dw_data_warehouse.CREATE_TIME
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dw_data_warehouse.CREATE_TIME:Coloured
     *
     * @return the value of dw_data_warehouse.CREATE_TIME:Coloured
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    public boolean isCreateTimeColoured() {
        return createTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dw_data_warehouse.CREATE_TIME
     *
     * @param createTime the value for dw_data_warehouse.CREATE_TIME
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
        this.createTimeColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dw_data_warehouse.CREATE_TIME:Coloured
     *
     * @param createTimeColoured the value for dw_data_warehouse.CREATE_TIME:Coloured
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    public void setCreateTimeColoured(boolean createTimeColoured) {
        this.createTimeColoured = createTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dw_data_warehouse.CREATE_OPER
     *
     * @return the value of dw_data_warehouse.CREATE_OPER
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    public String getCreateOper() {
        return createOper;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dw_data_warehouse.CREATE_OPER:Coloured
     *
     * @return the value of dw_data_warehouse.CREATE_OPER:Coloured
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    public boolean isCreateOperColoured() {
        return createOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dw_data_warehouse.CREATE_OPER
     *
     * @param createOper the value for dw_data_warehouse.CREATE_OPER
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    public void setCreateOper(String createOper) {
        this.createOper = createOper == null ? null : createOper.trim();
        this.createOperColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dw_data_warehouse.CREATE_OPER:Coloured
     *
     * @param createOperColoured the value for dw_data_warehouse.CREATE_OPER:Coloured
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    public void setCreateOperColoured(boolean createOperColoured) {
        this.createOperColoured = createOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dw_data_warehouse
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
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
        DwDataWarehouse other = (DwDataWarehouse) that;
        return (this.getDwId() == null ? other.getDwId() == null : this.getDwId().equals(other.getDwId()))
            && (this.getDwCode() == null ? other.getDwCode() == null : this.getDwCode().equals(other.getDwCode()))
            && (this.getDwName() == null ? other.getDwName() == null : this.getDwName().equals(other.getDwName()))
            && (this.getDwType() == null ? other.getDwType() == null : this.getDwType().equals(other.getDwType()))
            && (this.getOwnerProjectId() == null ? other.getOwnerProjectId() == null : this.getOwnerProjectId().equals(other.getOwnerProjectId()))
            && (this.getDataDfsDir() == null ? other.getDataDfsDir() == null : this.getDataDfsDir().equals(other.getDataDfsDir()))
            && (this.getDataLocalDir() == null ? other.getDataLocalDir() == null : this.getDataLocalDir().equals(other.getDataLocalDir()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getLastUpdateTime() == null ? other.getLastUpdateTime() == null : this.getLastUpdateTime().equals(other.getLastUpdateTime()))
            && (this.getLastUpdateOper() == null ? other.getLastUpdateOper() == null : this.getLastUpdateOper().equals(other.getLastUpdateOper()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getCreateOper() == null ? other.getCreateOper() == null : this.getCreateOper().equals(other.getCreateOper()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dw_data_warehouse
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDwId() == null) ? 0 : getDwId().hashCode());
        result = prime * result + ((getDwCode() == null) ? 0 : getDwCode().hashCode());
        result = prime * result + ((getDwName() == null) ? 0 : getDwName().hashCode());
        result = prime * result + ((getDwType() == null) ? 0 : getDwType().hashCode());
        result = prime * result + ((getOwnerProjectId() == null) ? 0 : getOwnerProjectId().hashCode());
        result = prime * result + ((getDataDfsDir() == null) ? 0 : getDataDfsDir().hashCode());
        result = prime * result + ((getDataLocalDir() == null) ? 0 : getDataLocalDir().hashCode());
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
     * This method corresponds to the database table dw_data_warehouse
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    @Override
    public void copyProperties(Object that) {
        if (this == that || that == null || this.getClass() != that.getClass() ) {
            return;
        }
        DwDataWarehouse other = (DwDataWarehouse) that;
        if(other.isDwIdColoured() ) {this.setDwId(other.getDwId() );}
        if(other.isDwCodeColoured() ) {this.setDwCode(other.getDwCode() );}
        if(other.isDwNameColoured() ) {this.setDwName(other.getDwName() );}
        if(other.isDwTypeColoured() ) {this.setDwType(other.getDwType() );}
        if(other.isOwnerProjectIdColoured() ) {this.setOwnerProjectId(other.getOwnerProjectId() );}
        if(other.isDataDfsDirColoured() ) {this.setDataDfsDir(other.getDataDfsDir() );}
        if(other.isDataLocalDirColoured() ) {this.setDataLocalDir(other.getDataLocalDir() );}
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
     * This method corresponds to the database table dw_data_warehouse
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    @Override
    public JSONObject toJSON() {
        HashMap<String, Object> hashMap = new HashMap();
        if(this.dwIdColoured) {hashMap.put("dwId", this.dwId);}
        if(this.dwCodeColoured) {hashMap.put("dwCode", this.dwCode);}
        if(this.dwNameColoured) {hashMap.put("dwName", this.dwName);}
        if(this.dwTypeColoured) {hashMap.put("dwType", this.dwType);}
        if(this.ownerProjectIdColoured) {hashMap.put("ownerProjectId", this.ownerProjectId);}
        if(this.dataDfsDirColoured) {hashMap.put("dataDfsDir", this.dataDfsDir);}
        if(this.dataLocalDirColoured) {hashMap.put("dataLocalDir", this.dataLocalDir);}
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
     * This method corresponds to the database table dw_data_warehouse
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    @Override
    public void clear() {
        if(this.dwIdColoured) {this.dwId = null; this.dwIdColoured = false;}
        if(this.dwCodeColoured) {this.dwCode = null; this.dwCodeColoured = false;}
        if(this.dwNameColoured) {this.dwName = null; this.dwNameColoured = false;}
        if(this.dwTypeColoured) {this.dwType = null; this.dwTypeColoured = false;}
        if(this.ownerProjectIdColoured) {this.ownerProjectId = null; this.ownerProjectIdColoured = false;}
        if(this.dataDfsDirColoured) {this.dataDfsDir = null; this.dataDfsDirColoured = false;}
        if(this.dataLocalDirColoured) {this.dataLocalDir = null; this.dataLocalDirColoured = false;}
        if(this.descriptionColoured) {this.description = null; this.descriptionColoured = false;}
        if(this.statusColoured) {this.status = null; this.statusColoured = false;}
        if(this.lastUpdateTimeColoured) {this.lastUpdateTime = null; this.lastUpdateTimeColoured = false;}
        if(this.lastUpdateOperColoured) {this.lastUpdateOper = null; this.lastUpdateOperColoured = false;}
        if(this.createTimeColoured) {this.createTime = null; this.createTimeColoured = false;}
        if(this.createOperColoured) {this.createOper = null; this.createOperColoured = false;}
        return;
    }
}