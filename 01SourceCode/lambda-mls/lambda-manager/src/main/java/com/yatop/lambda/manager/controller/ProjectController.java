package com.yatop.lambda.manager.controller;

import com.yatop.lambda.manager.api.request.project.ProjectRequest;
import com.yatop.lambda.manager.api.response.JsonResponse;
import com.yatop.lambda.manager.api.response.PagerResponse;
import com.yatop.lambda.manager.service.ProjectService;
import com.yatop.lambda.portal.common.annotation.Log;
import com.yatop.lambda.portal.common.controller.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@Api(value="项目管理")
@RestController
public class ProjectController extends BaseController {

    @Autowired
    private ProjectService projectService;

    @Log("查询项目列表")
    @RequestMapping("project/list")
    @RequiresPermissions("project:operate")
    public JsonResponse getProjectList(@RequestBody ProjectRequest vo) {
        return PagerResponse.build(projectService.queryProjectExt(vo), vo);
    }

    @Log("新建项目")
    @RequestMapping("project/add")
    @RequiresPermissions("project:operate")
    public JsonResponse addProject(@RequestBody ProjectRequest vo) {
        return JsonResponse.build(projectService.addProject(vo));
    }

    @Log("当前用户相关项目列表")
    @RequestMapping("project/listByMember")
    @RequiresPermissions("project:operate")
    public JsonResponse getProjectListByMember() {
        return JsonResponse.build(projectService.queryProject4CurrentUser());
    }

    @Log("删除项目")
    @RequestMapping("project/delete")
    @RequiresPermissions("project:operate")
    public JsonResponse deleteProject(@RequestBody ProjectRequest vo) {
        return JsonResponse.build(projectService.deleteProject(vo.getProjectId()));
    }


    @Log("修改项目")
    @RequestMapping("project/update")
    @RequiresPermissions("project:operate")
    public JsonResponse updateProject(@RequestBody ProjectRequest vo) {
        return JsonResponse.build(projectService.updateProject(vo));
    }

    @Log("检查项目是否存在")
    @RequestMapping("project/exists")
    @RequiresPermissions("project:operate")
    public JsonResponse existsProject(@RequestBody ProjectRequest vo) {
        return JsonResponse.build(projectService.existsProject(vo));
    }

    @Log("查看项目")
    @RequestMapping("project/query")
    @RequiresPermissions("project:operate")
    public JsonResponse queryProject(@RequestBody ProjectRequest vo) {
        return JsonResponse.build(projectService.queryProject(vo.getProjectId()));
    }


    @Log("手动清理临时表")
    @RequestMapping("project/clearTemporaryTable")
    @RequiresPermissions("project:operate")
    public JsonResponse clearTemporaryTable(@RequestBody ProjectRequest vo){
        if(vo.getClearDate() == null){
            return JsonResponse.build("请选择时间！");
        }
        return JsonResponse.build(projectService.clearTemporaryTable(vo.getClearDate()));
    }


    @Log("调度清理临时表")
    @RequestMapping("project/timingClearTemporaryTable/{saveTime}")
    @RequiresPermissions("project:operate")
    public JsonResponse timingClearTemporaryTable(@PathVariable Integer saveTime){
        //TODO 更新项目中的 过期字段
        return JsonResponse.build("保存成功！");
    }

}
