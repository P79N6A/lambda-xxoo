package com.yatop.lambda.base.mapper;

import com.yatop.lambda.base.model.MwModel;
import com.yatop.lambda.base.model.MwModelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MwModelMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mw_model
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    long countByExample(MwModelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mw_model
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    int deleteByExample(MwModelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mw_model
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    int deleteByPrimaryKey(Long modelId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mw_model
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    int insert(MwModel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mw_model
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    int insertSelective(MwModel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mw_model
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    List<MwModel> selectByExample(MwModelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mw_model
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    MwModel selectByPrimaryKey(Long modelId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mw_model
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    int updateByExampleSelective(@Param("record") MwModel record, @Param("example") MwModelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mw_model
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    int updateByExample(@Param("record") MwModel record, @Param("example") MwModelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mw_model
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    int updateByPrimaryKeySelective(MwModel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mw_model
     *
     * @mbg.generated Thu Feb 14 22:58:23 CST 2019
     */
    int updateByPrimaryKey(MwModel record);
}