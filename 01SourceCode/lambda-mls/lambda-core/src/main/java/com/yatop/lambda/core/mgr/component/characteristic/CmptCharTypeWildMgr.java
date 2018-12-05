package com.yatop.lambda.core.mgr.component.characteristic;

import com.yatop.lambda.base.model.CfCmptCharTypeWild;
import com.yatop.lambda.base.model.CfCmptCharTypeWildExample;
import com.yatop.lambda.core.enums.DataStatusEnum;
import com.yatop.lambda.core.exception.LambdaException;
import com.yatop.lambda.core.mgr.base.BaseMgr;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CmptCharTypeWildMgr extends BaseMgr {

    /*
     *
     *   查询特征类型通配信息
     *   返回结果集
     *
     * */
    public List<CfCmptCharTypeWild> queryCharTypeWild() {

        try {
            CfCmptCharTypeWildExample example = new CfCmptCharTypeWildExample();
            example.createCriteria().andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
            return  cfCmptCharTypeWildMapper.selectByExample(example);
        } catch (Throwable e) {
            throw new LambdaException("Query characteristic type-wild info failed.", "查询特征类型通配信息失败", e);
        }
    }
}
