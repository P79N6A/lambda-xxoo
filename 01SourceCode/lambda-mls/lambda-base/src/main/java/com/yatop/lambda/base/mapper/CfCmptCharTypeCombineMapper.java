package com.yatop.lambda.base.mapper;

import com.yatop.lambda.base.model.CfCmptCharTypeCombine;
import com.yatop.lambda.base.model.CfCmptCharTypeCombineExample;
import com.yatop.lambda.base.utils.MyMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CfCmptCharTypeCombineMapper extends MyMapper<CfCmptCharTypeCombine> {
    int countByExample(CfCmptCharTypeCombineExample example);

    int deleteByExample(CfCmptCharTypeCombineExample example);

    List<CfCmptCharTypeCombine> selectByExample(CfCmptCharTypeCombineExample example);

    int updateByExampleSelective(@Param("record") CfCmptCharTypeCombine record, @Param("example") CfCmptCharTypeCombineExample example);

    int updateByExample(@Param("record") CfCmptCharTypeCombine record, @Param("example") CfCmptCharTypeCombineExample example);
}