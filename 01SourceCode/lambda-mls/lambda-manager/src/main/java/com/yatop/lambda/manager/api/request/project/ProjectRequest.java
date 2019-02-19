package com.yatop.lambda.manager.api.request.project;

import com.yatop.lambda.core.utils.PagerUtil;

/**
 * Created by 19016 on 2019/2/1.
 */
public class ProjectRequest extends PagerUtil {

    private Long projectId;
    private String projectCode;
    private String projectName;
    private String projectDesc;
    private int cacheExpireDays;
    private String operUser;
    private String keyword;
    private Integer pageNum;
    private Integer pageSize;

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

    public String getOperUser() {
        return operUser;
    }

    public void setOperUser(String operUser) {
        this.operUser = operUser;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public Integer getPageNum() {
        return pageNum;
    }

    @Override
    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    @Override
    public Integer getPageSize() {
        return pageSize;
    }

    @Override
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
