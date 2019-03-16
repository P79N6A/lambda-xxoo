package com.yatop.lambda.base.mapper;

import com.yatop.lambda.base.model.EmExperimentOpen;
import com.yatop.lambda.base.model.EmExperimentOpenExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EmExperimentOpenMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table em_experiment_open
     *
     * @mbg.generated Thu Mar 07 20:56:58 CST 2019
     */
    long countByExample(EmExperimentOpenExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table em_experiment_open
     *
     * @mbg.generated Thu Mar 07 20:56:58 CST 2019
     */
    int deleteByExample(EmExperimentOpenExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table em_experiment_open
     *
     * @mbg.generated Thu Mar 07 20:56:58 CST 2019
     */
    int deleteByPrimaryKey(Long experimentId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table em_experiment_open
     *
     * @mbg.generated Thu Mar 07 20:56:58 CST 2019
     */
    int insert(EmExperimentOpen record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table em_experiment_open
     *
     * @mbg.generated Thu Mar 07 20:56:58 CST 2019
     */
    int insertSelective(EmExperimentOpen record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table em_experiment_open
     *
     * @mbg.generated Thu Mar 07 20:56:58 CST 2019
     */
    List<EmExperimentOpen> selectByExample(EmExperimentOpenExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table em_experiment_open
     *
     * @mbg.generated Thu Mar 07 20:56:58 CST 2019
     */
    EmExperimentOpen selectByPrimaryKey(Long experimentId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table em_experiment_open
     *
     * @mbg.generated Thu Mar 07 20:56:58 CST 2019
     */
    int updateByExampleSelective(@Param("record") EmExperimentOpen record, @Param("example") EmExperimentOpenExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table em_experiment_open
     *
     * @mbg.generated Thu Mar 07 20:56:58 CST 2019
     */
    int updateByExample(@Param("record") EmExperimentOpen record, @Param("example") EmExperimentOpenExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table em_experiment_open
     *
     * @mbg.generated Thu Mar 07 20:56:58 CST 2019
     */
    int updateByPrimaryKeySelective(EmExperimentOpen record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table em_experiment_open
     *
     * @mbg.generated Thu Mar 07 20:56:58 CST 2019
     */
    int updateByPrimaryKey(EmExperimentOpen record);
}