package com.yatop.lambda.base.mapper;

import com.yatop.lambda.base.model.CfCmptCharValue;
import com.yatop.lambda.base.model.CfCmptCharValueExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CfCmptCharValueMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_char_value
     *
     * @mbg.generated Mon Dec 03 11:07:18 CST 2018
     */
    long countByExample(CfCmptCharValueExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_char_value
     *
     * @mbg.generated Mon Dec 03 11:07:18 CST 2018
     */
    int deleteByExample(CfCmptCharValueExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_char_value
     *
     * @mbg.generated Mon Dec 03 11:07:18 CST 2018
     */
    int deleteByPrimaryKey(@Param("cmptId") String cmptId, @Param("charId") String charId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_char_value
     *
     * @mbg.generated Mon Dec 03 11:07:18 CST 2018
     */
    int insert(CfCmptCharValue record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_char_value
     *
     * @mbg.generated Mon Dec 03 11:07:18 CST 2018
     */
    int insertSelective(CfCmptCharValue record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_char_value
     *
     * @mbg.generated Mon Dec 03 11:07:18 CST 2018
     */
    List<CfCmptCharValue> selectByExample(CfCmptCharValueExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_char_value
     *
     * @mbg.generated Mon Dec 03 11:07:18 CST 2018
     */
    CfCmptCharValue selectByPrimaryKey(@Param("cmptId") String cmptId, @Param("charId") String charId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_char_value
     *
     * @mbg.generated Mon Dec 03 11:07:18 CST 2018
     */
    int updateByExampleSelective(@Param("record") CfCmptCharValue record, @Param("example") CfCmptCharValueExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_char_value
     *
     * @mbg.generated Mon Dec 03 11:07:18 CST 2018
     */
    int updateByExample(@Param("record") CfCmptCharValue record, @Param("example") CfCmptCharValueExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_char_value
     *
     * @mbg.generated Mon Dec 03 11:07:18 CST 2018
     */
    int updateByPrimaryKeySelective(CfCmptCharValue record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_char_value
     *
     * @mbg.generated Mon Dec 03 11:07:18 CST 2018
     */
    int updateByPrimaryKey(CfCmptCharValue record);
}