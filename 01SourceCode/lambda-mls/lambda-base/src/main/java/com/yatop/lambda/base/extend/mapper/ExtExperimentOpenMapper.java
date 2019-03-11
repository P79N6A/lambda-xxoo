package com.yatop.lambda.base.extend.mapper;

import com.yatop.lambda.base.model.EmExperimentOpen;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author huangyu
 * @create 2019-03-09-17:09
 */
public interface ExtExperimentOpenMapper {
    @Select("select * from em_experiment_open where user_name = #{userName} and project_Id = #{projectId}")
    List<EmExperimentOpen> findExperimentOpenByUserName(@Param("projectId") Long projectId, @Param("userName") String userName);

    @Select("delete from em_experiment_open where create_time = ( " +
            "  select a.CREATE_TIME from ( " +
            "     select " +
            "      min( create_time ) as CREATE_TIME " +
            "     from " +
            "      em_experiment_open " +
            "     where " +
            "      USER_NAME = #{userName} " +
            "      AND PROJECT_ID = #{projectId} " +
            "    ) a  " +
            ")")
    int deleteExperimentOpen(@Param("projectId") Long projectId, @Param("userName") String userName);

    @Select("select * from em_experiment_open where EXPERIMENT_ID = #{experimentId} and project_Id = #{projectId}")
    List<EmExperimentOpen> findExperimentOpenByExperimentId(@Param("projectId") Long projectId, @Param("experimentId") Long experimentId);
}
