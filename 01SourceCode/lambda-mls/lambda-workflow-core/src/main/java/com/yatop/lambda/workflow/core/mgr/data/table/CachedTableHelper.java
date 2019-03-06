package com.yatop.lambda.workflow.core.mgr.data.table;

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
import com.yatop.lambda.workflow.core.richmodel.workflow.charvalue.CharValue;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.Node;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CachedTableHelper {

    private static DataTableMgr DATA_TABLE_MGR;

    @Autowired
    public void setDataTableMgr(DataTableMgr dataTableMgr) {
        DATA_TABLE_MGR = dataTableMgr;
    }

    public static DataTable createCachedTable4Parquet(CharValueContext context) {
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

    public static void deleteCachedTable(CharValueContext context) {
        WorkflowContext workflowContext = context.getWorkflowContext();
        clearCachedTable(context);
        DATA_TABLE_MGR.deleteDataTable(Long.parseLong(context.getCharValue().getCharValue()), workflowContext.getOperId());
    }

    public static void recoverCachedTable(CharValueContext context) {
        WorkflowContext workflowContext = context.getWorkflowContext();
        DATA_TABLE_MGR.recoverDataTable(Long.parseLong(context.getCharValue().getCharValue()), workflowContext.getOperId());
        queryCachedTable(context.getCharValue());
    }

    public static void completeCachedTable(CharValueContext context) {
        WorkflowContext workflowContext = context.getWorkflowContext();
        DataTable table = context.getCharValue().getDataTable();

        table.data().setTableRowsColoured(true);
        table.data().setTableColumnsColoured(true);
        table.data().setDataFileSizeColoured(true);
        table.data().setTableState(DataTableStateEnum.NORMAL.getState());
        DATA_TABLE_MGR.updateDataTable(table.data(), workflowContext.getOperId());

        //TODO synchronize dfs table file to local filesystem
    }

    public static void clearCachedTable(CharValueContext context) {
        WorkflowContext workflowContext = context.getWorkflowContext();
        DataTable table = context.getCharValue().getDataTable();

        table.data().setTableRows(null);
        table.data().setTableColumns(null);
        table.data().setDataFileSize(null);
        table.data().setTableState(DataTableStateEnum.EMPTY.getState());
        DATA_TABLE_MGR.updateDataTable(table.data(), workflowContext.getOperId());

        //TODO remove dfs & local table file
    }

    public static DataTable queryCachedTable(CharValue charValue) {
        DwDataTable table = DATA_TABLE_MGR.queryDataTable(Long.parseLong(charValue.getCharValue()));

        DataTable richTable = new DataTable(table);
        charValue.setObjectValue(richTable);
        return richTable;
    }
}
