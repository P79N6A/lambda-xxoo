package com.yatop.lambda.workflow.module.clazz.machine_learning.evaluation;


import com.yatop.lambda.workflow.core.context.WorkflowContext;
import com.yatop.lambda.workflow.core.framework.module.ModuleClazzClazzBase;
import com.yatop.lambda.workflow.core.richmodel.component.characteristic.CmptChar;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.Node;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.NodeSchema;

import java.util.TreeMap;
import java.util.TreeSet;

public class BinaryEvaluate extends ModuleClazzClazzBase {

    @Override
    public TreeMap<CmptChar, String> validateParameters(WorkflowContext workflowContext, Node node) {
        return null;
    }

    @Override
    public boolean supportAnalyzeSchema() {
        return false;
    }

    @Override
    public TreeSet<CmptChar> reanalyzeSchemaParameterSet() {
        return null;
    }

    @Override
    public TreeMap<CmptChar, NodeSchema> analyzeSchema(WorkflowContext workflowContext, Node node) {
        return null;
    }
}
