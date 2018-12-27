package com.yatop.lambda.workflow.core.richmodel.workflow.node;

import com.yatop.lambda.base.model.WfFlowNodePort;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.framework.chartype.clazz.data.CharTypeDataGeneric;
import com.yatop.lambda.workflow.core.richmodel.IRichModel;
import com.yatop.lambda.workflow.core.richmodel.workflow.module.ModulePort;
import com.yatop.lambda.workflow.core.utils.ClazzHelperUtil;

public class NodePortOutput extends WfFlowNodePort implements IRichModel {

    private ModulePort modulePort;
    private NodeSchema schema;
    private boolean deleted;

    public NodePortOutput(WfFlowNodePort data, ModulePort modulePortInput) {
        super.copyProperties(data);
        this.modulePort = modulePortInput;
        this.deleted = false;
    }

    @Override
    public void clear() {
        modulePort = null;
        DataUtil.clear(schema);
        schema = null;
        super.clear();
    }

    public ModulePort getModulePort() {
        return modulePort;
    }

    public boolean isDataPort() {
        return ClazzHelperUtil.getCharTypeClazzBean(modulePort.getCmptChar().getType()) instanceof CharTypeDataGeneric;
    }

    public NodeSchema getSchema() {
        return schema;
    }

    public void setSchema(NodeSchema schema) {
        this.schema = schema;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void markDeleted() {
        this.deleted = true;
    }
}
