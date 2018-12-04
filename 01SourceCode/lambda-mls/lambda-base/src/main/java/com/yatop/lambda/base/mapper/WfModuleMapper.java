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
     * @mbg.generated Tue Dec 04 08:41:08 CST 2018
     */
    long countByExample(WfModuleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_module
     *
     * @mbg.generated Tue Dec 04 08:41:08 CST 2018
     */
    int deleteByExample(WfModuleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_module
     *
     * @mbg.generated Tue Dec 04 08:41:08 CST 2018
     */
    int deleteByPrimaryKey(Long moduleId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_module
     *
     * @mbg.generated Tue Dec 04 08:41:08 CST 2018
     */
    int insert(WfModule record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_module
     *
     * @mbg.generated Tue Dec 04 08:41:08 CST 2018
     */
    int insertSelective(WfModule record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_module
     *
     * @mbg.generated Tue Dec 04 08:41:08 CST 2018
     */
    List<WfModule> selectByExample(WfModuleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_module
     *
     * @mbg.generated Tue Dec 04 08:41:08 CST 2018
     */
    WfModule selectByPrimaryKey(Long moduleId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_module
     *
     * @mbg.generated Tue Dec 04 08:41:08 CST 2018
     */
    int updateByExampleSelective(@Param("record") WfModule record, @Param("example") WfModuleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_module
     *
     * @mbg.generated Tue Dec 04 08:41:08 CST 2018
     */
    int updateByExample(@Param("record") WfModule record, @Param("example") WfModuleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_module
     *
     * @mbg.generated Tue Dec 04 08:41:08 CST 2018
     */
    int updateByPrimaryKeySelective(WfModule record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_module
     *
     * @mbg.generated Tue Dec 04 08:41:08 CST 2018
     */
    int updateByPrimaryKey(WfModule record);
}