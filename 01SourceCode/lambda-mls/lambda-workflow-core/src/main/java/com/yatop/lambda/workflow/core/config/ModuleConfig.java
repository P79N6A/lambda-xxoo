package com.yatop.lambda.workflow.core.config;

import com.google.common.collect.TreeMultimap;
import com.yatop.lambda.base.model.WfModule;
import com.yatop.lambda.base.model.WfModuleCatalog;
import com.yatop.lambda.base.model.WfModulePort;
import com.yatop.lambda.core.mgr.workflow.module.ModuleCatalogMgr;
import com.yatop.lambda.core.mgr.workflow.module.ModuleMgr;
import com.yatop.lambda.core.mgr.workflow.module.ModulePortMgr;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.richmodel.workflow.module.Module;
import com.yatop.lambda.workflow.core.richmodel.workflow.module.ModuleCatalog;
import com.yatop.lambda.workflow.core.richmodel.workflow.module.ModulePort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ModuleConfig implements InitializingBean {

    public static Logger logger = LoggerFactory.getLogger(ModuleConfig.class);

    @Autowired
    ModuleCatalogMgr moduleCatalogMgr;

    @Autowired
    ModuleMgr moduleMgr;

    @Autowired
    ModulePortMgr modulePortMgr;

    private static TreeMultimap<Integer, ModuleCatalog> FIRST_LEVEL_MODULE_CATALOGS = TreeMultimap.create();    //一级工作流组件目录按序号排序
    private static HashMap<Long, ModuleCatalog> ALL_MODULE_CATALOGS = new HashMap<Long, ModuleCatalog>();       //工作流组件目录
    private static HashMap<Long, Module> ALL_MODULES = new HashMap<Long, Module>();                         //工作流组件
    private static HashMap<Long, ModulePort> ALL_MODULE_PORTS = new HashMap<Long, ModulePort>();            //工作流组件端口

    @Override
    public void afterPropertiesSet() throws Exception {
        loadModuleConfiguration();
    }

    public void loadModuleConfiguration() {
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

        {
            List<WfModule> moduleList = moduleMgr.queryModule();
            if(DataUtil.isEmpty(moduleList)) {
                logger.error(String.format("Loading module configuration occurs fatal error -- Empty module configuration."));
                System.exit(-1);
            }

            for (WfModule module : moduleList) {
                Module richModule = new Module(module);
                //richModule.setComponent();
                //richModule.setInputPort();
                //richModule.setOutputPort();

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
        }

        {
            List<WfModulePort> portList = modulePortMgr.queryModulePort();
            if(DataUtil.isEmpty(portList)) {
                logger.error(String.format("Loading module configuration occurs fatal error -- Empty module port configuration."));
                System.exit(-1);
            }

            for (WfModulePort port : portList) {
                ModulePort richPort = new ModulePort(port);
                //richPort.setCmptChar(null /*ComponentConfig.getCmptChar()*/);

                ALL_MODULE_PORTS.put(port.getPortId(), richPort);
                //TODO
            }
        }
    }
}
