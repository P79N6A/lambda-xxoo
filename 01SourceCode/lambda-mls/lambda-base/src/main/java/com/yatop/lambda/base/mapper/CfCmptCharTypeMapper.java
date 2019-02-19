package com.yatop.lambda.base.mapper;

import com.yatop.lambda.base.model.CfCmptCharType;
import com.yatop.lambda.base.model.CfCmptCharTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CfCmptCharTypeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_char_type
     *
     * @mbg.generated Tue Feb 19 12:35:31 CST 2019
     */
    long countByExample(CfCmptCharTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_char_type
     *
     * @mbg.generated Tue Feb 19 12:35:31 CST 2019
     */
    int deleteByExample(CfCmptCharTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_char_type
     *
     * @mbg.generated Tue Feb 19 12:35:31 CST 2019
     */
    int deleteByPrimaryKey(Integer charTypeId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_char_type
     *
     * @mbg.generated Tue Feb 19 12:35:31 CST 2019
     */
    int insert(CfCmptCharType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_char_type
     *
     * @mbg.generated Tue Feb 19 12:35:31 CST 2019
     */
    int insertSelective(CfCmptCharType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_char_type
     *
     * @mbg.generated Tue Feb 19 12:35:31 CST 2019
     */
    List<CfCmptCharType> selectByExample(CfCmptCharTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_char_type
     *
     * @mbg.generated Tue Feb 19 12:35:31 CST 2019
     */
    CfCmptCharType selectByPrimaryKey(Integer charTypeId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_char_type
     *
     * @mbg.generated Tue Feb 19 12:35:31 CST 2019
     */
    int updateByExampleSelective(@Param("record") CfCmptCharType record, @Param("example") CfCmptCharTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_char_type
     *
     * @mbg.generated Tue Feb 19 12:35:31 CST 2019
     */
    int updateByExample(@Param("record") CfCmptCharType record, @Param("example") CfCmptCharTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_char_type
     *
     * @mbg.generated Tue Feb 19 12:35:31 CST 2019
     */
    int updateByPrimaryKeySelective(CfCmptCharType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_char_type
     *
     * @mbg.generated Tue Feb 19 12:35:31 CST 2019
     */
    int updateByPrimaryKey(CfCmptCharType record);
}