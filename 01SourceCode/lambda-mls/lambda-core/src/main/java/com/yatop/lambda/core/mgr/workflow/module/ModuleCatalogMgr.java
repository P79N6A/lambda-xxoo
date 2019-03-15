package com.yatop.lambda.core.mgr.workflow.module;

import com.yatop.lambda.base.model.WfCfgModuleCatalog;
import com.yatop.lambda.base.model.WfCfgModuleCatalogExample;
import com.yatop.lambda.core.enums.LambdaExceptionEnum;
import com.yatop.lambda.core.mgr.base.BaseMgr;
import com.yatop.lambda.core.enums.DataStatusEnum;
import com.yatop.lambda.core.exception.LambdaException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModuleCatalogMgr extends BaseMgr {

    /*
     *
     *   查询工作流组件目录
     *   返回结果集
     *
     * */
    public List<WfCfgModuleCatalog> queryModuleCatalog() {

        try {
            WfCfgModuleCatalogExample example = new WfCfgModuleCatalogExample();
            example.createCriteria().andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
            return  wfCfgModuleCatalogMapper.selectByExample(example);
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query workflow module catalog failed.", "查询工作流组件目录失败", e);
        }
    }
}
