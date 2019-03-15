package com.yatop.lambda.base.mapper;

import com.yatop.lambda.base.model.WfCfgModulePropCtrlRel;
import com.yatop.lambda.base.model.WfCfgModulePropCtrlRelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WfCfgModulePropCtrlRelMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_cfg_module_prop_ctrl_rel
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    long countByExample(WfCfgModulePropCtrlRelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_cfg_module_prop_ctrl_rel
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    int deleteByExample(WfCfgModulePropCtrlRelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_cfg_module_prop_ctrl_rel
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    int insert(WfCfgModulePropCtrlRel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_cfg_module_prop_ctrl_rel
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    int insertSelective(WfCfgModulePropCtrlRel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_cfg_module_prop_ctrl_rel
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    List<WfCfgModulePropCtrlRel> selectByExample(WfCfgModulePropCtrlRelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_cfg_module_prop_ctrl_rel
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    int updateByExampleSelective(@Param("record") WfCfgModulePropCtrlRel record, @Param("example") WfCfgModulePropCtrlRelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_cfg_module_prop_ctrl_rel
     *
     * @mbg.generated Fri Mar 15 15:22:18 CST 2019
     */
    int updateByExample(@Param("record") WfCfgModulePropCtrlRel record, @Param("example") WfCfgModulePropCtrlRelExample example);
}