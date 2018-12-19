package com.yatop.lambda.workflow.core.framework.module;

import java.util.HashMap;

public abstract class ModuleClazzBase implements IModule {

    //<class-path, bean-object>
    private static final HashMap<String, IModule> CLAZZ_BEANS = new HashMap<String, IModule>();

    public static IModule getClazzBean(String classpath) {
        return CLAZZ_BEANS.get(classpath);
    }

    private static void putClazzBean(String classpath, IModule moduleBean) {
        CLAZZ_BEANS.put(classpath, moduleBean);
    }

    public ModuleClazzBase() {
        ModuleClazzBase.putClazzBean(this.getClass().getName(), this);
    }
}
