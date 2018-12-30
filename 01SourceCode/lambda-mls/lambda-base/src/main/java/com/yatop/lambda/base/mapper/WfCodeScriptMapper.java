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
     * @mbg.generated Sun Dec 30 22:07:03 CST 2018
     */
    long countByExample(WfCodeScriptExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_code_script
     *
     * @mbg.generated Sun Dec 30 22:07:03 CST 2018
     */
    int deleteByExample(WfCodeScriptExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_code_script
     *
     * @mbg.generated Sun Dec 30 22:07:03 CST 2018
     */
    int deleteByPrimaryKey(Long scriptId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_code_script
     *
     * @mbg.generated Sun Dec 30 22:07:03 CST 2018
     */
    int insert(WfCodeScript record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_code_script
     *
     * @mbg.generated Sun Dec 30 22:07:03 CST 2018
     */
    int insertSelective(WfCodeScript record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_code_script
     *
     * @mbg.generated Sun Dec 30 22:07:03 CST 2018
     */
    List<WfCodeScript> selectByExampleWithBLOBs(WfCodeScriptExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_code_script
     *
     * @mbg.generated Sun Dec 30 22:07:03 CST 2018
     */
    List<WfCodeScript> selectByExample(WfCodeScriptExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_code_script
     *
     * @mbg.generated Sun Dec 30 22:07:03 CST 2018
     */
    WfCodeScript selectByPrimaryKey(Long scriptId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_code_script
     *
     * @mbg.generated Sun Dec 30 22:07:03 CST 2018
     */
    int updateByExampleSelective(@Param("record") WfCodeScript record, @Param("example") WfCodeScriptExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_code_script
     *
     * @mbg.generated Sun Dec 30 22:07:03 CST 2018
     */
    int updateByExampleWithBLOBs(@Param("record") WfCodeScript record, @Param("example") WfCodeScriptExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_code_script
     *
     * @mbg.generated Sun Dec 30 22:07:03 CST 2018
     */
    int updateByExample(@Param("record") WfCodeScript record, @Param("example") WfCodeScriptExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_code_script
     *
     * @mbg.generated Sun Dec 30 22:07:03 CST 2018
     */
    int updateByPrimaryKeySelective(WfCodeScript record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_code_script
     *
     * @mbg.generated Sun Dec 30 22:07:03 CST 2018
     */
    int updateByPrimaryKeyWithBLOBs(WfCodeScript record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_code_script
     *
     * @mbg.generated Sun Dec 30 22:07:03 CST 2018
     */
    int updateByPrimaryKey(WfCodeScript record);
}