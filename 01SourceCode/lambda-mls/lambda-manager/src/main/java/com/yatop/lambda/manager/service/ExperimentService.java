package com.yatop.lambda.manager.service;

import com.yatop.lambda.base.extend.model.ExtEmExperiment;
import com.yatop.lambda.base.model.*;
import com.yatop.lambda.core.mgr.experiment.ExperimentMgr;
import com.yatop.lambda.core.mgr.experiment.ExperimentOpenMgr;
import com.yatop.lambda.core.mgr.experiment.ExperimentTemplateMgr;
import com.yatop.lambda.core.mgr.workflow.snapshot.SnapshotMgr;
import com.yatop.lambda.manager.api.request.experiment.ExperimentRequest;
import com.yatop.lambda.manager.api.response.experiment.AddExperimentNodeResponse;
import com.yatop.lambda.manager.api.response.experiment.ExperimentCanvasResponse;
import com.yatop.lambda.portal.common.utils.PortalUtil;
import com.yatop.lambda.workflow.core.context.WorkflowContext;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.NodeLink;
import com.yatop.lambda.workflow.engine.service.EditorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 实验管理
 *
 * @author huangyu
 * @create 2019-02-26-10:44
 */
@Service
public class ExperimentService {
    @Autowired
    private ExperimentMgr experimentMgr;
    @Autowired
    private ExperimentTemplateMgr experimentTemplateMgr;
    @Autowired
    private EditorService editorService;
    @Autowired
    private ProjectService projectService;
    @Autowired
    private SnapshotMgr snapshotMgr;
    @Autowired
    private ExperimentOpenMgr experimentOpenMgr;

    @Transactional
    public EmExperiment createExperiment(ExperimentRequest vo) {
        //判断项目是否存在
        projectService.queryProject(vo.getProjectId());

        EmExperiment experiment = new EmExperiment();
        experiment.setExperimentName(vo.getExperimentName());
        experiment.setOwnerProjectId(vo.getProjectId());
        experiment.setDescription(vo.getDescription());

        experiment = experimentMgr.insertExperiment(experiment, PortalUtil.getCurrentUserName());
        editorService.createWorkflow(experiment, PortalUtil.getCurrentUserName());
        return experiment;
    }

    public List<ExtEmExperiment> queryExperiment(ExperimentRequest vo) {
        projectService.queryProject(vo.getProjectId());
        return experimentMgr.queryExperiment(vo.getProjectId(), vo.getKeyword(), vo);
    }

    @Transactional
    public int deleteExperiment(List<Long> experimentIds) {
        for (Long experimentId : experimentIds) {
            EmExperiment emExperiment = experimentMgr.queryExperiment(experimentId);
            editorService.deleteWorkflow(emExperiment, PortalUtil.getCurrentUserName());
            experimentMgr.deleteExperiment(experimentId, PortalUtil.getCurrentUserName());
        }
        return experimentIds.size();
    }

    @Transactional
    public int updateExperiment(ExperimentRequest vo) {
        projectService.queryProject(vo.getProjectId());
        EmExperiment emExperiment = experimentMgr.queryExperiment(vo.getExperimentId());
        emExperiment.setExperimentName(vo.getExperimentName());
        emExperiment.setDescription(vo.getDescription());
        return experimentMgr.updateExperiment(emExperiment, PortalUtil.getCurrentUserName());
    }

    @Transactional
    public EmExperiment createExperimentByTemplate(ExperimentRequest vo) {
        //判断项目是否存在
        projectService.queryProject(vo.getProjectId());

        EmExperimentTemplate template = experimentTemplateMgr.queryExperimentTemplate(vo.getTemplateId());

        EmExperiment experiment = new EmExperiment();
        experiment.setExperimentName(vo.getExperimentName() + "_" + template.getTemplateCount() + 1);
        experiment.setOwnerProjectId(vo.getProjectId());
        experiment.setSummary(template.getSummary());
        experiment.setDescription(template.getDescription());

        experiment = experimentMgr.insertExperiment(experiment, PortalUtil.getCurrentUserName());
        editorService.createWorkflowByTemplate(experiment, template, PortalUtil.getCurrentUserName());
        return experiment;
    }

    @Transactional
    public EmExperiment copyExperiment(ExperimentRequest vo) {
        //判断项目是否存在
        projectService.queryProject(vo.getProjectId());

        EmExperiment copyExperiment = experimentMgr.queryExperiment(vo.getExperimentId());

        EmExperiment experiment = new EmExperiment();
        experiment.setExperimentName(vo.getExperimentName());
        experiment.setDescription(vo.getDescription());
        experiment.setOwnerProjectId(vo.getProjectId());
        experiment = experimentMgr.insertExperiment(experiment, PortalUtil.getCurrentUserName());
        //TODO Copy是否可以为空的实验
        editorService.createWorkflowByCopy(experiment, copyExperiment, PortalUtil.getCurrentUserName());
        return experiment;
    }

