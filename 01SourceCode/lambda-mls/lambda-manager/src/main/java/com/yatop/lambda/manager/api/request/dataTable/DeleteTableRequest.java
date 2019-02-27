package com.yatop.lambda.manager.api.request.dataTable;

import java.util.List;

/**
 * Created by xiaom on 2019/2/27.
 */
public class DeleteTableRequest {

    private List<Long> tableIdList;

    public List<Long> getTableIdList() {
        return tableIdList;
    }

    public void setTableIdList(List<Long> tableIdList) {
        this.tableIdList = tableIdList;
    }
}
