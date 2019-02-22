package com.yatop.lambda.manager.api.response;

import com.yatop.lambda.base.utils.LambdaRootModel;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.core.utils.PagerUtil;


import java.util.Collection;
import java.util.LinkedHashMap;

public class PagerResponse extends LinkedHashMap<String, Object> {

    private static String JSON_KEY_ROWS = "rows";
    private static String JSON_KEY_TOTAL = "total";

    private PagerResponse(Object rows, Long total) {
        this.put(JSON_KEY_ROWS, rows);
        this.put(JSON_KEY_TOTAL, total);
    }

    public static JsonResponse build(Collection<? extends LambdaRootModel> rows, PagerUtil pager) {
        return JsonResponse.build(new PagerResponse(DataUtil.toJSONArray(rows), pager.getTotalCount()));
    }

    public static JsonResponse build(Object rows, PagerUtil pager) {
        return JsonResponse.build(new PagerResponse(rows, pager.getTotalCount()));
    }
}
