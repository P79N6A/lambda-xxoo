package com.yatop.lambda.workflow.core.config;

import com.yatop.lambda.workflow.core.richmodel.workflow.component.CmptAlgorithm;
import com.yatop.lambda.workflow.core.richmodel.workflow.component.characteristic.CharType;
import com.yatop.lambda.workflow.core.richmodel.workflow.component.characteristic.CmptChar;
import com.yatop.lambda.workflow.core.richmodel.workflow.component.specification.CmptSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ComponentConfigHelper {

    private static ComponentConfig COMPONENT_CONFIG;

    @Autowired
    public void setComponentConfig(ComponentConfig componentConfig) {
        COMPONENT_CONFIG = componentConfig;
    }

    public static CmptAlgorithm getAlgorithm(Long algorithmId) {
        return COMPONENT_CONFIG.getAlgorithm(algorithmId);
    }

    public static CmptAlgorithm getAlgorithmByCode(String algorithmCode) {
        return COMPONENT_CONFIG.getAlgorithmByCode(algorithmCode);
    }

    public static com.yatop.lambda.workflow.core.richmodel.workflow.component.Component getComponent(String cmptId) {
        return COMPONENT_CONFIG.getComponent(cmptId);
    }

    public static com.yatop.lambda.workflow.core.richmodel.workflow.component.Component getComponentByCode(String cmptCode) {
        return COMPONENT_CONFIG.getComponentByCode(cmptCode);
    }

    public static CmptSpec getSpecification(String specId) {
        return COMPONENT_CONFIG.getSpecification(specId);
    }

    public static CmptChar getCharacteristic(String charId) {
        return COMPONENT_CONFIG.getCharacteristic(charId);
    }

    public static CharType getCharacteristicType(Integer typeId) {
        return COMPONENT_CONFIG.getCharacteristicType(typeId);
    }

    public static CharType getCharacteristicTypeByCode(String typeCode) {
        return COMPONENT_CONFIG.getCharacteristicTypeByCode(typeCode);
    }
}
