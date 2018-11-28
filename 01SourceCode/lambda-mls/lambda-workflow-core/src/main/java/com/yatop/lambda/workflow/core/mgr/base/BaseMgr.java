package com.yatop.lambda.workflow.core.mgr.base;

import com.yatop.lambda.base.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseMgr {

    @Autowired
    protected CfCmptAlgorithmMapper cfCmptAlgorithmMapper;

    @Autowired
    protected CfCmptCharEnumMapper cfCmptCharEnumMapper;

    @Autowired
    protected CfCmptCharMapper cfCmptCharMapper;

    @Autowired
    protected CfCmptCharTypeMapper cfCmptCharTypeMapper;

    @Autowired
    protected CfCmptCharTypeWildMapper cfCmptCharTypeWildMapper;

    @Autowired
    protected CfCmptCharValueMapper cfCmptCharValueMapper;

    @Autowired
    protected CfCmptSpecCharRelMapper cfCmptSpecCharRelMapper;

    @Autowired
    protected CfCmptSpecCharValueMapper cfCmptSpecCharValueMapper;

    @Autowired
    protected CfCmptSpecMapper cfCmptSpecMapper;

    @Autowired
    protected CfCmptSpecRelMapper cfCmptSpecRelMapper;

    @Autowired
    protected CfComponentMapper cfComponentMapper;

    @Autowired
    protected WfModuleCatalogMapper wfModuleCatalogMapper;

    @Autowired
    protected WfModuleMapper wfModuleMapper;

    @Autowired
    protected WfModulePortMapper wfModulePortMapper;
}
