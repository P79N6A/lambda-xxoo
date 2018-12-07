package com.yatop.lambda.core.mgr.workflow;

import com.yatop.lambda.base.model.WfFlowGlobalParameter;
import com.yatop.lambda.base.model.WfFlowGlobalParameterExample;
import com.yatop.lambda.core.enums.DataStatusEnum;
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
public class GlobalParameterMgr extends BaseMgr {

    /*
     *
     *   插入新全局变量（名称、所属项目ID、所属实验ID、快照状态）
     *   返回插入记录
     *
     * */
    public WfFlowGlobalParameter insertGlobalParameter(WfFlowGlobalParameter globalParameter, String operId) {
        if( DataUtil.isNull(globalParameter) ||
                globalParameter.isGlobalParamNameNotColoured() ||
                globalParameter.isRelFlowIdNotColoured() ||
                globalParameter.isRelNodeIdNotColoured() ||
                globalParameter.isRelCharIdNotColoured() ||
                globalParameter.isDefaultValueNotColoured() ||
                DataUtil.isEmpty(operId) ) {
            throw new LambdaException("Insert global parameter failed -- invalid insert data.", "无效插入数据");
        }

        WfFlowGlobalParameter insertGlobalParameter = new WfFlowGlobalParameter();
        try {
            Date dtCurrentTime = SystemTimeUtil.getCurrentTime();
            BeanUtils.copyProperties(globalParameter, insertGlobalParameter);
            insertGlobalParameter.setGlobalParamIdColoured(false);
            insertGlobalParameter.setStatus(DataStatusEnum.NORMAL.getStatus());
            insertGlobalParameter.setLastUpdateTime(dtCurrentTime);
            insertGlobalParameter.setLastUpdateOper(operId);
            insertGlobalParameter.setCreateTime(dtCurrentTime);
            insertGlobalParameter.setCreateOper(operId);
            wfFlowGlobalParameterMapper.insertSelective(insertGlobalParameter);
            return insertGlobalParameter;
        } catch (Throwable e) {
            throw new LambdaException("Insert global parameter failed.", "插入全局变量失败", e);
        }
    }

    /*
     *
     *   逻辑删除全局变量
     *   返回删除数量
     *
     * */
    public int deleteGlobalParameter(WfFlowGlobalParameter globalParameter, String operId) {
        if(DataUtil.isNull(globalParameter) || globalParameter.isGlobalParamIdNotColoured() || DataUtil.isEmpty(operId)){
            throw new LambdaException("Delete global parameter -- invalid query condition.", "无效删除条件");
        }

        try {
            WfFlowGlobalParameter deleteGlobalParameter = new WfFlowGlobalParameter();
            deleteGlobalParameter.setStatus(DataStatusEnum.INVALID.getStatus());
            deleteGlobalParameter.setLastUpdateTime(SystemTimeUtil.getCurrentTime());
            deleteGlobalParameter.setLastUpdateOper(operId);
            WfFlowGlobalParameterExample example = new WfFlowGlobalParameterExample();
            example.createCriteria().andGlobalParamIdEqualTo(globalParameter.getGlobalParamId()).andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
            return wfFlowGlobalParameterMapper.updateByExampleSelective(deleteGlobalParameter, example);
        } catch (Throwable e) {
            throw new LambdaException("Delete global parameter failed.", "删除全局变量失败", e);
        }
    }

    /*
     *
     *   更新全局变量（名称、默认值、警告消息、描述）
     *   返回更新数量
     *
     * */
    public int updateGlobalParameter(WfFlowGlobalParameter globalParameter, String operId) {
        if( DataUtil.isNull(globalParameter) || globalParameter.isGlobalParamIdNotColoured() || DataUtil.isEmpty(operId)) {
            throw new LambdaException("Update global parameter failed -- invalid update condition.", "无效更新条件");
        }

        if(globalParameter.isGlobalParamNameNotColoured() &&
                globalParameter.isDefaultValueNotColoured() &&
                globalParameter.isWarningMsgNotColoured() &&
                globalParameter.isDescriptionNotColoured()) {
            throw new LambdaException("Update global parameter failed -- invalid update data.", "无效更新内容");
        }

        WfFlowGlobalParameter updateGlobalParameter = new WfFlowGlobalParameter();
        try {
            updateGlobalParameter.setGlobalParamId(globalParameter.getGlobalParamId());
            if(globalParameter.isGlobalParamNameColoured())
                updateGlobalParameter.setGlobalParamName(globalParameter.getGlobalParamName());
            if(globalParameter.isDefaultValueColoured())
                updateGlobalParameter.setDefaultValue(globalParameter.getDefaultValue());
            if(globalParameter.isWarningMsgColoured())
                updateGlobalParameter.setWarningMsg(globalParameter.getWarningMsg());
            if(globalParameter.isDescriptionColoured())
                updateGlobalParameter.setDescription(globalParameter.getDescription());

            updateGlobalParameter.setLastUpdateTime(SystemTimeUtil.getCurrentTime());
            updateGlobalParameter.setLastUpdateOper((operId));
            return wfFlowGlobalParameterMapper.updateByPrimaryKeySelective(updateGlobalParameter);
        } catch (Throwable e) {
            throw new LambdaException("Update global parameter failed.", "更新全局变量失败", e);
        }
    }

    /*
     *
     *   查询全局变量（按ID）
     *   返回结果
     *
     * */
    public WfFlowGlobalParameter queryGlobalParameter(Long globalParameterId) {
        if(DataUtil.isNull(globalParameterId)){
            throw new LambdaException("Query global parameter failed -- invalid query condition.", "无效查询条件");
        }

        WfFlowGlobalParameter globalParameter;
        try {
            globalParameter = wfFlowGlobalParameterMapper.selectByPrimaryKey(globalParameterId);
        } catch (Throwable e) {
            throw new LambdaException("Query global parameter failed.", "查询全局变量失败", e);
        }

        if(DataUtil.isNull(globalParameter) || (globalParameter.getStatus() == DataStatusEnum.INVALID.getStatus()))
            throw new LambdaException("Query global parameter failed -- invalid status or not found.", "已删除或未查找到");

        return globalParameter;
    }

    /*
     *
     *   查询全局变量（按工作流ID）
     *   返回结果集
     *
     * */
    public List<WfFlowGlobalParameter> queryGlobalParameter(Long flowId, PagerUtil pager) {
        if(DataUtil.isNull(flowId)){
            throw new LambdaException("Query global parameter failed -- invalid query condition.", "无效查询条件");
        }

        try {
            PagerUtil.startPage(pager);
            WfFlowGlobalParameterExample example = new WfFlowGlobalParameterExample();
            example.createCriteria().andRelFlowIdEqualTo(flowId).andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
            example.setOrderByClause("CREATE_TIME ASC");
            return wfFlowGlobalParameterMapper.selectByExample(example);
        } catch (Throwable e) {
            PagerUtil.clearPage(pager);
            throw new LambdaException("Query global parameter failed.", "查询全局变量失败", e);
        }
    }

}