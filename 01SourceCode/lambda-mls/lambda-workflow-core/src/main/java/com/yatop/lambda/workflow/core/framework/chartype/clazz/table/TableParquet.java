package com.yatop.lambda.workflow.core.framework.chartype.clazz.table;

import com.yatop.lambda.workflow.core.context.CharValueContext;
import com.yatop.lambda.workflow.core.mgr.data.table.CachedTableHelper;
import org.springframework.stereotype.Service;

@Service
public class TableParquet extends TableGeneric {

    @Override
    public void createCharValue(CharValueContext context) {
        CachedTableHelper.createCachedTable4Parquet(context);
    }
}
