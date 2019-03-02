package com.yatop.lambda.core.mgr.component.characteristic;

import com.yatop.lambda.base.model.CfCharacteristic;
import com.yatop.lambda.base.model.CfCharacteristicExample;
import com.yatop.lambda.core.enums.LambdaExceptionEnum;
import com.yatop.lambda.core.mgr.base.BaseMgr;
import com.yatop.lambda.core.enums.DataStatusEnum;
import com.yatop.lambda.core.exception.LambdaException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacteristicMgr extends BaseMgr {

    /*
     *
     *   查询特征信息
     *   返回结果集
     *
     * */
    public List<CfCharacteristic> queryCharacteristic() {

        try {
            CfCharacteristicExample example = new CfCharacteristicExample();
            example.createCriteria().andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
            return  cfCharacteristicMapper.selectByExample(example);
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.G_COMPUTE_DEFAULT_ERROR, "Query characteristic info failed.", "查询特征信息失败", e);
        }
    }
}
