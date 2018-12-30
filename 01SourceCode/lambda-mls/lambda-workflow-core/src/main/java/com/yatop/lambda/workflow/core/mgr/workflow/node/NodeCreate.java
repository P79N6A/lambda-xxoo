package com.yatop.lambda.workflow.core.mgr.workflow.node;

import com.yatop.lambda.base.model.WfFlowNode;
import com.yatop.lambda.core.enums.LambdaExceptionEnum;
import com.yatop.lambda.core.enums.SystemParameterEnum;
import com.yatop.lambda.core.exception.LambdaException;
import com.yatop.lambda.core.mgr.workflow.node.NodeMgr;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.core.utils.SystemParameterUtil;
import com.yatop.lambda.workflow.core.context.WorkflowContext;
import com.yatop.lambda.workflow.core.mgr.workflow.node.parameter.ParameterCreate;
import com.yatop.lambda.workflow.core.mgr.workflow.node.port.NodePortCreate;
import com.yatop.lambda.workflow.core.richmodel.workflow.Workflow;
import com.yatop.lambda.workflow.core.richmodel.workflow.module.Module;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.Node;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NodeCreate {

    @Autowired
    private NodeMgr nodeMgr;

    @Autowired
    private ParameterCreate parameterCreate;

    @Autowired
    private NodePortCreate nodePortCreate;

    private Node createNode(WorkflowContext workflowContext, Module module, Node otherNode, Long x, Long y) {

        Workflow workflow = workflowContext.getWorkflow();
        Long flowMaxNodes = SystemParameterUtil.find4Long(SystemParameterEnum.WK_FLOW_MAX_NODES);
        if(workflow.getNodeCount() + 1 > flowMaxNodes) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Create node failed -- number of nodes can't exceed more then WK_FLOW_MAX_NODES.", "画布节点数量不能超过" + flowMaxNodes, workflow);
        }

        WfFlowNode node = new WfFlowNode();
        node.setNodeName(module.getModuleName());
        node.setOwnerProjectId(workflow.getOwnerProjectId());
        node.setOwnerFlowId(workflow.getFlowId());
        node.setRefModuleId(module.getModuleId());
        node.setPositionX(x);
        node.setPositionY(y);
        node = nodeMgr.insertNode(node, workflowContext.getOperId());

        Node richNode = new Node(node, module);
        //richNode.copyProperties(nodeMgr.queryNode(richNode.getNodeId()));
        workflowContext.putNode(richNode);
        workflow.increaseNodeCount();

        if(DataUtil.isNull(otherNode)) {
            parameterCreate.createParameters(workflowContext, richNode);
        } else {
            parameterCreate.createParameters(workflowContext, richNode, otherNode);
        }
        nodePortCreate.createNodePorts(workflowContext, richNode);
        return richNode;
    }

    public Node createNode(WorkflowContext workflowContext, Module module, Long x, Long y) {
        return createNode(workflowContext, module, null, x, y);
    }

    public Node createNode(WorkflowContext workflowContext, Node otherNode, Long x, Long y) {
        return createNode(workflowContext, otherNode.getModule(), otherNode, x, y);
    }
}
