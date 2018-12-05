package com.yatop.lambda.core.mgr.data;

import com.yatop.lambda.base.model.DwDataTable;
import com.yatop.lambda.base.model.DwDataTableExample;
import com.yatop.lambda.core.enums.DataFileTypeEnum;
import com.yatop.lambda.core.enums.DataStatusEnum;
import com.yatop.lambda.core.enums.DataTableTypeEnum;
import com.yatop.lambda.core.exception.LambdaException;
import com.yatop.lambda.core.mgr.base.BaseMgr;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.core.utils.PagerUtil;
import com.yatop.lambda.core.utils.SystemTimeUtil;
import org.springframework.beans.BeanUtils;

import java.util.Date;
import java.util.List;

public class DataTableMgr extends BaseMgr {

    /*
     *
     *   插入新数据表信息（表名、类型、所属数据仓库ID、数据文件类型、数据表状态）
     *   返回插入记录
     *
     * */
    public DwDataTable insertDataTable(DwDataTable table, String operId) {
        if( DataUtil.isNull(table) ||
                !table.isTableNameColoured() ||
                !table.isTableTypeColoured() ||
                !table.isOwnerDwIdColoured() ||
                !table.isDataFileTypeColoured() ||
                !table.isTableStateColoured() ||
                DataUtil.isEmpty(operId) ) {
            throw new LambdaException("Insert data table info failed -- invalid insert data.", "无效插入数据");
        }

        if(table.getDataFileType() != DataFileTypeEnum.PARQUET.getType()) {
            throw new LambdaException("Insert data table info failed -- only support parquet data file type.", "仅支持parquet数据文件类型");
        }

        if(existsDataTable(table.getOwnerDwId(), table.getTableName(), null)) {
            throw new LambdaException("Insert data table info failed -- name conflict.", "名称冲突");
        }

        DwDataTable insertTable = new DwDataTable();
        try {
            Date dtCurrentTime = SystemTimeUtil.getCurrentTime();
            BeanUtils.copyProperties(table, insertTable);
            insertTable.setTableIdColoured(false);
            insertTable.setStatus(DataStatusEnum.NORMAL.getStatus());
            insertTable.setLastUpdateTime(dtCurrentTime);
            insertTable.setLastUpdateOper(operId);
            insertTable.setCreateTime(dtCurrentTime);
            insertTable.setCreateOper(operId);
            dwDataTableMapper.insertSelective(insertTable);
            return insertTable;
        } catch (Throwable e) {
            throw new LambdaException("Insert data table info failed.", "插入数据表信息失败", e);
        }
    }

    /*
     *
     *   逻辑删除数据表信息
     *   返回删除数量
     *
     * */
    public int deleteDataTable(Long id, String operId) {
        if(DataUtil.isNull(id) || DataUtil.isEmpty(operId)){
            throw new LambdaException("Delete data table info failed -- invalid query condition.", "无效删除条件");
        }

        try {
            DwDataTable deleteTable = new DwDataTable();
            deleteTable.setTableId(id);
            deleteTable.setStatus(DataStatusEnum.INVALID.getStatus());
            deleteTable.setLastUpdateTime(SystemTimeUtil.getCurrentTime());
            deleteTable.setLastUpdateOper(operId);
            return dwDataTableMapper.updateByPrimaryKeySelective(deleteTable);
        } catch (Throwable e) {
            throw new LambdaException("Delete data table info failed.", "删除数据表信息失败", e);
        }
    }

    /*
     *
     *   更新数据表信息（表名、列数、行数、数据文件大小、数据文件名、数据概要文件名、数据表状态、描述）
     *   返回更新数量
     *
     * */
    public int updateDataTable(DwDataTable table, String operId) {
        if( DataUtil.isNull(table) || !table.isTableIdColoured() || DataUtil.isEmpty(operId)) {
            throw new LambdaException("Update data table info failed -- invalid update condition.", "无效更新条件");
        }

        if(!table.isTableNameColoured() &&
                !table.isTableColumnsColoured() &&
                !table.isTableRowsColoured() &&
                !table.isDataFileSizeColoured() &&
                !table.isDataFileColoured() &&
                !table.isDataSummaryFileColoured() &&
                !table.isTableStateColoured() &&
                !table.isDescriptionColoured()) {
            throw new LambdaException("Update data table info failed -- invalid update data.", "无效更新内容");
        }

        if(table.isTableNameColoured() && existsDataTable(table.getOwnerDwId(), table.getTableName(), table.getTableId())) {
            throw new LambdaException("Update data table info failed -- name conflict.", "名称冲突");
        }

        DwDataTable updateTable = new DwDataTable();
        try {
            updateTable.setTableId(table.getTableId());
            if(table.isTableNameColoured())
                updateTable.setTableName(table.getTableName());
            if(table.isTableColumnsColoured())
                updateTable.setTableColumns(table.getTableColumns());
            if(table.isTableRowsColoured())
                updateTable.setTableRows(table.getTableRows());
            if(table.isDataFileSizeColoured())
                updateTable.setDataFileSize(table.getDataFileSize());
            if(table.isDataFileColoured())
                updateTable.setDataFile(table.getDataFile());
            if(table.isDataSummaryFileColoured())
                updateTable.setDataSummaryFile(table.getDataSummaryFile());
            if(table.isTableStateColoured())
                updateTable.setTableState(table.getTableState());
            if(table.isDescriptionColoured())
                updateTable.setDescription(table.getDescription());

            updateTable.setLastUpdateTime(SystemTimeUtil.getCurrentTime());
            updateTable.setLastUpdateOper((operId));
            return dwDataTableMapper.updateByPrimaryKeySelective(updateTable);
        } catch (Throwable e) {
            throw new LambdaException("Update data table info failed.", "更新数据表信息失败", e);
        }
    }

