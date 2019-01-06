package com.yatop.lambda.core.enums;

public enum AnalyzeTypeEnum {

    /**
     * 无
     */
    NONE(0, "Node"),

    /**
     * 创建节点（独占，包括创建节点和画布内节点复制创建）
     */
    CREATE_NODE(1, "Create Nodes In Canvas"),

    /**
     * 创建链接（独占）
     */
    CREATE_LINK(2, "Create Link In Canvas"),

    /**
     * 更新节点参数（独占）
     */
    UPDATE_NODE_PARAMETER(3, "Update Node Parameter"),

    /**
     * 删除节点（独占）
     */
    DELETE_NODE(4, "Delete Node In Canvas"),

    /**
     * 删除链接（排斥除DELETE_NODE之外，同时有删除节点和链接时，设为删除节点）
     */
    DELETE_LINK(5, "Delete Link In Canvas"),

    /**
     * 拷贝工作流（独占，包括拷贝实验、拷贝快照和拷贝模版的工作流内容）
     */
    COPY_WORKFLOW(6, "Copy Workflow");

    private int type;
    private String name;

    AnalyzeTypeEnum(int type, String name) {
        this.type = type;
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
