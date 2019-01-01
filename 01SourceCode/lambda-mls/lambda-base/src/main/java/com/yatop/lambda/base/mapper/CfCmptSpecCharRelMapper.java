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
     * @mbg.generated Tue Jan 01 18:06:32 CST 2019
     */
    long countByExample(CfCmptSpecCharRelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_spec_char_rel
     *
     * @mbg.generated Tue Jan 01 18:06:32 CST 2019
     */
    int deleteByExample(CfCmptSpecCharRelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_spec_char_rel
     *
     * @mbg.generated Tue Jan 01 18:06:32 CST 2019
     */
    int deleteByPrimaryKey(@Param("specId") String specId, @Param("charId") String charId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_spec_char_rel
     *
     * @mbg.generated Tue Jan 01 18:06:32 CST 2019
     */
    int insert(CfCmptSpecCharRel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_spec_char_rel
     *
     * @mbg.generated Tue Jan 01 18:06:32 CST 2019
     */
    int insertSelective(CfCmptSpecCharRel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_spec_char_rel
     *
     * @mbg.generated Tue Jan 01 18:06:32 CST 2019
     */
    List<CfCmptSpecCharRel> selectByExample(CfCmptSpecCharRelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_spec_char_rel
     *
     * @mbg.generated Tue Jan 01 18:06:32 CST 2019
     */
    CfCmptSpecCharRel selectByPrimaryKey(@Param("specId") String specId, @Param("charId") String charId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_spec_char_rel
     *
     * @mbg.generated Tue Jan 01 18:06:32 CST 2019
     */
    int updateByExampleSelective(@Param("record") CfCmptSpecCharRel record, @Param("example") CfCmptSpecCharRelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_spec_char_rel
     *
     * @mbg.generated Tue Jan 01 18:06:32 CST 2019
     */
    int updateByExample(@Param("record") CfCmptSpecCharRel record, @Param("example") CfCmptSpecCharRelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_spec_char_rel
     *
     * @mbg.generated Tue Jan 01 18:06:32 CST 2019
     */
    int updateByPrimaryKeySelective(CfCmptSpecCharRel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_spec_char_rel
     *
     * @mbg.generated Tue Jan 01 18:06:32 CST 2019
     */
    int updateByPrimaryKey(CfCmptSpecCharRel record);
}