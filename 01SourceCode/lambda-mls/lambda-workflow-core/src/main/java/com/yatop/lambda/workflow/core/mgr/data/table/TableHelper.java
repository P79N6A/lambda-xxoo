package com.yatop.lambda.workflow.core.mgr.data.table;

import com.yatop.lambda.base.model.DwDataTable;
import com.yatop.lambda.core.enums.*;
import com.yatop.lambda.core.exception.LambdaException;
import com.yatop.lambda.core.mgr.table.DataTableMgr;
import com.yatop.lambda.core.utils.TableFileUtil;
import com.yatop.lambda.core.utils.WorkDirectoryUtil;
import com.yatop.lambda.workflow.core.context.CharValueContext;
import com.yatop.lambda.workflow.core.context.WorkflowContext;
import com.yatop.lambda.workflow.core.richmodel.data.table.DataTable;
import com.yatop.lambda.workflow.core.richmodel.workflow.execution.ExecutionJob;
import com.yatop.lambda.workflow.core.richmodel.workflow.execution.ExecutionTask;
import com.yatop.lambda.workflow.core.richmodel.workflow.module.ModulePort;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.Node;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TableHelper {

    private static DataTableMgr DATA_TABLE_MGR;

    @Autowired
    public void setDataTableMgr(DataTableMgr dataTableMgr) {
        DATA_TABLE_MGR = dataTableMgr;
    }

    public static DataTable createGeneralTable4Import(WorkflowContext workflowContext, Node node, String tableName) {
        if(existsTable(workflowContext, tableName))
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Create general table failed -- table name already existed.", "表名已存在");

        ExecutionTask task = workflowContext.getExecutionTask(node);

        DwDataTable table = new DwDataTable();
        table.setTableName(tableName);
        table.setTableType(DataTableTypeEnum.GENERAL.getType());
        table.setTableSrc(DataTableSourceEnum.IMPORT.getSource());
        table.setOwnerDwId(workflowContext.getDataWarehouse().data().getDwId());
        table.setRelFlowId(-1L);
        table.setRelNodeId(-1L);
        table.setRelCharId("-1");
        table.setRelTaskId(task.data().getTaskId());
        table.setDataFileType(DataFileTypeEnum.PARQUET.getType());
        table.setTableState(DataTableStateEnum.EMPTY.getState());
        table = DATA_TABLE_MGR.insertDataTable(table, workflowContext.getOperId());

        String dataWarehouseDfsDir = WorkDirectoryUtil.getDataWarehouseDfsDirectory(workflowContext.getDataWarehouse().data().getDwCode());
        String dataWarehouseLocalDir = WorkDirectoryUtil.getDataWarehouseLocalDirectory(workflowContext.getDataWarehouse().data().getDwCode());
        table.setDataFile(TableFileUtil.getFilePath4General(dataWarehouseDfsDir, table.getTableId()));
        table.setDfsSummaryFile(TableFileUtil.getSummaryFilePath4General(dataWarehouseDfsDir, table.getTableId()));
        table.setLocalSummaryFile(TableFileUtil.getSummaryFilePath4General(dataWarehouseLocalDir, table.getTableId()));
        DATA_TABLE_MGR.updateDataTable(table, workflowContext.getOperId());
        return new DataTable(table);
    }

    public static DataTable createCachedTable(CharValueContext context) {
        WorkflowContext workflowContext = context.getWorkflowContext();
        Node node = context.getNode();
        ModulePort modulePort = node.getOutputNodePort(context.getCmptChar().data().getCharId()).getModulePort();
        ExecutionJob job = workflowContext.getCurrentJob();
        ExecutionTask task = workflowContext.getExecutionTask(node);

        DwDataTable table = new DwDataTable();
        table.setTableName(String.format("tmp$%d_%d_%d", node.data().getNodeId(), modulePort.data().getPortId(), job.data().getJobId()));
        table.setTableType(DataTableTypeEnum.CACHED.getType());
        table.setTableSrc(DataTableSourceEnum.EXECUTION.getSource());
        table.setOwnerDwId(workflowContext.getDataWarehouse().data().getDwId());
        table.setRelFlowId(workflowContext.getWorkflow().data().getFlowId());
        table.setRelNodeId(node.data().getNodeId());
        table.setRelCharId(modulePort.getCmptChar().data().getCharId());
        table.setRelTaskId(task.data().getTaskId());
        table.setDataFileType(DataFileTypeEnum.PARQUET.getType());
        table.setTableState(DataTableStateEnum.EMPTY.getState());
        table = DATA_TABLE_MGR.insertDataTable(table, workflowContext.getOperId());

        String jobDfsDir = WorkDirectoryUtil.getJobDfsDirectory(workflowContext.getProject().data().getProjectId(), workflowContext.getWorkflow().data().getFlowId(), job.data().getJobId());
        String jobLocalDir = WorkDirectoryUtil.getJobDfsDirectory(workflowContext.getProject().data().getProjectId(), workflowContext.getWorkflow().data().getFlowId(), job.data().getJobId());
        table.setDataFile(TableFileUtil.getFilePath4Cached(jobDfsDir, task.data().getTaskId(), table.getTableId()));
        table.setDfsSummaryFile(TableFileUtil.getSummaryFilePath4Cached(jobDfsDir, task.data().getTaskId(), table.getTableId()));
        table.setLocalSummaryFile(TableFileUtil.getSummaryFilePath4Cached(jobLocalDir, task.data().getTaskId(), table.getTableId()));
        DATA_TABLE_MGR.updateDataTable(table, workflowContext.getOperId());
        return new DataTable(table);
    }

    public static DataTable createExternalTable(CharValueContext context, String externalDataFile) {
        WorkflowContext workflowContext = context.getWorkflowContext();
        Node node = context.getNode();
        ModulePort modulePort = node.getOutputNodePort(context.getCmptChar().data().getCharId()).getModulePort();
        ExecutionJob job = workflowContext.getCurrentJob();
        ExecutionTask task = workflowContext.getExecutionTask(node);

        DwDataTable table = new DwDataTable();
        table.setTableName(String.format("tmp$%d_%d_%d", node.data().getNodeId(), modulePort.data().getPortId(), job.data().getJobId()));
        table.setTableType(DataTableTypeEnum.EXTERNAL.getType());
        table.setTableSrc(DataTableSourceEnum.EXECUTION.getSource());
        table.setOwnerDwId(workflowContext.getDataWarehouse().data().getDwId());
        table.setRelFlowId(workflowContext.getWorkflow().data().getFlowId());
        table.setRelNodeId(node.data().getNodeId());
        table.setRelCharId(modulePort.getCmptChar().data().getCharId());
        table.setRelTaskId(task.data().getTaskId());
        table.setDataFileType(DataFileTypeEnum.PARQUET.getType());
        table.setDataFile(externalDataFile);
        table.setTableState(DataTableStateEnum.NORMAL.getState());
        table = DATA_TABLE_MGR.insertDataTable(table, workflowContext.getOperId());
        return new DataTable(table);
    }

    public static void deleteTable(CharValueContext context, DataTable table) {
        WorkflowContext workflowContext = context.getWorkflowContext();
        DATA_TABLE_MGR.deleteDataTable(table.data().getTableId(), workflowContext.getOperId());

        if(table.data().getTableType() != DataTableTypeEnum.EXTERNAL.getType()) {
            //TODO ignore table state
            //TODO clear dataFile & summaryDataFile
        }
    }

    public static void updateTable(CharValueContext context, DataTable table) {
        WorkflowContext workflowContext = context.getWorkflowContext();
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
        DwDataTable table = DATA_TABLE_MGR.queryDataTable(workflowContext.getDataWarehouse().data().getDwId(), tableName);
        return new DataTable(table);
    }

    public static boolean existsTable(WorkflowContext workflowContext, String tableName) {
        return DATA_TABLE_MGR.existsDataTable(workflowContext.getDataWarehouse().data().getDwId(), tableName, null);
    }
}
