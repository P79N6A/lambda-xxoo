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
     * @mbg.generated Sat Dec 08 20:55:03 CST 2018
     */
    long countByExample(WfFlowNodeParameterExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_node_parameter
     *
     * @mbg.generated Sat Dec 08 20:55:03 CST 2018
     */
    int deleteByExample(WfFlowNodeParameterExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_node_parameter
     *
     * @mbg.generated Sat Dec 08 20:55:03 CST 2018
     */
    int insert(WfFlowNodeParameter record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_node_parameter
     *
     * @mbg.generated Sat Dec 08 20:55:03 CST 2018
     */
    int insertSelective(WfFlowNodeParameter record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_node_parameter
     *
     * @mbg.generated Sat Dec 08 20:55:03 CST 2018
     */
    List<WfFlowNodeParameter> selectByExample(WfFlowNodeParameterExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_node_parameter
     *
     * @mbg.generated Sat Dec 08 20:55:03 CST 2018
     */
    int updateByExampleSelective(@Param("record") WfFlowNodeParameter record, @Param("example") WfFlowNodeParameterExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_node_parameter
     *
     * @mbg.generated Sat Dec 08 20:55:03 CST 2018
     */
    int updateByExample(@Param("record") WfFlowNodeParameter record, @Param("example") WfFlowNodeParameterExample example);
}