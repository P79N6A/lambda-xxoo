package com.yatop.lambda.base.mapper;

import com.yatop.lambda.base.model.WfCodeScript;
import com.yatop.lambda.base.model.WfCodeScriptExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WfCodeScriptMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_code_script
     *
     * @mbg.generated Thu Jan 24 15:07:19 CST 2019
     */
    long countByExample(WfCodeScriptExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_code_script
     *
     * @mbg.generated Thu Jan 24 15:07:19 CST 2019
     */
    int deleteByExample(WfCodeScriptExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_code_script
     *
     * @mbg.generated Thu Jan 24 15:07:19 CST 2019
     */
    int deleteByPrimaryKey(Long scriptId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_code_script
     *
     * @mbg.generated Thu Jan 24 15:07:19 CST 2019
     */
    int insert(WfCodeScript record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_code_script
     *
     * @mbg.generated Thu Jan 24 15:07:19 CST 2019
     */
    int insertSelective(WfCodeScript record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_code_script
     *
     * @mbg.generated Thu Jan 24 15:07:19 CST 2019
     */
    List<WfCodeScript> selectByExampleWithBLOBs(WfCodeScriptExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_code_script
     *
     * @mbg.generated Thu Jan 24 15:07:19 CST 2019
     */
    List<WfCodeScript> selectByExample(WfCodeScriptExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_code_script
     *
     * @mbg.generated Thu Jan 24 15:07:19 CST 2019
     */
    WfCodeScript selectByPrimaryKey(Long scriptId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_code_script
     *
     * @mbg.generated Thu Jan 24 15:07:19 CST 2019
     */
    int updateByExampleSelective(@Param("record") WfCodeScript record, @Param("example") WfCodeScriptExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_code_script
     *
     * @mbg.generated Thu Jan 24 15:07:19 CST 2019
     */
    int updateByExampleWithBLOBs(@Param("record") WfCodeScript record, @Param("example") WfCodeScriptExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_code_script
     *
     * @mbg.generated Thu Jan 24 15:07:19 CST 2019
     */
    int updateByExample(@Param("record") WfCodeScript record, @Param("example") WfCodeScriptExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_code_script
     *
     * @mbg.generated Thu Jan 24 15:07:19 CST 2019
     */
    int updateByPrimaryKeySelective(WfCodeScript record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_code_script
     *
     * @mbg.generated Thu Jan 24 15:07:19 CST 2019
     */
    int updateByPrimaryKeyWithBLOBs(WfCodeScript record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_code_script
     *
     * @mbg.generated Thu Jan 24 15:07:19 CST 2019
     */
    int updateByPrimaryKey(WfCodeScript record);
}