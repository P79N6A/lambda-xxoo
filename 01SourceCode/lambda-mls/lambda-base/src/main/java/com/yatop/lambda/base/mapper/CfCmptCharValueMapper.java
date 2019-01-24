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
     * @mbg.generated Thu Jan 24 15:07:19 CST 2019
     */
    long countByExample(CfCmptCharValueExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_char_value
     *
     * @mbg.generated Thu Jan 24 15:07:19 CST 2019
     */
    int deleteByExample(CfCmptCharValueExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_char_value
     *
     * @mbg.generated Thu Jan 24 15:07:19 CST 2019
     */
    int deleteByPrimaryKey(@Param("cmptId") String cmptId, @Param("charId") String charId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_char_value
     *
     * @mbg.generated Thu Jan 24 15:07:19 CST 2019
     */
    int insert(CfCmptCharValue record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_char_value
     *
     * @mbg.generated Thu Jan 24 15:07:19 CST 2019
     */
    int insertSelective(CfCmptCharValue record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_char_value
     *
     * @mbg.generated Thu Jan 24 15:07:19 CST 2019
     */
    List<CfCmptCharValue> selectByExample(CfCmptCharValueExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_char_value
     *
     * @mbg.generated Thu Jan 24 15:07:19 CST 2019
     */
    CfCmptCharValue selectByPrimaryKey(@Param("cmptId") String cmptId, @Param("charId") String charId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_char_value
     *
     * @mbg.generated Thu Jan 24 15:07:19 CST 2019
     */
    int updateByExampleSelective(@Param("record") CfCmptCharValue record, @Param("example") CfCmptCharValueExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_char_value
     *
     * @mbg.generated Thu Jan 24 15:07:19 CST 2019
     */
    int updateByExample(@Param("record") CfCmptCharValue record, @Param("example") CfCmptCharValueExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_char_value
     *
     * @mbg.generated Thu Jan 24 15:07:19 CST 2019
     */
    int updateByPrimaryKeySelective(CfCmptCharValue record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_char_value
     *
     * @mbg.generated Thu Jan 24 15:07:19 CST 2019
     */
    int updateByPrimaryKey(CfCmptCharValue record);
}