package com.yatop.lambda.base.mapper;

import com.yatop.lambda.base.model.PrProjectMember;
import com.yatop.lambda.base.model.PrProjectMemberExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PrProjectMemberMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pr_project_member
     *
     * @mbg.generated Fri Feb 01 23:43:10 CST 2019
     */
    long countByExample(PrProjectMemberExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pr_project_member
     *
     * @mbg.generated Fri Feb 01 23:43:10 CST 2019
     */
    int deleteByExample(PrProjectMemberExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pr_project_member
     *
     * @mbg.generated Fri Feb 01 23:43:10 CST 2019
     */
    int insert(PrProjectMember record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pr_project_member
     *
     * @mbg.generated Fri Feb 01 23:43:10 CST 2019
     */
    int insertSelective(PrProjectMember record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pr_project_member
     *
     * @mbg.generated Fri Feb 01 23:43:10 CST 2019
     */
    List<PrProjectMember> selectByExample(PrProjectMemberExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pr_project_member
     *
     * @mbg.generated Fri Feb 01 23:43:10 CST 2019
     */
    int updateByExampleSelective(@Param("record") PrProjectMember record, @Param("example") PrProjectMemberExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pr_project_member
     *
     * @mbg.generated Fri Feb 01 23:43:10 CST 2019
     */
    int updateByExample(@Param("record") PrProjectMember record, @Param("example") PrProjectMemberExample example);
}