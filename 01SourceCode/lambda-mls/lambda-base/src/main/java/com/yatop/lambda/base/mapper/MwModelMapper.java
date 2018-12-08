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
     * @mbg.generated Sun Dec 09 01:21:55 CST 2018
     */
    long countByExample(MwModelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mw_model
     *
     * @mbg.generated Sun Dec 09 01:21:55 CST 2018
     */
    int deleteByExample(MwModelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mw_model
     *
     * @mbg.generated Sun Dec 09 01:21:55 CST 2018
     */
    int deleteByPrimaryKey(Long modelId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mw_model
     *
     * @mbg.generated Sun Dec 09 01:21:55 CST 2018
     */
    int insert(MwModel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mw_model
     *
     * @mbg.generated Sun Dec 09 01:21:55 CST 2018
     */
    int insertSelective(MwModel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mw_model
     *
     * @mbg.generated Sun Dec 09 01:21:55 CST 2018
     */
    List<MwModel> selectByExample(MwModelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mw_model
     *
     * @mbg.generated Sun Dec 09 01:21:55 CST 2018
     */
    MwModel selectByPrimaryKey(Long modelId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mw_model
     *
     * @mbg.generated Sun Dec 09 01:21:55 CST 2018
     */
    int updateByExampleSelective(@Param("record") MwModel record, @Param("example") MwModelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mw_model
     *
     * @mbg.generated Sun Dec 09 01:21:55 CST 2018
     */
    int updateByExample(@Param("record") MwModel record, @Param("example") MwModelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mw_model
     *
     * @mbg.generated Sun Dec 09 01:21:55 CST 2018
     */
    int updateByPrimaryKeySelective(MwModel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mw_model
     *
     * @mbg.generated Sun Dec 09 01:21:55 CST 2018
     */
    int updateByPrimaryKey(MwModel record);
}