    @Transactional
    public EmExperiment createExperimentBySnapshot(ExperimentRequest vo) {
        //判断项目是否存在
        projectService.queryProject(vo.getProjectId());

        WfSnapshot snapshot = snapshotMgr.querySnapshot(vo.getSnapshotId());

        EmExperiment experiment = new EmExperiment();
        experiment.setExperimentName(vo.getExperimentName());
        experiment.setDescription(vo.getDescription());
        experiment.setOwnerProjectId(vo.getProjectId());

        experiment = experimentMgr.insertExperiment(experiment, PortalUtil.getCurrentUserName());
        editorService.createWorkflowByShapshot(experiment, snapshot, PortalUtil.getCurrentUserName());

        return experiment;
    }

    public EmExperimentOpen openExperiment(ExperimentRequest vo) {

        String userName = PortalUtil.getCurrentUserName();
        projectService.queryProject(vo.getProjectId());
        experimentMgr.queryExperiment(vo.getExperimentId());

        EmExperimentOpen experimentOpen = new EmExperimentOpen();
        experimentOpen.setProjectId(vo.getProjectId());
        experimentOpen.setExperimentId(vo.getExperimentId());
        experimentOpen.setUserName(userName);

        List<EmExperimentOpen> emExperimentOpenList = experimentOpenMgr.queryExperimentOpen(experimentOpen);
        if (emExperimentOpenList.size() == 1) {
            experimentOpenMgr.deleteExperimentOpen(vo.getProjectId(), userName);
        }
        if (emExperimentOpenList.size() > 4) {
            experimentOpenMgr.deleteExperimentOpen(vo.getProjectId(), userName);
        }
        return experimentOpenMgr.insertExperimentOpen(experimentOpen, userName);
    }


    public List<EmExperimentTemplate> queryExperimentTemplate() {
        return experimentTemplateMgr.queryExperimentTemplate("", null);
    }


    public ExperimentCanvasResponse queryExperimentCanvas(ExperimentRequest vo) {
        projectService.queryProject(vo.getProjectId());
        EmExperiment emExperiment = experimentMgr.queryExperiment(vo.getExperimentId());
        WorkflowContext workflowContext = editorService.queryWorkflowGraph(emExperiment, PortalUtil.getCurrentUserName());
        ExperimentCanvasResponse response = new ExperimentCanvasResponse(workflowContext);
        return response;
    }


    public AddExperimentNodeResponse addExperimentNode(ExperimentRequest vo) {
        projectService.queryProject(vo.getProjectId());
        EmExperiment emExperiment = experimentMgr.queryExperiment(vo.getExperimentId());
        editorService.createWorkflowNode(emExperiment, vo.getModuleId(), vo.getPosX(), vo.getPosY(),
                PortalUtil.getCurrentUserName());

        WorkflowContext context = editorService.queryWorkflowGraph(emExperiment,
                PortalUtil.getCurrentUserName());
        return new AddExperimentNodeResponse(context);
    }

    public AddExperimentNodeResponse addExperimentNode4Model(ExperimentRequest vo) {
        projectService.queryProject(vo.getProjectId());
        EmExperiment experiment = experimentMgr.queryExperiment(vo.getExperimentId());

        editorService.createWorkflowNode4ReadModel(experiment, vo.getModelId(),
                vo.getPosX(), vo.getPosY(), PortalUtil.getCurrentUserName());
        WorkflowContext context = editorService.queryWorkflowGraph(experiment,
                PortalUtil.getCurrentUserName());
        return new AddExperimentNodeResponse(context);

    }

    public AddExperimentNodeResponse addExperimentNode4Table(ExperimentRequest vo) {
        projectService.queryProject(vo.getProjectId());
        EmExperiment experiment = experimentMgr.queryExperiment(vo.getExperimentId());

        editorService.createWorkflowNode4ReadTable(experiment, vo.getTableName(),
                vo.getPosX(), vo.getPosY(), PortalUtil.getCurrentUserName());
        WorkflowContext context = editorService.queryWorkflowGraph(experiment,
                PortalUtil.getCurrentUserName());
        return new AddExperimentNodeResponse(context);
    }

    public Object updateExperimentNodeLocation(ExperimentRequest vo) {
        editorService.batchUpdateWorkflowNodePosition(vo.getNodeIds(), vo.getPosXs(), vo.getPosYs(), PortalUtil.getCurrentUserName());
        return "已更改位置！";
    }

    public Object validateExperimentNodeLink(ExperimentRequest vo) {
        projectService.queryProject(vo.getProjectId());
        experimentMgr.queryExperiment(vo.getExperimentId());

        EmExperiment emExperiment = new EmExperiment();
        emExperiment.setOwnerProjectId(vo.getProjectId());
        emExperiment.setExperimentId(vo.getExperimentId());
        return editorService.validateCreateWorkflowNodeLink(emExperiment, vo.getSrcNodeId(), vo.getDstNodeId(),
                vo.getSrcNodePortId(), vo.getDstNodePortId(), PortalUtil.getCurrentUserName());
        //return null;
    }

    public WfFlowNodeLink addExperimentNodeLink(ExperimentRequest vo) {
        projectService.queryProject(vo.getProjectId());
        EmExperiment emExperiment = experimentMgr.queryExperiment(vo.getExperimentId());

        NodeLink link = editorService.createWorkflowNodeLink(emExperiment, vo.getSrcNodeId(), vo.getDstNodeId(),
                vo.getSrcNodePortId(), vo.getDstNodePortId(), PortalUtil.getCurrentUserName());
        return link.data();
    }

}
