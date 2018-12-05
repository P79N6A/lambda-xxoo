package com.yatop.lambda.core.mgr.component.characteristic;

import com.yatop.lambda.base.model.CfCmptChar;
import com.yatop.lambda.base.model.CfCmptCharExample;
import com.yatop.lambda.core.enums.DataStatusEnum;
import com.yatop.lambda.core.exception.LambdaException;
import com.yatop.lambda.core.mgr.base.BaseMgr;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CmptCharMgr extends BaseMgr {

    /*
     *
     *   查询特征信息
     *   返回结果集
     *
     * */
    public List<CfCmptChar> queryCharacteristic() {

        try {
            CfCmptCharExample example = new CfCmptCharExample();
            example.createCriteria().andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
            return  cfCmptCharMapper.selectByExample(example);
        } catch (Throwable e) {
            throw new LambdaException("Query characteristic info failed.", "查询特征信息失败", e);
        }
    }
}
