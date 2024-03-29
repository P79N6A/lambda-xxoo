package com.yatop.lambda.workflow.core.mgr.workflow.node.link;

import com.yatop.lambda.base.model.WfFlowNodeLink;
import com.yatop.lambda.core.enums.LambdaExceptionEnum;
import com.yatop.lambda.core.exception.LambdaException;
import com.yatop.lambda.core.mgr.workflow.node.NodeLinkMgr;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.context.WorkflowContext;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.Node;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.NodeInputPort;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.NodeLink;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.NodeOutputPort;
import com.yatop.lambda.workflow.core.utils.CollectionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LinkQuery {

    @Autowired
    NodeLinkMgr nodeLinkMgr;

    private NodeLink doneQueryLink(WorkflowContext workflowContext, WfFlowNodeLink nodeLink) {
        if(DataUtil.isNull(nodeLink)) {
            return null;
        }

        NodeLink richNodeLink = workflowContext.getLink(nodeLink.getLinkId());
        if(DataUtil.isNotNull(richNodeLink)) {
            return richNodeLink;
        }

        richNodeLink = new NodeLink(nodeLink);
        NodeOutputPort outputNodePort = workflowContext.fetchUpstreamPort(richNodeLink);
        NodeInputPort inputNodePort = workflowContext.fetchDownstreamPort(richNodeLink);
        if(!outputNodePort.matchTargetInputPort(inputNodePort)) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query node link failed -- source node port vs destination node port were mismatched", "链接信息错误", outputNodePort.data(), inputNodePort.data());
        }

        workflowContext.putLink(richNodeLink);
        return richNodeLink;
    }

    public NodeLink queryLink(WorkflowContext workflowContext, Long linkId) {
        NodeLink richNodeLink = workflowContext.getLink(linkId);
        if(DataUtil.isNotNull(richNodeLink))
            return richNodeLink;

        WfFlowNodeLink nodeLink = nodeLinkMgr.queryLink(linkId);
        if(DataUtil.isNull(nodeLink)) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, String.format("Query node link failed -- node link not found, link-id:%d.", linkId), "链接信息缺失");
        }
        return doneQueryLink(workflowContext, nodeLink);
    }

    public void queryLinks(WorkflowContext workflowContext) {
        List<WfFlowNodeLink> nodeLinks = nodeLinkMgr.queryLink(workflowContext.getWorkflow().data().getFlowId(), null);
        if(DataUtil.isEmpty(nodeLinks)) {
            return;
        }

        for(WfFlowNodeLink nodeLink : nodeLinks) {
            doneQueryLink(workflowContext, nodeLink);
        }
    }

    private List<NodeLink> doneQueryLinks(WorkflowContext workflowContext, List<WfFlowNodeLink> nodeLinks) {
        if(DataUtil.isEmpty(nodeLinks)) {
            return null;
        }

        List<NodeLink> richLinks = new ArrayList<NodeLink>(nodeLinks.size());
        for(WfFlowNodeLink nodeLink : nodeLinks) {
            CollectionUtil.add(richLinks, doneQueryLink(workflowContext, nodeLink));
        }
        return richLinks;
    }

    public List<NodeLink> queryOutLinks(WorkflowContext workflowContext, Long srcNodePortId) {

        //List<NodeLink> outLinks = workflowContext.getOutLinks(srcNodePortId);
        //if(DataUtil.isNotEmpty(outLinks))
        //    return outLinks;

        return doneQueryLinks(workflowContext, nodeLinkMgr.queryLinkBySrcPortId(srcNodePortId));
    }

    public List<NodeLink> queryOutLinks(WorkflowContext workflowContext, Node srcNode) {

        if(srcNode.isTailNode())
            return null;

        return doneQueryLinks(workflowContext, nodeLinkMgr.queryLinkBySrcNodeId(srcNode.data().getNodeId()));
    }

    public NodeLink queryInLink(WorkflowContext workflowContext, Long dstNodePortId) {

        NodeLink inLink = workflowContext.getInLink(dstNodePortId);
        if(DataUtil.isNotNull(inLink))
           return inLink;

        WfFlowNodeLink nodeLink = nodeLinkMgr.queryLinkByDstPortId(dstNodePortId);
        if(DataUtil.isNull(nodeLink))
            return null;

        return doneQueryLink(workflowContext, nodeLinkMgr.queryLinkByDstPortId(dstNodePortId));
    }

    public List<NodeLink> queryInLinks(WorkflowContext workflowContext, Node dstNode) {
        if(dstNode.isHeadNode())
            return null;

        return doneQueryLinks(workflowContext, nodeLinkMgr.queryLinkByDstNodeId(dstNode.data().getNodeId()));
    }
}
