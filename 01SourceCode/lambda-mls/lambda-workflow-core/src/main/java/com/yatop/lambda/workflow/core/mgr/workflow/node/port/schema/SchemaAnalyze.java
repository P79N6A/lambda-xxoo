package com.yatop.lambda.workflow.core.mgr.workflow.node.port.schema;

import com.yatop.lambda.core.enums.IsRequiredEnum;
import com.yatop.lambda.core.enums.LambdaExceptionEnum;
import com.yatop.lambda.core.enums.SpecTypeEnum;
import com.yatop.lambda.core.exception.LambdaException;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.context.WorkflowContext;
import com.yatop.lambda.workflow.core.context.WorkflowNodeContext;
import com.yatop.lambda.workflow.core.framework.module.IModuleClazz;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.*;
import com.yatop.lambda.workflow.core.utils.ClazzHelperUtil;
import com.yatop.lambda.workflow.core.utils.CollectionUtil;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.TreeMap;
import java.util.List;

@Service
public class SchemaAnalyze {

    public boolean supportAnalyzeSchema(Node node) {

        if (node.haveOutputDataTablePort()) {
            return ClazzHelperUtil.getModuleClazzBean(node.getModule()).supportAnalyzeSchema();
        }
        return false;
    }

    public boolean needAnalyzeSchema(Node node) {
        return node.haveOutputDataTablePort();
    }

    public boolean needAnalyzeSchema(Node node, NodeParameter parameter) {

        if (node.haveOutputDataTablePort() && parameter.getCmptChar().data().getSpecType() == SpecTypeEnum.PARAMETER.getType()) {
            IModuleClazz moduleClazz = ClazzHelperUtil.getModuleClazzBean(node.getModule());
            if (moduleClazz.supportAnalyzeSchema()) {
                HashSet<String> cmptCodeSet = moduleClazz.reanlyzeSchemaParameterSet();
                return CollectionUtil.contains(cmptCodeSet, parameter.getCmptChar().data().getCharCode());
            }
        }
        return false;
    }

    private boolean reanalyzeSchemaConditionReady(WorkflowContext workflowContext, IModuleClazz moduleClazz, Node node) {
        {
            //reanalyze schema parameter in warning
            HashSet<String> cmptCodeSet = moduleClazz.reanlyzeSchemaParameterSet();
            List<NodeParameter> nodeParameters = node.getParameters();
            if (DataUtil.isNotEmpty(nodeParameters)) {
                for (NodeParameter nodeParameter : node.getParameters()) {
                    if (CollectionUtil.contains(cmptCodeSet, nodeParameter.getCmptChar().data().getCharCode()) && nodeParameter.isOccuredWarning())
                        return false;
                }
            }
        }
        {
            //required inputDataTablePort -> nonWebUpstreamPort's schema state is normal
            if(!node.isHeadNode()) {
                if(!node.haveOutputDataTablePort())
                    return false;

                TreeMap<Long, NodePortOutput> upstreamPorts = workflowContext.fetchNonWebUpstreamPorts(node);
                if(DataUtil.isEmpty(upstreamPorts))
                    return false;

                for (NodePortInput inputNodePort : node.getInputDataTablePorts()) {
                    if(inputNodePort.getCmptChar().data().getIsRequired() == IsRequiredEnum.YES.getMark()) {
                        NodePortOutput upstreamPort = CollectionUtil.get(upstreamPorts, inputNodePort.data().getNodePortId());
                        if(DataUtil.isNull(upstreamPort) || !upstreamPort.getSchema().isStateNormal()) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public void analyzeSchema(WorkflowContext workflowContext, Node node) {

        IModuleClazz moduleClazz = ClazzHelperUtil.getModuleClazzBean(node.getModule());
        if (node.haveOutputDataTablePort()) {
            if (moduleClazz.supportAnalyzeSchema()) {
                if(!this.reanalyzeSchemaConditionReady(workflowContext, moduleClazz, node)) {
                    try {
                        WorkflowNodeContext nodeContext = new WorkflowNodeContext(workflowContext, node);
                        moduleClazz.analyzeSchema(nodeContext);
                        TreeMap<String, NodeSchema> outSchemas = nodeContext.getOutSchemas();

                        List<NodeSchema> dataPortSchemas = node.getOutputDataTablePortSchemas();
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
                    List<NodeSchema> dataPortSchemas = node.getOutputDataTablePortSchemas();
                    if (DataUtil.isNotEmpty(dataPortSchemas)) {
                        for (NodeSchema nodeSchema : dataPortSchemas)
                            nodeSchema.changeState2Empty();
                    }
                }
            } else {
                List<NodeSchema> dataPortSchemas = node.getOutputDataTablePortSchemas();
                if (DataUtil.isNotEmpty(dataPortSchemas)) {
                    for (NodeSchema nodeSchema : dataPortSchemas) {
                        nodeSchema.changeState2NotSupport();
                    }
                }
            }
        }
    }
}
