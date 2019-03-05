package com.yatop.lambda.core.mgr.workflow.node;

import com.yatop.lambda.base.model.WfFlowNodeOutput;
import com.yatop.lambda.base.model.WfFlowNodeOutputExample;
import com.yatop.lambda.core.enums.LambdaExceptionEnum;
import com.yatop.lambda.core.mgr.base.BaseMgr;
import com.yatop.lambda.core.enums.DataStatusEnum;
import com.yatop.lambda.core.exception.LambdaException;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.core.utils.SystemTimeUtil;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class NodeOutputMgr extends BaseMgr {

    /*
     *
     *   插入新节点输出（节点ID、特征ID、特征值 ...）
     *   返回插入记录
     *
     * */
    public WfFlowNodeOutput insertNodeOutput(WfFlowNodeOutput nodeOutput, String operId) {
        if( DataUtil.isNull(nodeOutput) ||
                nodeOutput.isNodeIdNotColoured() ||
                nodeOutput.isCharIdNotColoured() ||
                nodeOutput.isCharValueNotColoured() ||
                DataUtil.isEmpty(operId) ) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Insert node output failed -- invalid insert data.", "无效插入数据");
        }

        if(existsNodeOutput(nodeOutput.getNodeId(), nodeOutput.getCharId())) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Insert node output failed -- output characteristics conflict.", "输出特征冲突");
        }

        WfFlowNodeOutput insertNodeOutput = new WfFlowNodeOutput();
        try {
            Date dtCurrentTime = SystemTimeUtil.getCurrentTime();
            insertNodeOutput.copyProperties(nodeOutput);
            insertNodeOutput.setStatus(DataStatusEnum.NORMAL.getStatus());
            insertNodeOutput.setLastUpdateTime(dtCurrentTime);
            insertNodeOutput.setLastUpdateOper(operId);
            insertNodeOutput.setCreateTime(dtCurrentTime);
            insertNodeOutput.setCreateOper(operId);
            wfFlowNodeOutputMapper.insertSelective(insertNodeOutput);
            return insertNodeOutput;
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Insert node output failed.", "插入节点输出失败", e);
        }
    }

    /*
     *
     *   逻辑删除节点输出（按节点删除，删除实验是否需要删除运行信息待定）
     *   返回删除数量
     *
     * */
    public int deleteNodeOutput(Long nodeId, String operId) {
        if(DataUtil.isNull(nodeId) || DataUtil.isEmpty(operId)){
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Delete node output -- invalid delete condition.", "无效删除条件");
        }

        try {
            WfFlowNodeOutput deleteNodeOutput = new WfFlowNodeOutput();
            deleteNodeOutput.setStatus(DataStatusEnum.INVALID.getStatus());
            deleteNodeOutput.setLastUpdateTime(SystemTimeUtil.getCurrentTime());
            deleteNodeOutput.setLastUpdateOper(operId);
            WfFlowNodeOutputExample example = new WfFlowNodeOutputExample();
            example.createCriteria().andNodeIdEqualTo(nodeId).andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());;
            return wfFlowNodeOutputMapper.updateByExampleSelective(deleteNodeOutput, example);
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Delete node output failed.", "删除节点输出失败", e);
        }
    }

    /*
     *
     *   恢复节点输出（按节点恢复）
     *   返回恢复数量
     *
     * */
    public int recoverNodeOutput(Long nodeId, String operId) {
        if(DataUtil.isNull(nodeId) || DataUtil.isEmpty(operId)){
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Delete node output -- invalid delete condition.", "无效恢复条件");
        }

        try {
            WfFlowNodeOutput recoverNodeOutput = new WfFlowNodeOutput();
            recoverNodeOutput.setStatus(DataStatusEnum.NORMAL.getStatus());
            recoverNodeOutput.setLastUpdateTime(SystemTimeUtil.getCurrentTime());
            recoverNodeOutput.setLastUpdateOper(operId);
            WfFlowNodeOutputExample example = new WfFlowNodeOutputExample();
            example.createCriteria().andNodeIdEqualTo(nodeId).andStatusEqualTo(DataStatusEnum.INVALID.getStatus());;
            return wfFlowNodeOutputMapper.updateByExampleSelective(recoverNodeOutput, example);
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Delete node output failed.", "恢复节点输出失败", e);
        }
    }

    /*
     *
     *   更新节点输出（警告消息、描述）
     *   返回更新数量
     *
     * */
    public int updateNodeOutput(WfFlowNodeOutput nodeOutput, String operId) {
        if( DataUtil.isNull(nodeOutput)
                || nodeOutput.isNodeIdNotColoured()
                || nodeOutput.isCharIdNotColoured()
                || DataUtil.isEmpty(operId)) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Update node output failed -- invalid update condition.", "无效更新条件");
        }

        if( nodeOutput.isWarningMsgNotColoured() &&
                nodeOutput.isDescriptionNotColoured()) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Update node output failed -- invalid update data.", "无效更新内容");
        }

        WfFlowNodeOutput updateNodeOutput = new WfFlowNodeOutput();
        try {
            if(nodeOutput.isWarningMsgColoured())
                updateNodeOutput.setWarningMsg(nodeOutput.getWarningMsg());
            if(nodeOutput.isDescriptionColoured())
                updateNodeOutput.setDescription(nodeOutput.getDescription());
            updateNodeOutput.setLastUpdateTime(SystemTimeUtil.getCurrentTime());
            updateNodeOutput.setLastUpdateOper((operId));

            nodeOutput.setLastUpdateTime(updateNodeOutput.getLastUpdateTime());
            nodeOutput.setLastUpdateOper(updateNodeOutput.getLastUpdateOper());

            WfFlowNodeOutputExample example = new WfFlowNodeOutputExample();
            example.createCriteria().andNodeIdEqualTo(nodeOutput.getNodeId()).andCharIdEqualTo(nodeOutput.getCharId()).andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
            return wfFlowNodeOutputMapper.updateByExampleSelective(updateNodeOutput, example);
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Update node output failed.", "更新节点输出失败", e);
        }
    }

    /*
     *
     *   查询节点输出（按节点ID）
     *   返回结果
     *
     * */
    public List<WfFlowNodeOutput> queryNodeOutput(Long nodeId) {
        if(DataUtil.isNull(nodeId)){
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query node output failed -- invalid query condition.", "无效查询条件");
        }

        try {
            WfFlowNodeOutputExample example = new WfFlowNodeOutputExample();
            example.createCriteria().andNodeIdEqualTo(nodeId).andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
            example.setOrderByClause("CREATE_TIME ASC");
            return wfFlowNodeOutputMapper.selectByExample(example);
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query node output failed.", "查询节点输出失败", e);
        }
    }

    /*
     *
     *   查询节点输出（按节点ID + 特征ID）
     *   返回结果
     *
     * */
    public WfFlowNodeOutput queryNodeOutput(Long nodeId, String charId) {
        if(DataUtil.isNull(nodeId) || DataUtil.isEmpty(charId)){
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query node output failed -- invalid query condition.", "无效查询条件");
        }

        try {
            WfFlowNodeOutputExample example = new WfFlowNodeOutputExample();
            example.createCriteria().andNodeIdEqualTo(nodeId).andCharIdEqualTo(charId).andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
            List<WfFlowNodeOutput> resultList = wfFlowNodeOutputMapper.selectByExample(example);
            return DataUtil.isNotEmpty(resultList) ? resultList.get(0) : null;
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query node output failed.", "查询节点输出失败", e);
        }
    }

    /*
     *
     *   是否已存在节点输出
     *   返回结果集
     *
     * */
    public boolean existsNodeOutput(Long nodeId, String charId) {
        if(DataUtil.isNull(nodeId) || DataUtil.isEmpty(charId)){
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Check node output exists failed -- invalid check condition.", "无效检查条件");
        }

        try {
            WfFlowNodeOutputExample example = new WfFlowNodeOutputExample();
            example.createCriteria().andNodeIdEqualTo(nodeId).andCharIdEqualTo(charId).andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
            return wfFlowNodeOutputMapper.countByExample(example) > 0 ? true : false;
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Check node output exists failed.", "检查节点输出是否已存在失败", e);
        }
    }
}
