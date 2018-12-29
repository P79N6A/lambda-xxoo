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
import com.yatop.lambda.workflow.engine.editor.node.port.schema.SchemaRecover;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NodePortRecover {

    @Autowired
    private NodePortMgr nodePortMgr;

    @Autowired
    private SchemaRecover schemaRecover;

    public void recoverNodePort(WorkflowContext workflowContext, Node node) {

        Module module = node.getModule();
        if(node.inputNodePortCount() > 0 || node.outputNodePortCount() > 0) {
            nodePortMgr.recoverNodePort(node, workflowContext.getOperId());

            List<WfFlowNodePort> nodePortList = nodePortMgr.queryNodePortByNodeId(node.getNodeId());
            if (DataUtil.isNull(nodePortList)) {
                throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Recover node port error -- node port list empty.", "节点端口信息缺失，请联系管理员");
            }

            for(WfFlowNodePort nodePort : nodePortList) {
                ModulePort modulePort = ModuleConfig.getModulePort(nodePort.getRefPortId());
                if(DataUtil.isNull(modulePort)) {
                    throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Recover node port error -- module port not found.", "节点端口信息错误，请联系管理员");
                }

                switch(PortTypeEnum.valueOf(modulePort.getPortType())) {
                    case INPUT_PORT:
                        node.putInputNodePort(new NodePortInput(nodePort, modulePort));
                        break;
                    case OUTPUT_PORT:
                        node.putOutputNodePort(new NodePortOutput(nodePort, modulePort));
                        break;
                }
            }

            schemaRecover.recoverSchemas(workflowContext, node);
        }
    }
}