package com.yatop.lambda.base.model;

import com.alibaba.fastjson.JSONObject;
import com.yatop.lambda.base.utils.LambdaRootModel;
import java.io.Serializable;
import java.util.Date;

public class PrProjectMember extends LambdaRootModel implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pr_project_member.PROJECT_ID
     *
     * @mbg.generated Tue Jan 01 18:06:32 CST 2019
     */
    private Long projectId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pr_project_member.PROJECT_ID:Coloured
     *
     * @mbg.generated Tue Jan 01 18:06:32 CST 2019
     */
    private boolean projectIdColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pr_project_member.PROJECT_ROLE
     *
     * @mbg.generated Tue Jan 01 18:06:32 CST 2019
     */
    private Integer projectRole;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pr_project_member.PROJECT_ROLE:Coloured
     *
     * @mbg.generated Tue Jan 01 18:06:32 CST 2019
     */
    private boolean projectRoleColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pr_project_member.MEMBER_USER
     *
     * @mbg.generated Tue Jan 01 18:06:32 CST 2019
     */
    private String memberUser;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pr_project_member.MEMBER_USER:Coloured
     *
     * @mbg.generated Tue Jan 01 18:06:32 CST 2019
     */
    private boolean memberUserColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pr_project_member.DESCRIPTION
     *
     * @mbg.generated Tue Jan 01 18:06:32 CST 2019
     */
    private String description;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pr_project_member.DESCRIPTION:Coloured
     *
     * @mbg.generated Tue Jan 01 18:06:32 CST 2019
     */
    private boolean descriptionColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pr_project_member.STATUS
     *
     * @mbg.generated Tue Jan 01 18:06:32 CST 2019
     */
    private Integer status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pr_project_member.STATUS:Coloured
     *
     * @mbg.generated Tue Jan 01 18:06:32 CST 2019
     */
    private boolean statusColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pr_project_member.LAST_UPDATE_TIME
     *
     * @mbg.generated Tue Jan 01 18:06:32 CST 2019
     */
    private Date lastUpdateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pr_project_member.LAST_UPDATE_TIME:Coloured
     *
     * @mbg.generated Tue Jan 01 18:06:32 CST 2019
     */
    private boolean lastUpdateTimeColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pr_project_member.LAST_UPDATE_OPER
     *
     * @mbg.generated Tue Jan 01 18:06:32 CST 2019
     */
    private String lastUpdateOper;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pr_project_member.LAST_UPDATE_OPER:Coloured
     *
     * @mbg.generated Tue Jan 01 18:06:32 CST 2019
     */
    private boolean lastUpdateOperColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pr_project_member.CREATE_TIME
     *
     * @mbg.generated Tue Jan 01 18:06:32 CST 2019
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pr_project_member.CREATE_TIME:Coloured
     *
     * @mbg.generated Tue Jan 01 18:06:32 CST 2019
     */
    private boolean createTimeColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pr_project_member.CREATE_OPER
     *
     * @mbg.generated Tue Jan 01 18:06:32 CST 2019
     */
    private String createOper;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pr_project_member.CREATE_OPER:Coloured
     *
     * @mbg.generated Tue Jan 01 18:06:32 CST 2019
     */
    private boolean createOperColoured;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table pr_project_member
     *
     * @mbg.generated Tue Jan 01 18:06:32 CST 2019
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pr_project_member.PROJECT_ID
     *
     * @return the value of pr_project_member.PROJECT_ID
     *
     * @mbg.generated Tue Jan 01 18:06:32 CST 2019
     */
    public Long getProjectId() {
        return projectId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pr_project_member.PROJECT_ID:Coloured
     *
     * @return the value of pr_project_member.PROJECT_ID:Coloured
     *
     * @mbg.generated Tue Jan 01 18:06:32 CST 2019
     */
    public boolean isProjectIdColoured() {
        return projectIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pr_project_member.PROJECT_ID:Coloured
     *
     * @return the value of pr_project_member.PROJECT_ID:Coloured
     *
     * @mbg.generated Tue Jan 01 18:06:32 CST 2019
     */
    public boolean isProjectIdNotColoured() {
        return !projectIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pr_project_member.PROJECT_ID
     *
     * @param projectId the value for pr_project_member.PROJECT_ID
     *
     * @mbg.generated Tue Jan 01 18:06:32 CST 2019
     */
    public void setProjectId(Long projectId) {
        this.projectId = projectId;
        this.projectIdColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pr_project_member.PROJECT_ID:Coloured
     *
     * @param projectIdColoured the value for pr_project_member.PROJECT_ID:Coloured
     *
     * @mbg.generated Tue Jan 01 18:06:32 CST 2019
     */
    public void setProjectIdColoured(boolean projectIdColoured) {
        this.projectIdColoured = projectIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pr_project_member.PROJECT_ROLE
     *
     * @return the value of pr_project_member.PROJECT_ROLE
     *
     * @mbg.generated Tue Jan 01 18:06:32 CST 2019
     */
    public Integer getProjectRole() {
        return projectRole;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pr_project_member.PROJECT_ROLE:Coloured
     *
     * @return the value of pr_project_member.PROJECT_ROLE:Coloured
     *
     * @mbg.generated Tue Jan 01 18:06:32 CST 2019
     */
    public boolean isProjectRoleColoured() {
        return projectRoleColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pr_project_member.PROJECT_ROLE:Coloured
     *
     * @return the value of pr_project_member.PROJECT_ROLE:Coloured
     *
     * @mbg.generated Tue Jan 01 18:06:32 CST 2019
     */
    public boolean isProjectRoleNotColoured() {
        return !projectRoleColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pr_project_member.PROJECT_ROLE
     *
     * @param projectRole the value for pr_project_member.PROJECT_ROLE
     *
     * @mbg.generated Tue Jan 01 18:06:32 CST 2019
     */
    public void setProjectRole(Integer projectRole) {
        this.projectRole = projectRole;
        this.projectRoleColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pr_project_member.PROJECT_ROLE:Coloured
     *
     * @param projectRoleColoured the value for pr_project_member.PROJECT_ROLE:Coloured
     *
     * @mbg.generated Tue Jan 01 18:06:32 CST 2019
     */
    public void setProjectRoleColoured(boolean projectRoleColoured) {
        this.projectRoleColoured = projectRoleColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pr_project_member.MEMBER_USER
     *
     * @return the value of pr_project_member.MEMBER_USER
     *
     * @mbg.generated Tue Jan 01 18:06:32 CST 2019
     */
    public String getMemberUser() {
        return memberUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pr_project_member.MEMBER_USER:Coloured
     *
     * @return the value of pr_project_member.MEMBER_USER:Coloured
     *
     * @mbg.generated Tue Jan 01 18:06:32 CST 2019
     */
    public boolean isMemberUserColoured() {
        return memberUserColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pr_project_member.MEMBER_USER:Coloured
     *
     * @return the value of pr_project_member.MEMBER_USER:Coloured
     *
     * @mbg.generated Tue Jan 01 18:06:32 CST 2019
     */
    public boolean isMemberUserNotColoured() {
        return !memberUserColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pr_project_member.MEMBER_USER
     *
     * @param memberUser the value for pr_project_member.MEMBER_USER
     *
     * @mbg.generated Tue Jan 01 18:06:32 CST 2019
     */
    public void setMemberUser(String memberUser) {
        this.memberUser = memberUser == null ? null : memberUser.trim();
        this.memberUserColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pr_project_member.MEMBER_USER:Coloured
     *
     * @param memberUserColoured the value for pr_project_member.MEMBER_USER:Coloured
     *
     * @mbg.generated Tue Jan 01 18:06:32 CST 2019
     */
    public void setMemberUserColoured(boolean memberUserColoured) {
        this.memberUserColoured = memberUserColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pr_project_member.DESCRIPTION
     *
     * @return the value of pr_project_member.DESCRIPTION
     *
     * @mbg.generated Tue Jan 01 18:06:32 CST 2019
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pr_project_member.DESCRIPTION:Coloured
     *
     * @return the value of pr_project_member.DESCRIPTION:Coloured
     *
     * @mbg.generated Tue Jan 01 18:06:32 CST 2019
     */
    public boolean isDescriptionColoured() {
        return descriptionColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pr_project_member.DESCRIPTION:Coloured
     *
     * @return the value of pr_project_member.DESCRIPTION:Coloured
     *
     * @mbg.generated Tue Jan 01 18:06:32 CST 2019
     */
    public boolean isDescriptionNotColoured() {
        return !descriptionColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pr_project_member.DESCRIPTION
     *
     * @param description the value for pr_project_member.DESCRIPTION
     *
     * @mbg.generated Tue Jan 01 18:06:32 CST 2019
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
        this.descriptionColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pr_project_member.DESCRIPTION:Coloured
     *
     * @param descriptionColoured the value for pr_project_member.DESCRIPTION:Coloured
     *
     * @mbg.generated Tue Jan 01 18:06:32 CST 2019
     */
    public void setDescriptionColoured(boolean descriptionColoured) {
        this.descriptionColoured = descriptionColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pr_project_member.STATUS
     *
     * @return the value of pr_project_member.STATUS
     *
     * @mbg.generated Tue Jan 01 18:06:32 CST 2019
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pr_project_member.STATUS:Coloured
     *
     * @return the value of pr_project_member.STATUS:Coloured
     *
     * @mbg.generated Tue Jan 01 18:06:32 CST 2019
     */
    public boolean isStatusColoured() {
        return statusColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pr_project_member.STATUS:Coloured
     *
     * @return the value of pr_project_member.STATUS:Coloured
     *
     * @mbg.generated Tue Jan 01 18:06:32 CST 2019
     */
    public boolean isStatusNotColoured() {
        return !statusColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pr_project_member.STATUS
     *
     * @param status the value for pr_project_member.STATUS
     *
     * @mbg.generated Tue Jan 01 18:06:32 CST 2019
     */
    public void setStatus(Integer status) {
        this.status = status;
        this.statusColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pr_project_member.STATUS:Coloured
     *
     * @param statusColoured the value for pr_project_member.STATUS:Coloured
     *
     * @mbg.generated Tue Jan 01 18:06:32 CST 2019
     */
    public void setStatusColoured(boolean statusColoured) {
        this.statusColoured = statusColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pr_project_member.LAST_UPDATE_TIME
     *
     * @return the value of pr_project_member.LAST_UPDATE_TIME
     *
     * @mbg.generated Tue Jan 01 18:06:32 CST 2019
     */
    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pr_project_member.LAST_UPDATE_TIME:Coloured
     *
     * @return the value of pr_project_member.LAST_UPDATE_TIME:Coloured
     *
     * @mbg.generated Tue Jan 01 18:06:32 CST 2019
     */
    public boolean isLastUpdateTimeColoured() {
        return lastUpdateTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pr_project_member.LAST_UPDATE_TIME:Coloured
     *
     * @return the value of pr_project_member.LAST_UPDATE_TIME:Coloured
     *
     * @mbg.generated Tue Jan 01 18:06:32 CST 2019
     */
    public boolean isLastUpdateTimeNotColoured() {
        return !lastUpdateTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pr_project_member.LAST_UPDATE_TIME
     *
     * @param lastUpdateTime the value for pr_project_member.LAST_UPDATE_TIME
     *
     * @mbg.generated Tue Jan 01 18:06:32 CST 2019
     */
    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
        this.lastUpdateTimeColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pr_project_member.LAST_UPDATE_TIME:Coloured
     *
     * @param lastUpdateTimeColoured the value for pr_project_member.LAST_UPDATE_TIME:Coloured
     *
     * @mbg.generated Tue Jan 01 18:06:32 CST 2019
     */
    public void setLastUpdateTimeColoured(boolean lastUpdateTimeColoured) {
        this.lastUpdateTimeColoured = lastUpdateTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pr_project_member.LAST_UPDATE_OPER
     *
     * @return the value of pr_project_member.LAST_UPDATE_OPER
     *
     * @mbg.generated Tue Jan 01 18:06:32 CST 2019
     */
    public String getLastUpdateOper() {
        return lastUpdateOper;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pr_project_member.LAST_UPDATE_OPER:Coloured
     *
     * @return the value of pr_project_member.LAST_UPDATE_OPER:Coloured
     *
     * @mbg.generated Tue Jan 01 18:06:32 CST 2019
     */
    public boolean isLastUpdateOperColoured() {
        return lastUpdateOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pr_project_member.LAST_UPDATE_OPER:Coloured
     *
     * @return the value of pr_project_member.LAST_UPDATE_OPER:Coloured
     *
     * @mbg.generated Tue Jan 01 18:06:32 CST 2019
     */
    public boolean isLastUpdateOperNotColoured() {
        return !lastUpdateOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pr_project_member.LAST_UPDATE_OPER
     *
     * @param lastUpdateOper the value for pr_project_member.LAST_UPDATE_OPER
     *
     * @mbg.generated Tue Jan 01 18:06:32 CST 2019
     */
    public void setLastUpdateOper(String lastUpdateOper) {
        this.lastUpdateOper = lastUpdateOper == null ? null : lastUpdateOper.trim();
        this.lastUpdateOperColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pr_project_member.LAST_UPDATE_OPER:Coloured
     *
     * @param lastUpdateOperColoured the value for pr_project_member.LAST_UPDATE_OPER:Coloured
     *
     * @mbg.generated Tue Jan 01 18:06:32 CST 2019
     */
    public void setLastUpdateOperColoured(boolean lastUpdateOperColoured) {
        this.lastUpdateOperColoured = lastUpdateOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pr_project_member.CREATE_TIME
     *
     * @return the value of pr_project_member.CREATE_TIME
     *
     * @mbg.generated Tue Jan 01 18:06:32 CST 2019
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pr_project_member.CREATE_TIME:Coloured
     *
     * @return the value of pr_project_member.CREATE_TIME:Coloured
     *
     * @mbg.generated Tue Jan 01 18:06:32 CST 2019
     */
    public boolean isCreateTimeColoured() {
        return createTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pr_project_member.CREATE_TIME:Coloured
     *
     * @return the value of pr_project_member.CREATE_TIME:Coloured
     *
     * @mbg.generated Tue Jan 01 18:06:32 CST 2019
     */
    public boolean isCreateTimeNotColoured() {
        return !createTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pr_project_member.CREATE_TIME
     *
     * @param createTime the value for pr_project_member.CREATE_TIME
     *
     * @mbg.generated Tue Jan 01 18:06:32 CST 2019
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
        this.createTimeColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pr_project_member.CREATE_TIME:Coloured
     *
     * @param createTimeColoured the value for pr_project_member.CREATE_TIME:Coloured
     *
     * @mbg.generated Tue Jan 01 18:06:32 CST 2019
     */
    public void setCreateTimeColoured(boolean createTimeColoured) {
        this.createTimeColoured = createTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pr_project_member.CREATE_OPER
     *
     * @return the value of pr_project_member.CREATE_OPER
     *
     * @mbg.generated Tue Jan 01 18:06:32 CST 2019
     */
    public String getCreateOper() {
        return createOper;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pr_project_member.CREATE_OPER:Coloured
     *
     * @return the value of pr_project_member.CREATE_OPER:Coloured
     *
     * @mbg.generated Tue Jan 01 18:06:32 CST 2019
     */
    public boolean isCreateOperColoured() {
        return createOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pr_project_member.CREATE_OPER:Coloured
     *
     * @return the value of pr_project_member.CREATE_OPER:Coloured
     *
     * @mbg.generated Tue Jan 01 18:06:32 CST 2019
     */
    public boolean isCreateOperNotColoured() {
        return !createOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pr_project_member.CREATE_OPER
     *
     * @param createOper the value for pr_project_member.CREATE_OPER
     *
     * @mbg.generated Tue Jan 01 18:06:32 CST 2019
     */
    public void setCreateOper(String createOper) {
        this.createOper = createOper == null ? null : createOper.trim();
        this.createOperColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pr_project_member.CREATE_OPER:Coloured
     *
     * @param createOperColoured the value for pr_project_member.CREATE_OPER:Coloured
     *
     * @mbg.generated Tue Jan 01 18:06:32 CST 2019
     */
    public void setCreateOperColoured(boolean createOperColoured) {
        this.createOperColoured = createOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pr_project_member
     *
     * @mbg.generated Tue Jan 01 18:06:32 CST 2019
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if(!(that instanceof PrProjectMember)) {
            return false;
        }
        PrProjectMember other = (PrProjectMember) that;
        return (this.getProjectId() == null ? other.getProjectId() == null : this.getProjectId().equals(other.getProjectId()))
            && (this.getProjectRole() == null ? other.getProjectRole() == null : this.getProjectRole().equals(other.getProjectRole()))
            && (this.getMemberUser() == null ? other.getMemberUser() == null : this.getMemberUser().equals(other.getMemberUser()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getLastUpdateTime() == null ? other.getLastUpdateTime() == null : this.getLastUpdateTime().equals(other.getLastUpdateTime()))
            && (this.getLastUpdateOper() == null ? other.getLastUpdateOper() == null : this.getLastUpdateOper().equals(other.getLastUpdateOper()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getCreateOper() == null ? other.getCreateOper() == null : this.getCreateOper().equals(other.getCreateOper()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pr_project_member
     *
     * @mbg.generated Tue Jan 01 18:06:32 CST 2019
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getProjectId() == null) ? 0 : getProjectId().hashCode());
        result = prime * result + ((getProjectRole() == null) ? 0 : getProjectRole().hashCode());
        result = prime * result + ((getMemberUser() == null) ? 0 : getMemberUser().hashCode());
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
     * This method corresponds to the database table pr_project_member
     *
     * @mbg.generated Tue Jan 01 18:06:32 CST 2019
     */
    public void copyProperties(PrProjectMember that) {
        if (this == that || that == null) {
            return;
        }
        if(that.isProjectIdColoured() ) {this.setProjectId(that.getProjectId() );}
        if(that.isProjectRoleColoured() ) {this.setProjectRole(that.getProjectRole() );}
        if(that.isMemberUserColoured() ) {this.setMemberUser(that.getMemberUser() );}
        if(that.isDescriptionColoured() ) {this.setDescription(that.getDescription() );}
        if(that.isStatusColoured() ) {this.setStatus(that.getStatus() );}
        if(that.isLastUpdateTimeColoured() ) {this.setLastUpdateTime(that.getLastUpdateTime() );}
        if(that.isLastUpdateOperColoured() ) {this.setLastUpdateOper(that.getLastUpdateOper() );}
        if(that.isCreateTimeColoured() ) {this.setCreateTime(that.getCreateTime() );}
        if(that.isCreateOperColoured() ) {this.setCreateOper(that.getCreateOper() );}
        return;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pr_project_member
     *
     * @mbg.generated Tue Jan 01 18:06:32 CST 2019
     */
    @Override
    public JSONObject toJSON() {
        JSONObject jsonObj = new JSONObject(32, true);
        if(this.projectId != null) {jsonObj.put("projectId", this.projectId);}
        if(this.projectRole != null) {jsonObj.put("projectRole", this.projectRole);}
        if(this.memberUser != null) {jsonObj.put("memberUser", this.memberUser);}
        if(this.description != null) {jsonObj.put("description", this.description);}
        if(this.status != null) {jsonObj.put("status", this.status);}
        if(this.lastUpdateTime != null) {jsonObj.put("lastUpdateTime", this.lastUpdateTime);}
        if(this.lastUpdateOper != null) {jsonObj.put("lastUpdateOper", this.lastUpdateOper);}
        if(this.createTime != null) {jsonObj.put("createTime", this.createTime);}
        if(this.createOper != null) {jsonObj.put("createOper", this.createOper);}
        return jsonObj;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pr_project_member
     *
     * @mbg.generated Tue Jan 01 18:06:32 CST 2019
     */
    @Override
    public void clear() {
         this.projectId = null; this.projectIdColoured = false;
         this.projectRole = null; this.projectRoleColoured = false;
         this.memberUser = null; this.memberUserColoured = false;
         this.description = null; this.descriptionColoured = false;
         this.status = null; this.statusColoured = false;
         this.lastUpdateTime = null; this.lastUpdateTimeColoured = false;
         this.lastUpdateOper = null; this.lastUpdateOperColoured = false;
         this.createTime = null; this.createTimeColoured = false;
         this.createOper = null; this.createOperColoured = false;
        return;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pr_project_member
     *
     * @mbg.generated Tue Jan 01 18:06:32 CST 2019
     */
    @Override
    public void clearColoured() {
        this.projectIdColoured = false;
        this.projectRoleColoured = false;
        this.memberUserColoured = false;
        this.descriptionColoured = false;
        this.statusColoured = false;
        this.lastUpdateTimeColoured = false;
        this.lastUpdateOperColoured = false;
        this.createTimeColoured = false;
        this.createOperColoured = false;
        return;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pr_project_member
     *
     * @mbg.generated Tue Jan 01 18:06:32 CST 2019
     */
    @Override
    public boolean isColoured() {
        if(this.projectIdColoured) return true;
        if(this.projectRoleColoured) return true;
        if(this.memberUserColoured) return true;
        if(this.descriptionColoured) return true;
        if(this.statusColoured) return true;
        if(this.lastUpdateTimeColoured) return true;
        if(this.lastUpdateOperColoured) return true;
        if(this.createTimeColoured) return true;
        if(this.createOperColoured) return true;
        return false;
    }
}