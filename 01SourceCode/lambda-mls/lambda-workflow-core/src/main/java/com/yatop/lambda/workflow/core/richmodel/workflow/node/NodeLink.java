package com.yatop.lambda.workflow.core.richmodel.workflow.node;

import com.yatop.lambda.base.model.WfFlowNodeLink;
import com.yatop.lambda.workflow.core.richmodel.RichModel;

public class NodeLink extends RichModel<WfFlowNodeLink> implements Comparable<NodeLink> {

    private boolean deleted;

    public NodeLink(WfFlowNodeLink data) {
        super(data);
        this.deleted = false;
        this.clearColoured();
    }

    @Override
    public int compareTo(NodeLink o) {
        return this.data().getLinkId().compareTo(o.data().getLinkId());
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void markDeleted() {
        this.deleted = true;
    }
}
