package com.yatop.lambda.core.mgr.workflow.node;

import com.yatop.lambda.base.model.WfFlowNode;
import com.yatop.lambda.base.model.WfFlowNodeSchema;
import com.yatop.lambda.base.model.WfFlowNodeSchemaExample;
import com.yatop.lambda.core.enums.LambdaExceptionEnum;
import com.yatop.lambda.core.enums.SchemaStateEnum;
import com.yatop.lambda.core.mgr.base.BaseMgr;
import com.yatop.lambda.core.enums.DataStatusEnum;
import com.yatop.lambda.core.exception.LambdaException;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.core.utils.SystemTimeUtil;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class NodeSchemaMgr extends BaseMgr {

    /*
     *
     *   插入新节点端口Schema（节点端口Id、Schema名称、Schema状态 ...）
     *   返回插入记录
     *
     * */
    public WfFlowNodeSchema insertSchema(WfFlowNodeSchema schema, String operId) {
        if( DataUtil.isNull(schema) ||
                schema.isNodePortIdNotColoured() ||
                schema.isSchemaNameNotColoured() ||
                schema.isOwnerNodeIdNotColoured() ||
                schema.isSchemaStateNotColoured() ||
                DataUtil.isEmpty(operId) ) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Insert node schema failed -- invalid insert data.", "无效插入数据");
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
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Insert node schema failed.", "插入节点端口Schema失败", e);
        }
    }

    /*
     *
     *   逻辑删除节点端口Schema
     *   返回删除数量
     *
     * */
    public int deleteSchema(Long nodeId, String operId) {
        if(DataUtil.isNull(nodeId) || DataUtil.isEmpty(operId)){
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Delete node schema -- invalid delete condition.", "无效删除条件");
        }

        try {
            WfFlowNodeSchema deleteSchema = new WfFlowNodeSchema();
            //deleteSchema.setSchemaContent();
            //deleteSchema.setSchemaState();
            deleteSchema.setStatus(DataStatusEnum.INVALID.getStatus());
            deleteSchema.setLastUpdateTime(SystemTimeUtil.getCurrentTime());
            deleteSchema.setLastUpdateOper(operId);
            WfFlowNodeSchemaExample example = new WfFlowNodeSchemaExample();
            example.createCriteria().andOwnerNodeIdEqualTo(nodeId).andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
            return wfFlowNodeSchemaMapper.updateByExampleSelective(deleteSchema, example);
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Delete node schema failed.", "删除节点端口Schema失败", e);
        }
    }

    /*
     *
     *   恢复节点端口Schema
     *   返回恢复数量
     *
     * */
    public int recoverSchema(Long nodeId, String operId) {
        if(DataUtil.isNull(nodeId) || DataUtil.isEmpty(operId)){
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Recover node schema -- invalid recover condition.", "无效恢复条件");
        }

        try {
            WfFlowNodeSchema recoverSchema = new WfFlowNodeSchema();
            recoverSchema.setStatus(DataStatusEnum.NORMAL.getStatus());
            recoverSchema.setLastUpdateTime(SystemTimeUtil.getCurrentTime());
            recoverSchema.setLastUpdateOper(operId);
            WfFlowNodeSchemaExample example = new WfFlowNodeSchemaExample();
            example.createCriteria().andOwnerNodeIdEqualTo(nodeId).andStatusEqualTo(DataStatusEnum.INVALID.getStatus());
            return wfFlowNodeSchemaMapper.updateByExampleSelective(recoverSchema, example);
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Recover node schema failed.", "恢复节点端口Schema失败", e);
        }
    }


    /*
     *
     *   更新节点端口Schema（schema状态）
     *   返回恢复数量
     *
     * */
    public int updateSchema(WfFlowNodeSchema schema, String operId) {
        if( DataUtil.isNull(schema) || schema.isNodePortIdNotColoured() || DataUtil.isEmpty(operId)) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Update node schema failed -- invalid update condition.", "无效更新条件");
        }

        if(schema.isSchemaStateNotColoured() &&
                schema.isDescriptionNotColoured()) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Update node schema failed -- invalid update data.", "无效更新内容");
        }

        try {
            WfFlowNodeSchema updateSchema= new WfFlowNodeSchema();
            updateSchema.setNodePortId(schema.getNodePortId());
            if(schema.isSchemaContentColoured())
                updateSchema.setSchemaContent(schema.getSchemaContent());
            if(schema.isSchemaStateColoured())
                updateSchema.setSchemaState(schema.getSchemaState());
            if(schema.isDescriptionColoured())
                updateSchema.setDescription(schema.getDescription());

            updateSchema.setLastUpdateTime(SystemTimeUtil.getCurrentTime());
            updateSchema.setLastUpdateOper((operId));

            schema.setLastUpdateTime(updateSchema.getLastUpdateTime());
            schema.setLastUpdateOper(updateSchema.getLastUpdateOper());
            return wfFlowNodeSchemaMapper.updateByPrimaryKeySelective(updateSchema);
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Update node schema failed.", "更新节点端口Schema失败", e);
        }
    }

    /*
     *
     *   查询节点端口Schema（按节点端口ID）
     *   返回结果
     *
     * */
    public WfFlowNodeSchema querySchema(Long nodePortId) {
        if(DataUtil.isNull(nodePortId)){
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query node schema failed -- invalid query condition.", "无效查询条件");
        }

        WfFlowNodeSchema schema;
        try {
            schema = wfFlowNodeSchemaMapper.selectByPrimaryKey(nodePortId);
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query node schema failed.", "查询节点端口Schema失败", e);
        }

        if(DataUtil.isNull(schema) || (schema.getStatus() == DataStatusEnum.INVALID.getStatus()))
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query node schema failed -- invalid status or not found.", "节点端口Schema不存在");

        return schema;
    }

    /*
     *
     *   查询节点端口Schema（按节点ID）
     *   返回结果集
     *
     * */
    public List<WfFlowNodeSchema> querySchemaByNodeId(Long nodeId) {
        if(DataUtil.isNull(nodeId)){
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query node schema failed -- invalid query condition.", "无效查询条件");
        }

        try {
            WfFlowNodeSchemaExample example = new WfFlowNodeSchemaExample();
            example.createCriteria().andOwnerNodeIdEqualTo(nodeId).andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
            example.setOrderByClause("CREATE_TIME ASC");
            return wfFlowNodeSchemaMapper.selectByExampleWithBLOBs(example);
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query node schema failed.", "查询节点端口Schema失败", e);
        }
    }
}
