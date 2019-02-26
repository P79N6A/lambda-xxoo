package com.yatop.lambda.base.extend.mapper;

import com.yatop.lambda.base.extend.model.ExtProjectMemberDetail;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ExtProjectMemberMapper {
    @Select(  "  SELECT  ppm.`MEMBER_USER` memberUser, " +
            "  ppm.`PROJECT_ROLE` projectRole, " +
            "  ppm.`CREATE_TIME` createTime, " +
            "  u.`EMAIL`, " +
            "  u.`MOBILE`, " +
            "  u.`SSEX`, " +
            "  u.`REALNAME` realname, " +
            "  dept.`DEPT_ID` deptId, " +
            "  dept.`DEPT_NAME` deptName, " +
            "  ppm.`STATUS` " +
            " FROM " +
            "  pr_project_member ppm, " +
            "  t_user u , " +
            "  t_dept dept " +
            "WHERE ppm.`PROJECT_ID` = #{projectId}" +
            "  AND u.`DEPT_ID` = dept.`DEPT_ID` " +
            "  AND ppm.`STATUS` = 0  " +
            "  AND ppm.`MEMBER_USER` = u.`USERNAME`  " +
            "  AND ppm.`PROJECT_ROLE` IN (0,1,2) " +
            "  AND ppm.`MEMBER_USER` LIKE #{memberUser} ")
    List<ExtProjectMemberDetail> queryProjectMemberList(@Param("projectId") Long projectId, @Param("memberUser") String memberUser);


    @Select(  "  SELECT " +
            "  u.`USERNAME`, " +
            "  u.`REALNAME` " +
            " FROM " +
            "  t_user u  " +
            "   left join pr_project_member m " +
            "   on u.username =  m.member_user and m.project_id = #{projectId}  " +
            "WHERE (m.member_user is null" +
            "  or m.status = '1') " +
            "  AND u.`USERNAME` LIKE #{memberUser} ")
    List<ExtProjectMemberDetail> queryUserListNotInProject(@Param("projectId") Long projectId, @Param("memberUser") String memberUser);
}