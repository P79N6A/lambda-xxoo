package com.yatop.lambda.manager.service;

import com.yatop.lambda.base.extend.model.ExtEmExperiment;
import com.yatop.lambda.base.model.EmExperiment;
import com.yatop.lambda.base.model.EmExperimentTemplate;
import com.yatop.lambda.base.model.WfSnapshot;
import com.yatop.lambda.core.mgr.experiment.ExperimentMgr;
import com.yatop.lambda.core.mgr.experiment.ExperimentTemplateMgr;
import com.yatop.lambda.core.mgr.workflow.snapshot.SnapshotMgr;
import com.yatop.lambda.manager.api.request.project.ExperimentRequest;
import com.yatop.lambda.portal.common.utils.PortalUtil;
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
        EmExperiment emExperiment = new EmExperiment();
        emExperiment.setExperimentName(vo.getExperimentName());
        emExperiment.setDescription(vo.getDescription());
        emExperiment.setExperimentId(vo.getExperimentId());
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

    public List<EmExperimentTemplate> queryExperimentTemplate() {
        return experimentTemplateMgr.queryExperimentTemplate("",null);
    }
}
