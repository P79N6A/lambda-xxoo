package com.yatop.lambda.workflow.core.framework.chartype;

import java.util.HashMap;

public abstract class CharTyeClazz implements ICharType {

    //<class-path, bean-object>
    private static final HashMap<String, ICharType> CLAZZ_BEANS = new HashMap<String, ICharType>();

    public static ICharType getClazzBean(String clazzPath) {
        return CLAZZ_BEANS.get(clazzPath);
    }

    private static void putClazzBean(String clazzPath, ICharType charTypeBean) {
        CLAZZ_BEANS.put(clazzPath, charTypeBean);
    }

    public CharTyeClazz() {
        CharTyeClazz.putClazzBean(this.getClass().getName(), this);
    }
}
