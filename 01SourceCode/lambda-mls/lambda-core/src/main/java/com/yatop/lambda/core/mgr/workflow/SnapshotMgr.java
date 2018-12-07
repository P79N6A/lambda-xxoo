package com.yatop.lambda.core.mgr.workflow;

import com.yatop.lambda.base.model.WfSnapshot;
import com.yatop.lambda.base.model.WfSnapshotExample;
import com.yatop.lambda.core.enums.DataStatusEnum;
import com.yatop.lambda.core.enums.SnapshotSourceEnum;
import com.yatop.lambda.core.enums.SnapshotStateEnum;
import com.yatop.lambda.core.exception.LambdaException;
import com.yatop.lambda.core.mgr.base.BaseMgr;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.core.utils.PagerUtil;
import com.yatop.lambda.core.utils.SystemTimeUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SnapshotMgr extends BaseMgr {

    /*
     *
     *   插入新快照信息（名称、所属项目ID、所属实验ID、快照状态）
     *   返回插入记录
     *
     * */
    public WfSnapshot insertSnapshot(WfSnapshot snapshot, String operId) {
        if( DataUtil.isNull(snapshot) ||
                snapshot.isSnapshotNameNotColoured() ||
                snapshot.isSnapshotSrcNotColoured() ||
                snapshot.isOwnerProjectIdNotColoured() ||
                snapshot.isOwnerFlowIdNotColoured() ||
                snapshot.isSnapshotContentNotColoured() ||
                snapshot.isSnapshotVersionNotColoured() ||
                DataUtil.isEmpty(operId) ) {
            throw new LambdaException("Insert snapshot info failed -- invalid insert data.", "无效插入数据");
        }

        WfSnapshot insertSnapshot = new WfSnapshot();
        try {
            Date dtCurrentTime = SystemTimeUtil.getCurrentTime();
            BeanUtils.copyProperties(snapshot, insertSnapshot);
            insertSnapshot.setSnapshotIdColoured(false);
            insertSnapshot.setSnapshotState(SnapshotStateEnum.FINISHED.getState());
            insertSnapshot.setStatus(DataStatusEnum.NORMAL.getStatus());
            insertSnapshot.setLastUpdateTime(dtCurrentTime);
            insertSnapshot.setLastUpdateOper(operId);
            insertSnapshot.setCreateTime(dtCurrentTime);
            insertSnapshot.setCreateOper(operId);
            wfSnapshotMapper.insertSelective(insertSnapshot);
            return insertSnapshot;
        } catch (Throwable e) {
            throw new LambdaException("Insert snapshot info failed.", "插入快照信息失败", e);
        }
    }

    /*
     *
     *   逻辑删除快照信息
     *   返回删除数量
     *
     * */
    public int deleteSnapshot(WfSnapshot snapshot, String operId) {
        if(DataUtil.isNull(snapshot) || snapshot.isSnapshotIdNotColoured() || DataUtil.isEmpty(operId)){
            throw new LambdaException("Delete snapshot info -- invalid query condition.", "无效删除条件");
        }

        try {
            WfSnapshot deleteSnapshot = new WfSnapshot();
            deleteSnapshot.setStatus(DataStatusEnum.INVALID.getStatus());
            deleteSnapshot.setLastUpdateTime(SystemTimeUtil.getCurrentTime());
            deleteSnapshot.setLastUpdateOper(operId);
            WfSnapshotExample example = new WfSnapshotExample();
            example.createCriteria().andSnapshotIdEqualTo(snapshot.getSnapshotId()).andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
            return wfSnapshotMapper.updateByExampleSelective(deleteSnapshot, example);
        } catch (Throwable e) {
            throw new LambdaException("Delete snapshot info failed.", "删除快照信息失败", e);
        }
    }

    /*
     *
     *   更新快照信息（名称、描述）
     *   返回更新数量
     *
     * */
    public int updateSnapshot(WfSnapshot snapshot, String operId) {
        if( DataUtil.isNull(snapshot) || snapshot.isSnapshotIdNotColoured() || DataUtil.isEmpty(operId)) {
            throw new LambdaException("Update snapshot info failed -- invalid update condition.", "无效更新条件");
        }

        if(snapshot.isSnapshotNameColoured() &&
                snapshot.isDescriptionNotColoured()) {
            throw new LambdaException("Update snapshot info failed -- invalid update data.", "无效更新内容");
        }

        WfSnapshot updateSnapshot = new WfSnapshot();
        try {
            updateSnapshot.setSnapshotId(snapshot.getSnapshotId());
            if(snapshot.isSnapshotNameColoured())
                updateSnapshot.setSnapshotName(snapshot.getSnapshotName());
            if(snapshot.isDescriptionColoured()) {
                updateSnapshot.setDescription(snapshot.getDescription());
            }

            updateSnapshot.setLastUpdateTime(SystemTimeUtil.getCurrentTime());
            updateSnapshot.setLastUpdateOper((operId));
            return wfSnapshotMapper.updateByPrimaryKeySelective(updateSnapshot);
        } catch (Throwable e) {
            throw new LambdaException("Update snapshot info failed.", "更新快照信息失败", e);
        }
    }

    /*
     *
     *   完成快照
     *   返回更新数量
     *
     * */
    public int finishSnapshot(WfSnapshot snapshot, String operId) {
        if( DataUtil.isNull(snapshot) || snapshot.isSnapshotIdNotColoured() || DataUtil.isEmpty(operId)) {
            throw new LambdaException("Finish snapshot failed -- invalid update condition.", "无效完成条件");
        }

        if(snapshot.isSnapshotIdNotColoured() &&
                snapshot.isDescriptionNotColoured()) {
            throw new LambdaException("Finish snapshot failed -- invalid update data.", "无效完成内容");
        }

        WfSnapshot updateSnapshot = new WfSnapshot();
        try {
            updateSnapshot.setSnapshotId(snapshot.getSnapshotId());
            if(snapshot.isSnapshotContentColoured())
                updateSnapshot.setSnapshotContent(snapshot.getSnapshotContent());
            if(snapshot.isDescriptionColoured()) {
                updateSnapshot.setDescription(snapshot.getDescription());
            }

            updateSnapshot.setSnapshotState(SnapshotStateEnum.FINISHED.getState());
            updateSnapshot.setLastUpdateTime(SystemTimeUtil.getCurrentTime());
            updateSnapshot.setLastUpdateOper((operId));
            return wfSnapshotMapper.updateByPrimaryKeySelective(updateSnapshot);
        } catch (Throwable e) {
            throw new LambdaException("Finish snapshot failed.", "完成快照失败", e);
        }
    }

    /*
     *
     *   查询快照信息（按ID）
     *   返回结果
     *
     * */
    public WfSnapshot querySnapshot(Long snapshotId) {
        if(DataUtil.isNull(snapshotId)){
            throw new LambdaException("Query snapshot info failed -- invalid query condition.", "无效查询条件");
        }

        WfSnapshot snapshot;
        try {
            snapshot = wfSnapshotMapper.selectByPrimaryKey(snapshotId);
        } catch (Throwable e) {
            throw new LambdaException("Query snapshot info failed.", "查询快照信息失败", e);
        }

        if(DataUtil.isNull(snapshot) || (snapshot.getStatus() == DataStatusEnum.INVALID.getStatus()))
            throw new LambdaException("Query snapshot info failed -- invalid status or not found.", "已删除或未查找到");

        return snapshot;
    }

    /*
     *
     *   查询快照信息（按项目ID + [工作流ID] + [快照来源] + [快照状态]）
     *   返回结果集
     *
     * */
    public List<WfSnapshot> querySnapshot(Long projectId, Long flowId, SnapshotSourceEnum sourceEnum, SnapshotStateEnum stateEnum, PagerUtil pager) {
        if(DataUtil.isNull(projectId)){
            throw new LambdaException("Query snapshot info failed -- invalid query condition.", "无效查询条件");
        }

        try {
            PagerUtil.startPage(pager);
            WfSnapshotExample example = new WfSnapshotExample();
            WfSnapshotExample.Criteria cond = example.createCriteria().andOwnerProjectIdEqualTo(projectId);

            if(DataUtil.isNotNull(flowId))
                cond.andOwnerFlowIdEqualTo(flowId);
            if(DataUtil.isNotNull(sourceEnum))
                cond.andSnapshotSrcEqualTo(sourceEnum.getSource());
            if(DataUtil.isNotNull(stateEnum))
                cond.andSnapshotStateEqualTo(stateEnum.getState());

            cond.andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
            example.setOrderByClause("CREATE_TIME ASC");
            return wfSnapshotMapper.selectByExample(example);
        } catch (Throwable e) {
            PagerUtil.clearPage(pager);
            throw new LambdaException("Query snapshot info failed.", "查询快照信息失败", e);
        }
    }
}