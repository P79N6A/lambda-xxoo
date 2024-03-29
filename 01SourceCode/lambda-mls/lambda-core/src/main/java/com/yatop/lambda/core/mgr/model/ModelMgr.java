package com.yatop.lambda.core.mgr.model;

import com.yatop.lambda.base.extend.mapper.ExtMwModelMapper;
import com.yatop.lambda.base.extend.model.ExtMwModel;
import com.yatop.lambda.base.model.MwModel;
import com.yatop.lambda.base.model.MwModelExample;
import com.yatop.lambda.core.enums.LambdaExceptionEnum;
import com.yatop.lambda.core.mgr.base.BaseMgr;
import com.yatop.lambda.core.enums.DataStatusEnum;
import com.yatop.lambda.core.enums.ModelTypeEnum;
import com.yatop.lambda.core.exception.LambdaException;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.core.utils.PagerUtil;
import com.yatop.lambda.core.utils.SystemTimeUtil;
import com.yatop.lambda.core.utils.WorkDirectoryUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ModelMgr extends BaseMgr {

    @Autowired
    private ExtMwModelMapper extMwModelMapper;

    /*
     *
     *   插入新模型信息（表名、类型、来源、所属模型仓库ID、引用算法ID、模型状态 ...）
     *   返回插入记录
     *
     * */
    public MwModel insertModel(MwModel model, String operId) {
        if( DataUtil.isNull(model) ||
                model.isModelNameNotColoured() ||
                model.isModelTypeNotColoured() ||
                model.isOwnerMwIdNotColoured() ||
                model.isRelFlowIdNotColoured() ||
                model.isRelNodeIdNotColoured() ||
                model.isRelCharIdNotColoured() ||
                model.isRefAlgorithmIdNotColoured() ||
                model.isModelStateNotColoured() ||
                DataUtil.isEmpty(operId) ) {
            throw new LambdaException(LambdaExceptionEnum.E_MODEL_DEFAULT_ERROR, "Insert model info failed -- invalid insert data.", "无效插入数据");
        }

        /*if(existsModel(model.getOwnerMwId(), model.getModelName(), null)) {
            throw new LambdaException(LambdaExceptionEnum.E_MODEL_DEFAULT_ERROR, "Insert model info failed -- name conflict.", "模型名称冲突");
        }*/

        MwModel insertModel = new MwModel();
        try {
            Date dtCurrentTime = SystemTimeUtil.getCurrentTime();
            insertModel.copyProperties(model);
            if(insertModel.isModelFileColoured())
                insertModel.setModelFile(WorkDirectoryUtil.removeDfsSchemaPrefix(insertModel.getModelFile()));
            if(insertModel.isSummaryDfsFileColoured())
                insertModel.setSummaryDfsFile(WorkDirectoryUtil.removeDfsSchemaPrefix(insertModel.getSummaryDfsFile()));
            insertModel.setModelIdColoured(false);
            insertModel.setStatus(DataStatusEnum.NORMAL.getStatus());
            insertModel.setLastUpdateTime(dtCurrentTime);
            insertModel.setLastUpdateOper(operId);
            insertModel.setCreateTime(dtCurrentTime);
            insertModel.setCreateOper(operId);
            mwModelMapper.insertSelective(insertModel);
            if(insertModel.isModelFileColoured())
                insertModel.setModelFile(WorkDirectoryUtil.addDfsSchemaPrefix(insertModel.getModelFile()));
            if(insertModel.isSummaryDfsFileColoured())
                insertModel.setSummaryDfsFile(WorkDirectoryUtil.addDfsSchemaPrefix(insertModel.getSummaryDfsFile()));
            return insertModel;
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.E_MODEL_DEFAULT_ERROR, "Insert model info failed.", "插入模型信息失败", e);
        }
    }

    /*
     *
     *   逻辑删除模型信息
     *   返回删除数量
     *
     * */
    public int deleteModel(Long modelId, String operId) {
        if(DataUtil.isNull(modelId) || DataUtil.isEmpty(operId)){
            throw new LambdaException(LambdaExceptionEnum.E_MODEL_DEFAULT_ERROR, "Delete model info failed -- invalid delete condition.", "无效删除条件");
        }

        try {
            MwModel deleteModel = new MwModel();
            deleteModel.setModelId(modelId);
            deleteModel.setStatus(DataStatusEnum.INVALID.getStatus());
            deleteModel.setLastUpdateTime(SystemTimeUtil.getCurrentTime());
            deleteModel.setLastUpdateOper(operId);
            return mwModelMapper.updateByPrimaryKeySelective(deleteModel);
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.E_MODEL_DEFAULT_ERROR, "Delete model info failed.", "删除模型信息失败", e);
        }
    }

    /*
     *
     *   恢复模型信息
     *   返回恢复数量
     *
     * */
    public int recoverModel(Long id, String operId) {
        if(DataUtil.isNull(id) || DataUtil.isEmpty(operId)){
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Recover model info -- invalid recover condition.", "无效恢复条件");
        }

        try {
            MwModel recoverModel = new MwModel();
            recoverModel.setModelId(id);
            recoverModel.setStatus(DataStatusEnum.NORMAL.getStatus());
            recoverModel.setLastUpdateTime(SystemTimeUtil.getCurrentTime());
            recoverModel.setLastUpdateOper(operId);
            return mwModelMapper.updateByPrimaryKeySelective(recoverModel);
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Recover model info failed.", "恢复模型信息失败", e);
        }
    }

    /*
     *
     *   更新模型信息（模型文件大小、模型文件名、模型概要文件名、模型状态、描述）
     *   返回更新数量
     *
     * */
    public int updateModel(MwModel model, String operId) {
        if( DataUtil.isNull(model) || model.isModelIdNotColoured() || DataUtil.isEmpty(operId)) {
            throw new LambdaException(LambdaExceptionEnum.E_MODEL_DEFAULT_ERROR, "Update model info failed -- invalid update condition.", "无效更新条件");
        }

        if(model.isModelNameNotColoured() &&
                model.isModelFileSizeNotColoured() &&
                model.isModelFileNotColoured() &&
                model.isSummaryDfsFileNotColoured() &&
                model.isSummaryLocalFileNotColoured() &&
                model.isModelStateNotColoured() &&
                model.isDescriptionNotColoured()) {
            throw new LambdaException(LambdaExceptionEnum.E_MODEL_DEFAULT_ERROR, "Update model info failed -- invalid update data.", "无效更新内容");
        }

        MwModel updateModel = new MwModel();
        try {
            updateModel.setModelId(model.getModelId());
            if(model.isModelNameColoured())
                updateModel.setModelName(model.getModelName());
            if(model.isModelFileSizeColoured())
                updateModel.setModelFileSize(model.getModelFileSize());
            if(model.isModelFileColoured())
                updateModel.setModelFile(WorkDirectoryUtil.removeDfsSchemaPrefix(model.getModelFile()));
            if(model.isSummaryDfsFileColoured())
                updateModel.setSummaryDfsFile(WorkDirectoryUtil.removeDfsSchemaPrefix(model.getSummaryDfsFile()));
            if(model.isSummaryLocalFileColoured())
                updateModel.setSummaryLocalFile(model.getSummaryLocalFile());
            if(model.isModelStateColoured())
                updateModel.setModelState(model.getModelState());
            if(model.isDescriptionColoured())
                updateModel.setDescription(model.getDescription());

            updateModel.setLastUpdateTime(SystemTimeUtil.getCurrentTime());
            updateModel.setLastUpdateOper((operId));
            return mwModelMapper.updateByPrimaryKeySelective(updateModel);
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.E_MODEL_DEFAULT_ERROR, "Update model info failed.", "更新模型信息失败", e);
        }
    }

    /*
     *
     *   查询模型信息（按ID）
     *   返回结果
     *
     * */
    public MwModel queryModel(Long modelId) {
        if(DataUtil.isNull(modelId)){
            throw new LambdaException(LambdaExceptionEnum.E_MODEL_DEFAULT_ERROR, "Query model info failed -- invalid query condition.", "无效查询条件");
        }

        MwModel model;
        try {
            model = mwModelMapper.selectByPrimaryKey(modelId);
            model.setModelFile(WorkDirectoryUtil.addDfsSchemaPrefix(model.getModelFile()));
            model.setSummaryDfsFile(WorkDirectoryUtil.addDfsSchemaPrefix(model.getSummaryDfsFile()));
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.E_MODEL_DEFAULT_ERROR, "Query model info failed.", "查询模型信息失败", e);
        }

        if(DataUtil.isNull(model) || (model.getStatus() == DataStatusEnum.INVALID.getStatus()))
            throw new LambdaException(LambdaExceptionEnum.E_MODEL_DEFAULT_ERROR, "Query model info failed -- invalid status or not found.", "模型信息不存在");

        return model;
    }

    /*
     *
     *   查询模型信息（按[类型] + [关键字]）
     *   返回结果集
     *
     * */
    public List<ExtMwModel> queryModel(Long warehouseId, ModelTypeEnum modelTypeEnum, String keyword, PagerUtil pager) {
        if(DataUtil.isNull(warehouseId)){
            throw new LambdaException(LambdaExceptionEnum.E_MODEL_DEFAULT_ERROR, "Query model info failed -- invalid query condition.", "无效查询条件");
        }
        try {
            PagerUtil.startPage(pager);
            List<ExtMwModel> resultList = null;

            if(DataUtil.isEmpty(keyword)){
                resultList = extMwModelMapper.findModelInfo(warehouseId,modelTypeEnum.getType(),DataStatusEnum.NORMAL.getStatus());
            }else {
                resultList = extMwModelMapper.findModelInfoBykeyWord(warehouseId,DataUtil.likeKeyword(keyword),modelTypeEnum.getType(),DataStatusEnum.NORMAL.getStatus());
            }

            if(DataUtil.isNotEmpty(resultList)) {
                for (ExtMwModel model : resultList) {
                    model.setModelFile(WorkDirectoryUtil.addDfsSchemaPrefix(model.getModelFile()));
                    model.setSummaryDfsFile(WorkDirectoryUtil.addDfsSchemaPrefix(model.getSummaryDfsFile()));
                }
            }
            return resultList;
        } catch (Throwable e) {
            PagerUtil.clearPage(pager);
            throw new LambdaException(LambdaExceptionEnum.E_MODEL_DEFAULT_ERROR, "Query model info failed.", "查询模型信息失败", e);
        }
    }
}















