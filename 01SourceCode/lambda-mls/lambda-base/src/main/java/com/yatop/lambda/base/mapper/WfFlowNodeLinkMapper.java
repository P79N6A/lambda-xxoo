package com.yatop.lambda.base.mapper;

import com.yatop.lambda.base.model.WfFlowNodeLink;
import com.yatop.lambda.base.model.WfFlowNodeLinkExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WfFlowNodeLinkMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_node_link
     *
     * @mbg.generated Mon Dec 10 12:31:47 CST 2018
     */
    long countByExample(WfFlowNodeLinkExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_node_link
     *
     * @mbg.generated Mon Dec 10 12:31:47 CST 2018
     */
    int deleteByExample(WfFlowNodeLinkExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_node_link
     *
     * @mbg.generated Mon Dec 10 12:31:47 CST 2018
     */
    int deleteByPrimaryKey(Long linkId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_node_link
     *
     * @mbg.generated Mon Dec 10 12:31:47 CST 2018
     */
    int insert(WfFlowNodeLink record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_node_link
     *
     * @mbg.generated Mon Dec 10 12:31:47 CST 2018
     */
    int insertSelective(WfFlowNodeLink record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_node_link
     *
     * @mbg.generated Mon Dec 10 12:31:47 CST 2018
     */
    List<WfFlowNodeLink> selectByExample(WfFlowNodeLinkExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_node_link
     *
     * @mbg.generated Mon Dec 10 12:31:47 CST 2018
     */
    WfFlowNodeLink selectByPrimaryKey(Long linkId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_node_link
     *
     * @mbg.generated Mon Dec 10 12:31:47 CST 2018
     */
    int updateByExampleSelective(@Param("record") WfFlowNodeLink record, @Param("example") WfFlowNodeLinkExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_node_link
     *
     * @mbg.generated Mon Dec 10 12:31:47 CST 2018
     */
    int updateByExample(@Param("record") WfFlowNodeLink record, @Param("example") WfFlowNodeLinkExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_node_link
     *
     * @mbg.generated Mon Dec 10 12:31:47 CST 2018
     */
    int updateByPrimaryKeySelective(WfFlowNodeLink record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_node_link
     *
     * @mbg.generated Mon Dec 10 12:31:47 CST 2018
     */
    int updateByPrimaryKey(WfFlowNodeLink record);
}