package com.yatop.lambda.workflow.core.richmodel.workflow.node;

import com.yatop.lambda.base.model.WfFlowNodePort;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.framework.chartype.ICharTypeClazz;
import com.yatop.lambda.workflow.core.mgr.workflow.node.schema.NodeSchemaHelper;
import com.yatop.lambda.workflow.core.richmodel.RichModel;
import com.yatop.lambda.workflow.core.richmodel.component.characteristic.CharType;
import com.yatop.lambda.workflow.core.richmodel.component.characteristic.CmptChar;
import com.yatop.lambda.workflow.core.richmodel.workflow.module.ModulePort;

public class NodeOutputPort extends RichModel<WfFlowNodePort> {

    private ModulePort modulePort;
    private NodeSchema schema;
    private boolean analyzed;
    private boolean deleted;

    public NodeOutputPort(WfFlowNodePort data, ModulePort modulePort) {
        super(data);
        this.modulePort = modulePort;
        this.analyzed = false;
    }

    @Override
    public void clear() {
        if(DataUtil.isNotNull(schema)) {
            schema.clear();
            schema = null;
        }
        super.clear();
    }

    protected void flush(String operId) {
        if (!this.isDeleted() && this.isDataTablePort() && DataUtil.isNotNull(schema)) {
            schema.flush(operId);
        }
    }

    public ModulePort getModulePort() {
        return modulePort;
    }

    public CmptChar getCmptChar() {
        return modulePort.getCmptChar();
    }

    public boolean isDataTablePort() {
        return modulePort.isDataTablePort();
    }

    public NodeSchema getSchema() {

        if(isDeleted())
            return null;

        if(!isDataTablePort())
            return null;

        if(DataUtil.isNull(schema)) {
            schema = NodeSchemaHelper.querySchema(this);
        }
        return schema;
    }

    public void setSchema(NodeSchema schema) {
        this.schema = schema;
    }

    public boolean isAnalyzed() {
        return analyzed;
    }

    protected void markAnalyzed() {
        this.analyzed = true;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void markDeleted() {
        this.deleted = true;
    }

    public CharType getType() {
        return this.getCmptChar().getType();
    }

    public boolean matchTargetInputPort(NodeInputPort dstNodePort) {
        return this.getType().matchTargetType(dstNodePort.getType());
    }

    public boolean isSchemaChanged() {
        return isDataTablePort() && (DataUtil.isNull(schema) ? false : schema.isSchemaChanged());
    }

    public ICharTypeClazz getCharTypeClazzBean() {
        return this.getCmptChar().getCharTypeClazzBean();
    }
}