    /*
     *
     *   查询数据表信息（按ID）
     *   返回结果
     *
     * */
    public DwDataTable queryDataTable(Long tableId) {
        if(DataUtil.isNull(tableId)){
            throw new LambdaException("Query data table info failed -- invalid query condition.", "无效查询条件");
        }

        try {
            DwDataTable table = dwDataTableMapper.selectByPrimaryKey(tableId);
            if(DataUtil.isNull(table) || (table.getStatus() == DataStatusEnum.INVALID.getStatus()))
                return null;

            return table;
        } catch (Throwable e) {
            throw new LambdaException("Query data table info failed.", "查询数据表信息失败", e);
        }
    }

    /*
     *
     *   查询数据表信息（按表名）
     *   返回结果
     *
     * */
    public DwDataTable queryDataTable(Long warehouseId, String tableName)  {
        if(DataUtil.isNull(warehouseId) && DataUtil.isEmpty(tableName))
            throw new LambdaException("Check data table exists failed -- invalid query condition.", "无效查询条件");

        try {
            DwDataTableExample example = new DwDataTableExample();
            DwDataTableExample.Criteria criteria = example.createCriteria().andOwnerDwIdEqualTo(warehouseId).andTableNameEqualTo(tableName).andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
            List<DwDataTable> resultList = dwDataTableMapper.selectByExample(example);
            return DataUtil.isNotEmpty(resultList) ? resultList.get(0) : null;
        } catch (Throwable e) {
            throw new LambdaException("Query data table info failed.", "查询数据表信息失败", e);
        }
    }

    /*
     *
     *   查询数据表信息
     *   返回结果集
     *
     * */
    public List<DwDataTable> queryDataTable(Long warehouseId, PagerUtil pager) {
        if(DataUtil.isNull(warehouseId)){
            throw new LambdaException("Query data table info failed -- invalid query condition.", "无效查询条件");
        }

        try {
            PagerUtil.startPage(pager);
            DwDataTableExample example = new DwDataTableExample();
            example.createCriteria().andOwnerDwIdEqualTo(warehouseId).andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
            example.setOrderByClause("CREATE_TIME ASC");
            return dwDataTableMapper.selectByExample(example);
        } catch (Throwable e) {
            PagerUtil.clearPage(pager);
            throw new LambdaException("Query data table info failed.", "查询数据表信息失败", e);
        }
    }

    /*
     *
     *   查询数据表信息（按关键字）
     *   返回结果集
     *
     * */
    public List<DwDataTable> queryDataTable(Long warehouseId, String keyword, PagerUtil pager) {
        if(DataUtil.isNull(warehouseId) || DataUtil.isEmpty(keyword)){
            throw new LambdaException("Query data table info failed -- invalid query condition.", "无效查询条件");
        }

        try {
            PagerUtil.startPage(pager);
            String keywordLike = "%" + keyword + "%";
            DwDataTableExample example = new DwDataTableExample();
            example.createCriteria().andOwnerDwIdEqualTo(warehouseId).andTableNameLike(keywordLike).andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
            example.setOrderByClause("CREATE_TIME ASC");
            return dwDataTableMapper.selectByExample(example);
        } catch (Throwable e) {
            PagerUtil.clearPage(pager);
            throw new LambdaException("Query data table info failed.", "查询数据表信息失败", e);
        }
    }

    /*
     *
     *   查询数据表信息（按类型）
     *   返回结果集
     *
     * */
    public List<DwDataTable> queryDataTable(Long warehouseId, DataTableTypeEnum type, PagerUtil pager) {
        if(DataUtil.isNull(warehouseId) || DataUtil.isNull(type)){
            throw new LambdaException("Query data table info failed -- invalid query condition.", "无效查询条件");
        }

        try {
            PagerUtil.startPage(pager);
            DwDataTableExample example = new DwDataTableExample();
            example.createCriteria().andOwnerDwIdEqualTo(warehouseId).andTableTypeEqualTo(type.getType()).andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
            example.setOrderByClause("CREATE_TIME ASC");
            List<DwDataTable> resultList = dwDataTableMapper.selectByExample(example);
            return resultList;
        } catch (Throwable e) {
            PagerUtil.clearPage(pager);
            throw new LambdaException("Query data table info failed.", "查询数据表信息失败", e);
        }
    }

    /*
     *
     *   检查相同数据表名称是否已存在（可排除原ID）
     *   返回是否存在
     *
     * */
    public boolean existsDataTable(Long warehouseId, String tableName, Long originalId)  {
        if(DataUtil.isNull(warehouseId) && DataUtil.isEmpty(tableName))
            throw new LambdaException("Check data table exists failed -- invalid check condition.", "无效检查条件");

        try {
            DwDataTableExample example = new DwDataTableExample();
            DwDataTableExample.Criteria criteria = example.createCriteria().andOwnerDwIdEqualTo(warehouseId)
                    .andTableNameEqualTo(tableName).andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
            if(DataUtil.isNotNull(originalId))
                criteria.andTableIdNotEqualTo(originalId);
            return dwDataTableMapper.countByExample(example) > 0 ? true : false;
        } catch (Throwable e) {
            throw new LambdaException("Check data table exists failed.", "检查已存在数据表失败", e);
        }
    }
}
