package com.yatop.lambda.workflow.core.mgr.workflow.node.port.schema;

import com.yatop.lambda.core.enums.IsRequiredEnum;
import com.yatop.lambda.core.enums.LambdaExceptionEnum;
import com.yatop.lambda.core.exception.LambdaException;
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

        Node analyzeNode = null;
        while(DataUtil.isNotNull(analyzeNode = workflowContext.popAnalyzeNode())) {

            //非头结点创建时schema已经初始化为empty，这里仅对头结点schema做分析
            if(analyzeNode.needAnalyzeSchema() && analyzeNode.isHeadNode()) {
                SCHEMA_ANALYZE.analyzeSchema(workflowContext, analyzeNode);
                analyzeNode.markAnalyzed();
            }
        }
    }

    private static void searchDownstreamNodes(WorkflowContext workflowContext, Node currentNode, Deque<Node> analyzeStack) {

        for(NodePortOutput outputDataPort : currentNode.getOutputDataTablePorts()) {
            //仅数据输出端口为schema changed时，找出端口下游节点
            if(outputDataPort.isSchemaChanged()) {
                List<Node> downStreamNodes = workflowContext.fetchDownstreamNodes(outputDataPort);
                if(DataUtil.isNotEmpty(downStreamNodes)) {
                    for (Node downStreamNode : downStreamNodes) {
                        if(downStreamNode.needAnalyzeSchema())
                            CollectionUtil.offerLast(analyzeStack, downStreamNode);
                    }
                }
            }
        }
    }

    private static void analyzeOneNode4CreateAndUpdate(WorkflowContext workflowContext, Node currentNode, boolean isStartNode, Deque<Node> analyzeStack, Deque<Node> analyzePendingStack) {

        if(DataUtil.isNull(currentNode) || !currentNode.needAnalyzeSchema())
            return;

        TreeMap<Long, NodePortOutput> upstreamNonWebPorts = workflowContext.fetchNonWebUpstreamPorts(currentNode);
        for(NodePortInput inputDataPort : currentNode.getInputDataTablePorts()) {
            //仅对必须输入端口的上游端口状态做分析判断
            if(inputDataPort.getCmptChar().data().getIsRequired() == IsRequiredEnum.YES.getMark()) {
                NodePortOutput upstreamDataPort = CollectionUtil.get(upstreamNonWebPorts, inputDataPort.data().getNodePortId());
                if (DataUtil.isNotNull(upstreamDataPort)) {
                    if(!upstreamDataPort.isDataTablePort())
                        throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Schema Analyzer error -- Illegal upstream node port.", "系统数据异常，请联系管理员", upstreamDataPort, inputDataPort);

                    //起始节点，必须输入端口的上游端口schema state不是normal时，直接更改为empty
                    //非起始节点，必须输入端口的上游端口已分析且schema state不是normal时，直接更改为empty
                    if(isStartNode || upstreamDataPort.isAnalyzed()) {
                        if(!upstreamDataPort.getSchema().isStateNormal()) {
                            currentNode.changeSchemas2Empty();
                            currentNode.markAnalyzed();
                            searchDownstreamNodes(workflowContext, currentNode, analyzeStack);
                            return;
                        }

                        //起始节点或非起始节点（上游端口已分析），必须输入端口的上游端口schema state为normal时，继续确认下一必须输入端口的上游端口状况
                        continue;
                    } else {
                        //非起始节点，上游必须输入端口未分析，转入pending队列
                        CollectionUtil.offerLast(analyzePendingStack, currentNode);
                        return;
                    }
                } else {
                    //必须输入端口无对应数据流入时，无需分析该节点
                    return;
                }
            }
        }


        SCHEMA_ANALYZE.analyzeSchema(workflowContext, currentNode);
        currentNode.markAnalyzed();
        searchDownstreamNodes(workflowContext, currentNode, analyzeStack);
    }

    private static void analyzeStartNode4CreateAndUpdate(WorkflowContext workflowContext, Node startNode) {

        Deque<Node> analyzeStack = new LinkedList<Node>();
        Deque<Node> analyzePendingStack = new LinkedList<Node>();
        analyzeOneNode4CreateAndUpdate(workflowContext, startNode, true, analyzeStack, analyzePendingStack);

        Node currentNode = null;
        while(DataUtil.isNotNull(currentNode = CollectionUtil.pollLast(analyzeStack))) {
            analyzeOneNode4CreateAndUpdate(workflowContext, currentNode, false, analyzeStack, analyzePendingStack);
        }
    }

    public static void dealAnalyzeSchema4CreateLink(WorkflowContext workflowContext) {
        NodeLink analyzeLink = workflowContext.popAnalyzeLink();
        if(DataUtil.isNotNull(analyzeLink) && !analyzeLink.isWebLink()) {
            workflowContext.clearAnalyzeNodes();
            Node analyzeNode = workflowContext.fetchDownstreamNode(analyzeLink);
            analyzeStartNode4CreateAndUpdate(workflowContext, analyzeNode);
        }
    }

    public static void dealAnalyzeSchema4UpdateNodeParameter(WorkflowContext workflowContext) {
        Node analyzeNode = workflowContext.popAnalyzeNode();
        analyzeStartNode4CreateAndUpdate(workflowContext, analyzeNode);
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
