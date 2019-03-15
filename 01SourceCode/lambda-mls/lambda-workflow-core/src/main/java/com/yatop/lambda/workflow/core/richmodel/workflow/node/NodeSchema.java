package com.yatop.lambda.workflow.core.richmodel.workflow.node;

import com.alibaba.fastjson.JSONArray;
import com.yatop.lambda.base.model.WfFlowNodeSchema;
import com.yatop.lambda.core.enums.LambdaExceptionEnum;
import com.yatop.lambda.core.enums.SchemaStateEnum;
import com.yatop.lambda.core.enums.SystemParameterEnum;
import com.yatop.lambda.core.exception.LambdaException;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.core.utils.SystemParameterUtil;
import com.yatop.lambda.workflow.core.richmodel.RichModel;
import com.yatop.lambda.workflow.core.richmodel.workflow.component.characteristic.CmptChar;
import com.yatop.lambda.workflow.core.richmodel.data.table.field.FieldAttribute;
import com.yatop.lambda.workflow.core.utils.CollectionUtil;
import com.yatop.lambda.workflow.core.mgr.workflow.node.schema.NodeSchemaHelper;

import java.util.List;

public class NodeSchema extends RichModel<WfFlowNodeSchema> {

    private CmptChar cmptChar;
    private List<FieldAttribute> fieldAttributes;
    private boolean isSchemaChanged;

    public NodeSchema(WfFlowNodeSchema data, CmptChar cmptChar) {
        super(data);
        this.cmptChar = cmptChar;
        this.fieldAttributes = null;
        this.isSchemaChanged = false;   //用于标记Schema字段属性信息变化
    }

    @Override
    public void clear() {
        CollectionUtil.clear(fieldAttributes);
        super.clear();
    }

    protected void flush(String operId) {
        if(isSchemaChanged) {
            this.data().setSchemaContent(DataUtil.isNotEmpty(fieldAttributes) ? JSONArray.toJSONString(fieldAttributes) : null);
            NodeSchemaHelper.updateNodeSchema(this, operId);
        }
    }

    public CmptChar getCmptChar() {
        return cmptChar;
    }

    public List<FieldAttribute> getFieldAttributes() {
        if(this.data().getSchemaState() != SchemaStateEnum.NORMAL.getState()) {
            return null;
        }

        if(DataUtil.isEmpty(fieldAttributes)) {
            if (DataUtil.isNotEmpty(this.data().getSchemaContent())) {
                fieldAttributes = JSONArray.parseArray(this.data().getSchemaContent(), FieldAttribute.class);
            }
            if(DataUtil.isEmpty(fieldAttributes)){
                throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Data output port schema info error -- empty field attribute list.", "节点数据输出端口schema信息错误", this.data());
            }
        }
        return fieldAttributes;
    }

    private void clearFieldAttributes(SchemaStateEnum schemaStateEnum) {
        if(this.isStateNormal()) {
            CollectionUtil.clear(this.fieldAttributes);
            this.fieldAttributes = null;
            this.isSchemaChanged = true;
        }
        this.changeSchemaState(schemaStateEnum);
    }

    public void setFieldAttributes(List<FieldAttribute> fieldAttributes) {

        if(DataUtil.isEmpty(fieldAttributes)) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Data output port schema info error -- input empty field attribute list.", "节点数据输出端口schema信息错误");
        }

        if(this.isStateNormal()) {
            if(fieldAttributes.size() > SystemParameterUtil.find4Integer(SystemParameterEnum.WK_FLOW_SCHEMA_MAX_FIELDS, 512)) {
                this.changeState2OverloadInterrupt();
                CollectionUtil.clear(this.fieldAttributes);
                this.fieldAttributes = null;
                this.isSchemaChanged = true;
            }
            else if(!CollectionUtil.equals(this.getFieldAttributes(), fieldAttributes)) {
                CollectionUtil.clear(this.fieldAttributes);
                this.fieldAttributes = fieldAttributes;
                this.isSchemaChanged = true;
            }
        } else {
            if(fieldAttributes.size() > SystemParameterUtil.find4Integer(SystemParameterEnum.WK_FLOW_SCHEMA_MAX_FIELDS, 512)) {
                this.changeState2OverloadInterrupt();
                return;
            }
            this.fieldAttributes = fieldAttributes;
            this.isSchemaChanged = true;
            this.changeSchemaState(SchemaStateEnum.NORMAL);
        }
    }

    public boolean isStateEmpty() {
        return this.data().getSchemaState() == SchemaStateEnum.EMPTY.getState();
    }

    public boolean isStateNormal() {
        return this.data().getSchemaState() == SchemaStateEnum.NORMAL.getState();
    }

    public boolean isStateNotSupport() {
        return this.data().getSchemaState() == SchemaStateEnum.NOT_SUPPORT.getState();
    }

    public boolean isStateOverloadInterrupt() {
        return this.data().getSchemaState() == SchemaStateEnum.OVERLOAD_INTERRUPT.getState();
    }

    public boolean isSchemaChanged() {
        return isSchemaChanged;
    }

    public void changeState2Empty() {
        this.clearFieldAttributes(SchemaStateEnum.EMPTY);
    }

    public void changeState2NotSupport() {
        this.clearFieldAttributes(SchemaStateEnum.NOT_SUPPORT);
    }

    private void changeState2OverloadInterrupt() {
        this.clearFieldAttributes(SchemaStateEnum.OVERLOAD_INTERRUPT);
    }

    private void changeSchemaState(SchemaStateEnum stateEnum) {
        if(this.data().getSchemaState() == stateEnum.getState())
            return;

        if(this.data().getSchemaState() == SchemaStateEnum.NOT_SUPPORT.getState() && stateEnum == SchemaStateEnum.EMPTY)
            return;

        this.data().setSchemaState(stateEnum.getState());
    }
}
