package com.yatop.lambda.workflow.core.richmodel.component;

import com.yatop.lambda.base.model.CfComponent;
import com.yatop.lambda.workflow.core.richmodel.IRichModel;
import com.yatop.lambda.workflow.core.richmodel.component.specification.CmptSpec;
import com.yatop.lambda.workflow.core.utils.CollectionUtil;

import java.util.TreeMap;

public class Component extends CfComponent implements IRichModel {

    private CmptAlgorithm algorithm;    //组件关联算法
    private CmptSpec input;             //组件输入内容规格
    private CmptSpec output;            //组件输出内容规格
    private CmptSpec execution;         //组件调用执行规格
    private CmptSpec optimizeExecution; //组件执行调优参数规格
    private CmptSpec parameter;         //组件参数规格
    private TreeMap<String, CmptCharValue> charValues = new TreeMap<String, CmptCharValue>();   //组件配置特征值

    public Component() {}

    public Component(CfComponent data) {super.copyProperties(data);}

    @Override
    public void clear() {
        algorithm = null;
        input = null;
        output = null;
        execution = null;
        optimizeExecution = null;
        parameter = null;
        CollectionUtil.clear(charValues);
        charValues = null;
        super.clear();
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

    public void setInput(CmptSpec input) {
        this.input = input;
    }

    public CmptSpec getOutput() {
        return output;
    }

    public void setOutput(CmptSpec output) {
        this.output = output;
    }

    public CmptSpec getExecution() {
        return execution;
    }

    public void setExecution(CmptSpec execution) {
        this.execution = execution;
    }

    public CmptSpec getOptimizeExecution() {
        return optimizeExecution;
    }

    public void setOptimizeExecution(CmptSpec optimizeExecution) {
        this.optimizeExecution = optimizeExecution;
    }

    public CmptSpec getParameter() {
        return parameter;
    }

    public void setParameter(CmptSpec parameter) {
        this.parameter = parameter;
    }

    public CmptCharValue getCharValue(String charId) {
        return CollectionUtil.get(charValues, charId);
    }

    public void setCharValue(CmptCharValue charValue) {
        CollectionUtil.put(charValues, charValue.getCharId(), charValue);
    }
}
