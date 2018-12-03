package com.yatop.lambda.core.mgr.project;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yatop.lambda.base.mapper.extend.ProjectMapper;
import com.yatop.lambda.base.model.PrProject;
import com.yatop.lambda.base.model.PrProjectExample;
import com.yatop.lambda.core.enums.DataStatus;
import com.yatop.lambda.core.enums.SystemParameterEnum;
import com.yatop.lambda.core.exception.LambdaException;
import com.yatop.lambda.core.mgr.base.BaseMgr;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.core.utils.PagerUtil;
import com.yatop.lambda.core.utils.SystemParameterUtil;
import com.yatop.lambda.core.utils.SystemTimeUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ProjectMgr extends BaseMgr {

    @Autowired
    ProjectMapper projectMapper;

    /*
    *
    *   插入新项目信息（代码、名称、数据库ID、模型库ID、描述）
    *
    * */
    public PrProject insertProject(PrProject prProject, String OperId) {
        if( DataUtil.isNull(prProject) ||
                !prProject.isProjectCodeColoured() ||
                !prProject.isProjectNameColoured() ||
                !prProject.isDwIdColoured() ||
                !prProject.isMwIdColoured() ||
                DataUtil.isEmpty(OperId) ) {
            throw new LambdaException("Insert project info failed -- invalid insert data.", "无效插入内容");
        }

        boolean isConflict;
        try {
            isConflict = existsProject(prProject.getProjectCode(), prProject.getProjectName(), null);
        } catch (Throwable e) {
            throw new LambdaException("Insert project info failed -- check exists project failed.", "检查已存在项目失败", e);
        }
        if(isConflict) {
            throw new LambdaException("Insert project info failed -- code or name conflict.", "项目代码或名称冲突");
        }

        PrProject insertProject = new PrProject();
        try {
            Date dtCurrentTime = SystemTimeUtil.getCurrentTime();
            BeanUtils.copyProperties(prProject, insertProject);
            insertProject.setProjectIdColoured(false);
            if(!insertProject.isCacheExpireDaysColoured())
                insertProject.setCacheExpireDays(SystemParameterUtil.find4Integer(SystemParameterEnum.PR_CACHE_DATA_EXPIRE_DAYS, -1));
            insertProject.setStatus(DataStatus.STATUS_NORMAL);
            insertProject.setLastUpdateTime(dtCurrentTime);
            insertProject.setLastUpdateOper(OperId);
            insertProject.setCreateTime(dtCurrentTime);
            insertProject.setCreateOper(OperId);

            prProjectMapper.insertSelective(insertProject);
        } catch (Throwable e) {
            throw new LambdaException("Insert project info failed.", "新增项目信息失败", e);
        }

        return insertProject;
    }


    /*
     *
     *   逻辑删除项目信息
     *
     * */
    public int deleteProjectByIds(List<Long> projectIds, String OperId) {
        if(DataUtil.isEmpty(projectIds) || DataUtil.isEmpty(OperId)){
            throw new LambdaException("Delete project info failed -- invalid query condition.", "无效删除条件");
        }

        try {
            int affectRows = 0;
            for(Long id : projectIds) {
                PrProject project = new PrProject();
                project.setProjectId(id);
                project.setStatus(DataStatus.STATUS_INVALID);
                project.setLastUpdateTime(SystemTimeUtil.getCurrentTime());
                project.setLastUpdateOper(OperId);
                affectRows += prProjectMapper.updateByPrimaryKeySelective(project);
            }

            return affectRows;
        } catch (Throwable e) {
            throw new LambdaException("Delete project info failed.", "删除项目信息失败", e);
        }
    }


    /*
     *
     *   物理删除项目信息
     *
     * */
    public int physicalDeleteProjectByIds(List<Long> projectIds) {
        if(DataUtil.isEmpty(projectIds)){
            throw new LambdaException("Physical delete project info failed -- invalid query condition.", "无效物理删除条件");
        }

        try {
            int affectRows = 0;
            for(Long id : projectIds) {
                affectRows += prProjectMapper.deleteByPrimaryKey(id);
            }

            return affectRows;
        } catch (Throwable e) {
            throw new LambdaException("Physical delete project info failed.", "物理删除项目信息失败", e);
        }
    }

    public int updateProjectById(PrProject prProject, String operId) {
        if( DataUtil.isNull(prProject) || !prProject.isProjectIdColoured() || DataUtil.isEmpty(operId)) {
            throw new LambdaException("Update project info failed -- invalid update condition.", "无效更新条件");
        }

        if(!prProject.isProjectCodeColoured() &&
            !prProject.isProjectNameColoured() &&
            !prProject.isCacheExpireDaysColoured() &&
            !prProject.isDescriptionColoured()) {
            throw new LambdaException("Update project info failed -- invalid update data.", "无效更新内容");
        }

        boolean isConflict;
        try {
            isConflict = existsProject(prProject.getProjectCode(), prProject.getProjectName(), prProject.getProjectId());
        } catch (Throwable e) {
            throw new LambdaException("Update project info failed -- check exists project failed.", "检查已存在项目失败", e);
        }
        if(isConflict) {
            throw new LambdaException("Update project info failed -- code or name conflict.", "项目代码或名称冲突");
        }

        PrProject updateProject = new PrProject();
        try {
                updateProject.setProjectId(prProject.getProjectId());
            if(prProject.isProjectCodeColoured())
                updateProject.setProjectCode(prProject.getProjectCode());
            if(prProject.isProjectNameColoured())
                updateProject.setProjectName(prProject.getProjectName());
            if(prProject.isCacheExpireDaysColoured())
                updateProject.setCacheExpireDays(prProject.getCacheExpireDays());
            if(prProject.isDescriptionColoured())
                updateProject.setDescription(prProject.getDescription());

            updateProject.setLastUpdateTime(SystemTimeUtil.getCurrentTime());
            updateProject.setLastUpdateOper((operId));

            return prProjectMapper.updateByPrimaryKeySelective(updateProject);
        } catch (Throwable e) {
            throw new LambdaException("Update project info failed.", "更新项目信息失败", e);
        }
    }

    public List<PrProject> queryProjectByIds(List<Long> projectIds) {
        if(DataUtil.isEmpty(projectIds)){
            throw new LambdaException("Query project info failed -- invalid query condition.", "无效查询条件");
        }

        try {
            List<PrProject> resultList = new ArrayList();
            for(Long id : projectIds) {
                PrProject project = prProjectMapper.selectByPrimaryKey(id);
                if(DataUtil.isNotNull(project) && project.getStatus() == DataStatus.STATUS_NORMAL)
                    resultList.add(project);
            }
            return resultList;
        } catch (Throwable e) {
            throw new LambdaException("Query project info failed.", "查询项目信息失败", e);
        }
    }

    /*
     *
     *   查询项目信息
     *   1.查询所有记录（关键字和用户都为null）
     *   2.按关键字查询
     *   3.按用户查询
     *   4.关键字和用户混合查询
     *
     * */
   public List<PrProject> queryProjectMixed(String keyword, String operId, PagerUtil pager) {

        try {
            //查询所有
            if(DataUtil.isEmpty(keyword) && DataUtil.isEmpty(operId)) {
                Page pageInfo = null;
                if(pager.isNeedPage()) {
                    pageInfo = PageHelper.startPage(pager.getPageNo(), pager.getPageSize(), pager.isNeedTotalCount());
                }
                PrProjectExample example = new PrProjectExample();
                example.createCriteria().andStatusEqualTo(DataStatus.STATUS_NORMAL);
                List<PrProject> list =  prProjectMapper.selectByExample(example);
                if(pager.isNeedTotalCount()) {
                    pager.setTotalCount(pageInfo.getTotal());
                }
                return list;
            }

            //按关键字查询
            if(DataUtil.isNotEmpty(keyword) && DataUtil.isEmpty(operId)) {
                PrProjectExample example = new PrProjectExample();
                example.createCriteria().andProjectCodeLike(keyword).andStatusEqualTo(DataStatus.STATUS_NORMAL);
                example.or(example.createCriteria().andProjectNameLike(keyword).andStatusEqualTo(DataStatus.STATUS_NORMAL));
                example.setOrderByClause("CREATE_TIME ASC");

                Page pageInfo = null;
                if(pager.isNeedPage()) {
                    pageInfo = PageHelper.startPage(pager.getPageNo(), pager.getPageSize(), pager.isNeedTotalCount());
                }
                List<PrProject> list = prProjectMapper.selectByExample(example);
                if(pager.isNeedTotalCount()) {
                    pager.setTotalCount(pageInfo.getTotal());
                }
                return list;
            }

            //按用户查询
            if(DataUtil.isEmpty(keyword)) {
                Page pageInfo = null;
                if(pager.isNeedPage()) {
                    pageInfo = PageHelper.startPage(pager.getPageNo(), pager.getPageSize(), pager.isNeedTotalCount());
                }
                List<PrProject> list = projectMapper.getProjectMixed4OperId(DataUtil.trimToNull(operId), DataStatus.STATUS_NORMAL);
                if(pager.isNeedTotalCount()) {
                    pager.setTotalCount(pageInfo.getTotal());
                }
                return list;

             //关键字和用户混合查询
            } else {
                Page pageInfo = null;
                if(pager.isNeedPage()) {
                    pageInfo = PageHelper.startPage(pager.getPageNo(), pager.getPageSize(), pager.isNeedTotalCount());
                }
                List<PrProject> list = projectMapper.getProjectMixed4Keyword(keyword, operId, DataStatus.STATUS_NORMAL);
                if(pager.isNeedTotalCount()) {
                    pager.setTotalCount(pageInfo.getTotal());
                }
                return list;
            }

        } catch (Throwable e) {
            throw new LambdaException("Query project info failed.", "查询项目信息失败", e);
        }
    }

    public boolean existsProject(String projectCode, String projectName, Long originalProjectId)  {
        if(DataUtil.isEmpty(projectCode) || DataUtil.isEmpty(projectCode))
            return false;

        try {
            Long existCount;
            PrProjectExample example = new PrProjectExample();
            if(DataUtil.isNotEmpty(projectCode)) {
                PrProjectExample.Criteria criteria = example.createCriteria().andProjectCodeEqualTo(projectCode).andStatusEqualTo(DataStatus.STATUS_NORMAL);
                if(DataUtil.isNotNull(originalProjectId))
                    criteria.andProjectIdNotEqualTo(originalProjectId);
                existCount = prProjectMapper.countByExample(example);
                if(existCount > 0)
                    return true;
            }

            example.clear();
            if(DataUtil.isNotEmpty(projectCode)) {
                PrProjectExample.Criteria criteria = example.createCriteria().andProjectNameEqualTo(projectName).andStatusEqualTo(DataStatus.STATUS_NORMAL);
                if(DataUtil.isNotNull(originalProjectId))
                    criteria.andProjectIdNotEqualTo(originalProjectId);
                existCount = prProjectMapper.countByExample(example);
                if(existCount > 0)
                    return true;
            }

            return false;
        } catch (Throwable e) {
            throw new LambdaException("Check project exists failed.", "检查已存在项目失败", e);
        }
    }
}
