package com.yatop.lambda.workflow.engine.editor.node;

import com.yatop.lambda.base.model.WfFlowNode;
import com.yatop.lambda.core.enums.LambdaExceptionEnum;
import com.yatop.lambda.core.exception.LambdaException;
import com.yatop.lambda.core.mgr.workflow.node.NodeMgr;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.config.ModuleConfig;
import com.yatop.lambda.workflow.core.context.WorkflowContext;
import com.yatop.lambda.workflow.core.richmodel.workflow.module.Module;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.Node;
import com.yatop.lambda.workflow.engine.editor.node.parameter.ParameterQuery;
import com.yatop.lambda.workflow.engine.editor.node.port.NodePortQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NodeQuery {

    @Autowired
    NodeMgr nodeMgr;

    @Autowired
    NodePortQuery nodePortQuery;

    @Autowired
    ParameterQuery parameterQuery;

    public Node queryNode(WorkflowContext workflowContext, Long nodeId) {

        WfFlowNode node = nodeMgr.queryNode(nodeId);
        if(DataUtil.isNull(node)) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, String.format("Query node error -- node not found, node-id:%d.", nodeId), "节点信息缺失");
        }

        Module module = ModuleConfig.getModule(node.getNodeId());
        if(DataUtil.isNull(module)) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query node error -- module not found.", "节点信息错误", node);
        }

        Node richNode = new Node(node, module);
        parameterQuery.queryParameters(workflowContext, richNode);
        nodePortQuery.queryNodePorts(workflowContext, richNode);
        workflowContext.putNode(richNode);
        return richNode;
    }

    public void queryNodes(WorkflowContext workflowContext) {

    }
}
