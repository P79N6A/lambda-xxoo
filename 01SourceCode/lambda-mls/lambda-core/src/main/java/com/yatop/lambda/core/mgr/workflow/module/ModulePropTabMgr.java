package com.yatop.lambda.core.mgr.workflow.module;

import com.yatop.lambda.base.model.WfCfgModulePort;
import com.yatop.lambda.base.model.WfCfgModulePortExample;
import com.yatop.lambda.base.model.WfCfgModulePropTab;
import com.yatop.lambda.base.model.WfCfgModulePropTabExample;
import com.yatop.lambda.core.enums.DataStatusEnum;
import com.yatop.lambda.core.enums.LambdaExceptionEnum;
import com.yatop.lambda.core.exception.LambdaException;
import com.yatop.lambda.core.mgr.base.BaseMgr;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModulePropTabMgr extends BaseMgr {

    /*
     *
     *   查询工作流组件属性页tab模版
     *   返回结果集
     *
     * */
    public List<WfCfgModulePropTab> queryModulePropTab() {

        try {
            WfCfgModulePropTabExample example = new WfCfgModulePropTabExample();
            example.createCriteria().andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
            return wfCfgModulePropTabMapper.selectByExample(example);
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query workflow module property page tab template failed.", "查询工作流组件属性页tab模版失败", e);
        }
    }
}
