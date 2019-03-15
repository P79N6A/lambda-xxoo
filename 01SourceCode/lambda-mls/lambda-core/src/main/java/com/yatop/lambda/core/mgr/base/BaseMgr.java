package com.yatop.lambda.core.mgr.base;

import com.yatop.lambda.base.model.WfCfgModulePropCtrl;
import com.yatop.lambda.base.model.WfCfgModulePropCtrlRel;
import com.yatop.lambda.base.model.WfCfgModulePropTab;
import org.springframework.beans.factory.annotation.Autowired;
import com.yatop.lambda.base.mapper.*;

public class BaseMgr {

    @Autowired
    protected DwDataTableMapper dwDataTableMapper;

    @Autowired
    protected DwDataWarehouseMapper dwDataWarehouseMapper;

    @Autowired
    protected EmExperimentMapper emExperimentMapper;

    @Autowired
    protected EmExperimentTemplateMapper emExperimentTemplateMapper;

    @Autowired
    protected EmExperimentOpenMapper emExperimentOpenMapper;

    @Autowired
    protected MwModelMapper mwModelMapper;

    @Autowired
    protected MwModelWarehouseMapper mwModelWarehouseMapper;

    @Autowired
    protected PrProjectMapper prProjectMapper;

    @Autowired
    protected PrProjectMemberMapper prProjectMemberMapper;

    @Autowired
    protected WfCodeScriptMapper wfCodeScriptMapper;

    @Autowired
    protected WfExecutionJobMapper wfExecutionJobMapper;

    @Autowired
    protected WfExecutionJobQueueMapper wfExecutionJobQueueMapper;

    @Autowired
    protected WfExecutionTaskMapper wfExecutionTaskMapper;

    @Autowired
    protected WfFlowMapper wfFlowMapper;

    @Autowired
    protected WfFlowAccumulateMapper wfFlowAccumulateMapper;

    @Autowired
    protected WfFlowNodeDeleteQueueMapper wfFlowNodeDeleteQueueMapper;

    @Autowired
    protected WfFlowNodeLinkMapper wfFlowNodeLinkMapper;

    @Autowired
    protected WfFlowNodeMapper wfFlowNodeMapper;

    @Autowired
    protected WfFlowNodeParameterMapper wfFlowNodeParameterMapper;

    @Autowired
    protected WfFlowNodeOutputMapper wfFlowNodeOutputMapper;

    @Autowired
    protected WfFlowNodePortMapper wfFlowNodePortMapper;

    @Autowired
    protected WfFlowNodeSchemaMapper wfFlowNodeSchemaMapper;

    @Autowired
    protected WfJsonObjectMapper wfJsonObjectMapper;

    @Autowired
    protected WfSnapshotMapper wfSnapshotMapper;

    @Autowired
    protected WfUserFavoriteModuleMapper wfUserFavoriteModuleMapper;

    @Autowired
    protected WfUserFavoriteTableMapper wfUserFavoriteTableMapper;

    //配置数据Mapper

    @Autowired
    protected SysParameterMapper sysParameterMapper;

    @Autowired
    protected WfCfgAlgorithmMapper wfCfgAlgorithmMapper;

    @Autowired
    protected WfCfgCharTypeMapper wfCfgCharTypeMapper;
    @Autowired
    protected WfCfgCharTypeWildMapper wfCfgCharTypeWildMapper;

    @Autowired
    protected WfCfgCharOptionMapper wfCfgCharOptionMapper;
    @Autowired
    protected WfCfgCharacteristicMapper wfCfgCharacteristicMapper;

    @Autowired
    protected WfCfgSpecCharRelMapper wfCfgSpecCharRelMapper;
    @Autowired
    protected WfCfgSpecCharValueMapper wfCfgSpecCharValueMapper;
    @Autowired
    protected WfCfgSpecificationMapper wfCfgSpecificationMapper;

    @Autowired
    protected WfCfgCmptSpecRelMapper wfCfgCmptSpecRelMapper;
    @Autowired
    protected WfCfgCmptCharValueMapper wfCfgCmptCharValueMapper;
    @Autowired
    protected WfCfgComponentMapper wfCfgComponentMapper;

    @Autowired
    protected WfCfgModuleCatalogMapper wfCfgModuleCatalogMapper;
    @Autowired
    protected WfCfgModuleMapper wfCfgModuleMapper;
    @Autowired
    protected WfCfgModulePortMapper wfCfgModulePortMapper;

    @Autowired
    protected WfCfgModulePropTabMapper wfCfgModulePropTabMapper;
    @Autowired
    protected WfCfgModulePropCtrlMapper wfCfgModulePropCtrlMapper;
    @Autowired
    protected WfCfgModulePropCtrlRelMapper wfCfgModulePropCtrlRelMapper;
}
