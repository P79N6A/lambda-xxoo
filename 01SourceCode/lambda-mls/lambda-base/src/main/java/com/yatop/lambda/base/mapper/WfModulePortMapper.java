package com.yatop.lambda.base.mapper;

import com.yatop.lambda.base.model.WfModulePort;
import com.yatop.lambda.base.model.WfModulePortExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WfModulePortMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_module_port
     *
     * @mbg.generated Sat Jan 19 23:32:35 CST 2019
     */
    long countByExample(WfModulePortExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_module_port
     *
     * @mbg.generated Sat Jan 19 23:32:35 CST 2019
     */
    int deleteByExample(WfModulePortExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_module_port
     *
     * @mbg.generated Sat Jan 19 23:32:35 CST 2019
     */
    int deleteByPrimaryKey(Long portId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_module_port
     *
     * @mbg.generated Sat Jan 19 23:32:35 CST 2019
     */
    int insert(WfModulePort record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_module_port
     *
     * @mbg.generated Sat Jan 19 23:32:35 CST 2019
     */
    int insertSelective(WfModulePort record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_module_port
     *
     * @mbg.generated Sat Jan 19 23:32:35 CST 2019
     */
    List<WfModulePort> selectByExample(WfModulePortExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_module_port
     *
     * @mbg.generated Sat Jan 19 23:32:35 CST 2019
     */
    WfModulePort selectByPrimaryKey(Long portId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_module_port
     *
     * @mbg.generated Sat Jan 19 23:32:35 CST 2019
     */
    int updateByExampleSelective(@Param("record") WfModulePort record, @Param("example") WfModulePortExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_module_port
     *
     * @mbg.generated Sat Jan 19 23:32:35 CST 2019
     */
    int updateByExample(@Param("record") WfModulePort record, @Param("example") WfModulePortExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_module_port
     *
     * @mbg.generated Sat Jan 19 23:32:35 CST 2019
     */
    int updateByPrimaryKeySelective(WfModulePort record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_module_port
     *
     * @mbg.generated Sat Jan 19 23:32:35 CST 2019
     */
    int updateByPrimaryKey(WfModulePort record);
}