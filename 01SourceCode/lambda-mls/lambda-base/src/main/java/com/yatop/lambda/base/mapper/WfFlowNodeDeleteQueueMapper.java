package com.yatop.lambda.base.mapper;

import com.yatop.lambda.base.model.WfFlowNodeDeleteQueue;
import com.yatop.lambda.base.model.WfFlowNodeDeleteQueueExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WfFlowNodeDeleteQueueMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_node_delete_queue
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    long countByExample(WfFlowNodeDeleteQueueExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_node_delete_queue
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    int deleteByExample(WfFlowNodeDeleteQueueExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_node_delete_queue
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    int insert(WfFlowNodeDeleteQueue record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_node_delete_queue
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    int insertSelective(WfFlowNodeDeleteQueue record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_node_delete_queue
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    List<WfFlowNodeDeleteQueue> selectByExample(WfFlowNodeDeleteQueueExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_node_delete_queue
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    int updateByExampleSelective(@Param("record") WfFlowNodeDeleteQueue record, @Param("example") WfFlowNodeDeleteQueueExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_node_delete_queue
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    int updateByExample(@Param("record") WfFlowNodeDeleteQueue record, @Param("example") WfFlowNodeDeleteQueueExample example);
}