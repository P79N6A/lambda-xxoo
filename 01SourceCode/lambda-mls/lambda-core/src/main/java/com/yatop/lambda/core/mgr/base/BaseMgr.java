package com.yatop.lambda.core.mgr.base;

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
    protected MwModelMapper mwModelMapper;

    @Autowired
    protected MwModelWarehouseMapper mwModelWarehouseMapper;

    @Autowired
    protected PrProjectMapper prProjectMapper;

    @Autowired
    protected PrProjectMemberMapper prProjectMemberMapper;

    @Autowired
    protected SysParameterMapper sysParameterMapper;

    @Autowired
    protected WfCodeScriptMapper wfCodeScriptMapper;

    @Autowired
    protected WfExecutionJobMapper wfExecutionJobMapper;

    @Autowired
    protected WfExecutionQueueMapper wfExecutionQueueMapper;

    @Autowired
    protected WfExecutionTaskMapper wfExecutionTaskMapper;

    @Autowired
    protected WfExecutionTaskOutputMapper wfExecutionTaskOutputMapper;

    @Autowired
    protected WfFlowGlobalParameterMapper wfFlowGlobalParameterMapper;

    @Autowired
    protected WfFlowMapper wfFlowMapper;

    @Autowired
    protected WfFlowNodeDeleteQueueMapper wfFlowNodeDeleteQueueMapper;

    @Autowired
    protected WfFlowNodeLinkMapper wfFlowNodeLinkMapper;

    @Autowired
    protected WfFlowNodeMapper wfFlowNodeMapper;

    @Autowired
    protected WfFlowNodeParameterMapper wfFlowNodeParameterMapper;

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
}
