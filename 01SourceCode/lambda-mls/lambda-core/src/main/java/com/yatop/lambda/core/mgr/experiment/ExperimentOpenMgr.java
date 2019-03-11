package com.yatop.lambda.core.mgr.experiment;

import com.yatop.lambda.base.extend.mapper.ExtExperimentOpenMapper;
import com.yatop.lambda.base.model.EmExperimentOpen;
import com.yatop.lambda.core.enums.DataStatusEnum;
import com.yatop.lambda.core.enums.LambdaExceptionEnum;
import com.yatop.lambda.core.exception.LambdaException;
import com.yatop.lambda.core.mgr.base.BaseMgr;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.core.utils.SystemTimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author huangyu
 * @create 2019-03-08-9:56
 */
@Service
public class ExperimentOpenMgr extends BaseMgr {
    @Autowired
    private ExtExperimentOpenMapper extExperimentOpenMapper;

    public EmExperimentOpen insertExperimentOpen(EmExperimentOpen experimentOpen, String operId) {
        if (DataUtil.isNull(experimentOpen) ||
                experimentOpen.isUserNameNotColoured() ||
                experimentOpen.isProjectIdNotColoured() ||
                experimentOpen.isExperimentIdNotColoured()
        ) {
            throw new LambdaException(LambdaExceptionEnum.C_EXPERMNT_DEFAULT_ERROR, "Insert experiment info failed -- invalid insert data.", "无效插入数据");
        }

        EmExperimentOpen insertExperimentOpen = new EmExperimentOpen();
        try {
            Date dtCurrentTime = SystemTimeUtil.getCurrentTime();
            insertExperimentOpen.copyProperties(experimentOpen);
            insertExperimentOpen.setOpenState(DataStatusEnum.NORMAL.getStatus());
            insertExperimentOpen.setLastUpdateTime(dtCurrentTime);
            insertExperimentOpen.setLastUpdateOper(operId);
            insertExperimentOpen.setCreateTime(dtCurrentTime);
            insertExperimentOpen.setCreateOper(operId);
            emExperimentOpenMapper.insertSelective(insertExperimentOpen);
            return insertExperimentOpen;
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.C_EXPERMNT_DEFAULT_ERROR, "Insert experiment info failed.", "插入实验信息失败", e);
        }
    }

    public List<EmExperimentOpen> queryExperimentOpen(EmExperimentOpen experimentOpen) {

        List<EmExperimentOpen> emExperimentOpen = null;
        try {
            if (DataUtil.isNotEmpty(experimentOpen.getUserName())) {
                emExperimentOpen = extExperimentOpenMapper.findExperimentOpenByUserName(experimentOpen.getProjectId(), experimentOpen.getUserName());
            }
            if (DataUtil.isNotNull(experimentOpen.getExperimentId())) {
                emExperimentOpen = extExperimentOpenMapper.findExperimentOpenByExperimentId(experimentOpen.getProjectId(), experimentOpen.getExperimentId());
            }
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.C_EXPERMNT_DEFAULT_ERROR, "Query experiment template info failed.", "查询实验模版信息失败", e);
        }

        if (DataUtil.isNull(emExperimentOpen))
            throw new LambdaException(LambdaExceptionEnum.C_EXPERMNT_DEFAULT_ERROR, "Query experiment template info failed -- invalid status or not found.", "实验模版信息不存在");
        return emExperimentOpen;
    }

    public int deleteExperimentOpen(Long projectId, String userName) {
        if (DataUtil.isNull(projectId) || DataUtil.isEmpty(userName)) {
            throw new LambdaException(LambdaExceptionEnum.C_EXPERMNT_DEFAULT_ERROR, "Query experiment template info failed -- invalid query condition.", "无效查询条件");
        }
        try {
            return extExperimentOpenMapper.deleteExperimentOpen(projectId, userName);
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.C_EXPERMNT_DEFAULT_ERROR, "Query experiment template info failed.", "查询实验模版信息失败", e);
        }
    }
}
