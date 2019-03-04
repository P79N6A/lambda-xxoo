package com.yatop.lambda.workflow.core.framework.chartype;

import com.yatop.lambda.workflow.core.utils.CollectionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;

public abstract class CharTypeClazzBaseClazz implements ICharTypeClazz {

    public static Logger logger = LoggerFactory.getLogger(CharTypeClazzBaseClazz.class);

    //<class-path, bean-object>
    private static final HashMap<String, ICharTypeClazz> CLAZZ_BEANS = new HashMap<String, ICharTypeClazz>();

    public static ICharTypeClazz getClazzBean(String clazzPath) {
        return CollectionUtil.get(CLAZZ_BEANS, clazzPath);
    }

    private static void putClazzBean(String clazzPath, ICharTypeClazz charTypeBean) {
        CollectionUtil.put(CLAZZ_BEANS, clazzPath, charTypeBean);
    }

    public CharTypeClazzBaseClazz() {
        CharTypeClazzBaseClazz.putClazzBean(this.getClass().getName(), this);
    }
}
