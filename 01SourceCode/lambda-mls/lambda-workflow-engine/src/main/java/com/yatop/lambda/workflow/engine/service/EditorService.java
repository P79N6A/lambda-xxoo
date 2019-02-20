package com.yatop.lambda.workflow.engine.service;

import com.yatop.lambda.base.model.*;
import com.yatop.lambda.core.enums.LambdaExceptionEnum;
import com.yatop.lambda.core.exception.LambdaException;
import com.yatop.lambda.core.mgr.experiment.ExperimentTemplateMgr;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.context.WorkflowContext;
import com.yatop.lambda.workflow.core.mgr.workflow.WorkflowCreate;
import com.yatop.lambda.workflow.core.mgr.workflow.WorkflowDelete;
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
import com.yatop.lambda.workflow.core.richmodel.experiment.Experiment;
import com.yatop.lambda.workflow.core.richmodel.workflow.module.Module;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.*;
import com.yatop.lambda.workflow.core.richmodel.workflow.snapshot.Snapshot;
import com.yatop.lambda.workflow.core.utils.WorkflowEditUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class EditorService {

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
        WfFlow workflow = workflowContext.getWorkflow().data();
        workflowContext.clear();
        return workflow;
    }

    //创建实验工作流（复制）
    @Transactional
    public WfFlow createWorkflowByCopy(EmExperiment experiment, EmExperiment copyExperiment, String operId) {

        Experiment richExperiment = new Experiment(experiment);
        Experiment richCopyExperiment = new Experiment(copyExperiment);

        try {
            workflowEditUtil.requestWorkflowResource(richCopyExperiment);
            WorkflowContext copyWorkflowContext = WorkflowContext.BuildWorkflowContext4Preload(richCopyExperiment, operId);
            WorkflowContext thisWorkflowContext = workflowCreate.createWorkflow(richExperiment, copyWorkflowContext, operId);
            WfFlow workflow = thisWorkflowContext.getWorkflow().data();
            thisWorkflowContext.clear();
            return workflow;
        } catch (Throwable exception) {
            workflowEditUtil.releaseWorkflowResource();
            throw exception;
        }
    }

    //创建实验工作流（快照）
    @Transactional
    public WfFlow createWorkflowByShapshot(EmExperiment experiment, Long snapshotId, String operId) {

        Experiment richExperiment = new Experiment(experiment);
        WorkflowContext snapshotWorkflowContext = WorkflowContext.BuildWorkflowContext4ViewSnapshot(snapshotId, operId);
        WorkflowContext thisWorkflowContext = workflowCreate.createWorkflow(richExperiment, snapshotWorkflowContext, operId);
        WfFlow workflow = thisWorkflowContext.getWorkflow().data();
        thisWorkflowContext.clear();
        return workflow;
    }

    //创建实验工作流（实验模版）
    @Transactional
    public WfFlow createWorkflowByTemplate(EmExperiment experiment, Long templateId, String operId) {

        Experiment richExperiment = new Experiment(experiment);
        WorkflowContext templateWorkflowContext = WorkflowContext.BuildWorkflowContext4ViewTemplate(templateId, operId);
        WorkflowContext thisWorkflowContext = workflowCreate.createWorkflow(richExperiment, templateWorkflowContext, operId);
        WfFlow workflow = thisWorkflowContext.getWorkflow().data();
        thisWorkflowContext.clear();
        experimentTemplateMgr.increaseTemplateCount(templateId, operId);
        return workflow;
    }

    //删除实验工作流
    @Transactional
    public void deleteWorkflow(EmExperiment experiment, String operId) {

        Experiment richExperiment = new Experiment(experiment);

        try {
            workflowEditUtil.requestWorkflowResource(richExperiment);
            workflowEditUtil.detectWorkflowShareLock(richExperiment);
            WorkflowContext workflowContext = WorkflowContext.BuildWorkflowContext4Preload(richExperiment, operId);
            workflowDelete.deleteWorkflow(workflowContext);
            workflowContext.clearAll();
        } catch (Throwable exception) {
            workflowEditUtil.releaseWorkflowResource();
            throw exception;
        }
    }

    public WorkflowContext queryWorkflowGraph(EmExperiment experiment, String operId) {

        Experiment richExperiment = new Experiment(experiment);
        return WorkflowContext.BuildWorkflowContext4Preload(richExperiment, operId, false);
    }

    //保存实验工作流副本快照
    @Transactional
    public WfSnapshot saveWorkflowSnapshot(EmExperiment experiment, String snapshotName, String operId) {

        Experiment richExperiment = new Experiment(experiment);

        try {
            workflowEditUtil.requestWorkflowResource(richExperiment);
            workflowEditUtil.detectWorkflowShareLock(richExperiment);
            WorkflowContext workflowContext = WorkflowContext.BuildWorkflowContext4Preload(richExperiment, operId);
            Snapshot snapshot = snapshotCreate.createSnapshot4Copy(workflowContext, snapshotName);
            workflowContext.clearAll();
            return snapshot.data();
        } catch (Throwable exception) {
            workflowEditUtil.releaseWorkflowResource();
            throw exception;
        }
    }

    //查看实验工作流副本快照
    public WorkflowContext viewWorkflowSnapshot(Long snapshotId, String operId) {
        return WorkflowContext.BuildWorkflowContext4ViewSnapshot(snapshotId, operId);
    }

    //添加实验工作流节点
    @Transactional
    public Node createWorkflowNode(EmExperiment experiment, Long moduleId, Long posX, Long posY, String operId) {

        Module module = workflowEditUtil.findWorkflowModule(moduleId);
        Experiment richExperiment = new Experiment(experiment);

        try {
            workflowEditUtil.requestWorkflowResource(richExperiment);
            workflowEditUtil.detectWorkflowShareLock(richExperiment);
            WorkflowContext workflowContext = WorkflowContext.BuildWorkflowContext4Lazyload(richExperiment, operId);
            Node node = nodeCreate.createNode(workflowContext, module, posX, posY);
            workflowContext.flush();
            workflowContext.clear(true, false);
            return node;
        } catch (Throwable exception) {
            workflowEditUtil.releaseWorkflowResource();
            throw exception;
        }
    }

    //添加实验工作流节点（指定数据表名）
    @Transactional
    public Node createWorkflowNode4ReadTable(EmExperiment experiment, String tableName, Long posX, Long posY, String operId) {

        //读数据表的ModuleId为1
        Module module = workflowEditUtil.findWorkflowModule(1L);
        Experiment richExperiment = new Experiment(experiment);

        try {
            workflowEditUtil.requestWorkflowResource(richExperiment);
            workflowEditUtil.detectWorkflowShareLock(richExperiment);
            WorkflowContext workflowContext = WorkflowContext.BuildWorkflowContext4Lazyload(richExperiment, operId);
            Node node = nodeCreate.createNode(workflowContext, module, posX, posY);

            //TODO 修改节点参数：数据表名 - CCP@IO-TableName
            parameterCharValueUpdate.updateParameter(workflowContext, node, node.getParameterByCharCode("CCP@IO-TableName"), tableName);

            workflowContext.flush();
            workflowContext.clear(true, false);
            return node;
        } catch (Throwable exception) {
            workflowEditUtil.releaseWorkflowResource();
            throw exception;
        }

    }

    //添加实验工作流节点（指定模型ID）
    @Transactional
    public Node createWorkflowNode4ReadModel(EmExperiment experiment, Long modelId, Long posX, Long posY, String operId) {

        //读模型的ModuleId为2
        Module module = workflowEditUtil.findWorkflowModule(2L);
        Experiment richExperiment = new Experiment(experiment);

        try {
            workflowEditUtil.requestWorkflowResource(richExperiment);
            workflowEditUtil.detectWorkflowShareLock(richExperiment);
            WorkflowContext workflowContext = WorkflowContext.BuildWorkflowContext4Lazyload(richExperiment, operId);
            Node node = nodeCreate.createNode(workflowContext, module, posX, posY);

            //TODO 修改节点参数：模型ID - CCP@IO-ModelID
            parameterCharValueUpdate.updateParameter(workflowContext, node, node.getParameterByCharCode("CCP@IO-ModelID"), String.valueOf(modelId));

            workflowContext.flush();
            workflowContext.clear(true, false);
            return node;
        } catch (Throwable exception) {
            workflowEditUtil.releaseWorkflowResource();
            throw exception;
        }
    }

    //批量更新实验工作流节点位置
    @Transactional
    public void batchUpdateWorkflowNodePostion(Long[] nodeIds, Long[] posXs, Long[] posYs, String operId) {

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
    public List<Node> copyWorkflowNodes(EmExperiment experiment, Long[] copyNodeIds, Long[] posXs, Long[] posYs, String operId) {

        Experiment richExperiment = new Experiment(experiment);

        try {
            workflowEditUtil.requestWorkflowResource(richExperiment);
            workflowEditUtil.detectWorkflowShareLock(richExperiment);
            WorkflowContext workflowContext = WorkflowContext.BuildWorkflowContext4Lazyload(richExperiment, operId);

            List<Node> newNodes = new ArrayList<>(copyNodeIds.length);
            for(int i = 0; i < copyNodeIds.length; i++) {
                Node copyNode = workflowContext.fetchNode(copyNodeIds[i]);
                Node newNode = nodeCreate.copyNode4SameWorkflow(workflowContext, copyNode, posXs[i], posYs[i]);
                newNodes.add(newNode);
            }

            workflowContext.flush();
            workflowContext.clear(true, false);
            return newNodes;
        } catch (Throwable exception) {
            workflowEditUtil.releaseWorkflowResource();
            throw exception;
        }
    }

    //删除实验工作流节点，返回删除关联的节点链接
    @Transactional
    public List<NodeLink> deleteWorkflowNodes(EmExperiment experiment, Long[] nodeIds, String operId) {

        Experiment richExperiment = new Experiment(experiment);

        try {
            workflowEditUtil.requestWorkflowResource(richExperiment);
            workflowEditUtil.detectWorkflowShareLock(richExperiment);
            WorkflowContext workflowContext = WorkflowContext.BuildWorkflowContext4Preload(richExperiment, operId);

            List<Node> deleteNodes = new ArrayList<>(nodeIds.length);
            for(int i = 0; i < nodeIds.length; i++) {
                Node deleteNode = workflowContext.fetchNode(nodeIds[i]);
                deleteNodes.add(deleteNode);
            }

            nodeDelete.deleteNodes(workflowContext, deleteNodes);
            workflowContext.flush();

            List<NodeLink> deleteNodeLinks = workflowContext.getDeleteLinks();
            workflowContext.clear();
            return deleteNodeLinks;
        } catch (Throwable exception) {
            workflowEditUtil.releaseWorkflowResource();
            throw exception;
        }
    }

    //撤销删除实验工作流节点
    @Transactional
    public List<Node> recoverDeleteWorkflowNodes(EmExperiment experiment, String operId) {

        Experiment richExperiment = new Experiment(experiment);

        try {
            workflowEditUtil.requestWorkflowResource(richExperiment);
            workflowEditUtil.detectWorkflowShareLock(richExperiment);
            WorkflowContext workflowContext = WorkflowContext.BuildWorkflowContext4Lazyload(richExperiment, operId);

            List<Node> recoverNodes = nodeRecover.recoverNodes(workflowContext);
            workflowContext.flush();
            workflowContext.clear(true, false);
            return recoverNodes;
        } catch (Throwable exception) {
            workflowEditUtil.releaseWorkflowResource();
            throw exception;
        }
    }

    //验证添加实验工作流节点链接
    public boolean validateCreateWorkflowNodeLink(EmExperiment experiment, Long srcNodeId, Long dstNodeId, Long srcNodePortId, Long dstNodePortId, String operId) {

        Experiment richExperiment = new Experiment(experiment);

        try {
            workflowEditUtil.requestWorkflowResource(richExperiment);
            workflowEditUtil.detectWorkflowShareLock(richExperiment);
            WorkflowContext workflowContext = WorkflowContext.BuildWorkflowContext4Lazyload(richExperiment, operId, false);
            boolean isPassValidate = linkValidate.validateLink(workflowContext, srcNodeId, dstNodeId, srcNodePortId, dstNodePortId);
            workflowContext.clearAll();
            return isPassValidate;
        } catch (Throwable exception) {
            workflowEditUtil.releaseWorkflowResource();
            throw exception;
        }
    }

    //添加实验工作流节点链接
    @Transactional
    public NodeLink createWorkflowNodeLink(EmExperiment experiment, Long srcNodeId, Long dstNodeId, Long srcNodePortId, Long dstNodePortId, String operId) {

        Experiment richExperiment = new Experiment(experiment);

        try {
            workflowEditUtil.requestWorkflowResource(richExperiment);
            workflowEditUtil.detectWorkflowShareLock(richExperiment);
            WorkflowContext workflowContext = WorkflowContext.BuildWorkflowContext4Preload(richExperiment, operId);
            NodeLink nodeLink = linkCreate.createLink(workflowContext, srcNodeId, dstNodeId, srcNodePortId, dstNodePortId);
            workflowContext.flush();
            workflowContext.clear();
            return nodeLink;
        } catch (Throwable exception) {
            workflowEditUtil.releaseWorkflowResource();
            throw exception;
        }
    }

    //移除实验工作流节点链接
    @Transactional
    public void removeWorkflowNodeLink(EmExperiment experiment, Long srcNodeId, Long dstNodeId, Long srcNodePortId, Long dstNodePortId, String operId) {

        Experiment richExperiment = new Experiment(experiment);

        try {
            workflowEditUtil.requestWorkflowResource(richExperiment);
            workflowEditUtil.detectWorkflowShareLock(richExperiment);
            WorkflowContext workflowContext = WorkflowContext.BuildWorkflowContext4Preload(richExperiment, operId);
            Node upstreamNode = workflowContext.fetchNode(srcNodeId);
            NodeOutputPort upstreamNodePort = workflowContext.fetchOutputPort(srcNodePortId);
            if(DataUtil.isNull(upstreamNode.getOutputNodePort(srcNodePortId))) {
                throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Remove workflow node link failed -- source node error.", "输出节点信息错误", upstreamNode.data(), upstreamNodePort.data());
            }

            Node downstreamNode = workflowContext.fetchNode(dstNodeId);
            NodeInputPort downstreamNodePort = workflowContext.fetchInputPort(dstNodePortId);
            if(DataUtil.isNull(downstreamNode.getInputNodePort(dstNodePortId))) {
                throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Remove workflow node link failed -- destination node error.", "输入节点信息错误", downstreamNode.data(), downstreamNodePort.data());
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
                throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Remove workflow node link failed -- node link not exists.", "节点链接不存在", upstreamNodePort.data(), downstreamNodePort.data());
            }

            linkDelete.deleteLink(workflowContext, targetLink);
            workflowContext.flush();
            workflowContext.clearAll();
        } catch (Throwable exception) {
            workflowEditUtil.releaseWorkflowResource();
            throw exception;
        }
    }

    //查询实验工作流节点参数值
    public Node queryWorkflowNodeParameters(EmExperiment experiment, Long nodeId, String operId) {

        Experiment richExperiment = new Experiment(experiment);
        WorkflowContext workflowContext = WorkflowContext.BuildWorkflowContext4Preload(richExperiment, operId, false);
        Node node = workflowContext.fetchNode(nodeId);
        workflowContext.clear(true, false);
        return node;
    }

    //验证更新实验工作流节点参数值
    public boolean validateUpdateWorkflowNodeParameter(EmExperiment experiment, Long nodeId, String paramCode, String paramValue, String operId) {

        Experiment richExperiment = new Experiment(experiment);

        try {
            workflowEditUtil.requestWorkflowResource(richExperiment);
            workflowEditUtil.detectWorkflowShareLock(richExperiment);
            WorkflowContext workflowContext = WorkflowContext.BuildWorkflowContext4Lazyload(richExperiment, operId);
            Node node = workflowContext.fetchNode(nodeId);
            NodeParameter nodeParameter = workflowEditUtil.findWorkflowNodeParameter(node, paramCode);
            boolean isPassValidate = ParameterHelper.validateUpdateNodeParameter(workflowContext, node, nodeParameter, paramValue);
            workflowContext.clearAll();
            return isPassValidate;
        } catch (Throwable exception) {
            workflowEditUtil.releaseWorkflowResource();
            throw exception;
        }
    }

    //更新实验工作流节点参数值
    @Transactional
    public Node updateWorkflowNodeParameter(EmExperiment experiment, Long nodeId, String paramCode, String paramValue, String operId) {

        Experiment richExperiment = new Experiment(experiment);

        try {
            workflowEditUtil.requestWorkflowResource(richExperiment);
            workflowEditUtil.detectWorkflowShareLock(richExperiment);
            WorkflowContext workflowContext = WorkflowContext.BuildWorkflowContext4Preload(richExperiment, operId);
            Node node = workflowContext.fetchNode(nodeId);
            NodeParameter nodeParameter = workflowEditUtil.findWorkflowNodeParameter(node, paramCode);
            parameterCharValueUpdate.updateParameter(workflowContext, node, nodeParameter, paramValue);
            workflowContext.flush();
            workflowContext.clear(true, false);
            return node;
        } catch (Throwable exception) {
            workflowEditUtil.releaseWorkflowResource();
            throw exception;
        }
    }
}
