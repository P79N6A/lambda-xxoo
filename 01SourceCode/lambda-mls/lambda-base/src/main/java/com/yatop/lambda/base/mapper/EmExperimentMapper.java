package com.yatop.lambda.base.mapper;

import com.yatop.lambda.base.model.EmExperiment;
import com.yatop.lambda.base.model.EmExperimentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EmExperimentMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table em_experiment
     *
     * @mbg.generated Sun Dec 09 01:21:55 CST 2018
     */
    long countByExample(EmExperimentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table em_experiment
     *
     * @mbg.generated Sun Dec 09 01:21:55 CST 2018
     */
    int deleteByExample(EmExperimentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table em_experiment
     *
     * @mbg.generated Sun Dec 09 01:21:55 CST 2018
     */
    int deleteByPrimaryKey(Long experimentId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table em_experiment
     *
     * @mbg.generated Sun Dec 09 01:21:55 CST 2018
     */
    int insert(EmExperiment record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table em_experiment
     *
     * @mbg.generated Sun Dec 09 01:21:55 CST 2018
     */
    int insertSelective(EmExperiment record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table em_experiment
     *
     * @mbg.generated Sun Dec 09 01:21:55 CST 2018
     */
    List<EmExperiment> selectByExample(EmExperimentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table em_experiment
     *
     * @mbg.generated Sun Dec 09 01:21:55 CST 2018
     */
    EmExperiment selectByPrimaryKey(Long experimentId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table em_experiment
     *
     * @mbg.generated Sun Dec 09 01:21:55 CST 2018
     */
    int updateByExampleSelective(@Param("record") EmExperiment record, @Param("example") EmExperimentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table em_experiment
     *
     * @mbg.generated Sun Dec 09 01:21:55 CST 2018
     */
    int updateByExample(@Param("record") EmExperiment record, @Param("example") EmExperimentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table em_experiment
     *
     * @mbg.generated Sun Dec 09 01:21:55 CST 2018
     */
    int updateByPrimaryKeySelective(EmExperiment record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table em_experiment
     *
     * @mbg.generated Sun Dec 09 01:21:55 CST 2018
     */
    int updateByPrimaryKey(EmExperiment record);
}