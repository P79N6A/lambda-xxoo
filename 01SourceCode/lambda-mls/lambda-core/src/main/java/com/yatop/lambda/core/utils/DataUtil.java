package com.yatop.lambda.core.utils;


import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

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
}
