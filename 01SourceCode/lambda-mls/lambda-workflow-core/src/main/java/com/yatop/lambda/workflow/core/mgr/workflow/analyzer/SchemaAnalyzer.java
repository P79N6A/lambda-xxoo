package com.yatop.lambda.workflow.core.mgr.workflow.analyzer;

import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.context.WorkflowContext;
import com.yatop.lambda.workflow.core.mgr.workflow.module.AnalyzeNodeStateHelper;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.Node;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.NodeInputPort;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.NodeLink;

import java.util.*;

public class SchemaAnalyzer {

    public static void freshWorkflow(WorkflowContext workflowContext) {
        dealAnalyzeSchema4RefreshWorkflow(workflowContext);
    }

    public static void dealAnalyzeSchema(WorkflowContext workflowContext) {
        switch (workflowContext.getAnalyzeType()) {
            case CREATE_NODE:
                dealAnalyzeSchema4CreateNode(workflowContext);
                break;
            case CREATE_LINK:
                dealAnalyzeSchema4CreateLink(workflowContext);
                break;
            case UPDATE_NODE_PARAMETER:
                dealAnalyzeSchema4UpdateNodeParameter(workflowContext);
                break;
            case DELETE_NODE:
                dealAnalyzeSchema4DeleteNode(workflowContext);
                break;
            case DELETE_LINK:
                dealAnalyzeSchema4DeleteLink(workflowContext);
                break;
            case REFRESH_WORKFLOW:
                dealAnalyzeSchema4RefreshWorkflow(workflowContext);
                break;
            default:
                break;
        }
    }

    private static void dealAnalyzeSchema4CreateNode(WorkflowContext workflowContext) {

        List<Node> startNodes = searchAddedStartNodes(workflowContext);
        if(DataUtil.isNotEmpty(startNodes)) {
            for(Node startNode : startNodes) {
                if(SchemaAnalyzerHelper.needAnalyzeNode(startNode)) {
                    SchemaAnalyzer4CreateNode$RefreshWorkflow.analyzeStartNode(workflowContext, startNode);
                }
            }
        }
    }

    private static void dealAnalyzeSchema4CreateLink(WorkflowContext workflowContext) {
        NodeLink analyzeLink = workflowContext.popAnalyzeLink();
        if(DataUtil.isNotNull(analyzeLink)) {
            Node analyzeNode = workflowContext.fetchDownstreamNode(analyzeLink);
            SchemaAnalyzer4CreateLink$UpdateParameter.analyzeStartNode(workflowContext, analyzeNode);
        }
    }

    private static void dealAnalyzeSchema4UpdateNodeParameter(WorkflowContext workflowContext) {
        Node analyzeNode = workflowContext.popAnalyzeNode();
        SchemaAnalyzer4CreateLink$UpdateParameter.analyzeStartNode(workflowContext, analyzeNode);
    }

    private static void dealAnalyzeSchema4DeleteNode(WorkflowContext workflowContext) {

        Node deleteNode = null;
        while (DataUtil.isNotNull(deleteNode = workflowContext.popAnalyzeNode())) {
            if(SchemaAnalyzerHelper.needAnalyzeNode(deleteNode)) {
                List<Node> downstreamNodes =  SchemaAnalyzer4DeleteNode$DeleteLink.searchDownstreamNodes(workflowContext, deleteNode);
                if(DataUtil.isNotEmpty(downstreamNodes)) {
                    for(Node downstreamNode : downstreamNodes)
                        SchemaAnalyzer4DeleteNode$DeleteLink.analyzeStartNode(workflowContext, downstreamNode);
                }
            }
        }
    }

    private static void dealAnalyzeSchema4DeleteLink(WorkflowContext workflowContext) {

        NodeLink deleteLink = null;
        while(DataUtil.isNotNull(deleteLink = workflowContext.popAnalyzeLink())) {

            Node downstreamNode = workflowContext.fetchDownstreamNode(deleteLink);
            SchemaAnalyzer4DeleteNode$DeleteLink.analyzeStartNode(workflowContext, downstreamNode);
        }
    }

    private static void dealAnalyzeSchema4RefreshWorkflow(WorkflowContext workflowContext) {

        List<Node> startNodes = searchStartNodes$analyzeNodes(workflowContext);
        if(DataUtil.isNotEmpty(startNodes)) {
            for(Node startNode : startNodes) {
                if(SchemaAnalyzerHelper.needAnalyzeNode(startNode)) {
                    SchemaAnalyzer4CreateNode$RefreshWorkflow.analyzeStartNode(workflowContext, startNode);
                }
            }
        }
    }

    public static List<Node> searchStartNodes$analyzeNodes(WorkflowContext workflowContext) {
        if(workflowContext.nodeCount() == 0)
            return null;

        List<Node> startNodes = new ArrayList<Node>();
        for(Node node : workflowContext.getNodes()) {
            AnalyzeNodeStateHelper.analyzeInputPortAndParameter(workflowContext, node);

            if(node.haveOutputDataTablePort()) {
                boolean push2startNodes = true;
                List<NodeInputPort> dataInputPorts = node.getInputDataTablePorts();
                if(DataUtil.isNotEmpty(dataInputPorts)) {
                    for(NodeInputPort dataInputPort : dataInputPorts) {
                        if (DataUtil.isNotNull(workflowContext.fetchInLink(dataInputPort))) {
                            push2startNodes = false;
                            break;
                        }
                    }
                }

                if(push2startNodes) {
                    startNodes.add(node);
                }
            }
        }
        return startNodes;
    }

    public static List<Node> searchAddedStartNodes(WorkflowContext workflowContext) {

        List<Node> startNodes = new ArrayList<Node>();
        Node addedNode = null;
        while(DataUtil.isNotNull(addedNode = workflowContext.popAnalyzeNode())) {
            if(addedNode.haveOutputDataTablePort()) {
                boolean push2startNodes = true;
                List<NodeInputPort> dataInputPorts = addedNode.getInputDataTablePorts();
                if(DataUtil.isNotEmpty(dataInputPorts)) {
                    for(NodeInputPort dataInputPort : dataInputPorts) {
                        if (DataUtil.isNotNull(workflowContext.fetchInLink(dataInputPort))) {
                            push2startNodes = false;
                            break;
                        }
                    }
                }

                if(push2startNodes) {
                    startNodes.add(addedNode);
                }
            }
        }
        return startNodes;
    }
}
