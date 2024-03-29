package com.yatop.lambda.base.mapper;

import com.yatop.lambda.base.model.WfCfgCharTypeWild;
import com.yatop.lambda.base.model.WfCfgCharTypeWildExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WfCfgCharTypeWildMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_cfg_char_type_wild
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    long countByExample(WfCfgCharTypeWildExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_cfg_char_type_wild
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    int deleteByExample(WfCfgCharTypeWildExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_cfg_char_type_wild
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    int deleteByPrimaryKey(@Param("dstCharTypeId") Integer dstCharTypeId, @Param("srcCharTypeId") Integer srcCharTypeId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_cfg_char_type_wild
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    int insert(WfCfgCharTypeWild record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_cfg_char_type_wild
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    int insertSelective(WfCfgCharTypeWild record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_cfg_char_type_wild
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    List<WfCfgCharTypeWild> selectByExample(WfCfgCharTypeWildExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_cfg_char_type_wild
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    WfCfgCharTypeWild selectByPrimaryKey(@Param("dstCharTypeId") Integer dstCharTypeId, @Param("srcCharTypeId") Integer srcCharTypeId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_cfg_char_type_wild
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    int updateByExampleSelective(@Param("record") WfCfgCharTypeWild record, @Param("example") WfCfgCharTypeWildExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_cfg_char_type_wild
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    int updateByExample(@Param("record") WfCfgCharTypeWild record, @Param("example") WfCfgCharTypeWildExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_cfg_char_type_wild
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    int updateByPrimaryKeySelective(WfCfgCharTypeWild record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_cfg_char_type_wild
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    int updateByPrimaryKey(WfCfgCharTypeWild record);
}