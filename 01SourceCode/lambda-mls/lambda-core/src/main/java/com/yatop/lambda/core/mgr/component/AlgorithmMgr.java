package com.yatop.lambda.core.mgr.component;

import com.yatop.lambda.base.model.CfAlgorithm;
import com.yatop.lambda.base.model.CfAlgorithmExample;
import com.yatop.lambda.core.enums.LambdaExceptionEnum;
import com.yatop.lambda.core.mgr.base.BaseMgr;
import com.yatop.lambda.core.enums.DataStatusEnum;
import com.yatop.lambda.core.exception.LambdaException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlgorithmMgr extends BaseMgr {

    /*
     *
     *   查询算法信息
     *   返回结果集
     *
     * */
    public List<CfAlgorithm> queryAlgorithm() {

        try {
            CfAlgorithmExample example = new CfAlgorithmExample();
            example.createCriteria().andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
            return  cfAlgorithmMapper.selectByExample(example);
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.G_COMPUTE_DEFAULT_ERROR, "Query algorithm info failed.", "查询算法信息失败", e);
        }
    }
}
