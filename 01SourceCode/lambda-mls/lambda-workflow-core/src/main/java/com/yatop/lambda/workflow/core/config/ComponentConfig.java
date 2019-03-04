package com.yatop.lambda.workflow.core.config;

import com.yatop.lambda.base.model.*;
import com.yatop.lambda.core.enums.*;
import com.yatop.lambda.core.mgr.component.AlgorithmMgr;
import com.yatop.lambda.core.mgr.component.CmptCharValueMgr;
import com.yatop.lambda.core.mgr.component.CmptSpecRelMgr;
import com.yatop.lambda.core.mgr.component.ComponentMgr;
import com.yatop.lambda.core.mgr.component.characteristic.CharEnumMgr;
import com.yatop.lambda.core.mgr.component.characteristic.CharacteristicMgr;
import com.yatop.lambda.core.mgr.component.characteristic.CharTypeMgr;
import com.yatop.lambda.core.mgr.component.characteristic.CharTypeWildMgr;
import com.yatop.lambda.core.mgr.component.specification.SpecCharRelMgr;
import com.yatop.lambda.core.mgr.component.specification.SpecCharValueMgr;
import com.yatop.lambda.core.mgr.component.specification.SpecificationMgr;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.richmodel.component.CmptAlgorithm;
import com.yatop.lambda.workflow.core.richmodel.component.CmptCharValue;
import com.yatop.lambda.workflow.core.richmodel.component.Component;
import com.yatop.lambda.workflow.core.richmodel.component.characteristic.CharType;
import com.yatop.lambda.workflow.core.richmodel.component.characteristic.CmptChar;
import com.yatop.lambda.workflow.core.richmodel.component.characteristic.CharEnum;
import com.yatop.lambda.workflow.core.richmodel.component.specification.CmptSpec;
import com.yatop.lambda.workflow.core.richmodel.component.specification.SpecCharValue;
import com.yatop.lambda.workflow.core.utils.CollectionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Service
public class ComponentConfig implements InitializingBean {

    public static Logger logger = LoggerFactory.getLogger(ComponentConfig.class);

    @Autowired
    private ComponentMgr componentMgr;

    @Autowired
    private AlgorithmMgr algorithmMgr;

    @Autowired
    private CmptSpecRelMgr cmptSpecRelMgr;

    @Autowired
    private CmptCharValueMgr cmptCharValueMgr;

    @Autowired
    private SpecificationMgr specificationMgr;

    @Autowired
    private SpecCharRelMgr specCharRelMgr;

    @Autowired
    private SpecCharValueMgr specCharValueMgr;

    @Autowired
    private CharacteristicMgr characteristicMgr;

    @Autowired
    private CharEnumMgr charEnumMgr;

    @Autowired
    private CharTypeMgr charTypeMgr;

    @Autowired
    private CharTypeWildMgr charTypeWildMgr;

    private HashMap<Long, CmptAlgorithm> ALL_ALGORITHMS = new HashMap<Long, CmptAlgorithm>();   //计算组件算法
    private HashMap<String, CmptAlgorithm> ALL_ALGORITHMS_BY_CODE = new HashMap<String, CmptAlgorithm>();   //计算组件算法（按算法代码）
    private HashMap<String, Component> ALL_COMPONENTS = new HashMap<String, Component>();    //计算组件
    private HashMap<String, Component> ALL_COMPONENTS_BY_CODE = new HashMap<String, Component>();    //计算组件（按组件代码）
    private HashMap<String, CmptSpec> ALL_SPECIFICATIONS = new HashMap<String, CmptSpec>();  //计算组件规格
    private HashMap<String, CmptChar> ALL_CHARACTERISTICS = new HashMap<String, CmptChar>(); //计算组件特征
    private HashMap<Integer, CharType> ALL_CHARACTERISTIC_TYPES = new HashMap<Integer, CharType>(); //计算组件特征类型
    private HashMap<String, CharType> ALL_CHARACTERISTIC_TYPES_BY_CODE = new HashMap<String, CharType>(); //计算组件特征类型（按类型代码）
    private HashMap<Integer, CharType> ALL_PORT_CHARACTERISTIC_TYPES = new HashMap<Integer, CharType>(); //计算组件绑定到端口的特征类型

