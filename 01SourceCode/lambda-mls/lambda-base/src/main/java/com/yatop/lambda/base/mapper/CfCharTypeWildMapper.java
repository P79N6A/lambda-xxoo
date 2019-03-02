package com.yatop.lambda.base.mapper;

import com.yatop.lambda.base.model.CfCharTypeWild;
import com.yatop.lambda.base.model.CfCharTypeWildExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CfCharTypeWildMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_char_type_wild
     *
     * @mbg.generated Sat Mar 02 13:34:42 CST 2019
     */
    long countByExample(CfCharTypeWildExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_char_type_wild
     *
     * @mbg.generated Sat Mar 02 13:34:42 CST 2019
     */
    int deleteByExample(CfCharTypeWildExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_char_type_wild
     *
     * @mbg.generated Sat Mar 02 13:34:42 CST 2019
     */
    int deleteByPrimaryKey(@Param("dstCharTypeId") Integer dstCharTypeId, @Param("srcCharTypeId") Integer srcCharTypeId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_char_type_wild
     *
     * @mbg.generated Sat Mar 02 13:34:42 CST 2019
     */
    int insert(CfCharTypeWild record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_char_type_wild
     *
     * @mbg.generated Sat Mar 02 13:34:42 CST 2019
     */
    int insertSelective(CfCharTypeWild record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_char_type_wild
     *
     * @mbg.generated Sat Mar 02 13:34:42 CST 2019
     */
    List<CfCharTypeWild> selectByExample(CfCharTypeWildExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_char_type_wild
     *
     * @mbg.generated Sat Mar 02 13:34:42 CST 2019
     */
    CfCharTypeWild selectByPrimaryKey(@Param("dstCharTypeId") Integer dstCharTypeId, @Param("srcCharTypeId") Integer srcCharTypeId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_char_type_wild
     *
     * @mbg.generated Sat Mar 02 13:34:42 CST 2019
     */
    int updateByExampleSelective(@Param("record") CfCharTypeWild record, @Param("example") CfCharTypeWildExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_char_type_wild
     *
     * @mbg.generated Sat Mar 02 13:34:42 CST 2019
     */
    int updateByExample(@Param("record") CfCharTypeWild record, @Param("example") CfCharTypeWildExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_char_type_wild
     *
     * @mbg.generated Sat Mar 02 13:34:42 CST 2019
     */
    int updateByPrimaryKeySelective(CfCharTypeWild record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_char_type_wild
     *
     * @mbg.generated Sat Mar 02 13:34:42 CST 2019
     */
    int updateByPrimaryKey(CfCharTypeWild record);
}