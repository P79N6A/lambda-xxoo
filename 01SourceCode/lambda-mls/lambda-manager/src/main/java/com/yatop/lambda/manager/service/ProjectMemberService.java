package com.yatop.lambda.manager.service;

import com.yatop.lambda.base.extend.mapper.ExtProjectMemberMapper;
import com.yatop.lambda.base.extend.model.ExtProjectMemberDetail;
import com.yatop.lambda.core.mgr.project.ProjectMemberMgr;
import com.yatop.lambda.core.utils.PagerUtil;
import com.yatop.lambda.manager.api.request.project.ProjectRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class ProjectMemberService {

    private static Logger log = LoggerFactory.getLogger(ProjectMemberService.class);

    @Autowired
    private ExtProjectMemberMapper extProjectMemberMapper;

    @Autowired
    private ProjectMemberMgr projectMemberMgr;

    public List<ExtProjectMemberDetail> getProjectMemberList(ProjectRequest request) {
       try{
           PagerUtil.startPage(request);
           return this.extProjectMemberMapper.queryProjectMemberList(request.getProjectId());
       }catch (Exception e){
           PagerUtil.clearPage(request);
           //this.log.error("error", e);
           //return new ArrayList<>();
           throw e;
       }
    }

    /**
     *
     * @param prProjectMember 项目成员对象
     * 项目成员状态，最近更新时间，最近更新用户，创建时间，创建用户。
     */

    /*public void addProjectMember(PrProjectMember prProjectMember) {
        User user=(User) SecurityUtils.getSubject().getPrincipal();
        projectMemberMgr.insertProjectMember(prProjectMember,user.getUsername());
    }*/

    /**
     * 逻辑上删除项目成员
     * 设置项目成员表状态为失效
     * @param prProjectMember 项目成员对象
     * @return
     */

    /*public int deleteProjectMember(PrProjectMember prProjectMember) {
        User user=(User) SecurityUtils.getSubject().getPrincipal();
        return projectMemberMgr.deleteProjectMember(prProjectMember.getProjectId(),
                prProjectMember.getMemberUser(),user.getUsername());
    }*/
}
