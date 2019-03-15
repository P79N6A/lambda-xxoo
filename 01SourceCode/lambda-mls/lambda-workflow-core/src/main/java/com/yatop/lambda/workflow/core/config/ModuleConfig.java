package com.yatop.lambda.workflow.core.config;

import com.yatop.lambda.base.model.*;
import com.yatop.lambda.core.enums.ModuleTypeEnum;
import com.yatop.lambda.core.enums.PortTypeEnum;
import com.yatop.lambda.core.enums.SpecMaskEnum;
import com.yatop.lambda.core.enums.SpecTypeEnum;
import com.yatop.lambda.core.mgr.workflow.module.*;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.richmodel.workflow.component.Component;
import com.yatop.lambda.workflow.core.richmodel.workflow.component.characteristic.CharType;
import com.yatop.lambda.workflow.core.richmodel.workflow.component.characteristic.CmptChar;
import com.yatop.lambda.workflow.core.richmodel.workflow.module.*;
import com.yatop.lambda.workflow.core.utils.CollectionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ModuleConfig implements InitializingBean {

    public static Logger logger = LoggerFactory.getLogger(ModuleConfig.class);

    @Autowired
    private ModuleCatalogMgr moduleCatalogMgr;

    @Autowired
    private ModuleMgr moduleMgr;

    @Autowired
    private ModulePortMgr modulePortMgr;

    @Autowired
    private ModulePropCtrlMgr modulePropCtrlMgr;

    @Autowired
    private ModulePropCtrlRelMgr modulePropCtrlRelMgr;

    @Autowired
    private ModulePropTabMgr modulePropTabMgr;

    @Autowired
    private ComponentConfig componentConfig;

    private TreeMap<Long, ModuleCatalog> ALL_MODULE_CATALOGS = new TreeMap<Long, ModuleCatalog>();       //工作流组件目录
    private TreeMap<Long, Module> ALL_MODULES = new TreeMap<Long, Module>();                             //工作流组件
    private HashMap<String, Module> ALL_MODULES_BY_CODE = new HashMap<String, Module>();                             //工作流组件（按组件代码）
    private HashMap<Long, ModulePort> ALL_MODULE_PORTS = new HashMap<Long, ModulePort>();         //工作流组件端口
    private TreeMap<Integer, CharType> ALL_OUTPUT_PORTS_MATCH_TABLE = new TreeMap<Integer, CharType>();   //key: charTypeId, 工作流组件输出端口特征类型的输入输出匹配

    public List<ModuleCatalog> getAllCatalogs() {
        return CollectionUtil.toList(ALL_MODULE_CATALOGS);
    }

    public ModuleCatalog getRootCatalog() {
        return getCatalog(0L);
    }

    public ModuleCatalog getCatalog(Long catalogId) {
        return CollectionUtil.get(ALL_MODULE_CATALOGS, catalogId);
    }

    public List<Module> getAllCatalogModules() {
        List<Module> vlist = new ArrayList<Module>(ALL_MODULES.size());
        for(Map.Entry<Long, Module> entry : ALL_MODULES.entrySet()) {
            if(entry.getValue().data().getCatalogId() > 0)
                vlist.add(entry.getValue());
        }
        return vlist;
    }

    public Module getModule(Long moduleId) {
        return CollectionUtil.get(ALL_MODULES, moduleId);
    }

    public Module getModuleByCode(String moduleCode) {
        return CollectionUtil.get(ALL_MODULES_BY_CODE, moduleCode);
    }

    public ModulePort getModulePort(Long portId) {
        return CollectionUtil.get(ALL_MODULE_PORTS, portId);
    }

    public List<CharType> getOutputPortsMatchTable() {
        return CollectionUtil.toList(ALL_OUTPUT_PORTS_MATCH_TABLE);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        loadModuleConfiguration();
    }

    public void loadModuleConfiguration() {
        //工作流组件目录
        {
            List<WfCfgModuleCatalog> catalogList = moduleCatalogMgr.queryModuleCatalog();
            if(DataUtil.isEmpty(catalogList)) {
                logger.error(String.format("Loading module configuration occurs fatal error -- Empty module catalog configuration."));
                System.exit(-1);
            }

            for (WfCfgModuleCatalog catalog : catalogList) {
                ModuleCatalog richCatalog = new ModuleCatalog(catalog);
                ALL_MODULE_CATALOGS.put(richCatalog.data().getCatalogId(), richCatalog);
            }
            catalogList.clear();

            for (Map.Entry<Long, ModuleCatalog>  entry : ALL_MODULE_CATALOGS.entrySet()) {
                if(entry.getValue().data().getParentCatalogId() >= 0) {
                    ModuleCatalog parentCatalog = ALL_MODULE_CATALOGS.get(entry.getValue().data().getParentCatalogId());
                    if (DataUtil.isNotNull(parentCatalog)) {
                        parentCatalog.putChildCatalog(entry.getValue());
                    } else {
                        logger.error(String.format("Loading module configuration occurs fatal error -- Parent module catalog not found:\n%s",
                                DataUtil.toPrettyJSONString(entry.getValue().data())));
                        System.exit(-1);
                    }
                }
            }
        }
        //工作流组件
        {
            List<WfCfgModule> moduleList = moduleMgr.queryModule();
            if(DataUtil.isEmpty(moduleList)) {
                logger.error(String.format("Loading module configuration occurs fatal error -- Empty module configuration."));
                System.exit(-1);
            }

            for (WfCfgModule module : moduleList) {

                ModuleTypeEnum moduleTypeEnum = ModuleTypeEnum.valueOf(module.getModuleType());
                if(DataUtil.isNull(moduleTypeEnum)) {
                    logger.error(String.format("Loading module configuration occurs fatal error -- Unknown module type:\n%s.",
                            DataUtil.toPrettyJSONString(module)));
                    System.exit(-1);
                }

                if(moduleTypeEnum == ModuleTypeEnum.NON_WORKFLOW_MODULE && module.getCatalogId() > 0) {
                    logger.error(String.format("Loading module configuration occurs fatal error -- Error module-type vs catalog-id:\n%s.",
                            DataUtil.toPrettyJSONString(module)));
                    System.exit(-1);
                }

                Component component =  componentConfig.getComponent(module.getPkgCmptId());
                if(DataUtil.isNull(component)) {
                    logger.error(String.format("Loading module configuration occurs fatal error -- Component not found:\n%s.",
                            DataUtil.toPrettyJSONString(module)));
                    System.exit(-1);
                }

                if(moduleTypeEnum == ModuleTypeEnum.NON_WORKFLOW_MODULE && component.haveInputContent()) {
                    logger.error(String.format("Loading module configuration occurs fatal error -- Forbid have input content:\n%s.",
                            DataUtil.toPrettyJSONString(module)));
                    System.exit(-1);
                }

                Module richModule = new Module(module, component);
                richModule.getModuleClazzBean();
                ALL_MODULES.put(richModule.data().getModuleId(), richModule);
                ALL_MODULES_BY_CODE.put(richModule.data().getModuleCode(), richModule);

                if(richModule.data().getCatalogId() > 0) {
                    ModuleCatalog catalog = ALL_MODULE_CATALOGS.get(richModule.data().getCatalogId());
                    if(DataUtil.isNotNull(catalog)) {
                        catalog.putChildModule(richModule);
                    } else {
                        logger.error(String.format("Loading module configuration occurs fatal error -- Owner module catalog not found:\n%s",
                                DataUtil.toPrettyJSONString(richModule.data())));
                        System.exit(-1);
                    }
                }
            }
            moduleList.clear();
        }
        //工作流组件端口
        {
            List<WfCfgModulePort> portList = modulePortMgr.queryModulePort();
            if(DataUtil.isEmpty(portList)) {
                logger.error(String.format("Loading module configuration occurs fatal error -- Empty module port configuration."));
                System.exit(-1);
            }

            for (WfCfgModulePort port : portList) {
                PortTypeEnum portTypeEnum = PortTypeEnum.valueOf(port.getPortType());
                if(DataUtil.isNull(portTypeEnum)) {
                    logger.error(String.format("Loading module configuration occurs fatal error -- Error port type:\n%s.",
                            DataUtil.toPrettyJSONString(port)));
                    System.exit(-1);
                }
                CmptChar cmptChar =  componentConfig.getCharacteristic(port.getBindCharId());
                if(DataUtil.isNull(cmptChar)) {
                    logger.error(String.format("Loading module configuration occurs fatal error -- Characteristic not found:\n%s.",
                            DataUtil.toPrettyJSONString(port)));
                    System.exit(-1);
                }
                if(!portTypeEnum.isCorrectPortType(SpecTypeEnum.valueOf(cmptChar.data().getSpecType()))) {
                    logger.error(String.format("Loading module configuration occurs fatal error -- Error port-type vs spec-type:\n%s\n%s.",
                            DataUtil.toPrettyJSONString(port), DataUtil.toPrettyJSONString(cmptChar.data())));
                    System.exit(-1);
                }
                Module module =  ALL_MODULES.get(port.getOwnerModuleId());
                if(DataUtil.isNull(module)) {
                    logger.error(String.format("Loading module configuration occurs fatal error -- Module not found:\n%s.",
                            DataUtil.toPrettyJSONString(port)));
                    System.exit(-1);
                }
                if(module.data().getModuleType() == ModuleTypeEnum.NON_WORKFLOW_MODULE.getType()) {
                    logger.error(String.format("Loading module configuration occurs fatal error -- Forbid non-workflow-module hold input/output port:\n%s.",
                            DataUtil.toPrettyJSONString(port)));
                    System.exit(-1);
                }
                if(!module.getComponent().existsCmptChar(cmptChar)) {
                    logger.error(String.format("Loading module configuration occurs fatal error -- Port-Char not found in Module's Package-Component :\n%s\n%s\n%s.",
                            DataUtil.toPrettyJSONString(port), DataUtil.toPrettyJSONString(cmptChar.data()), DataUtil.toPrettyJSONString(module.data())));
                    System.exit(-1);
                }

                ModulePort richPort = new ModulePort(port, cmptChar);
                ALL_MODULE_PORTS.put(port.getPortId(), richPort);
                switch (portTypeEnum) {
                    case INPUT_PORT: {
                        if(!SpecMaskEnum.matchInput(cmptChar.getType().data().getSpecMask())) {
                            logger.error(String.format("Loading module configuration occurs fatal error -- port-char-type not match input mask:\n%s\n%s.",
                                    DataUtil.toPrettyJSONString(port), DataUtil.toPrettyJSONString(cmptChar.data())));
                            System.exit(-1);
                        }
                        module.putInputPort(richPort);
                        break;
                    }
                    case OUTPUT_PORT: {
                        if(!SpecMaskEnum.matchOutput(cmptChar.getType().data().getSpecMask())) {
                            logger.error(String.format("Loading module configuration occurs fatal error -- port-char-type not match output mask:\n%s\n%s.",
                                    DataUtil.toPrettyJSONString(port), DataUtil.toPrettyJSONString(cmptChar.data())));
                            System.exit(-1);
                        }
                        module.putOutputPort(richPort);
                        if(!CollectionUtil.containsKey(ALL_OUTPUT_PORTS_MATCH_TABLE, richPort.getCmptChar().getType().data().getCharTypeId())) {
                            ALL_OUTPUT_PORTS_MATCH_TABLE.put(richPort.getCmptChar().getType().data().getCharTypeId(), richPort.getCmptChar().getType());
                        }
                        break;
                    }
                }
            }
            portList.clear();
        }

        //工作流组件校验和初始化
        {
            for(Map.Entry<Long, Module> moduleEntry : ALL_MODULES.entrySet()) {
                Module module = moduleEntry.getValue();
                Component component = module.getComponent();

                if(component.haveInputContent()) {
                    if (module.inputPortCount() != component.getInput().cmptCharCount()) {
                        logger.error(String.format("Check module configuration occurs fatal error -- Inconsistent number of input-port vs input-char:\n%s\n%s.",
                                DataUtil.toPrettyJSONString(component.data()), DataUtil.toPrettyJSONString(module.data())));
                        System.exit(-1);
                    }
                }

                if(module.inputPortCount() > 0) {
                    int sequence = 0;
                    for (ModulePort modulePort : module.getInputPorts()) {
                        if (modulePort.data().getSequence() != sequence) {
                            logger.error(String.format("Check module configuration occurs fatal error -- Error input port sequence number:\n%s.",
                                    DataUtil.toPrettyJSONString(modulePort.data())));
                            System.exit(-1);
                        }
                        sequence++;
                    }
                }

                if(module.outputPortCount() > 0) {
                    int sequence = 0;
                    for (ModulePort modulePort : module.getOutputPorts()) {
                        if (modulePort.data().getSequence() != sequence) {
                            logger.error(String.format("Check module configuration occurs fatal error -- Error output port sequence number:\n%s.",
                                    DataUtil.toPrettyJSONString(modulePort.data())));
                            System.exit(-1);
                        }
                        sequence++;
                    }
                }

                module.initializeDataPortCount();
            }
        }

        //工作流组件属性页初始化
        {
            //key: tab_id
            HashMap<Long, WfCfgModulePropTab> propTabs = new HashMap<Long, WfCfgModulePropTab>();
            //key: control_id
            HashMap<Long, Module> ctrlModuleIndex = new HashMap<Long, Module>();

            {
                List<WfCfgModulePropTab> resultList = modulePropTabMgr.queryModulePropTab();
                if (DataUtil.isEmpty(resultList)) {
                    logger.error(String.format("Check module configuration occurs fatal error -- Empty module property tab configuration ."));
                    System.exit(-1);
                }
                for (WfCfgModulePropTab tab : resultList) {
                    CollectionUtil.put(propTabs, tab.getTabId(), tab);
                }
            }

            {
                //key: moduleId, second_key: tab_id, third_key: control_id
                HashMap<Long, TreeMap<Long, HashMap<Long, WfCfgModulePropCtrl>>> modulePropTabCtrlIndex = new HashMap<Long, TreeMap<Long, HashMap<Long, WfCfgModulePropCtrl>>>();

                List<WfCfgModulePropCtrl> resultList = modulePropCtrlMgr.queryModulePropCtrl();
                if (DataUtil.isEmpty(resultList)) {
                    logger.error(String.format("Check module configuration occurs fatal error -- Empty module property control configuration ."));
                    System.exit(-1);
                }
                for (WfCfgModulePropCtrl control : resultList) {
                    Module module = CollectionUtil.get(ALL_MODULES, control.getOwnerModuleId());
                    if (DataUtil.isNull(module)) {
                        logger.error(String.format("Check module configuration occurs fatal error -- Owner module not exists:\n%s.",
                                DataUtil.toPrettyJSONString(control)));
                        System.exit(-1);
                    }
                    if (DataUtil.isNotEmpty(control.getBindCharCode()) && DataUtil.isNull(module.searchParameterByCode(control.getBindCharCode()))) {
                        logger.error(String.format("Check module configuration occurs fatal error -- Bind-Char-Code not exists:\n%s\n%s.",
                                DataUtil.toPrettyJSONString(module.data()), DataUtil.toPrettyJSONString(control)));
                        System.exit(-1);
                    }
                    if (!CollectionUtil.containsKey(propTabs, control.getOwnerTabId())) {
                        logger.error(String.format("Check module configuration occurs fatal error -- Owner property tab not exists:\n%s.",
                                DataUtil.toPrettyJSONString(control)));
                        System.exit(-1);
                    }

                    CollectionUtil.put(ctrlModuleIndex, control.getControlId(), module);

                    TreeMap<Long, HashMap<Long, WfCfgModulePropCtrl>> propTabIndex = CollectionUtil.get(modulePropTabCtrlIndex, control.getOwnerModuleId());
                    if (DataUtil.isNull(propTabIndex)) {
                        propTabIndex = new TreeMap<Long, HashMap<Long, WfCfgModulePropCtrl>>();
                        CollectionUtil.put(modulePropTabCtrlIndex, control.getOwnerModuleId(), propTabIndex);
                    }

                    HashMap<Long, WfCfgModulePropCtrl> ctrlIndex = CollectionUtil.get(propTabIndex, control.getOwnerTabId());
                    if (DataUtil.isNull(ctrlIndex)) {
                        ctrlIndex = new HashMap<Long, WfCfgModulePropCtrl>();
                        CollectionUtil.put(propTabIndex, control.getOwnerTabId(), ctrlIndex);
                    }
                    CollectionUtil.put(ctrlIndex, control.getControlId(), control);
                }

                for(Module module : CollectionUtil.toList(ALL_MODULES)) {
                    ModulePropertyPage propertyPage = module.getPropertyPage();
                    TreeMap<Long, HashMap<Long, WfCfgModulePropCtrl>> propTabIndex = CollectionUtil.get(modulePropTabCtrlIndex, module.data().getModuleId());
                    if(DataUtil.isNotEmpty(propTabIndex)) {
                        for (Map.Entry<Long, HashMap<Long, WfCfgModulePropCtrl>> second_entry : propTabIndex.entrySet()) {
                            ModulePropertyTab propertyTab = new ModulePropertyTab(CollectionUtil.get(propTabs, second_entry.getKey()).makeCopy());
                            HashMap<Long, WfCfgModulePropCtrl> ctrlIndex = second_entry.getValue();

                            for (Map.Entry<Long, WfCfgModulePropCtrl> third_entry : ctrlIndex.entrySet()) {
                                ModulePropertyControl propertyControl = new ModulePropertyControl(third_entry.getValue(), module.searchParameterByCode(third_entry.getValue().getBindCharCode()));
                                propertyTab.putControl(propertyControl);
                            }
                            propertyPage.putTab(propertyTab);
                            CollectionUtil.clear(ctrlIndex);
                        }
                        CollectionUtil.clear(propTabIndex);
                    }
                }
                CollectionUtil.clear(modulePropTabCtrlIndex);
            }

            {
                List<WfCfgModulePropCtrlRel> resultList = modulePropCtrlRelMgr.queryModulePropCtrlRel();
                if(DataUtil.isNotEmpty(resultList)) {
                    for(WfCfgModulePropCtrlRel relation : resultList) {
                        Module module = CollectionUtil.get(ctrlModuleIndex, relation.getControlId());
                        if (DataUtil.isNull(module)) {
                            logger.error(String.format("Check module configuration occurs fatal error -- Property control not exists:\n%s.",
                                    DataUtil.toPrettyJSONString(relation)));
                            System.exit(-1);
                        }
                        if ((!"control-id".equals(relation.getTargetSelect())) && (!"control-type".equals(relation.getTargetSelect()))) {
                            logger.error(String.format("Check module configuration occurs fatal error -- Property control relation's Target-Select error:\n%s.",
                                    DataUtil.toPrettyJSONString(relation)));
                            System.exit(-1);
                        }

                        ModulePropertyPage propertyPage = module.getPropertyPage();
                        propertyPage.addRelation(new ModulePropertyRelation(relation));
                    }
                }
            }
            CollectionUtil.clear(propTabs);
            CollectionUtil.clear(ctrlModuleIndex);
        }
    }
}
