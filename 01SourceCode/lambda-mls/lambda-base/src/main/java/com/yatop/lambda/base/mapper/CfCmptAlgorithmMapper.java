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
     * @mbg.generated Sun Dec 09 01:21:55 CST 2018
     */
    long countByExample(CfCmptAlgorithmExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_algorithm
     *
     * @mbg.generated Sun Dec 09 01:21:55 CST 2018
     */
    int deleteByExample(CfCmptAlgorithmExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_algorithm
     *
     * @mbg.generated Sun Dec 09 01:21:55 CST 2018
     */
    int deleteByPrimaryKey(Long algorithmId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_algorithm
     *
     * @mbg.generated Sun Dec 09 01:21:55 CST 2018
     */
    int insert(CfCmptAlgorithm record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_algorithm
     *
     * @mbg.generated Sun Dec 09 01:21:55 CST 2018
     */
    int insertSelective(CfCmptAlgorithm record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_algorithm
     *
     * @mbg.generated Sun Dec 09 01:21:55 CST 2018
     */
    List<CfCmptAlgorithm> selectByExample(CfCmptAlgorithmExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_algorithm
     *
     * @mbg.generated Sun Dec 09 01:21:55 CST 2018
     */
    CfCmptAlgorithm selectByPrimaryKey(Long algorithmId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_algorithm
     *
     * @mbg.generated Sun Dec 09 01:21:55 CST 2018
     */
    int updateByExampleSelective(@Param("record") CfCmptAlgorithm record, @Param("example") CfCmptAlgorithmExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_algorithm
     *
     * @mbg.generated Sun Dec 09 01:21:55 CST 2018
     */
    int updateByExample(@Param("record") CfCmptAlgorithm record, @Param("example") CfCmptAlgorithmExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_algorithm
     *
     * @mbg.generated Sun Dec 09 01:21:55 CST 2018
     */
    int updateByPrimaryKeySelective(CfCmptAlgorithm record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_algorithm
     *
     * @mbg.generated Sun Dec 09 01:21:55 CST 2018
     */
    int updateByPrimaryKey(CfCmptAlgorithm record);
}