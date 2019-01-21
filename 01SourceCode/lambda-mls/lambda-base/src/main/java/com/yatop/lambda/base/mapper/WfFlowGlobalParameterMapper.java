package com.yatop.lambda.base.mapper;

import com.yatop.lambda.base.model.WfFlowGlobalParameter;
import com.yatop.lambda.base.model.WfFlowGlobalParameterExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WfFlowGlobalParameterMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_global_parameter
     *
     * @mbg.generated Tue Jan 22 01:22:51 CST 2019
     */
    long countByExample(WfFlowGlobalParameterExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_global_parameter
     *
     * @mbg.generated Tue Jan 22 01:22:51 CST 2019
     */
    int deleteByExample(WfFlowGlobalParameterExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_global_parameter
     *
     * @mbg.generated Tue Jan 22 01:22:51 CST 2019
     */
    int deleteByPrimaryKey(Long globalParamId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_global_parameter
     *
     * @mbg.generated Tue Jan 22 01:22:51 CST 2019
     */
    int insert(WfFlowGlobalParameter record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_global_parameter
     *
     * @mbg.generated Tue Jan 22 01:22:51 CST 2019
     */
    int insertSelective(WfFlowGlobalParameter record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_global_parameter
     *
     * @mbg.generated Tue Jan 22 01:22:51 CST 2019
     */
    List<WfFlowGlobalParameter> selectByExample(WfFlowGlobalParameterExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_global_parameter
     *
     * @mbg.generated Tue Jan 22 01:22:51 CST 2019
     */
    WfFlowGlobalParameter selectByPrimaryKey(Long globalParamId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_global_parameter
     *
     * @mbg.generated Tue Jan 22 01:22:51 CST 2019
     */
    int updateByExampleSelective(@Param("record") WfFlowGlobalParameter record, @Param("example") WfFlowGlobalParameterExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_global_parameter
     *
     * @mbg.generated Tue Jan 22 01:22:51 CST 2019
     */
    int updateByExample(@Param("record") WfFlowGlobalParameter record, @Param("example") WfFlowGlobalParameterExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_global_parameter
     *
     * @mbg.generated Tue Jan 22 01:22:51 CST 2019
     */
    int updateByPrimaryKeySelective(WfFlowGlobalParameter record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_global_parameter
     *
     * @mbg.generated Tue Jan 22 01:22:51 CST 2019
     */
    int updateByPrimaryKey(WfFlowGlobalParameter record);
}