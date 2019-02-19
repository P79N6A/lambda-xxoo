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
            "  u.`STATUS` " +
            " FROM " +
            "  pr_project_member ppm, " +
            "  sys_manage_user u  " +
            "WHERE ppm.`PROJECT_ID` = #{projectId}" +
            "  AND ppm.`STATUS` = 0  " +
            "  AND ppm.`MEMBER_USER` = u.`USERNAME`  " +
            "  AND ppm.`PROJECT_ROLE` IN (0,1) " +
            "  AND ppm.`MEMBER_USER` LIKE #{memberUser} ")
    List<ExtProjectMemberDetail> queryProjectMemberList(@Param("projectId") Long projectId, @Param("memberUser") String memberUser);
}