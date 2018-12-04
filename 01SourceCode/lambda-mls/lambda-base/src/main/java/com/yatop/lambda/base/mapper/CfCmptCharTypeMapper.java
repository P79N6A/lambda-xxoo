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
     * @mbg.generated Tue Dec 04 13:25:54 CST 2018
     */
    long countByExample(CfCmptCharTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_char_type
     *
     * @mbg.generated Tue Dec 04 13:25:54 CST 2018
     */
    int deleteByExample(CfCmptCharTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_char_type
     *
     * @mbg.generated Tue Dec 04 13:25:54 CST 2018
     */
    int deleteByPrimaryKey(Integer charTypeId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_char_type
     *
     * @mbg.generated Tue Dec 04 13:25:54 CST 2018
     */
    int insert(CfCmptCharType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_char_type
     *
     * @mbg.generated Tue Dec 04 13:25:54 CST 2018
     */
    int insertSelective(CfCmptCharType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_char_type
     *
     * @mbg.generated Tue Dec 04 13:25:54 CST 2018
     */
    List<CfCmptCharType> selectByExample(CfCmptCharTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_char_type
     *
     * @mbg.generated Tue Dec 04 13:25:54 CST 2018
     */
    CfCmptCharType selectByPrimaryKey(Integer charTypeId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_char_type
     *
     * @mbg.generated Tue Dec 04 13:25:54 CST 2018
     */
    int updateByExampleSelective(@Param("record") CfCmptCharType record, @Param("example") CfCmptCharTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_char_type
     *
     * @mbg.generated Tue Dec 04 13:25:54 CST 2018
     */
    int updateByExample(@Param("record") CfCmptCharType record, @Param("example") CfCmptCharTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_char_type
     *
     * @mbg.generated Tue Dec 04 13:25:54 CST 2018
     */
    int updateByPrimaryKeySelective(CfCmptCharType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_char_type
     *
     * @mbg.generated Tue Dec 04 13:25:54 CST 2018
     */
    int updateByPrimaryKey(CfCmptCharType record);
}