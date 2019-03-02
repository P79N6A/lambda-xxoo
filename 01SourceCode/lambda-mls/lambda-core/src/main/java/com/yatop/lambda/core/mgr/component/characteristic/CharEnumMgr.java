package com.yatop.lambda.core.mgr.component.characteristic;

import com.yatop.lambda.base.model.CfCharEnum;
import com.yatop.lambda.base.model.CfCharEnumExample;
import com.yatop.lambda.core.enums.LambdaExceptionEnum;
import com.yatop.lambda.core.mgr.base.BaseMgr;
import com.yatop.lambda.core.enums.DataStatusEnum;
import com.yatop.lambda.core.exception.LambdaException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharEnumMgr extends BaseMgr {

    /*
     *
     *   查询特征枚举信息
     *   返回结果集
     *
     * */
    public List<CfCharEnum> queryCharEnum() {

        try {
            CfCharEnumExample example = new CfCharEnumExample();
            example.createCriteria().andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
            return  cfCharEnumMapper.selectByExample(example);
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.G_COMPUTE_DEFAULT_ERROR, "Query characteristic enumeration info failed.", "查询特征枚举信息失败", e);
        }
    }
}
