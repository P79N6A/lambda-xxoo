package com.yatop.lambda.base.mapper;

import com.yatop.lambda.base.model.WfFlowNodeOutput;
import com.yatop.lambda.base.model.WfFlowNodeOutputExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WfFlowNodeOutputMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_node_output
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    long countByExample(WfFlowNodeOutputExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_node_output
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    int deleteByExample(WfFlowNodeOutputExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_node_output
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    int insert(WfFlowNodeOutput record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_node_output
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    int insertSelective(WfFlowNodeOutput record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_node_output
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    List<WfFlowNodeOutput> selectByExample(WfFlowNodeOutputExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_node_output
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    int updateByExampleSelective(@Param("record") WfFlowNodeOutput record, @Param("example") WfFlowNodeOutputExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_node_output
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    int updateByExample(@Param("record") WfFlowNodeOutput record, @Param("example") WfFlowNodeOutputExample example);
}