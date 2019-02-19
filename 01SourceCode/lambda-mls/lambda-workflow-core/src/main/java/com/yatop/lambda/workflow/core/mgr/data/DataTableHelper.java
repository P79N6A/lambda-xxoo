package com.yatop.lambda.workflow.core.mgr.data;

import com.yatop.lambda.base.model.DwDataTable;
import com.yatop.lambda.core.enums.*;
import com.yatop.lambda.core.exception.LambdaException;
import com.yatop.lambda.core.mgr.table.DataTableMgr;
import com.yatop.lambda.core.utils.DataTableFileUtil;
import com.yatop.lambda.core.utils.DataTableNameUtil;
import com.yatop.lambda.workflow.core.context.CharValueContext;
import com.yatop.lambda.workflow.core.context.WorkflowContext;
import com.yatop.lambda.workflow.core.richmodel.component.characteristic.CmptChar;
import com.yatop.lambda.workflow.core.richmodel.data.table.DataTable;
import com.yatop.lambda.workflow.core.richmodel.data.table.DataWarehouse;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.Node;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataTableHelper {

    private static DataTableMgr DATA_TABLE_MGR;

    @Autowired
    public void setDataTableMgr(DataTableMgr dataTableMgr) {
        DATA_TABLE_MGR = dataTableMgr;
    }

    public static DataTable createGeneralTable4Import(WorkflowContext workflowContext, String tableName) {
        if(existsTable(workflowContext, tableName))
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Create general table failed -- table name already existed.", String.format("表名已存在:%s", tableName));


        DataWarehouse dataWarehouse = null;
        if(DataTableNameUtil.existsDatabaseName(tableName)) {
            String[] partitions = DataTableNameUtil.parseTableFullName(tableName);
            dataWarehouse = workflowContext.getDataWarehouse(partitions[0]);
            tableName = partitions[1];
        } else {
            dataWarehouse = workflowContext.getDataWarehouse();
        }

        DwDataTable table = new DwDataTable();
        table.setTableName(tableName);
        table.setTableType(DataTableTypeEnum.GENERAL.getType());
        table.setOwnerDwId(dataWarehouse.data().getDwId());
        table.setRelFlowId(-1L);
        table.setRelNodeId(-1L);
        table.setRelCharId("-1");
        table.setDataFileType(DataFileTypeEnum.PARQUET.getType());
        table.setTableState(DataTableStateEnum.EMPTY.getState());
        table = DATA_TABLE_MGR.insertDataTable(table, workflowContext.getOperId());

        String dataWarehouseDfsDir = dataWarehouse.data().getDataDfsDir();
        String dataWarehouseLocalDir = dataWarehouse.data().getDataLocalDir();
        table.setDataFile(DataTableFileUtil.getFilePath4General(dataWarehouseDfsDir, table.getTableId()));
        table.setSummaryDfsFile(DataTableFileUtil.getSummaryFilePath4General(dataWarehouseDfsDir, table.getTableId()));
        table.setSummaryLocalFile(DataTableFileUtil.getSummaryFilePath4General(dataWarehouseLocalDir, table.getTableId()));
        DATA_TABLE_MGR.updateDataTable(table, workflowContext.getOperId());
        return new DataTable(table);
    }

    public static DataTable createCachedTable(CharValueContext context) {
        WorkflowContext workflowContext = context.getWorkflowContext();
        Node node = context.getNode();
        CmptChar cmptChar = context.getCmptChar();

        DwDataTable table = new DwDataTable();
        table.setTableName(String.format("tmp$%d_%d_%s", node.data().getOwnerFlowId(), node.data().getNodeId(), cmptChar.data().getCharId()));
        table.setTableType(DataTableTypeEnum.CACHED.getType());
        table.setOwnerDwId(workflowContext.getDataWarehouse().data().getDwId());
        table.setRelFlowId(workflowContext.getWorkflow().data().getFlowId());
        table.setRelNodeId(node.data().getNodeId());
        table.setRelCharId(cmptChar.data().getCharId());
        table.setDataFileType(DataFileTypeEnum.PARQUET.getType());
        table.setTableState(DataTableStateEnum.EMPTY.getState());
        table = DATA_TABLE_MGR.insertDataTable(table, workflowContext.getOperId());

        String flowDfsDir = workflowContext.getWorkflow().data().getFlowDfsDir();
        String flowLocalDir = workflowContext.getWorkflow().data().getFlowLocalDir();
        table.setDataFile(DataTableFileUtil.getFilePath4Cached(flowDfsDir, node.data().getNodeId(), table.getTableId()));
        table.setSummaryDfsFile(DataTableFileUtil.getSummaryFilePath4Cached(flowDfsDir, node.data().getNodeId(), table.getTableId()));
        table.setSummaryLocalFile(DataTableFileUtil.getSummaryFilePath4Cached(flowLocalDir, node.data().getNodeId(), table.getTableId()));
        DATA_TABLE_MGR.updateDataTable(table, workflowContext.getOperId());
        return new DataTable(table);
    }

    public static void deleteTable(WorkflowContext workflowContext, DataTable table) {
        DATA_TABLE_MGR.deleteDataTable(table.data().getTableId(), workflowContext.getOperId());

        if(true) {
            //TODO ignore table state
            //TODO clear dataFile & summaryDataFile
        }
    }

    public static void completeTable(WorkflowContext workflowContext, DataTable table) {
        table.data().setTableRowsColoured(true);
        table.data().setTableColumnsColoured(true);
        table.data().setDataFileSizeColoured(true);
        table.data().setTableState(DataTableStateEnum.NORMAL.getState());
        DATA_TABLE_MGR.updateDataTable(table.data(), workflowContext.getOperId());
    }

    public static DataTable queryTable(Long tableId) {
        DwDataTable table = DATA_TABLE_MGR.queryDataTable(tableId);
        return new DataTable(table);
    }

    public static DataTable queryTable(WorkflowContext workflowContext, String tableName) {
        DataWarehouse dataWarehouse = null;
        if(DataTableNameUtil.existsDatabaseName(tableName)) {
            String[] partitions = DataTableNameUtil.parseTableFullName(tableName);
            dataWarehouse = workflowContext.getDataWarehouse(partitions[0]);
            tableName = partitions[1];
        } else {
            dataWarehouse = workflowContext.getDataWarehouse();
        }

        DwDataTable table = DATA_TABLE_MGR.queryDataTable(dataWarehouse.data().getDwId(), tableName);
        return new DataTable(table);
    }

    public static boolean existsTable(WorkflowContext workflowContext, String tableName) {
        DataWarehouse dataWarehouse = null;
        if(DataTableNameUtil.existsDatabaseName(tableName)) {
            String[] partitions = DataTableNameUtil.parseTableFullName(tableName);
            dataWarehouse = workflowContext.getDataWarehouse(partitions[0]);
            tableName = partitions[1];
        } else {
            dataWarehouse = workflowContext.getDataWarehouse();
        }

        return DATA_TABLE_MGR.existsDataTable(dataWarehouse.data().getDwId(), tableName, null);
    }
}
