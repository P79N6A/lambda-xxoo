package com.yatop.lambda.manager.controller;


import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.manager.api.request.project.ProjectMemberRequest;
import com.yatop.lambda.manager.api.response.JsonResponse;
import com.yatop.lambda.manager.api.response.PagerResponse;
import com.yatop.lambda.manager.service.ProjectMemberService;
import com.yatop.lambda.portal.common.annotation.Log;
import com.yatop.lambda.portal.common.controller.BaseController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ProjectMemberController extends BaseController {


    @Autowired
    private ProjectMemberService projectMemberService;

    @Log("项目成员分页查询")
    @RequestMapping("member/list")
    @RequiresPermissions("project:operate")
    public JsonResponse getProjectMemberList(@RequestBody ProjectMemberRequest request){
        if(DataUtil.isNull(request.getProjectId())){
            return JsonResponse.build("项目Id为空！");
        }
        return PagerResponse.build(projectMemberService.getProjectMemberList(request), request);
    }

    @Log("非项目成员的用户列表")
    @RequestMapping("member/userListNotInProject")
    @RequiresPermissions("project:operate")
    public JsonResponse getUserListNotInProject(@RequestBody ProjectMemberRequest request){
        if(DataUtil.isNull(request.getProjectId())){
            return JsonResponse.build("项目Id为空！");
        }
        return JsonResponse.build(projectMemberService.getUserListNotInProject(request));
    }

    @Log("添加项目成员")
    @RequestMapping("member/addProjectMembers")
    @RequiresPermissions("project:operate")
    public JsonResponse addProjectMembers(@RequestBody ProjectMemberRequest request){
        if(DataUtil.isNull(request.getProjectId())){
            return JsonResponse.build("项目Id为空！");
        }
        return JsonResponse.build(projectMemberService.addProjectMembers(request));
    }

    @Log("删除项目成员")
    @RequestMapping("member/deleteProjectMembers")
    @RequiresPermissions("project:operate")
    public JsonResponse deleteProjectMembers(@RequestBody ProjectMemberRequest request){
        if(DataUtil.isNull(request.getProjectId())){
            return JsonResponse.build("项目Id为空！");
        }
        return JsonResponse.build(projectMemberService.deleteProjectMembers(request));
    }

    @Log("转让项目")
    @RequestMapping("member/changeProjectOwner")
    @RequiresPermissions("project:operate")
    public JsonResponse changeProjectOwner(@RequestBody ProjectMemberRequest request){
        if(DataUtil.isNull(request.getProjectId())){
            return JsonResponse.build("项目Id为空！");
        }
        return JsonResponse.build(projectMemberService.changeProjectOwner(request));
    }
}
