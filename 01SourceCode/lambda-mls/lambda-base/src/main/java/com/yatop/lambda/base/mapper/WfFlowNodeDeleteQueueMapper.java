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
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    long countByExample(WfFlowNodeDeleteQueueExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_node_delete_queue
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    int deleteByExample(WfFlowNodeDeleteQueueExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_node_delete_queue
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    int insert(WfFlowNodeDeleteQueue record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_node_delete_queue
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    int insertSelective(WfFlowNodeDeleteQueue record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_node_delete_queue
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    List<WfFlowNodeDeleteQueue> selectByExample(WfFlowNodeDeleteQueueExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_node_delete_queue
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    int updateByExampleSelective(@Param("record") WfFlowNodeDeleteQueue record, @Param("example") WfFlowNodeDeleteQueueExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_node_delete_queue
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    int updateByExample(@Param("record") WfFlowNodeDeleteQueue record, @Param("example") WfFlowNodeDeleteQueueExample example);
}