package com.yatop.lambda.workflow.engine.editor.node.parameter;

import com.yatop.lambda.core.enums.SourceLevelEnum;
import com.yatop.lambda.core.mgr.workflow.node.NodeParameterMgr;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.context.WorkflowContext;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.Node;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.NodeParameter;
import com.yatop.lambda.workflow.engine.editor.value.CharValueDelete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParameterDelete {

    @Autowired
    private NodeParameterMgr nodeParameterMgr;

    @Autowired
    private CharValueDelete charValueDelete;

    private void deleteParameter(WorkflowContext workflowContext, Node node, NodeParameter parameter) {

        if(parameter.getCmptChar().getSrcLevel() == SourceLevelEnum.WORKFLOW.getSource() && DataUtil.isNotNull(parameter)) {
            charValueDelete.deleteCharValue(workflowContext, node, parameter.getValue());
        }
    }

    public void deleteParameters(WorkflowContext workflowContext, Node node) {

        //组件参数
        for (NodeParameter parameter : node.getParameters()) {
            deleteParameter(workflowContext, node, parameter);
        }

        //执行调优参数
        for (NodeParameter parameter : node.getOptimizeParameters()) {
            deleteParameter(workflowContext, node, parameter);
        }

        nodeParameterMgr.deleteNodeParameter(node, workflowContext.getOperId());
    }
}
