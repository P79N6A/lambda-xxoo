package com.yatop.lambda.base.mapper;

import com.yatop.lambda.base.model.CfCmptCharTypeWild;
import com.yatop.lambda.base.model.CfCmptCharTypeWildExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CfCmptCharTypeWildMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_char_type_wild
     *
     * @mbg.generated Sun Dec 09 01:21:55 CST 2018
     */
    long countByExample(CfCmptCharTypeWildExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_char_type_wild
     *
     * @mbg.generated Sun Dec 09 01:21:55 CST 2018
     */
    int deleteByExample(CfCmptCharTypeWildExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_char_type_wild
     *
     * @mbg.generated Sun Dec 09 01:21:55 CST 2018
     */
    int deleteByPrimaryKey(@Param("wildCharTypeId") Integer wildCharTypeId, @Param("unitCharTypeId") Integer unitCharTypeId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_char_type_wild
     *
     * @mbg.generated Sun Dec 09 01:21:55 CST 2018
     */
    int insert(CfCmptCharTypeWild record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_char_type_wild
     *
     * @mbg.generated Sun Dec 09 01:21:55 CST 2018
     */
    int insertSelective(CfCmptCharTypeWild record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_char_type_wild
     *
     * @mbg.generated Sun Dec 09 01:21:55 CST 2018
     */
    List<CfCmptCharTypeWild> selectByExample(CfCmptCharTypeWildExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_char_type_wild
     *
     * @mbg.generated Sun Dec 09 01:21:55 CST 2018
     */
    CfCmptCharTypeWild selectByPrimaryKey(@Param("wildCharTypeId") Integer wildCharTypeId, @Param("unitCharTypeId") Integer unitCharTypeId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_char_type_wild
     *
     * @mbg.generated Sun Dec 09 01:21:55 CST 2018
     */
    int updateByExampleSelective(@Param("record") CfCmptCharTypeWild record, @Param("example") CfCmptCharTypeWildExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_char_type_wild
     *
     * @mbg.generated Sun Dec 09 01:21:55 CST 2018
     */
    int updateByExample(@Param("record") CfCmptCharTypeWild record, @Param("example") CfCmptCharTypeWildExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_char_type_wild
     *
     * @mbg.generated Sun Dec 09 01:21:55 CST 2018
     */
    int updateByPrimaryKeySelective(CfCmptCharTypeWild record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_char_type_wild
     *
     * @mbg.generated Sun Dec 09 01:21:55 CST 2018
     */
    int updateByPrimaryKey(CfCmptCharTypeWild record);
}