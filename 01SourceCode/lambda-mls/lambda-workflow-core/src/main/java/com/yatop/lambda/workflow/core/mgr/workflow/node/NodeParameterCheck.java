package com.yatop.lambda.workflow.core.mgr.workflow.node;

import com.yatop.lambda.base.model.WfFlowNodeParameter;
import com.yatop.lambda.core.enums.IsRequiredEnum;
import com.yatop.lambda.core.enums.LambdaExceptionEnum;
import com.yatop.lambda.core.exception.LambdaException;
import com.yatop.lambda.core.mgr.workflow.node.NodeMgr;
import com.yatop.lambda.core.mgr.workflow.node.NodeParameterMgr;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.context.WorkflowContext;
import com.yatop.lambda.workflow.core.context.WorkflowNodeContext;
import com.yatop.lambda.workflow.core.framework.module.IModuleClazz;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.Node;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.NodeParameter;
import com.yatop.lambda.workflow.core.utils.ClazzHelperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.TreeMap;

@Service
public class NodeParameterCheck {

    @Autowired
    NodeParameterMgr nodeParameterMgr;

    @Autowired
    NodeMgr nodeMgr;

    public void checkParameter(WorkflowContext workflowContext, Node node) {

        if(node.parameterCount() > 0) {
            int checkCounter = 0;
            int requiredCounter = 0;
            IModuleClazz moduleClazz = ClazzHelperUtil.getModuleClazzBean(node.getModule());
            if (moduleClazz.catchCheckParameter()) {

                try {
                    WorkflowNodeContext nodeContext = new WorkflowNodeContext(workflowContext, node);
                    moduleClazz.onCheckParameter(nodeContext);

                    TreeMap<String, String> warningMsgs = nodeContext.getOutWarningMsgs();
                    if (!warningMsgs.isEmpty()) {
                        for (Map.Entry<String, String> entry : warningMsgs.entrySet()) {
                            NodeParameter nodeParameter = node.getParameter(entry.getKey());
                            String warningMsg = entry.getValue();
                            if (DataUtil.isNull(nodeParameter) || DataUtil.isEmpty(warningMsg)) {
                                throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Check node parameter failed -- module-clazz return warning message invalid.", "工作流组件校验节点参数返回内容无效", node);
                            }

                            checkCounter++;
                            WfFlowNodeParameter updateParameter = new WfFlowNodeParameter();
                            updateParameter.setNodeId(nodeParameter.getNodeId());
                            updateParameter.setCharId(nodeParameter.getCharId());
                            updateParameter.setWarningMsg(warningMsg);
                            nodeParameterMgr.updateNodeParameter(updateParameter, workflowContext.getOperId());
                            nodeParameter.copyProperties(nodeParameterMgr.queryNodeParameter(nodeParameter.getNodeId(), nodeParameter.getCharId()));
                        }
                    }
                    nodeContext.clear();
                    return;
                } catch (Exception e) {
                    throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Check node parameter failed -- module-clazz occur error.", "工作流组件校验节点参数时发生错误", e, node);
                }
            }

            for(NodeParameter parameter : node.getParameters()) {
                if(DataUtil.isEmpty(parameter.getCharValue()) && parameter.getCmptChar().getIsRequired() == IsRequiredEnum.YES.getMark()) {
                    requiredCounter++;
                }
            }

            if(checkCounter > 0 || requiredCounter > 0) {

                //nodeMgr.updateNode()
            }
        }
    }
}
