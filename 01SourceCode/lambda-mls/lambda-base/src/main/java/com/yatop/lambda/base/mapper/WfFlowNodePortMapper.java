package com.yatop.lambda.base.mapper;

import com.yatop.lambda.base.model.WfFlowNodePort;
import com.yatop.lambda.base.model.WfFlowNodePortExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WfFlowNodePortMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_node_port
     *
     * @mbg.generated Sat Jan 19 23:32:35 CST 2019
     */
    long countByExample(WfFlowNodePortExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_node_port
     *
     * @mbg.generated Sat Jan 19 23:32:35 CST 2019
     */
    int deleteByExample(WfFlowNodePortExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_node_port
     *
     * @mbg.generated Sat Jan 19 23:32:35 CST 2019
     */
    int deleteByPrimaryKey(Long nodePortId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_node_port
     *
     * @mbg.generated Sat Jan 19 23:32:35 CST 2019
     */
    int insert(WfFlowNodePort record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_node_port
     *
     * @mbg.generated Sat Jan 19 23:32:35 CST 2019
     */
    int insertSelective(WfFlowNodePort record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_node_port
     *
     * @mbg.generated Sat Jan 19 23:32:35 CST 2019
     */
    List<WfFlowNodePort> selectByExample(WfFlowNodePortExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_node_port
     *
     * @mbg.generated Sat Jan 19 23:32:35 CST 2019
     */
    WfFlowNodePort selectByPrimaryKey(Long nodePortId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_node_port
     *
     * @mbg.generated Sat Jan 19 23:32:35 CST 2019
     */
    int updateByExampleSelective(@Param("record") WfFlowNodePort record, @Param("example") WfFlowNodePortExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_node_port
     *
     * @mbg.generated Sat Jan 19 23:32:35 CST 2019
     */
    int updateByExample(@Param("record") WfFlowNodePort record, @Param("example") WfFlowNodePortExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_node_port
     *
     * @mbg.generated Sat Jan 19 23:32:35 CST 2019
     */
    int updateByPrimaryKeySelective(WfFlowNodePort record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_node_port
     *
     * @mbg.generated Sat Jan 19 23:32:35 CST 2019
     */
    int updateByPrimaryKey(WfFlowNodePort record);
}