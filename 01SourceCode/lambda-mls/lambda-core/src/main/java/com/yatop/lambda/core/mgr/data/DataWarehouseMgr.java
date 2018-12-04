package com.yatop.lambda.core.mgr.data;

import com.yatop.lambda.base.model.DwDataWarehouse;
import com.yatop.lambda.base.model.DwDataWarehouseExample;
import com.yatop.lambda.core.enums.DataStatusEnum;
import com.yatop.lambda.core.enums.DataWarehouseTypeEnum;
import com.yatop.lambda.core.exception.LambdaException;
import com.yatop.lambda.core.mgr.base.BaseMgr;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.core.utils.SystemTimeUtil;
import org.springframework.beans.BeanUtils;

import java.util.Date;
import java.util.List;

public class DataWarehouseMgr extends BaseMgr {

    /*
     *
     *   插入新数据仓库信息（代码、名称、类型、所属项目ID、DFS数据目录、本地数据目录）
     *   返回插入记录
     *
     * */
    public DwDataWarehouse insertDataWarehouse(DwDataWarehouse dwWarehouse, String operId) {
        if( DataUtil.isNull(dwWarehouse) ||
                !dwWarehouse.isDwCodeColoured() ||
                !dwWarehouse.isDwNameColoured() ||
                !dwWarehouse.isDwTypeColoured() ||
                !dwWarehouse.isOwnerProjectIdColoured() ||
                !dwWarehouse.isDataDfsDirColoured() ||
                !dwWarehouse.isDataLocalDirColoured() ||
                DataUtil.isEmpty(operId) ) {
            throw new LambdaException("Insert data warehouse info failed -- invalid insert data.", "无效插入数据");
        }

        if(dwWarehouse.getDwType() == DataWarehouseTypeEnum.PUBLIC.getType()) {
            throw new LambdaException("Insert data warehouse info failed -- public data warehouse not support.", "不支持公共数据库");
        }

        if(existsDataWarehouse(dwWarehouse.getDwCode(), dwWarehouse.getDwName(), null)) {
            throw new LambdaException("Insert data warehouse info failed -- code or name conflict.", "数据库代码或名称冲突");
        }

        DwDataWarehouse insertDwWarehouse = new DwDataWarehouse();
        try {
            Date dtCurrentTime = SystemTimeUtil.getCurrentTime();
            BeanUtils.copyProperties(dwWarehouse, insertDwWarehouse);
            insertDwWarehouse.setDwIdColoured(false);
            insertDwWarehouse.setStatus(DataStatusEnum.NORMAL.getStatus());
            insertDwWarehouse.setLastUpdateTime(dtCurrentTime);
            insertDwWarehouse.setLastUpdateOper(operId);
            insertDwWarehouse.setCreateTime(dtCurrentTime);
            insertDwWarehouse.setCreateOper(operId);
            dwDataWarehouseMapper.insertSelective(insertDwWarehouse);
            return insertDwWarehouse;
        } catch (Throwable e) {
            throw new LambdaException("Insert data warehouse info failed.", "插入数据库信息失败", e);
        }
    }

    /*
     *
     *   逻辑删除数据仓库信息
     *   返回删除数量
     *
     * */
    public int deleteDataWarehouse(Long warehouseId, String operId) {
        if(DataUtil.isNull(warehouseId) || DataUtil.isEmpty(operId)){
            throw new LambdaException("Delete data warehouse info failed -- invalid query condition.", "无效删除条件");
        }

        try {
            DwDataWarehouse deleteDataWarehouse = new DwDataWarehouse();
            deleteDataWarehouse.setDwId(warehouseId);
            deleteDataWarehouse.setStatus(DataStatusEnum.INVALID.getStatus());
            deleteDataWarehouse.setLastUpdateTime(SystemTimeUtil.getCurrentTime());
            deleteDataWarehouse.setLastUpdateOper(operId);
            return dwDataWarehouseMapper.updateByPrimaryKeySelective(deleteDataWarehouse);
        } catch (Throwable e) {
            throw new LambdaException("Delete data warehouse info failed.", "删除数据库信息失败", e);
        }
    }

    /*
     *
     *   更新数据仓库信息（代码、名称、缓存数据过期天数、描述）
     *   返回更新数量
     *
     * */
    public int updateDataWarehouse(DwDataWarehouse dwWarehouse, String operId) {
        if( DataUtil.isNull(dwWarehouse) || !dwWarehouse.isDwIdColoured() || DataUtil.isEmpty(operId)) {
            throw new LambdaException("Update data warehouse info failed -- invalid update condition.", "无效更新条件");
        }

        if(!dwWarehouse.isDwCodeColoured() &&
                !dwWarehouse.isDwNameColoured()&&
                !dwWarehouse.isDataDfsDirColoured() &&
                !dwWarehouse.isDataLocalDirColoured() &&
                !dwWarehouse.isDescriptionColoured()) {
            throw new LambdaException("Update data warehouse info failed -- invalid update data.", "无效更新内容");
        }

        boolean isConflict;
        //try {
        isConflict = existsProject(prProject.getProjectCode(), prProject.getProjectName(), prProject.getProjectId());
        //} catch (LambdaException e) {
        //    throw new LambdaException("Update data warehouse info failed -- check exists project failed.", "检查已存在项目失败", e);
        //}
        if(isConflict) {
            throw new LambdaException("Update data warehouse info failed -- code or name conflict.", "项目代码或名称冲突");
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
            throw new LambdaException("Update data warehouse info failed.", "更新项目信息失败", e);
        }
    }

    /*
     *
     *   查询正常状态项目信息（按ID）
     *   返回结果集
     *
     * */
    public List<PrProject> queryProjectByIds(List<Long> projectIds) {
        return queryProjectByIds(projectIds, DataStatusCondEnum.NORMAL_STATUS);
    }

