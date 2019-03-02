package com.yatop.lambda.base.extend.mapper;

import com.yatop.lambda.base.extend.model.ExtEmExperiment;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 实验
 *
 * @author huangyu
 * @create 2019-02-28-18:09
 */
public interface ExtExperimentMapper {
    @Select("SELECT " +
            "a.EXPERIMENT_ID experimentId," +
            "a.EXPERIMENT_NAME experimentName," +
            "a.OWNER_PROJECT_ID ownerProjectId," +
            "a.SUMMARY," +
            "a.DESCRIPTION," +
            "a.STATUS," +
            "a.LAST_UPDATE_OPER lastUpdateOper," +
            "a.LAST_UPDATE_TIME lastUpdateTime," +
            "a.CREATE_OPER createOper," +
            "a.CREATE_TIME createTime," +
            "b.FLOW_STATE flowState" +
            " FROM" +
            " em_experiment a," +
            "wf_flow b" +
            " WHERE a.OWNER_PROJECT_ID = #{projectId} " +
            "  AND a.EXPERIMENT_NAME LIKE #{keyword}" +
            "  AND a.STATUS = #{status}" +
            "  AND a.EXPERIMENT_ID = B.FLOW_ID" +
            " ORDER BY a.CREATE_TIME")
    List<ExtEmExperiment> queryExperiment(@Param("projectId") Long projectId, @Param("keyword") String keyword, @Param("status") Integer status);

    @Select("SELECT " +
            "a.EXPERIMENT_ID experimentId," +
            "a.EXPERIMENT_NAME experimentName," +
            "a.OWNER_PROJECT_ID ownerProjectId," +
            "a.SUMMARY," +
            "a.DESCRIPTION," +
            "a.STATUS," +
            "a.LAST_UPDATE_OPER lastUpdateOper," +
            "a.LAST_UPDATE_TIME lastUpdateTime," +
            "a.CREATE_OPER createOper," +
            "a.CREATE_TIME createTime," +
            "b.FLOW_STATE flowState" +
            " FROM" +
            " em_experiment a," +
            "wf_flow b" +
            " WHERE a.OWNER_PROJECT_ID = #{projectId}" +
            "  AND a.STATUS = #{status}" +
            "  AND a.EXPERIMENT_ID = b.FLOW_ID" +
            " ORDER BY a.CREATE_TIME")
    List<ExtEmExperiment> queryExperimentByProjectId(@Param("projectId") Long projectId,@Param("status") Integer status);
}
