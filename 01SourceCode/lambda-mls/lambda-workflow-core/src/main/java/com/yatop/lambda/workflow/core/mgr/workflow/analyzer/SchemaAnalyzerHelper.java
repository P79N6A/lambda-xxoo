package com.yatop.lambda.workflow.core.mgr.workflow.analyzer;

import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.context.WorkflowContext;
import com.yatop.lambda.workflow.core.mgr.workflow.node.port.schema.SchemaHelper;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.Node;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.NodePortOutput;
import com.yatop.lambda.workflow.core.utils.CollectionUtil;

import java.util.Deque;
import java.util.List;

public class SchemaAnalyzerHelper {

    public static void analyzeSchema(WorkflowContext workflowContext, Node node) {
        SchemaHelper.analyzeSchema(workflowContext, node);
    }

    public static void searchDownstreamNodes(WorkflowContext workflowContext, Node currentNode, Deque<Node> analyzeStack) {
        if(DataUtil.isNull(currentNode) || !currentNode.needAnalyzeSchema())
            return;

        for(NodePortOutput outputDataPort : currentNode.getOutputDataTablePorts()) {
            //仅数据输出端口为schema changed时，找出端口下游节点
            if(outputDataPort.isSchemaChanged()) {
                List<Node> downstreamNodes = workflowContext.fetchDownstreamNodes(outputDataPort);
                if(DataUtil.isNotEmpty(downstreamNodes)) {
                    for (Node downstreamNode : downstreamNodes) {
                        if(downstreamNode.needAnalyzeSchema())
                            CollectionUtil.offerLast(analyzeStack, downstreamNode);
                    }
                }
            }
        }
    }
}