    public CmptAlgorithm getAlgorithm(Long algorithmId) {
        return CollectionUtil.get(ALL_ALGORITHMS, algorithmId);
    }

    public CmptAlgorithm getAlgorithmByCode(String algorithmCode) {
        return CollectionUtil.get(ALL_ALGORITHMS_BY_CODE, algorithmCode);
    }

    public Component getComponent(String cmptId) {
        return CollectionUtil.get(ALL_COMPONENTS, cmptId);
    }

    public Component getComponentByCode(String cmptCode) {
        return CollectionUtil.get(ALL_COMPONENTS_BY_CODE, cmptCode);
    }

    public CmptSpec getSpecification(String specId) {
        return CollectionUtil.get(ALL_SPECIFICATIONS, specId);
    }


    public CmptChar getCharacteristic(String charId) {
        return CollectionUtil.get(ALL_CHARACTERISTICS, charId);
    }


    public CharType getCharacteristicType(Integer typeId) {
        return CollectionUtil.get(ALL_CHARACTERISTIC_TYPES, typeId);
    }

    public CharType getCharacteristicTypeByCode(String typeCode) {
        return CollectionUtil.get(ALL_CHARACTERISTIC_TYPES_BY_CODE, typeCode);
    }

    public CharType getPortCharacteristicType(Integer typeId) {
        return CollectionUtil.get(ALL_PORT_CHARACTERISTIC_TYPES, typeId);
    }

    public List<CharType> getPortCharacteristicTypes() {
        return CollectionUtil.toList(ALL_PORT_CHARACTERISTIC_TYPES);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        //loadComponentConfiguration();
    }

    private void loadComponentConfiguration() {

        //特征类型相关
        loadCharTypeConfig();

        //特征相关
        loadCharacteristicConfig();

        //规格相关
        loadSpecificationConfig();

        //组件相关
        loadComponentConfig();

        //校验相关
        checkConfiguration();
    }

