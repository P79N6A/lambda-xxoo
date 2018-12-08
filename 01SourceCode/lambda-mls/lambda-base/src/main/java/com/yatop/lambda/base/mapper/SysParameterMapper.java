package com.yatop.lambda.base.mapper;

import com.yatop.lambda.base.model.SysParameter;
import com.yatop.lambda.base.model.SysParameterExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysParameterMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_parameter
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    long countByExample(SysParameterExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_parameter
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    int deleteByExample(SysParameterExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_parameter
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    int deleteByPrimaryKey(Long paramId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_parameter
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    int insert(SysParameter record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_parameter
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    int insertSelective(SysParameter record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_parameter
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    List<SysParameter> selectByExample(SysParameterExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_parameter
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    SysParameter selectByPrimaryKey(Long paramId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_parameter
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    int updateByExampleSelective(@Param("record") SysParameter record, @Param("example") SysParameterExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_parameter
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    int updateByExample(@Param("record") SysParameter record, @Param("example") SysParameterExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_parameter
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    int updateByPrimaryKeySelective(SysParameter record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_parameter
     *
     * @mbg.generated Sat Dec 08 18:35:55 CST 2018
     */
    int updateByPrimaryKey(SysParameter record);
}