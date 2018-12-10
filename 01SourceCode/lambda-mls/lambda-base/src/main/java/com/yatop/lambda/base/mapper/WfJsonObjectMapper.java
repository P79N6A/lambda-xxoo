package com.yatop.lambda.base.mapper;

import com.yatop.lambda.base.model.WfJsonObject;
import com.yatop.lambda.base.model.WfJsonObjectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WfJsonObjectMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_json_object
     *
     * @mbg.generated Mon Dec 10 12:31:47 CST 2018
     */
    long countByExample(WfJsonObjectExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_json_object
     *
     * @mbg.generated Mon Dec 10 12:31:47 CST 2018
     */
    int deleteByExample(WfJsonObjectExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_json_object
     *
     * @mbg.generated Mon Dec 10 12:31:47 CST 2018
     */
    int deleteByPrimaryKey(Long objectId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_json_object
     *
     * @mbg.generated Mon Dec 10 12:31:47 CST 2018
     */
    int insert(WfJsonObject record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_json_object
     *
     * @mbg.generated Mon Dec 10 12:31:47 CST 2018
     */
    int insertSelective(WfJsonObject record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_json_object
     *
     * @mbg.generated Mon Dec 10 12:31:47 CST 2018
     */
    List<WfJsonObject> selectByExampleWithBLOBs(WfJsonObjectExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_json_object
     *
     * @mbg.generated Mon Dec 10 12:31:47 CST 2018
     */
    List<WfJsonObject> selectByExample(WfJsonObjectExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_json_object
     *
     * @mbg.generated Mon Dec 10 12:31:47 CST 2018
     */
    WfJsonObject selectByPrimaryKey(Long objectId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_json_object
     *
     * @mbg.generated Mon Dec 10 12:31:47 CST 2018
     */
    int updateByExampleSelective(@Param("record") WfJsonObject record, @Param("example") WfJsonObjectExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_json_object
     *
     * @mbg.generated Mon Dec 10 12:31:47 CST 2018
     */
    int updateByExampleWithBLOBs(@Param("record") WfJsonObject record, @Param("example") WfJsonObjectExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_json_object
     *
     * @mbg.generated Mon Dec 10 12:31:47 CST 2018
     */
    int updateByExample(@Param("record") WfJsonObject record, @Param("example") WfJsonObjectExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_json_object
     *
     * @mbg.generated Mon Dec 10 12:31:47 CST 2018
     */
    int updateByPrimaryKeySelective(WfJsonObject record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_json_object
     *
     * @mbg.generated Mon Dec 10 12:31:47 CST 2018
     */
    int updateByPrimaryKeyWithBLOBs(WfJsonObject record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_json_object
     *
     * @mbg.generated Mon Dec 10 12:31:47 CST 2018
     */
    int updateByPrimaryKey(WfJsonObject record);
}