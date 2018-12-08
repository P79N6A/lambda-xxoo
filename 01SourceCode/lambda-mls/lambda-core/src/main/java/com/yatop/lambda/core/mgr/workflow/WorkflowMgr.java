package com.yatop.lambda.core.mgr.workflow;

import com.yatop.lambda.base.mapper.extend.WorkflowMapper;
import com.yatop.lambda.base.model.EmExperiment;
import com.yatop.lambda.base.model.WfFlow;
import com.yatop.lambda.base.model.WfFlowExample;
import com.yatop.lambda.core.enums.DataStatusEnum;
import com.yatop.lambda.core.enums.WorkflowLockStateEnum;
import com.yatop.lambda.core.enums.WorkflowStateEnum;
import com.yatop.lambda.core.exception.LambdaException;
import com.yatop.lambda.core.mgr.base.BaseMgr;
import com.yatop.lambda.core.mgr.experiment.ExperimentMgr;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.core.utils.PagerUtil;
import com.yatop.lambda.core.utils.SystemTimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class WorkflowMgr extends BaseMgr {

    @Autowired
    WorkflowMapper workflowMapper;

    @Autowired
    ExperimentMgr experimentMgr;

    /*
     *
     *   插入新工作流信息（名称、所属项目ID、所属实验ID ...）
     *   返回插入记录
     *
     * */
    public WfFlow insertWorkflow(WfFlow workflow, String operId) {
        if( DataUtil.isNull(workflow) ||
                workflow.isFlowNameNotColoured() ||
                workflow.isOwnerProjectIdNotColoured() ||
                workflow.isOwnerExperimentIdNotColoured() ||
                DataUtil.isEmpty(operId) ) {
            throw new LambdaException("Insert workflow info failed -- invalid insert data.", "无效插入数据");
        }

        WfFlow insertWorkflow = new WfFlow();
        try {
            Date dtCurrentTime = SystemTimeUtil.getCurrentTime();
            insertWorkflow.copyProperties(workflow);
            insertWorkflow.setFlowIdColoured(false);
            insertWorkflow.setShareLockState(WorkflowLockStateEnum.UNLOCKED.getState());
            insertWorkflow.setShareLockMsgColoured(false);
            insertWorkflow.setLastSnapshotIdColoured(false);
            insertWorkflow.setNextSnapshotVersion(1L);
            insertWorkflow.setNodeCount(0L);
            insertWorkflow.setNextDeleteSequence(1L);
            insertWorkflow.setLastJobIdColoured(false);
            insertWorkflow.setFlowState(WorkflowStateEnum.DRAFT.getState());
            insertWorkflow.setStatus(DataStatusEnum.NORMAL.getStatus());
            insertWorkflow.setLastUpdateTime(dtCurrentTime);
            insertWorkflow.setLastUpdateOper(operId);
            insertWorkflow.setCreateTime(dtCurrentTime);
            insertWorkflow.setCreateOper(operId);
            insertWorkflow.setVersion(1L);
            wfFlowMapper.insertSelective(insertWorkflow);
            return insertWorkflow;
        } catch (Throwable e) {
            throw new LambdaException("Insert workflow info failed.", "插入工作流信息失败", e);
        }
    }

    /*
     *
     *   逻辑删除工作流信息
     *   返回删除数量
     *
     * */
    public int deleteWorkflow(WfFlow workflow, String operId) {
        if(DataUtil.isNull(workflow) || workflow.isFlowIdNotColoured() || DataUtil.isEmpty(operId)){
            throw new LambdaException("Delete workflow info -- invalid delete condition.", "无效删除条件");
        }

        try {
            WfFlow deleteWorkflow = new WfFlow();
            deleteWorkflow.setStatus(DataStatusEnum.INVALID.getStatus());
            deleteWorkflow.setLastUpdateTime(SystemTimeUtil.getCurrentTime());
            deleteWorkflow.setLastUpdateOper(operId);
            WfFlowExample example = new WfFlowExample();
            example.createCriteria().andFlowIdEqualTo(workflow.getFlowId()).andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
            return wfFlowMapper.updateByExampleSelective(deleteWorkflow, example);
        } catch (Throwable e) {
            throw new LambdaException("Delete workflow info failed.", "删除工作流信息失败", e);
        }
    }

    /*
     *
     *   更新工作流信息（名称、概要、描述）
     *   返回更新数量
     *
     * */
    public int updateWorkflow(WfFlow workflow, String operId) {
        if( DataUtil.isNull(workflow) || workflow.isFlowIdNotColoured() || DataUtil.isEmpty(operId)) {
            throw new LambdaException("Update workflow info failed -- invalid update condition.", "无效更新条件");
        }

        if(workflow.isFlowNameNotColoured() &&
                workflow.isSummaryNotColoured() &&
                workflow.isDescriptionNotColoured()) {
            throw new LambdaException("Update workflow info failed -- invalid update data.", "无效更新内容");
        }

        if(workflow.isSummaryColoured() && workflow.isDescriptionColoured()) {
            WfFlow thisFLow = queryWorkflow(workflow.getFlowId());
            if(DataUtil.isNull(thisFLow))
                throw new LambdaException("Update workflow info failed -- workflow not existed.", "工作流不存在");

            try {
                EmExperiment ownerExperiment = new EmExperiment();
                ownerExperiment.setExperimentId(thisFLow.getOwnerExperimentId());
                if(workflow.isSummaryColoured())
                    ownerExperiment.setSummary(workflow.getSummary());
                if(workflow.isDescriptionColoured())
                    ownerExperiment.setDescription(workflow.getDescription());
                experimentMgr.updateExperiment(ownerExperiment, operId);
            }
            catch (LambdaException e) {
                throw new LambdaException("Update workflow info failed -- synchronize experiment failed.", "同步实验失败", e);
            }
        }

        WfFlow updateWorkflow = new WfFlow();
        try {
            updateWorkflow.setFlowId(workflow.getFlowId());
            if(workflow.isFlowNameColoured())
                updateWorkflow.setFlowName(workflow.getFlowName());
            if(workflow.isSummaryColoured())
                updateWorkflow.setSummary(workflow.getSummary());
            if(workflow.isDescriptionColoured())
                updateWorkflow.setDescription(workflow.getDescription());

            updateWorkflow.setLastUpdateTime(SystemTimeUtil.getCurrentTime());
            updateWorkflow.setLastUpdateOper((operId));
            return wfFlowMapper.updateByPrimaryKeySelective(updateWorkflow);
        } catch (Throwable e) {
            throw new LambdaException("Update workflow info failed.", "更新工作流信息失败", e);
        }
    }

    /*
     *
     *   更新工作流信息（快照信息）
     *   返回更新数量
     *
     * */
    public int updateWorkflowSnapshot(WfFlow workflow, String operId) {
        if( DataUtil.isNull(workflow) || workflow.isFlowIdNotColoured() || DataUtil.isEmpty(operId)) {
            throw new LambdaException("Update workflow info failed -- invalid update condition.", "无效更新条件");
        }

        if(workflow.isLastSnapshotIdNotColoured()) {
            throw new LambdaException("Update workflow info failed -- invalid update data.", "无效更新内容");
        }

        try {
            return workflowMapper.updateWorkflowSnapshot(workflow.getFlowId(), workflow.getLastSnapshotId(), SystemTimeUtil.getCurrentTime(), operId);
        } catch (Throwable e) {
            throw new LambdaException("Update workflow info failed.", "更新工作流信息失败", e);
        }
    }

    /*
     *
     *   更新工作流信息（运行信息）
     *   返回更新数量
     *
     * */
    public int updateWorkflowExecution(WfFlow workflow, String operId) {
        if( DataUtil.isNull(workflow) || workflow.isFlowIdNotColoured() || DataUtil.isEmpty(operId)) {
            throw new LambdaException("Update workflow info failed -- invalid update condition.", "无效更新条件");
        }

        if(workflow.isLastJobIdNotColoured()) {
            throw new LambdaException("Update workflow info failed -- invalid update data.", "无效更新内容");
        }


        try {
            WfFlow updateWorkflow = new WfFlow();
            updateWorkflow.setFlowId(workflow.getFlowId());
            updateWorkflow.setLastJobId(workflow.getLastJobId());
            return wfFlowMapper.updateByPrimaryKeySelective(updateWorkflow);
        } catch (Throwable e) {
            throw new LambdaException("Update workflow info failed.", "更新工作流信息失败", e);
        }
    }

    /*
     *
     *   更新工作流信息（状态）
     *   返回更新数量
     *
     * */
    public int updateWorkflowState(WfFlow workflow, String operId) {
        if( DataUtil.isNull(workflow) || workflow.isFlowIdNotColoured() || DataUtil.isEmpty(operId)) {
            throw new LambdaException("Update workflow info failed -- invalid update condition.", "无效更新条件");
        }

        if(workflow.isFlowStateNotColoured()) {
            throw new LambdaException("Update workflow info failed -- invalid update data.", "无效更新内容");
        }


        try {
            WfFlow updateWorkflow = new WfFlow();
            updateWorkflow.setFlowId(workflow.getFlowId());
            updateWorkflow.setFlowState(workflow.getFlowState());
            return wfFlowMapper.updateByPrimaryKeySelective(updateWorkflow);
        } catch (Throwable e) {
            throw new LambdaException("Update workflow info failed.", "更新工作流信息失败", e);
        }
    }

    /*
     *
     *   工作流共享锁（加解锁）
     *   返回更新数量
     *
     * */
    private int lockWorkflowShareStateExt(WfFlow workflow, String operId, WorkflowLockStateEnum lockStateEnum) {
        if(DataUtil.isNull(workflow) || workflow.isFlowIdNotColoured() || DataUtil.isEmpty(operId)){
            throw new LambdaException("Lock workflow -- invalid query condition.", "无效加解锁条件");
        }

        try {
            WfFlow lockWorkflow = new WfFlow();
            lockWorkflow.setFlowId(workflow.getFlowId());
            lockWorkflow.setShareLockState(lockStateEnum.getState());
            if(lockWorkflow.isShareLockMsgColoured())
                lockWorkflow.setShareLockMsg(workflow.getShareLockMsg());
            lockWorkflow.setLastUpdateTime(SystemTimeUtil.getCurrentTime());
            lockWorkflow.setLastUpdateOper(operId);
            return wfFlowMapper.updateByPrimaryKeySelective(lockWorkflow);
        } catch (Throwable e) {
            throw new LambdaException("Lock workflow with version failed.", "加解锁工作流失败", e);
        }
    }

    /*
     *
     *   工作流共享锁（加锁）
     *   返回是否成功
     *
     * */
    public boolean lockWorkflowShareState(WfFlow workflow, String operId) {
        return (lockWorkflowShareStateExt(workflow, operId, WorkflowLockStateEnum.LOCKED) == 1 ? true : false);
    }

    /*
     *
     *   工作流共享锁（解锁）
     *   返回是否成功
     *
     * */
    public boolean unlockWorkflowShareStat(WfFlow workflow, String operId) {
        return (lockWorkflowShareStateExt(workflow, operId, WorkflowLockStateEnum.UNLOCKED) == 1 ? true : false);
    }

    /*
     *
     *   工作流节点增加
     *   返回更新数量
     *
     * */
    public int increaseWorkflowNode(WfFlow workflow, String operId) {
        if(DataUtil.isNull(workflow) || workflow.isFlowIdNotColoured() || DataUtil.isEmpty(operId)){
            throw new LambdaException("Update workflow info failed -- invalid update condition.", "无效更新条件");
        }

        try {
            return workflowMapper.increaseWorkflowNode(workflow.getFlowId(), SystemTimeUtil.getCurrentTime(), operId);
        } catch (Throwable e) {
            throw new LambdaException("Update workflow info failed.", "更新工作流信息失败", e);
        }
    }

    /*
     *
     *   工作流节点删除
     *   返回更新数量
     *
     * */
    public int deleteWorkflowNode(WfFlow workflow, Long deleteCount, String operId) {
        if(DataUtil.isNull(workflow) || workflow.isFlowIdNotColoured() || DataUtil.isNull(deleteCount) || DataUtil.isEmpty(operId)){
            throw new LambdaException("Update workflow info failed -- invalid update condition.", "无效更新条件");
        }

        try {
            return workflowMapper.deleteWorkflowNode(workflow.getFlowId(), deleteCount, SystemTimeUtil.getCurrentTime(), operId);
        } catch (Throwable e) {
            throw new LambdaException("Update workflow info failed.", "更新工作流信息失败", e);
        }
    }

    /*
     *
     *   工作流节点删除撤销
     *   返回更新数量
     *
     * */
    public int undoDeleteWorkflowNode(WfFlow workflow, Long deleteCount, String operId) {
        if(DataUtil.isNull(workflow) || workflow.isFlowIdNotColoured() || DataUtil.isNull(deleteCount) || DataUtil.isEmpty(operId)){
            throw new LambdaException("Update workflow info failed -- invalid update condition.", "无效更新条件");
        }

        try {
            return workflowMapper.undoDeleteWorkflowNode(workflow.getFlowId(), deleteCount, SystemTimeUtil.getCurrentTime(), operId);
        } catch (Throwable e) {
            throw new LambdaException("Update workflow info failed.", "更新工作流信息失败", e);
        }
    }

    /*
     *
     *   工作流节点前一删除批次
     *   返回更新数量
     *
     * */
    public long previousDeleteSequence(long nextDeleteSequence) {
        return Math.abs( (nextDeleteSequence - 1) % 32 );
    }

    /*
     *
     *   工作流版本号增加
     *   返回更新数量
     *
     * */
    public int increaseWorkflowVersion(WfFlow workflow, String operId) {
        if(DataUtil.isNull(workflow) || workflow.isFlowIdNotColoured() || DataUtil.isEmpty(operId)){
            throw new LambdaException("update workflow version failed -- invalid update condition.", "无效更新条件");
        }

        try {
            return workflowMapper.increaseWorkflowVersion(workflow.getFlowId(), SystemTimeUtil.getCurrentTime(), operId);
        } catch (Throwable e) {
            throw new LambdaException("update workflow version failed.", "更新工作流版本失败", e);
        }
    }

    /*
     *
     *   查询工作流信息（按实验ID）
     *   返回结果
     *
     * */
    public WfFlow queryWorkflowByExperimentId(Long experimentId) {
        if(DataUtil.isNull(experimentId)){
            throw new LambdaException("Query workflow info failed -- invalid query condition.", "无效查询条件");
        }

        List<WfFlow> resultList;
        try {
            WfFlowExample example = new WfFlowExample();
            example.createCriteria().andOwnerExperimentIdEqualTo(experimentId).andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
            resultList = wfFlowMapper.selectByExample(example);
        } catch (Throwable e) {
            throw new LambdaException("Query workflow info failed.", "查询工作流信息失败", e);
        }

        if(DataUtil.isEmpty(resultList))
            throw new LambdaException("Query workflow info failed -- invalid status or not found.", "已删除或未查找到");

        return resultList.get(0);
    }

    /*
     *
     *   查询工作流信息（按ID）
     *   返回结果
     *
     * */
    public WfFlow queryWorkflow(Long workflowId) {
        if(DataUtil.isNull(workflowId)){
            throw new LambdaException("Query workflow info failed -- invalid query condition.", "无效查询条件");
        }

        WfFlow workflow;
        try {
            workflow = wfFlowMapper.selectByPrimaryKey(workflowId);
        } catch (Throwable e) {
            throw new LambdaException("Query workflow info failed.", "查询工作流信息失败", e);
        }

        if(DataUtil.isNull(workflow) || (workflow.getStatus() == DataStatusEnum.INVALID.getStatus()))
            throw new LambdaException("Query workflow info failed -- invalid status or not found.", "已删除或未查找到");

        return workflow;
    }

    /*
     *
     *   查询工作流信息（按项目ID）
     *   返回结果集
     *
     * */
    public List<WfFlow> queryWorkflow(Long projectId, PagerUtil pager) {
        if(DataUtil.isNull(projectId)){
            throw new LambdaException("Query workflow info failed -- invalid query condition.", "无效查询条件");
        }

        try {
            PagerUtil.startPage(pager);
            WfFlowExample example = new WfFlowExample();
            example.createCriteria().andOwnerProjectIdEqualTo(projectId).andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
            example.setOrderByClause("CREATE_TIME ASC");
            return wfFlowMapper.selectByExample(example);
        } catch (Throwable e) {
            PagerUtil.clearPage(pager);
            throw new LambdaException("Query workflow info failed.", "查询工作流信息失败", e);
        }
    }
}
