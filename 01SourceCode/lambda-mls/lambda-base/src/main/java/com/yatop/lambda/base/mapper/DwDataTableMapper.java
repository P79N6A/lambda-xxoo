package com.yatop.lambda.base.mapper;

import com.yatop.lambda.base.model.DwDataTable;
import com.yatop.lambda.base.model.DwDataTableExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DwDataTableMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dw_data_table
     *
     * @mbg.generated Thu Dec 06 21:05:26 CST 2018
     */
    long countByExample(DwDataTableExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dw_data_table
     *
     * @mbg.generated Thu Dec 06 21:05:26 CST 2018
     */
    int deleteByExample(DwDataTableExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dw_data_table
     *
     * @mbg.generated Thu Dec 06 21:05:26 CST 2018
     */
    int deleteByPrimaryKey(Long tableId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dw_data_table
     *
     * @mbg.generated Thu Dec 06 21:05:26 CST 2018
     */
    int insert(DwDataTable record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dw_data_table
     *
     * @mbg.generated Thu Dec 06 21:05:26 CST 2018
     */
    int insertSelective(DwDataTable record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dw_data_table
     *
     * @mbg.generated Thu Dec 06 21:05:26 CST 2018
     */
    List<DwDataTable> selectByExample(DwDataTableExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dw_data_table
     *
     * @mbg.generated Thu Dec 06 21:05:26 CST 2018
     */
    DwDataTable selectByPrimaryKey(Long tableId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dw_data_table
     *
     * @mbg.generated Thu Dec 06 21:05:26 CST 2018
     */
    int updateByExampleSelective(@Param("record") DwDataTable record, @Param("example") DwDataTableExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dw_data_table
     *
     * @mbg.generated Thu Dec 06 21:05:26 CST 2018
     */
    int updateByExample(@Param("record") DwDataTable record, @Param("example") DwDataTableExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dw_data_table
     *
     * @mbg.generated Thu Dec 06 21:05:26 CST 2018
     */
    int updateByPrimaryKeySelective(DwDataTable record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dw_data_table
     *
     * @mbg.generated Thu Dec 06 21:05:26 CST 2018
     */
    int updateByPrimaryKey(DwDataTable record);
}