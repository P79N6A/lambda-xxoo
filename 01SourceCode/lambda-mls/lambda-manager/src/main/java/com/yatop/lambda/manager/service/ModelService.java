package com.yatop.lambda.manager.service;

import com.alibaba.fastjson.JSONObject;
import com.yatop.lambda.base.extend.model.ExtMwModel;
import com.yatop.lambda.base.model.MwModel;
import com.yatop.lambda.base.model.MwModelWarehouse;
import com.yatop.lambda.base.model.PrProject;
import com.yatop.lambda.core.enums.LambdaExceptionEnum;
import com.yatop.lambda.core.enums.ModelStateEnum;
import com.yatop.lambda.core.enums.ModelTypeEnum;
import com.yatop.lambda.core.exception.LambdaException;
import com.yatop.lambda.core.mgr.model.ModelMgr;
import com.yatop.lambda.core.mgr.model.ModelWarehouseMgr;
import com.yatop.lambda.core.utils.ModelFileUtil;
import com.yatop.lambda.manager.api.request.project.ModelRequest;
import com.yatop.lambda.portal.common.utils.PortalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 模型
 *
 * @author huangyu
 * @create 2019-02-28-14:31
 */
@Service
public class ModelService {
    @Autowired
    private ModelMgr modelMgr;
    @Autowired
    private ProjectService projectService;
    @Autowired
    private ModelWarehouseMgr modelWarehouseMgr;

    public List<ExtMwModel> queryModel(ModelRequest vo) {
        //判断项目是否存在
        PrProject prProject = projectService.queryProject(vo.getProjectId());
        return modelMgr.queryModel(prProject.getMwId(), ModelTypeEnum.GENERAL, vo.getKeyword(), vo);
    }
    @Transactional
    public int deleteModel(List<Long> modelIds) {

        for (Long modelId : modelIds) {
            MwModel model = modelMgr.queryModel(modelId);
            if(model.getModelState() != ModelStateEnum.EMPTY.getState()){
                //TODO 清理相关的文件 根据 dfs 和 本地 路径清理文件
//                model.getModelFile();
//                model.getSummaryDfsFile();
//                model.getSummaryLocalFile();
                //TODO 封装一个工具类 清理文件
            }
            modelMgr.deleteModel(modelId, PortalUtil.getCurrentUserName());
        }
        return modelIds.size();
    }

    public JSONObject viewModel(ModelRequest vo) {
        MwModel model = modelMgr.queryModel(vo.getModelId());
        if(model.getModelState() != ModelStateEnum.EMPTY.getState()){
            throw new LambdaException(LambdaExceptionEnum.E_MODEL_DEFAULT_ERROR, "model state empty","模型状态为空");
        }
        try {
//            model.getSummaryLocalFile();
//            model.getSummaryDfsFile();
            //TODO 解析文件内容为JSON对象返回
            return null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    @Transactional
    public MwModel saveTempModel(ModelRequest vo) {
        PrProject prProject = projectService.queryProject(vo.getProjectId());
        MwModelWarehouse modelWarehouse = modelWarehouseMgr.queryModelWarehouse(prProject.getMwId());
        MwModel tempModel = modelMgr.queryModel(vo.getModelId());

        if(tempModel.getModelState() == ModelStateEnum.EMPTY.getState()) {
            //TODO throw 要保存的临时表为空
        }

        MwModel model = new MwModel();
        model.setModelName(vo.getModelName());
        model.setOwnerMwId(modelWarehouse.getMwId());
        model.setRelFlowId(-1L);
        model.setRelNodeId(-1L);
        model.setRelCharId("-1");
        model.setRefAlgorithmId(tempModel.getRefAlgorithmId());
        model.setModelState(tempModel.getModelState());
        model.setModelFileSize(tempModel.getModelFileSize());
        model.setTrainTableId(tempModel.getTrainTableId());
        model.setTrainCostTime(tempModel.getTrainCostTime());
        model = modelMgr.insertModel(model, PortalUtil.getCurrentUserName());

        String modelWarehouseDfsDir = modelWarehouse.getModelDfsDir();
        String modelWarehouseLocalDir = modelWarehouse.getModelLocalDir();
        model.setModelFile(ModelFileUtil.getFilePath4General(modelWarehouseDfsDir, model.getModelId()));
        model.setSummaryDfsFile(ModelFileUtil.getSummaryFilePath4General(modelWarehouseDfsDir, model.getModelId()));
        model.setSummaryLocalFile(ModelFileUtil.getSummaryFilePath4General(modelWarehouseLocalDir, model.getModelId()));
        modelMgr.updateModel(model, PortalUtil.getCurrentUserName());

        // copy file from temp model to destination model
        //tempTable.getModelFile() copy to dataTable.getModelFile();
//                model.getModelFile();
//                model.getSummaryDfsFile();
//                model.getSummaryLocalFile();

        return model;
    }
}
