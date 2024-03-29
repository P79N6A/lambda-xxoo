package com.yatop.lambda.workflow.core.richmodel.workflow.component;

import com.yatop.lambda.base.model.WfCfgComponent;
import com.yatop.lambda.core.enums.*;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.core.utils.SystemParameterUtil;
import com.yatop.lambda.workflow.core.richmodel.RichModel;
import com.yatop.lambda.workflow.core.richmodel.workflow.component.characteristic.CmptChar;
import com.yatop.lambda.workflow.core.richmodel.workflow.component.specification.CmptSpec;
import com.yatop.lambda.workflow.core.richmodel.workflow.component.specification.SpecCharValue;
import com.yatop.lambda.workflow.core.utils.CollectionUtil;

import java.util.TreeMap;

public class Component extends RichModel<WfCfgComponent> {

    private CmptAlgorithm algorithm;    //组件关联算法
    private CmptSpec input;             //组件输入内容规格
    private CmptSpec output;            //组件输出内容规格
    private CmptSpec execution;         //组件调用执行规格
    private CmptSpec optimizeExecution; //组件执行调优参数规格
    private CmptSpec parameter;         //组件参数规格
    private TreeMap<String, CmptCharValue> charValues = new TreeMap<String, CmptCharValue>();   //组件配置特征值

    public Component(WfCfgComponent data) {
        super(data);
    }

    @Override
    public void clear() {
        algorithm = null;
        input = null;
        output = null;
        execution = null;
        optimizeExecution = null;
        parameter = null;
        CollectionUtil.enhancedClear(charValues);
        charValues = null;
        super.clear();
    }

    public boolean haveInputContent() {
        return DataUtil.isNotNull(getInput()) && getInput().cmptCharCount() > 0;
    }

    public boolean haveOutputContent() {
        return DataUtil.isNotNull(getOutput()) && getOutput().cmptCharCount() > 0;
    }

    public boolean haveExecutionContent() {
        return DataUtil.isNotNull(getExecution()) && getExecution().cmptCharCount() > 0;
    }

    public boolean haveOptimizeExecutionContent() {
        return DataUtil.isNotNull(getOptimizeExecution()) && getOptimizeExecution().cmptCharCount() > 0;
    }

    public boolean haveParameterContnent() {
        return DataUtil.isNotNull(getParameter()) && getParameter().cmptCharCount() > 0;
    }

    public boolean isAlgorithmComponent() {
        return DataUtil.isNotNull(algorithm);
    }

    public CmptAlgorithm getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(CmptAlgorithm algorithm) {
        this.algorithm = algorithm;
    }

    public CmptSpec getInput() {
        return input;
    }

    private void setInput(CmptSpec input) {
        this.input = input;
    }

    public CmptSpec getOutput() {
        return output;
    }

    private void setOutput(CmptSpec output) {
        this.output = output;
    }

    public CmptSpec getExecution() {
        return execution;
    }

    private void setExecution(CmptSpec execution) {
        this.execution = execution;
    }

    public CmptSpec getOptimizeExecution() {
        return optimizeExecution;
    }

    private void setOptimizeExecution(CmptSpec optimizeExecution) {
        this.optimizeExecution = optimizeExecution;
    }

    public CmptSpec getParameter() {
        return parameter;
    }

    private void setParameter(CmptSpec parameter) {
        this.parameter = parameter;
    }

    public int charValueCount() {
        return charValues.size();
    }

    public CmptCharValue getCharValue(String charId) {
        return CollectionUtil.get(charValues, charId);
    }

