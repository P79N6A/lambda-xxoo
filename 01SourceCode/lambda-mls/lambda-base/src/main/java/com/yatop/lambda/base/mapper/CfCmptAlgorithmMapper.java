package com.yatop.lambda.base.mapper;

import com.yatop.lambda.base.model.CfCmptAlgorithm;
import com.yatop.lambda.base.model.CfCmptAlgorithmExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CfCmptAlgorithmMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_algorithm
     *
     * @mbg.generated Tue Feb 19 12:35:31 CST 2019
     */
    long countByExample(CfCmptAlgorithmExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_algorithm
     *
     * @mbg.generated Tue Feb 19 12:35:31 CST 2019
     */
    int deleteByExample(CfCmptAlgorithmExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_algorithm
     *
     * @mbg.generated Tue Feb 19 12:35:31 CST 2019
     */
    int deleteByPrimaryKey(Long algorithmId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_algorithm
     *
     * @mbg.generated Tue Feb 19 12:35:31 CST 2019
     */
    int insert(CfCmptAlgorithm record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_algorithm
     *
     * @mbg.generated Tue Feb 19 12:35:31 CST 2019
     */
    int insertSelective(CfCmptAlgorithm record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_algorithm
     *
     * @mbg.generated Tue Feb 19 12:35:31 CST 2019
     */
    List<CfCmptAlgorithm> selectByExample(CfCmptAlgorithmExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_algorithm
     *
     * @mbg.generated Tue Feb 19 12:35:31 CST 2019
     */
    CfCmptAlgorithm selectByPrimaryKey(Long algorithmId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_algorithm
     *
     * @mbg.generated Tue Feb 19 12:35:31 CST 2019
     */
    int updateByExampleSelective(@Param("record") CfCmptAlgorithm record, @Param("example") CfCmptAlgorithmExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_algorithm
     *
     * @mbg.generated Tue Feb 19 12:35:31 CST 2019
     */
    int updateByExample(@Param("record") CfCmptAlgorithm record, @Param("example") CfCmptAlgorithmExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_algorithm
     *
     * @mbg.generated Tue Feb 19 12:35:31 CST 2019
     */
    int updateByPrimaryKeySelective(CfCmptAlgorithm record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_algorithm
     *
     * @mbg.generated Tue Feb 19 12:35:31 CST 2019
     */
    int updateByPrimaryKey(CfCmptAlgorithm record);
}