package com.yatop.lambda.core.mgr.workflow.module;

import com.yatop.lambda.base.model.WfModule;
import com.yatop.lambda.base.model.WfModuleExample;
import com.yatop.lambda.core.enums.DataStatusEnum;
import com.yatop.lambda.core.exception.LambdaException;
import com.yatop.lambda.core.mgr.base.BaseMgr;

import java.util.List;

public class WorkflowModuleMgr extends BaseMgr {

    /*
     *
     *   查询工作流组件信息
     *   返回结果集
     *
     * */
    public List<WfModule> queryModule() {

        try {
            WfModuleExample example = new WfModuleExample();
            example.createCriteria().andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
            return wfModuleMapper.selectByExample(example);
        } catch (Throwable e) {
            throw new LambdaException("Query workflow module catalog failed.", "查询工作流组件信息失败", e);
        }
    }
}
