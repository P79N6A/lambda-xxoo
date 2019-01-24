package com.yatop.lambda.base.mapper;

import com.yatop.lambda.base.model.WfUserFavoriteTable;
import com.yatop.lambda.base.model.WfUserFavoriteTableExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WfUserFavoriteTableMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_user_favorite_table
     *
     * @mbg.generated Thu Jan 24 15:07:19 CST 2019
     */
    long countByExample(WfUserFavoriteTableExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_user_favorite_table
     *
     * @mbg.generated Thu Jan 24 15:07:19 CST 2019
     */
    int deleteByExample(WfUserFavoriteTableExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_user_favorite_table
     *
     * @mbg.generated Thu Jan 24 15:07:19 CST 2019
     */
    int insert(WfUserFavoriteTable record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_user_favorite_table
     *
     * @mbg.generated Thu Jan 24 15:07:19 CST 2019
     */
    int insertSelective(WfUserFavoriteTable record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_user_favorite_table
     *
     * @mbg.generated Thu Jan 24 15:07:19 CST 2019
     */
    List<WfUserFavoriteTable> selectByExample(WfUserFavoriteTableExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_user_favorite_table
     *
     * @mbg.generated Thu Jan 24 15:07:19 CST 2019
     */
    int updateByExampleSelective(@Param("record") WfUserFavoriteTable record, @Param("example") WfUserFavoriteTableExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_user_favorite_table
     *
     * @mbg.generated Thu Jan 24 15:07:19 CST 2019
     */
    int updateByExample(@Param("record") WfUserFavoriteTable record, @Param("example") WfUserFavoriteTableExample example);
}