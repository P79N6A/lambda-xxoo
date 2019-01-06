package com.yatop.lambda.workflow.core.mgr.workflow.node.port.schema;

import com.yatop.lambda.core.enums.LambdaExceptionEnum;
import com.yatop.lambda.core.enums.SpecTypeEnum;
import com.yatop.lambda.core.exception.LambdaException;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.context.WorkflowContext;
import com.yatop.lambda.workflow.core.context.WorkflowNodeContext;
import com.yatop.lambda.workflow.core.framework.module.IModuleClazz;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.Node;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.NodeParameter;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.NodeSchema;
import com.yatop.lambda.workflow.core.utils.ClazzHelperUtil;
import com.yatop.lambda.workflow.core.utils.CollectionUtil;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.TreeMap;
import java.util.List;

@Service
public class SchemaAnalyze {

    public boolean supportAnalyzeSchema(Node node) {

        if (node.outputDataPortCount() > 0) {
            return ClazzHelperUtil.getModuleClazzBean(node.getModule()).supportAnalyzeSchema();
        }
        return false;
    }

    public boolean reanalyzeSchema(Node node, NodeParameter parameter) {

        if (node.outputDataPortCount() > 0 && parameter.getCmptChar().data().getSpecType() == SpecTypeEnum.PARAMETER.getType()) {
            IModuleClazz moduleClazz = ClazzHelperUtil.getModuleClazzBean(node.getModule());
            if (moduleClazz.supportAnalyzeSchema()) {
                HashSet<String> cmptCodeSet = moduleClazz.reanlyzeSchemaParameterSet();
                return CollectionUtil.contains(cmptCodeSet, parameter.getCmptChar().data().getCharCode());
            }
        }
        return false;
    }

    private boolean reanalyzeSchemaParameterWarning(IModuleClazz moduleClazz, Node node) {
        HashSet<String> cmptCodeSet = moduleClazz.reanlyzeSchemaParameterSet();
        List<NodeParameter> nodeParameters = node.getParameters();
        if(DataUtil.isNotEmpty(nodeParameters)) {
            for (NodeParameter nodeParameter : node.getParameters()) {
                if (CollectionUtil.contains(cmptCodeSet, nodeParameter.getCmptChar().data().getCharCode()) && nodeParameter.isOccuredWarning())
                    return true;
            }
        }
        return false;
    }

    public void analyzeSchema(WorkflowContext workflowContext, Node node) {

        IModuleClazz moduleClazz = ClazzHelperUtil.getModuleClazzBean(node.getModule());
        if (node.outputDataPortCount() > 0) {
            if (moduleClazz.supportAnalyzeSchema()) {
                if(!this.reanalyzeSchemaParameterWarning(moduleClazz, node)) {
                    try {
                        WorkflowNodeContext nodeContext = new WorkflowNodeContext(workflowContext, node);
                        moduleClazz.analyzeSchema(nodeContext);
                        TreeMap<String, NodeSchema> outSchemas = nodeContext.getOutSchemas();

                        List<NodeSchema> dataPortSchemas = node.getOutputDataPortSchemas();
                        if (DataUtil.isNotEmpty(dataPortSchemas)) {
                            for (NodeSchema nodeSchema : dataPortSchemas) {
                                if (!CollectionUtil.containsKey(outSchemas, nodeSchema.getCmptChar().data().getCharId()))
                                    nodeSchema.changeState2Empty();
                            }
                        }
                        nodeContext.clear();
                    } catch (Exception e) {
                        throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Analyze node data port schema failed -- module-clazz occur error.", "工作流组件分析节点数据端口schema时发生错误", e, node);
                    }
                } else {
                    List<NodeSchema> dataPortSchemas = node.getOutputDataPortSchemas();
                    if (DataUtil.isNotEmpty(dataPortSchemas)) {
                        for (NodeSchema nodeSchema : dataPortSchemas) {
                            nodeSchema.changeState2Empty();
                        }
                    }
                }
            } else {
                List<NodeSchema> dataPortSchemas = node.getOutputDataPortSchemas();
                if (DataUtil.isNotEmpty(dataPortSchemas)) {
                    for (NodeSchema nodeSchema : dataPortSchemas) {
                        nodeSchema.changeState2NotSupport();
                    }
                }
            }
        }
    }
}
