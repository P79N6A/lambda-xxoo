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
     * @mbg.generated Tue Dec 04 13:25:54 CST 2018
     */
    long countByExample(WfFlowNodePortExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_node_port
     *
     * @mbg.generated Tue Dec 04 13:25:54 CST 2018
     */
    int deleteByExample(WfFlowNodePortExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_node_port
     *
     * @mbg.generated Tue Dec 04 13:25:54 CST 2018
     */
    int deleteByPrimaryKey(Long nodePortId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_node_port
     *
     * @mbg.generated Tue Dec 04 13:25:54 CST 2018
     */
    int insert(WfFlowNodePort record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_node_port
     *
     * @mbg.generated Tue Dec 04 13:25:54 CST 2018
     */
    int insertSelective(WfFlowNodePort record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_node_port
     *
     * @mbg.generated Tue Dec 04 13:25:54 CST 2018
     */
    List<WfFlowNodePort> selectByExample(WfFlowNodePortExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_node_port
     *
     * @mbg.generated Tue Dec 04 13:25:54 CST 2018
     */
    WfFlowNodePort selectByPrimaryKey(Long nodePortId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_node_port
     *
     * @mbg.generated Tue Dec 04 13:25:54 CST 2018
     */
    int updateByExampleSelective(@Param("record") WfFlowNodePort record, @Param("example") WfFlowNodePortExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_node_port
     *
     * @mbg.generated Tue Dec 04 13:25:54 CST 2018
     */
    int updateByExample(@Param("record") WfFlowNodePort record, @Param("example") WfFlowNodePortExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_node_port
     *
     * @mbg.generated Tue Dec 04 13:25:54 CST 2018
     */
    int updateByPrimaryKeySelective(WfFlowNodePort record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_node_port
     *
     * @mbg.generated Tue Dec 04 13:25:54 CST 2018
     */
    int updateByPrimaryKey(WfFlowNodePort record);
}