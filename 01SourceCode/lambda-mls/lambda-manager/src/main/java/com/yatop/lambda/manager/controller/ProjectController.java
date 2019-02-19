package com.yatop.lambda.manager.controller;

import com.yatop.lambda.manager.api.response.JsonResponse;
import com.yatop.lambda.manager.service.ProjectService;
import com.yatop.lambda.portal.common.controller.BaseController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 19016 on 2019/1/28.
 */
@RestController
public class ProjectController extends BaseController {

    @Autowired
    private ProjectService projectService;

    // 项目列表
    @RequestMapping("project/list")
    @RequiresPermissions("project:list")
    public JsonResponse getProjectList(@RequestParam("pageNum")Integer pageNum,
                                       @RequestParam("pageSize")Integer pageSize,
                                       @RequestParam("keyword")String keyword,
                                       @RequestParam("operUser")String operUser){
        return JsonResponse.build(projectService.queryProjectExt(pageNum, pageSize, keyword, operUser));
    }

    // 新建项目
    @RequestMapping("project/add")
    @RequiresPermissions("project:add")
    //TODO 将请求参数的PrProject类型参数，修改为ProjectRequest类型参数
    public JsonResponse addProject(@RequestParam("projectCode") String projectCode,
                                   @RequestParam("projectName") String projectName,
                                   @RequestParam("projectDesc") String projecDesc,
                                   @RequestParam("operUser") String operUser) {
        return JsonResponse.build(projectService.addProject(projectCode, projectName, projecDesc, operUser));
    }

    // 删除项目
    @RequestMapping("project/delete")
    @RequiresPermissions("project:delete")
    public JsonResponse deleteProject(@RequestParam("projectId") Long projectId,
                                      @RequestParam("operUser") String operUser){
        return JsonResponse.build(projectService.deleteProject(projectId, operUser));
    }

    // 修改项目
    @RequestMapping("project/update")
    @RequiresPermissions("project:update")
    //TODO 将请求参数的PrProject类型参数，修改为ProjectRequest类型参数
    public JsonResponse Project(@RequestParam("projectId") Long projectId,
                                @RequestParam("projectCode") String projectCode,
                                @RequestParam("projectName") String projectName,
                                @RequestParam("projectDesc") String projectDesc,
                                @RequestParam("cacheExpireDays") Integer cacheExpireDays,
                                @RequestParam("operUser") String operUser) {
        return JsonResponse.build(projectService.updateProject(projectId, projectCode, projectName,
                                                                projectDesc, cacheExpireDays, operUser));
    }

    // 检查项目是否存在
    @RequestMapping("project/exists")
    // @RequiresPermissions("project:exists")
    public JsonResponse existsProject(@RequestParam("projectCode") String projectCode,
                                      @RequestParam("projectName") String projectName,
                                      @RequestParam("projectId") Long projectId) {
        return JsonResponse.build(projectService.existsProject(projectCode, projectName, projectId));
    }

    // 查看项目
    @RequestMapping("project/query")
    @RequiresPermissions("project:query")
    public JsonResponse queryProject(@RequestParam("projectId") Long projectId) {
        return JsonResponse.build(projectService.queryProject(projectId));
    }

}
