package com.yatop.lambda.workflow.core.mgr.workflow.node.port.schema;

import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.context.WorkflowContext;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.Node;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
            case COPY_WORKFLOW:
                dealAnalyzeSchema4CopyWokflow(workflowContext);
                break;
            default:
                break;
        }
    }

    public static void dealAnalyzeSchema4CreateNode(WorkflowContext workflowContext) {
        if(workflowContext.analyzeNodeCount() == 0)
            return;

        while(workflowContext.analyzeNodeCount() > 0) {

            Node analyzeNode = workflowContext.popAnalyzeNode();
            if()
            SCHEMA_ANALYZE.analyzeSchema(workflowContext, analyzeNode);
            analyzeNode.getOutputDataPorts();
        }
    }

    public static void dealAnalyzeSchema4CreateLink(WorkflowContext workflowContext) {

    }

    public static void dealAnalyzeSchema4UpdateNodeParameter(WorkflowContext workflowContext) {

    }

    public static void dealAnalyzeSchema4DeleteNode(WorkflowContext workflowContext) {

    }

    public static void dealAnalyzeSchema4DeleteLink(WorkflowContext workflowContext) {

    }

    public static void dealAnalyzeSchema4CopyWokflow(WorkflowContext workflowContext) {

    }
}
