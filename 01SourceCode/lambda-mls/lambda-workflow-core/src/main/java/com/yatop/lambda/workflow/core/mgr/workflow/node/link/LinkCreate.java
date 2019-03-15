package com.yatop.lambda.workflow.core.mgr.workflow.node.link;

import com.yatop.lambda.base.model.WfFlowNodeLink;
import com.yatop.lambda.core.enums.LambdaExceptionEnum;
import com.yatop.lambda.core.exception.LambdaException;
import com.yatop.lambda.core.mgr.workflow.node.NodeLinkMgr;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.context.WorkflowContext;
import com.yatop.lambda.workflow.core.context.WorkflowContextHelper;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.Node;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.NodeInputPort;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.NodeLink;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.NodeOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LinkCreate {

    @Autowired
    NodeLinkMgr nodeLinkMgr;

    @Autowired
    LinkValidate linkValidate;

    public NodeLink createLink(WorkflowContext workflowContext, Node srcNode, Node dstNode, NodeOutputPort srcNodePort, NodeInputPort dstNodePort) {

        if(!linkValidate.validateLink(workflowContext, srcNode, dstNode, srcNodePort, dstNodePort)) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR,
                    "Create node link failed -- validation failed for establishing link.", "链接建立验证失败", srcNodePort.data(), dstNodePort.data());
        }

        WfFlowNodeLink nodeLink = new WfFlowNodeLink();
        nodeLink.setLinkName(String.format("From %d.%d to %d.%d", srcNode.data().getNodeId(),
                                                                  srcNodePort.data().getNodePortId(),
                                                                  dstNode.data().getNodeId(),
                                                                  dstNodePort.data().getNodePortId()));
        nodeLink.setOwnerFlowId(workflowContext.getWorkflow().data().getFlowId());
        nodeLink.setSrcNodeId(srcNode.data().getNodeId());
        nodeLink.setSrcPortId(srcNodePort.data().getNodePortId());
        nodeLink.setDstNodeId(dstNode.data().getNodeId());
        nodeLink.setDstPortId(dstNodePort.data().getNodePortId());
        nodeLink = nodeLinkMgr.insertLink(nodeLink, workflowContext.getOperId());
        //nodeLink.copyProperties(nodeLinkMgr.queryLink(nodeLink.getLinkId()));
        NodeLink richNodeLink = new NodeLink(nodeLink);
        workflowContext.doneCreateLink(richNodeLink);

        if(WorkflowContextHelper.existDirectedCyclicGraph(workflowContext)) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR,
                    "Create node link failed -- Create link will make workflow exists directed cyclic graph..",
                    "新建链接将产生有向循环图", srcNodePort.data(), dstNodePort.data());
        }
        return richNodeLink;
    }

    public NodeLink createLink(WorkflowContext workflowContext, Long srcNodeId, Long dstNodeId, Long srcNodePortId, Long dstNodePortId) {
        Node srcNode = workflowContext.fetchNode(srcNodeId);
        if(DataUtil.isNull(srcNode)) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR,
                    "Find workflow node failed -- source node not exists.", "源头节点不存在");
        }
        Node dstNode = workflowContext.fetchNode(dstNodeId);
        if(DataUtil.isNull(dstNode)) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR,
                    "Find workflow node failed -- destination node not exists.", "目的节点不存在");
        }

        NodeOutputPort srcNodePort = srcNode.getOutputNodePort(srcNodePortId);
        if(DataUtil.isNull(srcNodePort)) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR,
                    "Create node link failed -- source node port info missing.", "输出端口信息缺失", srcNode.data());
        }

        NodeInputPort dstNodePort = dstNode.getInputNodePort(dstNodePortId);
        if(DataUtil.isNull(dstNodePort)) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR,
                    "Create node link failed -- destination node port info missing.", "输入端口信息缺失", dstNode.data());
        }

        return createLink(workflowContext, srcNode, dstNode, srcNodePort, dstNodePort);
    }

    public void createLink4CopyNodes(WorkflowContext workflowContext, HashMap<Long, Node> nodeIndexTable) {

        if(nodeIndexTable.size() < 2)
            return;

        for(Map.Entry<Long, Node> entry : nodeIndexTable.entrySet()) {
            Long copyNodeId = entry.getKey();
            Node copyNode = workflowContext.getNode(copyNodeId);
            List<NodeLink> outLinks = workflowContext.fetchOutLinks(copyNode);

            if(DataUtil.isNotEmpty(outLinks)) {
                for(NodeLink copyLink : outLinks) {
                    Node downstreamNode = nodeIndexTable.get(copyLink.data().getDstNodeId());
                    if(DataUtil.isNotNull(downstreamNode)) {
                        Node dstCopyNode = workflowContext.getNode(copyLink.data().getDstNodeId());

                        Node upstreamNode = entry.getValue();
                        NodeOutputPort upstreamPort = upstreamNode.getOutputNodePort(copyNode.getOutputNodePort(copyLink.data().getSrcPortId()).getCmptChar().data().getCharId());
                        NodeInputPort downstreamPort = downstreamNode.getInputNodePort(dstCopyNode.getInputNodePort(copyLink.data().getDstPortId()).getCmptChar().data().getCharId());
                        this.createLink(workflowContext, upstreamNode, downstreamNode, upstreamPort, downstreamPort);
                    }
                }
            }
        }
    }
}
