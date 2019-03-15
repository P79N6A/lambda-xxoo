package com.yatop.lambda.core.mgr.workflow.module;

import com.yatop.lambda.base.model.WfCfgModulePropCtrl;
import com.yatop.lambda.base.model.WfCfgModulePropCtrlExample;
import com.yatop.lambda.core.enums.DataStatusEnum;
import com.yatop.lambda.core.enums.LambdaExceptionEnum;
import com.yatop.lambda.core.exception.LambdaException;
import com.yatop.lambda.core.mgr.base.BaseMgr;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModulePropCtrlMgr extends BaseMgr {

    /*
     *
     *   查询工作流组件属性页控件配置
     *   返回结果集
     *
     * */
    public List<WfCfgModulePropCtrl> queryModulePropCtrl() {

        try {
            WfCfgModulePropCtrlExample example = new WfCfgModulePropCtrlExample();
            example.createCriteria().andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
            return wfCfgModulePropCtrlMapper.selectByExample(example);
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query workflow module property page control config failed.", "查询工作流组件属性页控件配置失败", e);
        }
    }
}
