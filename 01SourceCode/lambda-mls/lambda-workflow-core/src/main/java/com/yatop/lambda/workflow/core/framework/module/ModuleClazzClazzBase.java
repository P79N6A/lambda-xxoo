package com.yatop.lambda.workflow.core.framework.module;

import com.yatop.lambda.core.enums.LambdaExceptionEnum;
import com.yatop.lambda.core.exception.LambdaException;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.context.ExecutionTaskContext;
import com.yatop.lambda.workflow.core.context.WorkflowContext;
import com.yatop.lambda.workflow.core.mgr.workflow.node.output.OutputAndResourceHelper;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.Node;
import com.yatop.lambda.workflow.core.utils.CollectionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;

public abstract class ModuleClazzClazzBase implements IModuleClazz {

    //<class-path, bean-object>
    private static final HashMap<String, IModuleClazz> CLAZZ_BEANS = new HashMap<String, IModuleClazz>();

    public static IModuleClazz getClazzBean(String clazzPath) {
        IModuleClazz clazzBean = CollectionUtil.get(CLAZZ_BEANS, clazzPath);
        if(DataUtil.isNull(clazzBean)) {

            try {
                Class.forName(clazzPath).newInstance();
            } catch (Throwable e) {
                return null;
            }

            clazzBean = CollectionUtil.get(CLAZZ_BEANS, clazzPath);
        }

        return clazzBean;
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

/*
    @Override
    public TreeMap<CmptChar, String> validateParameters(WorkflowContext workflowContext, Node node) {
        return null;
    }
*/

    @Override
    public void exploreOutputAndResource(Node node) {
        OutputAndResourceHelper.queryOutputAndResources(node);
    }

    @Override
    public void prepareOutputAndResource(WorkflowContext workflowContext, Node node) {
        OutputAndResourceHelper.createOutputAndResources(workflowContext, node);
    }

    @Override
    public void completeOutputAndResource(WorkflowContext workflowContext, Node node) {
        OutputAndResourceHelper.completeOutputResource(workflowContext, node);
    }

    @Override
    public void clearOutputAndResource(WorkflowContext workflowContext, Node node) {
        OutputAndResourceHelper.clearOutputResource(workflowContext, node);
    }

    @Override
    public void deleteOutputAndResource(WorkflowContext workflowContext, Node node) {
        OutputAndResourceHelper.deleteOutputAndResources(workflowContext, node);
    }

    @Override
    public void recoverOutputAndResource(WorkflowContext workflowContext, Node node) {
        OutputAndResourceHelper.recoverOutputAndResources(workflowContext, node);
    }

    @Override
    public void execute(ExecutionTaskContext context) {
        //TODO if needn't submit compute-cluster, compute output content here
        return;
    }

/*
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
*/

}
