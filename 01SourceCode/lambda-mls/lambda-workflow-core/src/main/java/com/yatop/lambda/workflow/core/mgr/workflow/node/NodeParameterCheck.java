package com.yatop.lambda.workflow.core.mgr.workflow.node;

import com.yatop.lambda.core.enums.IsRequiredEnum;
import com.yatop.lambda.core.enums.LambdaExceptionEnum;
import com.yatop.lambda.core.exception.LambdaException;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.context.WorkflowContext;
import com.yatop.lambda.workflow.core.framework.module.IModuleClazz;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.Node;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.NodeParameter;
import com.yatop.lambda.workflow.core.utils.CollectionUtil;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.TreeMap;

@Service
public class NodeParameterCheck {

    public void checkParameter(WorkflowContext workflowContext, Node node) {

        if(node.parameterCount() > 0) {
            int warningCounter = 0;
            int missingCounter = 0;
            TreeMap<String, String> warningMessages = null;
            IModuleClazz moduleClazz = node.getModuleClazzBean();
            if (moduleClazz.catchCheckParameter()) {

                try {
                    warningMessages = moduleClazz.onCheckParameter(workflowContext, node);
                    if (DataUtil.isNotEmpty(warningMessages)) {
                        for (Map.Entry<String, String> entry : warningMessages.entrySet()) {
                            NodeParameter nodeParameter = node.getParameter(entry.getKey());
                            String warningMsg = entry.getValue();
                            if (DataUtil.isNull(nodeParameter) || DataUtil.isEmpty(warningMsg)) {
                                throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Check node parameter failed -- module-clazz return warning message invalid.", "工作流组件校验节点参数返回内容无效", node);
                            }

                            nodeParameter.changeOccuredWarning(warningMsg);
                            warningCounter++;
                        }
                    }
                    CollectionUtil.clear(warningMessages);
                } catch (Exception e) {
                    throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Check node parameter failed -- module-clazz occur error.", "工作流组件校验节点参数时发生错误", e, node);
                }
            }

            for(NodeParameter parameter : node.getParameters()) {
                if(DataUtil.isEmpty(parameter.data().getCharValue()) && parameter.getCmptChar().data().getIsRequired() == IsRequiredEnum.YES.getMark()) {
                    missingCounter++;

                    if(!CollectionUtil.containsKey(warningMessages, parameter.data().getCharId()))
                        parameter.changeOccuredWarning("节点参数值缺失");
                } else {
                    if(!CollectionUtil.containsKey(warningMessages, parameter.data().getCharId()))
                        parameter.clearOccuredWarning();
                }
            }

            for(NodeParameter parameter : node.getOptimizeParameters()) {
                if(DataUtil.isEmpty(parameter.data().getCharValue()) && parameter.getCmptChar().data().getIsRequired() == IsRequiredEnum.YES.getMark()) {
                    missingCounter++;

                    if(!CollectionUtil.containsKey(warningMessages, parameter.data().getCharId()))
                        parameter.changeOccuredWarning("节点执行调优参数值缺失");
                } else {
                    if(!CollectionUtil.containsKey(warningMessages, parameter.data().getCharId()))
                        parameter.clearOccuredWarning();
                }
            }

            if(DataUtil.isNotEmpty(warningMessages))
                warningMessages.clear();

            if(warningCounter > 0 || missingCounter > 0) {
                node.changeOccuredWarning(buildNodeWarningMsg(warningCounter, missingCounter));
            } else {
                node.changeState2Ready();
            }
        }
    }

    private String buildNodeWarningMsg(int warningCounter, int missingCounter) {
        StringBuilder sb = new StringBuilder();
        if(warningCounter > 0) {
            sb.append("参数值错误数量:").append(warningCounter).append(",");
        }
        if(missingCounter > 0) {
            sb.append("参数值缺失数量:").append(missingCounter);
        }
        return sb.toString();
    }
}
