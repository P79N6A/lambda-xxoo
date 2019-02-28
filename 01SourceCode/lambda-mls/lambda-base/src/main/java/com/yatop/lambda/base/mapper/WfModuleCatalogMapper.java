package com.yatop.lambda.base.mapper;

import com.yatop.lambda.base.model.WfModuleCatalog;
import com.yatop.lambda.base.model.WfModuleCatalogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WfModuleCatalogMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_module_catalog
     *
     * @mbg.generated Thu Feb 28 16:41:10 CST 2019
     */
    long countByExample(WfModuleCatalogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_module_catalog
     *
     * @mbg.generated Thu Feb 28 16:41:10 CST 2019
     */
    int deleteByExample(WfModuleCatalogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_module_catalog
     *
     * @mbg.generated Thu Feb 28 16:41:10 CST 2019
     */
    int deleteByPrimaryKey(Long catalogId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_module_catalog
     *
     * @mbg.generated Thu Feb 28 16:41:10 CST 2019
     */
    int insert(WfModuleCatalog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_module_catalog
     *
     * @mbg.generated Thu Feb 28 16:41:10 CST 2019
     */
    int insertSelective(WfModuleCatalog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_module_catalog
     *
     * @mbg.generated Thu Feb 28 16:41:10 CST 2019
     */
    List<WfModuleCatalog> selectByExample(WfModuleCatalogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_module_catalog
     *
     * @mbg.generated Thu Feb 28 16:41:10 CST 2019
     */
    WfModuleCatalog selectByPrimaryKey(Long catalogId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_module_catalog
     *
     * @mbg.generated Thu Feb 28 16:41:10 CST 2019
     */
    int updateByExampleSelective(@Param("record") WfModuleCatalog record, @Param("example") WfModuleCatalogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_module_catalog
     *
     * @mbg.generated Thu Feb 28 16:41:10 CST 2019
     */
    int updateByExample(@Param("record") WfModuleCatalog record, @Param("example") WfModuleCatalogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_module_catalog
     *
     * @mbg.generated Thu Feb 28 16:41:10 CST 2019
     */
    int updateByPrimaryKeySelective(WfModuleCatalog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_module_catalog
     *
     * @mbg.generated Thu Feb 28 16:41:10 CST 2019
     */
    int updateByPrimaryKey(WfModuleCatalog record);
}