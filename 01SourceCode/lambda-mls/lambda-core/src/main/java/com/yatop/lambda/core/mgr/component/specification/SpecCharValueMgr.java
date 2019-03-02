package com.yatop.lambda.core.mgr.component.specification;

import com.yatop.lambda.base.model.CfSpecCharValue;
import com.yatop.lambda.base.model.CfSpecCharValueExample;
import com.yatop.lambda.core.enums.LambdaExceptionEnum;
import com.yatop.lambda.core.mgr.base.BaseMgr;
import com.yatop.lambda.core.enums.DataStatusEnum;
import com.yatop.lambda.core.exception.LambdaException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecCharValueMgr extends BaseMgr {

    /*
     *
     *   查询规格特征值
     *   返回结果集
     *
     * */
    public List<CfSpecCharValue> querySpecCharValue() {

        try {
            CfSpecCharValueExample example = new CfSpecCharValueExample();
            example.createCriteria().andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
            return  cfSpecCharValueMapper.selectByExample(example);
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.G_COMPUTE_DEFAULT_ERROR, "Query specification characteristic value failed.", "查询规格特征值失败", e);
        }
    }
}
