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

import com.yatop.lambda.base.extend.mapper.ExtProjectMapper;
import com.yatop.lambda.base.model.PrProject;
import com.yatop.lambda.core.mgr.project.ProjectMgr;
import com.yatop.lambda.core.utils.PagerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProjectService {
    /*@Autowired
    private ExtProjectMapper extProjectMapper;

    @Autowired
    private ProjectMgr projectMgr;

    public PrProject addProject(String projectCode, String projectName,
                                String projectDesc, String operUser) {
        PrProject project = new PrProject();
        project.setProjectCode(projectCode);
        project.setProjectName(projectName);
        project.setDescription(projectDesc);
        project.setDwId(999L);
        project.setMwId(999L);
        return projectMgr.insertProject(project, operUser);
    }

    public int deleteProject(Long projectId, String operUser){
        return projectMgr.deleteProject(projectId, operUser);
    }

    public int updateProject(Long projectId, String projectCode, String projectName,
                             String projectDesc, Integer cacheExpireDays, String operUser) {
        PrProject project = new PrProject();
        project.setProjectId(projectId);
        project.setProjectCode(projectCode);
        project.setProjectName(projectName);
        project.setDescription(projectDesc);
        project.setCacheExpireDays(cacheExpireDays);
        return projectMgr.updateProject(project, operUser);
    }

    public PrProject queryProject(Long projectId) {
        return projectMgr.queryProject(projectId);
    }

    public boolean existsProject(String projectCode, String projectName, Long projectId) {
        return projectMgr.existsProject(projectCode, projectName, projectId);
    }

    public List<PrProject> queryProjectExt(Integer pageNum, Integer pageSize, String keyword, String operUser) {
        PagerUtil pager = new PagerUtil(pageNum, pageSize);
        return projectMgr.queryProjectExt(keyword, operUser, pager);
    }*/

}