    private void loadCharTypeConfig() {
        long wildTypeCounter = 0;
        List<CfCharType> typeList = charTypeMgr.queryCharType();
        if(DataUtil.isEmpty(typeList)) {
            logger.error(String.format("Loading component configuration occurs fatal error -- Empty characteristic type configuration."));
            System.exit(-1);
        }

        for(CfCharType type : typeList) {
            CharType richType = new CharType(type);

            IsWildTypeEnum wildTypeEnum = IsWildTypeEnum.valueOf(richType.data().getIsWildtype());
            if(DataUtil.isNull(wildTypeEnum)) {
                logger.error(String.format("Loading component configuration occurs fatal error -- Error Is-WildType:\n%s.", DataUtil.prettyFormat(type)));
                System.exit(-1);
            }
            if(wildTypeEnum.getMark() == IsWildTypeEnum.YES.getMark()) {
                wildTypeCounter++;
            }
            if(!SpecMaskEnum.isCorrectMask(richType.data().getSpecMask())) {
                logger.error(String.format("Loading component configuration occurs fatal error -- Error Spec-Mask:\n%s.", DataUtil.prettyFormat(type)));
                System.exit(-1);
            }

            ALL_CHARACTERISTIC_TYPES.put(richType.data().getCharTypeId(), richType);
            ALL_CHARACTERISTIC_TYPES_BY_CODE.put(richType.data().getCharTypeCode(), richType);
        }
        typeList.clear();

        if(wildTypeCounter > 0) {
            List<CfCharTypeWild> matchTypeList = charTypeWildMgr.queryCharTypeWild();
            if (DataUtil.isEmpty(matchTypeList)) {
                logger.error(String.format("Loading component configuration occurs fatal error -- Empty characteristic type wild match configuration."));
                System.exit(-1);
            }

            for (CfCharTypeWild match : matchTypeList) {
                CharType targetCharType = ALL_CHARACTERISTIC_TYPES.get(match.getDstCharTypeId());
                if (DataUtil.isNull(targetCharType)) {
                    logger.error(String.format("Loading component configuration occurs fatal error -- Destination port characteristic type not found:\n%s.", DataUtil.prettyFormat(match)));
                    System.exit(-1);
                }
                if (targetCharType.data().getIsWildtype() != IsWildTypeEnum.YES.getMark()) {
                    logger.error(String.format("Loading component configuration occurs fatal error -- Destination port characteristic type info error:\n%s.", DataUtil.prettyFormat(match)));
                    System.exit(-1);
                }
                if (!SpecMaskEnum.matchInputAndOutput(targetCharType.data().getSpecMask())) {
                    logger.error(String.format("Loading component configuration occurs fatal error -- Destination port characteristic type must be also support input & output:\n%s.", DataUtil.prettyFormat(match)));
                    System.exit(-1);
                }
                CharType sourceCharType = ALL_CHARACTERISTIC_TYPES.get(match.getSrcCharTypeId());
                if (DataUtil.isNull(sourceCharType)) {
                    logger.error(String.format("Loading component configuration occurs fatal error -- Source port characteristic type not found:\n%s.", DataUtil.prettyFormat(match)));
                    System.exit(-1);
                }
                if (!SpecMaskEnum.matchInputAndOutput(sourceCharType.data().getSpecMask())) {
                    logger.error(String.format("Loading component configuration occurs fatal error -- Source port characteristic type must be also support input & output:\n%s.", DataUtil.prettyFormat(match)));
                    System.exit(-1);
                }

                sourceCharType.putMatchTargetType(targetCharType);
            }
            matchTypeList.clear();
        }

        //sourceCharTypeId, <targetCharTypeId, CharType>
        HashMap<Integer, TreeMap<Integer, CharType>> expandedTargetCharTypesCache = new HashMap<Integer, TreeMap<Integer, CharType>>();
        for(Map.Entry<Integer, CharType> entry: ALL_CHARACTERISTIC_TYPES.entrySet()) {
            CharType sourceCharType = entry.getValue();
            if(SpecMaskEnum.matchInputAndOutput(sourceCharType.data().getSpecMask())) {
                ALL_PORT_CHARACTERISTIC_TYPES.put(sourceCharType.data().getCharTypeId(), sourceCharType);

                TreeMap<Integer, CharType> expandedTargetCharTypes = new TreeMap<Integer, CharType>();
                expandedTargetCharTypes.put(sourceCharType.data().getCharTypeId(), sourceCharType);
                expandedTargetCharTypesCache.put(sourceCharType.data().getCharTypeId(), expandedTargetCharTypes);

                expandSourcePortTargetCharType(sourceCharType.getMatchTargetTypes(), expandedTargetCharTypes);
            }
        }

        for(Map.Entry<Integer, TreeMap<Integer, CharType>> entry : expandedTargetCharTypesCache.entrySet()) {
            CharType sourceCharType = ALL_PORT_CHARACTERISTIC_TYPES.get(entry.getKey());
            sourceCharType.replaceMatchTargetTypes(entry.getValue());
        }
        expandedTargetCharTypesCache.clear();
    }

    private void expandSourcePortTargetCharType(List<CharType> targetCharTypes, TreeMap<Integer, CharType> expandedTargetCharTypes) {
        if(DataUtil.isEmpty(targetCharTypes))
            return;
        for(CharType targetCharType : targetCharTypes) {
            expandSourcePortTargetCharType(targetCharType.getMatchTargetTypes(), expandedTargetCharTypes);
            expandedTargetCharTypes.put(targetCharType.data().getCharTypeId(), targetCharType);
        }
    }

