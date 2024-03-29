package com.yatop.lambda.core.mgr.workflow.node;

import com.yatop.lambda.base.model.WfFlowNodeLink;
import com.yatop.lambda.base.model.WfFlowNodeLinkExample;
import com.yatop.lambda.core.enums.LambdaExceptionEnum;
import com.yatop.lambda.core.mgr.base.BaseMgr;
import com.yatop.lambda.core.enums.DataStatusEnum;
import com.yatop.lambda.core.exception.LambdaException;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.core.utils.PagerUtil;
import com.yatop.lambda.core.utils.SystemTimeUtil;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class NodeLinkMgr extends BaseMgr {

    /*
     *
     *   插入新节点链接（名称、所属工作流ID、是否为web组件流出链接、流出节点端口ID、流入节点端口ID ...）
     *   返回插入记录
     *
     * */
    public WfFlowNodeLink insertLink(WfFlowNodeLink link, String operId) {
        if( DataUtil.isNull(link) ||
                link.isLinkNameNotColoured() ||
                link.isOwnerFlowIdNotColoured() ||
                link.isSrcNodeIdNotColoured() ||
                link.isSrcPortIdNotColoured() ||
                link.isDstNodeIdNotColoured() ||
                link.isDstPortIdNotColoured() ||
                DataUtil.isEmpty(operId) ) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Insert node link failed -- invalid insert data.", "无效插入数据");
        }

        WfFlowNodeLink insertLink = new WfFlowNodeLink();
        try {
            Date dtCurrentTime = SystemTimeUtil.getCurrentTime();
            insertLink.copyProperties(link);
            insertLink.setLinkIdColoured(false);
            insertLink.setStatus(DataStatusEnum.NORMAL.getStatus());
            insertLink.setLastUpdateTime(dtCurrentTime);
            insertLink.setLastUpdateOper(operId);
            insertLink.setCreateTime(dtCurrentTime);
            insertLink.setCreateOper(operId);
            wfFlowNodeLinkMapper.insertSelective(insertLink);
            return insertLink;
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Insert node link failed.", "插入节点链接失败", e);
        }
    }

    /*
     *
     *   逻辑删除节点链接（是否考虑物理删除）
     *   返回删除数量
     *
     * */
    public int deleteLink(Long linkId, String operId) {
        if(DataUtil.isNull(linkId) || DataUtil.isEmpty(operId)){
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Delete node link -- invalid delete condition.", "无效删除条件");
        }

        try {
            WfFlowNodeLink deleteLink = new WfFlowNodeLink();
            deleteLink.setLinkId(linkId);
            deleteLink.setStatus(DataStatusEnum.INVALID.getStatus());
            deleteLink.setLastUpdateTime(SystemTimeUtil.getCurrentTime());
            deleteLink.setLastUpdateOper(operId);
            return wfFlowNodeLinkMapper.updateByPrimaryKeySelective(deleteLink);
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Delete node link failed.", "删除节点链接失败", e);
        }
    }

    /*
     *
     *   逻辑删除节点链接（是否考虑物理删除）
     *   返回删除数量
     *
     * */
    public int deleteLinkByWorkflowId(Long workflowId, String operId) {
        if(DataUtil.isNull(workflowId) || DataUtil.isEmpty(operId)){
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Delete node link -- invalid delete condition.", "无效删除条件");
        }

        try {
            WfFlowNodeLink deleteLink = new WfFlowNodeLink();
            deleteLink.setStatus(DataStatusEnum.INVALID.getStatus());
            deleteLink.setLastUpdateTime(SystemTimeUtil.getCurrentTime());
            deleteLink.setLastUpdateOper(operId);
            WfFlowNodeLinkExample example = new WfFlowNodeLinkExample();
            example.createCriteria().andOwnerFlowIdEqualTo(workflowId).andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
            return wfFlowNodeLinkMapper.updateByExampleSelective(deleteLink, example);
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Delete node link failed.", "删除节点链接失败", e);
        }
    }

    /*
     *
     *   查询节点链接（按ID）
     *   返回结果
     *
     * */
    public WfFlowNodeLink queryLink(Long id) {
        if(DataUtil.isNull(id)){
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query node link failed -- invalid query condition.", "无效查询条件");
        }

        WfFlowNodeLink link;
        try {
            link = wfFlowNodeLinkMapper.selectByPrimaryKey(id);
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query node link failed.", "查询节点链接失败", e);
        }

        if(DataUtil.isNull(link) || (link.getStatus() == DataStatusEnum.INVALID.getStatus()))
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query node link failed -- invalid status or not found.", "节点链接不存在");

        return link;
    }

    /*
     *
     *   查询节点链接（按工作流ID）
     *   返回结果集
     *
     * */
    public List<WfFlowNodeLink> queryLink(Long flowId, PagerUtil pager) {
        if(DataUtil.isNull(flowId)){
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query node link failed -- invalid query condition.", "无效查询条件");
        }

        try {
            PagerUtil.startPage(pager);
            WfFlowNodeLinkExample example = new WfFlowNodeLinkExample();
            example.createCriteria().andOwnerFlowIdEqualTo(flowId).andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
            example.setOrderByClause("CREATE_TIME ASC");
            return wfFlowNodeLinkMapper.selectByExample(example);
        } catch (Throwable e) {
            PagerUtil.clearPage(pager);
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query node link failed.", "查询节点链接失败", e);
        }
    }

    /*
     *
     *   查询节点链接（按输出节点ID）
     *   返回结果集
     *
     * */
    public List<WfFlowNodeLink> queryLinkBySrcNodeId(Long srcNodeId) {
        if(DataUtil.isNull(srcNodeId)){
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query node link failed -- invalid query condition.", "无效查询条件");
        }

        try {
            WfFlowNodeLinkExample example = new WfFlowNodeLinkExample();
            example.createCriteria().andSrcNodeIdEqualTo(srcNodeId).andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
            example.setOrderByClause("CREATE_TIME ASC");
            return wfFlowNodeLinkMapper.selectByExample(example);
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query node link failed.", "查询节点链接失败", e);
        }
    }

    /*
     *
     *   查询节点链接（按输入节点ID）
     *   返回结果集
     *
     * */
    public List<WfFlowNodeLink> queryLinkByDstNodeId(Long dstNodeId) {
        if(DataUtil.isNull(dstNodeId)){
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query node link failed -- invalid query condition.", "无效查询条件");
        }

        try {
            WfFlowNodeLinkExample example = new WfFlowNodeLinkExample();
            example.createCriteria().andDstNodeIdEqualTo(dstNodeId).andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
            example.setOrderByClause("CREATE_TIME ASC");
            return wfFlowNodeLinkMapper.selectByExample(example);
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query node link failed.", "查询节点链接失败", e);
        }
    }

    /*
     *
     *   查询节点链接（按输出节点端口ID）
     *   返回结果集
     *
     * */
    public List<WfFlowNodeLink> queryLinkBySrcPortId(Long srcNodePortId) {
        if(DataUtil.isNull(srcNodePortId)){
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query node link failed -- invalid query condition.", "无效查询条件");
        }

        try {
            WfFlowNodeLinkExample example = new WfFlowNodeLinkExample();
            example.createCriteria().andSrcPortIdEqualTo(srcNodePortId).andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
            example.setOrderByClause("CREATE_TIME ASC");
            return wfFlowNodeLinkMapper.selectByExample(example);
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query node link failed.", "查询节点链接失败", e);
        }
    }

    /*
     *
     *   查询节点链接（按输入节点端口ID）
     *   返回结果集
     *
     * */
    public WfFlowNodeLink queryLinkByDstPortId(Long dstNodePortId) {
        if(DataUtil.isNull(dstNodePortId)){
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query node link failed -- invalid query condition.", "无效查询条件");
        }

        try {
            WfFlowNodeLinkExample example = new WfFlowNodeLinkExample();
            example.createCriteria().andDstPortIdEqualTo(dstNodePortId).andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
            example.setOrderByClause("CREATE_TIME ASC");
            List<WfFlowNodeLink> resultList = wfFlowNodeLinkMapper.selectByExample(example);

            if(DataUtil.isNotEmpty(resultList) && resultList.size() > 1) {
                throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query node link failed -- node link data error.", "系统数据错误");
            }

            return DataUtil.isNotEmpty(resultList) ? resultList.get(0) : null;
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query node link failed.", "查询节点链接失败", e);
        }
    }
}
