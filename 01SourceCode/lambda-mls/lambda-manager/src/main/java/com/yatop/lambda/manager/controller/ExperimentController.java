package com.yatop.lambda.manager.controller;

import com.yatop.lambda.base.extend.model.ExtEmExperiment;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.manager.api.request.experiment.ExperimentRequest;
import com.yatop.lambda.manager.api.response.JsonResponse;
import com.yatop.lambda.manager.api.response.PagerResponse;
import com.yatop.lambda.manager.service.ExperimentService;
import com.yatop.lambda.portal.common.annotation.Log;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 实验管理
 *
 * @author huangyu
 * @create 2019-02-26-10:13
 */
@RestController
@RequestMapping("/experiment")
public class ExperimentController {

    @Autowired
    private ExperimentService experimentService;

    @Log("实验分页查询")
    @RequestMapping("/query")
    @RequiresPermissions("project:operate")
    public JsonResponse queryExperiment(@RequestBody ExperimentRequest vo) {
        List<ExtEmExperiment> emExperiments = experimentService.queryExperiment(vo);
        return PagerResponse.build(emExperiments, vo);
    }

    @Log("创建实验")
    @RequestMapping("/create")
    @RequiresPermissions("project:operate")
    public JsonResponse createExperiment(@RequestBody ExperimentRequest vo) {
        return JsonResponse.build(experimentService.createExperiment(vo));
    }


    @Log("删除实验")
    @RequestMapping("/delete")
    @RequiresPermissions("project:operate")
    public JsonResponse deleteExperiment(@RequestBody List<Long> experimentIds) {
        if (DataUtil.isNull(experimentIds)) {
            return JsonResponse.build(("请选择要删除的实验！"));
        }
        return JsonResponse.build(experimentService.deleteExperiment(experimentIds));
    }

    @Log("修改实验")
    @RequestMapping("/update")
    @RequiresPermissions("project:operate")
    public JsonResponse updateExperiment(@RequestBody ExperimentRequest vo) {
        return JsonResponse.build(experimentService.updateExperiment(vo));
    }

    @Log("创建实验(从模板创建)")
    @RequestMapping("/createByTemplate")
    @RequiresPermissions("project:operate")
    public JsonResponse createExperimentByTemplate(@RequestBody ExperimentRequest vo) {
        return JsonResponse.build(experimentService.createExperimentByTemplate(vo));
    }

    @Log("创建实验(复制)")
    @RequestMapping("/copy")
    @RequiresPermissions("project:operate")
    public JsonResponse copyExperiment(@RequestBody ExperimentRequest vo) {
        return JsonResponse.build(experimentService.copyExperiment(vo));
    }

    @Log("创建实验(从快照创建)")
    @RequestMapping("/createBySnapshot")
    @RequiresPermissions("project:operate")
    public JsonResponse createExperimentBySnapshot(@RequestBody ExperimentRequest vo) {
        return JsonResponse.build(experimentService.createExperimentBySnapshot(vo));
    }

    @Log("创建实验(打开)")
    @RequestMapping("/open")
    @RequiresPermissions("project:operate")
    public JsonResponse openExperiment(@RequestBody ExperimentRequest vo) {
        return JsonResponse.build(experimentService.openExperiment(vo));
    }

    @Log("创建实验(关闭)")
    @RequestMapping("/close")
    @RequiresPermissions("project:operate")
    public JsonResponse closeExperiment(@RequestBody ExperimentRequest vo) {
        //TODO 待完善
        return JsonResponse.build("关闭实验");
    }

    @Log("查询实验模板")
    @RequestMapping("/queryTemplate")
    @RequiresPermissions("project:operate")
    public JsonResponse queryAllExperimentTemplate() {
        return JsonResponse.build(experimentService.queryExperimentTemplate());
    }

    @Log("查询实验画布")
    @RequestMapping("/queryCanvas")
    @RequiresPermissions("project:operate")
    public JsonResponse queryExperimentCanvas(@RequestBody ExperimentRequest vo) {
        return JsonResponse.build(experimentService.queryExperimentCanvas(vo));
    }

    @Log("添加实验节点(组件)")
    @RequestMapping("/addNode")
    @RequiresPermissions("project:operate")
    public JsonResponse addExperimentNode(@RequestBody ExperimentRequest vo) {
        return JsonResponse.build(experimentService.addExperimentNode(vo));
    }

    @Log("添加实验节点（指定模型ID）")
    @RequestMapping("/addModelNode")
    @RequiresPermissions("project:operate")
    public JsonResponse addExperimentNode4Model(@RequestBody ExperimentRequest vo) {
        return JsonResponse.build(experimentService.addExperimentNode4Model(vo));
    }

    @Log("添加实验节点（指定数据表名）")
    @RequestMapping("/addDataSourceNode")
    @RequiresPermissions("project:operate")
    public JsonResponse addExperimentNode4Table(@RequestBody ExperimentRequest vo) {
        return JsonResponse.build(experimentService.addExperimentNode4Table(vo));
    }

    @Log("更改实验节点位置")
    @RequestMapping("/updateNodeLocation")
    @RequiresPermissions("project:operate")
    public JsonResponse updateExperimentNodeLocation(@RequestBody ExperimentRequest vo) {
        return JsonResponse.build(experimentService.updateExperimentNodeLocation(vo));
    }

    @Log("验证实验节点链接")
    @RequestMapping("/validateNodeLink")
    @RequiresPermissions("project:operate")
    public JsonResponse validateExperimentNodeLink(@RequestBody ExperimentRequest vo) {
        return JsonResponse.build(experimentService.validateExperimentNodeLink(vo));
    }

    @Log("添加实验节点链接")
    @RequestMapping("/addNodeLink")
    @RequiresPermissions("project:operate")
    public JsonResponse addExperimentNodeLink(@RequestBody ExperimentRequest vo) {
        return JsonResponse.build(experimentService.addExperimentNodeLink(vo));
    }
}
