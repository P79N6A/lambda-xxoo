package com.yatop.lambda.manager.api.request.member;

import java.util.List;

/**
 * Created by 19016 on 2019/2/14.
 */
public class MemberRequest {
    private Long projectId;
    private List<String> memberUsers;
    private String operUser;
    private String memberUser;
    private Integer pageNum;
    private Integer pageSize;
    private String srcOwner;
    private String dstOwner;

    public String getSrcOwner() {
        return srcOwner;
    }

    public void setSrcOwner(String srcOwner) {
        this.srcOwner = srcOwner;
    }

    public String getDstOwner() {
        return dstOwner;
    }

    public void setDstOwner(String dstOwner) {
        this.dstOwner = dstOwner;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public List<String> getMemberUsers() {
        return memberUsers;
    }

    public void setMemberUsers(List<String> memberUsers) {
        this.memberUsers = memberUsers;
    }

    public String getOperUser() {
        return operUser;
    }

    public void setOperUser(String operUser) {
        this.operUser = operUser;
    }

    public String getMemberUser() {
        return memberUser;
    }

    public void setMemberUser(String memberUser) {
        this.memberUser = memberUser;
    }
}
