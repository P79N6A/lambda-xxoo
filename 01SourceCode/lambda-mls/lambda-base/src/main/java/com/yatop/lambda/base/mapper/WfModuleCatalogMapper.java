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
     * @mbg.generated Sat Dec 22 01:08:46 CST 2018
     */
    long countByExample(WfModuleCatalogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_module_catalog
     *
     * @mbg.generated Sat Dec 22 01:08:46 CST 2018
     */
    int deleteByExample(WfModuleCatalogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_module_catalog
     *
     * @mbg.generated Sat Dec 22 01:08:46 CST 2018
     */
    int deleteByPrimaryKey(Long catalogId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_module_catalog
     *
     * @mbg.generated Sat Dec 22 01:08:46 CST 2018
     */
    int insert(WfModuleCatalog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_module_catalog
     *
     * @mbg.generated Sat Dec 22 01:08:46 CST 2018
     */
    int insertSelective(WfModuleCatalog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_module_catalog
     *
     * @mbg.generated Sat Dec 22 01:08:46 CST 2018
     */
    List<WfModuleCatalog> selectByExample(WfModuleCatalogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_module_catalog
     *
     * @mbg.generated Sat Dec 22 01:08:46 CST 2018
     */
    WfModuleCatalog selectByPrimaryKey(Long catalogId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_module_catalog
     *
     * @mbg.generated Sat Dec 22 01:08:46 CST 2018
     */
    int updateByExampleSelective(@Param("record") WfModuleCatalog record, @Param("example") WfModuleCatalogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_module_catalog
     *
     * @mbg.generated Sat Dec 22 01:08:46 CST 2018
     */
    int updateByExample(@Param("record") WfModuleCatalog record, @Param("example") WfModuleCatalogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_module_catalog
     *
     * @mbg.generated Sat Dec 22 01:08:46 CST 2018
     */
    int updateByPrimaryKeySelective(WfModuleCatalog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_module_catalog
     *
     * @mbg.generated Sat Dec 22 01:08:46 CST 2018
     */
    int updateByPrimaryKey(WfModuleCatalog record);
}