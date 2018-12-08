package com.yatop.lambda.core.mgr.workflow.node;

import com.yatop.lambda.base.model.WfFlowNodeSchema;
import com.yatop.lambda.base.model.WfFlowNodeSchemaExample;
import com.yatop.lambda.core.enums.DataStatusEnum;
import com.yatop.lambda.core.exception.LambdaException;
import com.yatop.lambda.core.mgr.base.BaseMgr;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.core.utils.PagerUtil;
import com.yatop.lambda.core.utils.SystemTimeUtil;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class NodeSchemaMgr extends BaseMgr {

    /*
     *
     *   插入新节点Schema（节点端口Id、Schema名称、Schema状态 ...）
     *   返回插入记录
     *
     * */
    public WfFlowNodeSchema insertSchema(WfFlowNodeSchema schema, String operId) {
        if( DataUtil.isNull(schema) ||
                schema.isNodePortIdNotColoured() ||
                schema.isSchemaNameNotColoured() ||
                schema.isSchemaStateNotColoured() ||
                DataUtil.isEmpty(operId) ) {
            throw new LambdaException("Insert node schema failed -- invalid insert data.", "无效插入数据");
        }

        WfFlowNodeSchema insertSchema = new WfFlowNodeSchema();
        try {
            Date dtCurrentTime = SystemTimeUtil.getCurrentTime();
            insertSchema.copyProperties(schema);
            insertSchema.setStatus(DataStatusEnum.NORMAL.getStatus());
            insertSchema.setLastUpdateTime(dtCurrentTime);
            insertSchema.setLastUpdateOper(operId);
            insertSchema.setCreateTime(dtCurrentTime);
            insertSchema.setCreateOper(operId);
            wfFlowNodeSchemaMapper.insertSelective(insertSchema);
            return insertSchema;
        } catch (Throwable e) {
            throw new LambdaException("Insert node schema failed.", "插入节点Schema失败", e);
        }
    }

    /*
     *
     *   逻辑删除节点Schema
     *   返回删除数量
     *
     * */
    public int deleteSchema(WfFlowNodeSchema schema, String operId) {
        if(DataUtil.isNull(schema) || schema.isNodePortIdNotColoured() || DataUtil.isEmpty(operId)){
            throw new LambdaException("Delete node schema -- invalid delete condition.", "无效删除条件");
        }

        try {
            WfFlowNodeSchema deleteSchema = new WfFlowNodeSchema();
            deleteSchema.setNodePortId(schema.getNodePortId());
            deleteSchema.setStatus(DataStatusEnum.INVALID.getStatus());
            deleteSchema.setLastUpdateTime(SystemTimeUtil.getCurrentTime());
            deleteSchema.setLastUpdateOper(operId);
            return wfFlowNodeSchemaMapper.updateByPrimaryKeySelective(deleteSchema);
        } catch (Throwable e) {
            throw new LambdaException("Delete node schema failed.", "删除节点Schema失败", e);
        }
    }

    /*
     *
     *   恢复节点Schema
     *   返回恢复数量
     *
     * */
    public int recoverchema(WfFlowNodeSchema schema, String operId) {
        if(DataUtil.isNull(schema) || schema.isNodePortIdNotColoured() || DataUtil.isEmpty(operId)){
            throw new LambdaException("Recover node schema -- invalid recover condition.", "无效恢复条件");
        }

        try {
            WfFlowNodeSchema recoverSchema = new WfFlowNodeSchema();
            recoverSchema.setNodePortId(schema.getNodePortId());
            recoverSchema.setStatus(DataStatusEnum.NORMAL.getStatus());
            recoverSchema.setLastUpdateTime(SystemTimeUtil.getCurrentTime());
            recoverSchema.setLastUpdateOper(operId);
            return wfFlowNodeSchemaMapper.updateByPrimaryKeySelective(recoverSchema);
        } catch (Throwable e) {
            throw new LambdaException("Recover node schema failed.", "恢复节点Schema失败", e);
        }
    }

    /*
     *
     *   查询节点Schema（按节点端口ID）
     *   返回结果
     *
     * */
    public WfFlowNodeSchema querySchema(Long id) {
        if(DataUtil.isNull(id)){
            throw new LambdaException("Query node schema failed -- invalid query condition.", "无效查询条件");
        }

        WfFlowNodeSchema schema;
        try {
            schema = wfFlowNodeSchemaMapper.selectByPrimaryKey(id);
        } catch (Throwable e) {
            throw new LambdaException("Query node schema failed.", "查询节点Schema失败", e);
        }

        if(DataUtil.isNull(schema) || (schema.getStatus() == DataStatusEnum.INVALID.getStatus()))
            throw new LambdaException("Query node schema failed -- invalid status or not found.", "已删除或未查找到");

        return schema;
    }

    /*
     *
     *   查询节点Schema
     *   返回结果集
     *
     * */
    public List<WfFlowNodeSchema> querySchemaByDstPortId(PagerUtil pager) {

        try {
            PagerUtil.startPage(pager);
            WfFlowNodeSchemaExample example = new WfFlowNodeSchemaExample();
            example.createCriteria().andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
            example.setOrderByClause("CREATE_TIME ASC");
            return wfFlowNodeSchemaMapper.selectByExample(example);
        } catch (Throwable e) {
            PagerUtil.clearPage(pager);
            throw new LambdaException("Query node schema failed.", "查询节点Schema失败", e);
        }
    }
}
