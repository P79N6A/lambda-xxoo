package com.yatop.lambda.base.mapper;

import com.yatop.lambda.base.model.WfExecutionQueue;
import com.yatop.lambda.base.model.WfExecutionQueueExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WfExecutionQueueMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_execution_queue
     *
     * @mbg.generated Wed Dec 05 11:19:48 CST 2018
     */
    long countByExample(WfExecutionQueueExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_execution_queue
     *
     * @mbg.generated Wed Dec 05 11:19:48 CST 2018
     */
    int deleteByExample(WfExecutionQueueExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_execution_queue
     *
     * @mbg.generated Wed Dec 05 11:19:48 CST 2018
     */
    int deleteByPrimaryKey(Long jobId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_execution_queue
     *
     * @mbg.generated Wed Dec 05 11:19:48 CST 2018
     */
    int insert(WfExecutionQueue record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_execution_queue
     *
     * @mbg.generated Wed Dec 05 11:19:48 CST 2018
     */
    int insertSelective(WfExecutionQueue record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_execution_queue
     *
     * @mbg.generated Wed Dec 05 11:19:48 CST 2018
     */
    List<WfExecutionQueue> selectByExample(WfExecutionQueueExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_execution_queue
     *
     * @mbg.generated Wed Dec 05 11:19:48 CST 2018
     */
    WfExecutionQueue selectByPrimaryKey(Long jobId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_execution_queue
     *
     * @mbg.generated Wed Dec 05 11:19:48 CST 2018
     */
    int updateByExampleSelective(@Param("record") WfExecutionQueue record, @Param("example") WfExecutionQueueExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_execution_queue
     *
     * @mbg.generated Wed Dec 05 11:19:48 CST 2018
     */
    int updateByExample(@Param("record") WfExecutionQueue record, @Param("example") WfExecutionQueueExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_execution_queue
     *
     * @mbg.generated Wed Dec 05 11:19:48 CST 2018
     */
    int updateByPrimaryKeySelective(WfExecutionQueue record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_execution_queue
     *
     * @mbg.generated Wed Dec 05 11:19:48 CST 2018
     */
    int updateByPrimaryKey(WfExecutionQueue record);
}