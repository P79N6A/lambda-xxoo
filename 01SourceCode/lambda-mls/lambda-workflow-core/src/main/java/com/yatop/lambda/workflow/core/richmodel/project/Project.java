package com.yatop.lambda.workflow.core.richmodel.project;

import com.yatop.lambda.base.model.PrProject;
import com.yatop.lambda.workflow.core.richmodel.data.DataWarehouse;
import com.yatop.lambda.workflow.core.richmodel.IRichModel;
import com.yatop.lambda.workflow.core.richmodel.model.ModelWarehouse;

public class Project extends PrProject implements IRichModel {
    private DataWarehouse dataWarehouse;    //项目数据库
    private ModelWarehouse modelWarehouse;  //项目模型库

    public Project() {}

    public Project(PrProject data) {super.copyProperties(data);}

    @Override
    public void clear() {
        dataWarehouse = null;
        modelWarehouse = null;
        super.clear();
    }

    public DataWarehouse getDataWarehouse() {
        return dataWarehouse;
    }

    public void setDataWarehouse(DataWarehouse dataWarehouse) {
        this.dataWarehouse = dataWarehouse;
    }

    public ModelWarehouse getModelWarehouse() {
        return modelWarehouse;
    }

    public void setModelWarehouse(ModelWarehouse modelWarehouse) {
        this.modelWarehouse = modelWarehouse;
    }
}
