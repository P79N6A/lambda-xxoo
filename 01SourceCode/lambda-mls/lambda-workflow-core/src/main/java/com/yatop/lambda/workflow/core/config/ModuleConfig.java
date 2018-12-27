package com.yatop.lambda.workflow.core.config;

import com.google.common.collect.TreeMultimap;
import com.yatop.lambda.base.model.WfModule;
import com.yatop.lambda.base.model.WfModuleCatalog;
import com.yatop.lambda.base.model.WfModulePort;
import com.yatop.lambda.core.enums.ModuleTypeEnum;
import com.yatop.lambda.core.enums.PortTypeEnum;
import com.yatop.lambda.core.enums.SpecTypeEnum;
import com.yatop.lambda.core.mgr.workflow.module.ModuleCatalogMgr;
import com.yatop.lambda.core.mgr.workflow.module.ModuleMgr;
import com.yatop.lambda.core.mgr.workflow.module.ModulePortMgr;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.richmodel.component.Component;
import com.yatop.lambda.workflow.core.richmodel.component.characteristic.CmptChar;
import com.yatop.lambda.workflow.core.richmodel.workflow.module.Module;
import com.yatop.lambda.workflow.core.richmodel.workflow.module.ModuleCatalog;
import com.yatop.lambda.workflow.core.richmodel.workflow.module.ModulePort;
import com.yatop.lambda.workflow.core.utils.CollectionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    private ComponentConfig componentConfig;

    private static TreeMultimap<Integer, ModuleCatalog> FIRST_LEVEL_MODULE_CATALOGS = TreeMultimap.create();    //一级工作流组件目录按序号排序
    private static HashMap<Long, ModuleCatalog> ALL_MODULE_CATALOGS = new HashMap<Long, ModuleCatalog>();       //工作流组件目录
    private static HashMap<Long, Module> ALL_MODULES = new HashMap<Long, Module>();                             //工作流组件
    private static HashMap<Long, ModulePort> ALL_MODULE_PORTS = new HashMap<Long, ModulePort>();         //工作流组件端口

    public static List<ModuleCatalog> getFirstLevelCatalogs() {
        return CollectionUtil.toList(FIRST_LEVEL_MODULE_CATALOGS);
    }

    public static ModuleCatalog getCatalog(Long catalogId) {
        if(DataUtil.isNull(catalogId))
            return null;
        return ALL_MODULE_CATALOGS.get(catalogId);
    }

    public static Module getModule(String moduleId) {
        if(DataUtil.isEmpty(moduleId))
            return null;
        return ALL_MODULES.get(moduleId);
    }

    public static ModulePort getModulePort(String portId) {
        if(DataUtil.isEmpty(portId))
            return null;
        return ALL_MODULE_PORTS.get(portId);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        loadModuleConfiguration();
    }

    public void loadModuleConfiguration() {
        //工作流组件目录
        {
            List<WfModuleCatalog> catalogList = moduleCatalogMgr.queryModuleCatalog();
            if(DataUtil.isEmpty(catalogList)) {
                logger.error(String.format("Loading module configuration occurs fatal error -- Empty module catalog configuration."));
                System.exit(-1);
            }

            for (WfModuleCatalog catalog : catalogList) {
                ModuleCatalog richCatalog = new ModuleCatalog(catalog);
                ALL_MODULE_CATALOGS.put(richCatalog.getCatalogId(), richCatalog);
            }
            catalogList.clear();

            for (Map.Entry<Long, ModuleCatalog>  entry : ALL_MODULE_CATALOGS.entrySet()) {
                if(entry.getValue().getParentCatalogId() == 0) {
                    FIRST_LEVEL_MODULE_CATALOGS.put(entry.getValue().getSequence(), entry.getValue());
                } else {
                    ModuleCatalog parentCatalog = ALL_MODULE_CATALOGS.get(entry.getValue().getParentCatalogId());
                    if(DataUtil.isNotNull(parentCatalog)) {
                        parentCatalog.putChildCatalog(entry.getValue());
                    } else {
                        logger.error(String.format("Loading module configuration occurs fatal error -- Parent module catalog not found:\n%s", DataUtil.prettyFormat(entry.getValue())));
                        System.exit(-1);
                    }
                }
            }
        }
        //工作流组件
        {
            List<WfModule> moduleList = moduleMgr.queryModule();
            if(DataUtil.isEmpty(moduleList)) {
                logger.error(String.format("Loading module configuration occurs fatal error -- Empty module configuration."));
                System.exit(-1);
            }

            for (WfModule module : moduleList) {

                ModuleTypeEnum moduleTypeEnum = ModuleTypeEnum.valueOf(module.getModuleType());
                if(DataUtil.isNull(moduleTypeEnum)) {
                    logger.error(String.format("Loading module configuration occurs fatal error -- Unknown module type:\n%s.", DataUtil.prettyFormat(module)));
                    System.exit(-1);
                }

                if(moduleTypeEnum == ModuleTypeEnum.NON_WORKFLOW_MODULE || module.getCatalogId() > 0) {
                    logger.error(String.format("Loading module configuration occurs fatal error -- Error module-type vs catalog-id:\n%s.", DataUtil.prettyFormat(module)));
                    System.exit(-1);
                }

                Component component =  componentConfig.getComponent(module.getPkgCmptId());
                if(DataUtil.isNull(component)) {
                    logger.error(String.format("Loading module configuration occurs fatal error -- Component not found:\n%s.", DataUtil.prettyFormat(module)));
                    System.exit(-1);
                }

                Module richModule = new Module(module, component);
                ALL_MODULES.put(richModule.getModuleId(), richModule);

                if(richModule.getCatalogId() > 0) {
                    ModuleCatalog catalog = ALL_MODULE_CATALOGS.get(richModule.getCatalogId());
                    if(DataUtil.isNotNull(catalog)) {
                        catalog.putChildModule(richModule);
                    } else {
                        logger.error(String.format("Loading module configuration occurs fatal error -- Owner module catalog not found:\n%s", DataUtil.prettyFormat(richModule)));
                        System.exit(-1);
                    }
                }
            }
            moduleList.clear();
        }
        //工作流组件端口
        {
            List<WfModulePort> portList = modulePortMgr.queryModulePort();
            if(DataUtil.isEmpty(portList)) {
                logger.error(String.format("Loading module configuration occurs fatal error -- Empty module port configuration."));
                System.exit(-1);
            }

            for (WfModulePort port : portList) {
                PortTypeEnum portTypeEnum = PortTypeEnum.valueOf(port.getPortType());
                if(DataUtil.isNull(portTypeEnum)) {
                    logger.error(String.format("Loading module configuration occurs fatal error -- Error port type:\n%s.", DataUtil.prettyFormat(port)));
                    System.exit(-1);
                }
                CmptChar cmptChar =  componentConfig.getCharacteristic(port.getBindCharId());
                if(DataUtil.isNull(cmptChar)) {
                    logger.error(String.format("Loading module configuration occurs fatal error -- Characteristic not found:\n%s.", DataUtil.prettyFormat(port)));
                    System.exit(-1);
                }
                if(!portTypeEnum.isCorrectPortType(SpecTypeEnum.valueOf(cmptChar.getSpecType()))) {
                    logger.error(String.format("Loading module configuration occurs fatal error -- Error port-type vs spec-type:\n%s\n%s.", DataUtil.prettyFormat(port), DataUtil.prettyFormat(cmptChar)));
                    System.exit(-1);
                }
                Module module =  ALL_MODULES.get(port.getOwnerModuleId());
                if(DataUtil.isNull(module)) {
                    logger.error(String.format("Loading module configuration occurs fatal error -- Module not found:\n%s.", DataUtil.prettyFormat(port)));
                    System.exit(-1);
                }
                if(module.getModuleType() == ModuleTypeEnum.NON_WORKFLOW_MODULE.getType()) {
                    logger.error(String.format("Loading module configuration occurs fatal error -- Forbid non-workflow-module hold input/output port:\n%s.", DataUtil.prettyFormat(port)));
                    System.exit(-1);
                }

                ModulePort richPort = new ModulePort(port, cmptChar);
                ALL_MODULE_PORTS.put(port.getPortId(), richPort);
                switch (portTypeEnum) {
                    case INPUT_PORT: {
                        module.putInputPort(richPort);
                        break;
                    }
                    case OUTPUT_PORT: {
                        module.putOutputPort(richPort);
                        break;
                    }
                }
            }
            portList.clear();
        }

        //工作流组件校验
        {
            for(Map.Entry<Long, Module> moduleEntry : ALL_MODULES.entrySet()) {
                Module module = moduleEntry.getValue();
                Component component = module.getComponent();
                if(module.getInputPorts().size() != component.getInput().getCmptChars().size()) {
                    logger.error(String.format("Check module configuration occurs fatal error -- Inconsistent number of input-port vs input-char:\n%s\n%s.", DataUtil.prettyFormat(component), DataUtil.prettyFormat(module)));
                    System.exit(-1);
                }
            }
        }
    }
}
