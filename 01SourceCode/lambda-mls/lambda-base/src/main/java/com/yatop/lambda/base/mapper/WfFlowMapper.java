package com.yatop.lambda.base.mapper;

import com.yatop.lambda.base.model.WfFlow;
import com.yatop.lambda.base.model.WfFlowExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WfFlowMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow
     *
     * @mbg.generated Sun Dec 30 22:07:03 CST 2018
     */
    long countByExample(WfFlowExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow
     *
     * @mbg.generated Sun Dec 30 22:07:03 CST 2018
     */
    int deleteByExample(WfFlowExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow
     *
     * @mbg.generated Sun Dec 30 22:07:03 CST 2018
     */
    int deleteByPrimaryKey(Long flowId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow
     *
     * @mbg.generated Sun Dec 30 22:07:03 CST 2018
     */
    int insert(WfFlow record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow
     *
     * @mbg.generated Sun Dec 30 22:07:03 CST 2018
     */
    int insertSelective(WfFlow record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow
     *
     * @mbg.generated Sun Dec 30 22:07:03 CST 2018
     */
    List<WfFlow> selectByExample(WfFlowExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow
     *
     * @mbg.generated Sun Dec 30 22:07:03 CST 2018
     */
    WfFlow selectByPrimaryKey(Long flowId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow
     *
     * @mbg.generated Sun Dec 30 22:07:03 CST 2018
     */
    int updateByExampleSelective(@Param("record") WfFlow record, @Param("example") WfFlowExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow
     *
     * @mbg.generated Sun Dec 30 22:07:03 CST 2018
     */
    int updateByExample(@Param("record") WfFlow record, @Param("example") WfFlowExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow
     *
     * @mbg.generated Sun Dec 30 22:07:03 CST 2018
     */
    int updateByPrimaryKeySelective(WfFlow record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow
     *
     * @mbg.generated Sun Dec 30 22:07:03 CST 2018
     */
    int updateByPrimaryKey(WfFlow record);
}