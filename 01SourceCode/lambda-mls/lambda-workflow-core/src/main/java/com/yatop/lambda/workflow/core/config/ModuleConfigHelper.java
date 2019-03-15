package com.yatop.lambda.workflow.core.config;

import com.yatop.lambda.workflow.core.richmodel.workflow.component.characteristic.CharType;
import com.yatop.lambda.workflow.core.richmodel.workflow.module.Module;
import com.yatop.lambda.workflow.core.richmodel.workflow.module.ModuleCatalog;
import com.yatop.lambda.workflow.core.richmodel.workflow.module.ModulePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ModuleConfigHelper {

    private static ModuleConfig MODULE_CONFIG;

    @Autowired
    public void setModuleConfig(ModuleConfig moduleConfig) {
        MODULE_CONFIG = moduleConfig;
    }


    public static List<ModuleCatalog> getAllCatalogs() {
        return MODULE_CONFIG.getAllCatalogs();
    }

    public List<Module> getAllCatalogModules() {
        return MODULE_CONFIG.getAllCatalogModules();
    }

    public static ModuleCatalog getRootCatalog() {
        return MODULE_CONFIG.getRootCatalog();
    }

    public static ModuleCatalog getCatalog(Long catalogId) {
        return MODULE_CONFIG.getCatalog(catalogId);
    }

    public static Module getModule(Long moduleId) {
        return MODULE_CONFIG.getModule(moduleId);
    }

    public static Module getModuleByCode(String moduleCode) {
        return MODULE_CONFIG.getModuleByCode(moduleCode);
    }

    public static ModulePort getModulePort(Long portId) {
        return MODULE_CONFIG.getModulePort(portId);
    }

    public static List<CharType> getOutputPortsMatchTable() {
        return MODULE_CONFIG.getOutputPortsMatchTable();
    }
}
