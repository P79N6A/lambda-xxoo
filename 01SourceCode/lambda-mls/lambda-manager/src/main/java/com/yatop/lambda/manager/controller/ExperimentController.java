package com.yatop.lambda.manager.controller;

import com.yatop.lambda.base.extend.model.ExtEmExperiment;
import com.yatop.lambda.base.model.EmExperiment;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.manager.api.request.project.ExperimentRequest;
import com.yatop.lambda.manager.api.response.JsonResponse;
import com.yatop.lambda.manager.api.response.PagerResponse;
import com.yatop.lambda.manager.service.ExperimentService;
import com.yatop.lambda.portal.common.annotation.Log;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 实验管理
 *
 * @author huangyu
 * @create 2019-02-26-10:13
 */
@RestController
@RequestMapping("/experiment")
public class ExperimentController{

    @Autowired
    private ExperimentService experimentService;

    @Log("实验分页查询(名称 + 项目Id)")
    @RequestMapping("/query")
    @RequiresPermissions("project:operate")
    public JsonResponse queryExperiment(@RequestBody ExperimentRequest vo){
        if(DataUtil.isNull(vo.getProjectId())){
            return JsonResponse.build("项目Id为空！");
        }
        List<ExtEmExperiment> emExperiments = experimentService.queryExperiment(vo);
        return PagerResponse.build(emExperiments,vo);
    }

    @Log("创建实验")
    @RequestMapping("/create")
    @RequiresPermissions("project:operate")
    public JsonResponse createExperiment(@RequestBody ExperimentRequest vo){
        if(DataUtil.isNull(vo.getProjectId())){
            return JsonResponse.build("项目Id为空！");
        }
        return JsonResponse.build(experimentService.createExperiment(vo));
    }


    @Log("删除实验")
    @RequestMapping("/delete")
    @RequiresPermissions("project:operate")
    public JsonResponse deleteExperiment(@RequestBody List<Long> experimentIds){
        if(DataUtil.isNull(experimentIds)){
            return JsonResponse.build(("请选择要删除的实验！"));
        }
        return JsonResponse.build(experimentService.deleteExperiment(experimentIds));
    }

    @Log("修改实验")
    @RequiresPermissions("project:operate")
    public JsonResponse updateExperiment(@RequestBody ExperimentRequest vo ){
        if(DataUtil.isNull(vo.getExperimentId())){
            return JsonResponse.build("请选择实验！");
        }
        return JsonResponse.build(experimentService.updateExperiment(vo));
    }

    @Log("创建实验(从模板创建)")
    @RequestMapping("/createByTemplate")
    @RequiresPermissions("project:operate")
    public JsonResponse createExperimentByTemplate(@RequestBody ExperimentRequest vo ){
        if(DataUtil.isNull(vo.getProjectId())){
            return JsonResponse.build("项目Id为空！");
        }
        return JsonResponse.build(experimentService.createExperimentByTemplate(vo));
    }

    @Log("创建实验(复制)")
    @RequestMapping("/copy")
    public JsonResponse copyExperiment(@RequestBody ExperimentRequest vo ){
        return JsonResponse.build(experimentService.copyExperiment(vo));
    }

    @Log("创建实验(从快照创建)")
    @RequestMapping("/createBySnapshot")
    public JsonResponse createExperimentBySnapshot(@RequestBody ExperimentRequest vo ){
        return JsonResponse.build(experimentService.createExperimentBySnapshot(vo));
    }

    @Log("创建实验(打开)")
    @RequestMapping("/open")
    public JsonResponse openExperiment(@RequestBody ExperimentRequest vo ){
        //TODO 打开上次未关闭的实验
        return JsonResponse.build("打开实验");
    }

    @Log("创建实验(关闭)")
    @RequestMapping("/close")
    public JsonResponse closeExperiment(@RequestBody ExperimentRequest vo ){
        //TODO 待完善
        return JsonResponse.build("关闭实验");
    }

    @Log("查询实验模板")
    @RequestMapping("/queryTemplate")
    public JsonResponse queryAllExperimentTemplate(){
        return JsonResponse.build(experimentService.queryExperimentTemplate());
    }
}
