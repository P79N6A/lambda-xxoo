package com.yatop.lambda.core.mgr.workflow.module;

import com.yatop.lambda.base.model.WfCfgModulePropCtrlRel;
import com.yatop.lambda.base.model.WfCfgModulePropCtrlRelExample;
import com.yatop.lambda.core.enums.DataStatusEnum;
import com.yatop.lambda.core.enums.LambdaExceptionEnum;
import com.yatop.lambda.core.exception.LambdaException;
import com.yatop.lambda.core.mgr.base.BaseMgr;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModulePropCtrlRelMgr extends BaseMgr {

    /*
     *
     *   查询工作流组件属性页控件关系
     *   返回结果集
     *
     * */
    public List<WfCfgModulePropCtrlRel> queryModulePropCtrlRel() {

        try {
            WfCfgModulePropCtrlRelExample example = new WfCfgModulePropCtrlRelExample();
            example.createCriteria().andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
            return wfCfgModulePropCtrlRelMapper.selectByExample(example);
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query workflow module property page control relation failed.", "查询工作流组件属性页控件关系失败", e);
        }
    }
}
