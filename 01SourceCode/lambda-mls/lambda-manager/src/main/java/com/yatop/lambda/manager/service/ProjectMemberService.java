package com.yatop.lambda.manager.service;

import com.yatop.lambda.base.extend.mapper.ExtProjectMemberMapper;
import com.yatop.lambda.base.extend.model.ExtProjectMemberDetail;
import com.yatop.lambda.base.model.PrProjectMember;
import com.yatop.lambda.core.enums.LambdaExceptionEnum;
import com.yatop.lambda.core.enums.ProjectRoleEnum;
import com.yatop.lambda.core.exception.LambdaException;
import com.yatop.lambda.core.mgr.project.ProjectMemberMgr;
import com.yatop.lambda.core.utils.PagerUtil;
import com.yatop.lambda.manager.api.request.project.ProjectMemberRequest;
import com.yatop.lambda.portal.common.utils.PortalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProjectMemberService {

    @Autowired
    private ExtProjectMemberMapper extProjectMemberMapper;

    @Autowired
    private ProjectMemberMgr projectMemberMgr;
    @Autowired
    private ProjectService projectService;

    public List<ExtProjectMemberDetail> getProjectMemberList(ProjectMemberRequest request) {
        //判断项目是否存在
        projectService.queryProject(request.getProjectId());

        PagerUtil.startPage(request);
       try{
           if(request.getMemberUser()==null){
               request.setMemberUser("");
           }
           String memberUser="%"+request.getMemberUser()+"%";
           return this.extProjectMemberMapper.queryProjectMemberList(request.getProjectId(),memberUser);
       }catch (Exception e){
           PagerUtil.clearPage(request);
           throw new LambdaException(LambdaExceptionEnum.B_PROJECT_DEFAULT_ERROR,"查询项目成员列表异常",e);
       }
    }

    public List<ExtProjectMemberDetail> getUserListNotInProject(ProjectMemberRequest request) {
        //判断项目是否存在
        projectService.queryProject(request.getProjectId());
        PagerUtil.startPage(request);
        try{
            if(request.getMemberUser()==null){
                request.setMemberUser("");
            }
            String memberUser="%"+request.getMemberUser()+"%";
            return this.extProjectMemberMapper.queryUserListNotInProject(request.getProjectId(),memberUser);
        }catch (Exception e){
            PagerUtil.clearPage(request);
            throw new LambdaException(LambdaExceptionEnum.B_PROJECT_DEFAULT_ERROR,"查询用户列表异常",e);
        }
    }
    /**
     *
     * @param request 请求 ，项目ID，成员用户列表，操作用户
     * 项目成员状态，最近更新时间，最近更新用户，创建时间，创建用户。
     */
    @Transactional
    public int addProjectMembers(ProjectMemberRequest request) {
        //判断项目是否存在
        projectService.queryProject(request.getProjectId());
        List<String> memberUsers=request.getMemberUsers();
        int count=0;
        if(memberUsers!=null){
            for(int i=0;i<memberUsers.size();i++){
                PrProjectMember prProjectMember=new PrProjectMember();
                prProjectMember.setProjectId(request.getProjectId());
                prProjectMember.setMemberUser(memberUsers.get(i));
                prProjectMember.setProjectRole(ProjectRoleEnum.PROJECT_DEVELOPER.getRole());
                boolean flag=projectMemberMgr.existsProjectMember(prProjectMember.getProjectId(),memberUsers.get(i));
                if(!flag){
                    projectMemberMgr.insertProjectMember(prProjectMember,PortalUtil.getCurrentUserName());
                    count+=1;
                }
            }
        }
        return count;
    }


    /**
     * 逻辑上删除项目成员
     * 设置项目成员表状态为失效
     * @param request  请求，项目ID，成员用户列表，操作用户
     * @return 删除数量
     */
    @Transactional
    public int deleteProjectMembers(ProjectMemberRequest request) {
        //判断项目是否存在
        projectService.queryProject(request.getProjectId());

        List<String> memberUsers=request.getMemberUsers();
        int counts=0;
        if(memberUsers!=null){
            for(int i=0;i<memberUsers.size();i++){
                counts+=projectMemberMgr.deleteProjectMember(request.getProjectId(),
                        memberUsers.get(i), PortalUtil.getCurrentUserName());
            }
        }
        return counts;
    }
    @Transactional
    public int changeProjectOwner(ProjectMemberRequest request){
        //判断项目是否存在
        projectService.queryProject(request.getProjectId());

        return projectMemberMgr.changeProjectOwner(request.getProjectId(),
                PortalUtil.getCurrentUserName(), request.getDstOwner(), PortalUtil.getCurrentUserName());
    }
}
