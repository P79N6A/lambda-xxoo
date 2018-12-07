package com.yatop.lambda.core.mgr.workflow;

import com.yatop.lambda.base.model.WfCodeScript;
import com.yatop.lambda.base.model.WfCodeScriptExample;
import com.yatop.lambda.core.enums.CodeScriptStateEnum;
import com.yatop.lambda.core.enums.CodeScriptTypeEnum;
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
public class CodeScriptMgr extends BaseMgr {
    
    /*
     *
     *   插入新代码脚本（名称、所属项目ID、所属实验ID、工作流状态）
     *   返回插入记录
     *
     * */
    public WfCodeScript insertCodeScript(WfCodeScript codeScript, String operId) {
        if( DataUtil.isNull(codeScript) ||
                codeScript.isScriptNameNotColoured() ||
                codeScript.isScriptTypeNotColoured() ||
                codeScript.isOwnerProjectIdNotColoured() ||
                codeScript.isRelExperimentIdNotColoured() ||
                codeScript.isRelFlowIdNotColoured() ||
                codeScript.isRelSnapshotVersionNotColoured() ||
                codeScript.isRelJobIdNotColoured() ||
                codeScript.isRelNodeIdNotColoured() ||
                codeScript.isRelCharIdNotColoured() ||
                codeScript.isScriptStateNotColoured() ||
                DataUtil.isEmpty(operId) ) {
            throw new LambdaException("Insert code script failed -- invalid insert data.", "无效插入数据");
        }

        WfCodeScript insertCodeScript = new WfCodeScript();
        try {
            Date dtCurrentTime = SystemTimeUtil.getCurrentTime();
            BeanUtils.copyProperties(codeScript, insertCodeScript);
            insertCodeScript.setScriptIdColoured(false);
            insertCodeScript.setStatus(DataStatusEnum.NORMAL.getStatus());
            insertCodeScript.setLastUpdateTime(dtCurrentTime);
            insertCodeScript.setLastUpdateOper(operId);
            insertCodeScript.setCreateTime(dtCurrentTime);
            insertCodeScript.setCreateOper(operId);
            wfCodeScriptMapper.insertSelective(insertCodeScript);
            return insertCodeScript;
        } catch (Throwable e) {
            throw new LambdaException("Insert code script failed.", "插入代码脚本失败", e);
        }
    }

    /*
     *
     *   逻辑删除代码脚本
     *   返回删除数量
     *
     * */
    public int deleteCodeScript(WfCodeScript codeScript, String operId) {
        if(DataUtil.isNull(codeScript) || codeScript.isScriptIdNotColoured() || DataUtil.isEmpty(operId)){
            throw new LambdaException("Delete code script -- invalid query condition.", "无效删除条件");
        }

        try {
            WfCodeScript deleteCodeScript = new WfCodeScript();
            deleteCodeScript.setStatus(DataStatusEnum.INVALID.getStatus());
            deleteCodeScript.setLastUpdateTime(SystemTimeUtil.getCurrentTime());
            deleteCodeScript.setLastUpdateOper(operId);
            WfCodeScriptExample example = new WfCodeScriptExample();
            example.createCriteria().andScriptIdEqualTo(codeScript.getScriptId()).andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
            return wfCodeScriptMapper.updateByExampleSelective(deleteCodeScript, example);
        } catch (Throwable e) {
            throw new LambdaException("Delete code script failed.", "删除代码脚本失败", e);
        }
    }

    /*
     *
     *   更新代码脚本（名称、脚本内容、脚本状态、描述）
     *   返回更新数量
     *
     * */
    public int updateCodeScript(WfCodeScript codeScript, String operId) {
        if( DataUtil.isNull(codeScript) || codeScript.isScriptIdNotColoured() || DataUtil.isEmpty(operId)) {
            throw new LambdaException("Update code script failed -- invalid update condition.", "无效更新条件");
        }

        if(codeScript.isScriptNameNotColoured() &&
                codeScript.isScriptContentNotColoured() &&
                codeScript.isScriptStateNotColoured() &&
                codeScript.isDescriptionNotColoured()) {
            throw new LambdaException("Update code script failed -- invalid update data.", "无效更新内容");
        }

        WfCodeScript updateCodeScript = new WfCodeScript();
        try {
            updateCodeScript.setScriptId(codeScript.getScriptId());
            if(codeScript.isScriptNameColoured())
                updateCodeScript.setScriptName(codeScript.getScriptName());
            if(codeScript.isScriptContentColoured())
                updateCodeScript.setScriptContent(codeScript.getScriptName());
            if(codeScript.isScriptStateColoured())
                updateCodeScript.setScriptState(codeScript.getScriptState());
            if(codeScript.isDescriptionColoured())
                updateCodeScript.setDescription(codeScript.getDescription());

            updateCodeScript.setLastUpdateTime(SystemTimeUtil.getCurrentTime());
            updateCodeScript.setLastUpdateOper((operId));
            return wfCodeScriptMapper.updateByPrimaryKeySelective(updateCodeScript);
        } catch (Throwable e) {
            throw new LambdaException("Update code script failed.", "更新代码脚本失败", e);
        }
    }

    /*
     *
     *   查询代码脚本（按ID）
     *   返回结果
     *
     * */
    public WfCodeScript queryCodeScript(Long codeScriptId) {
        if(DataUtil.isNull(codeScriptId)){
            throw new LambdaException("Query code script failed -- invalid query condition.", "无效查询条件");
        }

        WfCodeScript codeScript;
        try {
            codeScript = wfCodeScriptMapper.selectByPrimaryKey(codeScriptId);
        } catch (Throwable e) {
            throw new LambdaException("Query code script failed.", "查询代码脚本失败", e);
        }

        if(DataUtil.isNull(codeScript) || (codeScript.getStatus() == DataStatusEnum.INVALID.getStatus()))
            throw new LambdaException("Query code script failed -- invalid status or not found.", "已删除或未查找到");

        return codeScript;
    }

    /*
     *
     *   查询代码脚本（项目ID + [脚本类型]）
     *   返回结果集
     *
     * */
    public List<WfCodeScript> queryCodeScript(Long projectId, CodeScriptTypeEnum typeEnum, PagerUtil pager) {
        if(DataUtil.isNull(projectId)){
            throw new LambdaException("Query code script failed -- invalid query condition.", "无效查询条件");
        }

        try {
            PagerUtil.startPage(pager);
            WfCodeScriptExample example = new WfCodeScriptExample();
            WfCodeScriptExample.Criteria cond = example.createCriteria().andOwnerProjectIdEqualTo(projectId);

            if(DataUtil.isNotNull(typeEnum))
                cond.andScriptTypeEqualTo(typeEnum.getType());

            cond.andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
            example.setOrderByClause("CREATE_TIME ASC");
            return wfCodeScriptMapper.selectByExample(example);
        } catch (Throwable e) {
            PagerUtil.clearPage(pager);
            throw new LambdaException("Query code script failed.", "查询代码脚本失败", e);
        }
    }
}
