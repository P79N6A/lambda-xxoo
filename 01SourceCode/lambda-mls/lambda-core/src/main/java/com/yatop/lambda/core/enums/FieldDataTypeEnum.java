package com.yatop.lambda.core.enums;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public enum FieldDataTypeEnum {

    /** Parquet to Platform
            INT32 -> Integer
            INT64 -> Long
            FLOAT -> Float
            DOUBLE -> Double
            INT96 -> Timestamp（Date, Datetime）
            BINARY -> String
    * */

    BOOLEAN (1,  "Boolean",     "boolean"),
    SHORT   (2,  "Short",       "short"),
    INTEGER (3,  "Integer",     "integer"),
    LONG    (4,  "Long",        "long"),
    FLOAT   (5,  "Float",       "float"),
    DOUBLE  (6,  "Double",      "double"),
    STRING  (7,  "String",      "string"),
    DATE    (8,  "Date",        "date");

    private int type;
    private String platform;    //platform field type name
    private String spark;       //spark field type name

    FieldDataTypeEnum(int type, String platform, String spark) {
        this.type = type;
        this.platform = platform;
        this.spark = spark;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getSpark() {
        return spark;
    }

    public void setSpark(String spark) {
        this.spark = spark;
    }

    public static FieldDataTypeEnum valueOf(int type) {
        switch (type) {
            case 1: return BOOLEAN;
            case 2: return SHORT;
            case 3: return INTEGER;
            case 4: return LONG;
            case 5: return FLOAT;
            case 6: return DOUBLE;
            case 7: return STRING;
            case 8: return DATE;
            default: return null;
        }
    }

    private static TreeMap<String, FieldDataTypeEnum> PLATFORM_FIELD_DATA_TYPES = new TreeMap<String, FieldDataTypeEnum>();
    static {
        PLATFORM_FIELD_DATA_TYPES.put(BOOLEAN.getPlatform(), BOOLEAN);
        PLATFORM_FIELD_DATA_TYPES.put(SHORT.getPlatform(), SHORT);
        PLATFORM_FIELD_DATA_TYPES.put(INTEGER.getPlatform(), INTEGER);
        PLATFORM_FIELD_DATA_TYPES.put(LONG.getPlatform(), LONG);
        PLATFORM_FIELD_DATA_TYPES.put(FLOAT.getPlatform(), FLOAT);
        PLATFORM_FIELD_DATA_TYPES.put(DOUBLE.getPlatform(), DOUBLE);
        PLATFORM_FIELD_DATA_TYPES.put(STRING.getPlatform(), STRING);
        PLATFORM_FIELD_DATA_TYPES.put(DATE.getPlatform(), DATE);

    }

    public static FieldDataTypeEnum valueOfPlatform(String platformType) {
        return PLATFORM_FIELD_DATA_TYPES.get(platformType);
    }

    private static TreeMap<String, FieldDataTypeEnum> SPARK_FIELD_DATA_TYPES = new TreeMap<String, FieldDataTypeEnum>();
    static {
        PLATFORM_FIELD_DATA_TYPES.put(BOOLEAN.getSpark(), BOOLEAN);
        PLATFORM_FIELD_DATA_TYPES.put(SHORT.getSpark(), SHORT);
        PLATFORM_FIELD_DATA_TYPES.put(INTEGER.getSpark(), INTEGER);
        PLATFORM_FIELD_DATA_TYPES.put(LONG.getSpark(), LONG);
        PLATFORM_FIELD_DATA_TYPES.put(FLOAT.getSpark(), FLOAT);
        PLATFORM_FIELD_DATA_TYPES.put(DOUBLE.getSpark(), DOUBLE);
        PLATFORM_FIELD_DATA_TYPES.put(STRING.getSpark(), STRING);
        PLATFORM_FIELD_DATA_TYPES.put(DATE.getSpark(), DATE);

    }

    public static FieldDataTypeEnum valueOfSpark(String sparkType) {
        return SPARK_FIELD_DATA_TYPES.get(sparkType);
    }

    public static List<FieldDataTypeEnum> toList() {
        List<FieldDataTypeEnum> dataTypeEnums = new ArrayList<FieldDataTypeEnum>();
        for(Map.Entry<String, FieldDataTypeEnum> entry : PLATFORM_FIELD_DATA_TYPES.entrySet()) {
            dataTypeEnums.add(entry.getValue());
        }

        return dataTypeEnums;
    }
}
