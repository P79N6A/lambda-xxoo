package com.yatop.lambda.base.mapper;

import com.yatop.lambda.base.model.CfCmptSpecRel;
import com.yatop.lambda.base.model.CfCmptSpecRelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CfCmptSpecRelMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_spec_rel
     *
     * @mbg.generated Tue Feb 19 12:35:31 CST 2019
     */
    long countByExample(CfCmptSpecRelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_spec_rel
     *
     * @mbg.generated Tue Feb 19 12:35:31 CST 2019
     */
    int deleteByExample(CfCmptSpecRelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_spec_rel
     *
     * @mbg.generated Tue Feb 19 12:35:31 CST 2019
     */
    int deleteByPrimaryKey(@Param("cmptId") String cmptId, @Param("specType") Integer specType);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_spec_rel
     *
     * @mbg.generated Tue Feb 19 12:35:31 CST 2019
     */
    int insert(CfCmptSpecRel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_spec_rel
     *
     * @mbg.generated Tue Feb 19 12:35:31 CST 2019
     */
    int insertSelective(CfCmptSpecRel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_spec_rel
     *
     * @mbg.generated Tue Feb 19 12:35:31 CST 2019
     */
    List<CfCmptSpecRel> selectByExample(CfCmptSpecRelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_spec_rel
     *
     * @mbg.generated Tue Feb 19 12:35:31 CST 2019
     */
    CfCmptSpecRel selectByPrimaryKey(@Param("cmptId") String cmptId, @Param("specType") Integer specType);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_spec_rel
     *
     * @mbg.generated Tue Feb 19 12:35:31 CST 2019
     */
    int updateByExampleSelective(@Param("record") CfCmptSpecRel record, @Param("example") CfCmptSpecRelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_spec_rel
     *
     * @mbg.generated Tue Feb 19 12:35:31 CST 2019
     */
    int updateByExample(@Param("record") CfCmptSpecRel record, @Param("example") CfCmptSpecRelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_spec_rel
     *
     * @mbg.generated Tue Feb 19 12:35:31 CST 2019
     */
    int updateByPrimaryKeySelective(CfCmptSpecRel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_spec_rel
     *
     * @mbg.generated Tue Feb 19 12:35:31 CST 2019
     */
    int updateByPrimaryKey(CfCmptSpecRel record);
}