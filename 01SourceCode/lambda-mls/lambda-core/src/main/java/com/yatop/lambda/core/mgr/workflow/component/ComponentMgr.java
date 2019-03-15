package com.yatop.lambda.core.mgr.workflow.component;

import com.yatop.lambda.base.model.WfCfgComponent;
import com.yatop.lambda.base.model.WfCfgComponentExample;
import com.yatop.lambda.core.enums.LambdaExceptionEnum;
import com.yatop.lambda.core.mgr.base.BaseMgr;
import com.yatop.lambda.core.enums.DataStatusEnum;
import com.yatop.lambda.core.exception.LambdaException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComponentMgr extends BaseMgr {

    /*
     *
     *   查询组件信息
     *   返回结果集
     *
     * */
    public List<WfCfgComponent> queryComponent() {

        try {
            WfCfgComponentExample example = new WfCfgComponentExample();
            example.createCriteria().andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
            return  wfCfgComponentMapper.selectByExample(example);
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.G_COMPUTE_DEFAULT_ERROR, "Query component info failed.", "查询组件信息失败", e);
        }
    }
}
