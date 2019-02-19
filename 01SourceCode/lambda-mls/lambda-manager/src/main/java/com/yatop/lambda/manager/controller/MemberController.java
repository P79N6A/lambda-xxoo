package com.yatop.lambda.manager.controller;


import com.yatop.lambda.manager.api.request.member.MemberRequest;
import com.yatop.lambda.manager.api.response.JsonResponse;
import com.yatop.lambda.manager.service.ProjectMemberService;
import com.yatop.lambda.portal.common.controller.BaseController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 19016 on 2019/1/28.
 */
@RestController
public class MemberController extends BaseController {


    @Autowired
    private ProjectMemberService projectMemberService;

    @RequestMapping("member/queryProjectMembers")
    @RequiresPermissions("member:list")
    public JsonResponse getProjectMemberList( MemberRequest request){
        return JsonResponse.build(projectMemberService.getProjectMemberList(request));
    }

    @RequestMapping("member/addProjectMembers")
    @RequiresPermissions("member:add")
    public JsonResponse addProjectMembers( MemberRequest request){
        return JsonResponse.build(projectMemberService.addProjectMembers(request));
    }

    @RequestMapping("member/deleteProjectMembers")
    @RequiresPermissions("member:delete")
    public JsonResponse deleteProjectMembers( MemberRequest request){
        return JsonResponse.build(projectMemberService.deleteProjectMembers(request));
    }
    @RequestMapping("member/changeProjectOwner")
    @RequiresPermissions("member:changeProjectOwner")
    public JsonResponse changeProjectOwner( MemberRequest request){
        return JsonResponse.build(projectMemberService.changeProjectOwner(request));
    }
}
