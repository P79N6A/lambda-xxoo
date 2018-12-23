package com.yatop.lambda.workflow.core.richmodel.workflow.node;

import com.yatop.lambda.base.model.WfFlowNodePort;
import com.yatop.lambda.workflow.core.richmodel.IRichModel;
import com.yatop.lambda.workflow.core.richmodel.workflow.module.ModulePort;

public class NodePort extends WfFlowNodePort implements IRichModel {

    private ModulePort modulePort;
    private NodeSchema schema;

    public NodePort(WfFlowNodePort data, ModulePort modulePort) {
        super.copyProperties(data);
        this.modulePort = modulePort;
    }

    @Override
    public void clear() {
        modulePort = null;
        schema = null;
        super.clear();
    }

    public ModulePort getModulePort() {
        return modulePort;
    }

    public NodeSchema getSchema() {
        return schema;
    }

    public void setSchema(NodeSchema schema) {
        this.schema = schema;
    }
}
