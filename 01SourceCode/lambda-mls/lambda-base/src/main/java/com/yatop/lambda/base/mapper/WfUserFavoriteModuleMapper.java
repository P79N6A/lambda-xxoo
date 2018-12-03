package com.yatop.lambda.base.mapper;

import com.yatop.lambda.base.model.WfUserFavoriteModule;
import com.yatop.lambda.base.model.WfUserFavoriteModuleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WfUserFavoriteModuleMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_user_favorite_module
     *
     * @mbg.generated Mon Dec 03 11:07:18 CST 2018
     */
    long countByExample(WfUserFavoriteModuleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_user_favorite_module
     *
     * @mbg.generated Mon Dec 03 11:07:18 CST 2018
     */
    int deleteByExample(WfUserFavoriteModuleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_user_favorite_module
     *
     * @mbg.generated Mon Dec 03 11:07:18 CST 2018
     */
    int insert(WfUserFavoriteModule record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_user_favorite_module
     *
     * @mbg.generated Mon Dec 03 11:07:18 CST 2018
     */
    int insertSelective(WfUserFavoriteModule record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_user_favorite_module
     *
     * @mbg.generated Mon Dec 03 11:07:18 CST 2018
     */
    List<WfUserFavoriteModule> selectByExample(WfUserFavoriteModuleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_user_favorite_module
     *
     * @mbg.generated Mon Dec 03 11:07:18 CST 2018
     */
    int updateByExampleSelective(@Param("record") WfUserFavoriteModule record, @Param("example") WfUserFavoriteModuleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_user_favorite_module
     *
     * @mbg.generated Mon Dec 03 11:07:18 CST 2018
     */
    int updateByExample(@Param("record") WfUserFavoriteModule record, @Param("example") WfUserFavoriteModuleExample example);
}