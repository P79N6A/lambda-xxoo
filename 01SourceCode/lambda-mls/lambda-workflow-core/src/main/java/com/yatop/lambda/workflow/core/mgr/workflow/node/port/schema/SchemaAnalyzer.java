package com.yatop.lambda.workflow.core.mgr.workflow.node.port.schema;

import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.context.WorkflowContext;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.Node;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.NodeLink;
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
            case REFRESH_WORKFLOW:
                dealAnalyzeSchema4RefreshWokflow(workflowContext);
                break;
            default:
                break;
        }
    }

    public static void dealAnalyzeSchema4CreateNode(WorkflowContext workflowContext) {

        Node analyzeNode;
        while(DataUtil.isNotNull(analyzeNode = workflowContext.popAnalyzeNode())) {
            if(analyzeNode.isHeadNode() && analyzeNode.haveOutputDataTablePort() && !analyzeNode.isAnalyzed()) {
                SCHEMA_ANALYZE.analyzeSchema(workflowContext, analyzeNode);
                analyzeNode.markAnalyzed();
            }
        }
    }

    public static void dealAnalyzeSchema4CreateLink(WorkflowContext workflowContext) {
        NodeLink analyzeLink = workflowContext.popAnalyzeLink();
        if(DataUtil.isNotNull(analyzeLink) && !analyzeLink.isWebLink()) {
            workflowContext.clearAnalyzeNodes();
            Node analyzeNode = workflowContext.fetchDownstreamNode(analyzeLink);
            if(!analyzeNode.isAnalyzed()) {
                SCHEMA_ANALYZE.analyzeSchema(workflowContext, analyzeNode);
                analyzeNode.markAnalyzed();

                //TODO ....
            }
        }
    }

    public static void dealAnalyzeSchema4UpdateNodeParameter(WorkflowContext workflowContext) {

    }

    public static void dealAnalyzeSchema4DeleteNode(WorkflowContext workflowContext) {

    }

    public static void dealAnalyzeSchema4DeleteLink(WorkflowContext workflowContext) {

    }

    public static void dealAnalyzeSchema4RefreshWokflow(WorkflowContext workflowContext) {

    }
}
