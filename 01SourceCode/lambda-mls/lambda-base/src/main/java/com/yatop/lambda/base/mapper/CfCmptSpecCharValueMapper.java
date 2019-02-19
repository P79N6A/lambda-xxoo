package com.yatop.lambda.base.mapper;

import com.yatop.lambda.base.model.CfCmptSpecCharValue;
import com.yatop.lambda.base.model.CfCmptSpecCharValueExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CfCmptSpecCharValueMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_spec_char_value
     *
     * @mbg.generated Tue Feb 19 12:35:31 CST 2019
     */
    long countByExample(CfCmptSpecCharValueExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_spec_char_value
     *
     * @mbg.generated Tue Feb 19 12:35:31 CST 2019
     */
    int deleteByExample(CfCmptSpecCharValueExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_spec_char_value
     *
     * @mbg.generated Tue Feb 19 12:35:31 CST 2019
     */
    int deleteByPrimaryKey(@Param("specId") String specId, @Param("charId") String charId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_spec_char_value
     *
     * @mbg.generated Tue Feb 19 12:35:31 CST 2019
     */
    int insert(CfCmptSpecCharValue record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_spec_char_value
     *
     * @mbg.generated Tue Feb 19 12:35:31 CST 2019
     */
    int insertSelective(CfCmptSpecCharValue record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_spec_char_value
     *
     * @mbg.generated Tue Feb 19 12:35:31 CST 2019
     */
    List<CfCmptSpecCharValue> selectByExample(CfCmptSpecCharValueExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_spec_char_value
     *
     * @mbg.generated Tue Feb 19 12:35:31 CST 2019
     */
    CfCmptSpecCharValue selectByPrimaryKey(@Param("specId") String specId, @Param("charId") String charId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_spec_char_value
     *
     * @mbg.generated Tue Feb 19 12:35:31 CST 2019
     */
    int updateByExampleSelective(@Param("record") CfCmptSpecCharValue record, @Param("example") CfCmptSpecCharValueExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_spec_char_value
     *
     * @mbg.generated Tue Feb 19 12:35:31 CST 2019
     */
    int updateByExample(@Param("record") CfCmptSpecCharValue record, @Param("example") CfCmptSpecCharValueExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_spec_char_value
     *
     * @mbg.generated Tue Feb 19 12:35:31 CST 2019
     */
    int updateByPrimaryKeySelective(CfCmptSpecCharValue record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_spec_char_value
     *
     * @mbg.generated Tue Feb 19 12:35:31 CST 2019
     */
    int updateByPrimaryKey(CfCmptSpecCharValue record);
}