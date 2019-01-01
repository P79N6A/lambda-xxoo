package com.yatop.lambda.base.mapper;

import com.yatop.lambda.base.model.WfModule;
import com.yatop.lambda.base.model.WfModuleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WfModuleMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_module
     *
     * @mbg.generated Wed Jan 02 00:41:23 CST 2019
     */
    long countByExample(WfModuleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_module
     *
     * @mbg.generated Wed Jan 02 00:41:23 CST 2019
     */
    int deleteByExample(WfModuleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_module
     *
     * @mbg.generated Wed Jan 02 00:41:23 CST 2019
     */
    int deleteByPrimaryKey(Long moduleId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_module
     *
     * @mbg.generated Wed Jan 02 00:41:23 CST 2019
     */
    int insert(WfModule record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_module
     *
     * @mbg.generated Wed Jan 02 00:41:23 CST 2019
     */
    int insertSelective(WfModule record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_module
     *
     * @mbg.generated Wed Jan 02 00:41:23 CST 2019
     */
    List<WfModule> selectByExample(WfModuleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_module
     *
     * @mbg.generated Wed Jan 02 00:41:23 CST 2019
     */
    WfModule selectByPrimaryKey(Long moduleId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_module
     *
     * @mbg.generated Wed Jan 02 00:41:23 CST 2019
     */
    int updateByExampleSelective(@Param("record") WfModule record, @Param("example") WfModuleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_module
     *
     * @mbg.generated Wed Jan 02 00:41:23 CST 2019
     */
    int updateByExample(@Param("record") WfModule record, @Param("example") WfModuleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_module
     *
     * @mbg.generated Wed Jan 02 00:41:23 CST 2019
     */
    int updateByPrimaryKeySelective(WfModule record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_module
     *
     * @mbg.generated Wed Jan 02 00:41:23 CST 2019
     */
    int updateByPrimaryKey(WfModule record);
}