package com.yatop.lambda.base.extend.model;

import com.alibaba.fastjson.JSONObject;
import com.yatop.lambda.base.model.EmExperiment;

/**
 * 实验扩展类
 *
 * @author huangyu
 * @create 2019-02-28-18:57
 */
public class ExtEmExperiment extends EmExperiment{
    private Integer flowState;

    public Integer getFlowState() {
        return flowState;
    }

    public void setFlowState(Integer flowState) {
        this.flowState = flowState;
    }
    @Override
    public JSONObject toJSON() {
        JSONObject jsonObject = super.toJSON();
        if(this.flowState != null) {jsonObject.put("flowState", this.flowState);}
        return jsonObject;
    }
}
