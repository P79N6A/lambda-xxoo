package com.yatop.lambda.base.mapper;

import com.yatop.lambda.base.model.WfExecutionTaskOutput;
import com.yatop.lambda.base.model.WfExecutionTaskOutputExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WfExecutionTaskOutputMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_execution_task_output
     *
     * @mbg.generated Sat Dec 08 20:55:04 CST 2018
     */
    long countByExample(WfExecutionTaskOutputExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_execution_task_output
     *
     * @mbg.generated Sat Dec 08 20:55:04 CST 2018
     */
    int deleteByExample(WfExecutionTaskOutputExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_execution_task_output
     *
     * @mbg.generated Sat Dec 08 20:55:04 CST 2018
     */
    int deleteByPrimaryKey(@Param("taskId") Long taskId, @Param("charId") Long charId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_execution_task_output
     *
     * @mbg.generated Sat Dec 08 20:55:04 CST 2018
     */
    int insert(WfExecutionTaskOutput record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_execution_task_output
     *
     * @mbg.generated Sat Dec 08 20:55:04 CST 2018
     */
    int insertSelective(WfExecutionTaskOutput record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_execution_task_output
     *
     * @mbg.generated Sat Dec 08 20:55:04 CST 2018
     */
    List<WfExecutionTaskOutput> selectByExample(WfExecutionTaskOutputExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_execution_task_output
     *
     * @mbg.generated Sat Dec 08 20:55:04 CST 2018
     */
    WfExecutionTaskOutput selectByPrimaryKey(@Param("taskId") Long taskId, @Param("charId") Long charId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_execution_task_output
     *
     * @mbg.generated Sat Dec 08 20:55:04 CST 2018
     */
    int updateByExampleSelective(@Param("record") WfExecutionTaskOutput record, @Param("example") WfExecutionTaskOutputExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_execution_task_output
     *
     * @mbg.generated Sat Dec 08 20:55:04 CST 2018
     */
    int updateByExample(@Param("record") WfExecutionTaskOutput record, @Param("example") WfExecutionTaskOutputExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_execution_task_output
     *
     * @mbg.generated Sat Dec 08 20:55:04 CST 2018
     */
    int updateByPrimaryKeySelective(WfExecutionTaskOutput record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_execution_task_output
     *
     * @mbg.generated Sat Dec 08 20:55:04 CST 2018
     */
    int updateByPrimaryKey(WfExecutionTaskOutput record);
}