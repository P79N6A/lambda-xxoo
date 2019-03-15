package com.yatop.lambda.core.mgr.workflow.component.characteristic;

import com.yatop.lambda.base.model.WfCfgCharOption;
import com.yatop.lambda.base.model.WfCfgCharOptionExample;
import com.yatop.lambda.core.enums.LambdaExceptionEnum;
import com.yatop.lambda.core.mgr.base.BaseMgr;
import com.yatop.lambda.core.enums.DataStatusEnum;
import com.yatop.lambda.core.exception.LambdaException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharOptionMgr extends BaseMgr {

    /*
     *
     *   查询特征枚举信息
     *   返回结果集
     *
     * */
    public List<WfCfgCharOption> queryCharEnum() {

        try {
            WfCfgCharOptionExample example = new WfCfgCharOptionExample();
            example.createCriteria().andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
            return  wfCfgCharOptionMapper.selectByExample(example);
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.G_COMPUTE_DEFAULT_ERROR, "Query characteristic option info failed.", "查询特征枚举信息失败", e);
        }
    }
}
