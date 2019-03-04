package com.yatop.lambda.workflow.core.framework.module;

import com.yatop.lambda.workflow.core.config.ComponentConfig;
import com.yatop.lambda.workflow.core.config.ModuleConfig;
import com.yatop.lambda.workflow.core.context.ExecutionTaskContext;
import com.yatop.lambda.workflow.core.context.WorkflowContext;
import com.yatop.lambda.workflow.core.mgr.workflow.node.output.OutputAndResourceCreate;
import com.yatop.lambda.workflow.core.mgr.workflow.node.output.OutputAndResourceDelete;
import com.yatop.lambda.workflow.core.mgr.workflow.node.output.OutputAndResourceQuery;
import com.yatop.lambda.workflow.core.richmodel.component.characteristic.CmptChar;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.Node;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.NodeSchema;
import com.yatop.lambda.workflow.core.utils.CollectionUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.TreeMap;
import java.util.TreeSet;

public abstract class ModuleClazzClazzBase implements IModuleClazz {

    //<class-path, bean-object>
    private static final HashMap<String, IModuleClazz> CLAZZ_BEANS = new HashMap<String, IModuleClazz>();

    public static IModuleClazz getClazzBean(String clazzPath) {
        return CollectionUtil.get(CLAZZ_BEANS, clazzPath);
    }

    private static void putClazzBean(String clazzPath, IModuleClazz moduleBean) {
        CollectionUtil.put(CLAZZ_BEANS, clazzPath, moduleBean);
    }

    public ModuleClazzClazzBase() {
        ModuleClazzClazzBase.putClazzBean(this.getClass().getName(), this);
    }


    @Autowired
    ComponentConfig componentConfig;

    @Autowired
    ModuleConfig moduleConfig;

    @Autowired
    OutputAndResourceCreate outputAndResourceCreate;

    @Autowired
    OutputAndResourceQuery outputAndResourceQuery;

    @Autowired
    OutputAndResourceDelete outputAndResourceDelete;

    //
    //接口方法默认实现
    //

    @Override
    public TreeMap<CmptChar, String> validateParameters(WorkflowContext workflowContext, Node node) {
        return null;
    }

    @Override
    public void exploreOutputAndResource(Node node) {
        outputAndResourceQuery.queryOutputAndResources(node);
    }

    @Override
    public void prepareOutputAndResource(WorkflowContext workflowContext, Node node) {
        outputAndResourceCreate.createOutputAndResources(workflowContext, node);
    }

    @Override
    public void completeOutputAndResource(WorkflowContext workflowContext, Node node) {
        outputAndResourceDelete.deleteOutputAndResources(workflowContext, node);
    }

    @Override
    public void clearOutputAndResource(WorkflowContext workflowContext, Node node) {
        //TODO clear node output resource
        return;
    }

    @Override
    public void deleteOutputAndResource(WorkflowContext workflowContext, Node node) {
        //TODO complete node output resource
        return;
    }

    @Override
    public void recoverOutputAndResource(WorkflowContext workflowContext, Node node) {
        //TODO clear node output resource
        return;
    }

    @Override
    public void execute(ExecutionTaskContext context) {
        //TODO if needn't submit compute-cluster, compute output content here
        return;
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
