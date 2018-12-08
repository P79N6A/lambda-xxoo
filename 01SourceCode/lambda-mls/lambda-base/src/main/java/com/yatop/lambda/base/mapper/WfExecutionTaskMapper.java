package com.yatop.lambda.base.mapper;

import com.yatop.lambda.base.model.WfExecutionTask;
import com.yatop.lambda.base.model.WfExecutionTaskExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WfExecutionTaskMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_execution_task
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    long countByExample(WfExecutionTaskExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_execution_task
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    int deleteByExample(WfExecutionTaskExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_execution_task
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    int deleteByPrimaryKey(Long taskId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_execution_task
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    int insert(WfExecutionTask record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_execution_task
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    int insertSelective(WfExecutionTask record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_execution_task
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    List<WfExecutionTask> selectByExampleWithBLOBs(WfExecutionTaskExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_execution_task
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    List<WfExecutionTask> selectByExample(WfExecutionTaskExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_execution_task
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    WfExecutionTask selectByPrimaryKey(Long taskId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_execution_task
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    int updateByExampleSelective(@Param("record") WfExecutionTask record, @Param("example") WfExecutionTaskExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_execution_task
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    int updateByExampleWithBLOBs(@Param("record") WfExecutionTask record, @Param("example") WfExecutionTaskExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_execution_task
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    int updateByExample(@Param("record") WfExecutionTask record, @Param("example") WfExecutionTaskExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_execution_task
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    int updateByPrimaryKeySelective(WfExecutionTask record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_execution_task
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    int updateByPrimaryKeyWithBLOBs(WfExecutionTask record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_execution_task
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    int updateByPrimaryKey(WfExecutionTask record);
}