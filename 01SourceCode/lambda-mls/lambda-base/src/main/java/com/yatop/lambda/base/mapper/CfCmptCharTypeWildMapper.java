package com.yatop.lambda.base.mapper;

import com.yatop.lambda.base.model.CfCmptCharTypeWild;
import com.yatop.lambda.base.model.CfCmptCharTypeWildExample;
import com.yatop.lambda.base.utils.MyMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CfCmptCharTypeWildMapper extends MyMapper<CfCmptCharTypeWild> {
    int countByExample(CfCmptCharTypeWildExample example);

    int deleteByExample(CfCmptCharTypeWildExample example);

    List<CfCmptCharTypeWild> selectByExample(CfCmptCharTypeWildExample example);

    int updateByExampleSelective(@Param("record") CfCmptCharTypeWild record, @Param("example") CfCmptCharTypeWildExample example);

    int updateByExample(@Param("record") CfCmptCharTypeWild record, @Param("example") CfCmptCharTypeWildExample example);
}