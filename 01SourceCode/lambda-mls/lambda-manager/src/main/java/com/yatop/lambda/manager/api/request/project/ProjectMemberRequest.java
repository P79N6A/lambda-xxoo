package com.yatop.lambda.manager.api.request.project;

import com.yatop.lambda.core.utils.PagerUtil;

import java.util.List;

/**
 * Created by 19016 on 2019/2/14.
 */
public class ProjectMemberRequest extends PagerUtil {
    private Long projectId;
    private List<String> memberUsers;
    private String operUser;
    private String memberUser;
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
