package com.yatop.lambda.base.mapper;

import com.yatop.lambda.base.model.WfExecutionJob;
import com.yatop.lambda.base.model.WfExecutionJobExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WfExecutionJobMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_execution_job
     *
     * @mbg.generated Thu Jan 24 15:07:19 CST 2019
     */
    long countByExample(WfExecutionJobExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_execution_job
     *
     * @mbg.generated Thu Jan 24 15:07:19 CST 2019
     */
    int deleteByExample(WfExecutionJobExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_execution_job
     *
     * @mbg.generated Thu Jan 24 15:07:19 CST 2019
     */
    int deleteByPrimaryKey(Long jobId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_execution_job
     *
     * @mbg.generated Thu Jan 24 15:07:19 CST 2019
     */
    int insert(WfExecutionJob record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_execution_job
     *
     * @mbg.generated Thu Jan 24 15:07:19 CST 2019
     */
    int insertSelective(WfExecutionJob record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_execution_job
     *
     * @mbg.generated Thu Jan 24 15:07:19 CST 2019
     */
    List<WfExecutionJob> selectByExampleWithBLOBs(WfExecutionJobExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_execution_job
     *
     * @mbg.generated Thu Jan 24 15:07:19 CST 2019
     */
    List<WfExecutionJob> selectByExample(WfExecutionJobExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_execution_job
     *
     * @mbg.generated Thu Jan 24 15:07:19 CST 2019
     */
    WfExecutionJob selectByPrimaryKey(Long jobId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_execution_job
     *
     * @mbg.generated Thu Jan 24 15:07:19 CST 2019
     */
    int updateByExampleSelective(@Param("record") WfExecutionJob record, @Param("example") WfExecutionJobExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_execution_job
     *
     * @mbg.generated Thu Jan 24 15:07:19 CST 2019
     */
    int updateByExampleWithBLOBs(@Param("record") WfExecutionJob record, @Param("example") WfExecutionJobExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_execution_job
     *
     * @mbg.generated Thu Jan 24 15:07:19 CST 2019
     */
    int updateByExample(@Param("record") WfExecutionJob record, @Param("example") WfExecutionJobExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_execution_job
     *
     * @mbg.generated Thu Jan 24 15:07:19 CST 2019
     */
    int updateByPrimaryKeySelective(WfExecutionJob record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_execution_job
     *
     * @mbg.generated Thu Jan 24 15:07:19 CST 2019
     */
    int updateByPrimaryKeyWithBLOBs(WfExecutionJob record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_execution_job
     *
     * @mbg.generated Thu Jan 24 15:07:19 CST 2019
     */
    int updateByPrimaryKey(WfExecutionJob record);
}