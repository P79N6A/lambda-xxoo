package com.yatop.lambda.base.extend.mapper;

import com.yatop.lambda.base.extend.model.ExtProjectDetail;
import com.yatop.lambda.base.model.PrProject;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ExtProjectMapper {

    @Select(  "     SELECT                                                                                             " +
              "         x.`PROJECT_ID` as projectId,                                                                   " +
              "         x.`PROJECT_CODE` as projectCode,                                                               " +
              "         x.`PROJECT_NAME` as projectName,                                                               " +
              "         x.`DW_ID` as dwId,                                                                             " +
              "         x.`MW_ID` as mwId,                                                                             " +
              "         x.`CACHE_EXPIRE_DAYS` as cacheExpireDays,                                                      " +
              "         x.`DESCRIPTION` as description,                                                                " +
              "         x.`STATUS` as status,                                                                          " +
              "         x.`LAST_UPDATE_TIME` as lastUpdateTime,                                                        " +
              "         x.`LAST_UPDATE_OPER` as lastUpdateOper,                                                        " +
              "         x.`CREATE_TIME` as createTime,                                                                 " +
              "         x.`CREATE_OPER` as createOper,                                                                  " +
              "         u.`USERNAME` as ownerUserName,                                                                       " +
              "         u.`REALNAME` as ownerRealName                                                                        " +
              "     FROM                                                                                               " +
              "         pr_project x,                                                                                  " +
              "         pr_project_member y ,                                                                           " +
              "         pr_project_member o,                                                                            " +
              "         t_user u                                                                                        " +
              "     WHERE                                                                                              " +
              "           y.MEMBER_USER = #{user}                                                                      " +
            "         AND y.`STATUS` = #{status}                                                                       " +
            "         AND x.PROJECT_ID = y.PROJECT_ID                                                                  " +
            "         AND x.PROJECT_ID = o.PROJECT_ID  AND o.PROJECT_ROLE = 0  AND  o.`STATUS` = #{status}             " +
            "         AND o.MEMBER_USER = u.USERNAME                                                                   " +
            "         AND x.`STATUS` = #{status}")
    List<ExtProjectDetail> getProject4User(@Param("user") String operId, @Param("status") Integer status);

    @Select(  "     SELECT                                                                                           " +
            "         x.`PROJECT_ID` as projectId,                                                                   " +
            "         x.`PROJECT_CODE` as projectCode,                                                               " +
            "         x.`PROJECT_NAME` as projectName,                                                               " +
            "         x.`DW_ID` as dwId,                                                                             " +
            "         x.`MW_ID` as mwId,                                                                             " +
            "         x.`CACHE_EXPIRE_DAYS` as cacheExpireDays,                                                      " +
            "         x.`DESCRIPTION` as description,                                                                " +
            "         x.`STATUS` as status,                                                                          " +
            "         x.`LAST_UPDATE_TIME` as lastUpdateTime,                                                        " +
            "         x.`LAST_UPDATE_OPER` as lastUpdateOper,                                                        " +
            "         x.`CREATE_TIME` as createTime,                                                                 " +
            "         x.`CREATE_OPER` as createOper,                                                                  " +
            "         u.`USERNAME` as ownerUserName,                                                                       " +
            "         u.`REALNAME` as ownerRealName                                                                        " +
            "     FROM                                                                                               " +
            "         pr_project x,                                                                                  " +
            "         pr_project_member y,                                                                            " +
            "         pr_project_member o,                                                                            " +
            "         t_user u                                                                                        " +
            "     WHERE                                                                                              " +
            "           y.MEMBER_USER = #{user}                                                                      " +
            "         AND y.`STATUS` = #{status}                                                                     " +
            "         AND x.PROJECT_ID = y.PROJECT_ID                                                                " +
            "         AND x.PROJECT_ID = o.PROJECT_ID  AND o.PROJECT_ROLE = 0  AND  o.`STATUS` = #{status}           " +
            "         AND o.MEMBER_USER = u.USERNAME                                                                   " +
            "         AND x.`STATUS` = #{status}                                                                     " +
            "         AND (x.PROJECT_CODE LIKE #{keyword} or x.PROJECT_NAME LIKE #{keyword})")
    List<ExtProjectDetail> getProject4UserByKeyword(@Param("keyword") String keyword, @Param("user") String operId, @Param("status") Integer status);


    @Select(  "     SELECT                                                                                             " +
            "         x.`PROJECT_ID` as projectId,                                                                   " +
            "         x.`PROJECT_CODE` as projectCode,                                                               " +
            "         x.`PROJECT_NAME` as projectName,                                                               " +
            "         x.`DW_ID` as dwId,                                                                             " +
            "         x.`MW_ID` as mwId,                                                                             " +
            "         x.`CACHE_EXPIRE_DAYS` as cacheExpireDays,                                                      " +
            "         x.`DESCRIPTION` as description,                                                                " +
            "         x.`STATUS` as status,                                                                          " +
            "         x.`LAST_UPDATE_TIME` as lastUpdateTime,                                                        " +
            "         x.`LAST_UPDATE_OPER` as lastUpdateOper,                                                        " +
            "         x.`CREATE_TIME` as createTime,                                                                 " +
            "         x.`CREATE_OPER` as createOper                                                                  " +
            "     FROM                                                                                               " +
            "         pr_project x,                                                                                  " +
            "         pr_project_member y                                                                            " +
            "     WHERE                                                                                              " +
            "           y.MEMBER_USER = #{user}                                                                      " +
            "         AND y.`STATUS` = #{status}                                                                       " +
            "         AND x.PROJECT_ID = y.PROJECT_ID                                                                  " +
            "         AND x.`STATUS` = #{status}")
    List<PrProject> getProject4Member(@Param("user") String operId, @Param("status") Integer status);

}
