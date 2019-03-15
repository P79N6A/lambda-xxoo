package com.yatop.lambda.core.mgr.workflow.component.characteristic;

import com.yatop.lambda.base.model.WfCfgCharacteristic;
import com.yatop.lambda.base.model.WfCfgCharacteristicExample;
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
    public List<WfCfgCharacteristic> queryCharacteristic() {

        try {
            WfCfgCharacteristicExample example = new WfCfgCharacteristicExample();
            example.createCriteria().andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
            return  wfCfgCharacteristicMapper.selectByExample(example);
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.G_COMPUTE_DEFAULT_ERROR, "Query characteristic info failed.", "查询特征信息失败", e);
        }
    }
}
