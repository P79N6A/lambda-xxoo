package com.yatop.lambda.core.mgr.component.specification;

import com.yatop.lambda.base.model.CfSpecChar;
import com.yatop.lambda.base.model.CfSpecCharExample;
import com.yatop.lambda.core.enums.LambdaExceptionEnum;
import com.yatop.lambda.core.mgr.base.BaseMgr;
import com.yatop.lambda.core.enums.DataStatusEnum;
import com.yatop.lambda.core.exception.LambdaException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecCharMgr extends BaseMgr {

    /*
     *
     *   查询规格使用特征
     *   返回结果集
     *
     * */
    public List<CfSpecChar> querySpecCharRel() {

        try {
            CfSpecCharExample example = new CfSpecCharExample();
            example.createCriteria().andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
            return  cfSpecCharMapper.selectByExample(example);
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.G_COMPUTE_DEFAULT_ERROR, "Query specification characteristic relation failed.", "查询规格使用特征失败", e);
        }
    }
}
