package com.yatop.lambda.core.utils;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.yatop.lambda.base.utils.LambdaRootModel;
import com.yatop.lambda.core.exception.LambdaException;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.context.annotation.Bean;

import javax.xml.crypto.Data;
import java.lang.reflect.Method;
import java.util.List;

public class DataUtil {

    public static boolean isNull(Object obj) {
        return obj == null;
    }

    public static boolean isNotNull(Object obj) {
        return obj != null;
    }

    public static boolean isEmpty(String str) {
        return StringUtils.isEmpty(str);
    }

    public static boolean isNotEmpty(String str) {
        return StringUtils.isNotEmpty(str);
    }

    public static boolean isBlank(String str) {
        return StringUtils.isBlank(str);
    }

    public static boolean isNotBlank(String str) {
        return StringUtils.isNotBlank(str);
    }

    public static boolean equals(String lhs, String rhs) {
        return StringUtils.equals(lhs, rhs);
    }

    public static boolean equalsIgnoreCase(String lhs, String rhs) {
        return StringUtils.equalsIgnoreCase(lhs, rhs);
    }

    public static String trim(String str) {
        return StringUtils.trim(str);
    }

    public static String trimToNull(String str) {
        return StringUtils.trimToNull(str);
    }

    public static boolean isNumberic(String str) {
        return NumberUtils.isDigits(str);
    }

    public static boolean isNotNumberic(String str) {
        return !NumberUtils.isDigits(str);
    }

    public static boolean isDigits(String str) {
        return NumberUtils.isDigits(str);
    }

    public static boolean isNotDigits(String str) {
        return !NumberUtils.isDigits(str);
    }

    public static String prettyFormat(JSON json) {
        return JSON.toJSONString(json, SerializerFeature.PrettyFormat, SerializerFeature.WriteMapNullValue, SerializerFeature.WriteDateUseDateFormat);
    }

    public static String prettyFormat(List<? extends LambdaRootModel> models) {
        return JSON.toJSONString(DataUtil.toJSONArray(models), SerializerFeature.PrettyFormat, SerializerFeature.WriteMapNullValue, SerializerFeature.WriteDateUseDateFormat);
    }

    public static JSONArray toJSONArray(List<? extends LambdaRootModel> models) {
        if(DataUtil.isNull(models))
            return null;

        JSONArray jsonArray = new JSONArray();
        for(LambdaRootModel model : models) {
            jsonArray.add(model.toJSON());
        }
        return jsonArray;
    }

    public static boolean isEmpty(List<? extends Object> list) {
        return (DataUtil.isNotNull(list)  ? list.size() == 0 : true);
    }

    public static boolean isNotEmpty(List<? extends Object> list) {
        return !DataUtil.isEmpty(list);
    }
}
