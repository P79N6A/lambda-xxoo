package com.yatop.lambda.manager.service;

import com.yatop.lambda.base.model.EmExperiment;
import com.yatop.lambda.core.mgr.experiment.ExperimentMgr;
import com.yatop.lambda.core.mgr.experiment.ExperimentTemplateMgr;
import com.yatop.lambda.manager.api.request.project.ExperimentRequest;
import com.yatop.lambda.portal.common.utils.PortalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public EmExperiment createExperiment(ExperimentRequest vo) {
        EmExperiment emExperiment = new EmExperiment();
        emExperiment.setOwnerProjectId(vo.getProjectId());
        emExperiment.setExperimentName(vo.getExperimentName());
        emExperiment.setSummary(vo.getSummary());
        emExperiment.setDescription(vo.getDescription());
        return experimentMgr.insertExperiment(emExperiment, PortalUtil.getCurrentUser().getUsername());
    }

    public List<EmExperiment> queryExperiment(ExperimentRequest vo) {
        return experimentMgr.queryExperiment(vo.getProjectId(), vo.getKeyword(), vo);
    }

    public Object deleteExperiment(List<Long> experimentIds) {
        for (Long c : experimentIds) {
            experimentMgr.deleteExperiment(c, PortalUtil.getCurrentUser().getUsername());
        }
        return experimentIds.size();
    }

    public Object updateExperiment(ExperimentRequest vo) {
        EmExperiment emExperiment = new EmExperiment();
        emExperiment.setExperimentName(vo.getExperimentName());
        emExperiment.setDescription(vo.getDescription());
        emExperiment.setExperimentId(vo.getExperimentId());
        return experimentMgr.updateExperiment(emExperiment, PortalUtil.getCurrentUser().getUsername());
    }

    public Object createTemplate(ExperimentRequest vo) {
        int templateCount = experimentTemplateMgr.selectMaxTemplateCount(vo.getTemplateId());
        EmExperiment entity = new EmExperiment();
        entity.setSummary(vo.getSummary());
        entity.setDescription(vo.getDescription());
        entity.setOwnerProjectId(vo.getProjectId());
        //在实验名称后添加一个模板使用次数叠加值
        entity.setExperimentName(vo.getExperimentName() + "_" + templateCount);
        return experimentMgr.insertExperiment(entity, PortalUtil.getCurrentUser().getUsername());
    }
}
