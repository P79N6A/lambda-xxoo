package com.yatop.lambda.workflow.core.mgr.editor.node;

import com.yatop.lambda.base.model.WfFlowNode;
import com.yatop.lambda.base.model.WfFlowNodeDeleteQueue;
import com.yatop.lambda.core.enums.LambdaExceptionEnum;
import com.yatop.lambda.core.enums.SystemParameterEnum;
import com.yatop.lambda.core.exception.LambdaException;
import com.yatop.lambda.core.mgr.workflow.WorkflowMgr;
import com.yatop.lambda.core.mgr.workflow.node.NodeDeleteQueueMgr;
import com.yatop.lambda.core.mgr.workflow.node.NodeMgr;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.core.utils.SystemParameterUtil;
import com.yatop.lambda.workflow.core.config.ModuleConfig;
import com.yatop.lambda.workflow.core.context.WorkflowContext;
import com.yatop.lambda.workflow.core.richmodel.workflow.Workflow;
import com.yatop.lambda.workflow.core.richmodel.workflow.module.Module;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.Node;
import com.yatop.lambda.workflow.core.mgr.editor.node.parameter.ParameterRecover;
import com.yatop.lambda.workflow.core.mgr.editor.node.port.NodePortRecover;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NodeRecover {

    @Autowired
    WorkflowMgr workflowMgr;

    @Autowired
    NodeMgr nodeMgr;

    @Autowired
    NodeDeleteQueueMgr nodeDeleteQueueMgr;

    @Autowired
    NodePortRecover nodePortRecover;

    @Autowired
    ParameterRecover parameterRecover;

    private void recoverNode(WorkflowContext workflowContext, Long nodeId) {

        nodeMgr.recoverNode(nodeId, workflowContext.getOperId());
        WfFlowNode node = nodeMgr.queryNode(nodeId);
        if(DataUtil.isNull(node)) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, String.format("Recover node error -- node not found, node-id:%d.", nodeId), "节点信息缺失");
        }

        Module module = ModuleConfig.getModule(node.getNodeId());
        if(DataUtil.isNull(module)) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Recover node error -- module not found.", "节点信息错误", node);
        }

        Node richNode = new Node(node, module);
        workflowContext.putNode(richNode);
        parameterRecover.recoverParameters(workflowContext, richNode);
        nodePortRecover.recoverNodePorts(workflowContext, richNode);
    }

    public void recoverNode(WorkflowContext workflowContext) {

        Workflow workflow = workflowContext.getWorkflow();
        List<WfFlowNodeDeleteQueue> deleteQueues = nodeDeleteQueueMgr.queryNodeDelete(workflow.getFlowId(), workflow.previousDeleteSequence());

        if(workflow.getNodeCount() + deleteQueues.size() > SystemParameterUtil.find4Long(SystemParameterEnum.WK_FLOW_MAX_NODES)) {
            //TODO throw exception
        }

        nodeDeleteQueueMgr.removeNodeDelete(workflow.getFlowId(), workflow.previousDeleteSequence());
        workflowMgr.updateWorkflowNodeCount4Recover(workflow, deleteQueues.size() + 0L, workflowContext.getOperId());
        workflow.copyProperties(workflowMgr.queryWorkflow(workflow.getFlowId()));

        if(DataUtil.isNotEmpty(deleteQueues)) {
            for (WfFlowNodeDeleteQueue deleteQueue : deleteQueues) {
                recoverNode(workflowContext, deleteQueue.getNodeId());
            }
        }
    }
}
