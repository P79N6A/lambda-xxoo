package com.yatop.lambda.core.mgr.data;

import com.yatop.lambda.base.model.DwDataTable;
//import com.yatop.lambda.base.model.DwDataTableExample;
//import com.yatop.lambda.base.model.DwDataTableExample.Criteria;
import com.yatop.lambda.core.mgr.base.BaseMgr;

public class DataTableMgr extends BaseMgr {

    public DwDataTable getDataTableByID(Long tableID) {
        //DwDataTableExample condtion = new DwDataTableExample();
        return dwDataTableMapper.selectByPrimaryKey(tableID);
    }
}
