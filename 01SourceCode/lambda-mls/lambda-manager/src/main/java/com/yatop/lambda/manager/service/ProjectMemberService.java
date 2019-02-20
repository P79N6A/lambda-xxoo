package com.yatop.lambda.manager.service;

import com.yatop.lambda.base.extend.mapper.ExtProjectMemberMapper;
import com.yatop.lambda.base.extend.model.ExtProjectMemberDetail;
import com.yatop.lambda.base.model.PrProjectMember;
import com.yatop.lambda.core.enums.LambdaExceptionEnum;
import com.yatop.lambda.core.enums.ProjectRoleEnum;
import com.yatop.lambda.core.exception.LambdaException;
import com.yatop.lambda.core.mgr.project.ProjectMemberMgr;
import com.yatop.lambda.core.utils.PagerUtil;
import com.yatop.lambda.manager.api.request.member.MemberRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class ProjectMemberService {

    @Autowired
    private ExtProjectMemberMapper extProjectMemberMapper;

    @Autowired
    private ProjectMemberMgr projectMemberMgr;

    public List<ExtProjectMemberDetail> getProjectMemberList( MemberRequest request) {
        PagerUtil pager=new PagerUtil();
       try{
           pager.setPageNum(request.getPageNum());
           pager.setPageSize(request.getPageSize());
           PagerUtil.startPage(pager);
           if(request.getMemberUser()==null){
               request.setMemberUser("");
           }
           String memberUser="%"+request.getMemberUser()+"%";
           return this.extProjectMemberMapper.queryProjectMemberList(request.getProjectId(),memberUser);
       }catch (Exception e){
           PagerUtil.clearPage(pager);
           throw new LambdaException(LambdaExceptionEnum.B_PROJECT_DEFAULT_ERROR,"查询项目成员列表异常",e);
       }
    }

    /**
     *
     * @param request 请求 ，项目ID，成员用户列表，操作用户
     * 项目成员状态，最近更新时间，最近更新用户，创建时间，创建用户。
     */

    public int addProjectMembers(MemberRequest request) {
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
                    projectMemberMgr.insertProjectMember(prProjectMember,request.getOperUser());
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

    public int deleteProjectMembers(MemberRequest request) {
        List<String> memberUsers=request.getMemberUsers();
        int counts=0;
        if(memberUsers!=null){
            for(int i=0;i<memberUsers.size();i++){
                counts+=projectMemberMgr.deleteProjectMember(request.getProjectId(),
                        memberUsers.get(i),request.getOperUser());
            }
        }
        return counts;
    }
    public int changeProjectOwner(MemberRequest request){
        return projectMemberMgr.changeProjectOwner(request.getProjectId(),
                request.getSrcOwner(),request.getDstOwner(),request.getOperUser());
    }
}