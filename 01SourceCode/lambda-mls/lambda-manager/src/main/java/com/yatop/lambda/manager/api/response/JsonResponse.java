package com.yatop.lambda.manager.api.response;

import com.yatop.lambda.base.utils.LambdaRootModel;
import com.yatop.lambda.core.exception.LambdaException;
import com.yatop.lambda.core.utils.DataUtil;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class JsonResponse extends LinkedHashMap<String, Object> implements Serializable {

    private static final String JSON_KEY_SUCCESS = "success";
    private static final String JSON_KEY_DATA = "data";
    private static final String JSON_KEY_ERROR_CODE = "errorCode";
    private static final String JSON_KEY_ERROR_MESSAGE = "errorMessage";
    private static final String JSON_KEY_ERROR_HINT = "errorHint";

    private JsonResponse(Object data) {
        this.put(JSON_KEY_SUCCESS, true);
        this.put(JSON_KEY_DATA, data);
    }

    private JsonResponse(LambdaException e) {
        this.put(JSON_KEY_SUCCESS, false);
        this.put(JSON_KEY_ERROR_CODE, e.getCode());
        this.put(JSON_KEY_ERROR_MESSAGE, e.getMessage());
        this.put(JSON_KEY_ERROR_HINT, e.getHint());
    }

    public static JsonResponse build(Object data) {
        if(data instanceof LambdaRootModel) {
            return build(((LambdaRootModel) data));
        }

        return new JsonResponse(data);
    }

    public static <M extends Map<K, V>, K, V extends LambdaRootModel> JsonResponse build(M data) {
        return new JsonResponse(DataUtil.toJSONObject(data));
    }

    public static JsonResponse build(LambdaRootModel data) {
        return new JsonResponse(data.toJSON());
    }

    public static JsonResponse build(LambdaException e) {
        return new JsonResponse(e);
    }
}
