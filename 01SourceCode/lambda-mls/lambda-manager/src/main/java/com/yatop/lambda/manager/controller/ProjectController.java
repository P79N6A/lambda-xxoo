package com.yatop.lambda.manager.controller;

import com.yatop.lambda.core.utils.PagerUtil;
import com.yatop.lambda.manager.api.request.project.ProjectRequest;
import com.yatop.lambda.manager.service.ProjectMemberService;
import com.yatop.lambda.portal.common.controller.BaseController;
import com.yatop.lambda.portal.common.domain.JsonResponse;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProjectController extends BaseController {

    //private static Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ProjectMemberService projectMemberService;

    @RequestMapping(value = "/test/member/list")
    //@RequiresPermissions("member:list")
    public JsonResponse getProjectMemberList(@RequestBody ProjectRequest request){
        return JsonResponse.build(projectMemberService.getProjectMemberList(request));
        //return super.selectByPageNumSize(request,()->prProjectMemberService.queryProjectMemberList(projectId));
        //()->prProjectMemberService.queryProjectMemberList(projectId)

    }

    /*@RequestMapping("projectMember/add")
    @RequiresPermissions("member:add")
    public ResponseBo addProjectMember(PrProjectMember prProjectMember){
        //try{
            //prProjectMemberService.addProjectMember(prProjectMember);
            //return ResponseBo.ok("msg","新增成功");
        //}catch(Exception e){
            //log.error("新增项目成员失败", e);
            //return ResponseBo.error("新增失败");
        //}
        return null;
    }*/

    /*@RequestMapping("projectMember/delete")
    @RequiresPermissions("member:delete")
    public ResponseBo deleteProjectMember(PrProjectMember prProjectMember){
        //try{
            //return ResponseBo.ok("msg","删除成功");
        //}catch(Exception e){
        //    log.error("删除项目成员失败", e);
            //return ResponseBo.error("删除失败");
        //}
        return null;
    }*/
}
