package com.yatop.lambda.workflow.core.framework.chartype.clazz.table;

import com.yatop.lambda.workflow.core.context.CharValueContext;
import com.yatop.lambda.workflow.core.mgr.data.table.CachedTableHelper;
import org.springframework.stereotype.Service;

@Service
public class CharTypeTableParquet extends CharTypeTableGeneric {

    @Override
    public void createCharValue(CharValueContext context) {
        CachedTableHelper.createCachedTable4Parquet(context);
    }
}
