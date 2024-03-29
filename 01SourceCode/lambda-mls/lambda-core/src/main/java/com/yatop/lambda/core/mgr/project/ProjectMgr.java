package com.yatop.lambda.core.mgr.project;

import com.yatop.lambda.base.extend.mapper.ExtProjectMapper;
import com.yatop.lambda.base.extend.model.ExtProjectDetail;
import com.yatop.lambda.base.model.DwDataWarehouse;
import com.yatop.lambda.base.model.MwModelWarehouse;
import com.yatop.lambda.base.model.PrProject;
import com.yatop.lambda.base.model.PrProjectExample;
import com.yatop.lambda.core.enums.*;
import com.yatop.lambda.core.mgr.base.BaseMgr;
import com.yatop.lambda.core.exception.LambdaException;
import com.yatop.lambda.core.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProjectMgr extends BaseMgr {

    @Autowired
    ExtProjectMapper extProjectMapper;

    /*
    *
    *   插入新项目信息（代码、名称、数据库ID、模型库ID ...）
    *   返回插入记录
    *
    * */
    public PrProject insertProject(PrProject project, String operId) {
        if (DataUtil.isNull(project) ||
                project.isProjectCodeNotColoured() ||
                project.isProjectNameNotColoured() ||
                project.isDwIdNotColoured() ||
                project.isMwIdNotColoured() ||
                DataUtil.isEmpty(operId)) {
            throw new LambdaException(LambdaExceptionEnum.B_PROJECT_DEFAULT_ERROR, "Insert project info failed -- invalid insert data.", "无效插入数据");
        }
        if (existsProject(project.getProjectCode(), project.getProjectName(), null)) {
            throw new LambdaException(LambdaExceptionEnum.B_PROJECT_DEFAULT_ERROR, "Insert project info failed -- code or name conflict.", "代码或名称冲突");
        }
        PrProject insertProject = new PrProject();
        try {
            Date dtCurrentTime = SystemTimeUtil.getCurrentTime();
            insertProject.copyProperties(project);
            insertProject.setProjectIdColoured(false);
            if (insertProject.isCacheExpireDaysNotColoured())
                insertProject.setCacheExpireDays(SystemParameterUtil.find4Integer(SystemParameterEnum.PR_CACHE_DATA_EXPIRE_DAYS, -1));
            insertProject.setStatus(DataStatusEnum.NORMAL.getStatus());
            insertProject.setLastUpdateTime(dtCurrentTime);
            insertProject.setLastUpdateOper(operId);
            insertProject.setCreateTime(dtCurrentTime);
            insertProject.setCreateOper(operId);
            prProjectMapper.insertSelective(insertProject);
            return insertProject;
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.B_PROJECT_DEFAULT_ERROR, "Insert project info failed.", "插入项目信息失败", e);
        }
    }

    /*
     *
     *   逻辑删除项目信息
     *   返回删除数量
     *
     * */
    public int deleteProject(Long projectId, String operId) {
        if (DataUtil.isNull(projectId) || DataUtil.isEmpty(operId)) {
            throw new LambdaException(LambdaExceptionEnum.B_PROJECT_DEFAULT_ERROR, "Delete project info failed -- invalid delete condition.", "无效删除条件");
        }

        try {
            PrProject deleteProject = new PrProject();
            deleteProject.setProjectId(projectId);
            deleteProject.setStatus(DataStatusEnum.INVALID.getStatus());
            deleteProject.setLastUpdateTime(SystemTimeUtil.getCurrentTime());
            deleteProject.setLastUpdateOper(operId);
            return prProjectMapper.updateByPrimaryKeySelective(deleteProject);
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.B_PROJECT_DEFAULT_ERROR, "Delete project info failed.", "删除项目信息失败", e);
        }
    }

    /*
     *
     *   更新项目信息（数据仓库Id、模型仓库Id、名称、缓存数据过期天数、描述）
     *   返回更新数量
     *
     * */
    public int updateProject(PrProject project, String operId) {
        if (DataUtil.isNull(project) || DataUtil.isNull(project.getProjectId()) || DataUtil.isEmpty(operId)) {
            throw new LambdaException(LambdaExceptionEnum.B_PROJECT_DEFAULT_ERROR, "Update project info failed -- invalid update condition.", "无效更新条件");
        }

        if (project.isProjectNameNotColoured() &&
                project.isCacheExpireDaysNotColoured() &&
                project.isDescriptionNotColoured() &&
                project.isDwIdNotColoured() &&
                project.isMwIdNotColoured()) {
            throw new LambdaException(LambdaExceptionEnum.B_PROJECT_DEFAULT_ERROR, "Update project info failed -- invalid update data.", "无效更新数据");
        }

        if ((project.isProjectNameColoured()) &&
                existsProject(null, project.getProjectName(), project.getProjectId())) {
            throw new LambdaException(LambdaExceptionEnum.B_PROJECT_DEFAULT_ERROR, "Update project info failed -- code or name conflict.", "代码或名称冲突");
        }

        PrProject updateProject = new PrProject();
        try {
            updateProject.setProjectId(project.getProjectId());
            if (project.isProjectNameColoured())
                updateProject.setProjectName(project.getProjectName());
            if (project.isCacheExpireDaysColoured())
                updateProject.setCacheExpireDays(project.getCacheExpireDays());
            if (project.isDescriptionColoured())
                updateProject.setDescription(project.getDescription());
            if (project.isDwIdColoured())
                updateProject.setDwId(project.getDwId());
            if(project.isMwIdColoured())
                updateProject.setMwId(project.getMwId());
            updateProject.setLastUpdateTime(SystemTimeUtil.getCurrentTime());
            updateProject.setLastUpdateOper((operId));
            return prProjectMapper.updateByPrimaryKeySelective(updateProject);
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.B_PROJECT_DEFAULT_ERROR, "Update project info failed.", "更新项目信息失败", e);
        }
    }

    /*
     *
     *   查询项目信息（按ID）
     *   返回结果
     *
     * */
    public PrProject queryProject(Long id) {
        if (DataUtil.isNull(id)) {
            throw new LambdaException(LambdaExceptionEnum.B_PROJECT_DEFAULT_ERROR, "Query project info failed -- invalid query condition.", "无效查询条件");
        }

        PrProject project;
        try {
            project = prProjectMapper.selectByPrimaryKey(id);
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.B_PROJECT_DEFAULT_ERROR, "Query project info failed.", "查询项目信息失败", e);
        }

        if (DataUtil.isNull(project) || (project.getStatus() == DataStatusEnum.INVALID.getStatus()))
            throw new LambdaException(LambdaExceptionEnum.B_PROJECT_DEFAULT_ERROR, "Query project info failed -- invalid status or not found.", "项目信息不存在");

        return project;
    }

    /*
     *
     *   查询项目信息
     *   1.查询所有记录（关键字和用户都为null）
     *   2.按关键字查询（成员用户为null）
     *   3.按用户查询（关键字为null）
     *   4.关键字和用户混合查询
     *   返回结果集
     *
     * */
    public List<ExtProjectDetail> queryProject(String keyword, String user, PagerUtil pager) {

        try {
            PagerUtil.startPage(pager);
            String keywordLike = DataUtil.likeKeyword(keyword);

            //按用户查询
            if (DataUtil.isEmpty(keyword)) {
                return extProjectMapper.getProject4User(user, DataStatusEnum.NORMAL.getStatus());

                //关键字和用户混合查询
            } else {
                return extProjectMapper.getProject4UserByKeyword(keywordLike, user, DataStatusEnum.NORMAL.getStatus());
            }
        } catch (Throwable e) {
            PagerUtil.clearPage(pager);
            throw new LambdaException(LambdaExceptionEnum.B_PROJECT_DEFAULT_ERROR, "Query project info failed.", "查询项目信息失败", e);
        }
    }


    public List<PrProject> queryProject4CurrentUser(String user) {
        return extProjectMapper.getProject4Member(user, DataStatusEnum.NORMAL.getStatus());
    }

    /*
     *
     *   检查相同项目代码或名称是否已存在（可排除原ID）
     *   返回是否存在
     *
     * */
    public boolean existsProject(String code, String name, Long originalId) {
        if (DataUtil.isEmpty(code) && DataUtil.isEmpty(name))
            throw new LambdaException(LambdaExceptionEnum.B_PROJECT_DEFAULT_ERROR, "Check project exists failed -- invalid check condition.", "无效检查条件");

            try {
                PrProjectExample example = new PrProjectExample();
                if (DataUtil.isNotEmpty(code)) {
                    PrProjectExample.Criteria criteria = example.createCriteria().andProjectCodeEqualTo(code).andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
                    if (DataUtil.isNotNull(originalId))
                        criteria.andProjectIdNotEqualTo(originalId);
                    if (prProjectMapper.countByExample(example) > 0)
                        return true;
                }

                example.clear();
                if (DataUtil.isNotEmpty(name)) {
                    PrProjectExample.Criteria criteria = example.createCriteria().andProjectNameEqualTo(name).andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
                    if (DataUtil.isNotNull(originalId))
                        criteria.andProjectIdNotEqualTo(originalId);
                    if (prProjectMapper.countByExample(example) > 0)
                        return true;
                }

                return false;
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.B_PROJECT_DEFAULT_ERROR, "Check project exists failed.", "检查已存在项目失败", e);
        }
    }
}
