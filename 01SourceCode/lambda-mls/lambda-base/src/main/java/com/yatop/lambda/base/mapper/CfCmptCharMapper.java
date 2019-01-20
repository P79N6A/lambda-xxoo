package com.yatop.lambda.base.mapper;

import com.yatop.lambda.base.model.CfCmptChar;
import com.yatop.lambda.base.model.CfCmptCharExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CfCmptCharMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_char
     *
     * @mbg.generated Sun Jan 20 20:16:57 CST 2019
     */
    long countByExample(CfCmptCharExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_char
     *
     * @mbg.generated Sun Jan 20 20:16:57 CST 2019
     */
    int deleteByExample(CfCmptCharExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_char
     *
     * @mbg.generated Sun Jan 20 20:16:57 CST 2019
     */
    int deleteByPrimaryKey(String charId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_char
     *
     * @mbg.generated Sun Jan 20 20:16:57 CST 2019
     */
    int insert(CfCmptChar record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_char
     *
     * @mbg.generated Sun Jan 20 20:16:57 CST 2019
     */
    int insertSelective(CfCmptChar record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_char
     *
     * @mbg.generated Sun Jan 20 20:16:57 CST 2019
     */
    List<CfCmptChar> selectByExample(CfCmptCharExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_char
     *
     * @mbg.generated Sun Jan 20 20:16:57 CST 2019
     */
    CfCmptChar selectByPrimaryKey(String charId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_char
     *
     * @mbg.generated Sun Jan 20 20:16:57 CST 2019
     */
    int updateByExampleSelective(@Param("record") CfCmptChar record, @Param("example") CfCmptCharExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_char
     *
     * @mbg.generated Sun Jan 20 20:16:57 CST 2019
     */
    int updateByExample(@Param("record") CfCmptChar record, @Param("example") CfCmptCharExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_char
     *
     * @mbg.generated Sun Jan 20 20:16:57 CST 2019
     */
    int updateByPrimaryKeySelective(CfCmptChar record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_char
     *
     * @mbg.generated Sun Jan 20 20:16:57 CST 2019
     */
    int updateByPrimaryKey(CfCmptChar record);
}