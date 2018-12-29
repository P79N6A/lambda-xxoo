package com.yatop.lambda.workflow.engine.editor.node.port;

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
import com.yatop.lambda.workflow.core.richmodel.workflow.node.NodePortInput;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.NodePortOutput;
import com.yatop.lambda.workflow.engine.editor.node.port.schema.SchemaQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NodePortQuery {

    @Autowired
    private NodePortMgr nodePortMgr;

    @Autowired
    private SchemaQuery schemaQuery;

    public void queryNodePorts(WorkflowContext workflowContext, Node node) {

        Module module = node.getModule();
        if(module.inputPortCount() > 0 || module.outputPortCount() > 0) {

            List<WfFlowNodePort> nodePortList = nodePortMgr.queryNodePortByNodeId(node.getNodeId());
            if (DataUtil.isNull(nodePortList)) {
                throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query node port error -- node port list empty.", "节点端口信息缺失", node);
            }

            for(WfFlowNodePort nodePort : nodePortList) {
                ModulePort modulePort = ModuleConfig.getModulePort(nodePort.getRefPortId());
                if(DataUtil.isNull(modulePort)) {
                    throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query node port error -- module port not found.", "节点端口信息错误", nodePort);
                }

                switch(PortTypeEnum.valueOf(modulePort.getPortType())) {
                    case INPUT_PORT:
                        NodePortInput inputNodePort = new NodePortInput(nodePort, modulePort);
                        node.putInputNodePort(inputNodePort);
                        workflowContext.putInputPort(inputNodePort);
                        break;
                    case OUTPUT_PORT:
                        NodePortOutput outputNodePort = new NodePortOutput(nodePort, modulePort);
                        node.putOutputNodePort(outputNodePort);
                        workflowContext.putOutputPort(outputNodePort);
                        break;
                }
            }

            schemaQuery.querySchemas(workflowContext, node);
        }
    }

    public NodePortInput queryInputNodePort(WorkflowContext workflowContext, Long inputNodePortId) {

        WfFlowNodePort nodePort = nodePortMgr.queryNodePort(inputNodePortId);
        if(DataUtil.isNull(nodePort)) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, String.format("Query node port error -- node port not found, node-port-id:\n%d.", inputNodePortId), "节点端口信息缺失");
        }

        ModulePort modulePort = ModuleConfig.getModulePort(nodePort.getRefPortId());
        if(DataUtil.isNull(modulePort) || PortTypeEnum.valueOf(modulePort.getPortType()) != PortTypeEnum.INPUT_PORT) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query node port error -- module port not found.", "节点端口信息错误", nodePort);
        }

        NodePortInput inputNodePort =  new NodePortInput(nodePort, modulePort);
        workflowContext.putInputPort(inputNodePort);
        return inputNodePort;
    }

    public NodePortOutput queryOutputNodePort(WorkflowContext workflowContext, Long outputNodePortId) {

        WfFlowNodePort nodePort = nodePortMgr.queryNodePort(outputNodePortId);
        if(DataUtil.isNull(nodePort)) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, String.format("Query node port error -- node port not found, node-port-id:\n%d.", outputNodePortId), "节点端口信息缺失");
        }

        ModulePort modulePort = ModuleConfig.getModulePort(nodePort.getRefPortId());
        if(DataUtil.isNull(modulePort) || PortTypeEnum.valueOf(modulePort.getPortType()) != PortTypeEnum.OUTPUT_PORT) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query node port error -- module port not found.", "节点端口信息错误", nodePort);
        }

        NodePortOutput outputNodeport = new NodePortOutput(nodePort, modulePort);
        schemaQuery.querySchema(workflowContext, outputNodeport);
        workflowContext.putOutputPort(outputNodeport);
        return  outputNodeport;
    }
}
