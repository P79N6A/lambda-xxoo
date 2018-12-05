package com.yatop.lambda.core.mgr.workflow;

import com.yatop.lambda.base.mapper.extend.WorkflowMapper;
import com.yatop.lambda.base.model.WfFlow;
import com.yatop.lambda.base.model.WfFlowExample;
import com.yatop.lambda.core.enums.DataStatusEnum;
import com.yatop.lambda.core.enums.WorkflowLockStateEnum;
import com.yatop.lambda.core.enums.WorkflowStateEnum;
import com.yatop.lambda.core.exception.LambdaException;
import com.yatop.lambda.core.mgr.base.BaseMgr;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.core.utils.PagerUtil;
import com.yatop.lambda.core.utils.SystemTimeUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
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
        if(DataUtil.isNull(workflow) || DataUtil.isNull(workflow.getFlowId()) || DataUtil.isEmpty(operId)){
            throw new LambdaException("Delete workflow info -- invalid query condition.", "无效删除条件");
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
     *   更新工作流信息（快照信息）
     *   返回更新数量
     *
     * */
    public int updateWorkflowSnapshot(WfFlow workflow, String operId) {
        if( DataUtil.isNull(workflow) || !workflow.isFlowIdColoured() || DataUtil.isEmpty(operId)) {
            throw new LambdaException("Update workflow info failed -- invalid update condition.", "无效更新条件");
        }

        if(!workflow.isLastSnapshotIdColoured()) {
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
        if( DataUtil.isNull(workflow) || !workflow.isFlowIdColoured() || DataUtil.isEmpty(operId)) {
            throw new LambdaException("Update workflow info failed -- invalid update condition.", "无效更新条件");
        }

        if(!workflow.isLastJobIdColoured()) {
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
     *   更新工作流信息（运行加解锁）
     *   返回更新数量
     *
     * */
    private int updateWorkflowLockExt(WfFlow workflow, String operId, WorkflowLockStateEnum lockStateEnum) {
        if(DataUtil.isNull(workflow) || DataUtil.isNull(workflow.getFlowId()) || DataUtil.isEmpty(operId)){
            throw new LambdaException("Lock workflow -- invalid query condition.", "无效加解锁条件");
        }

        try {
            WfFlow lockWorkflow = new WfFlow();
            lockWorkflow.setFlowId(workflow.getFlowId());
            lockWorkflow.setLockState(lockStateEnum.getState());
            if(lockWorkflow.isLockMsgColoured())
                lockWorkflow.setLockMsg(workflow.getLockMsg());
            lockWorkflow.setLastUpdateTime(SystemTimeUtil.getCurrentTime());
            lockWorkflow.setLastUpdateOper(operId);
            return wfFlowMapper.updateByPrimaryKeySelective(lockWorkflow);
        } catch (Throwable e) {
            throw new LambdaException("Lock workflow with version failed.", "加解锁工作流失败", e);
        }
    }

    /*
     *
     *   更新工作流信息（运行加锁）
     *   返回更新数量
     *
     * */
    public int updateWorkflowLock(WfFlow workflow, String operId) {
        return updateWorkflowLockExt(workflow, operId, WorkflowLockStateEnum.LOCKED);
    }

    /*
     *
     *   更新工作流信息（运行解锁）
     *   返回更新数量
     *
     * */
    public int updateWorkflowUnlock(WfFlow workflow, String operId) {
        return updateWorkflowLockExt(workflow, operId, WorkflowLockStateEnum.UNLOCKED);
    }

    /*
     *
     *   更新工作流版本号
     *   返回记录
     *
     * */
    private WfFlow updateWorkflowVersion(WfFlow workflow, String operId) {
        if(DataUtil.isNull(workflow) || DataUtil.isNull(workflow.getFlowId()) || DataUtil.isEmpty(operId)){
            throw new LambdaException("Lock workflow -- invalid query condition.", "无效加解锁条件");
        }

        try {
            workflowMapper.updateWorkflowVersion(workflow.getFlowId(), SystemTimeUtil.getCurrentTime(), operId);
        } catch (Throwable e) {
            throw new LambdaException("Lock workflow with version failed.", "加解锁工作流失败", e);
        }

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
}
