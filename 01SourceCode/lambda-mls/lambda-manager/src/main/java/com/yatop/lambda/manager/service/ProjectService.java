/**
 * Copyright (C), 2016-2019, 杭州雅拓信息科技有限公司
 * FileName: ProjectService
 * Author:   Administrator
 * Date:     2019/2/13 16:48
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yatop.lambda.manager.service;

import com.yatop.lambda.base.model.PrProject;
import com.yatop.lambda.core.mgr.project.ProjectMgr;
import com.yatop.lambda.manager.api.request.project.ProjectRequest;
import com.yatop.lambda.portal.common.utils.PortalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProjectService {
//    @Autowired
//    private ExtProjectMapper extProjectMapper;

    @Autowired
    private ProjectMgr projectMgr;

    public PrProject addProject(ProjectRequest vo) {
        PrProject project = new PrProject();
        project.setProjectCode(vo.getProjectCode());
        project.setProjectName(vo.getProjectName());
        project.setDescription(vo.getProjectDesc());
        //TODO 创建项目下模型仓库, 表仓库
        project.setDwId(999L);
        project.setMwId(999L);
        return projectMgr.insertProject(project, PortalUtil.getCurrentUser().getUsername());
    }


    public int deleteProject(Long projectId){
        return projectMgr.deleteProject(projectId, PortalUtil.getCurrentUser().getUsername());
    }

    public int updateProject(ProjectRequest vo) {
      PrProject project = new PrProject();
      project.setProjectId(vo.getProjectId());
      project.setProjectCode(vo.getProjectCode());
      project.setProjectName(vo.getProjectName());
      project.setDescription(vo.getProjectDesc());
      project.setCacheExpireDays(vo.getCacheExpireDays());
      return projectMgr.updateProject(project, PortalUtil.getCurrentUser().getUsername());
    }

    public PrProject queryProject(Long projectId) {
        return projectMgr.queryProject(projectId);
    }

    public boolean existsProject(ProjectRequest vo) {
        return projectMgr.existsProject(vo.getProjectCode(), vo.getProjectName(), vo.getProjectId());
    }

    public List<PrProject> queryProjectExt(ProjectRequest vo) {
        return projectMgr.queryProject(vo.getKeyword(), PortalUtil.getCurrentUser().getUsername(), vo);
    }

}
