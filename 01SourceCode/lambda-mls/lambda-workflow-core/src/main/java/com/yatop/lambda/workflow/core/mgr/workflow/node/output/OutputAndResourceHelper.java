package com.yatop.lambda.workflow.core.mgr.workflow.node.output;

import com.yatop.lambda.base.model.WfFlowNodeOutput;
import com.yatop.lambda.core.enums.DataStatusEnum;
import com.yatop.lambda.core.mgr.workflow.node.NodeOutputMgr;
import com.yatop.lambda.workflow.core.context.WorkflowContext;
import com.yatop.lambda.workflow.core.richmodel.RichModel;
import com.yatop.lambda.workflow.core.richmodel.component.characteristic.CmptChar;
import com.yatop.lambda.workflow.core.richmodel.workflow.charvalue.CharValue;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.Node;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.NodeOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class OutputAndResourceHelper {

    private static NodeOutputMgr NODE_OUTPUT_MGR;

    @Autowired
    public void setNodeParameterMgr(NodeOutputMgr nodeOutputMgr) {
        NODE_OUTPUT_MGR = nodeOutputMgr;
    }

    public static NodeOutput simulateOutput(WorkflowContext workflowContext, Node node, CmptChar cmptChar, String resourceId, boolean resourceStateEmpty, RichModel resourceObj) {

        //模拟生成非workflow来源级别的节点参数，和workflow来源级别缺失的节点参数
        Date curTime = new Date();
        WfFlowNodeOutput output = new WfFlowNodeOutput();
        output.setNodeId(node.data().getNodeId());
        output.setCharId(cmptChar.data().getCharId());
        output.setCharValue(resourceId);
        output.setStatus(DataStatusEnum.NORMAL.getStatus());
        output.setDescription("Simulate Output");
        output.setLastUpdateTime(curTime);
        output.setLastUpdateOper(workflowContext.getOperId());
        output.setCreateTime(curTime);
        output.setCreateOper(workflowContext.getOperId());

        CharValue charValue = new CharValue(cmptChar);
        charValue.setCharValue(resourceId);
        charValue.setObjectValue(resourceObj);

        return new NodeOutput(output, charValue, true);
    }

    public static void updateOutput(NodeOutput output, String operId) {
        NODE_OUTPUT_MGR.updateNodeOutput(output.data(), operId);
        output.clearColoured();
    }


    ///////////////////////////////////////////


    private static OutputAndResourceCreate OUTPUT_AND_RESOURCE_CREATE;

    @Autowired
    public void setOutputAndResourceCreate(OutputAndResourceCreate outputAndResourceCreate) {
        OUTPUT_AND_RESOURCE_CREATE = outputAndResourceCreate;
    }

    private static OutputAndResourceQuery OUTPUT_AND_RESOURCE_QUERY;

    @Autowired
    public void setOutputAndResourceQuery(OutputAndResourceQuery outputAndResourceQuery) {
        OUTPUT_AND_RESOURCE_QUERY = outputAndResourceQuery;
    }

    private static OutputAndResourceDelete OUTPUT_AND_RESOURCE_DELETE;

    @Autowired
    public void setOutputAndResourceDelete(OutputAndResourceDelete outputAndResourceDelete) {
        OUTPUT_AND_RESOURCE_DELETE = outputAndResourceDelete;
    }

    private static OutputAndResourceRecover OUTPUT_AND_RESOURCE_RECOVER;

    @Autowired
    public void setOutputAndResourceRecover(OutputAndResourceRecover outputAndResourceRecover) {
        OUTPUT_AND_RESOURCE_RECOVER = outputAndResourceRecover;
    }

    private static OutputResourceComplete OUTPUT_RESOURCE_COMPLETE;

    @Autowired
    public void setOutputResourceComplete(OutputResourceComplete outputResourceComplete) {
        OUTPUT_RESOURCE_COMPLETE = outputResourceComplete;
    }

    private static OutputResourceClear OUTPUT_RESOURCE_CLEAR;

    @Autowired
    public void setOutputResourceClear(OutputResourceClear outputResourceClear) {
        OUTPUT_RESOURCE_CLEAR = outputResourceClear;
    }

    public static void createOutputAndResources(WorkflowContext workflowContext, Node node) {
        OUTPUT_AND_RESOURCE_CREATE.createOutputAndResources(workflowContext, node);
    }

    public static void completeOutputResource(WorkflowContext workflowContext, Node node) {
        OUTPUT_RESOURCE_COMPLETE.completeOutputResource(workflowContext, node);
    }

    public static void clearOutputResource(WorkflowContext workflowContext, Node node) {
        OUTPUT_RESOURCE_CLEAR.clearOutputResource(workflowContext, node);
    }

    public static void deleteOutputAndResources(WorkflowContext workflowContext, Node node) {
        OUTPUT_AND_RESOURCE_DELETE.deleteOutputAndResources(workflowContext, node);
    }

    public static void recoverOutputAndResources(WorkflowContext workflowContext, Node node) {
        OUTPUT_AND_RESOURCE_RECOVER.recoverOutputAndResources(workflowContext, node);
    }

    public static void queryOutputAndResources(Node node) {
        OUTPUT_AND_RESOURCE_QUERY.queryOutputAndResources(node);
    }
}
