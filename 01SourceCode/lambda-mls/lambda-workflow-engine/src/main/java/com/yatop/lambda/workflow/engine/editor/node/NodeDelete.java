package com.yatop.lambda.workflow.engine.editor.node;


import com.yatop.lambda.base.model.WfFlowNodeDeleteQueue;
import com.yatop.lambda.core.mgr.workflow.WorkflowMgr;
import com.yatop.lambda.core.mgr.workflow.node.NodeDeleteQueueMgr;
import com.yatop.lambda.core.mgr.workflow.node.NodeMgr;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.context.WorkflowContext;
import com.yatop.lambda.workflow.core.richmodel.workflow.Workflow;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.Node;
import com.yatop.lambda.workflow.engine.editor.node.parameter.ParameterDelete;
import com.yatop.lambda.workflow.engine.editor.node.port.NodePortDelete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NodeDelete {

    @Autowired
    WorkflowMgr workflowMgr;

    @Autowired
    NodeMgr nodeMgr;

    @Autowired
    NodeDeleteQueueMgr nodeDeleteQueueMgr;

    @Autowired
    NodePortDelete nodePortDelete;

    @Autowired
    ParameterDelete parameterDelete;

    public void deleteNode(WorkflowContext workflowContext, List<Node> nodes) {

        if(DataUtil.isNotEmpty(nodes)) {
            for (Node node : nodes) {
                nodePortDelete.deleteNodePorts(workflowContext, node);
                parameterDelete.deleteParameters(workflowContext, node);
                nodeMgr.deleteNode(node, workflowContext.getOperId());
                workflowContext.deleteNode(node);
            }


            Workflow workflow = workflowContext.getWorkflow();
            if(nodeDeleteQueueMgr.existsNodeDeleteSequence(workflow.getFlowId(), workflow.getNextDeleteSequence()))
                nodeDeleteQueueMgr.removeNodeDelete(workflow.getFlowId(), workflow.getNextDeleteSequence());

            for (Node node : nodes) {
                WfFlowNodeDeleteQueue deleteQueue = new WfFlowNodeDeleteQueue();
                deleteQueue.setFlowId(node.getOwnerFlowId());
                deleteQueue.setNodeId(node.getNodeId());
                deleteQueue.setSequence(workflow.getNextDeleteSequence());
                nodeDeleteQueueMgr.insertNodeDelete(deleteQueue, workflowContext.getOperId());
            }

            workflowMgr.updateWorkflowNodeCount4Delete(workflow, nodes.size() + 0L, workflowContext.getOperId());
            workflow.copyProperties(workflowMgr.queryWorkflow(workflow.getFlowId()));
        }
    }
}
