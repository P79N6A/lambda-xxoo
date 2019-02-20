package com.yatop.lambda.workflow.core.config;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yatop.lambda.LambdaApplication;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.richmodel.component.characteristic.CmptCharType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Random;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = LambdaApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ComponentConfigTest {


    @Autowired
    ComponentConfig componentConfig;

    private JSONObject toJSON(CmptCharType charType) {

        JSONObject jsonObj = new JSONObject(32, true);
        jsonObj.put("charTypeId", charType.data().getCharTypeId());
        jsonObj.put("charTypeCode", charType.data().getCharTypeCode());
        jsonObj.put("charTypeName", charType.data().getCharTypeName());
        return jsonObj;
    }

    @Test
    public void testWorkflowNamedLock(){

        List<CmptCharType> portTypes = componentConfig.getPortCharacteristicTypes();

        JSONArray jsonArray = new JSONArray(portTypes.size());
        for(CmptCharType portType : portTypes) {
            JSONObject jsonObject = this.toJSON(portType);
            JSONArray matchTypes = new JSONArray(portType.matchTargetTypeCount());

            for(CmptCharType matchType : portType.getMatchTargetTypes()) {
                matchTypes.add(this.toJSON(matchType));
            }

            jsonObject.put("matchTypes", matchTypes);
            jsonArray.add(jsonObject);
        }

        System.out.println(DataUtil.prettyFormat(jsonArray));
    }
}
