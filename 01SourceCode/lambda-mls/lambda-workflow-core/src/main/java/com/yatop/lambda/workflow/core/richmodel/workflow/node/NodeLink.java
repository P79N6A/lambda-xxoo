package com.yatop.lambda.workflow.core.richmodel.workflow.node;

import com.yatop.lambda.base.model.WfFlowNodeLink;
import com.yatop.lambda.workflow.core.richmodel.IRichModel;

public class NodeLink extends WfFlowNodeLink implements IRichModel, Comparable<NodeLink> {

    private NodePort srcNodePort;   //流出节点端口
    private NodePort dstNodePort;   //流入节点端口
    private boolean override;       //用于作业执行时辅助解析工作流有效的任务内容

    public NodeLink(WfFlowNodeLink data, NodePort srcNodePort, NodePort dstNodePort) {
        super.copyProperties(data);
        this.srcNodePort = srcNodePort;
        this.dstNodePort = dstNodePort;
        this.override = false;
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

    @Override
    public int compareTo(NodeLink o) {
        return this.getLinkId().compareTo(o.getLinkId());
    }

    public boolean isOverride() {
        return override;
    }

    public void setOverride(boolean override) {
        this.override = override;
    }
}
