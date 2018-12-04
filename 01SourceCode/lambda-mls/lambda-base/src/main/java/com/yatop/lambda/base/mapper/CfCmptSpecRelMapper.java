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
     * @mbg.generated Tue Dec 04 13:25:54 CST 2018
     */
    long countByExample(CfCmptSpecRelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_spec_rel
     *
     * @mbg.generated Tue Dec 04 13:25:54 CST 2018
     */
    int deleteByExample(CfCmptSpecRelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_spec_rel
     *
     * @mbg.generated Tue Dec 04 13:25:54 CST 2018
     */
    int deleteByPrimaryKey(@Param("cmptId") String cmptId, @Param("specType") Integer specType);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_spec_rel
     *
     * @mbg.generated Tue Dec 04 13:25:54 CST 2018
     */
    int insert(CfCmptSpecRel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_spec_rel
     *
     * @mbg.generated Tue Dec 04 13:25:54 CST 2018
     */
    int insertSelective(CfCmptSpecRel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_spec_rel
     *
     * @mbg.generated Tue Dec 04 13:25:54 CST 2018
     */
    List<CfCmptSpecRel> selectByExample(CfCmptSpecRelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_spec_rel
     *
     * @mbg.generated Tue Dec 04 13:25:54 CST 2018
     */
    CfCmptSpecRel selectByPrimaryKey(@Param("cmptId") String cmptId, @Param("specType") Integer specType);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_spec_rel
     *
     * @mbg.generated Tue Dec 04 13:25:54 CST 2018
     */
    int updateByExampleSelective(@Param("record") CfCmptSpecRel record, @Param("example") CfCmptSpecRelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_spec_rel
     *
     * @mbg.generated Tue Dec 04 13:25:54 CST 2018
     */
    int updateByExample(@Param("record") CfCmptSpecRel record, @Param("example") CfCmptSpecRelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_spec_rel
     *
     * @mbg.generated Tue Dec 04 13:25:54 CST 2018
     */
    int updateByPrimaryKeySelective(CfCmptSpecRel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_spec_rel
     *
     * @mbg.generated Tue Dec 04 13:25:54 CST 2018
     */
    int updateByPrimaryKey(CfCmptSpecRel record);
}