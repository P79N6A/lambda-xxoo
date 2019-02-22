package com.yatop.lambda.manager.controller;


import com.yatop.lambda.manager.api.request.project.ProjectMemberRequest;
import com.yatop.lambda.manager.api.response.JsonResponse;
import com.yatop.lambda.manager.api.response.PagerResponse;
import com.yatop.lambda.manager.service.ProjectMemberService;
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

    @RequestMapping("member/list")
    @RequiresPermissions("member:list")
    public JsonResponse getProjectMemberList(@RequestBody ProjectMemberRequest request){
        return PagerResponse.build(projectMemberService.getProjectMemberList(request), request);
    }

    @RequestMapping("member/addProjectMembers")
    @RequiresPermissions("member:add")
    public JsonResponse addProjectMembers(ProjectMemberRequest request){
        return JsonResponse.build(projectMemberService.addProjectMembers(request));
    }

    @RequestMapping("member/deleteProjectMembers")
    @RequiresPermissions("member:delete")
    public JsonResponse deleteProjectMembers( ProjectMemberRequest request){
        return JsonResponse.build(projectMemberService.deleteProjectMembers(request));
    }
    @RequestMapping("member/changeProjectOwner")
    @RequiresPermissions("member:changeProjectOwner")
    public JsonResponse changeProjectOwner( ProjectMemberRequest request){
        return JsonResponse.build(projectMemberService.changeProjectOwner(request));
    }
}