    private void loadCharacteristicConfig() {
        long enumCharCounter = 0L;

        List<CfCharacteristic> charList = characteristicMgr.queryCharacteristic();
        if(DataUtil.isEmpty(charList)) {
            logger.error(String.format("Loading component configuration occurs fatal error -- Empty characteristic configuration."));
            System.exit(-1);
        }

        for(CfCharacteristic cmptChar : charList) {

            CharType charType =  ALL_CHARACTERISTIC_TYPES.get(cmptChar.getCharType());
            if(DataUtil.isNull(charType)) {
                logger.error(String.format("Loading component configuration occurs fatal error -- Characteristic type not found:\n%s.", DataUtil.prettyFormat(cmptChar)));
                System.exit(-1);
            }

            CmptChar richChar = new CmptChar(cmptChar, charType);
            ALL_CHARACTERISTICS.put(richChar.data().getCharId(), richChar);

            SpecTypeEnum typeEnum = SpecTypeEnum.valueOf(richChar.data().getSpecType());
            if(DataUtil.isNull(typeEnum)) {
                logger.error(String.format("Loading component configuration occurs fatal error -- Unknown Spec-Type:\n%s.", DataUtil.prettyFormat(cmptChar)));
                System.exit(-1);
            }

            if(!SpecMaskEnum.isCorrectFitSpecType(charType.data().getSpecMask(), typeEnum)) {
                logger.error(String.format("Loading component configuration occurs fatal error -- Incorrect Spec-Type:\n%s.", DataUtil.prettyFormat(cmptChar)));
                System.exit(-1);
            }

            if(DataUtil.isNull(SourceLevelEnum.valueOf(richChar.data().getSrcLevel()))) {
                logger.error(String.format("Loading component configuration occurs fatal error -- Unknown Src-Level:\n%s.", DataUtil.prettyFormat(cmptChar)));
                System.exit(-1);
            }

            if((typeEnum.getType() == SpecTypeEnum.INPUT.getType() || typeEnum.getType() == SpecTypeEnum.OUTPUT.getType())
                    && richChar.data().getSrcLevel() != SourceLevelEnum.WORKFLOW.getSource()) {
                logger.error(String.format("Loading component configuration occurs fatal error -- Error Src-Level(input & output must be workflow-source-level):\n%s.", DataUtil.prettyFormat(cmptChar)));
                System.exit(-1);
            }

            if(typeEnum.getType() == SpecTypeEnum.EXECUTION.getType() && richChar.data().getSrcLevel() == SourceLevelEnum.WORKFLOW.getSource()) {
                logger.error(String.format("Loading component configuration occurs fatal error -- Error Src-Level(forbid execution to be workflow-source-level):\n%s.", DataUtil.prettyFormat(cmptChar)));
                System.exit(-1);
            }

            if(DataUtil.isNull(IsRequiredEnum.valueOf(richChar.data().getIsRequired()))) {
                logger.error(String.format("Loading component configuration occurs fatal error -- Unknown Is-Required:\n%s.", DataUtil.prettyFormat(cmptChar)));
                System.exit(-1);
            }

            if(DataUtil.isNull(IsLimitedEnum.valueOf(richChar.data().getIsLimited()))) {
                logger.error(String.format("Loading component configuration occurs fatal error -- Unknown Is-Limited:\n%s.", DataUtil.prettyFormat(cmptChar)));
                System.exit(-1);
            }

            if(cmptChar.getIsLimited() == IsLimitedEnum.ENUMERATION.getMark())
                enumCharCounter++;
        }
        charList.clear();

        if(enumCharCounter > 0) {
            List<CfCharEnum> enumList = charEnumMgr.queryCharEnum();
            if(DataUtil.isEmpty(enumList)) {
                logger.error(String.format("Loading component configuration occurs fatal error -- Empty characteristic enumeration configuration."));
                System.exit(-1);
            }

            for(CfCharEnum charEnum : enumList) {
                CharEnum richCharEnum = new CharEnum(charEnum);
                CmptChar cmptChar = ALL_CHARACTERISTICS.get(richCharEnum.data().getCharId());
                if(DataUtil.isNotNull(cmptChar)) {
                    cmptChar.putEnum(richCharEnum);
                } else {
                    logger.error(String.format("Loading component configuration occurs fatal error -- Owner characteristic not found:\n%s.", DataUtil.prettyFormat(charEnum)));
                    System.exit(-1);
                }
            }
            enumList.clear();
        }
    }

