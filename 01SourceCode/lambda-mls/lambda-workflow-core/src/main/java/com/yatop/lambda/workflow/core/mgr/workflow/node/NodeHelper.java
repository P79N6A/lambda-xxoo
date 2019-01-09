package com.yatop.lambda.workflow.core.mgr.workflow.node;


import com.yatop.lambda.base.model.WfFlowNode;
import com.yatop.lambda.core.mgr.workflow.node.NodeMgr;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.Node;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NodeHelper {

    private static NodeMgr NODE_MGR;

    @Autowired
    public void setNodeParameterMgr(NodeMgr nodeMgr) {
        NODE_MGR = nodeMgr;
    }

    //最后任务ID、警告消息、节点状态、概要
    public static void updateNode(Node node, String operId) {
        NODE_MGR.updateNode(node.data(), operId);
        node.clearColoured();
    }

    //名称、X坐标、Y坐标、注释、描述
    //TODO 直接调用 NodeMgr.updateNode去做更新
}
