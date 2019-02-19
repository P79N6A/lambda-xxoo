package com.yatop.lambda.workflow.core.mgr.workflow.node.port;

import com.yatop.lambda.base.model.WfFlowNodePort;
import com.yatop.lambda.core.enums.LambdaExceptionEnum;
import com.yatop.lambda.core.enums.PortTypeEnum;
import com.yatop.lambda.core.exception.LambdaException;
import com.yatop.lambda.core.mgr.workflow.node.NodePortMgr;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.config.ModuleConfig;
import com.yatop.lambda.workflow.core.context.WorkflowContext;
import com.yatop.lambda.workflow.core.richmodel.workflow.module.Module;
import com.yatop.lambda.workflow.core.richmodel.workflow.module.ModulePort;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.Node;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.NodeInputPort;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.NodeOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NodePortQuery {

    @Autowired
    private NodePortMgr nodePortMgr;

    @Autowired
    private ModuleConfig moduleConfig;

    public void queryNodePorts(WorkflowContext workflowContext, Node node) {

        Module module = node.getModule();
        if(module.inputPortCount() > 0 || module.outputPortCount() > 0) {

            List<WfFlowNodePort> nodePortList = nodePortMgr.queryNodePortByNodeId(node.data().getNodeId());
            if (DataUtil.isEmpty(nodePortList)) {
                throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query node port failed -- node port list empty.", "节点端口信息缺失", node.data());
            }

            for(WfFlowNodePort nodePort : nodePortList) {
                ModulePort modulePort = moduleConfig.getModulePort(nodePort.getRefPortId());
                if(DataUtil.isNull(modulePort) || !module.existsModulePort(modulePort)) {
                    throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query node port failed -- module port not found.", "节点端口信息错误", nodePort);
                }

                switch(PortTypeEnum.valueOf(modulePort.data().getPortType())) {
                    case INPUT_PORT:
                        NodeInputPort inputNodePort =  workflowContext.getInputPort(nodePort.getNodePortId());
                        if (DataUtil.isNull(inputNodePort)) {
                            inputNodePort = new NodeInputPort(nodePort, modulePort);
                            workflowContext.putInputPort(inputNodePort);
                        }
                        node.putInputNodePort(inputNodePort);
                        break;
                    case OUTPUT_PORT:
                        NodeOutputPort outputNodePort =  workflowContext.getOutputPort(nodePort.getNodePortId());
                        if (DataUtil.isNull(outputNodePort)) {
                            outputNodePort = new NodeOutputPort(nodePort, modulePort);
                            workflowContext.putOutputPort(outputNodePort);
                        }
                        node.putOutputNodePort(outputNodePort);
                        break;
                }
            }

            if(module.inputPortCount() != node.inputNodePortCount() || module.outputPortCount() != node.outputNodePortCount()) {
                throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query node port failed -- module-port vs node-port inconsistent.", "节点端口信息错误", node.data());
            }
        }
    }

    public NodeInputPort queryInputNodePort(WorkflowContext workflowContext, Long nodePortId) {

        NodeInputPort inputNodePort =  workflowContext.getInputPort(nodePortId);
        if (DataUtil.isNotNull(inputNodePort)) {
            return inputNodePort;
        }

        WfFlowNodePort nodePort = nodePortMgr.queryNodePort(nodePortId);
        if(DataUtil.isNull(nodePort)) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, String.format("Query node port failed -- node input port not found, node-port-id:\n%d.", nodePortId), "节点端口信息缺失");
        }

        ModulePort modulePort = moduleConfig.getModulePort(nodePort.getRefPortId());
        if(DataUtil.isNull(modulePort) || PortTypeEnum.valueOf(modulePort.data().getPortType()) != PortTypeEnum.INPUT_PORT) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query node port failed -- module port not found.", "节点端口信息错误", nodePort);
        }

        inputNodePort =  new NodeInputPort(nodePort, modulePort);
        workflowContext.putInputPort(inputNodePort);
        return inputNodePort;
    }

    public NodeOutputPort queryOutputNodePort(WorkflowContext workflowContext, Long nodePortId) {

        NodeOutputPort outputNodePort =  workflowContext.getOutputPort(nodePortId);
        if (DataUtil.isNotNull(outputNodePort)) {
            return outputNodePort;
        }

        WfFlowNodePort nodePort = nodePortMgr.queryNodePort(nodePortId);
        if(DataUtil.isNull(nodePort)) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, String.format("Query node port failed -- node output port not found, node-port-id:\n%d.", nodePortId), "节点端口信息缺失");
        }

        ModulePort modulePort = moduleConfig.getModulePort(nodePort.getRefPortId());
        if(DataUtil.isNull(modulePort) || PortTypeEnum.valueOf(modulePort.data().getPortType()) != PortTypeEnum.OUTPUT_PORT) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query node port failed -- module port not found.", "节点端口信息错误", nodePort);
        }

        outputNodePort = new NodeOutputPort(nodePort, modulePort);
        workflowContext.putOutputPort(outputNodePort);
        return outputNodePort;
    }
}
