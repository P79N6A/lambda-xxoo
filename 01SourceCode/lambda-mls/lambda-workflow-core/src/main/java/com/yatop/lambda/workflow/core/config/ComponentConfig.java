package com.yatop.lambda.workflow.core.config;

import com.yatop.lambda.base.model.CfCmptChar;
import com.yatop.lambda.base.model.CfCmptCharEnum;
import com.yatop.lambda.base.model.CfCmptCharType;
import com.yatop.lambda.base.model.CfCmptCharTypeWild;
import com.yatop.lambda.core.enums.IsLimitedEnum;
import com.yatop.lambda.core.mgr.component.CmptCharValueMgr;
import com.yatop.lambda.core.mgr.component.CmptSpecRelMgr;
import com.yatop.lambda.core.mgr.component.ComponentMgr;
import com.yatop.lambda.core.mgr.component.characteristic.CmptCharEnumMgr;
import com.yatop.lambda.core.mgr.component.characteristic.CmptCharMgr;
import com.yatop.lambda.core.mgr.component.characteristic.CmptCharTypeMgr;
import com.yatop.lambda.core.mgr.component.characteristic.CmptCharTypeWildMgr;
import com.yatop.lambda.core.mgr.component.specification.CmptSpecCharRelMgr;
import com.yatop.lambda.core.mgr.component.specification.CmptSpecCharValueMgr;
import com.yatop.lambda.core.mgr.component.specification.CmptSpecMgr;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.richmodel.component.CmptAlgorithm;
import com.yatop.lambda.workflow.core.richmodel.component.Component;
import com.yatop.lambda.workflow.core.richmodel.component.characteristic.CmptChar;
import com.yatop.lambda.workflow.core.richmodel.component.characteristic.CmptCharEnum;
import com.yatop.lambda.workflow.core.richmodel.component.characteristic.CmptCharType;
import com.yatop.lambda.workflow.core.richmodel.component.specification.CmptSpec;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class ComponentConfig implements InitializingBean {

    public static Logger logger = LoggerFactory.getLogger(ComponentConfig.class);

    @Autowired
    ComponentMgr componentMgr;

    @Autowired
    CmptAlgorithm cmptAlgorithm;

    @Autowired
    CmptSpecRelMgr cmptSpecRelMgr;

    @Autowired
    CmptCharValueMgr cmptCharValueMgr;

    @Autowired
    CmptSpecMgr cmptSpecMgr;

    @Autowired
    CmptSpecCharRelMgr cmptSpecCharRelMgr;

    @Autowired
    CmptSpecCharValueMgr cmptSpecCharValueMgr;

    @Autowired
    CmptCharMgr cmptCharMgr;

    @Autowired
    CmptCharEnumMgr cmptCharEnumMgr;

    @Autowired
    CmptCharTypeMgr cmptCharTypeMgr;

    @Autowired
    CmptCharTypeWildMgr cmptCharTypeWildMgr;

    private static HashMap<String, Component> ALL_COMPONENTS = new HashMap<String, Component>();    //计算组件
    private static HashMap<String, CmptSpec> ALL_SPECIFICATIONS = new HashMap<String, CmptSpec>();  //计算组件规格
    private static HashMap<String, CmptChar> ALL_CHARACTERISTICS = new HashMap<String, CmptChar>(); //计算组件特征
    private static HashMap<Integer, CmptCharType> ALL_CHARACTERISTIC_TYPES = new HashMap<Integer, CmptCharType>(); //计算组件特征类型

    @Override
    public void afterPropertiesSet() throws Exception {
        loadComponentConfiguration();
    }

    private void loadComponentConfiguration() {

        //特征类型相关
        {
            List<CfCmptCharType> typeList = cmptCharTypeMgr.queryCharType();
            if(DataUtil.isEmpty(typeList)) {
                logger.error(String.format("Loading component configuration occurs fatal error -- Empty characteristic type configuration."));
                System.exit(-1);
            }

            for(CfCmptCharType type : typeList) {
                CmptCharType richType = new CmptCharType(type);
                ALL_CHARACTERISTIC_TYPES.put(richType.getCharTypeId(), richType);
            }


            List<CfCmptCharTypeWild> matchList = cmptCharTypeWildMgr.queryCharTypeWild();
            if(DataUtil.isEmpty(matchList)) {
                logger.error(String.format("Loading component configuration occurs fatal error -- Empty characteristic type wild match configuration."));
                System.exit(-1);
            }

            for(CfCmptCharTypeWild match : matchList) {
                CmptCharType charType = ALL_CHARACTERISTIC_TYPES.get(match.getWildCharTypeId());
                if(DataUtil.isNotNull(charType)) {
                    charType.addMatchType(match.getMatchCharTypeId());
                } else {
                    logger.error(String.format("Loading component configuration occurs fatal error -- Owner characteristic type not found:\n%s.", DataUtil.prettyFormat(match.toJSON())));
                    System.exit(-1);
                }
            }

        }

        //特征相关
        {
            long enumCharCounter = 0L;

            List<CfCmptChar> cmptCharList = cmptCharMgr.queryCharacteristic();
            if(DataUtil.isEmpty(cmptCharList)) {
                logger.error(String.format("Loading component configuration occurs fatal error -- Empty characteristic configuration."));
                System.exit(-1);
            }

            for(CfCmptChar cmptChar : cmptCharList) {
                CmptChar richCmptChar = new CmptChar(cmptChar);
                ALL_CHARACTERISTICS.put(richCmptChar.getCharId(), richCmptChar);

                if(cmptChar.getIsLimited() == IsLimitedEnum.ENUMERATION.getMark())
                    enumCharCounter++;
            }

            if(enumCharCounter > 0) {
                List<CfCmptCharEnum> cmptCharEnum = cmptCharEnumMgr.queryCharEnum();
                if(DataUtil.isEmpty(cmptCharList)) {
                    logger.error(String.format("Loading component configuration occurs fatal error -- Empty characteristic enumeration configuration."));
                    System.exit(-1);
                }

                for(CfCmptCharEnum cmpCharEnum : cmptCharEnum) {
                    CmptCharEnum richCmptCharEnum = new CmptCharEnum(cmpCharEnum);
                    //ALL_CHARACTERISTICS.put(richCmptChar.getCharId(), richCmptChar);
                }
            }

        }

        //规格相关

        //组件相关
    }
}
