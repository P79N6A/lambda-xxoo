package com.yatop.lambda.core.enums;

public enum StorageLocationEnum {

    /**
     * 表字段OBJECT_DATA
     */
    TABLE(0, "Table.Object_Data"),

    /**
     * 文件系统
     */
    FILE_SYSTEM(1, "File System");

    private int location;
    private String name;

    StorageLocationEnum(int location, String name) {
        this.location = location;
        this.name = name;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static StorageLocationEnum valueOf(int location) {
        switch (location) {
            case 0: return TABLE;
            case 1: return FILE_SYSTEM;
            default: return null;
        }
    }
}
