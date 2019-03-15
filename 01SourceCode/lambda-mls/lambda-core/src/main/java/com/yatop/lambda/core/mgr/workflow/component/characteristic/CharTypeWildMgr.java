package com.yatop.lambda.core.mgr.workflow.component.characteristic;

import com.yatop.lambda.base.model.WfCfgCharTypeWild;
import com.yatop.lambda.base.model.WfCfgCharTypeWildExample;
import com.yatop.lambda.core.enums.LambdaExceptionEnum;
import com.yatop.lambda.core.mgr.base.BaseMgr;
import com.yatop.lambda.core.enums.DataStatusEnum;
import com.yatop.lambda.core.exception.LambdaException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharTypeWildMgr extends BaseMgr {

    /*
     *
     *   查询特征类型通配信息
     *   返回结果集
     *
     * */
    public List<WfCfgCharTypeWild> queryCharTypeWild() {

        try {
            WfCfgCharTypeWildExample example = new WfCfgCharTypeWildExample();
            example.createCriteria().andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
            return  wfCfgCharTypeWildMapper.selectByExample(example);
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.G_COMPUTE_DEFAULT_ERROR, "Query characteristic type-wild info failed.", "查询特征类型通配信息失败", e);
        }
    }
}
