package com.yatop.lambda.core.utils;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.yatop.lambda.base.utils.LambdaRootModel;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataUtil {

    private static Pattern PATTERN_REPLACE_BLANK = Pattern.compile("\\s*|\t|\r");

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

    public static String trimLeft(String str) {

        if(DataUtil.isEmpty(str))
            return null;

        int len = str.length();
        int st = 0;
        char[] val = str.toCharArray();    /* avoid getfield opcode */

        while ((st < len) && (val[st] <= ' ')) {
            st++;
        }
        return ((st > 0) || (len < str.length())) ? str.substring(st, len) : str;
    }

    public static String replaceBlank(String str) {

        String dest = null;
        if (str != null) {
            Matcher m = PATTERN_REPLACE_BLANK.matcher(str);
            dest = m.replaceAll("");
        }
        return dest;
    }


    public static boolean isNumber(String str) {
        return NumberUtils.isNumber(str);
    }

    public static boolean isNotNumber(String str) {
        return !NumberUtils.isNumber(str);
    }

    public static boolean isDigits(String str) {
        return NumberUtils.isDigits(str);
    }

    public static boolean isNotDigits(String str) {
        return !NumberUtils.isDigits(str);
    }

    public static String toJSONString(Object object) {
        return JSON.toJSONString(object, SerializerFeature.WriteMapNullValue, SerializerFeature.WriteDateUseDateFormat);
    }

    public static String toPrettyJSONString(JSON json) {
        return JSON.toJSONString(json, SerializerFeature.PrettyFormat, SerializerFeature.WriteMapNullValue, SerializerFeature.WriteDateUseDateFormat);
    }

    public static String toPrettyJSONString(LambdaRootModel model) {
        return JSON.toJSONString(DataUtil.toJSONObject(model), SerializerFeature.PrettyFormat, SerializerFeature.WriteMapNullValue, SerializerFeature.WriteDateUseDateFormat);
    }

    public static String toPrettyJSONString(Collection<? extends LambdaRootModel> models) {
        return JSON.toJSONString(DataUtil.toJSONArray(models), SerializerFeature.PrettyFormat, SerializerFeature.WriteMapNullValue, SerializerFeature.WriteDateUseDateFormat);
    }

    public static JSONObject toJSONObject(LambdaRootModel model) {
        return DataUtil.isNotNull(model) ? model.toJSON() : null;
    }

    public static <M extends Map<K, V>, K, V extends LambdaRootModel> JSONObject toJSONObject(M models) {
        if(DataUtil.isEmpty(models))
            return null;

        JSONObject jsonModels = new JSONObject(models.size(), true);
        for(Map.Entry<K, V> entry : models.entrySet()) {
            jsonModels.put(String.valueOf(entry.getKey()), entry.getValue().toJSON());
        }

        return jsonModels;
    }

    public static JSONArray toJSONArray(Collection<? extends LambdaRootModel> models) {
        if(DataUtil.isNull(models))
            return null;

        JSONArray jsonArray = new JSONArray();
        for(LambdaRootModel model : models) {
            jsonArray.add(model.toJSON());
        }
        return jsonArray;
    }

    public static boolean isEmpty(Collection<? extends Object> list) {
        return (DataUtil.isNotNull(list)  ? list.isEmpty() : true);
    }

    public static boolean isNotEmpty(Collection<? extends Object> list) {
        return !DataUtil.isEmpty(list);
    }

    public static boolean isEmpty(Map map) {
        return (DataUtil.isNotNull(map)  ? map.isEmpty() : true);
    }

    public static boolean isNotEmpty(Map map) {
        return !DataUtil.isEmpty(map);
    }

    public static String format(String message, LambdaRootModel m1) {
        return String.format("%s\n%s",message, DataUtil.toPrettyJSONString(m1));
    }

    public static String format(String message, LambdaRootModel m1, LambdaRootModel m2) {
        return String.format("%s\n%s\n%s",message, DataUtil.toPrettyJSONString(m1), DataUtil.toPrettyJSONString(m2));
    }

    public static String likeKeyword(String keyword) {
        return String.format("%%%s%%", keyword);
    }

    public static String toString(Object object) {
        if(DataUtil.isNull(object))
            return null;

        return object.toString();
    }

    public static Boolean toBoolean(String value) {
        if(DataUtil.isEmpty(value))
            return null;

        return Boolean.valueOf(value);
    }

    public static Long toLong(String value) {
        if(DataUtil.isEmpty(value))
            return null;

        return Long.valueOf(value);
    }

    public static Double toDouble(String value) {
        if(DataUtil.isEmpty(value))
            return null;

        return Double.valueOf(value);
    }

    public static Date toDate(String value, String format) throws Throwable {
        if(DataUtil.isEmpty(value))
            return null;

        return new SimpleDateFormat(format).parse(value);
    }
}