    private void loadSpecificationConfig() {
        List<CfSpecification> specList = specificationMgr.querySpecification();
        if(DataUtil.isEmpty(specList)) {
            logger.error(String.format("Loading component configuration occurs fatal error -- Empty specification configuration."));
            System.exit(-1);
        }

        for(CfSpecification cmptSpec : specList) {
            CmptSpec richSpec = new CmptSpec(cmptSpec);
            if(DataUtil.isNull(SpecTypeEnum.valueOf(richSpec.data().getSpecType()))) {
                logger.error(String.format("Loading component configuration occurs fatal error -- Unknown Spec-Type:\n%s.", DataUtil.prettyFormat(cmptSpec)));
                System.exit(-1);
            }

            ALL_SPECIFICATIONS.put(richSpec.data().getSpecId(), richSpec);
        }
        specList.clear();

        List<CfSpecCharRel> specCharRelList = specCharRelMgr.querySpecCharRel();
        if(DataUtil.isEmpty(specCharRelList)) {
            logger.error(String.format("Loading component configuration occurs fatal error -- Empty Spec-Char-Rel configuration."));
            System.exit(-1);
        }

        for(CfSpecCharRel rel : specCharRelList) {
            CmptSpec cmptSpec = ALL_SPECIFICATIONS.get(rel.getSpecId());
            if(DataUtil.isNull(cmptSpec)) {
                logger.error(String.format("Loading component configuration occurs fatal error -- Specification not found:\n%s.", DataUtil.prettyFormat(rel)));
                System.exit(-1);
            }
            CmptChar cmptChar = ALL_CHARACTERISTICS.get(rel.getCharId());
            if(DataUtil.isNull(cmptChar)) {
                logger.error(String.format("Loading component configuration occurs fatal error -- Characteristic not found:\n%s.", DataUtil.prettyFormat(rel)));
                System.exit(-1);
            }
            if(cmptChar.data().getSpecType() != cmptChar.data().getSpecType()) {
                logger.error(String.format("Loading component configuration occurs fatal error -- Error Spec-Char-Rel:\n%s.", DataUtil.prettyFormat(rel)));
                System.exit(-1);
            }

            CmptChar findChar = cmptSpec.getCmptCharByCode(cmptChar.data().getCharCode());
            if(DataUtil.isNotNull(findChar)) {
                logger.error(String.format("Loading component configuration occurs fatal error -- Characteristic code conflict:\n===Specification===%s\n===This Characteristic===%s\n===That Characteristic===%s.", DataUtil.prettyFormat(cmptSpec.data()),DataUtil.prettyFormat(findChar.data()), DataUtil.prettyFormat(cmptChar.data())));
                System.exit(-1);
            }

            cmptSpec.putCmptChar(cmptChar);
        }
        specCharRelList.clear();

        List<CfSpecCharValue> charValueList = specCharValueMgr.querySpecCharValue();
        if (DataUtil.isNotEmpty(charValueList)) {

            for (CfSpecCharValue value : charValueList) {
                CmptSpec cmptSpec = ALL_SPECIFICATIONS.get(value.getSpecId());
                if (DataUtil.isNull(cmptSpec)) {
                    logger.error(String.format("Loading component configuration occurs fatal error -- Specification not found:\n%s.", DataUtil.prettyFormat(value)));
                    System.exit(-1);
                }

                if(cmptSpec.data().getSpecType() == SpecTypeEnum.INPUT.getType() || cmptSpec.data().getSpecType() == SpecTypeEnum.OUTPUT.getType()) {
                    logger.error(String.format("Loading component configuration occurs fatal error -- Spec-Char-Value error(forbid input & output value):\n%s.", DataUtil.prettyFormat(value)));
                    System.exit(-1);
                }

                CmptChar cmptChar = cmptSpec.getCmptChar(value.getCharId());
                if (DataUtil.isNull(cmptChar)) {
                    logger.error(String.format("Loading component configuration occurs fatal error -- Spec-Char-Rel not found:\n%s.", DataUtil.prettyFormat(value)));
                    System.exit(-1);
                }
                if (DataUtil.isNull(IsSystemParamEnum.valueOf(value.getIsSystemParam()))) {
                    logger.error(String.format("Loading component configuration occurs fatal error -- Unknown Is-System-Param:\n%s.", DataUtil.prettyFormat(value)));
                    System.exit(-1);
                }

                cmptSpec.putCharValue(new SpecCharValue(value));
            }
        }
    }

