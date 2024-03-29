package com.yatop.lambda.workflow.engine.service;

import com.yatop.lambda.base.model.*;
import com.yatop.lambda.core.enums.LambdaExceptionEnum;
import com.yatop.lambda.core.exception.LambdaException;
import com.yatop.lambda.core.mgr.experiment.ExperimentTemplateMgr;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.context.WorkflowContext;
import com.yatop.lambda.workflow.core.mgr.workflow.WorkflowCreate;
import com.yatop.lambda.workflow.core.mgr.workflow.WorkflowDelete;
import com.yatop.lambda.workflow.core.mgr.workflow.WorkflowHelper;
import com.yatop.lambda.workflow.core.mgr.workflow.node.NodeCreate;
import com.yatop.lambda.workflow.core.mgr.workflow.node.NodeDelete;
import com.yatop.lambda.workflow.core.mgr.workflow.node.NodeHelper;
import com.yatop.lambda.workflow.core.mgr.workflow.node.NodeRecover;
import com.yatop.lambda.workflow.core.mgr.workflow.node.link.LinkCreate;
import com.yatop.lambda.workflow.core.mgr.workflow.node.link.LinkDelete;
import com.yatop.lambda.workflow.core.mgr.workflow.node.link.LinkValidate;
import com.yatop.lambda.workflow.core.mgr.workflow.node.parameter.ParameterCharValueUpdate;
import com.yatop.lambda.workflow.core.mgr.workflow.node.parameter.ParameterHelper;
import com.yatop.lambda.workflow.core.mgr.workflow.snapshot.SnapshotCreate;
import com.yatop.lambda.workflow.core.mgr.workflow.snapshot.SnapshotHelper;
import com.yatop.lambda.workflow.core.richmodel.experiment.Experiment;
import com.yatop.lambda.workflow.core.richmodel.experiment.ExperimentTemplate;
import com.yatop.lambda.workflow.core.richmodel.workflow.Workflow;
import com.yatop.lambda.workflow.core.richmodel.workflow.module.Module;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.*;
import com.yatop.lambda.workflow.core.richmodel.workflow.snapshot.Snapshot;
import com.yatop.lambda.workflow.core.utils.CollectionUtil;
import com.yatop.lambda.workflow.core.utils.WorkflowEditUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class EditorService {

    private static String READ$DATA$TABLE_TABLENAME_CHARCODE = "tableName";
    private static String READ$MODEL_MODELID_CHARCODE = "modelId";

    @Autowired
    WorkflowEditUtil workflowEditUtil;

    @Autowired
    WorkflowCreate workflowCreate;

    @Autowired
    ExperimentTemplateMgr experimentTemplateMgr;

    @Autowired
    WorkflowDelete workflowDelete;

    @Autowired
    SnapshotCreate snapshotCreate;

    @Autowired
    NodeCreate nodeCreate;

    @Autowired
    NodeDelete nodeDelete;

    @Autowired
    NodeRecover nodeRecover;

    @Autowired
    ParameterCharValueUpdate parameterCharValueUpdate;

    @Autowired
    LinkCreate linkCreate;

    @Autowired
    LinkDelete linkDelete;

    @Autowired
    LinkValidate linkValidate;

    //创建实验工作流（空白）
    @Transactional
    public WfFlow createWorkflow(EmExperiment experiment, String operId) {

        Experiment richExperiment = new Experiment(experiment);
        WorkflowContext workflowContext = workflowCreate.createWorkflow(richExperiment, operId);

        WfFlow flow = workflowContext.getWorkflow().data().makeCopy();
        workflowContext.clear();
        return flow;
    }

    //创建实验工作流（复制）
    @Transactional
    public WfFlow createWorkflowByCopy(EmExperiment experiment, EmExperiment copyExperiment, String operId) {

        Experiment richExperiment = new Experiment(experiment);
        Workflow copyWorkflow = WorkflowHelper.queryWorkflow(new Experiment(copyExperiment));

        try {
            workflowEditUtil.requestWorkflowResource(copyWorkflow);
            WorkflowContext copyWorkflowContext = WorkflowContext.BuildWorkflowContext4Preload(copyWorkflow, operId);
            WorkflowContext thisWorkflowContext = workflowCreate.createWorkflow(richExperiment, copyWorkflowContext, operId);

            WfFlow flow = thisWorkflowContext.getWorkflow().data().makeCopy();
            thisWorkflowContext.clear();
            workflowEditUtil.releaseWorkflowResource();
            return flow;
        } catch (Throwable exception) {
            workflowEditUtil.releaseWorkflowResource();
            throw exception;
        }
    }

    //创建实验工作流（快照）
    @Transactional
    public WfFlow createWorkflowByShapshot(EmExperiment experiment, WfSnapshot snapshot, String operId) {

        Experiment richExperiment = new Experiment(experiment);
        WorkflowContext snapshotWorkflowContext = WorkflowContext.BuildWorkflowContext4ViewSnapshot(Snapshot.BuildSnapshot(snapshot), operId);
        WorkflowContext thisWorkflowContext = workflowCreate.createWorkflow(richExperiment, snapshotWorkflowContext, operId);

        WfFlow flow = thisWorkflowContext.getWorkflow().data().makeCopy();
        thisWorkflowContext.clear();
        return flow;
    }

    //创建实验工作流（实验模版）
    @Transactional
    public WfFlow createWorkflowByTemplate(EmExperiment experiment, EmExperimentTemplate template, String operId) {

        Experiment richExperiment = new Experiment(experiment);
        WorkflowContext templateWorkflowContext = WorkflowContext.BuildWorkflowContext4ViewTemplate(new ExperimentTemplate(template), operId);
        WorkflowContext thisWorkflowContext = workflowCreate.createWorkflow(richExperiment, templateWorkflowContext, operId);
        experimentTemplateMgr.increaseTemplateCount(template.getTemplateId(), operId);

        WfFlow flow = thisWorkflowContext.getWorkflow().data().makeCopy();
        thisWorkflowContext.clear();
        return flow;
    }

    //删除实验工作流
    @Transactional
    public void deleteWorkflow(EmExperiment experiment, String operId) {

        Workflow workflow = WorkflowHelper.queryWorkflow(new Experiment(experiment));

        try {
            workflowEditUtil.requestWorkflowResource(workflow);
            workflowEditUtil.detectWorkflowShareLock(workflow);
            WorkflowContext workflowContext = WorkflowContext.BuildWorkflowContext4Preload(workflow, operId);
            workflowDelete.deleteWorkflow(workflowContext);
            workflowContext.clear();
            workflowEditUtil.releaseWorkflowResource();
        } catch (Throwable exception) {
            workflowEditUtil.releaseWorkflowResource();
            throw exception;
        }
    }

    public WorkflowContext queryWorkflowGraph(EmExperiment experiment, String operId) {

        Workflow workflow = WorkflowHelper.queryWorkflow(new Experiment(experiment));
        return WorkflowContext.BuildWorkflowContext4Preload(workflow, operId, false);
    }

    //保存实验工作流副本快照
    @Transactional
    public WfSnapshot saveWorkflowSnapshot(EmExperiment experiment, String snapshotName, String operId) {

        Workflow workflow = WorkflowHelper.queryWorkflow(new Experiment(experiment));

        try {
            workflowEditUtil.requestWorkflowResource(workflow);
            workflowEditUtil.detectWorkflowShareLock(workflow);
            WorkflowContext workflowContext = WorkflowContext.BuildWorkflowContext4Preload(workflow, operId);
            Snapshot snapshot = snapshotCreate.createSnapshot4Copy(workflowContext, snapshotName);
            workflowContext.clear();
            workflowEditUtil.releaseWorkflowResource();
            return snapshot.data();
        } catch (Throwable exception) {
            workflowEditUtil.releaseWorkflowResource();
            throw exception;
        }
    }

    //查看实验工作流副本快照
    public WorkflowContext viewWorkflowSnapshot(Long snapshotId, String operId) {
        return WorkflowContext.BuildWorkflowContext4ViewSnapshot(SnapshotHelper.querySnapshot4View(snapshotId), operId);
    }

    //添加实验工作流节点
    @Transactional
    public WorkflowContext createWorkflowNode(EmExperiment experiment, Long moduleId, Long posX, Long posY, String operId) {

        Module module = workflowEditUtil.findWorkflowModule(moduleId);
        if(DataUtil.isNull(module)) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR,
                    "Find workflow node failed -- module not exists.", "工作流组件不存在");
        }
        Workflow workflow = WorkflowHelper.queryWorkflow(new Experiment(experiment));

        try {
            workflowEditUtil.requestWorkflowResource(workflow);
            workflowEditUtil.detectWorkflowShareLock(workflow);
            WorkflowContext workflowContext = WorkflowContext.BuildWorkflowContext4Lazyload(workflow, operId);
            Node node = nodeCreate.createNode(workflowContext, module, posX, posY);
            workflowContext.flush();
            workflowEditUtil.releaseWorkflowResource();
            return workflowContext;
        } catch (Throwable exception) {
            workflowEditUtil.releaseWorkflowResource();
            throw exception;
        }
    }

    //添加实验工作流节点（指定数据表名）
    @Transactional
    public WorkflowContext createWorkflowNode4ReadTable(EmExperiment experiment, String tableName, Long posX, Long posY, String operId) {

        //读数据表的ModuleId为1
        Module module = workflowEditUtil.findWorkflowModule(1L);
        if(DataUtil.isNull(module)) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR,
                    "Find workflow node failed -- module not exists.", "工作流组件不存在");
        }
        Workflow workflow = WorkflowHelper.queryWorkflow(new Experiment(experiment));

        try {
            workflowEditUtil.requestWorkflowResource(workflow);
            workflowEditUtil.detectWorkflowShareLock(workflow);
            WorkflowContext workflowContext = WorkflowContext.BuildWorkflowContext4Lazyload(workflow, operId);
            Node node = nodeCreate.createNode(workflowContext, module, posX, posY);

            //TODO 修改节点参数：数据表名 - READ$DATA$TABLE_TABLENAME_CHARCODE
            parameterCharValueUpdate.updateParameter(workflowContext,
                    node, node.getParameterByCharCode(READ$DATA$TABLE_TABLENAME_CHARCODE), tableName);

            workflowContext.flush();
            workflowEditUtil.releaseWorkflowResource();
            return workflowContext;
        } catch (Throwable exception) {
            workflowEditUtil.releaseWorkflowResource();
            throw exception;
        }

    }

    //添加实验工作流节点（指定模型ID）
    @Transactional
    public WorkflowContext createWorkflowNode4ReadModel(EmExperiment experiment, Long modelId, Long posX, Long posY, String operId) {

        //读模型的ModuleId为2
        Module module = workflowEditUtil.findWorkflowModule(2L);
        if(DataUtil.isNull(module)) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR,
                    "Find workflow node failed -- module not exists.", "工作流组件不存在");
        }
        Workflow workflow = WorkflowHelper.queryWorkflow(new Experiment(experiment));

        try {
            workflowEditUtil.requestWorkflowResource(workflow);
            workflowEditUtil.detectWorkflowShareLock(workflow);
            WorkflowContext workflowContext = WorkflowContext.BuildWorkflowContext4Lazyload(workflow, operId);
            Node node = nodeCreate.createNode(workflowContext, module, posX, posY);

            //TODO 修改节点参数：模型ID - READ$MODEL_MODELID_CHARCODE
            parameterCharValueUpdate.updateParameter(workflowContext,
                    node, node.getParameterByCharCode(READ$MODEL_MODELID_CHARCODE), String.valueOf(modelId));

            workflowContext.flush();
            workflowEditUtil.releaseWorkflowResource();
            return workflowContext;
        } catch (Throwable exception) {
            workflowEditUtil.releaseWorkflowResource();
            throw exception;
        }
    }

    //批量更新实验工作流节点位置
    @Transactional
    public void batchUpdateWorkflowNodePosition(Long[] nodeIds, Long[] posXs, Long[] posYs, String operId) {

        for(int i = 0; i < nodeIds.length; i++) {
            NodeHelper.updateNodePosition(nodeIds[i], posXs[i], posYs[i], operId);
        }
    }

    //重命名实验工作流节点
    @Transactional
    public void renameWorkflowNode(Long nodeId, String newName, String operId) {
        NodeHelper.updateNodeName(nodeId, newName, operId);
    }

    //拷贝实验工作流节点
    @Transactional
    public WorkflowContext copyWorkflowNodes(EmExperiment experiment, Long[] copyNodeIds, Long[] posXs, Long[] posYs, String operId) {

        Workflow workflow = WorkflowHelper.queryWorkflow(new Experiment(experiment));

        try {
            workflowEditUtil.requestWorkflowResource(workflow);
            workflowEditUtil.detectWorkflowShareLock(workflow);
            WorkflowContext workflowContext = WorkflowContext.BuildWorkflowContext4Lazyload(workflow, operId);

            HashMap<Long, Node> nodeIndexTable = new HashMap<Long, Node>(copyNodeIds.length);
            for(int i = 0; i < copyNodeIds.length; i++) {
                Node copyNode = workflowContext.fetchNode(copyNodeIds[i]);
                if(DataUtil.isNull(copyNode)) {
                    throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR,
                            "Find workflow node failed -- delete node not exists.", "复制节点不存在");
                }
                Node newNode = nodeCreate.copyNode4SameWorkflow(workflowContext, copyNode, posXs[i], posYs[i]);
                CollectionUtil.put(nodeIndexTable, copyNode.data().getNodeId(), newNode);
            }

            linkCreate.createLink4CopyNodes(workflowContext, nodeIndexTable);
            workflowContext.flush();
            workflowEditUtil.releaseWorkflowResource();
            return workflowContext;
        } catch (Throwable exception) {
            workflowEditUtil.releaseWorkflowResource();
            throw exception;
        }
    }

    //删除实验工作流节点，返回删除关联的节点链接
    @Transactional
    public WorkflowContext deleteWorkflowNodes(EmExperiment experiment, Long[] nodeIds, String operId) {

        Workflow workflow = WorkflowHelper.queryWorkflow(new Experiment(experiment));

        try {
            workflowEditUtil.requestWorkflowResource(workflow);
            workflowEditUtil.detectWorkflowShareLock(workflow);
            WorkflowContext workflowContext = WorkflowContext.BuildWorkflowContext4Preload(workflow, operId);

            List<Node> deleteNodes = new ArrayList<>(nodeIds.length);
            for(int i = 0; i < nodeIds.length; i++) {
                Node deleteNode = workflowContext.fetchNode(nodeIds[i]);
                if(DataUtil.isNull(deleteNode)) {
                    throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR,
                            "Find workflow node failed -- delete node not exists.", "删除节点不存在");
                }
                deleteNodes.add(deleteNode);
            }

            nodeDelete.deleteNodes(workflowContext, deleteNodes);
            workflowContext.flush();
            workflowEditUtil.releaseWorkflowResource();
            return workflowContext;
        } catch (Throwable exception) {
            workflowEditUtil.releaseWorkflowResource();
            throw exception;
        }
    }

    //撤销删除实验工作流节点
    @Transactional
    public WorkflowContext recoverDeleteWorkflowNodes(EmExperiment experiment, String operId) {

        Workflow workflow = WorkflowHelper.queryWorkflow(new Experiment(experiment));

        try {
            workflowEditUtil.requestWorkflowResource(workflow);
            workflowEditUtil.detectWorkflowShareLock(workflow);
            WorkflowContext workflowContext = WorkflowContext.BuildWorkflowContext4Lazyload(workflow, operId);
            nodeRecover.recoverNodes(workflowContext);
            workflowContext.flush();
            workflowEditUtil.releaseWorkflowResource();
            return workflowContext;
        } catch (Throwable exception) {
            workflowEditUtil.releaseWorkflowResource();
            throw exception;
        }
    }

    //验证添加实验工作流节点链接
    public boolean validateCreateWorkflowNodeLink(EmExperiment experiment, Long srcNodeId, Long dstNodeId, Long srcNodePortId, Long dstNodePortId, String operId) {

        Workflow workflow = WorkflowHelper.queryWorkflow(new Experiment(experiment));

        try {
            workflowEditUtil.requestWorkflowResource(workflow);
            workflowEditUtil.detectWorkflowShareLock(workflow);
            WorkflowContext workflowContext = WorkflowContext.BuildWorkflowContext4Lazyload(workflow, operId, false);
            boolean isPassValidate = linkValidate.validateLink(workflowContext, srcNodeId, dstNodeId, srcNodePortId, dstNodePortId);
            workflowContext.clear();
            workflowEditUtil.releaseWorkflowResource();
            return isPassValidate;
        } catch (Throwable exception) {
            workflowEditUtil.releaseWorkflowResource();
            throw exception;
        }
    }

    //添加实验工作流节点链接
    @Transactional
    public WorkflowContext createWorkflowNodeLink(EmExperiment experiment, Long srcNodeId, Long dstNodeId, Long srcNodePortId, Long dstNodePortId, String operId) {

        Workflow workflow = WorkflowHelper.queryWorkflow(new Experiment(experiment));

        try {
            workflowEditUtil.requestWorkflowResource(workflow);
            workflowEditUtil.detectWorkflowShareLock(workflow);
            WorkflowContext workflowContext = WorkflowContext.BuildWorkflowContext4Preload(workflow, operId);
            linkCreate.createLink(workflowContext, srcNodeId, dstNodeId, srcNodePortId, dstNodePortId);
            workflowContext.flush();
            workflowEditUtil.releaseWorkflowResource();
            return workflowContext;
        } catch (Throwable exception) {
            workflowEditUtil.releaseWorkflowResource();
            throw exception;
        }
    }

    //移除实验工作流节点链接
    @Transactional
    public WorkflowContext removeWorkflowNodeLink(EmExperiment experiment, Long srcNodeId, Long dstNodeId, Long srcNodePortId, Long dstNodePortId, String operId) {

        Workflow workflow = WorkflowHelper.queryWorkflow(new Experiment(experiment));

        try {
            workflowEditUtil.requestWorkflowResource(workflow);
            workflowEditUtil.detectWorkflowShareLock(workflow);
            WorkflowContext workflowContext = WorkflowContext.BuildWorkflowContext4Preload(workflow, operId);
            Node upstreamNode = workflowContext.fetchNode(srcNodeId);
            if(DataUtil.isNull(upstreamNode)) {
                throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR,
                        "Find workflow node failed -- source node not exists.", "源头节点不存在");
            }
            NodeOutputPort upstreamNodePort = upstreamNode.getOutputNodePort(srcNodePortId);
            if(DataUtil.isNull(upstreamNodePort)) {
                throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR,
                        "Find workflow node failed -- source node port not exists.", "输出端口不存在");
            }

            Node downstreamNode = workflowContext.fetchNode(dstNodeId);
            if(DataUtil.isNull(downstreamNode)) {
                throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR,
                        "Find workflow node failed -- destination node not exists.", "目的节点不存在");
            }
            NodeInputPort downstreamNodePort = downstreamNode.getInputNodePort(dstNodePortId);
            if(DataUtil.isNull(downstreamNodePort)) {
                throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR,
                        "Find workflow node failed -- destination node port not exists.", "输入端口不存在");
            }

            List<NodeLink> outLinks = workflowContext.fetchOutLinks(upstreamNodePort);
            NodeLink targetLink = null;
            if(DataUtil.isNotEmpty(outLinks)) {
                for(NodeLink outLink : outLinks) {
                    if(outLink.data().getDstPortId().equals(dstNodePortId)) {
                        targetLink = outLink;
                        break;
                    }
                }
            }

            if(DataUtil.isNull(targetLink)) {
                throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR,
                        "Remove workflow node link failed -- node link not exists.", "节点链接不存在", upstreamNodePort.data(), downstreamNodePort.data());
            }

            linkDelete.deleteLink(workflowContext, targetLink);
            workflowContext.flush();
            workflowEditUtil.releaseWorkflowResource();
            return workflowContext;
        } catch (Throwable exception) {
            workflowEditUtil.releaseWorkflowResource();
            throw exception;
        }
    }

    //查询实验工作流节点参数值
    public Node queryWorkflowNodeParameters(EmExperiment experiment, Long nodeId, String operId) {

        Workflow workflow = WorkflowHelper.queryWorkflow(new Experiment(experiment));
        WorkflowContext workflowContext = WorkflowContext.BuildWorkflowContext4Lazyload(workflow, operId);
        Node node = workflowContext.fetchNode(nodeId);
        if(DataUtil.isNull(node)) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR,
                    "Find workflow node failed -- node not exists.", "节点不存在");
        }
        workflowContext.clearSkipNodes();
        workflowEditUtil.releaseWorkflowResource();
        return node;
    }

    //验证更新实验工作流节点参数值
    public boolean validateUpdateWorkflowNodeParameter(EmExperiment experiment, Long nodeId, String paramCode, String paramValue, String operId) {

        Workflow workflow = WorkflowHelper.queryWorkflow(new Experiment(experiment));

        try {
            workflowEditUtil.requestWorkflowResource(workflow);
            workflowEditUtil.detectWorkflowShareLock(workflow);
            WorkflowContext workflowContext = WorkflowContext.BuildWorkflowContext4Lazyload(workflow, operId);
            Node node = workflowContext.fetchNode(nodeId);
            if(DataUtil.isNull(node)) {
                throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR,
                        "Find workflow node failed -- node not exists.", "节点不存在");
            }
            NodeParameter nodeParameter = node.searchParameterByCode(paramCode);
            if(DataUtil.isNull(nodeParameter)) {
                throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR,
                        "Find workflow node parameter failed -- node parameter not exists.", "节点参数不存在");
            }
            boolean isPassValidate = ParameterHelper.validateUpdateNodeParameter(node, nodeParameter, paramValue);
            workflowContext.clear();
            workflowEditUtil.releaseWorkflowResource();
            return isPassValidate;
        } catch (Throwable exception) {
            workflowEditUtil.releaseWorkflowResource();
            throw exception;
        }
    }

    //更新实验工作流节点参数值
    @Transactional
    public WorkflowContext updateWorkflowNodeParameter(EmExperiment experiment, Long nodeId, String paramCode, String paramValue, String operId) {

        Workflow workflow = WorkflowHelper.queryWorkflow(new Experiment(experiment));

        try {
            workflowEditUtil.requestWorkflowResource(workflow);
            workflowEditUtil.detectWorkflowShareLock(workflow);
            WorkflowContext workflowContext = WorkflowContext.BuildWorkflowContext4Preload(workflow, operId);
            Node node = workflowContext.fetchNode(nodeId);
            if(DataUtil.isNull(node)) {
                throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR,
                        "Find workflow node failed -- node not exists.", "节点不存在");
            }
            NodeParameter nodeParameter = node.searchParameterByCode(paramCode);
            if(DataUtil.isNull(nodeParameter)) {
                throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR,
                        "Find workflow node parameter failed -- node parameter not exists.", "节点参数不存在");
            }
            parameterCharValueUpdate.updateParameter(workflowContext, node, nodeParameter, paramValue);
            workflowContext.flush();
            workflowEditUtil.releaseWorkflowResource();
            return workflowContext;
        } catch (Throwable exception) {
            workflowEditUtil.releaseWorkflowResource();
            throw exception;
        }
    }
}
