package com.yatop.lambda.manager.api.request.dataTable;

import com.yatop.lambda.core.utils.PagerUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by xiaom on 2019/2/27.
 */
@ApiModel(value = "TableRequest", description = "数据表查询信息")
public class TableRequest extends PagerUtil {

    @ApiModelProperty(value = "表ID",required = false)
    private Long tableId;
    @ApiModelProperty(value = "仓库ID",required = false)
    private Long warehouseId;
    @ApiModelProperty(value = "关键字",required = false)
    private String keyword;
    private Long projectId;
    private String tableName;


    public Long getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Long warehouseId) {
        this.warehouseId = warehouseId;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Long getTableId() {
        return tableId;
    }

    public void setTableId(Long tableId) {
        this.tableId = tableId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }
}
