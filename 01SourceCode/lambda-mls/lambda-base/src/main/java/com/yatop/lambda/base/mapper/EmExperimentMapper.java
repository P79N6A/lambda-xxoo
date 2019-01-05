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
     * @mbg.generated Sun Jan 06 01:14:12 CST 2019
     */
    long countByExample(EmExperimentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table em_experiment
     *
     * @mbg.generated Sun Jan 06 01:14:12 CST 2019
     */
    int deleteByExample(EmExperimentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table em_experiment
     *
     * @mbg.generated Sun Jan 06 01:14:12 CST 2019
     */
    int deleteByPrimaryKey(Long experimentId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table em_experiment
     *
     * @mbg.generated Sun Jan 06 01:14:12 CST 2019
     */
    int insert(EmExperiment record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table em_experiment
     *
     * @mbg.generated Sun Jan 06 01:14:12 CST 2019
     */
    int insertSelective(EmExperiment record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table em_experiment
     *
     * @mbg.generated Sun Jan 06 01:14:12 CST 2019
     */
    List<EmExperiment> selectByExample(EmExperimentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table em_experiment
     *
     * @mbg.generated Sun Jan 06 01:14:12 CST 2019
     */
    EmExperiment selectByPrimaryKey(Long experimentId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table em_experiment
     *
     * @mbg.generated Sun Jan 06 01:14:12 CST 2019
     */
    int updateByExampleSelective(@Param("record") EmExperiment record, @Param("example") EmExperimentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table em_experiment
     *
     * @mbg.generated Sun Jan 06 01:14:12 CST 2019
     */
    int updateByExample(@Param("record") EmExperiment record, @Param("example") EmExperimentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table em_experiment
     *
     * @mbg.generated Sun Jan 06 01:14:12 CST 2019
     */
    int updateByPrimaryKeySelective(EmExperiment record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table em_experiment
     *
     * @mbg.generated Sun Jan 06 01:14:12 CST 2019
     */
    int updateByPrimaryKey(EmExperiment record);
}