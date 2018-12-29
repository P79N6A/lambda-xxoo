package com.yatop.lambda.workflow.engine.editor.node.port;

import com.yatop.lambda.core.mgr.workflow.node.NodePortMgr;
import com.yatop.lambda.workflow.core.context.WorkflowContext;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.Node;
import com.yatop.lambda.workflow.engine.editor.node.port.schema.SchemaQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NodePortQuery {

    @Autowired
    private NodePortMgr nodePortMgr;

    @Autowired
    private SchemaQuery schemaQuery;

    public void queryNodePort(WorkflowContext workflowContext, Node node) {

    }
}
