package com.yatop.lambda.workflow.core.config;

import com.google.common.collect.TreeMultimap;
import com.yatop.lambda.base.model.WfModule;
import com.yatop.lambda.base.model.WfModuleCatalog;
import com.yatop.lambda.base.model.WfModulePort;
import com.yatop.lambda.core.enums.ModuleTypeEnum;
import com.yatop.lambda.core.enums.PortTypeEnum;
import com.yatop.lambda.core.enums.SpecMaskEnum;
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

    private HashMap<Long, ModuleCatalog> ALL_MODULE_CATALOGS = new HashMap<Long, ModuleCatalog>();       //工作流组件目录
    private HashMap<Long, Module> ALL_MODULES = new HashMap<Long, Module>();                             //工作流组件
    private HashMap<String, Module> ALL_MODULES_BY_CODE = new HashMap<String, Module>();                             //工作流组件（按组件代码）
    private HashMap<Long, ModulePort> ALL_MODULE_PORTS = new HashMap<Long, ModulePort>();         //工作流组件端口

    public ModuleCatalog getRootCatalog() {
        return getCatalog(0L);
    }

    public ModuleCatalog getCatalog(Long catalogId) {
        return CollectionUtil.get(ALL_MODULE_CATALOGS, catalogId);
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

    @Override
    public void afterPropertiesSet() throws Exception {
        //loadModuleConfiguration();
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
                ALL_MODULE_CATALOGS.put(richCatalog.data().getCatalogId(), richCatalog);
            }
            catalogList.clear();

            for (Map.Entry<Long, ModuleCatalog>  entry : ALL_MODULE_CATALOGS.entrySet()) {
                if(entry.getValue().data().getParentCatalogId() >= 0) {
                    ModuleCatalog parentCatalog = ALL_MODULE_CATALOGS.get(entry.getValue().data().getParentCatalogId());
                    if (DataUtil.isNotNull(parentCatalog)) {
                        parentCatalog.putChildCatalog(entry.getValue());
                    } else {
                        logger.error(String.format("Loading module configuration occurs fatal error -- Parent module catalog not found:\n%s", DataUtil.prettyFormat(entry.getValue().data())));
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
                ALL_MODULES.put(richModule.data().getModuleId(), richModule);
                ALL_MODULES_BY_CODE.put(richModule.data().getModuleCode(), richModule);

                if(richModule.data().getCatalogId() > 0) {
                    ModuleCatalog catalog = ALL_MODULE_CATALOGS.get(richModule.data().getCatalogId());
                    if(DataUtil.isNotNull(catalog)) {
                        catalog.putChildModule(richModule);
                    } else {
                        logger.error(String.format("Loading module configuration occurs fatal error -- Owner module catalog not found:\n%s", DataUtil.prettyFormat(richModule.data())));
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
                if(!portTypeEnum.isCorrectPortType(SpecTypeEnum.valueOf(cmptChar.data().getSpecType()))) {
                    logger.error(String.format("Loading module configuration occurs fatal error -- Error port-type vs spec-type:\n%s\n%s.", DataUtil.prettyFormat(port), DataUtil.prettyFormat(cmptChar.data())));
                    System.exit(-1);
                }
                if(!SpecMaskEnum.matchInputAndOutput(cmptChar.getType().data().getSpecMask())) {
                    logger.error(String.format("Loading module configuration occurs fatal error -- port => char-type.spec-mask must be also support input & output:\n%s\n%s.", DataUtil.prettyFormat(port), DataUtil.prettyFormat(cmptChar.data())));
                    System.exit(-1);
                }
                Module module =  ALL_MODULES.get(port.getOwnerModuleId());
                if(DataUtil.isNull(module)) {
                    logger.error(String.format("Loading module configuration occurs fatal error -- Module not found:\n%s.", DataUtil.prettyFormat(port)));
                    System.exit(-1);
                }
                if(module.data().getModuleType() == ModuleTypeEnum.NON_WORKFLOW_MODULE.getType()) {
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

        //工作流组件校验和初始化
        {
            for(Map.Entry<Long, Module> moduleEntry : ALL_MODULES.entrySet()) {
                Module module = moduleEntry.getValue();
                Component component = module.getComponent();
                if(module.inputPortCount() > 0) {
                    if (module.getInputPorts().size() != component.getInput().cmptCharCount()) {
                        logger.error(String.format("Check module configuration occurs fatal error -- Inconsistent number of input-port vs input-char:\n%s\n%s.", DataUtil.prettyFormat(component.data()), DataUtil.prettyFormat(module.data())));
                        System.exit(-1);
                    }
                }

                int sequence = 0;
                if(module.inputPortCount() > 0) {
                    for (ModulePort modulePort : module.getInputPorts()) {
                        if (modulePort.data().getSequence() != sequence) {
                            logger.error(String.format("Check module configuration occurs fatal error -- Error input port sequence number:\n%s.", DataUtil.prettyFormat(modulePort.data())));
                            System.exit(-1);
                        }
                        sequence++;
                    }
                }
                if(module.outputPortCount() > 0) {
                    for (ModulePort modulePort : module.getOutputPorts()) {
                        if (modulePort.data().getSequence() != sequence) {
                            logger.error(String.format("Check module configuration occurs fatal error -- Error output port sequence number:\n%s.", DataUtil.prettyFormat(modulePort.data())));
                            System.exit(-1);
                        }
                        sequence++;
                    }
                }

                module.initializeDataPortCount();
            }
        }
    }
}
