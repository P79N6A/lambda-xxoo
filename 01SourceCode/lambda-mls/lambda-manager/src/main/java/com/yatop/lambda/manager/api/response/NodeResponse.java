package com.yatop.lambda.manager.api.response;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yatop.lambda.base.model.CfComponent;
import com.yatop.lambda.base.model.WfModule;
import com.yatop.lambda.workflow.core.context.WorkflowContext;
import com.yatop.lambda.workflow.core.richmodel.workflow.module.Module;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.Node;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.NodeInputPort;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.NodeOutputPort;

/**
 * 节点端口返回
 *
 * @author huangyu
 * @create 2019-03-05-20:28
 */
public class NodeResponse {
    /**
     * @param context 工作流上下文
     * @param nodes   节点
     */
    public static void dumpNodes(WorkflowContext context, JSONArray nodes, Boolean flag) {
        if (context.nodeCount() > 0) {
            for (Node node : context.getNodes()) {
                JSONObject jnode = node.toJSON();

                JSONArray inPorts = new JSONArray(node.inputNodePortCount());
                if (node.inputNodePortCount() > 0) {
                    for (NodeInputPort port : node.getInputNodePorts()) {
                        JSONObject jport = port.toJSON();
                        jport.put("portDef", port.getModulePort().toJSON());
                        jport.put("type", port.getCmptChar().getType().data().getCharTypeId());
                        inPorts.add(jport);
                    }
                }

                JSONArray outPorts = new JSONArray(node.outputNodePortCount());
                if (node.outputNodePortCount() > 0) {
                    for (NodeOutputPort port : node.getOutputNodePorts()) {
                        JSONObject jport = port.toJSON();
                        jport.put("portDef", port.getModulePort().toJSON());
                        jport.put("type", port.getCmptChar().getType().data().getCharTypeId());
                        outPorts.add(jport);
                    }
                }

                jnode.put("inPorts", inPorts);
                jnode.put("outPorts", outPorts);
                if (flag) {
                    WfModule data = node.getModule().data();

                    jnode.put("nodeState", node.data().getNodeState());
                    jnode.put("posX", node.data().getPositionX());
                    jnode.put("posY", node.data().getPositionY());
                    jnode.put("moduleCode", data.getModuleCode());
                    jnode.put("iconType", data.getIconType());
                    jnode.put("category", data.getCategory());
                }
                nodes.add(jnode);
            }
        }
    }
}
