package com.yatop.lambda.core.mgr.component.specification;

import com.yatop.lambda.base.model.CfSpecification;
import com.yatop.lambda.base.model.CfSpecificationExample;
import com.yatop.lambda.core.enums.LambdaExceptionEnum;
import com.yatop.lambda.core.mgr.base.BaseMgr;
import com.yatop.lambda.core.enums.DataStatusEnum;
import com.yatop.lambda.core.exception.LambdaException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecificationMgr extends BaseMgr {

    /*
     *
     *   查询规格信息
     *   返回结果集
     *
     * */
    public List<CfSpecification> querySpecification() {

        try {
            CfSpecificationExample example = new CfSpecificationExample();
            example.createCriteria().andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
            return  cfSpecificationMapper.selectByExample(example);
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.G_COMPUTE_DEFAULT_ERROR, "Query specification info failed.", "查询规格信息失败", e);
        }
    }
}
