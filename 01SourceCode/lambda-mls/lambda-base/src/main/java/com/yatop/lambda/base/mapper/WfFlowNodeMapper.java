package com.yatop.lambda.base.mapper;

import com.yatop.lambda.base.model.WfFlowNode;
import com.yatop.lambda.base.model.WfFlowNodeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WfFlowNodeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_node
     *
     * @mbg.generated Wed Dec 05 11:19:48 CST 2018
     */
    long countByExample(WfFlowNodeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_node
     *
     * @mbg.generated Wed Dec 05 11:19:48 CST 2018
     */
    int deleteByExample(WfFlowNodeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_node
     *
     * @mbg.generated Wed Dec 05 11:19:48 CST 2018
     */
    int deleteByPrimaryKey(Long nodeId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_node
     *
     * @mbg.generated Wed Dec 05 11:19:48 CST 2018
     */
    int insert(WfFlowNode record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_node
     *
     * @mbg.generated Wed Dec 05 11:19:48 CST 2018
     */
    int insertSelective(WfFlowNode record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_node
     *
     * @mbg.generated Wed Dec 05 11:19:48 CST 2018
     */
    List<WfFlowNode> selectByExample(WfFlowNodeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_node
     *
     * @mbg.generated Wed Dec 05 11:19:48 CST 2018
     */
    WfFlowNode selectByPrimaryKey(Long nodeId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_node
     *
     * @mbg.generated Wed Dec 05 11:19:48 CST 2018
     */
    int updateByExampleSelective(@Param("record") WfFlowNode record, @Param("example") WfFlowNodeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_node
     *
     * @mbg.generated Wed Dec 05 11:19:48 CST 2018
     */
    int updateByExample(@Param("record") WfFlowNode record, @Param("example") WfFlowNodeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_node
     *
     * @mbg.generated Wed Dec 05 11:19:48 CST 2018
     */
    int updateByPrimaryKeySelective(WfFlowNode record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_node
     *
     * @mbg.generated Wed Dec 05 11:19:48 CST 2018
     */
    int updateByPrimaryKey(WfFlowNode record);
}