    /*
     *
     *   查询项目信息（按ID、数据状态）
     *   返回结果集
     *
     * */
    private List<PrProject> queryProjectByIds(List<Long> projectIds, DataStatusCondEnum dataStatusCond) {
        if(DataUtil.isEmpty(projectIds)){
            throw new LambdaException("Query data warehouse info failed -- invalid query condition.", "无效查询条件");
        }

        try {
            List<PrProject> resultList = new ArrayList();
            for(Long id : projectIds) {
                PrProject project = prProjectMapper.selectByPrimaryKey(id);
                if(DataUtil.isNotNull(project) && (dataStatusCond.isAllStatus() || project.getStatus() == dataStatusCond.getCondition()))
                    resultList.add(project);
            }
            return resultList;
        } catch (Throwable e) {
            throw new LambdaException("Query data warehouse info failed.", "查询项目信息失败", e);
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

        return queryProjectMixed(null, user, pager);
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

        return queryProjectMixed(keyword, null, pager);
    }

    /*
     *
     *   查询正常状态项目信息
     *   1.查询所有记录（关键字和用户都为null）
     *   2.按关键字查询（用户为null）
     *   3.按用户查询（关键字为null）
     *   4.关键字和用户混合查询
     *   返回结果集
     *
     * */
    public List<PrProject> queryProjectMixed(String keyword, String user, PagerUtil pager) {
        return queryProjectMixed(keyword, user, pager, DataStatusCondEnum.NORMAL_STATUS);
    }

    /*
     *
     *   查询项目信息（可选数据状态）
     *   1.查询所有记录（关键字和用户都为null）
     *   2.按关键字查询（成员用户为null）
     *   3.按用户查询（关键字为null）
     *   4.关键字和用户混合查询
     *   返回结果集
     *
     * */
    private List<PrProject> queryProjectMixed(String keyword, String user, PagerUtil pager, DataStatusCondEnum dataStatusCond) {

        try {
            String keywordLike = "%" + keyword + "%";
            Page pageInfo = null;
            if(DataUtil.isNotNull(pager) && pager.isNeedPage()) {
                pageInfo = PageHelper.startPage(pager.getPageNo(), pager.getPageSize(), pager.isNeedTotalCount());
            }
            List<PrProject> list = null;

            //查询所有
            if(DataUtil.isEmpty(keyword) && DataUtil.isEmpty(user)) {
                PrProjectExample example = new PrProjectExample();
                if(!dataStatusCond.isAllStatus())
                    example.createCriteria().andStatusEqualTo(dataStatusCond.getCondition());
                list =  prProjectMapper.selectByExample(example);
            }

            //按关键字查询
            else if(DataUtil.isNotEmpty(keyword) && DataUtil.isEmpty(user)) {
                PrProjectExample example = new PrProjectExample();
                PrProjectExample.Criteria cond1 = example.createCriteria().andProjectCodeLike(keywordLike);
                if(!dataStatusCond.isAllStatus())
                    cond1.andStatusEqualTo(dataStatusCond.getCondition());


                PrProjectExample.Criteria cond2 = example.or().andProjectNameLike(keywordLike);
                if(!dataStatusCond.isAllStatus())
                    cond2.andStatusEqualTo(dataStatusCond.getCondition());

                example.setOrderByClause("CREATE_TIME ASC");
                list = prProjectMapper.selectByExample(example);
            }

            //按用户查询
            else if(DataUtil.isEmpty(keyword)) {
                list = projectMapper.getProject4OperId(user, dataStatusCond.getCondition());

                //关键字和用户混合查询
            } else {
                list = projectMapper.getProjectMixed4Keyword(keywordLike, user, dataStatusCond.getCondition());
            }

            if(DataUtil.isNotNull(pager) && pager.isNeedTotalCount()) {
                pager.setTotalCount(pageInfo.getTotal());
            }
            return list;
        } catch (Throwable e) {
            if(DataUtil.isNotNull(pager) && pager.isNeedPage()) {
                PageHelper.clearPage();
            }
            throw new LambdaException("Query data warehouse info failed.", "查询项目信息失败", e);
        }
    }

    /*
     *
     *   检查相同数据仓库代码或名称是否已存在（可排除原ID）
     *   返回是否存在
     *
     * */
    public boolean existsDataWarehouse(String dwCode, String dwName, Long originalDwId)  {
        if(DataUtil.isEmpty(dwCode) && DataUtil.isEmpty(dwName))
            throw new LambdaException("Check data warehouse exists failed -- invalid check condition.", "无效检查条件");

        try {
            Long existCount;
            DwDataWarehouseExample example = new DwDataWarehouseExample();
            if(DataUtil.isNotEmpty(dwCode)) {
                DwDataWarehouseExample.Criteria criteria = example.createCriteria().andDwCodeEqualTo(dwCode).andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
                if(DataUtil.isNotNull(originalDwId))
                    criteria.andDwIdNotEqualTo(originalDwId);
                existCount = dwDataWarehouseMapper.countByExample(example);
                if(existCount > 0)
                    return true;
            }

            example.clear();
            if(DataUtil.isNotEmpty(dwName)) {
                DwDataWarehouseExample.Criteria criteria = example.createCriteria().andDwNameEqualTo(dwName).andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
                if(DataUtil.isNotNull(originalDwId))
                    criteria.andDwIdNotEqualTo(originalDwId);
                existCount = dwDataWarehouseMapper.countByExample(example);
                if(existCount > 0)
                    return true;
            }

            return false;
        } catch (Throwable e) {
            throw new LambdaException("Check data warehouse exists failed.", "检查已存在数据库失败", e);
        }
    }
}
