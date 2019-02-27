package com.yatop.lambda.manager.api.request.project;

import com.yatop.lambda.core.utils.PagerUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * Created by 19016 on 2019/2/1.
 */
@ApiModel(value = "ProjectRequest", description = "项目查询信息")
public class ProjectRequest extends PagerUtil {

    @ApiModelProperty(value = "项目Id",required = false)
    private Long projectId;
    @ApiModelProperty(value = "项目编码",required = false)
    private String projectCode;
    @ApiModelProperty(value = "项目名称",required = false)
    private String projectName;
    @ApiModelProperty(value = "项目描述",required = false)
    private String projectDesc;
    @ApiModelProperty(value = "",required = false)
    private int cacheExpireDays;
    @ApiModelProperty(value = "关键字",required = false)
    private String keyword;
    @ApiModelProperty(value = "清除日期",required = false)
    private Date clearDate;

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectDesc() {
        return projectDesc;
    }

    public void setProjectDesc(String projectDesc) {
        this.projectDesc = projectDesc;
    }

    public int getCacheExpireDays() {
        return cacheExpireDays;
    }

    public void setCacheExpireDays(int cacheExpireDays) {
        this.cacheExpireDays = cacheExpireDays;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Date getClearDate() {
        return clearDate;
    }

    public void setClearDate(Date clearDate) {
        this.clearDate = clearDate;
    }
}
