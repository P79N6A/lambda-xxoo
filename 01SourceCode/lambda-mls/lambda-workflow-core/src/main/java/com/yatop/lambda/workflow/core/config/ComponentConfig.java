package com.yatop.lambda.workflow.core.config;

import com.yatop.lambda.base.model.*;
import com.yatop.lambda.core.enums.*;
import com.yatop.lambda.core.mgr.workflow.component.AlgorithmMgr;
import com.yatop.lambda.core.mgr.workflow.component.CmptCharValueMgr;
import com.yatop.lambda.core.mgr.workflow.component.CmptSpecRelMgr;
import com.yatop.lambda.core.mgr.workflow.component.ComponentMgr;
import com.yatop.lambda.core.mgr.workflow.component.characteristic.CharOptionMgr;
import com.yatop.lambda.core.mgr.workflow.component.characteristic.CharacteristicMgr;
import com.yatop.lambda.core.mgr.workflow.component.characteristic.CharTypeMgr;
import com.yatop.lambda.core.mgr.workflow.component.characteristic.CharTypeWildMgr;
import com.yatop.lambda.core.mgr.workflow.component.specification.SpecCharRelMgr;
import com.yatop.lambda.core.mgr.workflow.component.specification.SpecCharValueMgr;
import com.yatop.lambda.core.mgr.workflow.component.specification.SpecificationMgr;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.richmodel.workflow.component.CmptAlgorithm;
import com.yatop.lambda.workflow.core.richmodel.workflow.component.CmptCharValue;
import com.yatop.lambda.workflow.core.richmodel.workflow.component.Component;
import com.yatop.lambda.workflow.core.richmodel.workflow.component.characteristic.CharType;
import com.yatop.lambda.workflow.core.richmodel.workflow.component.characteristic.CmptChar;
import com.yatop.lambda.workflow.core.richmodel.workflow.component.characteristic.CharOption;
import com.yatop.lambda.workflow.core.richmodel.workflow.component.specification.CmptSpec;
import com.yatop.lambda.workflow.core.richmodel.workflow.component.specification.SpecCharValue;
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
    private CharOptionMgr charOptionMgr;

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

    @Override
    public void afterPropertiesSet() throws Exception {
        loadComponentConfiguration();
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
        List<WfCfgCharType> typeList = charTypeMgr.queryCharType();
        if(DataUtil.isEmpty(typeList)) {
            logger.error(String.format("Loading component configuration occurs fatal error -- Empty characteristic type configuration."));
            System.exit(-1);
        }

        for(WfCfgCharType type : typeList) {
            CharType richType = new CharType(type);

            IsWildTypeEnum wildTypeEnum = IsWildTypeEnum.valueOf(richType.data().getIsWildtype());
            if(DataUtil.isNull(wildTypeEnum)) {
                logger.error(String.format("Loading component configuration occurs fatal error -- Error Is-WildType:\n%s.",
                        DataUtil.toPrettyJSONString(type)));
                System.exit(-1);
            }
            if(wildTypeEnum.getMark() == IsWildTypeEnum.YES.getMark()) {
                wildTypeCounter++;
            }
            if(!SpecMaskEnum.isCorrectMask(richType.data().getSpecMask())) {
                logger.error(String.format("Loading component configuration occurs fatal error -- Error Spec-Mask:\n%s.",
                        DataUtil.toPrettyJSONString(type)));
                System.exit(-1);
            }

            richType.getCharTypeClazzBean();
            ALL_CHARACTERISTIC_TYPES.put(richType.data().getCharTypeId(), richType);
            ALL_CHARACTERISTIC_TYPES_BY_CODE.put(richType.data().getCharTypeCode(), richType);
        }
        typeList.clear();

        if(wildTypeCounter > 0) {
            List<WfCfgCharTypeWild> matchTypeList = charTypeWildMgr.queryCharTypeWild();
            if (DataUtil.isEmpty(matchTypeList)) {
                logger.error(String.format("Loading component configuration occurs fatal error -- Empty characteristic type wild match configuration."));
                System.exit(-1);
            }

            for (WfCfgCharTypeWild match : matchTypeList) {
                CharType targetCharType = ALL_CHARACTERISTIC_TYPES.get(match.getDstCharTypeId());
                if (DataUtil.isNull(targetCharType)) {
                    logger.error(String.format("Loading component configuration occurs fatal error -- Destination port characteristic type not found:\n%s.",
                            DataUtil.toPrettyJSONString(match)));
                    System.exit(-1);
                }
                if (targetCharType.data().getIsWildtype() != IsWildTypeEnum.YES.getMark()) {
                    logger.error(String.format("Loading component configuration occurs fatal error -- Destination port characteristic type info error:\n%s.",
                            DataUtil.toPrettyJSONString(match)));
                    System.exit(-1);
                }
                if (!SpecMaskEnum.matchInput(targetCharType.data().getSpecMask())) {
                    logger.error(String.format("Loading component configuration occurs fatal error -- Destination port characteristic type's spec-mask error:\n%s.",
                            DataUtil.toPrettyJSONString(match)));
                    System.exit(-1);
                }
                CharType sourceCharType = ALL_CHARACTERISTIC_TYPES.get(match.getSrcCharTypeId());
                if (DataUtil.isNull(sourceCharType)) {
                    logger.error(String.format("Loading component configuration occurs fatal error -- Source port characteristic type not found:\n%s.",
                            DataUtil.toPrettyJSONString(match)));
                    System.exit(-1);
                }
                if ( targetCharType.data().getIsWildtype() != IsWildTypeEnum.YES.getMark()
                        ? !SpecMaskEnum.matchOutput(sourceCharType.data().getSpecMask())
                        : !SpecMaskEnum.matchInputOrOutput(sourceCharType.data().getSpecMask())) {
                    logger.error(String.format("Loading component configuration occurs fatal error -- Source port characteristic type's spec-mask error:\n%s.",
                            DataUtil.toPrettyJSONString(match)));
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
            if(SpecMaskEnum.matchOutput(sourceCharType.data().getSpecMask())) {

                TreeMap<Integer, CharType> expandedTargetCharTypes = new TreeMap<Integer, CharType>();
                expandedTargetCharTypes.put(sourceCharType.data().getCharTypeId(), sourceCharType);
                expandedTargetCharTypesCache.put(sourceCharType.data().getCharTypeId(), expandedTargetCharTypes);

                expandSourcePortTargetCharType(sourceCharType.getMatchTargetTypes(), expandedTargetCharTypes);
            }
        }

        for(Map.Entry<Integer, TreeMap<Integer, CharType>> entry : expandedTargetCharTypesCache.entrySet()) {
            CharType sourceCharType = ALL_CHARACTERISTIC_TYPES.get(entry.getKey());
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

        List<WfCfgCharacteristic> charList = characteristicMgr.queryCharacteristic();
        if(DataUtil.isEmpty(charList)) {
            logger.error(String.format("Loading component configuration occurs fatal error -- Empty characteristic configuration."));
            System.exit(-1);
        }

        for(WfCfgCharacteristic cmptChar : charList) {

            CharType charType =  ALL_CHARACTERISTIC_TYPES.get(cmptChar.getCharType());
            if(DataUtil.isNull(charType)) {
                logger.error(String.format("Loading component configuration occurs fatal error -- Characteristic type not found:\n%s.",
                        DataUtil.toPrettyJSONString(cmptChar)));
                System.exit(-1);
            }

            CmptChar richChar = new CmptChar(cmptChar, charType);
            ALL_CHARACTERISTICS.put(richChar.data().getCharId(), richChar);

            SpecTypeEnum specType = SpecTypeEnum.valueOf(richChar.data().getSpecType());
            if(DataUtil.isNull(specType)) {
                logger.error(String.format("Loading component configuration occurs fatal error -- Unknown Spec-Type:\n%s.",
                        DataUtil.toPrettyJSONString(cmptChar)));
                System.exit(-1);
            }

            if(!SpecMaskEnum.isCorrectFitSpecType(charType.data().getSpecMask(), specType)) {
                logger.error(String.format("Loading component configuration occurs fatal error -- Incorrect Spec-Type:\n%s.",
                        DataUtil.toPrettyJSONString(cmptChar)));
                System.exit(-1);
            }

            if(DataUtil.isNull(SourceLevelEnum.valueOf(richChar.data().getSrcLevel()))) {
                logger.error(String.format("Loading component configuration occurs fatal error -- Unknown Src-Level:\n%s.",
                        DataUtil.toPrettyJSONString(cmptChar)));
                System.exit(-1);
            }

            if((specType.getType() == SpecTypeEnum.INPUT.getType() || specType.getType() == SpecTypeEnum.OUTPUT.getType())
                    && richChar.data().getSrcLevel() != SourceLevelEnum.WORKFLOW.getSource()) {
                logger.error(String.format("Loading component configuration occurs fatal error -- Error Src-Level(input & output must be workflow-source-level):\n%s.",
                        DataUtil.toPrettyJSONString(cmptChar)));
                System.exit(-1);
            }

            if(specType.getType() == SpecTypeEnum.EXECUTION.getType() && richChar.data().getSrcLevel() == SourceLevelEnum.WORKFLOW.getSource()) {
                logger.error(String.format("Loading component configuration occurs fatal error -- Error Src-Level(forbid execution to be workflow-source-level):\n%s.",
                        DataUtil.toPrettyJSONString(cmptChar)));
                System.exit(-1);
            }

            if(DataUtil.isNull(IsRequiredEnum.valueOf(richChar.data().getIsRequired()))) {
                logger.error(String.format("Loading component configuration occurs fatal error -- Unknown Is-Required:\n%s.",
                        DataUtil.toPrettyJSONString(cmptChar)));
                System.exit(-1);
            }

            if(DataUtil.isNull(IsLimitedEnum.valueOf(richChar.data().getIsLimited()))) {
                logger.error(String.format("Loading component configuration occurs fatal error -- Unknown Is-Limited:\n%s.",
                        DataUtil.toPrettyJSONString(cmptChar)));
                System.exit(-1);
            }

            if(cmptChar.getIsLimited() == IsLimitedEnum.ENUMERATION.getMark())
                enumCharCounter++;
        }
        charList.clear();

        if(enumCharCounter > 0) {
            List<WfCfgCharOption> optionList = charOptionMgr.queryCharEnum();
            if(DataUtil.isEmpty(optionList)) {
                logger.error(String.format("Loading component configuration occurs fatal error -- Empty characteristic option configuration."));
                System.exit(-1);
            }

            for(WfCfgCharOption charEnum : optionList) {
                CharOption richCharOption = new CharOption(charEnum);
                CmptChar cmptChar = ALL_CHARACTERISTICS.get(richCharOption.data().getCharId());
                if(DataUtil.isNotNull(cmptChar)) {
                    cmptChar.putOption(richCharOption);
                } else {
                    logger.error(String.format("Loading component configuration occurs fatal error -- Owner characteristic not found:\n%s.",
                            DataUtil.toPrettyJSONString(charEnum)));
                    System.exit(-1);
                }
            }
            optionList.clear();
        }
    }

    private void loadSpecificationConfig() {
        List<WfCfgSpecification> specList = specificationMgr.querySpecification();
        if(DataUtil.isEmpty(specList)) {
            logger.error(String.format("Loading component configuration occurs fatal error -- Empty specification configuration."));
            System.exit(-1);
        }

        for(WfCfgSpecification cmptSpec : specList) {
            CmptSpec richSpec = new CmptSpec(cmptSpec);
            if(DataUtil.isNull(SpecTypeEnum.valueOf(richSpec.data().getSpecType()))) {
                logger.error(String.format("Loading component configuration occurs fatal error -- Unknown Spec-Type:\n%s.",
                        DataUtil.toPrettyJSONString(cmptSpec)));
                System.exit(-1);
            }

            ALL_SPECIFICATIONS.put(richSpec.data().getSpecId(), richSpec);
        }
        specList.clear();

        List<WfCfgSpecCharRel> specCharRelList = specCharRelMgr.querySpecCharRel();
        if(DataUtil.isEmpty(specCharRelList)) {
            logger.error(String.format("Loading component configuration occurs fatal error -- Empty Spec-Char-Rel configuration."));
            System.exit(-1);
        }

        for(WfCfgSpecCharRel rel : specCharRelList) {
            CmptSpec cmptSpec = ALL_SPECIFICATIONS.get(rel.getSpecId());
            if(DataUtil.isNull(cmptSpec)) {
                logger.error(String.format("Loading component configuration occurs fatal error -- Specification not found:\n%s.",
                        DataUtil.toPrettyJSONString(rel)));
                System.exit(-1);
            }
            CmptChar cmptChar = ALL_CHARACTERISTICS.get(rel.getCharId());
            if(DataUtil.isNull(cmptChar)) {
                logger.error(String.format("Loading component configuration occurs fatal error -- Characteristic not found:\n%s.",
                        DataUtil.toPrettyJSONString(rel)));
                System.exit(-1);
            }
            if(cmptChar.data().getSpecType() != cmptChar.data().getSpecType()) {
                logger.error(String.format("Loading component configuration occurs fatal error -- Error Spec-Char-Rel:\n%s.",
                        DataUtil.toPrettyJSONString(rel)));
                System.exit(-1);
            }

            CmptChar findChar = cmptSpec.getCmptCharByCode(cmptChar.data().getCharCode());
            if(DataUtil.isNotNull(findChar)) {
                logger.error(String.format("Loading component configuration occurs fatal error -- " +
                        "Characteristic code conflict:\n===Specification===%s\n===This Characteristic===%s\n===That Characteristic===%s.",
                        DataUtil.toPrettyJSONString(cmptSpec.data()),DataUtil.toPrettyJSONString(findChar.data()), DataUtil.toPrettyJSONString(cmptChar.data())));
                System.exit(-1);
            }

            cmptSpec.putCmptChar(cmptChar);
        }
        specCharRelList.clear();

        List<WfCfgSpecCharValue> charValueList = specCharValueMgr.querySpecCharValue();
        if (DataUtil.isNotEmpty(charValueList)) {

            for (WfCfgSpecCharValue value : charValueList) {
                CmptSpec cmptSpec = ALL_SPECIFICATIONS.get(value.getSpecId());
                if (DataUtil.isNull(cmptSpec)) {
                    logger.error(String.format("Loading component configuration occurs fatal error -- Specification not found:\n%s.",
                            DataUtil.toPrettyJSONString(value)));
                    System.exit(-1);
                }

                if(cmptSpec.data().getSpecType() == SpecTypeEnum.INPUT.getType() || cmptSpec.data().getSpecType() == SpecTypeEnum.OUTPUT.getType()) {
                    logger.error(String.format("Loading component configuration occurs fatal error -- Spec-Char-Value error(forbid input & output value):\n%s.",
                            DataUtil.toPrettyJSONString(value)));
                    System.exit(-1);
                }

                CmptChar cmptChar = cmptSpec.getCmptChar(value.getCharId());
                if (DataUtil.isNull(cmptChar)) {
                    logger.error(String.format("Loading component configuration occurs fatal error -- Spec-Char-Rel not found:\n%s.",
                            DataUtil.toPrettyJSONString(value)));
                    System.exit(-1);
                }
                if (DataUtil.isNull(IsSystemParamEnum.valueOf(value.getIsSystemParam()))) {
                    logger.error(String.format("Loading component configuration occurs fatal error -- Unknown Is-System-Param:\n%s.",
                            DataUtil.toPrettyJSONString(value)));
                    System.exit(-1);
                }

                cmptSpec.putCharValue(new SpecCharValue(value));
            }
        }
    }

    private void loadComponentConfig() {
        List<WfCfgAlgorithm> algorithmList = algorithmMgr.queryAlgorithm();
        if(DataUtil.isEmpty(algorithmList)) {
            logger.error(String.format("Loading component configuration occurs fatal error -- Empty algorithm configuration."));
            System.exit(-1);
        }

        for(WfCfgAlgorithm algorithm : algorithmList) {
            CmptAlgorithm richAlgorithm = new CmptAlgorithm(algorithm);
            if (DataUtil.isNull(AlgorithmTypeEnum.valueOf(richAlgorithm.data().getAlgorithmType()))) {
                logger.error(String.format("Loading component configuration occurs fatal error -- Unknown Algorithm-Type:\n%s.",
                        DataUtil.toPrettyJSONString(algorithm)));
                System.exit(-1);
            }

            ALL_ALGORITHMS.put(richAlgorithm.data().getAlgorithmId(), richAlgorithm);
            ALL_ALGORITHMS_BY_CODE.put(richAlgorithm.data().getAlgorithmCode(), richAlgorithm);
        }
        algorithmList.clear();

        List<WfCfgComponent> componentList = componentMgr.queryComponent();
        if(DataUtil.isEmpty(componentList)) {
            logger.error(String.format("Loading component configuration occurs fatal error -- Empty component configuration."));
            System.exit(-1);
        }

        for(WfCfgComponent component : componentList) {
            Component richComponent = new Component(component);
            if (DataUtil.isNull(CmptTypeEnum.valueOf(richComponent.data().getCmptType()))) {
                logger.error(String.format("Loading component configuration occurs fatal error -- Unknown Cmpt-Type:\n%s.",
                        DataUtil.toPrettyJSONString(component)));
                System.exit(-1);
            }

            if(richComponent.data().getRelAlgorithmId() > 0) {
                CmptAlgorithm algorithm = ALL_ALGORITHMS.get(richComponent.data().getRelAlgorithmId());
                if (DataUtil.isNull(algorithm)) {
                    logger.error(String.format("Loading component configuration occurs fatal error -- Algorithm not found:\n%s.",
                            DataUtil.toPrettyJSONString(component)));
                    System.exit(-1);
                }
                richComponent.setAlgorithm(algorithm);
            }
            ALL_COMPONENTS.put(richComponent.data().getCmptId(), richComponent);
            ALL_COMPONENTS_BY_CODE.put(richComponent.data().getCmptCode(), richComponent);
        }
        componentList.clear();

        List<WfCfgCmptSpecRel> cmptSpecRelList = cmptSpecRelMgr.queryCmptSpecRel();
        if(DataUtil.isEmpty(cmptSpecRelList)) {
            logger.error(String.format("Loading component configuration occurs fatal error -- Empty Cmpt-Spec-Rel configuration."));
            System.exit(-1);
        }

        for(WfCfgCmptSpecRel rel : cmptSpecRelList) {
            Component component = ALL_COMPONENTS.get(rel.getCmptId());
            if(DataUtil.isNull(component)) {
                logger.error(String.format("Loading component configuration occurs fatal error -- Component not found:\n%s.",
                        DataUtil.toPrettyJSONString(rel)));
                System.exit(-1);
            }
            CmptSpec cmptSpec = ALL_SPECIFICATIONS.get(rel.getSpecId());
            if(DataUtil.isNull(cmptSpec)) {
                logger.error(String.format("Loading component configuration occurs fatal error -- Specification not found:\n%s.",
                        DataUtil.toPrettyJSONString(rel)));
                System.exit(-1);
            }

            if(DataUtil.isNull(SpecTypeEnum.valueOf(rel.getSpecType()))) {
                logger.error(String.format("Loading component configuration occurs fatal error -- Unknown Spec-Type:\n%s.",
                        DataUtil.toPrettyJSONString(rel)));
                System.exit(-1);
            }

            if(rel.getSpecType() != cmptSpec.data().getSpecType()) {
                logger.error(String.format("Loading component configuration occurs fatal error -- Error Spec-Type:\n%s.",
                        DataUtil.toPrettyJSONString(rel)));
                System.exit(-1);
            }

            component.setCmptSpec(cmptSpec);
        }
        cmptSpecRelList.clear();

        List<WfCfgCmptCharValue> charValueList = cmptCharValueMgr.queryCmptCharValue();
        if (DataUtil.isNotEmpty(charValueList)) {

            for (WfCfgCmptCharValue value : charValueList) {
                Component component = ALL_COMPONENTS.get(value.getCmptId());
                if (DataUtil.isNull(component)) {
                    logger.error(String.format("Loading component configuration occurs fatal error -- Component not found:\n%s.",
                            DataUtil.toPrettyJSONString(value)));
                    System.exit(-1);
                }
                CmptChar cmptChar = ALL_CHARACTERISTICS.get(value.getCharId());
                if (DataUtil.isNull(cmptChar)) {
                    logger.error(String.format("Loading component configuration occurs fatal error -- Characteristic not found:\n%s.",
                            DataUtil.toPrettyJSONString(value)));
                    System.exit(-1);
                }
                CmptSpec cmptSpec = component.getCmptSpec(SpecTypeEnum.valueOf(cmptChar.data().getSpecType()));
                if (DataUtil.isNull(cmptSpec)) {
                    logger.error(String.format("Loading component configuration occurs fatal error -- Spec-Char-Rel not found:\n%s.",
                            DataUtil.toPrettyJSONString(value)));
                    System.exit(-1);
                }

                if(cmptSpec.data().getSpecType() == SpecTypeEnum.INPUT.getType() || cmptSpec.data().getSpecType() == SpecTypeEnum.OUTPUT.getType()) {
                    logger.error(String.format("Loading component configuration occurs fatal error -- Cmpt-Char-Value error(forbid input & output value):\n%s.",
                            DataUtil.toPrettyJSONString(value)));
                    System.exit(-1);
                }

                if (DataUtil.isNull(IsSystemParamEnum.valueOf(value.getIsSystemParam()))) {
                    logger.error(String.format("Loading component configuration occurs fatal error -- Unknown Is-System-Param:\n%s.",
                            DataUtil.toPrettyJSONString(value)));
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
                for (CmptChar cmptChar : execSpec.getCmptChars()) {
                    if (component.missingConfigCharValue(cmptChar)) {
                        logger.error(String.format("Check execution config occurs fatal error -- " +
                                "config-char-value not found:\n===Component===\n%s\n===CmptChar===\n%s.",
                                DataUtil.toPrettyJSONString(component.data()), DataUtil.toPrettyJSONString(cmptChar.data())));
                        System.exit(-1);
                    }
                }
            }

            //optimize execution
            CmptSpec o$execSpec = component.getOptimizeExecution();
            if(component.haveOptimizeExecutionContent()) {
                for (CmptChar cmptChar : o$execSpec.getCmptChars()) {
                    if (component.missingConfigCharValue(cmptChar)) {
                        logger.error(String.format("Check optimize execution config occurs fatal error -- " +
                                "config-char-value not found:\n===Component===\n%s\n===CmptChar===\n%s.",
                                DataUtil.toPrettyJSONString(component.data()), DataUtil.toPrettyJSONString(cmptChar.data())));
                        System.exit(-1);
                    }
                }
            }

            if(component.haveParameterContnent()) {
                //parameter
                CmptSpec paramSpec = component.getParameter();
                for (CmptChar cmptChar : component.getParameter().getCmptChars()) {
                    if (component.missingConfigCharValue(cmptChar)) {
                        logger.error(String.format("Check parameter config occurs fatal error -- " +
                                "config-char-value not found:\n===Component===\n%s\n===CmptChar===\n%s.",
                                DataUtil.toPrettyJSONString(component.data()), DataUtil.toPrettyJSONString(cmptChar.data())));
                        System.exit(-1);
                    }

                    if(DataUtil.isNotNull(o$execSpec) && DataUtil.isNotNull(o$execSpec.getCmptCharByCode(cmptChar.data().getCharCode()))) {
                        logger.error(String.format("Check parameter config occurs fatal error -- " +
                                "parameter char-code conflict vs optimize execution parameter:\n===Component===\n%s\n===CmptChar===\n%s.",
                                DataUtil.toPrettyJSONString(component.data()), DataUtil.toPrettyJSONString(cmptChar.data())));
                        System.exit(-1);
                    }
                }
            }
        }
    }
}
