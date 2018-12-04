package com.yatop.lambda.core.mgr.data;

import com.yatop.lambda.base.model.DwDataWarehouse;
import com.yatop.lambda.base.model.DwDataWarehouseExample;
import com.yatop.lambda.core.enums.DataStatusEnum;
import com.yatop.lambda.core.enums.DataWarehouseTypeEnum;
import com.yatop.lambda.core.exception.LambdaException;
import com.yatop.lambda.core.mgr.base.BaseMgr;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.core.utils.PagerUtil;
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
    public DwDataWarehouse insertDataWarehouse(DwDataWarehouse warehouse, String operId) {
        if( DataUtil.isNull(warehouse) ||
                !warehouse.isDwCodeColoured() ||
                !warehouse.isDwNameColoured() ||
                !warehouse.isDwTypeColoured() ||
                !warehouse.isOwnerProjectIdColoured() ||
                !warehouse.isDataDfsDirColoured() ||
                !warehouse.isDataLocalDirColoured() ||
                DataUtil.isEmpty(operId) ) {
            throw new LambdaException("Insert data warehouse info failed -- invalid insert data.", "无效插入数据");
        }

        if(warehouse.getDwType() == DataWarehouseTypeEnum.PUBLIC.getType()) {
            throw new LambdaException("Insert data warehouse info failed -- public data warehouse not support.", "不支持公共数据库");
        }

        if(existsDataWarehouse(warehouse.getDwCode(), warehouse.getDwName(), null)) {
            throw new LambdaException("Insert data warehouse info failed -- code or name conflict.", "数据库代码或名称冲突");
        }

        DwDataWarehouse insertWarehouse = new DwDataWarehouse();
        try {
            Date dtCurrentTime = SystemTimeUtil.getCurrentTime();
            BeanUtils.copyProperties(warehouse, insertWarehouse);
            insertWarehouse.setDwIdColoured(false);
            insertWarehouse.setStatus(DataStatusEnum.NORMAL.getStatus());
            insertWarehouse.setLastUpdateTime(dtCurrentTime);
            insertWarehouse.setLastUpdateOper(operId);
            insertWarehouse.setCreateTime(dtCurrentTime);
            insertWarehouse.setCreateOper(operId);
            dwDataWarehouseMapper.insertSelective(insertWarehouse);
            return insertWarehouse;
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
    public int deleteDataWarehouse(Long id, String operId) {
        if(DataUtil.isNull(id) || DataUtil.isEmpty(operId)){
            throw new LambdaException("Delete data warehouse info failed -- invalid query condition.", "无效删除条件");
        }

        try {
            DwDataWarehouse deleteWarehouse = new DwDataWarehouse();
            deleteWarehouse.setDwId(id);
            deleteWarehouse.setStatus(DataStatusEnum.INVALID.getStatus());
            deleteWarehouse.setLastUpdateTime(SystemTimeUtil.getCurrentTime());
            deleteWarehouse.setLastUpdateOper(operId);
            return dwDataWarehouseMapper.updateByPrimaryKeySelective(deleteWarehouse);
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
    public int updateDataWarehouse(DwDataWarehouse warehouse, String operId) {
        if( DataUtil.isNull(warehouse) || !warehouse.isDwIdColoured() || DataUtil.isEmpty(operId)) {
            throw new LambdaException("Update data warehouse info failed -- invalid update condition.", "无效更新条件");
        }

        if(!warehouse.isDwCodeColoured() &&
                !warehouse.isDwNameColoured() &&
                !warehouse.isDataDfsDirColoured() &&
                !warehouse.isDataLocalDirColoured() &&
                !warehouse.isDescriptionColoured()) {
            throw new LambdaException("Update data warehouse info failed -- invalid update data.", "无效更新内容");
        }

        if((warehouse.isDwCodeColoured() || warehouse.isDwNameColoured()) &&
                existsDataWarehouse(warehouse.getDwCode(), warehouse.getDwName(), warehouse.getDwId())) {
            throw new LambdaException("Update data warehouse info failed -- code or name conflict.", "代码或名称冲突");
        }

        DwDataWarehouse updateWarehouse = new DwDataWarehouse();
        try {
            updateWarehouse.setDwId(warehouse.getDwId());
            if(warehouse.isDwCodeColoured())
                updateWarehouse.setDwCode(warehouse.getDwCode());
            if(warehouse.isDwNameColoured())
                updateWarehouse.setDwName(warehouse.getDwName());
            if(warehouse.isDataDfsDirColoured())
                updateWarehouse.setDataDfsDir(warehouse.getDataDfsDir());
            if(warehouse.isDataDfsDirColoured())
                updateWarehouse.setDataLocalDir(warehouse.getDataLocalDir());
            if(warehouse.isDescriptionColoured())
                updateWarehouse.setDescription(warehouse.getDescription());

            updateWarehouse.setLastUpdateTime(SystemTimeUtil.getCurrentTime());
            updateWarehouse.setLastUpdateOper((operId));

            return dwDataWarehouseMapper.updateByPrimaryKeySelective(updateWarehouse);
        } catch (Throwable e) {
            throw new LambdaException("Update data warehouse info failed.", "更新数据库信息失败", e);
        }
    }

    /*
     *
     *   查询数据仓库信息（按ID）
     *   返回结果
     *
     * */
    public DwDataWarehouse queryDataWarehouse(Long id) {
        if(DataUtil.isNull(id)){
            throw new LambdaException("Query data warehouse info failed -- invalid query condition.", "无效查询条件");
        }

        try {
            DwDataWarehouse warehouse = dwDataWarehouseMapper.selectByPrimaryKey(id);
            if(DataUtil.isNull(warehouse) || (warehouse.getStatus() == DataStatusEnum.INVALID.getStatus()))
                return null;

            return warehouse;
        } catch (Throwable e) {
            throw new LambdaException("Query data warehouse info failed.", "查询数据库信息失败", e);
        }
    }

    /*
     *
     *   查询数据仓库信息（所有）
     *   返回结果
     *
     * */
    public List<DwDataWarehouse> queryDataWarehouse(PagerUtil pager) {
        try {
            PagerUtil.startPage(pager);
            DwDataWarehouseExample example = new DwDataWarehouseExample();
            example.createCriteria().andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
            example.setOrderByClause("CREATE_TIME ASC");
            return dwDataWarehouseMapper.selectByExample(example);
        } catch (Throwable e) {
            PagerUtil.clearPage(pager);
            throw new LambdaException("Query data warehouse info failed.", "查询数据库信息失败", e);
        }
    }

    /*
     *
     *   查询数据仓库信息（按关键字）
     *   返回结果集
     *
     * */
    public List<DwDataWarehouse> queryDataWarehouse(String keyword, PagerUtil pager) {
        if(DataUtil.isEmpty(keyword)){
            throw new LambdaException("Query data warehouse info failed -- invalid query condition.", "无效查询条件");
        }

        try {
            PagerUtil.startPage(pager);
            String keywordLike = "%" + keyword + "%";
            DwDataWarehouseExample example = new DwDataWarehouseExample();
            example.createCriteria().andDwCodeLike(keywordLike).andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
            example.or().andDwNameLike(keywordLike).andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
            example.setOrderByClause("CREATE_TIME ASC");
            return dwDataWarehouseMapper.selectByExample(example);
        } catch (Throwable e) {
            PagerUtil.clearPage(pager);
            throw new LambdaException("Query data warehouse info failed.", "查询数据库信息失败", e);
        }
    }

    /*
     *
     *   查询数据仓库信息（按类型）
     *   返回结果集
     *
     * */
    public List<DwDataWarehouse> queryDataWarehouse(DataWarehouseTypeEnum type, PagerUtil pager) {
        if(DataUtil.isNull(type)){
            throw new LambdaException("Query data warehouse info failed -- invalid query condition.", "无效查询条件");
        }

        try {
            PagerUtil.startPage(pager);
            DwDataWarehouseExample example = new DwDataWarehouseExample();
            example.createCriteria().andDwTypeEqualTo(type.getType()).andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
            example.setOrderByClause("CREATE_TIME ASC");
            List<DwDataWarehouse> resultList = dwDataWarehouseMapper.selectByExample(example);
            return resultList;
        } catch (Throwable e) {
            PagerUtil.clearPage(pager);
            throw new LambdaException("Query data warehouse info failed.", "查询数据库信息失败", e);
        }
    }

    /*
     *
     *   检查相同数据仓库代码或名称是否已存在（可排除原ID）
     *   返回是否存在
     *
     * */
    public boolean existsDataWarehouse(String code, String name, Long originalId)  {
        if(DataUtil.isEmpty(code) && DataUtil.isEmpty(name))
            throw new LambdaException("Check data warehouse exists failed -- invalid check condition.", "无效检查条件");

        try {
            DwDataWarehouseExample example = new DwDataWarehouseExample();
            if(DataUtil.isNotEmpty(code)) {
                DwDataWarehouseExample.Criteria criteria = example.createCriteria().andDwCodeEqualTo(code).andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
                if(DataUtil.isNotNull(originalId))
                    criteria.andDwIdNotEqualTo(originalId);
                if(dwDataWarehouseMapper.countByExample(example) > 0)
                    return true;
            }

            example.clear();
            if(DataUtil.isNotEmpty(name)) {
                DwDataWarehouseExample.Criteria criteria = example.createCriteria().andDwNameEqualTo(name).andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
                if(DataUtil.isNotNull(originalId))
                    criteria.andDwIdNotEqualTo(originalId);
                if(dwDataWarehouseMapper.countByExample(example) > 0)
                    return true;
            }

            return false;
        } catch (Throwable e) {
            throw new LambdaException("Check data warehouse exists failed.", "检查已存在数据库失败", e);
        }
    }
}
