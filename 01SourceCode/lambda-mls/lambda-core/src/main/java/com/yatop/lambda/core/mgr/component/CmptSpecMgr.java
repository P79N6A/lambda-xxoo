package com.yatop.lambda.core.mgr.component;

import com.yatop.lambda.base.model.CfCmptSpec;
import com.yatop.lambda.base.model.CfCmptSpecExample;
import com.yatop.lambda.core.enums.LambdaExceptionEnum;
import com.yatop.lambda.core.mgr.base.BaseMgr;
import com.yatop.lambda.core.enums.DataStatusEnum;
import com.yatop.lambda.core.exception.LambdaException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CmptSpecMgr extends BaseMgr {

    /*
     *
     *   查询组件使用规格
     *   返回结果集
     *
     * */
    public List<CfCmptSpec> queryCmptSpecRel() {

        try {
            CfCmptSpecExample example = new CfCmptSpecExample();
            example.createCriteria().andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
            return  cfCmptSpecMapper.selectByExample(example);
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.G_COMPUTE_DEFAULT_ERROR, "Query component specification relation failed.", "查询组件使用规格失败", e);
        }
    }
}
