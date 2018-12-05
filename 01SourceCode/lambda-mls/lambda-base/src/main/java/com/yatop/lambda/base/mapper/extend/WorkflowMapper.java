package com.yatop.lambda.base.mapper.extend;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.Date;

public interface WorkflowMapper {

    @Update(  "     UPDATE WF_FLOW                      " +
            "       SET NEXT_SNAPSHOT_VERSION = NEXT_SNAPSHOT_VERSION + 1,              " +
            "       LAST_SNAPSHOT_ID = #{snapshot},              " +
            "       LAST_UPDAT_TIME = #{time},          " +
            "       LAST_UPDATE_OPER = #{oper}          " +
            "       WHERE FLOW_ID = #{id}")
    int updateWorkflowSnapshot(@Param("id") Long id, @Param("snapshot") Long snapshot, @Param("time") Date time, @Param("oper") String oper);

    @Update(  "     UPDATE WF_FLOW                      " +
            "       SET VERSION = VERSION + 1,          " +
            "       LAST_UPDAT_TIME = #{time},          " +
            "       LAST_UPDATE_OPER = #{oper}          " +
            "       WHERE FLOW_ID = #{id}")
    int updateWorkflowVersion(@Param("id") Long id, @Param("time") Date time, @Param("oper") String oper);
}
