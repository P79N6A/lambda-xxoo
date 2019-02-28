package com.yatop.lambda.base.extend.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.Date;

public interface ExtExperimentTemplateMapper {

    @Update("     UPDATE EM_EXPERIMENT_TEMPLATE       " +
            "       SET COUNT = COUNT + 1,              " +
            "       LAST_UPDAT_TIME = #{time},          " +
            "       LAST_UPDATE_OPER = #{oper}          " +
            "       WHERE TEMPLATE_ID = #{id}")
    int increaseTemplateCount(@Param("id") Long id, @Param("time") Date time, @Param("oper") String oper);

    @Select("SELECT IFNULL(MAX(TEMPLATE_COUNT),1000) AS TEMPLATE_COUNT " +
            "FROM em_experiment_template " +
            "WHERE STATUS ='0' AND TEMPLATE_ID =#{templateId}")
    int selectMaxTemplateCount(@Param("templateId") Long templateId);
}
