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
     * @mbg.generated Tue Dec 04 13:25:54 CST 2018
     */
    long countByExample(WfFlowNodeSchemaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_node_schema
     *
     * @mbg.generated Tue Dec 04 13:25:54 CST 2018
     */
    int deleteByExample(WfFlowNodeSchemaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_node_schema
     *
     * @mbg.generated Tue Dec 04 13:25:54 CST 2018
     */
    int deleteByPrimaryKey(Long nodePortId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_node_schema
     *
     * @mbg.generated Tue Dec 04 13:25:54 CST 2018
     */
    int insert(WfFlowNodeSchema record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_node_schema
     *
     * @mbg.generated Tue Dec 04 13:25:54 CST 2018
     */
    int insertSelective(WfFlowNodeSchema record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_node_schema
     *
     * @mbg.generated Tue Dec 04 13:25:54 CST 2018
     */
    List<WfFlowNodeSchema> selectByExample(WfFlowNodeSchemaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_node_schema
     *
     * @mbg.generated Tue Dec 04 13:25:54 CST 2018
     */
    WfFlowNodeSchema selectByPrimaryKey(Long nodePortId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_node_schema
     *
     * @mbg.generated Tue Dec 04 13:25:54 CST 2018
     */
    int updateByExampleSelective(@Param("record") WfFlowNodeSchema record, @Param("example") WfFlowNodeSchemaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_node_schema
     *
     * @mbg.generated Tue Dec 04 13:25:54 CST 2018
     */
    int updateByExample(@Param("record") WfFlowNodeSchema record, @Param("example") WfFlowNodeSchemaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_node_schema
     *
     * @mbg.generated Tue Dec 04 13:25:54 CST 2018
     */
    int updateByPrimaryKeySelective(WfFlowNodeSchema record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_node_schema
     *
     * @mbg.generated Tue Dec 04 13:25:54 CST 2018
     */
    int updateByPrimaryKey(WfFlowNodeSchema record);
}