package com.yatop.lambda.core.mgr.model;

import com.yatop.lambda.base.model.MwModelWarehouse;
import com.yatop.lambda.base.model.MwModelWarehouseExample;
import com.yatop.lambda.core.enums.LambdaExceptionEnum;
import com.yatop.lambda.core.mgr.base.BaseMgr;
import com.yatop.lambda.core.enums.DataStatusEnum;
import com.yatop.lambda.core.enums.ModelWarehouseTypeEnum;
import com.yatop.lambda.core.exception.LambdaException;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.core.utils.PagerUtil;
import com.yatop.lambda.core.utils.SystemTimeUtil;
import com.yatop.lambda.core.utils.WorkDirectoryUtil;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ModelWarehouseMgr extends BaseMgr {
    
    /*
     *
     *   插入新模型仓库信息（代码、名称、类型、所属项目ID、DFS数据目录、本地数据目录 ...）
     *   返回插入记录
     *
     * */
    public MwModelWarehouse insertModelWarehouse(MwModelWarehouse warehouse, String operId) {
        if( DataUtil.isNull(warehouse) ||
                warehouse.isMwCodeNotColoured() ||
                warehouse.isMwNameNotColoured() ||
                warehouse.isMwTypeNotColoured() ||
                warehouse.isOwnerProjectIdNotColoured() ||
                DataUtil.isEmpty(operId) ) {
            throw new LambdaException(LambdaExceptionEnum.E_MODEL_DEFAULT_ERROR, "Insert model warehouse info failed -- invalid insert data.", "无效插入数据");
        }

        if(warehouse.getMwType() == ModelWarehouseTypeEnum.PUBLIC.getType()) {
            throw new LambdaException(LambdaExceptionEnum.E_MODEL_DEFAULT_ERROR, "Insert model warehouse info failed -- public model warehouse not support.", "不支持公共模型库");
        }

        if(existsModelWarehouse(warehouse.getMwCode(), warehouse.getMwName(), null)) {
            throw new LambdaException(LambdaExceptionEnum.E_MODEL_DEFAULT_ERROR, "Insert model warehouse info failed -- code or name conflict.", "模型库代码或名称冲突");
        }

        MwModelWarehouse insertWarehouse = new MwModelWarehouse();
        try {
            Date dtCurrentTime = SystemTimeUtil.getCurrentTime();
            insertWarehouse.copyProperties(warehouse);
            if(insertWarehouse.isModelDfsDirColoured())
                insertWarehouse.setModelDfsDir(WorkDirectoryUtil.removeDfsSchemaPrefix(insertWarehouse.getModelDfsDir()));
            insertWarehouse.setMwIdColoured(false);
            insertWarehouse.setStatus(DataStatusEnum.NORMAL.getStatus());
            insertWarehouse.setLastUpdateTime(dtCurrentTime);
            insertWarehouse.setLastUpdateOper(operId);
            insertWarehouse.setCreateTime(dtCurrentTime);
            insertWarehouse.setCreateOper(operId);
            mwModelWarehouseMapper.insertSelective(insertWarehouse);
            if(insertWarehouse.isModelDfsDirColoured())
                insertWarehouse.setModelDfsDir(WorkDirectoryUtil.addDfsSchemaPrefix(insertWarehouse.getModelDfsDir()));
            return insertWarehouse;
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.E_MODEL_DEFAULT_ERROR, "Insert model warehouse info failed.", "插入模型库信息失败", e);
        }
    }

    /*
     *
     *   逻辑删除模型仓库信息
     *   返回删除数量
     *
     * */
    public int deleteModelWarehouse(Long warehouseId, String operId) {
        if(DataUtil.isNull(warehouseId) || DataUtil.isEmpty(operId)){
            throw new LambdaException(LambdaExceptionEnum.E_MODEL_DEFAULT_ERROR, "Delete model warehouse info failed -- invalid delete condition.", "无效删除条件");
        }

        try {
            MwModelWarehouse deleteWarehouse = new MwModelWarehouse();
            deleteWarehouse.setMwId(warehouseId);
            deleteWarehouse.setStatus(DataStatusEnum.INVALID.getStatus());
            deleteWarehouse.setLastUpdateTime(SystemTimeUtil.getCurrentTime());
            deleteWarehouse.setLastUpdateOper(operId);
            return mwModelWarehouseMapper.updateByPrimaryKeySelective(deleteWarehouse);
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.E_MODEL_DEFAULT_ERROR, "Delete model warehouse info failed.", "删除模型库信息失败", e);
        }
    }

    /*
     *
     *   更新模型仓库信息（代码、名称、DFS数据目录、本地数据目录、描述）
     *   返回更新数量
     *
     * */
    public int updateModelWarehouse(MwModelWarehouse warehouse, String operId) {
        if( DataUtil.isNull(warehouse) || DataUtil.isNull(warehouse.getMwId()) || DataUtil.isEmpty(operId)) {
            throw new LambdaException(LambdaExceptionEnum.E_MODEL_DEFAULT_ERROR, "Update model warehouse info failed -- invalid update condition.", "无效更新条件");
        }

        if(warehouse.isMwCodeNotColoured() &&
                warehouse.isMwNameNotColoured() &&
                warehouse.isModelDfsDirNotColoured() &&
                warehouse.isModelLocalDirNotColoured() &&
                warehouse.isDescriptionNotColoured()) {
            throw new LambdaException(LambdaExceptionEnum.E_MODEL_DEFAULT_ERROR, "Update model warehouse info failed -- invalid update data.", "无效更新内容");
        }

        if((warehouse.isMwCodeColoured() || warehouse.isMwNameColoured()) &&
                existsModelWarehouse(warehouse.getMwCode(), warehouse.getMwName(), warehouse.getMwId())) {
            throw new LambdaException(LambdaExceptionEnum.E_MODEL_DEFAULT_ERROR, "Update model warehouse info failed -- code or name conflict.", "代码或名称冲突");
        }

        MwModelWarehouse updateWarehouse = new MwModelWarehouse();
        try {
            updateWarehouse.setMwId(warehouse.getMwId());
            if(warehouse.isMwCodeColoured())
                updateWarehouse.setMwCode(warehouse.getMwCode());
            if(warehouse.isMwNameColoured())
                updateWarehouse.setMwName(warehouse.getMwName());
            if(warehouse.isModelDfsDirColoured()) {
                updateWarehouse.setModelDfsDir(WorkDirectoryUtil.removeDfsSchemaPrefix(warehouse.getModelDfsDir()));
            }
            if(warehouse.isModelLocalDirColoured())
                updateWarehouse.setModelLocalDir(warehouse.getModelLocalDir());
            if(warehouse.isDescriptionColoured())
                updateWarehouse.setDescription(warehouse.getDescription());

            updateWarehouse.setLastUpdateTime(SystemTimeUtil.getCurrentTime());
            updateWarehouse.setLastUpdateOper((operId));

            warehouse.setLastUpdateTime(updateWarehouse.getLastUpdateTime());
            warehouse.setLastUpdateOper(updateWarehouse.getLastUpdateOper());
            return mwModelWarehouseMapper.updateByPrimaryKeySelective(updateWarehouse);
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.E_MODEL_DEFAULT_ERROR, "Update model warehouse info failed.", "更新模型库信息失败", e);
        }
    }

    /*
     *
     *   查询模型仓库信息（按ID）
     *   返回结果
     *
     * */
    public MwModelWarehouse queryModelWarehouse(Long id) {
        if(DataUtil.isNull(id)){
            throw new LambdaException(LambdaExceptionEnum.E_MODEL_DEFAULT_ERROR, "Query model warehouse info failed -- invalid query condition.", "无效查询条件");
        }

        MwModelWarehouse warehouse;

        try {
            warehouse = mwModelWarehouseMapper.selectByPrimaryKey(id);
            warehouse.setModelDfsDir(WorkDirectoryUtil.addDfsSchemaPrefix(warehouse.getModelDfsDir()));
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.E_MODEL_DEFAULT_ERROR, "Query model warehouse info failed.", "查询模型库信息失败", e);
        }

        if(DataUtil.isNull(warehouse) || (warehouse.getStatus() == DataStatusEnum.INVALID.getStatus()))
            throw new LambdaException(LambdaExceptionEnum.E_MODEL_DEFAULT_ERROR, "Query model warehouse info failed -- invalid status or not found.", "模型库信息不存在");

        return warehouse;
    }

    /*
     *
     *   查询模型仓库信息（按代码）
     *   返回结果
     *
     * */
    public MwModelWarehouse queryModelWarehouse(String mwCode) {
        if(DataUtil.isEmpty(mwCode)){
            throw new LambdaException(LambdaExceptionEnum.E_MODEL_DEFAULT_ERROR, "Query model warehouse info failed -- invalid query condition.", "无效查询条件");
        }

        try {
            MwModelWarehouseExample example = new MwModelWarehouseExample();
            example.createCriteria().andMwCodeEqualTo(mwCode).andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
            List<MwModelWarehouse> resultList = mwModelWarehouseMapper.selectByExample(example);

            if(DataUtil.isNotEmpty(resultList)) {
                for (MwModelWarehouse warehouse : resultList) {
                    warehouse.setModelDfsDir(WorkDirectoryUtil.addDfsSchemaPrefix(warehouse.getModelDfsDir()));
                }
            }

            return DataUtil.isNotEmpty(resultList) ? resultList.get(0) : null;
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.E_MODEL_DEFAULT_ERROR, "Query model warehouse info failed.", "查询模型库信息失败", e);
        }
    }

    /*
     *
     *   查询模型仓库信息（按[仓库类型] + [关键字]）
     *   返回结果集
     *
     * */
    public List<MwModelWarehouse> queryModelWarehouse(ModelWarehouseTypeEnum type, String keyword, PagerUtil pager) {

        try {
            PagerUtil.startPage(pager);
            MwModelWarehouseExample example = new MwModelWarehouseExample();

            if(DataUtil.isEmpty(keyword)) {
                MwModelWarehouseExample.Criteria cond = example.createCriteria();
                if(DataUtil.isNotNull(type))
                    cond.andMwTypeEqualTo(type.getType());
                cond.andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());

            } else {
                MwModelWarehouseExample.Criteria condA = example.createCriteria();
                MwModelWarehouseExample.Criteria condB = example.createCriteria();
                if(DataUtil.isNotNull(type)) {
                    condA.andMwTypeEqualTo(type.getType());
                    condB.andMwTypeEqualTo(type.getType());
                }
                condA.andMwCodeLike(DataUtil.likeKeyword(keyword)).andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
                condB.andMwNameLike(DataUtil.likeKeyword(keyword)).andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
                example.or(condB);
            }

            example.setOrderByClause("CREATE_TIME ASC");
            List<MwModelWarehouse> resultList = mwModelWarehouseMapper.selectByExample(example);

            if(DataUtil.isNotEmpty(resultList)) {
                for (MwModelWarehouse warehouse : resultList) {
                    warehouse.setModelDfsDir(WorkDirectoryUtil.addDfsSchemaPrefix(warehouse.getModelDfsDir()));
                }
            }
            return resultList;
        } catch (Throwable e) {
            PagerUtil.clearPage(pager);
            throw new LambdaException(LambdaExceptionEnum.E_MODEL_DEFAULT_ERROR, "Query model warehouse info failed.", "查询模型库信息失败", e);
        }
    }

    /*
     *
     *   检查相同模型仓库代码或名称是否已存在（可排除原ID）
     *   返回是否存在
     *
     * */
    public boolean existsModelWarehouse(String code, String name, Long originalId)  {
        if(DataUtil.isEmpty(code) && DataUtil.isEmpty(name))
            throw new LambdaException(LambdaExceptionEnum.E_MODEL_DEFAULT_ERROR, "Check model warehouse exists failed -- invalid check condition.", "无效检查条件");

        try {
            MwModelWarehouseExample example = new MwModelWarehouseExample();
            if(DataUtil.isNotEmpty(code)) {
                MwModelWarehouseExample.Criteria criteria = example.createCriteria().andMwCodeEqualTo(code).andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
                if(DataUtil.isNotNull(originalId))
                    criteria.andMwIdNotEqualTo(originalId);
                if(mwModelWarehouseMapper.countByExample(example) > 0)
                    return true;
            }

            example.clear();
            if(DataUtil.isNotEmpty(name)) {
                MwModelWarehouseExample.Criteria criteria = example.createCriteria().andMwNameEqualTo(name).andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
                if(DataUtil.isNotNull(originalId))
                    criteria.andMwIdNotEqualTo(originalId);
                if(mwModelWarehouseMapper.countByExample(example) > 0)
                    return true;
            }

            return false;
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.E_MODEL_DEFAULT_ERROR, "Check model warehouse exists failed.", "检查已存在模型库失败", e);
        }
    }
}