    public String getConfigCharValue(CmptChar cmptChar) {

        if(cmptChar.data().getSrcLevel() != SourceLevelEnum.SPECIFICATION.getSource()) {
            CmptCharValue cmptCharValue = this.getCharValue(cmptChar.data().getCharId());
            if (DataUtil.isNotNull(cmptCharValue)) {
                if (cmptCharValue.data().getIsSystemParam() == IsSystemParamEnum.YES.getMark())
                    return DataUtil.trimToNull(SystemParameterUtil.find(cmptCharValue.data().getCharValue()));
                else
                    return DataUtil.trimToNull(cmptCharValue.data().getCharValue());
            }
        }

        SpecCharValue specCharValue = null;
        switch (SpecTypeEnum.valueOf(cmptChar.data().getSpecType())) {
            case INPUT:
                if(haveInputContent()) {
                    specCharValue = this.input.getCharValue(cmptChar.data().getCharId());
                }
                break;
            case OUTPUT:
                if(haveOutputContent()) {
                    specCharValue = this.output.getCharValue(cmptChar.data().getCharId());
                }
                break;
            case EXECUTION:
                if(haveExecutionContent()) {
                    specCharValue = this.execution.getCharValue(cmptChar.data().getCharId());
                }
                break;
            case OPTIMIZE_EXECUTION:
                if(haveOptimizeExecutionContent()) {
                    specCharValue = this.optimizeExecution.getCharValue(cmptChar.data().getCharId());
                }
                break;
            case PARAMETER:
                if(haveParameterContnent()) {
                    specCharValue = this.parameter.getCharValue(cmptChar.data().getCharId());
                }
                break;
        }
        if(DataUtil.isNotNull(specCharValue)) {
            if(specCharValue.data().getIsSystemParam() == IsSystemParamEnum.YES.getMark())
                return DataUtil.trimToNull(SystemParameterUtil.find(specCharValue.data().getCharValue()));
            else
                return DataUtil.trimToNull(specCharValue.data().getCharValue());
        }
        return DataUtil.trimToNull(cmptChar.data().getDefaultValue());
    }

    public void putCharValue(CmptCharValue charValue) {
        CollectionUtil.put(charValues, charValue.data().getCharId(), charValue);
    }

    public void setCmptSpec(CmptSpec cmptSpec) {
        switch (SpecTypeEnum.valueOf(cmptSpec.data().getSpecType())) {
            case INPUT:
                this.setInput(cmptSpec);
                break;
            case OUTPUT:
                this.setOutput(cmptSpec);
                break;
            case EXECUTION:
                this.setExecution(cmptSpec);
                break;
            case OPTIMIZE_EXECUTION:
                this.setOptimizeExecution(cmptSpec);
                break;
            case PARAMETER:
                this.setParameter(cmptSpec);
                break;
        }
    }

    public CmptSpec getCmptSpec(SpecTypeEnum typeEnum) {
        switch (typeEnum) {
            case INPUT:
                return this.getInput();
            case OUTPUT:
                return this.getOutput();
            case EXECUTION:
                return this.getExecution();
            case OPTIMIZE_EXECUTION:
                return this.getOptimizeExecution();
            case PARAMETER:
                return this.getParameter();
        }
        return null;
    }

    public boolean existsCmptChar(CmptChar cmptChar) {
        switch (SpecTypeEnum.valueOf(cmptChar.data().getSpecType())) {
            case INPUT:
                return this.haveInputContent() && DataUtil.isNotNull(this.getInput().getCmptChar(cmptChar.data().getCharId()));
            case OUTPUT:
                return this.haveOutputContent() && DataUtil.isNotNull(this.getOutput().getCmptChar(cmptChar.data().getCharId()));
            case EXECUTION:
                return this.haveExecutionContent() && DataUtil.isNotNull(this.getExecution().getCmptChar(cmptChar.data().getCharId()));
            case OPTIMIZE_EXECUTION:
                return this.haveOptimizeExecutionContent() && DataUtil.isNotNull(this.getOptimizeExecution().getCmptChar(cmptChar.data().getCharId()));
            case PARAMETER:
                return this.haveParameterContnent() && DataUtil.isNotNull(this.getParameter().getCmptChar(cmptChar.data().getCharId()));
        }
        return false;
    }

    public boolean missingConfigCharValue(CmptChar cmptChar) {
        switch (SourceLevelEnum.valueOf(cmptChar.data().getSrcLevel())) {
            case SPECIFICATION:
            case COMPONENT:
                if(cmptChar.isRequired() && DataUtil.isEmpty(this.getConfigCharValue(cmptChar)))
                    return true;
          //case WORKFLOW:
        }
        return false;
    }
}
