package com.yatop.lambda.core.mgr.workflow;

import com.yatop.lambda.base.mapper.extend.WorkflowMapper;
import com.yatop.lambda.base.model.WfFlow;
import com.yatop.lambda.base.model.WfFlowExample;
import com.yatop.lambda.core.enums.DataStatusEnum;
import com.yatop.lambda.core.enums.WorkflowLockStateEnum;
import com.yatop.lambda.core.enums.WorkflowStateEnum;
import com.yatop.lambda.core.exception.LambdaException;
import com.yatop.lambda.core.exception.WorkFlowExpireException;
import com.yatop.lambda.core.mgr.base.BaseMgr;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.core.utils.PagerUtil;
import com.yatop.lambda.core.utils.SystemTimeUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class WorkflowMgr extends BaseMgr {

    @Autowired
    WorkflowMapper workflowMapper;

    /*
     *
     *   插入新工作流信息（名称、所属项目ID、所属实验ID、工作流状态）
     *   返回插入记录
     *
     * */
    public WfFlow insertWorkflow(WfFlow workflow, String operId) {
        if( DataUtil.isNull(workflow) ||
                !workflow.isFlowNameColoured() ||
                !workflow.isOwnerProjectIdColoured() ||
                !workflow.isOwnerExperimentIdColoured() ||
                DataUtil.isEmpty(operId) ) {
            throw new LambdaException("Insert workflow info failed -- invalid insert data.", "无效插入数据");
        }

        WfFlow insertWorkflow = new WfFlow();
        try {
            Date dtCurrentTime = SystemTimeUtil.getCurrentTime();
            BeanUtils.copyProperties(workflow, insertWorkflow);
            insertWorkflow.setFlowIdColoured(false);
            insertWorkflow.setLockState(WorkflowLockStateEnum.UNLOCKED.getState());
            insertWorkflow.setLockMsgColoured(false);
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
    public int deleteWorkflowWithVersion(WfFlow workflow, String operId) {
        if(DataUtil.isNull(workflow) || DataUtil.isNull(workflow.getFlowId()) || DataUtil.isNull(workflow.getVersion()) || DataUtil.isEmpty(operId)){
            throw new LambdaException("Delete workflow info with version failed -- invalid query condition.", "无效删除条件");
        }

        if(checkWorkflowLocked(workflow.getFlowId())) {
            throw new LambdaException("Delete workflow info with version failed -- workflow locked.", "工作流已加锁");
        }

        int affectRows;
        try {
            WfFlow deleteWorkflow = new WfFlow();
            deleteWorkflow.setStatus(DataStatusEnum.INVALID.getStatus());
            deleteWorkflow.setLastUpdateTime(SystemTimeUtil.getCurrentTime());
            deleteWorkflow.setLastUpdateOper(operId);
            deleteWorkflow.setVersion(workflow.getVersion() + 1);
            WfFlowExample example = new WfFlowExample();
            example.createCriteria().andFlowIdEqualTo(workflow.getFlowId()).andStatusEqualTo(DataStatusEnum.NORMAL.getStatus()).andVersionEqualTo(workflow.getVersion());
            affectRows = wfFlowMapper.updateByExampleSelective(deleteWorkflow, example);
        } catch (Throwable e) {
            throw new LambdaException("Delete workflow info failed.", "删除工作流信息失败", e);
        }

        if(affectRows < 1) {
            throw new WorkFlowExpireException("Delete workflow info with version failed -- affect rows is zero.", "删除影响零行");
        }
        return affectRows;
    }

    /*
     *
     *   更新工作流信息（名称、概要、描述）
     *   返回更新数量
     *
     * */
    public int updateWorkflowWithoutVersion(WfFlow workflow, String operId) {
        if( DataUtil.isNull(workflow) || !workflow.isFlowIdColoured() || DataUtil.isEmpty(operId)) {
            throw new LambdaException("Update workflow info failed -- invalid update condition.", "无效更新条件");
        }

        if(!workflow.isFlowNameColoured() &&
                !workflow.isSummaryColoured() &&
                !workflow.isDescriptionColoured()) {
            throw new LambdaException("Update workflow info failed -- invalid update data.", "无效更新内容");
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
     *   更新工作流信息（快照信息，必须在加锁和解锁中间进行，适用于实验副本和实验运行的快照信息更新）
     *   返回更新数量
     *
     * */
    public int updateWorkflowWithoutVersion4Snapshot(WfFlow workflow, String operId) {
        if( DataUtil.isNull(workflow) || !workflow.isFlowIdColoured() || DataUtil.isEmpty(operId)) {
            throw new LambdaException("Update workflow info for snapshot failed -- invalid update condition.", "无效更新条件");
        }

        if(!workflow.isLastSnapshotIdColoured()) {
            throw new LambdaException("Update workflow info for snapshot failed -- invalid update data.", "无效更新内容");
        }

        WfFlow updateWorkflow = new WfFlow();
        try {
            return workflowMapper.updateWorkflowWithVersion4Snapshot(workflow.getFlowId(), workflow.getLastSnapshotId(), SystemTimeUtil.getCurrentTime(), operId);
        } catch (Throwable e) {
            throw new LambdaException("Update workflow info for snapshot failed.", "更新工作流信息失败", e);
        }
    }

    /*
     *
     *   更新工作流信息（运行信息，必须在加锁和解锁中间进行，适用于实验副本和实验运行的快照信息更新）
     *   返回更新数量
     *
     * */
    public int updateWorkflow4Execution(WfFlow workflow, String operId) {
        if( DataUtil.isNull(workflow) || !workflow.isFlowIdColoured() || DataUtil.isEmpty(operId)) {
            throw new LambdaException("Update workflow info for snapshot failed -- invalid update condition.", "无效更新条件");
        }

        if(!workflow.isLastSnapshotIdColoured()) {
            throw new LambdaException("Update workflow info for snapshot failed -- invalid update data.", "无效更新内容");
        }

        WfFlow updateWorkflow = new WfFlow();
        try {
            return workflowMapper.updateWorkflowWithVersion4Snapshot(workflow.getFlowId(), workflow.getLastSnapshotId(), SystemTimeUtil.getCurrentTime(), operId);
        } catch (Throwable e) {
            throw new LambdaException("Update workflow info for snapshot failed.", "更新工作流信息失败", e);
        }
    }

    /*
     *
     *   加锁工作流
     *   返回记录
     *
     * */
    public WfFlow lockWorkflowWithVersion(WfFlow workflow, String operId) {
        if(DataUtil.isNull(workflow) || DataUtil.isNull(workflow.getFlowId()) || DataUtil.isNull(workflow.getVersion()) || DataUtil.isEmpty(operId)){
            throw new LambdaException("Lock workflow with version failed -- invalid query condition.", "无效加锁条件");
        }

        if(checkWorkflowLocked(workflow.getFlowId())) {
            throw new LambdaException("Lock workflow with version failed -- workflow locked.", "工作流已加锁");
        }

        int affectRows;
        try {
            WfFlow lockWorkflow = new WfFlow();
            lockWorkflow.setLockState(WorkflowLockStateEnum.LOCKED.getState());
            if(lockWorkflow.isLockMsgColoured())
                lockWorkflow.setLockMsg(workflow.getLockMsg());
            lockWorkflow.setLastUpdateTime(SystemTimeUtil.getCurrentTime());
            lockWorkflow.setLastUpdateOper(operId);
            lockWorkflow.setVersion(workflow.getVersion() + 1);
            WfFlowExample example = new WfFlowExample();
            example.createCriteria().andFlowIdEqualTo(workflow.getFlowId()).andStatusEqualTo(DataStatusEnum.NORMAL.getStatus()).andLockStateEqualTo(WorkflowLockStateEnum.UNLOCKED.getState())
                    .andVersionEqualTo(workflow.getVersion());
            affectRows = wfFlowMapper.updateByExampleSelective(lockWorkflow, example);
        } catch (Throwable e) {
            throw new LambdaException("Lock workflow with version failed.", "加锁工作流失败", e);
        }

        if(affectRows < 1) {
            throw new WorkFlowExpireException("Lock workflow with version failed -- affect rows is zero.", "加锁工作流失败");
        }

        return queryWorkflow(workflow.getFlowId());
    }

    /*
     *
     *   解锁工作流
     *   返回记录
     *
     * */
    public WfFlow unlockWorkflowWithVersion(WfFlow workflow, String operId) {
        if(DataUtil.isNull(workflow) || DataUtil.isNull(workflow.getFlowId()) || DataUtil.isNull(workflow.getVersion()) || DataUtil.isEmpty(operId)){
            throw new LambdaException("Unlock workflow with version failed -- invalid query condition.", "无效解锁条件");
        }

        if(!checkWorkflowLocked(workflow.getFlowId())) {
            throw new LambdaException("Unlock workflow with version failed -- workflow locked.", "工作流已解锁");
        }

        int affectRows;
        try {
            WfFlow lockWorkflow = new WfFlow();
            lockWorkflow.setLockState(WorkflowLockStateEnum.UNLOCKED.getState());
            if(lockWorkflow.isLockMsgColoured())
                lockWorkflow.setLockMsg(workflow.getLockMsg());
            lockWorkflow.setLastUpdateTime(SystemTimeUtil.getCurrentTime());
            lockWorkflow.setLastUpdateOper(operId);
            lockWorkflow.setVersion(workflow.getVersion() + 1);
            WfFlowExample example = new WfFlowExample();
            example.createCriteria().andFlowIdEqualTo(workflow.getFlowId()).andStatusEqualTo(DataStatusEnum.NORMAL.getStatus()).andLockStateEqualTo(WorkflowLockStateEnum.LOCKED.getState())
                    .andVersionEqualTo(workflow.getVersion());
            affectRows = wfFlowMapper.updateByExampleSelective(lockWorkflow, example);
        } catch (Throwable e) {
            throw new LambdaException("Unlock workflow with version failed.", "解锁工作流失败", e);
        }

        if(affectRows < 1) {
            throw new WorkFlowExpireException("Unlock workflow with version failed -- affect rows is zero.", "解锁工作流失败");
        }

        //解锁失败属于不可能出现的情况，是否采取强制解锁待定

        return queryWorkflow(workflow.getFlowId());
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

        try {
            WfFlowExample example = new WfFlowExample();
            example.createCriteria().andOwnerExperimentIdEqualTo(experimentId).andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
            List<WfFlow> resultList = wfFlowMapper.selectByExample(example);
            return DataUtil.isNotEmpty(resultList) ? resultList.get(0) : null;
        } catch (Throwable e) {
            throw new LambdaException("Query workflow info failed.", "查询工作流信息失败", e);
        }
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

        try {
            WfFlow workflow = wfFlowMapper.selectByPrimaryKey(workflowId);
            if(DataUtil.isNull(workflow) || (workflow.getStatus() == DataStatusEnum.INVALID.getStatus()))
                return null;

            return workflow;
        } catch (Throwable e) {
            throw new LambdaException("Query workflow info failed.", "查询工作流信息失败", e);
        }
    }

    /*
     *
     *   查询工作流信息
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

    /*
     *
     *   检查相工作流是否加锁
     *   返回是否存在
     *
     * */
    public boolean checkWorkflowLocked(Long id)  {
        if(DataUtil.isNull(id))
            throw new LambdaException("Check workflow locked failed -- invalid check condition.", "无效检查条件");

        try {
            WfFlowExample example = new WfFlowExample();
            example.createCriteria().andFlowIdEqualTo(id).andLockStateEqualTo(WorkflowLockStateEnum.LOCKED.getState())
                    .andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
            return wfFlowMapper.countByExample(example) > 0 ? true : false;
        } catch (Throwable e) {
            throw new LambdaException("Check workflow locked failed.", "检查工作流是否加锁失败", e);
        }
    }
}
