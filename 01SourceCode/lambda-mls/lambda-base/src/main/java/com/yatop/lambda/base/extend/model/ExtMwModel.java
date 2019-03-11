package com.yatop.lambda.base.extend.model;

import com.alibaba.fastjson.JSONObject;
import com.yatop.lambda.base.model.MwModel;

/**
 * 模型扩展类
 *
 * @author huangyu
 * @create 2019-03-01-14:51
 */
public class ExtMwModel extends MwModel {
    private String algorithmLabels;

    public String getAlgorithmLabels() {
        return algorithmLabels;
    }

    public void setAlgorithmLabels(String algorithmLabels) {
        this.algorithmLabels = algorithmLabels;
    }

    @Override
    public JSONObject toJSON() {
        JSONObject jsonObj = super.toJSON();
        if(this.algorithmLabels != null) {jsonObj.put("algorithmLabels", this.algorithmLabels);}
        return jsonObj;
    }
}
