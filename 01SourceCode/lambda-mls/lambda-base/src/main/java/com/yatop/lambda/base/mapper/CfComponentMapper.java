package com.yatop.lambda.base.mapper;

import com.yatop.lambda.base.model.CfComponent;
import com.yatop.lambda.base.model.CfComponentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CfComponentMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_component
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    long countByExample(CfComponentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_component
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    int deleteByExample(CfComponentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_component
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    int deleteByPrimaryKey(String cmptId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_component
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    int insert(CfComponent record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_component
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    int insertSelective(CfComponent record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_component
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    List<CfComponent> selectByExample(CfComponentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_component
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    CfComponent selectByPrimaryKey(String cmptId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_component
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    int updateByExampleSelective(@Param("record") CfComponent record, @Param("example") CfComponentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_component
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    int updateByExample(@Param("record") CfComponent record, @Param("example") CfComponentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_component
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    int updateByPrimaryKeySelective(CfComponent record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_component
     *
     * @mbg.generated Sun Jan 20 15:50:41 CST 2019
     */
    int updateByPrimaryKey(CfComponent record);
}