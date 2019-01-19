package com.yatop.lambda.workflow.core.framework.module;

import com.yatop.lambda.workflow.core.context.ExecutionTaskContext;
import com.yatop.lambda.workflow.core.context.WorkflowContext;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.Node;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.NodeSchema;
import com.yatop.lambda.workflow.core.richmodel.workflow.value.CharValue;
import com.yatop.lambda.workflow.core.utils.CollectionUtil;

import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeMap;

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

    //
    //接口方法默认实现
    //

    @Override
    public TreeMap<String, String> checkParameter(WorkflowContext workflowContext, Node node) {
        return null;
    }

    @Override
    public TreeMap<String, CharValue> exploreTaskExecutionOutput(WorkflowContext workflowContext, Node node) {
        //TODO query task output
        return null;
    }

    @Override
    public void prepareTaskExecutionOutput(ExecutionTaskContext context) {
        //TODO prepare task output
        return;
    }

    @Override
    public void clearTaskExecutionOutput(ExecutionTaskContext context) {
        //TODO clear task output
        return;
    }

    @Override
    public boolean supportAnalyzeSchema() {
        return false;
    }

    @Override
    public HashSet<String> reanalyzeSchemaParameterSet() {
        return null;
    }

    @Override
    public TreeMap<String, NodeSchema> analyzeSchema(WorkflowContext workflowContext, Node node) {
        return null;
    }
}
