package com.yatop.lambda.core.mgr.workflow.execution;

import com.yatop.lambda.base.model.WfExecutionJob;
import com.yatop.lambda.base.model.WfExecutionTask;
import com.yatop.lambda.base.model.WfExecutionTaskExample;
import com.yatop.lambda.core.enums.LambdaExceptionEnum;
import com.yatop.lambda.core.mgr.base.BaseMgr;
import com.yatop.lambda.core.enums.DataStatusEnum;
import com.yatop.lambda.core.enums.TaskStateEnum;
import com.yatop.lambda.core.exception.LambdaException;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.core.utils.PagerUtil;
import com.yatop.lambda.core.utils.SystemTimeUtil;
import com.yatop.lambda.core.utils.WorkDirectoryUtil;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ExecutionTaskMgr extends BaseMgr {

    /*
     *
     *   插入新任务信息（名称、所属项目ID、所属作业ID、任务序号、关联节点ID ...）
     *   返回插入记录
     *
     * */
    public WfExecutionTask insertTask(WfExecutionTask task, String operId) {
        if( DataUtil.isNull(task) ||
                task.isTaskNameNotColoured() ||
                task.isOwnerProjectIdNotColoured() ||
                task.isOwnerJobIdNotColoured() ||
                task.isSequenceNotColoured() ||
                task.isRelNodeIdNotColoured() ||
                DataUtil.isEmpty(operId) ) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Insert task info failed -- invalid insert data.", "无效插入数据");
        }

        WfExecutionTask insertTask = new WfExecutionTask();
        try {
            Date dtCurrentTime = SystemTimeUtil.getCurrentTime();
            insertTask.copyProperties(task);
            if(insertTask.isSubmitFileColoured())
                insertTask.setSubmitFile(WorkDirectoryUtil.removeDfsSchemaPrefix(insertTask.getSubmitFile()));
            if(insertTask.isReturnFileColoured())
                insertTask.setReturnFile(WorkDirectoryUtil.removeDfsSchemaPrefix(insertTask.getReturnFile()));
            if(insertTask.isLogFileColoured())
                insertTask.setLogFile(WorkDirectoryUtil.removeDfsSchemaPrefix(insertTask.getLogFile()));
            insertTask.setTaskIdColoured(false);
            insertTask.setEngineTypeColoured(false);
            insertTask.setExternalIdColoured(false);
            insertTask.setTaskContentColoured(false);
            insertTask.setSubmitFileColoured(false);
            insertTask.setReturnFileColoured(false);
            insertTask.setLogFileColoured(false);
            insertTask.setCostTimeColoured(false);
            insertTask.setTaskStartTimeColoured(false);
            insertTask.setTaskEndTimeColoured(false);
            insertTask.setTaskProgress(0);
            insertTask.setWarningMsgColoured(false);
            insertTask.setTaskState(TaskStateEnum.PREPARING.getState());
            insertTask.setStatus(DataStatusEnum.NORMAL.getStatus());
            insertTask.setLastUpdateTime(dtCurrentTime);
            insertTask.setLastUpdateOper(operId);
            insertTask.setCreateTime(dtCurrentTime);
            insertTask.setCreateOper(operId);
            wfExecutionTaskMapper.insertSelective(insertTask);
            if(insertTask.isSubmitFileColoured())
                insertTask.setSubmitFile(WorkDirectoryUtil.addDfsSchemaPrefix(insertTask.getSubmitFile()));
            if(insertTask.isReturnFileColoured())
                insertTask.setReturnFile(WorkDirectoryUtil.addDfsSchemaPrefix(insertTask.getReturnFile()));
            if(insertTask.isLogFileColoured())
                insertTask.setLogFile(WorkDirectoryUtil.addDfsSchemaPrefix(insertTask.getLogFile()));
            return insertTask;
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Insert task info failed.", "插入任务信息失败", e);
        }
    }

    /*
     *
     *   逻辑删除任务信息（按作业，删除实验是否需要删除运行信息待定）
     *   返回删除数量
     *
     * */
    public int deleteTask(Long jobId, String operId) {
        if(DataUtil.isNull(jobId) || DataUtil.isEmpty(operId)){
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Delete task info -- invalid delete condition.", "无效删除条件");
        }

        try {
            WfExecutionTask deleteTask = new WfExecutionTask();
            deleteTask.setStatus(DataStatusEnum.INVALID.getStatus());
            deleteTask.setLastUpdateTime(SystemTimeUtil.getCurrentTime());
            deleteTask.setLastUpdateOper(operId);
            WfExecutionTaskExample example = new WfExecutionTaskExample();
            example.createCriteria().andOwnerJobIdEqualTo(jobId);
            return wfExecutionTaskMapper.updateByExampleSelective(deleteTask, example);
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Delete task info failed.", "删除任务信息失败", e);
        }
    }

    /*
     *
     *   更新任务信息（计算引擎、外部任务ID、任务内容、提交文件、返回文件、日志文件、运行耗时、开始时间、结束时间、任务进度、警告消息、任务状态、描述）
     *   返回更新数量
     *
     * */
    public int updateTask(WfExecutionTask task, String operId) {
        if( DataUtil.isNull(task) || task.isTaskIdNotColoured() || DataUtil.isEmpty(operId)) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Update task info failed -- invalid update condition.", "无效更新条件");
        }

        if(task.isEngineTypeNotColoured() &&
                task.isExternalIdNotColoured() &&
                task.isTaskContentNotColoured() &&
                task.isSubmitFileNotColoured() &&
                task.isReturnFileNotColoured() &&
                task.isLogFileNotColoured() &&
                task.isCostTimeNotColoured() &&
                task.isTaskStartTimeNotColoured() &&
                task.isTaskEndTimeNotColoured() &&
                task.isTaskProgressNotColoured() &&
                task.isWarningMsgNotColoured() &&
                task.isTaskStateNotColoured() &&
                task.isDescriptionNotColoured()) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Update task info failed -- invalid update data.", "无效更新内容");
        }

        WfExecutionTask updateTask = new WfExecutionTask();
        try {
            updateTask.setTaskId(task.getTaskId());
            if(task.isExternalIdColoured())
                updateTask.setExternalId(task.getExternalId());
            if(task.isExternalIdColoured())
                updateTask.setExternalId(task.getExternalId());
            if(task.isSubmitFileColoured())
                updateTask.setSubmitFile(WorkDirectoryUtil.removeDfsSchemaPrefix(task.getSubmitFile()));
            if(task.isReturnFileColoured())
                updateTask.setReturnFile(WorkDirectoryUtil.removeDfsSchemaPrefix(task.getReturnFile()));
            if(task.isLogFileColoured())
                updateTask.setLogFile(WorkDirectoryUtil.removeDfsSchemaPrefix(task.getLogFile()));
            if(task.isCostTimeColoured())
                updateTask.setCostTime(task.getCostTime());
            if(task.isTaskStartTimeColoured())
                updateTask.setTaskStartTime(task.getTaskStartTime());
            if(task.isTaskEndTimeColoured())
                updateTask.setTaskEndTime(task.getTaskEndTime());
            if(task.isTaskProgressColoured())
                updateTask.setTaskProgress(task.getTaskProgress());
            if(task.isWarningMsgColoured())
                updateTask.setWarningMsg(task.getWarningMsg());
            if(task.isTaskStateColoured())
                updateTask.setTaskState(task.getTaskState());
            if(task.isDescriptionColoured())
                updateTask.setDescription(task.getDescription());

            updateTask.setLastUpdateTime(SystemTimeUtil.getCurrentTime());
            updateTask.setLastUpdateOper((operId));

            task.setLastUpdateTime(updateTask.getLastUpdateTime());
            task.setLastUpdateOper(updateTask.getLastUpdateOper());
            return wfExecutionTaskMapper.updateByPrimaryKeySelective(updateTask);
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Update task info failed.", "更新任务信息失败", e);
        }
    }

    /*
     *
     *   查询任务信息（按ID）
     *   返回结果
     *
     * */
    public WfExecutionTask queryTask(Long taskId) {
        if(DataUtil.isNull(taskId)){
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query task info failed -- invalid query condition.", "无效查询条件");
        }

        WfExecutionTask task;
        try {
            task = wfExecutionTaskMapper.selectByPrimaryKey(taskId);
            task.setSubmitFile(WorkDirectoryUtil.addDfsSchemaPrefix(task.getSubmitFile()));
            task.setReturnFile(WorkDirectoryUtil.addDfsSchemaPrefix(task.getReturnFile()));
            task.setLogFile(WorkDirectoryUtil.addDfsSchemaPrefix(task.getLogFile()));
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query task info failed.", "查询任务信息失败", e);
        }

        if(DataUtil.isNull(task) || (task.getStatus() == DataStatusEnum.INVALID.getStatus()))
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query task info failed -- invalid status or not found.", "任务信息不存在");

        return task;
    }

    /*
     *
     *   查询任务信息（按作业ID + 节点ID）
     *   返回结果集
     *
     * */
    public List<WfExecutionTask> queryTask(Long jobId, Long nodeId) {
        if(DataUtil.isNull(jobId) || DataUtil.isNull(nodeId)){
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query task info failed -- invalid query condition.", "无效查询条件");
        }

        try {
            WfExecutionTaskExample example = new WfExecutionTaskExample();
            example.createCriteria().andOwnerJobIdEqualTo(jobId).andRelNodeIdEqualTo(nodeId).andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
            example.setOrderByClause("CREATE_TIME ASC");
            List<WfExecutionTask> resultList = wfExecutionTaskMapper.selectByExample(example);

            if(DataUtil.isNotEmpty(resultList)) {
                for (WfExecutionTask task : resultList) {
                    task.setSubmitFile(WorkDirectoryUtil.addDfsSchemaPrefix(task.getSubmitFile()));
                    task.setReturnFile(WorkDirectoryUtil.addDfsSchemaPrefix(task.getReturnFile()));
                    task.setLogFile(WorkDirectoryUtil.addDfsSchemaPrefix(task.getLogFile()));
                }
            }
            return resultList;
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query task info failed.", "查询任务信息失败", e);
        }
    }

    /*
     *
     *   查询任务信息（按作业ID + [任务状态]）
     *   返回结果集
     *
     * */
    public List<WfExecutionTask> queryTaskByJobId(Long jobId, TaskStateEnum stateEnum, PagerUtil pager) {
        if(DataUtil.isNull(jobId)){
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query task info failed -- invalid query condition.", "无效查询条件");
        }

        try {
            PagerUtil.startPage(pager);
            WfExecutionTaskExample example = new WfExecutionTaskExample();
            WfExecutionTaskExample.Criteria cond = example.createCriteria().andOwnerJobIdEqualTo(jobId);
            if(DataUtil.isNotNull(stateEnum)) {
                cond.andTaskStateEqualTo(stateEnum.getState());
            }
            cond.andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
            example.setOrderByClause("CREATE_TIME ASC");
            List<WfExecutionTask> resultList = wfExecutionTaskMapper.selectByExample(example);

            if(DataUtil.isNotEmpty(resultList)) {
                for (WfExecutionTask task : resultList) {
                    task.setSubmitFile(WorkDirectoryUtil.addDfsSchemaPrefix(task.getSubmitFile()));
                    task.setReturnFile(WorkDirectoryUtil.addDfsSchemaPrefix(task.getReturnFile()));
                    task.setLogFile(WorkDirectoryUtil.addDfsSchemaPrefix(task.getLogFile()));
                }
            }
            return resultList;
        } catch (Throwable e) {
            PagerUtil.clearPage(pager);
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query task info failed.", "查询任务信息失败", e);
        }
    }

    /*
     *
     *   查询任务信息（按项目ID + [任务状态]）
     *   返回结果集
     *
     * */
    public List<WfExecutionTask> queryTaskByProjectId(Long projectId, TaskStateEnum stateEnum, PagerUtil pager) {
        if(DataUtil.isNull(projectId)){
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query task info failed -- invalid query condition.", "无效查询条件");
        }

        try {
            PagerUtil.startPage(pager);
            WfExecutionTaskExample example = new WfExecutionTaskExample();
            WfExecutionTaskExample.Criteria cond = example.createCriteria().andOwnerProjectIdEqualTo(projectId);
            if(DataUtil.isNotNull(stateEnum)) {
                cond.andTaskStateEqualTo(stateEnum.getState());
            }
            cond.andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
            example.setOrderByClause("CREATE_TIME ASC");
            List<WfExecutionTask> resultList = wfExecutionTaskMapper.selectByExample(example);

            if(DataUtil.isNotEmpty(resultList)) {
                for (WfExecutionTask task : resultList) {
                    task.setSubmitFile(WorkDirectoryUtil.addDfsSchemaPrefix(task.getSubmitFile()));
                    task.setReturnFile(WorkDirectoryUtil.addDfsSchemaPrefix(task.getReturnFile()));
                    task.setLogFile(WorkDirectoryUtil.addDfsSchemaPrefix(task.getLogFile()));
                }
            }
            return resultList;
        } catch (Throwable e) {
            PagerUtil.clearPage(pager);
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query task info failed.", "查询任务信息失败", e);
        }
    }
}
