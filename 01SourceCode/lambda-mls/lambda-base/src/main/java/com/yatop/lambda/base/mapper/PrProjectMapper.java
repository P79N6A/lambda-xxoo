package com.yatop.lambda.base.mapper;

import com.yatop.lambda.base.model.PrProject;
import com.yatop.lambda.base.model.PrProjectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PrProjectMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pr_project
     *
     * @mbg.generated Thu Feb 28 16:41:10 CST 2019
     */
    long countByExample(PrProjectExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pr_project
     *
     * @mbg.generated Thu Feb 28 16:41:10 CST 2019
     */
    int deleteByExample(PrProjectExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pr_project
     *
     * @mbg.generated Thu Feb 28 16:41:10 CST 2019
     */
    int deleteByPrimaryKey(Long projectId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pr_project
     *
     * @mbg.generated Thu Feb 28 16:41:10 CST 2019
     */
    int insert(PrProject record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pr_project
     *
     * @mbg.generated Thu Feb 28 16:41:10 CST 2019
     */
    int insertSelective(PrProject record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pr_project
     *
     * @mbg.generated Thu Feb 28 16:41:10 CST 2019
     */
    List<PrProject> selectByExample(PrProjectExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pr_project
     *
     * @mbg.generated Thu Feb 28 16:41:10 CST 2019
     */
    PrProject selectByPrimaryKey(Long projectId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pr_project
     *
     * @mbg.generated Thu Feb 28 16:41:10 CST 2019
     */
    int updateByExampleSelective(@Param("record") PrProject record, @Param("example") PrProjectExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pr_project
     *
     * @mbg.generated Thu Feb 28 16:41:10 CST 2019
     */
    int updateByExample(@Param("record") PrProject record, @Param("example") PrProjectExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pr_project
     *
     * @mbg.generated Thu Feb 28 16:41:10 CST 2019
     */
    int updateByPrimaryKeySelective(PrProject record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pr_project
     *
     * @mbg.generated Thu Feb 28 16:41:10 CST 2019
     */
    int updateByPrimaryKey(PrProject record);
}