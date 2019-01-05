package com.yatop.lambda.workflow.core.context;

import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.mgr.workflow.node.NodeQuery;
import com.yatop.lambda.workflow.core.mgr.workflow.node.link.LinkQuery;
import com.yatop.lambda.workflow.core.mgr.workflow.node.port.NodePortQuery;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.Node;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.NodeLink;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class WorkflowContextHelper {

    private static NodeQuery NODE_QUERY;
    private static LinkQuery LINK_QUERY;
    private static NodePortQuery NODE_PORT_QUERY;

    @Autowired
    void setNodeQuery(NodeQuery nodeQuery) {
        WorkflowContextHelper.NODE_QUERY = nodeQuery;
    }
    @Autowired
    void setLinkQuery(LinkQuery linkQuery) {
        WorkflowContextHelper.LINK_QUERY = linkQuery;
    }
    @Autowired
    void setNodePortQuery(NodePortQuery nodePortQuery) {
        WorkflowContextHelper.NODE_PORT_QUERY = nodePortQuery;
    }


/*    //inputNodePortId, node
    public TreeMap<Long, List<Node>> getUpstreamNodes(WorkflowContext workflowContext, Node node) {
        //loadUpstreamNodes(workflowContext, node);

        if(node.inputPortCount() > 0) {
            TreeMap<Long, Node> upstreamNodes = new TreeMap<Long, Node>();
            for(NodePortInput inputNodePort : node.getInputNodePorts()) {
                NodeLink inLink = workflowContext.getInLinks(inputNodePort.getNodePortId());
                CollectionUtil.put(upstreamNodes, inputNodePort.getNodePortId(), );
            }
        }
        return null;
    }

    //outputNodePortId, node
    public TreeMap<Long, Node> getDownstreamNodes(Node node) {

    }*/

    protected static void loadAllNodes(WorkflowContext workflowContext) {
        if(!workflowContext.isLazyLoadMode()) {
            WorkflowContextHelper.NODE_QUERY.queryNodes(workflowContext);
        }
    }

    protected static void loadOneNode(WorkflowContext workflowContext, Long nodeId) {
        if(workflowContext.isLazyLoadMode()) {
            WorkflowContextHelper.NODE_QUERY.queryNode(workflowContext, nodeId);
        }
    }

    protected static void loadUpstreamNode(WorkflowContext workflowContext, NodeLink nodeLink) {
        if(workflowContext.isLazyLoadMode()) {
            WorkflowContextHelper.NODE_QUERY.queryNode(workflowContext, nodeLink.getSrcNodeId());
        }
    }

    protected static void loadUpstreamNodes(WorkflowContext workflowContext, Node node) {
        if(workflowContext.isLazyLoadMode()) {
            List<NodeLink> nodeLinks = WorkflowContextHelper.LINK_QUERY.queryInLinks(workflowContext, node);
            if (DataUtil.isNotEmpty(nodeLinks)) {
                for (NodeLink nodeLink : nodeLinks) {
                    loadUpstreamNode(workflowContext, nodeLink);
                }
            }
        }
    }

    protected static void loadDownstreamNode(WorkflowContext workflowContext, NodeLink nodeLink) {
        if(workflowContext.isLazyLoadMode()) {
            WorkflowContextHelper.NODE_QUERY.queryNode(workflowContext, nodeLink.getDstNodeId());
        }
    }

    protected static void loadDownstreamNodes(WorkflowContext workflowContext, Node node) {
        if(workflowContext.isLazyLoadMode()) {
            List<NodeLink> nodeLinks = WorkflowContextHelper.LINK_QUERY.queryOutLinks(workflowContext, node);
            if (DataUtil.isNotEmpty(nodeLinks)) {
                for (NodeLink nodeLink : nodeLinks) {
                    loadDownstreamNode(workflowContext, nodeLink);
                }
            }
        }
    }

    protected static void loadAllLinks(WorkflowContext workflowContext) {
        if(!workflowContext.isLazyLoadMode()) {
            WorkflowContextHelper.LINK_QUERY.queryLinks(workflowContext);
        }
    }

    protected static void loadOneLink(WorkflowContext workflowContext, Long linkId) {
        if(workflowContext.isLazyLoadMode()) {
            WorkflowContextHelper.LINK_QUERY.queryLink(workflowContext, linkId);
        }
    }

    protected static void loadInLinks(WorkflowContext workflowContext, Long dstNodePortId) {
        if(workflowContext.isLazyLoadMode()) {
            WorkflowContextHelper.LINK_QUERY.queryInLinks(workflowContext, dstNodePortId);
        }
    }

    protected static void loadInLinks(WorkflowContext workflowContext, Node dstNode) {
        if(workflowContext.isLazyLoadMode()) {
            WorkflowContextHelper.LINK_QUERY.queryInLinks(workflowContext, dstNode);
        }
    }

    protected static void loadOutLinks(WorkflowContext workflowContext, Long srcNodePortId) {
        if(workflowContext.isLazyLoadMode()) {
            WorkflowContextHelper.LINK_QUERY.queryOutLinks(workflowContext, srcNodePortId);
        }
    }

    protected static void loadOutLinks(WorkflowContext workflowContext, Node srcNode) {
        if(workflowContext.isLazyLoadMode()) {
            WorkflowContextHelper.LINK_QUERY.queryOutLinks(workflowContext, srcNode);
        }
    }

    protected static void loadUpstreamNonWebPort(WorkflowContext workflowContext, Long dstPortId) {
        if(workflowContext.isLazyLoadMode()) {
            NodeLink nodeLink = workflowContext.getNonWebInLink(dstPortId);
            WorkflowContextHelper.NODE_PORT_QUERY.queryOutputNodePort(workflowContext, nodeLink.getSrcPortId());
        }
    }

    protected static void loadUpstreamWebPort(WorkflowContext workflowContext, Long dstPortId) {
        if(workflowContext.isLazyLoadMode()) {
            NodeLink nodeLink = workflowContext.getWebInLink(dstPortId);
            WorkflowContextHelper.NODE_PORT_QUERY.queryOutputNodePort(workflowContext, nodeLink.getSrcPortId());
        }
    }

    protected static void loadUpstreamPorts(WorkflowContext workflowContext, Long dstPortId) {
        if(workflowContext.isLazyLoadMode()) {
            List<NodeLink> nodeLinks = workflowContext.getInLinks(dstPortId);
            if(DataUtil.isNotEmpty(nodeLinks)) {
                for(NodeLink nodeLink : nodeLinks) {
                    WorkflowContextHelper.NODE_PORT_QUERY.queryOutputNodePort(workflowContext, nodeLink.getSrcPortId());
                }
            }
        }
    }

    protected static void loadDownstreamPorts(WorkflowContext workflowContext, Long srcPortId) {
        if(workflowContext.isLazyLoadMode()) {
            List<NodeLink> nodeLinks = workflowContext.getInLinks(srcPortId);
            if(DataUtil.isNotEmpty(nodeLinks)) {
                for(NodeLink nodeLink : nodeLinks) {
                    WorkflowContextHelper.NODE_PORT_QUERY.queryInputNodePort(workflowContext, nodeLink.getDstPortId());
                }
            }
        }
    }
}
