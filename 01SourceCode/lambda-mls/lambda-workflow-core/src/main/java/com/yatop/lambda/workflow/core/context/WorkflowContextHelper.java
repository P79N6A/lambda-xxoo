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

    protected static void loadUpstreamNodes(WorkflowContext workflowContext, Node node) {
        if(workflowContext.isLazyLoadMode()) {
            //List<NodeLink> nodeLinks = WorkflowContextHelper.LINK_QUERY.queryInLinks(workflowContext, node);
            if (DataUtil.isNotEmpty(nodeLinks)) {
                for (NodeLink nodeLink : nodeLinks) {
                    loadOneNode(workflowContext, nodeLink.data().getSrcNodeId());
                }
            }
        }
    }

    protected static void loadDownstreamNodes(WorkflowContext workflowContext, Node node) {
        if(workflowContext.isLazyLoadMode()) {
            //List<NodeLink> nodeLinks = WorkflowContextHelper.LINK_QUERY.queryOutLinks(workflowContext, node);
            if (DataUtil.isNotEmpty(nodeLinks)) {
                for (NodeLink nodeLink : nodeLinks) {
                    loadOneNode(workflowContext, nodeLink.data().getDstNodeId());
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

    protected static void loadInputPort(WorkflowContext workflowContext, Long portId) {
        if(workflowContext.isLazyLoadMode()) {
            WorkflowContextHelper.NODE_PORT_QUERY.queryInputNodePort(workflowContext, portId);
        }
    }

    protected static void loadOutputPort(WorkflowContext workflowContext, Long portId) {
        if(workflowContext.isLazyLoadMode()) {
            WorkflowContextHelper.NODE_PORT_QUERY.queryOutputNodePort(workflowContext, portId);
        }
    }

/*    protected static void loadUpstreamNonWebPort(WorkflowContext workflowContext, Long dstPortId) {
        if(workflowContext.isLazyLoadMode()) {
            NodeLink nodeLink = workflowContext.fetchNonWebInLink(dstPortId);
            WorkflowContextHelper.NODE_PORT_QUERY.queryOutputNodePort(workflowContext, nodeLink.data().getSrcPortId());
        }
    }

    protected static void loadUpstreamWebPort(WorkflowContext workflowContext, Long dstPortId) {
        if(workflowContext.isLazyLoadMode()) {
            NodeLink nodeLink = workflowContext.fetchWebInLink(dstPortId);
            WorkflowContextHelper.NODE_PORT_QUERY.queryOutputNodePort(workflowContext, nodeLink.data().getSrcPortId());
        }
    }*/

    protected static void loadUpstreamPorts(WorkflowContext workflowContext, Long dstPortId) {
        if(workflowContext.isLazyLoadMode()) {
            List<NodeLink> nodeLinks = workflowContext.fetchInLinks(dstPortId);
            if(DataUtil.isNotEmpty(nodeLinks)) {
                for(NodeLink nodeLink : nodeLinks) {
                    WorkflowContextHelper.loadOutputPort(workflowContext, nodeLink.data().getSrcPortId());
                }
            }
        }
    }

    protected static void loadDownstreamPorts(WorkflowContext workflowContext, Long srcPortId) {
        if(workflowContext.isLazyLoadMode()) {
            List<NodeLink> nodeLinks = workflowContext.getOutLinks(srcPortId);
            if(DataUtil.isNotEmpty(nodeLinks)) {
                for(NodeLink nodeLink : nodeLinks) {
                    WorkflowContextHelper.loadInputPort(workflowContext, nodeLink.data().getDstPortId());
                }
            }
        }
    }
}
