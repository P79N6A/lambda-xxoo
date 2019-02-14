package com.yatop.lambda.base.mapper;

import com.yatop.lambda.base.model.WfFlowAccumulate;
import com.yatop.lambda.base.model.WfFlowAccumulateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WfFlowAccumulateMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_accumulate
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    long countByExample(WfFlowAccumulateExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_accumulate
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    int deleteByExample(WfFlowAccumulateExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_accumulate
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    int insert(WfFlowAccumulate record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_accumulate
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    int insertSelective(WfFlowAccumulate record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_accumulate
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    List<WfFlowAccumulate> selectByExample(WfFlowAccumulateExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_accumulate
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    int updateByExampleSelective(@Param("record") WfFlowAccumulate record, @Param("example") WfFlowAccumulateExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_accumulate
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    int updateByExample(@Param("record") WfFlowAccumulate record, @Param("example") WfFlowAccumulateExample example);
}