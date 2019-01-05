package com.yatop.lambda.base.mapper;

import com.yatop.lambda.base.model.WfFlowNodeParameter;
import com.yatop.lambda.base.model.WfFlowNodeParameterExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WfFlowNodeParameterMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_node_parameter
     *
     * @mbg.generated Sun Jan 06 01:14:12 CST 2019
     */
    long countByExample(WfFlowNodeParameterExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_node_parameter
     *
     * @mbg.generated Sun Jan 06 01:14:12 CST 2019
     */
    int deleteByExample(WfFlowNodeParameterExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_node_parameter
     *
     * @mbg.generated Sun Jan 06 01:14:12 CST 2019
     */
    int insert(WfFlowNodeParameter record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_node_parameter
     *
     * @mbg.generated Sun Jan 06 01:14:12 CST 2019
     */
    int insertSelective(WfFlowNodeParameter record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_node_parameter
     *
     * @mbg.generated Sun Jan 06 01:14:12 CST 2019
     */
    List<WfFlowNodeParameter> selectByExample(WfFlowNodeParameterExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_node_parameter
     *
     * @mbg.generated Sun Jan 06 01:14:12 CST 2019
     */
    int updateByExampleSelective(@Param("record") WfFlowNodeParameter record, @Param("example") WfFlowNodeParameterExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_node_parameter
     *
     * @mbg.generated Sun Jan 06 01:14:12 CST 2019
     */
    int updateByExample(@Param("record") WfFlowNodeParameter record, @Param("example") WfFlowNodeParameterExample example);
}