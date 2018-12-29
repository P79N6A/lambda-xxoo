package com.yatop.lambda.workflow.core.richmodel.workflow.node;

import com.alibaba.fastjson.JSONArray;
import com.yatop.lambda.base.model.WfFlowNodeSchema;
import com.yatop.lambda.core.enums.JsonObjectStateEnum;
import com.yatop.lambda.core.enums.SchemaStateEnum;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.richmodel.IRichModel;
import com.yatop.lambda.workflow.core.richmodel.data.field.FieldAttribute;
import com.yatop.lambda.workflow.core.richmodel.workflow.JsonObject;
import com.yatop.lambda.workflow.core.utils.CollectionUtil;
import com.yatop.lambda.workflow.core.utils.NodeSchemaUtil;
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
    }

    @Override
    public void clear() {
        jsonObject = null;
        super.clear();
    }

    private JsonObject getJsonObject() {
        if(DataUtil.isNull(jsonObject)) {
            jsonObject = NodeSchemaUtil.queryJsonObject(this.getObjectId());
        }
        return jsonObject;
    }

    public List<FieldAttribute> getFieldAttributes() {
        if(this.getSchemaState() != SchemaStateEnum.NORMAL.getState())
            return null;

        if(DataUtil.isEmpty(fieldAttributes)) {
            if (getJsonObject().getObjectState() == JsonObjectStateEnum.NORMAL.getState()) {
                return fieldAttributes = JSONArray.parseArray(this.getJsonObject().getObjectData(), FieldAttribute.class);
            } else {
                return null;
            }
        } else {
            return fieldAttributes;
        }
    }

    public void setFieldAttributes(List<FieldAttribute> fieldAttributes, String operId) {
        this.fieldAttributes = fieldAttributes;
        if(DataUtil.isNotEmpty(fieldAttributes)) {
            this.getJsonObject().setObjectData(JSONArray.toJSONString(fieldAttributes));
        } else {
            this.getJsonObject().setObjectData(null);
        }

        NodeSchemaUtil.updateJsonObject(this.jsonObject, operId);
    }

    public void deleteFieldAttributes(String operId) {
        NodeSchemaUtil.deleteJsonObject(this.getJsonObject(), operId);
        this.jsonObject = null;
        CollectionUtil.clear(this.fieldAttributes);
        this.fieldAttributes = null;
    }

    public void recoverFieldAttributes(String operId) {
        this.jsonObject = NodeSchemaUtil.recoverJsonObject(this.getObjectId(), operId);
        CollectionUtil.clear(this.fieldAttributes);
        this.fieldAttributes = null;
    }
}
