package com.yatop.lambda.core.mgr.workflow.component;

import com.yatop.lambda.base.model.WfCfgCmptCharValue;
import com.yatop.lambda.base.model.WfCfgCmptCharValueExample;
import com.yatop.lambda.core.enums.LambdaExceptionEnum;
import com.yatop.lambda.core.mgr.base.BaseMgr;
import com.yatop.lambda.core.enums.DataStatusEnum;
import com.yatop.lambda.core.exception.LambdaException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CmptCharValueMgr extends BaseMgr {

    /*
     *
     *   查询组件特征值
     *   返回结果集
     *
     * */
    public List<WfCfgCmptCharValue> queryCmptCharValue() {

        try {
            WfCfgCmptCharValueExample example = new WfCfgCmptCharValueExample();
            example.createCriteria().andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
            return  wfCfgCmptCharValueMapper.selectByExample(example);
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.G_COMPUTE_DEFAULT_ERROR, "Query component characteristic value failed.", "查询组件特征值失败", e);
        }
    }
}
