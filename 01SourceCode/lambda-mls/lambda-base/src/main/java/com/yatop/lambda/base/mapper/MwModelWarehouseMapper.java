package com.yatop.lambda.base.mapper;

import com.yatop.lambda.base.model.MwModelWarehouse;
import com.yatop.lambda.base.model.MwModelWarehouseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MwModelWarehouseMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mw_model_warehouse
     *
     * @mbg.generated Sat Dec 01 22:15:38 CST 2018
     */
    long countByExample(MwModelWarehouseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mw_model_warehouse
     *
     * @mbg.generated Sat Dec 01 22:15:38 CST 2018
     */
    int deleteByExample(MwModelWarehouseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mw_model_warehouse
     *
     * @mbg.generated Sat Dec 01 22:15:38 CST 2018
     */
    int deleteByPrimaryKey(Long mwId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mw_model_warehouse
     *
     * @mbg.generated Sat Dec 01 22:15:38 CST 2018
     */
    int insert(MwModelWarehouse record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mw_model_warehouse
     *
     * @mbg.generated Sat Dec 01 22:15:38 CST 2018
     */
    int insertSelective(MwModelWarehouse record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mw_model_warehouse
     *
     * @mbg.generated Sat Dec 01 22:15:38 CST 2018
     */
    List<MwModelWarehouse> selectByExample(MwModelWarehouseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mw_model_warehouse
     *
     * @mbg.generated Sat Dec 01 22:15:38 CST 2018
     */
    MwModelWarehouse selectByPrimaryKey(Long mwId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mw_model_warehouse
     *
     * @mbg.generated Sat Dec 01 22:15:38 CST 2018
     */
    int updateByExampleSelective(@Param("record") MwModelWarehouse record, @Param("example") MwModelWarehouseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mw_model_warehouse
     *
     * @mbg.generated Sat Dec 01 22:15:38 CST 2018
     */
    int updateByExample(@Param("record") MwModelWarehouse record, @Param("example") MwModelWarehouseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mw_model_warehouse
     *
     * @mbg.generated Sat Dec 01 22:15:38 CST 2018
     */
    int updateByPrimaryKeySelective(MwModelWarehouse record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mw_model_warehouse
     *
     * @mbg.generated Sat Dec 01 22:15:38 CST 2018
     */
    int updateByPrimaryKey(MwModelWarehouse record);
}