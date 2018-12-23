package com.yatop.lambda.workflow.core.richmodel.workflow.node;

import com.yatop.lambda.base.model.WfFlowNodeLink;
import com.yatop.lambda.workflow.core.richmodel.IRichModel;

public class NodeLink extends WfFlowNodeLink implements IRichModel {

    private NodePort srcNodePort;   //流出节点端口
    private NodePort dstNodePort;   //流入节点端口

    public NodeLink(WfFlowNodeLink data, NodePort srcNodePort, NodePort dstNodePort) {
        super.copyProperties(data);
        this.srcNodePort = srcNodePort;
        this.dstNodePort = dstNodePort;
    }

    @Override
    public void clear() {
        srcNodePort = null;
        dstNodePort = null;
        super.clear();
    }

    public NodePort getSrcNodePort() {
        return srcNodePort;
    }

    public NodePort getDstNodePort() {
        return dstNodePort;
    }
}
