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
     * @mbg.generated Wed Dec 26 13:26:03 CST 2018
     */
    long countByExample(PrProjectExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pr_project
     *
     * @mbg.generated Wed Dec 26 13:26:03 CST 2018
     */
    int deleteByExample(PrProjectExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pr_project
     *
     * @mbg.generated Wed Dec 26 13:26:03 CST 2018
     */
    int deleteByPrimaryKey(Long projectId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pr_project
     *
     * @mbg.generated Wed Dec 26 13:26:03 CST 2018
     */
    int insert(PrProject record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pr_project
     *
     * @mbg.generated Wed Dec 26 13:26:03 CST 2018
     */
    int insertSelective(PrProject record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pr_project
     *
     * @mbg.generated Wed Dec 26 13:26:03 CST 2018
     */
    List<PrProject> selectByExample(PrProjectExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pr_project
     *
     * @mbg.generated Wed Dec 26 13:26:03 CST 2018
     */
    PrProject selectByPrimaryKey(Long projectId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pr_project
     *
     * @mbg.generated Wed Dec 26 13:26:03 CST 2018
     */
    int updateByExampleSelective(@Param("record") PrProject record, @Param("example") PrProjectExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pr_project
     *
     * @mbg.generated Wed Dec 26 13:26:03 CST 2018
     */
    int updateByExample(@Param("record") PrProject record, @Param("example") PrProjectExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pr_project
     *
     * @mbg.generated Wed Dec 26 13:26:03 CST 2018
     */
    int updateByPrimaryKeySelective(PrProject record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pr_project
     *
     * @mbg.generated Wed Dec 26 13:26:03 CST 2018
     */
    int updateByPrimaryKey(PrProject record);
}