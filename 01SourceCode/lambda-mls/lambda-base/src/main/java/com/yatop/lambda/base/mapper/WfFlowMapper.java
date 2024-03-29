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
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    long countByExample(WfFlowExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    int deleteByExample(WfFlowExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    int deleteByPrimaryKey(Long flowId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    int insert(WfFlow record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    int insertSelective(WfFlow record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    List<WfFlow> selectByExample(WfFlowExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    WfFlow selectByPrimaryKey(Long flowId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    int updateByExampleSelective(@Param("record") WfFlow record, @Param("example") WfFlowExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    int updateByExample(@Param("record") WfFlow record, @Param("example") WfFlowExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    int updateByPrimaryKeySelective(WfFlow record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    int updateByPrimaryKey(WfFlow record);
}