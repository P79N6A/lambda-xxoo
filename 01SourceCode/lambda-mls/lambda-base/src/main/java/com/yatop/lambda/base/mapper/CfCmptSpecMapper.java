package com.yatop.lambda.base.mapper;

import com.yatop.lambda.base.model.CfCmptSpec;
import com.yatop.lambda.base.model.CfCmptSpecExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CfCmptSpecMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_spec
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    long countByExample(CfCmptSpecExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_spec
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    int deleteByExample(CfCmptSpecExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_spec
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    int deleteByPrimaryKey(String specId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_spec
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    int insert(CfCmptSpec record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_spec
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    int insertSelective(CfCmptSpec record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_spec
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    List<CfCmptSpec> selectByExample(CfCmptSpecExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_spec
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    CfCmptSpec selectByPrimaryKey(String specId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_spec
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    int updateByExampleSelective(@Param("record") CfCmptSpec record, @Param("example") CfCmptSpecExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_spec
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    int updateByExample(@Param("record") CfCmptSpec record, @Param("example") CfCmptSpecExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_spec
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    int updateByPrimaryKeySelective(CfCmptSpec record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_spec
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    int updateByPrimaryKey(CfCmptSpec record);
}