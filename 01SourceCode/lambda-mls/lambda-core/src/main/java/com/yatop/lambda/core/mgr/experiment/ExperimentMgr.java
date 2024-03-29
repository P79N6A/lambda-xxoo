package com.yatop.lambda.core.mgr.experiment;

import com.yatop.lambda.base.extend.mapper.ExtExperimentMapper;
import com.yatop.lambda.base.extend.model.ExtEmExperiment;
import com.yatop.lambda.base.model.EmExperiment;
import com.yatop.lambda.core.enums.DataStatusEnum;
import com.yatop.lambda.core.enums.LambdaExceptionEnum;
import com.yatop.lambda.core.exception.LambdaException;
import com.yatop.lambda.core.mgr.base.BaseMgr;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.core.utils.PagerUtil;
import com.yatop.lambda.core.utils.SystemTimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ExperimentMgr extends BaseMgr {

    @Autowired
    private ExtExperimentMapper extExperimentMapper;


    /*
     *
     *   插入新实验信息（名称、类型、所属项目ID ...）
     *   返回插入记录
     *
     * */
    public EmExperiment insertExperiment(EmExperiment experiment, String operId) {
        if( DataUtil.isNull(experiment) ||
                experiment.isExperimentNameNotColoured() ||
                experiment.isOwnerProjectIdNotColoured() ||
                DataUtil.isEmpty(operId) ) {
            throw new LambdaException(LambdaExceptionEnum.C_EXPERMNT_DEFAULT_ERROR, "Insert experiment info failed -- invalid insert data.", "无效插入数据");
        }

        EmExperiment insertExperiment = new EmExperiment();
        try {
            Date dtCurrentTime = SystemTimeUtil.getCurrentTime();
            insertExperiment.copyProperties(experiment);
            insertExperiment.setExperimentIdColoured(false);
            insertExperiment.setStatus(DataStatusEnum.NORMAL.getStatus());
            insertExperiment.setLastUpdateTime(dtCurrentTime);
            insertExperiment.setLastUpdateOper(operId);
            insertExperiment.setCreateTime(dtCurrentTime);
            insertExperiment.setCreateOper(operId);
            emExperimentMapper.insertSelective(insertExperiment);
            return insertExperiment;
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.C_EXPERMNT_DEFAULT_ERROR, "Insert experiment info failed.", "插入实验信息失败", e);
        }
    }

    /*
     *
     *   逻辑删除实验信息
     *   返回删除数量
     *
     * */
    public int deleteExperiment(Long experimentId, String operId) {
        if(DataUtil.isNull(experimentId) || DataUtil.isEmpty(operId)){
            throw new LambdaException(LambdaExceptionEnum.C_EXPERMNT_DEFAULT_ERROR, "Delete experiment info failed -- invalid delete condition.", "无效删除条件");
        }

        try {
            EmExperiment deleteExperiment = new EmExperiment();
            deleteExperiment.setExperimentId(experimentId);
            deleteExperiment.setStatus(DataStatusEnum.INVALID.getStatus());
            deleteExperiment.setLastUpdateTime(SystemTimeUtil.getCurrentTime());
            deleteExperiment.setLastUpdateOper(operId);
            return emExperimentMapper.updateByPrimaryKeySelective(deleteExperiment);
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.C_EXPERMNT_DEFAULT_ERROR, "Delete experiment info failed.", "删除实验信息失败", e);
        }
    }

    /*
     *
     *   更新实验信息（实验名称、DFS实验目录、本地实验目录）
     *   返回更新数量
     *
     * */
    public int updateExperiment(EmExperiment experiment, String operId) {
        if( DataUtil.isNull(experiment) || DataUtil.isNull(experiment.getExperimentId()) || DataUtil.isEmpty(operId)) {
            throw new LambdaException(LambdaExceptionEnum.C_EXPERMNT_DEFAULT_ERROR, "Update experiment info failed -- invalid update condition.", "无效更新条件");
        }

        if(experiment.isExperimentNameNotColoured() &&
                experiment.isSummaryNotColoured() &&
                experiment.isDescriptionNotColoured() ) {
            throw new LambdaException(LambdaExceptionEnum.C_EXPERMNT_DEFAULT_ERROR, "Update experiment info failed -- invalid update data.", "无效更新内容");
        }

        EmExperiment updateExperiment = new EmExperiment();
        try {
            updateExperiment.setExperimentId(experiment.getExperimentId());
            if(experiment.isExperimentNameColoured())
                updateExperiment.setExperimentName(experiment.getExperimentName());
            if(experiment.isSummaryColoured())
                updateExperiment.setSummary(experiment.getSummary());
            if(experiment.isDescriptionColoured())
                updateExperiment.setDescription(experiment.getDescription());

            updateExperiment.setLastUpdateTime(SystemTimeUtil.getCurrentTime());
            updateExperiment.setLastUpdateOper((operId));

            experiment.setLastUpdateTime(updateExperiment.getLastUpdateTime());
            experiment.setLastUpdateOper(updateExperiment.getLastUpdateOper());
            return emExperimentMapper.updateByPrimaryKeySelective(updateExperiment);
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.C_EXPERMNT_DEFAULT_ERROR, "Update experiment info failed.", "更新实验信息失败", e);
        }
    }

    /*
     *
     *   查询实验信息（按ID）
     *   返回结果
     *
     * */
    public EmExperiment queryExperiment(Long id) {
        if(DataUtil.isNull(id)){
            throw new LambdaException(LambdaExceptionEnum.C_EXPERMNT_DEFAULT_ERROR, "Query experiment info failed -- invalid query condition.", "无效查询条件");
        }

        EmExperiment experiment;
        try {
            experiment = emExperimentMapper.selectByPrimaryKey(id);
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.C_EXPERMNT_DEFAULT_ERROR, "Query experiment info failed.", "查询实验信息失败", e);
        }

        if(DataUtil.isNull(experiment) || (experiment.getStatus() == DataStatusEnum.INVALID.getStatus()))
            throw new LambdaException(LambdaExceptionEnum.C_EXPERMNT_DEFAULT_ERROR, "Query experiment info failed -- invalid status or not found.", "实验信息不存在");

        return experiment;
    }

    /*
     *
     *   查询实验信息（按项目+[关键字]）
     *   返回结果集
     *
     * */
    public List<ExtEmExperiment> queryExperiment(Long projectId, String keyword, PagerUtil pager) {
        if(DataUtil.isNull(projectId)){
            throw new LambdaException(LambdaExceptionEnum.C_EXPERMNT_DEFAULT_ERROR, "Query experiment info failed -- invalid query condition.", "无效查询条件");
        }

        try {
            PagerUtil.startPage(pager);

            if(DataUtil.isNotEmpty(keyword)) {
                return extExperimentMapper.queryExperiment(projectId, DataUtil.likeKeyword(keyword),DataStatusEnum.NORMAL.getStatus());
            } else {
                return extExperimentMapper.queryExperimentByProjectId(projectId,DataStatusEnum.NORMAL.getStatus());
            }

        } catch (Throwable e) {
            PagerUtil.clearPage(pager);
            throw new LambdaException(LambdaExceptionEnum.C_EXPERMNT_DEFAULT_ERROR, "Query experiment info failed.", "查询实验信息失败", e);
        }
    }

}
