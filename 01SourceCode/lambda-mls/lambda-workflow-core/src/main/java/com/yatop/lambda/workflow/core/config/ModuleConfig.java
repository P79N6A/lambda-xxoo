package com.yatop.lambda.workflow.core.config;

import com.google.common.collect.TreeMultimap;
import com.yatop.lambda.base.model.WfModule;
import com.yatop.lambda.base.model.WfModuleCatalog;
import com.yatop.lambda.base.model.WfModulePort;
import com.yatop.lambda.core.enums.PortTypeEnum;
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
    private static HashMap<Long, ModulePort> ALL_MODULE_PORTS = new HashMap<Long, ModulePort>();                //工作流组件端口

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
                        logger.error(String.format("Loading module configuration occurs fatal error -- Parent module catalog not found:\n%s", DataUtil.prettyFormat(entry.getValue().toJSON())));
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
                Module richModule = new Module(module);

                Component component =  componentConfig.getComponent(richModule.getPkgCmptId());
                if(DataUtil.isNull(component)) {
                    logger.error(String.format("Loading module configuration occurs fatal error -- Component not found:\n%s.", DataUtil.prettyFormat(module.toJSON())));
                    System.exit(-1);
                }
                richModule.setComponent(component);
                ALL_MODULES.put(richModule.getModuleId(), richModule);

                if(richModule.getCatalogId() > 0) {
                    ModuleCatalog catalog = ALL_MODULE_CATALOGS.get(richModule.getCatalogId());
                    if(DataUtil.isNotNull(catalog)) {
                        catalog.putChildModule(richModule);
                    } else {
                        logger.error(String.format("Loading module configuration occurs fatal error -- Owner module catalog not found:\n%s", DataUtil.prettyFormat(richModule.toJSON())));
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
                ModulePort richPort = new ModulePort(port);
                if(DataUtil.isNull(PortTypeEnum.valueOf(richPort.getPortType()))) {
                    logger.error(String.format("Loading module configuration occurs fatal error -- Error Port-Type:\n%s.", DataUtil.prettyFormat(port.toJSON())));
                    System.exit(-1);
                }
                Module module =  ALL_MODULES.get(richPort.getOwnerModuleId());
                if(DataUtil.isNull(module)) {
                    logger.error(String.format("Loading module configuration occurs fatal error -- Module not found:\n%s.", DataUtil.prettyFormat(port.toJSON())));
                    System.exit(-1);
                }
                CmptChar cmptChar =  componentConfig.getCharacteristic(richPort.getBindCharId());
                if(DataUtil.isNull(cmptChar)) {
                    logger.error(String.format("Loading module configuration occurs fatal error -- Characteristic not found:\n%s.", DataUtil.prettyFormat(port.toJSON())));
                    System.exit(-1);
                }

                richPort.setCmptChar(cmptChar);
                ALL_MODULE_PORTS.put(port.getPortId(), richPort);

                switch (PortTypeEnum.valueOf(richPort.getPortType())) {
                    case INPUT_PORT:
                        module.putInputPort(richPort);
                        break;
                    case OUTPUT_PORT:
                        module.putOutputPort(richPort);
                        break;
                }
            }
            portList.clear();
        }
    }
}
