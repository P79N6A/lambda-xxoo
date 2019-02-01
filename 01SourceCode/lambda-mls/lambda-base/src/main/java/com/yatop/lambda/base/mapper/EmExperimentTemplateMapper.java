package com.yatop.lambda.base.mapper;

import com.yatop.lambda.base.model.EmExperimentTemplate;
import com.yatop.lambda.base.model.EmExperimentTemplateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EmExperimentTemplateMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table em_experiment_template
     *
     * @mbg.generated Fri Feb 01 23:43:10 CST 2019
     */
    long countByExample(EmExperimentTemplateExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table em_experiment_template
     *
     * @mbg.generated Fri Feb 01 23:43:10 CST 2019
     */
    int deleteByExample(EmExperimentTemplateExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table em_experiment_template
     *
     * @mbg.generated Fri Feb 01 23:43:10 CST 2019
     */
    int deleteByPrimaryKey(Long templateId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table em_experiment_template
     *
     * @mbg.generated Fri Feb 01 23:43:10 CST 2019
     */
    int insert(EmExperimentTemplate record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table em_experiment_template
     *
     * @mbg.generated Fri Feb 01 23:43:10 CST 2019
     */
    int insertSelective(EmExperimentTemplate record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table em_experiment_template
     *
     * @mbg.generated Fri Feb 01 23:43:10 CST 2019
     */
    List<EmExperimentTemplate> selectByExampleWithBLOBs(EmExperimentTemplateExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table em_experiment_template
     *
     * @mbg.generated Fri Feb 01 23:43:10 CST 2019
     */
    List<EmExperimentTemplate> selectByExample(EmExperimentTemplateExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table em_experiment_template
     *
     * @mbg.generated Fri Feb 01 23:43:10 CST 2019
     */
    EmExperimentTemplate selectByPrimaryKey(Long templateId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table em_experiment_template
     *
     * @mbg.generated Fri Feb 01 23:43:10 CST 2019
     */
    int updateByExampleSelective(@Param("record") EmExperimentTemplate record, @Param("example") EmExperimentTemplateExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table em_experiment_template
     *
     * @mbg.generated Fri Feb 01 23:43:10 CST 2019
     */
    int updateByExampleWithBLOBs(@Param("record") EmExperimentTemplate record, @Param("example") EmExperimentTemplateExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table em_experiment_template
     *
     * @mbg.generated Fri Feb 01 23:43:10 CST 2019
     */
    int updateByExample(@Param("record") EmExperimentTemplate record, @Param("example") EmExperimentTemplateExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table em_experiment_template
     *
     * @mbg.generated Fri Feb 01 23:43:10 CST 2019
     */
    int updateByPrimaryKeySelective(EmExperimentTemplate record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table em_experiment_template
     *
     * @mbg.generated Fri Feb 01 23:43:10 CST 2019
     */
    int updateByPrimaryKeyWithBLOBs(EmExperimentTemplate record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table em_experiment_template
     *
     * @mbg.generated Fri Feb 01 23:43:10 CST 2019
     */
    int updateByPrimaryKey(EmExperimentTemplate record);
}