    private void loadComponentConfig() {
        List<CfAlgorithm> algorithmList = algorithmMgr.queryAlgorithm();
        if(DataUtil.isEmpty(algorithmList)) {
            logger.error(String.format("Loading component configuration occurs fatal error -- Empty algorithm configuration."));
            System.exit(-1);
        }

        for(CfAlgorithm algorithm : algorithmList) {
            CmptAlgorithm richAlgorithm = new CmptAlgorithm(algorithm);
            if (DataUtil.isNull(AlgorithmTypeEnum.valueOf(richAlgorithm.data().getAlgorithmType()))) {
                logger.error(String.format("Loading component configuration occurs fatal error -- Unknown Algorithm-Type:\n%s.", DataUtil.prettyFormat(algorithm)));
                System.exit(-1);
            }

            ALL_ALGORITHMS.put(richAlgorithm.data().getAlgorithmId(), richAlgorithm);
            ALL_ALGORITHMS_BY_CODE.put(richAlgorithm.data().getAlgorithmCode(), richAlgorithm);
        }
        algorithmList.clear();

        List<CfComponent> componentList = componentMgr.queryComponent();
        if(DataUtil.isEmpty(componentList)) {
            logger.error(String.format("Loading component configuration occurs fatal error -- Empty component configuration."));
            System.exit(-1);
        }

        for(CfComponent component : componentList) {
            Component richComponent = new Component(component);
            if (DataUtil.isNull(CmptTypeEnum.valueOf(richComponent.data().getCmptType()))) {
                logger.error(String.format("Loading component configuration occurs fatal error -- Unknown Cmpt-Type:\n%s.", DataUtil.prettyFormat(component)));
                System.exit(-1);
            }

            if(richComponent.data().getRelAlgorithmId() > 0) {
                CmptAlgorithm algorithm = ALL_ALGORITHMS.get(richComponent.data().getRelAlgorithmId());
                if (DataUtil.isNull(algorithm)) {
                    logger.error(String.format("Loading component configuration occurs fatal error -- Algorithm not found:\n%s.", DataUtil.prettyFormat(component)));
                    System.exit(-1);
                }
                richComponent.setAlgorithm(algorithm);
            }
            ALL_COMPONENTS.put(richComponent.data().getCmptId(), richComponent);
            ALL_COMPONENTS_BY_CODE.put(richComponent.data().getCmptCode(), richComponent);
        }
        componentList.clear();

        List<CfCmptSpecRel> cmptSpecRelList = cmptSpecRelMgr.queryCmptSpecRel();
        if(DataUtil.isEmpty(cmptSpecRelList)) {
            logger.error(String.format("Loading component configuration occurs fatal error -- Empty Cmpt-Spec-Rel configuration."));
            System.exit(-1);
        }

        for(CfCmptSpecRel rel : cmptSpecRelList) {
            Component component = ALL_COMPONENTS.get(rel.getCmptId());
            if(DataUtil.isNull(component)) {
                logger.error(String.format("Loading component configuration occurs fatal error -- Component not found:\n%s.", DataUtil.prettyFormat(rel)));
                System.exit(-1);
            }
            CmptSpec cmptSpec = ALL_SPECIFICATIONS.get(rel.getSpecId());
            if(DataUtil.isNull(cmptSpec)) {
                logger.error(String.format("Loading component configuration occurs fatal error -- Specification not found:\n%s.", DataUtil.prettyFormat(rel)));
                System.exit(-1);
            }

            if(DataUtil.isNull(SpecTypeEnum.valueOf(rel.getSpecType()))) {
                logger.error(String.format("Loading component configuration occurs fatal error -- Unknown Spec-Type:\n%s.", DataUtil.prettyFormat(rel)));
                System.exit(-1);
            }

            if(rel.getSpecType() != cmptSpec.data().getSpecType()) {
                logger.error(String.format("Loading component configuration occurs fatal error -- Error Spec-Type:\n%s.", DataUtil.prettyFormat(rel)));
                System.exit(-1);
            }

            component.setCmptSpec(cmptSpec);
        }
        cmptSpecRelList.clear();

        List<CfCmptCharValue> charValueList = cmptCharValueMgr.queryCmptCharValue();
        if (DataUtil.isNotEmpty(charValueList)) {

            for (CfCmptCharValue value : charValueList) {
                Component component = ALL_COMPONENTS.get(value.getCmptId());
                if (DataUtil.isNull(component)) {
                    logger.error(String.format("Loading component configuration occurs fatal error -- Component not found:\n%s.", DataUtil.prettyFormat(value)));
                    System.exit(-1);
                }
                CmptChar cmptChar = ALL_CHARACTERISTICS.get(value.getCharId());
                if (DataUtil.isNull(cmptChar)) {
                    logger.error(String.format("Loading component configuration occurs fatal error -- Characteristic not found:\n%s.", DataUtil.prettyFormat(value)));
                    System.exit(-1);
                }
                CmptSpec cmptSpec = component.getCmptSpec(SpecTypeEnum.valueOf(cmptChar.data().getSpecType()));
                if (DataUtil.isNull(cmptSpec)) {
                    logger.error(String.format("Loading component configuration occurs fatal error -- Spec-Char-Rel not found:\n%s.", DataUtil.prettyFormat(value)));
                    System.exit(-1);
                }

                if(cmptSpec.data().getSpecType() == SpecTypeEnum.INPUT.getType() || cmptSpec.data().getSpecType() == SpecTypeEnum.OUTPUT.getType()) {
                    logger.error(String.format("Loading component configuration occurs fatal error -- Cmpt-Char-Value error(forbid input & output value):\n%s.", DataUtil.prettyFormat(value)));
                    System.exit(-1);
                }

                if (DataUtil.isNull(IsSystemParamEnum.valueOf(value.getIsSystemParam()))) {
                    logger.error(String.format("Loading component configuration occurs fatal error -- Unknown Is-System-Param:\n%s.", DataUtil.prettyFormat(value)));
                    System.exit(-1);
                }

                component.putCharValue(new CmptCharValue(value));
            }
        }
    }

