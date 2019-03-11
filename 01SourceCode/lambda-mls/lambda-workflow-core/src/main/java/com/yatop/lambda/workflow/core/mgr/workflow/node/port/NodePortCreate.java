package com.yatop.lambda.workflow.core.mgr.workflow.node.port;

import com.yatop.lambda.base.model.WfFlowNodePort;
import com.yatop.lambda.core.mgr.workflow.node.NodePortMgr;
import com.yatop.lambda.workflow.core.context.WorkflowContext;
import com.yatop.lambda.workflow.core.mgr.workflow.node.schema.NodeSchemaHelper;
import com.yatop.lambda.workflow.core.richmodel.workflow.module.Module;
import com.yatop.lambda.workflow.core.richmodel.workflow.module.ModulePort;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.Node;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.NodeInputPort;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.NodeOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NodePortCreate {

    @Autowired
    private NodePortMgr nodePortMgr;

    private NodeInputPort createInputPort(WorkflowContext workflowContext, Node node, ModulePort inputPort) {

        WfFlowNodePort nodePort = new WfFlowNodePort();
        nodePort.setNodePortName(inputPort.data().getPortName());
        nodePort.setOwnerNodeId(node.data().getNodeId());
        nodePort.setRefPortId(inputPort.data().getPortId());
        nodePort.setRefCharId(inputPort.getCmptChar().data().getCharId());
        nodePortMgr.insertNodePort(nodePort, workflowContext.getOperId());
        //nodePort.copyProperties(nodePortMgr.queryNodePort(nodePort.getNodePortId()));
        NodeInputPort richNodePort = new NodeInputPort(nodePort, inputPort);
        return richNodePort;
    }

    private NodeOutputPort createOutputPort(WorkflowContext workflowContext, Node node, ModulePort outputPort) {

        WfFlowNodePort nodePort = new WfFlowNodePort();
        nodePort.setNodePortName(outputPort.data().getPortName());
        nodePort.setOwnerNodeId(node.data().getNodeId());
        nodePort.setRefPortId(outputPort.data().getPortId());
        nodePort.setRefCharId(outputPort.getCmptChar().data().getCharId());
        nodePort = nodePortMgr.insertNodePort(nodePort, workflowContext.getOperId());
        //nodePort.copyProperties(nodePortMgr.queryNodePort(nodePort.getNodePortId()));
        NodeOutputPort richNodePort = new NodeOutputPort(nodePort, outputPort);

        if (richNodePort.isDataTablePort()) {
            NodeSchemaHelper.createSchema(workflowContext, node, richNodePort);
        }

        return richNodePort;
    }

    public void createNodePorts(WorkflowContext workflowContext, Node node) {

        Module module = node.getModule();
        //节点输入端口
        if (module.inputPortCount() > 0) {
            List<ModulePort> inputPorts = module.getInputPorts();
            for (ModulePort inputPort : inputPorts) {
                NodeInputPort inputNodePort = createInputPort(workflowContext, node, inputPort);
                node.putInputNodePort(inputNodePort);
                workflowContext.putInputPort(inputNodePort);
            }
        }

        //节点输出端口
        if (module.outputPortCount() > 0) {
            List<ModulePort> outputPorts = module.getOutputPorts();
            for (ModulePort outputPort : outputPorts) {
                NodeOutputPort outputNodePort = createOutputPort(workflowContext, node, outputPort);
                node.putOutputNodePort(outputNodePort);
                workflowContext.putOutputPort(outputNodePort);
            }
        }
    }
}
