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

import com.yatop.lambda.base.extend.model.ExtProjectDetail;
import com.yatop.lambda.base.mapper.DwDataWarehouseMapper;
import com.yatop.lambda.base.mapper.MwModelWarehouseMapper;
import com.yatop.lambda.base.model.DwDataWarehouse;
import com.yatop.lambda.base.model.MwModelWarehouse;
import com.yatop.lambda.base.model.PrProject;
import com.yatop.lambda.base.model.PrProjectMember;
import com.yatop.lambda.core.enums.*;
import com.yatop.lambda.core.mgr.model.ModelMgr;
import com.yatop.lambda.core.mgr.model.ModelWarehouseMgr;
import com.yatop.lambda.core.mgr.project.ProjectMemberMgr;
import com.yatop.lambda.core.mgr.project.ProjectMgr;
import com.yatop.lambda.core.mgr.table.DataTableMgr;
import com.yatop.lambda.core.mgr.table.DataWarehouseMgr;
import com.yatop.lambda.core.utils.WorkDirectoryUtil;
import com.yatop.lambda.manager.api.request.project.ProjectRequest;
import com.yatop.lambda.portal.common.utils.PortalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class ProjectService {

    @Autowired
    private DwDataWarehouseMapper dwDataWarehouseMapper;
    @Autowired
    private MwModelWarehouseMapper mwModelWarehouseMapper;
    @Autowired
    private ProjectMgr projectMgr;
    @Autowired
    private DataWarehouseMgr dataWarehouseMgr;
    @Autowired
    private ModelWarehouseMgr modelWarehouseMgr;
    @Autowired
    private ProjectMemberMgr projectMemberMgr;

    public PrProject addProject(ProjectRequest vo) {
        String currentUsername = PortalUtil.getCurrentUser().getUsername();
        PrProject project = new PrProject();
        project.setProjectCode(vo.getProjectCode());
        project.setProjectName(vo.getProjectName());
        project.setDescription(vo.getProjectDesc());
        project.setMwId(-1L);
        project.setDwId(-1L);
        project = projectMgr.insertProject(project, currentUsername);

        DwDataWarehouse dataWarehouse = new DwDataWarehouse();
        MwModelWarehouse modelWarehouse = new MwModelWarehouse();

        dataWarehouse.setDwCode("$"+project.getProjectId());
        dataWarehouse.setDwName(project.getProjectName());
        dataWarehouse.setDwType(DataWarehouseTypeEnum.PROJECT.getType());
        dataWarehouse.setOwnerProjectId(project.getProjectId());
        dataWarehouse.setDataDfsDir("-1");
        dataWarehouse.setDataLocalDir("-1");
        dataWarehouse = dataWarehouseMgr.insertDataWarehouse(dataWarehouse, currentUsername);
        dataWarehouse.setDataDfsDir(WorkDirectoryUtil.getDataWarehouseDfsDirectory(dataWarehouse.getDwId()));
        dataWarehouse.setDataLocalDir(WorkDirectoryUtil.getDataWarehouseLocalDirectory(dataWarehouse.getDwId()));
        dataWarehouseMgr.updateDataWarehouse(dataWarehouse, currentUsername);

        modelWarehouse.setMwCode("$"+project.getProjectId());
        modelWarehouse.setMwName(project.getProjectName());
        modelWarehouse.setMwType(ModelWarehouseTypeEnum.PROJECT.getType());
        modelWarehouse.setOwnerProjectId(project.getProjectId());
        modelWarehouse.setModelDfsDir("-1");
        modelWarehouse.setModelLocalDir("-1");
        modelWarehouse = modelWarehouseMgr.insertModelWarehouse(modelWarehouse, currentUsername);
        modelWarehouse.setModelDfsDir(WorkDirectoryUtil.getModelWarehouseDfsDirectory(modelWarehouse.getMwId()));
        modelWarehouse.setModelLocalDir(WorkDirectoryUtil.getModelWarehouseLocalDirectory(modelWarehouse.getMwId()));
        modelWarehouseMgr.updateModelWarehouse(modelWarehouse, currentUsername);

        project.setMwId(modelWarehouse.getMwId());
        project.setDwId(dataWarehouse.getDwId());
        projectMgr.updateProject(project, currentUsername);

        PrProjectMember prProjectMember=new PrProjectMember();
        prProjectMember.setProjectId(project.getProjectId());
        prProjectMember.setMemberUser(currentUsername);
        prProjectMember.setProjectRole(ProjectRoleEnum.PROJECT_OWNER.getRole());
        projectMemberMgr.insertProjectMember(prProjectMember, currentUsername);
        return project;
    }


    public int deleteProject(Long projectId) {
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

    public List<ExtProjectDetail> queryProjectExt(ProjectRequest vo) {
        return projectMgr.queryProject(vo.getKeyword(), PortalUtil.getCurrentUser().getUsername(), vo);
    }

    public List<PrProject> queryProject4CurrentUser() {
        return projectMgr.queryProject4CurrentUser(PortalUtil.getCurrentUser().getUsername());
    }

    /**
     * 手动清理临时表
     * @return
     */
    public String clearTemporaryTable(Date date) {
        return date+" 清理成功！";
    }
}
