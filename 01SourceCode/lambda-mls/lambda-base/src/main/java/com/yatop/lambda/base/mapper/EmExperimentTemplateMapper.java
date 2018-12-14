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
     * @mbg.generated Fri Dec 14 11:13:47 CST 2018
     */
    long countByExample(EmExperimentTemplateExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table em_experiment_template
     *
     * @mbg.generated Fri Dec 14 11:13:47 CST 2018
     */
    int deleteByExample(EmExperimentTemplateExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table em_experiment_template
     *
     * @mbg.generated Fri Dec 14 11:13:47 CST 2018
     */
    int deleteByPrimaryKey(Long templateId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table em_experiment_template
     *
     * @mbg.generated Fri Dec 14 11:13:47 CST 2018
     */
    int insert(EmExperimentTemplate record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table em_experiment_template
     *
     * @mbg.generated Fri Dec 14 11:13:47 CST 2018
     */
    int insertSelective(EmExperimentTemplate record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table em_experiment_template
     *
     * @mbg.generated Fri Dec 14 11:13:47 CST 2018
     */
    List<EmExperimentTemplate> selectByExampleWithBLOBs(EmExperimentTemplateExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table em_experiment_template
     *
     * @mbg.generated Fri Dec 14 11:13:47 CST 2018
     */
    List<EmExperimentTemplate> selectByExample(EmExperimentTemplateExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table em_experiment_template
     *
     * @mbg.generated Fri Dec 14 11:13:47 CST 2018
     */
    EmExperimentTemplate selectByPrimaryKey(Long templateId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table em_experiment_template
     *
     * @mbg.generated Fri Dec 14 11:13:47 CST 2018
     */
    int updateByExampleSelective(@Param("record") EmExperimentTemplate record, @Param("example") EmExperimentTemplateExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table em_experiment_template
     *
     * @mbg.generated Fri Dec 14 11:13:47 CST 2018
     */
    int updateByExampleWithBLOBs(@Param("record") EmExperimentTemplate record, @Param("example") EmExperimentTemplateExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table em_experiment_template
     *
     * @mbg.generated Fri Dec 14 11:13:47 CST 2018
     */
    int updateByExample(@Param("record") EmExperimentTemplate record, @Param("example") EmExperimentTemplateExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table em_experiment_template
     *
     * @mbg.generated Fri Dec 14 11:13:47 CST 2018
     */
    int updateByPrimaryKeySelective(EmExperimentTemplate record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table em_experiment_template
     *
     * @mbg.generated Fri Dec 14 11:13:47 CST 2018
     */
    int updateByPrimaryKeyWithBLOBs(EmExperimentTemplate record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table em_experiment_template
     *
     * @mbg.generated Fri Dec 14 11:13:47 CST 2018
     */
    int updateByPrimaryKey(EmExperimentTemplate record);
}