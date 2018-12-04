package com.yatop.lambda.core.mgr.project;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yatop.lambda.base.mapper.extend.ProjectMapper;
import com.yatop.lambda.base.model.PrProject;
import com.yatop.lambda.base.model.PrProjectExample;
import com.yatop.lambda.core.enums.DataStatusEnum;
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

import java.util.Date;
import java.util.List;

@Service
public class ProjectMgr extends BaseMgr {

    @Autowired
    ProjectMapper projectMapper;

    /*
    *
    *   插入新项目信息（代码、名称、数据库ID、模型库ID、描述）
    *   返回插入记录
    *
    * */
    public PrProject insertProject(PrProject prProject, String operId) {
        if( DataUtil.isNull(prProject) ||
                !prProject.isProjectCodeColoured() ||
                !prProject.isProjectNameColoured() ||
                !prProject.isDwIdColoured() ||
                !prProject.isMwIdColoured() ||
                DataUtil.isEmpty(operId) ) {
            throw new LambdaException("Insert project info failed -- invalid insert data.", "无效插入数据");
        }

        if(existsProject(prProject.getProjectCode(), prProject.getProjectName(), null)) {
            throw new LambdaException("Insert project info failed -- code or name conflict.", "项目代码或名称冲突");
        }

        PrProject insertProject = new PrProject();
        try {
            Date dtCurrentTime = SystemTimeUtil.getCurrentTime();
            BeanUtils.copyProperties(prProject, insertProject);
            insertProject.setProjectIdColoured(false);
            if(!insertProject.isCacheExpireDaysColoured())
                insertProject.setCacheExpireDays(SystemParameterUtil.find4Integer(SystemParameterEnum.PR_CACHE_DATA_EXPIRE_DAYS, -1));
            insertProject.setStatus(DataStatusEnum.NORMAL.getStatus());
            insertProject.setLastUpdateTime(dtCurrentTime);
            insertProject.setLastUpdateOper(operId);
            insertProject.setCreateTime(dtCurrentTime);
            insertProject.setCreateOper(operId);
            prProjectMapper.insertSelective(insertProject);
            return insertProject;
        } catch (Throwable e) {
            throw new LambdaException("Insert project info failed.", "插入项目信息失败", e);
        }
    }

    /*
     *
     *   逻辑删除项目信息
     *   返回删除数量
     *
     * */
    public int deleteProject(Long projectId, String operId) {
        if(DataUtil.isNull(projectId) || DataUtil.isEmpty(operId)){
            throw new LambdaException("Delete project info failed -- invalid query condition.", "无效删除条件");
        }

        try {
            PrProject deleteProject = new PrProject();
            deleteProject.setProjectId(projectId);
            deleteProject.setStatus(DataStatusEnum.INVALID.getStatus());
            deleteProject.setLastUpdateTime(SystemTimeUtil.getCurrentTime());
            deleteProject.setLastUpdateOper(operId);
            return prProjectMapper.updateByPrimaryKeySelective(deleteProject);
        } catch (Throwable e) {
            throw new LambdaException("Delete project info failed.", "删除项目信息失败", e);
        }
    }

