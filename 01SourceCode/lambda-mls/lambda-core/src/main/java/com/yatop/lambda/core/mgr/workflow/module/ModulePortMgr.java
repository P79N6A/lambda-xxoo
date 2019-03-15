package com.yatop.lambda.core.mgr.workflow.module;

import com.yatop.lambda.base.model.WfCfgModulePort;
import com.yatop.lambda.base.model.WfCfgModulePortExample;
import com.yatop.lambda.core.enums.LambdaExceptionEnum;
import com.yatop.lambda.core.mgr.base.BaseMgr;
import com.yatop.lambda.core.enums.DataStatusEnum;
import com.yatop.lambda.core.exception.LambdaException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModulePortMgr extends BaseMgr {

    /*
     *
     *   查询工作流组件端口
     *   返回结果集
     *
     * */
    public List<WfCfgModulePort> queryModulePort() {

        try {
            WfCfgModulePortExample example = new WfCfgModulePortExample();
            example.createCriteria().andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
            return wfCfgModulePortMapper.selectByExample(example);
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query workflow module catalog failed.", "查询工作流组件端口失败", e);
        }
    }
}
