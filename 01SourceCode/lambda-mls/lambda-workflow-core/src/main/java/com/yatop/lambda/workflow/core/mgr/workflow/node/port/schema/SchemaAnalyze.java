package com.yatop.lambda.workflow.core.mgr.workflow.node.port.schema;

import com.yatop.lambda.core.enums.LambdaExceptionEnum;
import com.yatop.lambda.core.exception.LambdaException;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.context.WorkflowContext;
import com.yatop.lambda.workflow.core.context.WorkflowNodeContext;
import com.yatop.lambda.workflow.core.framework.module.IModuleClazz;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.Node;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.NodeSchema;
import com.yatop.lambda.workflow.core.utils.ClazzHelperUtil;
import org.springframework.stereotype.Service;

import java.util.TreeMap;

@Service
public class SchemaAnalyze {

    public void analyzeSchema(WorkflowContext workflowContext, Node node) {

        if(node.outputPortCount() > 0)

        TreeMap<String, NodeSchema> outSchemas = null;
        IModuleClazz moduleClazz = ClazzHelperUtil.getModuleClazzBean(node.getModule());
        if (moduleClazz.supportAnalyzeSchema()) {

            try {
                WorkflowNodeContext nodeContext = new WorkflowNodeContext(workflowContext, node);
                moduleClazz.analyzeSchema(nodeContext);
                outSchemas = nodeContext.getOutSchemas();

                if(node.outputPortCount() > 0) {
                    //NodePortOutput

                    if (DataUtil.isNotEmpty(outSchemas)) {
                        for (NodeSchema nodeSchema :) {

                        }
                    }
                }
                nodeContext.clear();
            } catch (Exception e) {
                throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Analyze node data port schema failed -- module-clazz occur error.", "工作流组件分析节点数据端口schema时发生错误", e, node);
            }
        }
    }
}
