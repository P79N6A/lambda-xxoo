package com.yatop.lambda.base.mapper;

import com.yatop.lambda.base.model.WfExecutionTaskQueue;
import com.yatop.lambda.base.model.WfExecutionTaskQueueExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WfExecutionTaskQueueMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_execution_task_queue
     *
     * @mbg.generated Tue Jan 22 01:22:51 CST 2019
     */
    long countByExample(WfExecutionTaskQueueExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_execution_task_queue
     *
     * @mbg.generated Tue Jan 22 01:22:51 CST 2019
     */
    int deleteByExample(WfExecutionTaskQueueExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_execution_task_queue
     *
     * @mbg.generated Tue Jan 22 01:22:51 CST 2019
     */
    int deleteByPrimaryKey(Long taskId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_execution_task_queue
     *
     * @mbg.generated Tue Jan 22 01:22:51 CST 2019
     */
    int insert(WfExecutionTaskQueue record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_execution_task_queue
     *
     * @mbg.generated Tue Jan 22 01:22:51 CST 2019
     */
    int insertSelective(WfExecutionTaskQueue record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_execution_task_queue
     *
     * @mbg.generated Tue Jan 22 01:22:51 CST 2019
     */
    List<WfExecutionTaskQueue> selectByExample(WfExecutionTaskQueueExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_execution_task_queue
     *
     * @mbg.generated Tue Jan 22 01:22:51 CST 2019
     */
    WfExecutionTaskQueue selectByPrimaryKey(Long taskId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_execution_task_queue
     *
     * @mbg.generated Tue Jan 22 01:22:51 CST 2019
     */
    int updateByExampleSelective(@Param("record") WfExecutionTaskQueue record, @Param("example") WfExecutionTaskQueueExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_execution_task_queue
     *
     * @mbg.generated Tue Jan 22 01:22:51 CST 2019
     */
    int updateByExample(@Param("record") WfExecutionTaskQueue record, @Param("example") WfExecutionTaskQueueExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_execution_task_queue
     *
     * @mbg.generated Tue Jan 22 01:22:51 CST 2019
     */
    int updateByPrimaryKeySelective(WfExecutionTaskQueue record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_execution_task_queue
     *
     * @mbg.generated Tue Jan 22 01:22:51 CST 2019
     */
    int updateByPrimaryKey(WfExecutionTaskQueue record);
}