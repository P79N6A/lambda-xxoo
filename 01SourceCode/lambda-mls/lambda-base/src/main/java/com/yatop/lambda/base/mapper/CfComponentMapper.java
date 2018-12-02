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
     * @mbg.generated Mon Dec 03 03:14:10 CST 2018
     */
    long countByExample(CfComponentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_component
     *
     * @mbg.generated Mon Dec 03 03:14:10 CST 2018
     */
    int deleteByExample(CfComponentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_component
     *
     * @mbg.generated Mon Dec 03 03:14:10 CST 2018
     */
    int deleteByPrimaryKey(String cmptId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_component
     *
     * @mbg.generated Mon Dec 03 03:14:10 CST 2018
     */
    int insert(CfComponent record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_component
     *
     * @mbg.generated Mon Dec 03 03:14:10 CST 2018
     */
    int insertSelective(CfComponent record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_component
     *
     * @mbg.generated Mon Dec 03 03:14:10 CST 2018
     */
    List<CfComponent> selectByExample(CfComponentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_component
     *
     * @mbg.generated Mon Dec 03 03:14:10 CST 2018
     */
    CfComponent selectByPrimaryKey(String cmptId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_component
     *
     * @mbg.generated Mon Dec 03 03:14:10 CST 2018
     */
    int updateByExampleSelective(@Param("record") CfComponent record, @Param("example") CfComponentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_component
     *
     * @mbg.generated Mon Dec 03 03:14:10 CST 2018
     */
    int updateByExample(@Param("record") CfComponent record, @Param("example") CfComponentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_component
     *
     * @mbg.generated Mon Dec 03 03:14:10 CST 2018
     */
    int updateByPrimaryKeySelective(CfComponent record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_component
     *
     * @mbg.generated Mon Dec 03 03:14:10 CST 2018
     */
    int updateByPrimaryKey(CfComponent record);
}