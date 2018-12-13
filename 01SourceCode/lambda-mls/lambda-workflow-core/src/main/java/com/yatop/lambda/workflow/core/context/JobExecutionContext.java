package com.yatop.lambda.workflow.core.context;

import com.alibaba.fastjson.JSONObject;
import com.yatop.lambda.workflow.core.model.data.DataTable;
import com.yatop.lambda.workflow.core.model.data.DataWarehouse;
import com.yatop.lambda.workflow.core.model.experiment.Experiment;
import com.yatop.lambda.workflow.core.model.model.Model;
import com.yatop.lambda.workflow.core.model.model.ModelWarehouse;
import com.yatop.lambda.workflow.core.model.project.Project;
import com.yatop.lambda.workflow.core.model.workflow.Workflow;
import com.yatop.lambda.workflow.core.model.workflow.node.Node;
import com.yatop.lambda.workflow.core.model.workflow.node.NodeLink;

import java.util.TreeMap;

public class JobExecutionContext {

/*    Project project;    //操作关联的项目
    TreeMap<Long, DataWarehouse>  dataWarehouses;   //操作关联的数据仓库
    TreeMap<Long, ModelWarehouse> modelWarehouses;  //操作关联的模型仓库
    TreeMap<Long, DataTable> dataTables;    //操作关联的数据表
    TreeMap<Long, Model> models;    //操作关联的模型
    Experiment experiment;          //操作关联的实验
    Workflow workflow;              //操作关联的工作流
    TreeMap<Long, Node> nodes;      //操作关联的节点
    TreeMap<Long, NodeLink> links;  //操作关联的链接*/

    public JSONObject toJSON() {
        return null;
    }

    public void clear() {

    }
}
