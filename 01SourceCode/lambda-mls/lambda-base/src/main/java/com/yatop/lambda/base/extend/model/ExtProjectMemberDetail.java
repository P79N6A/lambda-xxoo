package com.yatop.lambda.base.extend.model;


import com.alibaba.fastjson.JSONObject;
import com.yatop.lambda.base.model.PrProjectMember;

import java.util.Date;


public class ExtProjectMemberDetail extends PrProjectMember {

    private static final long serialVersionUID = -8078831798548519162L;
    private String username;
    private String realname;
    private String email;
    private String mobile;
    private String deptId;
    private String deptName;
    private String ssex;
    private String userStatus;
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getSsex() {
        return ssex;
    }

    public void setSsex(String ssex) {
        this.ssex = ssex;
    }


    @Override
    public JSONObject toJSON() {
        JSONObject jsonObj = super.toJSON();
        if(this.ssex != null) {jsonObj.put("ssex", this.ssex);}
        if(this.realname != null) {jsonObj.put("realname", this.realname);}
        if(this.email != null) {jsonObj.put("email", this.email);}
        if(this.mobile != null) {jsonObj.put("mobile", this.mobile);}
        if(this.deptId != null) {jsonObj.put("deptId", this.deptId);}
        if(this.deptName != null) {jsonObj.put("deptName", this.deptName);}
        return jsonObj;
    }
}
