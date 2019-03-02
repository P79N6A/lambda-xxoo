package com.yatop.lambda.base.mapper;

import com.yatop.lambda.base.model.CfCharacteristic;
import com.yatop.lambda.base.model.CfCharacteristicExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CfCharacteristicMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_characteristic
     *
     * @mbg.generated Fri Mar 01 13:16:54 CST 2019
     */
    long countByExample(CfCharacteristicExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_characteristic
     *
     * @mbg.generated Fri Mar 01 13:16:54 CST 2019
     */
    int deleteByExample(CfCharacteristicExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_characteristic
     *
     * @mbg.generated Fri Mar 01 13:16:54 CST 2019
     */
    int deleteByPrimaryKey(String charId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_characteristic
     *
     * @mbg.generated Fri Mar 01 13:16:54 CST 2019
     */
    int insert(CfCharacteristic record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_characteristic
     *
     * @mbg.generated Fri Mar 01 13:16:54 CST 2019
     */
    int insertSelective(CfCharacteristic record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_characteristic
     *
     * @mbg.generated Fri Mar 01 13:16:54 CST 2019
     */
    List<CfCharacteristic> selectByExample(CfCharacteristicExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_characteristic
     *
     * @mbg.generated Fri Mar 01 13:16:54 CST 2019
     */
    CfCharacteristic selectByPrimaryKey(String charId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_characteristic
     *
     * @mbg.generated Fri Mar 01 13:16:54 CST 2019
     */
    int updateByExampleSelective(@Param("record") CfCharacteristic record, @Param("example") CfCharacteristicExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_characteristic
     *
     * @mbg.generated Fri Mar 01 13:16:54 CST 2019
     */
    int updateByExample(@Param("record") CfCharacteristic record, @Param("example") CfCharacteristicExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_characteristic
     *
     * @mbg.generated Fri Mar 01 13:16:54 CST 2019
     */
    int updateByPrimaryKeySelective(CfCharacteristic record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_characteristic
     *
     * @mbg.generated Fri Mar 01 13:16:54 CST 2019
     */
    int updateByPrimaryKey(CfCharacteristic record);
}