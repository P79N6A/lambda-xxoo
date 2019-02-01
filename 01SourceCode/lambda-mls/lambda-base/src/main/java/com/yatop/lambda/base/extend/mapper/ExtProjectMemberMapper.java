package com.yatop.lambda.base.extend.mapper;

import com.yatop.lambda.base.extend.model.ExtProjectMemberDetail;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ExtProjectMemberMapper {
    @Select(  "   SELECT \n" +
            "  ppm.`MEMBER_USER`,\n" +
            "  ppm.`PROJECT_ROLE`,\n" +
            "  ppm.`CREATE_TIME`,\n" +
            "  u.`EMAIL`,\n" +
            "  u.`MOBILE`,\n" +
            "  u.`STATUS`,\n" +
            "  u.`USER_REL_NAME` \n" +
            "FROM\n" +
            "  pr_project_member ppm,\n" +
            "  sys_manage_user u \n" +
            "WHERE ppm.`PROJECT_ID` = #{projectId} \n" +
            "  AND ppm.`STATUS` = 0 \n" +
            "  AND ppm.`MEMBER_USER` = u.`USERNAME`  ")
    List<ExtProjectMemberDetail> queryProjectMemberList(Long projectId);
}