    private void checkConfiguration() {

        //if SrcLevel < WorkFlow && IsRequired == Yes, Config-Char-Value must be existed in component
        for(Map.Entry<String, Component> cmptEntry : ALL_COMPONENTS.entrySet()) {
            Component component = cmptEntry.getValue();

            if(component.haveExecutionContent()) {
                //execution
                CmptSpec execSpec = component.getOptimizeExecution();
                for (CmptChar cmptChar : component.getExecution().getCmptChars()) {
                    if (component.missingConfigCharValue(cmptChar)) {
                        logger.error(String.format("Check execution config occurs fatal error -- config-char-value not found:\n===Component===\n%s\n===CmptChar===\n%s.", DataUtil.prettyFormat(component.data()), DataUtil.prettyFormat(cmptChar.data())));
                        System.exit(-1);
                    }
                }
            }

            //optimize execution
            CmptSpec o$execSpec = component.getOptimizeExecution();
            if(component.haveOptimizeExecutionContent()) {
                for (CmptChar cmptChar : component.getOptimizeExecution().getCmptChars()) {
                    if (component.missingConfigCharValue(cmptChar)) {
                        logger.error(String.format("Check optimize execution config occurs fatal error -- config-char-value not found:\n===Component===\n%s\n===CmptChar===\n%s.", DataUtil.prettyFormat(component.data()), DataUtil.prettyFormat(cmptChar.data())));
                        System.exit(-1);
                    }
                }
            }

            if(component.haveParameterContnent()) {
                //parameter
                CmptSpec paramSpec = component.getParameter();
                for (CmptChar cmptChar : component.getParameter().getCmptChars()) {
                    if (component.missingConfigCharValue(cmptChar)) {
                        logger.error(String.format("Check parameter config occurs fatal error -- config-char-value not found:\n===Component===\n%s\n===CmptChar===\n%s.", DataUtil.prettyFormat(component.data()), DataUtil.prettyFormat(cmptChar.data())));
                        System.exit(-1);
                    }

                    if(DataUtil.isNotNull(o$execSpec) && DataUtil.isNotNull(o$execSpec.getCmptCharByCode(cmptChar.data().getCharCode()))) {
                        logger.error(String.format("Check parameter config occurs fatal error -- parameter char-code conflict vs optimize execution parameter:\n===Component===\n%s\n===CmptChar===\n%s.", DataUtil.prettyFormat(component.data()), DataUtil.prettyFormat(cmptChar.data())));
                        System.exit(-1);
                    }
                }
            }
        }
    }
}
