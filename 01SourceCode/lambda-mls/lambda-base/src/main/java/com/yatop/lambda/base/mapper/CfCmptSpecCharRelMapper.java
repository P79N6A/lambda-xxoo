package com.yatop.lambda.base.mapper;

import com.yatop.lambda.base.model.CfCmptSpecCharRel;
import com.yatop.lambda.base.model.CfCmptSpecCharRelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CfCmptSpecCharRelMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_spec_char_rel
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    long countByExample(CfCmptSpecCharRelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_spec_char_rel
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    int deleteByExample(CfCmptSpecCharRelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_spec_char_rel
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    int deleteByPrimaryKey(@Param("specId") String specId, @Param("charId") String charId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_spec_char_rel
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    int insert(CfCmptSpecCharRel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_spec_char_rel
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    int insertSelective(CfCmptSpecCharRel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_spec_char_rel
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    List<CfCmptSpecCharRel> selectByExample(CfCmptSpecCharRelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_spec_char_rel
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    CfCmptSpecCharRel selectByPrimaryKey(@Param("specId") String specId, @Param("charId") String charId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_spec_char_rel
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    int updateByExampleSelective(@Param("record") CfCmptSpecCharRel record, @Param("example") CfCmptSpecCharRelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_spec_char_rel
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    int updateByExample(@Param("record") CfCmptSpecCharRel record, @Param("example") CfCmptSpecCharRelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_spec_char_rel
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    int updateByPrimaryKeySelective(CfCmptSpecCharRel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_spec_char_rel
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    int updateByPrimaryKey(CfCmptSpecCharRel record);
}