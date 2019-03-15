package com.yatop.lambda.base.mapper;

import com.yatop.lambda.base.model.DwDataWarehouse;
import com.yatop.lambda.base.model.DwDataWarehouseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DwDataWarehouseMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dw_data_warehouse
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    long countByExample(DwDataWarehouseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dw_data_warehouse
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    int deleteByExample(DwDataWarehouseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dw_data_warehouse
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    int deleteByPrimaryKey(Long dwId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dw_data_warehouse
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    int insert(DwDataWarehouse record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dw_data_warehouse
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    int insertSelective(DwDataWarehouse record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dw_data_warehouse
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    List<DwDataWarehouse> selectByExample(DwDataWarehouseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dw_data_warehouse
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    DwDataWarehouse selectByPrimaryKey(Long dwId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dw_data_warehouse
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    int updateByExampleSelective(@Param("record") DwDataWarehouse record, @Param("example") DwDataWarehouseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dw_data_warehouse
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    int updateByExample(@Param("record") DwDataWarehouse record, @Param("example") DwDataWarehouseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dw_data_warehouse
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    int updateByPrimaryKeySelective(DwDataWarehouse record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dw_data_warehouse
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    int updateByPrimaryKey(DwDataWarehouse record);
}