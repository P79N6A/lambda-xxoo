package com.yatop.lambda.base.mapper;

import com.yatop.lambda.base.model.CfCmptCharEnum;
import com.yatop.lambda.base.model.CfCmptCharEnumExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CfCmptCharEnumMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_char_enum
     *
     * @mbg.generated Wed Jan 02 16:24:07 CST 2019
     */
    long countByExample(CfCmptCharEnumExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_char_enum
     *
     * @mbg.generated Wed Jan 02 16:24:07 CST 2019
     */
    int deleteByExample(CfCmptCharEnumExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_char_enum
     *
     * @mbg.generated Wed Jan 02 16:24:07 CST 2019
     */
    int deleteByPrimaryKey(@Param("charId") String charId, @Param("enumName") String enumName);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_char_enum
     *
     * @mbg.generated Wed Jan 02 16:24:07 CST 2019
     */
    int insert(CfCmptCharEnum record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_char_enum
     *
     * @mbg.generated Wed Jan 02 16:24:07 CST 2019
     */
    int insertSelective(CfCmptCharEnum record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_char_enum
     *
     * @mbg.generated Wed Jan 02 16:24:07 CST 2019
     */
    List<CfCmptCharEnum> selectByExample(CfCmptCharEnumExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_char_enum
     *
     * @mbg.generated Wed Jan 02 16:24:07 CST 2019
     */
    CfCmptCharEnum selectByPrimaryKey(@Param("charId") String charId, @Param("enumName") String enumName);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_char_enum
     *
     * @mbg.generated Wed Jan 02 16:24:07 CST 2019
     */
    int updateByExampleSelective(@Param("record") CfCmptCharEnum record, @Param("example") CfCmptCharEnumExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_char_enum
     *
     * @mbg.generated Wed Jan 02 16:24:07 CST 2019
     */
    int updateByExample(@Param("record") CfCmptCharEnum record, @Param("example") CfCmptCharEnumExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_char_enum
     *
     * @mbg.generated Wed Jan 02 16:24:07 CST 2019
     */
    int updateByPrimaryKeySelective(CfCmptCharEnum record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_char_enum
     *
     * @mbg.generated Wed Jan 02 16:24:07 CST 2019
     */
    int updateByPrimaryKey(CfCmptCharEnum record);
}