package com.yatop.lambda.workflow.core.mgr.workflow.node.port.schema;

import com.yatop.lambda.core.enums.IsRequiredEnum;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.context.WorkflowContext;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.Node;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.NodeLink;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.NodePortInput;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.NodePortOutput;
import com.yatop.lambda.workflow.core.utils.CollectionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

@Component
public class SchemaAnalyzer {

    private static  SchemaAnalyze SCHEMA_ANALYZE;

    @Autowired
    public void setSchemaAnalyze(SchemaAnalyze schemaAnalyze) {
        SchemaAnalyzer.SCHEMA_ANALYZE = schemaAnalyze;
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
            case COMPILE_WORKFLOW:
                dealAnalyzeSchema4CompileWorkflow(workflowContext);
                break;
            default:
                break;
        }
    }

    public static void dealAnalyzeSchema4CreateNode(WorkflowContext workflowContext) {

        Node analyzeNode;
        while(DataUtil.isNotNull(analyzeNode = workflowContext.popAnalyzeNode())) {
            if(SchemaHelper.needAnalyzeSchema(analyzeNode)
                    && analyzeNode.isHeadNode() //非头结点创建时schema已经初始化为empty
                    && !analyzeNode.isAnalyzed()) {
                SCHEMA_ANALYZE.analyzeSchema(workflowContext, analyzeNode);
                analyzeNode.markAnalyzed();
            }
        }
    }

    private static void searchDownStreamNodes(WorkflowContext workflowContext, Node currentNode, Deque<Node> analyzeStack) {

        for(NodePortOutput outputDataPort : currentNode.getOutputDataTablePorts()) {
            if(outputDataPort.isSchemaChanged()) {
                List<Node> downStreamNodes = workflowContext.fetchDownstreamNodes(outputDataPort);
                if(DataUtil.isNotEmpty(downStreamNodes)) {
                    for (Node downStreamNode : downStreamNodes) {
                        if(SchemaHelper.needAnalyzeSchema(downStreamNode) && !downStreamNode.isAnalyzed())
                            CollectionUtil.offerLast(analyzeStack, downStreamNode);
                    }
                }
            }
        }
    }

    private static void analyzeSchemaByStartNode(WorkflowContext workflowContext, Node startNode) {

        if(DataUtil.isNotNull(startNode) && !startNode.isWebNode()) {
            if(SchemaHelper.needAnalyzeSchema(startNode) && !startNode.isAnalyzed()) {
                SCHEMA_ANALYZE.analyzeSchema(workflowContext, startNode);
                startNode.markAnalyzed();

                Deque<Node> analyzeStack = new LinkedList<Node>();
                Deque<Node> analyzePendingStack = new LinkedList<Node>();
                searchDownStreamNodes(workflowContext, startNode, analyzeStack);

                Node currentNode = null;
                while(DataUtil.isNotNull(currentNode = CollectionUtil.pollLast(analyzeStack))) {
                    boolean ready = true;
                    TreeMap<Long, NodePortOutput> upstreamPorts = workflowContext.fetchNonWebUpstreamPorts(currentNode);
                    for(NodePortInput inputDataPort : currentNode.getInputDataTablePorts()) {
                        if(inputDataPort.getCmptChar().data().getIsRequired() == IsRequiredEnum.YES.getMark()) {
                            NodePortOutput upstreamDataPort = CollectionUtil.get(upstreamPorts, inputDataPort.data().getNodePortId());
                            if (DataUtil.isNull(upstreamDataPort) || !upstreamDataPort.isDataTablePort()) {
                                if(upstreamDataPort.isAnalyzed()) {
                                    if(upstreamDataPort.getSchema().isStateNormal()) {
                                        ready = true;
                                    } else if(upstreamDataPort) {
                                        currentNode.changeSchemas2Empty();
                                    }
                                } else {
                                    ready = false;
                                }
                            } else {
                                ready = false;
                            }
                        }
                    }
                }
            }
        }
    }

    public static void dealAnalyzeSchema4CreateLink(WorkflowContext workflowContext) {
        NodeLink analyzeLink = workflowContext.popAnalyzeLink();
        workflowContext.clearAnalyzeLinks();
        if(DataUtil.isNotNull(analyzeLink) && !analyzeLink.isWebLink()) {
            workflowContext.clearAnalyzeNodes();
            Node analyzeNode = workflowContext.fetchDownstreamNode(analyzeLink);
            analyzeSchemaByStartNode(workflowContext, analyzeNode);
        }
    }

    public static void dealAnalyzeSchema4UpdateNodeParameter(WorkflowContext workflowContext) {
        Node analyzeNode = workflowContext.popAnalyzeNode();
        workflowContext.clearAnalyzeNodes();
        analyzeSchemaByStartNode(workflowContext, analyzeNode);
    }

    public static void dealAnalyzeSchema4DeleteNode(WorkflowContext workflowContext) {
        //TODO 一路clear下去
    }

    public static void dealAnalyzeSchema4DeleteLink(WorkflowContext workflowContext) {
        //TODO 一路clear下去
    }

    public static void dealAnalyzeSchema4CompileWorkflow(WorkflowContext workflowContext) {
        //TODO 从头节点开始分析
    }
}
