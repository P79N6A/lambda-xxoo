package com.yatop.lambda.workflow.core.richmodel.workflow.node;

import com.yatop.lambda.base.model.WfFlowNodePort;
import com.yatop.lambda.workflow.core.richmodel.IRichModel;
import com.yatop.lambda.workflow.core.richmodel.component.characteristic.CmptChar;
import com.yatop.lambda.workflow.core.richmodel.workflow.module.ModulePort;

public class NodePortInput extends WfFlowNodePort implements IRichModel {

    private ModulePort modulePort;
    private boolean analyzed;

    public NodePortInput(WfFlowNodePort data, ModulePort modulePort) {
        super.copyProperties(data);
        this.modulePort = modulePort;
        this.analyzed = false;
        this.clearColoured();
    }

    @Override
    public void clear() {
        modulePort = null;
        super.clear();
    }

    public ModulePort getModulePort() {
        return modulePort;
    }

    public CmptChar getCmptChar() {
        return modulePort.getCmptChar();
    }

    public boolean isDataPort() {
        return modulePort.isDataPort();
    }

    public boolean isAnalyzed() {
        return analyzed;
    }

    protected void markAnalyzed() {
        this.analyzed = true;
    }
}
