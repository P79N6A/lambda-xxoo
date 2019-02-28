package com.yatop.lambda.base.extend.model;

import com.alibaba.fastjson.JSONObject;
import com.yatop.lambda.base.model.PrProject;

/**
 * Created by xiaom on 2019/2/28.
 */
public class ExtProjectDetail extends PrProject {
    private String ownerUserName;
    private String ownerRealName;

    public String getOwnerUserName() {
        return ownerUserName;
    }

    public void setOwnerUserName(String ownerUserName) {
        this.ownerUserName = ownerUserName;
    }

    public String getOwnerRealName() {
        return ownerRealName;
    }

    public void setOwnerRealName(String ownerRealName) {
        this.ownerRealName = ownerRealName;
    }

    @Override
    public JSONObject toJSON() {
        JSONObject jsonObject = super.toJSON();
        if(this.ownerUserName != null) {jsonObject.put("ownerUserName", this.ownerUserName);}
        if(this.ownerRealName != null) {jsonObject.put("ownerRealName", this.ownerRealName);}
        return jsonObject;
    }
}
