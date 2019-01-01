package com.yatop.lambda.base.mapper;

import com.yatop.lambda.base.model.WfFlowNodeSchema;
import com.yatop.lambda.base.model.WfFlowNodeSchemaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WfFlowNodeSchemaMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_node_schema
     *
     * @mbg.generated Tue Jan 01 18:06:32 CST 2019
     */
    long countByExample(WfFlowNodeSchemaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_node_schema
     *
     * @mbg.generated Tue Jan 01 18:06:32 CST 2019
     */
    int deleteByExample(WfFlowNodeSchemaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_node_schema
     *
     * @mbg.generated Tue Jan 01 18:06:32 CST 2019
     */
    int deleteByPrimaryKey(Long nodePortId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_node_schema
     *
     * @mbg.generated Tue Jan 01 18:06:32 CST 2019
     */
    int insert(WfFlowNodeSchema record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_node_schema
     *
     * @mbg.generated Tue Jan 01 18:06:32 CST 2019
     */
    int insertSelective(WfFlowNodeSchema record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_node_schema
     *
     * @mbg.generated Tue Jan 01 18:06:32 CST 2019
     */
    List<WfFlowNodeSchema> selectByExample(WfFlowNodeSchemaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_node_schema
     *
     * @mbg.generated Tue Jan 01 18:06:32 CST 2019
     */
    WfFlowNodeSchema selectByPrimaryKey(Long nodePortId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_node_schema
     *
     * @mbg.generated Tue Jan 01 18:06:32 CST 2019
     */
    int updateByExampleSelective(@Param("record") WfFlowNodeSchema record, @Param("example") WfFlowNodeSchemaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_node_schema
     *
     * @mbg.generated Tue Jan 01 18:06:32 CST 2019
     */
    int updateByExample(@Param("record") WfFlowNodeSchema record, @Param("example") WfFlowNodeSchemaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_node_schema
     *
     * @mbg.generated Tue Jan 01 18:06:32 CST 2019
     */
    int updateByPrimaryKeySelective(WfFlowNodeSchema record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_node_schema
     *
     * @mbg.generated Tue Jan 01 18:06:32 CST 2019
     */
    int updateByPrimaryKey(WfFlowNodeSchema record);
}