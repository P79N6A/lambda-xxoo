package com.yatop.lambda.workflow.core.framework.chartype.clazz.report;

import com.yatop.lambda.core.enums.JsonObjectTypeEnum;
import com.yatop.lambda.workflow.core.context.CharValueContext;
import com.yatop.lambda.workflow.core.mgr.data.unstructured.JsonReportHelper;

public class ReportTuneParameters extends ReportGeneric {

    @Override
    public void createCharValue(CharValueContext context) {
        JsonReportHelper.createJsonReport(context, JsonObjectTypeEnum.TUNE_PARAMETERS_REPORT);
    }
}
