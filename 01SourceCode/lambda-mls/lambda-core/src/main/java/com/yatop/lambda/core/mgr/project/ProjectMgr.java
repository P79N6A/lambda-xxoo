package com.yatop.lambda.core.mgr.project;

import com.yatop.lambda.base.model.PrProject;
import com.yatop.lambda.base.model.PrProjectExample;
import com.yatop.lambda.core.enums.DataStatus;
import com.yatop.lambda.core.enums.SystemParameterEnum;
import com.yatop.lambda.core.exception.ProjectMgntException;
import com.yatop.lambda.core.mgr.base.BaseMgr;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.core.utils.PaginationUtil;
import com.yatop.lambda.core.utils.SystemParameterUtil;
import com.yatop.lambda.core.utils.SystemTimeUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProjectMgr extends BaseMgr {

    /*
    *
    *   插入新项目信息（代码、名称、数据库ID、模型库ID、描述）
    *
    * */
    public PrProject insertProject(PrProject prProject, String OperId) throws ProjectMgntException {
        if( DataUtil.isNull(prProject) ||
                DataUtil.isEmpty(prProject.getProjectCode()) ||
                DataUtil.isEmpty(prProject.getProjectName()) ||
                DataUtil.isNull(prProject.getDwId()) ||
                DataUtil.isNull(prProject.getMwId()) ||
                DataUtil.isEmpty(OperId) ) {
            throw new ProjectMgntException("Insert project info failed -- invalid input data.", "无效输入内容");
        }

        boolean isConfict;
        try {
            isConfict = existsProject(prProject.getProjectCode(), prProject.getProjectName());
        } catch (Throwable e) {
            throw new ProjectMgntException("Insert project info failed -- check exists project failed.", "检查已存在项目失败", e);
        }
        if(isConfict) {
            throw new ProjectMgntException("Insert project info failed -- code or name conflict.", "项目代码或名称冲突");
        }

        int affectRows;
        PrProject newProject = new PrProject();
        try {
            Date dtCurrentTime = SystemTimeUtil.getCurrentTime();
            BeanUtils.copyProperties(prProject, newProject);
            newProject.setProjectId(null);
            newProject.setCacheExipreDays(SystemParameterUtil.find4Integer(SystemParameterEnum.PR_CACHE_DATA_EXPIRE_DAYS, -1));
            newProject.setDescription(prProject.getDescription());
            newProject.setStatus(DataStatus.STATUS_NORMAL);
            newProject.setLastUpdateTime(dtCurrentTime);
            newProject.setLastUpdateOper(OperId);
            newProject.setCreateTime(dtCurrentTime);
            newProject.setCreateOper(OperId);

            affectRows = prProjectMapper.insertSelective(newProject);
            //return (affectRows == 1 ?  newProject : null);
        } catch (Throwable e) {
            throw new ProjectMgntException("Insert project info failed.", "新增项目信息失败", e);
        }

        if(affectRows != 1) {
            throw new ProjectMgntException("Insert project info failed -- no affect rows.", "新增项目信息失败");
        }

        return newProject;
    }

    /*
     *
     *   更新项目信息（代码、名称、临时数据过期天数、描述）
     *
     * */
    public int updateProject(PrProject prProject, String OperId) throws ProjectMgntException {
        if( DataUtil.isNull(prProject) ||
                DataUtil.isEmpty(prProject.getProjectCode()) ||
                DataUtil.isEmpty(prProject.getProjectName()) ||
                DataUtil.isNull(prProject.getCacheExipreDays()) ||
                DataUtil.isNull(prProject.getDescription()) ) {
            throw new ProjectMgntException("Update project info failed -- invalid input data.", "无效有效更新内容");
        }

        if(DataUtil.isEmpty(OperId) ) {

        }


        try {
            prProject.setStatus(null);

            prProjectMapper.updateByExample()
            return prProjectMapper.updateByPrimaryKeySelective(prProject);
        } catch (Throwable e) {
            throw new ProjectMgntException("Update project info failed.", e);
        }
    }

    public PrProject queryProjectById(Long projectId) throws ProjectMgntException {
        if(projectId == null)
            return null;

        try {
            return prProjectMapper.selectByPrimaryKey(projectId);
        } catch (Throwable e) {
            throw new ProjectMgntException("Query project info failed.", e);
        }
    }

    public List<PrProject> queryProjectByIds(List<Long> projectIds) throws ProjectMgntException {
        if(projectIds == null || projectIds.size() == 0)
            return null;

        try {
            PrProjectExample example = new PrProjectExample();
            example.createCriteria().andProjectIdIn(projectIds);
            return prProjectMapper.selectByExample(example);
        } catch (Throwable e) {
            throw new ProjectMgntException("Query project info failed.", e);
        }
    }

/*    public List<PrProject> queryProjects(String keywords, String OperId, PaginationUtil pager) throws ProjectMgntException {
        try {
            PrProjectExample example = new PrProjectExample();
            return prProjectMapper.selectByExample(example);
        } catch (Throwable e) {
            throw new ProjectMgntException("Query project info failed.", e);
        }
    }*/

    public boolean existsProject(String projectCode, String projectName) throws ProjectMgntException {
        if(DataUtil.isEmpty(projectCode) || DataUtil.isEmpty(projectCode))
            return false;

        try {
            Long existCount = -1L;
            PrProjectExample example = new PrProjectExample();

            if(DataUtil.isNotEmpty(projectCode)) {
                example.createCriteria().andProjectCodeEqualTo(projectCode).andStatusEqualTo(DataStatus.STATUS_NORMAL);
                existCount = prProjectMapper.countByExample(example);
                if(existCount > 0)
                    return true;
            }

            existCount = -1L;
            example.clear();

            if(DataUtil.isNotEmpty(projectCode)) {
                example.createCriteria().andProjectNameEqualTo(projectName).andStatusEqualTo(DataStatus.STATUS_NORMAL);
                existCount = prProjectMapper.countByExample(example);
                if(existCount > 0)
                    return true;
            }

            return false;
        } catch (Throwable e) {
            throw new ProjectMgntException("Check project exists failed.", "检查已存在项目失败", e);
        }
    }
}
