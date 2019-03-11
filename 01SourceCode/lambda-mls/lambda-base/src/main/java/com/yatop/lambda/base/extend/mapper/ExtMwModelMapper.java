package com.yatop.lambda.base.extend.mapper;

import com.yatop.lambda.base.extend.model.ExtMwModel;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 模型
 *
 * @author huangyu
 * @create 2019-03-01-14:57
 */
public interface ExtMwModelMapper {
    @Select("SELECT " +
            " a.MODEL_ID modelId," +
            " a.MODEL_NAME modelName," +
            " a.MODEL_TYPE modelType," +
            " a.OWNER_MW_ID ownerMwId," +
            " a.REL_FLOW_ID relFlowId," +
            " a.REL_NODE_ID relNodeId, " +
            " a.REL_CHAR_ID relCharId," +
            " a.REF_ALGORITHM_ID refAlgorithmId," +
            " a.MODEL_FILE_SIZE modelFileSize," +
            " a.MODEL_FILE modelFile, " +
            " a.SUMMARY_DFS_FILE summaryDfsFile," +
            " a.SUMMARY_LOCAL_FILE summaryLocalFile," +
            " a.MODEL_STATE modelState,      " +
            " a.TRAIN_TABLE_ID trainTableId,   " +
            " a.TRAIN_COST_TIME trainCostTime,  " +
            " a.DESCRIPTION,      " +
            " a.STATUS,           " +
            " a.LAST_UPDATE_TIME lastUpdateTime, " +
            " a.LAST_UPDATE_OPER lastUpdateOper, " +
            " a.CREATE_TIME createTime,  " +
            " a.CREATE_OPER createOper,  " +
            " b.ALGORITHM_LABELS algorithmLabels " +
            "FROM  " +
            " mw_model a ,  " +
            " cf_algorithm b " +
            " WHERE  " +
            "  a.REF_ALGORITHM_ID = b.ALGORITHM_ID " +
            "  and a.OWNER_MW_ID = #{ownerMwId}  " +
            "  AND a.MODEL_NAME LIKE #{keywork} " +
            "  AND a.MODEL_TYPE  = #{modelTypeEnum} " +
            "  AND a.STATUS  = #{status} " +
            "  ORDER BY a.CREATE_TIME ASC")
    List<ExtMwModel> findModelInfoBykeyWord(@Param("ownerMwId") Long ownerMwId,@Param("keywork") String keywork
    ,@Param("modelTypeEnum") Integer modelTypeEnum,@Param("status") Integer status);

    @Select("SELECT " +
            " a.MODEL_ID modelId," +
            " a.MODEL_NAME modelName," +
            " a.MODEL_TYPE modelType," +
            " a.OWNER_MW_ID ownerMwId," +
            " a.REL_FLOW_ID relFlowId," +
            " a.REL_NODE_ID relNodeId, " +
            " a.REL_CHAR_ID relCharId," +
            " a.REF_ALGORITHM_ID refAlgorithmId," +
            " a.MODEL_FILE_SIZE modelFileSize," +
            " a.MODEL_FILE modelFile, " +
            " a.SUMMARY_DFS_FILE summaryDfsFile," +
            " a.SUMMARY_LOCAL_FILE summaryLocalFile," +
            " a.MODEL_STATE modelState,      " +
            " a.TRAIN_TABLE_ID trainTableId,   " +
            " a.TRAIN_COST_TIME trainCostTime,  " +
            " a.DESCRIPTION,      " +
            " a.STATUS,           " +
            " a.LAST_UPDATE_TIME lastUpdateTime, " +
            " a.LAST_UPDATE_OPER lastUpdateOper, " +
            " a.CREATE_TIME createTime,  " +
            " a.CREATE_OPER createOper,  " +
            " b.ALGORITHM_LABELS algorithmLabels " +
            "FROM  " +
            " mw_model a ,  " +
            " cf_algorithm b " +
            " WHERE  " +
            "  a.REF_ALGORITHM_ID = b.ALGORITHM_ID " +
            "  AND a.OWNER_MW_ID = #{ownerMwId}  " +
            "  AND a.MODEL_TYPE  = #{modelTypeEnum} " +
            "  AND a.STATUS  = #{status} " +
            "  ORDER BY a.CREATE_TIME ASC")
    List<ExtMwModel> findModelInfo(@Param("ownerMwId") Long ownerMwId ,@Param("modelTypeEnum") Integer modelTypeEnum,@Param("status") Integer status);
}
