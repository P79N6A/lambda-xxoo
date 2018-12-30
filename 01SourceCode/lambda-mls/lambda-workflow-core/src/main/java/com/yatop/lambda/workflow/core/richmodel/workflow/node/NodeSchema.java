package com.yatop.lambda.workflow.core.richmodel.workflow.node;

import com.alibaba.fastjson.JSONArray;
import com.yatop.lambda.base.model.WfFlowNodeSchema;
import com.yatop.lambda.core.enums.JsonObjectStateEnum;
import com.yatop.lambda.core.enums.LambdaExceptionEnum;
import com.yatop.lambda.core.enums.SchemaStateEnum;
import com.yatop.lambda.core.exception.LambdaException;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.richmodel.IRichModel;
import com.yatop.lambda.workflow.core.richmodel.data.field.FieldAttribute;
import com.yatop.lambda.workflow.core.richmodel.workflow.JsonObject;
import com.yatop.lambda.workflow.core.utils.CollectionUtil;
import com.yatop.lambda.workflow.core.mgr.editor.node.port.schema.SchemaHelper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NodeSchema extends WfFlowNodeSchema implements IRichModel {

    private JsonObject jsonObject;  //关联JSON对象
    private List<FieldAttribute> fieldAttributes;

    public NodeSchema(WfFlowNodeSchema data) {
        this(data, null);
    }

    public NodeSchema(WfFlowNodeSchema data, JsonObject jsonObject) {
        super.copyProperties(data);
        this.jsonObject = jsonObject;
        this.clearColoured();
    }

    @Override
    public void clear() {
        jsonObject = null;
        CollectionUtil.clear(fieldAttributes);
        super.clear();
    }

    private JsonObject getJsonObject() {
        if(DataUtil.isNull(jsonObject)) {
            jsonObject = SchemaHelper.queryFieldAttributes(this.getObjectId());
        }
        return jsonObject;
    }

    public List<FieldAttribute> getFieldAttributes() {
        if(this.getSchemaState() != SchemaStateEnum.NORMAL.getState())
            return null;

        if(DataUtil.isEmpty(fieldAttributes)) {
            if (getJsonObject().getObjectState() == JsonObjectStateEnum.NORMAL.getState()) {
                fieldAttributes = JSONArray.parseArray(this.getJsonObject().getObjectData(), FieldAttribute.class);
            }
            if(DataUtil.isEmpty(fieldAttributes)){
                throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Data output port schema info error -- field attribute list confused.", "节点数据输出端口schema信息错乱，请联系管理员");
            }
        }
        return fieldAttributes;
    }

    public void setFieldAttributes(SchemaStateEnum schemaStateEnum, List<FieldAttribute> fieldAttributes) {
        if(schemaStateEnum.getState() == SchemaStateEnum.NORMAL.getState())
            this.fieldAttributes = fieldAttributes;
        else
            this.fieldAttributes = null;
        this.setSchemaState(schemaStateEnum.getState());
    }

    public void flushFieldAttributes(String operId) {

        if(this.getSchemaState() == SchemaStateEnum.NORMAL.getState()) {
            if(DataUtil.isNotEmpty(fieldAttributes)) {
                this.getJsonObject().setObjectData(JSONArray.toJSONString(fieldAttributes));
                SchemaHelper.updateFieldAttributes(this.jsonObject, operId);
            }
            else
                throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Data output port schema info error -- empty field attribute list.", "节点数据输出端口schema信息为空，请联系管理员");
        }
    }

    public void deleteFieldAttributes(String operId) {
        SchemaHelper.deleteFieldAttributes(this.getJsonObject(), operId);
        this.jsonObject = null;
        CollectionUtil.clear(this.fieldAttributes);
        this.fieldAttributes = null;
    }

    public void recoverFieldAttributes(String operId) {
        SchemaHelper.recoverFieldAttributes(this.getObjectId(), operId);
        this.jsonObject = null;
        CollectionUtil.clear(this.fieldAttributes);
        this.fieldAttributes = null;
    }
}