    /*
     *
     *   更新项目信息（代码、名称、缓存数据过期天数、描述）
     *   返回更新数量
     *
     * */
    public int updateProject(PrProject prProject, String operId) {
        if( DataUtil.isNull(prProject) || !prProject.isProjectIdColoured() || DataUtil.isEmpty(operId)) {
            throw new LambdaException("Update project info failed -- invalid update condition.", "无效更新条件");
        }

        if(!prProject.isProjectCodeColoured() &&
            !prProject.isProjectNameColoured() &&
            !prProject.isCacheExpireDaysColoured() &&
            !prProject.isDescriptionColoured()) {
            throw new LambdaException("Update project info failed -- invalid update data.", "无效更新数据");
        }

        if(existsProject(prProject.getProjectCode(), prProject.getProjectName(), prProject.getProjectId())) {
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

    /*
     *
     *   查询项目信息（按ID）
     *   返回结果集
     *
     * */
    private PrProject queryProject(Long projectId) {
        if(DataUtil.isNull(projectId)){
            throw new LambdaException("Query project info failed -- invalid query condition.", "无效查询条件");
        }

        try {
            PrProject project = prProjectMapper.selectByPrimaryKey(projectId);
            if(DataUtil.isNull(project) || (project.getStatus() == DataStatusEnum.INVALID.getStatus()))
                return null;

            return project;
        } catch (Throwable e) {
            throw new LambdaException("Query project info failed.", "查询项目信息失败", e);
        }
    }

    /*
     *
     *   查询项目信息（按用户）
     *   返回结果集
     *
     * */
    public List<PrProject> queryProjectByUser(String user, PagerUtil pager) {
        if(DataUtil.isEmpty(user))
            throw new LambdaException("Query project failed -- invalid query condition.", "无效查询条件");

        return queryProjectExt(null, user, pager);
    }

    /*
     *
     *   查询项目信息（按关键字）
     *   返回结果集
     *
     * */
    public List<PrProject> queryProjectByKeyword(String keyword, PagerUtil pager) {
        if(DataUtil.isEmpty(keyword))
            throw new LambdaException("Query project failed -- invalid query condition.", "无效查询条件");

        return queryProjectExt(keyword, null, pager);
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
    private List<PrProject> queryProjectExt(String keyword, String user, PagerUtil pager) {

        try {
            String keywordLike = "%" + keyword + "%";
            Page pageInfo = null;
            if(DataUtil.isNotNull(pager) && pager.isNeedPage()) {
                pageInfo = PageHelper.startPage(pager.getPageNo(), pager.getPageSize(), pager.isNeedTotalCount());
            }
            List<PrProject> resultList = null;

            //查询所有
            if(DataUtil.isEmpty(keyword) && DataUtil.isEmpty(user)) {
                PrProjectExample example = new PrProjectExample();
                example.createCriteria().andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
                resultList =  prProjectMapper.selectByExample(example);
            }

            //按关键字查询
            else if(DataUtil.isNotEmpty(keyword) && DataUtil.isEmpty(user)) {
                PrProjectExample example = new PrProjectExample();
                PrProjectExample.Criteria cond1 = example.createCriteria().andProjectCodeLike(keywordLike).andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
                PrProjectExample.Criteria cond2 = example.or().andProjectNameLike(keywordLike).andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
                example.setOrderByClause("CREATE_TIME ASC");
                resultList = prProjectMapper.selectByExample(example);
            }

            //按用户查询
            else if(DataUtil.isEmpty(keyword)) {
                resultList = projectMapper.getProject4User(user, DataStatusEnum.NORMAL.getStatus());

             //关键字和用户混合查询
            } else {
                resultList = projectMapper.getProjectMixed4Keyword(keywordLike, user, DataStatusEnum.NORMAL.getStatus());
            }

            if(DataUtil.isNotNull(pager) && pager.isNeedTotalCount()) {
                pager.setTotalCount(pageInfo.getTotal());
            }
            return resultList;
        } catch (Throwable e) {
            if(DataUtil.isNotNull(pager) && pager.isNeedPage()) {
                PageHelper.clearPage();
            }
            throw new LambdaException("Query project info failed.", "查询项目信息失败", e);
        }
    }

    /*
     *
     *   检查相同项目代码或名称是否已存在（可排除原ID）
     *   返回是否存在
     *
     * */
    public boolean existsProject(String projectCode, String projectName, Long originalProjectId)  {
        if(DataUtil.isEmpty(projectCode) && DataUtil.isEmpty(projectCode))
            throw new LambdaException("Check project exists failed -- invalid check condition.", "无效检查条件");

        try {
            Long existCount;
            PrProjectExample example = new PrProjectExample();
            if(DataUtil.isNotEmpty(projectCode)) {
                PrProjectExample.Criteria criteria = example.createCriteria().andProjectCodeEqualTo(projectCode).andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
                if(DataUtil.isNotNull(originalProjectId))
                    criteria.andProjectIdNotEqualTo(originalProjectId);
                existCount = prProjectMapper.countByExample(example);
                if(existCount > 0)
                    return true;
            }

            example.clear();
            if(DataUtil.isNotEmpty(projectName)) {
                PrProjectExample.Criteria criteria = example.createCriteria().andProjectNameEqualTo(projectName).andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
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
