package com.yatop.lambda.workflow.core.module;

import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class ModuleBoard {

    //<class-path, bean-object>
    public static final HashMap<String, IModule> MODULE_MAPPER = new HashMap<String, IModule>();

    public IModule getModule(String classpath) {
        return ModuleBoard.MODULE_MAPPER.get(classpath);
    }
}
